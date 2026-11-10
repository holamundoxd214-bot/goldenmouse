package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0017\u001A\u00020\tR\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2={"Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "", "<init>", "()V", "platformVelocityTracker", "Landroidx/compose/ui/input/pointer/util/PlatformVelocityTracker;", "getPlatformVelocityTracker$ui", "()Landroidx/compose/ui/input/pointer/util/PlatformVelocityTracker;", "addPosition", "", "timeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "addPosition-Uv8p0NA", "(JJ)V", "calculateVelocity", "Landroidx/compose/ui/unit/Velocity;", "calculateVelocity-9UxMQ8M", "()J", "maximumVelocity", "calculateVelocity-AH228Gc", "(J)J", "resetTracking", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VelocityTracker {
    public static final int $stable = 8;
    private final PlatformVelocityTracker platformVelocityTracker;

    static {
    }

    public VelocityTracker() {
        super();
        this.platformVelocityTracker = PlatformVelocityTracker_androidKt.PlatformVelocityTracker();
    }

    public final void addPosition-Uv8p0NA(long arg1, long arg3) {
        this.platformVelocityTracker.addPosition-Uv8p0NA(arg1, arg3);
    }

    public final long calculateVelocity-9UxMQ8M() {
        return this.calculateVelocity-AH228Gc(VelocityKt.Velocity(3.402823E+38f, 3.402823E+38f));
    }

    public final long calculateVelocity-AH228Gc(long arg1) {
        return this.platformVelocityTracker.calculateVelocity-AH228Gc(arg1);
    }

    public final PlatformVelocityTracker getPlatformVelocityTracker$ui() {
        return this.platformVelocityTracker;
    }

    public final void resetTracking() {
        this.platformVelocityTracker.resetTracking();
    }
}

