package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0016\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A;\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0087\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"synchronized", "T", "lock", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class Synchronized_commonKt {
    public static final Object synchronized(Object arg0, Function0 arg1) {
        Object v1_1;
        __monitor_enter(arg0);
        try {
            v1_1 = arg1.invoke();
        }
        catch(Throwable v1) {
            __monitor_exit(arg0);
            throw v1;
        }

        __monitor_exit(arg0);
        return v1_1;
    }
}

