package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0006\u001A\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00070\fH\u0000¢\u0006\u0004\b\r\u0010\u000EJ\u001B\u0010\u000F\u001A\u00020\n2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\b\u0010J\u0006\u0010\u0011\u001A\u00020\nR\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/compose/runtime/SnapshotFlowManager;", "", "<init>", "()V", "managerImpl", "Landroidx/compose/runtime/SnapshotFlowManagerImpl;", "runAndWatch", "T", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "", "block", "Lkotlin/Function0;", "runAndWatch$runtime", "(Lkotlinx/coroutines/channels/SendChannel;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "reportSnapshotFlowCancellation", "reportSnapshotFlowCancellation$runtime", "dispose", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SnapshotFlowManager {
    public static final int $stable = 8;
    private SnapshotFlowManagerImpl managerImpl;

    static {
    }

    public SnapshotFlowManager() {
        super();
        this.managerImpl = new SingleSubscriptionSnapshotFlowManager();
    }

    public final void dispose() {
        SnapshotFlowManagerImpl v0 = this.managerImpl;
        int v1 = v0 != null ? 1 : 0;
        if(v1 == 0) {
            PreconditionsKt.throwIllegalStateException("Called dispose on a manager that has been disposed of");
        }

        v0.dispose$runtime();
        this.managerImpl = null;
    }

    public final void reportSnapshotFlowCancellation$runtime(SendChannel arg1) {
        SnapshotFlowManagerImpl v0 = this.managerImpl;
        if(v0 != null) {
            v0.reportSnapshotFlowCancellation$runtime(arg1);
        }
    }

    public final Object runAndWatch$runtime(SendChannel arg3, Function0 arg4) {
        int v0 = this.managerImpl != null ? 1 : 0;
        if(v0 == 0) {
            PreconditionsKt.throwIllegalStateException("Called runAndWatch on a manager that has been disposed of");
        }

        SnapshotFlowManagerImpl v0_1 = this.managerImpl;
        if((v0_1 instanceof SingleSubscriptionSnapshotFlowManager)) {
            SendChannel v1 = ((SingleSubscriptionSnapshotFlowManager)v0_1).getSubscribedChannel();
            if(v1 != null && !Intrinsics.areEqual(v1, arg3)) {
                this.managerImpl = ((SingleSubscriptionSnapshotFlowManager)v0_1).promote();
            }
        }

        SnapshotFlowManagerImpl v2 = this.managerImpl;
        Intrinsics.checkNotNull(v2);
        return v2.runAndWatch$runtime(arg3, arg4);
    }
}

