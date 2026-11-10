package androidx.compose.ui.input.pointer;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\t\b\'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH&¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000E\u001A\u00020\u0005H&R\u001C\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\u00020\u0019X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u001BR\u0014\u0010 \u001A\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u001B¨\u0006\""}, d2={"Landroidx/compose/ui/input/pointer/PointerInputFilter;", "", "<init>", "()V", "onPointerEvent", "", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancel", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLayoutCoordinates$ui", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates$ui", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "size", "getSize-YbymL2g", "()J", "isAttached", "", "isAttached$ui", "()Z", "setAttached$ui", "(Z)V", "interceptOutOfBoundsChildEvents", "getInterceptOutOfBoundsChildEvents", "shareWithSiblings", "getShareWithSiblings", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class PointerInputFilter {
    public static final int $stable = 8;
    private boolean isAttached;
    private LayoutCoordinates layoutCoordinates;

    static {
    }

    public PointerInputFilter() {
        super();
    }

    public boolean getInterceptOutOfBoundsChildEvents() {
        return 0;
    }

    public final LayoutCoordinates getLayoutCoordinates$ui() {
        return this.layoutCoordinates;
    }

    public boolean getShareWithSiblings() {
        return 0;
    }

    public final long getSize-YbymL2g() {
        LayoutCoordinates v2 = this.layoutCoordinates;
        if(v2 != null) {
            return v2.getSize-YbymL2g();
        }

        return IntSize.Companion.getZero-YbymL2g();
    }

    public final boolean isAttached$ui() {
        return this.isAttached;
    }

    public abstract void onCancel();

    public abstract void onPointerEvent-H0pRuoY(PointerEvent arg1, PointerEventPass arg2, long arg3);

    public final void setAttached$ui(boolean arg1) {
        this.isAttached = arg1;
    }

    public final void setLayoutCoordinates$ui(LayoutCoordinates arg1) {
        this.layoutCoordinates = arg1;
    }
}

