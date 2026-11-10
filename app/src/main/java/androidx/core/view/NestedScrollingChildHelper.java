package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(View arg1) {
        super();
        this.mView = arg1;
    }

    public boolean dispatchNestedFling(float arg3, float arg4, boolean arg5) {
        if(this.isNestedScrollingEnabled()) {
            ViewParent v0 = this.getNestedScrollingParentForType(0);
            if(v0 != null) {
                return ViewParentCompat.onNestedFling(v0, this.mView, arg3, arg4, arg5);
            }
        }

        return 0;
    }

    public boolean dispatchNestedPreFling(float arg3, float arg4) {
        if(this.isNestedScrollingEnabled()) {
            ViewParent v0 = this.getNestedScrollingParentForType(0);
            if(v0 != null) {
                return ViewParentCompat.onNestedPreFling(v0, this.mView, arg3, arg4);
            }
        }

        return 0;
    }

    public boolean dispatchNestedPreScroll(int arg7, int arg8, int[] arg9, int[] arg10) {
        return this.dispatchNestedPreScroll(arg7, arg8, arg9, arg10, 0);
    }

    public boolean dispatchNestedPreScroll(int arg11, int arg12, int[] arg13, int[] arg14, int arg15) {
        int v9;
        int v8;
        if(this.isNestedScrollingEnabled()) {
            ViewParent v2 = this.getNestedScrollingParentForType(arg15);
            if(v2 == null) {
                return 0;
            }
            else {
                if(arg11 == 0) {
                    if(arg12 != 0) {
                    }
                    else {
                        if(arg14 != null) {
                            arg14[0] = 0;
                            arg14[1] = 0;
                        }
                        else {
                        }

                        return 0;
                    }
                }

                if(arg14 != null) {
                    this.mView.getLocationInWindow(arg14);
                    v8 = arg14[0];
                    v9 = arg14[1];
                }
                else {
                    v8 = 0;
                    v9 = 0;
                }

                if(arg13 == null) {
                    arg13 = this.getTempNestedScrollConsumed();
                }

                int[] v6 = arg13;
                v6[0] = 0;
                v6[1] = 0;
                ViewParentCompat.onNestedPreScroll(v2, this.mView, arg11, arg12, v6, arg15);
                if(arg14 != null) {
                    this.mView.getLocationInWindow(arg14);
                    arg14[0] -= v8;
                    arg14[1] -= v9;
                }

                if(v6[0] == 0) {
                    if(v6[1] != 0) {
                    }
                    else {
                        return 0;
                    }
                }

                return 1;
            }
        }

        return 0;
    }

    public void dispatchNestedScroll(int arg1, int arg2, int arg3, int arg4, int[] arg5, int arg6, int[] arg7) {
        this.dispatchNestedScrollInternal(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public boolean dispatchNestedScroll(int arg9, int arg10, int arg11, int arg12, int[] arg13) {
        return this.dispatchNestedScrollInternal(arg9, arg10, arg11, arg12, arg13, 0, null);
    }

    public boolean dispatchNestedScroll(int arg9, int arg10, int arg11, int arg12, int[] arg13, int arg14) {
        return this.dispatchNestedScrollInternal(arg9, arg10, arg11, arg12, arg13, arg14, null);
    }

    private boolean dispatchNestedScrollInternal(int arg14, int arg15, int arg16, int arg17, int[] arg18, int arg19, int[] arg20) {
        int[] v10;
        int v12;
        int v11;
        int[] v0 = arg18;
        if(this.isNestedScrollingEnabled()) {
            int v9 = arg19;
            ViewParent v3 = this.getNestedScrollingParentForType(v9);
            if(v3 == null) {
                return 0;
            }
            else {
                if(arg14 == 0 && arg15 == 0 && arg16 == 0) {
                    if(arg17 != 0) {
                    }
                    else {
                        if(v0 != null) {
                            v0[0] = 0;
                            v0[1] = 0;
                        }
                        else {
                        }

                        return 0;
                    }
                }

                if(v0 != null) {
                    this.mView.getLocationInWindow(v0);
                    v11 = v0[0];
                    v12 = v0[1];
                }
                else {
                    v11 = 0;
                    v12 = 0;
                }

                if(arg20 == null) {
                    int[] v4 = this.getTempNestedScrollConsumed();
                    v4[0] = 0;
                    v4[1] = 0;
                    v10 = v4;
                }
                else {
                    v10 = arg20;
                }

                ViewParentCompat.onNestedScroll(v3, this.mView, arg14, arg15, arg16, arg17, v9, v10);
                if(v0 != null) {
                    this.mView.getLocationInWindow(v0);
                    v0[0] -= v11;
                    v0[1] -= v12;
                }

                return 1;
            }
        }

        return 0;
    }

    private ViewParent getNestedScrollingParentForType(int arg2) {
        if(arg2 != 0) {
            if(arg2 != 1) {
                return null;
            }

            return this.mNestedScrollingParentNonTouch;
        }

        return this.mNestedScrollingParentTouch;
    }

    private int[] getTempNestedScrollConsumed() {
        int[] v0 = this.mTempNestedScrollConsumed;
        if(v0 == null) {
            v0 = new int[2];
            this.mTempNestedScrollConsumed = v0;
        }

        return v0;
    }

    public boolean hasNestedScrollingParent() {
        return this.hasNestedScrollingParent(0);
    }

    public boolean hasNestedScrollingParent(int arg1) {
        if(this.getNestedScrollingParentForType(arg1) != null) {
            return 1;
        }

        return 0;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(View arg1) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean arg2) {
        if(this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }

        this.mIsNestedScrollingEnabled = arg2;
    }

    private void setNestedScrollingParentForType(int arg2, ViewParent arg3) {
        if(arg2 != 0) {
            if(arg2 != 1) {
                return;
            }

            this.mNestedScrollingParentNonTouch = arg3;
            return;
        }

        this.mNestedScrollingParentTouch = arg3;
    }

    public boolean startNestedScroll(int arg2) {
        return this.startNestedScroll(arg2, 0);
    }

    public boolean startNestedScroll(int arg5, int arg6) {
        if(this.hasNestedScrollingParent(arg6)) {
            return 1;
        }

        if(this.isNestedScrollingEnabled()) {
            ViewParent v0 = this.mView.getParent();
            View v2 = this.mView;
            while(v0 != null) {
                if(ViewParentCompat.onStartNestedScroll(v0, v2, this.mView, arg5, arg6)) {
                    this.setNestedScrollingParentForType(arg6, v0);
                    ViewParentCompat.onNestedScrollAccepted(v0, v2, this.mView, arg5, arg6);
                    return 1;
                }
                else {
                    if((v0 instanceof View)) {
                        ViewParent v2_1 = v0;
                    }

                    v0 = v0.getParent();
                    continue;
                }

                return 0;
            }
        }

        return 0;
    }

    public void stopNestedScroll() {
        this.stopNestedScroll(0);
    }

    public void stopNestedScroll(int arg3) {
        ViewParent v0 = this.getNestedScrollingParentForType(arg3);
        if(v0 != null) {
            ViewParentCompat.onStopNestedScroll(v0, this.mView, arg3);
            this.setNestedScrollingParentForType(arg3, null);
        }
    }
}

