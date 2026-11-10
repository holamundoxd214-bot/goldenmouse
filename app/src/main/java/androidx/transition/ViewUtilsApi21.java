package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

class ViewUtilsApi21 extends ViewUtilsApi19 {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static void setAnimationMatrix(View arg0, Matrix arg1) {
            arg0.setAnimationMatrix(arg1);
        }

        static void transformMatrixToGlobal(View arg0, Matrix arg1) {
            arg0.transformMatrixToGlobal(arg1);
        }

        static void transformMatrixToLocal(View arg0, Matrix arg1) {
            arg0.transformMatrixToLocal(arg1);
        }
    }

    private static boolean sTryHiddenSetAnimationMatrix = true;
    private static boolean sTryHiddenTransformMatrixToGlobal = true;
    private static boolean sTryHiddenTransformMatrixToLocal = true;

    static {
    }

    ViewUtilsApi21() {
        super();
    }

    public void setAnimationMatrix(View arg1, Matrix arg2) {
        if(ViewUtilsApi21.sTryHiddenSetAnimationMatrix) {
            try {
                Api29Impl.setAnimationMatrix(arg1, arg2);
                return;
            }
            catch(NoSuchMethodError ) {
                ViewUtilsApi21.sTryHiddenSetAnimationMatrix = false;
            }
        }
    }

    public void transformMatrixToGlobal(View arg1, Matrix arg2) {
        if(ViewUtilsApi21.sTryHiddenTransformMatrixToGlobal) {
            try {
                Api29Impl.transformMatrixToGlobal(arg1, arg2);
                return;
            }
            catch(NoSuchMethodError ) {
                ViewUtilsApi21.sTryHiddenTransformMatrixToGlobal = false;
            }
        }
    }

    public void transformMatrixToLocal(View arg1, Matrix arg2) {
        if(ViewUtilsApi21.sTryHiddenTransformMatrixToLocal) {
            try {
                Api29Impl.transformMatrixToLocal(arg1, arg2);
                return;
            }
            catch(NoSuchMethodError ) {
                ViewUtilsApi21.sTryHiddenTransformMatrixToLocal = false;
            }
        }
    }
}

