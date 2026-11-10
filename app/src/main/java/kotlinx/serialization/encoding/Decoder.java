package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001A\u00020\u0007H\'J\n\u0010\b\u001A\u0004\u0018\u00010\tH\'J\b\u0010\n\u001A\u00020\u0007H&J\b\u0010\u000B\u001A\u00020\fH&J\b\u0010\r\u001A\u00020\u000EH&J\b\u0010\u000F\u001A\u00020\u0010H&J\b\u0010\u0011\u001A\u00020\u0012H&J\b\u0010\u0013\u001A\u00020\u0014H&J\b\u0010\u0015\u001A\u00020\u0016H&J\b\u0010\u0017\u001A\u00020\u0018H&J\b\u0010\u0019\u001A\u00020\u001AH&J\u0010\u0010\u001B\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u00020\u001DH&J\u0010\u0010\u001E\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u001DH&J\u0010\u0010 \u001A\u00020!2\u0006\u0010\u001F\u001A\u00020\u001DH&J\'\u0010\"\u001A\u0002H#\"\n\b\u0000\u0010#*\u0004\u0018\u00010\u00012\f\u0010$\u001A\b\u0012\u0004\u0012\u0002H#0%H\u0016¢\u0006\u0002\u0010&J)\u0010\'\u001A\u0004\u0018\u0001H#\"\b\b\u0000\u0010#*\u00020\u00012\u000E\u0010$\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001H#0%H\u0017¢\u0006\u0002\u0010&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006("}, d2={"Lkotlinx/serialization/encoding/Decoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeNotNullMark", "", "decodeNull", "", "decodeBoolean", "decodeByte", "", "decodeShort", "", "decodeChar", "", "decodeInt", "", "decodeLong", "", "decodeFloat", "", "decodeDouble", "", "decodeString", "", "decodeEnum", "enumDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeInline", "descriptor", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeNullableSerializableValue", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Decoder {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @ExperimentalSerializationApi public static Object decodeNullableSerializableValue(Decoder arg1, DeserializationStrategy arg2) {
            Intrinsics.checkNotNullParameter(arg2, "deserializer");
            if(!arg2.getDescriptor().isNullable()) {
                if(arg1.decodeNotNullMark()) {
                }
                else {
                    return arg1.decodeNull();
                }
            }

            return arg1.decodeSerializableValue(arg2);
        }

        public static Object decodeSerializableValue(Decoder arg1, DeserializationStrategy arg2) {
            Intrinsics.checkNotNullParameter(arg2, "deserializer");
            return arg2.deserialize(arg1);
        }
    }

    CompositeDecoder beginStructure(SerialDescriptor arg1);

    boolean decodeBoolean();

    byte decodeByte();

    char decodeChar();

    double decodeDouble();

    int decodeEnum(SerialDescriptor arg1);

    float decodeFloat();

    Decoder decodeInline(SerialDescriptor arg1);

    int decodeInt();

    long decodeLong();

    @ExperimentalSerializationApi boolean decodeNotNullMark();

    @ExperimentalSerializationApi Void decodeNull();

    @ExperimentalSerializationApi Object decodeNullableSerializableValue(DeserializationStrategy arg1);

    Object decodeSerializableValue(DeserializationStrategy arg1);

    short decodeShort();

    String decodeString();

    SerializersModule getSerializersModule();
}

