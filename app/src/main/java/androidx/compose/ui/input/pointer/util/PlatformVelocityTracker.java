package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u001F\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\n\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0007H&¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001A\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2={"Landroidx/compose/ui/input/pointer/util/PlatformVelocityTracker;", "", "addPointerInputChange", "", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "offset", "Landroidx/compose/ui/geometry/Offset;", "addPointerInputChange-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "addPosition", "timeMillis", "", "position", "addPosition-Uv8p0NA", "(JJ)V", "calculateVelocity", "Landroidx/compose/ui/unit/Velocity;", "maximumVelocity", "calculateVelocity-AH228Gc", "(J)J", "resetTracking", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PlatformVelocityTracker {
    void addPointerInputChange-Uv8p0NA(PointerInputChange arg1, long arg2);

    void addPosition-Uv8p0NA(long arg1, long arg2);

    long calculateVelocity-AH228Gc(long arg1);

    void resetTracking();
}

