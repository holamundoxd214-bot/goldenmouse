package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function0;
import kotlinx.serialization.DeserializationStrategy;

public final class TaggedDecoder$$ExternalSyntheticLambda1 implements Function0 {
    public TaggedDecoder$$ExternalSyntheticLambda1(TaggedDecoder arg1, DeserializationStrategy arg2, Object arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke() {
        return TaggedDecoder.decodeNullableSerializableElement$lambda$3(this.f$0, this.f$1, this.f$2);
    }
}

