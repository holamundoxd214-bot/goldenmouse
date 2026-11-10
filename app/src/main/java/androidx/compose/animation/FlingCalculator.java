package androidx.compose.animation;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000B\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0002J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0003H\u0002J\u000E\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\u0003J\u000E\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u0003J\u000E\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\u0003R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000E\u0010\n\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/animation/FlingCalculator;", "", "friction", "", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(FLandroidx/compose/ui/unit/Density;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "magicPhysicalCoefficient", "computeDeceleration", "getSplineDeceleration", "", "velocity", "flingDuration", "", "flingDistance", "flingInfo", "Landroidx/compose/animation/FlingCalculator$FlingInfo;", "FlingInfo", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FlingCalculator {
    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000E\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0006J\u000E\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0006J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0006HÆ\u0003J\'\u0010\u0014\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u001C"}, d2={"Landroidx/compose/animation/FlingCalculator$FlingInfo;", "", "initialVelocity", "", "distance", "duration", "", "<init>", "(FFJ)V", "getInitialVelocity", "()F", "getDistance", "getDuration", "()J", "position", "time", "velocity", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FlingInfo {
        public static final int $stable;
        private final float distance;
        private final long duration;
        private final float initialVelocity;

        static {
        }

        public FlingInfo(float arg1, float arg2, long arg3) {
            super();
            this.initialVelocity = arg1;
            this.distance = arg2;
            this.duration = arg3;
        }

        public final float component1() {
            return this.initialVelocity;
        }

        public final float component2() {
            return this.distance;
        }

        public final long component3() {
            return this.duration;
        }

        public final FlingInfo copy(float arg1, float arg2, long arg3) {
            return new FlingInfo(arg1, arg2, arg3);
        }

        public static FlingInfo copy$default(FlingInfo arg0, float arg1, float arg2, long arg3, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.initialVelocity;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.distance;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.duration;
            }

            return arg0.copy(arg1, arg2, arg3);
        }

        public boolean equals(Object arg6) {
            if(this == (((FlingInfo)arg6))) {
                return 1;
            }

            if(!(arg6 instanceof FlingInfo)) {
                return 0;
            }

            if(Float.compare(this.initialVelocity, ((FlingInfo)arg6).initialVelocity) != 0) {
                return 0;
            }

            if(Float.compare(this.distance, ((FlingInfo)arg6).distance) != 0) {
                return 0;
            }

            if(this.duration != ((FlingInfo)arg6).duration) {
                return 0;
            }

            return 1;
        }

        public final float getDistance() {
            return this.distance;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final float getInitialVelocity() {
            return this.initialVelocity;
        }

        public int hashCode() {
            return (Float.hashCode(this.initialVelocity) * 0x1F + Float.hashCode(this.distance)) * 0x1F + Long.hashCode(this.duration);
        }

        public final float position(long arg5) {
            long v0 = this.duration;
            float v5 = v0 > 0 ? (((float)arg5)) / (((float)v0)) : 1f;
            return this.distance * Math.signum(this.initialVelocity) * AndroidFlingSpline.INSTANCE.flingPosition(v5).getDistanceCoefficient();
        }

        public String toString() {
            return "FlingInfo(initialVelocity=" + this.initialVelocity + ", distance=" + this.distance + ", duration=" + this.duration + ')';
        }

        public final float velocity(long arg5) {
            long v0 = this.duration;
            float v5 = v0 > 0 ? (((float)arg5)) / (((float)v0)) : 1f;
            return AndroidFlingSpline.INSTANCE.flingPosition(v5).getVelocityCoefficient() * Math.signum(this.initialVelocity) * this.distance / (((float)this.duration)) * 1000f;
        }
    }

    public static final int $stable;
    private final Density density;
    private final float friction;
    private final float magicPhysicalCoefficient;

    static {
    }

    public FlingCalculator(float arg1, Density arg2) {
        super();
        this.friction = arg1;
        this.density = arg2;
        this.magicPhysicalCoefficient = this.computeDeceleration(arg2);
    }

    private final float computeDeceleration(Density arg1) {
        return FlingCalculatorKt.access$computeDeceleration(0.84f, arg1.getDensity());
    }

    public final float flingDistance(float arg7) {
        return ((float)((((double)(this.friction * this.magicPhysicalCoefficient))) * Math.exp((((double)FlingCalculatorKt.access$getDecelerationRate$p())) / ((((double)FlingCalculatorKt.access$getDecelerationRate$p())) - 1) * this.getSplineDeceleration(arg7))));
    }

    public final long flingDuration(float arg5) {
        return ((long)(Math.exp(this.getSplineDeceleration(arg5) / ((((double)FlingCalculatorKt.access$getDecelerationRate$p())) - 1)) * 1000));
    }

    public final FlingInfo flingInfo(float arg10) {
        double v0 = this.getSplineDeceleration(arg10);
        double v2 = (((double)FlingCalculatorKt.access$getDecelerationRate$p())) - 1;
        return new FlingInfo(arg10, ((float)((((double)(this.friction * this.magicPhysicalCoefficient))) * Math.exp((((double)FlingCalculatorKt.access$getDecelerationRate$p())) / v2 * v0))), ((long)(Math.exp(v0 / v2) * 1000)));
    }

    public final Density getDensity() {
        return this.density;
    }

    private final double getSplineDeceleration(float arg3) {
        return AndroidFlingSpline.INSTANCE.deceleration(arg3, this.friction * this.magicPhysicalCoefficient);
    }
}

