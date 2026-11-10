package androidx.transition;

import java.util.Arrays;

class VelocityTracker1D {
    private static final int ASSUME_POINTER_MOVE_STOPPED_MILLIS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final int HORIZON_MILLIS = 100;
    private float[] mDataSamples;
    private int mIndex;
    private long[] mTimeSamples;

    VelocityTracker1D() {
        super();
        long[] v1 = new long[20];
        this.mTimeSamples = v1;
        this.mDataSamples = new float[20];
        this.mIndex = 0;
        Arrays.fill(v1, -9223372036854775808L);
    }

    public void addDataPoint(long arg3, float arg5) {
        int v0 = (this.mIndex + 1) % 20;
        this.mIndex = v0;
        this.mTimeSamples[v0] = arg3;
        this.mDataSamples[v0] = arg5;
    }

    float calculateVelocity() {
        float v4_1;
        int v12;
        long v10;
        int v0 = this.mIndex;
        long v1 = -9223372036854775808L;
        if(v0 == 0 && this.mTimeSamples[v0] == v1) {
            return 0;
        }

        long v5 = this.mTimeSamples[v0];
        int v4 = 0;
        long v7 = v5;
        while(true) {
            v10 = this.mTimeSamples[v0];
            v12 = 20;
            if(Long.compare(v10, v1) != 0) {
                float v7_1 = ((float)Math.abs(v10 - v7));
                if((((float)(v5 - v10))) <= 100f) {
                    if(v7_1 > 40f) {
                    }
                    else {
                        if(v0 == 0) {
                            v0 = v12;
                        }

                        --v0;
                        ++v4;
                        if(v4 >= v12) {
                            break;
                        }

                        v7 = v10;
                        continue;
                    }
                }
            }
            else {
            }

            break;
        }

        v0 = 2;
        if(v4 < v0) {
            return 0;
        }

        int v1_1 = this.mIndex;
        float v2 = 1000f;
        if(v4 == v0) {
            v0 = v1_1 == 0 ? 19 : v1_1 - 1;
            v4_1 = ((float)(this.mTimeSamples[v1_1] - this.mTimeSamples[v0]));
            if(v4_1 == 0f) {
                return 0;
            }

            return (this.mDataSamples[v1_1] - this.mDataSamples[v0]) / v4_1 * v2;
        }

        v0 = (v1_1 - v4 + 21) % v12;
        v1_1 = (v1_1 + 21) % v12;
        v5 = this.mTimeSamples[v0];
        v4_1 = this.mDataSamples[v0];
        ++v0;
        int v7_2 = v0 % 20;
        float v8 = 0f;
        while(v7_2 != v1_1) {
            v10 = this.mTimeSamples[v7_2];
            float v9 = ((float)(v10 - v5));
            if(v9 == 0f) {
            }
            else {
                float v5_1 = this.mDataSamples[v7_2];
                v4_1 = (v5_1 - v4_1) / v9;
                v8 += (v4_1 - this.kineticEnergyToVelocity(v8)) * Math.abs(v4_1);
                if(v7_2 == v0) {
                    v8 *= 0.5f;
                }

                v4_1 = v5_1;
                v5 = v10;
            }

            v7_2 = (v7_2 + 1) % v12;
        }

        return this.kineticEnergyToVelocity(v8) * v2;
    }

    private float kineticEnergyToVelocity(float arg3) {
        return ((float)((((double)Math.signum(arg3))) * Math.sqrt(((double)(Math.abs(arg3) * 2f)))));
    }

    public void resetTracking() {
        this.mIndex = 0;
        Arrays.fill(this.mTimeSamples, -9223372036854775808L);
        Arrays.fill(this.mDataSamples, 0f);
    }
}

