package androidx.savedstate.serialization.serializers;

import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001B\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00028\u0000¢\u0006\u0002\u0010\u000FJ\u0013\u0010\u0010\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00020\u0012¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u0014"}, d2={"Landroidx/savedstate/serialization/serializers/JavaSerializableSerializer;", "T", "Ljava/io/Serializable;", "Lkotlinx/serialization/KSerializer;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/io/Serializable;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/io/Serializable;", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class JavaSerializableSerializer implements KSerializer {
    private final SerialDescriptor descriptor;

    public JavaSerializableSerializer() {
        super();
        this.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor$default("java.io.Serializable", new SerialDescriptor[0], null, 4, null);
    }

    public final Serializable deserialize(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        if((arg2 instanceof SavedStateDecoder)) {
            Serializable v1 = SavedStateReader.getJavaSerializable-impl(SavedStateReader.constructor-impl(((SavedStateDecoder)arg2).getSavedState$savedstate()), ((SavedStateDecoder)arg2).getKey$savedstate(), Reflection.getOrCreateKotlinClass(Serializable.class));
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type T of androidx.savedstate.serialization.serializers.JavaSerializableSerializer");
            return v1;
        }

        throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(this.descriptor.getSerialName(), arg2).toString());
    }

    public Object deserialize(Decoder arg1) {
        return this.deserialize(arg1);
    }

    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final void serialize(Encoder arg2, Serializable arg3) {
        Intrinsics.checkNotNullParameter(arg2, "encoder");
        Intrinsics.checkNotNullParameter(arg3, "value");
        if((arg2 instanceof SavedStateEncoder)) {
            SavedStateWriter.putJavaSerializable-impl(SavedStateWriter.constructor-impl(((SavedStateEncoder)arg2).getSavedState$savedstate()), ((SavedStateEncoder)arg2).getKey$savedstate(), arg3);
            return;
        }

        throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(this.descriptor.getSerialName(), arg2).toString());
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize(arg1, ((Serializable)arg2));
    }
}

