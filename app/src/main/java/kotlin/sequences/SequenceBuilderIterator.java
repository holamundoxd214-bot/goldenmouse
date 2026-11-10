package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\t\bF¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0013\u001A\u00020\u0014H\u0096\u0082\u0004J\u000F\u0010\u0015\u001A\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0016J\u000F\u0010\u0017\u001A\u00028\u0000H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0016J\n\u0010\u0018\u001A\u00020\u0019H\u0082\u0080\u0004J\u0017\u0010\u001A\u001A\u00020\u00052\u0006\u0010\u001B\u001A\u00028\u0000H\u0096À\u0004¢\u0006\u0002\u0010\u001CJ\u001D\u0010\u001D\u001A\u00020\u00052\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096À\u0004¢\u0006\u0002\u0010\u001FJ\u001D\u0010 \u001A\u00020\u00052\f\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00050\"H\u0096\u0080\u0004¢\u0006\u0002\u0010#R\u0013\u0010\b\u001A\u00060\tj\u0002`\nX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0013\u0010\u000B\u001A\u0004\u0018\u00018\u0000X\u0082\u008E\b¢\u0006\u0004\n\u0002\u0010\fR\u0017\u0010\r\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u0082\u008E\b¢\u0006\u0002\n\u0000R#\u0010\u000E\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0015\u0010$\u001A\u00020%8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b&\u0010\'¨\u0006("}, d2={"Lkotlin/sequences/SequenceBuilderIterator;", "T", "Lkotlin/sequences/SequenceScope;", "", "Lkotlin/coroutines/Continuation;", "", "<init>", "()V", "state", "", "Lkotlin/sequences/State;", "nextValue", "Ljava/lang/Object;", "nextIterator", "nextStep", "getNextStep", "()Lkotlin/coroutines/Continuation;", "setNextStep", "(Lkotlin/coroutines/Continuation;)V", "hasNext", "", "next", "()Ljava/lang/Object;", "nextNotReady", "exceptionalState", "", "yield", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class SequenceBuilderIterator extends SequenceScope implements Iterator, Continuation, KMappedMarker {
    private Iterator nextIterator;
    private Continuation nextStep;
    private Object nextValue;
    private int state;

    public SequenceBuilderIterator() {
        super();
    }

    private final Throwable exceptionalState() {
        int v0 = this.state;
        if(v0 != 4) {
            if(v0 != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.state);
            }

            return new IllegalStateException("Iterator has failed.");
        }

        return new NoSuchElementException();
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final Continuation getNextStep() {
        return this.nextStep;
    }

    public boolean hasNext() {
        while(true) {
            int v0 = this.state;
            Iterator v1 = null;
            if(v0 != 0) {
                int v2 = 2;
                if(v0 != 1) {
                    if(v0 != v2 && v0 != 3) {
                        if(v0 == 4) {
                            return 0;
                        }
                        else {
                            throw this.exceptionalState();
                        }
                    }

                    return 1;
                }
                else {
                    Iterator v0_1 = this.nextIterator;
                    Intrinsics.checkNotNull(v0_1);
                    if(v0_1.hasNext()) {
                        this.state = v2;
                        return 1;
                    }

                    this.nextIterator = v1;
                }
            }

            this.state = 5;
            Continuation v0_2 = this.nextStep;
            Intrinsics.checkNotNull(v0_2);
            this.nextStep = ((Continuation)v1);
            v0_2.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
    }

    public Object next() {
        int v0 = this.state;
        if(v0 != 0 && v0 != 1) {
            if(v0 == 2) {
                this.state = 1;
                Iterator v3 = this.nextIterator;
                Intrinsics.checkNotNull(v3);
                return v3.next();
            }
            else if(v0 == 3) {
                this.state = 0;
                Object v0_1 = this.nextValue;
                this.nextValue = null;
                return v0_1;
            }
            else {
                throw this.exceptionalState();
            }
        }

        return this.nextNotReady();
    }

    private final Object nextNotReady() {
        if(this.hasNext()) {
            return this.next();
        }

        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void resumeWith(Object arg1) {
        ResultKt.throwOnFailure(arg1);
        this.state = 4;
    }

    public final void setNextStep(Continuation arg1) {
        this.nextStep = arg1;
    }

    public Object yield(Object arg1, Continuation arg2) {
        this.nextValue = arg1;
        this.state = 3;
        this.nextStep = arg2;
        Object v0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg2);
        }

        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public Object yieldAll(Iterator arg2, Continuation arg3) {
        if(!arg2.hasNext()) {
            return Unit.INSTANCE;
        }

        this.nextIterator = arg2;
        this.state = 2;
        this.nextStep = arg3;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg3);
        }

        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }
}

