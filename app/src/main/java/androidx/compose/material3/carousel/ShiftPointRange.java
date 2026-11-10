package androidx.compose.material3.carousel;

import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0006HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0018"}, d2={"Landroidx/compose/material3/carousel/ShiftPointRange;", "", "fromStepIndex", "", "toStepIndex", "steppedInterpolation", "", "<init>", "(IIF)V", "getFromStepIndex", "()I", "getToStepIndex", "getSteppedInterpolation", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ShiftPointRange {
    private final int fromStepIndex;
    private final float steppedInterpolation;
    private final int toStepIndex;

    public ShiftPointRange(int arg1, int arg2, float arg3) {
        super();
        this.fromStepIndex = arg1;
        this.toStepIndex = arg2;
        this.steppedInterpolation = arg3;
    }

    public final int component1() {
        return this.fromStepIndex;
    }

    public final int component2() {
        return this.toStepIndex;
    }

    public final float component3() {
        return this.steppedInterpolation;
    }

    public final ShiftPointRange copy(int arg1, int arg2, float arg3) {
        return new ShiftPointRange(arg1, arg2, arg3);
    }

    public static ShiftPointRange copy$default(ShiftPointRange arg0, int arg1, int arg2, float arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.fromStepIndex;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.toStepIndex;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.steppedInterpolation;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((ShiftPointRange)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ShiftPointRange)) {
            return 0;
        }

        if(this.fromStepIndex != ((ShiftPointRange)arg5).fromStepIndex) {
            return 0;
        }

        if(this.toStepIndex != ((ShiftPointRange)arg5).toStepIndex) {
            return 0;
        }

        if(Float.compare(this.steppedInterpolation, ((ShiftPointRange)arg5).steppedInterpolation) != 0) {
            return 0;
        }

        return 1;
    }

    public final int getFromStepIndex() {
        return this.fromStepIndex;
    }

    public final float getSteppedInterpolation() {
        return this.steppedInterpolation;
    }

    public final int getToStepIndex() {
        return this.toStepIndex;
    }

    public int hashCode() {
        return (Integer.hashCode(this.fromStepIndex) * 0x1F + Integer.hashCode(this.toStepIndex)) * 0x1F + Float.hashCode(this.steppedInterpolation);
    }

    public String toString() {
        return "ShiftPointRange(fromStepIndex=" + this.fromStepIndex + ", toStepIndex=" + this.toStepIndex + ", steppedInterpolation=" + this.steppedInterpolation + ')';
    }
}

