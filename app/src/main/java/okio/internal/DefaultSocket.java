package okio.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.-SegmentedByteString;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.Segment;
import okio.SegmentPool;
import okio.Sink;
import okio.Socket;
import okio.Source;
import okio.Timeout;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001A\u00020\u0013H\u0016J\b\u0010\u0014\u001A\u00020\u0015H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000FX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2={"Lokio/internal/DefaultSocket;", "Lokio/Socket;", "socket", "Ljava/net/Socket;", "<init>", "(Ljava/net/Socket;)V", "getSocket", "()Ljava/net/Socket;", "closeBits", "Ljava/util/concurrent/atomic/AtomicInteger;", "source", "Lokio/Source;", "getSource", "()Lokio/Source;", "sink", "Lokio/Sink;", "getSink", "()Lokio/Sink;", "cancel", "", "toString", "", "SocketSink", "SocketSource", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DefaultSocket implements Socket {
    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\nH\u0016J\b\u0010\u0010\u001A\u00020\nH\u0016J\b\u0010\u0007\u001A\u00020\bH\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016R\u0016\u0010\u0004\u001A\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Lokio/internal/DefaultSocket$SocketSink;", "Lokio/Sink;", "<init>", "(Lokio/internal/DefaultSocket;)V", "outputStream", "Ljava/io/OutputStream;", "kotlin.jvm.PlatformType", "timeout", "Lokio/internal/SocketAsyncTimeout;", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "flush", "close", "toString", "", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SocketSink implements Sink {
        private final OutputStream outputStream;
        private final SocketAsyncTimeout timeout;

        public SocketSink(DefaultSocket arg2) {
            DefaultSocket.this = arg2;
            super();
            this.outputStream = arg2.getSocket().getOutputStream();
            this.timeout = new SocketAsyncTimeout(arg2.getSocket());
        }

        public void close() {
            SocketAsyncTimeout v0 = this.timeout;
            DefaultSocket v1 = DefaultSocket.this;
            ((AsyncTimeout)v0).enter();
            try {
                int v2 = _AtomicKt.setBitsOrZero(v1.closeBits, 1);
                if(v2 == 0) {
                    goto label_35;
                }

                if(v2 == 3) {
                    goto label_26;
                }

                if(!v1.getSocket().isClosed()) {
                    if(v1.getSocket().isOutputShutdown()) {
                    }
                    else {
                        this.outputStream.flush();
                        try {
                            v1.getSocket().shutdownOutput();
                        }
                        catch(UnsupportedOperationException ) {
                            this.outputStream.close();
                        }

                        goto label_28;
                    }
                }
            }
            catch(Throwable v4) {
                goto label_45;
            }
            catch(IOException v4_1) {
                goto label_40;
            }

            ((AsyncTimeout)v0).exit();
            return;
            try {
            label_26:
                v1.getSocket().close();
            label_28:
            }
            catch(Throwable v4) {
            }
            catch(IOException v4_1) {
                try {
                label_40:
                    if(!((AsyncTimeout)v0).exit()) {
                    }
                    else {
                        v4_1 = ((AsyncTimeout)v0).access$newTimeoutException(v4_1);
                    }

                    throw v4_1;
                }
                catch(Throwable v4) {
                label_45:
                    ((AsyncTimeout)v0).exit();
                    throw v4;
                }
            }

            if(!((AsyncTimeout)v0).exit()) {
                return;
            }

            throw ((AsyncTimeout)v0).access$newTimeoutException(null);
        label_35:
            ((AsyncTimeout)v0).exit();
        }

        public void flush() {
            SocketAsyncTimeout v0 = this.timeout;
            ((AsyncTimeout)v0).enter();
            try {
                this.outputStream.flush();
            }
            catch(Throwable v2) {
            }
            catch(IOException v2_1) {
                try {
                    if(((AsyncTimeout)v0).exit()) {
                        v2_1 = ((AsyncTimeout)v0).access$newTimeoutException(v2_1);
                    }

                    throw v2_1;
                }
                catch(Throwable v2) {
                    ((AsyncTimeout)v0).exit();
                    throw v2;
                }
            }

            if(!((AsyncTimeout)v0).exit()) {
                return;
            }

            throw ((AsyncTimeout)v0).access$newTimeoutException(null);
        }

        public Timeout timeout() {
            return this.timeout();
        }

        public SocketAsyncTimeout timeout() {
            return this.timeout;
        }

        public String toString() {
            return "sink(" + DefaultSocket.this.getSocket() + ')';
        }

        public void write(Buffer arg8, long arg9) {
            SocketAsyncTimeout v2;
            Intrinsics.checkNotNullParameter(arg8, "source");
            -SegmentedByteString.checkOffsetAndCount(arg8.size(), 0, arg9);
            while(true) {
                if(arg9 <= 0) {
                    return;
                }

                this.timeout.throwIfReached();
                Segment v0 = arg8.head;
                Intrinsics.checkNotNull(v0);
                int v1 = ((int)Math.min(arg9, ((long)(v0.limit - v0.pos))));
                v2 = this.timeout;
                ((AsyncTimeout)v2).enter();
                try {
                    this.outputStream.write(v0.data, v0.pos, v1);
                }
                catch(Throwable v0_1) {
                }
                catch(IOException v0_2) {
                    IOException v7 = v0_2;
                    try {
                        if(((AsyncTimeout)v2).exit()) {
                            v7 = ((AsyncTimeout)v2).access$newTimeoutException(v7);
                        }

                        throw v7;
                    }
                    catch(Throwable v0_1) {
                        Throwable v7_1 = v0_1;
                        ((AsyncTimeout)v2).exit();
                        throw v7_1;
                    }
                }

                if(((AsyncTimeout)v2).exit()) {
                    break;
                }

                v0.pos += v1;
                long v1_1 = ((long)v1);
                arg9 -= v1_1;
                arg8.setSize$okio(arg8.size() - v1_1);
                if(v0.pos != v0.limit) {
                    continue;
                }

                arg8.head = v0.pop();
                SegmentPool.recycle(v0);
            }

            throw ((AsyncTimeout)v2).access$newTimeoutException(null);
        }
    }

    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\nH\u0016J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0007\u001A\u00020\bH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u0016\u0010\u0004\u001A\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Lokio/internal/DefaultSocket$SocketSource;", "Lokio/Source;", "<init>", "(Lokio/internal/DefaultSocket;)V", "inputStream", "Ljava/io/InputStream;", "kotlin.jvm.PlatformType", "timeout", "Lokio/internal/SocketAsyncTimeout;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "close", "", "toString", "", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SocketSource implements Source {
        private final InputStream inputStream;
        private final SocketAsyncTimeout timeout;

        public SocketSource(DefaultSocket arg2) {
            DefaultSocket.this = arg2;
            super();
            this.inputStream = arg2.getSocket().getInputStream();
            this.timeout = new SocketAsyncTimeout(arg2.getSocket());
        }

        public void close() {
            SocketAsyncTimeout v0 = this.timeout;
            DefaultSocket v1 = DefaultSocket.this;
            ((AsyncTimeout)v0).enter();
            try {
                int v2 = _AtomicKt.setBitsOrZero(v1.closeBits, 2);
                if(v2 == 0) {
                    goto label_33;
                }

                if(v2 == 3) {
                    goto label_24;
                }

                if(!v1.getSocket().isClosed()) {
                    if(v1.getSocket().isInputShutdown()) {
                        goto label_15;
                    }
                    else {
                        goto label_16;
                    }
                }

                goto label_22;
            }
            catch(IOException v4) {
                goto label_38;
            }
            catch(Throwable v4_1) {
                goto label_43;
            }

        label_15:
            goto label_22;
            try {
            label_16:
                v1.getSocket().shutdownInput();
                goto label_26;
            }
            catch(Throwable v4_1) {
            }
            catch(IOException v4) {
            }
            catch(UnsupportedOperationException ) {
                try {
                    this.inputStream.close();
                    goto label_26;
                }
                catch(IOException v4) {
                    goto label_38;
                }
                catch(Throwable v4_1) {
                    goto label_43;
                }

            label_22:
                ((AsyncTimeout)v0).exit();
                return;
                try {
                label_24:
                    v1.getSocket().close();
                label_26:
                }
                catch(Throwable v4_1) {
                }
                catch(IOException v4) {
                    try {
                    label_38:
                        if(!((AsyncTimeout)v0).exit()) {
                        }
                        else {
                            v4 = ((AsyncTimeout)v0).access$newTimeoutException(v4);
                        }

                        throw v4;
                    }
                    catch(Throwable v4_1) {
                    label_43:
                        ((AsyncTimeout)v0).exit();
                        throw v4_1;
                    }
                }
            }

            if(!((AsyncTimeout)v0).exit()) {
                return;
            }

            throw ((AsyncTimeout)v0).access$newTimeoutException(null);
        label_33:
            ((AsyncTimeout)v0).exit();
        }

        public long read(Buffer arg4, long arg5) {
            int v3_3;
            SocketAsyncTimeout v6;
            Intrinsics.checkNotNullParameter(arg4, "sink");
            long v0 = 0;
            int v2 = Long.compare(arg5, v0);
            if(v2 == 0) {
                return v0;
            }

            if(v2 < 0) {
                goto label_62;
            }

            this.timeout.throwIfReached();
            Segment v0_1 = arg4.writableSegment$okio(1);
            int v5 = ((int)Math.min(arg5, ((long)(0x2000 - v0_1.limit))));
            try {
                v6 = this.timeout;
                ((AsyncTimeout)v6).enter();
            }
            catch(AssertionError v3) {
                goto label_57;
            }

            try {
                v3_3 = this.inputStream.read(v0_1.data, v0_1.limit, v5);
                goto label_22;
            }
            catch(Throwable v3_1) {
            }
            catch(IOException v3_2) {
                try {
                    if(!((AsyncTimeout)v6).exit()) {
                    }
                    else {
                        v3_2 = ((AsyncTimeout)v6).access$newTimeoutException(v3_2);
                    }

                    throw v3_2;
                }
                catch(Throwable v3_1) {
                    try {
                        ((AsyncTimeout)v6).exit();
                        throw v3_1;
                    label_22:
                        if(((AsyncTimeout)v6).exit()) {
                            goto label_42;
                        }
                    }
                    catch(AssertionError v3) {
                        goto label_57;
                    }
                }
            }

            if(v3_3 == -1) {
                if(v0_1.pos == v0_1.limit) {
                    arg4.head = v0_1.pop();
                    SegmentPool.recycle(v0_1);
                }

                return -1;
            }

            v0_1.limit += v3_3;
            v0 = ((long)v3_3);
            arg4.setSize$okio(arg4.size() + v0);
            return v0;
        label_42:
            v3_2 = null;
            try {
                throw ((AsyncTimeout)v6).access$newTimeoutException(v3_2);
            }
            catch(AssertionError v3) {
            label_57:
                if(_JavaIoKt.isAndroidGetsocknameError(v3)) {
                    throw new IOException(((Throwable)v3));
                }

                throw v3;
            }

        label_62:
            throw new IllegalArgumentException("byteCount < 0: " + arg5.toString());
        }

        public Timeout timeout() {
            return this.timeout();
        }

        public SocketAsyncTimeout timeout() {
            return this.timeout;
        }

        public String toString() {
            return "source(" + DefaultSocket.this.getSocket() + ')';
        }
    }

    private AtomicInteger closeBits;
    private final Sink sink;
    private final java.net.Socket socket;
    private final Source source;

    public DefaultSocket(java.net.Socket arg2) {
        Intrinsics.checkNotNullParameter(arg2, "socket");
        super();
        this.socket = arg2;
        this.closeBits = new AtomicInteger();
        this.source = new SocketSource(this);
        this.sink = new SocketSink(this);
    }

    public static final AtomicInteger access$getCloseBits$p(DefaultSocket arg0) {
        return arg0.closeBits;
    }

    public void cancel() {
        this.socket.close();
    }

    public Sink getSink() {
        return this.sink;
    }

    public final java.net.Socket getSocket() {
        return this.socket;
    }

    public Source getSource() {
        return this.source;
    }

    public String toString() {
        String v1 = this.socket.toString();
        Intrinsics.checkNotNullExpressionValue(v1, "toString(...)");
        return v1;
    }
}

