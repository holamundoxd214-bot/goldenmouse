package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u001B\bF\u0012\u0010\u0010\u0005\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\n\u001A\u00020\u000B2\u000E\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\rH\u0086\u0080\u0004¢\u0006\u0002\u0010\u000EJ!\u0010\u000F\u001A\u0004\u0018\u00010\u00022\u000E\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\rH¤\u0080\u0004¢\u0006\u0002\u0010\u0010J\n\u0010\u0011\u001A\u00020\u000BH\u0094\u0080\u0004J\u001C\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u000B0\u00012\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0001H\u0096\u0080\u0004J&\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u000B0\u00012\b\u0010\u0013\u001A\u0004\u0018\u00010\u00022\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0001H\u0096\u0080\u0004J\n\u0010\u0014\u001A\u00020\u0015H\u0096\u0080\u0004J\f\u0010\u0019\u001A\u0004\u0018\u00010\u001AH\u0096\u0080\u0004R\u001F\u0010\u0005\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0017\u0010\u0016\u001A\u0004\u0018\u00010\u00038VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u001B"}, d2={"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "<init>", "(Lkotlin/coroutines/Continuation;)V", "getCompletion", "()Lkotlin/coroutines/Continuation;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "create", "value", "toString", "", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class BaseContinuationImpl implements Serializable, Continuation, CoroutineStackFrame {
    private final Continuation completion;

    public BaseContinuationImpl(Continuation arg1) {
        super();
        this.completion = arg1;
    }

    public Continuation create(Object arg1, Continuation arg2) {
        Intrinsics.checkNotNullParameter(arg2, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public Continuation create(Continuation arg1) {
        Intrinsics.checkNotNullParameter(arg1, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public CoroutineStackFrame getCallerFrame() {
        Continuation v1 = this.completion;
        if((v1 instanceof CoroutineStackFrame)) {
            return ((CoroutineStackFrame)v1);
        }

        return null;
    }

    public final Continuation getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return DebugMetadataKt.getStackTraceElement(this);
    }

    protected abstract Object invokeSuspend(Object arg1);

    protected void releaseIntercepted() {
    }

    public final void resumeWith(Object arg3) {
        Continuation v0;
        while(true) {
            DebugProbesKt.probeCoroutineResumed(this);
            v0 = this.completion;
            Intrinsics.checkNotNull(v0);
            try {
                arg3 = this.invokeSuspend(arg3);
                if(arg3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return;
                }

                arg3 = Result.constructor-impl(arg3);
            }
            catch(Throwable v3) {
                arg3 = Result.constructor-impl(ResultKt.createFailure(v3));
            }

            this.releaseIntercepted();
            if(!(v0 instanceof BaseContinuationImpl)) {
                break;
            }

            Continuation v2 = v0;
        }

        v0.resumeWith(arg3);
    }

    public String toString() {
        String v1_1;
        StringBuilder v0 = new StringBuilder("Continuation at ");
        StackTraceElement v1 = this.getStackTraceElement();
        if(v1 == null) {
            v1_1 = this.getClass().getName();
        }

        return v0.append(v1_1).toString();
    }
}

