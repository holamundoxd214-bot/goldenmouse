package com.flyfishxu.kadb.core;

import com.flyfishxu.kadb.debug.LoggingKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u000F\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000E\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\nJ\u000E\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u0010J\u0016\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\u0010J\u000E\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\nJ \u0010\u0016\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\n2\u0006\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\nJ.\u0010\u001B\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u001D\u001A\u00020\n2\u0006\u0010\u001E\u001A\u00020\nJ\u0016\u0010\u001F\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\nJ\'\u0010 \u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\n2\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\n¢\u0006\u0002\u0010\"J8\u0010#\u001A\u00020\f2\u0006\u0010$\u001A\u00020\n2\u0006\u0010%\u001A\u00020\n2\u0006\u0010\u001A\u001A\u00020\n2\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u001D\u001A\u00020\n2\u0006\u0010\u001E\u001A\u00020\nJ \u0010&\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u001D\u001A\u00020\n2\u0006\u0010\u001E\u001A\u00020\nH\u0002J\b\u0010\'\u001A\u00020\fH\u0016R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006("}, d2={"Lcom/flyfishxu/kadb/core/AdbWriter;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "sink", "Lokio/Sink;", "<init>", "(Lokio/Sink;)V", "bufferedSink", "Lokio/BufferedSink;", "protocolVersion", "", "updateProtocolVersion", "", "peerVersion", "writeConnect", "payload", "", "writeAuth", "authType", "authPayload", "writeStls", "version", "writeOpen", "localId", "destination", "", "arg1", "writeWrite", "remoteId", "offset", "length", "writeClose", "writeOkay", "ackBytes", "(IILjava/lang/Integer;)V", "write", "command", "arg0", "payloadChecksum", "close", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbWriter implements AutoCloseable {
    private final BufferedSink bufferedSink;
    private volatile int protocolVersion;

    public AdbWriter(Sink arg2) {
        Intrinsics.checkNotNullParameter(arg2, "sink");
        super();
        this.bufferedSink = Okio.buffer(arg2);
        this.protocolVersion = 0x1000000;
    }

    public void close() {
        this.bufferedSink.close();
    }

    private final int payloadChecksum(byte[] arg2, int arg3, int arg4) {
        if(arg3 >= 0 && arg4 >= 0 && arg3 + arg4 <= arg2.length) {
            arg4 += arg3;
            int v1 = 0;
            while(arg3 < arg4) {
                v1 += UByte.constructor-impl(arg2[arg3]) & 0xFF;
                ++arg3;
            }

            return v1;
        }

        throw new IllegalArgumentException("payloadChecksum out of bounds: offset=" + arg3 + " length=" + arg4 + " size=" + arg2.length.toString());
    }

    public final void updateProtocolVersion(int arg2) {
        this.protocolVersion = Math.min(arg2, 0x1000001);
    }

    public final void write(int arg7, int arg8, int arg9, byte[] arg10, int arg11, int arg12) {
        int v1 = arg7;
        int v2 = arg8;
        int v3 = arg9;
        byte[] v5 = arg10;
        int v4 = arg12;
        LoggingKt.log(new AdbWriter$$ExternalSyntheticLambda0(v1, v2, v3, v4, v5));
        BufferedSink v7 = this.bufferedSink;
        __monitor_enter(v7);
        try {
            BufferedSink v8 = this.bufferedSink;
            v8.writeIntLe(v1);
            v8.writeIntLe(v2);
            v8.writeIntLe(v3);
            arg9 = 0;
            if(v5 == null) {
                v8.writeIntLe(0);
                v8.writeIntLe(0);
            }
            else {
                v8.writeIntLe(v4);
                if(this.protocolVersion >= 0x1000001) {
                }
                else {
                    arg9 = this.payloadChecksum(v5, arg11, v4);
                }

                v8.writeIntLe(arg9);
            }

            v8.writeIntLe(~v1);
            if(v5 != null) {
                v8.write(v5, arg11, v4);
            }

            v8.flush();
        }
        catch(Throwable v0) {
            __monitor_exit(v7);
            throw v0;
        }

        __monitor_exit(v7);
    }

    static final String write$lambda$0(int arg9, int arg10, int arg11, int arg12, byte[] arg13) {
        String v0 = Thread.currentThread().getName();
        if(arg13 == null) {
            arg13 = new byte[0];
        }

        return "(" + v0 + ") > " + new AdbMessage(arg9, arg10, arg11, arg12, 0, 0, arg13);
    }

    public final void writeAuth(int arg9, byte[] arg10) {
        Intrinsics.checkNotNullParameter(arg10, "authPayload");
        this.write(1213486401, arg9, 0, arg10, 0, arg10.length);
    }

    public final void writeClose(int arg8, int arg9) {
        this.write(1163086915, arg8, arg9, null, 0, 0);
    }

    public final void writeConnect(byte[] arg9) {
        Intrinsics.checkNotNullParameter(arg9, "payload");
        this.write(1314410051, 0x1000001, 0x100000, arg9, 0, arg9.length);
    }

    public final void writeOkay(int arg8, int arg9, Integer arg10) {
        byte[] v10 = arg10 != null ? ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(((Number)arg10).intValue()).array() : null;
        byte[] v4 = v10;
        int v10_1 = v4 != null ? v4.length : 0;
        this.write(0x59414B4F, arg8, arg9, v4, 0, v10_1);
    }

    public static void writeOkay$default(AdbWriter arg0, int arg1, int arg2, Integer arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        arg0.writeOkay(arg1, arg2, arg3);
    }

    public final void writeOpen(int arg9, String arg10, int arg11) {
        Intrinsics.checkNotNullParameter(arg10, "destination");
        byte[] v10 = arg10.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(v10, "getBytes(...)");
        ByteBuffer v0 = ByteBuffer.allocate(v10.length + 1);
        v0.put(v10);
        v0.put(0);
        byte[] v5 = v0.array();
        this.write(0x4E45504F, arg9, arg11, v5, 0, v5.length);
    }

    public static void writeOpen$default(AdbWriter arg0, int arg1, String arg2, int arg3, int arg4, Object arg5) {
        arg0.writeOpen(arg1, arg2, 0);
    }

    public final void writeStls(int arg8) {
        this.write(0x534C5453, arg8, 0, null, 0, 0);
    }

    public final void writeWrite(int arg9, int arg10, byte[] arg11, int arg12, int arg13) {
        Intrinsics.checkNotNullParameter(arg11, "payload");
        this.write(1163154007, arg9, arg10, arg11, arg12, arg13);
    }
}

