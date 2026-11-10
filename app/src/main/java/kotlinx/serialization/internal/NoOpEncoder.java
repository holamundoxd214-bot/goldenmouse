package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

@Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\tH\u0016J\u0010\u0010\r\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000EH\u0016J\u0010\u0010\u000F\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0010H\u0016J\u0010\u0010\u0011\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0012H\u0016J\u0010\u0010\u0013\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0014H\u0016J\u0010\u0010\u0015\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0016H\u0016J\u0010\u0010\u0017\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0018H\u0016J\u0010\u0010\u0019\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u001AH\u0016J\u0010\u0010\u001B\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u001CH\u0016J\u0010\u0010\u001D\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u001EH\u0016J\u0018\u0010\u001F\u001A\u00020\t2\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u0014H\u0016R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006#"}, d2={"Lkotlinx/serialization/internal/NoOpEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "<init>", "()V", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "encodeValue", "", "value", "", "encodeNull", "encodeBoolean", "", "encodeByte", "", "encodeShort", "", "encodeInt", "", "encodeLong", "", "encodeFloat", "", "encodeDouble", "", "encodeChar", "", "encodeString", "", "encodeEnum", "enumDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NoOpEncoder extends AbstractEncoder {
    public static final NoOpEncoder INSTANCE;
    private static final SerializersModule serializersModule;

    static {
        NoOpEncoder.INSTANCE = new NoOpEncoder();
        NoOpEncoder.serializersModule = SerializersModuleBuildersKt.EmptySerializersModule();
    }

    private NoOpEncoder() {
        super();
    }

    public void encodeBoolean(boolean arg1) {
    }

    public void encodeByte(byte arg1) {
    }

    public void encodeChar(char arg1) {
    }

    public void encodeDouble(double arg1) {
    }

    public void encodeEnum(SerialDescriptor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "enumDescriptor");
    }

    public void encodeFloat(float arg1) {
    }

    public void encodeInt(int arg1) {
    }

    public void encodeLong(long arg1) {
    }

    public void encodeNull() {
    }

    public void encodeShort(short arg1) {
    }

    public void encodeString(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "value");
    }

    public void encodeValue(Object arg1) {
        Intrinsics.checkNotNullParameter(arg1, "value");
    }

    public SerializersModule getSerializersModule() {
        return NoOpEncoder.serializersModule;
    }
}

