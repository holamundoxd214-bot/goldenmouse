package com.google.android.material.motion;

import android.window.OnBackInvokedCallback;

public final class MaterialBackOrchestrator$Api33BackCallbackDelegate$$ExternalSyntheticLambda0 implements OnBackInvokedCallback {
    public MaterialBackOrchestrator$Api33BackCallbackDelegate$$ExternalSyntheticLambda0(MaterialBackHandler arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onBackInvoked() {
        this.f$0.handleBackInvoked();
    }
}

