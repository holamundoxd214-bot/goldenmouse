package androidx.compose.ui.unit;

import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0003H\u0016J\u0010\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0003H\u0016J\t\u0010\n\u001A\u00020\u0003HÂ\u0003J\u0013\u0010\u000B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FHÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/compose/ui/unit/LinearFontScaleConverter;", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "fontScale", "", "<init>", "(F)V", "convertSpToDp", "sp", "convertDpToSp", "dp", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) final class LinearFontScaleConverter implements FontScaleConverter {
    private final float fontScale;

    public LinearFontScaleConverter(float arg1) {
        super();
        this.fontScale = arg1;
    }

    private final float component1() {
        return this.fontScale;
    }

    public float convertDpToSp(float arg1) {
        return arg1 / this.fontScale;
    }

    public float convertSpToDp(float arg1) {
        return arg1 * this.fontScale;
    }

    public final LinearFontScaleConverter copy(float arg1) {
        return new LinearFontScaleConverter(arg1);
    }

    public static LinearFontScaleConverter copy$default(LinearFontScaleConverter arg0, float arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.fontScale;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((LinearFontScaleConverter)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof LinearFontScaleConverter)) {
            return 0;
        }

        if(Float.compare(this.fontScale, ((LinearFontScaleConverter)arg4).fontScale) != 0) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return Float.hashCode(this.fontScale);
    }

    public String toString() {
        return "LinearFontScaleConverter(fontScale=" + this.fontScale + ')';
    }
}

