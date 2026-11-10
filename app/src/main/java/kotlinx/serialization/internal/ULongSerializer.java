package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0010\u001A\u00020\u00022\u0006\u0010\u0011\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2={"Lkotlinx/serialization/internal/ULongSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/ULong;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize-2TYgG_w", "(Lkotlinx/serialization/encoding/Encoder;J)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserialize-I7RO_PI", "(Lkotlinx/serialization/encoding/Decoder;)J", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ULongSerializer implements KSerializer {
    public static final ULongSerializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ULongSerializer.INSTANCE = new ULongSerializer();
        ULongSerializer.descriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlin.ULong", BuiltinSerializersKt.serializer(LongCompanionObject.INSTANCE));
    }

    private ULongSerializer() {
        super();
    }

    public Object deserialize(Decoder arg1) {
        return ULong.box-impl(this.deserialize-I7RO_PI(arg1));
    }

    public long deserialize-I7RO_PI(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        return ULong.constructor-impl(arg2.decodeInline(this.getDescriptor()).decodeLong());
    }

    public SerialDescriptor getDescriptor() {
        return ULongSerializer.descriptor;
    }

    public void serialize(Encoder arg3, Object arg4) {
        this.serialize-2TYgG_w(arg3, ((ULong)arg4).unbox-impl());
    }

    public void serialize-2TYgG_w(Encoder arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg2, "encoder");
        arg2.encodeInline(this.getDescriptor()).encodeLong(arg3);
    }
}

