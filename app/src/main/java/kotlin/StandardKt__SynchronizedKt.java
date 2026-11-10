package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A;\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2={"synchronized", "R", "lock", "", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/StandardKt") class StandardKt__SynchronizedKt extends StandardKt__StandardKt {
    public StandardKt__SynchronizedKt() {
        super();
    }

    @IgnorableReturnValue private static final Object synchronized(Object arg1, Function0 arg2) {
        Object v2_1;
        Intrinsics.checkNotNullParameter(arg1, "lock");
        Intrinsics.checkNotNullParameter(arg2, "block");
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

