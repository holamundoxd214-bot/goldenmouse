package com.TryJeanPc.goldenmouse.stretch;

import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J1\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/StretchRect;", "", "left", "", "top", "right", "bottom", "<init>", "(IIII)V", "getLeft", "()I", "getTop", "getRight", "getBottom", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRect {
    public static final int $stable;
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    static {
    }

    public StretchRect(int arg1, int arg2, int arg3, int arg4) {
        super();
        this.left = arg1;
        this.top = arg2;
        this.right = arg3;
        this.bottom = arg4;
    }

    public final int component1() {
        return this.left;
    }

    public final int component2() {
        return this.top;
    }

    public final int component3() {
        return this.right;
    }

    public final int component4() {
        return this.bottom;
    }

    public final StretchRect copy(int arg1, int arg2, int arg3, int arg4) {
        return new StretchRect(arg1, arg2, arg3, arg4);
    }

    public static StretchRect copy$default(StretchRect arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.left;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.top;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.right;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.bottom;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchRect)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchRect)) {
            return 0;
        }

        if(this.left != ((StretchRect)arg5).left) {
            return 0;
        }

        if(this.top != ((StretchRect)arg5).top) {
            return 0;
        }

        if(this.right != ((StretchRect)arg5).right) {
            return 0;
        }

        if(this.bottom != ((StretchRect)arg5).bottom) {
            return 0;
        }

        return 1;
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
        return ((Integer.hashCode(this.left) * 0x1F + Integer.hashCode(this.top)) * 0x1F + Integer.hashCode(this.right)) * 0x1F + Integer.hashCode(this.bottom);
    }

    public String toString() {
        return "StretchRect(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
    }
}

