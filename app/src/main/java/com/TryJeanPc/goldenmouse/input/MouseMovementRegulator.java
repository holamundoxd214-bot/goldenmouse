package com.TryJeanPc.goldenmouse.input;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u000278B]\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u000E\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004\u0012\u0018\u0010\n\u001A\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\u000B\u0012\u0014\b\u0002\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000F¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010$\u001A\u00020\r2\u0006\u0010%\u001A\u00020&2\u0012\u0010\'\u001A\u000E\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\r0\u000FJ\u000E\u0010(\u001A\u00020\r2\u0006\u0010%\u001A\u00020\fJ\u000E\u0010)\u001A\u00020\r2\u0006\u0010*\u001A\u00020\u0016J\u0006\u0010+\u001A\u00020\rJ\u0006\u0010,\u001A\u00020\rJ\b\u0010-\u001A\u00020\rH\u0016J\b\u0010.\u001A\u00020#H\u0002J\b\u0010/\u001A\u00020\rH\u0002J\b\u00100\u001A\u00020\rH\u0002J\b\u00101\u001A\u00020#H\u0002J\b\u00102\u001A\u00020\u0005H\u0002J\b\u00103\u001A\u00020\rH\u0002J\b\u00104\u001A\u00020\rH\u0002J\b\u00105\u001A\u00020\rH\u0002J\b\u00106\u001A\u00020\rH\u0002R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001A\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001A\u00020\u00168F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001A\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u001E\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001FR\u0016\u0010 \u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020#X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00069"}, d2={"Lcom/TryJeanPc/goldenmouse/input/MouseMovementRegulator;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "clock", "Lkotlin/Function0;", "", "timer", "Lcom/TryJeanPc/goldenmouse/input/MouseMovementRegulator$Timer;", "currentContext", "Lcom/TryJeanPc/goldenmouse/input/MouseMovementRegulator$Context;", "sink", "Lkotlin/Function2;", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$MouseMove;", "", "onFailure", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/TryJeanPc/goldenmouse/input/MouseMovementRegulator$Timer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "lock", "", "configured", "Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "selection", "getSelection", "()Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "context", "template", "pendingX", "pendingY", "lastDelivery", "Ljava/lang/Long;", "cancelWake", "wakeGeneration", "closed", "", "route", "event", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "discreteConsumer", "accept", "configure", "value", "flushBeforeDiscreteEvent", "discard", "close", "admit", "clear", "cancelTimer", "hasPending", "remainingNanos", "drainIfEligible", "drain", "flush", "schedulePending", "Context", "Timer", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MouseMovementRegulator implements AutoCloseable {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/input/MouseMovementRegulator$Context;", "", "sessionId", "", "modeEpoch", "<init>", "(JJ)V", "getSessionId", "()J", "getModeEpoch", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Context {
        public static final int $stable;
        private final long modeEpoch;
        private final long sessionId;

        static {
        }

        public Context(long arg1, long arg3) {
            super();
            this.sessionId = arg1;
            this.modeEpoch = arg3;
        }

        public final long component1() {
            return this.sessionId;
        }

        public final long component2() {
            return this.modeEpoch;
        }

        public final Context copy(long arg1, long arg3) {
            return new Context(arg1, arg3);
        }

        public static Context copy$default(Context arg0, long arg1, long arg3, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.sessionId;
            }

            if((arg5 & 2) != 0) {
                arg3 = arg0.modeEpoch;
            }

            return arg0.copy(arg1, arg3);
        }

        public boolean equals(Object arg8) {
            if(this == (((Context)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Context)) {
                return 0;
            }

            if(this.sessionId != ((Context)arg8).sessionId) {
                return 0;
            }

            if(this.modeEpoch != ((Context)arg8).modeEpoch) {
                return 0;
            }

            return 1;
        }

        public final long getModeEpoch() {
            return this.modeEpoch;
        }

        public final long getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            return Long.hashCode(this.sessionId) * 0x1F + Long.hashCode(this.modeEpoch);
        }

        public String toString() {
            return "Context(sessionId=" + this.sessionId + ", modeEpoch=" + this.modeEpoch + ")";
        }
    }

    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\b\u001A\u00020\u0004H&¨\u0006\tÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/input/MouseMovementRegulator$Timer;", "", "schedule", "Lkotlin/Function0;", "", "delayNanos", "", "action", "stop", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface Timer {
        Function0 schedule(long arg1, Function0 arg2);

        void stop();
    }

    public static final int $stable = 8;
    private Function0 cancelWake;
    private final Function0 clock;
    private boolean closed;
    private MousePollingSelection configured;
    private Context context;
    private final Function0 currentContext;
    private Long lastDelivery;
    private final Object lock;
    private final Function1 onFailure;
    private long pendingX;
    private long pendingY;
    private final Function2 sink;
    private MouseMove template;
    private final Timer timer;
    private long wakeGeneration;

    static {
    }

    public MouseMovementRegulator(Function0 arg2, Timer arg3, Function0 arg4, Function2 arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg2, "clock");
        Intrinsics.checkNotNullParameter(arg3, "timer");
        Intrinsics.checkNotNullParameter(arg4, "currentContext");
        Intrinsics.checkNotNullParameter(arg5, "sink");
        Intrinsics.checkNotNullParameter(arg6, "onFailure");
        super();
        this.clock = arg2;
        this.timer = arg3;
        this.currentContext = arg4;
        this.sink = arg5;
        this.onFailure = arg6;
        this.lock = new Object();
        this.configured = new MousePollingSelection(0, false, 3, null);
    }

    public MouseMovementRegulator(Function0 arg7, Timer arg8, Function0 arg9, Function2 arg10, Function1 arg11, int arg12, DefaultConstructorMarker arg13) {
        MouseMovementRegulator$$ExternalSyntheticLambda1 v11;
        if((arg12 & 16) != 0) {
            v11 = new MouseMovementRegulator$$ExternalSyntheticLambda1();
        }

        this(arg7, arg8, arg9, arg10, ((Function1)v11));
    }

    static final Unit _init_$lambda$0(Throwable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        throw arg1;
    }

    public final void accept(MouseMove arg6) {
        Intrinsics.checkNotNullParameter(arg6, "event");
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(this.admit()) {
                if(this.configured.getHz() == 0) {
                    Function2 v1 = this.sink;
                    Context v5_1 = this.context;
                    if(v5_1 != null) {
                        v1.invoke(arg6, v5_1);
                    }
                    else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
                else {
                    MouseMove v1_1 = this.template;
                    if(v1_1 != null) {
                        String v1_2 = v1_1.getDevicePath();
                    }
                    else {
                        Object v1_3 = null;
                    }

                    if(!Intrinsics.areEqual(v1_3, arg6.getDevicePath())) {
                        this.flush();
                    }

                    this.template = arg6;
                    this.pendingX += ((long)arg6.getDeltaX());
                    this.pendingY += ((long)arg6.getDeltaY());
                    this.drainIfEligible();
                    this.schedulePending();
                }
            }
        }
        catch(Throwable v5) {
            __monitor_exit(v0);
            throw v5;
        }

        __monitor_exit(v0);
    }

    private final boolean admit() {
        Object v0 = this.closed ? null : this.currentContext.invoke();
        if(v0 == null || !Intrinsics.areEqual(v0, this.context)) {
            this.clear();
            this.context = ((Context)v0);
        }

        if(v0 != null) {
            return 1;
        }

        return 0;
    }

    private final void cancelTimer() {
        ++this.wakeGeneration;
        Function0 v0 = this.cancelWake;
        if(v0 != null) {
            v0.invoke();
        }

        this.cancelWake = null;
    }

    private final void clear() {
        this.cancelTimer();
        this.pendingX = 0;
        this.pendingY = 0;
        this.template = null;
        this.context = null;
        this.lastDelivery = null;
        this.timer.stop();
    }

    public void close() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.closed = true;
            this.clear();
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    public final void configure(MousePollingSelection arg3) {
        Intrinsics.checkNotNullParameter(arg3, "value");
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(this.closed) {
                goto label_22;
            }

            if(!Intrinsics.areEqual(this.configured, arg3)) {
                if(this.admit()) {
                    this.flush();
                }

                this.configured = arg3;
                this.lastDelivery = null;
                if(arg3.getHz() != 0) {
                    goto label_19;
                }

                this.timer.stop();
            }

        label_19:
        }
        catch(Throwable v2) {
            goto label_28;
        }

        __monitor_exit(v0);
        return;
        try {
        label_22:
            throw new IllegalStateException("El regulador de mouse está cerrado".toString());
        }
        catch(Throwable v2) {
        label_28:
            __monitor_exit(v0);
            throw v2;
        }
    }

    public final void discard() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.clear();
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
    }

    private final void drain() {
        MouseMove v0 = this.template;
        if(v0 == null) {
            return;
        }

        int v1 = ((int)RangesKt.coerceIn(this.pendingX, -2147483648, 0x7FFFFFFF));
        int v2 = ((int)RangesKt.coerceIn(this.pendingY, -2147483648, 0x7FFFFFFF));
        this.pendingX -= ((long)v1);
        this.pendingY -= ((long)v2);
        this.lastDelivery = this.clock.invoke();
        Function2 v11 = this.sink;
        v0 = MouseMove.copy$default(v0, v1, v2, 0, null, 0, null, 60, null);
        Context v12 = this.context;
        if(v12 != null) {
            v11.invoke(v0, v12);
            return;
        }

        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void drainIfEligible() {
        if((this.hasPending()) && this.remainingNanos() == 0) {
            this.drain();
        }
    }

    private final void flush() {
        this.cancelTimer();
        while(this.hasPending()) {
            this.drain();
        }
    }

    public final void flushBeforeDiscreteEvent() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(this.admit()) {
                this.flush();
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    public final MousePollingSelection getSelection() {
        MousePollingSelection v1_1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1_1 = this.configured;
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    private final boolean hasPending() {
        long v2 = 0;
        if(this.pendingX == v2) {
            if(this.pendingY != v2) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final long remainingNanos() {
        Long v0 = this.lastDelivery;
        long v1 = 0;
        if(v0 != null) {
            return RangesKt.coerceAtLeast(this.configured.getIntervalNanos() - RangesKt.coerceAtLeast(this.clock.invoke().longValue() - v0.longValue(), v1), v1);
        }

        return v1;
    }

    public final void route(InputEvent arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "event");
        Intrinsics.checkNotNullParameter(arg3, "discreteConsumer");
        if((arg2 instanceof MouseMove)) {
            this.accept(((MouseMove)arg2));
            return;
        }

        this.flushBeforeDiscreteEvent();
        arg3.invoke(arg2);
    }

    private final void schedulePending() {
        if(!this.hasPending()) {
            this.cancelTimer();
            return;
        }

        if(this.cancelWake != null) {
            return;
        }

        long v0 = this.wakeGeneration + 1;
        this.wakeGeneration = v0;
        this.cancelWake = this.timer.schedule(this.remainingNanos(), new MouseMovementRegulator$$ExternalSyntheticLambda0(this, v0));
    }

    static final Unit schedulePending$lambda$11(MouseMovementRegulator arg3, long arg4) {
        Object v4_1;
        Object v0;
        try {
            v0 = arg3.lock;
            __monitor_enter(v0);
        }
        catch(Throwable v4) {
            goto label_22;
        }

        try {
            if(arg4 == arg3.wakeGeneration) {
                arg3.cancelWake = null;
                if(arg3.admit()) {
                    arg3.drainIfEligible();
                    arg3.schedulePending();
                }
            }

            goto label_12;
        }
        catch(Throwable v4) {
            try {
                __monitor_exit(v0);
                throw v4;
            label_12:
                __monitor_exit(v0);
                v4_1 = Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v4) {
            label_22:
                v4_1 = Result.constructor-impl(ResultKt.createFailure(v4));
            }
        }

        v4 = Result.exceptionOrNull-impl(v4_1);
        if(v4 != null) {
            arg3.discard();
            arg3.onFailure.invoke(v4);
        }

        return Unit.INSTANCE;
    }
}

