package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001B\b\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0010\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ\b\u0010\u000B\u001A\u00020\u0000H\u0016R\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "coroutine", "Lkotlinx/coroutines/Job;", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/Job;)V", "(Ljava/lang/String;)V", "createCopy", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class TimeoutCancellationException extends CancellationException implements CopyableThrowable {
    public final transient Job coroutine;

    public TimeoutCancellationException(String arg2) {
        this(arg2, null);
    }

    public TimeoutCancellationException(String arg1, Job arg2) {
        super(arg1);
        this.coroutine = arg2;
    }

    public Throwable createCopy() {
        return this.createCopy();
    }

    public TimeoutCancellationException createCopy() {
        String v1 = this.getMessage();
        if(v1 == null) {
            v1 = "";
        }

        TimeoutCancellationException v0 = new TimeoutCancellationException(v1, this.coroutine);
        v0.initCause(((Throwable)this));
        return v0;
    }
}

