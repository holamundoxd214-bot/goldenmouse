package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata(d1={"\u0000.\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\u001Ap\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\b\b\u0001\u0010\u0002*\u0002H\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00032F\u0010\u0004\u001AB\b\u0001\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0005H\u0086@¢\u0006\u0002\u0010\f\u001Av\u0010\r\u001A\u0002H\u000E\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000E*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000F\u001A\u0002H\u000E2H\b\u0004\u0010\u0004\u001AB\b\u0001\u0012\u0013\u0012\u0011H\u000E¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000E0\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0005H\u0086H¢\u0006\u0002\u0010\u0011\u001A\u001E\u0010\u0012\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0013\u001A \u0010\u0014\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0013\u001A\u001E\u0010\u0015\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0013\u001AB\u0010\u0015\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0016\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0017H\u0086@¢\u0006\u0002\u0010\u0019\u001A \u0010\u001A\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0013\u001AD\u0010\u001A\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0016\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0017H\u0086@¢\u0006\u0002\u0010\u0019\u001A\u001E\u0010\u001B\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0013\u001A \u0010\u001C\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0013¨\u0006\u001D"}, d2={"reduce", "S", "T", "Lkotlinx/coroutines/flow/Flow;", "operation", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "accumulator", "value", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fold", "R", "initial", "acc", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "single", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "singleOrNull", "first", "predicate", "Lkotlin/Function2;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstOrNull", "last", "lastOrNull", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__ReduceKt {
    public static final Object first(Flow arg5, Continuation arg6) {
        FlowKt__ReduceKt$first$$inlined$collectWhile$1 v5_2;
        ObjectRef v1_1;
        int v2;
        Continuation v0;
        if((arg6 instanceof FlowKt__ReduceKt$first$1)) {
            v0 = arg6;
            v2 = 0x80000000;
            if((((FlowKt__ReduceKt$first$1)v0).label & v2) != 0) {
                ((FlowKt__ReduceKt$first$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            FlowKt__ReduceKt$first$1 v0_1 = new FlowKt__ReduceKt$first$1(arg6);
        }

        Object v6 = ((FlowKt__ReduceKt$first$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((FlowKt__ReduceKt$first$1)v0).label;
        if(v2 != 0) {
            if(v2 == 1) {
                Object v5 = ((FlowKt__ReduceKt$first$1)v0).L$1;
                v1 = ((FlowKt__ReduceKt$first$1)v0).L$0;
                try {
                    ResultKt.throwOnFailure(v6);
                    goto label_52;
                }
                catch(AbortFlowException v6_1) {
                    goto label_49;
                }
            }

            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        ResultKt.throwOnFailure(v6);
        ObjectRef v6_2 = new ObjectRef();
        v6_2.element = NullSurrogateKt.NULL;
        FlowKt__ReduceKt$first$$inlined$collectWhile$1 v2_1 = new FlowKt__ReduceKt$first$$inlined$collectWhile$1(v6_2);
        try {
            ((FlowKt__ReduceKt$first$1)v0).L$0 = v6_2;
            ((FlowKt__ReduceKt$first$1)v0).L$1 = v2_1;
            ((FlowKt__ReduceKt$first$1)v0).label = 1;
            if(arg5.collect(v2_1, v0) != v1) {
                goto label_43;
            }

            return v1;
        }
        catch(AbortFlowException v5_1) {
            v1_1 = v6_2;
            v6_1 = v5_1;
            v5_2 = v2_1;
        }

    label_49:
        FlowExceptions_commonKt.checkOwnership(v6_1, v5_2);
        JobKt.ensureActive(v0.getContext());
        goto label_52;
        return v1;
    label_43:
        v1_1 = v6_2;
    label_52:
        if(((ObjectRef)v1).element != NullSurrogateKt.NULL) {
            return ((ObjectRef)v1).element;
        }

        throw new NoSuchElementException("Expected at least one element");
    }

    public static final Object first(Flow arg4, Function2 arg5, Continuation arg6) {
        ObjectRef v5_1;
        Object v5;
        Object v4;
        FlowKt__ReduceKt$first$3 v0_1;
        int v2;
        if((arg6 instanceof FlowKt__ReduceKt$first$3)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((FlowKt__ReduceKt$first$3)v0).label & v2) != 0) {
                ((FlowKt__ReduceKt$first$3)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new FlowKt__ReduceKt$first$3(arg6);
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
                    goto label_52;
                }
                catch(AbortFlowException v6_1) {
                    goto label_49;
                }
            }

            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        ResultKt.throwOnFailure(v6);
        ObjectRef v6_2 = new ObjectRef();
        v6_2.element = NullSurrogateKt.NULL;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2 v2_1 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2(arg5, v6_2);
        try {
            v0_1.L$0 = v6_2;
            v0_1.L$1 = v2_1;
            v0_1.label = 1;
            if(arg4.collect(v2_1, ((Continuation)v0_1)) != v1) {
                goto label_43;
            }

            return v1;
        }
        catch(AbortFlowException v4_1) {
            v5_1 = v6_2;
            v6_1 = v4_1;
            FlowKt__ReduceKt$first$$inlined$collectWhile$2 v4_2 = v2_1;
        }

    label_49:
        FlowExceptions_commonKt.checkOwnership(v6_1, v4);
        JobKt.ensureActive(((Continuation)v0_1).getContext());
        goto label_52;
        return v1;
    label_43:
        v5_1 = v6_2;
    label_52:
        if(((ObjectRef)v5).element != NullSurrogateKt.NULL) {
            return ((ObjectRef)v5).element;
        }

        throw new NoSuchElementException("Expected at least one element matching the predicate");
    }

    public static final Object firstOrNull(Flow arg5, Continuation arg6) {
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1 v5_2;
        ObjectRef v1_1;
        FlowKt__ReduceKt$firstOrNull$1 v0_1;
        int v2;
        if((arg6 instanceof FlowKt__ReduceKt$firstOrNull$1)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((FlowKt__ReduceKt$firstOrNull$1)v0).label & v2) != 0) {
                ((FlowKt__ReduceKt$firstOrNull$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new FlowKt__ReduceKt$firstOrNull$1(arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 != 0) {
            if(v2 == 1) {
                Object v5 = v0_1.L$1;
                v1 = v0_1.L$0;
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
        ObjectRef v6_2 = new ObjectRef();
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1 v2_1 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1(v6_2);
        try {
            v0_1.L$0 = v6_2;
            v0_1.L$1 = v2_1;
            v0_1.label = 1;
            if(arg5.collect(v2_1, ((Continuation)v0_1)) != v1) {
                goto label_41;
            }

            return v1;
        }
        catch(AbortFlowException v5_1) {
            v1_1 = v6_2;
            v6_1 = v5_1;
            v5_2 = v2_1;
        }

    label_47:
        FlowExceptions_commonKt.checkOwnership(v6_1, v5_2);
        JobKt.ensureActive(((Continuation)v0_1).getContext());
        goto label_50;
        return v1;
    label_41:
        v1_1 = v6_2;
    label_50:
        return v1_1.element;
    }

    public static final Object firstOrNull(Flow arg4, Function2 arg5, Continuation arg6) {
        ObjectRef v5_1;
        Object v5;
        Object v4;
        FlowKt__ReduceKt$firstOrNull$3 v0_1;
        int v2;
        if((arg6 instanceof FlowKt__ReduceKt$firstOrNull$3)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((FlowKt__ReduceKt$firstOrNull$3)v0).label & v2) != 0) {
                ((FlowKt__ReduceKt$firstOrNull$3)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new FlowKt__ReduceKt$firstOrNull$3(arg6);
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
        ObjectRef v6_2 = new ObjectRef();
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 v2_1 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2(arg5, v6_2);
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
            FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 v4_2 = v2_1;
        }

    label_47:
        FlowExceptions_commonKt.checkOwnership(v6_1, v4);
        JobKt.ensureActive(((Continuation)v0_1).getContext());
        goto label_50;
        return v1;
    label_41:
        v5_1 = v6_2;
    label_50:
        return ((ObjectRef)v5).element;
    }

    public static final Object fold(Flow arg4, Object arg5, Function3 arg6, Continuation arg7) {
        Object v4;
        int v2;
        Continuation v0;
        if((arg7 instanceof FlowKt__ReduceKt$fold$1)) {
            v0 = arg7;
            v2 = 0x80000000;
            if((((FlowKt__ReduceKt$fold$1)v0).label & v2) != 0) {
                ((FlowKt__ReduceKt$fold$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            FlowKt__ReduceKt$fold$1 v0_1 = new FlowKt__ReduceKt$fold$1(arg7);
        }

        Object v7 = ((FlowKt__ReduceKt$fold$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((FlowKt__ReduceKt$fold$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            ObjectRef v7_1 = new ObjectRef();
            v7_1.element = arg5;
            FlowKt__ReduceKt$fold$2 v5 = new FlowKt__ReduceKt$fold$2(v7_1, arg6);
            ((FlowKt__ReduceKt$fold$1)v0).L$0 = v7_1;
            ((FlowKt__ReduceKt$fold$1)v0).label = 1;
            if(arg4.collect(((FlowCollector)v5), v0) == v1) {
                return v1;
            }
            else {
                ObjectRef v4_1 = v7_1;
            }
        }
        else if(v2 == 1) {
            v4 = ((FlowKt__ReduceKt$fold$1)v0).L$0;
            ResultKt.throwOnFailure(v7);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return ((ObjectRef)v4).element;
    }

    private static final Object fold$$forInline(Flow arg1, Object arg2, Function3 arg3, Continuation arg4) {
        ObjectRef v0 = new ObjectRef();
        v0.element = arg2;
        arg1.collect(new FlowKt__ReduceKt$fold$2(v0, arg3), arg4);
        return v0.element;
    }

    public static final Object last(Flow arg4, Continuation arg5) {
        ObjectRef v4_1;
        FlowKt__ReduceKt$last$1 v0_1;
        int v2;
        if((arg5 instanceof FlowKt__ReduceKt$last$1)) {
            Continuation v0 = arg5;
            v2 = 0x80000000;
            if((((FlowKt__ReduceKt$last$1)v0).label & v2) != 0) {
                ((FlowKt__ReduceKt$last$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new FlowKt__ReduceKt$last$1(arg5);
        }

        Object v5 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            ObjectRef v5_1 = new ObjectRef();
            v5_1.element = NullSurrogateKt.NULL;
            FlowKt__ReduceKt$last$2 v2_1 = new FlowKt__ReduceKt$last$2(v5_1);
            v0_1.L$0 = v5_1;
            v0_1.label = 1;
            if(arg4.collect(((FlowCollector)v2_1), ((Continuation)v0_1)) == v1) {
                return v1;
            }
            else {
                v4_1 = v5_1;
            }
        }
        else if(v2 == 1) {
            Object v4 = v0_1.L$0;
            ResultKt.throwOnFailure(v5);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        if(v4_1.element != NullSurrogateKt.NULL) {
            return v4_1.element;
        }

        throw new NoSuchElementException("Expected at least one element");
    }

    public static final Object lastOrNull(Flow arg4, Continuation arg5) {
        Object v4;
        int v2;
        Continuation v0;
        if((arg5 instanceof FlowKt__ReduceKt$lastOrNull$1)) {
            v0 = arg5;
            v2 = 0x80000000;
            if((((FlowKt__ReduceKt$lastOrNull$1)v0).label & v2) != 0) {
                ((FlowKt__ReduceKt$lastOrNull$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            FlowKt__ReduceKt$lastOrNull$1 v0_1 = new FlowKt__ReduceKt$lastOrNull$1(arg5);
        }

        Object v5 = ((FlowKt__ReduceKt$lastOrNull$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((FlowKt__ReduceKt$lastOrNull$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            ObjectRef v5_1 = new ObjectRef();
            FlowKt__ReduceKt$lastOrNull$2 v2_1 = new FlowKt__ReduceKt$lastOrNull$2(v5_1);
            ((FlowKt__ReduceKt$lastOrNull$1)v0).L$0 = v5_1;
            ((FlowKt__ReduceKt$lastOrNull$1)v0).label = 1;
            if(arg4.collect(((FlowCollector)v2_1), v0) == v1) {
                return v1;
            }
            else {
                ObjectRef v4_1 = v5_1;
            }
        }
        else if(v2 == 1) {
            v4 = ((FlowKt__ReduceKt$lastOrNull$1)v0).L$0;
            ResultKt.throwOnFailure(v5);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return ((ObjectRef)v4).element;
    }

    public static final Object reduce(Flow arg4, Function3 arg5, Continuation arg6) {
        ObjectRef v4_1;
        int v2;
        Continuation v0;
        if((arg6 instanceof FlowKt__ReduceKt$reduce$1)) {
            v0 = arg6;
            v2 = 0x80000000;
            if((((FlowKt__ReduceKt$reduce$1)v0).label & v2) != 0) {
                ((FlowKt__ReduceKt$reduce$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            FlowKt__ReduceKt$reduce$1 v0_1 = new FlowKt__ReduceKt$reduce$1(arg6);
        }

        Object v6 = ((FlowKt__ReduceKt$reduce$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((FlowKt__ReduceKt$reduce$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            ObjectRef v6_1 = new ObjectRef();
            v6_1.element = NullSurrogateKt.NULL;
            FlowKt__ReduceKt$reduce$2 v2_1 = new FlowKt__ReduceKt$reduce$2(v6_1, arg5);
            ((FlowKt__ReduceKt$reduce$1)v0).L$0 = v6_1;
            ((FlowKt__ReduceKt$reduce$1)v0).label = 1;
            if(arg4.collect(((FlowCollector)v2_1), v0) == v1) {
                return v1;
            }
            else {
                v4_1 = v6_1;
            }
        }
        else if(v2 == 1) {
            Object v4 = ((FlowKt__ReduceKt$reduce$1)v0).L$0;
            ResultKt.throwOnFailure(v6);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        if(v4_1.element != NullSurrogateKt.NULL) {
            return v4_1.element;
        }

        throw new NoSuchElementException("Empty flow can\'t be reduced");
    }

    public static final Object single(Flow arg4, Continuation arg5) {
        Object v4;
        FlowKt__ReduceKt$single$1 v0_1;
        int v2;
        if((arg5 instanceof FlowKt__ReduceKt$single$1)) {
            Continuation v0 = arg5;
            v2 = 0x80000000;
            if((((FlowKt__ReduceKt$single$1)v0).label & v2) != 0) {
                ((FlowKt__ReduceKt$single$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new FlowKt__ReduceKt$single$1(arg5);
        }

        Object v5 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            ObjectRef v5_1 = new ObjectRef();
            v5_1.element = NullSurrogateKt.NULL;
            FlowKt__ReduceKt$single$2 v2_1 = new FlowKt__ReduceKt$single$2(v5_1);
            v0_1.L$0 = v5_1;
            v0_1.label = 1;
            if(arg4.collect(((FlowCollector)v2_1), ((Continuation)v0_1)) == v1) {
                return v1;
            }
            else {
                ObjectRef v4_1 = v5_1;
            }
        }
        else if(v2 == 1) {
            v4 = v0_1.L$0;
            ResultKt.throwOnFailure(v5);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        if(((ObjectRef)v4).element != NullSurrogateKt.NULL) {
            return ((ObjectRef)v4).element;
        }

        throw new NoSuchElementException("Flow is empty");
    }

    public static final Object singleOrNull(Flow arg5, Continuation arg6) {
        ObjectRef v1_1;
        Object v5;
        FlowKt__ReduceKt$singleOrNull$1 v0_1;
        int v2;
        if((arg6 instanceof FlowKt__ReduceKt$singleOrNull$1)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((FlowKt__ReduceKt$singleOrNull$1)v0).label & v2) != 0) {
                ((FlowKt__ReduceKt$singleOrNull$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new FlowKt__ReduceKt$singleOrNull$1(arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 != 0) {
            if(v2 == 1) {
                v5 = v0_1.L$1;
                v1 = v0_1.L$0;
                try {
                    ResultKt.throwOnFailure(v6);
                    goto label_52;
                }
                catch(AbortFlowException v6_1) {
                    goto label_49;
                }
            }

            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        ResultKt.throwOnFailure(v6);
        ObjectRef v6_2 = new ObjectRef();
        v6_2.element = NullSurrogateKt.NULL;
        FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1 v2_1 = new FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1(v6_2);
        try {
            v0_1.L$0 = v6_2;
            v0_1.L$1 = v2_1;
            v0_1.label = 1;
            if(arg5.collect(v2_1, ((Continuation)v0_1)) != v1) {
                goto label_43;
            }

            return v1;
        }
        catch(AbortFlowException v5_1) {
            v1_1 = v6_2;
            v6_1 = v5_1;
            FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1 v5_2 = v2_1;
        }

    label_49:
        FlowExceptions_commonKt.checkOwnership(v6_1, v5);
        JobKt.ensureActive(((Continuation)v0_1).getContext());
        goto label_52;
        return v1;
    label_43:
        v1_1 = v6_2;
    label_52:
        return ((ObjectRef)v1).element == NullSurrogateKt.NULL ? null : ((ObjectRef)v1).element;
    }
}

