package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

class ViewUtilsApi29 extends ViewUtilsApi23 {
    ViewUtilsApi29() {
        super();
    }

    public float getTransitionAlpha(View arg1) {
        return arg1.getTransitionAlpha();
    }

    public void setAnimationMatrix(View arg1, Matrix arg2) {
        arg1.setAnimationMatrix(arg2);
    }

    public void setLeftTopRightBottom(View arg1, int arg2, int arg3, int arg4, int arg5) {
        arg1.setLeftTopRightBottom(arg2, arg3, arg4, arg5);
    }

    public void setTransitionAlpha(View arg1, float arg2) {
        arg1.setTransitionAlpha(arg2);
    }

    public void setTransitionVisibility(View arg1, int arg2) {
        arg1.setTransitionVisibility(arg2);
    }

    public void transformMatrixToGlobal(View arg1, Matrix arg2) {
        arg1.transformMatrixToGlobal(arg2);
    }

    public void transformMatrixToLocal(View arg1, Matrix arg2) {
        arg1.transformMatrixToLocal(arg2);
    }
}

