package com.TryJeanPc.goldenmouse.aim;

import android.util.Log;
import com.TryJeanPc.goldenmouse.input.InputPipelineDiagnostics;
import java.util.Map$Entry;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010(\u001A\u00020)2\u0006\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020+2\u0006\u0010-\u001A\u00020+2\u0006\u0010.\u001A\u00020+2\b\b\u0002\u0010/\u001A\u0002002\b\b\u0002\u00101\u001A\u000200J\u001E\u00102\u001A\u00020)2\u0006\u00103\u001A\u00020+2\u0006\u00104\u001A\u00020+2\u0006\u00105\u001A\u00020+J\u0016\u00106\u001A\u00020)2\u0006\u00107\u001A\u00020+2\u0006\u00108\u001A\u00020+J\u001E\u00109\u001A\u00020)2\u0006\u00107\u001A\u00020+2\u0006\u00108\u001A\u00020+2\u0006\u0010:\u001A\u00020;J\u0016\u0010<\u001A\u00020)2\u0006\u00107\u001A\u00020+2\u0006\u00108\u001A\u00020+J\u001E\u0010=\u001A\u00020)2\u0006\u0010>\u001A\u00020+2\u0006\u00107\u001A\u00020+2\u0006\u00108\u001A\u00020+J\u001E\u0010?\u001A\u00020)2\u0006\u0010@\u001A\u00020A2\u0006\u0010B\u001A\u00020A2\u0006\u0010C\u001A\u00020+J\u0016\u0010D\u001A\u00020)2\u0006\u0010E\u001A\u0002002\u0006\u0010F\u001A\u00020+J\b\u0010G\u001A\u00020+H\u0002J\u0012\u0010H\u001A\u000E\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020+0IJ\u0006\u0010K\u001A\u00020)J\u0018\u0010L\u001A\u00020+2\u0006\u0010M\u001A\u00020\u00052\u0006\u0010N\u001A\u00020\u0005H\u0002J\u0018\u0010O\u001A\u00020)2\u0006\u0010P\u001A\u00020\u00052\u0006\u0010Q\u001A\u00020+H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/FpsPipelineMetrics;", "", "<init>", "()V", "rawReports", "Ljava/util/concurrent/atomic/AtomicLong;", "queuedReports", "oldestQueuedRaw", "pendingXMilliPixels", "pendingYMilliPixels", "maxPendingMilliPixels", "pendingAgeNanos", "maxPendingAgeNanos", "rawDx", "rawDy", "recenterCount", "abortedRecenters", "recenterNanos", "recenterMax", "recenterUpCallMax", "recenterDownCallMax", "recenterGapMax", "rawIntervalSum", "rawIntervalCount", "rawIntervalMax", "previousRaw", "combined", "maxPendingReports", "maxPendingDelta", "steps", "rawToCommandSum", "rawToCommandMax", "rawToCommandSamples", "cameraDispatches", "dispatchIntervalSum", "dispatchIntervalMax", "previousDispatch", "backendNanos", "backendMax", "lastReport", "offered", "", "timestamp", "", "pendingReports", "dx", "dy", "reportDx", "", "reportDy", "stepped", "oldestTimestamp", "reports", "now", "dispatched", "start", "finish", "recentered", "completed", "", "recenterUpCalled", "recenterDownCalled", "upFinished", "backlog", "x", "", "y", "ageNanos", "queue", "depth", "oldestRawNanos", "queueAge", "snapshot", "", "", "reportIfDue", "avg", "total", "count", "max", "target", "value", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class FpsPipelineMetrics {
    public static final int $stable = 8;
    private final AtomicLong abortedRecenters;
    private final AtomicLong backendMax;
    private final AtomicLong backendNanos;
    private final AtomicLong cameraDispatches;
    private final AtomicLong combined;
    private final AtomicLong dispatchIntervalMax;
    private final AtomicLong dispatchIntervalSum;
    private final AtomicLong lastReport;
    private final AtomicLong maxPendingAgeNanos;
    private final AtomicLong maxPendingDelta;
    private final AtomicLong maxPendingMilliPixels;
    private final AtomicLong maxPendingReports;
    private final AtomicLong oldestQueuedRaw;
    private final AtomicLong pendingAgeNanos;
    private final AtomicLong pendingXMilliPixels;
    private final AtomicLong pendingYMilliPixels;
    private final AtomicLong previousDispatch;
    private final AtomicLong previousRaw;
    private final AtomicLong queuedReports;
    private final AtomicLong rawDx;
    private final AtomicLong rawDy;
    private final AtomicLong rawIntervalCount;
    private final AtomicLong rawIntervalMax;
    private final AtomicLong rawIntervalSum;
    private final AtomicLong rawReports;
    private final AtomicLong rawToCommandMax;
    private final AtomicLong rawToCommandSamples;
    private final AtomicLong rawToCommandSum;
    private final AtomicLong recenterCount;
    private final AtomicLong recenterDownCallMax;
    private final AtomicLong recenterGapMax;
    private final AtomicLong recenterMax;
    private final AtomicLong recenterNanos;
    private final AtomicLong recenterUpCallMax;
    private final AtomicLong steps;

    static {
    }

    public FpsPipelineMetrics() {
        super();
        this.rawReports = new AtomicLong();
        this.queuedReports = new AtomicLong();
        this.oldestQueuedRaw = new AtomicLong();
        this.pendingXMilliPixels = new AtomicLong();
        this.pendingYMilliPixels = new AtomicLong();
        this.maxPendingMilliPixels = new AtomicLong();
        this.pendingAgeNanos = new AtomicLong();
        this.maxPendingAgeNanos = new AtomicLong();
        this.rawDx = new AtomicLong();
        this.rawDy = new AtomicLong();
        this.recenterCount = new AtomicLong();
        this.abortedRecenters = new AtomicLong();
        this.recenterNanos = new AtomicLong();
        this.recenterMax = new AtomicLong();
        this.recenterUpCallMax = new AtomicLong();
        this.recenterDownCallMax = new AtomicLong();
        this.recenterGapMax = new AtomicLong();
        this.rawIntervalSum = new AtomicLong();
        this.rawIntervalCount = new AtomicLong();
        this.rawIntervalMax = new AtomicLong();
        this.previousRaw = new AtomicLong();
        this.combined = new AtomicLong();
        this.maxPendingReports = new AtomicLong();
        this.maxPendingDelta = new AtomicLong();
        this.steps = new AtomicLong();
        this.rawToCommandSum = new AtomicLong();
        this.rawToCommandMax = new AtomicLong();
        this.rawToCommandSamples = new AtomicLong();
        this.cameraDispatches = new AtomicLong();
        this.dispatchIntervalSum = new AtomicLong();
        this.dispatchIntervalMax = new AtomicLong();
        this.previousDispatch = new AtomicLong();
        this.backendNanos = new AtomicLong();
        this.backendMax = new AtomicLong();
        this.lastReport = new AtomicLong(System.nanoTime());
    }

    private final long avg(AtomicLong arg5, AtomicLong arg6) {
        return arg5.get() / RangesKt.coerceAtLeast(arg6.get(), 1);
    }

    public final void backlog(double arg3, double arg5, long arg7) {
        long v3 = ((long)(arg3 * 1000));
        long v5 = ((long)(arg5 * 1000));
        this.pendingXMilliPixels.set(v3);
        this.pendingYMilliPixels.set(v5);
        this.max(this.maxPendingMilliPixels, Math.max(Math.abs(v3), Math.abs(v5)));
        this.pendingAgeNanos.set(arg7);
        this.max(this.maxPendingAgeNanos, arg7);
    }

    public final void dispatched(long arg6, long arg8) {
        this.cameraDispatches.incrementAndGet();
        long v0 = this.previousDispatch.getAndSet(arg6);
        long v2 = 0;
        if(v0 != v2 && arg6 > v0) {
            v0 = arg6 - v0;
            this.dispatchIntervalSum.addAndGet(v0);
            this.max(this.dispatchIntervalMax, v0);
        }

        arg6 = RangesKt.coerceAtLeast(arg8 - arg6, v2);
        this.backendNanos.addAndGet(arg6);
        this.max(this.backendMax, arg6);
    }

    private final void max(AtomicLong arg3, long arg4) {
        do {
            long v0 = arg3.get();
            if(arg4 <= v0) {
                return;
            }
        }
        while(!arg3.compareAndSet(v0, arg4));
    }

    public final void offered(long arg4, long arg6, long arg8, long arg10, int arg12, int arg13) {
        this.rawReports.incrementAndGet();
        this.rawDx.addAndGet(((long)arg12));
        this.rawDy.addAndGet(((long)arg13));
        long v12 = this.previousRaw.getAndSet(arg4);
        if(v12 != 0 && arg4 > v12) {
            arg4 -= v12;
            this.rawIntervalSum.addAndGet(arg4);
            this.rawIntervalCount.incrementAndGet();
            this.max(this.rawIntervalMax, arg4);
        }

        this.max(this.maxPendingReports, arg6);
        this.max(this.maxPendingDelta, Math.max(Math.abs(arg8), Math.abs(arg10)));
    }

    public static void offered$default(FpsPipelineMetrics arg1, long arg2, long arg4, long arg6, long arg8, int arg10, int arg11, int arg12, Object arg13) {
        arg1.offered(arg2, arg4, arg6, arg8, 0, 0);
    }

    public final void queue(int arg4, long arg5) {
        long v1 = ((long)arg4);
        this.queuedReports.set(v1);
        this.oldestQueuedRaw.set(arg5);
        this.max(this.maxPendingReports, v1);
    }

    private final long queueAge() {
        long v0 = this.oldestQueuedRaw.get();
        long v2 = 0;
        if(v0 > v2) {
            v2 = RangesKt.coerceAtLeast(System.nanoTime() - v0, v2);
        }

        this.max(this.maxPendingAgeNanos, v2);
        return v2;
    }

    public final void recenterDownCalled(long arg4, long arg6, long arg8) {
        this.max(this.recenterGapMax, RangesKt.coerceAtLeast(arg6 - arg4, 0));
        this.max(this.recenterDownCallMax, RangesKt.coerceAtLeast(arg8 - arg6, 0));
    }

    public final void recenterUpCalled(long arg2, long arg4) {
        this.max(this.recenterUpCallMax, RangesKt.coerceAtLeast(arg4 - arg2, 0));
    }

    public final void recentered(long arg2, long arg4, boolean arg6) {
        this.recenterCount.incrementAndGet();
        if(!arg6) {
            this.abortedRecenters.incrementAndGet();
        }

        arg2 = RangesKt.coerceAtLeast(arg4 - arg2, 0);
        this.recenterNanos.addAndGet(arg2);
        this.max(this.recenterMax, arg2);
    }

    public final void reportIfDue() {
        if(!InputPipelineDiagnostics.INSTANCE.getEnabled$app()) {
        }
        else {
            long v0 = System.nanoTime();
            long v2 = this.lastReport.get();
            if(v0 - v2 >= 1000000000) {
                if(!this.lastReport.compareAndSet(v2, v0)) {
                }
                else {
                    Log.i("GOLDEN_FPS_PIPELINE", CollectionsKt.joinToString$default(this.snapshot().entrySet(), " ", null, null, 0, null, new FpsPipelineMetrics$$ExternalSyntheticLambda0(), 30, null));
                }
            }
        }
    }

    static final CharSequence reportIfDue$lambda$0(Map$Entry arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return arg2.getKey() + "=" + arg2.getValue();
    }

    public final Map snapshot() {
        return MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("pendingReports", Long.valueOf(this.queuedReports.get())), TuplesKt.to("pendingXMilliPixels", Long.valueOf(this.pendingXMilliPixels.get())), TuplesKt.to("pendingYMilliPixels", Long.valueOf(this.pendingYMilliPixels.get())), TuplesKt.to("maxPendingMilliPixels", Long.valueOf(this.maxPendingMilliPixels.get())), TuplesKt.to("pendingAgeUs", Long.valueOf(this.queueAge() / 1000)), TuplesKt.to("maxPendingAgeUs", Long.valueOf(this.maxPendingAgeNanos.get() / 1000)), TuplesKt.to("rawDx", Long.valueOf(this.rawDx.get())), TuplesKt.to("rawDy", Long.valueOf(this.rawDy.get())), TuplesKt.to("recenters", Long.valueOf(this.recenterCount.get())), TuplesKt.to("abortedRecenters", Long.valueOf(this.abortedRecenters.get())), TuplesKt.to("recenterAvgUs", Long.valueOf(this.avg(this.recenterNanos, this.recenterCount) / 1000)), TuplesKt.to("recenterMaxUs", Long.valueOf(this.recenterMax.get() / 1000)), TuplesKt.to("recenterUpCallMaxUs", Long.valueOf(this.recenterUpCallMax.get() / 1000)), TuplesKt.to("recenterDownCallMaxUs", Long.valueOf(this.recenterDownCallMax.get() / 1000)), TuplesKt.to("recenterGapMaxUs", Long.valueOf(this.recenterGapMax.get() / 1000)), TuplesKt.to("rawReports", Long.valueOf(this.rawReports.get())), TuplesKt.to("rawIntervalAvgUs", Long.valueOf(this.avg(this.rawIntervalSum, this.rawIntervalCount) / 1000)), TuplesKt.to("rawIntervalMaxUs", Long.valueOf(this.rawIntervalMax.get() / 1000)), TuplesKt.to("combinedReports", Long.valueOf(this.combined.get())), TuplesKt.to("maxPendingReports", Long.valueOf(this.maxPendingReports.get())), TuplesKt.to("maxPendingDelta", Long.valueOf(this.maxPendingDelta.get())), TuplesKt.to("steps", Long.valueOf(this.steps.get())), TuplesKt.to("rawToCommandAvgUs", Long.valueOf(this.avg(this.rawToCommandSum, this.rawToCommandSamples) / 1000)), TuplesKt.to("rawToCommandMaxUs", Long.valueOf(this.rawToCommandMax.get() / 1000)), TuplesKt.to("cameraDispatches", Long.valueOf(this.cameraDispatches.get())), TuplesKt.to("dispatchIntervalAvgUs", Long.valueOf(this.dispatchIntervalSum.get() / RangesKt.coerceAtLeast(this.cameraDispatches.get() - 1, 1) / 1000)), TuplesKt.to("dispatchIntervalMaxUs", Long.valueOf(this.dispatchIntervalMax.get() / 1000)), TuplesKt.to("backendCallAvgUs", Long.valueOf(this.avg(this.backendNanos, this.cameraDispatches) / 1000)), TuplesKt.to("backendCallMaxUs", Long.valueOf(this.backendMax.get() / 1000))});
    }

    public final void stepped(long arg4, long arg6, long arg8) {
        this.steps.incrementAndGet();
        this.combined.addAndGet(RangesKt.coerceAtLeast(arg6 - 1, 0));
        if(arg4 > 0 && arg8 >= arg4) {
            arg8 -= arg4;
            this.rawToCommandSum.addAndGet(arg8);
            this.rawToCommandSamples.incrementAndGet();
            this.max(this.rawToCommandMax, arg8);
        }
    }
}

