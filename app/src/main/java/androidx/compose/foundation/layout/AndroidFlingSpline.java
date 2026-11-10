package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\u0016\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\fR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/layout/AndroidFlingSpline;", "", "<init>", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "flingPosition", "Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "time", "", "flingPosition-LfoxSSI", "(F)J", "deceleration", "", "velocity", "friction", "FlingResult", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class AndroidFlingSpline {
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0011\u0010\n\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "", "packedValue", "", "constructor-impl", "(J)J", "distanceCoefficient", "", "getDistanceCoefficient-impl", "(J)F", "velocityCoefficient", "getVelocityCoefficient-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class FlingResult {
        private final long packedValue;

        private FlingResult(long arg1) {
            super();
            this.packedValue = arg1;
        }

        public static final FlingResult box-impl(long arg1) {
            return new FlingResult(arg1);
        }

        public static long constructor-impl(long arg0) {
            return arg0;
        }

        public boolean equals(Object arg3) {
            return FlingResult.equals-impl(this.packedValue, arg3);
        }

        public static boolean equals-impl(long arg4, Object arg6) {
            if(!(arg6 instanceof FlingResult)) {
                return 0;
            }

            if(arg4 != ((FlingResult)arg6).unbox-impl()) {
                return 0;
            }

            return 1;
        }

        public static final boolean equals-impl0(long arg0, long arg2) {
            if(arg0 == arg2) {
                return 1;
            }

            return 0;
        }

        public static final float getDistanceCoefficient-impl(long arg1) {
            return Float.intBitsToFloat(((int)(arg1 >> 0x20)));
        }

        public static final float getVelocityCoefficient-impl(long arg2) {
            return Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL)));
        }

        public int hashCode() {
            return FlingResult.hashCode-impl(this.packedValue);
        }

        public static int hashCode-impl(long arg0) {
            return Long.hashCode(arg0);
        }

        public String toString() {
            return FlingResult.toString-impl(this.packedValue);
        }

        public static String toString-impl(long arg2) {
            return "FlingResult(packedValue=" + arg2 + ')';
        }

        public final long unbox-impl() {
            return this.packedValue;
        }
    }

    public static final AndroidFlingSpline INSTANCE = null;
    private static final int NbSamples = 100;
    private static final float[] SplinePositions;
    private static final float[] SplineTimes;

    static {
        float v20;
        float v16;
        float v12;
        float v14;
        float v13;
        float v11;
        float v9;
        float v10;
        float v8;
        float v6;
        float v7;
        float v4;
        int v3;
        AndroidFlingSpline.INSTANCE = new AndroidFlingSpline();
        AndroidFlingSpline.SplinePositions = new float[101];
        AndroidFlingSpline.SplineTimes = new float[101];
        float v0 = 0f;
        int v2 = 0;
        float v1 = 0f;
        while(true) {
            v3 = 100;
            v4 = 1f;
            if(v2 >= v3) {
                break;
            }

            float v3_1 = (((float)v2)) / 100f;
            float v5;
            for(v5 = v4; true; v5 = v17) {
            label_19:
                v7 = 2f;
                v6 = (v5 - v0) / v7 + v0;
                v8 = 3f;
                v10 = v4 - v6;
                v9 = v6 * v8 * v10;
                v11 = 0.175f;
                v13 = 0.35f;
                v14 = v6 * v6 * v6;
                v12 = (v10 * v11 + v6 * v13) * v9 + v14;
                v16 = v4;
                float v17 = v5;
                double v18 = 0.00001;
                if((((double)Math.abs(v12 - v3_1))) < v18) {
                    break;
                }

                if(v12 > v3_1) {
                    v5 = v6;
                    v4 = v16;
                    goto label_19;
                }

                v0 = v6;
                v4 = v16;
            }

            v5 = 0.5f;
            AndroidFlingSpline.SplinePositions[v2] = v9 * (v10 * v5 + v6) + v14;
            v4 = v16;
            while(true) {
                v6 = (v4 - v1) / v7 + v1;
                v10 = v16 - v6;
                v9 = v6 * v8 * v10;
                v14 = v6 * v6 * v6;
                v12 = (v10 * v5 + v6) * v9 + v14;
                v20 = v6;
                if((((double)Math.abs(v12 - v3_1))) < v18) {
                    break;
                }

                if(v12 > v3_1) {
                    v4 = v20;
                }
                else {
                    v1 = v20;
                }

                v5 = 0.5f;
            }

            AndroidFlingSpline.SplineTimes[v2] = v9 * (v10 * v11 + v20 * v13) + v14;
            ++v2;
        }

        AndroidFlingSpline.SplineTimes[v3] = v4;
        AndroidFlingSpline.SplinePositions[v3] = v4;
    }

    private AndroidFlingSpline() {
        super();
    }

    public final double deceleration(float arg3, float arg4) {
        return Math.log((((double)(Math.abs(arg3) * 0.35f))) / (((double)arg4)));
    }

    public final long flingPosition-LfoxSSI(float arg5) {
        float v0_1;
        float v4 = 100f;
        int v0 = ((int)(v4 * arg5));
        if(v0 < 100) {
            float v1 = (((float)v0)) / v4;
            int v2 = v0 + 1;
            float v3 = (((float)v2)) / v4;
            float[] v4_1 = AndroidFlingSpline.SplinePositions;
            v0_1 = v4_1[v0];
            v4 = (v4_1[v2] - v0_1) / (v3 - v1);
            v0_1 += (arg5 - v1) * v4;
        }
        else {
            v0_1 = 1f;
            v4 = 0f;
        }

        return FlingResult.constructor-impl((((long)Float.floatToRawIntBits(v4))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v0_1))) << 0x20);
    }
}

