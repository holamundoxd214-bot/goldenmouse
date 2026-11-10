package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1={"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k=4, mv={2, 1, 0}, xi=0x30) public final class JobKt {
    public static final CompletableJob Job(Job arg0) {
        return JobKt__JobKt.Job(arg0);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static final Job Job(Job arg0) {
        return JobKt__JobKt.Job(arg0);
    }

    public static CompletableJob Job$default(Job arg0, int arg1, Object arg2) {
        return JobKt__JobKt.Job$default(arg0, arg1, arg2);
    }

    public static Job Job$default(Job arg0, int arg1, Object arg2) {
        return JobKt__JobKt.Job$default(arg0, arg1, arg2);
    }

    public static final void cancel(CoroutineContext arg0, CancellationException arg1) {
        JobKt__JobKt.cancel(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static final void cancel(CoroutineContext arg0) {
        JobKt__JobKt.cancel(arg0);
    }

    public static final void cancel(Job arg0, String arg1, Throwable arg2) {
        JobKt__JobKt.cancel(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static final boolean cancel(CoroutineContext arg0, Throwable arg1) {
        return JobKt__JobKt.cancel(arg0, arg1);
    }

    public static void cancel$default(Job arg0, String arg1, Throwable arg2, int arg3, Object arg4) {
        JobKt__JobKt.cancel$default(arg0, arg1, arg2, arg3, arg4);
    }

    public static void cancel$default(CoroutineContext arg0, CancellationException arg1, int arg2, Object arg3) {
        JobKt__JobKt.cancel$default(arg0, arg1, arg2, arg3);
    }

    public static boolean cancel$default(CoroutineContext arg0, Throwable arg1, int arg2, Object arg3) {
        return JobKt__JobKt.cancel$default(arg0, arg1, arg2, arg3);
    }

    public static final Object cancelAndJoin(Job arg0, Continuation arg1) {
        return JobKt__JobKt.cancelAndJoin(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static final void cancelChildren(CoroutineContext arg0) {
        JobKt__JobKt.cancelChildren(arg0);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static final void cancelChildren(CoroutineContext arg0, Throwable arg1) {
        JobKt__JobKt.cancelChildren(arg0, arg1);
    }

    public static final void cancelChildren(CoroutineContext arg0, CancellationException arg1) {
        JobKt__JobKt.cancelChildren(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static final void cancelChildren(Job arg0) {
        JobKt__JobKt.cancelChildren(arg0);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static final void cancelChildren(Job arg0, Throwable arg1) {
        JobKt__JobKt.cancelChildren(arg0, arg1);
    }

    public static final void cancelChildren(Job arg0, CancellationException arg1) {
        JobKt__JobKt.cancelChildren(arg0, arg1);
    }

    public static void cancelChildren$default(CoroutineContext arg0, Throwable arg1, int arg2, Object arg3) {
        JobKt__JobKt.cancelChildren$default(arg0, arg1, arg2, arg3);
    }

    public static void cancelChildren$default(CoroutineContext arg0, CancellationException arg1, int arg2, Object arg3) {
        JobKt__JobKt.cancelChildren$default(arg0, arg1, arg2, arg3);
    }

    public static void cancelChildren$default(Job arg0, Throwable arg1, int arg2, Object arg3) {
        JobKt__JobKt.cancelChildren$default(arg0, arg1, arg2, arg3);
    }

    public static void cancelChildren$default(Job arg0, CancellationException arg1, int arg2, Object arg3) {
        JobKt__JobKt.cancelChildren$default(arg0, arg1, arg2, arg3);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="This function does not do what its name implies: it will not cancel the future if just cancel() was called.", replaceWith="<_subannotation>") public static final void cancelFutureOnCancellation(CancellableContinuation arg0, Future arg1) {
        JobKt__FutureKt.cancelFutureOnCancellation(arg0, arg1);
    }

    public static final DisposableHandle disposeOnCompletion(Job arg0, DisposableHandle arg1) {
        return JobKt__JobKt.disposeOnCompletion(arg0, arg1);
    }

    public static final void ensureActive(CoroutineContext arg0) {
        JobKt__JobKt.ensureActive(arg0);
    }

    public static final void ensureActive(Job arg0) {
        JobKt__JobKt.ensureActive(arg0);
    }

    public static final Job getJob(CoroutineContext arg0) {
        return JobKt__JobKt.getJob(arg0);
    }

    public static final DisposableHandle invokeOnCompletion(Job arg0, boolean arg1, JobNode arg2) {
        return JobKt__JobKt.invokeOnCompletion(arg0, arg1, arg2);
    }

    public static DisposableHandle invokeOnCompletion$default(Job arg0, boolean arg1, JobNode arg2, int arg3, Object arg4) {
        return JobKt__JobKt.invokeOnCompletion$default(arg0, arg1, arg2, arg3, arg4);
    }

    public static final boolean isActive(CoroutineContext arg0) {
        return JobKt__JobKt.isActive(arg0);
    }
}

