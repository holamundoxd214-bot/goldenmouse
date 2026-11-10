package androidx.compose.foundation.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2={"Landroidx/compose/foundation/layout/FlowLayoutData;", "", "fillCrossAxisFraction", "", "<init>", "(F)V", "getFillCrossAxisFraction", "()F", "setFillCrossAxisFraction", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FlowLayoutData {
    public static final int $stable = 8;
    private float fillCrossAxisFraction;

    static {
    }

    public FlowLayoutData(float arg1) {
        super();
        this.fillCrossAxisFraction = arg1;
    }

    public final float component1() {
        return this.fillCrossAxisFraction;
    }

    public final FlowLayoutData copy(float arg1) {
        return new FlowLayoutData(arg1);
    }

    public static FlowLayoutData copy$default(FlowLayoutData arg0, float arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.fillCrossAxisFraction;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((FlowLayoutData)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof FlowLayoutData)) {
            return 0;
        }

        if(Float.compare(this.fillCrossAxisFraction, ((FlowLayoutData)arg4).fillCrossAxisFraction) != 0) {
            return 0;
        }

        return 1;
    }

    public final float getFillCrossAxisFraction() {
        return this.fillCrossAxisFraction;
    }

    public int hashCode() {
        return Float.hashCode(this.fillCrossAxisFraction);
    }

    public final void setFillCrossAxisFraction(float arg1) {
        this.fillCrossAxisFraction = arg1;
    }

    public String toString() {
        return "FlowLayoutData(fillCrossAxisFraction=" + this.fillCrossAxisFraction + ')';
    }
}

