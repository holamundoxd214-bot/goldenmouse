package com.TryJeanPc.goldenmouse.injector;

import android.util.Log;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000E\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0012\u001A\u00020\u00132\u0006\u0010\r\u001A\u00020\u000EJ\u0006\u0010\u0014\u001A\u00020\tJ\u0006\u0010\u0015\u001A\u00020\tJ\u000E\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0018J\u0016\u0010\u0019\u001A\u00020\u000E2\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u000EJ\u001E\u0010\u001D\u001A\u00020\u00132\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\t2\u0006\u0010!\u001A\u00020\tJ\u001E\u0010\"\u001A\u00020\u00132\u0006\u0010!\u001A\u00020\t2\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\tJ\u000E\u0010#\u001A\u00020\u00132\u0006\u0010\u001E\u001A\u00020\u001FJ\u0006\u0010$\u001A\u00020\u0013J\u0006\u0010%\u001A\u00020\u0013J\u0006\u0010&\u001A\u00020\u0013J\u0016\u0010\'\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\t2\u0006\u0010(\u001A\u00020\u000EJ\u001E\u0010)\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010(\u001A\u00020\u000EJ\u000E\u0010*\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\tJ\u0006\u0010+\u001A\u00020\u0005J\u0006\u0010,\u001A\u00020\u0013R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u000E@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006-"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/GgPerformanceDiagnostics;", "", "<init>", "()V", "TAG", "", "stats", "Lcom/TryJeanPc/goldenmouse/injector/GgPerformanceStats;", "sinceNanos", "", "pausedAt", "lastReport", "Ljava/util/concurrent/atomic/AtomicLong;", "value", "", "enabled", "getEnabled", "()Z", "setEnabled", "", "start", "confirmedCallStarted", "backendStarted", "backend", "Lcom/TryJeanPc/goldenmouse/injector/GgMeasuredBackend;", "isGgConfirmed", "command", "Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;", "confirmed", "enqueued", "size", "", "oldest", "queuedAt", "dequeued", "cleared", "processed", "stale", "overflow", "confirmedCallFinished", "accepted", "backendFinished", "transportGateAcquired", "snapshot", "reportIfDue", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GgPerformanceDiagnostics {
    public static final int $stable = 0;
    public static final GgPerformanceDiagnostics INSTANCE = null;
    public static final String TAG = "GOLDEN_GG_PERF";
    private static volatile boolean enabled;
    private static final AtomicLong lastReport;
    private static long pausedAt;
    private static final long sinceNanos;
    private static final GgPerformanceStats stats;

    static {
        GgPerformanceDiagnostics.INSTANCE = new GgPerformanceDiagnostics();
        GgPerformanceDiagnostics.stats = new GgPerformanceStats();
        long v0 = System.nanoTime();
        GgPerformanceDiagnostics.sinceNanos = v0;
        GgPerformanceDiagnostics.pausedAt = v0;
        GgPerformanceDiagnostics.lastReport = new AtomicLong();
        GgPerformanceDiagnostics.$stable = 8;
    }

    private GgPerformanceDiagnostics() {
        super();
    }

    public final void backendFinished(long arg4, GgMeasuredBackend arg6, boolean arg7) {
        Intrinsics.checkNotNullParameter(arg6, "backend");
        if(arg4 != 0) {
            GgPerformanceStats v3 = GgPerformanceDiagnostics.stats;
            v3.backend(arg6).record(System.nanoTime() - arg4, arg7);
            v3.backendFinished(arg6, arg4);
        }
    }

    public final long backendStarted(GgMeasuredBackend arg5) {
        Intrinsics.checkNotNullParameter(arg5, "backend");
        long v0 = this.start();
        if(v0 != 0) {
            GgPerformanceDiagnostics.stats.backendStarted(arg5, v0);
        }

        return v0;
    }

    public final void cleared(int arg4) {
        boolean v3 = GgPerformanceDiagnostics.enabled;
        GgPerformanceStats v0 = GgPerformanceDiagnostics.stats;
        long v1 = v3 ? System.nanoTime() : 0;
        v0.cleared(arg4, v3, v1);
    }

    public final void confirmedCallFinished(long arg6, boolean arg8) {
        long v0 = 0;
        if(arg6 != v0) {
            GgPerformanceStats v5 = GgPerformanceDiagnostics.stats;
            v5.getConfirmedCall().record(System.nanoTime() - arg6, arg8);
            v5.getConfirmedInFlightAt().compareAndSet(arg6, v0);
        }
    }

    public final long confirmedCallStarted() {
        long v0 = this.start();
        if(v0 != 0) {
            GgPerformanceDiagnostics.stats.getConfirmedInFlightAt().set(v0);
        }

        return v0;
    }

    public final void dequeued(long arg9, int arg11, long arg12) {
        long v1;
        GgPerformanceStats v0 = GgPerformanceDiagnostics.stats;
        if(!GgPerformanceDiagnostics.enabled) {
            v1 = 0;
            if(arg9 != v1) {
                goto label_5;
            }
        }
        else {
        label_5:
            v1 = System.nanoTime();
        }

        v0.dequeued(arg9, arg11, arg12, v1);
    }

    public final void enqueued(int arg1, long arg2, long arg4) {
        GgPerformanceDiagnostics.stats.enqueued(arg1, arg2, arg4);
    }

    public final boolean getEnabled() {
        return GgPerformanceDiagnostics.enabled;
    }

    public final boolean isGgConfirmed(TouchCommand arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "command");
        if((GgPerformanceDiagnostics.enabled) && (arg2) && arg1.getPointerId() == 2 && arg1.getAction() == Action.ACTION_MOVE) {
            return 1;
        }

        return 0;
    }

    public final void overflow() {
        if(GgPerformanceDiagnostics.enabled) {
            GgPerformanceDiagnostics.stats.getOverflows().incrementAndGet();
        }
    }

    public final void processed() {
        if(GgPerformanceDiagnostics.enabled) {
            GgPerformanceDiagnostics.stats.getProcessed().incrementAndGet();
        }
    }

    public final void reportIfDue() {
        if(!GgPerformanceDiagnostics.enabled) {
        }
        else {
            long v0 = System.nanoTime();
            AtomicLong v2 = GgPerformanceDiagnostics.lastReport;
            long v3 = v2.get();
            if(v0 - v3 >= 1000000000) {
                if(!v2.compareAndSet(v3, v0)) {
                }
                else {
                    Log.i("GOLDEN_GG_PERF", this.snapshot());
                }
            }
        }
    }

    public final void setEnabled(boolean arg3) {
        if(!arg3) {
            GgPerformanceDiagnostics.pausedAt = System.nanoTime();
        }

        GgPerformanceDiagnostics.stats.backend(GgMeasuredBackend.OTHER);
        GgPerformanceDiagnostics.enabled = arg3;
    }

    public final String snapshot() {
        boolean v5 = GgPerformanceDiagnostics.enabled;
        long v0 = GgPerformanceDiagnostics.sinceNanos;
        GgPerformanceStats v2 = GgPerformanceDiagnostics.stats;
        long v3 = GgPerformanceDiagnostics.enabled ? System.nanoTime() : GgPerformanceDiagnostics.pausedAt;
        return "GG_PERF v=1 enabled=" + v5 + " sinceNs=" + v0 + " histUpperUs=[250,1000,2000,4000,8000,16000,32000,64000,128000,inf] " + v2.snapshot(v3);
    }

    public final void stale() {
        if(GgPerformanceDiagnostics.enabled) {
            GgPerformanceDiagnostics.stats.getStale().incrementAndGet();
        }
    }

    public final long start() {
        if(GgPerformanceDiagnostics.enabled) {
            return System.nanoTime();
        }

        return 0;
    }

    public final void transportGateAcquired(long arg7) {
        if(arg7 != 0) {
            GgLatencyHistogram.record$default(GgPerformanceDiagnostics.stats.getTransportGate(), System.nanoTime() - arg7, false, 2, null);
        }
    }
}

