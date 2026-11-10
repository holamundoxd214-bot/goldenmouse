package androidx.savedstate.compose.serialization.serializers;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001E\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0016\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0015\u001A\u00020\u0016H\u0016R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\t\u001A\u00020\nX\u0096\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u0017"}, d2={"Landroidx/savedstate/compose/serialization/serializers/SnapshotStateListSerializer;", "T", "Lkotlinx/serialization/KSerializer;", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "elementSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "base", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "()V", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "savedstate-compose"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SnapshotStateListSerializer implements KSerializer {
    private final KSerializer base;
    private final SerialDescriptor descriptor;
    private final KSerializer elementSerializer;

    public SnapshotStateListSerializer(KSerializer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elementSerializer");
        super();
        this.elementSerializer = arg2;
        arg2 = BuiltinSerializersKt.ListSerializer(arg2);
        this.base = arg2;
        this.descriptor = SerialDescriptorsKt.SerialDescriptor("androidx.compose.runtime.SnapshotStateList", arg2.getDescriptor());
    }

    public SnapshotStateList deserialize(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        Object v1 = arg2.decodeSerializableValue(this.base);
        SnapshotStateList v2 = new SnapshotStateList();
        v2.addAll(CollectionsKt.toList(((Iterable)v1)));
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

    public void serialize(Encoder arg2, SnapshotStateList arg3) {
        Intrinsics.checkNotNullParameter(arg2, "encoder");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg2.encodeSerializableValue(this.base, arg3);
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize(arg1, ((SnapshotStateList)arg2));
    }
}

