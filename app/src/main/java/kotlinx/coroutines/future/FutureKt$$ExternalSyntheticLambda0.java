package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Deferred;

public final class FutureKt$$ExternalSyntheticLambda0 implements Function1 {
    public FutureKt$$ExternalSyntheticLambda0(CompletableFuture arg1, Deferred arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return FutureKt.asCompletableFuture$lambda$1(this.f$0, this.f$1, ((Throwable)arg2));
    }
}

