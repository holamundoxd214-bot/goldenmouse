package androidx.window.layout.util;

import android.view.DisplayCutout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u000E\u0010\b\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u000E\u0010\t\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u000E\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\u000B"}, d2={"Landroidx/window/layout/util/DisplayCompatHelperApi28;", "", "<init>", "()V", "safeInsetLeft", "", "displayCutout", "Landroid/view/DisplayCutout;", "safeInsetTop", "safeInsetRight", "safeInsetBottom", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DisplayCompatHelperApi28 {
    public static final DisplayCompatHelperApi28 INSTANCE;

    static {
        DisplayCompatHelperApi28.INSTANCE = new DisplayCompatHelperApi28();
    }

    private DisplayCompatHelperApi28() {
        super();
    }

    public final int safeInsetBottom(DisplayCutout arg1) {
        Intrinsics.checkNotNullParameter(arg1, "displayCutout");
        return arg1.getSafeInsetBottom();
    }

    public final int safeInsetLeft(DisplayCutout arg1) {
        Intrinsics.checkNotNullParameter(arg1, "displayCutout");
        return arg1.getSafeInsetLeft();
    }

    public final int safeInsetRight(DisplayCutout arg1) {
        Intrinsics.checkNotNullParameter(arg1, "displayCutout");
        return arg1.getSafeInsetRight();
    }

    public final int safeInsetTop(DisplayCutout arg1) {
        Intrinsics.checkNotNullParameter(arg1, "displayCutout");
        return arg1.getSafeInsetTop();
    }
}

