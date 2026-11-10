package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A\u001E\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0004\u001AB\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0005\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0086@¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2={"count", "", "T", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__CountKt {
    public static final Object count(Flow arg4, Continuation arg5) {
        IntRef v4_1;
        int v2;
        Continuation v0;
        if((arg5 instanceof FlowKt__CountKt$count$1)) {
            v0 = arg5;
            v2 = 0x80000000;
            if((((FlowKt__CountKt$count$1)v0).label & v2) != 0) {
                ((FlowKt__CountKt$count$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            FlowKt__CountKt$count$1 v0_1 = new FlowKt__CountKt$count$1(arg5);
        }

        Object v5 = ((FlowKt__CountKt$count$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((FlowKt__CountKt$count$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            IntRef v5_1 = new IntRef();
            FlowKt__CountKt$count$2 v2_1 = new FlowKt__CountKt$count$2(v5_1);
            ((FlowKt__CountKt$count$1)v0).L$0 = v5_1;
            ((FlowKt__CountKt$count$1)v0).label = 1;
            if(arg4.collect(((FlowCollector)v2_1), v0) == v1) {
                return v1;
            }
            else {
                v4_1 = v5_1;
            }
        }
        else if(v2 == 1) {
            Object v4 = ((FlowKt__CountKt$count$1)v0).L$0;
            ResultKt.throwOnFailure(v5);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Boxing.boxInt(v4_1.element);
    }

    public static final Object count(Flow arg4, Function2 arg5, Continuation arg6) {
        IntRef v4_1;
        FlowKt__CountKt$count$3 v0_1;
        int v2;
        if((arg6 instanceof FlowKt__CountKt$count$3)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((FlowKt__CountKt$count$3)v0).label & v2) != 0) {
                ((FlowKt__CountKt$count$3)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new FlowKt__CountKt$count$3(arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            IntRef v6_1 = new IntRef();
            FlowKt__CountKt$count$4 v2_1 = new FlowKt__CountKt$count$4(arg5, v6_1);
            v0_1.L$0 = v6_1;
            v0_1.label = 1;
            if(arg4.collect(((FlowCollector)v2_1), ((Continuation)v0_1)) == v1) {
                return v1;
            }
            else {
                v4_1 = v6_1;
            }
        }
        else if(v2 == 1) {
            Object v4 = v0_1.L$0;
            ResultKt.throwOnFailure(v6);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Boxing.boxInt(v4_1.element);
    }
}

