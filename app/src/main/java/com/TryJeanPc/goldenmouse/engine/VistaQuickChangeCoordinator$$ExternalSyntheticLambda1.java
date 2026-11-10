package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.aim.AimModeTransition$Result;

public final class VistaQuickChangeCoordinator$$ExternalSyntheticLambda1 implements Runnable {
    public VistaQuickChangeCoordinator$$ExternalSyntheticLambda1(VistaQuickChangeCoordinator arg1, Sequence arg2, Result arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void run() {
        VistaQuickChangeCoordinator.restoreAfterInterval$lambda$12$lambda$11$lambda$10(this.f$0, this.f$1, this.f$2);
    }
}

