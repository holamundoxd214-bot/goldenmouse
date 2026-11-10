package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0014\u0010\u0000\u001A\u00020\u00012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003H\u0000\u001A\u0014\u0010\u0004\u001A\u00020\u00012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003H\u0000\u001A\"\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0003\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0003H\u0000¨\u0006\b"}, d2={"probeCoroutineResumed", "", "frame", "Lkotlin/coroutines/Continuation;", "probeCoroutineSuspended", "probeCoroutineCreated", "T", "completion", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class DebugProbesKt {
    public static final Continuation probeCoroutineCreated(Continuation arg1) {
        return DebugProbesImpl.INSTANCE.probeCoroutineCreated$kotlinx_coroutines_core(arg1);
    }

    public static final void probeCoroutineResumed(Continuation arg1) {
        DebugProbesImpl.INSTANCE.probeCoroutineResumed$kotlinx_coroutines_core(arg1);
    }

    public static final void probeCoroutineSuspended(Continuation arg1) {
        DebugProbesImpl.INSTANCE.probeCoroutineSuspended$kotlinx_coroutines_core(arg1);
    }
}

