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

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0001\u0018\u00002\u00020\u0001B3\b\u0000\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0014\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010\u0018\u001A\u00020\u0012H\u0016J\u001E\u0010#\u001A\u00020\u00012\u0014\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J\r\u0010$\u001A\u00020\nH\u0010¢\u0006\u0002\b%J\b\u0010&\u001A\u00020\nH\u0016J\u0015\u0010\'\u001A\u00020\n2\u0006\u0010(\u001A\u00020\u0001H\u0010¢\u0006\u0002\b)J\u0015\u0010*\u001A\u00020\n2\u0006\u0010(\u001A\u00020\u0001H\u0010¢\u0006\u0002\b+J\u0015\u0010,\u001A\u00020\n2\u0006\u0010-\u001A\u00020\u001DH\u0010¢\u0006\u0002\b.R\"\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001A\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001A\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u000ER4\u0010\u001E\u001A\n\u0012\u0004\u0012\u00020\u001D\u0018\u00010\u001C2\u000E\u0010\u001B\u001A\n\u0012\u0004\u0012\u00020\u001D\u0018\u00010\u001C8P@PX\u0090\u000E¢\u0006\f\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"¨\u0006/"}, d2={"Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "<init>", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;)V", "getReadObserver$runtime", "()Lkotlin/jvm/functions/Function1;", "snapshots", "", "readOnly", "", "getReadOnly", "()Z", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "hasPendingChanges", "writeObserver", "getWriteObserver$runtime", "value", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "modified", "getModified$runtime", "()Landroidx/collection/MutableScatterSet;", "setModified$runtime", "(Landroidx/collection/MutableScatterSet;)V", "takeNestedSnapshot", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime", "dispose", "nestedActivated", "snapshot", "nestedActivated$runtime", "nestedDeactivated", "nestedDeactivated$runtime", "recordModified", "state", "recordModified$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ReadonlySnapshot extends Snapshot {
    public static final int $stable = 8;
    private final Function1 readObserver;
    private int snapshots;

    static {
    }

    public ReadonlySnapshot(long arg2, SnapshotIdSet arg4, Function1 arg5) {
        super(arg2, arg4, null);
        this.readObserver = arg5;
        this.snapshots = 1;
    }

    public void dispose() {
        if(!this.getDisposed$runtime()) {
            this.nestedDeactivated$runtime(this);
            super.dispose();
            SnapshotObserverKt.dispatchObserverOnPreDispose(this);
        }
    }

    public MutableScatterSet getModified$runtime() {
        return null;
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
        return this;
    }

    public Function1 getWriteObserver$runtime() {
        return null;
    }

    public boolean hasPendingChanges() {
        return 0;
    }

    public void nestedActivated$runtime(Snapshot arg1) {
        ++this.snapshots;
    }

    public void nestedDeactivated$runtime(Snapshot arg1) {
        int v1 = this.snapshots - 1;
        this.snapshots = v1;
        if(v1 == 0) {
            this.closeAndReleasePinning$runtime();
        }
    }

    public void notifyObjectsInitialized$runtime() {
    }

    public void recordModified$runtime(StateObject arg1) {
        SnapshotKt.access$reportReadonlySnapshotWrite();
        throw new KotlinNothingValueException();
    }

    public void setModified$runtime(MutableScatterSet arg1) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public Snapshot takeNestedSnapshot(Function1 arg11) {
        Map v7_1;
        Function1 v1_1;
        ReadonlySnapshot v5 = this;
        SnapshotKt.access$validateOpen(((Snapshot)v5));
        PersistentList v6 = SnapshotObserverKt.access$getObservers$p();
        Function1 v0 = null;
        if(v6 != null) {
            Pair v11 = SnapshotObserverKt.mergeObservers(v6, ((Snapshot)v5), true, arg11, v0);
            Object v1 = v11.getFirst();
            Function1 v2 = ((SnapshotInstanceObservers)v1).getReadObserver();
            ((SnapshotInstanceObservers)v1).getWriteObserver();
            Object v7 = v11.getSecond();
            v1_1 = v0;
            arg11 = v2;
        }
        else {
            v1_1 = v0;
            v7_1 = ((Map)v1_1);
        }

        NestedReadonlySnapshot v0_1 = new NestedReadonlySnapshot(this.getSnapshotId(), this.getInvalid$runtime(), SnapshotKt.mergedReadObserver$default(arg11, this.getReadObserver$runtime(), false, 4, v1_1), ((Snapshot)v5));
        if(v6 != null) {
            SnapshotObserverKt.dispatchCreatedObservers(v6, ((Snapshot)v5), ((Snapshot)v0_1), v7_1);
        }

        return ((Snapshot)v0_1);
    }
}

