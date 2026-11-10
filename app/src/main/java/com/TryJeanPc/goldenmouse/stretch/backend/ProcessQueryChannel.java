package com.TryJeanPc.goldenmouse.stretch.backend;

import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0007H\u0002J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\b\u0010\u0015\u001A\u00020\u000FH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000B\u001A\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/ProcessQueryChannel;", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryChannel;", "process", "Ljava/lang/Process;", "<init>", "(Ljava/lang/Process;)V", "stdout", "Lcom/TryJeanPc/goldenmouse/stretch/backend/LimitedQueryOutput;", "stderr", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "drains", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "drain", "", "input", "Ljava/io/InputStream;", "output", "collect", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchRawResponse;", "close", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class ProcessQueryChannel implements StretchQueryChannel {
    private final AtomicBoolean closed;
    private final ExecutorService drains;
    private final Process process;
    private final LimitedQueryOutput stderr;
    private final LimitedQueryOutput stdout;

    public ProcessQueryChannel(Process arg2) {
        Intrinsics.checkNotNullParameter(arg2, "process");
        super();
        this.process = arg2;
        this.stdout = new LimitedQueryOutput();
        this.stderr = new LimitedQueryOutput();
        this.closed = new AtomicBoolean(false);
        this.drains = Executors.newFixedThreadPool(2, new ProcessQueryChannel$$ExternalSyntheticLambda0());
    }

    public void close() {
        if(this.closed.compareAndSet(false, true)) {
            try {
                this.process.destroy();
            }
            catch(Throwable v0) {
                this.drains.shutdownNow();
                try {
                    this.process.getInputStream().close();
                    Result.constructor-impl(Unit.INSTANCE);
                }
                catch(Throwable v1) {
                    Result.constructor-impl(ResultKt.createFailure(v1));
                }

                try {
                    this.process.getErrorStream().close();
                    Result.constructor-impl(Unit.INSTANCE);
                }
                catch(Throwable v1) {
                    Result.constructor-impl(ResultKt.createFailure(v1));
                }

                try {
                    this.process.getOutputStream().close();
                    Result.constructor-impl(Unit.INSTANCE);
                }
                catch(Throwable v3) {
                    Result.constructor-impl(ResultKt.createFailure(v3));
                }

                throw v0;
            }

            this.drains.shutdownNow();
            try {
                this.process.getInputStream().close();
                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v0) {
                Result.constructor-impl(ResultKt.createFailure(v0));
            }

            try {
                this.process.getErrorStream().close();
                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v0) {
                Result.constructor-impl(ResultKt.createFailure(v0));
            }

            try {
                this.process.getOutputStream().close();
                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v3) {
                Result.constructor-impl(ResultKt.createFailure(v3));
            }
        }
    }

    public StretchRawResponse collect() {
        StretchTransportError v10;
        Exception v1_2;
        Future v0 = this.drains.submit(new ProcessQueryChannel$$ExternalSyntheticLambda1(this));
        Future v1 = this.drains.submit(new ProcessQueryChannel$$ExternalSyntheticLambda2(this));
        try {
            v0.get();
            v1.get();
            return new StretchRawResponse(this.stdout.text(), this.stderr.text(), Integer.valueOf(this.process.waitFor()), false, null, 24, null);
        }
        catch(Exception v0_1) {
            Throwable v1_1 = v0_1.getCause();
            if(v1_1 == null) {
                v1_2 = v0_1;
            }

            String v3 = this.stdout.text();
            String v4 = this.stderr.text();
            if(((((Throwable)v1_2)) instanceof StretchTransportException)) {
            }
            else {
                v1_1 = null;
            }

            if((((Throwable)v1_2)) != null) {
                v10 = ((StretchTransportException)v1_2).getReason();
                if(v10 == null) {
                    goto label_40;
                }
            }
            else {
            label_40:
                v10 = StretchTransportError.TRANSPORT_FAILURE;
            }

            return new StretchRawResponse(v3, v4, null, false, v10);
        }
    }

    static final void collect$lambda$3(ProcessQueryChannel arg2) {
        InputStream v0 = arg2.process.getInputStream();
        Intrinsics.checkNotNullExpressionValue(v0, "getInputStream(...)");
        arg2.drain(v0, arg2.stdout);
    }

    static final void collect$lambda$4(ProcessQueryChannel arg2) {
        InputStream v0 = arg2.process.getErrorStream();
        Intrinsics.checkNotNullExpressionValue(v0, "getErrorStream(...)");
        arg2.drain(v0, arg2.stderr);
    }

    private final void drain(InputStream arg3, LimitedQueryOutput arg4) {
        int v0 = 0x1000;
        try {
            byte[] v0_1 = new byte[v0];
            while(true) {
                int v1 = arg3.read(v0_1);
                if(v1 < 0) {
                    return;
                }

                arg4.append(v0_1, v1);
            }
        }
        catch(Exception v3) {
            goto label_8;
        }

        return;
        try {
        label_8:
            this.process.destroy();
            Result.constructor-impl(Unit.INSTANCE);
        }
        catch(Throwable v2) {
            Result.constructor-impl(ResultKt.createFailure(v2));
        }

        throw v3;
    }

    static final Thread drains$lambda$1(Runnable arg2) {
        Thread v0 = new Thread(arg2, "StretchQueryOutput");
        v0.setDaemon(true);
        return v0;
    }
}

