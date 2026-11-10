package kotlinx.serialization;

import kotlin.jvm.functions.Function1;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

public final class ContextualSerializer$$ExternalSyntheticLambda0 implements Function1 {
    public ContextualSerializer$$ExternalSyntheticLambda0(ContextualSerializer arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return ContextualSerializer.descriptor$lambda$0(this.f$0, ((ClassSerialDescriptorBuilder)arg1));
    }
}

