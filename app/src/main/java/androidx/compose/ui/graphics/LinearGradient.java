package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BC\b\u0000\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\u001B\u0010\u001C\u001A\u00060\u001Dj\u0002`\u001E2\u0006\u0010\u001F\u001A\u00020\u001AH\u0016¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001A\u00020\'H\u0016J\b\u0010(\u001A\u00020)H\u0016J\u001C\u0010*\u001A\u0004\u0018\u00010%2\b\u0010$\u001A\u0004\u0018\u00010%2\u0006\u0010+\u001A\u00020\u0007H\u0016R\u001A\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u001C\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001A\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0012\u0010\u0013R\u0016\u0010\n\u001A\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0015\u0010\u0013R\u0016\u0010\u000B\u001A\u00020\fX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001A\u00020\u001A8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0013¨\u0006,"}, d2={"Landroidx/compose/ui/graphics/LinearGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Interpolatable;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "<init>", "(Ljava/util/List;Ljava/util/List;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColors$ui_graphics", "()Ljava/util/List;", "getStops$ui_graphics", "getStart-F1C5BW0$ui_graphics", "()J", "J", "getEnd-F1C5BW0$ui_graphics", "getTileMode-3opZhB0$ui_graphics", "()I", "I", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "lerp", "t", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LinearGradient extends ShaderBrush implements Interpolatable {
    public static final int $stable;
    private final List colors;
    private final long end;
    private final long start;
    private final List stops;
    private final int tileMode;

    static {
    }

    public LinearGradient(List arg1, List arg2, long arg3, long arg5, int arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg5, arg7);
    }

    private LinearGradient(List arg1, List arg2, long arg3, long arg5, int arg7) {
        super();
        this.colors = arg1;
        this.stops = arg2;
        this.start = arg3;
        this.end = arg5;
        this.tileMode = arg7;
    }

    public LinearGradient(List arg10, List arg11, long arg12, long arg14, int arg16, int arg17, DefaultConstructorMarker arg18) {
        if((arg17 & 2) != 0) {
            arg11 = null;
        }

        List v2 = arg11;
        int v7 = (arg17 & 16) != 0 ? TileMode.Companion.getClamp-3opZhB0() : arg16;
        this(arg10, v2, arg12, arg14, v7, null);
    }

    public Shader createShader-uvyYCjk(long arg15) {
        int v2 = 0x20;
        float v1 = Infinityf;
        long v3 = Float.intBitsToFloat(((int)(this.start >> v2))) == v1 ? arg15 >> v2 : this.start >> v2;
        float v0 = Float.intBitsToFloat(((int)v3));
        long v5 = 0xFFFFFFFFL;
        v3 = Float.intBitsToFloat(((int)(this.start & v5))) == v1 ? arg15 & v5 : this.start & v5;
        float v3_1 = Float.intBitsToFloat(((int)v3));
        long v7 = Float.intBitsToFloat(((int)(this.end >> v2))) == v1 ? arg15 >> v2 : this.end >> v2;
        float v4 = Float.intBitsToFloat(((int)v7));
        v7 = Float.intBitsToFloat(((int)(this.end & v5))) == v1 ? arg15 & v5 : this.end & v5;
        return ShaderKt.LinearGradientShader-VjE6UOU(Offset.constructor-impl((((long)Float.floatToRawIntBits(v0))) << v2 | (((long)Float.floatToRawIntBits(v3_1))) & v5), Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)v7))))) & v5 | (((long)Float.floatToRawIntBits(v4))) << v2), this.colors, this.stops, this.tileMode);
    }

    public boolean equals(Object arg8) {
        if(this == (((LinearGradient)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof LinearGradient)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.colors, ((LinearGradient)arg8).colors)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.stops, ((LinearGradient)arg8).stops)) {
            return 0;
        }

        if(!Offset.equals-impl0(this.start, ((LinearGradient)arg8).start)) {
            return 0;
        }

        if(!Offset.equals-impl0(this.end, ((LinearGradient)arg8).end)) {
            return 0;
        }

        if(!TileMode.equals-impl0(this.tileMode, ((LinearGradient)arg8).tileMode)) {
            return 0;
        }

        return 1;
    }

    public final List getColors$ui_graphics() {
        return this.colors;
    }

    public final long getEnd-F1C5BW0$ui_graphics() {
        return this.end;
    }

    public long getIntrinsicSize-NH-jbRc() {
        int v2 = 0x20;
        float v0 = Float.intBitsToFloat(((int)(this.start >> v2)));
        float v3 = NaNf;
        if((Float.isInfinite(v0)) || (Float.isNaN(v0))) {
        label_29:
            v0 = v3;
        }
        else {
            v0 = Float.intBitsToFloat(((int)(this.end >> v2)));
            if(Float.isInfinite(v0)) {
                goto label_29;
            }
            else if(!Float.isNaN(v0)) {
                v0 = Math.abs(Float.intBitsToFloat(((int)(this.start >> v2))) - Float.intBitsToFloat(((int)(this.end >> v2))));
            }
            else {
                goto label_29;
            }
        }

        long v6 = 0xFFFFFFFFL;
        float v1 = Float.intBitsToFloat(((int)(this.start & v6)));
        if(!Float.isInfinite(v1) && !Float.isNaN(v1)) {
            v1 = Float.intBitsToFloat(((int)(this.end & v6)));
            if(!Float.isInfinite(v1) && !Float.isNaN(v1)) {
                v3 = Math.abs(Float.intBitsToFloat(((int)(this.start & v6))) - Float.intBitsToFloat(((int)(this.end & v6))));
            }
        }

        return Size.constructor-impl((((long)Float.floatToRawIntBits(v0))) << v2 | (((long)Float.floatToRawIntBits(v3))) & v6);
    }

    public final long getStart-F1C5BW0$ui_graphics() {
        return this.start;
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
        return (((v0 + v1_1) * 0x1F + Offset.hashCode-impl(this.start)) * 0x1F + Offset.hashCode-impl(this.end)) * 0x1F + TileMode.hashCode-impl(this.tileMode);
    }

    public Object lerp(Object arg18, float arg19) {
        Object v3_1;
        LinearGradient v0 = this;
        float v1 = arg19;
        DefaultConstructorMarker v2 = null;
        if(arg18 == null) {
            SolidColor v3 = new SolidColor(Color.Companion.getTransparent-0d7_KjU(), v2);
        }
        else {
            v3_1 = arg18;
        }

        if(((((SolidColor)v3_1)) instanceof SolidColor)) {
            List v4 = v0.colors;
            ArrayList v5 = new ArrayList(v4.size());
            int v6 = v4.size();
            int v7;
            for(v7 = 0; v7 < v6; ++v7) {
                v4.get(v7).unbox-impl();
                v5.add(Color.box-impl(((SolidColor)v3_1).getValue-0d7_KjU()));
            }

            LinearGradient v3_2 = new LinearGradient(v5, v0.stops, v0.start, v0.end, v0.tileMode, null);
        }

        if(((((SolidColor)v3_1)) instanceof LinearGradient)) {
            List v6_1 = BrushKt.lerpColorList(v0.colors, ((LinearGradient)v3_1).colors, v1);
            List v7_1 = BrushKt.lerpNullableFloatList(v0.stops, ((LinearGradient)v3_1).stops, v1);
            long v8 = BrushKt.lerpSafe-Wko1d7g(v0.start, ((LinearGradient)v3_1).start, v1);
            long v10 = BrushKt.lerpSafe-Wko1d7g(v0.end, ((LinearGradient)v3_1).end, v1);
            int v0_1 = v1 < 0.5f ? v0.tileMode : ((LinearGradient)v3_1).tileMode;
            return new LinearGradient(v6_1, v7_1, v8, v10, v0_1, null);
        }

        return v2;
    }

    public String toString() {
        long v2 = 0x7F8000007F800000L;
        long v4 = 0x100000001L;
        long v6 = -9223372034707292160L;
        long v8 = 0;
        String v1 = "";
        String v10 = ", ";
        String v0 = Long.compare((this.start & v2 ^ v2) - v4 & v6, v8) == 0 ? "start=" + Offset.toString-impl(this.start) + v10 : v1;
        if(((v2 ^ this.end & v2) - v4 & v6) == v8) {
            v1 = "end=" + Offset.toString-impl(this.end) + v10;
        }

        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + v10 + v0 + v1 + "tileMode=" + TileMode.toString-impl(this.tileMode) + ')';
    }
}

