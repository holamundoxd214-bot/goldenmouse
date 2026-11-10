package androidx.savedstate.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A/\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u000E\b\u0004\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2={"synchronizedImpl", "T", "lock", "Landroidx/savedstate/internal/SynchronizedObject;", "action", "Lkotlin/Function0;", "(Landroidx/savedstate/internal/SynchronizedObject;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "savedstate"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SynchronizedObject_jvmKt {
    public static final Object synchronizedImpl(SynchronizedObject arg1, Function0 arg2) {
        Object v2_1;
        Intrinsics.checkNotNullParameter(arg1, "lock");
        Intrinsics.checkNotNullParameter(arg2, "action");
        __monitor_enter(arg1);
        try {
            v2_1 = arg2.invoke();
        }
        catch(Throwable v2) {
            __monitor_exit(arg1);
            throw v2;
        }

        __monitor_exit(arg1);
        return v2_1;
    }
}

