package com.flyfishxu.kadb.tls;

import com.flyfishxu.kadb.exception.AdbPairAuthException;
import java.io.IOException;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.Iterator;
import java.util.Locale;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005¨\u0006\u0007"}, d2={"Lcom/flyfishxu/kadb/tls/TlsErrorMapper;", "", "<init>", "()V", "map", "", "throwable", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class TlsErrorMapper {
    public static final TlsErrorMapper INSTANCE;

    public static Throwable $r8$lambda$NDLCitk61X0YR6mm5B18J-5KGMo(Throwable arg0) {
        return TlsErrorMapper.map$lambda$0$0(arg0);
    }

    static {
        TlsErrorMapper.INSTANCE = new TlsErrorMapper();
    }

    private TlsErrorMapper() {
        super();
    }

    public final Throwable map(Throwable arg5) {
        Iterator v4_2;
        Intrinsics.checkNotNullParameter(arg5, "throwable");
        StringBuilder v4 = new StringBuilder();
        Iterator v0 = SequencesKt.generateSequence(arg5, new TlsErrorMapper$$ExternalSyntheticLambda0()).iterator();
        while(v0.hasNext()) {
            String v1 = v0.next().getMessage();
            if(v1 == null) {
                continue;
            }

            v1 = v1.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(v1, "toLowerCase(...)");
            v4.append(v1).append('\n');
        }

        String v4_1 = v4.toString();
        int v2 = 2;
        Object v3 = null;
        if(!StringsKt.contains$default(((CharSequence)v4_1), "certificate_required", false, v2, v3) && !StringsKt.contains$default(((CharSequence)v4_1), "unknown_ca", false, v2, v3) && !StringsKt.contains$default(((CharSequence)v4_1), "access_denied", false, v2, v3)) {
            if(StringsKt.contains$default(((CharSequence)v4_1), "certificate_unknown", false, v2, v3)) {
            }
            else {
                v4_2 = SequencesKt.generateSequence(arg5, new TlsErrorMapper$$ExternalSyntheticLambda1()).iterator();
                goto label_42;
            }
        }

        return new AdbPairAuthException();
        do {
        label_42:
            if(!v4_2.hasNext()) {
                goto label_51;
            }
        }
        while(!(v4_2.next() instanceof InterruptedByTimeoutException));

        return new IOException("TLS handshake timeout", arg5);
    label_51:
        v4_2 = SequencesKt.generateSequence(arg5, new TlsErrorMapper$$ExternalSyntheticLambda2()).iterator();
        do {
            if(!v4_2.hasNext()) {
                return arg5;
            }

            Object v0_1 = v4_2.next();
            if((v0_1 instanceof SSLHandshakeException)) {
                break;
            }

            if((v0_1 instanceof SSLProtocolException)) {
                break;
            }
        }
        while(!(v0_1 instanceof SSLException));

        v4_1 = arg5.getMessage();
        String v0_2 = "";
        if(v4_1 == null) {
            v4_1 = v0_2;
        }

        if(v4_1.length() > 0) {
            v0_2 = ": " + v4_1;
        }

        return new IOException("TLS handshake failed" + v0_2, arg5);
    }

    private static final Throwable map$lambda$0$0(Throwable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return arg1.getCause();
    }

    static final Throwable map$lambda$1(Throwable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return arg1.getCause();
    }

    static final Throwable map$lambda$3(Throwable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return arg1.getCause();
    }
}

