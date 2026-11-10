package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0010\u001A\u00020\u00022\u0006\u0010\u0011\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2={"Lkotlinx/serialization/internal/UIntSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/UInt;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize-Qn1smSk", "(Lkotlinx/serialization/encoding/Encoder;I)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserialize-OGnWXxg", "(Lkotlinx/serialization/encoding/Decoder;)I", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class UIntSerializer implements KSerializer {
    public static final UIntSerializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        UIntSerializer.INSTANCE = new UIntSerializer();
        UIntSerializer.descriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlin.UInt", BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE));
    }

    private UIntSerializer() {
        super();
    }

    public Object deserialize(Decoder arg1) {
        return UInt.box-impl(this.deserialize-OGnWXxg(arg1));
    }

    public int deserialize-OGnWXxg(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        return UInt.constructor-impl(arg2.decodeInline(this.getDescriptor()).decodeInt());
    }

    public SerialDescriptor getDescriptor() {
        return UIntSerializer.descriptor;
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize-Qn1smSk(arg1, ((UInt)arg2).unbox-impl());
    }

    public void serialize-Qn1smSk(Encoder arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "encoder");
        arg2.encodeInline(this.getDescriptor()).encodeInt(arg3);
    }
}

