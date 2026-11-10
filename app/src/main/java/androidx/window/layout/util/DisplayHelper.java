package androidx.window.layout.util;

import android.graphics.Point;
import android.view.Display;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Landroidx/window/layout/util/DisplayHelper;", "", "<init>", "()V", "getRealSizeForDisplay", "Landroid/graphics/Point;", "display", "Landroid/view/Display;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DisplayHelper {
    public static final DisplayHelper INSTANCE;

    static {
        DisplayHelper.INSTANCE = new DisplayHelper();
    }

    private DisplayHelper() {
        super();
    }

    public final Point getRealSizeForDisplay(Display arg1) {
        Intrinsics.checkNotNullParameter(arg1, "display");
        Point v0 = new Point();
        arg1.getRealSize(v0);
        return v0;
    }
}

