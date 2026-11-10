package kotlinx.coroutines.android;

import android.os.Build$VERSION;
import android.os.Handler$Callback;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.Constructor;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001D\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\b\u0005\u001A\u0014\u0010\b\u001A\u00020\u0002*\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0001\u001A\u000E\u0010\u0011\u001A\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u0012\u001A\u000E\u0010\u0013\u001A\u00020\u0007H\u0082@¢\u0006\u0002\u0010\u0012\u001A\u0016\u0010\u0014\u001A\u00020\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0002\u001A\u001E\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u000F\u001A\u00020\u00102\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0002\"\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\f\u001A\u0004\u0018\u00010\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u000E\"\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"asCoroutineDispatcher", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Landroid/os/Handler;", "name", "", "from", "MAX_DELAY", "", "asHandler", "Landroid/os/Looper;", "async", "", "Main", "getMain$annotations", "()V", "choreographer", "Landroid/view/Choreographer;", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFrameSlowPath", "updateChoreographerAndPostFrameCallback", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "postFrameCallback", "kotlinx-coroutines-android"}, k=2, mv={2, 1, 0}, xi=0x30) public final class HandlerDispatcherKt {
    private static final long MAX_DELAY = 0x3FFFFFFFFFFFFFFFL;
    public static final HandlerDispatcher Main;
    private static volatile Choreographer choreographer;

    static {
        Object v0_1;
        Object v1_1;
        String v0 = null;
        try {
            v1_1 = Result.constructor-impl(new HandlerContext(HandlerDispatcherKt.asHandler(Looper.getMainLooper(), true), v0, 2, ((DefaultConstructorMarker)v0)));
        }
        catch(Throwable v1) {
            v1_1 = Result.constructor-impl(ResultKt.createFailure(v1));
        }

        if(Result.isFailure-impl(v1_1)) {
        }
        else {
            v0_1 = v1_1;
        }

        HandlerDispatcherKt.Main = ((HandlerDispatcher)v0_1);
    }

    public static final Object access$awaitFrameSlowPath(Continuation arg0) {
        return HandlerDispatcherKt.awaitFrameSlowPath(arg0);
    }

    public static final void access$postFrameCallback(Choreographer arg0, CancellableContinuation arg1) {
        HandlerDispatcherKt.postFrameCallback(arg0, arg1);
    }

    public static final void access$updateChoreographerAndPostFrameCallback(CancellableContinuation arg0) {
        HandlerDispatcherKt.updateChoreographerAndPostFrameCallback(arg0);
    }

    public static final Handler asHandler(Looper arg5, boolean arg6) {
        Constructor v6;
        if(arg6) {
            Object v1 = null;
            if(Build$VERSION.SDK_INT >= 28) {
                Object v5 = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(v1, arg5);
                Intrinsics.checkNotNull(v5, "null cannot be cast to non-null type android.os.Handler");
                return ((Handler)v5);
            }

            try {
                v6 = Handler.class.getDeclaredConstructor(Looper.class, Handler$Callback.class, Boolean.TYPE);
            }
            catch(NoSuchMethodException ) {
                return new Handler(arg5);
            }

            return v6.newInstance(arg5, v1, Boolean.valueOf(true));
        }

        return new Handler(arg5);
    }

    public static final Object awaitFrame(Continuation arg4) {
        Choreographer v0 = HandlerDispatcherKt.choreographer;
        if(v0 != null) {
            CancellableContinuationImpl v1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg4), 1);
            v1.initCancellability();
            HandlerDispatcherKt.postFrameCallback(v0, v1);
            Object v0_1 = v1.getResult();
            if(v0_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(arg4);
            }

            return v0_1;
        }

        return HandlerDispatcherKt.awaitFrameSlowPath(arg4);
    }

    private static final Object awaitFrameSlowPath(Continuation arg5) {
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg5), 1);
        v0.initCancellability();
        CancellableContinuationImpl v1 = v0;
        if(Looper.myLooper() == Looper.getMainLooper()) {
            HandlerDispatcherKt.updateChoreographerAndPostFrameCallback(((CancellableContinuation)v1));
        }
        else {
            Dispatchers.getMain().dispatch(((CancellableContinuation)v1).getContext(), new HandlerDispatcherKt$awaitFrameSlowPath$2$1(((CancellableContinuation)v1)));
        }

        Object v0_1 = v0.getResult();
        if(v0_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg5);
        }

        return v0_1;
    }

    public static final HandlerDispatcher from(Handler arg1, String arg2) {
        return new HandlerContext(arg1, arg2);
    }

    public static final HandlerDispatcher from(Handler arg2) {
        return HandlerDispatcherKt.from$default(arg2, null, 1, null);
    }

    public static HandlerDispatcher from$default(Handler arg0, String arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        return HandlerDispatcherKt.from(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use Dispatchers.Main instead") public static void getMain$annotations() {
    }

    private static final void postFrameCallback(Choreographer arg1, CancellableContinuation arg2) {
        arg1.postFrameCallback(new HandlerDispatcherKt$$ExternalSyntheticLambda0(arg2));
    }

    static final void postFrameCallback$lambda$5(CancellableContinuation arg1, long arg2) {
        arg1.resumeUndispatched(Dispatchers.getMain(), Long.valueOf(arg2));
    }

    private static final void updateChoreographerAndPostFrameCallback(CancellableContinuation arg1) {
        Choreographer v0 = HandlerDispatcherKt.choreographer;
        if(v0 == null) {
            v0 = Choreographer.getInstance();
            Intrinsics.checkNotNull(v0);
            HandlerDispatcherKt.choreographer = v0;
        }

        HandlerDispatcherKt.postFrameCallback(v0, arg1);
    }
}

