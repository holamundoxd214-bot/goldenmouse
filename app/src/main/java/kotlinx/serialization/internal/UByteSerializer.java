package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0010\u001A\u00020\u00022\u0006\u0010\u0011\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2={"Lkotlinx/serialization/internal/UByteSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/UByte;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize-EK-6454", "(Lkotlinx/serialization/encoding/Encoder;B)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserialize-Wa3L5BU", "(Lkotlinx/serialization/encoding/Decoder;)B", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class UByteSerializer implements KSerializer {
    public static final UByteSerializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        UByteSerializer.INSTANCE = new UByteSerializer();
        UByteSerializer.descriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlin.UByte", BuiltinSerializersKt.serializer(ByteCompanionObject.INSTANCE));
    }

    private UByteSerializer() {
        super();
    }

    public Object deserialize(Decoder arg1) {
        return UByte.box-impl(this.deserialize-Wa3L5BU(arg1));
    }

    public byte deserialize-Wa3L5BU(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        return UByte.constructor-impl(arg2.decodeInline(this.getDescriptor()).decodeByte());
    }

    public SerialDescriptor getDescriptor() {
        return UByteSerializer.descriptor;
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize-EK-6454(arg1, ((UByte)arg2).unbox-impl());
    }

    public void serialize-EK-6454(Encoder arg2, byte arg3) {
        Intrinsics.checkNotNullParameter(arg2, "encoder");
        arg2.encodeInline(this.getDescriptor()).encodeByte(arg3);
    }
}

