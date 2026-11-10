package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;

public abstract class AutoScrollHelper implements View$OnTouchListener {
    class ClampedScroller {
        private long mDeltaTime;
        private int mDeltaX;
        private int mDeltaY;
        private int mEffectiveRampDown;
        private int mRampDownDuration;
        private int mRampUpDuration;
        private long mStartTime;
        private long mStopTime;
        private float mStopValue;
        private float mTargetVelocityX;
        private float mTargetVelocityY;

        ClampedScroller() {
            super();
            this.mStartTime = -9223372036854775808L;
            this.mStopTime = -1;
            this.mDeltaTime = 0;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        }

        public void computeScrollDelta() {
            if(this.mDeltaTime != 0) {
                long v0 = AnimationUtils.currentAnimationTimeMillis();
                float v2 = this.interpolateValue(this.getValueAt(v0));
                long v3 = v0 - this.mDeltaTime;
                this.mDeltaTime = v0;
                float v0_1 = (((float)v3)) * v2;
                this.mDeltaX = ((int)(this.mTargetVelocityX * v0_1));
                this.mDeltaY = ((int)(v0_1 * this.mTargetVelocityY));
                return;
            }

            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int getDeltaX() {
            return this.mDeltaX;
        }

        public int getDeltaY() {
            return this.mDeltaY;
        }

        public int getHorizontalDirection() {
            return ((int)(this.mTargetVelocityX / Math.abs(this.mTargetVelocityX)));
        }

        private float getValueAt(long arg9) {
            long v0 = this.mStartTime;
            if(Long.compare(arg9, v0) < 0) {
                return 0;
            }

            long v4 = this.mStopTime;
            float v6 = 1f;
            if(Long.compare(v4, 0) >= 0) {
                if(arg9 < v4) {
                }
                else {
                    return v6 - this.mStopValue + this.mStopValue * AutoScrollHelper.constrain((((float)(arg9 - v4))) / (((float)this.mEffectiveRampDown)), 0f, v6);
                }
            }

            return AutoScrollHelper.constrain((((float)(arg9 - v0))) / (((float)this.mRampUpDuration)), 0f, v6) * 0.5f;
        }

        public int getVerticalDirection() {
            return ((int)(this.mTargetVelocityY / Math.abs(this.mTargetVelocityY)));
        }

        private float interpolateValue(float arg2) {
            return -4f * arg2 * arg2 + arg2 * 4f;
        }

        public boolean isFinished() {
            if(this.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + (((long)this.mEffectiveRampDown))) {
                return 1;
            }

            return 0;
        }

        public void requestStop() {
            long v0 = AnimationUtils.currentAnimationTimeMillis();
            this.mEffectiveRampDown = AutoScrollHelper.constrain(((int)(v0 - this.mStartTime)), 0, this.mRampDownDuration);
            this.mStopValue = this.getValueAt(v0);
            this.mStopTime = v0;
        }

        public void setRampDownDuration(int arg1) {
            this.mRampDownDuration = arg1;
        }

        public void setRampUpDuration(int arg1) {
            this.mRampUpDuration = arg1;
        }

        public void setTargetVelocity(float arg1, float arg2) {
            this.mTargetVelocityX = arg1;
            this.mTargetVelocityY = arg2;
        }

        public void start() {
            long v0 = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = v0;
            this.mStopTime = -1;
            this.mDeltaTime = v0;
            this.mStopValue = 0.5f;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        }
    }

    class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable(AutoScrollHelper arg1) {
            AutoScrollHelper.this = arg1;
            super();
        }

        public void run() {
            if(!AutoScrollHelper.this.mAnimating) {
                return;
            }

            if(AutoScrollHelper.this.mNeedsReset) {
                AutoScrollHelper.this.mNeedsReset = false;
                AutoScrollHelper.this.mScroller.start();
            }

            ClampedScroller v0 = AutoScrollHelper.this.mScroller;
            if(!v0.isFinished()) {
                if(!AutoScrollHelper.this.shouldAnimate()) {
                }
                else {
                    if(AutoScrollHelper.this.mNeedsCancel) {
                        AutoScrollHelper.this.mNeedsCancel = false;
                        AutoScrollHelper.this.cancelTargetTouch();
                    }

                    v0.computeScrollDelta();
                    AutoScrollHelper.this.scrollTargetBy(v0.getDeltaX(), v0.getDeltaY());
                    ViewCompat.postOnAnimation(AutoScrollHelper.this.mTarget, ((Runnable)this));
                    return;
                }
            }

            AutoScrollHelper.this.mAnimating = false;
        }
    }

