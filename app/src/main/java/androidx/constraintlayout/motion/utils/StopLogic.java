package androidx.constraintlayout.motion.utils;

import android.util.Log;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

public class StopLogic extends MotionInterpolator {
    private boolean mBackwards;
    private float mLastPosition;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    public StopLogic() {
        super();
        this.mBackwards = false;
    }

    private float calcY(float arg6) {
        float v0 = this.mStage1Duration;
        float v2 = 2f;
        if(Float.compare(arg6, v0) <= 0) {
            return this.mStage1Velocity * arg6 + (this.mStage2Velocity - this.mStage1Velocity) * arg6 * arg6 / (v0 * v2);
        }

        int v1 = this.mNumberOfStages;
        if(v1 == 1) {
            return this.mStage1EndPosition;
        }

        arg6 -= v0;
        v0 = this.mStage2Duration;
        if(arg6 < v0) {
            return this.mStage1EndPosition + this.mStage2Velocity * arg6 + (this.mStage3Velocity - this.mStage2Velocity) * arg6 * arg6 / (v0 * v2);
        }

        if(v1 == 2) {
            return this.mStage2EndPosition;
        }

        arg6 -= v0;
        v0 = this.mStage3Duration;
        if(arg6 < v0) {
            return this.mStage2EndPosition + this.mStage3Velocity * arg6 - this.mStage3Velocity * arg6 * arg6 / (v0 * v2);
        }

        return this.mStage3EndPosition;
    }

    public void config(float arg7, float arg8, float arg9, float arg10, float arg11, float arg12) {
        this.mStartPosition = arg7;
        boolean v0 = arg7 > arg8 ? true : false;
        this.mBackwards = v0;
        if(v0) {
            this.setup(-arg9, arg7 - arg8, arg11, arg12, arg10);
            return;
        }

        this.setup(arg9, arg8 - arg7, arg11, arg12, arg10);
    }

    public void debug(String arg7, String arg8, float arg9) {
        Log.v(arg7, arg8 + " ===== " + this.mType);
        StringBuilder v0 = new StringBuilder().append(arg8);
        String v1 = this.mBackwards ? "backwards" : "forward ";
        Log.v(arg7, v0.append(v1).append(" time = ").append(arg9).append("  stages ").append(this.mNumberOfStages).toString());
        v1 = " dur ";
        String v2 = " vel ";
        String v3 = " pos ";
        Log.v(arg7, arg8 + v1 + this.mStage1Duration + v2 + this.mStage1Velocity + v3 + this.mStage1EndPosition);
        if(this.mNumberOfStages > 1) {
            Log.v(arg7, arg8 + v1 + this.mStage2Duration + v2 + this.mStage2Velocity + v3 + this.mStage2EndPosition);
        }

        int v5 = 2;
        if(this.mNumberOfStages > v5) {
            Log.v(arg7, arg8 + v1 + this.mStage3Duration + v2 + this.mStage3Velocity + v3 + this.mStage3EndPosition);
        }

        float v0_1 = this.mStage1Duration;
        if(arg9 <= v0_1) {
            Log.v(arg7, arg8 + "stage 0");
            return;
        }

        int v1_1 = this.mNumberOfStages;
        if(v1_1 == 1) {
            Log.v(arg7, arg8 + "end stage 0");
            return;
        }

        arg9 -= v0_1;
        v0_1 = this.mStage2Duration;
        if(arg9 < v0_1) {
            Log.v(arg7, arg8 + " stage 1");
            return;
        }

        if(v1_1 == v5) {
            Log.v(arg7, arg8 + "end stage 1");
            return;
        }

        if(arg9 - v0_1 < this.mStage3Duration) {
            Log.v(arg7, arg8 + " stage 2");
            return;
        }

        Log.v(arg7, arg8 + " end stage 2");
    }

    public float getInterpolation(float arg2) {
        float v0 = this.calcY(arg2);
        this.mLastPosition = arg2;
        boolean v2 = this.mBackwards;
        float v1 = this.mStartPosition;
        if(v2) {
            return v1 - v0;
        }

        return v1 + v0;
    }

    public float getVelocity() {
        boolean v0 = this.mBackwards;
        float v2 = this.getVelocity(this.mLastPosition);
        if(v0) {
            v2 = -v2;
        }

        return v2;
    }

