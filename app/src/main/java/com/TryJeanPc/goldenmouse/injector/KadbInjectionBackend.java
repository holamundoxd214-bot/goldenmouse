package com.TryJeanPc.goldenmouse.injector;

import android.util.Log;
import com.TryJeanPc.goldenmouse.bridge.KadbBridge;
import com.TryJeanPc.goldenmouse.license.LicenseManager;
import com.TryJeanPc.goldenmouse.transport.TransportDeadline$Budget;
import com.TryJeanPc.goldenmouse.transport.TransportDeadline;
import com.flyfishxu.kadb.shell.AdbShellPacket$Exit;
import com.flyfishxu.kadb.shell.AdbShellPacket$StdError;
import com.flyfishxu.kadb.shell.AdbShellPacket$StdOut;
import com.flyfishxu.kadb.shell.AdbShellPacket;
import com.flyfishxu.kadb.shell.AdbShellStream;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001A\u00020\u000F2\b\b\u0002\u0010\u0019\u001A\u00020\u0005J\u0010\u0010\u001A\u001A\u00020\u000F2\u0006\u0010\u001B\u001A\u00020\u001CH\u0016J\u0010\u0010\u001D\u001A\u00020\u000F2\u0006\u0010\u001B\u001A\u00020\u001CH\u0016J\u0010\u0010\u001E\u001A\u00020\u000F2\u0006\u0010\u001B\u001A\u00020\u001CH\u0016J\u0006\u0010\u001F\u001A\u00020 R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000FX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\"X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\"X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\"X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\"X\u0082T¢\u0006\u0002\n\u0000¨\u0006\'"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/KadbInjectionBackend;", "Lcom/TryJeanPc/goldenmouse/injector/InjectionBackend;", "<init>", "()V", "CONTROL_TIMEOUT_MS", "", "stateLock", "", "connection", "Lcom/TryJeanPc/goldenmouse/injector/KadbInjectionBackend$Connection;", "registryIdentity", "contactRegistryIdentity", "getContactRegistryIdentity", "()Ljava/lang/Object;", "supportsAsyncMoves", "", "getSupportsAsyncMoves", "()Z", "startup", "Lcom/TryJeanPc/goldenmouse/transport/TransportDeadline;", "opening", "Ljava/util/concurrent/CompletableFuture;", "generation", "retiring", "connect", "timeoutMillis", "execute", "command", "Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;", "executeConfirmed", "executeMove", "close", "", "TAG", "", "APPLICATION_ID", "MAIN_CLASS", "START_COMMAND", "Connection", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class KadbInjectionBackend implements InjectionBackend {
    @Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001A\u00020\bH\u0016J\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0002J\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001A\u00060\nj\u0002`\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0016"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/KadbInjectionBackend$Connection;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "stream", "Lcom/flyfishxu/kadb/shell/AdbShellStream;", "<init>", "(Lcom/flyfishxu/kadb/shell/AdbShellStream;)V", "close", "", "buffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "worker", "Lcom/TryJeanPc/goldenmouse/injector/OrderedInjectionWorker;", "getWorker", "()Lcom/TryJeanPc/goldenmouse/injector/OrderedInjectionWorker;", "sendAndAwait", "", "command", "Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;", "readLine", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Connection implements AutoCloseable {
        private final StringBuilder buffer;
        private final AdbShellStream stream;
        private final OrderedInjectionWorker worker;

        public Connection(AdbShellStream arg9) {
            Intrinsics.checkNotNullParameter(arg9, "stream");
            super();
            this.stream = arg9;
            this.buffer = new StringBuilder();
            this.worker = new OrderedInjectionWorker(new KadbInjectionBackend$Connection$worker$1(this), new KadbInjectionBackend$Connection$$ExternalSyntheticLambda0(this), new KadbInjectionBackend$Connection$$ExternalSyntheticLambda1(), new KadbInjectionBackend$Connection$worker$4(InjectionDiagnostics.INSTANCE), new KadbInjectionBackend$Connection$worker$5(InjectionDiagnostics.INSTANCE), new KadbInjectionBackend$Connection$worker$6(InjectionDiagnostics.INSTANCE), new KadbInjectionBackend$Connection$worker$7(InjectionDiagnostics.INSTANCE));
        }

        public static final boolean access$sendAndAwait(Connection arg0, TouchCommand arg1) {
            return arg0.sendAndAwait(arg1);
        }

        public void close() {
            this.worker.close();
            if(this.worker.awaitStopped(2000)) {
                return;
            }

            throw new IllegalStateException("Cierre del canal KADB sin confirmar".toString());
        }

        public final OrderedInjectionWorker getWorker() {
            return this.worker;
        }

        public final String readLine() {
            int v0;
            while(true) {
                v0 = this.buffer.indexOf("\n");
                if(v0 >= 0) {
                    goto label_4;
                }

                AdbShellPacket v0_1 = this.stream.read();
                if((v0_1 instanceof StdOut)) {
                    this.buffer.append(new String(((StdOut)v0_1).getPayload(), Charsets.UTF_8));
                    continue;
                }

                if(!(v0_1 instanceof StdError)) {
                    break;
                }

                Integer.valueOf(Log.e("GOLDEN_INJECTOR", StringsKt.trim(new String(((StdError)v0_1).getPayload(), Charsets.UTF_8)).toString()));
            }

            if((v0_1 instanceof Exit)) {
                return null;
            }

            throw new NoWhenBranchMatchedException();
        label_4:
            String v1 = this.buffer.substring(0, v0);
            Intrinsics.checkNotNullExpressionValue(v1, "substring(...)");
            v1 = StringsKt.trim(((CharSequence)v1)).toString();
            this.buffer.delete(0, v0 + 1);
            return v1;
        }

        private final boolean sendAndAwait(TouchCommand arg5) {
            String v5 = arg5.getAction().ordinal() + '|' + arg5.getX() + '|' + arg5.getY() + '|' + arg5.getPointerId() + '|' + arg5.getTimestamp() + '\n';
            long v0_1 = System.nanoTime();
            this.stream.write(v5);
            InjectionDiagnostics.INSTANCE.recordWriteSample(System.nanoTime() - v0_1);
            v0_1 = System.nanoTime();
            String v4 = this.readLine();
            InjectionDiagnostics.INSTANCE.recordAckWait(System.nanoTime() - v0_1);
            if(Intrinsics.areEqual(v4, "1")) {
                return 1;
            }

            if(Intrinsics.areEqual(v4, "0")) {
                return 0;
            }

            throw new IOException("KADB ACK inválido o EOF: " + v4);
        }

        static final Unit worker$lambda$3(Connection arg2) {
            try {
                arg2.stream.closeStdin();
                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v0) {
                Result.constructor-impl(ResultKt.createFailure(v0));
            }

            try {
                arg2.stream.close();
                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v2) {
                Result.constructor-impl(ResultKt.createFailure(v2));
            }

            return Unit.INSTANCE;
        }

        static final Unit worker$lambda$4(Throwable arg2) {
            Intrinsics.checkNotNullParameter(arg2, "it");
            Log.e("GOLDEN_INJECTOR", "Se perdió el backend de inyección KADB", arg2);
            return Unit.INSTANCE;
        }
    }

    public static final int $stable = 0;
    private static final String APPLICATION_ID = "com.TryJeanPc.goldenmouse";
    private static final long CONTROL_TIMEOUT_MS = 2000;
    public static final KadbInjectionBackend INSTANCE = null;
    private static final String MAIN_CLASS = "com.TryJeanPc.goldenmouse.injector.KadbTouchServiceMain";
    private static final String START_COMMAND = "APK_PATH=$(pm path com.TryJeanPc.goldenmouse | head -n 1 | cut -d: -f2); export CLASSPATH=$APK_PATH; exec app_process /system/bin com.TryJeanPc.goldenmouse.injector.KadbTouchServiceMain";
    private static final String TAG = "GOLDEN_INJECTOR";
    private static Connection connection;
    private static long generation;
    private static CompletableFuture opening;
    private static volatile Object registryIdentity;
    private static Connection retiring;
    private static final TransportDeadline startup;
    private static final Object stateLock;
    private static final boolean supportsAsyncMoves;

    static {
        KadbInjectionBackend.INSTANCE = new KadbInjectionBackend();
        KadbInjectionBackend.stateLock = new Object();
        KadbInjectionBackend.registryIdentity = new Object();
        KadbInjectionBackend.supportsAsyncMoves = true;
        KadbInjectionBackend.startup = new TransportDeadline("GoldenKadbStart");
        KadbInjectionBackend.$stable = 8;
    }

    private KadbInjectionBackend() {
        super();
    }

    public final void close() {
        Connection v0_1;
        Object v4 = KadbInjectionBackend.stateLock;
        __monitor_enter(v4);
        try {
            ++KadbInjectionBackend.generation;
            v0_1 = KadbInjectionBackend.connection;
            KadbInjectionBackend.connection = null;
            if(v0_1 != null) {
                KadbInjectionBackend.retiring = v0_1;
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v4);
            throw v0;
        }

        __monitor_exit(v4);
        if(v0_1 != null) {
            OrderedInjectionWorker v4_1 = v0_1.getWorker();
            if(v4_1 != null) {
                v4_1.close();
            }
        }
    }

    public final boolean connect(long arg10) {
        OrderedInjectionWorker v9_4;
        AutoCloseable v9_3;
        Boolean v9_2;
        Object v9_1;
        Connection v4;
        boolean v3;
        OrderedInjectionWorker v1_1;
        boolean v2;
        Connection v1;
        Budget v0 = new Budget(arg10);
        ObjectRef v10 = new ObjectRef();
        Object v11 = KadbInjectionBackend.stateLock;
        __monitor_enter(v11);
        try {
            v1 = KadbInjectionBackend.connection;
            v2 = true;
            if(v1 != null) {
                v1_1 = v1.getWorker();
                if(v1_1 != null && (v1_1.isAlive())) {
                    goto label_13;
                }
            }

            goto label_15;
        }
        catch(Throwable v9) {
            goto label_167;
        }

    label_13:
        __monitor_exit(v11);
        return 1;
        try {
        label_15:
            v1 = KadbInjectionBackend.retiring;
            v3 = false;
            if(v1 != null) {
                v1_1 = v1.getWorker();
                if(v1_1 != null && !v1_1.isTerminated()) {
                    goto label_22;
                }
            }

            goto label_24;
        }
        catch(Throwable v9) {
            goto label_167;
        }

    label_22:
        __monitor_exit(v11);
        return 0;
        try {
        label_24:
            v1 = KadbInjectionBackend.connection;
            v4 = null;
            if(v1 != null) {
                if(!v1.getWorker().isTerminated()) {
                    goto label_30;
                }
                else {
                    goto label_32;
                }
            }

            goto label_33;
        }
        catch(Throwable v9) {
            goto label_167;
        }

    label_30:
        __monitor_exit(v11);
        return 0;
        try {
        label_32:
            KadbInjectionBackend.connection = v4;
        label_33:
            long v5 = KadbInjectionBackend.generation;
            CompletableFuture v1_2 = KadbInjectionBackend.opening;
            int v7 = v1_2 == null ? 1 : 0;
            if(v1_2 == null) {
                v1_2 = new CompletableFuture();
                KadbInjectionBackend.opening = v1_2;
            }

            v10.element = v1_2;
        }
        catch(Throwable v9) {
        label_167:
            __monitor_exit(v11);
            throw v9;
        }

        __monitor_exit(v11);
        if(v7 == 0) {
            try {
                v9_1 = Result.constructor-impl(v10.element.get(v0.remainingMillis(), TimeUnit.MILLISECONDS));
            }
            catch(Throwable v9) {
                v9_1 = Result.constructor-impl(ResultKt.createFailure(v9));
            }

            Boolean v10_1 = Boolean.valueOf(false);
            if(Result.isFailure-impl(v9_1)) {
                v9_2 = v10_1;
            }

            return v9_2.booleanValue();
        }

        try {
            v9_3 = KadbInjectionBackend.startup.open(v0.remainingMillis(), new KadbInjectionBackend$$ExternalSyntheticLambda0(), new KadbInjectionBackend$$ExternalSyntheticLambda1());
        }
        catch(Throwable v11_1) {
            v9_3 = ((AutoCloseable)v4);
            goto label_146;
        }
        catch(Exception v11_2) {
            v9_3 = ((AutoCloseable)v4);
            goto label_122;
        }

        try {
            __monitor_enter(v11);
        }
        catch(Throwable v11_1) {
            goto label_146;
        }
        catch(Exception v11_2) {
            goto label_116;
        }

        try {
            if(KadbInjectionBackend.generation == v5) {
                KadbInjectionBackend.connection = v9_3;
                KadbInjectionBackend.registryIdentity = v9_3;
                v9_3.getWorker().start();
            }
            else {
                goto label_81;
            }

            goto label_82;
        }
        catch(Throwable v0_1) {
            goto label_113;
        }

    label_81:
        v2 = false;
    label_82:
        goto label_83;
        v3 = v2;
        try {
        label_113:
            __monitor_exit(v11);
            throw v0_1;
        }
        catch(Throwable v11_1) {
        }
        catch(Exception v11_2) {
        label_116:
            goto label_122;
            try {
            label_83:
                __monitor_exit(v11);
                if(v2) {
                    goto label_89;
                }

                goto label_85;
            }
            catch(Throwable v11_1) {
                v3 = v2;
            }
            catch(Exception v11_2) {
                v3 = v2;
                try {
                label_122:
                    Log.e("GOLDEN_INJECTOR", "No se pudo abrir KADB dentro del plazo completo", ((Throwable)v11_2));
                    if(v3) {
                        goto label_130;
                    }
                }
                catch(Throwable v11_1) {
                    goto label_146;
                }

                if(v9_3 != null) {
                    v9_4 = ((Connection)v9_3).getWorker();
                    if(v9_4 != null) {
                        v9_4.close();
                    }
                }

            label_130:
                v9_1 = KadbInjectionBackend.stateLock;
                __monitor_enter(v9_1);
                try {
                    if(KadbInjectionBackend.opening == v10.element) {
                        KadbInjectionBackend.opening = ((CompletableFuture)v4);
                    }
                }
                catch(Throwable v10_2) {
                    __monitor_exit(v9_1);
                    throw v10_2;
                }

                __monitor_exit(v9_1);
                v10.element.complete(Boolean.valueOf(v3));
                return v3;
            }
        }

    label_146:
        if(!v3 && v9_3 != null) {
            v9_4 = ((Connection)v9_3).getWorker();
            if(v9_4 != null) {
                v9_4.close();
            }
        }

        v9_1 = KadbInjectionBackend.stateLock;
        __monitor_enter(v9_1);
        try {
            if(KadbInjectionBackend.opening == v10.element) {
                KadbInjectionBackend.opening = ((CompletableFuture)v4);
            }
        }
        catch(Throwable v10_2) {
            __monitor_exit(v9_1);
            throw v10_2;
        }

        __monitor_exit(v9_1);
        v10.element.complete(Boolean.valueOf(v3));
        throw v11_1;
    label_85:
        if(v9_3 != null) {
            v9_4 = ((Connection)v9_3).getWorker();
            if(v9_4 == null) {
                goto label_89;
            }

            v9_4.close();
        }

    label_89:
        __monitor_enter(v11);
        try {
            if(KadbInjectionBackend.opening == v10.element) {
                KadbInjectionBackend.opening = ((CompletableFuture)v4);
            }
        }
        catch(Throwable v9) {
            __monitor_exit(v11);
            throw v9;
        }

        __monitor_exit(v11);
        v10.element.complete(Boolean.valueOf(v2));
        return v2;
    }

    public static boolean connect$default(KadbInjectionBackend arg0, long arg1, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = 2000;
        }

        return arg0.connect(arg1);
    }

    static final Connection connect$lambda$6() {
        if(LicenseManager.authorizeSession()) {
            if(KadbBridge.INSTANCE.estaConectado()) {
                return new Connection(KadbBridge.INSTANCE.abrirShell("APK_PATH=$(pm path com.TryJeanPc.goldenmouse | head -n 1 | cut -d: -f2); export CLASSPATH=$APK_PATH; exec app_process /system/bin com.TryJeanPc.goldenmouse.injector.KadbTouchServiceMain"));
            }

            throw new IllegalStateException("KADB desconectado".toString());
        }

        throw new IllegalStateException("Licencia de Golden no autorizada".toString());
    }

    static final Unit connect$lambda$8(Connection arg4) {
        Intrinsics.checkNotNullParameter(arg4, "it");
        String v4 = arg4.readLine();
        if(v4 != null && (StringsKt.startsWith$default(v4, "GOLDEN_TOUCH_READY", false, 2, null))) {
            return Unit.INSTANCE;
        }

        throw new IllegalStateException("READY KADB inválido".toString());
    }

    public boolean execute(TouchCommand arg3) {
        Intrinsics.checkNotNullParameter(arg3, "command");
        if(arg3.getAction() == Action.ACTION_MOVE) {
            return this.executeMove(arg3);
        }

        return this.executeConfirmed(arg3);
    }

    public boolean executeConfirmed(TouchCommand arg9) {
        boolean v8_2;
        Connection v5;
        String v0 = "Timeout/error esperando confirmación KADB para ";
        Intrinsics.checkNotNullParameter(arg9, "command");
        long v1 = System.nanoTime();
        InjectionDiagnostics.INSTANCE.recordExecute();
        Budget v3 = new Budget(2000);
        if(!this.connect(v3.remainingMillis())) {
            return 0;
        }

        Object v8 = KadbInjectionBackend.stateLock;
        __monitor_enter(v8);
        try {
            v5 = KadbInjectionBackend.connection;
        }
        catch(Throwable v9) {
            __monitor_exit(v8);
            throw v9;
        }

        __monitor_exit(v8);
        if(v5 == null) {
            return 0;
        }

        try {
            v8 = v5.getWorker().offerControl(arg9).get(v3.remainingMillis(), TimeUnit.MILLISECONDS);
            Intrinsics.checkNotNull(v8);
            v8_2 = ((Boolean)v8).booleanValue();
        }
        catch(Throwable v8_1) {
            try {
                Log.e("GOLDEN_INJECTOR", v0 + arg9.getAction(), v8_1);
                v5.getWorker().close();
            }
            catch(Throwable v8_1) {
                InjectionDiagnostics.INSTANCE.recordExecute(System.nanoTime() - v1);
                throw v8_1;
            }

            InjectionDiagnostics.INSTANCE.recordExecute(System.nanoTime() - v1);
            return 0;
        }

        InjectionDiagnostics.INSTANCE.recordExecute(System.nanoTime() - v1);
        return v8_2;
    }

    public boolean executeMove(TouchCommand arg7) {
        Connection v3;
        Object v6_1;
        Intrinsics.checkNotNullParameter(arg7, "command");
        long v0 = System.nanoTime();
        InjectionDiagnostics.INSTANCE.recordExecute();
        long v2 = 0;
        Object v4 = null;
        boolean v5 = true;
        try {
            if(KadbInjectionBackend.connect$default(this, v2, 1, v4)) {
                v6_1 = KadbInjectionBackend.stateLock;
                __monitor_enter(v6_1);
            }
            else {
                goto label_11;
            }
        }
        catch(Throwable v6) {
            goto label_34;
        }

        try {
            v3 = KadbInjectionBackend.connection;
            goto label_16;
        }
        catch(Throwable v7) {
            try {
                __monitor_exit(v6_1);
                throw v7;
            label_16:
                __monitor_exit(v6_1);
                if(v3 != null) {
                    OrderedInjectionWorker v6_2 = v3.getWorker();
                    if(v6_2 == null) {
                        goto label_11;
                    }
                    else if(!v6_2.offerMove(arg7)) {
                        goto label_11;
                    }
                }
                else {
                label_11:
                    v5 = false;
                }
            }
            catch(Throwable v6) {
            label_34:
                v2 = System.nanoTime() - v0;
                InjectionDiagnostics.INSTANCE.recordExecute(v2);
                InjectionDiagnostics.INSTANCE.recordMoveExecute(v2);
                throw v6;
            }
        }

        long v6_3 = System.nanoTime() - v0;
        InjectionDiagnostics.INSTANCE.recordExecute(v6_3);
        InjectionDiagnostics.INSTANCE.recordMoveExecute(v6_3);
        return v5;
    }

    public long getConfirmedCancelEpoch() {
        return InjectionBackend.super.getConfirmedCancelEpoch();
    }

    public Object getContactRegistryIdentity() {
        return KadbInjectionBackend.registryIdentity;
    }

    public boolean getSupportsAsyncMoves() {
        return KadbInjectionBackend.supportsAsyncMoves;
    }
}

