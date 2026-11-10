package androidx.window.layout.util;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Landroidx/window/layout/util/ActivityCompatHelperApi24;", "", "<init>", "()V", "isInMultiWindowMode", "", "activity", "Landroid/app/Activity;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ActivityCompatHelperApi24 {
    public static final ActivityCompatHelperApi24 INSTANCE;

    static {
        ActivityCompatHelperApi24.INSTANCE = new ActivityCompatHelperApi24();
    }

    private ActivityCompatHelperApi24() {
        super();
    }

    public final boolean isInMultiWindowMode(Activity arg1) {
        Intrinsics.checkNotNullParameter(arg1, "activity");
        return arg1.isInMultiWindowMode();
    }
}

