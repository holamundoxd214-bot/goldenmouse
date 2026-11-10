package androidx.savedstate.compose.serialization.serializers;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001E\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0016\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0013\u001A\u00020\u0014H\u0016R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0007\u001A\u00020\bX\u0096\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\f¨\u0006\u0015"}, d2={"Landroidx/savedstate/compose/serialization/serializers/MutableStateSerializer;", "T", "Lkotlinx/serialization/KSerializer;", "Landroidx/compose/runtime/MutableState;", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "()V", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "savedstate-compose"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MutableStateSerializer implements KSerializer {
    private final SerialDescriptor descriptor;
    private final KSerializer valueSerializer;

    public MutableStateSerializer(KSerializer arg3) {
        Intrinsics.checkNotNullParameter(arg3, "valueSerializer");
        super();
        this.valueSerializer = arg3;
        SerialKind v3 = this.valueSerializer.getDescriptor().getKind();
        String v1 = "androidx.compose.runtime.MutableState";
        SerialDescriptor v3_1 = (v3 instanceof PrimitiveKind) ? SerialDescriptorsKt.PrimitiveSerialDescriptor(v1, ((PrimitiveKind)v3)) : SerialDescriptorsKt.SerialDescriptor(v1, this.valueSerializer.getDescriptor());
        this.descriptor = v3_1;
    }

    public MutableState deserialize(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        return SnapshotStateKt.mutableStateOf$default(arg2.decodeSerializableValue(this.valueSerializer), null, 2, null);
    }

    public Object deserialize(Decoder arg1) {
        return this.deserialize(arg1);
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public static void getDescriptor$annotations() {
    }

    public void serialize(Encoder arg2, MutableState arg3) {
        Intrinsics.checkNotNullParameter(arg2, "encoder");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg2.encodeSerializableValue(this.valueSerializer, arg3.getValue());
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize(arg1, ((MutableState)arg2));
    }
}

