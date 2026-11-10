package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.window.layout.util.DensityCompatHelper;
import androidx.window.layout.util.WindowMetricsCompatHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0010\u0010\f\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0010\u0010\f\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\r\u001A\u0012\u0012\u0004\u0012\u00020\u000F0\u000Ej\b\u0012\u0004\u0012\u00020\u000F`\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2={"Landroidx/window/layout/WindowMetricsCalculatorCompat;", "Landroidx/window/layout/WindowMetricsCalculator;", "densityCompatHelper", "Landroidx/window/layout/util/DensityCompatHelper;", "<init>", "(Landroidx/window/layout/util/DensityCompatHelper;)V", "computeCurrentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "computeMaximumWindowMetrics", "insetsTypeMasks", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getInsetsTypeMasks$window_release", "()Ljava/util/ArrayList;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {
    private final DensityCompatHelper densityCompatHelper;
    private final ArrayList insetsTypeMasks;

    public WindowMetricsCalculatorCompat(DensityCompatHelper arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = DensityCompatHelper.Companion.getInstance();
        }

        this(arg1);
    }

    public WindowMetricsCalculatorCompat() {
        this(null, 1, null);
    }

    public WindowMetricsCalculatorCompat(DensityCompatHelper arg3) {
        Intrinsics.checkNotNullParameter(arg3, "densityCompatHelper");
        super();
        this.densityCompatHelper = arg3;
        this.insetsTypeMasks = CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(Type.statusBars()), Integer.valueOf(Type.navigationBars()), Integer.valueOf(Type.captionBar()), Integer.valueOf(Type.ime()), Integer.valueOf(Type.systemGestures()), Integer.valueOf(Type.mandatorySystemGestures()), Integer.valueOf(Type.tappableElement()), Integer.valueOf(Type.displayCutout())});
    }

    public WindowMetrics computeCurrentWindowMetrics(Activity arg2) {
        Intrinsics.checkNotNullParameter(arg2, "activity");
        return WindowMetricsCompatHelper.Companion.getInstance().currentWindowMetrics(arg2, this.densityCompatHelper);
    }

    public WindowMetrics computeCurrentWindowMetrics(Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        return WindowMetricsCompatHelper.Companion.getInstance().currentWindowMetrics(arg2, this.densityCompatHelper);
    }

    public WindowMetrics computeMaximumWindowMetrics(Activity arg2) {
        Intrinsics.checkNotNullParameter(arg2, "activity");
        return WindowMetricsCompatHelper.Companion.getInstance().maximumWindowMetrics(((Context)arg2), this.densityCompatHelper);
    }

    public WindowMetrics computeMaximumWindowMetrics(Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        return WindowMetricsCompatHelper.Companion.getInstance().maximumWindowMetrics(arg2, this.densityCompatHelper);
    }

    public final ArrayList getInsetsTypeMasks$window_release() {
        return this.insetsTypeMasks;
    }
}

