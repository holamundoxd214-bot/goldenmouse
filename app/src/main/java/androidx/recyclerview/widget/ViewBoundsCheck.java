package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class ViewBoundsCheck {
    class BoundFlags {
        int mBoundFlags;
        int mChildEnd;
        int mChildStart;
        int mRvEnd;
        int mRvStart;

        BoundFlags() {
            super();
            this.mBoundFlags = 0;
        }

        void addFlags(int arg2) {
            this.mBoundFlags |= arg2;
        }

        boolean boundsMatch() {
            int v0 = this.mBoundFlags;
            if((v0 & 7) != 0 && (v0 & this.compare(this.mChildStart, this.mRvStart)) == 0) {
                return 0;
            }

            v0 = this.mBoundFlags;
            if((v0 & 0x70) != 0 && (v0 & this.compare(this.mChildStart, this.mRvEnd) << 4) == 0) {
                return 0;
            }

            v0 = this.mBoundFlags;
            if((v0 & 0x700) != 0 && (v0 & this.compare(this.mChildEnd, this.mRvStart) << 8) == 0) {
                return 0;
            }

            v0 = this.mBoundFlags;
            if((v0 & 0x7000) != 0 && (this.compare(this.mChildEnd, this.mRvEnd) << 12 & v0) == 0) {
                return 0;
            }

            return 1;
        }

        int compare(int arg1, int arg2) {
            if(arg1 > arg2) {
                return 1;
            }

            if(arg1 == arg2) {
                return 2;
            }

            return 4;
        }

        void resetFlags() {
            this.mBoundFlags = 0;
        }

        void setBounds(int arg1, int arg2, int arg3, int arg4) {
            this.mRvStart = arg1;
            this.mRvEnd = arg2;
            this.mChildStart = arg3;
            this.mChildEnd = arg4;
        }
    }

    interface Callback {
        View getChildAt(int arg1);

        int getChildEnd(View arg1);

        int getChildStart(View arg1);

        int getParentEnd();

        int getParentStart();
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface ViewBounds {
    }

    static final int CVE_PVE_POS = 12;
    static final int CVE_PVS_POS = 8;
    static final int CVS_PVE_POS = 4;
    static final int CVS_PVS_POS = 0;
    static final int EQ = 2;
    static final int FLAG_CVE_EQ_PVE = 0x2000;
    static final int FLAG_CVE_EQ_PVS = 0x200;
    static final int FLAG_CVE_GT_PVE = 0x1000;
    static final int FLAG_CVE_GT_PVS = 0x100;
    static final int FLAG_CVE_LT_PVE = 0x4000;
    static final int FLAG_CVE_LT_PVS = 0x400;
    static final int FLAG_CVS_EQ_PVE = 0x20;
    static final int FLAG_CVS_EQ_PVS = 2;
    static final int FLAG_CVS_GT_PVE = 16;
    static final int FLAG_CVS_GT_PVS = 1;
    static final int FLAG_CVS_LT_PVE = 0x40;
    static final int FLAG_CVS_LT_PVS = 4;
    static final int GT = 1;
    static final int LT = 4;
    static final int MASK = 7;
    BoundFlags mBoundFlags;
    final Callback mCallback;

    ViewBoundsCheck(Callback arg1) {
        super();
        this.mCallback = arg1;
        this.mBoundFlags = new BoundFlags();
    }

    View findOneViewWithinBoundFlags(int arg9, int arg10, int arg11, int arg12) {
        int v0 = this.mCallback.getParentStart();
        int v1 = this.mCallback.getParentEnd();
        int v2 = arg10 > arg9 ? 1 : -1;
        View v3 = null;
        while(arg9 != arg10) {
            View v4 = this.mCallback.getChildAt(arg9);
            this.mBoundFlags.setBounds(v0, v1, this.mCallback.getChildStart(v4), this.mCallback.getChildEnd(v4));
            if(arg11 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(arg11);
                if(this.mBoundFlags.boundsMatch()) {
                    return v4;
                }
            }

            if(arg12 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(arg12);
                if(this.mBoundFlags.boundsMatch()) {
                    v3 = v4;
                }
            }

            arg9 += v2;
        }

        return v3;
    }

    boolean isViewWithinBoundFlags(View arg6, int arg7) {
        this.mBoundFlags.setBounds(this.mCallback.getParentStart(), this.mCallback.getParentEnd(), this.mCallback.getChildStart(arg6), this.mCallback.getChildEnd(arg6));
        if(arg7 != 0) {
            this.mBoundFlags.resetFlags();
            this.mBoundFlags.addFlags(arg7);
            return this.mBoundFlags.boundsMatch();
        }

        return 0;
    }
}

