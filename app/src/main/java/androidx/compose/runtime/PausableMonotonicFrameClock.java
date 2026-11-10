package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\n\u001A\u00020\u000BJ\u0006\u0010\f\u001A\u00020\u000BJ7\u0010\r\u001A\u0002H\u000E\"\u0004\b\u0000\u0010\u000E2!\u0010\u000F\u001A\u001D\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u0002H\u000E0\u0010H\u0096@¢\u0006\u0002\u0010\u0015R\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\u0007\u0010\t¨\u0006\u0016"}, d2={"Landroidx/compose/runtime/PausableMonotonicFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "frameClock", "<init>", "(Landroidx/compose/runtime/MonotonicFrameClock;)V", "latch", "Landroidx/compose/runtime/Latch;", "isPaused", "", "()Z", "pause", "", "resume", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PausableMonotonicFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;
    private final MonotonicFrameClock frameClock;
    private final Latch latch;

    static {
    }

    public PausableMonotonicFrameClock(MonotonicFrameClock arg1) {
        super();
        this.frameClock = arg1;
        this.latch = new Latch();
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((MonotonicFrameClock)this), arg1, arg2);
    }

    public Element get(Key arg1) {
        return DefaultImpls.get(((MonotonicFrameClock)this), arg1);
    }

    public final boolean isPaused() {
        return this.latch.isOpen() ^ 1;
    }

    public CoroutineContext minusKey(Key arg1) {
        return DefaultImpls.minusKey(((MonotonicFrameClock)this), arg1);
    }

    public final void pause() {
        this.latch.closeLatch();
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((MonotonicFrameClock)this), arg1);
    }

    public final void resume() {
        this.latch.openLatch();
    }

    public Object withFrameNanos(Function1 arg6, Continuation arg7) {
        Object v6;
        PausableMonotonicFrameClock$withFrameNanos$1 v0_1;
        int v2;
        if((arg7 instanceof PausableMonotonicFrameClock$withFrameNanos$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((PausableMonotonicFrameClock$withFrameNanos$1)v0).label & v2) != 0) {
                ((PausableMonotonicFrameClock$withFrameNanos$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new PausableMonotonicFrameClock$withFrameNanos$1(this, arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            Latch v7_1 = this.latch;
            v0_1.L$0 = arg6;
            v0_1.label = 1;
            if(v7_1.await(((Continuation)v0_1)) == v1) {
            }
            else {
            label_37:
                MonotonicFrameClock v5 = this.frameClock;
                v0_1.L$0 = null;
                v0_1.label = v3;
                Object v5_1 = v5.withFrameNanos(((Function1)v6), ((Continuation)v0_1));
                if(v5_1 == v1) {
                    return v1;
                }

                return v5_1;
            }
        }
        else if(v2 == 1) {
            v6 = v0_1.L$0;
            ResultKt.throwOnFailure(v7);
            goto label_37;
        }
        else if(v2 == v3) {
            ResultKt.throwOnFailure(v7);
            return v7;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return v1;
    }
}

