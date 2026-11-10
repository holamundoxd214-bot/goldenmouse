package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b!\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\r\u001A\u00020\u0001H ¢\u0006\u0002\b\u000EJ\'\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\u00102\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\fH ¢\u0006\u0002\b\u0011J\u001B\u0010\u0012\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\fH ¢\u0006\u0002\b\u0013J\r\u0010\u0014\u001A\u00020\nH ¢\u0006\u0002\b\u0015J1\u0010\u0016\u001A\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\f2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\u00170\u0019H\u0000¢\u0006\u0004\b\u001A\u0010\u001BJ\u001B\u0010\u001C\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\fH\u0000¢\u0006\u0002\b\u001DJ\r\u0010\u001E\u001A\u00020\nH ¢\u0006\u0002\b\u001FR\u001A\u0010\u0004\u001A\u00060\u0001j\u0002`\u0005X\u0084\u0004¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007¨\u0006 "}, d2={"Landroidx/compose/runtime/SnapshotFlowManagerImpl;", "", "<init>", "()V", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "getLock", "()Ljava/lang/Object;", "Ljava/lang/Object;", "watch", "", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "obj", "watch$runtime", "readObserverFor", "Lkotlin/Function1;", "readObserverFor$runtime", "clearWatchSet", "clearWatchSet$runtime", "commitSubscriptionChanges", "commitSubscriptionChanges$runtime", "runAndWatch", "T", "block", "Lkotlin/Function0;", "runAndWatch$runtime", "(Lkotlinx/coroutines/channels/SendChannel;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "reportSnapshotFlowCancellation", "reportSnapshotFlowCancellation$runtime", "dispose", "dispose$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class SnapshotFlowManagerImpl {
    public static final int $stable = 8;
    private final Object lock;

    static {
    }

    public SnapshotFlowManagerImpl() {
        super();
        this.lock = new Object();
    }

    public abstract void clearWatchSet$runtime(SendChannel arg1);

    public abstract void commitSubscriptionChanges$runtime();

    public abstract void dispose$runtime();

    protected final Object getLock() {
        return this.lock;
    }

    public abstract Function1 readObserverFor$runtime(SendChannel arg1);

    public final void reportSnapshotFlowCancellation$runtime(SendChannel arg1) {
        this.clearWatchSet$runtime(arg1);
        this.commitSubscriptionChanges$runtime();
    }

    public final Object runAndWatch$runtime(SendChannel arg3, Function0 arg4) {
        Object v4;
        Snapshot v3;
        Snapshot v0 = Snapshot.Companion.takeSnapshot(this.readObserverFor$runtime(arg3));
        this.clearWatchSet$runtime(arg3);
        try {
            v3 = v0.makeCurrent();
        }
        catch(Throwable v2) {
            goto label_14;
        }

        try {
            v4 = arg4.invoke();
            goto label_6;
        }
        catch(Throwable v2) {
            try {
                v0.restoreCurrent(v3);
                throw v2;
            label_6:
                v0.restoreCurrent(v3);
            }
            catch(Throwable v2) {
            label_14:
                v0.dispose();
                throw v2;
            }
        }

        v0.dispose();
        this.commitSubscriptionChanges$runtime();
        return v4;
    }

    public abstract void watch$runtime(SendChannel arg1, Object arg2);
}

