package kotlinx.coroutines.future;

import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;

public final class FutureKt$$ExternalSyntheticLambda1 implements Function2 {
    public FutureKt$$ExternalSyntheticLambda1(CompletableDeferred arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return FutureKt.asDeferred$lambda$5(this.f$0, arg1, ((Throwable)arg2));
    }
}

