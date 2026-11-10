package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0012\u0010\u0000\u001A\u00020\u00012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u001A\u0019\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\u0000\u001AJ\u0010\u0005\u001A\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\'\u0010\u0007\u001A#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\b¢\u0006\u0002\b\fH\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\r¨\u0006\u000E"}, d2={"SupervisorJob", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "SupervisorJob0", "supervisorScope", "R", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SupervisorKt {
    public static final CompletableJob SupervisorJob(Job arg1) {
        return new SupervisorJobImpl(arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static final Job SupervisorJob(Job arg0) {
        return SupervisorKt.SupervisorJob(arg0);
    }

    public static CompletableJob SupervisorJob$default(Job arg0, int arg1, Object arg2) {
        if((arg1 & 1) != 0) {
            arg0 = null;
        }

        return SupervisorKt.SupervisorJob(arg0);
    }

    public static Job SupervisorJob$default(Job arg0, int arg1, Object arg2) {
        if((arg1 & 1) != 0) {
            arg0 = null;
        }

        return SupervisorKt.SupervisorJob(arg0);
    }

    public static final Object supervisorScope(Function2 arg2, Continuation arg3) {
        SupervisorCoroutine v0 = new SupervisorCoroutine(arg3.getContext(), arg3);
        Object v2 = UndispatchedKt.startUndispatchedOrReturn(v0, v0, arg2);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg3);
        }

        return v2;
    }
}

