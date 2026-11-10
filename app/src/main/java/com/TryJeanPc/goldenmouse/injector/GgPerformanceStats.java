package com.TryJeanPc.goldenmouse.injector;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010$\u001A\u00020\u00052\u0006\u0010$\u001A\u00020%J\u0016\u0010&\u001A\u00020\'2\u0006\u0010$\u001A\u00020%2\u0006\u0010(\u001A\u00020#J\u0016\u0010)\u001A\u00020*2\u0006\u0010$\u001A\u00020%2\u0006\u0010(\u001A\u00020#J\u001E\u0010+\u001A\u00020\'2\u0006\u0010,\u001A\u00020!2\u0006\u0010-\u001A\u00020#2\u0006\u0010.\u001A\u00020#J&\u0010/\u001A\u00020\'2\u0006\u0010.\u001A\u00020#2\u0006\u0010,\u001A\u00020!2\u0006\u0010-\u001A\u00020#2\u0006\u00100\u001A\u00020#J \u00101\u001A\u00020\'2\u0006\u0010,\u001A\u00020!2\u0006\u0010-\u001A\u00020#2\u0006\u00100\u001A\u00020#H\u0002J \u0010\u001D\u001A\u00020\'2\u0006\u0010,\u001A\u00020!2\u0006\u00102\u001A\u00020*2\b\b\u0002\u00100\u001A\u00020#J\u000E\u00103\u001A\u0002042\u0006\u00100\u001A\u00020#J\u0018\u00105\u001A\u0002042\u0006\u0010(\u001A\u00020#2\u0006\u00100\u001A\u00020#H\u0002R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u000E\u0010\f\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0012R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020!X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020#X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00066"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/GgPerformanceStats;", "", "<init>", "()V", "queueWait", "Lcom/TryJeanPc/goldenmouse/injector/GgLatencyHistogram;", "getQueueWait", "()Lcom/TryJeanPc/goldenmouse/injector/GgLatencyHistogram;", "confirmedCall", "getConfirmedCall", "transportGate", "getTransportGate", "shizuku", "kadb", "other", "processed", "Ljava/util/concurrent/atomic/AtomicLong;", "getProcessed", "()Ljava/util/concurrent/atomic/AtomicLong;", "stale", "getStale", "overflows", "getOverflows", "confirmedInFlightAt", "getConfirmedInFlightAt", "backendInFlightAt", "Ljava/util/concurrent/atomic/AtomicLongArray;", "admitted", "accumulated", "cleared", "maxDepth", "maxAgeNanos", "depth", "", "oldestQueuedAt", "", "backend", "Lcom/TryJeanPc/goldenmouse/injector/GgMeasuredBackend;", "backendStarted", "", "start", "backendFinished", "", "enqueued", "size", "oldest", "queuedAt", "dequeued", "now", "queueState", "observed", "snapshot", "", "elapsed", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GgPerformanceStats {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[GgMeasuredBackend.values().length];
            try {
                v0[GgMeasuredBackend.SHIZUKU.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[GgMeasuredBackend.KADB.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[GgMeasuredBackend.OTHER.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private final AtomicLong accumulated;
    private final AtomicLong admitted;
    private final AtomicLongArray backendInFlightAt;
    private final AtomicLong cleared;
    private final GgLatencyHistogram confirmedCall;
    private final AtomicLong confirmedInFlightAt;
    private volatile int depth;
    private final GgLatencyHistogram kadb;
    private final AtomicLong maxAgeNanos;
    private final AtomicLong maxDepth;
    private volatile long oldestQueuedAt;
    private final GgLatencyHistogram other;
    private final AtomicLong overflows;
    private final AtomicLong processed;
    private final GgLatencyHistogram queueWait;
    private final GgLatencyHistogram shizuku;
    private final AtomicLong stale;
    private final GgLatencyHistogram transportGate;

    static {
    }

    public GgPerformanceStats() {
        super();
        this.queueWait = new GgLatencyHistogram();
        this.confirmedCall = new GgLatencyHistogram();
        this.transportGate = new GgLatencyHistogram();
        this.shizuku = new GgLatencyHistogram();
        this.kadb = new GgLatencyHistogram();
        this.other = new GgLatencyHistogram();
        this.processed = new AtomicLong();
        this.stale = new AtomicLong();
        this.overflows = new AtomicLong();
        this.confirmedInFlightAt = new AtomicLong();
        this.backendInFlightAt = new AtomicLongArray(GgMeasuredBackend.getEntries().size());
        this.admitted = new AtomicLong();
        this.accumulated = new AtomicLong();
        this.cleared = new AtomicLong();
        this.maxDepth = new AtomicLong();
        this.maxAgeNanos = new AtomicLong();
    }

    public final GgLatencyHistogram backend(GgMeasuredBackend arg2) {
        Intrinsics.checkNotNullParameter(arg2, "backend");
        int v2 = WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()];
        if(v2 != 1) {
            if(v2 != 2) {
                if(v2 == 3) {
                    return this.other;
                }

                throw new NoWhenBranchMatchedException();
            }

            return this.kadb;
        }

        return this.shizuku;
    }

    public final boolean backendFinished(GgMeasuredBackend arg8, long arg9) {
        Intrinsics.checkNotNullParameter(arg8, "backend");
        return this.backendInFlightAt.compareAndSet(arg8.ordinal(), arg9, 0);
    }

    public final void backendStarted(GgMeasuredBackend arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg2, "backend");
        this.backendInFlightAt.set(arg2.ordinal(), arg3);
    }

    public final void cleared(int arg10, boolean arg11, long arg12) {
        if(arg11) {
            this.cleared.addAndGet(((long)arg10));
            long v10 = this.oldestQueuedAt;
            long v0 = 0;
            if(v10 != v0 && arg12 != v0) {
                GgPerformanceDiagnosticsKt.updateGgMaximum(this.maxAgeNanos, RangesKt.coerceAtLeast(arg12 - v10, v0));
            }
        }

        this.queueState(0, 0, 0);
    }

    public static void cleared$default(GgPerformanceStats arg0, int arg1, boolean arg2, long arg3, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = 0;
        }

        arg0.cleared(arg1, arg2, arg3);
    }

    public final void dequeued(long arg9, int arg11, long arg12, long arg14) {
        long v0 = 0;
        if(arg9 != v0 && arg14 != v0) {
            long v3 = RangesKt.coerceAtLeast(arg14 - arg9, v0);
            GgLatencyHistogram.record$default(this.queueWait, v3, false, 2, null);
            GgPerformanceDiagnosticsKt.updateGgMaximum(this.maxAgeNanos, v3);
        }

        this.queueState(arg11, arg12, arg14);
    }

    private final String elapsed(long arg3, long arg5) {
        long v0 = 0;
        if(arg3 == v0) {
            return "NA";
        }

        return String.valueOf(RangesKt.coerceAtLeast(arg5 - arg3, v0) / 1000);
    }

    public final void enqueued(int arg3, long arg4, long arg6) {
        if(arg6 != 0) {
            this.admitted.incrementAndGet();
            if(arg3 > 1) {
                this.accumulated.incrementAndGet();
            }
        }

        this.queueState(arg3, arg4, arg6);
    }

    public final GgLatencyHistogram getConfirmedCall() {
        return this.confirmedCall;
    }

    public final AtomicLong getConfirmedInFlightAt() {
        return this.confirmedInFlightAt;
    }

    public final AtomicLong getOverflows() {
        return this.overflows;
    }

    public final AtomicLong getProcessed() {
        return this.processed;
    }

    public final GgLatencyHistogram getQueueWait() {
        return this.queueWait;
    }

    public final AtomicLong getStale() {
        return this.stale;
    }

    public final GgLatencyHistogram getTransportGate() {
        return this.transportGate;
    }

    private final void queueState(int arg6, long arg7, long arg9) {
        this.oldestQueuedAt = arg7;
        this.depth = arg6;
        long v0 = 0;
        if(arg9 != v0) {
            GgPerformanceDiagnosticsKt.updateGgMaximum(this.maxDepth, ((long)arg6));
            if(arg7 != v0) {
                GgPerformanceDiagnosticsKt.updateGgMaximum(this.maxAgeNanos, RangesKt.coerceAtLeast(arg9 - arg7, v0));
            }
        }
    }

    public final String snapshot(long arg28) {
        GgPerformanceStats v0 = this;
        long v1 = arg28;
        int v3 = v0.depth;
        long v4 = v0.oldestQueuedAt;
        long v6 = 0;
        if(v3 == 0) {
            v4 = v6;
        }
        else if(v4 == v6) {
            v4 = -1;
        }
        else {
            v4 = RangesKt.coerceAtLeast(v1 - v4, v6);
        }

        GgPerformanceDiagnosticsKt.updateGgMaximum(v0.maxDepth, ((long)v3));
        int v6_1 = Long.compare(v4, v6);
        if(v6_1 >= 0) {
            GgPerformanceDiagnosticsKt.updateGgMaximum(v0.maxAgeNanos, v4);
        }

        long v7 = v0.admitted.get();
        long v9 = v0.processed.get();
        long v11 = v0.stale.get();
        long v13 = v0.cleared.get();
        long v16 = v4;
        int v18 = v3;
        long v19 = v0.overflows.get();
        long v3_1 = v0.accumulated.get();
        long v21 = 1000;
        String v5 = v6_1 < 0 ? "NA" : String.valueOf(v16 / v21);
        return "admitted=" + v7 + ",processed=" + v9 + ",stale=" + v11 + ",cleared=" + v13 + ",overflows=" + v19 + ",backloggedAdmissions=" + v3_1 + ",depth=" + v18 + ",oldestAgeUs=" + v5 + ",maxDepth=" + v0.maxDepth.get() + ",maxAgeUs=" + v0.maxAgeNanos.get() / v21 + ",confirmedInFlightUs=" + v0.elapsed(v0.confirmedInFlightAt.get(), v1) + ",shizukuInFlightUs=" + v0.elapsed(v0.backendInFlightAt.get(GgMeasuredBackend.SHIZUKU.ordinal()), v1) + ",kadbInFlightUs=" + v0.elapsed(v0.backendInFlightAt.get(GgMeasuredBackend.KADB.ordinal()), v1) + " " + v0.queueWait.snapshot("queueWait") + " " + v0.confirmedCall.snapshot("confirmedCall") + " " + v0.transportGate.snapshot("transportGate") + " " + v0.shizuku.snapshot("shizuku") + " " + v0.kadb.snapshot("kadb") + " " + v0.other.snapshot("other");
    }
}

