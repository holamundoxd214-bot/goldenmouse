package kotlinx.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u00052\u00020\u0006B\u001D\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010)\u001A\u00020*H\u0016J\b\u0010+\u001A\u00020!H\u0002J\b\u0010,\u001A\u00020!H\u0001J\u0015\u00100\u001A\n\u0018\u000101j\u0004\u0018\u0001`2H\u0016¢\u0006\u0002\u00103J\u000F\u00104\u001A\u0004\u0018\u00010\u0017H\u0010¢\u0006\u0002\b5J\u001F\u00106\u001A\u00020*2\b\u00107\u001A\u0004\u0018\u00010\u00172\u0006\u00108\u001A\u000209H\u0010¢\u0006\u0002\b:J\u0010\u0010;\u001A\u00020!2\u0006\u00108\u001A\u000209H\u0002J\u0012\u0010<\u001A\u00020!2\b\u00108\u001A\u0004\u0018\u000109H\u0016J\u0015\u0010=\u001A\u00020*2\u0006\u00108\u001A\u000209H\u0000¢\u0006\u0002\b>J\u0017\u0010?\u001A\u00020*2\f\u0010@\u001A\b\u0012\u0004\u0012\u00020*0AH\u0082\bJ\u0018\u0010B\u001A\u00020*2\u0006\u0010C\u001A\u00020D2\b\u00108\u001A\u0004\u0018\u000109J\u001E\u0010E\u001A\u00020*2\n\u0010F\u001A\u0006\u0012\u0002\b\u00030G2\b\u00108\u001A\u0004\u0018\u000109H\u0002Jn\u0010H\u001A\u00020*\"\u0004\b\u0001\u0010I2K\u0010J\u001AG\u0012\u0013\u0012\u001109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020*0K2\u0006\u00108\u001A\u0002092\u0006\u0010N\u001A\u0002HI¢\u0006\u0002\u0010OJ\u0010\u0010P\u001A\u0002092\u0006\u0010Q\u001A\u00020RH\u0016J\b\u0010S\u001A\u00020!H\u0002J\b\u0010T\u001A\u00020!H\u0002J\n\u0010U\u001A\u0004\u0018\u00010\u0017H\u0001J\n\u0010V\u001A\u0004\u0018\u00010\u0019H\u0002J\r\u0010W\u001A\u00020*H\u0000¢\u0006\u0002\bXJ\u001B\u0010Y\u001A\u00020*2\f\u0010Z\u001A\b\u0012\u0004\u0012\u00028\u00000[H\u0016¢\u0006\u0002\u0010\\J:\u0010]\u001A\u00020*2\u0006\u0010N\u001A\u00028\u00002#\u0010J\u001A\u001F\u0012\u0013\u0012\u001109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020*\u0018\u00010^H\u0016¢\u0006\u0002\u0010_Jn\u0010]\u001A\u00020*\"\b\b\u0001\u0010I*\u00028\u00002\u0006\u0010N\u001A\u0002HI2M\u0010J\u001AI\u0012\u0013\u0012\u001109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020*\u0018\u00010KH\u0016¢\u0006\u0002\u0010`J\u001C\u0010a\u001A\u00020*2\n\u0010F\u001A\u0006\u0012\u0002\b\u00030G2\u0006\u0010b\u001A\u00020\nH\u0016J1\u0010a\u001A\u00020*2\'\u0010C\u001A#\u0012\u0015\u0012\u0013\u0018\u000109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020*0^j\u0002`cH\u0016J\u0015\u0010d\u001A\u00020*2\u0006\u0010C\u001A\u00020DH\u0000¢\u0006\u0002\beJ\u0010\u0010f\u001A\u00020*2\u0006\u0010C\u001A\u00020\u0017H\u0002J\u001A\u0010g\u001A\u00020*2\u0006\u0010C\u001A\u00020\u00172\b\u0010\u001D\u001A\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010h\u001A\u00020*2\u0006\u0010i\u001A\u00020\nH\u0002J\u0086\u0001\u0010j\u001A\u0004\u0018\u00010\u0017\"\u0004\b\u0001\u0010I2\u0006\u0010\u001D\u001A\u00020k2\u0006\u0010l\u001A\u0002HI2\u0006\u0010\t\u001A\u00020\n2M\u0010J\u001AI\u0012\u0013\u0012\u001109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020*\u0018\u00010K2\b\u0010m\u001A\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010nJv\u0010o\u001A\u00020*\"\u0004\b\u0001\u0010I2\u0006\u0010l\u001A\u0002HI2\u0006\u0010\t\u001A\u00020\n2O\b\u0002\u0010J\u001AI\u0012\u0013\u0012\u001109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020*\u0018\u00010KH\u0000¢\u0006\u0004\bp\u0010qJv\u0010r\u001A\u0004\u0018\u00010s\"\u0004\b\u0001\u0010I2\u0006\u0010l\u001A\u0002HI2\b\u0010m\u001A\u0004\u0018\u00010\u00172M\u0010J\u001AI\u0012\u0013\u0012\u001109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020*\u0018\u00010KH\u0002¢\u0006\u0002\u0010tJ\u0012\u0010u\u001A\u00020v2\b\u0010l\u001A\u0004\u0018\u00010\u0017H\u0002J\b\u0010w\u001A\u00020*H\u0002J\r\u0010x\u001A\u00020*H\u0000¢\u0006\u0002\byJ!\u0010T\u001A\u0004\u0018\u00010\u00172\u0006\u0010N\u001A\u00028\u00002\b\u0010m\u001A\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010zJz\u0010T\u001A\u0004\u0018\u00010\u0017\"\b\b\u0001\u0010I*\u00028\u00002\u0006\u0010N\u001A\u0002HI2\b\u0010m\u001A\u0004\u0018\u00010\u00172M\u0010J\u001AI\u0012\u0013\u0012\u001109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020*\u0018\u00010KH\u0016¢\u0006\u0002\u0010{J\u0012\u0010|\u001A\u0004\u0018\u00010\u00172\u0006\u0010}\u001A\u000209H\u0016J\u0010\u0010~\u001A\u00020*2\u0006\u0010\u007F\u001A\u00020\u0017H\u0016J\u001C\u0010\u0080\u0001\u001A\u00020**\u00030\u0081\u00012\u0006\u0010N\u001A\u00028\u0000H\u0016¢\u0006\u0003\u0010\u0082\u0001J\u0016\u0010\u0083\u0001\u001A\u00020**\u00030\u0081\u00012\u0006\u0010}\u001A\u000209H\u0016J\"\u0010\u0084\u0001\u001A\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u001D\u001A\u0004\u0018\u00010\u0017H\u0010¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u001B\u0010\u0087\u0001\u001A\u0004\u0018\u0001092\b\u0010\u001D\u001A\u0004\u0018\u00010\u0017H\u0010¢\u0006\u0003\b\u0088\u0001J\t\u0010\u0089\u0001\u001A\u00020&H\u0016J\t\u0010\u008A\u0001\u001A\u00020&H\u0014R\u001A\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\bX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\t\u0010\u0013\u001A\u00020\u0014X\u0082\u0004R\u0011\u0010\u0015\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u0004R\u0011\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0016X\u0082\u0004R\u0016\u0010\u001A\u001A\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0016\u0010\u001D\u001A\u0004\u0018\u00010\u00178@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020!8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b \u0010\"R\u0014\u0010#\u001A\u00020!8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b#\u0010\"R\u0014\u0010$\u001A\u00020!8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b$\u0010\"R\u0014\u0010%\u001A\u00020&8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010(R\u001C\u0010-\u001A\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b.\u0010/¨\u0006\u008B\u0001"}, d2={"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/Waiter;", "delegate", "Lkotlin/coroutines/Continuation;", "resumeMode", "", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "_decisionAndIndex", "Lkotlinx/atomicfu/AtomicInt;", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "_parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "parentHandle", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "isActive", "", "()Z", "isCompleted", "isCancelled", "stateDebugRepresentation", "", "getStateDebugRepresentation", "()Ljava/lang/String;", "initCancellability", "", "isReusable", "resetStateReusable", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "()Ljava/lang/StackTraceElement;", "takeState", "takeState$kotlinx_coroutines_core", "cancelCompletedResult", "takenState", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "cancelLater", "cancel", "parentCancelled", "parentCancelled$kotlinx_coroutines_core", "callCancelHandlerSafely", "block", "Lkotlin/Function0;", "callCancelHandler", "handler", "Lkotlinx/coroutines/CancelHandler;", "callSegmentOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "callOnCancellation", "R", "onCancellation", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "value", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Throwable;Ljava/lang/Object;)V", "getContinuationCancellationCause", "parent", "Lkotlinx/coroutines/Job;", "trySuspend", "tryResume", "getResult", "installParentHandle", "releaseClaimedReusableContinuation", "releaseClaimedReusableContinuation$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "resume", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "invokeOnCancellation", "index", "Lkotlinx/coroutines/CompletionHandler;", "invokeOnCancellationInternal", "invokeOnCancellationInternal$kotlinx_coroutines_core", "invokeOnCancellationImpl", "multipleHandlersError", "dispatchResume", "mode", "resumedState", "Lkotlinx/coroutines/NotCompleted;", "proposedUpdate", "idempotent", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function3;Ljava/lang/Object;)Ljava/lang/Object;", "resumeImpl", "resumeImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function3;)V", "tryResumeImpl", "Lkotlinx/coroutines/internal/Symbol;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/internal/Symbol;", "alreadyResumedError", "", "detachChildIfNonReusable", "detachChild", "detachChild$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "tryResumeWithException", "exception", "completeResume", "token", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getExceptionalResult", "getExceptionalResult$kotlinx_coroutines_core", "toString", "nameString", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class CancellableContinuationImpl extends DispatchedTask implements CoroutineStackFrame, CancellableContinuation, Waiter {
    private final CoroutineContext context;
    private final Continuation delegate;

    static {
        Class v1 = CancellableContinuationImpl.class;
        CancellableContinuationImpl._decisionAndIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(v1, "_decisionAndIndex$volatile");
        Class v0 = Object.class;
        CancellableContinuationImpl._state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v1, v0, "_state$volatile");
        CancellableContinuationImpl._parentHandle$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v1, v0, "_parentHandle$volatile");
    }

    public CancellableContinuationImpl(Continuation arg2, int arg3) {
        super(arg3);
        this.delegate = arg2;
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg3 != -1) {
            }
            else {
                throw new AssertionError();
            }
        }

        this.context = arg2.getContext();
        this._decisionAndIndex$volatile = 0x1FFFFFFF;
        this._state$volatile = Active.INSTANCE;
    }

    private final Void alreadyResumedError(Object arg3) {
        throw new IllegalStateException("Already resumed, but proposed with update " + arg3.toString());
    }

    public final void callCancelHandler(CancelHandler arg4, Throwable arg5) {
        try {
            arg4.invoke(arg5);
            return;
        }
        catch(Throwable v4) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, v4));
            return;
        }
    }

    private final void callCancelHandlerSafely(Function0 arg5) {
        try {
            arg5.invoke();
            return;
        }
        catch(Throwable v5) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, v5));
            return;
        }
    }

    public final void callOnCancellation(Function3 arg3, Throwable arg4, Object arg5) {
        try {
            arg3.invoke(arg4, arg5, this.getContext());
            return;
        }
        catch(Throwable v3) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, v3));
            return;
        }
    }

    private final void callSegmentOnCancellation(Segment arg4, Throwable arg5) {
        int v0 = CancellableContinuationImpl.get_decisionAndIndex$volatile$FU().get(this) & 0x1FFFFFFF;
        if(v0 != 0x1FFFFFFF) {
            try {
                arg4.onCancellation(v0, arg5, this.getContext());
                return;
            }
            catch(Throwable v4) {
                CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, v4));
                return;
            }
        }

        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
    }

    public boolean cancel(Throwable arg8) {
        Object v1;
        AtomicReferenceFieldUpdater v0 = CancellableContinuationImpl.get_state$volatile$FU();
        do {
            v1 = v0.get(this);
            boolean v3 = false;
            if(!(v1 instanceof NotCompleted)) {
                return 0;
            }

            CancellableContinuationImpl v4 = this;
            if(((v1 instanceof CancelHandler)) || ((v1 instanceof Segment))) {
                v3 = true;
            }
        }
        while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(CancellableContinuationImpl.get_state$volatile$FU(), this, v1, new CancelledContinuation(((Continuation)v4), arg8, v3)));

        Object v0_1 = v1;
        if((v0_1 instanceof CancelHandler)) {
            this.callCancelHandler(((CancelHandler)v1), arg8);
        }
        else if((v0_1 instanceof Segment)) {
            this.callSegmentOnCancellation(((Segment)v1), arg8);
        }

        this.detachChildIfNonReusable();
        this.dispatchResume(this.resumeMode);
        return 1;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(Object arg11, Throwable arg12) {
        Throwable v5;
        AtomicReferenceFieldUpdater v11 = CancellableContinuationImpl.get_state$volatile$FU();
        while(true) {
            Object v1 = v11.get(this);
            if((v1 instanceof NotCompleted)) {
                break;
            }

            if((v1 instanceof CompletedExceptionally)) {
            }
            else {
                if((v1 instanceof CompletedContinuation)) {
                    Object v2 = v1;
                    if(!((CompletedContinuation)v2).getCancelled()) {
                        v5 = arg12;
                        if(AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(CancellableContinuationImpl.get_state$volatile$FU(), this, v1, CompletedContinuation.copy$default(((CompletedContinuation)v2), null, null, null, null, arg12, 15, null))) {
                            ((CompletedContinuation)v2).invokeHandlers(this, v5);
                            return;
                        }
                    }
                    else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                }
                else {
                    v5 = arg12;
                    if(AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(CancellableContinuationImpl.get_state$volatile$FU(), this, v1, new CompletedContinuation(v1, null, null, null, v5, 14, null))) {
                        return;
                    }
                }

                goto label_43;
            }

            return;
        label_43:
            arg12 = v5;
        }

        throw new IllegalStateException("Not completed".toString());
    }

    private final boolean cancelLater(Throwable arg2) {
        if(!this.isReusable()) {
            return 0;
        }

        Continuation v1 = this.delegate;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((DispatchedContinuation)v1).postponeCancellation$kotlinx_coroutines_core(arg2);
    }

    public void completeResume(Object arg2) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg2 == CancellableContinuationImplKt.RESUME_TOKEN) {
            }
            else {
                throw new AssertionError();
            }
        }

        this.dispatchResume(this.resumeMode);
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle v0 = this.getParentHandle();
        if(v0 == null) {
            return;
        }

        v0.dispose();
        CancellableContinuationImpl.get_parentHandle$volatile$FU().set(this, NonDisposableHandle.INSTANCE);
    }

    private final void detachChildIfNonReusable() {
        if(!this.isReusable()) {
            this.detachChild$kotlinx_coroutines_core();
        }
    }

    private final void dispatchResume(int arg2) {
        if(this.tryResume()) {
            return;
        }

        DispatchedTaskKt.dispatch(((DispatchedTask)this), arg2);
    }

    public CoroutineStackFrame getCallerFrame() {
        Continuation v1 = this.delegate;
        if((v1 instanceof CoroutineStackFrame)) {
            return ((CoroutineStackFrame)v1);
        }

        return null;
    }

    public CoroutineContext getContext() {
        return this.context;
    }

    public Throwable getContinuationCancellationCause(Job arg1) {
        return arg1.getCancellationException();
    }

    public final Continuation getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object arg2) {
        Throwable v2 = super.getExceptionalResult$kotlinx_coroutines_core(arg2);
        if(v2 != null) {
            Continuation v1 = this.delegate;
            if(DebugKt.getRECOVER_STACK_TRACES()) {
                if(!(v1 instanceof CoroutineStackFrame)) {
                }
                else {
                    return StackTraceRecoveryKt.access$recoverFromStackFrame(v2, ((CoroutineStackFrame)v1));
                }
            }

            return v2;
        }

        return null;
    }

    private final DisposableHandle getParentHandle() {
        return CancellableContinuationImpl.get_parentHandle$volatile$FU().get(this);
    }

    public final Object getResult() {
        Throwable v1_2;
        boolean v0 = this.isReusable();
        if(this.trySuspend()) {
            if(this.getParentHandle() == null) {
                this.installParentHandle();
            }

            if(v0) {
                this.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            }

            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }

        if(v0) {
            this.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        }

        Object v0_1 = this.getState$kotlinx_coroutines_core();
        if((v0_1 instanceof CompletedExceptionally)) {
            Throwable v0_2 = ((CompletedExceptionally)v0_1).cause;
            if(DebugKt.getRECOVER_STACK_TRACES()) {
                if(!(this instanceof CoroutineStackFrame)) {
                }
                else {
                    v0_2 = StackTraceRecoveryKt.access$recoverFromStackFrame(v0_2, ((CoroutineStackFrame)this));
                }
            }

            throw v0_2;
        }

        if(DispatchedTaskKt.isCancellableMode(this.resumeMode)) {
            Element v1 = this.getContext().get(Job.Key);
            if(v1 != null && !((Job)v1).isActive()) {
                CancellationException v1_1 = ((Job)v1).getCancellationException();
                this.cancelCompletedResult$kotlinx_coroutines_core(v0_1, ((Throwable)v1_1));
                if(DebugKt.getRECOVER_STACK_TRACES()) {
                    if(!(this instanceof CoroutineStackFrame)) {
                    }
                    else {
                        v1_2 = StackTraceRecoveryKt.access$recoverFromStackFrame(((Throwable)v1_1), ((CoroutineStackFrame)this));
                    }
                }

                throw ((CancellationException)v1_2);
            }
        }

        return this.getSuccessfulResult$kotlinx_coroutines_core(v0_1);
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final Object getState$kotlinx_coroutines_core() {
        return CancellableContinuationImpl.get_state$volatile$FU().get(this);
    }

    private final String getStateDebugRepresentation() {
        Object v1 = this.getState$kotlinx_coroutines_core();
        if((v1 instanceof NotCompleted)) {
            return "Active";
        }

        if((v1 instanceof CancelledContinuation)) {
            return "Cancelled";
        }

        return "Completed";
    }

    public Object getSuccessfulResult$kotlinx_coroutines_core(Object arg1) {
        if((arg1 instanceof CompletedContinuation)) {
            return ((CompletedContinuation)arg1).result;
        }

        return arg1;
    }

    private final int get_decisionAndIndex$volatile() {
        return this._decisionAndIndex$volatile;
    }

    private static final AtomicIntegerFieldUpdater get_decisionAndIndex$volatile$FU() {
        return CancellableContinuationImpl._decisionAndIndex$volatile$FU;
    }

    private final Object get_parentHandle$volatile() {
        return this._parentHandle$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_parentHandle$volatile$FU() {
        return CancellableContinuationImpl._parentHandle$volatile$FU;
    }

    private final Object get_state$volatile() {
        return this._state$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_state$volatile$FU() {
        return CancellableContinuationImpl._state$volatile$FU;
    }

    public void initCancellability() {
        DisposableHandle v0 = this.installParentHandle();
        if(v0 == null) {
        }
        else if(this.isCompleted()) {
            v0.dispose();
            CancellableContinuationImpl.get_parentHandle$volatile$FU().set(this, NonDisposableHandle.INSTANCE);
        }
    }

    private final DisposableHandle installParentHandle() {
        Element v0 = this.getContext().get(Job.Key);
        DisposableHandle v1 = null;
        if(v0 == null) {
            return v1;
        }

        DisposableHandle v0_1 = JobKt.invokeOnCompletion$default(((Job)v0), false, new ChildContinuation(this), 1, v1);
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(CancellableContinuationImpl.get_parentHandle$volatile$FU(), this, v1, v0_1);
        return v0_1;
    }

    public void invokeOnCancellation(Function1 arg2) {
        CancellableContinuationKt.invokeOnCancellation(((CancellableContinuation)this), new UserSupplied(arg2));
    }

    public void invokeOnCancellation(Segment arg5, int arg6) {
        AtomicIntegerFieldUpdater v0 = CancellableContinuationImpl.get_decisionAndIndex$volatile$FU();
        do {
            int v1 = v0.get(this);
            if((v1 & 0x1FFFFFFF) != 0x1FFFFFFF) {
                goto label_12;
            }
        }
        while(!v0.compareAndSet(this, v1, (v1 >> 29 << 29) + arg6));

        this.invokeOnCancellationImpl(arg5);
        return;
    label_12:
        throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
    }

    private final void invokeOnCancellationImpl(Object arg13) {
        if((DebugKt.getASSERTIONS_ENABLED()) && !(arg13 instanceof CancelHandler)) {
            if((arg13 instanceof Segment)) {
            }
            else {
                throw new AssertionError();
            }
        }

        AtomicReferenceFieldUpdater v0 = CancellableContinuationImpl.get_state$volatile$FU();
        do {
            Object v2 = v0.get(this);
            if(!(v2 instanceof Active)) {
                if(!(v2 instanceof CancelHandler)) {
                    if((v2 instanceof Segment)) {
                    }
                    else {
                        boolean v1 = v2 instanceof CompletedExceptionally;
                        if(v1) {
                            Object v0_1 = v2;
                            if(!((CompletedExceptionally)v0_1).makeHandled()) {
                                this.multipleHandlersError(arg13, v2);
                            }

                            if(!(v2 instanceof CancelledContinuation)) {
                                return;
                            }

                            Throwable v2_1 = null;
                            if(v1) {
                            }
                            else {
                                v0_1 = v2_1;
                            }

                            if(v0_1 != null) {
                                v2_1 = ((CompletedExceptionally)v0_1).cause;
                            }

                            if((arg13 instanceof CancelHandler)) {
                                this.callCancelHandler(((CancelHandler)arg13), v2_1);
                                return;
                            }

                            Intrinsics.checkNotNull(arg13, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                            this.callSegmentOnCancellation(((Segment)arg13), v2_1);
                            return;
                        }
                        else {
                            String v3 = "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler";
                            if((v2 instanceof CompletedContinuation)) {
                                Object v4 = v2;
                                if(((CompletedContinuation)v4).cancelHandler != null) {
                                    this.multipleHandlersError(arg13, v2);
                                }

                                if((arg13 instanceof Segment)) {
                                    return;
                                }

                                Intrinsics.checkNotNull(arg13, v3);
                                Object v6 = arg13;
                                if(((CompletedContinuation)v4).getCancelled()) {
                                    this.callCancelHandler(((CancelHandler)v6), ((CompletedContinuation)v4).cancelCause);
                                    return;
                                }

                                if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(CancellableContinuationImpl.get_state$volatile$FU(), this, v2, CompletedContinuation.copy$default(((CompletedContinuation)v4), null, ((CancelHandler)v6), null, null, null, 29, null))) {
                                    continue;
                                }

                                return;
                            }

                            if((arg13 instanceof Segment)) {
                                return;
                            }

                            Intrinsics.checkNotNull(arg13, v3);
                            if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(CancellableContinuationImpl.get_state$volatile$FU(), this, v2, new CompletedContinuation(v2, arg13, null, null, null, 28, null))) {
                                continue;
                            }

                            return;
                        }
                    }
                }

                this.multipleHandlersError(arg13, v2);
                continue;
            }
            else {
                if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(CancellableContinuationImpl.get_state$volatile$FU(), this, v2, arg13)) {
                    continue;
                }

                return;
            }
        }
        while(true);
    }

    public final void invokeOnCancellationInternal$kotlinx_coroutines_core(CancelHandler arg1) {
        this.invokeOnCancellationImpl(arg1);
    }

    public boolean isActive() {
        return this.getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    public boolean isCancelled() {
        return this.getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
    }

    public boolean isCompleted() {
        return this.getState$kotlinx_coroutines_core() instanceof NotCompleted ^ 1;
    }

    private final boolean isReusable() {
        if(DispatchedTaskKt.isReusableMode(this.resumeMode)) {
            Continuation v1 = this.delegate;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if(((DispatchedContinuation)v1).isReusable$kotlinx_coroutines_core()) {
                return 1;
            }
        }

        return 0;
    }

    private final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater arg1, Object arg2, Function1 arg3) {
        while(true) {
            arg3.invoke(arg1.get(arg2));
        }
    }

    private final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Int(AtomicIntegerFieldUpdater arg1, Object arg2, Function1 arg3) {
        while(true) {
            arg3.invoke(Integer.valueOf(arg1.get(arg2)));
        }
    }

    private final void multipleHandlersError(Object arg3, Object arg4) {
        throw new IllegalStateException("It\'s prohibited to register multiple handlers, tried to register " + arg3 + ", already has " + arg4.toString());
    }

    protected String nameString() {
        return "CancellableContinuation";
    }

    public final void parentCancelled$kotlinx_coroutines_core(Throwable arg2) {
        if(this.cancelLater(arg2)) {
            return;
        }

        this.cancel(arg2);
        this.detachChildIfNonReusable();
    }

    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        Continuation v0 = this.delegate;
        if((v0 instanceof DispatchedContinuation)) {
        }
        else {
            v0 = null;
        }

        if(v0 != null) {
            Throwable v0_1 = ((DispatchedContinuation)v0).tryReleaseClaimedContinuation$kotlinx_coroutines_core(this);
            if(v0_1 == null) {
            }
            else {
                this.detachChild$kotlinx_coroutines_core();
                this.cancel(v0_1);
            }
        }
    }

    public final boolean resetStateReusable() {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.resumeMode == 2) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.getParentHandle() != NonDisposableHandle.INSTANCE) {
            }
            else {
                throw new AssertionError();
            }
        }

        Object v0 = CancellableContinuationImpl.get_state$volatile$FU().get(this);
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(!(v0 instanceof NotCompleted)) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(((v0 instanceof CompletedContinuation)) && ((CompletedContinuation)v0).idempotentResume != null) {
            this.detachChild$kotlinx_coroutines_core();
            return 0;
        }

        CancellableContinuationImpl.get_decisionAndIndex$volatile$FU().set(this, 0x1FFFFFFF);
        CancellableContinuationImpl.get_state$volatile$FU().set(this, Active.INSTANCE);
        return 1;
    }

    public void resume(Object arg3, Function1 arg4) {
        Function3 v1_1;
        int v0 = this.resumeMode;
        if(arg4 != null) {
            CancellableContinuationImpl$$ExternalSyntheticLambda0 v1 = new CancellableContinuationImpl$$ExternalSyntheticLambda0(arg4);
        }
        else {
            v1_1 = null;
        }

        this.resumeImpl$kotlinx_coroutines_core(arg3, v0, v1_1);
    }

    public void resume(Object arg2, Function3 arg3) {
        this.resumeImpl$kotlinx_coroutines_core(arg2, this.resumeMode, arg3);
    }

    static final Unit resume$lambda$13$lambda$12(Function1 arg0, Throwable arg1, Object arg2, CoroutineContext arg3) {
        arg0.invoke(arg1);
        return Unit.INSTANCE;
    }

    public final void resumeImpl$kotlinx_coroutines_core(Object arg10, int arg11, Function3 arg12) {
        Function3 v7;
        Object v5;
        CancellableContinuationImpl v3;
        Object v1;
        AtomicReferenceFieldUpdater v0 = CancellableContinuationImpl.get_state$volatile$FU();
        while(true) {
            v1 = v0.get(this);
            if(!(v1 instanceof NotCompleted)) {
                break;
            }

            v3 = this;
            v5 = arg10;
            int v6 = arg11;
            v7 = arg12;
            if(AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(CancellableContinuationImpl.get_state$volatile$FU(), v3, v1, v3.resumedState(v1, v5, v6, v7, null))) {
                v3.detachChildIfNonReusable();
                v3.dispatchResume(v6);
                return;
            }

            this = v3;
            arg10 = v5;
            arg11 = v6;
            arg12 = v7;
        }

        v3 = this;
        v5 = arg10;
        v7 = arg12;
        if(((v1 instanceof CancelledContinuation)) && (((CancelledContinuation)v1).makeResumed())) {
            if(v7 != null) {
                v3.callOnCancellation(v7, ((CancelledContinuation)v1).cause, v5);
            }

            return;
        }

        v3.alreadyResumedError(v5);
        throw new KotlinNothingValueException();
    }

    public static void resumeImpl$kotlinx_coroutines_core$default(CancellableContinuationImpl arg0, Object arg1, int arg2, Function3 arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 4) != 0) {
                arg3 = null;
            }

            arg0.resumeImpl$kotlinx_coroutines_core(arg1, arg2, arg3);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    public void resumeUndispatched(CoroutineDispatcher arg7, Object arg8) {
        Continuation v0 = this.delegate;
        CoroutineDispatcher v2 = null;
        if((v0 instanceof DispatchedContinuation)) {
        }
        else {
            v0 = ((Continuation)v2);
        }

        if(v0 != null) {
            v2 = ((DispatchedContinuation)v0).dispatcher;
        }

        int v7 = v2 == arg7 ? 4 : this.resumeMode;
        CancellableContinuationImpl.resumeImpl$kotlinx_coroutines_core$default(this, arg8, v7, null, 4, null);
    }

    public void resumeUndispatchedWithException(CoroutineDispatcher arg10, Throwable arg11) {
        Continuation v0 = this.delegate;
        DefaultConstructorMarker v2 = null;
        if((v0 instanceof DispatchedContinuation)) {
        }
        else {
            v0 = ((Continuation)v2);
        }

        CompletedExceptionally v4 = new CompletedExceptionally(arg11, false, 2, v2);
        if(v0 != null) {
            CoroutineDispatcher v2_1 = ((DispatchedContinuation)v0).dispatcher;
        }

        int v10 = (((CoroutineDispatcher)v2)) == arg10 ? 4 : this.resumeMode;
        CancellableContinuationImpl.resumeImpl$kotlinx_coroutines_core$default(this, v4, v10, null, 4, null);
    }

    public void resumeWith(Object arg8) {
        CancellableContinuationImpl.resumeImpl$kotlinx_coroutines_core$default(this, CompletionStateKt.toState(arg8, this), this.resumeMode, null, 4, null);
    }

    private final Object resumedState(NotCompleted arg9, Object arg10, int arg11, Function3 arg12, Object arg13) {
        if((arg10 instanceof CompletedExceptionally)) {
            if(DebugKt.getASSERTIONS_ENABLED()) {
                if(arg13 == null) {
                }
                else {
                    throw new AssertionError();
                }
            }

            if(!DebugKt.getASSERTIONS_ENABLED()) {
                return arg10;
            }

            if(arg12 == null) {
                return arg10;
            }

            throw new AssertionError();
        }
        else {
            if(!DispatchedTaskKt.isCancellableMode(arg11) && arg13 == null) {
                return arg10;
            }

            if(arg12 == null && !(arg9 instanceof CancelHandler)) {
                if(arg13 != null) {
                }
                else {
                    return arg10;
                }
            }

            goto label_26;
        }

        return arg10;
    label_26:
        if((arg9 instanceof CancelHandler)) {
        }
        else {
            arg9 = null;
        }

        return new CompletedContinuation(arg10, arg9, arg12, arg13, null, 16, null);
    }

    private final void set_decisionAndIndex$volatile(int arg1) {
        this._decisionAndIndex$volatile = arg1;
    }

    private final void set_parentHandle$volatile(Object arg1) {
        this._parentHandle$volatile = arg1;
    }

    private final void set_state$volatile(Object arg1) {
        this._state$volatile = arg1;
    }

    public Object takeState$kotlinx_coroutines_core() {
        return this.getState$kotlinx_coroutines_core();
    }

    public String toString() {
        return this.nameString() + '(' + DebugStringsKt.toDebugString(this.delegate) + "){" + this.getStateDebugRepresentation() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    private final boolean tryResume() {
        AtomicIntegerFieldUpdater v0 = CancellableContinuationImpl.get_decisionAndIndex$volatile$FU();
        do {
            int v1 = v0.get(this);
            int v2 = v1 >> 29;
            if(v2 != 0) {
                goto label_5;
            }
        }
        while(!CancellableContinuationImpl.get_decisionAndIndex$volatile$FU().compareAndSet(this, v1, 0x40000000 + (0x1FFFFFFF & v1)));

        return 1;
    label_5:
        if(v2 == 1) {
            return 0;
        }

        throw new IllegalStateException("Already resumed".toString());
    }

    public Object tryResume(Object arg2, Object arg3) {
        return this.tryResumeImpl(arg2, arg3, null);
    }

    public Object tryResume(Object arg1, Object arg2, Function3 arg3) {
        return this.tryResumeImpl(arg1, arg2, arg3);
    }

    private final Symbol tryResumeImpl(Object arg10, Object arg11, Function3 arg12) {
        Object v8;
        Object v5;
        AtomicReferenceFieldUpdater v0 = CancellableContinuationImpl.get_state$volatile$FU();
        while(true) {
            Object v1 = v0.get(this);
            if(!(v1 instanceof NotCompleted)) {
                break;
            }

            CancellableContinuationImpl v3 = this;
            v5 = arg10;
            v8 = arg11;
            Function3 v7 = arg12;
            if(AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(CancellableContinuationImpl.get_state$volatile$FU(), v3, v1, v3.resumedState(v1, v5, this.resumeMode, v7, v8))) {
                v3.detachChildIfNonReusable();
                return CancellableContinuationImplKt.RESUME_TOKEN;
            }

            this = v3;
            arg10 = v5;
            arg12 = v7;
            arg11 = v8;
        }

        v5 = arg10;
        v8 = arg11;
        Symbol v10 = null;
        if(((v1 instanceof CompletedContinuation)) && v8 != null && ((CompletedContinuation)v1).idempotentResume == v8) {
            if(DebugKt.getASSERTIONS_ENABLED()) {
                if(Intrinsics.areEqual(((CompletedContinuation)v1).result, v5)) {
                }
                else {
                    throw new AssertionError();
                }
            }

            return CancellableContinuationImplKt.RESUME_TOKEN;
        }

        return v10;
    }

    public Object tryResumeWithException(Throwable arg5) {
        return this.tryResumeImpl(new CompletedExceptionally(arg5, false, 2, null), null, null);
    }

    private final boolean trySuspend() {
        AtomicIntegerFieldUpdater v0 = CancellableContinuationImpl.get_decisionAndIndex$volatile$FU();
        do {
            int v1 = v0.get(this);
            int v2 = v1 >> 29;
            if(v2 != 0) {
                goto label_4;
            }
        }
        while(!CancellableContinuationImpl.get_decisionAndIndex$volatile$FU().compareAndSet(this, v1, 0x20000000 + (0x1FFFFFFF & v1)));

        return 1;
    label_4:
        if(v2 == 2) {
            return 0;
        }

        throw new IllegalStateException("Already suspended".toString());
    }

    private final void update$atomicfu$ATOMIC_FIELD_UPDATER$Int(AtomicIntegerFieldUpdater arg2, Object arg3, Function1 arg4) {
        do {
            int v1 = arg2.get(arg3);
        }
        while(!arg2.compareAndSet(arg3, v1, arg4.invoke(Integer.valueOf(v1)).intValue()));
    }
}

