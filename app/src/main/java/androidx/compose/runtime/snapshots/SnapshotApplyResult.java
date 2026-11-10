package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\n\u000BB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H&R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t\u0082\u0001\u0002\f\r¨\u0006\u000E"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "", "<init>", "()V", "check", "", "succeeded", "", "getSucceeded", "()Z", "Success", "Failure", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult$Failure;", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult$Success;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class SnapshotApplyResult {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001A\u00020\tH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotApplyResult$Failure;", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "<init>", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "getSnapshot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "check", "", "succeeded", "", "getSucceeded", "()Z", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Failure extends SnapshotApplyResult {
        public static final int $stable = 8;
        private final Snapshot snapshot;

        static {
        }

        public Failure(Snapshot arg2) {
            super(null);
            this.snapshot = arg2;
        }

        public void check() {
            this.snapshot.dispose();
            throw new SnapshotApplyConflictException(this.snapshot);
        }

        public final Snapshot getSnapshot() {
            return this.snapshot;
        }

        public boolean getSucceeded() {
            return 0;
        }
    }

    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotApplyResult$Success;", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "<init>", "()V", "check", "", "succeeded", "", "getSucceeded", "()Z", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Success extends SnapshotApplyResult {
        public static final int $stable;
        public static final Success INSTANCE;

        static {
            Success.INSTANCE = new Success();
        }

        private Success() {
            super(null);
        }

        public void check() {
        }

        public boolean getSucceeded() {
            return 1;
        }
    }

    public static final int $stable;

    static {
    }

    private SnapshotApplyResult() {
        super();
    }

    public SnapshotApplyResult(DefaultConstructorMarker arg1) {
        this();
    }

    public abstract void check();

    public abstract boolean getSucceeded();
}

