package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A2\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007\u001A\u001C\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001A0\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0007¨\u0006\u000B"}, d2={"asLiveData", "Landroidx/lifecycle/LiveData;", "T", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "timeoutInMs", "", "asFlow", "timeout", "Ljava/time/Duration;", "lifecycle-livedata"}, k=2, mv={2, 1, 0}, xi=0x30) public final class FlowLiveDataConversions {
    public static final Flow asFlow(LiveData arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return FlowKt.conflate(FlowKt.callbackFlow(new FlowLiveDataConversions$asFlow$1(arg2, null)));
    }

    public static final LiveData asLiveData(Flow arg7) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        return FlowLiveDataConversions.asLiveData$default(arg7, null, 0, 3, null);
    }

    public static final LiveData asLiveData(Flow arg2, Duration arg3, CoroutineContext arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "timeout");
        Intrinsics.checkNotNullParameter(arg4, "context");
        return FlowLiveDataConversions.asLiveData(arg2, arg4, Api26Impl.INSTANCE.toMillis(arg3));
    }

    public static final LiveData asLiveData(Flow arg2, CoroutineContext arg3, long arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "context");
        LiveData v3 = CoroutineLiveDataKt.liveData(arg3, arg4, new FlowLiveDataConversions$asLiveData$1(arg2, null));
        if((arg2 instanceof StateFlow)) {
            if(ArchTaskExecutor.getInstance().isMainThread()) {
                v3.setValue(((StateFlow)arg2).getValue());
                return v3;
            }
            else {
                v3.postValue(((StateFlow)arg2).getValue());
            }
        }

        return v3;
    }

    public static final LiveData asLiveData(Flow arg7, CoroutineContext arg8) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "context");
        return FlowLiveDataConversions.asLiveData$default(arg7, arg8, 0, 2, null);
    }

    public static LiveData asLiveData$default(Flow arg0, CoroutineContext arg1, long arg2, int arg4, Object arg5) {
        EmptyCoroutineContext v1;
        if((arg4 & 1) != 0) {
            v1 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg4 & 2) != 0) {
            arg2 = 5000;
        }

        return FlowLiveDataConversions.asLiveData(arg0, ((CoroutineContext)v1), arg2);
    }

    public static LiveData asLiveData$default(Flow arg0, Duration arg1, CoroutineContext arg2, int arg3, Object arg4) {
        EmptyCoroutineContext v2;
        if((arg3 & 2) != 0) {
            v2 = EmptyCoroutineContext.INSTANCE;
        }

        return FlowLiveDataConversions.asLiveData(arg0, arg1, ((CoroutineContext)v2));
    }
}

