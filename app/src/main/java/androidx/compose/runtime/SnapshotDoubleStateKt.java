package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

@Metadata(d1={"androidx/compose/runtime/SnapshotDoubleStateKt__SnapshotDoubleStateKt"}, k=4, mv={2, 1, 0}, xi=0x30) public final class SnapshotDoubleStateKt {
    public static final double getValue(DoubleState arg0, Object arg1, KProperty arg2) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.getValue(arg0, arg1, arg2);
    }

    public static final MutableDoubleState mutableDoubleStateOf(double arg0) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.mutableDoubleStateOf(arg0);
    }

    public static final void setValue(MutableDoubleState arg0, Object arg1, KProperty arg2, double arg3) {
        SnapshotDoubleStateKt__SnapshotDoubleStateKt.setValue(arg0, arg1, arg2, arg3);
    }
}

