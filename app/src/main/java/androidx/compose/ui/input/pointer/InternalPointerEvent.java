package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.collection.LongSparseArray;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u001D\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\r\u001A\u0004\u0018\u00010\u000E8F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0017\u001A\u00020\u0012X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2={"Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "", "changes", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "pointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "<init>", "(Landroidx/collection/LongSparseArray;Landroidx/compose/ui/input/pointer/PointerInputEvent;)V", "getChanges", "()Landroidx/collection/LongSparseArray;", "getPointerInputEvent", "()Landroidx/compose/ui/input/pointer/PointerInputEvent;", "motionEvent", "Landroid/view/MotionEvent;", "getMotionEvent", "()Landroid/view/MotionEvent;", "activeHoverEvent", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "activeHoverEvent-0FcD4WY", "(J)Z", "suppressMovementConsumption", "getSuppressMovementConsumption", "()Z", "setSuppressMovementConsumption", "(Z)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InternalPointerEvent {
    public static final int $stable = 8;
    private final LongSparseArray changes;
    private final PointerInputEvent pointerInputEvent;
    private boolean suppressMovementConsumption;

    static {
    }

    public InternalPointerEvent(LongSparseArray arg1, PointerInputEvent arg2) {
        super();
        this.changes = arg1;
        this.pointerInputEvent = arg2;
    }

    public final boolean activeHoverEvent-0FcD4WY(long arg7) {
        Object v3;
        List v6 = this.pointerInputEvent.getPointers();
        int v0 = v6.size();
        int v2 = 0;
        while(true) {
            if(v2 < v0) {
                v3 = v6.get(v2);
                if(PointerId.equals-impl0(v3.getId-J3iCeTQ(), arg7)) {
                }
                else {
                    ++v2;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_16;
        }

        v3 = null;
    label_16:
        if(v3 != null) {
            return ((PointerInputEventData)v3).getActiveHover();
        }

        return 0;
    }

    public final LongSparseArray getChanges() {
        return this.changes;
    }

    public final MotionEvent getMotionEvent() {
        return this.pointerInputEvent.getMotionEvent();
    }

    public final PointerInputEvent getPointerInputEvent() {
        return this.pointerInputEvent;
    }

    public final boolean getSuppressMovementConsumption() {
        return this.suppressMovementConsumption;
    }

    public final void setSuppressMovementConsumption(boolean arg1) {
        this.suppressMovementConsumption = arg1;
    }
}

