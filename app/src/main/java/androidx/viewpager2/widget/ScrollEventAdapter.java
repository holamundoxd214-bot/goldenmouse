package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

final class ScrollEventAdapter extends OnScrollListener {
    final class ScrollEventValues {
        float mOffset;
        int mOffsetPx;
        int mPosition;

        ScrollEventValues() {
            super();
        }

        void reset() {
            this.mPosition = -1;
            this.mOffset = 0f;
            this.mOffsetPx = 0;
        }
    }

    private static final int NO_POSITION = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_PROGRESS_FAKE_DRAG = 4;
    private static final int STATE_IN_PROGRESS_IMMEDIATE_SCROLL = 3;
    private static final int STATE_IN_PROGRESS_MANUAL_DRAG = 1;
    private static final int STATE_IN_PROGRESS_SMOOTH_SCROLL = 2;
    private int mAdapterState;
    private OnPageChangeCallback mCallback;
    private boolean mDataSetChangeHappened;
    private boolean mDispatchSelected;
    private int mDragStartPosition;
    private boolean mFakeDragging;
    private final LinearLayoutManager mLayoutManager;
    private final RecyclerView mRecyclerView;
    private boolean mScrollHappened;
    private int mScrollState;
    private ScrollEventValues mScrollValues;
    private int mTarget;
    private final ViewPager2 mViewPager;

    ScrollEventAdapter(ViewPager2 arg1) {
        super();
        this.mViewPager = arg1;
        RecyclerView v1 = arg1.mRecyclerView;
        this.mRecyclerView = v1;
        this.mLayoutManager = v1.getLayoutManager();
        this.mScrollValues = new ScrollEventValues();
        this.resetState();
    }

    private void dispatchScrolled(int arg1, float arg2, int arg3) {
        OnPageChangeCallback v0 = this.mCallback;
        if(v0 != null) {
            v0.onPageScrolled(arg1, arg2, arg3);
        }
    }

    private void dispatchSelected(int arg1) {
        OnPageChangeCallback v0 = this.mCallback;
        if(v0 != null) {
            v0.onPageSelected(arg1);
        }
    }

    private void dispatchStateChanged(int arg3) {
        if(this.mAdapterState == 3 && this.mScrollState == 0) {
        }
        else if(this.mScrollState == arg3) {
        }
        else {
            this.mScrollState = arg3;
            OnPageChangeCallback v2 = this.mCallback;
            if(v2 != null) {
                v2.onPageScrollStateChanged(arg3);
            }
        }
    }

    private int getPosition() {
        return this.mLayoutManager.findFirstVisibleItemPosition();
    }

    double getRelativeScrollPosition() {
        this.updateScrollEventValues();
        return (((double)this.mScrollValues.mPosition)) + (((double)this.mScrollValues.mOffset));
    }

    int getScrollState() {
        return this.mScrollState;
    }

    boolean isDragging() {
        if(this.mScrollState == 1) {
            return 1;
        }

        return 0;
    }

    boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    boolean isIdle() {
        if(this.mScrollState == 0) {
            return 1;
        }

        return 0;
    }

