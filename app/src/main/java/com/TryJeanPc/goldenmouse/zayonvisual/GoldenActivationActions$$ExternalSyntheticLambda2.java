package com.TryJeanPc.goldenmouse.zayonvisual;

import androidx.activity.result.ActivityResultCallback;

public final class GoldenActivationActions$$ExternalSyntheticLambda2 implements ActivityResultCallback {
    public GoldenActivationActions$$ExternalSyntheticLambda2(GoldenActivationActions arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onActivityResult(Object arg1) {
        GoldenActivationActions.notificationPermission$lambda$1(this.f$0, ((Boolean)arg1).booleanValue());
    }
}

