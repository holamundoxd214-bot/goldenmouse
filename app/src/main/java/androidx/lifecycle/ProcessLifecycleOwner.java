package androidx.lifecycle;

import android.app.Activity;
import android.app.Application$ActivityLifecycleCallbacks;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \'2\u00020\u0001:\u0002\'(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0012\u001A\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J\r\u0010\u0015\u001A\u00020\u0013H\u0000¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001A\u00020\u0013H\u0000¢\u0006\u0002\b\u0018J\r\u0010\u0019\u001A\u00020\u0013H\u0000¢\u0006\u0002\b\u001AJ\r\u0010\u001B\u001A\u00020\u0013H\u0000¢\u0006\u0002\b\u001CJ\r\u0010\u001D\u001A\u00020\u0013H\u0000¢\u0006\u0002\b\u001EJ\u0015\u0010\u001F\u001A\u00020\u00132\u0006\u0010 \u001A\u00020!H\u0000¢\u0006\u0002\b\"R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001A\u00020$8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b%\u0010&¨\u0006)"}, d2={"Landroidx/lifecycle/ProcessLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "startedCounter", "", "resumedCounter", "pauseSent", "", "stopSent", "handler", "Landroid/os/Handler;", "registry", "Landroidx/lifecycle/LifecycleRegistry;", "delayedPauseRunnable", "Ljava/lang/Runnable;", "initializationListener", "Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "activityStarted", "", "activityStarted$lifecycle_process", "activityResumed", "activityResumed$lifecycle_process", "activityPaused", "activityPaused$lifecycle_process", "activityStopped", "activityStopped$lifecycle_process", "dispatchPauseIfNeeded", "dispatchPauseIfNeeded$lifecycle_process", "dispatchStopIfNeeded", "dispatchStopIfNeeded$lifecycle_process", "attach", "context", "Landroid/content/Context;", "attach$lifecycle_process", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Companion", "Api29Impl", "lifecycle-process"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ProcessLifecycleOwner implements LifecycleOwner {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007¨\u0006\n"}, d2={"Landroidx/lifecycle/ProcessLifecycleOwner$Api29Impl;", "", "<init>", "()V", "registerActivityLifecycleCallbacks", "", "activity", "Landroid/app/Activity;", "callback", "Landroid/app/Application$ActivityLifecycleCallbacks;", "lifecycle-process"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Api29Impl {
        public static final Api29Impl INSTANCE;

        static {
            Api29Impl.INSTANCE = new Api29Impl();
        }

        private Api29Impl() {
            super();
        }

        @JvmStatic public static final void registerActivityLifecycleCallbacks(Activity arg1, Application$ActivityLifecycleCallbacks arg2) {
            Intrinsics.checkNotNullParameter(arg1, "activity");
            Intrinsics.checkNotNullParameter(arg2, "callback");
            arg1.registerActivityLifecycleCallbacks(arg2);
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001A\u00020\nH\u0007J\u0015\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0001¢\u0006\u0002\b\u000FR\u0016\u0010\u0004\u001A\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/lifecycle/ProcessLifecycleOwner$Companion;", "", "<init>", "()V", "TIMEOUT_MS", "", "getTIMEOUT_MS$lifecycle_process$annotations", "newInstance", "Landroidx/lifecycle/ProcessLifecycleOwner;", "get", "Landroidx/lifecycle/LifecycleOwner;", "init", "", "context", "Landroid/content/Context;", "init$lifecycle_process", "lifecycle-process"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final LifecycleOwner get() {
            return ProcessLifecycleOwner.newInstance;
        }

        public static void getTIMEOUT_MS$lifecycle_process$annotations() {
        }

        @JvmStatic public final void init$lifecycle_process(Context arg1) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            ProcessLifecycleOwner.newInstance.attach$lifecycle_process(arg1);
        }
    }

    public static final Companion Companion = null;
    public static final long TIMEOUT_MS = 700;
    private final Runnable delayedPauseRunnable;
    private Handler handler;
    private final ActivityInitializationListener initializationListener;
    private static final ProcessLifecycleOwner newInstance;
    private boolean pauseSent;
    private final LifecycleRegistry registry;
    private int resumedCounter;
    private int startedCounter;
    private boolean stopSent;

    static {
        ProcessLifecycleOwner.Companion = new Companion(null);
        ProcessLifecycleOwner.newInstance = new ProcessLifecycleOwner();
    }

    private ProcessLifecycleOwner() {
        super();
        this.pauseSent = true;
        this.stopSent = true;
        this.registry = new LifecycleRegistry(this);
        this.delayedPauseRunnable = new ProcessLifecycleOwner$$ExternalSyntheticLambda0(this);
        this.initializationListener = new ProcessLifecycleOwner$initializationListener$1(this);
    }

    public static final ActivityInitializationListener access$getInitializationListener$p(ProcessLifecycleOwner arg0) {
        return arg0.initializationListener;
    }

    public static final ProcessLifecycleOwner access$getNewInstance$cp() {
        return ProcessLifecycleOwner.newInstance;
    }

    public final void activityPaused$lifecycle_process() {
        int v0 = this.resumedCounter - 1;
        this.resumedCounter = v0;
        if(v0 == 0) {
            Handler v0_1 = this.handler;
            Intrinsics.checkNotNull(v0_1);
            v0_1.postDelayed(this.delayedPauseRunnable, 700);
        }
    }

    public final void activityResumed$lifecycle_process() {
        int v0 = this.resumedCounter + 1;
        this.resumedCounter = v0;
        if(v0 == 1) {
            if(this.pauseSent) {
                this.registry.handleLifecycleEvent(Event.ON_RESUME);
                this.pauseSent = false;
                return;
            }
            else {
                Handler v0_1 = this.handler;
                Intrinsics.checkNotNull(v0_1);
                v0_1.removeCallbacks(this.delayedPauseRunnable);
            }
        }
    }

    public final void activityStarted$lifecycle_process() {
        int v0 = this.startedCounter + 1;
        this.startedCounter = v0;
        if(v0 == 1 && (this.stopSent)) {
            this.registry.handleLifecycleEvent(Event.ON_START);
            this.stopSent = false;
        }
    }

    public final void activityStopped$lifecycle_process() {
        --this.startedCounter;
        this.dispatchStopIfNeeded$lifecycle_process();
    }

    public final void attach$lifecycle_process(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this.handler = new Handler();
        this.registry.handleLifecycleEvent(Event.ON_CREATE);
        arg3 = arg3.getApplicationContext();
        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type android.app.Application");
        ((Application)arg3).registerActivityLifecycleCallbacks(new ProcessLifecycleOwner$attach$1(this));
    }

    static final void delayedPauseRunnable$lambda$0(ProcessLifecycleOwner arg0) {
        arg0.dispatchPauseIfNeeded$lifecycle_process();
        arg0.dispatchStopIfNeeded$lifecycle_process();
    }

    public final void dispatchPauseIfNeeded$lifecycle_process() {
        if(this.resumedCounter == 0) {
            this.pauseSent = true;
            this.registry.handleLifecycleEvent(Event.ON_PAUSE);
        }
    }

    public final void dispatchStopIfNeeded$lifecycle_process() {
        if(this.startedCounter == 0 && (this.pauseSent)) {
            this.registry.handleLifecycleEvent(Event.ON_STOP);
            this.stopSent = true;
        }
    }

    @JvmStatic public static final LifecycleOwner get() {
        return ProcessLifecycleOwner.Companion.get();
    }

    public Lifecycle getLifecycle() {
        return this.registry;
    }

    @JvmStatic public static final void init$lifecycle_process(Context arg1) {
        ProcessLifecycleOwner.Companion.init$lifecycle_process(arg1);
    }
}

