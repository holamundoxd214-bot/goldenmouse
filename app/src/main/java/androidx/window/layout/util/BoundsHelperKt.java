package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0002\u001A\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0002\u001A\u0012\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\rH\u0003¨\u0006\u000E"}, d2={"getNavigationBarHeight", "", "context", "Landroid/content/Context;", "getRectSizeFromDisplay", "", "activity", "Landroid/app/Activity;", "bounds", "Landroid/graphics/Rect;", "getCutoutForDisplay", "Landroid/view/DisplayCutout;", "display", "Landroid/view/Display;", "window_release"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BoundsHelperKt {
    public static final DisplayCutout access$getCutoutForDisplay(Display arg0) {
        return BoundsHelperKt.getCutoutForDisplay(arg0);
    }

    public static final int access$getNavigationBarHeight(Context arg0) {
        return BoundsHelperKt.getNavigationBarHeight(arg0);
    }

    public static final void access$getRectSizeFromDisplay(Activity arg0, Rect arg1) {
        BoundsHelperKt.getRectSizeFromDisplay(arg0, arg1);
    }

    private static final DisplayCutout getCutoutForDisplay(Display arg7) {
        try {
            Constructor v0 = Class.forName("android.view.DisplayInfo").getConstructor();
            v0.setAccessible(true);
            Object v0_1 = v0.newInstance();
            Method v1 = arg7.getClass().getDeclaredMethod("getDisplayInfo", v0_1.getClass());
            v1.setAccessible(true);
            v1.invoke(arg7, v0_1);
            Field v7_1 = v0_1.getClass().getDeclaredField("displayCutout");
            v7_1.setAccessible(true);
            Object v7_2 = v7_1.get(v0_1);
            if(!(v7_2 instanceof DisplayCutout)) {
                return null;
            }

            return ((DisplayCutout)v7_2);
        }
        catch(Exception v7) {
            if(!(v7 instanceof ClassNotFoundException) && !(v7 instanceof NoSuchMethodException) && !(v7 instanceof NoSuchFieldException) && !(v7 instanceof IllegalAccessException) && !(v7 instanceof InvocationTargetException)) {
                if((v7 instanceof InstantiationException)) {
                }
                else {
                    throw v7;
                }
            }

            Log.w(BoundsHelper.Companion.getTAG(), ((Throwable)v7));
        }

        return null;
    }

    private static final int getNavigationBarHeight(Context arg3) {
        Resources v3 = arg3.getResources();
        int v0 = v3.getIdentifier("navigation_bar_height", "dimen", "android");
        if(v0 > 0) {
            return v3.getDimensionPixelSize(v0);
        }

        return 0;
    }

    private static final void getRectSizeFromDisplay(Activity arg0, Rect arg1) {
        arg0.getWindowManager().getDefaultDisplay().getRectSize(arg1);
    }
}

