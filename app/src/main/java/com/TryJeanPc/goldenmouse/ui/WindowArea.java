package com.TryJeanPc.goldenmouse.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003\u0012\b\b\u0002\u0010\t\u001A\u00020\u0003\u0012\b\b\u0002\u0010\n\u001A\u00020\u0003¢\u0006\u0004\b\u000B\u0010\fJ\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0003HÆ\u0003JO\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u001E\u001A\u00020\u001F2\b\u0010 \u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001A\u00020\u0003HÖ\u0001J\t\u0010\"\u001A\u00020#HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000ER\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000ER\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u000ER\u0011\u0010\n\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u000E¨\u0006$"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/WindowArea;", "", "widthPx", "", "heightPx", "density", "", "leftInsetPx", "topInsetPx", "rightInsetPx", "bottomInsetPx", "<init>", "(IIFIIII)V", "getWidthPx", "()I", "getHeightPx", "getDensity", "()F", "getLeftInsetPx", "getTopInsetPx", "getRightInsetPx", "getBottomInsetPx", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class WindowArea {
    public static final int $stable;
    private final int bottomInsetPx;
    private final float density;
    private final int heightPx;
    private final int leftInsetPx;
    private final int rightInsetPx;
    private final int topInsetPx;
    private final int widthPx;

    static {
    }

    public WindowArea(int arg1, int arg2, float arg3, int arg4, int arg5, int arg6, int arg7) {
        super();
        this.widthPx = arg1;
        this.heightPx = arg2;
        this.density = arg3;
        this.leftInsetPx = arg4;
        this.topInsetPx = arg5;
        this.rightInsetPx = arg6;
        this.bottomInsetPx = arg7;
        String v0 = "Failed requirement.";
        if(arg1 > 0 && arg2 > 0 && Math.abs(arg3) <= 3.402823E+38f && arg3 > 0f) {
            if(arg4 >= 0 && arg5 >= 0 && arg6 >= 0 && arg7 >= 0) {
                return;
            }

            throw new IllegalArgumentException(v0.toString());
        }

        throw new IllegalArgumentException(v0.toString());
    }

    public WindowArea(int arg2, int arg3, float arg4, int arg5, int arg6, int arg7, int arg8, int arg9, DefaultConstructorMarker arg10) {
        this(arg2, arg3, arg4, 0, 0, 0, 0);
    }

    public final int component1() {
        return this.widthPx;
    }

    public final int component2() {
        return this.heightPx;
    }

    public final float component3() {
        return this.density;
    }

    public final int component4() {
        return this.leftInsetPx;
    }

    public final int component5() {
        return this.topInsetPx;
    }

    public final int component6() {
        return this.rightInsetPx;
    }

    public final int component7() {
        return this.bottomInsetPx;
    }

    public final WindowArea copy(int arg1, int arg2, float arg3, int arg4, int arg5, int arg6, int arg7) {
        return new WindowArea(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static WindowArea copy$default(WindowArea arg0, int arg1, int arg2, float arg3, int arg4, int arg5, int arg6, int arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.widthPx;
        }

        if((arg8 & 2) != 0) {
            arg2 = arg0.heightPx;
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.density;
        }

        if((arg8 & 8) != 0) {
            arg4 = arg0.leftInsetPx;
        }

        if((arg8 & 16) != 0) {
            arg5 = arg0.topInsetPx;
        }

        if((arg8 & 0x20) != 0) {
            arg6 = arg0.rightInsetPx;
        }

        if((arg8 & 0x40) != 0) {
            arg7 = arg0.bottomInsetPx;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public boolean equals(Object arg5) {
        if(this == (((WindowArea)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof WindowArea)) {
            return 0;
        }

        if(this.widthPx != ((WindowArea)arg5).widthPx) {
            return 0;
        }

        if(this.heightPx != ((WindowArea)arg5).heightPx) {
            return 0;
        }

        if(Float.compare(this.density, ((WindowArea)arg5).density) != 0) {
            return 0;
        }

        if(this.leftInsetPx != ((WindowArea)arg5).leftInsetPx) {
            return 0;
        }

        if(this.topInsetPx != ((WindowArea)arg5).topInsetPx) {
            return 0;
        }

        if(this.rightInsetPx != ((WindowArea)arg5).rightInsetPx) {
            return 0;
        }

        if(this.bottomInsetPx != ((WindowArea)arg5).bottomInsetPx) {
            return 0;
        }

        return 1;
    }

    public final int getBottomInsetPx() {
        return this.bottomInsetPx;
    }

    public final float getDensity() {
        return this.density;
    }

    public final int getHeightPx() {
        return this.heightPx;
    }

    public final int getLeftInsetPx() {
        return this.leftInsetPx;
    }

    public final int getRightInsetPx() {
        return this.rightInsetPx;
    }

    public final int getTopInsetPx() {
        return this.topInsetPx;
    }

    public final int getWidthPx() {
        return this.widthPx;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.widthPx) * 0x1F + Integer.hashCode(this.heightPx)) * 0x1F + Float.hashCode(this.density)) * 0x1F + Integer.hashCode(this.leftInsetPx)) * 0x1F + Integer.hashCode(this.topInsetPx)) * 0x1F + Integer.hashCode(this.rightInsetPx)) * 0x1F + Integer.hashCode(this.bottomInsetPx);
    }

    public String toString() {
        return "WindowArea(widthPx=" + this.widthPx + ", heightPx=" + this.heightPx + ", density=" + this.density + ", leftInsetPx=" + this.leftInsetPx + ", topInsetPx=" + this.topInsetPx + ", rightInsetPx=" + this.rightInsetPx + ", bottomInsetPx=" + this.bottomInsetPx + ")";
    }
}

