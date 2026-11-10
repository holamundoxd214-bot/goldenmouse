package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BO\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0014\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0014\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0006\u0010\f\u001A\u00020\u0001¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010\u0017\u001A\u00020\nH\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\b\u0010\u001A\u001A\u00020\nH\u0002R\u0011\u0010\f\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001A\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u001B"}, d2={"Landroidx/compose/runtime/snapshots/NestedMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "parent", "<init>", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "getParent", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "deactivated", "", "root", "Landroidx/compose/runtime/snapshots/Snapshot;", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "dispose", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "deactivate", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class NestedMutableSnapshot extends MutableSnapshot {
    public static final int $stable = 8;
    private boolean deactivated;
    private final MutableSnapshot parent;

    static {
    }

    public NestedMutableSnapshot(long arg1, SnapshotIdSet arg3, Function1 arg4, Function1 arg5, MutableSnapshot arg6) {
        super(arg1, arg3, arg4, arg5);
        this.parent = arg6;
        arg6.nestedActivated$runtime(((Snapshot)this));
    }

    public SnapshotApplyResult apply() {
        SnapshotApplyResult v10;
        NestedMutableSnapshot v1;
        if(!this.parent.getApplied$runtime()) {
            if(this.parent.getDisposed$runtime()) {
            }
            else {
                MutableScatterSet v4 = this.getModified$runtime();
                long v7 = this.getSnapshotId();
                MutableScatterSet v0 = null;
                Map v5 = v4 != null ? SnapshotKt.access$optimisticMerges(this.parent.getSnapshotId(), this, this.parent.getInvalid$runtime()) : ((Map)v0);
                Object v9 = SnapshotKt.getLock();
                __monitor_enter(v9);
                try {
                    SnapshotKt.access$validateOpen(this);
                    if(v4 == null) {
                        goto label_49;
                    }
                    else if(v4.getSize() == 0) {
                        goto label_49;
                    }
                    else {
                        v1 = this;
                        v10 = v1.innerApplyLocked$runtime(this.parent.getSnapshotId(), v4, v5, this.parent.getInvalid$runtime());
                        if(!Intrinsics.areEqual(v10, Success.INSTANCE)) {
                            goto label_37;
                        }
                        else {
                            goto label_39;
                        }
                    }

                    goto label_52;
                }
                catch(Throwable v0_1) {
                    goto label_86;
                }

            label_37:
                __monitor_exit(v9);
                return v10;
                try {
                label_39:
                    MutableScatterSet v10_1 = v1.parent.getModified$runtime();
                    if(v10_1 != null) {
                        v10_1.addAll(v4);
                        if(v10_1 == null) {
                            goto label_45;
                        }
                    }
                    else {
                    label_45:
                        v1.parent.setModified$runtime(v4);
                        v1.setModified$runtime(v0);
                        goto label_52;
                    label_49:
                        v1 = this;
                        v1.closeAndReleasePinning$runtime();
                    }

                label_52:
                    if(Intrinsics.compare(v1.parent.getSnapshotId(), v7) < 0) {
                        v1.parent.advance$runtime();
                    }

                    v1.parent.setInvalid$runtime(v1.parent.getInvalid$runtime().clear(v7).andNot(v1.getPreviousIds$runtime()));
                    v1.parent.recordPrevious$runtime(v7);
                    v1.parent.recordPreviousPinnedSnapshot$runtime(v1.takeoverPinnedSnapshot$runtime());
                    v1.parent.recordPreviousList$runtime(v1.getPreviousIds$runtime());
                    v1.parent.recordPreviousPinnedSnapshots$runtime(v1.getPreviousPinnedSnapshots$runtime());
                }
                catch(Throwable v0_1) {
                label_86:
                    __monitor_exit(v9);
                    throw v0_1;
                }

                __monitor_exit(v9);
                v1.setApplied$runtime(true);
                v1.deactivate();
                SnapshotObserverKt.dispatchObserverOnApplied(v1, ((ScatterSet)v4));
                return Success.INSTANCE;
            }
        }

        return new Failure(this);
    }

    private final void deactivate() {
        if(!this.deactivated) {
            this.deactivated = true;
            this.parent.nestedDeactivated$runtime(((Snapshot)this));
        }
    }

    public void dispose() {
        if(!this.getDisposed$runtime()) {
            super.dispose();
            this.deactivate();
        }
    }

    public final MutableSnapshot getParent() {
        return this.parent;
    }

    public Snapshot getRoot() {
        return this.parent.getRoot();
    }
}

