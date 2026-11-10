package com.TryJeanPc.goldenmouse.injector;

import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010#\u001A\u00020\u0007J\u000E\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00020\'J\u000E\u0010(\u001A\u00020%2\u0006\u0010)\u001A\u00020\'J\u000E\u0010*\u001A\u00020%2\u0006\u0010+\u001A\u00020,J\u0006\u0010-\u001A\u00020\u0007J\u0006\u0010.\u001A\u00020\u0007J\u000E\u0010/\u001A\u00020\u00072\u0006\u00100\u001A\u00020\u0007J\u000E\u00101\u001A\u00020%2\u0006\u00100\u001A\u00020\u0007J\u000E\u00102\u001A\u00020%2\u0006\u00100\u001A\u00020\u0007J\u000E\u0010#\u001A\u00020\u00072\u0006\u00100\u001A\u00020\u0007J\u000E\u00103\u001A\u00020%2\u0006\u00100\u001A\u00020\u0007J\u000E\u00104\u001A\u00020%2\u0006\u00105\u001A\u00020\u0007J\u0006\u00106\u001A\u00020\u0007J\u0016\u00107\u001A\u00020%2\u0006\u00108\u001A\u0002092\u0006\u0010:\u001A\u000209J\r\u0010;\u001A\u00020\u0005H\u0000¢\u0006\u0002\b<J\u000E\u0010=\u001A\u00020%2\u0006\u0010>\u001A\u00020\u0005J\u0018\u0010?\u001A\u00020\u00072\u0006\u0010@\u001A\u00020\t2\u0006\u0010A\u001A\u00020\tH\u0002J\u0018\u0010B\u001A\u00020%2\u0006\u0010C\u001A\u00020\t2\u0006\u0010D\u001A\u00020\u0007H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/InjectionDiagnostics;", "", "<init>", "()V", "TAG", "", "REPORT_INTERVAL_MS", "", "executeCalls", "Ljava/util/concurrent/atomic/AtomicLong;", "moveOffers", "moveCoalesced", "moveDispatched", "moveFailures", "pointer2Down", "pointer2Move", "pointer2Up", "pointer2Cancel", "recenterCount", "dispatcherTicks", "writeNanos", "ackWaitNanos", "executeNanos", "moveExecuteNanos", "moveExecuteCalls", "writeSamples", "ackWaitSamples", "controlBlockedMoveCount", "maxPendingQueue", "maxQueuedItems", "queueWaitNanos", "queueWaitSamples", "queueWaitMax", "lastReport", "lastReportTicks", "recordExecute", "recordMoveOffer", "", "coalesced", "", "recordMoveDispatched", "success", "recordPointer2", "action", "Lcom/TryJeanPc/goldenmouse/injector/TouchCommand$Action;", "recordRecenter", "recordDispatcherTick", "recordWrite", "durationNanos", "recordWriteSample", "recordAckWait", "recordMoveExecute", "recordQueueWait", "nanos", "recordControlBlockedMove", "recordQueueDepth", "pending", "", "queued", "cameraSnapshot", "cameraSnapshot$app", "reportIfDue", "source", "average", "total", "samples", "updateMax", "target", "candidate", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class InjectionDiagnostics {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Action.values().length];
            try {
                v0[Action.ACTION_DOWN.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Action.ACTION_MOVE.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Action.ACTION_UP.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[Action.ACTION_CANCEL.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 0;
    public static final InjectionDiagnostics INSTANCE = null;
    private static final long REPORT_INTERVAL_MS = 1000;
    private static final String TAG = "GOLDEN_AIM_METRICS";
    private static final AtomicLong ackWaitNanos;
    private static final AtomicLong ackWaitSamples;
    private static final AtomicLong controlBlockedMoveCount;
    private static final AtomicLong dispatcherTicks;
    private static final AtomicLong executeCalls;
    private static final AtomicLong executeNanos;
    private static final AtomicLong lastReport;
    private static final AtomicLong lastReportTicks;
    private static final AtomicLong maxPendingQueue;
    private static final AtomicLong maxQueuedItems;
    private static final AtomicLong moveCoalesced;
    private static final AtomicLong moveDispatched;
    private static final AtomicLong moveExecuteCalls;
    private static final AtomicLong moveExecuteNanos;
    private static final AtomicLong moveFailures;
    private static final AtomicLong moveOffers;
    private static final AtomicLong pointer2Cancel;
    private static final AtomicLong pointer2Down;
    private static final AtomicLong pointer2Move;
    private static final AtomicLong pointer2Up;
    private static final AtomicLong queueWaitMax;
    private static final AtomicLong queueWaitNanos;
    private static final AtomicLong queueWaitSamples;
    private static final AtomicLong recenterCount;
    private static final AtomicLong writeNanos;
    private static final AtomicLong writeSamples;

    static {
        InjectionDiagnostics.INSTANCE = new InjectionDiagnostics();
        InjectionDiagnostics.executeCalls = new AtomicLong();
        InjectionDiagnostics.moveOffers = new AtomicLong();
        InjectionDiagnostics.moveCoalesced = new AtomicLong();
        InjectionDiagnostics.moveDispatched = new AtomicLong();
        InjectionDiagnostics.moveFailures = new AtomicLong();
        InjectionDiagnostics.pointer2Down = new AtomicLong();
        InjectionDiagnostics.pointer2Move = new AtomicLong();
        InjectionDiagnostics.pointer2Up = new AtomicLong();
        InjectionDiagnostics.pointer2Cancel = new AtomicLong();
        InjectionDiagnostics.recenterCount = new AtomicLong();
        InjectionDiagnostics.dispatcherTicks = new AtomicLong();
        InjectionDiagnostics.writeNanos = new AtomicLong();
        InjectionDiagnostics.ackWaitNanos = new AtomicLong();
        InjectionDiagnostics.executeNanos = new AtomicLong();
        InjectionDiagnostics.moveExecuteNanos = new AtomicLong();
        InjectionDiagnostics.moveExecuteCalls = new AtomicLong();
        InjectionDiagnostics.writeSamples = new AtomicLong();
        InjectionDiagnostics.ackWaitSamples = new AtomicLong();
        InjectionDiagnostics.controlBlockedMoveCount = new AtomicLong();
        InjectionDiagnostics.maxPendingQueue = new AtomicLong();
        InjectionDiagnostics.maxQueuedItems = new AtomicLong();
        InjectionDiagnostics.queueWaitNanos = new AtomicLong();
        InjectionDiagnostics.queueWaitSamples = new AtomicLong();
        InjectionDiagnostics.queueWaitMax = new AtomicLong();
        InjectionDiagnostics.lastReport = new AtomicLong();
        InjectionDiagnostics.lastReportTicks = new AtomicLong();
        InjectionDiagnostics.$stable = 8;
    }

    private InjectionDiagnostics() {
        super();
    }

    private final long average(AtomicLong arg5, AtomicLong arg6) {
        long v0 = arg6.get();
        long v2 = 0;
        if(v0 == v2) {
            return v2;
        }

        return arg5.get() / v0;
    }

    public final String cameraSnapshot$app() {
        return "transportMoveOffers=" + InjectionDiagnostics.moveOffers.get() + " transportMoveCoalesced=" + InjectionDiagnostics.moveCoalesced.get() + " transportMoveDispatched=" + InjectionDiagnostics.moveDispatched.get() + " transportMoveFailures=" + InjectionDiagnostics.moveFailures.get() + " queueWaitAvgUs=" + this.average(InjectionDiagnostics.queueWaitNanos, InjectionDiagnostics.queueWaitSamples) / 1000 + " queueWaitMaxUs=" + InjectionDiagnostics.queueWaitMax.get() / 1000 + " ackWaitAvgUs=" + this.average(InjectionDiagnostics.ackWaitNanos, InjectionDiagnostics.ackWaitSamples) / 1000 + " maxPendingQueue=" + InjectionDiagnostics.maxPendingQueue.get() + " maxQueuedItems=" + InjectionDiagnostics.maxQueuedItems.get() + " controlBlockedMove=" + InjectionDiagnostics.controlBlockedMoveCount.get();
    }

    public final void recordAckWait(long arg3) {
        InjectionDiagnostics.ackWaitNanos.addAndGet(RangesKt.coerceAtLeast(arg3, 0));
        InjectionDiagnostics.ackWaitSamples.incrementAndGet();
    }

    public final long recordControlBlockedMove() {
        return InjectionDiagnostics.controlBlockedMoveCount.incrementAndGet();
    }

    public final long recordDispatcherTick() {
        return InjectionDiagnostics.dispatcherTicks.incrementAndGet();
    }

    public final long recordExecute() {
        return InjectionDiagnostics.executeCalls.incrementAndGet();
    }

    public final long recordExecute(long arg3) {
        return InjectionDiagnostics.executeNanos.addAndGet(RangesKt.coerceAtLeast(arg3, 0));
    }

    public final void recordMoveDispatched(boolean arg1) {
        InjectionDiagnostics.moveDispatched.incrementAndGet();
        if(!arg1) {
            InjectionDiagnostics.moveFailures.incrementAndGet();
        }
    }

    public final void recordMoveExecute(long arg3) {
        InjectionDiagnostics.moveExecuteNanos.addAndGet(RangesKt.coerceAtLeast(arg3, 0));
        InjectionDiagnostics.moveExecuteCalls.incrementAndGet();
    }

    public final void recordMoveOffer(boolean arg1) {
        InjectionDiagnostics.moveOffers.incrementAndGet();
        if(arg1) {
            InjectionDiagnostics.moveCoalesced.incrementAndGet();
        }
    }

    public final void recordPointer2(Action arg1) {
        Intrinsics.checkNotNullParameter(arg1, "action");
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg1.ordinal()];
        if(v0 != 1) {
            if(v0 != 2) {
                if(v0 != 3) {
                    if(v0 == 4) {
                        InjectionDiagnostics.pointer2Cancel.incrementAndGet();
                        return;
                    }

                    throw new NoWhenBranchMatchedException();
                }

                InjectionDiagnostics.pointer2Up.incrementAndGet();
                return;
            }

            InjectionDiagnostics.pointer2Move.incrementAndGet();
            return;
        }

        InjectionDiagnostics.pointer2Down.incrementAndGet();
    }

    public final void recordQueueDepth(int arg4, int arg5) {
        this.updateMax(InjectionDiagnostics.maxPendingQueue, ((long)arg4));
        this.updateMax(InjectionDiagnostics.maxQueuedItems, ((long)arg5));
    }

    public final void recordQueueWait(long arg2) {
        InjectionDiagnostics.queueWaitNanos.addAndGet(arg2);
        InjectionDiagnostics.queueWaitSamples.incrementAndGet();
        this.updateMax(InjectionDiagnostics.queueWaitMax, arg2);
    }

    public final long recordRecenter() {
        return InjectionDiagnostics.recenterCount.incrementAndGet();
    }

    public final long recordWrite(long arg3) {
        return InjectionDiagnostics.writeNanos.addAndGet(RangesKt.coerceAtLeast(arg3, 0));
    }

    public final void recordWriteSample(long arg1) {
        this.recordWrite(arg1);
        InjectionDiagnostics.writeSamples.incrementAndGet();
    }

    public final void reportIfDue(String arg48) {
        InjectionDiagnostics v0 = this;
        String v1 = arg48;
        Intrinsics.checkNotNullParameter(v1, "source");
        long v2 = SystemClock.uptimeMillis();
        AtomicLong v4 = InjectionDiagnostics.lastReport;
        long v5 = v4.get();
        long v7 = v2 - v5;
        long v9 = 1000;
        if(v7 >= v9) {
            if(!v4.compareAndSet(v5, v2)) {
            }
            else {
                Log.i("GOLDEN_AIM_METRICS", "source=" + v1 + " execute=" + InjectionDiagnostics.executeCalls.get() + " moveOffers=" + InjectionDiagnostics.moveOffers.get() + " moveCoalesced=" + InjectionDiagnostics.moveCoalesced.get() + " moveDispatched=" + InjectionDiagnostics.moveDispatched.get() + " moveFailures=" + InjectionDiagnostics.moveFailures.get() + " recenter=" + InjectionDiagnostics.recenterCount.get() + " dispatcherHz=" + (InjectionDiagnostics.dispatcherTicks.get() - InjectionDiagnostics.lastReportTicks.getAndSet(InjectionDiagnostics.dispatcherTicks.get())) * v9 / RangesKt.coerceAtLeast(v7, 1) + " p2(D/M/U/C)=" + InjectionDiagnostics.pointer2Down.get() + "/" + InjectionDiagnostics.pointer2Move.get() + "/" + InjectionDiagnostics.pointer2Up.get() + "/" + InjectionDiagnostics.pointer2Cancel.get() + " executeMs=" + InjectionDiagnostics.executeNanos.get() / 1000000 + " moveExecuteAvgUs=" + v0.average(InjectionDiagnostics.moveExecuteNanos, InjectionDiagnostics.moveExecuteCalls) / v9 + " writeAvgUs=" + v0.average(InjectionDiagnostics.writeNanos, InjectionDiagnostics.writeSamples) / v9 + " ackWaitAvgUs=" + v0.average(InjectionDiagnostics.ackWaitNanos, InjectionDiagnostics.ackWaitSamples) / v9 + " maxPendingQueue=" + InjectionDiagnostics.maxPendingQueue.get() + " maxQueuedItems=" + InjectionDiagnostics.maxQueuedItems.get() + " controlBlockedMoveCount=" + InjectionDiagnostics.controlBlockedMoveCount.get() + " queueWaitAvgUs=" + v0.average(InjectionDiagnostics.queueWaitNanos, InjectionDiagnostics.queueWaitSamples) / v9 + " queueWaitMaxUs=" + InjectionDiagnostics.queueWaitMax.get() / v9);
            }
        }
    }

    private final void updateMax(AtomicLong arg3, long arg4) {
        do {
            long v0 = arg3.get();
            if(arg4 <= v0) {
                return;
            }
        }
        while(!arg3.compareAndSet(v0, arg4));
    }
}

