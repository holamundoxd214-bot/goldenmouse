package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001A\u00020\u000EH\u0016R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/UnboxedFloatState;", "Landroidx/compose/runtime/FloatState;", "baseState", "Landroidx/compose/runtime/State;", "", "<init>", "(Landroidx/compose/runtime/State;)V", "floatValue", "getFloatValue", "()F", "value", "getValue", "()Ljava/lang/Float;", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class UnboxedFloatState implements FloatState {
    public static final int $stable;
    private final State baseState;

    static {
    }

    public UnboxedFloatState(State arg1) {
        super();
        this.baseState = arg1;
    }

    public float getFloatValue() {
        return this.baseState.getValue().floatValue();
    }

    public Float getValue() {
        return this.baseState.getValue();
    }

    public Object getValue() {
        return this.getValue();
    }

    public String toString() {
        return "UnboxedFloatState(baseState=" + this.baseState + ")@" + this.hashCode();
    }
}

