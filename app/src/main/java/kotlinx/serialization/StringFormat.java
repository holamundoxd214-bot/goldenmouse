package kotlinx.serialization;

import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\u0007\u001A\u0002H\u0004H&¢\u0006\u0002\u0010\bJ)\u0010\t\u001A\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00040\u000B2\u0006\u0010\f\u001A\u00020\u0003H&¢\u0006\u0002\u0010\r¨\u0006\u000E"}, d2={"Lkotlinx/serialization/StringFormat;", "Lkotlinx/serialization/SerialFormat;", "encodeToString", "", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "decodeFromString", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "string", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public interface StringFormat extends SerialFormat {
    Object decodeFromString(DeserializationStrategy arg1, String arg2);

    String encodeToString(SerializationStrategy arg1, Object arg2);
}