    public float getVelocity(float arg4) {
        float v3;
        float v1;
        float v0 = this.mStage1Duration;
        if(arg4 <= v0) {
            v1 = this.mStage1Velocity;
            v3 = this.mStage2Velocity;
        }
        else {
            int v1_1 = this.mNumberOfStages;
            if(v1_1 == 1) {
                return 0;
            }
            else {
                arg4 -= v0;
                v0 = this.mStage2Duration;
                if(arg4 < v0) {
                    v1 = this.mStage2Velocity;
                    v3 = this.mStage3Velocity;
                }
                else {
                    goto label_20;
                }
            }
        }

        return v1 + (v3 - v1) * arg4 / v0;
    label_20:
        if(v1_1 == 2) {
            return this.mStage2EndPosition;
        }

        arg4 -= v0;
        v0 = this.mStage3Duration;
        if(arg4 < v0) {
            return this.mStage3Velocity - arg4 * this.mStage3Velocity / v0;
        }

        return this.mStage3EndPosition;
    }

    private void setup(float arg9, float arg10, float arg11, float arg12, float arg13) {
        if(arg9 == 0f) {
            arg9 = 0.0001f;
        }

        this.mStage1Velocity = arg9;
        float v1 = arg9 / arg11;
        float v3 = 2f;
        float v2 = v1 * arg9 / v3;
        int v5 = 3;
        int v6 = 2;
        if(Float.compare(arg9, 0f) < 0) {
            arg13 = ((float)Math.sqrt(((double)((arg10 - -arg9 / arg11 * arg9 / v3) * arg11))));
            if(arg13 < arg12) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = v6;
                this.mStage1Velocity = arg9;
                this.mStage2Velocity = arg13;
                this.mStage3Velocity = 0f;
                arg12 = (arg13 - arg9) / arg11;
                this.mStage1Duration = arg12;
                this.mStage2Duration = arg13 / arg11;
                this.mStage1EndPosition = (arg9 + arg13) * arg12 / v3;
                this.mStage2EndPosition = arg10;
                this.mStage3EndPosition = arg10;
                return;
            }

            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = v5;
            this.mStage1Velocity = arg9;
            this.mStage2Velocity = arg12;
            this.mStage3Velocity = arg12;
            arg13 = (arg12 - arg9) / arg11;
            this.mStage1Duration = arg13;
            arg11 = arg12 / arg11;
            this.mStage3Duration = arg11;
            arg9 = (arg9 + arg12) * arg13 / v3;
            arg11 = arg11 * arg12 / v3;
            this.mStage2Duration = (arg10 - arg9 - arg11) / arg12;
            this.mStage1EndPosition = arg9;
            this.mStage2EndPosition = arg10 - arg11;
            this.mStage3EndPosition = arg10;
            return;
        }

        if(v2 >= arg10) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = arg9;
            this.mStage2Velocity = 0f;
            this.mStage1EndPosition = arg10;
            this.mStage1Duration = v3 * arg10 / arg9;
            return;
        }

        v2 = arg10 - v2;
        float v4 = v2 / arg9;
        if(v4 + v1 < arg13) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = v6;
            this.mStage1Velocity = arg9;
            this.mStage2Velocity = arg9;
            this.mStage3Velocity = 0f;
            this.mStage1EndPosition = v2;
            this.mStage2EndPosition = arg10;
            this.mStage1Duration = v4;
            this.mStage2Duration = v1;
            return;
        }

        arg13 = ((float)Math.sqrt(((double)(arg11 * arg10 + arg9 * arg9 / v3))));
        v1 = (arg13 - arg9) / arg11;
        this.mStage1Duration = v1;
        v2 = arg13 / arg11;
        this.mStage2Duration = v2;
        if(arg13 < arg12) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = v6;
            this.mStage1Velocity = arg9;
            this.mStage2Velocity = arg13;
            this.mStage3Velocity = 0f;
            this.mStage1Duration = v1;
            this.mStage2Duration = v2;
            this.mStage1EndPosition = (arg9 + arg13) * v1 / v3;
            this.mStage2EndPosition = arg10;
            return;
        }

        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = v5;
        this.mStage1Velocity = arg9;
        this.mStage2Velocity = arg12;
        this.mStage3Velocity = arg12;
        arg13 = (arg12 - arg9) / arg11;
        this.mStage1Duration = arg13;
        arg11 = arg12 / arg11;
        this.mStage3Duration = arg11;
        arg9 = (arg9 + arg12) * arg13 / v3;
        arg11 = arg11 * arg12 / v3;
        this.mStage2Duration = (arg10 - arg9 - arg11) / arg12;
        this.mStage1EndPosition = arg9;
        this.mStage2EndPosition = arg10 - arg11;
        this.mStage3EndPosition = arg10;
    }
}

