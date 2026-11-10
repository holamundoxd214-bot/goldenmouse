package com.flyfishxu.kadb.pair;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0000¨\u0006\u0005"}, d2={"getBytes", "", "text", "", "charsetName", "kadb"}, k=2, mv={2, 3, 0}, xi=0x30) public final class PairingAuthCtxKt {
    public static final byte[] getBytes(String arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg3, "text");
        Intrinsics.checkNotNullParameter(arg4, "charsetName");
        try {
            Charset v0 = Charset.forName(arg4);
            Intrinsics.checkNotNullExpressionValue(v0, "forName(...)");
            byte[] v3_1 = arg3.getBytes(v0);
            Intrinsics.checkNotNullExpressionValue(v3_1, "getBytes(...)");
            return v3_1;
        }
        catch(UnsupportedEncodingException v3) {
            Throwable v3_2 = new IllegalCharsetNameException("Illegal charset " + arg4).initCause(((Throwable)v3));
            Intrinsics.checkNotNull(v3_2, "null cannot be cast to non-null type java.nio.charset.IllegalCharsetNameException");
            throw v3_2;
        }
    }
}

