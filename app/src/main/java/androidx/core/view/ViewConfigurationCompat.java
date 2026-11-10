package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build$VERSION;
import android.util.Log;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import androidx.annotation.ReplaceWith;
import androidx.core.util.Supplier;
import java.lang.reflect.Method;
import java.util.Objects;

public final class ViewConfigurationCompat {
    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static float getScaledHorizontalScrollFactor(ViewConfiguration arg0) {
            return arg0.getScaledHorizontalScrollFactor();
        }

        static float getScaledVerticalScrollFactor(ViewConfiguration arg0) {
            return arg0.getScaledVerticalScrollFactor();
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static int getScaledHoverSlop(ViewConfiguration arg0) {
            return arg0.getScaledHoverSlop();
        }

        static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration arg0) {
            return arg0.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    class Api34Impl {
        private Api34Impl() {
            super();
        }

        static int getScaledMaximumFlingVelocity(ViewConfiguration arg0, int arg1, int arg2, int arg3) {
            return arg0.getScaledMaximumFlingVelocity(arg1, arg2, arg3);
        }

        static int getScaledMinimumFlingVelocity(ViewConfiguration arg0, int arg1, int arg2, int arg3) {
            return arg0.getScaledMinimumFlingVelocity(arg1, arg2, arg3);
        }
    }

    private static final int NO_FLING_MAX_VELOCITY = 0x80000000;
    private static final int NO_FLING_MIN_VELOCITY = 0x7FFFFFFF;
    private static final int RESOURCE_ID_NOT_SUPPORTED = -1;
    private static final int RESOURCE_ID_SUPPORTED_BUT_NOT_FOUND = 0;
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

    public static int $r8$lambda$DUnOdzWd_GMixRu8Q8mhfglZyiM(ViewConfiguration arg0) {
        return arg0.getScaledMinimumFlingVelocity();
    }

    public static int $r8$lambda$u_xUdJpIAAO3758SdHprtx7JUP0(ViewConfiguration arg0) {
        return arg0.getScaledMaximumFlingVelocity();
    }

    static {
    }

    private ViewConfigurationCompat() {
        super();
    }

    private static int getCompatFlingVelocityThreshold(Resources arg1, int arg2, Supplier arg3, int arg4) {
        if(arg2 != -1) {
            if(arg2 != 0) {
                int v1 = arg1.getDimensionPixelSize(arg2);
                if(v1 < 0) {
                }
                else {
                    return v1;
                }
            }

            return arg4;
        }

        return arg3.get().intValue();
    }

    private static float getLegacyScrollFactor(ViewConfiguration arg3, Context arg4) {
        Method v0 = ViewConfigurationCompat.sGetScaledScrollFactorMethod;
        if(v0 != null) {
            try {
                return ((float)v0.invoke(arg3).intValue());
            }
            catch(Exception ) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }

        TypedValue v3 = new TypedValue();
        if(arg4.getTheme().resolveAttribute(0x101004D, v3, true)) {
            return v3.getDimension(arg4.getResources().getDisplayMetrics());
        }

        return 0;
    }

    private static int getPlatformResId(Resources arg1, String arg2, String arg3) {
        return arg1.getIdentifier(arg2, arg3, "android");
    }

    private static int getPreApi34MaximumFlingVelocityResId(Resources arg1, int arg2, int arg3) {
        if(arg2 == 0x400000 && arg3 == 26) {
            return ViewConfigurationCompat.getPlatformResId(arg1, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
        }

        return -1;
    }

    private static int getPreApi34MinimumFlingVelocityResId(Resources arg1, int arg2, int arg3) {
        if(arg2 == 0x400000 && arg3 == 26) {
            return ViewConfigurationCompat.getPlatformResId(arg1, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
        }

        return -1;
    }

    public static float getScaledHorizontalScrollFactor(ViewConfiguration arg0, Context arg1) {
        return Api26Impl.getScaledHorizontalScrollFactor(arg0);
    }

    public static int getScaledHoverSlop(ViewConfiguration arg2) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.getScaledHoverSlop(arg2);
        }

        return arg2.getScaledTouchSlop() / 2;
    }

    public static int getScaledMaximumFlingVelocity(Context arg2, ViewConfiguration arg3, int arg4, int arg5, int arg6) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.getScaledMaximumFlingVelocity(arg3, arg4, arg5, arg6);
        }

        int v0 = 0x80000000;
        if(!ViewConfigurationCompat.isInputDeviceInfoValid(arg4, arg5, arg6)) {
            return v0;
        }

        Resources v2 = arg2.getResources();
        arg4 = ViewConfigurationCompat.getPreApi34MaximumFlingVelocityResId(v2, arg6, arg5);
        Objects.requireNonNull(arg3);
        return ViewConfigurationCompat.getCompatFlingVelocityThreshold(v2, arg4, new ViewConfigurationCompat$$ExternalSyntheticLambda0(arg3), v0);
    }

    public static int getScaledMinimumFlingVelocity(Context arg2, ViewConfiguration arg3, int arg4, int arg5, int arg6) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.getScaledMinimumFlingVelocity(arg3, arg4, arg5, arg6);
        }

        int v0 = 0x7FFFFFFF;
        if(!ViewConfigurationCompat.isInputDeviceInfoValid(arg4, arg5, arg6)) {
            return v0;
        }

        Resources v2 = arg2.getResources();
        arg4 = ViewConfigurationCompat.getPreApi34MinimumFlingVelocityResId(v2, arg6, arg5);
        Objects.requireNonNull(arg3);
        return ViewConfigurationCompat.getCompatFlingVelocityThreshold(v2, arg4, new ViewConfigurationCompat$$ExternalSyntheticLambda1(arg3), v0);
    }

    @ReplaceWith(expression="config.getScaledPagingTouchSlop()") @Deprecated public static int getScaledPagingTouchSlop(ViewConfiguration arg0) {
        return arg0.getScaledPagingTouchSlop();
    }

    public static float getScaledVerticalScrollFactor(ViewConfiguration arg0, Context arg1) {
        return Api26Impl.getScaledVerticalScrollFactor(arg0);
    }

    @ReplaceWith(expression="config.hasPermanentMenuKey()") @Deprecated public static boolean hasPermanentMenuKey(ViewConfiguration arg0) {
        return arg0.hasPermanentMenuKey();
    }

    private static boolean isInputDeviceInfoValid(int arg0, int arg1, int arg2) {
        InputDevice v0 = InputDevice.getDevice(arg0);
        if(v0 != null && v0.getMotionRange(arg1, arg2) != null) {
            return 1;
        }

        return 0;
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration arg2, Context arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.shouldShowMenuShortcutsWhenKeyboardPresent(arg2);
        }

        Resources v2 = arg3.getResources();
        int v3 = ViewConfigurationCompat.getPlatformResId(v2, "config_showMenuShortcutsWhenKeyboardPresent", "bool");
        if(v3 != 0 && (v2.getBoolean(v3))) {
            return 1;
        }

        return 0;
    }
}

