package kotlinx.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlinx.serialization.internal.InternalHexConverter;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\u001A\"\u0010\u0000\u001A\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001A\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u0005\u001A\"\u0010\u0006\u001A\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0001H\u0086\b¢\u0006\u0002\u0010\b\u001A+\u0010\t\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\u0004\u001A\u0002H\u0002¢\u0006\u0002\u0010\r\u001A+\u0010\u000E\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\n2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0001¢\u0006\u0002\u0010\u0012\u001A\"\u0010\t\u001A\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0004\u001A\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u0013\u001A\"\u0010\u000E\u001A\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0011\u001A\u00020\u0001H\u0086\b¢\u0006\u0002\u0010\u0014\u001A\"\u0010\u0015\u001A\u00020\u0016\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0004\u001A\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u0017\u001A\"\u0010\u0018\u001A\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0019\u001A\u00020\u0016H\u0086\b¢\u0006\u0002\u0010\u001A¨\u0006\u001B"}, d2={"encodeToString", "", "T", "Lkotlinx/serialization/StringFormat;", "value", "(Lkotlinx/serialization/StringFormat;Ljava/lang/Object;)Ljava/lang/String;", "decodeFromString", "string", "(Lkotlinx/serialization/StringFormat;Ljava/lang/String;)Ljava/lang/Object;", "encodeToHexString", "Lkotlinx/serialization/BinaryFormat;", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/BinaryFormat;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "decodeFromHexString", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "hex", "(Lkotlinx/serialization/BinaryFormat;Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/String;)Ljava/lang/Object;", "encodeToByteArray", "", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/Object;)[B", "decodeFromByteArray", "bytes", "(Lkotlinx/serialization/BinaryFormat;[B)Ljava/lang/Object;", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SerialFormatKt {
    public static final Object decodeFromByteArray(BinaryFormat arg3, byte[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "bytes");
        SerializersModule v0 = arg3.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return arg3.decodeFromByteArray(SerializersKt.serializer(v0, null), arg4);
    }

    public static final Object decodeFromHexString(BinaryFormat arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "hex");
        SerializersModule v0 = arg3.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SerialFormatKt.decodeFromHexString(arg3, SerializersKt.serializer(v0, null), arg4);
    }

    public static final Object decodeFromHexString(BinaryFormat arg1, DeserializationStrategy arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "deserializer");
        Intrinsics.checkNotNullParameter(arg3, "hex");
        return arg1.decodeFromByteArray(arg2, InternalHexConverter.INSTANCE.parseHexBinary(arg3));
    }

    public static final Object decodeFromString(StringFormat arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "string");
        SerializersModule v0 = arg3.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return arg3.decodeFromString(SerializersKt.serializer(v0, null), arg4);
    }

    public static final byte[] encodeToByteArray(BinaryFormat arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        SerializersModule v0 = arg3.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return arg3.encodeToByteArray(SerializersKt.serializer(v0, null), arg4);
    }

    public static final String encodeToHexString(BinaryFormat arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        SerializersModule v0 = arg3.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SerialFormatKt.encodeToHexString(arg3, SerializersKt.serializer(v0, null), arg4);
    }

    public static final String encodeToHexString(BinaryFormat arg1, SerializationStrategy arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "serializer");
        return InternalHexConverter.INSTANCE.printHexBinary(arg1.encodeToByteArray(arg2, arg3), true);
    }

    public static final String encodeToString(StringFormat arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        SerializersModule v0 = arg3.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return arg3.encodeToString(SerializersKt.serializer(v0, null), arg4);
    }
}

