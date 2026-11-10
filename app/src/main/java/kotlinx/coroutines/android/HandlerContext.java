package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.NonDisposableHandle;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nB\u001D\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\u000BJ\u0010\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u001C\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0010\u001A\u00020\u00112\n\u0010\u0014\u001A\u00060\u0015j\u0002`\u0016H\u0016J\u001E\u0010\u0017\u001A\u00020\u00132\u0006\u0010\u0018\u001A\u00020\u00192\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00130\u001BH\u0016J$\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u0018\u001A\u00020\u00192\n\u0010\u0014\u001A\u00060\u0015j\u0002`\u00162\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u001C\u0010\u001E\u001A\u00020\u00132\u0006\u0010\u0010\u001A\u00020\u00112\n\u0010\u0014\u001A\u00060\u0015j\u0002`\u0016H\u0002J\b\u0010\u001F\u001A\u00020\u0006H\u0016J\u0013\u0010 \u001A\u00020\b2\b\u0010!\u001A\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001A\u00020$H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006%"}, d2={"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "invokeImmediately", "", "<init>", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "(Landroid/os/Handler;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "isDispatchNeeded", "context", "Lkotlin/coroutines/CoroutineContext;", "dispatch", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "scheduleResumeAfterDelay", "timeMillis", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "cancelOnRejection", "toString", "equals", "other", "", "hashCode", "", "kotlinx-coroutines-android"}, k=1, mv={2, 1, 0}, xi=0x30) public final class HandlerContext extends HandlerDispatcher implements Delay {
    private final Handler handler;
    private final HandlerContext immediate;
    private final boolean invokeImmediately;
    private final String name;

    public HandlerContext(Handler arg1, String arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public HandlerContext(Handler arg2, String arg3) {
        this(arg2, arg3, false);
    }

    private HandlerContext(Handler arg2, String arg3, boolean arg4) {
        super(null);
        this.handler = arg2;
        this.name = arg3;
        this.invokeImmediately = arg4;
        HandlerContext v4 = arg4 ? this : new HandlerContext(arg2, arg3, true);
        this.immediate = v4;
    }

    private final void cancelOnRejection(CoroutineContext arg4, Runnable arg5) {
        JobKt.cancel(arg4, new CancellationException("The task was rejected, the handler underlying the dispatcher \'" + this + "\' was closed"));
        Dispatchers.getIO().dispatch(arg4, arg5);
    }

    public void dispatch(CoroutineContext arg2, Runnable arg3) {
        if(!this.handler.post(arg3)) {
            this.cancelOnRejection(arg2, arg3);
        }
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof HandlerContext)) && ((HandlerContext)arg3).handler == this.handler && ((HandlerContext)arg3).invokeImmediately == this.invokeImmediately) {
            return 1;
        }

        return 0;
    }

    public MainCoroutineDispatcher getImmediate() {
        return this.getImmediate();
    }

    public HandlerContext getImmediate() {
        return this.immediate;
    }

    public HandlerDispatcher getImmediate() {
        return this.getImmediate();
    }

    public int hashCode() {
        int v0 = System.identityHashCode(this.handler);
        int v1 = this.invokeImmediately ? 0x4CF : 0x4D5;
        return v1 ^ v0;
    }

    public DisposableHandle invokeOnTimeout(long arg4, Runnable arg6, CoroutineContext arg7) {
        if(this.handler.postDelayed(arg6, RangesKt.coerceAtMost(arg4, 0x3FFFFFFFFFFFFFFFL))) {
            return new HandlerContext$$ExternalSyntheticLambda0(this, arg6);
        }

        this.cancelOnRejection(arg7, arg6);
        return NonDisposableHandle.INSTANCE;
    }

    static final void invokeOnTimeout$lambda$3(HandlerContext arg0, Runnable arg1) {
        arg0.handler.removeCallbacks(arg1);
    }

    public boolean isDispatchNeeded(CoroutineContext arg1) {
        if(this.invokeImmediately) {
            if(!Intrinsics.areEqual(Looper.myLooper(), this.handler.getLooper())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public void scheduleResumeAfterDelay(long arg5, CancellableContinuation arg7) {
        HandlerContext$$ExternalSyntheticLambda1 v0 = new HandlerContext$$ExternalSyntheticLambda1(arg7, this);
        if(this.handler.postDelayed(((Runnable)v0), RangesKt.coerceAtMost(arg5, 0x3FFFFFFFFFFFFFFFL))) {
            arg7.invokeOnCancellation(new HandlerContext$$ExternalSyntheticLambda2(this, ((Runnable)v0)));
            return;
        }

        this.cancelOnRejection(arg7.getContext(), ((Runnable)v0));
    }

    static final void scheduleResumeAfterDelay$lambda$1(CancellableContinuation arg1, HandlerContext arg2) {
        arg1.resumeUndispatched(((CoroutineDispatcher)arg2), Unit.INSTANCE);
    }

    static final Unit scheduleResumeAfterDelay$lambda$2(HandlerContext arg0, Runnable arg1, Throwable arg2) {
        arg0.handler.removeCallbacks(arg1);
        return Unit.INSTANCE;
    }

    public String toString() {
        String v0 = this.toStringInternalImpl();
        if(v0 == null) {
            v0 = this.name;
            if(v0 == null) {
                v0 = this.handler.toString();
            }

            if(!this.invokeImmediately) {
                return v0;
            }

            return v0 + ".immediate";
        }

        return v0;
    }
}

