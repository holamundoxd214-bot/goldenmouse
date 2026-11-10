package androidx.activity.result;

import androidx.core.app.ActivityOptionsCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u001A#\u0010\u0000\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2={"launch", "", "Landroidx/activity/result/ActivityResultLauncher;", "Ljava/lang/Void;", "options", "Landroidx/core/app/ActivityOptionsCompat;", "launchUnit", "activity"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ActivityResultLauncherKt {
    public static final void launch(ActivityResultLauncher arg1, ActivityOptionsCompat arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.launch(null, arg2);
    }

    public static void launch$default(ActivityResultLauncher arg0, ActivityOptionsCompat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        ActivityResultLauncherKt.launch(arg0, arg1);
    }

    public static final void launchUnit(ActivityResultLauncher arg1, ActivityOptionsCompat arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.launch(Unit.INSTANCE, arg2);
    }

    public static void launchUnit$default(ActivityResultLauncher arg0, ActivityOptionsCompat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        ActivityResultLauncherKt.launchUnit(arg0, arg1);
    }
}

