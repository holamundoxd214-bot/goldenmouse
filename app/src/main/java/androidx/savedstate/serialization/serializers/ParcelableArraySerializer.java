package androidx.savedstate.serialization.serializers;

import android.os.Parcelable;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\u000FJ\u001B\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0011\u001A\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u0014"}, d2={"Landroidx/savedstate/serialization/serializers/ParcelableArraySerializer;", "Lkotlinx/serialization/KSerializer;", "", "Landroid/os/Parcelable;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;[Landroid/os/Parcelable;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)[Landroid/os/Parcelable;", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ParcelableArraySerializer implements KSerializer {
    public static final ParcelableArraySerializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ParcelableArraySerializer.INSTANCE = new ParcelableArraySerializer();
        ParcelableArraySerializer.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor$default("kotlin.Array<android.os.Parcelable>", new SerialDescriptor[0], null, 4, null);
    }

    private ParcelableArraySerializer() {
        super();
    }

    public Parcelable[] deserialize(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        if((arg2 instanceof SavedStateDecoder)) {
            return SavedStateReader.getParcelableArray-impl(SavedStateReader.constructor-impl(((SavedStateDecoder)arg2).getSavedState$savedstate()), ((SavedStateDecoder)arg2).getKey$savedstate(), Reflection.getOrCreateKotlinClass(Parcelable.class));
        }

        throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(ParcelableArraySerializer.INSTANCE.getDescriptor().getSerialName(), arg2).toString());
    }

    public Object deserialize(Decoder arg1) {
        return this.deserialize(arg1);
    }

    public SerialDescriptor getDescriptor() {
        return ParcelableArraySerializer.descriptor;
    }

    public void serialize(Encoder arg1, Parcelable[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "encoder");
        Intrinsics.checkNotNullParameter(arg2, "value");
        if((arg1 instanceof SavedStateEncoder)) {
            SavedStateWriter.putParcelableArray-impl(SavedStateWriter.constructor-impl(((SavedStateEncoder)arg1).getSavedState$savedstate()), ((SavedStateEncoder)arg1).getKey$savedstate(), arg2);
            return;
        }

        throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(ParcelableArraySerializer.INSTANCE.getDescriptor().getSerialName(), arg1).toString());
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize(arg1, ((Parcelable[])arg2));
    }
}

