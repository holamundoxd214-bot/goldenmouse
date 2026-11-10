package androidx.activity;

import android.content.IntentSender$SendIntentException;

public final class ComponentActivity$activityResultRegistry$1$$ExternalSyntheticLambda1 implements Runnable {
    public ComponentActivity$activityResultRegistry$1$$ExternalSyntheticLambda1(ComponentActivity$activityResultRegistry$1 arg1, int arg2, IntentSender$SendIntentException arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void run() {
        ComponentActivity$activityResultRegistry$1.onLaunch$lambda$1(this.f$0, this.f$1, this.f$2);
    }
}

