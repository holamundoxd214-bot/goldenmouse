package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001Af\u0010\n\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u0001*\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u00032<\u0010\f\u001A8\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u0003\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0000\u0012\u0004\u0012\u00020\u000B0\r¢\u0006\u0002\b\u0010H\u0080\b¢\u0006\u0002\u0010\u0011\"D\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u00032\u0006\u0010\u0000\u001A\u00028\u00008@@@X\u0080\u000E¢\u0006\u0012\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2={"value", "T", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/internal/WorkaroundAtomicReference;", "getValue$annotations", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "getValue", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Object;", "setValue", "(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V", "loop", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/concurrent/atomic/AtomicReference;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class Concurrent_commonKt {
    public static final Object getValue(AtomicReference arg0) {
        return arg0.get();
    }

    public static void getValue$annotations(AtomicReference arg0) {
    }

    public static final void loop(AtomicReference arg1, Function2 arg2) {
        while(true) {
            arg2.invoke(arg1, Concurrent_commonKt.getValue(arg1));
        }
    }

    public static final void setValue(AtomicReference arg0, Object arg1) {
        arg0.set(arg1);
    }
}

