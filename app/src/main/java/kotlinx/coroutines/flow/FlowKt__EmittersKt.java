package kotlinx.coroutines.flow;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u001Ap\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012D\b\u0005\u0010\u0000\u001A>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0004¢\u0006\u0002\b\fH\u0086\b¢\u0006\u0002\u0010\r\u001Ap\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012D\b\u0005\u0010\u0000\u001A>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0004¢\u0006\u0002\b\fH\u0081\b¢\u0006\u0002\u0010\r\u001AP\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00012-\u0010\u0010\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0011¢\u0006\u0002\b\f¢\u0006\u0002\u0010\u0012\u001Ag\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00012D\u0010\u0010\u001A@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0004¢\u0006\u0002\b\f¢\u0006\u0002\u0010\r\u001AP\u0010\u0016\u001A\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00012-\u0010\u0010\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0011¢\u0006\u0002\b\f¢\u0006\u0002\u0010\u0012\u001A\u0010\u0010\u0017\u001A\u00020\n*\u0006\u0012\u0002\b\u00030\u0005H\u0000\u001Ap\u0010\u0018\u001A\u00020\n\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00052D\u0010\u0010\u001A@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0004¢\u0006\u0002\b\f2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014H\u0082@¢\u0006\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2={"transform", "Lkotlinx/coroutines/flow/Flow;", "R", "T", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "unsafeTransform", "onStart", "action", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "onCompletion", "", "cause", "onEmpty", "ensureActive", "invokeSafely", "invokeSafely$FlowKt__EmittersKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function3;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__EmittersKt {
    public static final Object access$invokeSafely$FlowKt__EmittersKt(FlowCollector arg0, Function3 arg1, Throwable arg2, Continuation arg3) {
        return FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(arg0, arg1, arg2, arg3);
    }

    public static final void ensureActive(FlowCollector arg1) {
        if(!(arg1 instanceof ThrowingCollector)) {
            return;
        }

        throw ((ThrowingCollector)arg1).e;
    }

    private static final Object invokeSafely$FlowKt__EmittersKt(FlowCollector arg4, Function3 arg5, Throwable arg6, Continuation arg7) {
        Object v6;
        FlowKt__EmittersKt$invokeSafely$1 v0_1;
        int v2;
        if((arg7 instanceof FlowKt__EmittersKt$invokeSafely$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((FlowKt__EmittersKt$invokeSafely$1)v0).label & v2) != 0) {
                ((FlowKt__EmittersKt$invokeSafely$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new FlowKt__EmittersKt$invokeSafely$1(arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            try {
                v0_1.L$0 = arg6;
                v0_1.label = 1;
                if(arg5.invoke(arg4, arg6, v0_1) != v1) {
                    goto label_33;
                }
            }
            catch(Throwable v4) {
            label_36:
                if((((Throwable)v6)) != null && (((Throwable)v6)) != v4) {
                    ExceptionsKt.addSuppressed(v4, ((Throwable)v6));
                }

                throw v4;
            }

            return v1;
        }
        else if(v2 == 1) {
            v6 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v7);
            }
            catch(Throwable v4) {
                goto label_36;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_33:
        return Unit.INSTANCE;
    }

    public static final Flow onCompletion(Flow arg1, Function3 arg2) {
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(arg1, arg2);
    }

    public static final Flow onEmpty(Flow arg1, Function2 arg2) {
        return new FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(arg1, arg2);
    }

    public static final Flow onStart(Flow arg1, Function2 arg2) {
        return new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(arg2, arg1);
    }

    public static final Flow transform(Flow arg2, Function3 arg3) {
        return FlowKt.flow(new FlowKt__EmittersKt$transform$1(arg2, arg3, null));
    }

    public static final Flow unsafeTransform(Flow arg1, Function3 arg2) {
        return new FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(arg1, arg2);
    }
}

