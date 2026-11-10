package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\b\u0000\u0012\n\u0010\u0003\u001A\u00060\u0004j\u0002`\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0002H\u0016J\b\u0010\u0017\u001A\u00020\u0002H\u0016J\u0019\u0010\u0017\u001A\u00020\u00022\n\u0010\u0003\u001A\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0002\u0010\u0018R \u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001A\u0010\u000E\u001A\u00020\u000FX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/snapshots/StateSetStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "set", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "<init>", "(JLandroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;)V", "getSet$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "setSet$runtime", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;)V", "modification", "", "getModification$runtime", "()I", "setModification$runtime", "(I)V", "assign", "", "value", "create", "(J)Landroidx/compose/runtime/snapshots/StateRecord;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class StateSetStateRecord extends StateRecord {
    public static final int $stable = 8;
    private int modification;
    private PersistentSet set;

    static {
    }

    public StateSetStateRecord(long arg1, PersistentSet arg3) {
        super(arg1);
        this.set = arg3;
    }

    public void assign(StateRecord arg3) {
        Object v0 = SnapshotStateSetKt.sync;
        __monitor_enter(v0);
        try {
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.StateSetStateRecord>");
            this.set = arg3.set;
            this.modification = ((StateSetStateRecord)arg3).modification;
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    public StateRecord create() {
        return new StateSetStateRecord(SnapshotKt.currentSnapshot().getSnapshotId(), this.set);
    }

    public StateRecord create(long arg2) {
        return new StateSetStateRecord(arg2, this.set);
    }

    public final int getModification$runtime() {
        return this.modification;
    }

    public final PersistentSet getSet$runtime() {
        return this.set;
    }

    public final void setModification$runtime(int arg1) {
        this.modification = arg1;
    }

    public final void setSet$runtime(PersistentSet arg1) {
        this.set = arg1;
    }
}

