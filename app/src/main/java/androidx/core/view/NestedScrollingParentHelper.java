package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

public class NestedScrollingParentHelper {
    private int mNestedScrollAxesNonTouch;
    private int mNestedScrollAxesTouch;

    public NestedScrollingParentHelper(ViewGroup arg1) {
        super();
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollAxesNonTouch | this.mNestedScrollAxesTouch;
    }

    public void onNestedScrollAccepted(View arg2, View arg3, int arg4) {
        this.onNestedScrollAccepted(arg2, arg3, arg4, 0);
    }

    public void onNestedScrollAccepted(View arg1, View arg2, int arg3, int arg4) {
        if(arg4 == 1) {
            this.mNestedScrollAxesNonTouch = arg3;
            return;
        }

        this.mNestedScrollAxesTouch = arg3;
    }

    public void onStopNestedScroll(View arg2, int arg3) {
        if(arg3 == 1) {
            this.mNestedScrollAxesNonTouch = 0;
            return;
        }

        this.mNestedScrollAxesTouch = 0;
    }

    public void onStopNestedScroll(View arg2) {
        this.onStopNestedScroll(arg2, 0);
    }
}

