package kotlin.jvm.internal;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KTypeProjection;

public final class TypeReference$$ExternalSyntheticLambda0 implements Function1 {
    public TypeReference$$ExternalSyntheticLambda0(TypeReference arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return TypeReference.asString$lambda$0(this.f$0, ((KTypeProjection)arg1));
    }
}

