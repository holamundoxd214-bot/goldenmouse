package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007\u001A#\u0010\u0004\u001A\u00020\u0003*\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\u0010\b\u001A\u0006\u0012\u0002\b\u00030\tH\u0086\n\u001A+\u0010\n\u001A\u00020\u000B*\u00020\u00012\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\u0010\b\u001A\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0002\u001A\u00020\u0003H\u0086\n¨\u0006\f"}, d2={"mutableLongStateOf", "Landroidx/compose/runtime/MutableLongState;", "value", "", "getValue", "Landroidx/compose/runtime/LongState;", "thisObj", "", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "runtime"}, k=5, mv={2, 1, 0}, xi=0x30, xs="androidx/compose/runtime/SnapshotLongStateKt") final class SnapshotLongStateKt__SnapshotLongStateKt {
    public static final long getValue(LongState arg0, Object arg1, KProperty arg2) {
        return arg0.getLongValue();
    }

    public static final MutableLongState mutableLongStateOf(long arg0) {
        return SnapshotLongState_androidKt.createSnapshotMutableLongState(arg0);
    }

    public static final void setValue(MutableLongState arg0, Object arg1, KProperty arg2, long arg3) {
        arg0.setLongValue(arg3);
    }
}

