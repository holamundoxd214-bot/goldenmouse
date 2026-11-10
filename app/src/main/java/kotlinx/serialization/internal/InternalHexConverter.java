package kotlinx.serialization.internal;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005J\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0002J\u0018\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u00072\b\b\u0002\u0010\u000F\u001A\u00020\u0010J\u000E\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\nR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Lkotlinx/serialization/internal/InternalHexConverter;", "", "<init>", "()V", "hexCode", "", "parseHexBinary", "", "s", "hexToInt", "", "ch", "", "printHexBinary", "data", "lowerCase", "", "toHexString", "n", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InternalHexConverter {
    public static final InternalHexConverter INSTANCE = null;
    private static final String hexCode = "0123456789ABCDEF";

    static {
        InternalHexConverter.INSTANCE = new InternalHexConverter();
    }

    private InternalHexConverter() {
        super();
    }

    private final int hexToInt(char arg2) {
        int v1 = 0x30;
        if(v1 <= arg2 && arg2 < 58) {
            return arg2 - v1;
        }

        if(65 <= arg2 && arg2 < 71) {
            return arg2 - 55;
        }

        if(97 <= arg2 && arg2 < 103) {
            return arg2 - 87;
        }

        return -1;
    }

    public final byte[] parseHexBinary(String arg8) {
        int v4;
        Intrinsics.checkNotNullParameter(arg8, "s");
        int v0 = arg8.length();
        if(v0 % 2 != 0) {
            goto label_37;
        }

        byte[] v1 = new byte[v0 / 2];
        int v2 = 0;
        while(true) {
            if(v2 >= v0) {
                return v1;
            }

            int v3 = this.hexToInt(arg8.charAt(v2));
            v4 = v2 + 1;
            int v5 = this.hexToInt(arg8.charAt(v4));
            int v6 = -1;
            if(v3 != v6 && v5 != v6) {
                v1[v2 / 2] = ((byte)((v3 << 4) + v5));
                v2 += 2;
                continue;
            }

            break;
        }

        throw new IllegalArgumentException("Invalid hex chars: " + arg8.charAt(v2) + arg8.charAt(v4).toString());
        return v1;
    label_37:
        throw new IllegalArgumentException("HexBinary string must be even length".toString());
    }

    public final String printHexBinary(byte[] arg6, boolean arg7) {
        Intrinsics.checkNotNullParameter(arg6, "data");
        StringBuilder v5 = new StringBuilder(arg6.length * 2);
        int v0 = arg6.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            int v2 = arg6[v1];
            v5.append("0123456789ABCDEF".charAt(v2 >> 4 & 15));
            v5.append("0123456789ABCDEF".charAt(v2 & 15));
        }

        String v5_1 = v5.toString();
        Intrinsics.checkNotNullExpressionValue(v5_1, "toString(...)");
        if(arg7) {
            v5_1 = v5_1.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(v5_1, "toLowerCase(...)");
        }

        return v5_1;
    }

    public static String printHexBinary$default(InternalHexConverter arg0, byte[] arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.printHexBinary(arg1, false);
    }

    public final String toHexString(int arg6) {
        int v0 = 4;
        byte[] v1 = new byte[v0];
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            v1[v3] = ((byte)(arg6 >> 24 - v3 * 8));
        }

        String v5 = StringsKt.trimStart(this.printHexBinary(v1, true), new char[]{'0'});
        if(v5.length() > 0) {
        }
        else {
            v5 = null;
        }

        if(v5 == null) {
            v5 = "0";
        }

        return v5;
    }
}

