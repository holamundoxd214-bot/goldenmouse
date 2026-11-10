package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;
import androidx.window.layout.WindowMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J\u0018\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016J\u0018\u0010\n\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u000EH\u0016J\u0018\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016¨\u0006\u0012"}, d2={"Landroidx/window/layout/util/WindowMetricsCompatHelperApi34Impl;", "Landroidx/window/layout/util/WindowMetricsCompatHelper;", "<init>", "()V", "translateWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "windowMetrics", "Landroid/view/WindowMetrics;", "density", "", "currentWindowMetrics", "context", "Landroid/content/Context;", "densityCompatHelper", "Landroidx/window/layout/util/DensityCompatHelper;", "activity", "Landroid/app/Activity;", "maximumWindowMetrics", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowMetricsCompatHelperApi34Impl implements WindowMetricsCompatHelper {
    public static final WindowMetricsCompatHelperApi34Impl INSTANCE;

    static {
        WindowMetricsCompatHelperApi34Impl.INSTANCE = new WindowMetricsCompatHelperApi34Impl();
    }

    private WindowMetricsCompatHelperApi34Impl() {
        super();
    }

    public WindowMetrics currentWindowMetrics(Activity arg1, DensityCompatHelper arg2) {
        Intrinsics.checkNotNullParameter(arg1, "activity");
        Intrinsics.checkNotNullParameter(arg2, "densityCompatHelper");
        return WindowMetricsCompatHelperApi30Impl.INSTANCE.currentWindowMetrics(arg1, arg2);
    }

    public WindowMetrics currentWindowMetrics(Context arg2, DensityCompatHelper arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "densityCompatHelper");
        Object v1 = arg2.isUiContext() ? arg2.getSystemService(WindowManager.class) : arg2.getApplicationContext().getSystemService(WindowManager.class);
        Rect v3 = ((WindowManager)v1).getCurrentWindowMetrics().getBounds();
        Intrinsics.checkNotNullExpressionValue(v3, "getBounds(...)");
        return new WindowMetrics(v3, ((WindowManager)v1).getCurrentWindowMetrics().getDensity());
    }

    public WindowMetrics maximumWindowMetrics(Context arg1, DensityCompatHelper arg2) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        Intrinsics.checkNotNullParameter(arg2, "densityCompatHelper");
        return WindowMetricsCompatHelperApi30Impl.INSTANCE.maximumWindowMetrics(arg1, arg2);
    }

    public WindowMetrics translateWindowMetrics(android.view.WindowMetrics arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg2, "windowMetrics");
        Rect v3 = arg2.getBounds();
        Intrinsics.checkNotNullExpressionValue(v3, "getBounds(...)");
        return new WindowMetrics(v3, arg2.getDensity());
    }
}

