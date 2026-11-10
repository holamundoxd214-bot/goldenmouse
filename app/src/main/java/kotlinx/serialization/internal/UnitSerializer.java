package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0007H\u0096\u0001J\u001E\u0010\b\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0002H\u0096\u0001¢\u0006\u0002\u0010\fR\u0012\u0010\r\u001A\u00020\u000EX\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2={"Lkotlinx/serialization/internal/UnitSerializer;", "Lkotlinx/serialization/KSerializer;", "", "<init>", "()V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Lkotlin/Unit;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class UnitSerializer implements KSerializer {
    public static final UnitSerializer INSTANCE;

    static {
        UnitSerializer.INSTANCE = new UnitSerializer();
    }

    private UnitSerializer() {
        super();
        this.$$delegate_0 = new ObjectSerializer("kotlin.Unit", Unit.INSTANCE);
    }

    public Object deserialize(Decoder arg1) {
        this.deserialize(arg1);
        return Unit.INSTANCE;
    }

    public void deserialize(Decoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "decoder");
        this.$$delegate_0.deserialize(arg2);
    }

    public SerialDescriptor getDescriptor() {
        return this.$$delegate_0.getDescriptor();
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize(arg1, ((Unit)arg2));
    }

    public void serialize(Encoder arg2, Unit arg3) {
        Intrinsics.checkNotNullParameter(arg2, "encoder");
        Intrinsics.checkNotNullParameter(arg3, "value");
        this.$$delegate_0.serialize(arg2, arg3);
    }
}

