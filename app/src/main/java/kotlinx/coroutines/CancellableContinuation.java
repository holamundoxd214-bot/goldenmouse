package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002J#\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00028\u00002\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\tH\'¢\u0006\u0002\u0010\fJz\u0010\b\u001A\u0004\u0018\u00010\t\"\b\b\u0001\u0010\r*\u00028\u00002\u0006\u0010\n\u001A\u0002H\r2\b\u0010\u000B\u001A\u0004\u0018\u00010\t2M\u0010\u000E\u001AI\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u0011H\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000FH\'¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001A\u00020\u0010H\'J\u0010\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00020\tH\'J\b\u0010\u001C\u001A\u00020\u0016H\'J\u0014\u0010\u001D\u001A\u00020\u00042\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0010H&J1\u0010\u001E\u001A\u00020\u00162\'\u0010\u001F\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00160 j\u0002`!H&J\u0019\u0010\"\u001A\u00020\u0016*\u00020#2\u0006\u0010\n\u001A\u00028\u0000H\'¢\u0006\u0002\u0010$J\u0014\u0010%\u001A\u00020\u0016*\u00020#2\u0006\u0010\u0019\u001A\u00020\u0010H\'J:\u0010&\u001A\u00020\u00162\u0006\u0010\n\u001A\u00028\u00002#\u0010\u000E\u001A\u001F\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0016\u0018\u00010 H\'¢\u0006\u0002\u0010\'Jn\u0010&\u001A\u00020\u0016\"\b\b\u0001\u0010\r*\u00028\u00002\u0006\u0010\n\u001A\u0002H\r2M\u0010\u000E\u001AI\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u0011H\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000FH&¢\u0006\u0002\u0010(R\u0012\u0010\u0003\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0005R\u0012\u0010\u0007\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005¨\u0006)"}, d2={"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", "isActive", "", "()Z", "isCompleted", "isCancelled", "tryResume", "", "value", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "R", "onCancellation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/CoroutineContext;", "context", "", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "tryResumeWithException", "exception", "completeResume", "token", "initCancellability", "cancel", "invokeOnCancellation", "handler", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface CancellableContinuation extends Continuation {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        public static boolean cancel$default(CancellableContinuation arg0, Throwable arg1, int arg2, Object arg3) {
            if(arg3 == null) {
                if((arg2 & 1) != 0) {
                    arg1 = null;
                }

                return arg0.cancel(arg1);
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static Object tryResume$default(CancellableContinuation arg0, Object arg1, Object arg2, int arg3, Object arg4) {
            if(arg4 == null) {
                if((arg3 & 2) != 0) {
                    arg2 = null;
                }

                return arg0.tryResume(arg1, arg2);
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
    }

    boolean cancel(Throwable arg1);

    void completeResume(Object arg1);

    void initCancellability();

    void invokeOnCancellation(Function1 arg1);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    void resume(Object arg1, Function3 arg2);

    @Deprecated(level=DeprecationLevel.WARNING, message="Use the overload that also accepts the `value` and the coroutine context in lambda", replaceWith="<_subannotation>") void resume(Object arg1, Function1 arg2);

    void resumeUndispatched(CoroutineDispatcher arg1, Object arg2);

    void resumeUndispatchedWithException(CoroutineDispatcher arg1, Throwable arg2);

    Object tryResume(Object arg1, Object arg2);

    Object tryResume(Object arg1, Object arg2, Function3 arg3);

    Object tryResumeWithException(Throwable arg1);
}

