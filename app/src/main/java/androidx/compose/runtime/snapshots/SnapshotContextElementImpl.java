package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ThreadContextElement;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u000B\u001A\u0004\u0018\u00010\u00032\u0006\u0010\f\u001A\u00020\rH\u0016J\u001A\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0003H\u0016R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\n¨\u0006\u0011"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotContextElementImpl;", "Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "Lkotlinx/coroutines/ThreadContextElement;", "Landroidx/compose/runtime/snapshots/Snapshot;", "snapshot", "<init>", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "updateThreadContext", "context", "Lkotlin/coroutines/CoroutineContext;", "restoreThreadContext", "", "oldState", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SnapshotContextElementImpl implements SnapshotContextElement, ThreadContextElement {
    public static final int $stable = 8;
    private final Snapshot snapshot;

    static {
    }

    public SnapshotContextElementImpl(Snapshot arg1) {
        super();
        this.snapshot = arg1;
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((SnapshotContextElement)this), arg1, arg2);
    }

    public Element get(Key arg1) {
        return DefaultImpls.get(((SnapshotContextElement)this), arg1);
    }

    public Key getKey() {
        return SnapshotContextElement.Key;
    }

    public CoroutineContext minusKey(Key arg1) {
        return DefaultImpls.minusKey(((SnapshotContextElement)this), arg1);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((SnapshotContextElement)this), arg1);
    }

    public void restoreThreadContext(CoroutineContext arg1, Snapshot arg2) {
        this.snapshot.unsafeLeave(arg2);
    }

    public void restoreThreadContext(CoroutineContext arg1, Object arg2) {
        this.restoreThreadContext(arg1, ((Snapshot)arg2));
    }

    public Snapshot updateThreadContext(CoroutineContext arg1) {
        return this.snapshot.unsafeEnter();
    }

    public Object updateThreadContext(CoroutineContext arg1) {
        return this.updateThreadContext(arg1);
    }
}

