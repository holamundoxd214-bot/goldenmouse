package com.flyfishxu.kadb.transport;

import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult$HandshakeStatus;
import javax.net.ssl.SSLEngineResult$Status;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\b\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001E\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J&\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0015J&\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0015J&\u0010\u0018\u001A\u00020\f2\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0015J&\u0010\u0019\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0015J\u000E\u0010\u001A\u001A\u00020\fH\u0096@¢\u0006\u0002\u0010\u001BJ\u000E\u0010\u001C\u001A\u00020\fH\u0096@¢\u0006\u0002\u0010\u001BJ\b\u0010&\u001A\u00020\fH\u0016J\u0018\u0010\'\u001A\u00020\b2\u0006\u0010(\u001A\u00020\b2\u0006\u0010)\u001A\u00020\u0013H\u0002J\b\u0010*\u001A\u00020\fH\u0002R\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001D\u001A\u00020\u001E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u001E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010 R\u0014\u0010#\u001A\u00020$8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b#\u0010%¨\u0006,"}, d2={"Lcom/flyfishxu/kadb/transport/TlsNioChannel;", "Lcom/flyfishxu/kadb/transport/TransportChannel;", "net", "engine", "Ljavax/net/ssl/SSLEngine;", "<init>", "(Lcom/flyfishxu/kadb/transport/TransportChannel;Ljavax/net/ssl/SSLEngine;)V", "netIn", "Ljava/nio/ByteBuffer;", "netOut", "appIn", "handshake", "", "timeout", "", "unit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", "", "dst", "(Ljava/nio/ByteBuffer;JLjava/util/concurrent/TimeUnit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "write", "src", "readExactly", "writeExactly", "shutdownInput", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdownOutput", "localAddress", "Ljava/net/InetSocketAddress;", "getLocalAddress", "()Ljava/net/InetSocketAddress;", "remoteAddress", "getRemoteAddress", "isOpen", "", "()Z", "close", "enlarge", "buffer", "minimum", "resizeIfNeeded", "Companion", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class TlsNioChannel implements TransportChannel {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lcom/flyfishxu/kadb/transport/TlsNioChannel$Companion;", "", "<init>", "()V", "EMPTY", "Ljava/nio/ByteBuffer;", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[SSLEngineResult$Status.values().length];
            try {
                v0[SSLEngineResult$Status.OK.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
            label_7:
                int v2 = 2;
                try {
                    v0[SSLEngineResult$Status.BUFFER_OVERFLOW.ordinal()] = v2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    int v3 = 3;
                    try {
                        v0[SSLEngineResult$Status.BUFFER_UNDERFLOW.ordinal()] = v3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        int v4 = 4;
                        try {
                            v0[SSLEngineResult$Status.CLOSED.ordinal()] = v4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            v0 = new int[SSLEngineResult$HandshakeStatus.values().length];
                            try {
                                v0[SSLEngineResult$HandshakeStatus.NEED_WRAP.ordinal()] = 1;
                                goto label_26;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_26:
                                    v0[SSLEngineResult$HandshakeStatus.NEED_UNWRAP.ordinal()] = v2;
                                    goto label_29;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_29:
                                        v0[SSLEngineResult$HandshakeStatus.NEED_TASK.ordinal()] = v3;
                                        goto label_32;
                                    }
                                    catch(NoSuchFieldError ) {
                                        try {
                                        label_32:
                                            v0[SSLEngineResult$HandshakeStatus.FINISHED.ordinal()] = v4;
                                            goto label_35;
                                        }
                                        catch(NoSuchFieldError ) {
                                            try {
                                            label_35:
                                                v0[SSLEngineResult$HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 5;
                                                goto label_39;
                                            }
                                            catch(NoSuchFieldError ) {
                                            label_39:
                                                WhenMappings.$EnumSwitchMapping$1 = v0;
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static final Companion Companion;
    private static final ByteBuffer EMPTY;
    private ByteBuffer appIn;
    private final SSLEngine engine;
    private final TransportChannel net;
    private ByteBuffer netIn;
    private ByteBuffer netOut;

    static {
        TlsNioChannel.Companion = new Companion(null);
        ByteBuffer v0 = ByteBuffer.allocate(0);
        Intrinsics.checkNotNullExpressionValue(v0, "allocate(...)");
        TlsNioChannel.EMPTY = v0;
    }

    public TlsNioChannel(TransportChannel arg2, SSLEngine arg3) {
        Intrinsics.checkNotNullParameter(arg2, "net");
        Intrinsics.checkNotNullParameter(arg3, "engine");
        super();
        this.net = arg2;
        this.engine = arg3;
        ByteBuffer v2 = ByteBuffer.allocate(arg3.getSession().getPacketBufferSize());
        Intrinsics.checkNotNullExpressionValue(v2, "allocate(...)");
        this.netIn = v2;
        v2 = ByteBuffer.allocate(arg3.getSession().getPacketBufferSize());
        Intrinsics.checkNotNullExpressionValue(v2, "allocate(...)");
        this.netOut = v2;
        v2 = ByteBuffer.allocate(arg3.getSession().getApplicationBufferSize());
        Intrinsics.checkNotNullExpressionValue(v2, "allocate(...)");
        this.appIn = v2;
    }

    public static final TransportChannel access$getNet$p(TlsNioChannel arg0) {
        return arg0.net;
    }

    public static final ByteBuffer access$getNetOut$p(TlsNioChannel arg0) {
        return arg0.netOut;
    }

    public void close() {
        SSLEngineResult v1;
        Continuation v0;
        try {
            this.engine.closeOutbound();
            this.netOut.clear();
            v0 = null;
        }
        catch(Throwable ) {
            goto label_34;
        }

        try {
            v1 = this.engine.wrap(TlsNioChannel.EMPTY.duplicate(), this.netOut);
        }
        catch(Throwable ) {
            v1 = ((SSLEngineResult)v0);
        }

        if(v1 == null) {
            goto label_34;
        }

        try {
            if(v1.getStatus() != SSLEngineResult$Status.OK) {
                goto label_34;
            }

            if(this.netOut.position() <= 0) {
                goto label_34;
            }

            this.netOut.flip();
        }
        catch(Throwable ) {
            goto label_34;
        }

        try {
            BuildersKt.runBlocking$default(((CoroutineContext)v0), new TlsNioChannel$close$1$1(this, v0), 1, v0);
            Result.constructor-impl(Unit.INSTANCE);
            goto label_34;
        }
        catch(Throwable v0_1) {
            try {
                Result.constructor-impl(ResultKt.createFailure(v0_1));
                goto label_34;
            }
            catch(Throwable ) {
            label_34:
                this.net.close();
                return;
            }
        }
    }

    private final ByteBuffer enlarge(ByteBuffer arg1, int arg2) {
        ByteBuffer v0 = ByteBuffer.allocate(Math.max(arg1.capacity() * 2, arg2));
        arg1.flip();
        v0.put(arg1);
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    public InetSocketAddress getLocalAddress() {
        return this.net.getLocalAddress();
    }

    public InetSocketAddress getRemoteAddress() {
        return this.net.getRemoteAddress();
    }

    public final Object handshake(long arg22, TimeUnit arg24, Continuation arg25) {
        long v11_1;
        Object v13;
        Object v2_2;
        Continuation v14;
        Object v11;
        Object v4_1;
        long v9;
        ByteBuffer v10;
        TransportChannel v9_1;
        SSLEngineResult$Status v4_2;
        SSLEngineResult$HandshakeStatus v2_4;
        SSLEngineResult v1_3;
        TimeUnit v13_1;
        SSLEngineResult$HandshakeStatus v1_2;
        TlsNioChannel$handshake$1 v2_1;
        int v4;
        Continuation v2;
        TlsNioChannel v0 = this;
        Continuation v1 = arg25;
        if((v1 instanceof TlsNioChannel$handshake$1)) {
            v2 = v1;
            v4 = 0x80000000;
            if((((TlsNioChannel$handshake$1)v2).label & v4) != 0) {
                ((TlsNioChannel$handshake$1)v2).label -= v4;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            v2_1 = new TlsNioChannel$handshake$1(v0, v1);
        }

        Object v1_1 = v2_1.result;
        Object v3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v4 = v2_1.label;
        int v5 = -1;
        int v6 = 3;
        int v7 = 2;
        if(v4 == 0) {
            ResultKt.throwOnFailure(v1_1);
            v0.netIn.clear();
            v0.netIn.limit(0);
            v0.appIn.clear();
            v0.engine.beginHandshake();
            v1_2 = v0.engine.getHandshakeStatus();
            v11_1 = arg22;
            v13_1 = arg24;
            v14 = ((Continuation)v2_1);
            goto label_70;
            while(true) {
            label_244:
                if(v0.netOut.hasRemaining()) {
                    TransportChannel v15 = v0.net;
                    ByteBuffer v2_3 = v0.netOut;
                    ((TlsNioChannel$handshake$1)v14).L$0 = v13_1;
                    ((TlsNioChannel$handshake$1)v14).L$1 = v1_1;
                    ((TlsNioChannel$handshake$1)v14).L$2 = SpillingKt.nullOutSpilledVariable(v4_1);
                    ((TlsNioChannel$handshake$1)v14).J$0 = v11_1;
                    ((TlsNioChannel$handshake$1)v14).label = 1;
                    long v17 = v11_1;
                    Object v19 = v13_1;
                    Continuation v20 = v14;
                    if(v15.writeExactly(v2_3, v17, ((TimeUnit)v19), v20) != v3) {
                        v11_1 = v17;
                        v13 = v19;
                        v14 = v20;
                        continue;
                    }
                    else {
                        return v3;
                    }
                }

                goto label_70;
            }

            return v3;
        label_181:
            if(((Number)v1_1).intValue() >= 0) {
                v0.netIn.flip();
                goto label_185;
            }
            else {
                throw new SSLException("EOF during handshake");
            label_185:
                v1_1 = v2_2;
                goto label_70;
            label_130:
                if(((Number)v1_1).intValue() >= 0) {
                    v0.netIn.flip();
                    v14 = ((Continuation)v2_1);
                    v13 = v4_1;
                    v11_1 = v9;
                    goto label_142;
                }
                else {
                    throw new SSLException("Channel closed during handshake");
                label_142:
                    v1_3 = v0.engine.unwrap(v0.netIn, v0.appIn);
                    v2_4 = v1_3.getHandshakeStatus();
                    v4_2 = v1_3.getStatus();
                    v4 = v4_2 == null ? v5 : WhenMappings.$EnumSwitchMapping$0[v4_2.ordinal()];
                    if(v4 == 1) {
                        goto label_185;
                    }

                    if(v4 != v7) {
                        if(v4 == v6) {
                            if(v0.netIn.limit() == v0.netIn.capacity()) {
                                v0.netIn = v0.enlarge(v0.netIn, v0.engine.getSession().getPacketBufferSize());
                            }

                            v0.netIn.compact();
                            v9_1 = v0.net;
                            v10 = v0.netIn;
                            ((TlsNioChannel$handshake$1)v14).L$0 = v13_1;
                            ((TlsNioChannel$handshake$1)v14).L$1 = v2_4;
                            ((TlsNioChannel$handshake$1)v14).L$2 = SpillingKt.nullOutSpilledVariable(v1_3);
                            ((TlsNioChannel$handshake$1)v14).J$0 = v11_1;
                            ((TlsNioChannel$handshake$1)v14).label = v6;
                            v1_1 = v9_1.read(v10, v11_1, v13_1, v14);
                            if(v1_1 != v3) {
                                goto label_181;
                            }

                            return v3;
                        }

                        throw new SSLException("NEED_UNWRAP: " + v1_3.getStatus());
                    }

                    v0.appIn = v0.enlarge(v0.appIn, v0.engine.getSession().getApplicationBufferSize());
                    goto label_185;
                }
            }
        }
        else if(v4 == 1) {
            v9 = v2_1.J$0;
            v4_1 = v2_1.L$2;
            v11 = v2_1.L$1;
            Object v12 = v2_1.L$0;
            ResultKt.throwOnFailure(v1_1);
            v14 = ((Continuation)v2_1);
            v1_1 = v11;
            v13 = v12;
            v11_1 = v9;
            goto label_244;
        }
        else if(v4 == v7) {
            v9 = v2_1.J$0;
            v4_1 = v2_1.L$0;
            ResultKt.throwOnFailure(v1_1);
            goto label_130;
        }
        else if(v4 == v6) {
            v9 = v2_1.J$0;
            v4_1 = v2_1.L$1;
            v11 = v2_1.L$0;
            ResultKt.throwOnFailure(v1_1);
            v14 = ((Continuation)v2_1);
            v2_2 = v4_1;
            v13 = v11;
            v11_1 = v9;
            goto label_181;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        while(true) {
        label_70:
            int v2_5 = v1_1 == null ? v5 : WhenMappings.$EnumSwitchMapping$1[((SSLEngineResult$HandshakeStatus)v1_1).ordinal()];
            if(v2_5 == 1) {
                goto label_207;
            }

            if(v2_5 == v7) {
                goto label_110;
            }

            if(v2_5 == v6) {
                goto label_100;
            }

            if(v2_5 != 4 && v2_5 != 5) {
                if(Intrinsics.areEqual(((SSLEngineResult$HandshakeStatus)v1_1).name(), "NEED_UNWRAP_AGAIN")) {
                    v1_2 = SSLEngineResult$HandshakeStatus.NEED_UNWRAP;
                    continue;
                }
                else {
                    break;
                }
            }

            goto label_97;
        }

        throw new SSLException("Unsupported handshake status: " + v1_1);
    label_97:
        v0.resizeIfNeeded();
        return Unit.INSTANCE;
    label_100:
        Runnable v1_4 = v0.engine.getDelegatedTask();
        goto label_102;
    label_110:
        if(v0.netIn.hasRemaining()) {
            goto label_142;
        }

        v0.netIn.compact();
        v9_1 = v0.net;
        v10 = v0.netIn;
        ((TlsNioChannel$handshake$1)v14).L$0 = v13_1;
        ((TlsNioChannel$handshake$1)v14).L$1 = SpillingKt.nullOutSpilledVariable(v1_1);
        ((TlsNioChannel$handshake$1)v14).L$2 = null;
        ((TlsNioChannel$handshake$1)v14).J$0 = v11_1;
        ((TlsNioChannel$handshake$1)v14).label = v7;
        v1_1 = v9_1.read(v10, v11_1, v13_1, v14);
        if(v1_1 == v3) {
            return v3;
        }

        v9 = v11_1;
        v4_1 = v13_1;
        v2 = v14;
        goto label_130;
    label_207:
        v0.netOut.clear();
        v1_3 = v0.engine.wrap(TlsNioChannel.EMPTY.duplicate(), v0.netOut);
        v2_4 = v1_3.getHandshakeStatus();
        v4_2 = v1_3.getStatus();
        v4 = v4_2 == null ? v5 : WhenMappings.$EnumSwitchMapping$0[v4_2.ordinal()];
        if(v4 != 1) {
            if(v4 == v7) {
                v0.netOut = v0.enlarge(v0.netOut, v0.engine.getSession().getPacketBufferSize());
                goto label_185;
            }

            throw new SSLException("NEED_WRAP: " + v1_3.getStatus());
        }

        v0.netOut.flip();
        SSLEngineResult v4_3 = v1_3;
        v1_2 = v2_4;
        goto label_244;
    label_102:
        while(v1_4 != null) {
            v1_4.run();
            v1_4 = v0.engine.getDelegatedTask();
        }

        v1_2 = v0.engine.getHandshakeStatus();
        goto label_70;
    }

    public boolean isOpen() {
        return this.net.isOpen();
    }

    public Object read(ByteBuffer arg18, long arg19, TimeUnit arg21, Continuation arg22) {
        long v10_1;
        Object v12;
        Continuation v13;
        Object v10;
        Object v4_1;
        long v8;
        Continuation v16;
        long v13_1;
        Object v15;
        TimeUnit v12_1;
        int v2_2;
        int v1_2;
        TlsNioChannel$read$1 v2_1;
        int v4;
        Continuation v2;
        TlsNioChannel v0 = this;
        Continuation v1 = arg22;
        if((v1 instanceof TlsNioChannel$read$1)) {
            v2 = v1;
            v4 = 0x80000000;
            if((((TlsNioChannel$read$1)v2).label & v4) != 0) {
                ((TlsNioChannel$read$1)v2).label -= v4;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            v2_1 = new TlsNioChannel$read$1(v0, v1);
        }

        Object v1_1 = v2_1.result;
        Object v3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v4 = v2_1.label;
        int v5 = 2;
        int v7 = -1;
        if(v4 == 0) {
            ResultKt.throwOnFailure(v1_1);
            v0.appIn.flip();
            if(v0.appIn.hasRemaining()) {
                v1_2 = Math.min(arg18.remaining(), v0.appIn.remaining());
                v2_2 = v0.appIn.limit();
                v0.appIn.limit(v0.appIn.position() + v1_2);
                arg18.put(v0.appIn);
                v0.appIn.limit(v2_2);
                v0.appIn.compact();
                return Boxing.boxInt(v1_2);
            }
            else {
                ByteBuffer v4_2 = arg18;
                v0.appIn.compact();
                v10_1 = arg19;
                v12_1 = arg21;
                v13 = ((Continuation)v2_1);
                goto label_74;
            label_146:
                if(((Number)v1_1).intValue() < 0) {
                    return Boxing.boxInt(v7);
                }
                else {
                    v0.netIn.flip();
                    goto label_74;
                label_94:
                    if(((Number)v1_1).intValue() < 0) {
                        return Boxing.boxInt(v7);
                    }
                    else {
                        v0.netIn.flip();
                        v15 = v4_1;
                        v13_1 = v8;
                        v4_1 = v10;
                    label_107:
                        SSLEngineResult v1_3 = v0.engine.unwrap(v0.netIn, v0.appIn);
                        SSLEngineResult$Status v8_1 = v1_3.getStatus();
                        int v8_2 = v8_1 == null ? v7 : WhenMappings.$EnumSwitchMapping$0[v8_1.ordinal()];
                        if(v8_2 == 1) {
                            v16 = ((Continuation)v2_1);
                            if(v0.appIn.position() > 0) {
                                v0.appIn.flip();
                                v1_2 = Math.min(((ByteBuffer)v4_1).remaining(), v0.appIn.remaining());
                                v2_2 = v0.appIn.limit();
                                v0.appIn.limit(v0.appIn.position() + v1_2);
                                ((ByteBuffer)v4_1).put(v0.appIn);
                                v0.appIn.limit(v2_2);
                                v0.appIn.compact();
                                return Boxing.boxInt(v1_2);
                            }
                        }
                        else if(v8_2 == v5) {
                            v16 = ((Continuation)v2_1);
                            v0.appIn = v0.enlarge(v0.appIn, v0.engine.getSession().getApplicationBufferSize());
                        }
                        else if(v8_2 == 3) {
                            v0.netIn.compact();
                            TransportChannel v11 = v0.net;
                            ByteBuffer v12_2 = v0.netIn;
                            v2_1.L$0 = v4_1;
                            v2_1.L$1 = v15;
                            v2_1.L$2 = SpillingKt.nullOutSpilledVariable(v1_3);
                            v2_1.J$0 = v13_1;
                            v2_1.label = v5;
                            v16 = ((Continuation)v2_1);
                            v1_1 = v11.read(v12_2, v13_1, ((TimeUnit)v15), v16);
                            if(v1_1 != v3) {
                                v10_1 = v13_1;
                                v12 = v15;
                                v13 = v16;
                                goto label_146;
                            }
                            else {
                                return v3;
                            }
                        }
                        else if(v8_2 == 4) {
                            return Boxing.boxInt(v7);
                        }
                        else {
                            throw new NoWhenBranchMatchedException();
                        }

                        v10_1 = v13_1;
                        v12 = v15;
                        v13 = v16;
                        goto label_74;
                        return v3;
                    }
                }
            }
        }
        else if(v4 == 1) {
            v8 = v2_1.J$0;
            v4_1 = v2_1.L$1;
            v10 = v2_1.L$0;
            ResultKt.throwOnFailure(v1_1);
            goto label_94;
        }
        else if(v4 == v5) {
            v8 = v2_1.J$0;
            v4_1 = v2_1.L$1;
            v10 = v2_1.L$0;
            ResultKt.throwOnFailure(v1_1);
            v13 = ((Continuation)v2_1);
            v12 = v4_1;
            v4_1 = v10;
            v10_1 = v8;
            goto label_146;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_74:
        if(!v0.netIn.hasRemaining()) {
            v0.netIn.clear();
            TransportChannel v8_3 = v0.net;
            ByteBuffer v9 = v0.netIn;
            ((TlsNioChannel$read$1)v13).L$0 = v4_1;
            ((TlsNioChannel$read$1)v13).L$1 = v12_1;
            ((TlsNioChannel$read$1)v13).L$2 = null;
            ((TlsNioChannel$read$1)v13).J$0 = v10_1;
            ((TlsNioChannel$read$1)v13).label = 1;
            v1_1 = v8_3.read(v9, v10_1, v12_1, v13);
            if(v1_1 == v3) {
                return v3;
            }

            v8 = v10_1;
            v2 = v13;
            v10 = v4_1;
            v4_1 = v12_1;
            goto label_94;
        }

        v15 = v12_1;
        v2 = v13;
        v13_1 = v10_1;
        goto label_107;
    }

    public Object readExactly(ByteBuffer arg11, long arg12, TimeUnit arg14, Continuation arg15) {
        Continuation v9;
        long v6;
        TlsNioChannel v4;
        TimeUnit v8_1;
        ByteBuffer v5_1;
        TlsNioChannel$readExactly$1 v0_1;
        int v2;
        if((arg15 instanceof TlsNioChannel$readExactly$1)) {
            Continuation v0 = arg15;
            v2 = 0x80000000;
            if((((TlsNioChannel$readExactly$1)v0).label & v2) != 0) {
                ((TlsNioChannel$readExactly$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new TlsNioChannel$readExactly$1(this, arg15);
        }

        Object v15 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v15);
            v5_1 = arg11;
            v6 = arg12;
            v8_1 = arg14;
            v9 = ((Continuation)v0_1);
            goto label_38;
        label_48:
            if(((Number)v15).intValue() >= 0) {
                this = v4;
            }
            else {
                throw new EOFException("EOF while TLS readExactly");
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
            Object v5 = v14;
            v9 = ((Continuation)v0_1);
            goto label_48;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_38:
        if(v5_1.hasRemaining()) {
            ((TlsNioChannel$readExactly$1)v9).L$0 = v5_1;
            ((TlsNioChannel$readExactly$1)v9).L$1 = v8_1;
            ((TlsNioChannel$readExactly$1)v9).J$0 = v6;
            ((TlsNioChannel$readExactly$1)v9).label = 1;
            v4 = this;
            v15 = v4.read(v5_1, v6, v8_1, v9);
            if(v15 != v1) {
                goto label_48;
            }

            return v1;
        }

        return Unit.INSTANCE;
    }

    private final void resizeIfNeeded() {
        int v0 = this.engine.getSession().getPacketBufferSize();
        int v1 = this.engine.getSession().getApplicationBufferSize();
        if(this.netIn.capacity() < v0) {
            this.netIn = this.enlarge(this.netIn, v0);
        }

        if(this.netOut.capacity() < v0) {
            this.netOut = this.enlarge(this.netOut, v0);
        }

        if(this.appIn.capacity() < v1) {
            this.appIn = this.enlarge(this.appIn, v1);
        }
    }

    public Object shutdownInput(Continuation arg1) {
        Object v0 = this.net.shutdownInput(arg1);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public Object shutdownOutput(Continuation arg1) {
        Object v0 = this.net.shutdownOutput(arg1);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public Object write(ByteBuffer arg12, long arg13, TimeUnit arg15, Continuation arg16) {
        long v7_1;
        Continuation v10;
        Object v9;
        Object v12;
        int v3;
        Continuation v1;
        Continuation v0 = arg16;
        if((v0 instanceof TlsNioChannel$write$1)) {
            v1 = v0;
            v3 = 0x80000000;
            if((((TlsNioChannel$write$1)v1).label & v3) != 0) {
                ((TlsNioChannel$write$1)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            TlsNioChannel$write$1 v1_1 = new TlsNioChannel$write$1(this, v0);
        }

        Continuation v7 = v1;
        Object v0_1 = ((TlsNioChannel$write$1)v7).result;
        Object v1_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v2 = ((TlsNioChannel$write$1)v7).label;
        v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v0_1);
            this.netOut.clear();
            SSLEngineResult v0_2 = this.engine.wrap(arg12, this.netOut);
            SSLEngineResult$Status v2_2 = v0_2.getStatus();
            int v5_1 = -1;
            v2 = v2_2 == null ? v5_1 : WhenMappings.$EnumSwitchMapping$0[v2_2.ordinal()];
            if(v2 != 1) {
                if(v2 != v3) {
                    if(v2 != 3) {
                        if(v2 == 4) {
                            goto label_117;
                        }

                        throw new NoWhenBranchMatchedException();
                    }

                    throw new IllegalStateException("wrap BUFFER_UNDERFLOW should not happen".toString());
                }

                this.netOut = this.enlarge(this.netOut, this.engine.getSession().getPacketBufferSize());
                ((TlsNioChannel$write$1)v7).L$0 = SpillingKt.nullOutSpilledVariable(arg12);
                ((TlsNioChannel$write$1)v7).L$1 = SpillingKt.nullOutSpilledVariable(arg15);
                ((TlsNioChannel$write$1)v7).L$2 = SpillingKt.nullOutSpilledVariable(v0_2);
                ((TlsNioChannel$write$1)v7).J$0 = arg13;
                ((TlsNioChannel$write$1)v7).label = v3;
                Object v11 = this.write(arg12, arg13, arg15, v7);
                if(v11 == v1_2) {
                    return v1_2;
                }

                return v11;
            }

            this.netOut.flip();
            SSLEngineResult v8 = v0_2;
            ByteBuffer v0_3 = arg12;
            SSLEngineResult v12_1 = v8;
            TimeUnit v9_1 = arg15;
            v10 = v7;
            v7_1 = arg13;
            do {
            label_102:
                if(!this.netOut.hasRemaining()) {
                    break;
                }

                TransportChannel v5_2 = this.net;
                ByteBuffer v6_1 = this.netOut;
                ((TlsNioChannel$write$1)v10).L$0 = SpillingKt.nullOutSpilledVariable(v0_3);
                ((TlsNioChannel$write$1)v10).L$1 = v9;
                ((TlsNioChannel$write$1)v10).L$2 = v12;
                ((TlsNioChannel$write$1)v10).J$0 = v7_1;
                ((TlsNioChannel$write$1)v10).label = 1;
                if(v5_2.writeExactly(v6_1, v7_1, ((TimeUnit)v9), v10) != v1_2) {
                    continue;
                }

                return v1_2;
            }
            while(true);

            v5_1 = ((SSLEngineResult)v12).bytesConsumed();
        label_117:
            return Boxing.boxInt(v5_1);
        }
        else if(v2 == 1) {
            long v2_1 = ((TlsNioChannel$write$1)v7).J$0;
            v12 = ((TlsNioChannel$write$1)v7).L$2;
            Object v5 = ((TlsNioChannel$write$1)v7).L$1;
            Object v6 = ((TlsNioChannel$write$1)v7).L$0;
            ResultKt.throwOnFailure(v0_1);
            v9 = v5;
            v0_1 = v6;
            v10 = v7;
            v7_1 = v2_1;
            goto label_102;
        }
        else if(v2 == v3) {
            ResultKt.throwOnFailure(v0_1);
            return v0_1;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return v1_2;
    }

    public Object writeExactly(ByteBuffer arg11, long arg12, TimeUnit arg14, Continuation arg15) {
        Continuation v9;
        long v6;
        TlsNioChannel v4;
        TimeUnit v8_1;
        ByteBuffer v5_1;
        int v2;
        Continuation v0;
        if((arg15 instanceof TlsNioChannel$writeExactly$1)) {
            v0 = arg15;
            v2 = 0x80000000;
            if((((TlsNioChannel$writeExactly$1)v0).label & v2) != 0) {
                ((TlsNioChannel$writeExactly$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            TlsNioChannel$writeExactly$1 v0_1 = new TlsNioChannel$writeExactly$1(this, arg15);
        }

        Object v15 = ((TlsNioChannel$writeExactly$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((TlsNioChannel$writeExactly$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v15);
            v5_1 = arg11;
            v6 = arg12;
            v8_1 = arg14;
            v9 = v0;
            goto label_38;
        label_48:
            int v10 = ((Number)v15).intValue();
            if(v10 >= 0) {
                this = v4;
            }
            else {
                throw new IOException("TLS write returned " + v10);
            }
        }
        else if(v2 == 1) {
            long v11 = ((TlsNioChannel$writeExactly$1)v0).J$0;
            Object v13 = ((TlsNioChannel$writeExactly$1)v0).L$1;
            Object v14 = ((TlsNioChannel$writeExactly$1)v0).L$0;
            ResultKt.throwOnFailure(v15);
            v4 = this;
            v6 = v11;
            Object v8 = v13;
            Object v5 = v14;
            v9 = v0;
            goto label_48;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_38:
        if(v5_1.hasRemaining()) {
            ((TlsNioChannel$writeExactly$1)v9).L$0 = v5_1;
            ((TlsNioChannel$writeExactly$1)v9).L$1 = v8_1;
            ((TlsNioChannel$writeExactly$1)v9).J$0 = v6;
            ((TlsNioChannel$writeExactly$1)v9).label = 1;
            v4 = this;
            v15 = v4.write(v5_1, v6, v8_1, v9);
            if(v15 != v1) {
                goto label_48;
            }

            return v1;
        }

        return Unit.INSTANCE;
    }
}

