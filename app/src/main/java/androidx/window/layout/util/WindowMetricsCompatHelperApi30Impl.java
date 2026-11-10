package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;
import androidx.window.core.Bounds;
import androidx.window.layout.WindowMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J\u0018\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016J\u0018\u0010\n\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u000EH\u0016J\u0018\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016¨\u0006\u0012"}, d2={"Landroidx/window/layout/util/WindowMetricsCompatHelperApi30Impl;", "Landroidx/window/layout/util/WindowMetricsCompatHelper;", "<init>", "()V", "translateWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "windowMetrics", "Landroid/view/WindowMetrics;", "density", "", "currentWindowMetrics", "context", "Landroid/content/Context;", "densityCompatHelper", "Landroidx/window/layout/util/DensityCompatHelper;", "activity", "Landroid/app/Activity;", "maximumWindowMetrics", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowMetricsCompatHelperApi30Impl implements WindowMetricsCompatHelper {
    public static final WindowMetricsCompatHelperApi30Impl INSTANCE;

    static {
        WindowMetricsCompatHelperApi30Impl.INSTANCE = new WindowMetricsCompatHelperApi30Impl();
    }

    private WindowMetricsCompatHelperApi30Impl() {
        super();
    }

    public WindowMetrics currentWindowMetrics(Activity arg3, DensityCompatHelper arg4) {
        Intrinsics.checkNotNullParameter(arg3, "activity");
        Intrinsics.checkNotNullParameter(arg4, "densityCompatHelper");
        return new WindowMetrics(new Bounds(BoundsHelper.Companion.getInstance().currentWindowBounds(arg3)), arg4.density(((Context)arg3)));
    }

    public WindowMetrics currentWindowMetrics(Context arg2, DensityCompatHelper arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "densityCompatHelper");
        Object v1 = arg2.getSystemService(WindowManager.class);
        float v2 = arg2.getResources().getDisplayMetrics().density;
        Rect v1_1 = ((WindowManager)v1).getCurrentWindowMetrics().getBounds();
        Intrinsics.checkNotNullExpressionValue(v1_1, "getBounds(...)");
        return new WindowMetrics(v1_1, v2);
    }

    public WindowMetrics maximumWindowMetrics(Context arg3, DensityCompatHelper arg4) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        Intrinsics.checkNotNullParameter(arg4, "densityCompatHelper");
        return new WindowMetrics(new Bounds(BoundsHelper.Companion.getInstance().maximumWindowBounds(arg3)), arg4.density(arg3));
    }

    public WindowMetrics translateWindowMetrics(android.view.WindowMetrics arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg2, "windowMetrics");
        Rect v2 = arg2.getBounds();
        Intrinsics.checkNotNullExpressionValue(v2, "getBounds(...)");
        return new WindowMetrics(v2, arg3);
    }
}

