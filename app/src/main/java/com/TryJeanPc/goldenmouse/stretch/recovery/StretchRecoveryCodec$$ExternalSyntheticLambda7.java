package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.io.DataOutputStream;
import kotlin.jvm.functions.Function1;

public final class StretchRecoveryCodec$$ExternalSyntheticLambda7 implements Function1 {
    public StretchRecoveryCodec$$ExternalSyntheticLambda7(StretchRecoverySnapshot arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return StretchRecoveryCodec.snapshotDigest$lambda$2(this.f$0, ((DataOutputStream)arg1));
    }
}

