package androidx.activity;

import androidx.activity.result.contract.ActivityResultContract$SynchronousResult;

public final class ComponentActivity$activityResultRegistry$1$$ExternalSyntheticLambda0 implements Runnable {
    public ComponentActivity$activityResultRegistry$1$$ExternalSyntheticLambda0(ComponentActivity$activityResultRegistry$1 arg1, int arg2, SynchronousResult arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void run() {
        ComponentActivity$activityResultRegistry$1.onLaunch$lambda$0(this.f$0, this.f$1, this.f$2);
    }
}

