package com.TryJeanPc.goldenmouse.graphics;

import com.flyfishxu.kadb.shell.AdbShellPacket$Exit;
import com.flyfishxu.kadb.shell.AdbShellPacket$StdError;
import com.flyfishxu.kadb.shell.AdbShellPacket$StdOut;
import com.flyfishxu.kadb.shell.AdbShellPacket;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J<\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u00112\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00160\u0013J\u0018\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsCommandRunner;", "", "worker", "Ljava/util/concurrent/ExecutorService;", "timeoutMillis", "", "<init>", "(Ljava/util/concurrent/ExecutorService;J)V", "occupied", "Ljava/util/concurrent/atomic/AtomicBoolean;", "run", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsResponse;", "command", "", "shizuku", "", "audit", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttemptLog;", "openProcess", "Lkotlin/Function0;", "Ljava/lang/Process;", "openShell", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsShellChannel;", "drain", "", "input", "Ljava/io/InputStream;", "sink", "Ljava/io/ByteArrayOutputStream;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsCommandRunner {
    public static final int $stable = 8;
    private final AtomicBoolean occupied;
    private final long timeoutMillis;
    private final ExecutorService worker;

    static {
    }

    public GraphicsCommandRunner(ExecutorService arg1, long arg2, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = Executors.newSingleThreadExecutor(new GraphicsCommandRunner$$ExternalSyntheticLambda6());
            Intrinsics.checkNotNullExpressionValue(arg1, "newSingleThreadExecutor(...)");
        }

        if((arg4 & 2) != 0) {
            arg2 = 8000;
        }

        this(arg1, arg2);
    }

    public GraphicsCommandRunner() {
        this(null, 0, 3, null);
    }

    public GraphicsCommandRunner(ExecutorService arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg2, "worker");
        super();
        this.worker = arg2;
        this.timeoutMillis = arg3;
        this.occupied = new AtomicBoolean(false);
    }

    static final Thread _init_$lambda$1(Runnable arg2) {
        Thread v0 = new Thread(arg2, "GoldenGraphicsShell");
        v0.setDaemon(true);
        return v0;
    }

    private final void drain(InputStream arg5, ByteArrayOutputStream arg6) {
        try {
            InputStream v4_1 = arg5;
            byte[] v0 = new byte[0x800];
            while(true) {
                int v1 = v4_1.read(v0);
                if(v1 < 0) {
                    goto label_17;
                }

                if(arg6.size() + v1 > 0x18000) {
                    break;
                }

                arg6.write(v0, 0, v1);
            }

            throw new IllegalStateException("Salida excesiva del comando".toString());
        label_17:
        }
        catch(Throwable v4) {
            goto label_22;
        }

        CloseableKt.closeFinally(((Closeable)arg5), null);
        return;
        try {
        label_22:
            throw v4;
        }
        catch(Throwable v6) {
            CloseableKt.closeFinally(((Closeable)arg5), v4);
            throw v6;
        }
    }

    public final GraphicsResponse run(String arg13, boolean arg14, GraphicsAttemptLog arg15, Function0 arg16, Function0 arg17) {
        String v14_2;
        Future v13;
        String v0 = "exit=";
        Intrinsics.checkNotNullParameter(arg13, "command");
        Function0 v4 = arg16;
        Intrinsics.checkNotNullParameter(v4, "openProcess");
        Function0 v8 = arg17;
        Intrinsics.checkNotNullParameter(v8, "openShell");
        if(this.occupied.compareAndSet(false, true)) {
            AtomicReference v5 = new AtomicReference(null);
            try {
                v13 = this.worker.submit(new GraphicsCommandRunner$$ExternalSyntheticLambda7(arg14, v4, v5, arg15, arg13, v8, this));
            }
            catch(Exception v0_1) {
                this.occupied.set(false);
                throw v0_1;
            }

            try {
                Object v13_1 = v13.get(this.timeoutMillis, TimeUnit.MILLISECONDS);
                Object v14 = v13_1;
                if(arg15 != null) {
                    arg15.event("RESULTADO", v0 + ((GraphicsResponse)v14).getExit() + " stdout=" + StringsKt.take(((GraphicsResponse)v14).getOut(), 200) + " stderr=" + StringsKt.take(((GraphicsResponse)v14).getError(), 200));
                }

                Intrinsics.checkNotNull(v13_1);
                return ((GraphicsResponse)v13_1);
            }
            catch(Exception v0_1) {
                Exception v12 = v0_1;
                Throwable v14_1 = v12.getCause();
                if(v14_1 != null) {
                    v14_2 = v14_1.getMessage();
                    if(v14_2 == null) {
                        goto label_57;
                    }
                }
                else {
                label_57:
                    v14_2 = v12.getMessage();
                    if(v14_2 == null) {
                        v14_2 = "Fallo de transporte; resultado incierto";
                    }
                }

                throw new GraphicsUncertain(v14_2);
            }
            catch(TimeoutException ) {
                Thread v13_2 = new Thread(new GraphicsCommandRunner$$ExternalSyntheticLambda8(this, v5), "GoldenGraphicsClose");
                v13_2.setDaemon(true);
                v13_2.start();
                throw new GraphicsUncertain("Tiempo agotado; resultado remoto incierto. No se reintenta ni cambia de backend.");
            }
        }

        throw new IllegalStateException("Un canal gráfico anterior aún no terminó".toString());
    }

    static final GraphicsResponse run$lambda$15(boolean arg14, Function0 arg15, AtomicReference arg16, GraphicsAttemptLog arg17, String arg18, Function0 arg19, GraphicsCommandRunner arg20) {
        AdbShellPacket v2_3;
        int v0_4;
        Throwable v14_2;
        GraphicsResponse v2_2;
        String v1_2;
        String v0_3;
        int v14_1;
        ByteArrayOutputStream v1_1;
        ByteArrayOutputStream v0_2;
        long v12;
        GraphicsCommandRunner$$ExternalSyntheticLambda9 v5_1;
        Object v14;
        AtomicReference v0 = arg16;
        GraphicsAttemptLog v1 = arg17;
        String v2 = arg18;
        GraphicsCommandRunner v3 = arg20;
        String v4 = "Shizuku newProcess: ";
        String v5 = "KADB shell-v2: ";
        String v6 = "ENVIADO";
        ExecutorService v7 = null;
        String v8 = "toString(...)";
        String v9 = "UTF-8";
        if(!arg14) {
            goto label_111;
        }

        try {
            v14 = arg15.invoke();
            v5_1 = new GraphicsCommandRunner$$ExternalSyntheticLambda9(((Process)v14));
            v0.set(v5_1);
            v12 = 1;
            if(v1 != null) {
                goto label_19;
            }

            goto label_24;
        }
        catch(Throwable v0_1) {
            goto label_191;
        }

        try {
        label_19:
            v1.event(v6, v4 + v2);
        label_24:
            v0_2 = new ByteArrayOutputStream();
            v1_1 = new ByteArrayOutputStream();
            v7 = Executors.newFixedThreadPool(2, new GraphicsCommandRunner$$ExternalSyntheticLambda10());
            Future v2_1 = v7.submit(new GraphicsCommandRunner$$ExternalSyntheticLambda11(v3, ((Process)v14), v0_2));
            Future v4_1 = v7.submit(new GraphicsCommandRunner$$ExternalSyntheticLambda1(v3, ((Process)v14), v1_1));
            v14_1 = ((Process)v14).waitFor();
            v2_1.get();
            v4_1.get();
            v0_3 = v0_2.toString(v9);
            Intrinsics.checkNotNullExpressionValue(v0_3, v8);
            v1_2 = v1_1.toString(v9);
            Intrinsics.checkNotNullExpressionValue(v1_2, v8);
            v2_2 = new GraphicsResponse(v0_3, v1_2, v14_1);
        }
        catch(Throwable v0_1) {
            v14_2 = v0_1;
            try {
                ((Function0)v5_1).invoke();
                if(v7 == null) {
                    goto label_94;
                }

                goto label_82;
            }
            catch(Throwable v0_1) {
                try {
                    v14_2 = v0_1;
                    if(v7 == null) {
                        goto label_110;
                    }

                    v7.shutdownNow();
                    v0_4 = 0;
                    while(!v7.isTerminated()) {
                        try {
                            v7.awaitTermination(v12, TimeUnit.SECONDS);
                        }
                        catch(InterruptedException ) {
                            v0_4 = 1;
                        }
                    }
                }
                catch(Throwable v0_1) {
                    goto label_191;
                }

                if(v0_4 == 0) {
                    goto label_110;
                }

                try {
                    Thread.currentThread().interrupt();
                label_110:
                    throw v14_2;
                label_82:
                    v7.shutdownNow();
                    v0_4 = 0;
                    while(!v7.isTerminated()) {
                        try {
                            v7.awaitTermination(v12, TimeUnit.SECONDS);
                        }
                        catch(InterruptedException ) {
                            v0_4 = 1;
                        }
                    }
                }
                catch(Throwable v0_1) {
                    goto label_191;
                }
            }

            if(v0_4 == 0) {
                goto label_94;
            }

            try {
                Thread.currentThread().interrupt();
            label_94:
                throw v14_2;
            }
            catch(Throwable v0_1) {
                goto label_191;
            }
        }

        try {
            ((Function0)v5_1).invoke();
            if(v7 == null) {
                goto label_182;
            }

            goto label_49;
        }
        catch(Throwable v0_1) {
            try {
                v14_2 = v0_1;
                if(v7 == null) {
                    goto label_77;
                }

                v7.shutdownNow();
                v0_4 = 0;
                while(!v7.isTerminated()) {
                    try {
                        v7.awaitTermination(v12, TimeUnit.SECONDS);
                    }
                    catch(InterruptedException ) {
                        v0_4 = 1;
                    }
                }
            }
            catch(Throwable v0_1) {
                goto label_191;
            }

            if(v0_4 == 0) {
                goto label_77;
            }

            try {
                Thread.currentThread().interrupt();
            label_77:
                throw v14_2;
            label_49:
                v7.shutdownNow();
                v14_1 = 0;
                while(!v7.isTerminated()) {
                    try {
                        v7.awaitTermination(v12, TimeUnit.SECONDS);
                    }
                    catch(InterruptedException ) {
                        v14_1 = 1;
                    }
                }
            }
            catch(Throwable v0_1) {
                goto label_191;
            }
        }

        if(v14_1 != 0) {
            try {
                Thread.currentThread().interrupt();
                goto label_182;
            label_111:
                v14 = arg19.invoke();
                v0.set(new GraphicsCommandRunner$$ExternalSyntheticLambda2(((GraphicsShellChannel)v14)));
                if(v1 != null) {
                    goto label_116;
                }

                goto label_121;
            }
            catch(Throwable v0_1) {
                goto label_191;
            }

            try {
            label_116:
                v1.event(v6, v5 + v2);
            label_121:
                v0_2 = new ByteArrayOutputStream();
                v1_1 = new ByteArrayOutputStream();
                while(true) {
                label_125:
                    if((((Integer)v7)) != null) {
                        goto label_174;
                    }

                    v2_3 = ((GraphicsShellChannel)v14).read();
                    boolean v4_2 = v2_3 instanceof StdOut;
                    break;
                }
            }
            catch(Throwable v0_1) {
                goto label_186;
            }

            int v5_2 = 0x18000;
            v6 = "Check failed.";
            if(!v4_2) {
                goto label_143;
            }

            try {
                if(v0_2.size() + v2_3.getPayload().length <= v5_2) {
                    v0_2.write(((StdOut)v2_3).getPayload());
                    goto label_125;
                }

                throw new IllegalStateException(v6);
            label_143:
                if((v2_3 instanceof StdError)) {
                    if(v1_1.size() + v2_3.getPayload().length <= v5_2) {
                        v1_1.write(((StdError)v2_3).getPayload());
                        goto label_125;
                    }

                    throw new IllegalStateException(v6);
                }

                if((v2_3 instanceof Exit)) {
                    if(v2_3.getPayload().length == 1) {
                        Integer v7_1 = Integer.valueOf(((Exit)v2_3).getPayload()[0] & 0xFF);
                        goto label_125;
                    }

                    throw new IllegalStateException(v6);
                }

                throw new NoWhenBranchMatchedException();
            label_174:
                v0_3 = v0_2.toString(v9);
                Intrinsics.checkNotNullExpressionValue(v0_3, v8);
                v1_2 = v1_1.toString(v9);
                Intrinsics.checkNotNullExpressionValue(v1_2, v8);
                v2_2 = new GraphicsResponse(v0_3, v1_2, ((Number)v7).intValue());
            }
            catch(Throwable v0_1) {
                goto label_186;
            }

            try {
                ((GraphicsShellChannel)v14).close();
            }
            catch(Throwable v0_1) {
                goto label_191;
            }
        }

    label_182:
        v3.occupied.set(false);
        return v2_2;
        try {
        label_186:
            ((GraphicsShellChannel)v14).close();
            throw v0_1;
        }
        catch(Throwable v0_1) {
        label_191:
            v3.occupied.set(false);
            throw v0_1;
        }
    }

    static final Thread run$lambda$15$lambda$10(Runnable arg2) {
        Thread v0 = new Thread(arg2, "GoldenGraphicsOutput");
        v0.setDaemon(true);
        return v0;
    }

    static final void run$lambda$15$lambda$11(GraphicsCommandRunner arg1, Process arg2, ByteArrayOutputStream arg3) {
        InputStream v2 = arg2.getInputStream();
        Intrinsics.checkNotNullExpressionValue(v2, "getInputStream(...)");
        arg1.drain(v2, arg3);
    }

    static final void run$lambda$15$lambda$12(GraphicsCommandRunner arg1, Process arg2, ByteArrayOutputStream arg3) {
        InputStream v2 = arg2.getErrorStream();
        Intrinsics.checkNotNullExpressionValue(v2, "getErrorStream(...)");
        arg1.drain(v2, arg3);
    }

    static final Unit run$lambda$15$lambda$14(GraphicsShellChannel arg0) {
        arg0.close();
        return Unit.INSTANCE;
    }

    static final Unit run$lambda$15$lambda$8(Process arg2) {
        ObjectRef v0 = new ObjectRef();
        GraphicsCommandRunner.run$lambda$15$lambda$8$attempt(v0, new GraphicsCommandRunner$$ExternalSyntheticLambda0(arg2));
        GraphicsCommandRunner.run$lambda$15$lambda$8$attempt(v0, new GraphicsCommandRunner$$ExternalSyntheticLambda3(arg2));
        GraphicsCommandRunner.run$lambda$15$lambda$8$attempt(v0, new GraphicsCommandRunner$$ExternalSyntheticLambda4(arg2));
        GraphicsCommandRunner.run$lambda$15$lambda$8$attempt(v0, new GraphicsCommandRunner$$ExternalSyntheticLambda5(arg2));
        Object v2 = v0.element;
        if(v2 == null) {
            return Unit.INSTANCE;
        }

        throw v2;
    }

    private static final void run$lambda$15$lambda$8$attempt(ObjectRef arg1, Function0 arg2) {
        try {
            arg2.invoke();
            return;
        }
        catch(Exception v2) {
            if(arg1.element == null) {
                arg1.element = v2;
            }
            else {
                Object v1 = arg1.element;
                Intrinsics.checkNotNull(v1);
                ExceptionsKt.addSuppressed(((Throwable)v1), ((Throwable)v2));
            }

            return;
        }
    }

    static final Unit run$lambda$15$lambda$8$lambda$3(Process arg0) {
        arg0.destroy();
        return Unit.INSTANCE;
    }

    static final Unit run$lambda$15$lambda$8$lambda$4(Process arg0) {
        arg0.getOutputStream().close();
        return Unit.INSTANCE;
    }

    static final Unit run$lambda$15$lambda$8$lambda$5(Process arg0) {
        arg0.getInputStream().close();
        return Unit.INSTANCE;
    }

    static final Unit run$lambda$15$lambda$8$lambda$6(Process arg0) {
        arg0.getErrorStream().close();
        return Unit.INSTANCE;
    }

    static final void run$lambda$18(GraphicsCommandRunner arg0, AtomicReference arg1) {
        try {
            Object v0_1 = arg1.get();
            if(v0_1 != null) {
                ((Function0)v0_1).invoke();
                Unit v0_2 = Unit.INSTANCE;
            }
            else {
                v0_1 = null;
            }

            Result.constructor-impl(v0_1);
            return;
        }
        catch(Throwable v0) {
            Result.constructor-impl(ResultKt.createFailure(v0));
            return;
        }
    }
}

