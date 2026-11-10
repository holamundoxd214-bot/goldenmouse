package kotlinx.serialization;

import kotlin.jvm.functions.Function1;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

public final class PolymorphicSerializer$$ExternalSyntheticLambda0 implements Function1 {
    public PolymorphicSerializer$$ExternalSyntheticLambda0(PolymorphicSerializer arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return PolymorphicSerializer.descriptor_delegate$lambda$1$lambda$0(this.f$0, ((ClassSerialDescriptorBuilder)arg1));
    }
}

