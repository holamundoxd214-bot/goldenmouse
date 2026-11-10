package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.function.BiConsumer;
import kotlin.jvm.functions.Function2;

public final class StretchRecoverySupervisor$$ExternalSyntheticLambda13 implements BiConsumer {
    public StretchRecoverySupervisor$$ExternalSyntheticLambda13(Function2 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void accept(Object arg1, Object arg2) {
        StretchRecoverySupervisor.rollback$lambda$32$lambda$30(this.f$0, arg1, arg2);
    }
}

