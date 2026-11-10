package com.google.android.material.floatingactionbutton;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix$ScaleToFit;
import android.graphics.Matrix;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build$VERSION;
import android.view.View;
import android.view.ViewTreeObserver$OnPreDrawListener;
import android.view.ViewTreeObserver;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FloatingActionButtonImpl {
    class DisabledElevationAnimation extends ShadowAnimatorImpl {
        DisabledElevationAnimation(FloatingActionButtonImpl arg2) {
            FloatingActionButtonImpl.this = arg2;
            super(arg2, null);
        }

        protected float getTargetShadowSize() {
            return 0;
        }
    }

    class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToHoveredFocusedTranslationZAnimation(FloatingActionButtonImpl arg2) {
            FloatingActionButtonImpl.this = arg2;
            super(arg2, null);
        }

        protected float getTargetShadowSize() {
            return FloatingActionButtonImpl.this.elevation + FloatingActionButtonImpl.this.hoveredFocusedTranslationZ;
        }
    }

    class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToPressedTranslationZAnimation(FloatingActionButtonImpl arg2) {
            FloatingActionButtonImpl.this = arg2;
            super(arg2, null);
        }

        protected float getTargetShadowSize() {
            return FloatingActionButtonImpl.this.elevation + FloatingActionButtonImpl.this.pressedTranslationZ;
        }
    }

    interface InternalTransformationCallback {
        void onScaleChanged();

        void onTranslationChanged();
    }

    interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    class ResetElevationAnimation extends ShadowAnimatorImpl {
        ResetElevationAnimation(FloatingActionButtonImpl arg2) {
            FloatingActionButtonImpl.this = arg2;
            super(arg2, null);
        }

        protected float getTargetShadowSize() {
            return FloatingActionButtonImpl.this.elevation;
        }
    }

    abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator$AnimatorUpdateListener {
        private float shadowSizeEnd;
        private float shadowSizeStart;
        private boolean validValues;

        private ShadowAnimatorImpl(FloatingActionButtonImpl arg1) {
            FloatingActionButtonImpl.this = arg1;
            super();
        }

        ShadowAnimatorImpl(FloatingActionButtonImpl arg1, com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$1 arg2) {
            this(arg1);
        }

        protected abstract float getTargetShadowSize();

        public void onAnimationEnd(Animator arg2) {
            FloatingActionButtonImpl.this.updateShapeElevation(((float)(((int)this.shadowSizeEnd))));
            this.validValues = false;
        }

        public void onAnimationUpdate(ValueAnimator arg3) {
            if(!this.validValues) {
                float v0 = FloatingActionButtonImpl.this.shapeDrawable == null ? 0f : FloatingActionButtonImpl.this.shapeDrawable.getElevation();
                this.shadowSizeStart = v0;
                this.shadowSizeEnd = this.getTargetShadowSize();
                this.validValues = true;
            }

            FloatingActionButtonImpl.this.updateShapeElevation(((float)(((int)(this.shadowSizeStart + (this.shadowSizeEnd - this.shadowSizeStart) * arg3.getAnimatedFraction())))));
        }
    }

    static final int ANIM_STATE_HIDING = 1;
    static final int ANIM_STATE_NONE = 0;
    static final int ANIM_STATE_SHOWING = 2;
    static final long ELEVATION_ANIM_DELAY = 100;
    static final long ELEVATION_ANIM_DURATION = 100;
    static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = null;
    static final int[] EMPTY_STATE_SET = null;
    static final int[] ENABLED_STATE_SET = null;
    static final int[] FOCUSED_ENABLED_STATE_SET = null;
    private static final int HIDE_ANIM_DURATION_ATTR = 0;
    private static final int HIDE_ANIM_EASING_ATTR = 0;
    private static final float HIDE_ICON_SCALE = 0.4f;
    private static final float HIDE_OPACITY = 0f;
    private static final float HIDE_SCALE = 0.4f;
    static final int[] HOVERED_ENABLED_STATE_SET = null;
    static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = null;
    static final int[] PRESSED_ENABLED_STATE_SET = null;
    static final float SHADOW_MULTIPLIER = 1.5f;
    private static final int SHOW_ANIM_DURATION_ATTR = 0;
    private static final int SHOW_ANIM_EASING_ATTR = 0;
    private static final float SHOW_ICON_SCALE = 1f;
    private static final float SHOW_OPACITY = 1f;
    private static final float SHOW_SCALE = 1f;
    private static final float SPEC_HIDE_ICON_SCALE;
    private static final float SPEC_HIDE_SCALE;
    private int animState;
    BorderDrawable borderDrawable;
    Drawable contentBackground;
    private Animator currentAnimator;
    float elevation;
    boolean ensureMinTouchTargetSize;
    private ArrayList hideListeners;
    private MotionSpec hideMotionSpec;
    float hoveredFocusedTranslationZ;
    private float imageMatrixScale;
    private int maxImageSize;
    int minTouchTargetSize;
    private ViewTreeObserver$OnPreDrawListener preDrawListener;
    float pressedTranslationZ;
    Drawable rippleDrawable;
    private float rotation;
    boolean shadowPaddingEnabled;
    final ShadowViewDelegate shadowViewDelegate;
    ShapeAppearanceModel shapeAppearance;
    MaterialShapeDrawable shapeDrawable;
    private ArrayList showListeners;
    private MotionSpec showMotionSpec;
    private final StateListAnimator stateListAnimator;
    private final Matrix tmpMatrix;
    private final Rect tmpRect;
    private final RectF tmpRectF1;
    private final RectF tmpRectF2;
    private ArrayList transformationCallbacks;
    final FloatingActionButton view;

    static {
        FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
        FloatingActionButtonImpl.SHOW_ANIM_DURATION_ATTR = attr.motionDurationLong2;
        FloatingActionButtonImpl.SHOW_ANIM_EASING_ATTR = attr.motionEasingEmphasizedInterpolator;
        FloatingActionButtonImpl.HIDE_ANIM_DURATION_ATTR = attr.motionDurationMedium1;
        FloatingActionButtonImpl.HIDE_ANIM_EASING_ATTR = attr.motionEasingEmphasizedAccelerateInterpolator;
        FloatingActionButtonImpl.PRESSED_ENABLED_STATE_SET = new int[]{0x10100A7, 0x101009E};
        FloatingActionButtonImpl.HOVERED_FOCUSED_ENABLED_STATE_SET = new int[]{0x1010367, 0x101009C, 0x101009E};
        FloatingActionButtonImpl.FOCUSED_ENABLED_STATE_SET = new int[]{0x101009C, 0x101009E};
        FloatingActionButtonImpl.HOVERED_ENABLED_STATE_SET = new int[]{0x1010367, 0x101009E};
        FloatingActionButtonImpl.ENABLED_STATE_SET = new int[]{0x101009E};
        FloatingActionButtonImpl.EMPTY_STATE_SET = new int[0];
    }

    FloatingActionButtonImpl(FloatingActionButton arg3, ShadowViewDelegate arg4) {
        super();
        this.shadowPaddingEnabled = true;
        this.imageMatrixScale = 1f;
        this.animState = 0;
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpMatrix = new Matrix();
        this.view = arg3;
        this.shadowViewDelegate = arg4;
        StateListAnimator v4 = new StateListAnimator();
        this.stateListAnimator = v4;
        v4.addState(FloatingActionButtonImpl.PRESSED_ENABLED_STATE_SET, this.createElevationAnimator(new ElevateToPressedTranslationZAnimation(this)));
        v4.addState(FloatingActionButtonImpl.HOVERED_FOCUSED_ENABLED_STATE_SET, this.createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        v4.addState(FloatingActionButtonImpl.FOCUSED_ENABLED_STATE_SET, this.createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        v4.addState(FloatingActionButtonImpl.HOVERED_ENABLED_STATE_SET, this.createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        v4.addState(FloatingActionButtonImpl.ENABLED_STATE_SET, this.createElevationAnimator(new ResetElevationAnimation(this)));
        v4.addState(FloatingActionButtonImpl.EMPTY_STATE_SET, this.createElevationAnimator(new DisabledElevationAnimation(this)));
        this.rotation = arg3.getRotation();
    }

    static int access$002(FloatingActionButtonImpl arg0, int arg1) {
        arg0.animState = arg1;
        return arg1;
    }

    static Animator access$102(FloatingActionButtonImpl arg0, Animator arg1) {
        arg0.currentAnimator = arg1;
        return arg1;
    }

    static float access$202(FloatingActionButtonImpl arg0, float arg1) {
        arg0.imageMatrixScale = arg1;
        return arg1;
    }

    static void access$300(FloatingActionButtonImpl arg0, float arg1, Matrix arg2) {
        arg0.calculateImageMatrixFromScale(arg1, arg2);
    }

    public void addOnHideAnimationListener(Animator$AnimatorListener arg2) {
        ArrayList v0 = this.hideListeners;
        if(v0 == null) {
            v0 = new ArrayList();
            this.hideListeners = v0;
        }

        v0.add(arg2);
    }

    void addOnShowAnimationListener(Animator$AnimatorListener arg2) {
        ArrayList v0 = this.showListeners;
        if(v0 == null) {
            v0 = new ArrayList();
            this.showListeners = v0;
        }

        v0.add(arg2);
    }

    void addTransformationCallback(InternalTransformationCallback arg2) {
        ArrayList v0 = this.transformationCallbacks;
        if(v0 == null) {
            v0 = new ArrayList();
            this.transformationCallbacks = v0;
        }

        v0.add(arg2);
    }

    private void calculateImageMatrixFromScale(float arg6, Matrix arg7) {
        arg7.reset();
        Drawable v0 = this.view.getDrawable();
        if(v0 != null && this.maxImageSize != 0) {
            RectF v1 = this.tmpRectF1;
            RectF v2 = this.tmpRectF2;
            v1.set(0f, 0f, ((float)v0.getIntrinsicWidth()), ((float)v0.getIntrinsicHeight()));
            v2.set(0f, 0f, ((float)this.maxImageSize), ((float)this.maxImageSize));
            arg7.setRectToRect(v1, v2, Matrix$ScaleToFit.CENTER);
            arg7.postScale(arg6, arg6, (((float)this.maxImageSize)) / 2f, (((float)this.maxImageSize)) / 2f);
        }
    }

    private AnimatorSet createAnimator(MotionSpec arg7, float arg8, float arg9, float arg10) {
        ArrayList v0 = new ArrayList();
        ObjectAnimator v8 = ObjectAnimator.ofFloat(this.view, View.ALPHA, new float[]{arg8});
        arg7.getTiming("opacity").apply(((Animator)v8));
        ((List)v0).add(v8);
        v8 = ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{arg9});
        arg7.getTiming("scale").apply(((Animator)v8));
        this.workAroundOreoBug(v8);
        ((List)v0).add(v8);
        v8 = ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{arg9});
        arg7.getTiming("scale").apply(((Animator)v8));
        this.workAroundOreoBug(v8);
        ((List)v0).add(v8);
        this.calculateImageMatrixFromScale(arg10, this.tmpMatrix);
        ObjectAnimator v6 = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new MatrixEvaluator() {
            public Matrix evaluate(float arg2, Matrix arg3, Matrix arg4) {
                FloatingActionButtonImpl.this.imageMatrixScale = arg2;
                return super.evaluate(arg2, arg3, arg4);
            }

            public Object evaluate(float arg1, Object arg2, Object arg3) {
                return this.evaluate(arg1, ((Matrix)arg2), ((Matrix)arg3));
            }
        }, new Matrix[]{new Matrix(this.tmpMatrix)});
        arg7.getTiming("iconScale").apply(((Animator)v6));
        ((List)v0).add(v6);
        AnimatorSet v6_1 = new AnimatorSet();
        AnimatorSetCompat.playTogether(v6_1, ((List)v0));
        return v6_1;
    }

    private AnimatorSet createDefaultAnimator(float arg14, float arg15, float arg16, int arg17, int arg18) {
        AnimatorSet v10 = new AnimatorSet();
        ArrayList v11 = new ArrayList();
        ValueAnimator v12 = ValueAnimator.ofFloat(new float[]{0f, 1f});
        v12.addUpdateListener(new ValueAnimator$AnimatorUpdateListener(this.view.getAlpha(), arg14, this.view.getScaleX(), arg15, this.view.getScaleY(), this.imageMatrixScale, arg16, new Matrix(this.tmpMatrix)) {
            public void onAnimationUpdate(ValueAnimator arg6) {
                float v6 = arg6.getAnimatedValue().floatValue();
                FloatingActionButtonImpl.this.view.setAlpha(AnimationUtils.lerp(this.val$startAlpha, this.val$targetOpacity, 0f, 0.2f, v6));
                FloatingActionButtonImpl.this.view.setScaleX(AnimationUtils.lerp(this.val$startScaleX, this.val$targetScale, v6));
                FloatingActionButtonImpl.this.view.setScaleY(AnimationUtils.lerp(this.val$startScaleY, this.val$targetScale, v6));
                FloatingActionButtonImpl.this.imageMatrixScale = AnimationUtils.lerp(this.val$startImageMatrixScale, this.val$targetIconScale, v6);
                FloatingActionButtonImpl.this.calculateImageMatrixFromScale(AnimationUtils.lerp(this.val$startImageMatrixScale, this.val$targetIconScale, v6), this.val$matrix);
                FloatingActionButtonImpl.this.view.setImageMatrix(this.val$matrix);
            }
        });
        ((List)v11).add(v12);
        AnimatorSetCompat.playTogether(v10, ((List)v11));
        v10.setDuration(((long)MotionUtils.resolveThemeDuration(this.view.getContext(), arg17, this.view.getContext().getResources().getInteger(integer.material_motion_duration_long_1))));
        v10.setInterpolator(MotionUtils.resolveThemeInterpolator(this.view.getContext(), arg18, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return v10;
    }

    private ValueAnimator createElevationAnimator(ShadowAnimatorImpl arg3) {
        ValueAnimator v2 = new ValueAnimator();
        v2.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        v2.setDuration(100);
        v2.addListener(((Animator$AnimatorListener)arg3));
        v2.addUpdateListener(((ValueAnimator$AnimatorUpdateListener)arg3));
        v2.setFloatValues(new float[]{0f, 1f});
        return v2;
    }

    MaterialShapeDrawable createShapeDrawable() {
        return new MaterialShapeDrawable(Preconditions.checkNotNull(this.shapeAppearance));
    }

    final Drawable getContentBackground() {
        return this.contentBackground;
    }

    float getElevation() {
        return this.elevation;
    }

    boolean getEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    final MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    float getHoveredFocusedTranslationZ() {
        return this.hoveredFocusedTranslationZ;
    }

    private ViewTreeObserver$OnPreDrawListener getOrCreatePreDrawListener() {
        if(this.preDrawListener == null) {
            this.preDrawListener = new ViewTreeObserver$OnPreDrawListener() {
                public boolean onPreDraw() {
                    FloatingActionButtonImpl.this.onPreDraw();
                    return 1;
                }
            };
        }

        return this.preDrawListener;
    }

    void getPadding(Rect arg5) {
        int v0 = this.getTouchTargetPadding();
        float v1 = this.shadowPaddingEnabled ? this.getElevation() + this.pressedTranslationZ : 0f;
        int v4 = Math.max(v0, ((int)Math.ceil(((double)v1))));
        v0 = Math.max(v0, ((int)Math.ceil(((double)(v1 * 1.5f)))));
        arg5.set(v4, v0, v4, v0);
    }

    float getPressedTranslationZ() {
        return this.pressedTranslationZ;
    }

    final ShapeAppearanceModel getShapeAppearance() {
        return this.shapeAppearance;
    }

    final MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    int getTouchTargetPadding() {
        if(this.ensureMinTouchTargetSize) {
            return Math.max((this.minTouchTargetSize - this.view.getSizeDimension()) / 2, 0);
        }

        return 0;
    }

    void hide(InternalVisibilityChangedListener arg8, boolean arg9) {
        FloatingActionButtonImpl v1;
        AnimatorSet v0_2;
        if(this.isOrWillBeHidden()) {
        }
        else {
            Animator v0 = this.currentAnimator;
            if(v0 != null) {
                v0.cancel();
            }

            if(this.shouldAnimateVisibilityChange()) {
                MotionSpec v0_1 = this.hideMotionSpec;
                if(v0_1 != null) {
                    v0_2 = this.createAnimator(v0_1, 0f, 0f, 0f);
                    v1 = this;
                }
                else {
                    v1 = this;
                    v0_2 = v1.createDefaultAnimator(0f, 0.4f, 0.4f, FloatingActionButtonImpl.HIDE_ANIM_DURATION_ATTR, FloatingActionButtonImpl.HIDE_ANIM_EASING_ATTR);
                }

                v0_2.addListener(new AnimatorListenerAdapter(arg9, arg8) {
                    private boolean cancelled;

                    public void onAnimationCancel(Animator arg1) {
                        this.cancelled = true;
                    }

                    public void onAnimationEnd(Animator arg3) {
                        FloatingActionButtonImpl.this.animState = 0;
                        FloatingActionButtonImpl.this.currentAnimator = null;
                        if(!this.cancelled) {
                            FloatingActionButton v3 = FloatingActionButtonImpl.this.view;
                            boolean v0 = this.val$fromUser;
                            int v1 = v0 ? 8 : 4;
                            v3.internalSetVisibility(v1, v0);
                            InternalVisibilityChangedListener v2 = this.val$listener;
                            if(v2 == null) {
                                return;
                            }

                            v2.onHidden();
                        }
                    }

                    public void onAnimationStart(Animator arg4) {
                        FloatingActionButtonImpl.this.view.internalSetVisibility(0, this.val$fromUser);
                        FloatingActionButtonImpl.this.animState = 1;
                        FloatingActionButtonImpl.this.currentAnimator = arg4;
                        this.cancelled = false;
                    }
                });
                ArrayList v7 = v1.hideListeners;
                if(v7 != null) {
                    Iterator v7_1 = v7.iterator();
                    while(v7_1.hasNext()) {
                        v0_2.addListener(v7_1.next());
                    }
                }

                v0_2.start();
                return;
            }

            FloatingActionButton v7_2 = this.view;
            int v0_3 = arg9 ? 8 : 4;
            v7_2.internalSetVisibility(v0_3, arg9);
            if(arg8 == null) {
                return;
            }

            arg8.onHidden();
        }
    }

    void initializeBackgroundDrawable(ColorStateList arg1, PorterDuff$Mode arg2, ColorStateList arg3, int arg4) {
        MaterialShapeDrawable v4 = this.createShapeDrawable();
        this.shapeDrawable = v4;
        v4.setTintList(arg1);
        if(arg2 != null) {
            this.shapeDrawable.setTintMode(arg2);
        }

        this.shapeDrawable.setShadowColor(-12303292);
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        RippleDrawableCompat v1 = new RippleDrawableCompat(this.shapeDrawable.getShapeAppearanceModel());
        v1.setTintList(RippleUtils.sanitizeRippleDrawableColor(arg3));
        this.rippleDrawable = ((Drawable)v1);
        this.contentBackground = new LayerDrawable(new Drawable[]{Preconditions.checkNotNull(this.shapeDrawable), v1});
    }

    boolean isOrWillBeHidden() {
        int v0 = this.view.getVisibility();
        int v3 = this.animState;
        if(v0 == 0) {
            if(v3 == 1) {
                return 1;
            }

            return 0;
        }

        if(v3 != 2) {
            return 1;
        }

        return 0;
    }

    boolean isOrWillBeShown() {
        int v0 = this.view.getVisibility();
        int v3 = this.animState;
        if(v0 != 0) {
            if(v3 == 2) {
                return 1;
            }

            return 0;
        }

        if(v3 != 1) {
            return 1;
        }

        return 0;
    }

    void jumpDrawableToCurrentState() {
        this.stateListAnimator.jumpToCurrentState();
    }

    void onAttachedToWindow() {
        MaterialShapeDrawable v0 = this.shapeDrawable;
        if(v0 != null) {
            MaterialShapeUtils.setParentAbsoluteElevation(this.view, v0);
        }

        if(this.requirePreDrawListener()) {
            this.view.getViewTreeObserver().addOnPreDrawListener(this.getOrCreatePreDrawListener());
        }
    }

    void onCompatShadowChanged() {
    }

    void onDetachedFromWindow() {
        ViewTreeObserver v0 = this.view.getViewTreeObserver();
        ViewTreeObserver$OnPreDrawListener v1 = this.preDrawListener;
        if(v1 != null) {
            v0.removeOnPreDrawListener(v1);
            this.preDrawListener = null;
        }
    }

    void onDrawableStateChanged(int[] arg1) {
        this.stateListAnimator.setState(arg1);
    }

    void onElevationsChanged(float arg1, float arg2, float arg3) {
        this.jumpDrawableToCurrentState();
        this.updatePadding();
        this.updateShapeElevation(arg1);
    }

    void onPaddingUpdated(Rect arg8) {
        Preconditions.checkNotNull(this.contentBackground, "Didn\'t initialize content background");
        if(this.shouldAddPadding()) {
            this.shadowViewDelegate.setBackgroundDrawable(new InsetDrawable(this.contentBackground, arg8.left, arg8.top, arg8.right, arg8.bottom));
            return;
        }

        this.shadowViewDelegate.setBackgroundDrawable(this.contentBackground);
    }

    void onPreDraw() {
        float v0 = this.view.getRotation();
        if(this.rotation != v0) {
            this.rotation = v0;
            this.updateFromViewRotation();
        }
    }

    void onScaleChanged() {
        ArrayList v1 = this.transformationCallbacks;
        if(v1 != null) {
            Iterator v1_1 = v1.iterator();
            while(v1_1.hasNext()) {
                v1_1.next().onScaleChanged();
            }
        }
    }

    void onTranslationChanged() {
        ArrayList v1 = this.transformationCallbacks;
        if(v1 != null) {
            Iterator v1_1 = v1.iterator();
            while(v1_1.hasNext()) {
                v1_1.next().onTranslationChanged();
            }
        }
    }

    public void removeOnHideAnimationListener(Animator$AnimatorListener arg1) {
        ArrayList v0 = this.hideListeners;
        if(v0 == null) {
            return;
        }

        v0.remove(arg1);
    }

    void removeOnShowAnimationListener(Animator$AnimatorListener arg1) {
        ArrayList v0 = this.showListeners;
        if(v0 == null) {
            return;
        }

        v0.remove(arg1);
    }

    void removeTransformationCallback(InternalTransformationCallback arg1) {
        ArrayList v0 = this.transformationCallbacks;
        if(v0 == null) {
            return;
        }

        v0.remove(arg1);
    }

    boolean requirePreDrawListener() {
        return 1;
    }

    void setBackgroundTintList(ColorStateList arg2) {
        MaterialShapeDrawable v0 = this.shapeDrawable;
        if(v0 != null) {
            v0.setTintList(arg2);
        }

        BorderDrawable v1 = this.borderDrawable;
        if(v1 != null) {
            v1.setBorderTint(arg2);
        }
    }

    void setBackgroundTintMode(PorterDuff$Mode arg1) {
        MaterialShapeDrawable v0 = this.shapeDrawable;
        if(v0 != null) {
            v0.setTintMode(arg1);
        }
    }

    final void setElevation(float arg3) {
        if(this.elevation != arg3) {
            this.elevation = arg3;
            this.onElevationsChanged(arg3, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        }
    }

    void setEnsureMinTouchTargetSize(boolean arg1) {
        this.ensureMinTouchTargetSize = arg1;
    }

    final void setHideMotionSpec(MotionSpec arg1) {
        this.hideMotionSpec = arg1;
    }

    final void setHoveredFocusedTranslationZ(float arg3) {
        if(this.hoveredFocusedTranslationZ != arg3) {
            this.hoveredFocusedTranslationZ = arg3;
            this.onElevationsChanged(this.elevation, arg3, this.pressedTranslationZ);
        }
    }

    final void setImageMatrixScale(float arg2) {
        this.imageMatrixScale = arg2;
        Matrix v0 = this.tmpMatrix;
        this.calculateImageMatrixFromScale(arg2, v0);
        this.view.setImageMatrix(v0);
    }

    final void setMaxImageSize(int arg2) {
        if(this.maxImageSize != arg2) {
            this.maxImageSize = arg2;
            this.updateImageMatrixScale();
        }
    }

    void setMinTouchTargetSize(int arg1) {
        this.minTouchTargetSize = arg1;
    }

    final void setPressedTranslationZ(float arg3) {
        if(this.pressedTranslationZ != arg3) {
            this.pressedTranslationZ = arg3;
            this.onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, arg3);
        }
    }

    void setRippleColor(ColorStateList arg1) {
        Drawable v0 = this.rippleDrawable;
        if(v0 != null) {
            DrawableCompat.setTintList(v0, RippleUtils.sanitizeRippleDrawableColor(arg1));
        }
    }

    void setShadowPaddingEnabled(boolean arg1) {
        this.shadowPaddingEnabled = arg1;
        this.updatePadding();
    }

    final void setShapeAppearance(ShapeAppearanceModel arg3) {
        this.shapeAppearance = arg3;
        MaterialShapeDrawable v0 = this.shapeDrawable;
        if(v0 != null) {
            v0.setShapeAppearanceModel(arg3);
        }

        Drawable v0_1 = this.rippleDrawable;
        if((v0_1 instanceof Shapeable)) {
            ((Shapeable)v0_1).setShapeAppearanceModel(arg3);
        }

        BorderDrawable v2 = this.borderDrawable;
        if(v2 != null) {
            v2.setShapeAppearanceModel(arg3);
        }
    }

    final void setShowMotionSpec(MotionSpec arg1) {
        this.showMotionSpec = arg1;
    }

    boolean shouldAddPadding() {
        return 1;
    }

    private boolean shouldAnimateVisibilityChange() {
        if((ViewCompat.isLaidOut(this.view)) && !this.view.isInEditMode()) {
            return 1;
        }

        return 0;
    }

    final boolean shouldExpandBoundsForA11y() {
        if(this.ensureMinTouchTargetSize) {
            if(this.view.getSizeDimension() >= this.minTouchTargetSize) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    void show(InternalVisibilityChangedListener arg8, boolean arg9) {
        if(this.isOrWillBeShown()) {
        }
        else {
            Animator v0 = this.currentAnimator;
            if(v0 != null) {
                v0.cancel();
            }

            int v0_1 = this.showMotionSpec == null ? 1 : 0;
            boolean v2 = this.shouldAnimateVisibilityChange();
            FloatingActionButton v3 = this.view;
            float v4 = 1f;
            if(v2) {
                if(v3.getVisibility() != 0) {
                    float v2_1 = 0f;
                    this.view.setAlpha(0f);
                    FloatingActionButton v1 = this.view;
                    float v3_1 = 0.4f;
                    float v5 = v0_1 != 0 ? v3_1 : 0f;
                    v1.setScaleY(v5);
                    v1 = this.view;
                    v5 = v0_1 != 0 ? v3_1 : 0f;
                    v1.setScaleX(v5);
                    if(v0_1 != 0) {
                        v2_1 = v3_1;
                    }

                    this.setImageMatrixScale(v2_1);
                }

                MotionSpec v0_2 = this.showMotionSpec;
                AnimatorSet v0_3 = v0_2 != null ? this.createAnimator(v0_2, v4, v4, v4) : this.createDefaultAnimator(1f, 1f, 1f, FloatingActionButtonImpl.SHOW_ANIM_DURATION_ATTR, FloatingActionButtonImpl.SHOW_ANIM_EASING_ATTR);
                v0_3.addListener(new AnimatorListenerAdapter(arg9, arg8) {
                    public void onAnimationEnd(Animator arg2) {
                        FloatingActionButtonImpl.this.animState = 0;
                        FloatingActionButtonImpl.this.currentAnimator = null;
                        InternalVisibilityChangedListener v1 = this.val$listener;
                        if(v1 != null) {
                            v1.onShown();
                        }
                    }

                    public void onAnimationStart(Animator arg4) {
                        FloatingActionButtonImpl.this.view.internalSetVisibility(0, this.val$fromUser);
                        FloatingActionButtonImpl.this.animState = 2;
                        FloatingActionButtonImpl.this.currentAnimator = arg4;
                    }
                });
                ArrayList v7 = this.showListeners;
                if(v7 != null) {
                    Iterator v7_1 = v7.iterator();
                    while(v7_1.hasNext()) {
                        v0_3.addListener(v7_1.next());
                    }
                }

                v0_3.start();
                return;
            }

            v3.internalSetVisibility(0, arg9);
            this.view.setAlpha(v4);
            this.view.setScaleY(v4);
            this.view.setScaleX(v4);
            this.setImageMatrixScale(v4);
            if(arg8 == null) {
                return;
            }

            arg8.onShown();
        }
    }

    void updateFromViewRotation() {
        MaterialShapeDrawable v0 = this.shapeDrawable;
        if(v0 != null) {
            v0.setShadowCompatRotation(((int)this.rotation));
        }
    }

    final void updateImageMatrixScale() {
        this.setImageMatrixScale(this.imageMatrixScale);
    }

    final void updatePadding() {
        Rect v0 = this.tmpRect;
        this.getPadding(v0);
        this.onPaddingUpdated(v0);
        this.shadowViewDelegate.setShadowPadding(v0.left, v0.top, v0.right, v0.bottom);
    }

    void updateShapeElevation(float arg1) {
        MaterialShapeDrawable v0 = this.shapeDrawable;
        if(v0 != null) {
            v0.setElevation(arg1);
        }
    }

    private void workAroundOreoBug(ObjectAnimator arg3) {
        if(Build$VERSION.SDK_INT != 26) {
            return;
        }

        arg3.setEvaluator(new TypeEvaluator() {
            FloatEvaluator floatEvaluator;

            public Float evaluate(float arg1, Float arg2, Float arg3) {
                float v0 = this.floatEvaluator.evaluate(arg1, ((Number)arg2), ((Number)arg3)).floatValue();
                if(v0 < 0.1f) {
                    v0 = 0f;
                }

                return Float.valueOf(v0);
            }

            public Object evaluate(float arg1, Object arg2, Object arg3) {
                return this.evaluate(arg1, ((Float)arg2), ((Float)arg3));
            }
        });
    }
}

