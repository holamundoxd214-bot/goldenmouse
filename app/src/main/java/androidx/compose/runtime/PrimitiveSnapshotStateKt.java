package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

@Metadata(d1={"androidx/compose/runtime/PrimitiveSnapshotStateKt__SnapshotFloatStateKt"}, k=4, mv={2, 1, 0}, xi=0x30) public final class PrimitiveSnapshotStateKt {
    public static final float getValue(FloatState arg0, Object arg1, KProperty arg2) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.getValue(arg0, arg1, arg2);
    }

    public static final MutableFloatState mutableFloatStateOf(float arg0) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.mutableFloatStateOf(arg0);
    }

    public static final void setValue(MutableFloatState arg0, Object arg1, KProperty arg2, float arg3) {
        PrimitiveSnapshotStateKt__SnapshotFloatStateKt.setValue(arg0, arg1, arg2, arg3);
    }
}

