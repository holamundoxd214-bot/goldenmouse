package androidx.compose.ui.platform;

import android.view.Choreographer$FrameCallback;
import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock$DefaultImpls;
import androidx.compose.runtime.MonotonicFrameClock;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001B\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ(\u0010\u000B\u001A\u0002H\f\"\u0004\b\u0000\u0010\f2\u0012\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u0002H\f0\u000EH\u0096@¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Landroidx/compose/ui/platform/AndroidUiFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "choreographer", "Landroid/view/Choreographer;", "dispatcher", "Landroidx/compose/ui/platform/AndroidUiDispatcher;", "<init>", "(Landroid/view/Choreographer;Landroidx/compose/ui/platform/AndroidUiDispatcher;)V", "(Landroid/view/Choreographer;)V", "getChoreographer", "()Landroid/view/Choreographer;", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidUiFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;
    private final Choreographer choreographer;
    private final AndroidUiDispatcher dispatcher;

    static {
    }

    public AndroidUiFrameClock(Choreographer arg1, AndroidUiDispatcher arg2) {
        super();
        this.choreographer = arg1;
        this.dispatcher = arg2;
    }

    public AndroidUiFrameClock(Choreographer arg2) {
        this(arg2, null);
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((MonotonicFrameClock)this), arg1, arg2);
    }

    public Element get(Key arg1) {
        return DefaultImpls.get(((MonotonicFrameClock)this), arg1);
    }

    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    public CoroutineContext minusKey(Key arg1) {
        return DefaultImpls.minusKey(((MonotonicFrameClock)this), arg1);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((MonotonicFrameClock)this), arg1);
    }

    public Object withFrameNanos(Function1 arg6, Continuation arg7) {
        Element v0_1;
        AndroidUiDispatcher v0 = this.dispatcher;
        if(v0 == null) {
            v0_1 = arg7.getContext().get(ContinuationInterceptor.Key);
            if((v0_1 instanceof AndroidUiDispatcher)) {
            }
            else {
                v0 = null;
            }
        }

        CancellableContinuationImpl v1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg7), 1);
        v1.initCancellability();
        CancellableContinuationImpl v2 = v1;
        AndroidUiFrameClock$withFrameNanos$2$callback$1 v3 = new AndroidUiFrameClock$withFrameNanos$2$callback$1(((CancellableContinuation)v2), this, arg6);
        if((((AndroidUiDispatcher)v0_1)) == null || !Intrinsics.areEqual(((AndroidUiDispatcher)v0_1).getChoreographer(), this.getChoreographer())) {
            this.getChoreographer().postFrameCallback(((Choreographer$FrameCallback)v3));
            ((CancellableContinuation)v2).invokeOnCancellation(new AndroidUiFrameClock$withFrameNanos$2$2(this, ((Choreographer$FrameCallback)v3)));
        }
        else {
            ((AndroidUiDispatcher)v0_1).postFrameCallback$ui(((Choreographer$FrameCallback)v3));
            ((CancellableContinuation)v2).invokeOnCancellation(new AndroidUiFrameClock$withFrameNanos$2$1(((AndroidUiDispatcher)v0_1), ((Choreographer$FrameCallback)v3)));
        }

        Object v5 = v1.getResult();
        if(v5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg7);
        }

        return v5;
    }
}

