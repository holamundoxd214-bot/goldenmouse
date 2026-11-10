package androidx.compose.runtime.snapshots.tooling;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0016\b\u0002\u0010\u0002\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001F\u0010\u0002\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u001F\u0010\u0005\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\t¨\u0006\u000B"}, d2={"Landroidx/compose/runtime/snapshots/tooling/SnapshotInstanceObservers;", "", "readObserver", "Lkotlin/Function1;", "", "writeObserver", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getReadObserver", "()Lkotlin/jvm/functions/Function1;", "getWriteObserver", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SnapshotInstanceObservers {
    public static final int $stable;
    private final Function1 readObserver;
    private final Function1 writeObserver;

    static {
    }

    public SnapshotInstanceObservers() {
        this(null, null, 3, null);
    }

    public SnapshotInstanceObservers(Function1 arg2, Function1 arg3, int arg4, DefaultConstructorMarker arg5) {
        Function1 v0 = null;
        if((arg4 & 1) != 0) {
            arg2 = v0;
        }

        if((arg4 & 2) != 0) {
            arg3 = v0;
        }

        this(arg2, arg3);
    }

    public SnapshotInstanceObservers(Function1 arg1, Function1 arg2) {
        super();
        this.readObserver = arg1;
        this.writeObserver = arg2;
    }

    public final Function1 getReadObserver() {
        return this.readObserver;
    }

    public final Function1 getWriteObserver() {
        return this.writeObserver;
    }
}

