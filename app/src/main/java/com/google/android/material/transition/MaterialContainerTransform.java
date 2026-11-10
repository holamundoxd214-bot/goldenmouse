package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region$Op;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition$TransitionListener;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.canvas.CanvasCompat$CanvasOperation;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class MaterialContainerTransform extends Transition {
    @Retention(value=RetentionPolicy.SOURCE) @public interface FadeMode {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface FitMode {
    }

    public class ProgressThresholds {
        private final float end;
        private final float start;

        public ProgressThresholds(float arg1, float arg2) {
            super();
            this.start = arg1;
            this.end = arg2;
        }

        static float access$1000(ProgressThresholds arg0) {
            return arg0.start;
        }

        static float access$1100(ProgressThresholds arg0) {
            return arg0.end;
        }

        public float getEnd() {
            return this.end;
        }

        public float getStart() {
            return this.start;
        }
    }

    class ProgressThresholdsGroup {
        private final ProgressThresholds fade;
        private final ProgressThresholds scale;
        private final ProgressThresholds scaleMask;
        private final ProgressThresholds shapeMask;

        ProgressThresholdsGroup(ProgressThresholds arg1, ProgressThresholds arg2, ProgressThresholds arg3, ProgressThresholds arg4, com.google.android.material.transition.MaterialContainerTransform$1 arg5) {
            this(arg1, arg2, arg3, arg4);
        }

        private ProgressThresholdsGroup(ProgressThresholds arg1, ProgressThresholds arg2, ProgressThresholds arg3, ProgressThresholds arg4) {
            super();
            this.fade = arg1;
            this.scale = arg2;
            this.scaleMask = arg3;
            this.shapeMask = arg4;
        }

        static ProgressThresholds access$400(ProgressThresholdsGroup arg0) {
            return arg0.fade;
        }

        static ProgressThresholds access$500(ProgressThresholdsGroup arg0) {
            return arg0.scale;
        }

        static ProgressThresholds access$600(ProgressThresholdsGroup arg0) {
            return arg0.scaleMask;
        }

        static ProgressThresholds access$700(ProgressThresholdsGroup arg0) {
            return arg0.shapeMask;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface TransitionDirection {
    }

    final class TransitionDrawable extends Drawable {
        private static final int COMPAT_SHADOW_COLOR = 0xFF888888;
        private static final int SHADOW_COLOR = 0x2D000000;
        private static final float SHADOW_DX_MULTIPLIER_ADJUSTMENT = 0.3f;
        private static final float SHADOW_DY_MULTIPLIER_ADJUSTMENT = 1.5f;
        private final MaterialShapeDrawable compatShadowDrawable;
        private final Paint containerPaint;
        private float currentElevation;
        private float currentElevationDy;
        private final RectF currentEndBounds;
        private final RectF currentEndBoundsMasked;
        private RectF currentMaskBounds;
        private final RectF currentStartBounds;
        private final RectF currentStartBoundsMasked;
        private final Paint debugPaint;
        private final Path debugPath;
        private final float displayHeight;
        private final float displayWidth;
        private final boolean drawDebugEnabled;
        private final boolean elevationShadowEnabled;
        private final RectF endBounds;
        private final Paint endContainerPaint;
        private final float endElevation;
        private final ShapeAppearanceModel endShapeAppearanceModel;
        private final View endView;
        private final boolean entering;
        private final FadeModeEvaluator fadeModeEvaluator;
        private FadeModeResult fadeModeResult;
        private final FitModeEvaluator fitModeEvaluator;
        private FitModeResult fitModeResult;
        private final MaskEvaluator maskEvaluator;
        private final float motionPathLength;
        private final PathMeasure motionPathMeasure;
        private final float[] motionPathPosition;
        private float progress;
        private final ProgressThresholdsGroup progressThresholds;
        private final Paint scrimPaint;
        private final Paint shadowPaint;
        private final RectF startBounds;
        private final Paint startContainerPaint;
        private final float startElevation;
        private final ShapeAppearanceModel startShapeAppearanceModel;
        private final View startView;

        TransitionDrawable(PathMotion arg1, View arg2, RectF arg3, ShapeAppearanceModel arg4, float arg5, View arg6, RectF arg7, ShapeAppearanceModel arg8, float arg9, int arg10, int arg11, int arg12, int arg13, boolean arg14, boolean arg15, FadeModeEvaluator arg16, FitModeEvaluator arg17, ProgressThresholdsGroup arg18, boolean arg19, com.google.android.material.transition.MaterialContainerTransform$1 arg20) {
            this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
        }

        private TransitionDrawable(PathMotion arg11, View arg12, RectF arg13, ShapeAppearanceModel arg14, float arg15, View arg16, RectF arg17, ShapeAppearanceModel arg18, float arg19, int arg20, int arg21, int arg22, int arg23, boolean arg24, boolean arg25, FadeModeEvaluator arg26, FitModeEvaluator arg27, ProgressThresholdsGroup arg28, boolean arg29) {
            super();
            Paint v0 = new Paint();
            this.containerPaint = v0;
            Paint v1 = new Paint();
            this.startContainerPaint = v1;
            Paint v2 = new Paint();
            this.endContainerPaint = v2;
            this.shadowPaint = new Paint();
            Paint v3 = new Paint();
            this.scrimPaint = v3;
            this.maskEvaluator = new MaskEvaluator();
            float[] v5 = new float[2];
            this.motionPathPosition = v5;
            MaterialShapeDrawable v6 = new MaterialShapeDrawable();
            this.compatShadowDrawable = v6;
            Paint v7 = new Paint();
            this.debugPaint = v7;
            this.debugPath = new Path();
            this.startView = arg12;
            this.startBounds = arg13;
            this.startShapeAppearanceModel = arg14;
            this.startElevation = arg15;
            this.endView = arg16;
            this.endBounds = arg17;
            this.endShapeAppearanceModel = arg18;
            this.endElevation = arg19;
            this.entering = arg24;
            this.elevationShadowEnabled = arg25;
            this.fadeModeEvaluator = arg26;
            this.fitModeEvaluator = arg27;
            this.progressThresholds = arg28;
            this.drawDebugEnabled = arg29;
            Object v12 = arg12.getContext().getSystemService("window");
            DisplayMetrics v9 = new DisplayMetrics();
            ((WindowManager)v12).getDefaultDisplay().getMetrics(v9);
            this.displayWidth = ((float)v9.widthPixels);
            this.displayHeight = ((float)v9.heightPixels);
            v0.setColor(arg20);
            v1.setColor(arg21);
            v2.setColor(arg22);
            v6.setFillColor(ColorStateList.valueOf(0));
            v6.setShadowCompatibilityMode(2);
            v6.setShadowBitmapDrawingEnable(false);
            v6.setShadowColor(0xFF888888);
            RectF v0_1 = new RectF(arg13);
            this.currentStartBounds = v0_1;
            this.currentStartBoundsMasked = new RectF(v0_1);
            RectF v1_1 = new RectF(v0_1);
            this.currentEndBounds = v1_1;
            this.currentEndBoundsMasked = new RectF(v1_1);
            PointF v0_2 = TransitionDrawable.getMotionPathPoint(arg13);
            PointF v1_2 = TransitionDrawable.getMotionPathPoint(arg17);
            PathMeasure v0_3 = new PathMeasure(arg11.getPath(v0_2.x, v0_2.y, v1_2.x, v1_2.y), false);
            this.motionPathMeasure = v0_3;
            this.motionPathLength = v0_3.getLength();
            v5[0] = arg13.centerX();
            v5[1] = arg13.top;
            v3.setStyle(Paint$Style.FILL);
            v3.setShader(TransitionUtils.createColorShader(arg23));
            v7.setStyle(Paint$Style.STROKE);
            v7.setStrokeWidth(10f);
            this.updateProgress(0f);
        }

        static void access$200(TransitionDrawable arg0, float arg1) {
            arg0.setProgress(arg1);
        }

        static View access$800(TransitionDrawable arg0) {
            return arg0.startView;
        }

        static View access$900(TransitionDrawable arg0) {
            return arg0.endView;
        }

        private static float calculateElevationDxMultiplier(RectF arg1, float arg2) {
            return (arg1.centerX() / (arg2 / 2f) - 1f) * 0.3f;
        }

        private static float calculateElevationDyMultiplier(RectF arg0, float arg1) {
            return arg0.centerY() / arg1 * 1.5f;
        }

        public void draw(Canvas arg4) {
            if(this.scrimPaint.getAlpha() > 0) {
                arg4.drawRect(this.getBounds(), this.scrimPaint);
            }

            int v0 = this.drawDebugEnabled ? arg4.save() : -1;
            if((this.elevationShadowEnabled) && this.currentElevation > 0f) {
                this.drawElevationShadow(arg4);
            }

            this.maskEvaluator.clip(arg4);
            this.maybeDrawContainerColor(arg4, this.containerPaint);
            if(this.fadeModeResult.endOnTop) {
                this.drawStartView(arg4);
                this.drawEndView(arg4);
            }
            else {
                this.drawEndView(arg4);
                this.drawStartView(arg4);
            }

            if(this.drawDebugEnabled) {
                arg4.restoreToCount(v0);
                this.drawDebugCumulativePath(arg4, this.currentStartBounds, this.debugPath, 0xFFFF00FF);
                this.drawDebugRect(arg4, this.currentStartBoundsMasked, 0xFFFFFF00);
                this.drawDebugRect(arg4, this.currentStartBounds, 0xFF00FF00);
                this.drawDebugRect(arg4, this.currentEndBoundsMasked, 0xFF00FFFF);
                this.drawDebugRect(arg4, this.currentEndBounds, 0xFF0000FF);
            }
        }

        private void drawDebugCumulativePath(Canvas arg3, RectF arg4, Path arg5, int arg6) {
            PointF v4 = TransitionDrawable.getMotionPathPoint(arg4);
            if(this.progress == 0f) {
                arg5.reset();
                arg5.moveTo(v4.x, v4.y);
                return;
            }

            arg5.lineTo(v4.x, v4.y);
            this.debugPaint.setColor(arg6);
            arg3.drawPath(arg5, this.debugPaint);
        }

        private void drawDebugRect(Canvas arg2, RectF arg3, int arg4) {
            this.debugPaint.setColor(arg4);
            arg2.drawRect(arg3, this.debugPaint);
        }

        private void drawElevationShadow(Canvas arg3) {
            arg3.save();
            arg3.clipPath(this.maskEvaluator.getPath(), Region$Op.DIFFERENCE);
            if(Build$VERSION.SDK_INT > 28) {
                this.drawElevationShadowWithPaintShadowLayer(arg3);
            }
            else {
                this.drawElevationShadowWithMaterialShapeDrawable(arg3);
            }

            arg3.restore();
        }

        private void drawElevationShadowWithMaterialShapeDrawable(Canvas arg6) {
            this.compatShadowDrawable.setBounds(((int)this.currentMaskBounds.left), ((int)this.currentMaskBounds.top), ((int)this.currentMaskBounds.right), ((int)this.currentMaskBounds.bottom));
            this.compatShadowDrawable.setElevation(this.currentElevation);
            this.compatShadowDrawable.setShadowVerticalOffset(((int)this.currentElevationDy));
            this.compatShadowDrawable.setShapeAppearanceModel(this.maskEvaluator.getCurrentShapeAppearanceModel());
            this.compatShadowDrawable.draw(arg6);
        }

        private void drawElevationShadowWithPaintShadowLayer(Canvas arg3) {
            ShapeAppearanceModel v0 = this.maskEvaluator.getCurrentShapeAppearanceModel();
            if(v0.isRoundRect(this.currentMaskBounds)) {
                float v0_1 = v0.getTopLeftCornerSize().getCornerSize(this.currentMaskBounds);
                arg3.drawRoundRect(this.currentMaskBounds, v0_1, v0_1, this.shadowPaint);
                return;
            }

            arg3.drawPath(this.maskEvaluator.getPath(), this.shadowPaint);
        }

        private void drawEndView(Canvas arg9) {
            this.maybeDrawContainerColor(arg9, this.endContainerPaint);
            TransitionUtils.transform(arg9, this.getBounds(), this.currentEndBounds.left, this.currentEndBounds.top, this.fitModeResult.endScale, this.fadeModeResult.endAlpha, new CanvasOperation() {
                public void run(Canvas arg1) {
                    TransitionDrawable.this.endView.draw(arg1);
                }
            });
        }

        private void drawStartView(Canvas arg9) {
            this.maybeDrawContainerColor(arg9, this.startContainerPaint);
            TransitionUtils.transform(arg9, this.getBounds(), this.currentStartBounds.left, this.currentStartBounds.top, this.fitModeResult.startScale, this.fadeModeResult.startAlpha, new CanvasOperation() {
                public void run(Canvas arg1) {
                    TransitionDrawable.this.startView.draw(arg1);
                }
            });
        }

        private static PointF getMotionPathPoint(RectF arg2) {
            return new PointF(arg2.centerX(), arg2.top);
        }

        public int getOpacity() {
            return -3;
        }

        private void maybeDrawContainerColor(Canvas arg2, Paint arg3) {
            if(arg3.getColor() != 0 && arg3.getAlpha() > 0) {
                arg2.drawRect(this.getBounds(), arg3);
            }
        }

        public void setAlpha(int arg1) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        public void setColorFilter(ColorFilter arg1) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        private void setProgress(float arg2) {
            if(this.progress != arg2) {
                this.updateProgress(arg2);
            }
        }

        private void updateProgress(float arg14) {
            float v10;
            float v7_1;
            this.progress = arg14;
            Paint v0 = this.scrimPaint;
            float v3 = 255f;
            float v2 = this.entering ? TransitionUtils.lerp(0f, v3, arg14) : TransitionUtils.lerp(v3, 0f, arg14);
            v0.setAlpha(((int)v2));
            float[] v4 = null;
            this.motionPathMeasure.getPosTan(this.motionPathLength * arg14, this.motionPathPosition, v4);
            float[] v0_1 = this.motionPathPosition;
            v3 = v0_1[0];
            float v6 = v0_1[1];
            float v9 = 1f;
            int v7 = Float.compare(arg14, v9);
            if(v7 > 0 || arg14 < 0f) {
                if(v7 > 0) {
                    v7_1 = (arg14 - v9) / 0.01f;
                    v10 = 0.99f;
                }
                else {
                    v10 = 0.01f;
                    v7_1 = arg14 / v10 * -1f;
                }

                this.motionPathMeasure.getPosTan(this.motionPathLength * v10, v0_1, v4);
                v0_1 = this.motionPathPosition;
                v3 += (v3 - v0_1[0]) * v7_1;
                v6 += (v6 - v0_1[1]) * v7_1;
            }

            v10 = v3;
            float v11 = v6;
            FitModeResult v0_2 = this.fitModeEvaluator.evaluate(arg14, Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.scale.start)).floatValue(), Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.scale.end)).floatValue(), this.startBounds.width(), this.startBounds.height(), this.endBounds.width(), this.endBounds.height());
            this.fitModeResult = v0_2;
            this.currentStartBounds.set(v10 - v0_2.currentStartWidth / 2f, v11, this.fitModeResult.currentStartWidth / 2f + v10, this.fitModeResult.currentStartHeight + v11);
            this.currentEndBounds.set(v10 - this.fitModeResult.currentEndWidth / 2f, v11, v10 + this.fitModeResult.currentEndWidth / 2f, this.fitModeResult.currentEndHeight + v11);
            this.currentStartBoundsMasked.set(this.currentStartBounds);
            this.currentEndBoundsMasked.set(this.currentEndBounds);
            float v0_3 = Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.scaleMask.start)).floatValue();
            v2 = Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.scaleMask.end)).floatValue();
            boolean v3_1 = this.fitModeEvaluator.shouldMaskStartBounds(this.fitModeResult);
            RectF v4_1 = v3_1 ? this.currentStartBoundsMasked : this.currentEndBoundsMasked;
            v0_3 = TransitionUtils.lerp(0f, v9, v0_3, v2, arg14);
            if(v3_1) {
            }
            else {
                v0_3 = v9 - v0_3;
            }

            this.fitModeEvaluator.applyMask(v4_1, v0_3, this.fitModeResult);
            this.currentMaskBounds = new RectF(Math.min(this.currentStartBoundsMasked.left, this.currentEndBoundsMasked.left), Math.min(this.currentStartBoundsMasked.top, this.currentEndBoundsMasked.top), Math.max(this.currentStartBoundsMasked.right, this.currentEndBoundsMasked.right), Math.max(this.currentStartBoundsMasked.bottom, this.currentEndBoundsMasked.bottom));
            this.maskEvaluator.evaluate(arg14, this.startShapeAppearanceModel, this.endShapeAppearanceModel, this.currentStartBounds, this.currentStartBoundsMasked, this.currentEndBoundsMasked, this.progressThresholds.shapeMask);
            this.currentElevation = TransitionUtils.lerp(this.startElevation, this.endElevation, arg14);
            v0_3 = TransitionDrawable.calculateElevationDxMultiplier(this.currentMaskBounds, this.displayWidth);
            v2 = TransitionDrawable.calculateElevationDyMultiplier(this.currentMaskBounds, this.displayHeight);
            v3 = this.currentElevation;
            v2 = ((float)(((int)(v2 * v3))));
            this.currentElevationDy = v2;
            this.shadowPaint.setShadowLayer(v3, ((float)(((int)(v0_3 * v3)))), v2, 0x2D000000);
            this.fadeModeResult = this.fadeModeEvaluator.evaluate(arg14, Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.fade.start)).floatValue(), Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.fade.end)).floatValue(), 0.35f);
            if(this.startContainerPaint.getColor() != 0) {
                this.startContainerPaint.setAlpha(this.fadeModeResult.startAlpha);
            }

            if(this.endContainerPaint.getColor() != 0) {
                this.endContainerPaint.setAlpha(this.fadeModeResult.endAlpha);
            }

            this.invalidateSelf();
        }
    }

    private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS = null;
    private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS_ARC = null;
    private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS = null;
    private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS_ARC = null;
    private static final float ELEVATION_NOT_SET = -1f;
    public static final int FADE_MODE_CROSS = 2;
    public static final int FADE_MODE_IN = 0;
    public static final int FADE_MODE_OUT = 1;
    public static final int FADE_MODE_THROUGH = 3;
    public static final int FIT_MODE_AUTO = 0;
    public static final int FIT_MODE_HEIGHT = 2;
    public static final int FIT_MODE_WIDTH = 1;
    private static final String PROP_BOUNDS = "materialContainerTransition:bounds";
    private static final String PROP_SHAPE_APPEARANCE = "materialContainerTransition:shapeAppearance";
    private static final String TAG = "MaterialContainerTransform";
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;
    private static final String[] TRANSITION_PROPS;
    private boolean appliedThemeValues;
    private int containerColor;
    private boolean drawDebugEnabled;
    private int drawingViewId;
    private boolean elevationShadowEnabled;
    private int endContainerColor;
    private float endElevation;
    private ShapeAppearanceModel endShapeAppearanceModel;
    private View endView;
    private int endViewId;
    private int fadeMode;
    private ProgressThresholds fadeProgressThresholds;
    private int fitMode;
    private boolean holdAtEndEnabled;
    private boolean pathMotionCustom;
    private ProgressThresholds scaleMaskProgressThresholds;
    private ProgressThresholds scaleProgressThresholds;
    private int scrimColor;
    private ProgressThresholds shapeMaskProgressThresholds;
    private int startContainerColor;
    private float startElevation;
    private ShapeAppearanceModel startShapeAppearanceModel;
    private View startView;
    private int startViewId;
    private int transitionDirection;

    static {
        MaterialContainerTransform.TRANSITION_PROPS = new String[]{"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};
        MaterialContainerTransform.DEFAULT_ENTER_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0f, 0.25f), new ProgressThresholds(0f, 1f), new ProgressThresholds(0f, 1f), new ProgressThresholds(0f, 0.75f), null);
        MaterialContainerTransform.DEFAULT_RETURN_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0f, 1f), new ProgressThresholds(0f, 0.9f), new ProgressThresholds(0.3f, 0.9f), null);
        MaterialContainerTransform.DEFAULT_ENTER_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1f), new ProgressThresholds(0.1f, 1f), new ProgressThresholds(0.1f, 0.9f), null);
        MaterialContainerTransform.DEFAULT_RETURN_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0f, 0.9f), new ProgressThresholds(0f, 0.9f), new ProgressThresholds(0.2f, 0.9f), null);
    }

    public MaterialContainerTransform() {
        super();
        boolean v0 = false;
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = 0x1020002;
        this.startViewId = -1;
        this.endViewId = -1;
        this.containerColor = 0;
        this.startContainerColor = 0;
        this.endContainerColor = 0;
        this.scrimColor = 0x52000000;
        this.transitionDirection = 0;
        this.fadeMode = 0;
        this.fitMode = 0;
        if(Build$VERSION.SDK_INT >= 28) {
            v0 = true;
        }

        this.elevationShadowEnabled = v0;
        this.startElevation = -1f;
        this.endElevation = -1f;
    }

    public MaterialContainerTransform(Context arg5, boolean arg6) {
        super();
        boolean v0 = false;
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = 0x1020002;
        this.startViewId = -1;
        this.endViewId = -1;
        this.containerColor = 0;
        this.startContainerColor = 0;
        this.endContainerColor = 0;
        this.scrimColor = 0x52000000;
        this.transitionDirection = 0;
        this.fadeMode = 0;
        this.fitMode = 0;
        if(Build$VERSION.SDK_INT >= 28) {
            v0 = true;
        }

        this.elevationShadowEnabled = v0;
        this.startElevation = -1f;
        this.endElevation = -1f;
        this.maybeApplyThemeValues(arg5, arg6);
        this.appliedThemeValues = true;
    }

    static boolean access$300(MaterialContainerTransform arg0) {
        return arg0.holdAtEndEnabled;
    }

    private ProgressThresholdsGroup buildThresholdsGroup(boolean arg3) {
        PathMotion v0 = this.getPathMotion();
        if(!(v0 instanceof ArcMotion)) {
            if((v0 instanceof MaterialArcMotion)) {
            }
            else {
                return this.getThresholdsOrDefault(arg3, MaterialContainerTransform.DEFAULT_ENTER_THRESHOLDS, MaterialContainerTransform.DEFAULT_RETURN_THRESHOLDS);
            }
        }

        return this.getThresholdsOrDefault(arg3, MaterialContainerTransform.DEFAULT_ENTER_THRESHOLDS_ARC, MaterialContainerTransform.DEFAULT_RETURN_THRESHOLDS_ARC);
    }

    private static RectF calculateDrawableBounds(View arg0, View arg1, float arg2, float arg3) {
        if(arg1 != null) {
            RectF v0 = TransitionUtils.getLocationOnScreen(arg1);
            v0.offset(arg2, arg3);
            return v0;
        }

        return new RectF(0f, 0f, ((float)arg0.getWidth()), ((float)arg0.getHeight()));
    }

    public void captureEndValues(TransitionValues arg3) {
        MaterialContainerTransform.captureValues(arg3, this.endView, this.endViewId, this.endShapeAppearanceModel);
    }

    private static ShapeAppearanceModel captureShapeAppearance(View arg0, RectF arg1, ShapeAppearanceModel arg2) {
        return TransitionUtils.convertToRelativeCornerSizes(MaterialContainerTransform.getShapeAppearance(arg0, arg2), arg1);
    }

    public void captureStartValues(TransitionValues arg3) {
        MaterialContainerTransform.captureValues(arg3, this.startView, this.startViewId, this.startShapeAppearanceModel);
    }

    private static void captureValues(TransitionValues arg2, View arg3, int arg4, ShapeAppearanceModel arg5) {
        if(arg4 != -1) {
            arg2.view = TransitionUtils.findDescendantOrAncestorById(arg2.view, arg4);
        }
        else if(arg3 != null) {
            arg2.view = arg3;
        }
        else if((arg2.view.getTag(id.mtrl_motion_snapshot_view) instanceof View)) {
            Object v3 = arg2.view.getTag(id.mtrl_motion_snapshot_view);
            arg2.view.setTag(id.mtrl_motion_snapshot_view, null);
            arg2.view = ((View)v3);
        }

        arg3 = arg2.view;
        if(!ViewCompat.isLaidOut(arg3) && arg3.getWidth() == 0) {
            if(arg3.getHeight() != 0) {
            }
            else {
                return;
            }
        }

        RectF v4 = arg3.getParent() == null ? TransitionUtils.getRelativeBounds(arg3) : TransitionUtils.getLocationOnScreen(arg3);
        arg2.values.put("materialContainerTransition:bounds", v4);
        arg2.values.put("materialContainerTransition:shapeAppearance", MaterialContainerTransform.captureShapeAppearance(arg3, v4, arg5));
    }

    public Animator createAnimator(ViewGroup arg28, TransitionValues arg29, TransitionValues arg30) {
        View v2_2;
        MaterialContainerTransform v1 = this;
        TransitionValues v0 = arg29;
        TransitionValues v2 = arg30;
        View v3 = null;
        if(v0 != null) {
            if(v2 == null) {
            }
            else {
                String v5 = "materialContainerTransition:bounds";
                Object v9 = v0.values.get(v5);
                String v6 = "materialContainerTransition:shapeAppearance";
                Object v10 = v0.values.get(v6);
                if(v9 != null) {
                    if(v10 == null) {
                    }
                    else {
                        Object v13 = v2.values.get(v5);
                        Object v14 = v2.values.get(v6);
                        if(v13 != null) {
                            if(v14 == null) {
                            }
                            else {
                                View v4 = v0.view;
                                View v12 = v2.view;
                                View v0_1 = v12.getParent() != null ? v12 : v4;
                                if(v1.drawingViewId == v0_1.getId()) {
                                    ViewParent v2_1 = v0_1.getParent();
                                    v3 = v0_1;
                                }
                                else {
                                    v2_2 = TransitionUtils.findAncestorById(v0_1, v1.drawingViewId);
                                }

                                RectF v5_1 = TransitionUtils.getLocationOnScreen(v2_2);
                                float v6_1 = -v5_1.left;
                                float v5_2 = -v5_1.top;
                                RectF v3_1 = MaterialContainerTransform.calculateDrawableBounds(v2_2, v3, v6_1, v5_2);
                                ((RectF)v9).offset(v6_1, v5_2);
                                ((RectF)v13).offset(v6_1, v5_2);
                                boolean v5_3 = v1.isEntering(((RectF)v9), ((RectF)v13));
                                if(!v1.appliedThemeValues) {
                                    v1.maybeApplyThemeValues(v0_1.getContext(), v5_3);
                                }

                                TransitionDrawable v6_2 = new TransitionDrawable(v1.getPathMotion(), v4, ((RectF)v9), ((ShapeAppearanceModel)v10), MaterialContainerTransform.getElevationOrDefault(v1.startElevation, v4), v12, ((RectF)v13), ((ShapeAppearanceModel)v14), MaterialContainerTransform.getElevationOrDefault(v1.endElevation, v12), v1.containerColor, v1.startContainerColor, v1.endContainerColor, v1.scrimColor, v5_3, v1.elevationShadowEnabled, FadeModeEvaluators.get(v1.fadeMode, v5_3), FitModeEvaluators.get(v1.fitMode, v5_3, ((RectF)v9), ((RectF)v13)), v1.buildThresholdsGroup(v5_3), v1.drawDebugEnabled, null);
                                v6_2.setBounds(Math.round(v3_1.left), Math.round(v3_1.top), Math.round(v3_1.right), Math.round(v3_1.bottom));
                                ValueAnimator v7 = ValueAnimator.ofFloat(new float[]{0f, 1f});
                                v7.addUpdateListener(new ValueAnimator$AnimatorUpdateListener(v6_2) {
                                    public void onAnimationUpdate(ValueAnimator arg1) {
                                        TransitionDrawable.access$200(this.val$transitionDrawable, arg1.getAnimatedFraction());
                                    }
                                });
                                v1.addListener(new TransitionListenerAdapter(v2_2, v6_2, v4, v12) {
                                    public void onTransitionEnd(Transition arg2) {
                                        MaterialContainerTransform.this.removeListener(((TransitionListener)this));
                                        if(MaterialContainerTransform.this.holdAtEndEnabled) {
                                            return;
                                        }

                                        this.val$startView.setAlpha(1f);
                                        this.val$endView.setAlpha(1f);
                                        ViewUtils.getOverlay(this.val$drawingView).remove(this.val$transitionDrawable);
                                    }

                                    public void onTransitionStart(Transition arg2) {
                                        ViewUtils.getOverlay(this.val$drawingView).add(this.val$transitionDrawable);
                                        this.val$startView.setAlpha(0f);
                                        this.val$endView.setAlpha(0f);
                                    }
                                });
                                return ((Animator)v7);
                            }
                        }

                        Log.w(MaterialContainerTransform.TAG, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                        return ((Animator)v3);
                    }
                }

                Log.w(MaterialContainerTransform.TAG, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
            }
        }

        return ((Animator)v3);
    }

    public int getContainerColor() {
        return this.containerColor;
    }

    public int getDrawingViewId() {
        return this.drawingViewId;
    }

    private static float getElevationOrDefault(float arg1, View arg2) {
        if(arg1 != -1f) {
            return arg1;
        }

        return ViewCompat.getElevation(arg2);
    }

    public int getEndContainerColor() {
        return this.endContainerColor;
    }

    public float getEndElevation() {
        return this.endElevation;
    }

    public ShapeAppearanceModel getEndShapeAppearanceModel() {
        return this.endShapeAppearanceModel;
    }

    public View getEndView() {
        return this.endView;
    }

    public int getEndViewId() {
        return this.endViewId;
    }

    public int getFadeMode() {
        return this.fadeMode;
    }

    public ProgressThresholds getFadeProgressThresholds() {
        return this.fadeProgressThresholds;
    }

    public int getFitMode() {
        return this.fitMode;
    }

    public ProgressThresholds getScaleMaskProgressThresholds() {
        return this.scaleMaskProgressThresholds;
    }

    public ProgressThresholds getScaleProgressThresholds() {
        return this.scaleProgressThresholds;
    }

    public int getScrimColor() {
        return this.scrimColor;
    }

    private static ShapeAppearanceModel getShapeAppearance(View arg2, ShapeAppearanceModel arg3) {
        if(arg3 != null) {
            return arg3;
        }

        if((arg2.getTag(id.mtrl_motion_snapshot_view) instanceof ShapeAppearanceModel)) {
            return arg2.getTag(id.mtrl_motion_snapshot_view);
        }

        Context v3 = arg2.getContext();
        int v0 = MaterialContainerTransform.getTransitionShapeAppearanceResId(v3);
        if(v0 != -1) {
            return ShapeAppearanceModel.builder(v3, v0, 0).build();
        }

        if((arg2 instanceof Shapeable)) {
            return ((Shapeable)arg2).getShapeAppearanceModel();
        }

        return ShapeAppearanceModel.builder().build();
    }

    public ProgressThresholds getShapeMaskProgressThresholds() {
        return this.shapeMaskProgressThresholds;
    }

    public int getStartContainerColor() {
        return this.startContainerColor;
    }

    public float getStartElevation() {
        return this.startElevation;
    }

    public ShapeAppearanceModel getStartShapeAppearanceModel() {
        return this.startShapeAppearanceModel;
    }

    public View getStartView() {
        return this.startView;
    }

    public int getStartViewId() {
        return this.startViewId;
    }

    private ProgressThresholdsGroup getThresholdsOrDefault(boolean arg7, ProgressThresholdsGroup arg8, ProgressThresholdsGroup arg9) {
        if(arg7) {
        }
        else {
            arg8 = arg9;
        }

        return new ProgressThresholdsGroup(TransitionUtils.defaultIfNull(this.fadeProgressThresholds, ProgressThresholdsGroup.access$400(arg8)), TransitionUtils.defaultIfNull(this.scaleProgressThresholds, ProgressThresholdsGroup.access$500(arg8)), TransitionUtils.defaultIfNull(this.scaleMaskProgressThresholds, ProgressThresholdsGroup.access$600(arg8)), TransitionUtils.defaultIfNull(this.shapeMaskProgressThresholds, ProgressThresholdsGroup.access$700(arg8)), null);
    }

    public int getTransitionDirection() {
        return this.transitionDirection;
    }

    public String[] getTransitionProperties() {
        return MaterialContainerTransform.TRANSITION_PROPS;
    }

    private static int getTransitionShapeAppearanceResId(Context arg2) {
        TypedArray v2 = arg2.obtainStyledAttributes(new int[]{attr.transitionShapeAppearance});
        int v0 = v2.getResourceId(0, -1);
        v2.recycle();
        return v0;
    }

    public boolean isDrawDebugEnabled() {
        return this.drawDebugEnabled;
    }

    public boolean isElevationShadowEnabled() {
        return this.elevationShadowEnabled;
    }

    private boolean isEntering(RectF arg4, RectF arg5) {
        int v0 = this.transitionDirection;
        if(v0 != 0) {
            if(v0 != 1) {
                if(v0 == 2) {
                    return 0;
                }

                throw new IllegalArgumentException("Invalid transition direction: " + this.transitionDirection);
            }

            return 1;
        }

        if(TransitionUtils.calculateArea(arg5) > TransitionUtils.calculateArea(arg4)) {
            return 1;
        }

        return 0;
    }

    public boolean isHoldAtEndEnabled() {
        return this.holdAtEndEnabled;
    }

    private void maybeApplyThemeValues(Context arg3, boolean arg4) {
        TransitionUtils.maybeApplyThemeInterpolator(((Transition)this), arg3, attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        int v4 = arg4 ? attr.motionDurationLong2 : attr.motionDurationMedium4;
        TransitionUtils.maybeApplyThemeDuration(((Transition)this), arg3, v4);
        if(!this.pathMotionCustom) {
            TransitionUtils.maybeApplyThemePath(((Transition)this), arg3, attr.motionPath);
        }
    }

    public void setAllContainerColors(int arg1) {
        this.containerColor = arg1;
        this.startContainerColor = arg1;
        this.endContainerColor = arg1;
    }

    public void setContainerColor(int arg1) {
        this.containerColor = arg1;
    }

    public void setDrawDebugEnabled(boolean arg1) {
        this.drawDebugEnabled = arg1;
    }

    public void setDrawingViewId(int arg1) {
        this.drawingViewId = arg1;
    }

    public void setElevationShadowEnabled(boolean arg1) {
        this.elevationShadowEnabled = arg1;
    }

    public void setEndContainerColor(int arg1) {
        this.endContainerColor = arg1;
    }

    public void setEndElevation(float arg1) {
        this.endElevation = arg1;
    }

    public void setEndShapeAppearanceModel(ShapeAppearanceModel arg1) {
        this.endShapeAppearanceModel = arg1;
    }

    public void setEndView(View arg1) {
        this.endView = arg1;
    }

    public void setEndViewId(int arg1) {
        this.endViewId = arg1;
    }

    public void setFadeMode(int arg1) {
        this.fadeMode = arg1;
    }

    public void setFadeProgressThresholds(ProgressThresholds arg1) {
        this.fadeProgressThresholds = arg1;
    }

    public void setFitMode(int arg1) {
        this.fitMode = arg1;
    }

    public void setHoldAtEndEnabled(boolean arg1) {
        this.holdAtEndEnabled = arg1;
    }

    public void setPathMotion(PathMotion arg1) {
        super.setPathMotion(arg1);
        this.pathMotionCustom = true;
    }

    public void setScaleMaskProgressThresholds(ProgressThresholds arg1) {
        this.scaleMaskProgressThresholds = arg1;
    }

    public void setScaleProgressThresholds(ProgressThresholds arg1) {
        this.scaleProgressThresholds = arg1;
    }

    public void setScrimColor(int arg1) {
        this.scrimColor = arg1;
    }

    public void setShapeMaskProgressThresholds(ProgressThresholds arg1) {
        this.shapeMaskProgressThresholds = arg1;
    }

    public void setStartContainerColor(int arg1) {
        this.startContainerColor = arg1;
    }

    public void setStartElevation(float arg1) {
        this.startElevation = arg1;
    }

    public void setStartShapeAppearanceModel(ShapeAppearanceModel arg1) {
        this.startShapeAppearanceModel = arg1;
    }

    public void setStartView(View arg1) {
        this.startView = arg1;
    }

    public void setStartViewId(int arg1) {
        this.startViewId = arg1;
    }

    public void setTransitionDirection(int arg1) {
        this.transitionDirection = arg1;
    }
}

