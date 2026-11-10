package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u001F\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000B\u0010\fJ\u0015\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001A\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\tH\u0014J\b\u0010\u001E\u001A\u00020\u001FH\u0014J\u0012\u0010 \u001A\u00020\u00172\b\u0010!\u001A\u0004\u0018\u00010\"H\u0004J\u0019\u0010#\u001A\u00020\u00172\f\u0010$\u001A\b\u0012\u0004\u0012\u00028\u00000%¢\u0006\u0002\u0010\u0019J\u0012\u0010&\u001A\u00020\u00172\b\u0010!\u001A\u0004\u0018\u00010\"H\u0014J\u0015\u0010\'\u001A\u00020\u00172\u0006\u0010(\u001A\u00020\u001CH\u0000¢\u0006\u0002\b)J\r\u0010*\u001A\u00020\u001FH\u0010¢\u0006\u0002\b+JJ\u0010,\u001A\u00020\u0017\"\u0004\b\u0001\u0010-2\u0006\u0010,\u001A\u00020.2\u0006\u0010/\u001A\u0002H-2\'\u00100\u001A#\b\u0001\u0012\u0004\u0012\u0002H-\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\"01¢\u0006\u0002\b2¢\u0006\u0002\u00103R\u0017\u0010\r\u001A\u00020\u0007¢\u0006\u000E\n\u0000\u0012\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u00064"}, d2={"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "initParentJob", "", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;ZZ)V", "context", "getContext$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "isActive", "()Z", "onCompleted", "", "value", "(Ljava/lang/Object;)V", "onCancelled", "cause", "", "handled", "cancellationExceptionMessage", "", "onCompletionInternal", "state", "", "resumeWith", "result", "Lkotlin/Result;", "afterResume", "handleOnCompletionException", "exception", "handleOnCompletionException$kotlinx_coroutines_core", "nameString", "nameString$kotlinx_coroutines_core", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class AbstractCoroutine extends JobSupport implements Continuation, CoroutineScope, Job {
    private final CoroutineContext context;

    public AbstractCoroutine(CoroutineContext arg1, boolean arg2, boolean arg3) {
        super(arg3);
        if(arg2) {
            this.initParentJob(arg1.get(Job.Key));
        }

        this.context = arg1.plus(this);
    }

    protected void afterResume(Object arg1) {
        this.afterCompletion(arg1);
    }

    protected String cancellationExceptionMessage() {
        return DebugStringsKt.getClassSimpleName(this) + " was cancelled";
    }

    public final CoroutineContext getContext() {
        return this.context;
    }

    public static void getContext$annotations() {
    }

    public CoroutineContext getCoroutineContext() {
        return this.context;
    }

    public final void handleOnCompletionException$kotlinx_coroutines_core(Throwable arg1) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.context, arg1);
    }

    public boolean isActive() {
        return super.isActive();
    }

    public String nameString$kotlinx_coroutines_core() {
        String v0 = CoroutineContextKt.getCoroutineName(this.context);
        if(v0 == null) {
            return super.nameString$kotlinx_coroutines_core();
        }

        return "\"" + v0 + "\":" + super.nameString$kotlinx_coroutines_core();
    }

    protected void onCancelled(Throwable arg1, boolean arg2) {
    }

    protected void onCompleted(Object arg1) {
    }

    protected final void onCompletionInternal(Object arg2) {
        if((arg2 instanceof CompletedExceptionally)) {
            this.onCancelled(((CompletedExceptionally)arg2).cause, ((CompletedExceptionally)arg2).getHandled());
            return;
        }

        this.onCompleted(arg2);
    }

    public final void resumeWith(Object arg2) {
        arg2 = this.makeCompletingOnce$kotlinx_coroutines_core(CompletionStateKt.toState(arg2));
        if(arg2 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return;
        }

        this.afterResume(arg2);
    }

    public final void start(CoroutineStart arg1, Object arg2, Function2 arg3) {
        arg1.invoke(arg3, arg2, ((Continuation)this));
    }
}

