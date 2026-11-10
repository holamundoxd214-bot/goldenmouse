package kotlinx.coroutines;

import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0006\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0000\u001A\u0012\u0010\u0007\u001A\u00020\b2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0002\u001A\u0019\u0010\n\u001A\u00020\u00022\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0002\b\u0007\u001A\u0014\u0010\u000B\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001A\u00020\u0001H\u0000\u001A\u0012\u0010\r\u001A\u00020\u000E*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u000F\u001A!\u0010\u0010\u001A\u00020\u000E*\u00020\u00022\u0010\b\u0002\u0010\u0011\u001A\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\u0002\u0010\u0014\u001A\f\u0010\u0010\u001A\u00020\u000E*\u00020\u0002H\u0007\u001A\u0018\u0010\u0010\u001A\u00020\u000E*\u00020\u00022\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0015H\u0007\u001A!\u0010\u0019\u001A\u00020\u000E*\u00020\u00172\u0010\b\u0002\u0010\u0011\u001A\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\u0002\u0010\u001A\u001A\f\u0010\u0019\u001A\u00020\u000E*\u00020\u0017H\u0007\u001A\n\u0010\u001B\u001A\u00020\u000E*\u00020\u0002\u001A\n\u0010\u001B\u001A\u00020\u000E*\u00020\u0017\u001A\u001E\u0010\u0019\u001A\u00020\u000E*\u00020\u00022\u0006\u0010\u001C\u001A\u00020\u001D2\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0015\u001A\u0018\u0010\u0019\u001A\u00020\u0004*\u00020\u00172\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0015H\u0007\u001A!\u0010\u0010\u001A\u00020\u000E*\u00020\u00172\u0010\b\u0002\u0010\u0011\u001A\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\u0002\u0010\u001A\u001A\f\u0010\u0010\u001A\u00020\u000E*\u00020\u0017H\u0007\u001A\u0018\u0010\u0010\u001A\u00020\u000E*\u00020\u00172\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0015H\u0007\u001A\u001B\u0010!\u001A\u00020\u0015*\u0004\u0018\u00010\u00152\u0006\u0010\u001E\u001A\u00020\u0002H\u0002¢\u0006\u0002\b\"\"\u0015\u0010\u0016\u001A\u00020\u0004*\u00020\u00178F¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0018\"\u0015\u0010\u001E\u001A\u00020\u0002*\u00020\u00178F¢\u0006\u0006\u001A\u0004\b\u001F\u0010 ¨\u0006#"}, d2={"invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Job;", "invokeImmediately", "", "handler", "Lkotlinx/coroutines/JobNode;", "Job", "Lkotlinx/coroutines/CompletableJob;", "parent", "Job0", "disposeOnCompletion", "handle", "cancelAndJoin", "", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelChildren", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Lkotlinx/coroutines/Job;Ljava/util/concurrent/CancellationException;)V", "", "isActive", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Z", "cancel", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/CancellationException;)V", "ensureActive", "message", "", "job", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "orCancellation", "orCancellation$JobKt__JobKt", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/JobKt") final class JobKt__JobKt {
    public static final CompletableJob Job(Job arg1) {
        return new JobImpl(arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static final Job Job(Job arg0) {
        return JobKt.Job(arg0);
    }

    public static CompletableJob Job$default(Job arg0, int arg1, Object arg2) {
        if((arg1 & 1) != 0) {
            arg0 = null;
        }

        return JobKt.Job(arg0);
    }

    public static Job Job$default(Job arg0, int arg1, Object arg2) {
        if((arg1 & 1) != 0) {
            arg0 = null;
        }

        return JobKt.Job(arg0);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static final void cancel(CoroutineContext arg1) {
        JobKt.cancel(arg1, null);
    }

    public static final void cancel(CoroutineContext arg1, CancellationException arg2) {
        Element v1 = arg1.get(Job.Key);
        if(v1 != null) {
            ((Job)v1).cancel(arg2);
        }
    }

    public static final void cancel(Job arg0, String arg1, Throwable arg2) {
        arg0.cancel(ExceptionsKt.CancellationException(arg1, arg2));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static final boolean cancel(CoroutineContext arg1, Throwable arg2) {
        Element v1 = arg1.get(Job.Key);
        if((v1 instanceof JobSupport)) {
        }
        else {
            v1 = null;
        }

        if(v1 == null) {
            return 0;
        }

        ((JobSupport)v1).cancelInternal(JobKt__JobKt.orCancellation$JobKt__JobKt(arg2, v1));
        return 1;
    }

    public static void cancel$default(CoroutineContext arg0, CancellationException arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        JobKt.cancel(arg0, arg1);
    }

    public static void cancel$default(Job arg0, String arg1, Throwable arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        JobKt.cancel(arg0, arg1, arg2);
    }

    public static boolean cancel$default(CoroutineContext arg0, Throwable arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        return JobKt.cancel(arg0, arg1);
    }

    public static final Object cancelAndJoin(Job arg2, Continuation arg3) {
        DefaultImpls.cancel$default(arg2, null, 1, null);
        Object v2 = arg2.join(arg3);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static final void cancelChildren(CoroutineContext arg1) {
        JobKt.cancelChildren(arg1, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static final void cancelChildren(CoroutineContext arg3, Throwable arg4) {
        Element v3 = arg3.get(Job.Key);
        if(v3 == null) {
        }
        else {
            Iterator v0 = ((Job)v3).getChildren().iterator();
            while(v0.hasNext()) {
                Object v1 = v0.next();
                if((v1 instanceof JobSupport)) {
                }
                else {
                    v1 = null;
                }

                if(v1 == null) {
                    continue;
                }

                ((JobSupport)v1).cancelInternal(JobKt__JobKt.orCancellation$JobKt__JobKt(arg4, ((Job)v3)));
            }
        }
    }

    public static final void cancelChildren(CoroutineContext arg1, CancellationException arg2) {
        Element v1 = arg1.get(Job.Key);
        if(v1 != null) {
            Sequence v1_1 = ((Job)v1).getChildren();
            if(v1_1 != null) {
                Iterator v1_2 = v1_1.iterator();
                while(v1_2.hasNext()) {
                    v1_2.next().cancel(arg2);
                }
            }
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static final void cancelChildren(Job arg1) {
        JobKt.cancelChildren(arg1, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static final void cancelChildren(Job arg3, Throwable arg4) {
        Iterator v0 = arg3.getChildren().iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            if((v1 instanceof JobSupport)) {
            }
            else {
                v1 = null;
            }

            if(v1 == null) {
                continue;
            }

            ((JobSupport)v1).cancelInternal(JobKt__JobKt.orCancellation$JobKt__JobKt(arg4, arg3));
        }
    }

    public static final void cancelChildren(Job arg1, CancellationException arg2) {
        Iterator v1 = arg1.getChildren().iterator();
        while(v1.hasNext()) {
            v1.next().cancel(arg2);
        }
    }

    public static void cancelChildren$default(CoroutineContext arg0, Throwable arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        JobKt.cancelChildren(arg0, arg1);
    }

    public static void cancelChildren$default(CoroutineContext arg0, CancellationException arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        JobKt.cancelChildren(arg0, arg1);
    }

    public static void cancelChildren$default(Job arg0, Throwable arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        JobKt.cancelChildren(arg0, arg1);
    }

    public static void cancelChildren$default(Job arg0, CancellationException arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        JobKt.cancelChildren(arg0, arg1);
    }

    public static final DisposableHandle disposeOnCompletion(Job arg3, DisposableHandle arg4) {
        return JobKt.invokeOnCompletion$default(arg3, false, new DisposeOnCompletion(arg4), 1, null);
    }

    public static final void ensureActive(CoroutineContext arg1) {
        Element v1 = arg1.get(Job.Key);
        if(v1 != null) {
            JobKt.ensureActive(((Job)v1));
        }
    }

    public static final void ensureActive(Job arg1) {
        if(arg1.isActive()) {
            return;
        }

        throw arg1.getCancellationException();
    }

    public static final Job getJob(CoroutineContext arg3) {
        Element v0 = arg3.get(Job.Key);
        if(v0 != null) {
            return ((Job)v0);
        }

        throw new IllegalStateException("Current context doesn\'t contain Job in it: " + arg3.toString());
    }

    public static final DisposableHandle invokeOnCompletion(Job arg2, boolean arg3, JobNode arg4) {
        if((arg2 instanceof JobSupport)) {
            return ((JobSupport)arg2).invokeOnCompletionInternal$kotlinx_coroutines_core(arg3, arg4);
        }

        return arg2.invokeOnCompletion(arg4.getOnCancelling(), arg3, new JobKt__JobKt$invokeOnCompletion$1(arg4));
    }

    public static DisposableHandle invokeOnCompletion$default(Job arg0, boolean arg1, JobNode arg2, int arg3, Object arg4) {
        return JobKt.invokeOnCompletion(arg0, true, arg2);
    }

    public static final boolean isActive(CoroutineContext arg1) {
        Element v1 = arg1.get(Job.Key);
        if(v1 != null) {
            return ((Job)v1).isActive();
        }

        return 1;
    }

    private static final Throwable orCancellation$JobKt__JobKt(Throwable arg2, Job arg3) {
        JobCancellationException v2;
        if(arg2 == null) {
            v2 = new JobCancellationException("Job was cancelled", null, arg3);
        }

        return ((Throwable)v2);
    }
}

