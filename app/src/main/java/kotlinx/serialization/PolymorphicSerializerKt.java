package kotlinx.serialization;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.AbstractPolymorphicSerializerKt;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A4\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0007\u001A7\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u0002H\u0002H\u0007¢\u0006\u0002\u0010\r¨\u0006\u000E"}, d2={"findPolymorphicSerializer", "Lkotlinx/serialization/DeserializationStrategy;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "klassName", "", "Lkotlinx/serialization/SerializationStrategy;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PolymorphicSerializerKt {
    @InternalSerializationApi public static final DeserializationStrategy findPolymorphicSerializer(AbstractPolymorphicSerializer arg1, CompositeDecoder arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        DeserializationStrategy v2 = arg1.findPolymorphicSerializerOrNull(arg2, arg3);
        if(v2 != null) {
            return v2;
        }

        AbstractPolymorphicSerializerKt.throwSubtypeNotRegistered(arg3, arg1.getBaseClass());
        throw new KotlinNothingValueException();
    }

    @InternalSerializationApi public static final SerializationStrategy findPolymorphicSerializer(AbstractPolymorphicSerializer arg1, Encoder arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "encoder");
        Intrinsics.checkNotNullParameter(arg3, "value");
        SerializationStrategy v2 = arg1.findPolymorphicSerializerOrNull(arg2, arg3);
        if(v2 != null) {
            return v2;
        }

        AbstractPolymorphicSerializerKt.throwSubtypeNotRegistered(Reflection.getOrCreateKotlinClass(arg3.getClass()), arg1.getBaseClass());
        throw new KotlinNothingValueException();
    }
}

