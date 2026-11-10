package kotlinx.coroutines.internal;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A*\u0010\u0002\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\u00060\u0001j\u0002`\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0080\b¢\u0006\u0002\u0010\u0007\u001A\u001D\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\f0\u000B\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001A\u00020\u000EH\u0080\b\u001A\u0010\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0000\"\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001*\u001E\b\u0000\u0010\b\u001A\u0004\b\u0000\u0010\u0003\"\b\u0012\u0004\u0012\u0002H\u00030\t2\b\u0012\u0004\u0012\u0002H\u00030\t¨\u0006\u0015"}, d2={"ReentrantLock", "Ljava/util/concurrent/locks/ReentrantLock;", "withLock", "T", "Lkotlinx/coroutines/internal/ReentrantLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "WorkaroundAtomicReference", "Ljava/util/concurrent/atomic/AtomicReference;", "identitySet", "", "E", "expectedSize", "", "REMOVE_FUTURE_ON_CANCEL", "Ljava/lang/reflect/Method;", "removeFutureOnCancel", "", "executor", "Ljava/util/concurrent/Executor;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ConcurrentKt {
    private static final Method REMOVE_FUTURE_ON_CANCEL;

    static {
        Method v0;
        try {
            v0 = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
        }
        catch(Throwable ) {
            v0 = null;
        }

        ConcurrentKt.REMOVE_FUTURE_ON_CANCEL = v0;
    }

    public static final Set identitySet(int arg1) {
        return Collections.newSetFromMap(new IdentityHashMap(arg1));
    }

    public static final boolean removeFutureOnCancel(Executor arg4) {
        Object v4;
        try {
            if((arg4 instanceof ScheduledThreadPoolExecutor)) {
            }
            else {
                v4 = null;
            }

            if(0 == 0) {
                return 0;
            }

            Method v1 = ConcurrentKt.REMOVE_FUTURE_ON_CANCEL;
            if(v1 == null) {
                return 0;
            }

            v1.invoke(v4, Boolean.valueOf(true));
            return 1;
        }
        catch(Throwable ) {
            return 0;
        }
    }

    public static final Object withLock(ReentrantLock arg0, Function0 arg1) {
        Object v1_1;
        ((Lock)arg0).lock();
        try {
            v1_1 = arg1.invoke();
        }
        catch(Throwable v1) {
            ((Lock)arg0).unlock();
            throw v1;
        }

        ((Lock)arg0).unlock();
        return v1_1;
    }
}

