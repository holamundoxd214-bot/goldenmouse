package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u001AB\u0010\u0000\u001A\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001A?\u0010\u0007\u001A\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0081\u0080\u0004¢\u0006\u0002\u0010\u0006\u001A[\u0010\u0000\u001A\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\b\n2\u0006\u0010\u000B\u001A\u0002H\b2\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\f\u001AX\u0010\u0007\u001A\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\b\n2\u0006\u0010\u000B\u001A\u0002H\b2\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0081\u0080\u0004¢\u0006\u0002\u0010\f\u001Ao\u0010\u0000\u001A\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u0002*)\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000E¢\u0006\u0002\b\n2\u0006\u0010\u000B\u001A\u0002H\b2\u0006\u0010\u000F\u001A\u0002H\r2\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0081\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001Al\u0010\u0007\u001A\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u0002*)\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000E¢\u0006\u0002\b\n2\u0006\u0010\u000B\u001A\u0002H\b2\u0006\u0010\u000F\u001A\u0002H\r2\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0081\u0080\u0004¢\u0006\u0002\u0010\u0010\u001AC\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\u0004\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0013\u001A\\\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\u0004\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\b\n2\u0006\u0010\u000B\u001A\u0002H\b2\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0014\u001A \u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0087\u0080\u0004\u001AG\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00120\u0004\"\u0004\b\u0000\u0010\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00042\u001C\b\u0004\u0010\u0017\u001A\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H\u0083\u0088\u0004¢\u0006\u0002\b\u0018\u001A)\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0082\u0080\u0004¢\u0006\u0002\b\u001A\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001B"}, d2={"startCoroutineUninterceptedOrReturn", "", "T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wrapWithContinuationImpl", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P", "Lkotlin/Function3;", "param", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCoroutineUnintercepted", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "createCoroutineFromSuspendFunction", "block", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createSimpleCoroutineForSuspendFunction", "createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/coroutines/intrinsics/IntrinsicsKt") class IntrinsicsKt__IntrinsicsJvmKt {
    public IntrinsicsKt__IntrinsicsJvmKt() {
        super();
    }

    private static final Continuation createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(Continuation arg2, Function1 arg3) {
        CoroutineContext v0 = arg2.getContext();
        if(v0 == EmptyCoroutineContext.INSTANCE) {
            return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1(arg2, arg3);
        }

        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2(arg2, v0, arg3);
    }

    public static final Continuation createCoroutineUnintercepted(Function1 arg2, Continuation arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "completion");
        arg3 = DebugProbesKt.probeCoroutineCreated(arg3);
        if((arg2 instanceof BaseContinuationImpl)) {
            return ((BaseContinuationImpl)arg2).create(arg3);
        }

        CoroutineContext v0 = arg3.getContext();
        if(v0 == EmptyCoroutineContext.INSTANCE) {
            return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1(arg3, arg2);
        }

        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2(arg3, v0, arg2);
    }

    public static final Continuation createCoroutineUnintercepted(Function2 arg2, Object arg3, Continuation arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "completion");
        arg4 = DebugProbesKt.probeCoroutineCreated(arg4);
        if((arg2 instanceof BaseContinuationImpl)) {
            return ((BaseContinuationImpl)arg2).create(arg3, arg4);
        }

        CoroutineContext v0 = arg4.getContext();
        if(v0 == EmptyCoroutineContext.INSTANCE) {
            return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(arg4, arg2, arg3);
        }

        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(arg4, v0, arg2, arg3);
    }

    private static final Continuation createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(Continuation arg2) {
        CoroutineContext v0 = arg2.getContext();
        if(v0 == EmptyCoroutineContext.INSTANCE) {
            return new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1(arg2);
        }

        return new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2(arg2, v0);
    }

    public static final Continuation intercepted(Continuation arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Continuation v0 = (arg1 instanceof ContinuationImpl) ? arg1 : null;
        if(v0 != null) {
            v0 = ((ContinuationImpl)v0).intercepted();
            if(v0 == null) {
            }
            else {
                return v0;
            }
        }

        return arg1;
    }

    private static final Object startCoroutineUninterceptedOrReturn(Function1 arg1, Continuation arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "completion");
        if(!(arg1 instanceof BaseContinuationImpl)) {
            return IntrinsicsKt.wrapWithContinuationImpl(arg1, arg2);
        }

        return TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg1, 1).invoke(arg2);
    }

    private static final Object startCoroutineUninterceptedOrReturn(Function2 arg1, Object arg2, Continuation arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "completion");
        if(!(arg1 instanceof BaseContinuationImpl)) {
            return IntrinsicsKt.wrapWithContinuationImpl(arg1, arg2, arg3);
        }

        return TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg1, 2).invoke(arg2, arg3);
    }

    private static final Object startCoroutineUninterceptedOrReturn(Function3 arg1, Object arg2, Object arg3, Continuation arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "completion");
        if(!(arg1 instanceof BaseContinuationImpl)) {
            return IntrinsicsKt.wrapWithContinuationImpl(arg1, arg2, arg3, arg4);
        }

        return TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg1, 3).invoke(arg2, arg3, arg4);
    }

    public static final Object wrapWithContinuationImpl(Function1 arg1, Continuation arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "completion");
        return TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg1, 1).invoke(IntrinsicsKt__IntrinsicsJvmKt.createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(arg2)));
    }

    public static final Object wrapWithContinuationImpl(Function2 arg1, Object arg2, Continuation arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "completion");
        return TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg1, 2).invoke(arg2, IntrinsicsKt__IntrinsicsJvmKt.createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(arg3)));
    }

    public static final Object wrapWithContinuationImpl(Function3 arg1, Object arg2, Object arg3, Continuation arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "completion");
        return TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg1, 3).invoke(arg2, arg3, IntrinsicsKt__IntrinsicsJvmKt.createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(arg4)));
    }
}

