package androidx.compose.material.ripple;

import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u0015"}, d2={"Landroidx/compose/material/ripple/RippleAlpha;", "", "draggedAlpha", "", "focusedAlpha", "hoveredAlpha", "pressedAlpha", "<init>", "(FFFF)V", "getDraggedAlpha", "()F", "getFocusedAlpha", "getHoveredAlpha", "getPressedAlpha", "equals", "", "other", "hashCode", "", "toString", "", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RippleAlpha {
    public static final int $stable;
    private final float draggedAlpha;
    private final float focusedAlpha;
    private final float hoveredAlpha;
    private final float pressedAlpha;

    static {
    }

    public RippleAlpha(float arg1, float arg2, float arg3, float arg4) {
        super();
        this.draggedAlpha = arg1;
        this.focusedAlpha = arg2;
        this.hoveredAlpha = arg3;
        this.pressedAlpha = arg4;
    }

    public boolean equals(Object arg5) {
        if(this == (((RippleAlpha)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RippleAlpha)) {
            return 0;
        }

        if(this.draggedAlpha == ((RippleAlpha)arg5).draggedAlpha && this.focusedAlpha == ((RippleAlpha)arg5).focusedAlpha && this.hoveredAlpha == ((RippleAlpha)arg5).hoveredAlpha && this.pressedAlpha == ((RippleAlpha)arg5).pressedAlpha) {
            return 1;
        }

        return 0;
    }

    public final float getDraggedAlpha() {
        return this.draggedAlpha;
    }

    public final float getFocusedAlpha() {
        return this.focusedAlpha;
    }

    public final float getHoveredAlpha() {
        return this.hoveredAlpha;
    }

    public final float getPressedAlpha() {
        return this.pressedAlpha;
    }

    public int hashCode() {
        return ((Float.hashCode(this.draggedAlpha) * 0x1F + Float.hashCode(this.focusedAlpha)) * 0x1F + Float.hashCode(this.hoveredAlpha)) * 0x1F + Float.hashCode(this.pressedAlpha);
    }

    public String toString() {
        return "RippleAlpha(draggedAlpha=" + this.draggedAlpha + ", focusedAlpha=" + this.focusedAlpha + ", hoveredAlpha=" + this.hoveredAlpha + ", pressedAlpha=" + this.pressedAlpha + ')';
    }
}

