package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BE\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n\u0012\b\b\u0001\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u000F\u0010\u0010BA\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0003\u0010\u000B\u001A\u00020\f\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u000F\u0010\u0011BC\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0003\u0010\u000B\u001A\u00020\f\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u000F\u0010\u0012J\u0013\u0010!\u001A\u00020\"2\b\u0010#\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010$\u001A\u00020%H\u0016J\b\u0010&\u001A\u00020\'H\u0016J\r\u0010(\u001A\u00020\u0000H\u0000¢\u0006\u0002\b)J\r\u0010*\u001A\u00020\u0000H\u0000¢\u0006\u0002\b+R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0005\u001A\u00020\u0006¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u0017\u0010\u0018R\u0013\u0010\r\u001A\u00020\u000E¢\u0006\n\n\u0002\u0010\u001C\u001A\u0004\b\u001A\u0010\u001BR\u0013\u0010\u0007\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u001D\u0010\u0018R\u0013\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u0014¨\u0006,"}, d2={"Landroidx/compose/ui/graphics/shadow/Shadow;", "", "radius", "Landroidx/compose/ui/unit/Dp;", "spread", "offset", "Landroidx/compose/ui/unit/DpOffset;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "<init>", "(FFJJLandroidx/compose/ui/graphics/Brush;FILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(FLandroidx/compose/ui/graphics/Brush;FJFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(FJFJFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRadius-D9Ej5fM", "()F", "F", "getSpread-D9Ej5fM", "getOffset-RKDOV3M", "()J", "J", "getBlendMode-0nO6VwU", "()I", "I", "getColor-0d7_KjU", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getAlpha", "equals", "", "other", "hashCode", "", "toString", "", "copyWithoutOffset", "copyWithoutOffset$ui_graphics", "transparentCopy", "transparentCopy$ui_graphics", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Shadow {
    public static final int $stable;
    private final float alpha;
    private final int blendMode;
    private final Brush brush;
    private final long color;
    private final long offset;
    private final float radius;
    private final float spread;

    static {
    }

    public Shadow(float arg1, Brush arg2, float arg3, long arg4, float arg6, int arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg6, arg7);
    }

    public Shadow(float arg1, long arg2, float arg4, long arg5, float arg7, int arg8, DefaultConstructorMarker arg9) {
        this(arg1, arg2, arg4, arg5, arg7, arg8);
    }

    private Shadow(float arg1, float arg2, long arg3, long arg5, Brush arg7, float arg8, int arg9) {
        super();
        this.radius = arg1;
        this.spread = arg2;
        this.offset = arg3;
        this.blendMode = arg9;
        if((arg7 instanceof SolidColor)) {
            this.color = ((SolidColor)arg7).getValue-0d7_KjU();
            this.brush = null;
        }
        else {
            this.color = arg5;
            this.brush = arg7;
        }

        this.alpha = RangesKt.coerceIn(arg8, 0f, 1f);
    }

    public Shadow(float arg1, float arg2, long arg3, long arg5, Brush arg7, float arg8, int arg9, DefaultConstructorMarker arg10) {
        this(arg1, arg2, arg3, arg5, arg7, arg8, arg9);
    }

    private Shadow(float arg14, long arg15, float arg17, long arg18, float arg20, int arg21) {
        long v7 = arg15 != 16 ? arg15 : Color.Companion.getBlack-0d7_KjU();
        this(arg14, arg17, arg18, v7, null, arg20, arg21, null);
    }

    public Shadow(float arg11, long arg12, float arg14, long arg15, float arg17, int arg18, int arg19, DefaultConstructorMarker arg20) {
        if((arg19 & 2) != 0) {
            arg12 = Color.Companion.getBlack-0d7_KjU();
        }

        long v2 = arg12;
        float v4 = (arg19 & 4) != 0 ? Dp.constructor-impl(0f) : arg14;
        long v5 = (arg19 & 8) != 0 ? DpOffset.Companion.getZero-RKDOV3M() : arg15;
        float v7 = (arg19 & 16) != 0 ? 1f : arg17;
        int v8 = (arg19 & 0x20) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg18;
        this(arg11, v2, v4, v5, v7, v8, null);
    }

    private Shadow(float arg13, Brush arg14, float arg15, long arg16, float arg18, int arg19) {
        this(arg13, arg15, arg16, Color.Companion.getBlack-0d7_KjU(), arg14, arg18, arg19, null);
    }

    public Shadow(float arg10, Brush arg11, float arg12, long arg13, float arg15, int arg16, int arg17, DefaultConstructorMarker arg18) {
        if((arg17 & 4) != 0) {
            arg12 = Dp.constructor-impl(0f);
        }

        float v3 = arg12;
        if((arg17 & 8) != 0) {
            arg13 = DpOffset.Companion.getZero-RKDOV3M();
        }

        long v4 = arg13;
        float v6 = (arg17 & 16) != 0 ? 1f : arg15;
        int v7 = (arg17 & 0x20) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg16;
        this(arg10, arg11, v3, v4, v6, v7, null);
    }

    public final Shadow copyWithoutOffset$ui_graphics() {
        return new Shadow(this.radius, this.spread, DpOffset.Companion.getZero-RKDOV3M(), this.color, this.brush, this.alpha, this.blendMode, null);
    }

    public boolean equals(Object arg8) {
        if(this == (((Shadow)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof Shadow)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.radius, ((Shadow)arg8).radius)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.spread, ((Shadow)arg8).spread)) {
            return 0;
        }

        if(!DpOffset.equals-impl0(this.offset, ((Shadow)arg8).offset)) {
            return 0;
        }

        if(this.alpha == ((Shadow)arg8).alpha) {
            if(!BlendMode.equals-impl0(this.blendMode, ((Shadow)arg8).blendMode)) {
                return 0;
            }

            if(!Color.equals-impl0(this.color, ((Shadow)arg8).color)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.brush, ((Shadow)arg8).brush)) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final int getBlendMode-0nO6VwU() {
        return this.blendMode;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final long getColor-0d7_KjU() {
        return this.color;
    }

    public final long getOffset-RKDOV3M() {
        return this.offset;
    }

    public final float getRadius-D9Ej5fM() {
        return this.radius;
    }

    public final float getSpread-D9Ej5fM() {
        return this.spread;
    }

    public int hashCode() {
        int v0 = (((((Dp.hashCode-impl(this.radius) * 0x1F + Dp.hashCode-impl(this.spread)) * 0x1F + DpOffset.hashCode-impl(this.offset)) * 0x1F + Float.hashCode(this.alpha)) * 0x1F + BlendMode.hashCode-impl(this.blendMode)) * 0x1F + Color.hashCode-impl(this.color)) * 0x1F;
        Brush v3 = this.brush;
        int v3_1 = v3 != null ? v3.hashCode() : 0;
        return v0 + v3_1;
    }

    public String toString() {
        return "Shadow(radius=" + Dp.toString-impl(this.radius) + ", spread=" + Dp.toString-impl(this.spread) + ", offset=" + DpOffset.toString-impl(this.offset) + ", alpha=" + this.alpha + ", blendMode=" + BlendMode.toString-impl(this.blendMode) + ", color=" + Color.toString-impl(this.color) + ", brush=" + this.brush + ')';
    }

    public final Shadow transparentCopy$ui_graphics() {
        return new Shadow(this.radius, Color.Companion.getTransparent-0d7_KjU(), this.spread, this.offset, this.alpha, this.blendMode, null);
    }
}

