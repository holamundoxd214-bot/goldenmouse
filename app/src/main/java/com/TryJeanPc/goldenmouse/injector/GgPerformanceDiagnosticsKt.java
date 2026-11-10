package com.TryJeanPc.goldenmouse.injector;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0002¨\u0006\u0006"}, d2={"updateGgMaximum", "", "target", "Ljava/util/concurrent/atomic/AtomicLong;", "value", "", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class GgPerformanceDiagnosticsKt {
    public static final void access$updateGgMaximum(AtomicLong arg0, long arg1) {
        GgPerformanceDiagnosticsKt.updateGgMaximum(arg0, arg1);
    }

    private static final void updateGgMaximum(AtomicLong arg3, long arg4) {
        do {
            long v0 = arg3.get();
            if(arg4 <= v0) {
                return;
            }
        }
        while(!arg3.compareAndSet(v0, arg4));
    }
}

