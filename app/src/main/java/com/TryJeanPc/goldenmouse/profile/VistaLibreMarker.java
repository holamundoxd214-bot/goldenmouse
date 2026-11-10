package com.TryJeanPc.goldenmouse.profile;

import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001D\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\b\u0002\u0010\n\u001A\u00020\b\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\t\u0010\u001E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001F\u001A\u00020\u0005HÆ\u0003J\t\u0010 \u001A\u00020\u0005HÆ\u0003J\t\u0010!\u001A\u00020\bHÆ\u0003J\t\u0010\"\u001A\u00020\bHÆ\u0003J\t\u0010#\u001A\u00020\bHÆ\u0003J\t\u0010$\u001A\u00020\fHÆ\u0003J\u000B\u0010%\u001A\u0004\u0018\u00010\u000EHÆ\u0003J[\u0010&\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000EHÆ\u0001J\u0013\u0010\'\u001A\u00020\f2\b\u0010(\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001A\u00020\bHÖ\u0001J\t\u0010*\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0017R\u0011\u0010\n\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0017R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0013\u0010\r\u001A\u0004\u0018\u00010\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001D¨\u0006+"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/VistaLibreMarker;", "", "id", "", "x", "", "y", "width", "", "height", "sensitivity", "resetOnEdge", "", "activationBinding", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "<init>", "(Ljava/lang/String;FFIIIZLcom/TryJeanPc/goldenmouse/mapper/InputBinding;)V", "getId", "()Ljava/lang/String;", "getX", "()F", "getY", "getWidth", "()I", "getHeight", "getSensitivity", "getResetOnEdge", "()Z", "getActivationBinding", "()Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class VistaLibreMarker {
    public static final int $stable;
    private final InputBinding activationBinding;
    private final int height;
    private final String id;
    private final boolean resetOnEdge;
    private final int sensitivity;
    private final int width;
    private final float x;
    private final float y;

    static {
    }

    public VistaLibreMarker(String arg2, float arg3, float arg4, int arg5, int arg6, int arg7, boolean arg8, InputBinding arg9) {
        Intrinsics.checkNotNullParameter(arg2, "id");
        super();
        this.id = arg2;
        this.x = arg3;
        this.y = arg4;
        this.width = arg5;
        this.height = arg6;
        this.sensitivity = arg7;
        this.resetOnEdge = arg8;
        this.activationBinding = arg9;
    }

    public VistaLibreMarker(String arg12, float arg13, float arg14, int arg15, int arg16, int arg17, boolean arg18, InputBinding arg19, int arg20, DefaultConstructorMarker arg21) {
        int v0 = arg20;
        int v8 = (v0 & 0x20) != 0 ? 320 : arg17;
        boolean v9 = (v0 & 0x40) != 0 ? false : arg18;
        InputBinding v10 = (v0 & 0x80) != 0 ? null : arg19;
        this(arg12, arg13, arg14, arg15, arg16, v8, v9, v10);
    }

    public final String component1() {
        return this.id;
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

    public final int component6() {
        return this.sensitivity;
    }

    public final boolean component7() {
        return this.resetOnEdge;
    }

    public final InputBinding component8() {
        return this.activationBinding;
    }

    public final VistaLibreMarker copy(String arg10, float arg11, float arg12, int arg13, int arg14, int arg15, boolean arg16, InputBinding arg17) {
        Intrinsics.checkNotNullParameter(arg10, "id");
        return new VistaLibreMarker(arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
    }

    public static VistaLibreMarker copy$default(VistaLibreMarker arg0, String arg1, float arg2, float arg3, int arg4, int arg5, int arg6, boolean arg7, InputBinding arg8, int arg9, Object arg10) {
        if((arg9 & 1) != 0) {
            arg1 = arg0.id;
        }

        if((arg9 & 2) != 0) {
            arg2 = arg0.x;
        }

        if((arg9 & 4) != 0) {
            arg3 = arg0.y;
        }

        if((arg9 & 8) != 0) {
            arg4 = arg0.width;
        }

        if((arg9 & 16) != 0) {
            arg5 = arg0.height;
        }

        if((arg9 & 0x20) != 0) {
            arg6 = arg0.sensitivity;
        }

        if((arg9 & 0x40) != 0) {
            arg7 = arg0.resetOnEdge;
        }

        if((arg9 & 0x80) != 0) {
            arg8 = arg0.activationBinding;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public boolean equals(Object arg5) {
        if(this == (((VistaLibreMarker)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof VistaLibreMarker)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.id, ((VistaLibreMarker)arg5).id)) {
            return 0;
        }

        if(Float.compare(this.x, ((VistaLibreMarker)arg5).x) != 0) {
            return 0;
        }

        if(Float.compare(this.y, ((VistaLibreMarker)arg5).y) != 0) {
            return 0;
        }

        if(this.width != ((VistaLibreMarker)arg5).width) {
            return 0;
        }

        if(this.height != ((VistaLibreMarker)arg5).height) {
            return 0;
        }

        if(this.sensitivity != ((VistaLibreMarker)arg5).sensitivity) {
            return 0;
        }

        if(this.resetOnEdge != ((VistaLibreMarker)arg5).resetOnEdge) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.activationBinding, ((VistaLibreMarker)arg5).activationBinding)) {
            return 0;
        }

        return 1;
    }

    public final InputBinding getActivationBinding() {
        return this.activationBinding;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getResetOnEdge() {
        return this.resetOnEdge;
    }

    public final int getSensitivity() {
        return this.sensitivity;
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
        int v0 = ((((((this.id.hashCode() * 0x1F + Float.hashCode(this.x)) * 0x1F + Float.hashCode(this.y)) * 0x1F + Integer.hashCode(this.width)) * 0x1F + Integer.hashCode(this.height)) * 0x1F + Integer.hashCode(this.sensitivity)) * 0x1F + Boolean.hashCode(this.resetOnEdge)) * 0x1F;
        InputBinding v2 = this.activationBinding;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        return v0 + v2_1;
    }

    public String toString() {
        return "VistaLibreMarker(id=" + this.id + ", x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ", sensitivity=" + this.sensitivity + ", resetOnEdge=" + this.resetOnEdge + ", activationBinding=" + this.activationBinding + ")";
    }
}

