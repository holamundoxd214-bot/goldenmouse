package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001AB\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0086@¢\u0006\u0002\u0010\b\u001AB\u0010\t\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0086@¢\u0006\u0002\u0010\b\u001AB\u0010\n\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0086@¢\u0006\u0002\u0010\b¨\u0006\u000B"}, d2={"any", "", "T", "Lkotlinx/coroutines/flow/Flow;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "all", "none", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__LogicKt {
    public static final Object all(Flow arg4, Function2 arg5, Continuation arg6) {
        FlowKt__LogicKt$all$$inlined$collectWhile$1 v4_2;
        BooleanRef v5_1;
        int v2;
        Continuation v0;
        if((arg6 instanceof FlowKt__LogicKt$all$1)) {
            v0 = arg6;
            v2 = 0x80000000;
            if((((FlowKt__LogicKt$all$1)v0).label & v2) != 0) {
                ((FlowKt__LogicKt$all$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            FlowKt__LogicKt$all$1 v0_1 = new FlowKt__LogicKt$all$1(arg6);
        }

        Object v6 = ((FlowKt__LogicKt$all$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((FlowKt__LogicKt$all$1)v0).label;
        if(v2 != 0) {
            if(v2 == 1) {
                Object v4 = ((FlowKt__LogicKt$all$1)v0).L$1;
                Object v5 = ((FlowKt__LogicKt$all$1)v0).L$0;
                try {
                    ResultKt.throwOnFailure(v6);
                    goto label_50;
                }
                catch(AbortFlowException v6_1) {
                    goto label_47;
                }
            }

            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        ResultKt.throwOnFailure(v6);
        BooleanRef v6_2 = new BooleanRef();
        FlowKt__LogicKt$all$$inlined$collectWhile$1 v2_1 = new FlowKt__LogicKt$all$$inlined$collectWhile$1(arg5, v6_2);
        try {
            ((FlowKt__LogicKt$all$1)v0).L$0 = v6_2;
            ((FlowKt__LogicKt$all$1)v0).L$1 = v2_1;
            ((FlowKt__LogicKt$all$1)v0).label = 1;
            if(arg4.collect(v2_1, v0) != v1) {
                goto label_41;
            }

            return v1;
        }
        catch(AbortFlowException v4_1) {
            v5_1 = v6_2;
            v6_1 = v4_1;
            v4_2 = v2_1;
        }

    label_47:
        FlowExceptions_commonKt.checkOwnership(v6_1, v4_2);
        JobKt.ensureActive(v0.getContext());
        goto label_50;
        return v1;
    label_41:
        v5_1 = v6_2;
    label_50:
        return Boxing.boxBoolean(v5_1.element ^ 1);
    }

    public static final Object any(Flow arg4, Function2 arg5, Continuation arg6) {
        BooleanRef v5_1;
        Object v5;
        Object v4;
        FlowKt__LogicKt$any$1 v0_1;
        int v2;
        if((arg6 instanceof FlowKt__LogicKt$any$1)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((FlowKt__LogicKt$any$1)v0).label & v2) != 0) {
                ((FlowKt__LogicKt$any$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new FlowKt__LogicKt$any$1(arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 != 0) {
            if(v2 == 1) {
                v4 = v0_1.L$1;
                v5 = v0_1.L$0;
                try {
                    ResultKt.throwOnFailure(v6);
                    goto label_50;
                }
                catch(AbortFlowException v6_1) {
                    goto label_47;
                }
            }

            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        ResultKt.throwOnFailure(v6);
        BooleanRef v6_2 = new BooleanRef();
        FlowKt__LogicKt$any$$inlined$collectWhile$1 v2_1 = new FlowKt__LogicKt$any$$inlined$collectWhile$1(arg5, v6_2);
        try {
            v0_1.L$0 = v6_2;
            v0_1.L$1 = v2_1;
            v0_1.label = 1;
            if(arg4.collect(v2_1, ((Continuation)v0_1)) != v1) {
                goto label_41;
            }

            return v1;
        }
        catch(AbortFlowException v4_1) {
            v5_1 = v6_2;
            v6_1 = v4_1;
            FlowKt__LogicKt$any$$inlined$collectWhile$1 v4_2 = v2_1;
        }

    label_47:
        FlowExceptions_commonKt.checkOwnership(v6_1, v4);
        JobKt.ensureActive(((Continuation)v0_1).getContext());
        goto label_50;
        return v1;
    label_41:
        v5_1 = v6_2;
    label_50:
        return Boxing.boxBoolean(((BooleanRef)v5).element);
    }

    public static final Object none(Flow arg4, Function2 arg5, Continuation arg6) {
        int v2;
        Continuation v0;
        if((arg6 instanceof FlowKt__LogicKt$none$1)) {
            v0 = arg6;
            v2 = 0x80000000;
            if((((FlowKt__LogicKt$none$1)v0).label & v2) != 0) {
                ((FlowKt__LogicKt$none$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            FlowKt__LogicKt$none$1 v0_1 = new FlowKt__LogicKt$none$1(arg6);
        }

        Object v6 = ((FlowKt__LogicKt$none$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((FlowKt__LogicKt$none$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            ((FlowKt__LogicKt$none$1)v0).label = 1;
            v6 = FlowKt.any(arg4, arg5, v0);
            if(v6 == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v6);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Boxing.boxBoolean(((Boolean)v6).booleanValue() ^ 1);
    }
}

