package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A$\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004\u001AE\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\"\u0010\u0006\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0002\u0010\u000B\u001A$\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004\u001A0\u0010\r\u001A\u00020\u000E\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000F2\u0006\u0010\u0010\u001A\u0002H\u00022\u0006\u0010\u0011\u001A\u00020\nH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013\u001AE\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\"\u0010\u0006\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0002\u0010\u000B\u001Am\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00020\u00012D\b\u0001\u0010\u0017\u001A>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u000F\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0018¢\u0006\u0002\b\u001B¢\u0006\u0002\u0010\u001C\u001AS\u0010\u001D\u001A\u00020\u000E\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000123\b\u0004\u0010\u0006\u001A-\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007H\u0080H¢\u0006\u0002\u0010\u001E¨\u0006\u001F"}, d2={"drop", "Lkotlinx/coroutines/flow/Flow;", "T", "count", "", "dropWhile", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "take", "emitAbort", "", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "ownershipMarker", "emitAbort$FlowKt__LimitKt", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "takeWhile", "transformWhile", "R", "transform", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "collectWhile", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__LimitKt {
    public static final Object access$emitAbort$FlowKt__LimitKt(FlowCollector arg0, Object arg1, Object arg2, Continuation arg3) {
        return FlowKt__LimitKt.emitAbort$FlowKt__LimitKt(arg0, arg1, arg2, arg3);
    }

    public static final Object collectWhile(Flow arg4, Function2 arg5, Continuation arg6) {
        FlowKt__LimitKt$collectWhile$collector$1 v4_1;
        FlowKt__LimitKt$collectWhile$1 v0_1;
        int v2;
        if((arg6 instanceof FlowKt__LimitKt$collectWhile$1)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((FlowKt__LimitKt$collectWhile$1)v0).label & v2) != 0) {
                ((FlowKt__LimitKt$collectWhile$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new FlowKt__LimitKt$collectWhile$1(arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 != 0) {
            if(v2 == 1) {
                Object v4 = v0_1.L$0;
                try {
                    ResultKt.throwOnFailure(v6);
                    goto label_42;
                }
                catch(AbortFlowException v5) {
                    goto label_39;
                }
            }

            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        ResultKt.throwOnFailure(v6);
        FlowKt__LimitKt$collectWhile$collector$1 v6_1 = new FlowKt__LimitKt$collectWhile$collector$1(arg5);
        try {
            v0_1.L$0 = v6_1;
            v0_1.label = 1;
            if(arg4.collect(v6_1, ((Continuation)v0_1)) != v1) {
                goto label_42;
            }

            return v1;
        }
        catch(AbortFlowException v5) {
            v4_1 = v6_1;
        }

    label_39:
        FlowExceptions_commonKt.checkOwnership(v5, v4_1);
        JobKt.ensureActive(((Continuation)v0_1).getContext());
        goto label_42;
        return v1;
    label_42:
        return Unit.INSTANCE;
    }

    private static final Object collectWhile$$forInline(Flow arg1, Function2 arg2, Continuation arg3) {
        FlowKt__LimitKt$collectWhile$collector$1 v0 = new FlowKt__LimitKt$collectWhile$collector$1(arg2);
        try {
            arg1.collect(v0, arg3);
        }
        catch(AbortFlowException v1) {
            FlowExceptions_commonKt.checkOwnership(v1, v0);
            null.getContext();
            throw null;
        }

        return Unit.INSTANCE;
    }

    public static final Flow drop(Flow arg1, int arg2) {
        if(arg2 >= 0) {
            return new FlowKt__LimitKt$drop$$inlined$unsafeFlow$1(arg1, arg2);
        }

        throw new IllegalArgumentException("Drop count should be non-negative, but had " + arg2.toString());
    }

    public static final Flow dropWhile(Flow arg1, Function2 arg2) {
        return new FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1(arg1, arg2);
    }

    private static final Object emitAbort$FlowKt__LimitKt(FlowCollector arg4, Object arg5, Object arg6, Continuation arg7) {
        FlowKt__LimitKt$emitAbort$1 v0_1;
        int v2;
        if((arg7 instanceof FlowKt__LimitKt$emitAbort$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((FlowKt__LimitKt$emitAbort$1)v0).label & v2) != 0) {
                ((FlowKt__LimitKt$emitAbort$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new FlowKt__LimitKt$emitAbort$1(arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            v0_1.L$0 = arg6;
            v0_1.label = 1;
            if(arg4.emit(arg5, ((Continuation)v0_1)) == v1) {
                return v1;
            }
        }
        else if(v2 != 1) {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }
        else {
            arg6 = v0_1.L$0;
            ResultKt.throwOnFailure(v7);
        }

        throw new AbortFlowException(arg6);
    }

    public static final Flow take(Flow arg1, int arg2) {
        if(arg2 > 0) {
            return new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(arg1, arg2);
        }

        throw new IllegalArgumentException("Requested element count " + arg2 + " should be positive".toString());
    }

    public static final Flow takeWhile(Flow arg1, Function2 arg2) {
        return new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(arg1, arg2);
    }

    public static final Flow transformWhile(Flow arg2, Function3 arg3) {
        return FlowKt.flow(new FlowKt__LimitKt$transformWhile$1(arg2, arg3, null));
    }
}

