package com.google.android.material.navigation;

import com.google.android.material.motion.MaterialBackOrchestrator;

public final class NavigationView$1$$ExternalSyntheticLambda0 implements Runnable {
    public NavigationView$1$$ExternalSyntheticLambda0(MaterialBackOrchestrator arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void run() {
        this.f$0.startListeningForBackCallbacksWithPriorityOverlay();
    }
}

