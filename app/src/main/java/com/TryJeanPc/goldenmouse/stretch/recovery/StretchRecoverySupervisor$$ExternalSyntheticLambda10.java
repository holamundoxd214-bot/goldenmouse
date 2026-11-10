package com.TryJeanPc.goldenmouse.stretch.recovery;

public final class StretchRecoverySupervisor$$ExternalSyntheticLambda10 implements Runnable {
    public StretchRecoverySupervisor$$ExternalSyntheticLambda10(StretchRecoverySupervisor arg1, StretchRestoreRequest arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        StretchRecoverySupervisor.rollback$lambda$32(this.f$0, this.f$1);
    }
}

