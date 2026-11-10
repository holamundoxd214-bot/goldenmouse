package com.TryJeanPc.goldenmouse.notification;

import android.content.Context;
import com.TryJeanPc.goldenmouse.activation.ActivationManager$PairingResult;

public final class PairingCodeReceiver$onReceive$1$$ExternalSyntheticLambda0 implements Runnable {
    public PairingCodeReceiver$onReceive$1$$ExternalSyntheticLambda0(Context arg1, PairingResult arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        PairingCodeReceiver$onReceive$1.invokeSuspend$lambda$0(this.f$0, this.f$1);
    }
}

