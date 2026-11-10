package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH&J\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\rH\u0017J \u0010\u000E\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u000BH&J \u0010\u0010\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0011H&J \u0010\u0012\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0013H&J \u0010\u0014\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0015H&J \u0010\u0016\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\rH&J \u0010\u0017\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0018H&J \u0010\u0019\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u001AH&J \u0010\u001B\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u001CH&J \u0010\u001D\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u001EH&J\u0018\u0010\u001F\u001A\u00020 2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\rH&J?\u0010!\u001A\u00020\u0007\"\n\b\u0000\u0010\"*\u0004\u0018\u00010\u00012\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\r2\f\u0010#\u001A\b\u0012\u0004\u0012\u0002H\"0$2\u0006\u0010\u000F\u001A\u0002H\"H&¢\u0006\u0002\u0010%J?\u0010&\u001A\u00020\u0007\"\b\b\u0000\u0010\"*\u00020\u00012\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\r2\f\u0010#\u001A\b\u0012\u0004\u0012\u0002H\"0$2\b\u0010\u000F\u001A\u0004\u0018\u0001H\"H\'¢\u0006\u0002\u0010%R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\'"}, d2={"Lkotlinx/serialization/encoding/CompositeEncoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "endStructure", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "shouldEncodeElementDefault", "", "index", "", "encodeBooleanElement", "value", "encodeByteElement", "", "encodeShortElement", "", "encodeCharElement", "", "encodeIntElement", "encodeLongElement", "", "encodeFloatElement", "", "encodeDoubleElement", "", "encodeStringElement", "", "encodeInlineElement", "Lkotlinx/serialization/encoding/Encoder;", "encodeSerializableElement", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableElement", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public interface CompositeEncoder {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @ExperimentalSerializationApi public static boolean shouldEncodeElementDefault(CompositeEncoder arg0, SerialDescriptor arg1, int arg2) {
            Intrinsics.checkNotNullParameter(arg1, "descriptor");
            return 1;
        }
    }

    void encodeBooleanElement(SerialDescriptor arg1, int arg2, boolean arg3);

    void encodeByteElement(SerialDescriptor arg1, int arg2, byte arg3);

    void encodeCharElement(SerialDescriptor arg1, int arg2, char arg3);

    void encodeDoubleElement(SerialDescriptor arg1, int arg2, double arg3);

    void encodeFloatElement(SerialDescriptor arg1, int arg2, float arg3);

    Encoder encodeInlineElement(SerialDescriptor arg1, int arg2);

    void encodeIntElement(SerialDescriptor arg1, int arg2, int arg3);

    void encodeLongElement(SerialDescriptor arg1, int arg2, long arg3);

    @ExperimentalSerializationApi void encodeNullableSerializableElement(SerialDescriptor arg1, int arg2, SerializationStrategy arg3, Object arg4);

    void encodeSerializableElement(SerialDescriptor arg1, int arg2, SerializationStrategy arg3, Object arg4);

    void encodeShortElement(SerialDescriptor arg1, int arg2, short arg3);

    void encodeStringElement(SerialDescriptor arg1, int arg2, String arg3);

    void endStructure(SerialDescriptor arg1);

    SerializersModule getSerializersModule();

    @ExperimentalSerializationApi boolean shouldEncodeElementDefault(SerialDescriptor arg1, int arg2);
}

