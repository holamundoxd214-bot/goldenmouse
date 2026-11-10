package androidx.window.layout.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.view.Display;
import android.view.WindowManager;
import androidx.window.core.Bounds;
import androidx.window.layout.WindowMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J\u0018\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016J\u0018\u0010\n\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u000EH\u0016J\u0018\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016¨\u0006\u0012"}, d2={"Landroidx/window/layout/util/WindowMetricsCompatHelperBaseImpl;", "Landroidx/window/layout/util/WindowMetricsCompatHelper;", "<init>", "()V", "translateWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "windowMetrics", "Landroid/view/WindowMetrics;", "density", "", "currentWindowMetrics", "context", "Landroid/content/Context;", "densityCompatHelper", "Landroidx/window/layout/util/DensityCompatHelper;", "activity", "Landroid/app/Activity;", "maximumWindowMetrics", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowMetricsCompatHelperBaseImpl implements WindowMetricsCompatHelper {
    public static final WindowMetricsCompatHelperBaseImpl INSTANCE;

    static {
        WindowMetricsCompatHelperBaseImpl.INSTANCE = new WindowMetricsCompatHelperBaseImpl();
    }

    private WindowMetricsCompatHelperBaseImpl() {
        super();
    }

    public WindowMetrics currentWindowMetrics(Activity arg3, DensityCompatHelper arg4) {
        Intrinsics.checkNotNullParameter(arg3, "activity");
        Intrinsics.checkNotNullParameter(arg4, "densityCompatHelper");
        return new WindowMetrics(new Bounds(BoundsHelper.Companion.getInstance().currentWindowBounds(arg3)), arg4.density(((Context)arg3)));
    }

    public WindowMetrics currentWindowMetrics(Context arg4, DensityCompatHelper arg5) {
        Intrinsics.checkNotNullParameter(arg4, "context");
        Intrinsics.checkNotNullParameter(arg5, "densityCompatHelper");
        Context v0 = ContextCompatHelper.INSTANCE.unwrapContext$window_release(arg4);
        if((v0 instanceof Activity)) {
            return this.currentWindowMetrics(((Activity)v0), arg5);
        }

        if(!(v0 instanceof InputMethodService)) {
            if((v0 instanceof Application)) {
            }
            else {
                throw new IllegalArgumentException("Must provide a UiContext or Application Context");
            }
        }

        Object v3 = arg4.getSystemService("window");
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayHelper v0_1 = DisplayHelper.INSTANCE;
        Display v3_1 = ((WindowManager)v3).getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(v3_1, "getDefaultDisplay(...)");
        Point v3_2 = v0_1.getRealSizeForDisplay(v3_1);
        return new WindowMetrics(new Rect(0, 0, v3_2.x, v3_2.y), arg5.density(arg4));
    }

    public WindowMetrics maximumWindowMetrics(Context arg3, DensityCompatHelper arg4) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        Intrinsics.checkNotNullParameter(arg4, "densityCompatHelper");
        return new WindowMetrics(new Bounds(BoundsHelper.Companion.getInstance().maximumWindowBounds(arg3)), arg4.density(arg3));
    }

    public WindowMetrics translateWindowMetrics(android.view.WindowMetrics arg1, float arg2) {
        Intrinsics.checkNotNullParameter(arg1, "windowMetrics");
        throw new UnsupportedOperationException("translateWindowMetrics not available before API30");
    }
}

