package com.flyfishxu.kadb.transport;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CH\u0096@¢\u0006\u0002\u0010\u001DJ&\u0010\u001E\u001A\u00020\u00162\u0006\u0010\u001F\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CH\u0096@¢\u0006\u0002\u0010\u001DJ&\u0010 \u001A\u00020!2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CH\u0096@¢\u0006\u0002\u0010\u001DJ&\u0010\"\u001A\u00020!2\u0006\u0010\u001F\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CH\u0096@¢\u0006\u0002\u0010\u001DJ\u000E\u0010#\u001A\u00020!H\u0096@¢\u0006\u0002\u0010$J\u000E\u0010%\u001A\u00020!H\u0096@¢\u0006\u0002\u0010$J\b\u0010)\u001A\u00020!H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0006\u001A\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u001C\u0010\u000B\u001A\n \b*\u0004\u0018\u00010\f0\f8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0012R\u0014\u0010&\u001A\u00020\'8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b&\u0010(¨\u0006+"}, d2={"Lcom/flyfishxu/kadb/transport/PlainBlockingChannel;", "Lcom/flyfishxu/kadb/transport/TransportChannel;", "socket", "Ljava/net/Socket;", "<init>", "(Ljava/net/Socket;)V", "input", "Ljava/io/InputStream;", "kotlin.jvm.PlatformType", "getInput", "()Ljava/io/InputStream;", "output", "Ljava/io/OutputStream;", "getOutput", "()Ljava/io/OutputStream;", "localAddress", "Ljava/net/InetSocketAddress;", "getLocalAddress", "()Ljava/net/InetSocketAddress;", "remoteAddress", "getRemoteAddress", "read", "", "dst", "Ljava/nio/ByteBuffer;", "timeout", "", "unit", "Ljava/util/concurrent/TimeUnit;", "(Ljava/nio/ByteBuffer;JLjava/util/concurrent/TimeUnit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "write", "src", "readExactly", "", "writeExactly", "shutdownInput", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdownOutput", "isOpen", "", "()Z", "close", "Companion", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class PlainBlockingChannel implements TransportChannel {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B¨\u0006\f"}, d2={"Lcom/flyfishxu/kadb/transport/PlainBlockingChannel$Companion;", "", "<init>", "()V", "connect", "Lcom/flyfishxu/kadb/transport/PlainBlockingChannel;", "host", "", "port", "", "connectTimeoutMs", "", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final PlainBlockingChannel connect(String arg3, int arg4, long arg5) {
            Intrinsics.checkNotNullParameter(arg3, "host");
            Socket v2 = new Socket();
            v2.setKeepAlive(true);
            v2.setTcpNoDelay(true);
            v2.connect(new InetSocketAddress(arg3, arg4), ((int)RangesKt.coerceAtMost(arg5, 0x7FFFFFFF)));
            return new PlainBlockingChannel(v2, null);
        }
    }

    public static final Companion Companion;
    private final Socket socket;

    static {
        PlainBlockingChannel.Companion = new Companion(null);
    }

    private PlainBlockingChannel(Socket arg1) {
        super();
        this.socket = arg1;
    }

    public PlainBlockingChannel(Socket arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public void close() {
        this.socket.close();
    }

    private final InputStream getInput() {
        return this.socket.getInputStream();
    }

    public InetSocketAddress getLocalAddress() {
        SocketAddress v1 = this.socket.getLocalSocketAddress();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.net.InetSocketAddress");
        return ((InetSocketAddress)v1);
    }

    private final OutputStream getOutput() {
        return this.socket.getOutputStream();
    }

    public InetSocketAddress getRemoteAddress() {
        SocketAddress v1 = this.socket.getRemoteSocketAddress();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.net.InetSocketAddress");
        return ((InetSocketAddress)v1);
    }

    public boolean isOpen() {
        if((this.socket.isConnected()) && !this.socket.isClosed()) {
            return 1;
        }

        return 0;
    }

    public Object read(ByteBuffer arg6, long arg7, TimeUnit arg9, Continuation arg10) {
        Integer v6_1;
        int v10 = this.socket.getSoTimeout();
        try {
            Socket v0 = this.socket;
            int v7 = Long.compare(arg7, 0) > 0 ? ((int)RangesKt.coerceAtMost(arg9.toMillis(arg7), 0x7FFFFFFF)) : 0;
            v0.setSoTimeout(v7);
            byte[] v7_1 = new byte[Math.min(arg6.remaining(), 0x10000)];
            int v8 = this.getInput().read(v7_1);
            if(v8 <= 0) {
                v6_1 = Boxing.boxInt(-1);
            }
            else {
                arg6.put(v7_1, 0, v8);
                v6_1 = Boxing.boxInt(v8);
            }
        }
        catch(Throwable v6) {
            this.socket.setSoTimeout(v10);
            throw v6;
        }

        this.socket.setSoTimeout(v10);
        return v6_1;
    }

    public Object readExactly(ByteBuffer arg11, long arg12, TimeUnit arg14, Continuation arg15) {
        Continuation v9;
        Object v5;
        long v6;
        PlainBlockingChannel v4;
        TimeUnit v8_1;
        PlainBlockingChannel$readExactly$1 v0_1;
        int v2;
        if((arg15 instanceof PlainBlockingChannel$readExactly$1)) {
            Continuation v0 = arg15;
            v2 = 0x80000000;
            if((((PlainBlockingChannel$readExactly$1)v0).label & v2) != 0) {
                ((PlainBlockingChannel$readExactly$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new PlainBlockingChannel$readExactly$1(this, arg15);
        }

        Object v15 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v15);
            ByteBuffer v5_1 = arg11;
            v6 = arg12;
            v8_1 = arg14;
            v9 = ((Continuation)v0_1);
            goto label_38;
        label_48:
            if(((Number)v15).intValue() >= 0) {
                this = v4;
            }
            else {
                throw new EOFException("EOF while readExactly");
            }
        }
        else if(v2 == 1) {
            long v11 = v0_1.J$0;
            Object v13 = v0_1.L$1;
            Object v14 = v0_1.L$0;
            ResultKt.throwOnFailure(v15);
            v4 = this;
            v6 = v11;
            Object v8 = v13;
            v5 = v14;
            v9 = ((Continuation)v0_1);
            goto label_48;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_38:
        if(((ByteBuffer)v5).hasRemaining()) {
            ((PlainBlockingChannel$readExactly$1)v9).L$0 = v5;
            ((PlainBlockingChannel$readExactly$1)v9).L$1 = v8_1;
            ((PlainBlockingChannel$readExactly$1)v9).J$0 = v6;
            ((PlainBlockingChannel$readExactly$1)v9).label = 1;
            v4 = this;
            v15 = v4.read(((ByteBuffer)v5), v6, v8_1, v9);
            if(v15 != v1) {
                goto label_48;
            }

            return v1;
        }

        return Unit.INSTANCE;
    }

    public Object shutdownInput(Continuation arg1) {
        this.socket.shutdownInput();
        return Unit.INSTANCE;
    }

    public Object shutdownOutput(Continuation arg1) {
        this.socket.shutdownOutput();
        return Unit.INSTANCE;
    }

    public Object write(ByteBuffer arg1, long arg2, TimeUnit arg4, Continuation arg5) {
        int v2 = Math.min(arg1.remaining(), 0x10000);
        byte[] v3 = new byte[v2];
        int v4 = arg1.limit();
        arg1.limit(arg1.position() + v2);
        arg1.get(v3);
        arg1.limit(v4);
        this.getOutput().write(v3);
        return Boxing.boxInt(v2);
    }

    public Object writeExactly(ByteBuffer arg11, long arg12, TimeUnit arg14, Continuation arg15) {
        Continuation v9;
        Object v5;
        Object v8;
        long v6;
        PlainBlockingChannel v4;
        int v2;
        Continuation v0;
        if((arg15 instanceof PlainBlockingChannel$writeExactly$1)) {
            v0 = arg15;
            v2 = 0x80000000;
            if((((PlainBlockingChannel$writeExactly$1)v0).label & v2) != 0) {
                ((PlainBlockingChannel$writeExactly$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            PlainBlockingChannel$writeExactly$1 v0_1 = new PlainBlockingChannel$writeExactly$1(this, arg15);
        }

        Object v15 = ((PlainBlockingChannel$writeExactly$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((PlainBlockingChannel$writeExactly$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v15);
            ByteBuffer v5_1 = arg11;
            v6 = arg12;
            TimeUnit v8_1 = arg14;
            v9 = v0;
            goto label_38;
        label_48:
            int v10 = ((Number)v15).intValue();
            if(v10 >= 0) {
                this = v4;
            }
            else {
                throw new IOException("write returned " + v10);
            }
        }
        else if(v2 == 1) {
            long v11 = ((PlainBlockingChannel$writeExactly$1)v0).J$0;
            Object v13 = ((PlainBlockingChannel$writeExactly$1)v0).L$1;
            Object v14 = ((PlainBlockingChannel$writeExactly$1)v0).L$0;
            ResultKt.throwOnFailure(v15);
            v4 = this;
            v6 = v11;
            v8 = v13;
            v5 = v14;
            v9 = v0;
            goto label_48;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_38:
        if(((ByteBuffer)v5).hasRemaining()) {
            ((PlainBlockingChannel$writeExactly$1)v9).L$0 = v5;
            ((PlainBlockingChannel$writeExactly$1)v9).L$1 = v8;
            ((PlainBlockingChannel$writeExactly$1)v9).J$0 = v6;
            ((PlainBlockingChannel$writeExactly$1)v9).label = 1;
            v4 = this;
            v15 = v4.write(((ByteBuffer)v5), v6, ((TimeUnit)v8), v9);
            if(v15 != v1) {
                goto label_48;
            }

            return v1;
        }

        return Unit.INSTANCE;
    }
}

