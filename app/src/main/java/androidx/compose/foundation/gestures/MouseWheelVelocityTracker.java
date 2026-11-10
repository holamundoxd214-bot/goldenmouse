package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\r\u0010\u000F\u001A\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/gestures/MouseWheelVelocityTracker;", "", "<init>", "()V", "xVelocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D;", "yVelocityTracker", "addDelta", "", "timeMillis", "", "delta", "Landroidx/compose/ui/geometry/Offset;", "addDelta-Uv8p0NA", "(JJ)V", "calculateVelocity", "Landroidx/compose/ui/unit/Velocity;", "calculateVelocity-9UxMQ8M", "()J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class MouseWheelVelocityTracker {
    private final VelocityTracker1D xVelocityTracker;
    private final VelocityTracker1D yVelocityTracker;

    public MouseWheelVelocityTracker() {
        super();
        this.xVelocityTracker = new VelocityTracker1D(true);
        this.yVelocityTracker = new VelocityTracker1D(true);
    }

    public final void addDelta-Uv8p0NA(long arg4, long arg6) {
        this.xVelocityTracker.addDataPoint(arg4, Float.intBitsToFloat(((int)(arg6 >> 0x20))));
        this.yVelocityTracker.addDataPoint(arg4, Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))));
    }

    public final long calculateVelocity-9UxMQ8M() {
        return VelocityKt.Velocity(this.xVelocityTracker.calculateVelocity(3.402823E+38f), this.yVelocityTracker.calculateVelocity(3.402823E+38f));
    }
}

