package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001A\u00020\u0007H\u0017J\b\u0010\b\u001A\u00020\u0007H\'J\u0010\u0010\t\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u000BH&J\u0010\u0010\f\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\rH&J\u0010\u0010\u000E\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u000FH&J\u0010\u0010\u0010\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0011H&J\u0010\u0010\u0012\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0013H&J\u0010\u0010\u0014\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0015H&J\u0010\u0010\u0016\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0017H&J\u0010\u0010\u0018\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0019H&J\u0010\u0010\u001A\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u001BH&J\u0018\u0010\u001C\u001A\u00020\u00072\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u0013H&J\u0010\u0010 \u001A\u00020\u00002\u0006\u0010!\u001A\u00020\u001EH&J\u0010\u0010\"\u001A\u00020#2\u0006\u0010!\u001A\u00020\u001EH&J\u0018\u0010$\u001A\u00020#2\u0006\u0010!\u001A\u00020\u001E2\u0006\u0010%\u001A\u00020\u0013H\u0016J/\u0010&\u001A\u00020\u0007\"\n\b\u0000\u0010\'*\u0004\u0018\u00010\u00012\f\u0010(\u001A\b\u0012\u0004\u0012\u0002H\'0)2\u0006\u0010\n\u001A\u0002H\'H\u0016¢\u0006\u0002\u0010*J/\u0010+\u001A\u00020\u0007\"\b\b\u0000\u0010\'*\u00020\u00012\f\u0010(\u001A\b\u0012\u0004\u0012\u0002H\'0)2\b\u0010\n\u001A\u0004\u0018\u0001H\'H\u0017¢\u0006\u0002\u0010*R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006,"}, d2={"Lkotlinx/serialization/encoding/Encoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "encodeNotNullMark", "", "encodeNull", "encodeBoolean", "value", "", "encodeByte", "", "encodeShort", "", "encodeChar", "", "encodeInt", "", "encodeLong", "", "encodeFloat", "", "encodeDouble", "", "encodeString", "", "encodeEnum", "enumDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "encodeInline", "descriptor", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "beginCollection", "collectionSize", "encodeSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableValue", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Encoder {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static CompositeEncoder beginCollection(Encoder arg0, SerialDescriptor arg1, int arg2) {
            Intrinsics.checkNotNullParameter(arg1, "descriptor");
            return arg0.beginStructure(arg1);
        }

        @ExperimentalSerializationApi public static void encodeNotNullMark(Encoder arg0) {
        }

        @ExperimentalSerializationApi public static void encodeNullableSerializableValue(Encoder arg1, SerializationStrategy arg2, Object arg3) {
            Intrinsics.checkNotNullParameter(arg2, "serializer");
            if(arg2.getDescriptor().isNullable()) {
                arg1.encodeSerializableValue(arg2, arg3);
                return;
            }

            if(arg3 == null) {
                arg1.encodeNull();
                return;
            }

            arg1.encodeNotNullMark();
            arg1.encodeSerializableValue(arg2, arg3);
        }

        public static void encodeSerializableValue(Encoder arg1, SerializationStrategy arg2, Object arg3) {
            Intrinsics.checkNotNullParameter(arg2, "serializer");
            arg2.serialize(arg1, arg3);
        }
    }

    CompositeEncoder beginCollection(SerialDescriptor arg1, int arg2);

    CompositeEncoder beginStructure(SerialDescriptor arg1);

    void encodeBoolean(boolean arg1);

    void encodeByte(byte arg1);

    void encodeChar(char arg1);

    void encodeDouble(double arg1);

    void encodeEnum(SerialDescriptor arg1, int arg2);

    void encodeFloat(float arg1);

    Encoder encodeInline(SerialDescriptor arg1);

    void encodeInt(int arg1);

    void encodeLong(long arg1);

    @ExperimentalSerializationApi void encodeNotNullMark();

    @ExperimentalSerializationApi void encodeNull();

    @ExperimentalSerializationApi void encodeNullableSerializableValue(SerializationStrategy arg1, Object arg2);

    void encodeSerializableValue(SerializationStrategy arg1, Object arg2);

    void encodeShort(short arg1);

    void encodeString(String arg1);

    SerializersModule getSerializersModule();
}

