package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0001\u001A\u0010\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0001¨\u0006\u0005"}, d2={"isSchedulerWorker", "", "thread", "Ljava/lang/Thread;", "mayNotBlock", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CoroutineSchedulerKt {
    public static final boolean isSchedulerWorker(Thread arg0) {
        return arg0 instanceof Worker;
    }

    public static final boolean mayNotBlock(Thread arg1) {
        if(((arg1 instanceof Worker)) && ((Worker)arg1).state == WorkerState.CPU_ACQUIRED) {
            return 1;
        }

        return 0;
    }
}

