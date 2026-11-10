package com.flyfishxu.kadb.core;

import com.flyfishxu.kadb.debug.LoggingKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000E\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0005\u001A\u00020\u0006J\u0006\u0010\u000F\u001A\u00020\u0010J\b\u0010\u0011\u001A\u00020\u000EH\u0016R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Lcom/flyfishxu/kadb/core/AdbReader;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "source", "Lokio/Source;", "maxPayloadSize", "", "<init>", "(Lokio/Source;I)V", "bufferedSource", "Lokio/BufferedSource;", "localHardCap", "inboundMaxPayloadSize", "setInboundMaxPayloadSize", "", "readMessage", "Lcom/flyfishxu/kadb/core/AdbMessage;", "close", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbReader implements AutoCloseable {
    private final BufferedSource bufferedSource;
    private volatile int inboundMaxPayloadSize;
    private final int localHardCap;

    public static String $r8$lambda$Xkw3wiFJ8t0mbN4gr-jOlxmFORA(AdbMessage arg0) {
        return AdbReader.readMessage$lambda$0$0$0$0(arg0);
    }

    public AdbReader(Source arg1, int arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = 0x100000;
        }

        this(arg1, arg2);
    }

    public AdbReader(Source arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        super();
        this.bufferedSource = Okio.buffer(arg2);
        int v2 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(arg3, 0), 0x100000);
        this.localHardCap = v2;
        this.inboundMaxPayloadSize = v2;
    }

    public void close() {
        this.bufferedSource.close();
    }

    public final AdbMessage readMessage() {
        AdbMessage v4;
        int v12;
        int v10;
        int v8;
        int v5;
        String v0 = "Invalid ADB magic: expected=";
        String v1 = "Invalid ADB payload length: ";
        BufferedSource v2 = this.bufferedSource;
        __monitor_enter(v2);
        try {
            BufferedSource v3 = this.bufferedSource;
            v5 = v3.readIntLe();
            int v6 = v3.readIntLe();
            int v7 = v3.readIntLe();
            v8 = v3.readIntLe();
            if(v8 >= 0 && v8 <= this.inboundMaxPayloadSize) {
                int v9 = v3.readIntLe();
                v10 = v3.readIntLe();
                v12 = ~v5;
                if(v10 == v12) {
                    v4 = new AdbMessage(v5, v6, v7, v8, v9, v10, v3.readByteArray(((long)v8)));
                    LoggingKt.log(new AdbReader$$ExternalSyntheticLambda0(v4));
                    goto label_23;
                }
                else {
                    goto label_25;
                }
            }

            goto label_38;
        }
        catch(Throwable v0_1) {
            goto label_53;
        }

    label_23:
        __monitor_exit(v2);
        return v4;
        try {
        label_25:
            throw new IOException(v0 + v12 + " actual=" + v10 + " command=" + v5);
        label_38:
            throw new IOException(v1 + v8 + " (max=" + this.inboundMaxPayloadSize + ")");
        }
        catch(Throwable v0_1) {
        label_53:
            __monitor_exit(v2);
            throw v0_1;
        }
    }

    private static final String readMessage$lambda$0$0$0$0(AdbMessage arg3) {
        return "(" + Thread.currentThread().getName() + ") < " + arg3;
    }

    public final void setInboundMaxPayloadSize(int arg2) {
        this.inboundMaxPayloadSize = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(arg2, 0), 0x100000);
    }
}

