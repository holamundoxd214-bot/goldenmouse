package androidx.lifecycle;

import android.app.Activity;
import android.app.Application$ActivityLifecycleCallbacks;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\f\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\r\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0018\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\tH\u0016J\u0010\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016¨\u0006\u0011"}, d2={"Landroidx/lifecycle/EmptyActivityLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "outState", "onActivityDestroyed", "lifecycle-process"}, k=1, mv={2, 1, 0}, xi=0x30) public class EmptyActivityLifecycleCallbacks implements Application$ActivityLifecycleCallbacks {
    public EmptyActivityLifecycleCallbacks() {
        super();
    }

    public void onActivityCreated(Activity arg1, Bundle arg2) {
        Intrinsics.checkNotNullParameter(arg1, "activity");
    }

    public void onActivityDestroyed(Activity arg1) {
        Intrinsics.checkNotNullParameter(arg1, "activity");
    }

    public void onActivityPaused(Activity arg1) {
        Intrinsics.checkNotNullParameter(arg1, "activity");
    }

    public void onActivityResumed(Activity arg1) {
        Intrinsics.checkNotNullParameter(arg1, "activity");
    }

    public void onActivitySaveInstanceState(Activity arg1, Bundle arg2) {
        Intrinsics.checkNotNullParameter(arg1, "activity");
        Intrinsics.checkNotNullParameter(arg2, "outState");
    }

    public void onActivityStarted(Activity arg1) {
        Intrinsics.checkNotNullParameter(arg1, "activity");
    }

    public void onActivityStopped(Activity arg1) {
        Intrinsics.checkNotNullParameter(arg1, "activity");
    }
}

