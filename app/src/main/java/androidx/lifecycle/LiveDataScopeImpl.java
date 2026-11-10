package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001D\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001C\u0010\u0011\u001A\u00020\u00122\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00028\u0000H\u0097@¢\u0006\u0002\u0010\u0019R \u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u0016\u0010\r\u001A\u0004\u0018\u00018\u00008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0010\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/lifecycle/LiveDataScopeImpl;", "T", "Landroidx/lifecycle/LiveDataScope;", "target", "Landroidx/lifecycle/CoroutineLiveData;", "context", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Landroidx/lifecycle/CoroutineLiveData;Lkotlin/coroutines/CoroutineContext;)V", "getTarget$lifecycle_livedata", "()Landroidx/lifecycle/CoroutineLiveData;", "setTarget$lifecycle_livedata", "(Landroidx/lifecycle/CoroutineLiveData;)V", "latestValue", "getLatestValue", "()Ljava/lang/Object;", "coroutineContext", "emitSource", "Lkotlinx/coroutines/DisposableHandle;", "source", "Landroidx/lifecycle/LiveData;", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-livedata"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LiveDataScopeImpl implements LiveDataScope {
    private final CoroutineContext coroutineContext;
    private CoroutineLiveData target;

    public LiveDataScopeImpl(CoroutineLiveData arg2, CoroutineContext arg3) {
        Intrinsics.checkNotNullParameter(arg2, "target");
        Intrinsics.checkNotNullParameter(arg3, "context");
        super();
        this.target = arg2;
        this.coroutineContext = arg3.plus(Dispatchers.getMain().getImmediate());
    }

    public Object emit(Object arg4, Continuation arg5) {
        Object v3 = BuildersKt.withContext(this.coroutineContext, new LiveDataScopeImpl$emit$2(this, arg4, null), arg5);
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v3;
        }

        return Unit.INSTANCE;
    }

    public Object emitSource(LiveData arg4, Continuation arg5) {
        return BuildersKt.withContext(this.coroutineContext, new LiveDataScopeImpl$emitSource$2(this, arg4, null), arg5);
    }

    public Object getLatestValue() {
        return this.target.getValue();
    }

    public final CoroutineLiveData getTarget$lifecycle_livedata() {
        return this.target;
    }

    public final void setTarget$lifecycle_livedata(CoroutineLiveData arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.target = arg2;
    }
}

