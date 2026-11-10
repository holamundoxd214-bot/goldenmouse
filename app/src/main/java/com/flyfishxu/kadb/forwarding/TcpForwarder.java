package com.flyfishxu.kadb.forwarding;

import com.flyfishxu.kadb.Kadb;
import com.flyfishxu.kadb.debug.LoggingKt;
import com.flyfishxu.kadb.stream.AdbStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\"B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0012\u001A\u00020\u0013J\b\u0010\u0014\u001A\u00020\u0013H\u0002J\b\u0010\u0015\u001A\u00020\u0013H\u0016J\u0018\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0002J\u0010\u0010\u001B\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u000BH\u0002J&\u0010\u001C\u001A\u00020\u00132\u0006\u0010\u001D\u001A\u00020\u00062\u0006\u0010\u001E\u001A\u00020\u00062\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020!0 H\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0003"}, d2={"Lcom/flyfishxu/kadb/forwarding/TcpForwarder;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "kadb", "Lcom/flyfishxu/kadb/Kadb;", "hostPort", "", "targetPort", "<init>", "(Lcom/flyfishxu/kadb/Kadb;II)V", "state", "Lcom/flyfishxu/kadb/forwarding/TcpForwarder$State;", "serverThread", "Ljava/lang/Thread;", "server", "Ljava/net/ServerSocket;", "clientExecutor", "Ljava/util/concurrent/ExecutorService;", "start", "", "handleForwarding", "close", "forward", "source", "Lokio/Source;", "sink", "Lokio/BufferedSink;", "moveToState", "waitFor", "intervalMs", "timeoutMs", "test", "Lkotlin/Function0;", "", "State"}, k=1, mv={2, 3, 0}, xi=0x30) public final class TcpForwarder implements AutoCloseable {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/flyfishxu/kadb/forwarding/TcpForwarder$State;", "", "<init>", "(Ljava/lang/String;I)V", "STARTING", "STARTED", "STOPPING", "STOPPED", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) enum State {
        public static final enum State STARTED;
        public static final enum State STARTING;
        public static final enum State STOPPED;
        public static final enum State STOPPING;

        private static final State[] $values() {
            return new State[]{State.STARTING, State.STARTED, State.STOPPING, State.STOPPED};
        }

        static {
            State.STARTING = new State("STARTING", 0);
            State.STARTED = new State("STARTED", 1);
            State.STOPPING = new State("STOPPING", 2);
            State.STOPPED = new State("STOPPED", 3);
            State[] v0 = State.$values();
            State.$VALUES = v0;
            State.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private State(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return State.$ENTRIES;
        }

        public static State valueOf(String arg1) {
            return Enum.valueOf(State.class, arg1);
        }

        public static State[] values() {
            return State.$VALUES.clone();
        }
    }

    private ExecutorService clientExecutor;
    private final int hostPort;
    private final Kadb kadb;
    private ServerSocket server;
    private Thread serverThread;
    private State state;
    private final int targetPort;

    public static String $r8$lambda$ZeBdXx-JSQB64tiPtzGulAzZ2E4(IOException arg0) {
        return TcpForwarder.start$lambda$1$0(arg0);
    }

    public static Unit $r8$lambda$ys02MDOLYPXSfrYhhW_00_63nMU(TcpForwarder arg0, Socket arg1, AdbStream arg2) {
        return TcpForwarder.handleForwarding$lambda$0$0(arg0, arg1, arg2);
    }

    public TcpForwarder(Kadb arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "kadb");
        super();
        this.kadb = arg2;
        this.hostPort = arg3;
        this.targetPort = arg4;
        this.state = State.STOPPED;
    }

    public void close() {
        if(this.state != State.STOPPED) {
            if(this.state == State.STOPPING) {
            }
            else {
                int v1 = 10;
                int v2 = 5000;
                this.waitFor(v1, v2, new TcpForwarder$$ExternalSyntheticLambda3(this));
                this.moveToState(State.STOPPING);
                ServerSocket v0 = this.server;
                if(v0 != null) {
                    v0.close();
                }

                v0 = null;
                this.server = v0;
                Thread v3 = this.serverThread;
                if(v3 != null) {
                    v3.interrupt();
                }

                this.serverThread = ((Thread)v0);
                ExecutorService v3_1 = this.clientExecutor;
                if(v3_1 != null) {
                    v3_1.shutdown();
                }

                v3_1 = this.clientExecutor;
                if(v3_1 != null) {
                    v3_1.awaitTermination(5, TimeUnit.SECONDS);
                }

                this.clientExecutor = ((ExecutorService)v0);
                this.waitFor(v1, v2, new TcpForwarder$$ExternalSyntheticLambda4(this));
            }
        }
    }

    static final boolean close$lambda$0(TcpForwarder arg1) {
        if(arg1.state == State.STARTED) {
            return 1;
        }

        return 0;
    }

    static final boolean close$lambda$1(TcpForwarder arg1) {
        if(arg1.state == State.STOPPED) {
            return 1;
        }

        return 0;
    }

    private final void forward(Source arg5, BufferedSink arg6) {
        try {
            while(true) {
                if(!Thread.interrupted() && arg5.read(arg6.getBuffer(), 0x100) >= 0) {
                    arg6.flush();
                    continue;
                }

                return;
            }
        }
        catch(InterruptedIOException ) {
            return;
        }
    }

    private final void handleForwarding() {
        ServerSocket v0 = new ServerSocket(this.hostPort);
        this.server = v0;
        this.moveToState(State.STARTED);
        while(!Thread.interrupted()) {
            Socket v1 = v0.accept();
            ExecutorService v2 = this.clientExecutor;
            if(v2 == null) {
                continue;
            }

            v2.execute(new TcpForwarder$$ExternalSyntheticLambda0(this, v1));
        }
    }

    static final void handleForwarding$lambda$0(TcpForwarder arg11, Socket arg12) {
        Thread v1_1;
        Thread v0_2;
        Throwable v11;
        AdbStream v2;
        String v0 = "tcp:";
        AdbStream v1 = null;
        try {
            v2 = arg11.kadb.open(v0 + arg11.targetPort);
        }
        catch(Throwable v0_1) {
            v11 = v0_1;
            v0_2 = ((Thread)v1);
            goto label_38;
        }

        try {
            v1_1 = ThreadsKt.thread$default(false, false, null, null, 0, new TcpForwarder$$ExternalSyntheticLambda2(arg11, arg12, v2), 0x1F, null);
            BufferedSource v0_3 = v2.getSource();
            Intrinsics.checkNotNull(arg12);
            arg11.forward(((Source)v0_3), Okio.buffer(Okio.sink(arg12)));
            if(v2 == null) {
                goto label_26;
            }

            goto label_25;
        }
        catch(Throwable v0_1) {
            v11 = v0_1;
            v0_2 = v1_1;
            v1 = v2;
        }

    label_38:
        if(v1 != null) {
            v1.close();
        }

        arg12.close();
        if(v0_2 != null) {
            v0_2.interrupt();
        }

        throw v11;
    label_25:
        v2.close();
    label_26:
        arg12.close();
        if(v1_1 != null) {
            v1_1.interrupt();
        }
    }

    private static final Unit handleForwarding$lambda$0$0(TcpForwarder arg1, Socket arg2, AdbStream arg3) {
        try {
            InputStream v2 = arg2.getInputStream();
            Intrinsics.checkNotNullExpressionValue(v2, "getInputStream(...)");
            arg1.forward(Okio.source(v2), arg3.getSink());
        }
        catch(Throwable v1) {
            arg3.close();
            throw v1;
        }

        arg3.close();
        return Unit.INSTANCE;
    }

    private final void moveToState(State arg1) {
        this.state = arg1;
    }

    public final void start() {
        if(this.state == State.STOPPED) {
            this.moveToState(State.STARTING);
            this.clientExecutor = Executors.newCachedThreadPool();
            this.serverThread = ThreadsKt.thread$default(false, false, null, null, 0, new TcpForwarder$$ExternalSyntheticLambda5(this), 0x1F, null);
            this.waitFor(10, 5000, new TcpForwarder$$ExternalSyntheticLambda6(this));
            return;
        }

        throw new IllegalStateException("Forwarder is already started at port " + this.hostPort.toString());
    }

    static final Unit start$lambda$1(TcpForwarder arg2) {
        try {
            arg2.handleForwarding();
            goto label_1;
        }
        catch(SocketException ) {
        label_1:
            arg2.moveToState(State.STOPPED);
            return Unit.INSTANCE;
        }
        catch(Throwable v0) {
        }
        catch(IOException v0_1) {
            try {
                LoggingKt.log(new TcpForwarder$$ExternalSyntheticLambda1(v0_1));
                goto label_1;
            }
            catch(Throwable v0) {
                arg2.moveToState(State.STOPPED);
                throw v0;
            }
        }
    }

    private static final String start$lambda$1$0(IOException arg2) {
        return "could not start TCP port forwarding: " + arg2.getMessage();
    }

    static final boolean start$lambda$2(TcpForwarder arg1) {
        if(arg1.state == State.STARTED) {
            return 1;
        }

        return 0;
    }

    private final void waitFor(int arg11, int arg12, Function0 arg13) {
        long v0 = System.currentTimeMillis();
        long v2;
        for(v2 = v0; !arg13.invoke().booleanValue(); v2 = System.currentTimeMillis()) {
            long v4 = System.currentTimeMillis();
            long v6 = v4 - v0;
            v4 -= v2;
            v2 = ((long)arg12);
            long v8 = 0;
            if(v8 <= v2) {
                if(v2 > v6) {
                }
                else {
                    throw new TimeoutException();
                }
            }

            v2 = (((long)arg11)) - v4;
            if(v2 > v8) {
                Thread.sleep(v2);
            }
        }
    }
}

