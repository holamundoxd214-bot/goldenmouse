package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.internal.Thread_jvmKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0001\u0012\u0014\u0010\u0003\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0014\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010\u001C\u001A\u00020\u0006H\u0016J\b\u0010)\u001A\u00020\tH\u0016J\b\u0010:\u001A\u00020;H\u0016J\u0015\u0010<\u001A\u00020\u00062\u0006\u0010=\u001A\u00020+H\u0010¢\u0006\u0002\b>J\u001E\u0010?\u001A\u00020@2\u0014\u0010\r\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J4\u0010A\u001A\u00020\u00012\u0014\u0010\r\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u0010\u0012\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\r\u0010B\u001A\u00020\u0006H\u0010¢\u0006\u0002\bCJ\u0015\u0010D\u001A\u00020E2\u0006\u0010F\u001A\u00020@H\u0010¢\u0006\u0002\bGJ\u0015\u0010H\u001A\u00020E2\u0006\u0010F\u001A\u00020@H\u0010¢\u0006\u0002\bIR\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0090\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0090\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u000F\"\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001A\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001A\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR,\u0010\u001F\u001A\u00060\u0016j\u0002`\u001E2\n\u0010\u001D\u001A\u00060\u0016j\u0002`\u001E8V@PX\u0096\u000E¢\u0006\f\u001A\u0004\b \u0010\u0018\"\u0004\b!\u0010\"R$\u0010$\u001A\u00020#2\u0006\u0010\u001D\u001A\u00020#8P@PX\u0090\u000E¢\u0006\f\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(R4\u0010,\u001A\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\u000E\u0010\u001D\u001A\n\u0012\u0004\u0012\u00020+\u0018\u00010*8P@PX\u0090\u000E¢\u0006\f\u001A\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00102\u001A\u0002012\u0006\u0010\u001D\u001A\u0002018P@PX\u0090\u000E¢\u0006\f\u001A\u0004\b3\u00104\"\u0004\b5\u00106R\u0014\u00107\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b8\u00109¨\u0006J"}, d2={"Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "parentSnapshot", "specifiedReadObserver", "Lkotlin/Function1;", "", "", "specifiedWriteObserver", "mergeParentObservers", "", "ownsParentSnapshot", "<init>", "(Landroidx/compose/runtime/snapshots/MutableSnapshot;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZZ)V", "readObserver", "getReadObserver$runtime", "()Lkotlin/jvm/functions/Function1;", "setReadObserver$runtime", "(Lkotlin/jvm/functions/Function1;)V", "writeObserver", "getWriteObserver$runtime", "setWriteObserver$runtime", "threadId", "", "getThreadId$runtime", "()J", "currentSnapshot", "getCurrentSnapshot", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "dispose", "value", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", "getSnapshotId", "setSnapshotId$runtime", "(J)V", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "getInvalid$runtime", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "hasPendingChanges", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "modified", "getModified$runtime", "()Landroidx/collection/MutableScatterSet;", "setModified$runtime", "(Landroidx/collection/MutableScatterSet;)V", "", "writeCount", "getWriteCount$runtime", "()I", "setWriteCount$runtime", "(I)V", "readOnly", "getReadOnly", "()Z", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "recordModified", "state", "recordModified$runtime", "takeNestedSnapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "takeNestedMutableSnapshot", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime", "nestedActivated", "", "snapshot", "nestedActivated$runtime", "nestedDeactivated", "nestedDeactivated$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class TransparentObserverMutableSnapshot extends MutableSnapshot {
    public static final int $stable = 8;
    private final boolean mergeParentObservers;
    private final boolean ownsParentSnapshot;
    private final MutableSnapshot parentSnapshot;
    private Function1 readObserver;
    private final long threadId;
    private Function1 writeObserver;

    static {
    }

    public TransparentObserverMutableSnapshot(MutableSnapshot arg7, Function1 arg8, Function1 arg9, boolean arg10, boolean arg11) {
        Function1 v0;
        long v1 = SnapshotKt.INVALID_SNAPSHOT;
        SnapshotIdSet v3 = SnapshotIdSet.Companion.getEMPTY();
        if(arg7 != null) {
            v0 = arg7.getReadObserver$runtime();
            if(v0 == null) {
                goto label_6;
            }
        }
        else {
        label_6:
            v0 = SnapshotKt.globalSnapshot.getReadObserver$runtime();
        }

        Function1 v4 = SnapshotKt.mergedReadObserver(arg8, v0, arg10);
        if(arg7 != null) {
            arg8 = arg7.getWriteObserver$runtime();
            if(arg8 == null) {
                goto label_12;
            }
        }
        else {
        label_12:
            arg8 = SnapshotKt.globalSnapshot.getWriteObserver$runtime();
        }

        super(v1, v3, v4, SnapshotKt.mergedWriteObserver(arg9, arg8));
        this.parentSnapshot = arg7;
        this.mergeParentObservers = arg10;
        this.ownsParentSnapshot = arg11;
        this.readObserver = super.getReadObserver$runtime();
        this.writeObserver = super.getWriteObserver$runtime();
        this.threadId = Thread_jvmKt.currentThreadId();
    }

    public SnapshotApplyResult apply() {
        return this.getCurrentSnapshot().apply();
    }

    public void dispose() {
        this.setDisposed$runtime(true);
        if(this.ownsParentSnapshot) {
            MutableSnapshot v1 = this.parentSnapshot;
            if(v1 != null) {
                v1.dispose();
            }
        }
    }

    private final MutableSnapshot getCurrentSnapshot() {
        GlobalSnapshot v0_1;
        MutableSnapshot v0 = this.parentSnapshot;
        if(v0 == null) {
            v0_1 = SnapshotKt.globalSnapshot;
        }

        return ((MutableSnapshot)v0_1);
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

    public long getSnapshotId() {
        return this.getCurrentSnapshot().getSnapshotId();
    }

    public final long getThreadId$runtime() {
        return this.threadId;
    }

    public int getWriteCount$runtime() {
        return this.getCurrentSnapshot().getWriteCount$runtime();
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

    public void setWriteCount$runtime(int arg1) {
        this.getCurrentSnapshot().setWriteCount$runtime(arg1);
    }

    public void setWriteObserver$runtime(Function1 arg1) {
        this.writeObserver = arg1;
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1 arg11, Function1 arg12) {
        Object v3 = null;
        Function1 v6 = SnapshotKt.mergedReadObserver$default(arg11, this.getReadObserver$runtime(), false, 4, v3);
        Function1 v7 = SnapshotKt.mergedWriteObserver(arg12, this.getWriteObserver$runtime());
        if(!this.mergeParentObservers) {
            return new TransparentObserverMutableSnapshot(this.getCurrentSnapshot().takeNestedMutableSnapshot(((Function1)v3), v7), v6, v7, false, true);
        }

        return this.getCurrentSnapshot().takeNestedMutableSnapshot(v6, v7);
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

