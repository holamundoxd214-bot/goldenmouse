package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0013\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0007J\u001A\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BHÖ\u0003J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u0007R\u0016\u0010\u000B\u001A\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2={"Landroidx/compose/ui/text/style/ColorStyle;", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "value", "Landroidx/compose/ui/graphics/Color;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-0d7_KjU", "()J", "J", "color", "getColor-0d7_KjU", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "alpha", "", "getAlpha", "()F", "component1", "component1-0d7_KjU", "copy", "copy-8_81llA", "(J)Landroidx/compose/ui/text/style/ColorStyle;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class ColorStyle implements TextForegroundStyle {
    private final long value;

    public ColorStyle(long arg1, DefaultConstructorMarker arg3) {
        this(arg1);
    }

    private ColorStyle(long arg3) {
        super();
        this.value = arg3;
        int v2 = arg3 != 16 ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.");
        }
    }

    public final long component1-0d7_KjU() {
        return this.value;
    }

    public final ColorStyle copy-8_81llA(long arg2) {
        return new ColorStyle(arg2, null);
    }

    public static ColorStyle copy-8_81llA$default(ColorStyle arg0, long arg1, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.value;
        }

        return arg0.copy-8_81llA(arg1);
    }

    public boolean equals(Object arg6) {
        if(this == (((ColorStyle)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof ColorStyle)) {
            return 0;
        }

        if(!Color.equals-impl0(this.value, ((ColorStyle)arg6).value)) {
            return 0;
        }

        return 1;
    }

    public float getAlpha() {
        return Color.getAlpha-impl(this.getColor-0d7_KjU());
    }

    public Brush getBrush() {
        return null;
    }

    public long getColor-0d7_KjU() {
        return this.value;
    }

    public final long getValue-0d7_KjU() {
        return this.value;
    }

    public int hashCode() {
        return Color.hashCode-impl(this.value);
    }

    public String toString() {
        return "ColorStyle(value=" + Color.toString-impl(this.value) + ')';
    }
}

