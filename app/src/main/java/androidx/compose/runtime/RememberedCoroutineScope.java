package androidx.compose.runtime;

import androidx.compose.runtime.tooling.ComposeToolingFlags;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001A\u00020\u0011J\b\u0010\u0012\u001A\u00020\u0011H\u0016J\b\u0010\u0013\u001A\u00020\u0011H\u0016J\b\u0010\u0014\u001A\u00020\u0011H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u00060\tj\u0002`\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000BR\u0010\u0010\f\u001A\u0004\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0016"}, d2={"Landroidx/compose/runtime/RememberedCoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/RememberObserver;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "overlayContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;)V", "lock", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "_coroutineContext", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "cancelIfCreated", "", "onRemembered", "onForgotten", "onAbandoned", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class RememberedCoroutineScope implements RememberObserver, CoroutineScope {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/compose/runtime/RememberedCoroutineScope$Companion;", "", "<init>", "()V", "CancelledCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable;
    public static final CoroutineContext CancelledCoroutineContext;
    public static final Companion Companion;
    private volatile CoroutineContext _coroutineContext;
    private final Object lock;
    private final CoroutineContext overlayContext;
    private final CoroutineContext parentContext;

    static {
        RememberedCoroutineScope.Companion = new Companion(null);
        RememberedCoroutineScope.$stable = 8;
        RememberedCoroutineScope.CancelledCoroutineContext = new CancelledCoroutineContext();
    }

    public RememberedCoroutineScope(CoroutineContext arg1, CoroutineContext arg2) {
        super();
        this.parentContext = arg1;
        this.overlayContext = arg2;
        this.lock = this;
    }

    public static final CoroutineContext access$getOverlayContext$p(RememberedCoroutineScope arg0) {
        return arg0.overlayContext;
    }

    public static final CoroutineContext access$getParentContext$p(RememberedCoroutineScope arg0) {
        return arg0.parentContext;
    }

    public final void cancelIfCreated() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            CoroutineContext v1 = this._coroutineContext;
            if(v1 == null) {
                this._coroutineContext = RememberedCoroutineScope.CancelledCoroutineContext;
            }
            else {
                JobKt.cancel(v1, new ForgottenCoroutineScopeException());
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    public CoroutineContext getCoroutineContext() {
        CoroutineContext v1;
        EmptyCoroutineContext v2_1;
        CoroutineContext v0 = this._coroutineContext;
        if(v0 == null || v0 == RememberedCoroutineScope.CancelledCoroutineContext) {
            Element v0_1 = this.parentContext.get(CompositionErrorContextImpl.Key);
            if(v0_1 != null) {
                RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1 v2 = new RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, ((CompositionErrorContextImpl)v0_1), this);
            }
            else {
                v2_1 = EmptyCoroutineContext.INSTANCE;
            }

            Object v0_2 = this.lock;
            __monitor_enter(v0_2);
            try {
                v1 = this._coroutineContext;
                if(v1 == null) {
                    v1 = this.parentContext.plus(JobKt.Job(this.parentContext.get(Job.Key))).plus(this.overlayContext).plus(((CoroutineContext)v2_1));
                }
                else if(v1 == RememberedCoroutineScope.CancelledCoroutineContext) {
                    v1 = this.parentContext;
                    CompletableJob v3 = JobKt.Job(v1.get(Job.Key));
                    v3.cancel(new ForgottenCoroutineScopeException());
                    v1 = v1.plus(((CoroutineContext)v3)).plus(this.overlayContext).plus(((CoroutineContext)v2_1));
                    if(ComposeToolingFlags.isVerboseTracingEnabled) {
                        v1 = v1.plus(RememberedCoroutineScopeTracingContext.INSTANCE);
                    }
                }

                this._coroutineContext = v1;
            }
            catch(Throwable v5) {
                __monitor_exit(v0_2);
                throw v5;
            }

            __monitor_exit(v0_2);
            v0 = v1;
        }

        Intrinsics.checkNotNull(v0);
        return v0;
    }

    public void onAbandoned() {
        this.cancelIfCreated();
    }

    public void onForgotten() {
        this.cancelIfCreated();
    }

    public void onRemembered() {
    }
}

