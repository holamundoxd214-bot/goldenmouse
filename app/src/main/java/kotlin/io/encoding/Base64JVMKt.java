package kotlin.io.encoding;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\u001A&\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0081\u0088\u0004\u001A&\u0010\b\u001A\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0081\u0088\u0004\u001A6\u0010\n\u001A\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0081\u0088\u0004\u001A&\u0010\r\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0081\u0088\u0004¨\u0006\u000E"}, d2={"platformCharsToBytes", "", "Lkotlin/io/encoding/Base64;", "source", "", "startIndex", "", "endIndex", "platformEncodeToString", "", "platformEncodeIntoByteArray", "destination", "destinationOffset", "platformEncodeToByteArray", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class Base64JVMKt {
    private static final byte[] platformCharsToBytes(Base64 arg1, CharSequence arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "source");
        if((arg2 instanceof String)) {
            arg1.checkSourceBounds$kotlin_stdlib(((String)arg2).length(), arg3, arg4);
            String v1 = ((String)arg2).substring(arg3, arg4);
            Intrinsics.checkNotNullExpressionValue(v1, "substring(...)");
            Charset v2 = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.lang.String");
            byte[] v1_1 = v1.getBytes(v2);
            Intrinsics.checkNotNullExpressionValue(v1_1, "getBytes(...)");
            return v1_1;
        }

        return arg1.charsToBytesImpl$kotlin_stdlib(arg2, arg3, arg4);
    }

    private static final int platformEncodeIntoByteArray(Base64 arg1, byte[] arg2, byte[] arg3, int arg4, int arg5, int arg6) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "destination");
        return arg1.encodeIntoByteArrayImpl$kotlin_stdlib(arg2, arg3, arg4, arg5, arg6);
    }

    private static final byte[] platformEncodeToByteArray(Base64 arg1, byte[] arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "source");
        return arg1.encodeToByteArrayImpl$kotlin_stdlib(arg2, arg3, arg4);
    }

    private static final String platformEncodeToString(Base64 arg1, byte[] arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "source");
        return new String(arg1.encodeToByteArrayImpl$kotlin_stdlib(arg2, arg3, arg4), Charsets.ISO_8859_1);
    }
}

