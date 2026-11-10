package androidx.savedstate.serialization.serializers;

import android.util.SizeF;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0002H\u0016J\u0010\u0010\u000E\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u0010H\u0016R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2={"Landroidx/savedstate/serialization/serializers/SizeFSerializer;", "Lkotlinx/serialization/KSerializer;", "Landroid/util/SizeF;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SizeFSerializer implements KSerializer {
    public static final SizeFSerializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SizeFSerializer.INSTANCE = new SizeFSerializer();
        SizeFSerializer.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor$default("android.util.SizeF", new SerialDescriptor[0], null, 4, null);
    }

    private SizeFSerializer() {
        super();
    }

    public SizeF deserialize(Decoder arg1) {
        Intrinsics.checkNotNullParameter(arg1, "decoder");
        if((arg1 instanceof SavedStateDecoder)) {
            return SavedStateReader.getSizeF-impl(SavedStateReader.constructor-impl(((SavedStateDecoder)arg1).getSavedState$savedstate()), ((SavedStateDecoder)arg1).getKey$savedstate());
        }

        throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(SizeFSerializer.INSTANCE.getDescriptor().getSerialName(), arg1).toString());
    }

    public Object deserialize(Decoder arg1) {
        return this.deserialize(arg1);
    }

    public SerialDescriptor getDescriptor() {
        return SizeFSerializer.descriptor;
    }

    public void serialize(Encoder arg1, SizeF arg2) {
        Intrinsics.checkNotNullParameter(arg1, "encoder");
        Intrinsics.checkNotNullParameter(arg2, "value");
        if((arg1 instanceof SavedStateEncoder)) {
            SavedStateWriter.putSizeF-impl(SavedStateWriter.constructor-impl(((SavedStateEncoder)arg1).getSavedState$savedstate()), ((SavedStateEncoder)arg1).getKey$savedstate(), arg2);
            return;
        }

        throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(SizeFSerializer.INSTANCE.getDescriptor().getSerialName(), arg1).toString());
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize(arg1, ((SizeF)arg2));
    }
}

