package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import androidx.window.core.Bounds;
import androidx.window.layout.util.WindowMetricsCompatHelper;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\b\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010\b\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0007H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2={"Landroidx/window/layout/WindowMetricsCalculator;", "", "computeCurrentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "activity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "computeMaximumWindowMetrics", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public interface WindowMetricsCalculator {
    @Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001A\u00020\u0006H\u0007J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0007J\b\u0010\u000E\u001A\u00020\u000BH\u0007J\u001D\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0001¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001A\u00020\u00102\u0006\u0010\u0017\u001A\u00020\u0018H\u0000¢\u0006\u0002\b\u0019R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/window/layout/WindowMetricsCalculator$Companion;", "", "<init>", "()V", "decorator", "Lkotlin/Function1;", "Landroidx/window/layout/WindowMetricsCalculator;", "windowMetricsCalculatorCompat", "Landroidx/window/layout/WindowMetricsCalculatorCompat;", "getOrCreate", "overrideDecorator", "", "overridingDecorator", "Landroidx/window/layout/WindowMetricsCalculatorDecorator;", "reset", "translateWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "windowMetrics", "Landroid/view/WindowMetrics;", "density", "", "translateWindowMetrics$window_release", "fromDisplayMetrics", "displayMetrics", "Landroid/util/DisplayMetrics;", "fromDisplayMetrics$window_release", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static Function1 decorator;
        private static final WindowMetricsCalculatorCompat windowMetricsCalculatorCompat;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.decorator = new WindowMetricsCalculator$Companion$$ExternalSyntheticLambda1();
            Companion.windowMetricsCalculatorCompat = new WindowMetricsCalculatorCompat(null, 1, null);
        }

        private Companion() {
            super();
        }

        static final WindowMetricsCalculator decorator$lambda$0(WindowMetricsCalculator arg1) {
            Intrinsics.checkNotNullParameter(arg1, "it");
            return arg1;
        }

        public final WindowMetrics fromDisplayMetrics$window_release(DisplayMetrics arg5) {
            Intrinsics.checkNotNullParameter(arg5, "displayMetrics");
            return new WindowMetrics(new Bounds(0, 0, arg5.widthPixels, arg5.heightPixels), arg5.density);
        }

        @JvmStatic public final WindowMetricsCalculator getOrCreate() {
            return Companion.decorator.invoke(Companion.windowMetricsCalculatorCompat);
        }

        @JvmStatic public final void overrideDecorator(WindowMetricsCalculatorDecorator arg1) {
            Intrinsics.checkNotNullParameter(arg1, "overridingDecorator");
            Companion.decorator = new WindowMetricsCalculator$Companion$overrideDecorator$1(arg1);
        }

        @JvmStatic public final void reset() {
            Companion.decorator = new WindowMetricsCalculator$Companion$$ExternalSyntheticLambda0();
        }

        static final WindowMetricsCalculator reset$lambda$1(WindowMetricsCalculator arg1) {
            Intrinsics.checkNotNullParameter(arg1, "it");
            return arg1;
        }

        public final WindowMetrics translateWindowMetrics$window_release(android.view.WindowMetrics arg1, float arg2) {
            Intrinsics.checkNotNullParameter(arg1, "windowMetrics");
            return WindowMetricsCompatHelper.Companion.getInstance().translateWindowMetrics(arg1, arg2);
        }
    }

    public static final Companion Companion;

    static {
        WindowMetricsCalculator.Companion = Companion.$$INSTANCE;
    }

    default WindowMetrics computeCurrentWindowMetrics(Context arg1) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        throw new NotImplementedError("Must override computeCurrentWindowMetrics(context) and provide an implementation.");
    }

    WindowMetrics computeCurrentWindowMetrics(Activity arg1);

    WindowMetrics computeMaximumWindowMetrics(Activity arg1);

    default WindowMetrics computeMaximumWindowMetrics(Context arg1) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        throw new NotImplementedError("Must override computeMaximumWindowMetrics(context) and provide an implementation.");
    }

    @JvmStatic static WindowMetricsCalculator getOrCreate() {
        return WindowMetricsCalculator.Companion.getOrCreate();
    }

    @JvmStatic static void overrideDecorator(WindowMetricsCalculatorDecorator arg1) {
        WindowMetricsCalculator.Companion.overrideDecorator(arg1);
    }

    @JvmStatic static void reset() {
        WindowMetricsCalculator.Companion.reset();
    }
}

