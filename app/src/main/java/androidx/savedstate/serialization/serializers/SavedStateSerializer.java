package androidx.savedstate.serialization.serializers;

import android.os.Bundle;
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

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\n\u0010\u000E\u001A\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0002\u0010\u000FJ\u0019\u0010\u0010\u001A\u00060\u0002j\u0002`\u00032\u0006\u0010\u0011\u001A\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u0014"}, d2={"Landroidx/savedstate/serialization/serializers/SavedStateSerializer;", "Lkotlinx/serialization/KSerializer;", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Landroid/os/Bundle;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Landroid/os/Bundle;", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SavedStateSerializer implements KSerializer {
    public static final SavedStateSerializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SavedStateSerializer.INSTANCE = new SavedStateSerializer();
        SavedStateSerializer.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor$default("androidx.savedstate.SavedState", new SerialDescriptor[0], null, 4, null);
    }

    private SavedStateSerializer() {
        super();
    }

    public Bundle deserialize(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        if((arg2 instanceof SavedStateDecoder)) {
            if(Intrinsics.areEqual(((SavedStateDecoder)arg2).getKey$savedstate(), "")) {
                return ((SavedStateDecoder)arg2).getSavedState$savedstate();
            }

            return SavedStateReader.getSavedState-impl(SavedStateReader.constructor-impl(((SavedStateDecoder)arg2).getSavedState$savedstate()), ((SavedStateDecoder)arg2).getKey$savedstate());
        }

        throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(SavedStateSerializer.INSTANCE.getDescriptor().getSerialName(), arg2).toString());
    }

    public Object deserialize(Decoder arg1) {
        return this.deserialize(arg1);
    }

    public SerialDescriptor getDescriptor() {
        return SavedStateSerializer.descriptor;
    }

    public void serialize(Encoder arg2, Bundle arg3) {
        Intrinsics.checkNotNullParameter(arg2, "encoder");
        Intrinsics.checkNotNullParameter(arg3, "value");
        if((arg2 instanceof SavedStateEncoder)) {
            if(Intrinsics.areEqual(((SavedStateEncoder)arg2).getKey$savedstate(), "")) {
                SavedStateWriter.putAll-impl(SavedStateWriter.constructor-impl(((SavedStateEncoder)arg2).getSavedState$savedstate()), arg3);
                return;
            }

            SavedStateWriter.putSavedState-impl(SavedStateWriter.constructor-impl(((SavedStateEncoder)arg2).getSavedState$savedstate()), ((SavedStateEncoder)arg2).getKey$savedstate(), arg3);
            return;
        }

        throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(SavedStateSerializer.INSTANCE.getDescriptor().getSerialName(), arg2).toString());
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize(arg1, ((Bundle)arg2));
    }
}

