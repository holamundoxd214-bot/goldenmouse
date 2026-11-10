package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.tooling.SnapshotInstanceObservers;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001B\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001E\u0010\t\u001A\u00020\n2\u0014\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E\u0018\u00010\fH\u0016J4\u0010\u000F\u001A\u00020\u00012\u0014\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E\u0018\u00010\f2\u0014\u0010\u0010\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E\u0018\u00010\fH\u0016J\r\u0010\u0011\u001A\u00020\u000EH\u0010¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\nH\u0010¢\u0006\u0002\b\u0016J\u0015\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\nH\u0010¢\u0006\u0002\b\u0018J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\b\u0010\u001B\u001A\u00020\u000EH\u0016¨\u0006\u001C"}, d2={"Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "<init>", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "takeNestedSnapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readObserver", "Lkotlin/Function1;", "", "", "takeNestedMutableSnapshot", "writeObserver", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime", "nestedDeactivated", "", "snapshot", "nestedDeactivated$runtime", "nestedActivated", "nestedActivated$runtime", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "dispose", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class GlobalSnapshot extends MutableSnapshot {
    public static final int $stable = 8;

    static {
    }

    public GlobalSnapshot(long arg7, SnapshotIdSet arg9) {
        super(arg7, arg9, null, new GlobalSnapshot$$ExternalSyntheticLambda0());
    }

    static final Unit _init_$lambda$0(Object arg5) {
        Object v0 = SnapshotKt.getLock();
        __monitor_enter(v0);
        try {
            List v1 = SnapshotKt.access$getGlobalWriteObservers$p();
            int v2 = v1.size();
            int v3;
            for(v3 = 0; v3 < v2; ++v3) {
                v1.get(v3).invoke(arg5);
            }
        }
        catch(Throwable v5) {
            goto label_16;
        }

        __monitor_exit(v0);
        return Unit.INSTANCE;
    label_16:
        __monitor_exit(v0);
        throw v5;
    }

    public SnapshotApplyResult apply() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot".toString());
    }

    public void dispose() {
        Object v0 = SnapshotKt.getLock();
        __monitor_enter(v0);
        try {
            this.releasePinnedSnapshotLocked$runtime();
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
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
        SnapshotKt.access$advanceGlobalSnapshot();
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1 arg5, Function1 arg6) {
        Function1 v1;
        Object v6;
        PersistentList v4 = SnapshotObserverKt.access$getObservers$p();
        Snapshot v0 = null;
        if(v4 != null) {
            Pair v5 = SnapshotObserverKt.mergeObservers(v4, v0, false, arg5, arg6);
            v6 = v5.getFirst();
            v1 = ((SnapshotInstanceObservers)v6).getReadObserver();
            Function1 v3 = ((SnapshotInstanceObservers)v6).getWriteObserver();
            v6 = v5.getSecond();
            arg5 = v1;
            v1 = v3;
        }
        else {
            v1 = arg6;
            Map v6_1 = ((Map)v0);
        }

        Snapshot v5_1 = SnapshotKt.access$takeNewSnapshot(new GlobalSnapshot$takeNestedMutableSnapshot$1$1(arg5, v1));
        if(v4 != null) {
            SnapshotObserverKt.dispatchCreatedObservers(v4, v0, v5_1, ((Map)v6));
        }

        return ((MutableSnapshot)v5_1);
    }

    public Snapshot takeNestedSnapshot(Function1 arg4) {
        Map v1_1;
        PersistentList v3 = SnapshotObserverKt.access$getObservers$p();
        Snapshot v0 = null;
        if(v3 != null) {
            Pair v4 = SnapshotObserverKt.mergeObservers(v3, v0, true, arg4, ((Function1)v0));
            Object v1 = v4.getFirst();
            Function1 v2 = ((SnapshotInstanceObservers)v1).getReadObserver();
            ((SnapshotInstanceObservers)v1).getWriteObserver();
            v1 = v4.getSecond();
            arg4 = v2;
        }
        else {
            v1_1 = ((Map)v0);
        }

        Snapshot v4_1 = SnapshotKt.access$takeNewSnapshot(new GlobalSnapshot$takeNestedSnapshot$1$1(arg4));
        if(v3 != null) {
            SnapshotObserverKt.dispatchCreatedObservers(v3, v0, v4_1, v1_1);
        }

        return v4_1;
    }
}

