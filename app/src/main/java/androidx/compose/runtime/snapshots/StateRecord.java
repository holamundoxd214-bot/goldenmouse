package androidx.compose.runtime.snapshots;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0002\b\u0004\b\'\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007B\u0011\b\u0017\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\u0005\u0010\nJ\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0000H&J\b\u0010\u0017\u001A\u00020\u0000H&J\u0010\u0010\u0017\u001A\u00020\u00002\u0006\u0010\u0002\u001A\u00020\tH\u0017J\u0019\u0010\u0017\u001A\u00020\u00002\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H\u0016¢\u0006\u0002\u0010\u0018R \u0010\u0002\u001A\u00060\u0003j\u0002`\u0004X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u000E\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u0006R\u001C\u0010\u000F\u001A\u0004\u0018\u00010\u0000X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/snapshots/StateRecord;", "", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "<init>", "(J)V", "()V", "id", "", "(I)V", "getSnapshotId$runtime", "()J", "setSnapshotId$runtime", "J", "next", "getNext$runtime", "()Landroidx/compose/runtime/snapshots/StateRecord;", "setNext$runtime", "(Landroidx/compose/runtime/snapshots/StateRecord;)V", "assign", "", "value", "create", "(J)Landroidx/compose/runtime/snapshots/StateRecord;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class StateRecord {
    public static final int $stable = 8;
    private StateRecord next;
    private long snapshotId;

    static {
    }

    public StateRecord() {
        this(SnapshotKt.currentSnapshot().getSnapshotId());
    }

    public StateRecord(long arg1) {
        super();
        this.snapshotId = arg1;
    }

    @Deprecated(message="Use snapshotId: Long constructor instead") public StateRecord(int arg3) {
        this(SnapshotId_jvmKt.toSnapshotId(arg3));
    }

    public abstract void assign(StateRecord arg1);

    public abstract StateRecord create();

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use snapshotId: Long version instead") public StateRecord create(int arg3) {
        this = this.create();
        this.snapshotId = SnapshotId_jvmKt.toSnapshotId(arg3);
        return this;
    }

    public StateRecord create(long arg1) {
        this = this.create();
        this.snapshotId = arg1;
        return this;
    }

    public final StateRecord getNext$runtime() {
        return this.next;
    }

    public final long getSnapshotId$runtime() {
        return this.snapshotId;
    }

    public final void setNext$runtime(StateRecord arg1) {
        this.next = arg1;
    }

    public final void setSnapshotId$runtime(long arg1) {
        this.snapshotId = arg1;
    }
}

