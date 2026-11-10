package androidx.compose.ui.platform;

import android.os.Handler;
import android.view.Choreographer$FrameCallback;
import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1={"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0017\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0019\u001A\u0004\u0018\u00010\u000EH\u0002J\b\u0010\u001A\u001A\u00020\u001BH\u0002J\u0010\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u001EH\u0002J\u0015\u0010\u001F\u001A\u00020\u001B2\u0006\u0010 \u001A\u00020\u0011H\u0000¢\u0006\u0002\b!J\u0015\u0010\"\u001A\u00020\u001B2\u0006\u0010 \u001A\u00020\u0011H\u0000¢\u0006\u0002\b#J\u0018\u0010(\u001A\u00020\u001B2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020\u000EH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0011\u0010$\u001A\u00020%¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'¨\u0006-"}, d2={"Landroidx/compose/ui/platform/AndroidUiDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "choreographer", "Landroid/view/Choreographer;", "handler", "Landroid/os/Handler;", "<init>", "(Landroid/view/Choreographer;Landroid/os/Handler;)V", "getChoreographer", "()Landroid/view/Choreographer;", "lock", "", "toRunTrampolined", "Lkotlin/collections/ArrayDeque;", "Ljava/lang/Runnable;", "toRunOnFrame", "", "Landroid/view/Choreographer$FrameCallback;", "spareToRunOnFrame", "scheduledTrampolineDispatch", "", "scheduledFrameDispatch", "dispatchCallback", "androidx/compose/ui/platform/AndroidUiDispatcher$dispatchCallback$1", "Landroidx/compose/ui/platform/AndroidUiDispatcher$dispatchCallback$1;", "nextTask", "performTrampolineDispatch", "", "performFrameDispatch", "frameTimeNanos", "", "postFrameCallback", "callback", "postFrameCallback$ui", "removeFrameCallback", "removeFrameCallback$ui", "frameClock", "Landroidx/compose/runtime/MonotonicFrameClock;", "getFrameClock", "()Landroidx/compose/runtime/MonotonicFrameClock;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidUiDispatcher extends CoroutineDispatcher {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001B\u0010\u0004\u001A\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00050\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\r\u0010\u0007¨\u0006\u000E"}, d2={"Landroidx/compose/ui/platform/AndroidUiDispatcher$Companion;", "", "<init>", "()V", "Main", "Lkotlin/coroutines/CoroutineContext;", "getMain", "()Lkotlin/coroutines/CoroutineContext;", "Main$delegate", "Lkotlin/Lazy;", "currentThread", "Ljava/lang/ThreadLocal;", "CurrentThread", "getCurrentThread", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final CoroutineContext getCurrentThread() {
            if(AndroidUiDispatcher_androidKt.access$isMainThread()) {
                return this.getMain();
            }

            Object v1 = AndroidUiDispatcher.currentThread.get();
            if(v1 != null) {
                return ((CoroutineContext)v1);
            }

            throw new IllegalStateException("no AndroidUiDispatcher for this thread".toString());
        }

        public final CoroutineContext getMain() {
            return AndroidUiDispatcher.Main$delegate.getValue();
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Lazy Main$delegate;
    private final Choreographer choreographer;
    private static final ThreadLocal currentThread;
    private final AndroidUiDispatcher$dispatchCallback$1 dispatchCallback;
    private final MonotonicFrameClock frameClock;
    private final Handler handler;
    private final Object lock;
    private boolean scheduledFrameDispatch;
    private boolean scheduledTrampolineDispatch;
    private List spareToRunOnFrame;
    private List toRunOnFrame;
    private final ArrayDeque toRunTrampolined;

    static {
        AndroidUiDispatcher.Companion = new Companion(null);
        AndroidUiDispatcher.$stable = 8;
        AndroidUiDispatcher.Main$delegate = LazyKt.lazy(AndroidUiDispatcher$Companion$Main$2.INSTANCE);
        AndroidUiDispatcher.currentThread = new AndroidUiDispatcher$Companion$currentThread$1();
    }

    private AndroidUiDispatcher(Choreographer arg1, Handler arg2) {
        super();
        this.choreographer = arg1;
        this.handler = arg2;
        this.lock = new Object();
        this.toRunTrampolined = new ArrayDeque();
        this.toRunOnFrame = new ArrayList();
        this.spareToRunOnFrame = new ArrayList();
        this.dispatchCallback = new AndroidUiDispatcher$dispatchCallback$1(this);
        this.frameClock = new AndroidUiFrameClock(arg1, this);
    }

    public AndroidUiDispatcher(Choreographer arg1, Handler arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public static final ThreadLocal access$getCurrentThread$cp() {
        return AndroidUiDispatcher.currentThread;
    }

    public static final Handler access$getHandler$p(AndroidUiDispatcher arg0) {
        return arg0.handler;
    }

    public static final Object access$getLock$p(AndroidUiDispatcher arg0) {
        return arg0.lock;
    }

    public static final Lazy access$getMain$delegate$cp() {
        return AndroidUiDispatcher.Main$delegate;
    }

    public static final List access$getToRunOnFrame$p(AndroidUiDispatcher arg0) {
        return arg0.toRunOnFrame;
    }

    public static final void access$performFrameDispatch(AndroidUiDispatcher arg0, long arg1) {
        arg0.performFrameDispatch(arg1);
    }

    public static final void access$performTrampolineDispatch(AndroidUiDispatcher arg0) {
        arg0.performTrampolineDispatch();
    }

    public static final void access$setScheduledFrameDispatch$p(AndroidUiDispatcher arg0, boolean arg1) {
        arg0.scheduledFrameDispatch = arg1;
    }

    public void dispatch(CoroutineContext arg3, Runnable arg4) {
        Object v3 = this.lock;
        __monitor_enter(v3);
        try {
            this.toRunTrampolined.addLast(arg4);
            if(!this.scheduledTrampolineDispatch) {
                this.scheduledTrampolineDispatch = true;
                this.handler.post(this.dispatchCallback);
                if(!this.scheduledFrameDispatch) {
                    this.scheduledFrameDispatch = true;
                    this.choreographer.postFrameCallback(this.dispatchCallback);
                }
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v3);
            throw v2;
        }

        __monitor_exit(v3);
    }

    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    public final MonotonicFrameClock getFrameClock() {
        return this.frameClock;
    }

    private final Runnable nextTask() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            __monitor_exit(v0);
            return this.toRunTrampolined.removeFirstOrNull();
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }
    }

    private final void performFrameDispatch(long arg5) {
        List v2;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(this.scheduledFrameDispatch) {
                goto label_6;
            }
        }
        catch(Throwable v4) {
            goto label_22;
        }

        __monitor_exit(v0);
        return;
    label_6:
        int v1 = 0;
        try {
            this.scheduledFrameDispatch = false;
            v2 = this.toRunOnFrame;
            this.toRunOnFrame = this.spareToRunOnFrame;
            this.spareToRunOnFrame = v2;
        }
        catch(Throwable v4) {
        label_22:
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
        int v4_1 = v2.size();
        while(v1 < v4_1) {
            v2.get(v1).doFrame(arg5);
            ++v1;
        }

        v2.clear();
    }

    private final void performTrampolineDispatch() {
        int v1;
        do {
            Runnable v0;
            for(v0 = this.nextTask(); v0 != null; v0 = this.nextTask()) {
                v0.run();
            }

            Object v0_1 = this.lock;
            __monitor_enter(v0_1);
            try {
                if(this.toRunTrampolined.isEmpty()) {
                    v1 = 0;
                    this.scheduledTrampolineDispatch = false;
                }
                else {
                    goto label_13;
                }

                goto label_14;
            }
            catch(Throwable v2) {
                __monitor_exit(v0_1);
                throw v2;
            }

        label_13:
            v1 = 1;
        label_14:
            __monitor_exit(v0_1);
        }
        while(v1 != 0);
    }

    public final void postFrameCallback$ui(Choreographer$FrameCallback arg3) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.toRunOnFrame.add(arg3);
            if(!this.scheduledFrameDispatch) {
                this.scheduledFrameDispatch = true;
                this.choreographer.postFrameCallback(this.dispatchCallback);
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    public final void removeFrameCallback$ui(Choreographer$FrameCallback arg2) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.toRunOnFrame.remove(arg2);
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
    }
}

