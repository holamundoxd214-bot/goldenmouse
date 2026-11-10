package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001E\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000\u001A&\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0002\u001AX\u0010\b\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t2\u0006\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u0002H\t2\b\b\u0002\u0010\f\u001A\u00020\r2\"\u0010\u000E\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000FH\u0080@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2={"asChannelFlow", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "withUndispatchedContextCollector", "Lkotlinx/coroutines/flow/FlowCollector;", "emitContext", "Lkotlin/coroutines/CoroutineContext;", "withContextUndispatched", "V", "newContext", "value", "countOrElement", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ChannelFlowKt {
    public static final FlowCollector access$withUndispatchedContextCollector(FlowCollector arg0, CoroutineContext arg1) {
        return ChannelFlowKt.withUndispatchedContextCollector(arg0, arg1);
    }

    public static final ChannelFlow asChannelFlow(Flow arg8) {
        Flow v0 = (arg8 instanceof ChannelFlow) ? arg8 : null;
        if(v0 == null) {
            return new ChannelFlowOperatorImpl(arg8, null, 0, null, 14, null);
        }

        return ((ChannelFlow)v0);
    }

    public static final Object withContextUndispatched(CoroutineContext arg2, Object arg3, Object arg4, Function2 arg5, Continuation arg6) {
        arg4 = ThreadContextKt.updateThreadContext(arg2, arg4);
        try {
            StackFrameContinuation v0 = new StackFrameContinuation(arg6, arg2);
            arg3 = !(arg5 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(arg5, arg3, ((Continuation)v0)) : TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg5, 2).invoke(arg3, v0);
        }
        catch(Throwable v3) {
            ThreadContextKt.restoreThreadContext(arg2, arg4);
            throw v3;
        }

        ThreadContextKt.restoreThreadContext(arg2, arg4);
        if(arg3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg6);
        }

        return arg3;
    }

    public static Object withContextUndispatched$default(CoroutineContext arg0, Object arg1, Object arg2, Function2 arg3, Continuation arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg2 = ThreadContextKt.threadContextElements(arg0);
        }

        return ChannelFlowKt.withContextUndispatched(arg0, arg1, arg2, arg3, arg4);
    }

    private static final FlowCollector withUndispatchedContextCollector(FlowCollector arg1, CoroutineContext arg2) {
        if(!(arg1 instanceof SendingCollector)) {
            if((arg1 instanceof NopCollector)) {
            }
            else {
                return new UndispatchedContextCollector(arg1, arg2);
            }
        }

        return arg1;
    }
}

