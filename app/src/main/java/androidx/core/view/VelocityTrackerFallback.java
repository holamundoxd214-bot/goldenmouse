package androidx.core.view;

import android.view.MotionEvent;

class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private int mDataPointsBufferLastUsedIndex;
    private int mDataPointsBufferSize;
    private final long[] mEventTimes;
    private float mLastComputedVelocity;
    private final float[] mMovements;

    VelocityTrackerFallback() {
        super();
        this.mMovements = new float[20];
        this.mEventTimes = new long[20];
        this.mLastComputedVelocity = 0f;
        this.mDataPointsBufferSize = 0;
        this.mDataPointsBufferLastUsedIndex = 0;
    }

    void addMovement(MotionEvent arg7) {
        long v0 = arg7.getEventTime();
        if(this.mDataPointsBufferSize != 0 && v0 - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > 40) {
            this.clear();
        }

        int v2 = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = v2;
        int v4 = this.mDataPointsBufferSize;
        if(v4 != 20) {
            this.mDataPointsBufferSize = v4 + 1;
        }

        this.mMovements[v2] = arg7.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = v0;
    }

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0f;
    }

    void computeCurrentVelocity(int arg2, float arg3) {
        float v0 = this.getCurrentVelocity() * (((float)arg2));
        this.mLastComputedVelocity = v0;
        if(v0 < -Math.abs(arg3)) {
            this.mLastComputedVelocity = -Math.abs(arg3);
            return;
        }

        if(this.mLastComputedVelocity > Math.abs(arg3)) {
            this.mLastComputedVelocity = Math.abs(arg3);
        }
    }

    void computeCurrentVelocity(int arg2) {
        this.computeCurrentVelocity(arg2, 3.402823E+38f);
    }

    float getAxisVelocity(int arg2) {
        if(arg2 != 26) {
            return 0;
        }

        return this.mLastComputedVelocity;
    }

    private float getCurrentVelocity() {
        int v3;
        long v8;
        long[] v0_1;
        int v0 = this.mDataPointsBufferSize;
        int v2 = 2;
        if(v0 < v2) {
            return 0;
        }

        int v4 = (this.mDataPointsBufferLastUsedIndex + 20 - (v0 - 1)) % 20;
        long v6 = this.mEventTimes[this.mDataPointsBufferLastUsedIndex];
        while(true) {
            v0_1 = this.mEventTimes;
            v8 = v0_1[v4];
            v3 = Long.compare(v6 - v8, 100);
            int v10 = this.mDataPointsBufferSize;
            if(v3 <= 0) {
                break;
            }

            this.mDataPointsBufferSize = v10 - 1;
            v4 = (v4 + 1) % 20;
        }

        if(v10 < v2) {
            return 0;
        }

        if(v10 == v2) {
            v4 = (v4 + 1) % 20;
            long v2_1 = v0_1[v4];
            if(v8 == v2_1) {
                return 0;
            }

            return this.mMovements[v4] / (((float)(v2_1 - v8)));
        }

        v0 = 0;
        float v2_2 = 0f;
        int v1 = 0;
        while(v0 < this.mDataPointsBufferSize - 1) {
            v3 = v0 + v4;
            long[] v6_1 = this.mEventTimes;
            long v7 = v6_1[v3 % 20];
            v3 = (v3 + 1) % 20;
            if(v6_1[v3] == v7) {
            }
            else {
                ++v1;
                float v6_2 = VelocityTrackerFallback.kineticEnergyToVelocity(v2_2);
                float v9 = this.mMovements[v3] / (((float)(this.mEventTimes[v3] - v7)));
                v2_2 += (v9 - v6_2) * Math.abs(v9);
                if(v1 == 1) {
                    v2_2 *= 0.5f;
                }
            }

            ++v0;
        }

        return VelocityTrackerFallback.kineticEnergyToVelocity(v2_2);
    }

    private static float kineticEnergyToVelocity(float arg3) {
        float v0 = arg3 < 0f ? -1f : 1f;
        return v0 * (((float)Math.sqrt(((double)(Math.abs(arg3) * 2f)))));
    }
}

