package com.TryJeanPc.goldenmouse.controls;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000B\u0010\fJ\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001A\u00020\bHÆ\u0003J\t\u0010\u001A\u001A\u00020\bHÆ\u0003J\u000B\u0010\u001B\u001A\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010\u001C\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001D\u001A\u00020\u001E2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001A\u00020\bHÖ\u0001J\t\u0010!\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0013R\u0013\u0010\n\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u000E¨\u0006\""}, d2={"Lcom/TryJeanPc/goldenmouse/controls/ControlVisualState;", "", "tipo", "", "x", "", "y", "width", "", "height", "tecla", "<init>", "(Ljava/lang/String;FFIILjava/lang/String;)V", "getTipo", "()Ljava/lang/String;", "getX", "()F", "getY", "getWidth", "()I", "getHeight", "getTecla", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ControlVisualState {
    public static final int $stable;
    private final int height;
    private final String tecla;
    private final String tipo;
    private final int width;
    private final float x;
    private final float y;

    static {
    }

    public ControlVisualState(String arg2, float arg3, float arg4, int arg5, int arg6, String arg7) {
        Intrinsics.checkNotNullParameter(arg2, "tipo");
        super();
        this.tipo = arg2;
        this.x = arg3;
        this.y = arg4;
        this.width = arg5;
        this.height = arg6;
        this.tecla = arg7;
    }

    public ControlVisualState(String arg8, float arg9, float arg10, int arg11, int arg12, String arg13, int arg14, DefaultConstructorMarker arg15) {
        if((arg14 & 0x20) != 0) {
            arg13 = null;
        }

        this(arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public final String component1() {
        return this.tipo;
    }

    public final float component2() {
        return this.x;
    }

    public final float component3() {
        return this.y;
    }

    public final int component4() {
        return this.width;
    }

    public final int component5() {
        return this.height;
    }

    public final String component6() {
        return this.tecla;
    }

    public final ControlVisualState copy(String arg8, float arg9, float arg10, int arg11, int arg12, String arg13) {
        Intrinsics.checkNotNullParameter(arg8, "tipo");
        return new ControlVisualState(arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public static ControlVisualState copy$default(ControlVisualState arg0, String arg1, float arg2, float arg3, int arg4, int arg5, String arg6, int arg7, Object arg8) {
        if((arg7 & 1) != 0) {
            arg1 = arg0.tipo;
        }

        if((arg7 & 2) != 0) {
            arg2 = arg0.x;
        }

        if((arg7 & 4) != 0) {
            arg3 = arg0.y;
        }

        if((arg7 & 8) != 0) {
            arg4 = arg0.width;
        }

        if((arg7 & 16) != 0) {
            arg5 = arg0.height;
        }

        if((arg7 & 0x20) != 0) {
            arg6 = arg0.tecla;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public boolean equals(Object arg5) {
        if(this == (((ControlVisualState)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ControlVisualState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.tipo, ((ControlVisualState)arg5).tipo)) {
            return 0;
        }

        if(Float.compare(this.x, ((ControlVisualState)arg5).x) != 0) {
            return 0;
        }

        if(Float.compare(this.y, ((ControlVisualState)arg5).y) != 0) {
            return 0;
        }

        if(this.width != ((ControlVisualState)arg5).width) {
            return 0;
        }

        if(this.height != ((ControlVisualState)arg5).height) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.tecla, ((ControlVisualState)arg5).tecla)) {
            return 0;
        }

        return 1;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getTecla() {
        return this.tecla;
    }

    public final String getTipo() {
        return this.tipo;
    }

    public final int getWidth() {
        return this.width;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        int v0 = ((((this.tipo.hashCode() * 0x1F + Float.hashCode(this.x)) * 0x1F + Float.hashCode(this.y)) * 0x1F + Integer.hashCode(this.width)) * 0x1F + Integer.hashCode(this.height)) * 0x1F;
        String v2 = this.tecla;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        return v0 + v2_1;
    }

    public String toString() {
        return "ControlVisualState(tipo=" + this.tipo + ", x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ", tecla=" + this.tecla + ")";
    }
}

