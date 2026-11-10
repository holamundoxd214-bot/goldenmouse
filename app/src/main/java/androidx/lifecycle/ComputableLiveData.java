package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001A\u001A\u00020\u001BH\u0016J\r\u0010\u001C\u001A\u00028\u0000H%¢\u0006\u0002\u0010\u001DR\u0014\u0010\u0003\u001A\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u000B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\nX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000FX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u000FX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0014\u001A\u00020\u00158\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001A\u00020\u00158\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0017¨\u0006\u001E"}, d2={"Landroidx/lifecycle/ComputableLiveData;", "T", "", "executor", "Ljava/util/concurrent/Executor;", "<init>", "(Ljava/util/concurrent/Executor;)V", "getExecutor$lifecycle_livedata", "()Ljava/util/concurrent/Executor;", "_liveData", "Landroidx/lifecycle/LiveData;", "liveData", "getLiveData", "()Landroidx/lifecycle/LiveData;", "invalid", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInvalid$lifecycle_livedata", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "computing", "getComputing$lifecycle_livedata", "refreshRunnable", "Ljava/lang/Runnable;", "getRefreshRunnable$lifecycle_livedata$annotations", "()V", "invalidationRunnable", "getInvalidationRunnable$lifecycle_livedata$annotations", "invalidate", "", "compute", "()Ljava/lang/Object;", "lifecycle-livedata"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class ComputableLiveData {
    private final LiveData _liveData;
    private final AtomicBoolean computing;
    private final Executor executor;
    private final AtomicBoolean invalid;
    public final Runnable invalidationRunnable;
    private final LiveData liveData;
    public final Runnable refreshRunnable;

    public ComputableLiveData() {
        this(null, 1, null);
    }

    public ComputableLiveData(Executor arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = ArchTaskExecutor.getIOThreadExecutor();
            Intrinsics.checkNotNullExpressionValue(arg1, "getIOThreadExecutor(...)");
        }

        this(arg1);
    }

    public ComputableLiveData(Executor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "executor");
        super();
        this.executor = arg2;
        ComputableLiveData$_liveData$1 v2 = new ComputableLiveData$_liveData$1(this);
        this._liveData = ((LiveData)v2);
        this.liveData = ((LiveData)v2);
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.refreshRunnable = new ComputableLiveData$$ExternalSyntheticLambda0(this);
        this.invalidationRunnable = new ComputableLiveData$$ExternalSyntheticLambda1(this);
    }

    protected abstract Object compute();

    public final AtomicBoolean getComputing$lifecycle_livedata() {
        return this.computing;
    }

    public final Executor getExecutor$lifecycle_livedata() {
        return this.executor;
    }

    public final AtomicBoolean getInvalid$lifecycle_livedata() {
        return this.invalid;
    }

    public static void getInvalidationRunnable$lifecycle_livedata$annotations() {
    }

    public LiveData getLiveData() {
        return this.liveData;
    }

    public static void getRefreshRunnable$lifecycle_livedata$annotations() {
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.invalidationRunnable);
    }

    static final void invalidationRunnable$lambda$0(ComputableLiveData arg4) {
        boolean v0 = arg4.getLiveData().hasActiveObservers();
        if((arg4.invalid.compareAndSet(false, true)) && (v0)) {
            arg4.executor.execute(arg4.refreshRunnable);
        }
    }

    static final void refreshRunnable$lambda$0(ComputableLiveData arg5) {
        do {
            int v1 = 0;
            if(arg5.computing.compareAndSet(false, true)) {
                Object v0 = null;
                int v3 = 0;
                try {
                    while(arg5.invalid.compareAndSet(true, false)) {
                        v0 = arg5.compute();
                        v3 = 1;
                    }

                    if(v3 != 0) {
                        arg5.getLiveData().postValue(v0);
                    }
                }
                catch(Throwable v0_1) {
                    arg5.computing.set(false);
                    throw v0_1;
                }

                arg5.computing.set(false);
                v1 = v3;
            }

            if(v1 == 0) {
                return;
            }
        }
        while(arg5.invalid.get());
    }
}

