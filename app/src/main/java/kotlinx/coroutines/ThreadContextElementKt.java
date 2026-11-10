package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.internal.ThreadLocalElement;
import kotlinx.coroutines.internal.ThreadLocalKey;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001A+\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u0002H\u0002¢\u0006\u0002\u0010\u0005\u001A\u0016\u0010\u0006\u001A\u00020\u0007*\u0006\u0012\u0002\b\u00030\u0003H\u0086H¢\u0006\u0002\u0010\b\u001A\u0016\u0010\t\u001A\u00020\n*\u0006\u0012\u0002\b\u00030\u0003H\u0086H¢\u0006\u0002\u0010\b¨\u0006\u000B"}, d2={"asContextElement", "Lkotlinx/coroutines/ThreadContextElement;", "T", "Ljava/lang/ThreadLocal;", "value", "(Ljava/lang/ThreadLocal;Ljava/lang/Object;)Lkotlinx/coroutines/ThreadContextElement;", "isPresent", "", "(Ljava/lang/ThreadLocal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensurePresent", "", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ThreadContextElementKt {
    public static final ThreadContextElement asContextElement(ThreadLocal arg1, Object arg2) {
        return new ThreadLocalElement(arg2, arg1);
    }

    public static ThreadContextElement asContextElement$default(ThreadLocal arg0, Object arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.get();
        }

        return ThreadContextElementKt.asContextElement(arg0, arg1);
    }

    public static final Object ensurePresent(ThreadLocal arg2, Continuation arg3) {
        if(arg3.getContext().get(new ThreadLocalKey(arg2)) != null) {
            return Unit.INSTANCE;
        }

        throw new IllegalStateException("ThreadLocal " + arg2 + " is missing from context " + arg3.getContext().toString());
    }

    private static final Object ensurePresent$$forInline(ThreadLocal arg0, Continuation arg1) {
        null.getContext();
        throw null;
    }

    public static final Object isPresent(ThreadLocal arg1, Continuation arg2) {
        boolean v1 = arg2.getContext().get(new ThreadLocalKey(arg1)) != null ? true : false;
        return Boxing.boxBoolean(v1);
    }

    private static final Object isPresent$$forInline(ThreadLocal arg0, Continuation arg1) {
        null.getContext();
        throw null;
    }
}

