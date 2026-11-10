package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fJ\u0016\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/compose/animation/AndroidFlingSpline;", "", "<init>", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "flingPosition", "Landroidx/compose/animation/AndroidFlingSpline$FlingResult;", "time", "", "deceleration", "", "velocity", "friction", "FlingResult", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidFlingSpline {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0014"}, d2={"Landroidx/compose/animation/AndroidFlingSpline$FlingResult;", "", "distanceCoefficient", "", "velocityCoefficient", "<init>", "(FF)V", "getDistanceCoefficient", "()F", "getVelocityCoefficient", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FlingResult {
        public static final int $stable;
        private final float distanceCoefficient;
        private final float velocityCoefficient;

        static {
        }

        public FlingResult(float arg1, float arg2) {
            super();
            this.distanceCoefficient = arg1;
            this.velocityCoefficient = arg2;
        }

        public final float component1() {
            return this.distanceCoefficient;
        }

        public final float component2() {
            return this.velocityCoefficient;
        }

        public final FlingResult copy(float arg1, float arg2) {
            return new FlingResult(arg1, arg2);
        }

        public static FlingResult copy$default(FlingResult arg0, float arg1, float arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.distanceCoefficient;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.velocityCoefficient;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((FlingResult)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof FlingResult)) {
                return 0;
            }

            if(Float.compare(this.distanceCoefficient, ((FlingResult)arg5).distanceCoefficient) != 0) {
                return 0;
            }

            if(Float.compare(this.velocityCoefficient, ((FlingResult)arg5).velocityCoefficient) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getDistanceCoefficient() {
            return this.distanceCoefficient;
        }

        public final float getVelocityCoefficient() {
            return this.velocityCoefficient;
        }

        public int hashCode() {
            return Float.hashCode(this.distanceCoefficient) * 0x1F + Float.hashCode(this.velocityCoefficient);
        }

        public String toString() {
            return "FlingResult(distanceCoefficient=" + this.distanceCoefficient + ", velocityCoefficient=" + this.velocityCoefficient + ')';
        }
    }

    public static final int $stable = 0;
    public static final AndroidFlingSpline INSTANCE = null;
    private static final int NbSamples = 100;
    private static final float[] SplinePositions;
    private static final float[] SplineTimes;

    static {
        AndroidFlingSpline.INSTANCE = new AndroidFlingSpline();
        float[] v1 = new float[101];
        AndroidFlingSpline.SplinePositions = v1;
        float[] v0 = new float[101];
        AndroidFlingSpline.SplineTimes = v0;
        SplineBasedDecayKt.access$computeSplineInfo(v1, v0, 100);
        AndroidFlingSpline.$stable = 8;
    }

    private AndroidFlingSpline() {
        super();
    }

    public final double deceleration(float arg3, float arg4) {
        return Math.log((((double)(Math.abs(arg3) * 0.35f))) / (((double)arg4)));
    }

    public final FlingResult flingPosition(float arg6) {
        float v5 = 0f;
        float v0 = 1f;
        arg6 = RangesKt.coerceIn(arg6, 0f, v0);
        float v1 = 100f;
        int v2 = ((int)(v1 * arg6));
        if(v2 < 100) {
            v5 = (((float)v2)) / v1;
            int v0_1 = v2 + 1;
            float v3 = (((float)v0_1)) / v1;
            float[] v1_1 = AndroidFlingSpline.SplinePositions;
            float v2_1 = v1_1[v2];
            v0 = (v1_1[v0_1] - v2_1) / (v3 - v5);
            float v4 = v0;
            v0 = v2_1 + (arg6 - v5) * v0;
            v5 = v4;
        }

        return new FlingResult(v0, v5);
    }
}

