package kotlinx.coroutines.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0001\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J!\u0010\f\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\u000B2\n\u0010\u000E\u001A\u00060\u000Fj\u0002`\u0010H\u0016¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\u000B2\n\u0010\u000E\u001A\u00060\u000Fj\u0002`\u0010H\u0017¢\u0006\u0002\u0010\u0011J\b\u0010\u0013\u001A\u00020\u0005H\u0016J\u0016\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u0016H\u0097A¢\u0006\u0002\u0010\u0017J*\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u00162\n\u0010\u000E\u001A\u00060\u000Fj\u0002`\u00102\u0006\u0010\n\u001A\u00020\u000BH\u0096\u0001¢\u0006\u0002\u0010\u001BJ\u001F\u0010\u001C\u001A\u00020\r2\u0006\u0010\u001A\u001A\u00020\u00162\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\r0\u001EH\u0096\u0001R\u000E\u0010\u0003\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Lkotlinx/coroutines/internal/NamedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "dispatcher", "name", "", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/String;)V", "isDispatchNeeded", "", "context", "Lkotlin/coroutines/CoroutineContext;", "dispatch", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", "toString", "delay", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class NamedDispatcher extends CoroutineDispatcher implements Delay {
    private final CoroutineDispatcher dispatcher;
    private final String name;

    public NamedDispatcher(CoroutineDispatcher arg2, String arg3) {
        Delay v0_1;
        super();
        CoroutineDispatcher v0 = (arg2 instanceof Delay) ? arg2 : null;
        if(v0 == null) {
            v0_1 = DefaultExecutorKt.getDefaultDelay();
        }

        this.$$delegate_0 = v0_1;
        this.dispatcher = arg2;
        this.name = arg3;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated without replacement as an internal method never intended for public use") public Object delay(long arg1, Continuation arg3) {
        return this.$$delegate_0.delay(arg1, arg3);
    }

    public void dispatch(CoroutineContext arg1, Runnable arg2) {
        this.dispatcher.dispatch(arg1, arg2);
    }

    public void dispatchYield(CoroutineContext arg1, Runnable arg2) {
        this.dispatcher.dispatchYield(arg1, arg2);
    }

    public DisposableHandle invokeOnTimeout(long arg1, Runnable arg3, CoroutineContext arg4) {
        return this.$$delegate_0.invokeOnTimeout(arg1, arg3, arg4);
    }

    public boolean isDispatchNeeded(CoroutineContext arg1) {
        return this.dispatcher.isDispatchNeeded(arg1);
    }

    public void scheduleResumeAfterDelay(long arg1, CancellableContinuation arg3) {
        this.$$delegate_0.scheduleResumeAfterDelay(arg1, arg3);
    }

    public String toString() {
        return this.name;
    }
}

