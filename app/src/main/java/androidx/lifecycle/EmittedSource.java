package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001F\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\n\u001A\u00020\u000BH\u0086@¢\u0006\u0002\u0010\fJ\b\u0010\r\u001A\u00020\u000BH\u0016J\b\u0010\u000E\u001A\u00020\u000BH\u0003R\u0012\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/lifecycle/EmittedSource;", "Lkotlinx/coroutines/DisposableHandle;", "source", "Landroidx/lifecycle/LiveData;", "mediator", "Landroidx/lifecycle/MediatorLiveData;", "<init>", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/MediatorLiveData;)V", "disposed", "", "disposeNow", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "removeSource", "lifecycle-livedata"}, k=1, mv={2, 1, 0}, xi=0x30) public final class EmittedSource implements DisposableHandle {
    private boolean disposed;
    private final MediatorLiveData mediator;
    private final LiveData source;

    public EmittedSource(LiveData arg2, MediatorLiveData arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "mediator");
        super();
        this.source = arg2;
        this.mediator = arg3;
    }

    public static final void access$removeSource(EmittedSource arg0) {
        arg0.removeSource();
    }

    public void dispose() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new EmittedSource$dispose$1(this, null), 3, null);
    }

    public final Object disposeNow(Continuation arg4) {
        Object v3 = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new EmittedSource$disposeNow$2(this, null), arg4);
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v3;
        }

        return Unit.INSTANCE;
    }

    private final void removeSource() {
        if(!this.disposed) {
            this.mediator.removeSource(this.source);
            this.disposed = true;
        }
    }
}

