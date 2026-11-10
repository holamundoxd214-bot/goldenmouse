package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B!\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u000F\u001A\u00020\u0007H\u0016J\n\u0010\u0010\u001A\u0004\u0018\u00010\u0000H\u0016J\b\u0010\u0011\u001A\u00020\u0005H\u0016J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001A\u00020\u0017H\u0016R\u0010\u0010\f\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0018"}, d2={"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "_job", "getJob$kotlinx_coroutines_core", "()Lkotlinx/coroutines/Job;", "fillInStackTrace", "createCopy", "toString", "equals", "", "other", "", "hashCode", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class JobCancellationException extends CancellationException implements CopyableThrowable {
    private final transient Job _job;

    public JobCancellationException(String arg1, Throwable arg2, Job arg3) {
        super(arg1);
        this._job = arg3;
        if(arg2 != null) {
            this.initCause(arg2);
        }
    }

    public Throwable createCopy() {
        return this.createCopy();
    }

    public JobCancellationException createCopy() {
        if(DebugKt.getDEBUG()) {
            String v1 = this.getMessage();
            Intrinsics.checkNotNull(v1);
            return new JobCancellationException(v1, this, this.getJob$kotlinx_coroutines_core());
        }

        return null;
    }

    public boolean equals(Object arg3) {
        if((((JobCancellationException)arg3)) != this && (!(arg3 instanceof JobCancellationException) || !Intrinsics.areEqual(((JobCancellationException)arg3).getMessage(), this.getMessage()) || !Intrinsics.areEqual(((JobCancellationException)arg3).getJob$kotlinx_coroutines_core(), this.getJob$kotlinx_coroutines_core()) || !Intrinsics.areEqual(((JobCancellationException)arg3).getCause(), this.getCause()))) {
            return 0;
        }

        return 1;
    }

    public Throwable fillInStackTrace() {
        if(DebugKt.getDEBUG()) {
            return super.fillInStackTrace();
        }

        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final Job getJob$kotlinx_coroutines_core() {
        Job v0 = this._job;
        if(v0 == null) {
            NonCancellable v0_1 = NonCancellable.INSTANCE;
        }

        return v0;
    }

    public int hashCode() {
        String v0 = this.getMessage();
        Intrinsics.checkNotNull(v0);
        int v0_1 = v0.hashCode() * 0x1F;
        Job v1 = this.getJob$kotlinx_coroutines_core();
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0_1 = (v0_1 + v1_1) * 0x1F;
        Throwable v3 = this.getCause();
        if(v3 != null) {
            v2 = v3.hashCode();
        }

        return v0_1 + v2;
    }

    public String toString() {
        return super.toString() + "; job=" + this.getJob$kotlinx_coroutines_core();
    }
}

