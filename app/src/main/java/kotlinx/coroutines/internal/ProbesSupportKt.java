package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001A#\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0080\b\u001A\u001D\u0010\u0004\u001A\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0080\b¨\u0006\u0006"}, d2={"probeCoroutineCreated", "Lkotlin/coroutines/Continuation;", "T", "completion", "probeCoroutineResumed", "", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ProbesSupportKt {
    public static final Continuation probeCoroutineCreated(Continuation arg0) {
        return DebugProbesKt.probeCoroutineCreated(arg0);
    }

    public static final void probeCoroutineResumed(Continuation arg0) {
        DebugProbesKt.probeCoroutineResumed(arg0);
    }
}

