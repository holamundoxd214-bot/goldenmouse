package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.selects.SelectClause0;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 /2\u00020\u0001:\u0001/J\u0011\u0010\f\u001A\u00060\rj\u0002`\u000EH\'¢\u0006\u0002\u0010\u000FJ\b\u0010\u0010\u001A\u00020\bH&J\u001F\u0010\u0011\u001A\u00020\u00122\u0010\b\u0002\u0010\u0013\u001A\n\u0018\u00010\rj\u0004\u0018\u0001`\u000EH&¢\u0006\u0002\u0010\u0014J\b\u0010\u0011\u001A\u00020\u0012H\u0017J\u0014\u0010\u0011\u001A\u00020\b2\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0015H\'J\u0010\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DH\'J\u000E\u0010\u001E\u001A\u00020\u0012H¦@¢\u0006\u0002\u0010\u001FJ1\u0010$\u001A\u00020%2\'\u0010&\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00120\'j\u0002`*H&JE\u0010$\u001A\u00020%2\b\b\u0002\u0010+\u001A\u00020\b2\b\b\u0002\u0010,\u001A\u00020\b2\'\u0010&\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00120\'j\u0002`*H\'J\u0011\u0010-\u001A\u00020\u00002\u0006\u0010.\u001A\u00020\u0000H\u0097\u0002R\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u00008&X§\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\tR\u0012\u0010\n\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\tR\u0012\u0010\u000B\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\tR\u0018\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00000\u0017X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0012\u0010 \u001A\u00020!X¦\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#¨\u00060"}, d2={"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "parent", "getParent$annotations", "()V", "getParent", "()Lkotlinx/coroutines/Job;", "isActive", "", "()Z", "isCompleted", "isCancelled", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "()Ljava/util/concurrent/CancellationException;", "start", "cancel", "", "cause", "(Ljava/util/concurrent/CancellationException;)V", "", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "onCancelling", "invokeImmediately", "plus", "other", "Key", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface Job extends Element {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static void cancel(Job arg1) {
            arg1.cancel(null);
        }

        public static void cancel$default(Job arg0, CancellationException arg1, int arg2, Object arg3) {
            if(arg3 == null) {
                if((arg2 & 1) != 0) {
                    arg1 = null;
                }

                arg0.cancel(arg1);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static boolean cancel$default(Job arg0, Throwable arg1, int arg2, Object arg3) {
            if(arg3 == null) {
                if((arg2 & 1) != 0) {
                    arg1 = null;
                }

                return arg0.cancel(arg1);
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static Object fold(Job arg0, Object arg1, Function2 arg2) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.fold(((Element)arg0), arg1, arg2);
        }

        public static Element get(Job arg0, Key arg1) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.get(((Element)arg0), arg1);
        }

        public static void getParent$annotations() {
        }

        public static DisposableHandle invokeOnCompletion$default(Job arg0, boolean arg1, boolean arg2, Function1 arg3, int arg4, Object arg5) {
            if(arg5 == null) {
                return arg0.invokeOnCompletion(false, true, arg3);
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static CoroutineContext minusKey(Job arg0, Key arg1) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.minusKey(((Element)arg0), arg1);
        }

        public static CoroutineContext plus(Job arg0, CoroutineContext arg1) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.plus(((Element)arg0), arg1);
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Operator \'+\' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.") public static Job plus(Job arg0, Job arg1) {
            return arg1;
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Lkotlinx/coroutines/Job$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/Job;", "<init>", "()V", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class kotlinx.coroutines.Job$Key implements Key {
        static {
            kotlinx.coroutines.Job$Key.$$INSTANCE = new kotlinx.coroutines.Job$Key();
        }

        private kotlinx.coroutines.Job$Key() {
            super();
        }
    }

    public static final kotlinx.coroutines.Job$Key Key;

    static {
        Job.Key = kotlinx.coroutines.Job$Key.$$INSTANCE;
    }

    ChildHandle attachChild(ChildJob arg1);

    void cancel(CancellationException arg1);

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") void cancel();

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") boolean cancel(Throwable arg1);

    CancellationException getCancellationException();

    Sequence getChildren();

    SelectClause0 getOnJoin();

    Job getParent();

    DisposableHandle invokeOnCompletion(Function1 arg1);

    DisposableHandle invokeOnCompletion(boolean arg1, boolean arg2, Function1 arg3);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    Object join(Continuation arg1);

    @Deprecated(level=DeprecationLevel.ERROR, message="Operator \'+\' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.") Job plus(Job arg1);

    boolean start();
}

