package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause1;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u000E\u0010\u0003\u001A\u00028\u0000H¦@¢\u0006\u0002\u0010\u0004J\r\u0010\t\u001A\u00028\u0000H\'¢\u0006\u0002\u0010\nJ\n\u0010\u000B\u001A\u0004\u0018\u00010\fH\'R\u0018\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\r"}, d2={"Lkotlinx/coroutines/Deferred;", "T", "Lkotlinx/coroutines/Job;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAwait", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "getCompleted", "()Ljava/lang/Object;", "getCompletionExceptionOrNull", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface Deferred extends Job {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static void cancel(Deferred arg0) {
            kotlinx.coroutines.Job$DefaultImpls.cancel(((Job)arg0));
        }

        public static Object fold(Deferred arg0, Object arg1, Function2 arg2) {
            return kotlinx.coroutines.Job$DefaultImpls.fold(((Job)arg0), arg1, arg2);
        }

        public static Element get(Deferred arg0, Key arg1) {
            return kotlinx.coroutines.Job$DefaultImpls.get(((Job)arg0), arg1);
        }

        public static CoroutineContext minusKey(Deferred arg0, Key arg1) {
            return kotlinx.coroutines.Job$DefaultImpls.minusKey(((Job)arg0), arg1);
        }

        public static CoroutineContext plus(Deferred arg0, CoroutineContext arg1) {
            return kotlinx.coroutines.Job$DefaultImpls.plus(((Job)arg0), arg1);
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Operator \'+\' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.") public static Job plus(Deferred arg0, Job arg1) {
            return kotlinx.coroutines.Job$DefaultImpls.plus(((Job)arg0), arg1);
        }
    }

    Object await(Continuation arg1);

    Object getCompleted();

    Throwable getCompletionExceptionOrNull();

    SelectClause1 getOnAwait();
}

