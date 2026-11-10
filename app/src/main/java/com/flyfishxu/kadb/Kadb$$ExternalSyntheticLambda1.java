package com.flyfishxu.kadb;

import kotlin.jvm.functions.Function1;

public final class Kadb$$ExternalSyntheticLambda1 implements Function1 {
    public Kadb$$ExternalSyntheticLambda1(Kadb arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Kadb.buildShellCommand$lambda$1(this.f$0, ((String)arg1));
    }
}

