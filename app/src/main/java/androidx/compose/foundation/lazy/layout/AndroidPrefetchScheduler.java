package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import android.view.Choreographer$FrameCallback;
import android.view.Choreographer;
import android.view.Display;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 %2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002$%B\u000F\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0017\u001A\u00020\u0018H\u0016J\b\u0010\u0019\u001A\u00020\u000EH\u0002J\u0010\u0010\u001A\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u0016H\u0016J\b\u0010\u001C\u001A\u00020\u0018H\u0002J\u0010\u0010\u001D\u001A\u00020\u00182\u0006\u0010\u001E\u001A\u00020\u001FH\u0016J\u0010\u0010 \u001A\u00020\u00182\u0006\u0010\u001E\u001A\u00020\u001FH\u0016J\u0010\u0010!\u001A\u00020\u00182\u0006\u0010\"\u001A\u00020\u0007H\u0016J\u0010\u0010#\u001A\u00020\u00182\u0006\u0010\"\u001A\u00020\u0007H\u0016R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u000F\u001A\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006&"}, d2={"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler;", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "Landroidx/compose/foundation/lazy/layout/PriorityPrefetchScheduler;", "Landroid/view/View$OnAttachStateChangeListener;", "Ljava/lang/Runnable;", "Landroid/view/Choreographer$FrameCallback;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "prefetchRequests", "Ljava/util/PriorityQueue;", "Landroidx/compose/foundation/lazy/layout/PriorityTask;", "prefetchScheduled", "", "choreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "scope", "Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler$PrefetchRequestScopeImpl;", "isActive", "frameStartTimeNanos", "", "run", "", "runRequest", "doFrame", "frameTimeNanos", "startExecution", "scheduleLowPriorityPrefetch", "prefetchRequest", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "scheduleHighPriorityPrefetch", "onViewAttachedToWindow", "v", "onViewDetachedFromWindow", "PrefetchRequestScopeImpl", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidPrefetchScheduler implements Choreographer$FrameCallback, View$OnAttachStateChangeListener, PrefetchScheduler, PriorityPrefetchScheduler, Runnable {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler$Companion;", "", "<init>", "()V", "frameIntervalNs", "", "calculateFrameIntervalIfNeeded", "", "view", "Landroid/view/View;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final void access$calculateFrameIntervalIfNeeded(Companion arg0, View arg1) {
            arg0.calculateFrameIntervalIfNeeded(arg1);
        }

        private final void calculateFrameIntervalIfNeeded(View arg5) {
            float v4_1;
            if(AndroidPrefetchScheduler.frameIntervalNs == 0) {
                Display v4 = arg5.getDisplay();
                if((arg5.isInEditMode()) || v4 == null) {
                label_11:
                    v4_1 = 60f;
                }
                else {
                    v4_1 = v4.getRefreshRate();
                    if(v4_1 >= 30f) {
                    }
                    else {
                        goto label_11;
                    }
                }

                AndroidPrefetchScheduler.frameIntervalNs = ((long)(1000000000f / v4_1));
            }
        }
    }

    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000F\u001A\u00020\nH\u0016R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler$PrefetchRequestScopeImpl;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "<init>", "()V", "isFrameIdle", "", "()Z", "setFrameIdle", "(Z)V", "nextFrameTimeNs", "", "getNextFrameTimeNs", "()J", "setNextFrameTimeNs", "(J)V", "availableTimeNanos", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PrefetchRequestScopeImpl implements PrefetchRequestScope {
        public static final int $stable = 8;
        private boolean isFrameIdle;
        private long nextFrameTimeNs;

        static {
        }

        public PrefetchRequestScopeImpl() {
            super();
        }

        public long availableTimeNanos() {
            if(this.isFrameIdle) {
                return 0x7FFFFFFFFFFFFFFFL;
            }

            return Math.max(0, this.nextFrameTimeNs - System.nanoTime());
        }

        public final long getNextFrameTimeNs() {
            return this.nextFrameTimeNs;
        }

        public final boolean isFrameIdle() {
            return this.isFrameIdle;
        }

        public final void setFrameIdle(boolean arg1) {
            this.isFrameIdle = arg1;
        }

        public final void setNextFrameTimeNs(long arg1) {
            this.nextFrameTimeNs = arg1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final Choreographer choreographer;
    private static long frameIntervalNs;
    private long frameStartTimeNanos;
    private boolean isActive;
    private final PriorityQueue prefetchRequests;
    private boolean prefetchScheduled;
    private final PrefetchRequestScopeImpl scope;
    private final View view;

    static {
        AndroidPrefetchScheduler.Companion = new Companion(null);
        AndroidPrefetchScheduler.$stable = 8;
    }

    public AndroidPrefetchScheduler(View arg4) {
        super();
        this.view = arg4;
        this.prefetchRequests = new PriorityQueue(11, new AndroidPrefetchScheduler$$ExternalSyntheticLambda0());
        this.choreographer = Choreographer.getInstance();
        this.scope = new PrefetchRequestScopeImpl();
        Companion.access$calculateFrameIntervalIfNeeded(AndroidPrefetchScheduler.Companion, arg4);
        arg4.addOnAttachStateChangeListener(this);
        if(arg4.isAttachedToWindow()) {
            this.onViewAttachedToWindow(arg4);
        }
    }

    public static final long access$getFrameIntervalNs$cp() {
        return AndroidPrefetchScheduler.frameIntervalNs;
    }

    public static final void access$setFrameIntervalNs$cp(long arg0) {
        AndroidPrefetchScheduler.frameIntervalNs = arg0;
    }

    public void doFrame(long arg2) {
        if(this.isActive) {
            this.frameStartTimeNanos = arg2;
            this.view.post(((Runnable)this));
        }
    }

    public void onViewAttachedToWindow(View arg1) {
        this.isActive = true;
    }

    public void onViewDetachedFromWindow(View arg2) {
        this.isActive = false;
        this.view.removeCallbacks(this);
        this.choreographer.removeFrameCallback(((Choreographer$FrameCallback)this));
    }

    static final int prefetchRequests$lambda$0(PriorityTask arg0, PriorityTask arg1) {
        return Intrinsics.compare(arg1.getPriority(), arg0.getPriority());
    }

    public void run() {
        if(!this.prefetchRequests.isEmpty() && (this.prefetchScheduled) && (this.isActive)) {
            if(this.view.getWindowVisibility() != 0) {
            }
            else {
                long v2 = TimeUnit.MILLISECONDS.toNanos(this.view.getDrawingTime());
                PrefetchRequestScopeImpl v0 = this.scope;
                boolean v4 = System.nanoTime() > 2 * AndroidPrefetchScheduler.frameIntervalNs + v2 ? true : false;
                v0.setFrameIdle(v4);
                this.scope.setNextFrameTimeNs(Math.max(this.frameStartTimeNanos, v2) + AndroidPrefetchScheduler.frameIntervalNs);
                boolean v0_1 = false;
                while(!this.prefetchRequests.isEmpty()) {
                    if(v0_1) {
                        break;
                    }

                    if(this.scope.isFrameIdle()) {
                        Trace.beginSection("compose:lazy:prefetch:idle_frame");
                        try {
                            v0_1 = this.runRequest();
                        }
                        catch(Throwable v10) {
                            Trace.endSection();
                            throw v10;
                        }

                        Trace.endSection();
                    }
                    else {
                        v0_1 = this.runRequest();
                    }
                }

                if(v0_1) {
                    this.choreographer.postFrameCallback(((Choreographer$FrameCallback)this));
                }
                else {
                    this.prefetchScheduled = false;
                }

                AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", 0);
                return;
            }
        }

        this.prefetchScheduled = false;
    }

    private final boolean runRequest() {
        long v0 = this.scope.availableTimeNanos();
        AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", v0);
        int v0_1 = Long.compare(v0, 0);
        boolean v1 = true;
        if(v0_1 > 0) {
            Object v0_2 = this.prefetchRequests.peek();
            Intrinsics.checkNotNull(v0_2);
            if(((PriorityTask)v0_2).getRequest().execute(this.scope)) {
            }
            else {
                this.prefetchRequests.poll();
                v1 = false;
            }

            this.scope.setFrameIdle(false);
        }

        return v1;
    }

    public void scheduleHighPriorityPrefetch(PrefetchRequest arg4) {
        this.prefetchRequests.add(new PriorityTask(PriorityTask.Companion.getHigh(), arg4));
        this.startExecution();
    }

    public void scheduleLowPriorityPrefetch(PrefetchRequest arg4) {
        this.prefetchRequests.add(new PriorityTask(PriorityTask.Companion.getLow(), arg4));
        this.startExecution();
    }

    private final void startExecution() {
        if(!this.prefetchScheduled) {
            this.prefetchScheduled = true;
            this.view.post(((Runnable)this));
        }
    }
}

