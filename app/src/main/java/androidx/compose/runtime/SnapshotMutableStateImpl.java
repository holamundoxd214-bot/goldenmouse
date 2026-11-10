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

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001%B\u001D\u0012\u0006\u0010\u0004\u001A\u00028\u0000\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0004\u001A\u00020\u0014H\u0016J\"\u0010\u0019\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u001A\u001A\u00020\u00142\u0006\u0010\u001B\u001A\u00020\u00142\u0006\u0010\u001C\u001A\u00020\u0014H\u0016J\b\u0010\u001D\u001A\u00020\u001EH\u0016J\u000E\u0010\u001F\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000EJ\u0015\u0010 \u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00180!H\u0096\u0002R\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR*\u0010\u0004\u001A\u00028\u00002\u0006\u0010\u0004\u001A\u00028\u00008V@VX\u0096\u000E¢\u0006\u0012\u0012\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001A\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R\u0017\u0010\"\u001A\u00028\u00008G¢\u0006\f\u0012\u0004\b#\u0010\f\u001A\u0004\b$\u0010\u000E¨\u0006&"}, d2={"Landroidx/compose/runtime/SnapshotMutableStateImpl;", "T", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "value", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "<init>", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "next", "Landroidx/compose/runtime/SnapshotMutableStateImpl$StateStateRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "prependStateRecord", "", "mergeRecords", "previous", "current", "applied", "toString", "", "component1", "component2", "Lkotlin/Function1;", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "StateStateRecord", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public class SnapshotMutableStateImpl extends StateObjectImpl implements SnapshotMutableState {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u001B\u0012\n\u0010\u0003\u001A\u00060\u0004j\u0002`\u0005\u0012\u0006\u0010\u0006\u001A\u00028\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0002H\u0016J\u000E\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000H\u0016J\u001F\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00010\u00002\n\u0010\u0003\u001A\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0002\u0010\rR\u001C\u0010\u000B\u001A\u00028\u0001X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0012\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2={"Landroidx/compose/runtime/SnapshotMutableStateImpl$StateStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "myValue", "<init>", "(JLjava/lang/Object;)V", "assign", "", "value", "create", "(J)Landroidx/compose/runtime/SnapshotMutableStateImpl$StateStateRecord;", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class StateStateRecord extends StateRecord {
        private Object value;

        public StateStateRecord(long arg1, Object arg3) {
            super(arg1);
            this.value = arg3;
        }

        public void assign(StateRecord arg2) {
            Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord>");
            this.value = ((StateStateRecord)arg2).value;
        }

        public StateStateRecord create(long arg3) {
            return new StateStateRecord(SnapshotKt.currentSnapshot().getSnapshotId(), this.value);
        }

        public StateStateRecord create() {
            return new StateStateRecord(SnapshotKt.currentSnapshot().getSnapshotId(), this.value);
        }

        public StateRecord create() {
            return this.create();
        }

        public StateRecord create(long arg1) {
            return this.create(arg1);
        }

        public final Object getValue() {
            return this.value;
        }

        public final void setValue(Object arg1) {
            this.value = arg1;
        }
    }

    public static final int $stable;
    private StateStateRecord next;
    private final SnapshotMutationPolicy policy;

    static {
    }

    public SnapshotMutableStateImpl(Object arg4, SnapshotMutationPolicy arg5) {
        super();
        this.policy = arg5;
        Snapshot v5 = SnapshotKt.currentSnapshot();
        StateStateRecord v0 = new StateStateRecord(v5.getSnapshotId(), arg4);
        if(!(v5 instanceof GlobalSnapshot)) {
            v0.setNext$runtime(new StateStateRecord(SnapshotId_jvmKt.toSnapshotId(1), arg4));
        }

        this.next = v0;
    }

    public Object component1() {
        return this.getValue();
    }

    public Function1 component2() {
        return new SnapshotMutableStateImpl$$ExternalSyntheticLambda0(this);
    }

    static final Unit component2$lambda$0(SnapshotMutableStateImpl arg0, Object arg1) {
        arg0.setValue(arg1);
        return Unit.INSTANCE;
    }

    public final Object getDebuggerDisplayValue() {
        return SnapshotKt.current(this.next).getValue();
    }

    public static void getDebuggerDisplayValue$annotations() {
    }

    public StateRecord getFirstStateRecord() {
        return this.next;
    }

    public SnapshotMutationPolicy getPolicy() {
        return this.policy;
    }

    public Object getValue() {
        return SnapshotKt.readable(this.next, ((StateObject)this)).getValue();
    }

    public static void getValue$annotations() {
    }

    public StateRecord mergeRecords(StateRecord arg5, StateRecord arg6, StateRecord arg7) {
        StateStateRecord v5;
        Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        Intrinsics.checkNotNull(arg6, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        StateRecord v1 = arg6;
        Intrinsics.checkNotNull(arg7, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        if(this.getPolicy().equivalent(((StateStateRecord)v1).getValue(), ((StateStateRecord)arg7).getValue())) {
            return arg6;
        }

        Object v4 = this.getPolicy().merge(((StateStateRecord)arg5).getValue(), ((StateStateRecord)v1).getValue(), ((StateStateRecord)arg7).getValue());
        if(v4 != null) {
            v5 = ((StateStateRecord)arg7).create(((StateStateRecord)arg7).getSnapshotId$runtime());
            v5.setValue(v4);
        }
        else {
            arg5 = null;
        }

        return ((StateRecord)v5);
    }

    public void prependStateRecord(StateRecord arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        this.next = ((StateStateRecord)arg2);
    }

    public void setValue(Object arg5) {
        Snapshot v3;
        StateRecord v0 = SnapshotKt.current(this.next);
        if(!this.getPolicy().equivalent(((StateStateRecord)v0).getValue(), arg5)) {
            StateStateRecord v1 = this.next;
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
        return "MutableState(value=" + SnapshotKt.current(this.next).getValue() + ")@" + this.hashCode();
    }
}

