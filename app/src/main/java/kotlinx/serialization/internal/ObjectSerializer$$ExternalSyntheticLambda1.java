package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function1;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

public final class ObjectSerializer$$ExternalSyntheticLambda1 implements Function1 {
    public ObjectSerializer$$ExternalSyntheticLambda1(ObjectSerializer arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return ObjectSerializer.descriptor_delegate$lambda$1$lambda$0(this.f$0, ((ClassSerialDescriptorBuilder)arg1));
    }
}

