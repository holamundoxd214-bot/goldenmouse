package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BC\b\u0000\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u0007\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\u001B\u0010\u001D\u001A\u00060\u001Ej\u0002`\u001F2\u0006\u0010 \u001A\u00020\u001BH\u0016¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001A\u00020$2\b\u0010%\u001A\u0004\u0018\u00010&H\u0096\u0002J\b\u0010\'\u001A\u00020(H\u0016J\b\u0010)\u001A\u00020*H\u0016J\u001C\u0010+\u001A\u0004\u0018\u00010&2\b\u0010%\u001A\u0004\u0018\u00010&2\u0006\u0010,\u001A\u00020\u0007H\u0016R\u001A\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u001C\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001A\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\n\u001A\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000B\u001A\u00020\fX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001A\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u0013¨\u0006-"}, d2={"Landroidx/compose/ui/graphics/RadialGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Interpolatable;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "<init>", "(Ljava/util/List;Ljava/util/List;JFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColors$ui_graphics", "()Ljava/util/List;", "getStops$ui_graphics", "getCenter-F1C5BW0$ui_graphics", "()J", "J", "getRadius$ui_graphics", "()F", "getTileMode-3opZhB0$ui_graphics", "()I", "I", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "lerp", "t", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RadialGradient extends ShaderBrush implements Interpolatable {
    public static final int $stable;
    private final long center;
    private final List colors;
    private final float radius;
    private final List stops;
    private final int tileMode;

    static {
    }

    public RadialGradient(List arg1, List arg2, long arg3, float arg5, int arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg3, arg5, arg6);
    }

    private RadialGradient(List arg1, List arg2, long arg3, float arg5, int arg6) {
        super();
        this.colors = arg1;
        this.stops = arg2;
        this.center = arg3;
        this.radius = arg5;
        this.tileMode = arg6;
    }

    public RadialGradient(List arg9, List arg10, long arg11, float arg13, int arg14, int arg15, DefaultConstructorMarker arg16) {
        if((arg15 & 2) != 0) {
            arg10 = null;
        }

        List v2 = arg10;
        if((arg15 & 16) != 0) {
            arg14 = TileMode.Companion.getClamp-3opZhB0();
        }

        this(arg9, v2, arg11, arg13, arg14, null);
    }

    public Shader createShader-uvyYCjk(long arg14) {
        float v0_1;
        float v2;
        long v0 = this.center;
        float v3 = Infinityf;
        long v4 = 0xFFFFFFFFL;
        int v6 = 0x20;
        if(Long.compare(0x7FFFFFFF7FFFFFFFL & v0, 0x7FC000007FC00000L) == 0) {
            v0 = SizeKt.getCenter-uvyYCjk(arg14);
            v2 = Float.intBitsToFloat(((int)(v0 >> v6)));
            v0_1 = Float.intBitsToFloat(((int)(v0 & v4)));
        }
        else {
            v0 = Float.intBitsToFloat(((int)(v0 >> v6))) == v3 ? arg14 >> v6 : this.center >> v6;
            v2 = Float.intBitsToFloat(((int)v0));
            v0 = Float.intBitsToFloat(((int)(this.center & v4))) == v3 ? arg14 & v4 : this.center & v4;
            v0_1 = Float.intBitsToFloat(((int)v0));
        }

        List v10 = this.colors;
        List v11 = this.stops;
        long v7 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v2))) << v6 | v4 & (((long)Float.floatToRawIntBits(v0_1))));
        v0_1 = this.radius;
        if(v0_1 == v3) {
            v0_1 = Size.getMinDimension-impl(arg14) / 2f;
        }

        return ShaderKt.RadialGradientShader-8uybcMk(v7, v0_1, v10, v11, this.tileMode);
    }

    public boolean equals(Object arg8) {
        if(this == (((RadialGradient)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof RadialGradient)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.colors, ((RadialGradient)arg8).colors)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.stops, ((RadialGradient)arg8).stops)) {
            return 0;
        }

        if(!Offset.equals-impl0(this.center, ((RadialGradient)arg8).center)) {
            return 0;
        }

        if(this.radius == ((RadialGradient)arg8).radius) {
            if(!TileMode.equals-impl0(this.tileMode, ((RadialGradient)arg8).tileMode)) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    public final long getCenter-F1C5BW0$ui_graphics() {
        return this.center;
    }

    public final List getColors$ui_graphics() {
        return this.colors;
    }

    public long getIntrinsicSize-NH-jbRc() {
        if((Float.floatToRawIntBits(this.radius) & 0x7FFFFFFF) < 0x7F800000) {
            return Size.constructor-impl((((long)Float.floatToRawIntBits(this.radius * 2f))) << 0x20 | (((long)Float.floatToRawIntBits(this.radius * 2f))) & 0xFFFFFFFFL);
        }

        return Size.Companion.getUnspecified-NH-jbRc();
    }

    public final float getRadius$ui_graphics() {
        return this.radius;
    }

    public final List getStops$ui_graphics() {
        return this.stops;
    }

    public final int getTileMode-3opZhB0$ui_graphics() {
        return this.tileMode;
    }

    public int hashCode() {
        int v0 = this.colors.hashCode() * 0x1F;
        List v1 = this.stops;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        return (((v0 + v1_1) * 0x1F + Offset.hashCode-impl(this.center)) * 0x1F + Float.hashCode(this.radius)) * 0x1F + TileMode.hashCode-impl(this.tileMode);
    }

    public Object lerp(Object arg14, float arg15) {
        RadialGradient v14_1;
        SolidColor v14;
        DefaultConstructorMarker v0 = null;
        if(arg14 == null) {
            v14 = new SolidColor(Color.Companion.getTransparent-0d7_KjU(), v0);
        }

        if((v14 instanceof SolidColor)) {
            List v1 = this.colors;
            ArrayList v2 = new ArrayList(v1.size());
            int v3 = v1.size();
            int v4;
            for(v4 = 0; v4 < v3; ++v4) {
                v1.get(v4).unbox-impl();
                v2.add(Color.box-impl(v14.getValue-0d7_KjU()));
            }

            v14_1 = new RadialGradient(v2, this.stops, this.center, this.radius, this.tileMode, null);
        }

        if((v14_1 instanceof RadialGradient)) {
            List v3_1 = BrushKt.lerpColorList(this.colors, v14_1.colors, arg15);
            List v4_1 = BrushKt.lerpNullableFloatList(this.stops, v14_1.stops, arg15);
            long v5 = OffsetKt.lerp-Wko1d7g(this.center, v14_1.center, arg15);
            float v7 = MathHelpersKt.lerp(this.radius, v14_1.radius, arg15);
            int v13 = arg15 < 0.5f ? this.tileMode : v14_1.tileMode;
            return new RadialGradient(v3_1, v4_1, v5, v7, v13, null);
        }

        return v0;
    }

    public String toString() {
        String v1 = "";
        String v2 = ", ";
        String v0 = Long.compare(this.center & 0x7FFFFFFF7FFFFFFFL, 0x7FC000007FC00000L) != 0 ? "center=" + Offset.toString-impl(this.center) + v2 : v1;
        if((Float.floatToRawIntBits(this.radius) & 0x7FFFFFFF) < 0x7F800000) {
            v1 = "radius=" + this.radius + v2;
        }

        return "RadialGradient(colors=" + this.colors + ", stops=" + this.stops + v2 + v0 + v1 + "tileMode=" + TileMode.toString-impl(this.tileMode) + ')';
    }
}

