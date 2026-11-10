package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u001D\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0012\u001A\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014H\u0016¢\u0006\u0002\u0010\u0015J\r\u0010\u001D\u001A\u00020\u001EH\u0000¢\u0006\u0002\b\u001FJ\r\u0010 \u001A\u00020!H\u0000¢\u0006\u0002\b\"J\r\u0010#\u001A\u00020!H\u0000¢\u0006\u0002\b$J\u0015\u0010%\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001AH\u0000¢\u0006\u0002\b&J\u001B\u0010\'\u001A\u0004\u0018\u00010(2\n\u0010\b\u001A\u0006\u0012\u0002\b\u00030)H\u0000¢\u0006\u0002\b*J\u0015\u0010+\u001A\u00020\u001E2\u0006\u0010,\u001A\u00020(H\u0000¢\u0006\u0002\b-J\u000F\u0010.\u001A\u0004\u0018\u00010\fH\u0010¢\u0006\u0002\b/J\u001B\u00103\u001A\u00020!2\f\u00104\u001A\b\u0012\u0004\u0012\u00028\u000005H\u0016¢\u0006\u0002\u00106J\u001E\u00107\u001A\u00020!2\f\u00104\u001A\b\u0012\u0004\u0012\u00028\u000005H\u0080\b¢\u0006\u0004\b8\u00106J\u0018\u00109\u001A\u00020\u001E2\b\u0010:\u001A\u0004\u0018\u00010\fH\u0080\b¢\u0006\u0002\b;J\u001E\u0010<\u001A\u00020!2\f\u00104\u001A\b\u0012\u0004\u0012\u00028\u000005H\u0080\b¢\u0006\u0004\b=\u00106J\u001F\u0010>\u001A\u00020!2\u0006\u0010?\u001A\u00020@2\u0006\u0010A\u001A\u00028\u0000H\u0000¢\u0006\u0004\bB\u0010CJ\b\u0010D\u001A\u00020EH\u0016R\u0010\u0010\u0006\u001A\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000B\u001A\u0004\u0018\u00010\f8\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u000ER\u001C\u0010\u000F\u001A\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0016\u001A\u00020\f8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0018X\u0082\u0004R\u001A\u0010\u0019\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u001A8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u001A\u00100\u001A\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b1\u00102R\u0012\u0010?\u001A\u00020@X\u0096\u0005¢\u0006\u0006\u001A\u0004\bF\u0010G¨\u0006H"}, d2={"Lkotlinx/coroutines/internal/DispatchedContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "_state", "", "get_state$kotlinx_coroutines_core$annotations", "()V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "()Ljava/lang/StackTraceElement;", "countOrElement", "_reusableCancellableContinuation", "Lkotlinx/atomicfu/AtomicRef;", "reusableCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "getReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "isReusable", "", "isReusable$kotlinx_coroutines_core", "awaitReusability", "", "awaitReusability$kotlinx_coroutines_core", "release", "release$kotlinx_coroutines_core", "claimReusableCancellableContinuation", "claimReusableCancellableContinuation$kotlinx_coroutines_core", "tryReleaseClaimedContinuation", "", "Lkotlinx/coroutines/CancellableContinuation;", "tryReleaseClaimedContinuation$kotlinx_coroutines_core", "postponeCancellation", "cause", "postponeCancellation$kotlinx_coroutines_core", "takeState", "takeState$kotlinx_coroutines_core", "delegate", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "resumeCancellableWith", "resumeCancellableWith$kotlinx_coroutines_core", "resumeCancelled", "state", "resumeCancelled$kotlinx_coroutines_core", "resumeUndispatchedWith", "resumeUndispatchedWith$kotlinx_coroutines_core", "dispatchYield", "context", "Lkotlin/coroutines/CoroutineContext;", "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "toString", "", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DispatchedContinuation extends DispatchedTask implements Continuation, CoroutineStackFrame {
    public Object _state;
    public final Continuation continuation;
    public final Object countOrElement;
    public final CoroutineDispatcher dispatcher;

    static {
        DispatchedContinuation._reusableCancellableContinuation$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation$volatile");
    }

    public DispatchedContinuation(CoroutineDispatcher arg2, Continuation arg3) {
        super(-1);
        this.dispatcher = arg2;
        this.continuation = arg3;
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        this.countOrElement = ThreadContextKt.threadContextElements(this.getContext());
    }

    public final void awaitReusability$kotlinx_coroutines_core() {
        AtomicReferenceFieldUpdater v0 = DispatchedContinuation.get_reusableCancellableContinuation$volatile$FU();
        do {
        }
        while(v0.get(this) == DispatchedContinuationKt.REUSABLE_CLAIMED);
    }

    public final CancellableContinuationImpl claimReusableCancellableContinuation$kotlinx_coroutines_core() {
        Object v1;
        AtomicReferenceFieldUpdater v0 = DispatchedContinuation.get_reusableCancellableContinuation$volatile$FU();
        while(true) {
            v1 = v0.get(this);
            if(v1 == null) {
                goto label_3;
            }

            if((v1 instanceof CancellableContinuationImpl)) {
                if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(DispatchedContinuation.get_reusableCancellableContinuation$volatile$FU(), this, v1, DispatchedContinuationKt.REUSABLE_CLAIMED)) {
                    continue;
                }

                return ((CancellableContinuationImpl)v1);
            }

            if(v1 == DispatchedContinuationKt.REUSABLE_CLAIMED) {
                continue;
            }

            if(!(v1 instanceof Throwable)) {
                break;
            }
        }

        throw new IllegalStateException("Inconsistent state " + v1.toString());
    label_3:
        DispatchedContinuation.get_reusableCancellableContinuation$volatile$FU().set(this, DispatchedContinuationKt.REUSABLE_CLAIMED);
        return null;
    }

    public final void dispatchYield$kotlinx_coroutines_core(CoroutineContext arg1, Object arg2) {
        this._state = arg2;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(arg1, ((Runnable)this));
    }

    public CoroutineStackFrame getCallerFrame() {
        Continuation v1 = this.continuation;
        if((v1 instanceof CoroutineStackFrame)) {
            return ((CoroutineStackFrame)v1);
        }

        return null;
    }

    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    public Continuation getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    private final CancellableContinuationImpl getReusableCancellableContinuation() {
        Object v1 = DispatchedContinuation.get_reusableCancellableContinuation$volatile$FU().get(this);
        if((v1 instanceof CancellableContinuationImpl)) {
            return ((CancellableContinuationImpl)v1);
        }

        return null;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    private final Object get_reusableCancellableContinuation$volatile() {
        return this._reusableCancellableContinuation$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_reusableCancellableContinuation$volatile$FU() {
        return DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
    }

    public static void get_state$kotlinx_coroutines_core$annotations() {
    }

    public final boolean isReusable$kotlinx_coroutines_core() {
        if(DispatchedContinuation.get_reusableCancellableContinuation$volatile$FU().get(this) != null) {
            return 1;
        }

        return 0;
    }

    private final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater arg1, Object arg2, Function1 arg3) {
        while(true) {
            arg3.invoke(arg1.get(arg2));
        }
    }

    public final boolean postponeCancellation$kotlinx_coroutines_core(Throwable arg5) {
        AtomicReferenceFieldUpdater v0 = DispatchedContinuation.get_reusableCancellableContinuation$volatile$FU();
        do {
        label_1:
            Object v1 = v0.get(this);
            if(Intrinsics.areEqual(v1, DispatchedContinuationKt.REUSABLE_CLAIMED)) {
                if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(DispatchedContinuation.get_reusableCancellableContinuation$volatile$FU(), this, DispatchedContinuationKt.REUSABLE_CLAIMED, arg5)) {
                    goto label_1;
                }

                return 1;
            }

            if((v1 instanceof Throwable)) {
                return 1;
            }
        }
        while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(DispatchedContinuation.get_reusableCancellableContinuation$volatile$FU(), this, v1, null));

        return 0;
    }

    public final void release$kotlinx_coroutines_core() {
        this.awaitReusability$kotlinx_coroutines_core();
        CancellableContinuationImpl v0 = this.getReusableCancellableContinuation();
        if(v0 != null) {
            v0.detachChild$kotlinx_coroutines_core();
        }
    }

    public final void resumeCancellableWith$kotlinx_coroutines_core(Object arg8) {
        UndispatchedCoroutine v0_2;
        CoroutineContext v5;
        Object v4_1;
        Object v0 = CompletionStateKt.toState(arg8);
        if(DispatchedContinuationKt.safeIsDispatchNeeded(this.dispatcher, this.getContext())) {
            this._state = v0;
            this.resumeMode = 1;
            DispatchedContinuationKt.safeDispatch(this.dispatcher, this.getContext(), ((Runnable)this));
            return;
        }

        DebugKt.getASSERTIONS_ENABLED();
        EventLoop v1 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if(v1.isUnconfinedLoopActive()) {
            this._state = v0;
            this.resumeMode = 1;
            v1.dispatchUnconfined(((DispatchedTask)this));
            return;
        }

        DispatchedContinuation v3 = this;
        v1.incrementUseCount(true);
        try {
            Element v4 = this.getContext().get(Job.Key);
            if(v4 == null || (((Job)v4).isActive())) {
                Continuation v0_1 = this.continuation;
                v4_1 = this.countOrElement;
                v5 = v0_1.getContext();
                v4_1 = ThreadContextKt.updateThreadContext(v5, v4_1);
                if(v4_1 != ThreadContextKt.NO_THREAD_ELEMENTS) {
                    v0_2 = CoroutineContextKt.updateUndispatchedCompletion(v0_1, v5, v4_1);
                }
                else {
                    goto label_45;
                }

                goto label_46;
            }
            else {
                CancellationException v8 = ((Job)v4).getCancellationException();
                this.cancelCompletedResult$kotlinx_coroutines_core(v0, v8);
                ((Continuation)this).resumeWith(Result.constructor-impl(ResultKt.createFailure(((Throwable)v8))));
            }

            goto label_53;
        }
        catch(Throwable v7) {
            goto label_63;
        }

    label_45:
        v0_2 = null;
        try {
        label_46:
            this.continuation.resumeWith(arg8);
            if(v0_2 == null) {
                goto label_52;
            }

            goto label_50;
        }
        catch(Throwable v7) {
            try {
                if(v0_2 == null || (v0_2.clearThreadContext())) {
                    ThreadContextKt.restoreThreadContext(v5, v4_1);
                }

                throw v7;
            label_50:
                if(!v0_2.clearThreadContext()) {
                    goto label_53;
                }

            label_52:
                ThreadContextKt.restoreThreadContext(v5, v4_1);
                do {
                label_53:
                }
                while(v1.processUnconfinedEvent());
            }
            catch(Throwable v7) {
                try {
                label_63:
                    ((DispatchedTask)v3).handleFatalException$kotlinx_coroutines_core(v7);
                }
                catch(Throwable v7) {
                    v1.decrementUseCount(true);
                    throw v7;
                }
            }
        }

        v1.decrementUseCount(true);
    }

    public final boolean resumeCancelled$kotlinx_coroutines_core(Object arg3) {
        Element v0 = this.getContext().get(Job.Key);
        if(v0 != null && !((Job)v0).isActive()) {
            CancellationException v0_1 = ((Job)v0).getCancellationException();
            this.cancelCompletedResult$kotlinx_coroutines_core(arg3, ((Throwable)v0_1));
            ((Continuation)this).resumeWith(Result.constructor-impl(ResultKt.createFailure(((Throwable)v0_1))));
            return 1;
        }

        return 0;
    }

    public final void resumeUndispatchedWith$kotlinx_coroutines_core(Object arg5) {
        Continuation v0 = this.continuation;
        Object v1 = this.countOrElement;
        CoroutineContext v2 = v0.getContext();
        v1 = ThreadContextKt.updateThreadContext(v2, v1);
        UndispatchedCoroutine v0_1 = v1 != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(v0, v2, v1) : null;
        try {
            this.continuation.resumeWith(arg5);
            if(v0_1 == null) {
                goto label_15;
            }
        }
        catch(Throwable v4) {
            if(v0_1 == null || (v0_1.clearThreadContext())) {
                ThreadContextKt.restoreThreadContext(v2, v1);
            }

            throw v4;
        }

        if(v0_1.clearThreadContext()) {
        label_15:
            ThreadContextKt.restoreThreadContext(v2, v1);
        }
    }

    public void resumeWith(Object arg6) {
        Object v4;
        CoroutineContext v3;
        Object v0 = CompletionStateKt.toState(arg6);
        if(DispatchedContinuationKt.safeIsDispatchNeeded(this.dispatcher, this.getContext())) {
            this._state = v0;
            this.resumeMode = 0;
            DispatchedContinuationKt.safeDispatch(this.dispatcher, this.getContext(), ((Runnable)this));
            return;
        }

        DebugKt.getASSERTIONS_ENABLED();
        EventLoop v1 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if(v1.isUnconfinedLoopActive()) {
            this._state = v0;
            this.resumeMode = 0;
            v1.dispatchUnconfined(((DispatchedTask)this));
            return;
        }

        DispatchedContinuation v0_1 = this;
        v1.incrementUseCount(true);
        try {
            v3 = this.getContext();
            v4 = ThreadContextKt.updateThreadContext(v3, this.countOrElement);
        }
        catch(Throwable v5) {
            goto label_38;
        }

        try {
            this.continuation.resumeWith(arg6);
            goto label_30;
        }
        catch(Throwable v5) {
            try {
                ThreadContextKt.restoreThreadContext(v3, v4);
                throw v5;
            label_30:
                ThreadContextKt.restoreThreadContext(v3, v4);
                do {
                }
                while(v1.processUnconfinedEvent());
            }
            catch(Throwable v5) {
                try {
                label_38:
                    ((DispatchedTask)v0_1).handleFatalException$kotlinx_coroutines_core(v5);
                }
                catch(Throwable v5) {
                    v1.decrementUseCount(true);
                    throw v5;
                }
            }
        }

        v1.decrementUseCount(true);
    }

    private final void set_reusableCancellableContinuation$volatile(Object arg1) {
        this._reusableCancellableContinuation$volatile = arg1;
    }

    public Object takeState$kotlinx_coroutines_core() {
        Object v0 = this._state;
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(v0 != DispatchedContinuationKt.access$getUNDEFINED$p()) {
            }
            else {
                throw new AssertionError();
            }
        }

        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        return v0;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + DebugStringsKt.toDebugString(this.continuation) + ']';
    }

    public final Throwable tryReleaseClaimedContinuation$kotlinx_coroutines_core(CancellableContinuation arg5) {
        Throwable v3;
        Object v1;
        AtomicReferenceFieldUpdater v0 = DispatchedContinuation.get_reusableCancellableContinuation$volatile$FU();
        do {
            v1 = v0.get(this);
            v3 = null;
            if(v1 != DispatchedContinuationKt.REUSABLE_CLAIMED) {
                goto label_10;
            }
        }
        while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(DispatchedContinuation.get_reusableCancellableContinuation$volatile$FU(), this, DispatchedContinuationKt.REUSABLE_CLAIMED, arg5));

        return v3;
    label_10:
        if((v1 instanceof Throwable)) {
            if(AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(DispatchedContinuation.get_reusableCancellableContinuation$volatile$FU(), this, v1, v3)) {
                return ((Throwable)v1);
            }

            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        throw new IllegalStateException("Inconsistent state " + v1.toString());
    }
}

