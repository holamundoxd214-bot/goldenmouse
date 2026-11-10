package androidx.compose.foundation.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0003H\u0016J\b\u0010\u0012\u001A\u00020\u0013H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/layout/InsetsValues;", "", "left", "", "top", "right", "bottom", "<init>", "(IIII)V", "getLeft", "()I", "getTop", "getRight", "getBottom", "equals", "", "other", "hashCode", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InsetsValues {
    public static final int $stable;
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    static {
    }

    public InsetsValues(int arg1, int arg2, int arg3, int arg4) {
        super();
        this.left = arg1;
        this.top = arg2;
        this.right = arg3;
        this.bottom = arg4;
    }

    public boolean equals(Object arg5) {
        if(this == (((InsetsValues)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof InsetsValues)) {
            return 0;
        }

        if(this.left == ((InsetsValues)arg5).left && this.top == ((InsetsValues)arg5).top && this.right == ((InsetsValues)arg5).right && this.bottom == ((InsetsValues)arg5).bottom) {
            return 1;
        }

        return 0;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public int hashCode() {
        return ((this.left * 0x1F + this.top) * 0x1F + this.right) * 0x1F + this.bottom;
    }

    public String toString() {
        return "InsetsValues(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ')';
    }
}

