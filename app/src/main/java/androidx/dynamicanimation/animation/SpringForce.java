package androidx.dynamicanimation.animation;

public final class SpringForce implements Force {
    public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
    public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
    public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
    public static final float DAMPING_RATIO_NO_BOUNCY = 1f;
    public static final float STIFFNESS_HIGH = 10000f;
    public static final float STIFFNESS_LOW = 200f;
    public static final float STIFFNESS_MEDIUM = 1500f;
    public static final float STIFFNESS_VERY_LOW = 50f;
    private static final double UNSET = 1.797693E+308;
    private static final double VELOCITY_THRESHOLD_MULTIPLIER = 62.5;
    private double mDampedFreq;
    double mDampingRatio;
    private double mFinalPosition;
    private double mGammaMinus;
    private double mGammaPlus;
    private boolean mInitialized;
    private final MassState mMassState;
    double mNaturalFreq;
    private double mValueThreshold;
    private double mVelocityThreshold;

    public SpringForce() {
        super();
        this.mNaturalFreq = Math.sqrt(1500);
        this.mDampingRatio = 0.5;
        this.mInitialized = false;
        this.mFinalPosition = 1.797693E+308;
        this.mMassState = new MassState();
    }

    public SpringForce(float arg3) {
        super();
        this.mNaturalFreq = Math.sqrt(1500);
        this.mDampingRatio = 0.5;
        this.mInitialized = false;
        this.mFinalPosition = 1.797693E+308;
        this.mMassState = new MassState();
        this.mFinalPosition = ((double)arg3);
    }

    public float getAcceleration(float arg7, float arg8) {
        return ((float)(-(this.mNaturalFreq * this.mNaturalFreq) * (((double)(arg7 - this.getFinalPosition()))) - this.mNaturalFreq * 2 * this.mDampingRatio * (((double)arg8))));
    }

    public float getDampingRatio() {
        return ((float)this.mDampingRatio);
    }

    public float getFinalPosition() {
        return ((float)this.mFinalPosition);
    }

    public float getStiffness() {
        return ((float)(this.mNaturalFreq * this.mNaturalFreq));
    }

    private void init() {
        if(this.mInitialized) {
            return;
        }

        if(this.mFinalPosition != 1.797693E+308) {
            double v0 = this.mDampingRatio;
            double v2 = 1;
            if(v0 > v2) {
                this.mGammaPlus = -v0 * this.mNaturalFreq + this.mNaturalFreq * Math.sqrt(v0 * v0 - v2);
                this.mGammaMinus = -this.mDampingRatio * this.mNaturalFreq - this.mNaturalFreq * Math.sqrt(this.mDampingRatio * this.mDampingRatio - v2);
            }
            else if(v0 >= 0 && v0 < v2) {
                this.mDampedFreq = this.mNaturalFreq * Math.sqrt(v2 - v0 * v0);
            }

            this.mInitialized = true;
            return;
        }

        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    public boolean isAtEquilibrium(float arg5, float arg6) {
        if((((double)Math.abs(arg6))) < this.mVelocityThreshold && (((double)Math.abs(arg5 - this.getFinalPosition()))) < this.mValueThreshold) {
            return 1;
        }

        return 0;
    }

    public SpringForce setDampingRatio(float arg3) {
        if(arg3 >= 0f) {
            this.mDampingRatio = ((double)arg3);
            this.mInitialized = false;
            return this;
        }

        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public SpringForce setFinalPosition(float arg3) {
        this.mFinalPosition = ((double)arg3);
        return this;
    }

    public SpringForce setStiffness(float arg3) {
        if(arg3 > 0f) {
            this.mNaturalFreq = Math.sqrt(((double)arg3));
            this.mInitialized = false;
            return this;
        }

        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    void setValueThreshold(double arg3) {
        arg3 = Math.abs(arg3);
        this.mValueThreshold = arg3;
        this.mVelocityThreshold = arg3 * 62.5;
    }

    MassState updateValues(double arg17, double arg19, long arg21) {
        SpringForce v0 = this;
        v0.init();
        double v1 = (((double)arg21)) / 1000;
        double v3 = arg17 - v0.mFinalPosition;
        double v5 = v0.mDampingRatio;
        double v7 = 1;
        double v10 = 2.718282;
        if(Double.compare(v5, v7) > 0) {
            v5 = v0.mGammaMinus;
            v7 = v3 - (v5 * v3 - arg19) / (v5 - v0.mGammaPlus);
            v3 = (v3 * v5 - arg19) / (v5 - v0.mGammaPlus);
            v5 = Math.pow(v10, v5 * v1) * v7 + Math.pow(v10, v0.mGammaPlus * v1) * v3;
            v7 = v7 * v0.mGammaMinus * Math.pow(v10, v0.mGammaMinus * v1) + v3 * v0.mGammaPlus * Math.pow(v10, v0.mGammaPlus * v1);
        }
        else if(v5 == v7) {
            v7 = arg19 + v0.mNaturalFreq * v3;
            v3 += v7 * v1;
            v5 = Math.pow(v10, -v0.mNaturalFreq * v1) * v3;
            v7 = v7 * Math.pow(v10, -v0.mNaturalFreq * v1) + v3 * Math.pow(v10, -v0.mNaturalFreq * v1) * -v0.mNaturalFreq;
        }
        else {
            v7 = v7 / v0.mDampedFreq * (v5 * v0.mNaturalFreq * v3 + arg19);
            v5 = Math.pow(v10, -v5 * v0.mNaturalFreq * v1) * (Math.cos(v0.mDampedFreq * v1) * v3 + Math.sin(v0.mDampedFreq * v1) * v7);
            v7 = -v0.mNaturalFreq * v5 * v0.mDampingRatio + Math.pow(2.718282, -v0.mDampingRatio * v0.mNaturalFreq * v1) * (-v0.mDampedFreq * v3 * Math.sin(v0.mDampedFreq * v1) + v7 * v0.mDampedFreq * Math.cos(v0.mDampedFreq * v1));
        }

        v0.mMassState.mValue = ((float)(v5 + v0.mFinalPosition));
        v0.mMassState.mVelocity = ((float)v7);
        return v0.mMassState;
    }
}

