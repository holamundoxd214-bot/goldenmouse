package kotlinx.coroutines.future;

import java.util.function.BiFunction;
import kotlin.jvm.functions.Function2;

public final class FutureKt$$ExternalSyntheticLambda4 implements BiFunction {
    public FutureKt$$ExternalSyntheticLambda4(Function2 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object apply(Object arg1, Object arg2) {
        return FutureKt.setupCancellation$lambda$3(this.f$0, arg1, ((Throwable)arg2));
    }
}

