package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0006\u001A\u0002H\u0007\"\u0004\b\u0000\u0010\u00072!\u0010\b\u001A\u001D\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00070\tH\u0096@¢\u0006\u0002\u0010\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/runtime/FallbackFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "<init>", "()V", "DefaultFrameDelay", "", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class FallbackFrameClock implements MonotonicFrameClock {
    private static final long DefaultFrameDelay = 16;
    public static final FallbackFrameClock INSTANCE;

    static {
        FallbackFrameClock.INSTANCE = new FallbackFrameClock();
    }

    private FallbackFrameClock() {
        super();
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((MonotonicFrameClock)this), arg1, arg2);
    }

    public Element get(Key arg1) {
        return DefaultImpls.get(((MonotonicFrameClock)this), arg1);
    }

    public CoroutineContext minusKey(Key arg1) {
        return DefaultImpls.minusKey(((MonotonicFrameClock)this), arg1);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((MonotonicFrameClock)this), arg1);
    }

    public Object withFrameNanos(Function1 arg3, Continuation arg4) {
        return BuildersKt.withContext(Dispatchers.getMain(), new FallbackFrameClock$withFrameNanos$2(arg3, null), arg4);
    }
}

