package com.TryJeanPc.goldenmouse.aim;

import java.util.LinkedList;
import java.util.function.Consumer;

public final class AimTouchDispatcher$$ExternalSyntheticLambda0 implements Consumer {
    public AimTouchDispatcher$$ExternalSyntheticLambda0(AimTouchDispatcher arg1, long arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void accept(Object arg4) {
        AimTouchDispatcher.offerDelta$lambda$14$lambda$13(this.f$0, this.f$1, ((LinkedList)arg4));
    }
}

