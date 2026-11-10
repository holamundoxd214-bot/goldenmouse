package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.Parcel;
import kotlin.jvm.functions.Function1;

public final class StretchApplyEndpoint$onTransact$3$$ExternalSyntheticLambda0 implements Function1 {
    public StretchApplyEndpoint$onTransact$3$$ExternalSyntheticLambda0(long arg1, StretchCandidateRecord arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg3;
    }

    public final Object invoke(Object arg3) {
        return StretchApplyEndpoint$onTransact$3.commit$lambda$1(this.f$0, this.f$1, ((Parcel)arg3));
    }
}

