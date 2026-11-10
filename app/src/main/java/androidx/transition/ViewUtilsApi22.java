package androidx.transition;

import android.view.View;

class ViewUtilsApi22 extends ViewUtilsApi21 {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static void setLeftTopRightBottom(View arg0, int arg1, int arg2, int arg3, int arg4) {
            arg0.setLeftTopRightBottom(arg1, arg2, arg3, arg4);
        }
    }

    private static boolean sTryHiddenSetLeftTopRightBottom = true;

    static {
    }

    ViewUtilsApi22() {
        super();
    }

    public void setLeftTopRightBottom(View arg1, int arg2, int arg3, int arg4, int arg5) {
        if(ViewUtilsApi22.sTryHiddenSetLeftTopRightBottom) {
            try {
                Api29Impl.setLeftTopRightBottom(arg1, arg2, arg3, arg4, arg5);
                return;
            }
            catch(NoSuchMethodError ) {
                ViewUtilsApi22.sTryHiddenSetLeftTopRightBottom = false;
            }
        }
    }
}

