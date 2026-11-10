package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\b\u0000\u0012\n\u0010\u0003\u001A\u00060\u0004j\u0002`\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0002H\u0016J\b\u0010\u001A\u001A\u00020\u0002H\u0016J\u0019\u0010\u001A\u001A\u00020\u00022\n\u0010\u0003\u001A\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0002\u0010\u001BR \u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001A\u0010\u000E\u001A\u00020\u000FX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0014\u001A\u00020\u000FX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u001C"}, d2={"Landroidx/compose/runtime/snapshots/StateListStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "list", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "<init>", "(JLandroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "getList$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "setList$runtime", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "modification", "", "getModification$runtime", "()I", "setModification$runtime", "(I)V", "structuralChange", "getStructuralChange$runtime", "setStructuralChange$runtime", "assign", "", "value", "create", "(J)Landroidx/compose/runtime/snapshots/StateRecord;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class StateListStateRecord extends StateRecord {
    public static final int $stable = 8;
    private PersistentList list;
    private int modification;
    private int structuralChange;

    static {
    }

    public StateListStateRecord(long arg1, PersistentList arg3) {
        super(arg1);
        this.list = arg3;
    }

    public void assign(StateRecord arg3) {
        Object v0 = SnapshotStateListKt.sync;
        __monitor_enter(v0);
        try {
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.StateListStateRecord>");
            this.list = arg3.list;
            this.modification = arg3.modification;
            this.structuralChange = ((StateListStateRecord)arg3).structuralChange;
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    public StateRecord create() {
        return this.create(SnapshotKt.currentSnapshot().getSnapshotId());
    }

    public StateRecord create(long arg2) {
        return new StateListStateRecord(arg2, this.list);
    }

    public final PersistentList getList$runtime() {
        return this.list;
    }

    public final int getModification$runtime() {
        return this.modification;
    }

    public final int getStructuralChange$runtime() {
        return this.structuralChange;
    }

    public final void setList$runtime(PersistentList arg1) {
        this.list = arg1;
    }

    public final void setModification$runtime(int arg1) {
        this.modification = arg1;
    }

    public final void setStructuralChange$runtime(int arg1) {
        this.structuralChange = arg1;
    }
}

