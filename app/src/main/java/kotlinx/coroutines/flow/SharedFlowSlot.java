package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\n\u001A\u00020\u000B2\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\u0002H\u0016J\'\u0010\r\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u000E2\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0002\u0010\u000FR\u0012\u0010\u0005\u001A\u00020\u00068\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "<init>", "()V", "index", "", "cont", "Lkotlin/coroutines/Continuation;", "", "allocateLocked", "", "flow", "freeLocked", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;)[Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SharedFlowSlot extends AbstractSharedFlowSlot {
    public Continuation cont;
    public long index;

    public SharedFlowSlot() {
        super();
        this.index = -1;
    }

    public boolean allocateLocked(Object arg1) {
        return this.allocateLocked(((SharedFlowImpl)arg1));
    }

    public boolean allocateLocked(SharedFlowImpl arg5) {
        if(this.index >= 0) {
            return 0;
        }

        this.index = arg5.updateNewCollectorIndexLocked$kotlinx_coroutines_core();
        return 1;
    }

    public Continuation[] freeLocked(Object arg1) {
        return this.freeLocked(((SharedFlowImpl)arg1));
    }

    public Continuation[] freeLocked(SharedFlowImpl arg5) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.index >= 0) {
            }
            else {
                throw new AssertionError();
            }
        }

        long v0 = this.index;
        this.index = -1;
        this.cont = null;
        return arg5.updateCollectorIndexLocked$kotlinx_coroutines_core(v0);
    }
}

