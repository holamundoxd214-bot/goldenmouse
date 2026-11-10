package kotlinx.coroutines.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay$DefaultImpls;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001D\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u001A\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0006H\u0016J$\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\n\u0010\u0019\u001A\u00060\u001Aj\u0002`\u001B2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u001C\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u000E\u001A\u00020\u000F2\n\u0010\u0019\u001A\u00060\u001Aj\u0002`\u001BH\u0016J\u001E\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u0017\u001A\u00020\u00182\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020!0 H\u0016J\b\u0010\"\u001A\u00020\u001DH\u0002J\b\u0010#\u001A\u00020\u0006H\u0016R\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006$"}, d2={"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "isDispatchNeeded", "", "context", "Lkotlin/coroutines/CoroutineContext;", "limitedParallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "", "name", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "missing", "toString", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class MissingMainCoroutineDispatcher extends MainCoroutineDispatcher implements Delay {
    private final Throwable cause;
    private final String errorHint;

    public MissingMainCoroutineDispatcher(Throwable arg1, String arg2) {
        super();
        this.cause = arg1;
        this.errorHint = arg2;
    }

    public MissingMainCoroutineDispatcher(Throwable arg1, String arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated without replacement as an internal method never intended for public use") public Object delay(long arg1, Continuation arg3) {
        return DefaultImpls.delay(((Delay)this), arg1, arg3);
    }

    public Void dispatch(CoroutineContext arg1, Runnable arg2) {
        this.missing();
        throw new KotlinNothingValueException();
    }

    public void dispatch(CoroutineContext arg1, Runnable arg2) {
        this.dispatch(arg1, arg2);
    }

    public MainCoroutineDispatcher getImmediate() {
        return this;
    }

    public DisposableHandle invokeOnTimeout(long arg1, Runnable arg3, CoroutineContext arg4) {
        this.missing();
        throw new KotlinNothingValueException();
    }

    public boolean isDispatchNeeded(CoroutineContext arg1) {
        this.missing();
        throw new KotlinNothingValueException();
    }

    public CoroutineDispatcher limitedParallelism(int arg1, String arg2) {
        this.missing();
        throw new KotlinNothingValueException();
    }

    private final Void missing() {
        if(this.cause != null) {
            StringBuilder v0 = new StringBuilder("Module with the Main dispatcher had failed to initialize");
            String v1 = this.errorHint;
            if(v1 != null) {
                v1 = ". " + v1;
                if(v1 == null) {
                    goto label_13;
                }
            }
            else {
            label_13:
                v1 = "";
            }

            throw new IllegalStateException(v0.append(v1).toString(), this.cause);
        }

        MainDispatchersKt.throwMissingMainDispatcherException();
        throw new KotlinNothingValueException();
    }

    public Void scheduleResumeAfterDelay(long arg1, CancellableContinuation arg3) {
        this.missing();
        throw new KotlinNothingValueException();
    }

    public void scheduleResumeAfterDelay(long arg1, CancellableContinuation arg3) {
        this.scheduleResumeAfterDelay(arg1, arg3);
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("Dispatchers.Main[missing");
        String v3 = this.cause != null ? ", cause=" + this.cause : "";
        return v0.append(v3).append(']').toString();
    }
}