    private boolean isInAnyDraggingState() {
        int v2 = this.mAdapterState;
        if(v2 != 1) {
            if(v2 == 4) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    void notifyBeginFakeDrag() {
        this.mAdapterState = 4;
        this.startDrag(true);
    }

    void notifyDataSetChangeHappened() {
        this.mDataSetChangeHappened = true;
    }

    void notifyEndFakeDrag() {
        if((this.isDragging()) && !this.mFakeDragging) {
            return;
        }

        this.mFakeDragging = false;
        this.updateScrollEventValues();
        if(this.mScrollValues.mOffsetPx == 0) {
            if(this.mScrollValues.mPosition != this.mDragStartPosition) {
                this.dispatchSelected(this.mScrollValues.mPosition);
            }

            this.dispatchStateChanged(0);
            this.resetState();
            return;
        }

        this.dispatchStateChanged(2);
    }

    void notifyProgrammaticScroll(int arg3, boolean arg4) {
        int v0 = 2;
        int v4 = arg4 ? v0 : 3;
        this.mAdapterState = v4;
        v4 = 0;
        this.mFakeDragging = false;
        if(this.mTarget != arg3) {
            v4 = 1;
        }

        this.mTarget = arg3;
        this.dispatchStateChanged(v0);
        if(v4 != 0) {
            this.dispatchSelected(arg3);
        }
    }

    public void onScrollStateChanged(RecyclerView arg5, int arg6) {
        if((this.mAdapterState != 1 || this.mScrollState != 1) && arg6 == 1) {
            this.startDrag(false);
            return;
        }

        int v2 = 2;
        if(!this.isInAnyDraggingState() || arg6 != v2) {
            int v1 = -1;
            if((this.isInAnyDraggingState()) && arg6 == 0) {
                this.updateScrollEventValues();
                boolean v5 = this.mScrollHappened;
                ScrollEventValues v3 = this.mScrollValues;
                if(!v5) {
                    if(v3.mPosition != v1) {
                        this.dispatchScrolled(this.mScrollValues.mPosition, 0f, 0);
                    }
                }
                else if(v3.mOffsetPx != 0) {
                    goto label_44;
                }
                else if(this.mDragStartPosition != this.mScrollValues.mPosition) {
                    this.dispatchSelected(this.mScrollValues.mPosition);
                }

                this.dispatchStateChanged(0);
                this.resetState();
            }

        label_44:
            if(this.mAdapterState != v2) {
                return;
            }

            if(arg6 != 0) {
                return;
            }

            if(!this.mDataSetChangeHappened) {
                return;
            }

            this.updateScrollEventValues();
            if(this.mScrollValues.mOffsetPx != 0) {
                return;
            }

            if(this.mTarget != this.mScrollValues.mPosition) {
                int v5_1 = this.mScrollValues.mPosition == v1 ? 0 : this.mScrollValues.mPosition;
                this.dispatchSelected(v5_1);
            }

            this.dispatchStateChanged(0);
            this.resetState();
        }
        else if(this.mScrollHappened) {
            this.dispatchStateChanged(v2);
            this.mDispatchSelected = true;
            return;
        }
    }

    public void onScrolled(RecyclerView arg4, int arg5, int arg6) {
        this.mScrollHappened = true;
        this.updateScrollEventValues();
        int v1 = -1;
        if(this.mDispatchSelected) {
            this.mDispatchSelected = false;
            if(arg6 > 0) {
            label_17:
                if(this.mScrollValues.mOffsetPx != 0) {
                    arg5 = this.mScrollValues.mPosition + 1;
                    goto label_26;
                }

            label_24:
                arg5 = this.mScrollValues.mPosition;
            }
            else if(arg6 == 0) {
                boolean v5 = arg5 < 0 ? true : false;
                if(v5 != this.mViewPager.isRtl()) {
                    goto label_24;
                }

                goto label_17;
            }
            else {
                goto label_24;
            }

        label_26:
            this.mTarget = arg5;
            if(this.mDragStartPosition == arg5) {
                goto label_38;
            }

            this.dispatchSelected(arg5);
        }
        else {
            if(this.mAdapterState != 0) {
                goto label_38;
            }

            arg5 = this.mScrollValues.mPosition;
            if(arg5 == v1) {
                arg5 = 0;
            }

            this.dispatchSelected(arg5);
        }

    label_38:
        arg5 = this.mScrollValues.mPosition == v1 ? 0 : this.mScrollValues.mPosition;
        this.dispatchScrolled(arg5, this.mScrollValues.mOffset, this.mScrollValues.mOffsetPx);
        arg5 = this.mScrollValues.mPosition;
        arg6 = this.mTarget;
        if((arg5 == arg6 || arg6 == v1) && (this.mScrollValues.mOffsetPx == 0 && this.mScrollState != 1)) {
            this.dispatchStateChanged(0);
            this.resetState();
        }
    }

    private void resetState() {
        this.mAdapterState = 0;
        this.mScrollState = 0;
        this.mScrollValues.reset();
        this.mDragStartPosition = -1;
        this.mTarget = -1;
        this.mDispatchSelected = false;
        this.mScrollHappened = false;
        this.mFakeDragging = false;
        this.mDataSetChangeHappened = false;
    }

    void setOnPageChangeCallback(OnPageChangeCallback arg1) {
        this.mCallback = arg1;
    }

    private void startDrag(boolean arg3) {
        this.mFakeDragging = arg3;
        int v3 = arg3 ? 4 : 1;
        this.mAdapterState = v3;
        v3 = this.mTarget;
        int v1 = -1;
        if(v3 != v1) {
            this.mDragStartPosition = v3;
            this.mTarget = v1;
        }
        else if(this.mDragStartPosition == v1) {
            this.mDragStartPosition = this.getPosition();
        }

        this.dispatchStateChanged(1);
    }

    private void updateScrollEventValues() {
        int v1_1;
        ScrollEventValues v0 = this.mScrollValues;
        v0.mPosition = this.mLayoutManager.findFirstVisibleItemPosition();
        if(v0.mPosition == -1) {
            v0.reset();
            return;
        }

        View v1 = this.mLayoutManager.findViewByPosition(v0.mPosition);
        if(v1 == null) {
            v0.reset();
            return;
        }

        int v2 = this.mLayoutManager.getLeftDecorationWidth(v1);
        int v3 = this.mLayoutManager.getRightDecorationWidth(v1);
        int v4 = this.mLayoutManager.getTopDecorationHeight(v1);
        int v5 = this.mLayoutManager.getBottomDecorationHeight(v1);
        ViewGroup$LayoutParams v6 = v1.getLayoutParams();
        if((v6 instanceof ViewGroup$MarginLayoutParams)) {
            v2 += ((ViewGroup$MarginLayoutParams)v6).leftMargin;
            v3 += ((ViewGroup$MarginLayoutParams)v6).rightMargin;
            v4 += ((ViewGroup$MarginLayoutParams)v6).topMargin;
            v5 += ((ViewGroup$MarginLayoutParams)v6).bottomMargin;
        }

        int v6_1 = v1.getHeight() + v4 + v5;
        v5 = v1.getWidth() + v2 + v3;
        if(this.mLayoutManager.getOrientation() == 0) {
            v1_1 = v1.getLeft() - v2 - this.mRecyclerView.getPaddingLeft();
            if(this.mViewPager.isRtl()) {
                v1_1 = -v1_1;
            }

            v6_1 = v5;
        }
        else {
            v1_1 = v1.getTop() - v4 - this.mRecyclerView.getPaddingTop();
        }

        v0.mOffsetPx = -v1_1;
        if(v0.mOffsetPx < 0) {
            if(new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations()) {
                throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
            }

            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(v0.mOffsetPx)));
        }

        float v8 = v6_1 == 0 ? 0f : (((float)v0.mOffsetPx)) / (((float)v6_1));
        v0.mOffset = v8;
    }
}

