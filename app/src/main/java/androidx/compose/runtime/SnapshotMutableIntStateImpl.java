package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.GlobalSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0011\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001&B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\u0016\u001A\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u0017J\u0015\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001A0\u0019H\u0096\u0002J\u0010\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0005\u001A\u00020\u000BH\u0016J\"\u0010\u001C\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u001D\u001A\u00020\u000B2\u0006\u0010\u001E\u001A\u00020\u000B2\u0006\u0010\u001F\u001A\u00020\u000BH\u0016J\b\u0010 \u001A\u00020!H\u0016R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR$\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00048V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0007R\u001A\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00040\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u001A\u0010\"\u001A\u00020\u00048GX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010$\u001A\u0004\b%\u0010\u0010¨\u0006\'"}, d2={"Landroidx/compose/runtime/SnapshotMutableIntStateImpl;", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/MutableIntState;", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "", "value", "<init>", "(I)V", "next", "Landroidx/compose/runtime/SnapshotMutableIntStateImpl$IntStateStateRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "intValue", "getIntValue", "()I", "setIntValue", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "component1", "()Ljava/lang/Integer;", "component2", "Lkotlin/Function1;", "", "prependStateRecord", "mergeRecords", "previous", "current", "applied", "toString", "", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "IntStateStateRecord", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public class SnapshotMutableIntStateImpl extends StateObjectImpl implements MutableIntState, SnapshotMutableState {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0005\u001A\u00020\u0001H\u0016J\b\u0010\u000F\u001A\u00020\u0001H\u0016J\u0019\u0010\u000F\u001A\u00020\u00012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H\u0016¢\u0006\u0002\u0010\u0010R\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\f¨\u0006\u0011"}, d2={"Landroidx/compose/runtime/SnapshotMutableIntStateImpl$IntStateStateRecord;", "Landroidx/compose/runtime/snapshots/StateRecord;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "value", "", "<init>", "(JI)V", "getValue", "()I", "setValue", "(I)V", "assign", "", "create", "(J)Landroidx/compose/runtime/snapshots/StateRecord;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class IntStateStateRecord extends StateRecord {
        private int value;

        public IntStateStateRecord(long arg1, int arg3) {
            super(arg1);
            this.value = arg3;
        }

        public void assign(StateRecord arg2) {
            Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
            this.value = ((IntStateStateRecord)arg2).value;
        }

        public StateRecord create() {
            return this.create(SnapshotKt.currentSnapshot().getSnapshotId());
        }

        public StateRecord create(long arg2) {
            return new IntStateStateRecord(arg2, this.value);
        }

        public final int getValue() {
            return this.value;
        }

        public final void setValue(int arg1) {
            this.value = arg1;
        }
    }

    public static final int $stable;
    private IntStateStateRecord next;

    static {
    }

    public SnapshotMutableIntStateImpl(int arg5) {
        super();
        Snapshot v0 = SnapshotKt.currentSnapshot();
        IntStateStateRecord v1 = new IntStateStateRecord(v0.getSnapshotId(), arg5);
        if(!(v0 instanceof GlobalSnapshot)) {
            v1.setNext$runtime(new IntStateStateRecord(SnapshotId_jvmKt.toSnapshotId(1), arg5));
        }

        this.next = v1;
    }

    public Integer component1() {
        return Integer.valueOf(this.getIntValue());
    }

    public Object component1() {
        return this.component1();
    }

    public Function1 component2() {
        return new SnapshotMutableIntStateImpl$$ExternalSyntheticLambda0(this);
    }

    static final Unit component2$lambda$0(SnapshotMutableIntStateImpl arg0, int arg1) {
        arg0.setIntValue(arg1);
        return Unit.INSTANCE;
    }

    public final int getDebuggerDisplayValue() {
        return SnapshotKt.current(this.next).getValue();
    }

    public static void getDebuggerDisplayValue$annotations() {
    }

    public StateRecord getFirstStateRecord() {
        return this.next;
    }

    public int getIntValue() {
        return SnapshotKt.readable(this.next, ((StateObject)this)).getValue();
    }

    public SnapshotMutationPolicy getPolicy() {
        return SnapshotStateKt.structuralEqualityPolicy();
    }

    public StateRecord mergeRecords(StateRecord arg1, StateRecord arg2, StateRecord arg3) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        if(arg2.getValue() == ((IntStateStateRecord)arg3).getValue()) {
            return arg2;
        }

        return null;
    }

    public void prependStateRecord(StateRecord arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        this.next = ((IntStateStateRecord)arg2);
    }

    public void setIntValue(int arg5) {
        Snapshot v3;
        StateRecord v0 = SnapshotKt.current(this.next);
        if(((IntStateStateRecord)v0).getValue() != arg5) {
            IntStateStateRecord v1 = this.next;
            Object v2 = SnapshotKt.getLock();
            __monitor_enter(v2);
            try {
                v3 = Snapshot.Companion.getCurrent();
                SnapshotKt.overwritableRecord(((StateRecord)v1), ((StateObject)this), v3, v0).setValue(arg5);
            }
            catch(Throwable v4) {
                __monitor_exit(v2);
                throw v4;
            }

            __monitor_exit(v2);
            SnapshotKt.notifyWrite(v3, ((StateObject)this));
            return;
        }
    }

    public String toString() {
        return "MutableIntState(value=" + SnapshotKt.current(this.next).getValue() + ")@" + this.hashCode();
    }
}

