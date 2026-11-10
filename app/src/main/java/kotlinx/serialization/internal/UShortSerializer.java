package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0010\u001A\u00020\u00022\u0006\u0010\u0011\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2={"Lkotlinx/serialization/internal/UShortSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/UShort;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize-i8woANY", "(Lkotlinx/serialization/encoding/Encoder;S)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserialize-BwKQO78", "(Lkotlinx/serialization/encoding/Decoder;)S", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class UShortSerializer implements KSerializer {
    public static final UShortSerializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        UShortSerializer.INSTANCE = new UShortSerializer();
        UShortSerializer.descriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlin.UShort", BuiltinSerializersKt.serializer(ShortCompanionObject.INSTANCE));
    }

    private UShortSerializer() {
        super();
    }

    public Object deserialize(Decoder arg1) {
        return UShort.box-impl(this.deserialize-BwKQO78(arg1));
    }

    public short deserialize-BwKQO78(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        return UShort.constructor-impl(arg2.decodeInline(this.getDescriptor()).decodeShort());
    }

    public SerialDescriptor getDescriptor() {
        return UShortSerializer.descriptor;
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize-i8woANY(arg1, ((UShort)arg2).unbox-impl());
    }

    public void serialize-i8woANY(Encoder arg2, short arg3) {
        Intrinsics.checkNotNullParameter(arg2, "encoder");
        arg2.encodeInline(this.getDescriptor()).encodeShort(arg3);
    }
}

