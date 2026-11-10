package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.io.DataOutputStream;
import kotlin.jvm.functions.Function1;

public final class StretchRecoveryCodec$$ExternalSyntheticLambda26 implements Function1 {
    public StretchRecoveryCodec$$ExternalSyntheticLambda26(byte[] arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return StretchRecoveryCodec.encode$lambda$5(this.f$0, ((DataOutputStream)arg1));
    }
}

