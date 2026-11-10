package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0080\b\u001A\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002¨\u0006\u0007"}, d2={"commonDecodeHex", "Lokio/ByteString;", "", "decodeHexDigit", "", "c", "", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class -ByteStringNonJs {
    public static final int access$decodeHexDigit(char arg0) {
        return -ByteStringNonJs.decodeHexDigit(arg0);
    }

    public static final ByteString commonDecodeHex(String arg5) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        if(arg5.length() % 2 == 0) {
            int v0 = arg5.length() / 2;
            byte[] v1 = new byte[v0];
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                int v3 = v2 * 2;
                v1[v2] = ((byte)((-ByteStringNonJs.decodeHexDigit(arg5.charAt(v3)) << 4) + -ByteStringNonJs.decodeHexDigit(arg5.charAt(v3 + 1))));
            }

            return new ByteString(v1);
        }

        throw new IllegalArgumentException("Unexpected hex string: " + arg5.toString());
    }

    private static final int decodeHexDigit(char arg3) {
        int v0 = 0x30;
        if(v0 <= arg3 && arg3 < 58) {
            return arg3 - v0;
        }

        if(97 <= arg3 && arg3 < 103) {
            return arg3 - 87;
        }

        if(65 <= arg3 && arg3 < 71) {
            return arg3 - 55;
        }

        throw new IllegalArgumentException("Unexpected hex digit: " + arg3);
    }
}

