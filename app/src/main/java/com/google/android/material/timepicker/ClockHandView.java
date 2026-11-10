package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.math.MathUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ClockHandView extends View {
    public interface OnActionUpListener {
        void onActionUp(float arg1, boolean arg2);
    }

    public interface OnRotateListener {
        void onRotate(float arg1, boolean arg2);
    }

    private static final int DEFAULT_ANIMATION_DURATION = 200;
    private boolean animatingOnTouchUp;
    private final int animationDuration;
    private final TimeInterpolator animationInterpolator;
    private final float centerDotRadius;
    private boolean changedDuringTouch;
    private int circleRadius;
    private int currentLevel;
    private double degRad;
    private float downX;
    private float downY;
    private boolean isInTapRegion;
    private boolean isMultiLevel;
    private final List listeners;
    private OnActionUpListener onActionUpListener;
    private float originalDeg;
    private final Paint paint;
    private final ValueAnimator rotationAnimator;
    private final int scaledTouchSlop;
    private final RectF selectorBox;
    private final int selectorRadius;
    private final int selectorStrokeWidth;

    public ClockHandView(Context arg2) {
        this(arg2, null);
    }

    public ClockHandView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.materialClockStyle);
    }

    public ClockHandView(Context arg5, AttributeSet arg6, int arg7) {
        super(arg5, arg6, arg7);
        this.rotationAnimator = new ValueAnimator();
        this.listeners = new ArrayList();
        Paint v0 = new Paint();
        this.paint = v0;
        this.selectorBox = new RectF();
        this.currentLevel = 1;
        TypedArray v6 = arg5.obtainStyledAttributes(arg6, styleable.ClockHandView, arg7, style.Widget_MaterialComponents_TimePicker_Clock);
        this.animationDuration = MotionUtils.resolveThemeDuration(arg5, attr.motionDurationLong2, 200);
        this.animationInterpolator = MotionUtils.resolveThemeInterpolator(arg5, attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.circleRadius = v6.getDimensionPixelSize(styleable.ClockHandView_materialCircleRadius, 0);
        this.selectorRadius = v6.getDimensionPixelSize(styleable.ClockHandView_selectorSize, 0);
        Resources v7 = this.getResources();
        this.selectorStrokeWidth = v7.getDimensionPixelSize(dimen.material_clock_hand_stroke_width);
        this.centerDotRadius = ((float)v7.getDimensionPixelSize(dimen.material_clock_hand_center_dot_radius));
        arg7 = v6.getColor(styleable.ClockHandView_clockHandColor, 0);
        v0.setAntiAlias(true);
        v0.setColor(arg7);
        this.setHandRotation(0f);
        this.scaledTouchSlop = ViewConfiguration.get(arg5).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(((View)this), 2);
        v6.recycle();
    }

    public void addOnRotateListener(OnRotateListener arg1) {
        this.listeners.add(arg1);
    }

    private void adjustLevel(float arg4, float arg5) {
        int v1 = 2;
        if(MathUtils.dist(((float)(this.getWidth() / v1)), ((float)(this.getHeight() / v1)), arg4, arg5) <= (((float)this.getLeveledCircleRadius(v1))) + ViewUtils.dpToPx(this.getContext(), 12)) {
        }
        else {
            v1 = 1;
        }

        this.currentLevel = v1;
    }

    private void drawSelector(Canvas arg11) {
        int v0 = this.getHeight() / 2;
        int v1 = this.getWidth() / 2;
        int v2 = this.getLeveledCircleRadius(this.currentLevel);
        float v4 = ((float)v1);
        float v3 = ((float)v2);
        float v6 = (((float)Math.cos(this.degRad))) * v3 + v4;
        float v5 = ((float)v0);
        v3 = v3 * (((float)Math.sin(this.degRad))) + v5;
        this.paint.setStrokeWidth(0f);
        arg11.drawCircle(v6, v3, ((float)this.selectorRadius), this.paint);
        double v6_1 = Math.sin(this.degRad);
        double v8 = Math.cos(this.degRad);
        double v2_1 = ((double)(((float)(v2 - this.selectorRadius))));
        this.paint.setStrokeWidth(((float)this.selectorStrokeWidth));
        arg11.drawLine(v4, v5, ((float)(v1 + (((int)(v8 * v2_1))))), ((float)(v0 + (((int)(v2_1 * v6_1))))), this.paint);
        arg11.drawCircle(v4, v5, this.centerDotRadius, this.paint);
    }

    int getCurrentLevel() {
        return this.currentLevel;
    }

    public RectF getCurrentSelectorBox() {
        return this.selectorBox;
    }

    private int getDegreesFromXY(float arg3, float arg4) {
        int v2 = ((int)Math.toDegrees(Math.atan2(((double)(arg4 - (((float)(this.getHeight() / 2))))), ((double)(arg3 - (((float)(this.getWidth() / 2))))))));
        int v3 = v2 + 90;
        if(v3 < 0) {
            return v2 + 450;
        }

        return v3;
    }

    public float getHandRotation() {
        return this.originalDeg;
    }

    private int getLeveledCircleRadius(int arg2) {
        int v1 = this.circleRadius;
        if(arg2 == 2) {
            v1 = Math.round((((float)v1)) * 0.66f);
        }

        return v1;
    }

    public int getSelectorRadius() {
        return this.selectorRadius;
    }

    private Pair getValuesForAnimation(float arg4) {
        float v3 = this.getHandRotation();
        float v1 = 180f;
        if(Math.abs(v3 - arg4) > v1) {
            float v2 = 360f;
            if(Float.compare(v3, v1) > 0 && arg4 < v1) {
                arg4 += v2;
            }

            if(v3 >= v1) {
                goto label_13;
            }

            if(arg4 <= v1) {
                goto label_13;
            }

            v3 += v2;
        }

    label_13:
        return new Pair(Float.valueOf(v3), Float.valueOf(arg4));
    }

    private boolean handleTouchInput(float arg3, float arg4, boolean arg5, boolean arg6, boolean arg7) {
        arg3 = ((float)this.getDegreesFromXY(arg3, arg4));
        boolean v0 = false;
        int v4 = Float.compare(this.getHandRotation(), arg3) != 0 ? 1 : 0;
        if((arg6) && v4 != 0) {
            return 1;
        }

        if(v4 == 0) {
            if(arg5) {
            }
            else {
                return 0;
            }
        }

        if((arg7) && (this.animatingOnTouchUp)) {
            v0 = true;
        }

        this.setHandRotation(arg3, v0);
        return 1;
    }

    void lambda$setHandRotation$0$com-google-android-material-timepicker-ClockHandView(ValueAnimator arg2) {
        this.setHandRotationInternal(arg2.getAnimatedValue().floatValue(), true);
    }

    protected void onDraw(Canvas arg1) {
        super.onDraw(arg1);
        this.drawSelector(arg1);
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        if(!this.rotationAnimator.isRunning()) {
            this.setHandRotation(this.getHandRotation());
        }
    }

    public boolean onTouchEvent(MotionEvent arg8) {
        boolean v6;
        boolean v5;
        boolean v4;
        int v0 = arg8.getActionMasked();
        float v2 = arg8.getX();
        float v3 = arg8.getY();
        if(v0 != 0) {
            if(v0 != 1 && v0 != 2) {
                v4 = false;
                v5 = false;
                v6 = false;
                goto label_46;
            }

            int v4_1 = ((int)(v2 - this.downX));
            int v5_1 = ((int)(v3 - this.downY));
            v4 = v4_1 * v4_1 + v5_1 * v5_1 > this.scaledTouchSlop ? true : false;
            this.isInTapRegion = v4;
            v4 = this.changedDuringTouch;
            boolean v0_1 = v0 == 1 ? true : false;
            if(this.isMultiLevel) {
                this.adjustLevel(v2, v3);
            }

            v6 = v0_1;
            v5 = false;
        }
        else {
            this.downX = v2;
            this.downY = v3;
            this.isInTapRegion = true;
            this.changedDuringTouch = false;
            v5 = true;
            v4 = false;
            v6 = false;
        }

    label_46:
        ClockHandView v1 = this;
        int v7 = v1.handleTouchInput(v2, v3, v4, v5, v6) | this.changedDuringTouch;
        v1.changedDuringTouch = ((boolean)v7);
        if(v7 != 0 && (v6)) {
            OnActionUpListener v7_1 = v1.onActionUpListener;
            if(v7_1 != null) {
                v7_1.onActionUp(((float)v1.getDegreesFromXY(v2, v3)), v1.isInTapRegion);
            }
        }

        return 1;
    }

    public void setAnimateOnTouchUp(boolean arg1) {
        this.animatingOnTouchUp = arg1;
    }

    public void setCircleRadius(int arg1) {
        this.circleRadius = arg1;
        this.invalidate();
    }

    void setCurrentLevel(int arg1) {
        this.currentLevel = arg1;
        this.invalidate();
    }

    public void setHandRotation(float arg2) {
        this.setHandRotation(arg2, false);
    }

    public void setHandRotation(float arg4, boolean arg5) {
        ValueAnimator v0 = this.rotationAnimator;
        if(v0 != null) {
            v0.cancel();
        }

        if(!arg5) {
            this.setHandRotationInternal(arg4, false);
            return;
        }

        Pair v4 = this.getValuesForAnimation(arg4);
        this.rotationAnimator.setFloatValues(new float[]{v4.first.floatValue(), v4.second.floatValue()});
        this.rotationAnimator.setDuration(((long)this.animationDuration));
        this.rotationAnimator.setInterpolator(this.animationInterpolator);
        this.rotationAnimator.addUpdateListener(new ClockHandView$$ExternalSyntheticLambda0(this));
        this.rotationAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator arg1) {
                arg1.end();
            }
        });
        this.rotationAnimator.start();
    }

    private void setHandRotationInternal(float arg8, boolean arg9) {
        arg8 %= 360f;
        this.originalDeg = arg8;
        this.degRad = Math.toRadians(((double)(arg8 - 90f)));
        int v0 = this.getHeight() / 2;
        int v1 = this.getWidth() / 2;
        float v2 = ((float)this.getLeveledCircleRadius(this.currentLevel));
        float v1_1 = (((float)v1)) + (((float)Math.cos(this.degRad))) * v2;
        float v0_1 = (((float)v0)) + v2 * (((float)Math.sin(this.degRad)));
        this.selectorBox.set(v1_1 - (((float)this.selectorRadius)), v0_1 - (((float)this.selectorRadius)), v1_1 + (((float)this.selectorRadius)), v0_1 + (((float)this.selectorRadius)));
        Iterator v0_2 = this.listeners.iterator();
        while(v0_2.hasNext()) {
            v0_2.next().onRotate(arg8, arg9);
        }

        this.invalidate();
    }

    void setMultiLevel(boolean arg2) {
        if((this.isMultiLevel) && !arg2) {
            this.currentLevel = 1;
        }

        this.isMultiLevel = arg2;
        this.invalidate();
    }

    public void setOnActionUpListener(OnActionUpListener arg1) {
        this.onActionUpListener = arg1;
    }
}

