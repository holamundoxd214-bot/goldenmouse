package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import kotlin.jvm.functions.Function1;

public final class FutureKt$$ExternalSyntheticLambda3 implements Function1 {
    public FutureKt$$ExternalSyntheticLambda3(CompletableFuture arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return FutureKt.asCompletableFuture$lambda$2(this.f$0, ((Throwable)arg1));
    }
}

