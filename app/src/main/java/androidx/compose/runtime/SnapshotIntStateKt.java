package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

@Metadata(d1={"androidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt"}, k=4, mv={2, 1, 0}, xi=0x30) public final class SnapshotIntStateKt {
    public static final int getValue(IntState arg0, Object arg1, KProperty arg2) {
        return SnapshotIntStateKt__SnapshotIntStateKt.getValue(arg0, arg1, arg2);
    }

    public static final MutableIntState mutableIntStateOf(int arg0) {
        return SnapshotIntStateKt__SnapshotIntStateKt.mutableIntStateOf(arg0);
    }

    public static final void setValue(MutableIntState arg0, Object arg1, KProperty arg2, int arg3) {
        SnapshotIntStateKt__SnapshotIntStateKt.setValue(arg0, arg1, arg2, arg3);
    }
}

