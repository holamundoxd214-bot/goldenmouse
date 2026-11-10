package androidx.compose.ui.input.pointer;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Deprecated(message="Use PointerInputChange.isConsumed and PointerInputChange.consume() instead") @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u0005\u0010\tR\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R,\u0010\u0002\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u00038F@FX\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R,\u0010\u0004\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u00038F@FX\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\f\u001A\u0004\b\u0012\u0010\u000E\"\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2={"Landroidx/compose/ui/input/pointer/ConsumedData;", "", "positionChange", "", "downChange", "<init>", "(ZZ)V", "change", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "value", "getPositionChange$annotations", "()V", "getPositionChange", "()Z", "setPositionChange", "(Z)V", "getDownChange$annotations", "getDownChange", "setDownChange", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ConsumedData {
    public static final int $stable = 8;
    private PointerInputChange change;
    private boolean downChange;
    private boolean positionChange;

    static {
    }

    public ConsumedData() {
        this(false, false, 3, null);
    }

    public ConsumedData(boolean arg2, boolean arg3, int arg4, DefaultConstructorMarker arg5) {
        this(false, false);
    }

    public ConsumedData(PointerInputChange arg3) {
        this(arg3.getPositionChange$ui(), arg3.getDownChange$ui());
        this.change = arg3;
    }

    public ConsumedData(boolean arg1, boolean arg2) {
        super();
        this.positionChange = arg1;
        this.downChange = arg2;
    }

    public final boolean getDownChange() {
        PointerInputChange v0 = this.change;
        if(v0 != null) {
            v0 = v0.getConsumedDelegate$ui();
            if(v0 != null) {
                return v0.getDownChange$ui();
            }
        }

        v0 = this.change;
        if(v0 != null) {
            return v0.getDownChange$ui();
        }

        return this.downChange;
    }

    @Deprecated(message="Partial consumption was deprecated. Use PointerEvent.isConsumed and PointerEvent.consume() instead.") public static void getDownChange$annotations() {
    }

    public final boolean getPositionChange() {
        PointerInputChange v0 = this.change;
        if(v0 != null) {
            v0 = v0.getConsumedDelegate$ui();
            if(v0 != null) {
                return v0.getPositionChange$ui();
            }
        }

        v0 = this.change;
        if(v0 != null) {
            return v0.getPositionChange$ui();
        }

        return this.positionChange;
    }

    @Deprecated(message="Partial consumption was deprecated. Use PointerEvent.isConsumed and PointerEvent.consume() instead.") public static void getPositionChange$annotations() {
    }

    public final void setDownChange(boolean arg2) {
        PointerInputChange v0 = this.change;
        if(v0 != null) {
            v0 = v0.getConsumedDelegate$ui();
            if(v0 != null) {
                v0.setDownChange$ui(arg2);
            }
        }

        v0 = this.change;
        if(v0 != null) {
            v0.setDownChange$ui(arg2);
        }

        this.downChange = arg2;
    }

    public final void setPositionChange(boolean arg2) {
        PointerInputChange v0 = this.change;
        if(v0 != null) {
            v0 = v0.getConsumedDelegate$ui();
            if(v0 != null) {
                v0.setPositionChange$ui(arg2);
            }
        }

        v0 = this.change;
        if(v0 != null) {
            v0.setPositionChange$ui(arg2);
        }

        this.positionChange = arg2;
    }
}

