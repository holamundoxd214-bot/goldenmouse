package androidx.transition;

import android.os.Build$VERSION;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewGroupUtils {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static int getChildDrawingOrder(ViewGroup arg0, int arg1) {
            return arg0.getChildDrawingOrder(arg1);
        }

        static void suppressLayout(ViewGroup arg0, boolean arg1) {
            arg0.suppressLayout(arg1);
        }
    }

    private static Method sGetChildDrawingOrderMethod = null;
    private static boolean sGetChildDrawingOrderMethodFetched = false;
    private static boolean sTryHiddenSuppressLayout = true;

    static {
    }

    private ViewGroupUtils() {
        super();
    }

    static int getChildDrawingOrder(ViewGroup arg6, int arg7) {
        if(Build$VERSION.SDK_INT >= 29) {
            return Api29Impl.getChildDrawingOrder(arg6, arg7);
        }

        if(!ViewGroupUtils.sGetChildDrawingOrderMethodFetched) {
            try {
                Method v1 = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", Integer.TYPE, Integer.TYPE);
                ViewGroupUtils.sGetChildDrawingOrderMethod = v1;
                v1.setAccessible(true);
                goto label_20;
            }
            catch(NoSuchMethodException ) {
            label_20:
                ViewGroupUtils.sGetChildDrawingOrderMethodFetched = true;
            }
        }

        Method v0 = ViewGroupUtils.sGetChildDrawingOrderMethod;
        if(v0 == null) {
            return arg7;
        }

        try {
            return v0.invoke(arg6, Integer.valueOf(arg6.getChildCount()), Integer.valueOf(arg7)).intValue();
        }
        catch(InvocationTargetException ) {
            return arg7;
        }
    }

    private static void hiddenSuppressLayout(ViewGroup arg1, boolean arg2) {
        if(ViewGroupUtils.sTryHiddenSuppressLayout) {
            try {
                Api29Impl.suppressLayout(arg1, arg2);
                return;
            }
            catch(NoSuchMethodError ) {
                ViewGroupUtils.sTryHiddenSuppressLayout = false;
            }
        }
    }

    static void suppressLayout(ViewGroup arg2, boolean arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.suppressLayout(arg2, arg3);
            return;
        }

        ViewGroupUtils.hiddenSuppressLayout(arg2, arg3);
    }
}

