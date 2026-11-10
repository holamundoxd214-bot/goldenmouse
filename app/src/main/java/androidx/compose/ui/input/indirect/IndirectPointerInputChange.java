package androidx.compose.ui.input.indirect;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerId;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\u0005\u0012\u0006\u0010\r\u001A\u00020\u0007\u0012\u0006\u0010\u000E\u001A\u00020\t¢\u0006\u0004\b\u000F\u0010\u0010J\u0006\u0010\u001F\u001A\u00020 J\b\u0010!\u001A\u00020\"H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0015\u0010\u0012R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0012R\u0013\u0010\r\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u001B\u0010\u0012R\u0011\u0010\u000E\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0017R\u001E\u0010\u001E\u001A\u00020\t2\u0006\u0010\u001D\u001A\u00020\t@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0017¨\u0006#"}, d2={"Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptimeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "pressed", "", "pressure", "", "previousUptimeMillis", "previousPosition", "previousPressed", "<init>", "(JJJZFJJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getId-J3iCeTQ", "()J", "J", "getUptimeMillis", "getPosition-F1C5BW0", "getPressed", "()Z", "getPressure", "()F", "getPreviousUptimeMillis", "getPreviousPosition-F1C5BW0", "getPreviousPressed", "value", "isConsumed", "consume", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class IndirectPointerInputChange {
    public static final int $stable = 8;
    private final long id;
    private boolean isConsumed;
    private final long position;
    private final boolean pressed;
    private final float pressure;
    private final long previousPosition;
    private final boolean previousPressed;
    private final long previousUptimeMillis;
    private final long uptimeMillis;

    static {
    }

    public IndirectPointerInputChange(long arg1, long arg3, long arg5, boolean arg7, float arg8, long arg9, long arg11, boolean arg13, DefaultConstructorMarker arg14) {
        this(arg1, arg3, arg5, arg7, arg8, arg9, arg11, arg13);
    }

    private IndirectPointerInputChange(long arg1, long arg3, long arg5, boolean arg7, float arg8, long arg9, long arg11, boolean arg13) {
        super();
        this.id = arg1;
        this.uptimeMillis = arg3;
        this.position = arg5;
        this.pressed = arg7;
        this.pressure = arg8;
        this.previousUptimeMillis = arg9;
        this.previousPosition = arg11;
        this.previousPressed = arg13;
    }

    public final void consume() {
        this.isConsumed = true;
    }

    public final long getId-J3iCeTQ() {
        return this.id;
    }

    public final long getPosition-F1C5BW0() {
        return this.position;
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    public final float getPressure() {
        return this.pressure;
    }

    public final long getPreviousPosition-F1C5BW0() {
        return this.previousPosition;
    }

    public final boolean getPreviousPressed() {
        return this.previousPressed;
    }

    public final long getPreviousUptimeMillis() {
        return this.previousUptimeMillis;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final boolean isConsumed() {
        return this.isConsumed;
    }

    public String toString() {
        return "IndirectPointerInputChange(id=" + PointerId.toString-impl(this.id) + ", uptimeMillis=" + this.uptimeMillis + ", position=" + Offset.toString-impl(this.position) + ", pressed=" + this.pressed + ", pressure=" + this.pressure + ", previousUptimeMillis=" + this.previousUptimeMillis + ", previousPosition=" + Offset.toString-impl(this.previousPosition) + ", previousPressed=" + this.previousPressed + ", isConsumed=" + this.isConsumed + ')';
    }
}

