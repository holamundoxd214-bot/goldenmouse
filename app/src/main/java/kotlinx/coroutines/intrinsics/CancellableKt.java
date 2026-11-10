package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u001A;\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0007\u001AO\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*\u001E\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t2\u0006\u0010\n\u001A\u0002H\b2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000¢\u0006\u0002\u0010\u000B\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00042\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\u0004H\u0000\u001A#\u0010\r\u001A\u00020\u00012\n\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u00042\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00010\u000FH\u0082\b\u001A\u001C\u0010\u0010\u001A\u00020\u00012\n\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0011\u001A\u00020\u0012H\u0002¨\u0006\u0013"}, d2={"startCoroutineCancellable", "", "T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "fatalCompletion", "runSafely", "block", "Lkotlin/Function0;", "dispatcherFailure", "e", "", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CancellableKt {
    private static final void dispatcherFailure(Continuation arg1, Throwable arg2) {
        if((arg2 instanceof DispatchException)) {
            arg2 = ((DispatchException)arg2).getCause();
        }

        arg1.resumeWith(Result.constructor-impl(ResultKt.createFailure(arg2)));
        throw arg2;
    }

    private static final void runSafely(Continuation arg0, Function0 arg1) {
        try {
            arg1.invoke();
            return;
        }
        catch(Throwable v1) {
            CancellableKt.dispatcherFailure(arg0, v1);
            return;
        }
    }

    public static final void startCoroutineCancellable(Function2 arg0, Object arg1, Continuation arg2) {
        try {
            DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(arg0, arg1, arg2)), Result.constructor-impl(Unit.INSTANCE));
            return;
        }
        catch(Throwable v0) {
            CancellableKt.dispatcherFailure(arg2, v0);
            return;
        }
    }

    public static final void startCoroutineCancellable(Continuation arg1, Continuation arg2) {
        try {
            DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt.intercepted(arg1), Result.constructor-impl(Unit.INSTANCE));
            return;
        }
        catch(Throwable v1) {
            CancellableKt.dispatcherFailure(arg2, v1);
            return;
        }
    }

    public static final void startCoroutineCancellable(Function1 arg1, Continuation arg2) {
        try {
            DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(arg1, arg2)), Result.constructor-impl(Unit.INSTANCE));
            return;
        }
        catch(Throwable v1) {
            CancellableKt.dispatcherFailure(arg2, v1);
            return;
        }
    }
}

