package androidx.savedstate.compose.serialization.serializers;

import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B#\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0012\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\u001C\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0017\u001A\u00020\u0018H\u0016R \u0010\t\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000B\u001A\u00020\fX\u0096\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0019"}, d2={"Landroidx/savedstate/compose/serialization/serializers/SnapshotStateMapSerializer;", "K", "V", "Lkotlinx/serialization/KSerializer;", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "base", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "()V", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "savedstate-compose"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SnapshotStateMapSerializer implements KSerializer {
    private final KSerializer base;
    private final SerialDescriptor descriptor;

    public SnapshotStateMapSerializer(KSerializer arg2, KSerializer arg3) {
        Intrinsics.checkNotNullParameter(arg2, "keySerializer");
        Intrinsics.checkNotNullParameter(arg3, "valueSerializer");
        super();
        arg2 = BuiltinSerializersKt.MapSerializer(arg2, arg3);
        this.base = arg2;
        this.descriptor = SerialDescriptorsKt.SerialDescriptor("androidx.compose.runtime.SnapshotStateMap", arg2.getDescriptor());
    }

    public SnapshotStateMap deserialize(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        Object v1 = arg2.decodeSerializableValue(this.base);
        SnapshotStateMap v2 = new SnapshotStateMap();
        v2.putAll(((Map)v1));
        return v2;
    }

    public Object deserialize(Decoder arg1) {
        return this.deserialize(arg1);
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public static void getDescriptor$annotations() {
    }

    public void serialize(Encoder arg2, SnapshotStateMap arg3) {
        Intrinsics.checkNotNullParameter(arg2, "encoder");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg2.encodeSerializableValue(this.base, arg3);
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize(arg1, ((SnapshotStateMap)arg2));
    }
}

