package androidx.lifecycle;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A,\u0010\u0002\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0080@¢\u0006\u0002\u0010\b\u001A\\\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0007\"\u0004\b\u0000\u0010\u00042\b\b\u0002\u0010\u0011\u001A\u00020\u00122\b\b\u0002\u0010\u0013\u001A\u00020\u00012-\u0010\u0014\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\n¢\u0006\u0002\b\u000FH\u0007¢\u0006\u0002\u0010\u0015\u001AZ\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0007\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0011\u001A\u00020\u00122-\u0010\u0014\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\n¢\u0006\u0002\b\u000FH\u0007¢\u0006\u0002\u0010\u0018\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000*`\b\u0000\u0010\t\u001A\u0004\b\u0000\u0010\u0004\")\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\n¢\u0006\u0002\b\u000F2)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\n¢\u0006\u0002\b\u000F¨\u0006\u0019"}, d2={"DEFAULT_TIMEOUT", "", "addDisposableSource", "Landroidx/lifecycle/EmittedSource;", "T", "Landroidx/lifecycle/MediatorLiveData;", "source", "Landroidx/lifecycle/LiveData;", "(Landroidx/lifecycle/MediatorLiveData;Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Block", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "liveData", "context", "Lkotlin/coroutines/CoroutineContext;", "timeoutInMs", "block", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)Landroidx/lifecycle/LiveData;", "timeout", "Ljava/time/Duration;", "(Ljava/time/Duration;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Landroidx/lifecycle/LiveData;", "lifecycle-livedata"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    public static final Object addDisposableSource(MediatorLiveData arg3, LiveData arg4, Continuation arg5) {
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new CoroutineLiveDataKt$addDisposableSource$2(arg3, arg4, null), arg5);
    }

    public static final LiveData liveData(Duration arg3, CoroutineContext arg4, Function2 arg5) {
        Intrinsics.checkNotNullParameter(arg3, "timeout");
        Intrinsics.checkNotNullParameter(arg4, "context");
        Intrinsics.checkNotNullParameter(arg5, "block");
        return new CoroutineLiveData(arg4, Api26Impl.INSTANCE.toMillis(arg3), arg5);
    }

    public static final LiveData liveData(Duration arg2, Function2 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "timeout");
        Intrinsics.checkNotNullParameter(arg3, "block");
        return CoroutineLiveDataKt.liveData$default(arg2, null, arg3, 2, null);
    }

    public static final LiveData liveData(CoroutineContext arg1, long arg2, Function2 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        Intrinsics.checkNotNullParameter(arg4, "block");
        return new CoroutineLiveData(arg1, arg2, arg4);
    }

    public static final LiveData liveData(CoroutineContext arg7, Function2 arg8) {
        Intrinsics.checkNotNullParameter(arg7, "context");
        Intrinsics.checkNotNullParameter(arg8, "block");
        return CoroutineLiveDataKt.liveData$default(arg7, 0, arg8, 2, null);
    }

    public static final LiveData liveData(Function2 arg7) {
        Intrinsics.checkNotNullParameter(arg7, "block");
        return CoroutineLiveDataKt.liveData$default(null, 0, arg7, 3, null);
    }

    public static LiveData liveData$default(Duration arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        EmptyCoroutineContext v1;
        if((arg3 & 2) != 0) {
            v1 = EmptyCoroutineContext.INSTANCE;
        }

        return CoroutineLiveDataKt.liveData(arg0, ((CoroutineContext)v1), arg2);
    }

    public static LiveData liveData$default(CoroutineContext arg0, long arg1, Function2 arg3, int arg4, Object arg5) {
        EmptyCoroutineContext v0;
        if((arg4 & 1) != 0) {
            v0 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg4 & 2) != 0) {
            arg1 = 5000;
        }

        return CoroutineLiveDataKt.liveData(((CoroutineContext)v0), arg1, arg3);
    }
}

