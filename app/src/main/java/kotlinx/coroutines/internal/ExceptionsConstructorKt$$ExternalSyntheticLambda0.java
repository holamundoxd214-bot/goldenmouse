package kotlinx.coroutines.internal;

import kotlin.jvm.functions.Function1;

public final class ExceptionsConstructorKt$$ExternalSyntheticLambda0 implements Function1 {
    public ExceptionsConstructorKt$$ExternalSyntheticLambda0(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return ExceptionsConstructorKt.safeCtor$lambda$9(this.f$0, ((Throwable)arg1));
    }
}

