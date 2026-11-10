package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build$VERSION;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewUtils {
    static final boolean SDK_LEVEL_SUPPORTS_AUTOSIZE = false;
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    static {
        boolean v0 = Build$VERSION.SDK_INT >= 27 ? true : false;
        ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE = v0;
        try {
            Class v0_1 = View.class;
            Class[] v4 = new Class[2];
            Class v5 = Rect.class;
            v4[0] = v5;
            v4[1] = v5;
            Method v0_2 = v0_1.getDeclaredMethod("computeFitSystemWindows", v4);
            ViewUtils.sComputeFitSystemWindowsMethod = v0_2;
            if(!v0_2.isAccessible()) {
                ViewUtils.sComputeFitSystemWindowsMethod.setAccessible(true);
            }
        }
        catch(NoSuchMethodException ) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            return;
        }
    }

    private ViewUtils() {
        super();
    }

    public static void computeFitSystemWindows(View arg1, Rect arg2, Rect arg3) {
        Method v0 = ViewUtils.sComputeFitSystemWindowsMethod;
        if(v0 != null) {
            try {
                v0.invoke(arg1, arg2, arg3);
                return;
            }
            catch(Exception v1) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", ((Throwable)v1));
            }
        }
    }

    public static boolean isLayoutRtl(View arg1) {
        if(ViewCompat.getLayoutDirection(arg1) == 1) {
            return 1;
        }

        return 0;
    }

    public static void makeOptionalFitsSystemWindows(View arg6) {
        String v0 = "Could not invoke makeOptionalFitsSystemWindows";
        String v1 = "ViewUtils";
        try {
            Method v2 = arg6.getClass().getMethod("makeOptionalFitsSystemWindows");
            if(!v2.isAccessible()) {
                v2.setAccessible(true);
            }

            v2.invoke(arg6);
            return;
        }
        catch(IllegalAccessException v6) {
            Log.d(v1, v0, ((Throwable)v6));
        }
        catch(InvocationTargetException v6_1) {
            Log.d(v1, v0, ((Throwable)v6_1));
        }
        catch(NoSuchMethodException ) {
            Log.d(v1, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        }
    }
}

