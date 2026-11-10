package androidx.core.view;

import android.os.Build$VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager$LayoutParams;
import java.util.Objects;

public final class WindowCompat {
    class Api16Impl {
        private Api16Impl() {
            super();
        }

        static void setDecorFitsSystemWindows(Window arg1, boolean arg2) {
            View v1 = arg1.getDecorView();
            int v0 = v1.getSystemUiVisibility();
            int v2 = arg2 ? v0 & 0xFFFFF8FF : v0 | 0x700;
            v1.setSystemUiVisibility(v2);
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static Object requireViewById(Window arg0, int arg1) {
            return arg0.requireViewById(arg1);
        }
    }

    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static void setDecorFitsSystemWindows(Window arg2, boolean arg3) {
            View v0 = arg2.getDecorView();
            int v1 = v0.getSystemUiVisibility();
            if(arg3) {
                v1 &= 0xFFFFFEFF;
            }
            else {
                v1 |= 0x100;
            }

            v0.setSystemUiVisibility(v1);
            arg2.setDecorFitsSystemWindows(arg3);
        }
    }

    class Api35Impl {
        private Api35Impl() {
            super();
        }

        static void setDecorFitsSystemWindows(Window arg0, boolean arg1) {
            arg0.setDecorFitsSystemWindows(arg1);
        }
    }

    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    private WindowCompat() {
        super();
    }

    public static void enableEdgeToEdge(Window arg4) {
        Objects.requireNonNull(arg4);
        arg4.getDecorView();
        WindowCompat.setDecorFitsSystemWindows(arg4, false);
        arg4.setStatusBarColor(0);
        arg4.setNavigationBarColor(0);
        if(Build$VERSION.SDK_INT >= 28) {
            int v1 = Build$VERSION.SDK_INT >= 30 ? 3 : 1;
            WindowManager$LayoutParams v2 = arg4.getAttributes();
            if(v2.layoutInDisplayCutoutMode == v1) {
                goto label_20;
            }

            v2.layoutInDisplayCutoutMode = v1;
            arg4.setAttributes(v2);
        }

    label_20:
        if(Build$VERSION.SDK_INT >= 29) {
            arg4.setStatusBarContrastEnforced(false);
            arg4.setNavigationBarContrastEnforced(false);
        }
    }

    public static WindowInsetsControllerCompat getInsetsController(Window arg1, View arg2) {
        return new WindowInsetsControllerCompat(arg1, arg2);
    }

    public static View requireViewById(Window arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.requireViewById(arg2, arg3);
        }

        View v2 = arg2.findViewById(arg3);
        if(v2 != null) {
            return v2;
        }

        throw new IllegalArgumentException("ID does not reference a View inside this Window");
    }

    public static void setDecorFitsSystemWindows(Window arg2, boolean arg3) {
        if(Build$VERSION.SDK_INT >= 35) {
            Api35Impl.setDecorFitsSystemWindows(arg2, arg3);
            return;
        }

        if(Build$VERSION.SDK_INT >= 30) {
            Api30Impl.setDecorFitsSystemWindows(arg2, arg3);
            return;
        }

        Api16Impl.setDecorFitsSystemWindows(arg2, arg3);
    }
}

