package kotlinx.serialization;

import kotlin.jvm.functions.Function1;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

public final class SealedClassSerializer$$ExternalSyntheticLambda1 implements Function1 {
    public SealedClassSerializer$$ExternalSyntheticLambda1(SealedClassSerializer arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return SealedClassSerializer.descriptor_delegate$lambda$3$lambda$2(this.f$0, ((ClassSerialDescriptorBuilder)arg1));
    }
}