    private static final int DEFAULT_ACTIVATION_DELAY = 0;
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = 3.402823E+38f;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 0x627;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = 3.402823E+38f;
    public static final float NO_MIN = 0f;
    public static final float RELATIVE_UNSPECIFIED = 0f;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    boolean mAnimating;
    private final Interpolator mEdgeInterpolator;
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    private float[] mMaximumEdges;
    private float[] mMaximumVelocity;
    private float[] mMinimumVelocity;
    boolean mNeedsCancel;
    boolean mNeedsReset;
    private float[] mRelativeEdges;
    private float[] mRelativeVelocity;
    private Runnable mRunnable;
    final ClampedScroller mScroller;
    final View mTarget;

    static {
        AutoScrollHelper.DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    }

    public AutoScrollHelper(View arg4) {
        super();
        this.mScroller = new ClampedScroller();
        this.mEdgeInterpolator = new AccelerateInterpolator();
        this.mRelativeEdges = new float[]{0f, 0f};
        this.mMaximumEdges = new float[]{3.402823E+38f, 3.402823E+38f};
        this.mRelativeVelocity = new float[]{0f, 0f};
        this.mMinimumVelocity = new float[]{0f, 0f};
        this.mMaximumVelocity = new float[]{3.402823E+38f, 3.402823E+38f};
        this.mTarget = arg4;
        DisplayMetrics v4 = Resources.getSystem().getDisplayMetrics();
        int v1 = ((int)(v4.density * 1575f + 0.5f));
        int v4_1 = ((int)(v4.density * 315f + 0.5f));
        float v0 = ((float)v1);
        this.setMaximumVelocity(v0, v0);
        float v4_2 = ((float)v4_1);
        this.setMinimumVelocity(v4_2, v4_2);
        this.setEdgeType(1);
        this.setMaximumEdges(3.402823E+38f, 3.402823E+38f);
        this.setRelativeEdges(0.2f, 0.2f);
        this.setRelativeVelocity(1f, 1f);
        this.setActivationDelay(AutoScrollHelper.DEFAULT_ACTIVATION_DELAY);
        this.setRampUpDuration(500);
        this.setRampDownDuration(500);
    }

    public abstract boolean canTargetScrollHorizontally(int arg1);

    public abstract boolean canTargetScrollVertically(int arg1);

    void cancelTargetTouch() {
        long v0 = SystemClock.uptimeMillis();
        MotionEvent v0_1 = MotionEvent.obtain(v0, v0, 3, 0f, 0f, 0);
        this.mTarget.onTouchEvent(v0_1);
        v0_1.recycle();
    }

    private float computeTargetVelocity(int arg3, float arg4, float arg5, float arg6) {
        arg4 = this.getEdgeValue(this.mRelativeEdges[arg3], arg5, this.mMaximumEdges[arg3], arg4);
        int v0 = Float.compare(arg4, 0f);
        if(v0 == 0) {
            return 0;
        }

        arg5 = this.mRelativeVelocity[arg3];
        float v1 = this.mMinimumVelocity[arg3];
        float v2 = this.mMaximumVelocity[arg3];
        arg5 *= arg6;
        if(v0 > 0) {
            return AutoScrollHelper.constrain(arg4 * arg5, v1, v2);
        }

        return -AutoScrollHelper.constrain(-arg4 * arg5, v1, v2);
    }

    static float constrain(float arg1, float arg2, float arg3) {
        if(arg1 > arg3) {
            return arg3;
        }

        if(arg1 < arg2) {
            return arg2;
        }

        return arg1;
    }

    static int constrain(int arg0, int arg1, int arg2) {
        if(arg0 > arg2) {
            return arg2;
        }

        if(arg0 < arg1) {
            return arg1;
        }

        return arg0;
    }

    private float constrainEdgeValue(float arg6, float arg7) {
        if(arg7 == 0f) {
            return 0;
        }

        int v1 = this.mEdgeType;
        if(v1 == 0 || v1 == 1) {
            if(arg6 < arg7) {
                float v4 = 1f;
                if(Float.compare(arg6, 0f) >= 0) {
                    return v4 - arg6 / arg7;
                }
                else if((this.mAnimating) && v1 == 1) {
                    return v4;
                }
            }
        }
        else if(v1 != 2) {
        }
        else if(arg6 < 0f) {
            return arg6 / -arg7;
        }

        return 0;
    }

