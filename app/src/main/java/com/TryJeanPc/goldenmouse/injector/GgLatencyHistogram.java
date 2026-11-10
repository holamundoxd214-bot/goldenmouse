package com.TryJeanPc.goldenmouse.injector;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000FJ\u0015\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u000E\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0015R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/GgLatencyHistogram;", "", "<init>", "()V", "buckets", "Ljava/util/concurrent/atomic/AtomicLongArray;", "totalNanos", "Ljava/util/concurrent/atomic/AtomicLong;", "maxNanos", "failures", "record", "", "nanos", "", "accepted", "", "bucketCount", "index", "", "bucketCount$app", "snapshot", "", "name", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GgLatencyHistogram {
    public static final int $stable = 8;
    private final AtomicLongArray buckets;
    private final AtomicLong failures;
    private final AtomicLong maxNanos;
    private final AtomicLong totalNanos;

    static {
    }

    public GgLatencyHistogram() {
        super();
        this.buckets = new AtomicLongArray(10);
        this.totalNanos = new AtomicLong();
        this.maxNanos = new AtomicLong();
        this.failures = new AtomicLong();
    }

    public final long bucketCount$app(int arg1) {
        return this.buckets.get(arg1);
    }

    public final void record(long arg3, boolean arg5) {
        int v0;
        arg3 = RangesKt.coerceAtLeast(arg3, 0);
        if(arg3 <= 250000) {
            v0 = 0;
        }
        else if(arg3 <= 1000000) {
            v0 = 1;
        }
        else if(arg3 <= 2000000) {
            v0 = 2;
        }
        else if(arg3 <= 4000000) {
            v0 = 3;
        }
        else if(arg3 <= 8000000) {
            v0 = 4;
        }
        else if(arg3 <= 16000000) {
            v0 = 5;
        }
        else if(arg3 <= 32000000) {
            v0 = 6;
        }
        else if(arg3 <= 64000000) {
            v0 = 7;
        }
        else if(arg3 <= 128000000) {
            v0 = 8;
        }
        else {
            v0 = 9;
        }

        this.totalNanos.addAndGet(arg3);
        if(!arg5) {
            this.failures.incrementAndGet();
        }

        GgPerformanceDiagnosticsKt.access$updateGgMaximum(this.maxNanos, arg3);
        this.buckets.incrementAndGet(v0);
    }

    public static void record$default(GgLatencyHistogram arg0, long arg1, boolean arg3, int arg4, Object arg5) {
        arg0.record(arg1, true);
    }

    public final String snapshot(String arg13) {
        Intrinsics.checkNotNullParameter(arg13, "name");
        int v0 = this.buckets.length();
        long[] v1 = new long[v0];
        int v2 = 0;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            v1[v3] = this.buckets.get(v3);
        }

        long v3_1 = 0;
        int v5 = 0;
        long v6 = v3_1;
        while(v5 < v0) {
            v6 += v1[v5];
            ++v5;
        }

        StringBuilder v5_1 = new StringBuilder();
        v5_1.append(arg13);
        v5_1.append("{n=");
        v5_1.append(v6);
        v5_1.append(",failed=");
        v5_1.append(this.failures.get());
        v5_1.append(",avgUs=");
        int v13 = Long.compare(v6, v3_1);
        String v3_2 = "NA";
        long v8 = 1000;
        if(v13 == 0) {
            v5_1.append(v3_2);
        }
        else {
            v5_1.append(this.totalNanos.get() / v6 / v8);
        }

        v5_1.append(",maxUs=");
        if(v13 == 0) {
            v5_1.append(v3_2);
        }
        else {
            v5_1.append(this.maxNanos.get() / v8);
        }

        v5_1.append(",h=[");
        while(v2 < v0) {
            if(v2 != 0) {
                v5_1.append(',');
            }

            v5_1.append(v1[v2]);
            ++v2;
        }

        v5_1.append("]}");
        return v5_1.toString();
    }
}

