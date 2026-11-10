package com.TryJeanPc.goldenmouse.stretch.physical;

import java.util.concurrent.CompletableFuture;
import kotlin.jvm.functions.Function0;

public final class StretchPreparationDeadlineKt$$ExternalSyntheticLambda0 implements Runnable {
    public StretchPreparationDeadlineKt$$ExternalSyntheticLambda0(CompletableFuture arg1, Function0 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        StretchPreparationDeadlineKt.stretchPreparationDeadline$lambda$0(this.f$0, this.f$1);
    }
}

