package kotlin.text;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u001F\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001A3\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0004\b\n\u0010\u000B\u001A\u001D\u0010\f\u001A\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0002\u0010\r\u001A\u001F\u0010\u0000\u001A\u00020\u0001*\u00020\u000E2\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0004\b\u000F\u0010\u0010\u001A\u001D\u0010\u0011\u001A\u00020\u000E*\u00020\u00012\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0012\u001A\u001F\u0010\u0000\u001A\u00020\u0001*\u00020\u00132\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0004\b\u0014\u0010\u0015\u001A\u001D\u0010\u0016\u001A\u00020\u0013*\u00020\u00012\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0017\u001A\u001F\u0010\u0000\u001A\u00020\u0001*\u00020\u00182\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0004\b\u0019\u0010\u001A\u001A\u001D\u0010\u001B\u001A\u00020\u0018*\u00020\u00012\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0002\u0010\u001C\u001A\u001F\u0010\u0000\u001A\u00020\u0001*\u00020\u001D2\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0004\b\u001E\u0010\u001F\u001A\u001D\u0010 \u001A\u00020\u001D*\u00020\u00012\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0002\u0010!¨\u0006\""}, d2={"toHexString", "", "Lkotlin/UByteArray;", "format", "Lkotlin/text/HexFormat;", "toHexString-zHuV2wU", "([BLkotlin/text/HexFormat;)Ljava/lang/String;", "startIndex", "", "endIndex", "toHexString-lZCiFrA", "([BIILkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUByteArray", "(Ljava/lang/String;Lkotlin/text/HexFormat;)[B", "Lkotlin/UByte;", "toHexString-ZQbaR00", "(BLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUByte", "(Ljava/lang/String;Lkotlin/text/HexFormat;)B", "Lkotlin/UShort;", "toHexString-r3ox_E0", "(SLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUShort", "(Ljava/lang/String;Lkotlin/text/HexFormat;)S", "Lkotlin/UInt;", "toHexString-8M7LxHw", "(ILkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUInt", "(Ljava/lang/String;Lkotlin/text/HexFormat;)I", "Lkotlin/ULong;", "toHexString-8UJCm-I", "(JLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToULong", "(Ljava/lang/String;Lkotlin/text/HexFormat;)J", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class UHexExtensionsKt {
    private static final byte hexToUByte(String arg1, HexFormat arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "format");
        return UByte.constructor-impl(HexExtensionsKt.hexToByte(arg1, arg2));
    }

    static byte hexToUByte$default(String arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "format");
        return UByte.constructor-impl(HexExtensionsKt.hexToByte(arg0, arg1));
    }

    private static final byte[] hexToUByteArray(String arg1, HexFormat arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "format");
        return UByteArray.constructor-impl(HexExtensionsKt.hexToByteArray(arg1, arg2));
    }

    static byte[] hexToUByteArray$default(String arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "format");
        return UByteArray.constructor-impl(HexExtensionsKt.hexToByteArray(arg0, arg1));
    }

    private static final int hexToUInt(String arg1, HexFormat arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "format");
        return UInt.constructor-impl(HexExtensionsKt.hexToInt(arg1, arg2));
    }

    static int hexToUInt$default(String arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "format");
        return UInt.constructor-impl(HexExtensionsKt.hexToInt(arg0, arg1));
    }

    private static final long hexToULong(String arg1, HexFormat arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "format");
        return ULong.constructor-impl(HexExtensionsKt.hexToLong(arg1, arg2));
    }

    static long hexToULong$default(String arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "format");
        return ULong.constructor-impl(HexExtensionsKt.hexToLong(arg0, arg1));
    }

    private static final short hexToUShort(String arg1, HexFormat arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "format");
        return UShort.constructor-impl(HexExtensionsKt.hexToShort(arg1, arg2));
    }

    static short hexToUShort$default(String arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "format");
        return UShort.constructor-impl(HexExtensionsKt.hexToShort(arg0, arg1));
    }

    private static final String toHexString-8M7LxHw(int arg1, HexFormat arg2) {
        Intrinsics.checkNotNullParameter(arg2, "format");
        return HexExtensionsKt.toHexString(arg1, arg2);
    }

    static String toHexString-8M7LxHw$default(int arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        Intrinsics.checkNotNullParameter(arg1, "format");
        return HexExtensionsKt.toHexString(arg0, arg1);
    }

    private static final String toHexString-8UJCm-I(long arg1, HexFormat arg3) {
        Intrinsics.checkNotNullParameter(arg3, "format");
        return HexExtensionsKt.toHexString(arg1, arg3);
    }

    static String toHexString-8UJCm-I$default(long arg0, HexFormat arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg2 = HexFormat.Companion.getDefault();
        }

        Intrinsics.checkNotNullParameter(arg2, "format");
        return HexExtensionsKt.toHexString(arg0, arg2);
    }

    private static final String toHexString-ZQbaR00(byte arg1, HexFormat arg2) {
        Intrinsics.checkNotNullParameter(arg2, "format");
        return HexExtensionsKt.toHexString(arg1, arg2);
    }

    static String toHexString-ZQbaR00$default(byte arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        Intrinsics.checkNotNullParameter(arg1, "format");
        return HexExtensionsKt.toHexString(arg0, arg1);
    }

    private static final String toHexString-lZCiFrA(byte[] arg1, int arg2, int arg3, HexFormat arg4) {
        Intrinsics.checkNotNullParameter(arg1, "$this$toHexString");
        Intrinsics.checkNotNullParameter(arg4, "format");
        return HexExtensionsKt.toHexString(arg1, arg2, arg3, arg4);
    }

    static String toHexString-lZCiFrA$default(byte[] arg0, int arg1, int arg2, HexFormat arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = UByteArray.getSize-impl(arg0);
        }

        if((arg4 & 4) != 0) {
            arg3 = HexFormat.Companion.getDefault();
        }

        Intrinsics.checkNotNullParameter(arg0, "$this$toHexString");
        Intrinsics.checkNotNullParameter(arg3, "format");
        return HexExtensionsKt.toHexString(arg0, 0, arg2, arg3);
    }

    private static final String toHexString-r3ox_E0(short arg1, HexFormat arg2) {
        Intrinsics.checkNotNullParameter(arg2, "format");
        return HexExtensionsKt.toHexString(arg1, arg2);
    }

    static String toHexString-r3ox_E0$default(short arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        Intrinsics.checkNotNullParameter(arg1, "format");
        return HexExtensionsKt.toHexString(arg0, arg1);
    }

    private static final String toHexString-zHuV2wU(byte[] arg1, HexFormat arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$toHexString");
        Intrinsics.checkNotNullParameter(arg2, "format");
        return HexExtensionsKt.toHexString(arg1, arg2);
    }

    static String toHexString-zHuV2wU$default(byte[] arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        Intrinsics.checkNotNullParameter(arg0, "$this$toHexString");
        Intrinsics.checkNotNullParameter(arg1, "format");
        return HexExtensionsKt.toHexString(arg0, arg1);
    }
}

