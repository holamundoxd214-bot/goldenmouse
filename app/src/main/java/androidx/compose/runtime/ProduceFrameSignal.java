package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0005\u001A\u00020\u00062\n\u0010\u0007\u001A\u00060\u0001j\u0002`\bH\u0086@¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001A\u00020\u0006J\u000E\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fR\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Landroidx/compose/runtime/ProduceFrameSignal;", "", "<init>", "()V", "pendingFrameContinuation", "awaitFrameRequest", "", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "takeFrameRequestLocked", "requestFrameLocked", "Lkotlin/coroutines/Continuation;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class ProduceFrameSignal {
    private Object pendingFrameContinuation;

    public ProduceFrameSignal() {
        super();
    }

    public static final Object access$getPendingFrameContinuation$p(ProduceFrameSignal arg0) {
        return arg0.pendingFrameContinuation;
    }

    public static final void access$setPendingFrameContinuation$p(ProduceFrameSignal arg0, Object arg1) {
        arg0.pendingFrameContinuation = arg1;
    }

    public final Object awaitFrameRequest(Object arg5, Continuation arg6) {
        Unit v4_1;
        __monitor_enter(arg5);
        try {
            if(this.pendingFrameContinuation != RecomposerKt.access$getProduceAnotherFrame$p()) {
                goto label_9;
            }

            this.pendingFrameContinuation = RecomposerKt.access$getFramePending$p();
            v4_1 = Unit.INSTANCE;
        }
        catch(Throwable v4) {
            goto label_45;
        }

        __monitor_exit(arg5);
        return v4_1;
    label_9:
        goto label_10;
    label_45:
        __monitor_exit(arg5);
        throw v4;
    label_10:
        __monitor_exit(arg5);
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg6), 1);
        v0.initCancellability();
        CancellableContinuationImpl v1 = v0;
        __monitor_enter(arg5);
        try {
            if(this.pendingFrameContinuation == RecomposerKt.access$getProduceAnotherFrame$p()) {
                this.pendingFrameContinuation = RecomposerKt.access$getFramePending$p();
            }
            else {
                this.pendingFrameContinuation = v1;
                v1 = null;
            }
        }
        catch(Throwable v4) {
            __monitor_exit(arg5);
            throw v4;
        }

        __monitor_exit(arg5);
        if(v1 != null) {
            ((Continuation)v1).resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }

        Object v4_2 = v0.getResult();
        if(v4_2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg6);
        }

        if(v4_2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v4_2;
        }

        return Unit.INSTANCE;
    }

    public final Continuation requestFrameLocked() {
        Object v0 = this.pendingFrameContinuation;
        if((v0 instanceof Continuation)) {
            this.pendingFrameContinuation = RecomposerKt.access$getFramePending$p();
            return ((Continuation)v0);
        }

        Continuation v2 = null;
        if(!Intrinsics.areEqual(v0, RecomposerKt.access$getProduceAnotherFrame$p())) {
            if(Intrinsics.areEqual(v0, RecomposerKt.access$getFramePending$p())) {
            }
            else if(v0 == null) {
                this.pendingFrameContinuation = RecomposerKt.access$getProduceAnotherFrame$p();
                return v2;
            }
            else {
                throw new IllegalStateException("invalid pendingFrameContinuation " + v0.toString());
            }
        }

        return v2;
    }

    public final void takeFrameRequestLocked() {
        int v0 = this.pendingFrameContinuation == RecomposerKt.access$getFramePending$p() ? 1 : 0;
        if(v0 == 0) {
            PreconditionsKt.throwIllegalStateException("frame not pending");
        }

        this.pendingFrameContinuation = null;
    }
}

