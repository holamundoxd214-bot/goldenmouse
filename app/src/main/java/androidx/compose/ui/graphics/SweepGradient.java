package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.SizeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000BJ\u001B\u0010\u0012\u001A\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0096\u0002J\b\u0010\u001D\u001A\u00020\u001EH\u0016J\b\u0010\u001F\u001A\u00020 H\u0016J\u001C\u0010!\u001A\u0004\u0018\u00010\u001C2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\u0006\u0010\"\u001A\u00020\tH\u0016R\u0016\u0010\u0003\u001A\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u001C\u0010\b\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010¨\u0006#"}, d2={"Landroidx/compose/ui/graphics/SweepGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Interpolatable;", "center", "Landroidx/compose/ui/geometry/Offset;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "<init>", "(JLjava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCenter-F1C5BW0$ui_graphics", "()J", "J", "getColors$ui_graphics", "()Ljava/util/List;", "getStops$ui_graphics", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "Landroidx/compose/ui/geometry/Size;", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "lerp", "t", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SweepGradient extends ShaderBrush implements Interpolatable {
    public static final int $stable;
    private final long center;
    private final List colors;
    private final List stops;

    static {
    }

    public SweepGradient(long arg1, List arg3, List arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg3, arg4);
    }

    private SweepGradient(long arg1, List arg3, List arg4) {
        super();
        this.center = arg1;
        this.colors = arg3;
        this.stops = arg4;
    }

    public SweepGradient(long arg7, List arg9, List arg10, int arg11, DefaultConstructorMarker arg12) {
        if((arg11 & 4) != 0) {
            arg10 = null;
        }

        this(arg7, arg9, arg10, null);
    }

    public Shader createShader-uvyYCjk(long arg8) {
        long v0 = this.center;
        if((0x7FFFFFFF7FFFFFFFL & v0) == 0x7FC000007FC00000L) {
            arg8 = SizeKt.getCenter-uvyYCjk(arg8);
        }
        else {
            int v2 = 0x20;
            float v0_1 = Float.intBitsToFloat(((int)(v0 >> v2)));
            float v1 = Infinityf;
            long v3 = v0_1 == v1 ? arg8 >> v2 : this.center >> v2;
            v0_1 = Float.intBitsToFloat(((int)v3));
            long v5 = 0xFFFFFFFFL;
            if(Float.intBitsToFloat(((int)(this.center & v5))) == v1) {
            }
            else {
                arg8 = this.center;
            }

            arg8 = Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg8 & v5)))))) & v5 | (((long)Float.floatToRawIntBits(v0_1))) << v2);
        }

        return ShaderKt.SweepGradientShader-9KIMszo(arg8, this.colors, this.stops);
    }

    public boolean equals(Object arg8) {
        if(this == (((SweepGradient)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof SweepGradient)) {
            return 0;
        }

        if(!Offset.equals-impl0(this.center, ((SweepGradient)arg8).center)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.colors, ((SweepGradient)arg8).colors)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.stops, ((SweepGradient)arg8).stops)) {
            return 0;
        }

        return 1;
    }

    public final long getCenter-F1C5BW0$ui_graphics() {
        return this.center;
    }

    public final List getColors$ui_graphics() {
        return this.colors;
    }

    public final List getStops$ui_graphics() {
        return this.stops;
    }

    public int hashCode() {
        int v0 = (Offset.hashCode-impl(this.center) * 0x1F + this.colors.hashCode()) * 0x1F;
        List v2 = this.stops;
        int v2_1 = v2 != null ? v2.hashCode() : 0;
        return v0 + v2_1;
    }

    public Object lerp(Object arg12, float arg13) {
        SweepGradient v12_1;
        SolidColor v12;
        DefaultConstructorMarker v0 = null;
        if(arg12 == null) {
            v12 = new SolidColor(Color.Companion.getTransparent-0d7_KjU(), v0);
        }

        if((v12 instanceof SolidColor)) {
            long v3 = this.center;
            List v1 = this.colors;
            ArrayList v2 = new ArrayList(v1.size());
            int v5 = v1.size();
            int v6;
            for(v6 = 0; v6 < v5; ++v6) {
                v1.get(v6).unbox-impl();
                v2.add(Color.box-impl(v12.getValue-0d7_KjU()));
            }

            v12_1 = new SweepGradient(v3, v2, this.stops, null);
        }

        if((v12_1 instanceof SweepGradient)) {
            return new SweepGradient(OffsetKt.lerp-Wko1d7g(this.center, v12_1.center, arg13), BrushKt.lerpColorList(this.colors, v12_1.colors, arg13), BrushKt.lerpNullableFloatList(this.stops, v12_1.stops, arg13), null);
        }

        return v0;
    }

    public String toString() {
        String v0 = (this.center & 0x7FFFFFFF7FFFFFFFL) != 0x7FC000007FC00000L ? "center=" + Offset.toString-impl(this.center) + ", " : "";
        return "SweepGradient(" + v0 + "colors=" + this.colors + ", stops=" + this.stops + ')';
    }
}

