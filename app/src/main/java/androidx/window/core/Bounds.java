package androidx.window.core;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FB\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u0007\u0010\u000BJ\u0006\u0010\u0011\u001A\u00020\nJ\b\u0010\u001A\u001A\u00020\u001BH\u0016J\u0013\u0010\u001C\u001A\u00020\u00172\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001E\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\rR\u0011\u0010\u0012\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001A\u00020\u00178F¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0018R\u0011\u0010\u0019\u001A\u00020\u00178F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0018¨\u0006 "}, d2={"Landroidx/window/core/Bounds;", "", "left", "", "top", "right", "bottom", "<init>", "(IIII)V", "rect", "Landroid/graphics/Rect;", "(Landroid/graphics/Rect;)V", "getLeft", "()I", "getTop", "getRight", "getBottom", "toRect", "width", "getWidth", "height", "getHeight", "isEmpty", "", "()Z", "isZero", "toString", "", "equals", "other", "hashCode", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Bounds {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/window/core/Bounds$Companion;", "", "<init>", "()V", "EMPTY_BOUNDS", "Landroidx/window/core/Bounds;", "getEMPTY_BOUNDS", "()Landroidx/window/core/Bounds;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Bounds getEMPTY_BOUNDS() {
            return Bounds.EMPTY_BOUNDS;
        }
    }

    public static final Companion Companion;
    private static final Bounds EMPTY_BOUNDS;
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    static {
        Bounds.Companion = new Companion(null);
        Bounds.EMPTY_BOUNDS = new Bounds(0, 0, 0, 0);
    }

    public Bounds(int arg1, int arg2, int arg3, int arg4) {
        super();
        this.left = arg1;
        this.top = arg2;
        this.right = arg3;
        this.bottom = arg4;
        if(arg1 <= arg3) {
            if(arg2 <= arg4) {
                return;
            }

            throw new IllegalArgumentException("top must be less than or equal to bottom, top: " + arg2 + ", bottom: " + arg4.toString());
        }

        throw new IllegalArgumentException("Left must be less than or equal to right, left: " + arg1 + ", right: " + arg3.toString());
    }

    public Bounds(Rect arg4) {
        Intrinsics.checkNotNullParameter(arg4, "rect");
        this(arg4.left, arg4.top, arg4.right, arg4.bottom);
    }

    public static final Bounds access$getEMPTY_BOUNDS$cp() {
        return Bounds.EMPTY_BOUNDS;
    }

    public boolean equals(Object arg5) {
        if(this == (((Bounds)arg5))) {
            return 1;
        }

        Class v1 = this.getClass();
        if(arg5 != null) {
            Class v2 = arg5.getClass();
        }
        else {
            Object v2_1 = null;
        }

        if(!Intrinsics.areEqual(v1, v2)) {
            return 0;
        }

        Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type androidx.window.core.Bounds");
        if(this.left != ((Bounds)arg5).left) {
            return 0;
        }

        if(this.top != ((Bounds)arg5).top) {
            return 0;
        }

        if(this.right != ((Bounds)arg5).right) {
            return 0;
        }

        if(this.bottom != ((Bounds)arg5).bottom) {
            return 0;
        }

        return 1;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getHeight() {
        return this.bottom - this.top;
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

    public final int getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return ((this.left * 0x1F + this.top) * 0x1F + this.right) * 0x1F + this.bottom;
    }

    public final boolean isEmpty() {
        if(this.getHeight() != 0) {
            if(this.getWidth() == 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean isZero() {
        if(this.getHeight() == 0 && this.getWidth() == 0) {
            return 1;
        }

        return 0;
    }

    public final Rect toRect() {
        return new Rect(this.left, this.top, this.right, this.bottom);
    }

    public String toString() {
        return "Bounds { [" + this.left + ',' + this.top + ',' + this.right + ',' + this.bottom + "] }";
    }
}

