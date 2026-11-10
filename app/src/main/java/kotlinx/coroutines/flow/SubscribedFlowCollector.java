package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.SafeCollector;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BD\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000BJ\u000E\u0010\r\u001A\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u000EJ\u0016\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00028\u0000H\u0096A¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u0004\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0012"}, d2={"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "onSubscription", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SubscribedFlowCollector implements FlowCollector {
    private final Function2 action;
    private final FlowCollector collector;

    public SubscribedFlowCollector(FlowCollector arg1, Function2 arg2) {
        super();
        this.collector = arg1;
        this.action = arg2;
    }

    public Object emit(Object arg1, Continuation arg2) {
        return this.collector.emit(arg1, arg2);
    }

    public final Object onSubscription(Continuation arg8) {
        SafeCollector v7_2;
        SubscribedFlowCollector$onSubscription$1 v0_1;
        int v2;
        if((arg8 instanceof SubscribedFlowCollector$onSubscription$1)) {
            Continuation v0 = arg8;
            v2 = 0x80000000;
            if((((SubscribedFlowCollector$onSubscription$1)v0).label & v2) != 0) {
                ((SubscribedFlowCollector$onSubscription$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new SubscribedFlowCollector$onSubscription$1(this, arg8);
        }

        Object v8 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            SafeCollector v8_2 = new SafeCollector(this.collector, ((Continuation)v0_1).getContext());
            try {
                Function2 v2_2 = this.action;
                v0_1.L$0 = this;
                v0_1.L$1 = v8_2;
                v0_1.label = 1;
                if(v2_2.invoke(v8_2, v0_1) != v1) {
                    goto label_45;
                }

                return v1;
            }
            catch(Throwable v7_1) {
                SafeCollector v6 = v8_2;
                v8_1 = v7_1;
                v7_2 = v6;
            }

        label_66:
            v7_2.releaseIntercepted();
            throw v8_1;
            return v1;
        label_45:
            SubscribedFlowCollector v2_3 = this;
            v7_2 = v8_2;
        label_47:
            v7_2.releaseIntercepted();
            FlowCollector v7_3 = v2_3.collector;
            if((v7_3 instanceof SubscribedFlowCollector)) {
                v0_1.L$0 = null;
                v0_1.L$1 = null;
                v0_1.label = v3;
                if(((SubscribedFlowCollector)v7_3).onSubscription(((Continuation)v0_1)) == v1) {
                    return v1;
                }
            }
            else {
                goto label_60;
            }
        }
        else if(v2 == 1) {
            Object v7 = v0_1.L$1;
            Object v2_1 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v8);
                goto label_47;
            }
            catch(Throwable v8_1) {
                goto label_66;
            }
        }
        else if(v2 == v3) {
            ResultKt.throwOnFailure(v8);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Unit.INSTANCE;
    label_60:
        return Unit.INSTANCE;
    }
}

