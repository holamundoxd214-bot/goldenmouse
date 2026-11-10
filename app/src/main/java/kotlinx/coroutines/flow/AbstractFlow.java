package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.internal.SafeCollector;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001C\u0010\u0006\u001A\u00020\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tH\u0086@¢\u0006\u0002\u0010\nJ\u001C\u0010\u000B\u001A\u00020\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tH¦@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2={"Lkotlinx/coroutines/flow/AbstractFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "<init>", "()V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class AbstractFlow implements CancellableFlow, Flow {
    public AbstractFlow() {
        super();
    }

    public final Object collect(FlowCollector arg5, Continuation arg6) {
        SafeCollector v4_1;
        AbstractFlow$collect$1 v0_1;
        int v2;
        if((arg6 instanceof AbstractFlow$collect$1)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((AbstractFlow$collect$1)v0).label & v2) != 0) {
                ((AbstractFlow$collect$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new AbstractFlow$collect$1(this, arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            SafeCollector v6_1 = new SafeCollector(arg5, ((Continuation)v0_1).getContext());
            try {
                v0_1.L$0 = v6_1;
                v0_1.label = 1;
                if(this.collectSafely(v6_1, ((Continuation)v0_1)) != v1) {
                    goto label_38;
                }

                return v1;
            }
            catch(Throwable v5) {
                v4_1 = v6_1;
            }

        label_44:
            v4_1.releaseIntercepted();
            throw v5;
            return v1;
        label_38:
            v4_1 = v6_1;
        }
        else if(v2 == 1) {
            Object v4 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v6);
            }
            catch(Throwable v5) {
                goto label_44;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        v4_1.releaseIntercepted();
        return Unit.INSTANCE;
    }

    public abstract Object collectSafely(FlowCollector arg1, Continuation arg2);
}

