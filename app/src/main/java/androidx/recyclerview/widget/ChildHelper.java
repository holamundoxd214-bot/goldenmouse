package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ChildHelper {
    class Bucket {
        static final int BITS_PER_WORD = 0x40;
        static final long LAST_BIT = -9223372036854775808L;
        long mData;
        Bucket mNext;

        Bucket() {
            super();
            this.mData = 0;
        }

        void clear(int arg5) {
            int v0 = 0x40;
            if(arg5 >= v0) {
                this = this.mNext;
                if(this != null) {
                    this.clear(arg5 - v0);
                }

                return;
            }

            this.mData &= ~(1 << arg5);
        }

        int countOnesBefore(int arg7) {
            Bucket v0 = this.mNext;
            int v1 = 0x40;
            long v2 = 1;
            if(v0 == null) {
                long v4 = this.mData;
                if(arg7 >= v1) {
                    return Long.bitCount(v4);
                }

                return Long.bitCount((v2 << arg7) - v2 & v4);
            }

            if(arg7 < v1) {
                return Long.bitCount((v2 << arg7) - v2 & this.mData);
            }

            return v0.countOnesBefore(arg7 - v1) + Long.bitCount(this.mData);
        }

        private void ensureNext() {
            if(this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        boolean get(int arg5) {
            int v0 = 0x40;
            if(arg5 >= v0) {
                this.ensureNext();
                return this.mNext.get(arg5 - v0);
            }

            if((1 << arg5 & this.mData) != 0) {
                return 1;
            }

            return 0;
        }

        void insert(int arg10, boolean arg11) {
            int v0 = 0x40;
            if(arg10 >= v0) {
                this.ensureNext();
                this.mNext.insert(arg10 - v0, arg11);
                return;
            }

            long v0_1 = this.mData;
            boolean v2 = Long.compare(-9223372036854775808L & v0_1, 0) != 0 ? true : false;
            long v7 = (1 << arg10) - 1;
            this.mData = (v0_1 & ~v7) << 1 | v0_1 & v7;
            if(arg11) {
                this.set(arg10);
            }
            else {
                this.clear(arg10);
            }

            if(!v2) {
                if(this.mNext != null) {
                }
                else {
                    return;
                }
            }

            this.ensureNext();
            this.mNext.insert(0, v2);
        }

        boolean remove(int arg11) {
            int v0 = 0x40;
            if(arg11 >= v0) {
                this.ensureNext();
                return this.mNext.remove(arg11 - v0);
            }

            long v0_1 = 1;
            long v2 = v0_1 << arg11;
            long v4 = this.mData;
            boolean v11 = Long.compare(v4 & v2, 0) != 0 ? true : false;
            v4 &= ~v2;
            this.mData = v4;
            v2 -= v0_1;
            this.mData = v4 & v2 | Long.rotateRight(~v2 & v4, 1);
            Bucket v0_2 = this.mNext;
            if(v0_2 != null) {
                if(v0_2.get(0)) {
                    this.set(0x3F);
                }

                this.mNext.remove(0);
            }

            return v11;
        }

        void reset() {
            this.mData = 0;
            this = this.mNext;
            if(this != null) {
                this.reset();
            }
        }

        void set(int arg5) {
            int v0 = 0x40;
            if(arg5 >= v0) {
                this.ensureNext();
                this.mNext.set(arg5 - v0);
                return;
            }

            this.mData |= 1 << arg5;
        }

        public String toString() {
            if(this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }

            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    interface Callback {
        void addView(View arg1, int arg2);

        void attachViewToParent(View arg1, int arg2, ViewGroup$LayoutParams arg3);

        void detachViewFromParent(int arg1);

        View getChildAt(int arg1);

        int getChildCount();

        ViewHolder getChildViewHolder(View arg1);

        int indexOfChild(View arg1);

        void onEnteredHiddenState(View arg1);

        void onLeftHiddenState(View arg1);

        void removeAllViews();

        void removeViewAt(int arg1);
    }

    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Bucket mBucket;
    final Callback mCallback;
    final List mHiddenViews;

    ChildHelper(Callback arg1) {
        super();
        this.mCallback = arg1;
        this.mBucket = new Bucket();
        this.mHiddenViews = new ArrayList();
    }

    void addView(View arg2, int arg3, boolean arg4) {
        arg3 = arg3 < 0 ? this.mCallback.getChildCount() : this.getOffset(arg3);
        this.mBucket.insert(arg3, arg4);
        if(arg4) {
            this.hideViewInternal(arg2);
        }

        this.mCallback.addView(arg2, arg3);
    }

    void addView(View arg2, boolean arg3) {
        this.addView(arg2, -1, arg3);
    }

    void attachViewToParent(View arg2, int arg3, ViewGroup$LayoutParams arg4, boolean arg5) {
        arg3 = arg3 < 0 ? this.mCallback.getChildCount() : this.getOffset(arg3);
        this.mBucket.insert(arg3, arg5);
        if(arg5) {
            this.hideViewInternal(arg2);
        }

        this.mCallback.attachViewToParent(arg2, arg3, arg4);
    }

    void detachViewFromParent(int arg2) {
        arg2 = this.getOffset(arg2);
        this.mBucket.remove(arg2);
        this.mCallback.detachViewFromParent(arg2);
    }

    View findHiddenNonRemovedView(int arg6) {
        int v0 = this.mHiddenViews.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = this.mHiddenViews.get(v1);
            ViewHolder v3 = this.mCallback.getChildViewHolder(((View)v2));
            if(v3.getLayoutPosition() == arg6 && !v3.isInvalid() && !v3.isRemoved()) {
                return ((View)v2);
            }
        }

        return null;
    }

    View getChildAt(int arg1) {
        return this.mCallback.getChildAt(this.getOffset(arg1));
    }

    int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    private int getOffset(int arg5) {
        int v0 = -1;
        if(arg5 < 0) {
            return v0;
        }

        int v1 = this.mCallback.getChildCount();
        int v2 = arg5;
        while(v2 < v1) {
            int v3 = arg5 - (v2 - this.mBucket.countOnesBefore(v2));
            if(v3 != 0) {
                v2 += v3;
                continue;
            }

            goto label_12;
        }

        return v0;
    label_12:
        while(this.mBucket.get(v2)) {
            ++v2;
        }

        return v2;
    }

    View getUnfilteredChildAt(int arg1) {
        return this.mCallback.getChildAt(arg1);
    }

    int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    void hide(View arg3) {
        int v0 = this.mCallback.indexOfChild(arg3);
        if(v0 >= 0) {
            this.mBucket.set(v0);
            this.hideViewInternal(arg3);
            return;
        }

        throw new IllegalArgumentException("view is not a child, cannot hide " + arg3);
    }

    private void hideViewInternal(View arg2) {
        this.mHiddenViews.add(arg2);
        this.mCallback.onEnteredHiddenState(arg2);
    }

    int indexOfChild(View arg3) {
        int v3 = this.mCallback.indexOfChild(arg3);
        int v0 = -1;
        if(v3 == v0) {
            return v0;
        }

        if(this.mBucket.get(v3)) {
            return v0;
        }

        return v3 - this.mBucket.countOnesBefore(v3);
    }

    boolean isHidden(View arg1) {
        return this.mHiddenViews.contains(arg1);
    }

    void removeAllViewsUnfiltered() {
        Callback v1;
        this.mBucket.reset();
        int v0;
        for(v0 = this.mHiddenViews.size() - 1; true; --v0) {
            v1 = this.mCallback;
            if(v0 < 0) {
                break;
            }

            v1.onLeftHiddenState(this.mHiddenViews.get(v0));
            this.mHiddenViews.remove(v0);
        }

        v1.removeAllViews();
    }

    void removeView(View arg3) {
        int v0 = this.mCallback.indexOfChild(arg3);
        if(v0 < 0) {
            return;
        }

        if(this.mBucket.remove(v0)) {
            this.unhideViewInternal(arg3);
        }

        this.mCallback.removeViewAt(v0);
    }

    void removeViewAt(int arg3) {
        arg3 = this.getOffset(arg3);
        View v0 = this.mCallback.getChildAt(arg3);
        if(v0 == null) {
            return;
        }

        if(this.mBucket.remove(arg3)) {
            this.unhideViewInternal(v0);
        }

        this.mCallback.removeViewAt(arg3);
    }

    boolean removeViewIfHidden(View arg4) {
        int v0 = this.mCallback.indexOfChild(arg4);
        if(v0 == -1) {
            this.unhideViewInternal(arg4);
            return 1;
        }

        if(this.mBucket.get(v0)) {
            this.mBucket.remove(v0);
            this.unhideViewInternal(arg4);
            this.mCallback.removeViewAt(v0);
            return 1;
        }

        return 0;
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    void unhide(View arg3) {
        int v0 = this.mCallback.indexOfChild(arg3);
        if(v0 >= 0) {
            if(this.mBucket.get(v0)) {
                this.mBucket.clear(v0);
                this.unhideViewInternal(arg3);
                return;
            }

            throw new RuntimeException("trying to unhide a view that was not hidden" + arg3);
        }

        throw new IllegalArgumentException("view is not a child, cannot hide " + arg3);
    }

    private boolean unhideViewInternal(View arg2) {
        if(this.mHiddenViews.remove(arg2)) {
            this.mCallback.onLeftHiddenState(arg2);
            return 1;
        }

        return 0;
    }
}

