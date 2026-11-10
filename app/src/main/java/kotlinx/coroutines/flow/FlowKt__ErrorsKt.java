package kotlinx.coroutines.flow;

import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001Ae\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012B\u0010\u0003\u001A>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u000E\u001A`\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0010\u001A\u00020\u001123\b\u0002\u0010\u0012\u001A-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0013¢\u0006\u0002\u0010\u0015\u001Az\u0010\u0016\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012W\u0010\u0012\u001AS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0017¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u0019\u001A.\u0010\u001A\u001A\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u001C\u001A\u0019\u0010\u001D\u001A\u00020\u0014*\u00020\u00062\u0006\u0010\u001E\u001A\u00020\u001FH\u0002¢\u0006\u0002\b \u001A\u001B\u0010!\u001A\u00020\u0014*\u00020\u00062\b\u0010\"\u001A\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\b#¨\u0006$"}, d2={"catch", "Lkotlinx/coroutines/flow/Flow;", "T", "action", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "retry", "retries", "", "predicate", "Lkotlin/Function2;", "", "(Lkotlinx/coroutines/flow/Flow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "retryWhen", "Lkotlin/Function4;", "attempt", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "catchImpl", "collector", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCancellationCause", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "isCancellationCause$FlowKt__ErrorsKt", "isSameExceptionAs", "other", "isSameExceptionAs$FlowKt__ErrorsKt", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__ErrorsKt {
    public static final Flow catch(Flow arg1, Function3 arg2) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(arg1, arg2);
    }

    public static final Object catchImpl(Flow arg4, FlowCollector arg5, Continuation arg6) {
        Object v4;
        int v2;
        Continuation v0;
        if((arg6 instanceof FlowKt__ErrorsKt$catchImpl$1)) {
            v0 = arg6;
            v2 = 0x80000000;
            if((((FlowKt__ErrorsKt$catchImpl$1)v0).label & v2) != 0) {
                ((FlowKt__ErrorsKt$catchImpl$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            FlowKt__ErrorsKt$catchImpl$1 v0_1 = new FlowKt__ErrorsKt$catchImpl$1(arg6);
        }

        Object v6 = ((FlowKt__ErrorsKt$catchImpl$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((FlowKt__ErrorsKt$catchImpl$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            ObjectRef v6_1 = new ObjectRef();
            try {
                FlowKt__ErrorsKt$catchImpl$2 v2_1 = new FlowKt__ErrorsKt$catchImpl$2(arg5, v6_1);
                ((FlowKt__ErrorsKt$catchImpl$1)v0).L$0 = v6_1;
                ((FlowKt__ErrorsKt$catchImpl$1)v0).label = 1;
                if(arg4.collect(((FlowCollector)v2_1), v0) != v1) {
                    return null;
                }

                return v1;
            }
            catch(Throwable v5) {
                ObjectRef v4_1 = v6_1;
            }

        label_42:
            v4 = ((ObjectRef)v4).element;
            if(!FlowKt__ErrorsKt.isSameExceptionAs$FlowKt__ErrorsKt(v5, ((Throwable)v4)) && !FlowKt__ErrorsKt.isCancellationCause$FlowKt__ErrorsKt(v5, v0.getContext())) {
                if(v4 == null) {
                    return v5;
                }
                else if((v5 instanceof CancellationException)) {
                    ExceptionsKt.addSuppressed(((Throwable)v4), v5);
                    throw v4;
                }
                else {
                    ExceptionsKt.addSuppressed(v5, ((Throwable)v4));
                    throw v5;
                }
            }

            throw v5;
            return v1;
        }
        else if(v2 == 1) {
            v4 = ((FlowKt__ErrorsKt$catchImpl$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v6);
            }
            catch(Throwable v5) {
                goto label_42;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return null;
    }

    private static final boolean isCancellationCause$FlowKt__ErrorsKt(Throwable arg1, CoroutineContext arg2) {
        Element v2 = arg2.get(Job.Key);
        if(v2 != null) {
            if(!((Job)v2).isCancelled()) {
            }
            else {
                return FlowKt__ErrorsKt.isSameExceptionAs$FlowKt__ErrorsKt(arg1, ((Job)v2).getCancellationException());
            }
        }

        return 0;
    }

    private static final boolean isSameExceptionAs$FlowKt__ErrorsKt(Throwable arg1, Throwable arg2) {
        if(arg2 != null) {
            if(!DebugKt.getRECOVER_STACK_TRACES()) {
            }
            else {
                arg2 = StackTraceRecoveryKt.unwrapImpl(arg2);
            }

            if(!DebugKt.getRECOVER_STACK_TRACES()) {
            }
            else {
                arg1 = StackTraceRecoveryKt.unwrapImpl(arg1);
            }

            if(!Intrinsics.areEqual(arg2, arg1)) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    public static final Flow retry(Flow arg2, long arg3, Function2 arg5) {
        if(arg3 > 0) {
            return FlowKt.retryWhen(arg2, new FlowKt__ErrorsKt$retry$3(arg3, arg5, null));
        }

        throw new IllegalArgumentException("Expected positive amount of retries, but had " + arg3.toString());
    }

    public static Flow retry$default(Flow arg0, long arg1, Function2 arg3, int arg4, Object arg5) {
        FlowKt__ErrorsKt$retry$1 v3;
        if((arg4 & 1) != 0) {
            arg1 = 0x7FFFFFFFFFFFFFFFL;
        }

        if((arg4 & 2) != 0) {
            v3 = new FlowKt__ErrorsKt$retry$1(null);
        }

        return FlowKt.retry(arg0, arg1, ((Function2)v3));
    }

    public static final Flow retryWhen(Flow arg1, Function4 arg2) {
        return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(arg1, arg2);
    }
}

