package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000E\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0002R\u0014\u0010\u0007\u001A\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\r"}, d2={"Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "initialValue", "<init>", "(I)V", "value", "getValue", "()Ljava/lang/Integer;", "increment", "", "delta", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class SubscriptionCountStateFlow extends SharedFlowImpl implements StateFlow {
    public SubscriptionCountStateFlow(int arg4) {
        super(1, 0x7FFFFFFF, BufferOverflow.DROP_OLDEST);
        this.tryEmit(Integer.valueOf(arg4));
    }

    public Integer getValue() {
        Integer v0_1;
        __monitor_enter(this);
        try {
            v0_1 = Integer.valueOf(this.getLastReplayedLocked().intValue());
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public Object getValue() {
        return this.getValue();
    }

    public final boolean increment(int arg2) {
        boolean v2_1;
        __monitor_enter(this);
        try {
            v2_1 = this.tryEmit(Integer.valueOf(this.getLastReplayedLocked().intValue() + arg2));
        }
        catch(Throwable v2) {
            __monitor_exit(this);
            throw v2;
        }

        __monitor_exit(this);
        return v2_1;
    }
}

