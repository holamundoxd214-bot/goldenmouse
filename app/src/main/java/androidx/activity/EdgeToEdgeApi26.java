package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000EH\u0017¨\u0006\u0010"}, d2={"Landroidx/activity/EdgeToEdgeApi26;", "Landroidx/activity/EdgeToEdgeBase;", "<init>", "()V", "setUp", "", "statusBarStyle", "Landroidx/activity/SystemBarStyle;", "navigationBarStyle", "window", "Landroid/view/Window;", "view", "Landroid/view/View;", "statusBarIsDark", "", "navigationBarIsDark", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) class EdgeToEdgeApi26 extends EdgeToEdgeBase {
    public EdgeToEdgeApi26() {
        super();
    }

    public void setUp(SystemBarStyle arg1, SystemBarStyle arg2, Window arg3, View arg4, boolean arg5, boolean arg6) {
        Intrinsics.checkNotNullParameter(arg1, "statusBarStyle");
        Intrinsics.checkNotNullParameter(arg2, "navigationBarStyle");
        Intrinsics.checkNotNullParameter(arg3, "window");
        Intrinsics.checkNotNullParameter(arg4, "view");
        WindowCompat.setDecorFitsSystemWindows(arg3, false);
        arg3.setStatusBarColor(arg1.getScrim$activity(arg5));
        arg3.setNavigationBarColor(arg2.getScrim$activity(arg6));
        WindowInsetsControllerCompat v0 = new WindowInsetsControllerCompat(arg3, arg4);
        v0.setAppearanceLightStatusBars((((int)arg5)) ^ 1);
        v0.setAppearanceLightNavigationBars((((int)arg6)) ^ 1);
    }
}

