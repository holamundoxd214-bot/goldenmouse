package androidx.dynamicanimation.animation;

public final class FlingAnimation extends DynamicAnimation {
    final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction;
        private final MassState mMassState;
        private float mVelocityThreshold;

        DragForce() {
            super();
            this.mFriction = -4.2f;
            this.mMassState = new MassState();
        }

        public float getAcceleration(float arg1, float arg2) {
            return arg2 * this.mFriction;
        }

        float getFrictionScalar() {
            return this.mFriction / -4.2f;
        }

        public boolean isAtEquilibrium(float arg1, float arg2) {
            if(Math.abs(arg2) < this.mVelocityThreshold) {
                return 1;
            }

            return 0;
        }

        void setFrictionScalar(float arg2) {
            this.mFriction = arg2 * -4.2f;
        }

        void setValueThreshold(float arg2) {
            this.mVelocityThreshold = arg2 * 62.5f;
        }

        MassState updateValueAndVelocity(float arg6, float arg7, long arg8) {
            float v8 = ((float)arg8);
            this.mMassState.mVelocity = ((float)((((double)arg7)) * Math.exp(((double)(v8 / 1000f * this.mFriction)))));
            this.mMassState.mValue = ((float)((((double)(arg6 - arg7 / this.mFriction))) + (((double)(arg7 / this.mFriction))) * Math.exp(((double)(this.mFriction * v8 / 1000f)))));
            if(this.isAtEquilibrium(this.mMassState.mValue, this.mMassState.mVelocity)) {
                this.mMassState.mVelocity = 0f;
            }

            return this.mMassState;
        }
    }

    private final DragForce mFlingForce;

    public FlingAnimation(FloatValueHolder arg1) {
        super(arg1);
        DragForce v1 = new DragForce();
        this.mFlingForce = v1;
        v1.setValueThreshold(this.getValueThreshold());
    }

    public FlingAnimation(Object arg1, FloatPropertyCompat arg2) {
        super(arg1, arg2);
        DragForce v1 = new DragForce();
        this.mFlingForce = v1;
        v1.setValueThreshold(this.getValueThreshold());
    }

    float getAcceleration(float arg1, float arg2) {
        return this.mFlingForce.getAcceleration(arg1, arg2);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    boolean isAtEquilibrium(float arg2, float arg3) {
        if(arg2 < this.mMaxValue && arg2 > this.mMinValue) {
            if(this.mFlingForce.isAtEquilibrium(arg2, arg3)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public FlingAnimation setFriction(float arg2) {
        if(arg2 > 0f) {
            this.mFlingForce.setFrictionScalar(arg2);
            return this;
        }

        throw new IllegalArgumentException("Friction must be positive");
    }

    public DynamicAnimation setMaxValue(float arg1) {
        return this.setMaxValue(arg1);
    }

    public FlingAnimation setMaxValue(float arg1) {
        super.setMaxValue(arg1);
        return this;
    }

    public DynamicAnimation setMinValue(float arg1) {
        return this.setMinValue(arg1);
    }

    public FlingAnimation setMinValue(float arg1) {
        super.setMinValue(arg1);
        return this;
    }

    public DynamicAnimation setStartVelocity(float arg1) {
        return this.setStartVelocity(arg1);
    }

    public FlingAnimation setStartVelocity(float arg1) {
        super.setStartVelocity(arg1);
        return this;
    }

    void setValueThreshold(float arg1) {
        this.mFlingForce.setValueThreshold(arg1);
    }

    boolean updateValueAndVelocity(long arg4) {
        MassState v4 = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, arg4);
        this.mValue = v4.mValue;
        this.mVelocity = v4.mVelocity;
        if(Float.compare(this.mValue, this.mMinValue) < 0) {
            this.mValue = this.mMinValue;
            return 1;
        }

        if(this.mValue > this.mMaxValue) {
            this.mValue = this.mMaxValue;
            return 1;
        }

        if(this.isAtEquilibrium(this.mValue, this.mVelocity)) {
            return 1;
        }

        return 0;
    }
}

