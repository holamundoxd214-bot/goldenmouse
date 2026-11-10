package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015J\u0016\u0010\u0016\u001A\u00020\u00172\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0018\u001A\u00020\rJ\u0016\u0010\u0019\u001A\u00020\u00172\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0018\u001A\u00020\rR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001C\u0010\f\u001A\u0004\u0018\u00010\rX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/text/selection/ClicksCounter;", "", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "<init>", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "clicks", "", "getClicks", "()I", "setClicks", "(I)V", "prevClick", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "getPrevClick", "()Landroidx/compose/ui/input/pointer/PointerInputChange;", "setPrevClick", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "update", "", "event", "Landroidx/compose/ui/input/pointer/PointerEvent;", "timeIsTolerable", "", "newClick", "positionIsTolerable", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ClicksCounter {
    public static final int $stable = 8;
    private int clicks;
    private PointerInputChange prevClick;
    private final ViewConfiguration viewConfiguration;

    static {
    }

    public ClicksCounter(ViewConfiguration arg1) {
        super();
        this.viewConfiguration = arg1;
    }

    public final int getClicks() {
        return this.clicks;
    }

    public final PointerInputChange getPrevClick() {
        return this.prevClick;
    }

    public final boolean positionIsTolerable(PointerInputChange arg1, PointerInputChange arg2) {
        return SelectionGesturesKt.access$distanceIsTolerable(this.viewConfiguration, arg1, arg2);
    }

    public final void setClicks(int arg1) {
        this.clicks = arg1;
    }

    public final void setPrevClick(PointerInputChange arg1) {
        this.prevClick = arg1;
    }

    public final boolean timeIsTolerable(PointerInputChange arg3, PointerInputChange arg4) {
        if(arg4.getUptimeMillis() - arg3.getUptimeMillis() < this.viewConfiguration.getDoubleTapTimeoutMillis()) {
            return 1;
        }

        return 0;
    }

    public final void update(PointerEvent arg4) {
        PointerInputChange v0 = this.prevClick;
        Object v4 = arg4.getChanges().get(0);
        if(v0 == null || !this.timeIsTolerable(v0, ((PointerInputChange)v4)) || !this.positionIsTolerable(v0, ((PointerInputChange)v4))) {
            this.clicks = 1;
        }
        else {
            ++this.clicks;
        }

        this.prevClick = ((PointerInputChange)v4);
    }
}

