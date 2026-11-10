package androidx.lifecycle;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000B\u0010\b\u001A\u00028\u0000¢\u0006\u0002\u0010\tJ\u001B\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010\r\u001A\u00028\u0000¢\u0006\u0002\u0010\u000ER\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/lifecycle/AtomicReference;", "V", "", "initialValue", "<init>", "(Ljava/lang/Object;)V", "base", "Ljava/util/concurrent/atomic/AtomicReference;", "get", "()Ljava/lang/Object;", "compareAndSet", "", "expectedValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "lifecycle-common"}, k=1, mv={2, 1, 0}, xi=0x30) public final class AtomicReference {
    private final java.util.concurrent.atomic.AtomicReference base;

    public AtomicReference(Object arg2) {
        super();
        this.base = new java.util.concurrent.atomic.AtomicReference(arg2);
    }

    public final boolean compareAndSet(Object arg1, Object arg2) {
        return MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.base, arg1, arg2);
    }

    public final Object get() {
        return this.base.get();
    }
}

