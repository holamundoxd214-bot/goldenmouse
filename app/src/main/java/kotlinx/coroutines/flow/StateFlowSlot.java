package kotlinx.coroutines.flow;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Concurrent_commonKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\n\u001A\u00020\u000B2\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\u0002H\u0016J\'\u0010\r\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000F0\u000E2\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001A\u00020\u0010J\u0006\u0010\u0013\u001A\u00020\u000BJ\u000E\u0010\u0014\u001A\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0015R$\u0010\u0005\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0016"}, d2={"Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "<init>", "()V", "_state", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Lkotlinx/coroutines/internal/WorkaroundAtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "allocateLocked", "", "flow", "freeLocked", "", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "awaitPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class StateFlowSlot extends AbstractSharedFlowSlot {
    private final AtomicReference _state;

    public StateFlowSlot() {
        super();
        this._state = new AtomicReference(null);
    }

    public static final AtomicReference access$get_state$p(StateFlowSlot arg0) {
        return arg0._state;
    }

    public boolean allocateLocked(Object arg1) {
        return this.allocateLocked(((StateFlowImpl)arg1));
    }

    public boolean allocateLocked(StateFlowImpl arg1) {
        if(Concurrent_commonKt.getValue(this._state) != null) {
            return 0;
        }

        Concurrent_commonKt.setValue(this._state, StateFlowKt.NONE);
        return 1;
    }

    public final Object awaitPending(Continuation arg5) {
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg5), 1);
        v0.initCancellability();
        CancellableContinuationImpl v1 = v0;
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(!(Concurrent_commonKt.getValue(this._state) instanceof CancellableContinuationImpl)) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this._state, StateFlowKt.NONE, v1)) {
            if(DebugKt.getASSERTIONS_ENABLED()) {
                if(Concurrent_commonKt.getValue(this._state) == StateFlowKt.PENDING) {
                }
                else {
                    throw new AssertionError();
                }
            }

            ((Continuation)v1).resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }

        Object v4 = v0.getResult();
        if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg5);
        }

        if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v4;
        }

        return Unit.INSTANCE;
    }

    public Continuation[] freeLocked(Object arg1) {
        return this.freeLocked(((StateFlowImpl)arg1));
    }

    public Continuation[] freeLocked(StateFlowImpl arg1) {
        Concurrent_commonKt.setValue(this._state, null);
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }

    public final void makePending() {
        Object v1;
        AtomicReference v0 = this._state;
        do {
            v1 = Concurrent_commonKt.getValue(v0);
            if(v1 == null) {
            }
            else if(v1 == StateFlowKt.PENDING) {
            }
            else {
                Symbol v2 = StateFlowKt.NONE;
                AtomicReference v3 = this._state;
                if(v1 != v2) {
                    if(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(v3, v1, StateFlowKt.NONE)) {
                        continue;
                    }

                    break;
                }
                else if(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(v3, v1, StateFlowKt.PENDING)) {
                    continue;
                }
            }

            return;
        }
        while(true);

        ((Continuation)v1).resumeWith(Result.constructor-impl(Unit.INSTANCE));
    }

    public final boolean takePending() {
        Object v1 = this._state.getAndSet(StateFlowKt.NONE);
        Intrinsics.checkNotNull(v1);
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(!(v1 instanceof CancellableContinuationImpl)) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(v1 == StateFlowKt.PENDING) {
            return 1;
        }

        return 0;
    }
}