    private float getEdgeValue(float arg2, float arg3, float arg4, float arg5) {
        float v1;
        arg2 = AutoScrollHelper.constrain(arg2 * arg3, 0f, arg4);
        arg2 = this.constrainEdgeValue(arg3 - arg5, arg2) - this.constrainEdgeValue(arg5, arg2);
        if(arg2 < 0f) {
            v1 = -this.mEdgeInterpolator.getInterpolation(-arg2);
        }
        else if(arg2 > 0f) {
            v1 = this.mEdgeInterpolator.getInterpolation(arg2);
        }
        else {
            return 0;
        }

        return AutoScrollHelper.constrain(v1, -1f, 1f);
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isExclusive() {
        return this.mExclusive;
    }

    public boolean onTouch(View arg6, MotionEvent arg7) {
        if(!this.mEnabled) {
            return 0;
        }

        int v0 = arg7.getActionMasked();
        if(v0 != 0) {
            if(v0 != 1) {
                if(v0 == 2) {
                    goto label_17;
                }
                else if(v0 != 3) {
                    goto label_38;
                }
            }

            this.requestStop();
        }
        else {
            this.mNeedsCancel = true;
            this.mAlreadyDelayed = false;
        label_17:
            this.mScroller.setTargetVelocity(this.computeTargetVelocity(0, arg7.getX(), ((float)arg6.getWidth()), ((float)this.mTarget.getWidth())), this.computeTargetVelocity(1, arg7.getY(), ((float)arg6.getHeight()), ((float)this.mTarget.getHeight())));
            if(this.mAnimating) {
                goto label_38;
            }

            if(!this.shouldAnimate()) {
                goto label_38;
            }

            this.startAnimating();
        }

    label_38:
        if((this.mExclusive) && (this.mAnimating)) {
            return 1;
        }

        return 0;
    }

    private void requestStop() {
        if(this.mNeedsReset) {
            this.mAnimating = false;
            return;
        }

        this.mScroller.requestStop();
    }

    public abstract void scrollTargetBy(int arg1, int arg2);

    public AutoScrollHelper setActivationDelay(int arg1) {
        this.mActivationDelay = arg1;
        return this;
    }

    public AutoScrollHelper setEdgeType(int arg1) {
        this.mEdgeType = arg1;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean arg2) {
        if((this.mEnabled) && !arg2) {
            this.requestStop();
        }

        this.mEnabled = arg2;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean arg1) {
        this.mExclusive = arg1;
        return this;
    }

    public AutoScrollHelper setMaximumEdges(float arg3, float arg4) {
        float[] v0 = this.mMaximumEdges;
        v0[0] = arg3;
        v0[1] = arg4;
        return this;
    }

    public AutoScrollHelper setMaximumVelocity(float arg4, float arg5) {
        float[] v0 = this.mMaximumVelocity;
        v0[0] = arg4 / 1000f;
        v0[1] = arg5 / 1000f;
        return this;
    }

    public AutoScrollHelper setMinimumVelocity(float arg4, float arg5) {
        float[] v0 = this.mMinimumVelocity;
        v0[0] = arg4 / 1000f;
        v0[1] = arg5 / 1000f;
        return this;
    }

    public AutoScrollHelper setRampDownDuration(int arg2) {
        this.mScroller.setRampDownDuration(arg2);
        return this;
    }

    public AutoScrollHelper setRampUpDuration(int arg2) {
        this.mScroller.setRampUpDuration(arg2);
        return this;
    }

    public AutoScrollHelper setRelativeEdges(float arg3, float arg4) {
        float[] v0 = this.mRelativeEdges;
        v0[0] = arg3;
        v0[1] = arg4;
        return this;
    }

    public AutoScrollHelper setRelativeVelocity(float arg4, float arg5) {
        float[] v0 = this.mRelativeVelocity;
        v0[0] = arg4 / 1000f;
        v0[1] = arg5 / 1000f;
        return this;
    }

    boolean shouldAnimate() {
        ClampedScroller v0 = this.mScroller;
        int v1 = v0.getVerticalDirection();
        int v0_1 = v0.getHorizontalDirection();
        if(v1 != 0 && (this.canTargetScrollVertically(v1)) || v0_1 != 0 && (this.canTargetScrollHorizontally(v0_1))) {
            return 1;
        }

        return 0;
    }

    private void startAnimating() {
        if(this.mRunnable == null) {
            this.mRunnable = new ScrollAnimationRunnable(this);
        }

        this.mAnimating = true;
        this.mNeedsReset = true;
        if(!this.mAlreadyDelayed) {
            int v1 = this.mActivationDelay;
            if(v1 > 0) {
                ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, ((long)v1));
            }
            else {
                goto label_17;
            }
        }
        else {
        label_17:
            this.mRunnable.run();
        }

        this.mAlreadyDelayed = true;
    }
}

