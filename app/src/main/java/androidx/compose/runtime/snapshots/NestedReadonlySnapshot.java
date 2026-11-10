package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.tooling.SnapshotInstanceObservers;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B9\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0014\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0006\u0010\u000B\u001A\u00020\u0001¢\u0006\u0004\b\f\u0010\rJ\u001E\u0010\u0018\u001A\u00020\u00002\u0014\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J\r\u0010\u0019\u001A\u00020\nH\u0010¢\u0006\u0002\b\u001AJ\b\u0010\u001B\u001A\u00020\u0013H\u0016J\b\u0010\u001C\u001A\u00020\nH\u0016J\u0015\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00020\u001FH\u0010¢\u0006\u0002\b\'J\u0015\u0010(\u001A\u00020%2\u0006\u0010)\u001A\u00020\u0001H\u0010¢\u0006\u0002\b*J\u0015\u0010+\u001A\u00020%2\u0006\u0010)\u001A\u00020\u0001H\u0010¢\u0006\u0002\b,R\"\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u000B\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001A\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0011R\u001C\u0010\u001D\u001A\n\u0012\u0004\u0012\u00020\u001F\u0018\u00010\u001E8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b \u0010!R\"\u0010\"\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b#\u0010\u000F¨\u0006-"}, d2={"Landroidx/compose/runtime/snapshots/NestedReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "parent", "<init>", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/Snapshot;)V", "getReadObserver$runtime", "()Lkotlin/jvm/functions/Function1;", "getParent", "()Landroidx/compose/runtime/snapshots/Snapshot;", "readOnly", "", "getReadOnly", "()Z", "root", "getRoot", "takeNestedSnapshot", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime", "hasPendingChanges", "dispose", "modified", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "getModified$runtime", "()Landroidx/collection/MutableScatterSet;", "writeObserver", "getWriteObserver$runtime", "recordModified", "", "state", "recordModified$runtime", "nestedDeactivated", "snapshot", "nestedDeactivated$runtime", "nestedActivated", "nestedActivated$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class NestedReadonlySnapshot extends Snapshot {
    public static final int $stable = 8;
    private final Snapshot parent;
    private final Function1 readObserver;

    static {
    }

    public NestedReadonlySnapshot(long arg2, SnapshotIdSet arg4, Function1 arg5, Snapshot arg6) {
        super(arg2, arg4, null);
        this.readObserver = arg5;
        this.parent = arg6;
        arg6.nestedActivated$runtime(((Snapshot)this));
    }

    public void dispose() {
        if(!this.getDisposed$runtime()) {
            if(this.getSnapshotId() != this.parent.getSnapshotId()) {
                this.closeAndReleasePinning$runtime();
            }

            this.parent.nestedDeactivated$runtime(this);
            super.dispose();
            SnapshotObserverKt.dispatchObserverOnPreDispose(this);
        }
    }

    public MutableScatterSet getModified$runtime() {
        return null;
    }

    public final Snapshot getParent() {
        return this.parent;
    }

    public Function1 getReadObserver() {
        return this.getReadObserver$runtime();
    }

    public Function1 getReadObserver$runtime() {
        return this.readObserver;
    }

    public boolean getReadOnly() {
        return 1;
    }

    public Snapshot getRoot() {
        return this.parent.getRoot();
    }

    public Function1 getWriteObserver$runtime() {
        return null;
    }

    public boolean hasPendingChanges() {
        return 0;
    }

    public Void nestedActivated$runtime(Snapshot arg1) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public void nestedActivated$runtime(Snapshot arg1) {
        this.nestedActivated$runtime(arg1);
    }

    public Void nestedDeactivated$runtime(Snapshot arg1) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public void nestedDeactivated$runtime(Snapshot arg1) {
        this.nestedDeactivated$runtime(arg1);
    }

    public void notifyObjectsInitialized$runtime() {
    }

    public Void recordModified$runtime(StateObject arg1) {
        SnapshotKt.access$reportReadonlySnapshotWrite();
        throw new KotlinNothingValueException();
    }

    public void recordModified$runtime(StateObject arg1) {
        this.recordModified$runtime(arg1);
    }

    public NestedReadonlySnapshot takeNestedSnapshot(Function1 arg12) {
        Map v3_1;
        NestedReadonlySnapshot v0 = this;
        PersistentList v1 = SnapshotObserverKt.access$getObservers$p();
        Function1 v2 = null;
        if(v1 != null) {
            Pair v12 = SnapshotObserverKt.mergeObservers(v1, ((Snapshot)v0), true, arg12, v2);
            Object v3 = v12.getFirst();
            Function1 v4 = ((SnapshotInstanceObservers)v3).getReadObserver();
            ((SnapshotInstanceObservers)v3).getWriteObserver();
            v3 = v12.getSecond();
            arg12 = v4;
        }
        else {
            v3_1 = ((Map)v2);
        }

        NestedReadonlySnapshot v4_1 = new NestedReadonlySnapshot(this.getSnapshotId(), this.getInvalid$runtime(), SnapshotKt.mergedReadObserver$default(arg12, this.getReadObserver$runtime(), false, 4, v2), this.getParent());
        if(v1 != null) {
            SnapshotObserverKt.dispatchCreatedObservers(v1, ((Snapshot)v0), ((Snapshot)v4_1), v3_1);
        }

        return v4_1;
    }

    public Snapshot takeNestedSnapshot(Function1 arg1) {
        return this.takeNestedSnapshot(arg1);
    }
}

