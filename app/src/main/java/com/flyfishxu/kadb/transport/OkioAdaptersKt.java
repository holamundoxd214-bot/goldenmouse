package com.flyfishxu.kadb.transport;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Sink;
import okio.Source;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0016\u0010\u0003\u001A\u00020\u0004*\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0000\u001A\u0016\u0010\b\u001A\u00020\t*\u00020\u00052\b\b\u0002\u0010\n\u001A\u00020\u0007H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"DEFAULT_CHUNK_SIZE", "", "MAX_CHUNK_SIZE", "asOkioSource", "Lokio/Source;", "Lcom/flyfishxu/kadb/transport/TransportChannel;", "readTimeoutMs", "", "asOkioSink", "Lokio/Sink;", "writeTimeoutMs", "kadb"}, k=2, mv={2, 3, 0}, xi=0x30) public final class OkioAdaptersKt {
    private static final int DEFAULT_CHUNK_SIZE = 0x10000;
    private static final int MAX_CHUNK_SIZE = 0x40000;

    public static final Sink asOkioSink(TransportChannel arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new OkioAdaptersKt$asOkioSink$1(arg2, arg1);
    }

    public static Sink asOkioSink$default(TransportChannel arg0, long arg1, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = 0;
        }

        return OkioAdaptersKt.asOkioSink(arg0, arg1);
    }

    public static final Source asOkioSource(TransportChannel arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new OkioAdaptersKt$asOkioSource$1(arg2, arg1);
    }

    public static Source asOkioSource$default(TransportChannel arg0, long arg1, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = 0;
        }

        return OkioAdaptersKt.asOkioSource(arg0, arg1);
    }
}

