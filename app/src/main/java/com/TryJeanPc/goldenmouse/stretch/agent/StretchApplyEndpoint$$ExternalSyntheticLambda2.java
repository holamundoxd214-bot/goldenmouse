package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.Parcel;
import kotlin.jvm.functions.Function1;

public final class StretchApplyEndpoint$$ExternalSyntheticLambda2 implements Function1 {
    public StretchApplyEndpoint$$ExternalSyntheticLambda2(StretchApplyEndpoint arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return StretchApplyEndpoint.onTransact$lambda$0(this.f$0, ((Parcel)arg1));
    }
}

