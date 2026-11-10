package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BT\u0012-\u0010\u0003\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u000F¢\u0006\u0004\b\u0010\u0010\u0011J\u001C\u0010\u0013\u001A\u00020\u00072\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0094@¢\u0006\u0002\u0010\u0015J&\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0014R7\u0010\u0003\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u0018"}, d2={"Lkotlinx/coroutines/flow/CallbackFlowBuilder;", "T", "Lkotlinx/coroutines/flow/ChannelFlowBuilder;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlin/jvm/functions/Function2;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class CallbackFlowBuilder extends ChannelFlowBuilder {
    private final Function2 block;

    public CallbackFlowBuilder(Function2 arg1, CoroutineContext arg2, int arg3, BufferOverflow arg4) {
        super(arg1, arg2, arg3, arg4);
        this.block = arg1;
    }

    public CallbackFlowBuilder(Function2 arg1, CoroutineContext arg2, int arg3, BufferOverflow arg4, int arg5, DefaultConstructorMarker arg6) {
        EmptyCoroutineContext v2;
        if((arg5 & 2) != 0) {
            v2 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg5 & 4) != 0) {
            arg3 = -2;
        }

        if((arg5 & 8) != 0) {
            arg4 = BufferOverflow.SUSPEND;
        }

        this(arg1, ((CoroutineContext)v2), arg3, arg4);
    }

    protected Object collectTo(ProducerScope arg5, Continuation arg6) {
        int v2;
        Continuation v0;
        if((arg6 instanceof CallbackFlowBuilder$collectTo$1)) {
            v0 = arg6;
            v2 = 0x80000000;
            if((((CallbackFlowBuilder$collectTo$1)v0).label & v2) != 0) {
                ((CallbackFlowBuilder$collectTo$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            CallbackFlowBuilder$collectTo$1 v0_1 = new CallbackFlowBuilder$collectTo$1(this, arg6);
        }

        Object v6 = ((CallbackFlowBuilder$collectTo$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((CallbackFlowBuilder$collectTo$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            ((CallbackFlowBuilder$collectTo$1)v0).L$0 = arg5;
            ((CallbackFlowBuilder$collectTo$1)v0).label = 1;
            if(super.collectTo(arg5, v0) == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            Object v5 = ((CallbackFlowBuilder$collectTo$1)v0).L$0;
            ResultKt.throwOnFailure(v6);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        if(((ProducerScope)v5).isClosedForSend()) {
            return Unit.INSTANCE;
        }

        throw new IllegalStateException("\'awaitClose { yourCallbackOrListener.cancel() }\' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    }

    protected ChannelFlow create(CoroutineContext arg2, int arg3, BufferOverflow arg4) {
        return new CallbackFlowBuilder(this.block, arg2, arg3, arg4);
    }
}

