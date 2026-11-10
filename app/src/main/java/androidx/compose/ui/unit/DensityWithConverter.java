package androidx.compose.ui.unit;

import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\f\u001A\u00020\r*\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u0013\u0010\u0011\u001A\u00020\u000E*\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0006HÂ\u0003J\'\u0010\u0017\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BHÖ\u0003J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Landroidx/compose/ui/unit/DensityWithConverter;", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "converter", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "<init>", "(FFLandroidx/compose/ui/unit/fontscaling/FontScaleConverter;)V", "getDensity", "()F", "getFontScale", "toSp", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/ui/unit/Dp;", "toSp-0xMU5do", "(F)J", "toDp", "toDp-GaN1DYA", "(J)F", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) final class DensityWithConverter implements Density {
    private final FontScaleConverter converter;
    private final float density;
    private final float fontScale;

    public DensityWithConverter(float arg1, float arg2, FontScaleConverter arg3) {
        super();
        this.density = arg1;
        this.fontScale = arg2;
        this.converter = arg3;
    }

    public final float component1() {
        return this.density;
    }

    public final float component2() {
        return this.fontScale;
    }

    private final FontScaleConverter component3() {
        return this.converter;
    }

    public final DensityWithConverter copy(float arg1, float arg2, FontScaleConverter arg3) {
        return new DensityWithConverter(arg1, arg2, arg3);
    }

    public static DensityWithConverter copy$default(DensityWithConverter arg0, float arg1, float arg2, FontScaleConverter arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.density;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.fontScale;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.converter;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((DensityWithConverter)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof DensityWithConverter)) {
            return 0;
        }

        if(Float.compare(this.density, ((DensityWithConverter)arg5).density) != 0) {
            return 0;
        }

        if(Float.compare(this.fontScale, ((DensityWithConverter)arg5).fontScale) != 0) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.converter, ((DensityWithConverter)arg5).converter)) {
            return 0;
        }

        return 1;
    }

    public float getDensity() {
        return this.density;
    }

    public float getFontScale() {
        return this.fontScale;
    }

    public int hashCode() {
        return (Float.hashCode(this.density) * 0x1F + Float.hashCode(this.fontScale)) * 0x1F + this.converter.hashCode();
    }

    public float toDp-GaN1DYA(long arg5) {
        if(TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(arg5), TextUnitType.Companion.getSp-UIouoOA())) {
            return Dp.constructor-impl(this.converter.convertSpToDp(TextUnit.getValue-impl(arg5)));
        }

        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    public long toSp-0xMU5do(float arg1) {
        return TextUnitKt.getSp(this.converter.convertDpToSp(arg1));
    }

    public String toString() {
        return "DensityWithConverter(density=" + this.density + ", fontScale=" + this.fontScale + ", converter=" + this.converter + ')';
    }
}

