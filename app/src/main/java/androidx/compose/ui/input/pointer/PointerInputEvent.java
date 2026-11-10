package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0001\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u001C\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2={"Landroidx/compose/ui/input/pointer/PointerInputEvent;", "", "uptime", "", "pointers", "", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "motionEvent", "Landroid/view/MotionEvent;", "<init>", "(JLjava/util/List;Landroid/view/MotionEvent;)V", "getUptime", "()J", "getPointers", "()Ljava/util/List;", "getMotionEvent", "()Landroid/view/MotionEvent;", "setMotionEvent", "(Landroid/view/MotionEvent;)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PointerInputEvent {
    public static final int $stable = 8;
    private MotionEvent motionEvent;
    private final List pointers;
    private final long uptime;

    static {
    }

    public PointerInputEvent(long arg1, List arg3, MotionEvent arg4) {
        super();
        this.uptime = arg1;
        this.pointers = arg3;
        this.motionEvent = arg4;
    }

    public final MotionEvent getMotionEvent() {
        return this.motionEvent;
    }

    public final List getPointers() {
        return this.pointers;
    }

    public final long getUptime() {
        return this.uptime;
    }

    public final void setMotionEvent(MotionEvent arg1) {
        this.motionEvent = arg1;
    }
}

