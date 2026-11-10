package androidx.compose.foundation.platform;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0015\u0010\u0002\u001A\u00020\u00012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0001H\u0080\b\u001A;\u0010\u0004\u001A\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\n\u0010\u0006\u001A\u00060\u0001j\u0002`\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00050\tH\u0080\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\n*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u000B"}, d2={"SynchronizedObject", "", "makeSynchronizedObject", "ref", "synchronized", "R", "lock", "Landroidx/compose/foundation/platform/SynchronizedObject;", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Synchronization_androidKt {
    public static final Object makeSynchronizedObject(Object arg0) {
        if(arg0 == null) {
            arg0 = new Object();
        }

        return arg0;
    }

    public static Object makeSynchronizedObject$default(Object arg0, int arg1, Object arg2) {
        if((arg1 & 1) != 0) {
            arg0 = null;
        }

        if(0 == 0) {
            arg0 = new Object();
        }

        return arg0;
    }

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

