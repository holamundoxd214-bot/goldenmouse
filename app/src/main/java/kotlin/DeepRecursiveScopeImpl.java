package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004BL\bF\u00129\u0010\u0005\u001A5\b\u0001\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\b\b\u0012\u0006\u0010\t\u001A\u00028\u0000¢\u0006\u0004\b\n\u0010\u000BJ\u001D\u0010\u0017\u001A\u00020\u00182\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0019J\u0017\u0010\u001A\u001A\u00028\u00012\u0006\u0010\t\u001A\u00028\u0000H\u0096À\u0004¢\u0006\u0002\u0010\u001BJ3\u0010\u001A\u001A\u0002H\u001C\"\u0004\b\u0002\u0010\u001D\"\u0004\b\u0003\u0010\u001C*\u000E\u0012\u0004\u0012\u0002H\u001D\u0012\u0004\u0012\u0002H\u001C0\u001E2\u0006\u0010\t\u001A\u0002H\u001DH\u0096À\u0004¢\u0006\u0002\u0010\u001FJf\u0010 \u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00042=\u0010!\u001A9\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\u0002`\r¢\u0006\u0002\b\b2\u000E\u0010\u000F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0082\u0080\u0004¢\u0006\u0002\u0010\"J\u000F\u0010#\u001A\u00028\u0001H\u0086\u0080\u0004¢\u0006\u0002\u0010$RH\u0010\f\u001A9\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\u0002`\r¢\u0006\u0002\b\bX\u0082\u008E\b¢\u0006\u0004\n\u0002\u0010\u000ER\u0011\u0010\t\u001A\u0004\u0018\u00010\u0007X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0019\u0010\u000F\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0019\u0010\u0010\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0011X\u0082\u008E\b¢\u0006\u0004\n\u0002\u0010\u0012R\u0015\u0010\u0013\u001A\u00020\u00148VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2={"Lkotlin/DeepRecursiveScopeImpl;", "T", "R", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function3;", "", "Lkotlin/ExtensionFunctionType;", "value", "<init>", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;)V", "function", "Lkotlin/DeepRecursiveFunctionBlock;", "Lkotlin/jvm/functions/Function3;", "cont", "result", "Lkotlin/Result;", "Ljava/lang/Object;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "(Ljava/lang/Object;)V", "callRecursive", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "S", "U", "Lkotlin/DeepRecursiveFunction;", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "crossFunctionCompletion", "currentFunction", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "runCallLoop", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class DeepRecursiveScopeImpl extends DeepRecursiveScope implements Continuation {
    private Continuation cont;
    private Function3 function;
    private Object result;
    private Object value;

    public DeepRecursiveScopeImpl(Function3 arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "block");
        super(null);
        this.function = arg2;
        this.value = arg3;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.cont = this;
        this.result = DeepRecursiveKt.UNDEFINED_RESULT;
    }

    public static final void access$setCont$p(DeepRecursiveScopeImpl arg0, Continuation arg1) {
        arg0.cont = arg1;
    }

    public static final void access$setFunction$p(DeepRecursiveScopeImpl arg0, Function3 arg1) {
        arg0.function = arg1;
    }

    public static final void access$setResult$p(DeepRecursiveScopeImpl arg0, Object arg1) {
        arg0.result = arg1;
    }

    public Object callRecursive(Object arg2, Continuation arg3) {
        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.cont = arg3;
        this.value = arg2;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg3);
        }

        return v1;
    }

    public Object callRecursive(DeepRecursiveFunction arg3, Object arg4, Continuation arg5) {
        Function3 v3 = arg3.getBlock$kotlin_stdlib();
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<kotlin.DeepRecursiveScope<*, *>, kotlin.Any?, kotlin.Any?>");
        Function3 v0 = this.function;
        String v1 = "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>";
        if(v3 != v0) {
            this.function = v3;
            Intrinsics.checkNotNull(arg5, v1);
            this.cont = this.crossFunctionCompletion(v0, arg5);
        }
        else {
            Intrinsics.checkNotNull(arg5, v1);
            this.cont = arg5;
        }

        this.value = arg4;
        Object v2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg5);
        }

        return v2;
    }

    private final Continuation crossFunctionCompletion(Function3 arg3, Continuation arg4) {
        return new DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1(EmptyCoroutineContext.INSTANCE, this, arg3, arg4);
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public void resumeWith(Object arg2) {
        this.cont = null;
        this.result = arg2;
    }

    public final Object runCallLoop() {
        Object v0;
        while(true) {
            v0 = this.result;
            Continuation v1 = this.cont;
            if(v1 == null) {
                break;
            }

            if(Result.equals-impl0(DeepRecursiveKt.UNDEFINED_RESULT, v0)) {
                try {
                    Function3 v0_2 = this.function;
                    Object v2 = this.value;
                    v0 = !(v0_2 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(v0_2, this, v2, v1) : TypeIntrinsics.beforeCheckcastToFunctionOfArity(v0_2, 3).invoke(this, v2, v1);
                }
                catch(Throwable v0_1) {
                    v1.resumeWith(Result.constructor-impl(ResultKt.createFailure(v0_1)));
                    continue;
                }

                if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    continue;
                }

                v1.resumeWith(Result.constructor-impl(v0));
                continue;
            }

            this.result = DeepRecursiveKt.UNDEFINED_RESULT;
            v1.resumeWith(v0);
        }

        ResultKt.throwOnFailure(v0);
        return v0;
    }
}

