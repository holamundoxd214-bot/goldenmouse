package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build$VERSION;
import androidx.window.layout.WindowMetrics;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u0018\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\'J\u0018\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH&J\u0018\u0010\b\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\fH&J\u0018\u0010\u000F\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2={"Landroidx/window/layout/util/WindowMetricsCompatHelper;", "", "translateWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "windowMetrics", "Landroid/view/WindowMetrics;", "density", "", "currentWindowMetrics", "context", "Landroid/content/Context;", "densityCompatHelper", "Landroidx/window/layout/util/DensityCompatHelper;", "activity", "Landroid/app/Activity;", "maximumWindowMetrics", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public interface WindowMetricsCompatHelper {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001A\u00020\u0005¨\u0006\u0006"}, d2={"Landroidx/window/layout/util/WindowMetricsCompatHelper$Companion;", "", "<init>", "()V", "getInstance", "Landroidx/window/layout/util/WindowMetricsCompatHelper;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }

        public final WindowMetricsCompatHelper getInstance() {
            if(Build$VERSION.SDK_INT >= 34) {
                return WindowMetricsCompatHelperApi34Impl.INSTANCE;
            }

            if(Build$VERSION.SDK_INT >= 30) {
                return WindowMetricsCompatHelperApi30Impl.INSTANCE;
            }

            return WindowMetricsCompatHelperBaseImpl.INSTANCE;
        }
    }

    public static final Companion Companion;

    static {
        WindowMetricsCompatHelper.Companion = Companion.$$INSTANCE;
    }

    WindowMetrics currentWindowMetrics(Activity arg1, DensityCompatHelper arg2);

    WindowMetrics currentWindowMetrics(Context arg1, DensityCompatHelper arg2);

    WindowMetrics maximumWindowMetrics(Context arg1, DensityCompatHelper arg2);

    WindowMetrics translateWindowMetrics(android.view.WindowMetrics arg1, float arg2);
}

