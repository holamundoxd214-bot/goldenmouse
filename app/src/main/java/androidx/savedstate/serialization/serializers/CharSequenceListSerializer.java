package androidx.savedstate.serialization.serializers;

import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001E\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0010\u001A\u00020\u0011H\u0016R\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u0012"}, d2={"Landroidx/savedstate/serialization/serializers/CharSequenceListSerializer;", "Lkotlinx/serialization/KSerializer;", "", "", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CharSequenceListSerializer implements KSerializer {
    public static final CharSequenceListSerializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CharSequenceListSerializer.INSTANCE = new CharSequenceListSerializer();
        CharSequenceListSerializer.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor$default("kotlin.collections.List<kotlin.CharSequence>", new SerialDescriptor[0], null, 4, null);
    }

    private CharSequenceListSerializer() {
        super();
    }

    public List deserialize(Decoder arg1) {
        Intrinsics.checkNotNullParameter(arg1, "decoder");
        if((arg1 instanceof SavedStateDecoder)) {
            return SavedStateReader.getCharSequenceList-impl(SavedStateReader.constructor-impl(((SavedStateDecoder)arg1).getSavedState$savedstate()), ((SavedStateDecoder)arg1).getKey$savedstate());
        }

        throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(CharSequenceListSerializer.INSTANCE.getDescriptor().getSerialName(), arg1).toString());
    }

    public Object deserialize(Decoder arg1) {
        return this.deserialize(arg1);
    }

    public SerialDescriptor getDescriptor() {
        return CharSequenceListSerializer.descriptor;
    }

    public void serialize(Encoder arg1, List arg2) {
        Intrinsics.checkNotNullParameter(arg1, "encoder");
        Intrinsics.checkNotNullParameter(arg2, "value");
        if((arg1 instanceof SavedStateEncoder)) {
            SavedStateWriter.putCharSequenceList-impl(SavedStateWriter.constructor-impl(((SavedStateEncoder)arg1).getSavedState$savedstate()), ((SavedStateEncoder)arg1).getKey$savedstate(), arg2);
            return;
        }

        throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(CharSequenceListSerializer.INSTANCE.getDescriptor().getSerialName(), arg1).toString());
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize(arg1, ((List)arg2));
    }
}

