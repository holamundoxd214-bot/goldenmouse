package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000\u001A\u0016\u0010\u0003\u001A\u00020\u0004*\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0000¨\u0006\u0007"}, d2={"checkParallelism", "", "", "namedOrThis", "Lkotlinx/coroutines/CoroutineDispatcher;", "name", "", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LimitedDispatcherKt {
    public static final void checkParallelism(int arg2) {
        if(arg2 >= 1) {
            return;
        }

        throw new IllegalArgumentException("Expected positive parallelism level, but got " + arg2.toString());
    }

    public static final CoroutineDispatcher namedOrThis(CoroutineDispatcher arg1, String arg2) {
        if(arg2 != null) {
            return new NamedDispatcher(arg1, arg2);
        }

        return arg1;
    }
}

