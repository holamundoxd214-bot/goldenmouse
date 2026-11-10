package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u001A\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u001A,\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001A)\u0010\u0007\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\b\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0002¢\u0006\u0002\u0010\t\"\u000E\u0010\n\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\f\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\r\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000E\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"runInterruptible", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runInterruptibleInExpectedContext", "coroutineContext", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "WORKING", "", "FINISHED", "INTERRUPTING", "INTERRUPTED", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class InterruptibleKt {
    private static final int FINISHED = 1;
    private static final int INTERRUPTED = 3;
    private static final int INTERRUPTING = 2;
    private static final int WORKING;

    public static final Object access$runInterruptibleInExpectedContext(CoroutineContext arg0, Function0 arg1) {
        return InterruptibleKt.runInterruptibleInExpectedContext(arg0, arg1);
    }

    public static final Object runInterruptible(CoroutineContext arg2, Function0 arg3, Continuation arg4) {
        return BuildersKt.withContext(arg2, new InterruptibleKt$runInterruptible$2(arg3, null), arg4);
    }

    public static Object runInterruptible$default(CoroutineContext arg0, Function0 arg1, Continuation arg2, int arg3, Object arg4) {
        EmptyCoroutineContext v0;
        if((arg3 & 1) != 0) {
            v0 = EmptyCoroutineContext.INSTANCE;
        }

        return InterruptibleKt.runInterruptible(((CoroutineContext)v0), arg1, arg2);
    }

    private static final Object runInterruptibleInExpectedContext(CoroutineContext arg1, Function0 arg2) {
        Object v1_2;
        ThreadState v0;
        try {
            v0 = new ThreadState();
            v0.setup(JobKt.getJob(arg1));
        }
        catch(InterruptedException v1) {
            goto label_15;
        }

        try {
            v1_2 = arg2.invoke();
            goto label_5;
        }
        catch(Throwable v1_1) {
            try {
                v0.clearInterrupt();
                throw v1_1;
            label_5:
                v0.clearInterrupt();
                return v1_2;
            }
            catch(InterruptedException v1) {
            label_15:
                throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(((Throwable)v1));
            }
        }
    }
}

