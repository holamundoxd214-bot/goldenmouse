package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;

public final class SpringAnimation extends DynamicAnimation {
    private static final float UNSET = 3.402823E+38f;
    private boolean mEndRequested;
    private float mPendingPosition;
    private SpringForce mSpring;

    public SpringAnimation(FloatValueHolder arg1) {
        super(arg1);
        this.mSpring = null;
        this.mPendingPosition = 3.402823E+38f;
        this.mEndRequested = false;
    }

    public SpringAnimation(Object arg1, FloatPropertyCompat arg2) {
        super(arg1, arg2);
        this.mSpring = null;
        this.mPendingPosition = 3.402823E+38f;
        this.mEndRequested = false;
    }

    public SpringAnimation(Object arg1, FloatPropertyCompat arg2, float arg3) {
        super(arg1, arg2);
        this.mSpring = null;
        this.mPendingPosition = 3.402823E+38f;
        this.mEndRequested = false;
        this.mSpring = new SpringForce(arg3);
    }

    public void animateToFinalPosition(float arg2) {
        if(this.isRunning()) {
            this.mPendingPosition = arg2;
            return;
        }

        SpringForce v0 = this.mSpring;
        if(v0 == null) {
            v0 = new SpringForce(arg2);
            this.mSpring = v0;
        }

        v0.setFinalPosition(arg2);
        this.start();
    }

    public boolean canSkipToEnd() {
        if(this.mSpring.mDampingRatio > 0) {
            return 1;
        }

        return 0;
    }

    float getAcceleration(float arg1, float arg2) {
        return this.mSpring.getAcceleration(arg1, arg2);
    }

    public SpringForce getSpring() {
        return this.mSpring;
    }

    boolean isAtEquilibrium(float arg1, float arg2) {
        return this.mSpring.isAtEquilibrium(arg1, arg2);
    }

    private void sanityCheck() {
        SpringForce v0 = this.mSpring;
        if(v0 != null) {
            double v0_1 = ((double)v0.getFinalPosition());
            if(v0_1 <= (((double)this.mMaxValue))) {
                if(v0_1 >= (((double)this.mMinValue))) {
                    return;
                }

                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }

            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }

        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }

    public SpringAnimation setSpring(SpringForce arg1) {
        this.mSpring = arg1;
        return this;
    }

    void setValueThreshold(float arg1) {
    }

    public void skipToEnd() {
        if(this.canSkipToEnd()) {
            if(Looper.myLooper() == Looper.getMainLooper()) {
                if(this.mRunning) {
                    this.mEndRequested = true;
                }

                return;
            }

            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }

        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }

    public void start() {
        this.sanityCheck();
        this.mSpring.setValueThreshold(((double)this.getValueThreshold()));
        super.start();
    }

    boolean updateValueAndVelocity(long arg21) {
        MassState v1_2;
        SpringAnimation v0 = this;
        boolean v1 = v0.mEndRequested;
        float v2 = v0.mPendingPosition;
        float v6 = 3.402823E+38f;
        if(v1) {
            if(v2 != v6) {
                v0.mSpring.setFinalPosition(v2);
                v0.mPendingPosition = v6;
            }

            v0.mValue = v0.mSpring.getFinalPosition();
            v0.mVelocity = 0f;
            v0.mEndRequested = false;
            return 1;
        }

        int v1_1 = Float.compare(v2, v6);
        SpringForce v7 = v0.mSpring;
        if(v1_1 != 0) {
            v7.getFinalPosition();
            long v13 = arg21 / 2;
            v1_2 = v0.mSpring.updateValues(((double)v0.mValue), ((double)v0.mVelocity), v13);
            v0.mSpring.setFinalPosition(v0.mPendingPosition);
            v0.mPendingPosition = v6;
            v1_2 = v0.mSpring.updateValues(((double)v1_2.mValue), ((double)v1_2.mVelocity), v13);
            v0.mValue = v1_2.mValue;
            v0.mVelocity = v1_2.mVelocity;
        }
        else {
            v1_2 = v7.updateValues(((double)v0.mValue), ((double)v0.mVelocity), arg21);
            v0.mValue = v1_2.mValue;
            v0.mVelocity = v1_2.mVelocity;
        }

        v0.mValue = Math.max(v0.mValue, v0.mMinValue);
        v0.mValue = Math.min(v0.mValue, v0.mMaxValue);
        if(v0.isAtEquilibrium(v0.mValue, v0.mVelocity)) {
            v0.mValue = v0.mSpring.getFinalPosition();
            v0.mVelocity = 0f;
            return 1;
        }

        return 0;
    }
}

