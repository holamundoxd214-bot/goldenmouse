package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 )2\u00020\u0001:\u0001)J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH&J\b\u0010\n\u001A\u00020\u000BH\u0017J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\tH&J\u0010\u0010\u000E\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\tH\u0016J\u0018\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\rH&J\u0018\u0010\u0011\u001A\u00020\u00122\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\rH&J\u0018\u0010\u0013\u001A\u00020\u00142\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\rH&J\u0018\u0010\u0015\u001A\u00020\u00162\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\rH&J\u0018\u0010\u0017\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\rH&J\u0018\u0010\u0018\u001A\u00020\u00192\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\rH&J\u0018\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\rH&J\u0018\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\rH&J\u0018\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\rH&J\u0018\u0010 \u001A\u00020!2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\rH&JC\u0010\"\u001A\u0002H#\"\n\b\u0000\u0010#*\u0004\u0018\u00010\u00012\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\r2\f\u0010$\u001A\b\u0012\u0004\u0012\u0002H#0%2\n\b\u0002\u0010&\u001A\u0004\u0018\u0001H#H&¢\u0006\u0002\u0010\'JE\u0010(\u001A\u0004\u0018\u0001H#\"\b\b\u0000\u0010#*\u00020\u00012\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\r2\u000E\u0010$\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001H#0%2\n\b\u0002\u0010&\u001A\u0004\u0018\u0001H#H\'¢\u0006\u0002\u0010\'R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006*"}, d2={"Lkotlinx/serialization/encoding/CompositeDecoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "endStructure", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeSequentially", "", "decodeElementIndex", "", "decodeCollectionSize", "decodeBooleanElement", "index", "decodeByteElement", "", "decodeCharElement", "", "decodeShortElement", "", "decodeIntElement", "decodeLongElement", "", "decodeFloatElement", "", "decodeDoubleElement", "", "decodeStringElement", "", "decodeInlineElement", "Lkotlinx/serialization/encoding/Decoder;", "decodeSerializableElement", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeNullableSerializableElement", "Companion", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public interface CompositeDecoder {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Lkotlinx/serialization/encoding/CompositeDecoder$Companion;", "", "<init>", "()V", "DECODE_DONE", "", "UNKNOWN_NAME", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public static final int DECODE_DONE = -1;
        public static final int UNKNOWN_NAME = -3;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static int decodeCollectionSize(CompositeDecoder arg0, SerialDescriptor arg1) {
            Intrinsics.checkNotNullParameter(arg1, "descriptor");
            return -1;
        }

        public static Object decodeNullableSerializableElement$default(CompositeDecoder arg0, SerialDescriptor arg1, int arg2, DeserializationStrategy arg3, Object arg4, int arg5, Object arg6) {
            if(arg6 == null) {
                if((arg5 & 8) != 0) {
                    arg4 = null;
                }

                return arg0.decodeNullableSerializableElement(arg1, arg2, arg3, arg4);
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeNullableSerializableElement");
        }

        @ExperimentalSerializationApi public static boolean decodeSequentially(CompositeDecoder arg0) {
            return 0;
        }

        public static Object decodeSerializableElement$default(CompositeDecoder arg0, SerialDescriptor arg1, int arg2, DeserializationStrategy arg3, Object arg4, int arg5, Object arg6) {
            if(arg6 == null) {
                if((arg5 & 8) != 0) {
                    arg4 = null;
                }

                return arg0.decodeSerializableElement(arg1, arg2, arg3, arg4);
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
        }
    }

    public static final Companion Companion = null;
    public static final int DECODE_DONE = -1;
    public static final int UNKNOWN_NAME = -3;

    static {
        CompositeDecoder.Companion = Companion.$$INSTANCE;
    }

    boolean decodeBooleanElement(SerialDescriptor arg1, int arg2);

    byte decodeByteElement(SerialDescriptor arg1, int arg2);

    char decodeCharElement(SerialDescriptor arg1, int arg2);

    int decodeCollectionSize(SerialDescriptor arg1);

    double decodeDoubleElement(SerialDescriptor arg1, int arg2);

    int decodeElementIndex(SerialDescriptor arg1);

    float decodeFloatElement(SerialDescriptor arg1, int arg2);

    Decoder decodeInlineElement(SerialDescriptor arg1, int arg2);

    int decodeIntElement(SerialDescriptor arg1, int arg2);

    long decodeLongElement(SerialDescriptor arg1, int arg2);

    @ExperimentalSerializationApi Object decodeNullableSerializableElement(SerialDescriptor arg1, int arg2, DeserializationStrategy arg3, Object arg4);

    @ExperimentalSerializationApi boolean decodeSequentially();

    Object decodeSerializableElement(SerialDescriptor arg1, int arg2, DeserializationStrategy arg3, Object arg4);

    short decodeShortElement(SerialDescriptor arg1, int arg2);

    String decodeStringElement(SerialDescriptor arg1, int arg2);

    void endStructure(SerialDescriptor arg1);

    SerializersModule getSerializersModule();
}

