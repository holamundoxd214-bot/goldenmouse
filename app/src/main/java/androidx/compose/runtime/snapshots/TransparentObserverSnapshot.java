package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.internal.Thread_jvmKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u0001\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0001\u0012\u0014\u0010\u0003\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u001C\u001A\u00020\u0006H\u0016J\b\u0010)\u001A\u00020\bH\u0016J\u0015\u00104\u001A\u00020\u00062\u0006\u00105\u001A\u00020+H\u0010¢\u0006\u0002\b6J\u001E\u00107\u001A\u00020\u00012\u0014\u0010\f\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\r\u00108\u001A\u00020\u0006H\u0010¢\u0006\u0002\b9J\u0015\u0010:\u001A\u00020;2\u0006\u0010<\u001A\u00020\u0001H\u0010¢\u0006\u0002\b=J\u0015\u0010>\u001A\u00020;2\u0006\u0010<\u001A\u00020\u0001H\u0010¢\u0006\u0002\b?R\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0090\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\"\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000ER\u0014\u0010\u0013\u001A\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0019R,\u0010\u001F\u001A\u00060\u0014j\u0002`\u001E2\n\u0010\u001D\u001A\u00060\u0014j\u0002`\u001E8V@PX\u0096\u000E¢\u0006\f\u001A\u0004\b \u0010\u0016\"\u0004\b!\u0010\"R$\u0010$\u001A\u00020#2\u0006\u0010\u001D\u001A\u00020#8P@PX\u0090\u000E¢\u0006\f\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(R4\u0010,\u001A\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\u000E\u0010\u001D\u001A\n\u0012\u0004\u0012\u00020+\u0018\u00010*8P@PX\u0090\u000E¢\u0006\f\u001A\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b2\u00103¨\u0006@"}, d2={"Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "parentSnapshot", "specifiedReadObserver", "Lkotlin/Function1;", "", "", "mergeParentObservers", "", "ownsParentSnapshot", "<init>", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;ZZ)V", "readObserver", "getReadObserver$runtime", "()Lkotlin/jvm/functions/Function1;", "setReadObserver$runtime", "(Lkotlin/jvm/functions/Function1;)V", "writeObserver", "getWriteObserver$runtime", "threadId", "", "getThreadId$runtime", "()J", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "currentSnapshot", "getCurrentSnapshot", "dispose", "value", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", "getSnapshotId", "setSnapshotId$runtime", "(J)V", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "getInvalid$runtime", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "hasPendingChanges", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "modified", "getModified$runtime", "()Landroidx/collection/MutableScatterSet;", "setModified$runtime", "(Landroidx/collection/MutableScatterSet;)V", "readOnly", "getReadOnly", "()Z", "recordModified", "state", "recordModified$runtime", "takeNestedSnapshot", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime", "nestedActivated", "", "snapshot", "nestedActivated$runtime", "nestedDeactivated", "nestedDeactivated$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class TransparentObserverSnapshot extends Snapshot {
    public static final int $stable = 8;
    private final boolean mergeParentObservers;
    private final boolean ownsParentSnapshot;
    private final Snapshot parentSnapshot;
    private Function1 readObserver;
    private final Snapshot root;
    private final long threadId;
    private final Function1 writeObserver;

    static {
    }

    public TransparentObserverSnapshot(Snapshot arg5, Function1 arg6, boolean arg7, boolean arg8) {
        Function1 v5;
        super(SnapshotKt.INVALID_SNAPSHOT, SnapshotIdSet.Companion.getEMPTY(), null);
        this.parentSnapshot = arg5;
        this.mergeParentObservers = arg7;
        this.ownsParentSnapshot = arg8;
        if(arg5 != null) {
            v5 = arg5.getReadObserver();
            if(v5 == null) {
                goto label_11;
            }
        }
        else {
        label_11:
            v5 = SnapshotKt.globalSnapshot.getReadObserver$runtime();
        }

        this.readObserver = SnapshotKt.mergedReadObserver(arg6, v5, arg7);
        this.threadId = Thread_jvmKt.currentThreadId();
        this.root = this;
    }

    public void dispose() {
        this.setDisposed$runtime(true);
        if(this.ownsParentSnapshot) {
            Snapshot v1 = this.parentSnapshot;
            if(v1 != null) {
                v1.dispose();
            }
        }
    }

    private final Snapshot getCurrentSnapshot() {
        GlobalSnapshot v0_1;
        Snapshot v0 = this.parentSnapshot;
        if(v0 == null) {
            v0_1 = SnapshotKt.globalSnapshot;
        }

        return ((Snapshot)v0_1);
    }

    public SnapshotIdSet getInvalid$runtime() {
        return this.getCurrentSnapshot().getInvalid$runtime();
    }

    public MutableScatterSet getModified$runtime() {
        return this.getCurrentSnapshot().getModified$runtime();
    }

    public Function1 getReadObserver() {
        return this.getReadObserver$runtime();
    }

    public Function1 getReadObserver$runtime() {
        return this.readObserver;
    }

    public boolean getReadOnly() {
        return this.getCurrentSnapshot().getReadOnly();
    }

    public Snapshot getRoot() {
        return this.root;
    }

    public long getSnapshotId() {
        return this.getCurrentSnapshot().getSnapshotId();
    }

    public final long getThreadId$runtime() {
        return this.threadId;
    }

    public Function1 getWriteObserver$runtime() {
        return this.writeObserver;
    }

    public boolean hasPendingChanges() {
        return this.getCurrentSnapshot().hasPendingChanges();
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
        this.getCurrentSnapshot().notifyObjectsInitialized$runtime();
    }

    public void recordModified$runtime(StateObject arg1) {
        this.getCurrentSnapshot().recordModified$runtime(arg1);
    }

    public void setInvalid$runtime(SnapshotIdSet arg1) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public void setModified$runtime(MutableScatterSet arg1) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public void setReadObserver$runtime(Function1 arg1) {
        this.readObserver = arg1;
    }

    public void setSnapshotId$runtime(long arg1) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public Snapshot takeNestedSnapshot(Function1 arg5) {
        Object v3 = null;
        arg5 = SnapshotKt.mergedReadObserver$default(arg5, this.getReadObserver$runtime(), false, 4, v3);
        if(!this.mergeParentObservers) {
            return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(this.getCurrentSnapshot().takeNestedSnapshot(((Function1)v3)), arg5, true);
        }

        return this.getCurrentSnapshot().takeNestedSnapshot(arg5);
    }
}

