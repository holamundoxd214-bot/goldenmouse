package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.io.DataInputStream;
import kotlin.jvm.functions.Function1;

public final class StretchRecoveryCodec$$ExternalSyntheticLambda3 implements Function1 {
    public StretchRecoveryCodec$$ExternalSyntheticLambda3(StretchRecoverySnapshot arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return StretchRecoveryCodec.record$lambda$52(this.f$0, ((DataInputStream)arg1));
    }
}

