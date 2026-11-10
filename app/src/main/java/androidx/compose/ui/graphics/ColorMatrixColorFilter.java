package androidx.compose.ui.graphics;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001F\b\u0000\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\u0010\u0004\u001A\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\tJ\u0017\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u0003¢\u0006\u0004\b\r\u0010\u000EJ\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0002J\u000F\u0010\u0013\u001A\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001A\u00020\u0017H\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016R\u0012\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001A"}, d2={"Landroidx/compose/ui/graphics/ColorMatrixColorFilter;", "Landroidx/compose/ui/graphics/ColorFilter;", "colorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "<init>", "([FLandroid/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "([FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "[F", "copyColorMatrix", "targetColorMatrix", "copyColorMatrix-gBh15pI", "([F)[F", "equals", "", "other", "", "obtainColorMatrix", "obtainColorMatrix-p10-uLo", "()[F", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ColorMatrixColorFilter extends ColorFilter {
    public static final int $stable;
    private float[] colorMatrix;

    static {
    }

    public ColorMatrixColorFilter(float[] arg1, android.graphics.ColorFilter arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public ColorMatrixColorFilter(float[] arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    private ColorMatrixColorFilter(float[] arg3) {
        this(arg3, AndroidColorFilter_androidKt.actualColorMatrixColorFilter-jHG-Opc(arg3), null);
    }

    private ColorMatrixColorFilter(float[] arg1, android.graphics.ColorFilter arg2) {
        super(arg2);
        this.colorMatrix = arg1;
    }

    public final float[] copyColorMatrix-gBh15pI(float[] arg8) {
        ArraysKt.copyInto$default(this.obtainColorMatrix-p10-uLo(), arg8, 0, 0, 0, 14, null);
        return arg8;
    }

    public static float[] copyColorMatrix-gBh15pI$default(ColorMatrixColorFilter arg0, float[] arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = ColorMatrix.constructor-impl$default(null, 1, null);
        }

        return arg0.copyColorMatrix-gBh15pI(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((ColorMatrixColorFilter)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof ColorMatrixColorFilter)) {
            return 0;
        }

        if(!Arrays.equals(this.obtainColorMatrix-p10-uLo(), ((ColorMatrixColorFilter)arg4).obtainColorMatrix-p10-uLo())) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        float[] v0 = this.colorMatrix;
        if(v0 != null) {
            return ColorMatrix.hashCode-impl(v0);
        }

        return 0;
    }

    private final float[] obtainColorMatrix-p10-uLo() {
        float[] v0 = this.colorMatrix;
        if(v0 == null) {
            v0 = AndroidColorFilter_androidKt.actualColorMatrixFromFilter(this.getNativeColorFilter$ui_graphics());
            this.colorMatrix = v0;
        }

        return v0;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("ColorMatrixColorFilter(colorMatrix=");
        float[] v2 = this.colorMatrix;
        String v2_1 = v2 == null ? "null" : ColorMatrix.toString-impl(v2);
        return v0.append(v2_1).append(')').toString();
    }
}

