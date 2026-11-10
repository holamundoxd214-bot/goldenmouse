package androidx.compose.ui.unit;

import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/ui/unit/DensityImpl;", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "<init>", "(FF)V", "getDensity", "()F", "getFontScale", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) final class DensityImpl implements Density {
    private final float density;
    private final float fontScale;

    public DensityImpl(float arg1, float arg2) {
        super();
        this.density = arg1;
        this.fontScale = arg2;
    }

    public final float component1() {
        return this.density;
    }

    public final float component2() {
        return this.fontScale;
    }

    public final DensityImpl copy(float arg1, float arg2) {
        return new DensityImpl(arg1, arg2);
    }

    public static DensityImpl copy$default(DensityImpl arg0, float arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.density;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.fontScale;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((DensityImpl)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof DensityImpl)) {
            return 0;
        }

        if(Float.compare(this.density, ((DensityImpl)arg5).density) != 0) {
            return 0;
        }

        if(Float.compare(this.fontScale, ((DensityImpl)arg5).fontScale) != 0) {
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
        return Float.hashCode(this.density) * 0x1F + Float.hashCode(this.fontScale);
    }

    public String toString() {
        return "DensityImpl(density=" + this.density + ", fontScale=" + this.fontScale + ')';
    }
}

