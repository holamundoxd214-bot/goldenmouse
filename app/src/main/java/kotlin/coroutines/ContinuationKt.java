package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\u001A\'\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001A\u0002H\u0002H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0005\u001A\"\u0010\u0006\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0007\u001A\u00020\bH\u0087\u0088\u0004\u001A=\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\n\u001A\u00020\u000B2\u001A\b\u0004\u0010\f\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000E\u0012\u0004\u0012\u00020\u00010\rH\u0087\u0088\u0004ø\u0001\u0000\u001AC\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00010\u0003\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0012\u001A\\\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00010\u0003\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014¢\u0006\u0002\b\u00152\u0006\u0010\u0016\u001A\u0002H\u00132\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0017\u001A=\u0010\u0018\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0019\u001AV\u0010\u0018\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014¢\u0006\u0002\b\u00152\u0006\u0010\u0016\u001A\u0002H\u00132\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\u001A\u001A>\u0010\u001B\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001A\b\u0004\u0010\u001C\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0004\u0012\u00020\u00010\rH\u0087È\u0004\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001D\"\u001C\u0010\u001E\u001A\u00020\u000B8Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, d2={"resume", "", "T", "Lkotlin/coroutines/Continuation;", "value", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "resumeWithException", "exception", "", "Continuation", "context", "Lkotlin/coroutines/CoroutineContext;", "resumeWith", "Lkotlin/Function1;", "Lkotlin/Result;", "createCoroutine", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "suspendCoroutine", "block", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coroutineContext", "getCoroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class ContinuationKt {
    private static final Continuation Continuation(CoroutineContext arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        Intrinsics.checkNotNullParameter(arg2, "resumeWith");
        return new ContinuationKt$Continuation$1(arg1, arg2);
    }

    public static final Continuation createCoroutine(Function2 arg1, Object arg2, Continuation arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "completion");
        return new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(arg1, arg2, arg3)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    public static final Continuation createCoroutine(Function1 arg1, Continuation arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "completion");
        return new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(arg1, arg2)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    private static final CoroutineContext getCoroutineContext() {
        throw new NotImplementedError("Implemented as intrinsic");
    }

    public static void getCoroutineContext$annotations() {
    }

    private static final void resume(Continuation arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.resumeWith(Result.constructor-impl(arg2));
    }

    private static final void resumeWithException(Continuation arg1, Throwable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "exception");
        arg1.resumeWith(Result.constructor-impl(ResultKt.createFailure(arg2)));
    }

    public static final void startCoroutine(Function1 arg1, Continuation arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "completion");
        IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(arg1, arg2)).resumeWith(Result.constructor-impl(Unit.INSTANCE));
    }

    public static final void startCoroutine(Function2 arg1, Object arg2, Continuation arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "completion");
        IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(arg1, arg2, arg3)).resumeWith(Result.constructor-impl(Unit.INSTANCE));
    }

    private static final Object suspendCoroutine(Function1 arg2, Continuation arg3) {
        SafeContinuation v0 = new SafeContinuation(IntrinsicsKt.intercepted(arg3));
        arg2.invoke(v0);
        Object v2 = v0.getOrThrow();
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg3);
        }

        return v2;
    }
}

