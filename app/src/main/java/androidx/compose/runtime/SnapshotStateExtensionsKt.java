package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007\u001A\u0012\u0010\u0004\u001A\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007\u001A\u0012\u0010\u0007\u001A\u00020\b*\b\u0012\u0004\u0012\u00020\t0\u0002H\u0007\u001A\u0012\u0010\n\u001A\u00020\u000B*\b\u0012\u0004\u0012\u00020\f0\u0002H\u0007¨\u0006\r"}, d2={"asIntState", "Landroidx/compose/runtime/IntState;", "Landroidx/compose/runtime/State;", "", "asLongState", "Landroidx/compose/runtime/LongState;", "", "asFloatState", "Landroidx/compose/runtime/FloatState;", "", "asDoubleState", "Landroidx/compose/runtime/DoubleState;", "", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SnapshotStateExtensionsKt {
    public static final DoubleState asDoubleState(State arg1) {
        if((arg1 instanceof DoubleState)) {
            return arg1;
        }

        return new UnboxedDoubleState(arg1);
    }

    public static final FloatState asFloatState(State arg1) {
        if((arg1 instanceof FloatState)) {
            return arg1;
        }

        return new UnboxedFloatState(arg1);
    }

    public static final IntState asIntState(State arg1) {
        if((arg1 instanceof IntState)) {
            return arg1;
        }

        return new UnboxedIntState(arg1);
    }

    public static final LongState asLongState(State arg1) {
        if((arg1 instanceof LongState)) {
            return arg1;
        }

        return new UnboxedLongState(arg1);
    }
}

