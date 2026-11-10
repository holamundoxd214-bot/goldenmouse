package androidx.activity.compose;

import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001D\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u00002\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001A\u00020\fR\"\u0010\u0005\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, d2={"Landroidx/activity/compose/ActivityResultLauncherHolder;", "I", "", "<init>", "()V", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "launch", "", "input", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", "unregister", "activity-compose"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ActivityResultLauncherHolder {
    public static final int $stable = 8;
    private ActivityResultLauncher launcher;

    static {
    }

    public ActivityResultLauncherHolder() {
        super();
    }

    public final ActivityResultLauncher getLauncher() {
        return this.launcher;
    }

    public final void launch(Object arg1, ActivityOptionsCompat arg2) {
        ActivityResultLauncher v0 = this.launcher;
        if(v0 != null) {
            v0.launch(arg1, arg2);
            return;
        }

        throw new IllegalStateException("Launcher has not been initialized".toString());
    }

    public final void setLauncher(ActivityResultLauncher arg1) {
        this.launcher = arg1;
    }

    public final void unregister() {
        ActivityResultLauncher v1 = this.launcher;
        if(v1 != null) {
            v1.unregister();
            return;
        }

        throw new IllegalStateException("Launcher has not been initialized".toString());
    }
}

