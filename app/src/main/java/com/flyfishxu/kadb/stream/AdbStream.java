package com.flyfishxu.kadb.stream;

import com.flyfishxu.kadb.core.AdbMessage;
import com.flyfishxu.kadb.core.AdbWriter;
import com.flyfishxu.kadb.queue.AdbMessageQueue;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002BE\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\b\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\b\u0010\u001A\u001A\u00020\bH\u0002J\u0010\u0010\u001B\u001A\u00020\b2\u0006\u0010\u001C\u001A\u00020\u001DH\u0002J\u0012\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\u0006\u0010\u001F\u001A\u00020\bH\u0002J\b\u0010 \u001A\u00020!H\u0016J\u0010\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\fH\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001A\u00020\u0013¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001A\u00020\u0017¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2={"Lcom/flyfishxu/kadb/stream/AdbStream;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "messageQueue", "Lcom/flyfishxu/kadb/queue/AdbMessageQueue;", "adbWriter", "Lcom/flyfishxu/kadb/core/AdbWriter;", "outboundMaxPayloadSize", "", "localId", "remoteId", "delayedAckEnabled", "", "initialAvailableSendBytes", "", "<init>", "(Lcom/flyfishxu/kadb/queue/AdbMessageQueue;Lcom/flyfishxu/kadb/core/AdbWriter;IIIZJ)V", "isClosed", "source", "Lokio/BufferedSource;", "getSource", "()Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "getSink", "()Lokio/BufferedSink;", "awaitAckBytes", "decodeOkayAckBytes", "message", "Lcom/flyfishxu/kadb/core/AdbMessage;", "nextMessage", "command", "close", "", "sendClose", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbStream implements AutoCloseable {
    private final AdbWriter adbWriter;
    private final boolean delayedAckEnabled;
    private final long initialAvailableSendBytes;
    private boolean isClosed;
    private final int localId;
    private final AdbMessageQueue messageQueue;
    private final int outboundMaxPayloadSize;
    private final int remoteId;
    private final BufferedSink sink;
    private final BufferedSource source;

    public AdbStream(AdbMessageQueue arg2, AdbWriter arg3, int arg4, int arg5, int arg6, boolean arg7, long arg8) {
        Intrinsics.checkNotNullParameter(arg2, "messageQueue");
        Intrinsics.checkNotNullParameter(arg3, "adbWriter");
        super();
        this.messageQueue = arg2;
        this.adbWriter = arg3;
        this.outboundMaxPayloadSize = arg4;
        this.localId = arg5;
        this.remoteId = arg6;
        this.delayedAckEnabled = arg7;
        this.initialAvailableSendBytes = arg8;
        this.source = Okio.buffer(new AdbStream$source$1(this));
        this.sink = Okio.buffer(new AdbStream$sink$1(this));
    }

    public AdbStream(AdbMessageQueue arg11, AdbWriter arg12, int arg13, int arg14, int arg15, boolean arg16, long arg17, int arg19, DefaultConstructorMarker arg20) {
        AdbStream v1;
        int v6;
        int v5;
        int v4;
        AdbWriter v3;
        AdbMessageQueue v2;
        long v8;
        boolean v7 = (arg19 & 0x20) != 0 ? false : arg16;
        if((arg19 & 0x40) != 0) {
            v8 = 0;
            v2 = arg11;
            v3 = arg12;
            v4 = arg13;
            v5 = arg14;
            v6 = arg15;
            v1 = this;
        }
        else {
            v8 = arg17;
            v1 = this;
            v2 = arg11;
            v3 = arg12;
            v4 = arg13;
            v5 = arg14;
            v6 = arg15;
        }

        this(v2, v3, v4, v5, v6, v7, v8);
    }

    public static final int access$awaitAckBytes(AdbStream arg0) {
        return arg0.awaitAckBytes();
    }

    public static final AdbWriter access$getAdbWriter$p(AdbStream arg0) {
        return arg0.adbWriter;
    }

    public static final boolean access$getDelayedAckEnabled$p(AdbStream arg0) {
        return arg0.delayedAckEnabled;
    }

    public static final long access$getInitialAvailableSendBytes$p(AdbStream arg2) {
        return arg2.initialAvailableSendBytes;
    }

    public static final int access$getLocalId$p(AdbStream arg0) {
        return arg0.localId;
    }

    public static final int access$getOutboundMaxPayloadSize$p(AdbStream arg0) {
        return arg0.outboundMaxPayloadSize;
    }

    public static final int access$getRemoteId$p(AdbStream arg0) {
        return arg0.remoteId;
    }

    public static final AdbMessage access$nextMessage(AdbStream arg0, int arg1) {
        return arg0.nextMessage(arg1);
    }

    private final int awaitAckBytes() {
        AdbMessage v0 = this.nextMessage(0x59414B4F);
        if(v0 != null) {
            return this.decodeOkayAckBytes(v0);
        }

        String v3 = Integer.toString(this.localId, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(v3, "toString(...)");
        throw new IOException("ADB stream closed before delayed ACK for localId: " + v3);
    }

    public void close() {
        this.close(true);
    }

    private final void close(boolean arg3) {
        if(this.isClosed) {
            return;
        }

        this.isClosed = true;
        if(arg3) {
            try {
                this.adbWriter.writeClose(this.localId, this.remoteId);
            }
            catch(Throwable v3) {
                this.messageQueue.stopListening(this.localId);
                throw v3;
            }
        }

        this.messageQueue.stopListening(this.localId);
    }

    private final int decodeOkayAckBytes(AdbMessage arg3) {
        if(arg3.getCommand() == 0x59414B4F) {
            int v0 = arg3.getPayloadLength();
            if(v0 != 0) {
                if(v0 == 4) {
                    if(this.delayedAckEnabled) {
                        return new Buffer().write(arg3.getPayload()).readIntLe();
                    }

                    throw new IOException("Unexpected OKAY payload for non-delayed-ack stream: " + arg3.getPayloadLength());
                }

                throw new IOException("Invalid OKAY payload size: " + arg3.getPayloadLength());
            }

            if(!this.delayedAckEnabled) {
                return 0;
            }

            String v2 = Integer.toString(this.localId, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(v2, "toString(...)");
            throw new IOException("Delayed ACK stream missing OKAY payload for localId: " + v2);
        }

        throw new IllegalArgumentException("Expected OKAY message, got " + arg3.getCommand().toString());
    }

    public final BufferedSink getSink() {
        return this.sink;
    }

    public final BufferedSource getSource() {
        return this.source;
    }

    private final AdbMessage nextMessage(int arg3) {
        try {
            return this.messageQueue.take(this.localId, arg3);
        }
        catch(IOException ) {
            this.close(false);
            return null;
        }
    }
}

