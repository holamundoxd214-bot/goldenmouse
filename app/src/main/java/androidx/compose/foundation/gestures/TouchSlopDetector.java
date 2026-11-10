package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u001D\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\f\u001A\u00020\r*\u00020\u0005¢\u0006\u0004\b\u000E\u0010\u000FJ\u0011\u0010\u0010\u001A\u00020\r*\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u000FJ%\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u0005¢\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010\u001F\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\rH\u0002¢\u0006\u0004\b \u0010!R\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u0010\u0010\u0012\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\""}, d2={"Landroidx/compose/foundation/gestures/TouchSlopDetector;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "initialPositionChange", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "mainAxis", "", "mainAxis-k-4lQ0M", "(J)F", "crossAxis", "crossAxis-k-4lQ0M", "totalPositionChange", "J", "addPositions", "currentPosition", "previousPosition", "touchSlop", "addPositions-akrDWew", "(JJF)J", "reset", "", "initialPositionAccumulator", "reset-k-4lQ0M", "(J)V", "calculatePostSlopOffset", "calculatePostSlopOffset-tuRUvjQ", "(F)J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TouchSlopDetector {
    public static final int $stable = 8;
    private Orientation orientation;
    private long totalPositionChange;

    static {
    }

    public TouchSlopDetector(Orientation arg2, long arg3, int arg5, DefaultConstructorMarker arg6) {
        DefaultConstructorMarker v0 = null;
        if((arg5 & 1) != 0) {
            arg2 = ((Orientation)v0);
        }

        if((arg5 & 2) != 0) {
            arg3 = Offset.Companion.getZero-F1C5BW0();
        }

        this(arg2, arg3, v0);
    }

    public TouchSlopDetector(Orientation arg1, long arg2, DefaultConstructorMarker arg4) {
        this(arg1, arg2);
    }

    private TouchSlopDetector(Orientation arg1, long arg2) {
        super();
        this.orientation = arg1;
        this.totalPositionChange = arg2;
    }

    public final long addPositions-akrDWew(long arg1, long arg3, float arg5) {
        arg1 = Offset.plus-MK-Hz9U(this.totalPositionChange, Offset.minus-MK-Hz9U(arg1, arg3));
        this.totalPositionChange = arg1;
        float v1 = this.orientation == null ? Offset.getDistance-impl(arg1) : Math.abs(this.mainAxis-k-4lQ0M(arg1));
        if(v1 >= arg5) {
            return this.calculatePostSlopOffset-tuRUvjQ(arg5);
        }

        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    private final long calculatePostSlopOffset-tuRUvjQ(float arg6) {
        Orientation v0 = this.orientation;
        long v1 = this.totalPositionChange;
        if(v0 == null) {
            return Offset.minus-MK-Hz9U(this.totalPositionChange, Offset.times-tuRUvjQ(Offset.div-tuRUvjQ(v1, Offset.getDistance-impl(v1)), arg6));
        }

        float v0_1 = this.mainAxis-k-4lQ0M(v1) - Math.signum(this.mainAxis-k-4lQ0M(this.totalPositionChange)) * arg6;
        arg6 = this.crossAxis-k-4lQ0M(this.totalPositionChange);
        long v2 = 0xFFFFFFFFL;
        int v4 = 0x20;
        if(this.orientation == Orientation.Horizontal) {
            return Offset.constructor-impl((((long)Float.floatToRawIntBits(arg6))) & v2 | (((long)Float.floatToRawIntBits(v0_1))) << v4);
        }

        return Offset.constructor-impl((((long)Float.floatToRawIntBits(arg6))) << v4 | (((long)Float.floatToRawIntBits(v0_1))) & v2);
    }

    public final float crossAxis-k-4lQ0M(long arg3) {
        long v2 = this.orientation == Orientation.Horizontal ? arg3 & 0xFFFFFFFFL : arg3 >> 0x20;
        return Float.intBitsToFloat(((int)v2));
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final float mainAxis-k-4lQ0M(long arg3) {
        long v2 = this.orientation == Orientation.Horizontal ? arg3 >> 0x20 : arg3 & 0xFFFFFFFFL;
        return Float.intBitsToFloat(((int)v2));
    }

    public final void reset-k-4lQ0M(long arg1) {
        this.totalPositionChange = arg1;
    }

    public static void reset-k-4lQ0M$default(TouchSlopDetector arg0, long arg1, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Offset.Companion.getZero-F1C5BW0();
        }

        arg0.reset-k-4lQ0M(arg1);
    }

    public final void setOrientation(Orientation arg1) {
        this.orientation = arg1;
    }
}

