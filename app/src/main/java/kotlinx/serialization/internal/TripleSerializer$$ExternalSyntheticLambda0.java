package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function1;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

public final class TripleSerializer$$ExternalSyntheticLambda0 implements Function1 {
    public TripleSerializer$$ExternalSyntheticLambda0(TripleSerializer arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return TripleSerializer.descriptor$lambda$0(this.f$0, ((ClassSerialDescriptorBuilder)arg1));
    }
}

