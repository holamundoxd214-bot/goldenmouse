package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import kotlin.jvm.functions.Function1;

public final class ExceptionsConstructorKt$$ExternalSyntheticLambda2 implements Function1 {
    public ExceptionsConstructorKt$$ExternalSyntheticLambda2(Constructor arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$3(this.f$0, ((Throwable)arg1));
    }
}

