package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind$BOOLEAN;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0002H\u0016J\u0015\u0010\u000E\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2={"Lkotlinx/serialization/internal/BooleanSerializer;", "Lkotlinx/serialization/KSerializer;", "", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Boolean;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BooleanSerializer implements KSerializer {
    public static final BooleanSerializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BooleanSerializer.INSTANCE = new BooleanSerializer();
        BooleanSerializer.descriptor = new PrimitiveSerialDescriptor("kotlin.Boolean", BOOLEAN.INSTANCE);
    }

    private BooleanSerializer() {
        super();
    }

    public Boolean deserialize(Decoder arg1) {
        Intrinsics.checkNotNullParameter(arg1, "decoder");
        return Boolean.valueOf(arg1.decodeBoolean());
    }

    public Object deserialize(Decoder arg1) {
        return this.deserialize(arg1);
    }

    public SerialDescriptor getDescriptor() {
        return BooleanSerializer.descriptor;
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize(arg1, ((Boolean)arg2).booleanValue());
    }

    public void serialize(Encoder arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "encoder");
        arg1.encodeBoolean(arg2);
    }
}

