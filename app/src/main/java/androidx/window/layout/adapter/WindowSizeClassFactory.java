package androidx.window.layout.adapter;

import androidx.window.core.layout.WindowSizeClass;
import androidx.window.core.layout.WindowSizeClassSelectors;
import androidx.window.layout.WindowMetrics;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0003\u001A\u00020\u0004¨\u0006\u0005"}, d2={"computeWindowSizeClass", "Landroidx/window/core/layout/WindowSizeClass;", "", "windowMetrics", "Landroidx/window/layout/WindowMetrics;", "window_release"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WindowSizeClassFactory {
    public static final WindowSizeClass computeWindowSizeClass(Set arg1, WindowMetrics arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "windowMetrics");
        return WindowSizeClassSelectors.computeWindowSizeClass(arg1, arg2.getWidthDp(), arg2.getHeightDp());
    }
}

