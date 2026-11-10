package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u0016\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u001AHÖ\u0003J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001J\t\u0010\u001D\u001A\u00020\u001EHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001F"}, d2={"Landroidx/compose/ui/text/style/BrushStyle;", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "value", "Landroidx/compose/ui/graphics/ShaderBrush;", "alpha", "", "<init>", "(Landroidx/compose/ui/graphics/ShaderBrush;F)V", "getValue", "()Landroidx/compose/ui/graphics/ShaderBrush;", "getAlpha", "()F", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class BrushStyle implements TextForegroundStyle {
    private final float alpha;
    private final ShaderBrush value;

    public BrushStyle(ShaderBrush arg1, float arg2) {
        super();
        this.value = arg1;
        this.alpha = arg2;
    }

    public final ShaderBrush component1() {
        return this.value;
    }

    public final float component2() {
        return this.alpha;
    }

    public final BrushStyle copy(ShaderBrush arg1, float arg2) {
        return new BrushStyle(arg1, arg2);
    }

    public static BrushStyle copy$default(BrushStyle arg0, ShaderBrush arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.value;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.alpha;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((BrushStyle)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof BrushStyle)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.value, ((BrushStyle)arg5).value)) {
            return 0;
        }

        if(Float.compare(this.alpha, ((BrushStyle)arg5).alpha) != 0) {
            return 0;
        }

        return 1;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public Brush getBrush() {
        return this.value;
    }

    public long getColor-0d7_KjU() {
        return Color.Companion.getUnspecified-0d7_KjU();
    }

    public final ShaderBrush getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() * 0x1F + Float.hashCode(this.alpha);
    }

    public String toString() {
        return "BrushStyle(value=" + this.value + ", alpha=" + this.alpha + ')';
    }
}

