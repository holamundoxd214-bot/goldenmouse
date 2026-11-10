package androidx.compose.runtime;

import android.view.Choreographer$FrameCallback;
import android.view.Choreographer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0007\u001A\u0002H\b\"\u0004\b\u0000\u0010\b2!\u0010\t\u001A\u001D\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u0002H\b0\nH\u0096@¢\u0006\u0002\u0010\u000FR\u0016\u0010\u0004\u001A\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/compose/runtime/DefaultChoreographerFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "<init>", "()V", "choreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class DefaultChoreographerFrameClock implements MonotonicFrameClock {
    public static final DefaultChoreographerFrameClock INSTANCE;
    private static final Choreographer choreographer;

    static {
        DefaultChoreographerFrameClock.INSTANCE = new DefaultChoreographerFrameClock();
        DefaultChoreographerFrameClock.choreographer = BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new DefaultChoreographerFrameClock$choreographer$1(null));
    }

    private DefaultChoreographerFrameClock() {
        super();
    }

    public static final Choreographer access$getChoreographer$p() {
        return DefaultChoreographerFrameClock.choreographer;
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((MonotonicFrameClock)this), arg1, arg2);
    }

    public Element get(Key arg1) {
        return DefaultImpls.get(((MonotonicFrameClock)this), arg1);
    }

    public CoroutineContext minusKey(Key arg1) {
        return DefaultImpls.minusKey(((MonotonicFrameClock)this), arg1);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((MonotonicFrameClock)this), arg1);
    }

    public Object withFrameNanos(Function1 arg3, Continuation arg4) {
        CancellableContinuationImpl v2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg4), 1);
        v2.initCancellability();
        DefaultChoreographerFrameClock$withFrameNanos$2$callback$1 v1 = new DefaultChoreographerFrameClock$withFrameNanos$2$callback$1(v2, arg3);
        DefaultChoreographerFrameClock.choreographer.postFrameCallback(((Choreographer$FrameCallback)v1));
        v2.invokeOnCancellation(new DefaultChoreographerFrameClock$withFrameNanos$2$1(((Choreographer$FrameCallback)v1)));
        Object v2_1 = v2.getResult();
        if(v2_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg4);
        }

        return v2_1;
    }
}

