package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.input.InputEvent;

public final class InputSessionManager$$ExternalSyntheticLambda8 implements Runnable {
    public InputSessionManager$$ExternalSyntheticLambda8(Event arg1, InputSessionManager arg2, InputEvent arg3, PhysicalInput arg4, long arg5, boolean arg7) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg7;
    }

    public final void run() {
        InputSessionManager.submit$lambda$26$lambda$25(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}

