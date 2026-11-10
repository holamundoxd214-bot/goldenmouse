package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00028\u0000H¦@¢\u0006\u0002\u0010\u0006J\u001C\u0010\u0007\u001A\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\nH¦@¢\u0006\u0002\u0010\u000BR\u0014\u0010\f\u001A\u0004\u0018\u00018\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000Eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000FÀ\u0006\u0001"}, d2={"Landroidx/lifecycle/LiveDataScope;", "T", "", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSource", "Lkotlinx/coroutines/DisposableHandle;", "source", "Landroidx/lifecycle/LiveData;", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "latestValue", "getLatestValue", "()Ljava/lang/Object;", "lifecycle-livedata"}, k=1, mv={2, 1, 0}, xi=0x30) public interface LiveDataScope {
    Object emit(Object arg1, Continuation arg2);

    Object emitSource(LiveData arg1, Continuation arg2);

    Object getLatestValue();
}

