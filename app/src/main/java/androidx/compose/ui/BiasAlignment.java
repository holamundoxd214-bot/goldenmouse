package androidx.compose.ui;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\u001E\u001FB\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\'\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006 "}, d2={"Landroidx/compose/ui/BiasAlignment;", "Landroidx/compose/ui/Alignment;", "horizontalBias", "", "verticalBias", "<init>", "(FF)V", "getHorizontalBias", "()F", "getVerticalBias", "align", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "align-KFBX0sM", "(JJLandroidx/compose/ui/unit/LayoutDirection;)J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Horizontal", "Vertical", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BiasAlignment implements Alignment {
    @Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\rH\u0016J\u0011\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0096\u0002J\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0010\u001A\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001A\u00020\tHÖ\u0001J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u001A"}, d2={"Landroidx/compose/ui/BiasAlignment$Horizontal;", "Landroidx/compose/ui/Alignment$Horizontal;", "bias", "", "<init>", "(F)V", "getBias", "()F", "align", "", "size", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "plus", "Landroidx/compose/ui/Alignment;", "other", "Landroidx/compose/ui/Alignment$Vertical;", "component1", "copy", "equals", "", "", "hashCode", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Horizontal implements androidx.compose.ui.Alignment$Horizontal {
        public static final int $stable;
        private final float bias;

        static {
        }

        public Horizontal(float arg1) {
            super();
            this.bias = arg1;
        }

        public int align(int arg1, int arg2, LayoutDirection arg3) {
            float v1 = (((float)(arg2 - arg1))) / 2f;
            LayoutDirection v2 = LayoutDirection.Ltr;
            float v0 = this.bias;
            if(arg3 == v2) {
            }
            else {
                v0 *= -1f;
            }

            return Math.round(v1 * (1f + v0));
        }

        public final float component1() {
            return this.bias;
        }

        public final Horizontal copy(float arg1) {
            return new Horizontal(arg1);
        }

        public static Horizontal copy$default(Horizontal arg0, float arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.bias;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((Horizontal)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Horizontal)) {
                return 0;
            }

            if(Float.compare(this.bias, ((Horizontal)arg4).bias) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getBias() {
            return this.bias;
        }

        public int hashCode() {
            return Float.hashCode(this.bias);
        }

        public Alignment plus(Vertical arg2) {
            if((arg2 instanceof androidx.compose.ui.BiasAlignment$Vertical)) {
                return new BiasAlignment(this.bias, ((androidx.compose.ui.BiasAlignment$Vertical)arg2).getBias());
            }

            return androidx.compose.ui.Alignment$Horizontal.super.plus(arg2);
        }

        public String toString() {
            return "Horizontal(bias=" + this.bias + ')';
        }
    }

    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\tH\u0016J\u0011\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0096\u0002J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u000E\u001A\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001A\u00020\tHÖ\u0001J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2={"Landroidx/compose/ui/BiasAlignment$Vertical;", "Landroidx/compose/ui/Alignment$Vertical;", "bias", "", "<init>", "(F)V", "getBias", "()F", "align", "", "size", "space", "plus", "Landroidx/compose/ui/Alignment;", "other", "Landroidx/compose/ui/Alignment$Horizontal;", "component1", "copy", "equals", "", "", "hashCode", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.BiasAlignment$Vertical implements Vertical {
        public static final int $stable;
        private final float bias;

        static {
        }

        public androidx.compose.ui.BiasAlignment$Vertical(float arg1) {
            super();
            this.bias = arg1;
        }

        public int align(int arg1, int arg2) {
            return Math.round((((float)(arg2 - arg1))) / 2f * (1f + this.bias));
        }

        public final float component1() {
            return this.bias;
        }

        public final androidx.compose.ui.BiasAlignment$Vertical copy(float arg1) {
            return new androidx.compose.ui.BiasAlignment$Vertical(arg1);
        }

        public static androidx.compose.ui.BiasAlignment$Vertical copy$default(androidx.compose.ui.BiasAlignment$Vertical arg0, float arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.bias;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((androidx.compose.ui.BiasAlignment$Vertical)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof androidx.compose.ui.BiasAlignment$Vertical)) {
                return 0;
            }

            if(Float.compare(this.bias, ((androidx.compose.ui.BiasAlignment$Vertical)arg4).bias) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getBias() {
            return this.bias;
        }

        public int hashCode() {
            return Float.hashCode(this.bias);
        }

        public Alignment plus(androidx.compose.ui.Alignment$Horizontal arg2) {
            if((arg2 instanceof Horizontal)) {
                return new BiasAlignment(((Horizontal)arg2).getBias(), this.bias);
            }

            if((arg2 instanceof androidx.compose.ui.BiasAbsoluteAlignment$Horizontal)) {
                return new BiasAbsoluteAlignment(((androidx.compose.ui.BiasAbsoluteAlignment$Horizontal)arg2).getBias(), this.bias);
            }

            return Vertical.super.plus(arg2);
        }

        public String toString() {
            return "Vertical(bias=" + this.bias + ')';
        }
    }

    public static final int $stable;
    private final float horizontalBias;
    private final float verticalBias;

    static {
    }

    public BiasAlignment(float arg1, float arg2) {
        super();
        this.horizontalBias = arg1;
        this.verticalBias = arg2;
    }

    public long align-KFBX0sM(long arg6, long arg8, LayoutDirection arg10) {
        int v0 = 0x20;
        float v1 = (((float)((((int)(arg8 >> v0))) - (((int)(arg6 >> v0)))))) / 2f;
        long v3 = 0xFFFFFFFFL;
        float v6 = (((float)((((int)(arg8 & v3))) - (((int)(arg6 & v3)))))) / 2f;
        LayoutDirection v7 = LayoutDirection.Ltr;
        float v8 = this.horizontalBias;
        if(arg10 == v7) {
        }
        else {
            v8 *= -1f;
        }

        return IntOffset.constructor-impl((((long)Math.round(v6 * (1f + this.verticalBias)))) & v3 | (((long)Math.round(v1 * (v8 + 1f)))) << v0);
    }

    public final float component1() {
        return this.horizontalBias;
    }

    public final float component2() {
        return this.verticalBias;
    }

    public final BiasAlignment copy(float arg1, float arg2) {
        return new BiasAlignment(arg1, arg2);
    }

    public static BiasAlignment copy$default(BiasAlignment arg0, float arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.horizontalBias;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.verticalBias;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((BiasAlignment)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof BiasAlignment)) {
            return 0;
        }

        if(Float.compare(this.horizontalBias, ((BiasAlignment)arg5).horizontalBias) != 0) {
            return 0;
        }

        if(Float.compare(this.verticalBias, ((BiasAlignment)arg5).verticalBias) != 0) {
            return 0;
        }

        return 1;
    }

    public final float getHorizontalBias() {
        return this.horizontalBias;
    }

    public final float getVerticalBias() {
        return this.verticalBias;
    }

    public int hashCode() {
        return Float.hashCode(this.horizontalBias) * 0x1F + Float.hashCode(this.verticalBias);
    }

    public String toString() {
        return "BiasAlignment(horizontalBias=" + this.horizontalBias + ", verticalBias=" + this.verticalBias + ')';
    }
}

