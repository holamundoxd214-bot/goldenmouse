package androidx.core.view;

import android.os.Build$VERSION;
import android.view.View$OnApplyWindowInsetsListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ReplaceWith;
import androidx.core.R$id;

public final class ViewGroupCompat {
    private static final WindowInsets CONSUMED = null;
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;
    static boolean sCompatInsetsDispatchInstalled;

    static {
        ViewGroupCompat.CONSUMED = WindowInsetsCompat.CONSUMED.toWindowInsets();
        ViewGroupCompat.sCompatInsetsDispatchInstalled = false;
    }

    private ViewGroupCompat() {
        super();
    }

    static WindowInsets dispatchApplyWindowInsets(View arg5, WindowInsets arg6) {
        Object v0 = arg5.getTag(id.tag_on_apply_window_listener);
        Object v1 = arg5.getTag(id.tag_window_insets_animation_callback);
        if((v0 instanceof View$OnApplyWindowInsetsListener)) {
        }
        else if((v1 instanceof View$OnApplyWindowInsetsListener)) {
            v0 = v1;
        }
        else {
            View$OnApplyWindowInsetsListener v0_1 = null;
        }

        WindowInsets[] v1_1 = new WindowInsets[]{ViewGroupCompat.CONSUMED};
        arg5.setOnApplyWindowInsetsListener(new ViewGroupCompat$$ExternalSyntheticLambda0(v1_1, ((View$OnApplyWindowInsetsListener)v0)));
        arg5.dispatchApplyWindowInsets(arg6);
        Object v6 = arg5.getTag(id.tag_compat_insets_dispatch);
        if((v6 instanceof View$OnApplyWindowInsetsListener)) {
            v0 = v6;
        }

        arg5.setOnApplyWindowInsetsListener(((View$OnApplyWindowInsetsListener)v0));
        arg6 = v1_1[0];
        if(arg6 != null && !arg6.isConsumed() && ((arg5 instanceof ViewGroup))) {
            int v6_1 = ((ViewGroup)arg5).getChildCount();
            int v0_2;
            for(v0_2 = 0; v0_2 < v6_1; ++v0_2) {
                ViewGroupCompat.dispatchApplyWindowInsets(((ViewGroup)arg5).getChildAt(v0_2), v1_1[0]);
            }
        }

        WindowInsets v5 = v1_1[0];
        if(v5 != null) {
            return v5;
        }

        return ViewGroupCompat.CONSUMED;
    }

    @ReplaceWith(expression="group.getLayoutMode()") @Deprecated public static int getLayoutMode(ViewGroup arg0) {
        return arg0.getLayoutMode();
    }

    public static int getNestedScrollAxes(ViewGroup arg0) {
        return arg0.getNestedScrollAxes();
    }

    public static void installCompatInsetsDispatch(View arg2) {
        if(Build$VERSION.SDK_INT >= 30) {
            return;
        }

        ViewGroupCompat$$ExternalSyntheticLambda1 v0 = new ViewGroupCompat$$ExternalSyntheticLambda1();
        arg2.setTag(id.tag_compat_insets_dispatch, v0);
        arg2.setOnApplyWindowInsetsListener(((View$OnApplyWindowInsetsListener)v0));
        ViewGroupCompat.sCompatInsetsDispatchInstalled = true;
    }

    public static boolean isTransitionGroup(ViewGroup arg0) {
        return arg0.isTransitionGroup();
    }

    static WindowInsets lambda$dispatchApplyWindowInsets$1(WindowInsets[] arg0, View$OnApplyWindowInsetsListener arg1, View arg2, WindowInsets arg3) {
        WindowInsets v1 = arg1 != null ? arg1.onApplyWindowInsets(arg2, arg3) : arg2.onApplyWindowInsets(arg3);
        arg0[0] = v1;
        return ViewGroupCompat.CONSUMED;
    }

    static WindowInsets lambda$installCompatInsetsDispatch$0(View arg0, WindowInsets arg1) {
        ViewGroupCompat.dispatchApplyWindowInsets(arg0, arg1);
        return ViewGroupCompat.CONSUMED;
    }

    @ReplaceWith(expression="group.onRequestSendAccessibilityEvent(child, event)") @Deprecated public static boolean onRequestSendAccessibilityEvent(ViewGroup arg0, View arg1, AccessibilityEvent arg2) {
        return arg0.onRequestSendAccessibilityEvent(arg1, arg2);
    }

    @ReplaceWith(expression="group.setLayoutMode(mode)") @Deprecated public static void setLayoutMode(ViewGroup arg0, int arg1) {
        arg0.setLayoutMode(arg1);
    }

    @ReplaceWith(expression="group.setMotionEventSplittingEnabled(split)") @Deprecated public static void setMotionEventSplittingEnabled(ViewGroup arg0, boolean arg1) {
        arg0.setMotionEventSplittingEnabled(arg1);
    }

    public static void setTransitionGroup(ViewGroup arg0, boolean arg1) {
        arg0.setTransitionGroup(arg1);
    }
}

