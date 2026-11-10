package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function1;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

public final class PairSerializer$$ExternalSyntheticLambda0 implements Function1 {
    public PairSerializer$$ExternalSyntheticLambda0(KSerializer arg1, KSerializer arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return PairSerializer.descriptor$lambda$0(this.f$0, this.f$1, ((ClassSerialDescriptorBuilder)arg2));
    }
}

