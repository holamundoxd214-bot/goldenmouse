package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2={"Landroidx/compose/ui/layout/FixedScale;", "Landroidx/compose/ui/layout/ContentScale;", "value", "", "<init>", "(F)V", "getValue", "()F", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FixedScale implements ContentScale {
    public static final int $stable;
    private final float value;

    static {
    }

    public FixedScale(float arg1) {
        super();
        this.value = arg1;
    }

    public final float component1() {
        return this.value;
    }

    public long computeScaleFactor-H7hwNQA(long arg3, long arg5) {
        return ScaleFactor.constructor-impl((((long)Float.floatToRawIntBits(this.value))) << 0x20 | (((long)Float.floatToRawIntBits(this.value))) & 0xFFFFFFFFL);
    }

    public final FixedScale copy(float arg1) {
        return new FixedScale(arg1);
    }

    public static FixedScale copy$default(FixedScale arg0, float arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.value;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((FixedScale)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof FixedScale)) {
            return 0;
        }

        if(Float.compare(this.value, ((FixedScale)arg4).value) != 0) {
            return 0;
        }

        return 1;
    }

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        return Float.hashCode(this.value);
    }

    public String toString() {
        return "FixedScale(value=" + this.value + ')';
    }
}

