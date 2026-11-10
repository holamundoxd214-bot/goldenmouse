package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.selects.SelectClause0;

@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0013\u001A\u00020\fH\u0017J\u000E\u0010\u0014\u001A\u00020\u0015H\u0097@¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001C\u001A\u00060\u001Dj\u0002`\u001EH\u0017¢\u0006\u0002\u0010\u001FJ1\u0010 \u001A\u00020!2\'\u0010\"\u001A#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\'\u0012\u0004\u0012\u00020\u00150#j\u0002`(H\u0017JA\u0010 \u001A\u00020!2\u0006\u0010)\u001A\u00020\f2\u0006\u0010*\u001A\u00020\f2\'\u0010\"\u001A#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\'\u0012\u0004\u0012\u00020\u00150#j\u0002`(H\u0017J\u001D\u0010+\u001A\u00020\u00152\u000E\u0010\'\u001A\n\u0018\u00010\u001Dj\u0004\u0018\u0001`\u001EH\u0017¢\u0006\u0002\u0010,J\u0012\u0010+\u001A\u00020\f2\b\u0010\'\u001A\u0004\u0018\u00010$H\u0017J\u0010\u00102\u001A\u0002032\u0006\u00104\u001A\u000205H\u0017J\b\u00106\u001A\u00020\u0006H\u0016R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001C\u0010\u0007\u001A\u0004\u0018\u00010\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001A\u0004\b\t\u0010\nR\u001A\u0010\u000B\u001A\u00020\f8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0004\u001A\u0004\b\u000B\u0010\u000ER\u001A\u0010\u000F\u001A\u00020\f8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0004\u001A\u0004\b\u000F\u0010\u000ER\u001A\u0010\u0011\u001A\u00020\f8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0004\u001A\u0004\b\u0011\u0010\u000ER\u001A\u0010\u0017\u001A\u00020\u00188VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0004\u001A\u0004\b\u001A\u0010\u001BR \u0010-\u001A\b\u0012\u0004\u0012\u00020\u00020.8VX\u0097\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0004\u001A\u0004\b0\u00101¨\u00067"}, d2={"Lkotlinx/coroutines/NonCancellable;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/Job;", "<init>", "()V", "message", "", "parent", "getParent$annotations", "getParent", "()Lkotlinx/coroutines/Job;", "isActive", "", "isActive$annotations", "()Z", "isCompleted", "isCompleted$annotations", "isCancelled", "isCancelled$annotations", "start", "join", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "()Ljava/util/concurrent/CancellationException;", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "onCancelling", "invokeImmediately", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "children", "Lkotlin/sequences/Sequence;", "getChildren$annotations", "getChildren", "()Lkotlin/sequences/Sequence;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "toString", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class NonCancellable extends AbstractCoroutineContextElement implements Job {
    public static final NonCancellable INSTANCE = null;
    private static final String message = "NonCancellable can be used only as an argument for \'withContext\', direct usages of its API are prohibited";

    static {
        NonCancellable.INSTANCE = new NonCancellable();
    }

    private NonCancellable() {
        super(Job.Key);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="NonCancellable can be used only as an argument for \'withContext\', direct usages of its API are prohibited") public ChildHandle attachChild(ChildJob arg1) {
        return NonDisposableHandle.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public void cancel() {
        DefaultImpls.cancel(((Job)this));
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="NonCancellable can be used only as an argument for \'withContext\', direct usages of its API are prohibited") public void cancel(CancellationException arg1) {
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public boolean cancel(Throwable arg1) {
        return 0;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="NonCancellable can be used only as an argument for \'withContext\', direct usages of its API are prohibited") public CancellationException getCancellationException() {
        throw new IllegalStateException("This job is always active");
    }

    public Sequence getChildren() {
        return SequencesKt.emptySequence();
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="NonCancellable can be used only as an argument for \'withContext\', direct usages of its API are prohibited") public static void getChildren$annotations() {
    }

    public SelectClause0 getOnJoin() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="NonCancellable can be used only as an argument for \'withContext\', direct usages of its API are prohibited") public static void getOnJoin$annotations() {
    }

    public Job getParent() {
        return null;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="NonCancellable can be used only as an argument for \'withContext\', direct usages of its API are prohibited") public static void getParent$annotations() {
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="NonCancellable can be used only as an argument for \'withContext\', direct usages of its API are prohibited") public DisposableHandle invokeOnCompletion(Function1 arg1) {
        return NonDisposableHandle.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="NonCancellable can be used only as an argument for \'withContext\', direct usages of its API are prohibited") public DisposableHandle invokeOnCompletion(boolean arg1, boolean arg2, Function1 arg3) {
        return NonDisposableHandle.INSTANCE;
    }

    public boolean isActive() {
        return 1;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="NonCancellable can be used only as an argument for \'withContext\', direct usages of its API are prohibited") public static void isActive$annotations() {
    }

    public boolean isCancelled() {
        return 0;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="NonCancellable can be used only as an argument for \'withContext\', direct usages of its API are prohibited") public static void isCancelled$annotations() {
    }

    public boolean isCompleted() {
        return 0;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="NonCancellable can be used only as an argument for \'withContext\', direct usages of its API are prohibited") public static void isCompleted$annotations() {
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="NonCancellable can be used only as an argument for \'withContext\', direct usages of its API are prohibited") public Object join(Continuation arg1) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Operator \'+\' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.") public Job plus(Job arg1) {
        return DefaultImpls.plus(((Job)this), arg1);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="NonCancellable can be used only as an argument for \'withContext\', direct usages of its API are prohibited") public boolean start() {
        return 0;
    }

    public String toString() {
        return "NonCancellable";
    }
}

