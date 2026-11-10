package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Deprecated(level=DeprecationLevel.ERROR, message="This is internal API and may be removed in the future releases") @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H\'¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2={"Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/Job;", "getChildJobCancellationCause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "()Ljava/util/concurrent/CancellationException;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface ParentJob extends Job {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static void cancel(ParentJob arg0) {
            kotlinx.coroutines.Job$DefaultImpls.cancel(((Job)arg0));
        }

        public static Object fold(ParentJob arg0, Object arg1, Function2 arg2) {
            return kotlinx.coroutines.Job$DefaultImpls.fold(((Job)arg0), arg1, arg2);
        }

        public static Element get(ParentJob arg0, Key arg1) {
            return kotlinx.coroutines.Job$DefaultImpls.get(((Job)arg0), arg1);
        }

        public static CoroutineContext minusKey(ParentJob arg0, Key arg1) {
            return kotlinx.coroutines.Job$DefaultImpls.minusKey(((Job)arg0), arg1);
        }

        public static CoroutineContext plus(ParentJob arg0, CoroutineContext arg1) {
            return kotlinx.coroutines.Job$DefaultImpls.plus(((Job)arg0), arg1);
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Operator \'+\' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.") public static Job plus(ParentJob arg0, Job arg1) {
            return kotlinx.coroutines.Job$DefaultImpls.plus(((Job)arg0), arg1);
        }
    }

    CancellationException getChildJobCancellationCause();
}

