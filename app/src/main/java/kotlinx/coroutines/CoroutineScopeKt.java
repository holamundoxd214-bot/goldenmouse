package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0003\n\u0002\b\u0004\u001A\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0086\u0002\u001A\u0006\u0010\u0004\u001A\u00020\u0001\u001AJ\u0010\n\u001A\u0002H\u000B\"\u0004\b\u0000\u0010\u000B2\'\u0010\f\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000B0\u000E\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\r¢\u0006\u0002\b\u0010H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0011\u001A\u000E\u0010\u0012\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003\u001A!\u0010\u0013\u001A\u00020\u0014*\u00020\u00012\u0010\b\u0002\u0010\u0015\u001A\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u0017¢\u0006\u0002\u0010\u0018\u001A\u001E\u0010\u0013\u001A\u00020\u0014*\u00020\u00012\u0006\u0010\u0019\u001A\u00020\u001A2\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u001B\u001A\n\u0010\u001C\u001A\u00020\u0014*\u00020\u0001\u001A\u000E\u0010\u001D\u001A\u00020\u0003H\u0086H¢\u0006\u0002\u0010\u001E\"\u001B\u0010\u0005\u001A\u00020\u0006*\u00020\u00018F¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001A\u0004\b\u0005\u0010\t¨\u0006\u001F"}, d2={"plus", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "isActive", "", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CoroutineScope", "cancel", "", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Lkotlinx/coroutines/CoroutineScope;Ljava/util/concurrent/CancellationException;)V", "message", "", "", "ensureActive", "currentCoroutineContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CoroutineScopeKt {
    public static final CoroutineScope CoroutineScope(CoroutineContext arg3) {
        if(arg3.get(Job.Key) != null) {
        }
        else {
            arg3 = arg3.plus(JobKt.Job$default(null, 1, null));
        }

        return new ContextScope(arg3);
    }

    public static final CoroutineScope MainScope() {
        return new ContextScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
    }

    public static final void cancel(CoroutineScope arg2, CancellationException arg3) {
        Element v0 = arg2.getCoroutineContext().get(Job.Key);
        if(v0 != null) {
            ((Job)v0).cancel(arg3);
            return;
        }

        throw new IllegalStateException("Scope cannot be cancelled because it does not have a job: " + arg2.toString());
    }

    public static final void cancel(CoroutineScope arg0, String arg1, Throwable arg2) {
        CoroutineScopeKt.cancel(arg0, ExceptionsKt.CancellationException(arg1, arg2));
    }

    public static void cancel$default(CoroutineScope arg0, CancellationException arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        CoroutineScopeKt.cancel(arg0, arg1);
    }

    public static void cancel$default(CoroutineScope arg0, String arg1, Throwable arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        CoroutineScopeKt.cancel(arg0, arg1, arg2);
    }

    public static final Object coroutineScope(Function2 arg2, Continuation arg3) {
        ScopeCoroutine v0 = new ScopeCoroutine(arg3.getContext(), arg3);
        Object v2 = UndispatchedKt.startUndispatchedOrReturn(v0, v0, arg2);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg3);
        }

        return v2;
    }

    public static final Object currentCoroutineContext(Continuation arg0) {
        return arg0.getContext();
    }

    private static final Object currentCoroutineContext$$forInline(Continuation arg0) {
        null.getContext();
        throw null;
    }

    public static final void ensureActive(CoroutineScope arg0) {
        JobKt.ensureActive(arg0.getCoroutineContext());
    }

    public static final boolean isActive(CoroutineScope arg1) {
        Element v1 = arg1.getCoroutineContext().get(Job.Key);
        if(v1 != null) {
            return ((Job)v1).isActive();
        }

        return 1;
    }

    public static void isActive$annotations(CoroutineScope arg0) {
    }

    public static final CoroutineScope plus(CoroutineScope arg1, CoroutineContext arg2) {
        return new ContextScope(arg1.getCoroutineContext().plus(arg2));
    }
}

