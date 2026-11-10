package androidx.transition;

import android.os.Build$VERSION;
import android.view.View;

class ViewUtilsApi23 extends ViewUtilsApi22 {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static void setTransitionVisibility(View arg0, int arg1) {
            arg0.setTransitionVisibility(arg1);
        }
    }

    private static boolean sTryHiddenSetTransitionVisibility = true;

    static {
    }

    ViewUtilsApi23() {
        super();
    }

    public void setTransitionVisibility(View arg3, int arg4) {
        if(Build$VERSION.SDK_INT == 28) {
            super.setTransitionVisibility(arg3, arg4);
            return;
        }

        if(ViewUtilsApi23.sTryHiddenSetTransitionVisibility) {
            try {
                Api29Impl.setTransitionVisibility(arg3, arg4);
                return;
            }
            catch(NoSuchMethodError ) {
                ViewUtilsApi23.sTryHiddenSetTransitionVisibility = false;
            }
        }
    }
}

