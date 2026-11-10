package com.google.android.material.card;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel$Builder;
import com.google.android.material.shape.ShapeAppearanceModel;

class MaterialCardViewHelper {
    private static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    private static final int CHECKED_ICON_LAYER_INDEX = 2;
    private static final Drawable CHECKED_ICON_NONE = null;
    private static final double COS_45 = 0;
    public static final int DEFAULT_FADE_ANIM_DURATION = 300;
    private static final int DEFAULT_STROKE_VALUE = -1;
    private final MaterialShapeDrawable bgDrawable;
    private boolean checkable;
    private float checkedAnimationProgress;
    private Drawable checkedIcon;
    private int checkedIconGravity;
    private int checkedIconMargin;
    private int checkedIconSize;
    private ColorStateList checkedIconTint;
    private LayerDrawable clickableForegroundDrawable;
    private MaterialShapeDrawable compatRippleDrawable;
    private Drawable fgDrawable;
    private final MaterialShapeDrawable foregroundContentDrawable;
    private MaterialShapeDrawable foregroundShapeDrawable;
    private ValueAnimator iconAnimator;
    private final TimeInterpolator iconFadeAnimInterpolator;
    private final int iconFadeInAnimDuration;
    private final int iconFadeOutAnimDuration;
    private boolean isBackgroundOverwritten;
    private final MaterialCardView materialCardView;
    private ColorStateList rippleColor;
    private Drawable rippleDrawable;
    private ShapeAppearanceModel shapeAppearanceModel;
    private ColorStateList strokeColor;
    private int strokeWidth;
    private final Rect userContentPadding;

    static {
        ColorDrawable v0;
        MaterialCardViewHelper.COS_45 = Math.cos(Math.toRadians(45));
        if(Build$VERSION.SDK_INT <= 28) {
            v0 = new ColorDrawable();
        }
        else {
            Drawable v0_1 = null;
        }

        MaterialCardViewHelper.CHECKED_ICON_NONE = ((Drawable)v0);
    }

    public MaterialCardViewHelper(MaterialCardView arg5, AttributeSet arg6, int arg7, int arg8) {
        super();
        this.userContentPadding = new Rect();
        this.isBackgroundOverwritten = false;
        this.checkedAnimationProgress = 0f;
        this.materialCardView = arg5;
        MaterialShapeDrawable v1 = new MaterialShapeDrawable(arg5.getContext(), arg6, arg7, arg8);
        this.bgDrawable = v1;
        v1.initializeElevationOverlay(arg5.getContext());
        v1.setShadowColor(-12303292);
        Builder v8 = v1.getShapeAppearanceModel().toBuilder();
        TypedArray v6 = arg5.getContext().obtainStyledAttributes(arg6, styleable.CardView, arg7, style.CardView);
        if(v6.hasValue(styleable.CardView_cardCornerRadius)) {
            v8.setAllCornerSizes(v6.getDimension(styleable.CardView_cardCornerRadius, 0f));
        }

        this.foregroundContentDrawable = new MaterialShapeDrawable();
        this.setShapeAppearanceModel(v8.build());
        this.iconFadeAnimInterpolator = MotionUtils.resolveThemeInterpolator(arg5.getContext(), attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        this.iconFadeInAnimDuration = MotionUtils.resolveThemeDuration(arg5.getContext(), attr.motionDurationShort2, 300);
        this.iconFadeOutAnimDuration = MotionUtils.resolveThemeDuration(arg5.getContext(), attr.motionDurationShort1, 300);
        v6.recycle();
    }

    public void animateCheckedIcon(boolean arg6) {
        float v0 = 1f;
        float v1 = arg6 ? v0 : 0f;
        float v2 = this.checkedAnimationProgress;
        if(arg6) {
            v2 = v0 - v2;
        }

        ValueAnimator v0_1 = this.iconAnimator;
        if(v0_1 != null) {
            v0_1.cancel();
            this.iconAnimator = null;
        }

        v0_1 = ValueAnimator.ofFloat(new float[]{this.checkedAnimationProgress, v1});
        this.iconAnimator = v0_1;
        v0_1.addUpdateListener(new MaterialCardViewHelper$$ExternalSyntheticLambda0(this));
        this.iconAnimator.setInterpolator(this.iconFadeAnimInterpolator);
        v0_1 = this.iconAnimator;
        int v6 = arg6 ? this.iconFadeInAnimDuration : this.iconFadeOutAnimDuration;
        v0_1.setDuration(((long)((((float)v6)) * v2)));
        this.iconAnimator.start();
    }

    private float calculateActualCornerPadding() {
        return Math.max(Math.max(this.calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopLeftCorner(), this.bgDrawable.getTopLeftCornerResolvedSize()), this.calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopRightCorner(), this.bgDrawable.getTopRightCornerResolvedSize())), Math.max(this.calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomRightCorner(), this.bgDrawable.getBottomRightCornerResolvedSize()), this.calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomLeftCorner(), this.bgDrawable.getBottomLeftCornerResolvedSize())));
    }

    private float calculateCornerPaddingForCornerTreatment(CornerTreatment arg3, float arg4) {
        if((arg3 instanceof RoundedCornerTreatment)) {
            return ((float)((1 - MaterialCardViewHelper.COS_45) * (((double)arg4))));
        }

        if((arg3 instanceof CutCornerTreatment)) {
            return arg4 / 2f;
        }

        return 0;
    }

    private float calculateHorizontalBackgroundPadding() {
        float v0 = this.materialCardView.getMaxCardElevation();
        float v2 = this.shouldAddCornerPaddingOutsideCardBackground() ? this.calculateActualCornerPadding() : 0f;
        return v0 + v2;
    }

    private float calculateVerticalBackgroundPadding() {
        float v0 = this.materialCardView.getMaxCardElevation() * 1.5f;
        float v2 = this.shouldAddCornerPaddingOutsideCardBackground() ? this.calculateActualCornerPadding() : 0f;
        return v0 + v2;
    }

    private boolean canClipToOutline() {
        if(this.bgDrawable.isRoundRect()) {
            return 1;
        }

        return 0;
    }

    private Drawable createCompatRippleDrawable() {
        StateListDrawable v0 = new StateListDrawable();
        MaterialShapeDrawable v1 = this.createForegroundShapeDrawable();
        this.compatRippleDrawable = v1;
        v1.setFillColor(this.rippleColor);
        v0.addState(new int[]{0x10100A7}, this.compatRippleDrawable);
        return ((Drawable)v0);
    }

    private Drawable createForegroundRippleDrawable() {
        if(RippleUtils.USE_FRAMEWORK_RIPPLE) {
            this.foregroundShapeDrawable = this.createForegroundShapeDrawable();
            return new RippleDrawable(this.rippleColor, null, this.foregroundShapeDrawable);
        }

        return this.createCompatRippleDrawable();
    }

    private MaterialShapeDrawable createForegroundShapeDrawable() {
        return new MaterialShapeDrawable(this.shapeAppearanceModel);
    }

    void forceRippleRedraw() {
        Drawable v0 = this.rippleDrawable;
        if(v0 != null) {
            Rect v0_1 = v0.getBounds();
            int v1 = v0_1.bottom;
            this.rippleDrawable.setBounds(v0_1.left, v0_1.top, v0_1.right, v1 - 1);
            this.rippleDrawable.setBounds(v0_1.left, v0_1.top, v0_1.right, v1);
        }
    }

    MaterialShapeDrawable getBackground() {
        return this.bgDrawable;
    }

    ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    ColorStateList getCardForegroundColor() {
        return this.foregroundContentDrawable.getFillColor();
    }

    Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    int getCheckedIconGravity() {
        return this.checkedIconGravity;
    }

    int getCheckedIconMargin() {
        return this.checkedIconMargin;
    }

    int getCheckedIconSize() {
        return this.checkedIconSize;
    }

    ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    private Drawable getClickableForeground() {
        if(this.rippleDrawable == null) {
            this.rippleDrawable = this.createForegroundRippleDrawable();
        }

        if(this.clickableForegroundDrawable == null) {
            LayerDrawable v0 = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, this.checkedIcon});
            this.clickableForegroundDrawable = v0;
            v0.setId(2, id.mtrl_card_checked_layer_id);
        }

        return this.clickableForegroundDrawable;
    }

    float getCornerRadius() {
        return this.bgDrawable.getTopLeftCornerResolvedSize();
    }

    private float getParentCardViewCalculatedCornerPadding() {
        if((this.materialCardView.getPreventCornerOverlap()) && (this.materialCardView.getUseCompatPadding())) {
            return ((float)((1 - MaterialCardViewHelper.COS_45) * (((double)this.materialCardView.getCardViewRadius()))));
        }

        return 0;
    }

    float getProgress() {
        return this.bgDrawable.getInterpolation();
    }

    ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    int getStrokeColor() {
        ColorStateList v0 = this.strokeColor;
        if(v0 == null) {
            return -1;
        }

        return v0.getDefaultColor();
    }

    ColorStateList getStrokeColorStateList() {
        return this.strokeColor;
    }

    int getStrokeWidth() {
        return this.strokeWidth;
    }

    Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    private Drawable insetDrawable(Drawable arg9) {
        int v4;
        int v5;
        if(this.materialCardView.getUseCompatPadding()) {
            v5 = ((int)Math.ceil(((double)this.calculateVerticalBackgroundPadding())));
            v4 = ((int)Math.ceil(((double)this.calculateHorizontalBackgroundPadding())));
        }
        else {
            v4 = 0;
            v5 = 0;
        }

        return new InsetDrawable(arg9, v4, v5, v4, v5) {
            public int getMinimumHeight() {
                return -1;
            }

            public int getMinimumWidth() {
                return -1;
            }

            public boolean getPadding(Rect arg1) {
                return 0;
            }
        };
    }

    boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    boolean isCheckable() {
        return this.checkable;
    }

    private boolean isCheckedIconBottom() {
        if((this.checkedIconGravity & 80) == 80) {
            return 1;
        }

        return 0;
    }

    private boolean isCheckedIconEnd() {
        if((this.checkedIconGravity & 0x800005) == 0x800005) {
            return 1;
        }

        return 0;
    }

    void lambda$animateCheckedIcon$0$com-google-android-material-card-MaterialCardViewHelper(ValueAnimator arg3) {
        float v3 = arg3.getAnimatedValue().floatValue();
        this.checkedIcon.setAlpha(((int)(255f * v3)));
        this.checkedAnimationProgress = v3;
    }

    void loadFromAttributes(TypedArray arg4) {
        Drawable v4;
        ColorStateList v0 = MaterialResources.getColorStateList(this.materialCardView.getContext(), arg4, styleable.MaterialCardView_strokeColor);
        this.strokeColor = v0;
        if(v0 == null) {
            this.strokeColor = ColorStateList.valueOf(-1);
        }

        this.strokeWidth = arg4.getDimensionPixelSize(styleable.MaterialCardView_strokeWidth, 0);
        boolean v0_1 = arg4.getBoolean(styleable.MaterialCardView_android_checkable, false);
        this.checkable = v0_1;
        this.materialCardView.setLongClickable(v0_1);
        this.checkedIconTint = MaterialResources.getColorStateList(this.materialCardView.getContext(), arg4, styleable.MaterialCardView_checkedIconTint);
        this.setCheckedIcon(MaterialResources.getDrawable(this.materialCardView.getContext(), arg4, styleable.MaterialCardView_checkedIcon));
        this.setCheckedIconSize(arg4.getDimensionPixelSize(styleable.MaterialCardView_checkedIconSize, 0));
        this.setCheckedIconMargin(arg4.getDimensionPixelSize(styleable.MaterialCardView_checkedIconMargin, 0));
        this.checkedIconGravity = arg4.getInteger(styleable.MaterialCardView_checkedIconGravity, 0x800035);
        v0 = MaterialResources.getColorStateList(this.materialCardView.getContext(), arg4, styleable.MaterialCardView_rippleColor);
        this.rippleColor = v0;
        if(v0 == null) {
            this.rippleColor = ColorStateList.valueOf(MaterialColors.getColor(this.materialCardView, attr.colorControlHighlight));
        }

        this.setCardForegroundColor(MaterialResources.getColorStateList(this.materialCardView.getContext(), arg4, styleable.MaterialCardView_cardForegroundColor));
        this.updateRippleColor();
        this.updateElevation();
        this.updateStroke();
        this.materialCardView.setBackgroundInternal(this.insetDrawable(this.bgDrawable));
        if(this.shouldUseClickableForeground()) {
            v4 = this.getClickableForeground();
        }
        else {
            MaterialShapeDrawable v4_1 = this.foregroundContentDrawable;
        }

        this.fgDrawable = v4;
        this.materialCardView.setForeground(this.insetDrawable(v4));
    }

    void recalculateCheckedIconPosition(int arg12, int arg13) {
        int v7;
        int v9;
        int v1;
        int v0;
        if(this.clickableForegroundDrawable != null) {
            if(this.materialCardView.getUseCompatPadding()) {
                v0 = ((int)Math.ceil(((double)(this.calculateVerticalBackgroundPadding() * 2f))));
                v1 = ((int)Math.ceil(((double)(this.calculateHorizontalBackgroundPadding() * 2f))));
            }
            else {
                v0 = 0;
                v1 = 0;
            }

            boolean v2 = this.isCheckedIconEnd();
            int v3 = this.checkedIconMargin;
            if(v2) {
                v3 = arg12 - v3 - this.checkedIconSize - v1;
            }

            v2 = this.isCheckedIconBottom();
            int v4 = this.checkedIconMargin;
            if(v2) {
            }
            else {
                v4 = arg13 - v4 - this.checkedIconSize - v0;
            }

            int v10 = v4;
            v2 = this.isCheckedIconEnd();
            v4 = this.checkedIconMargin;
            if(v2) {
            }
            else {
                v4 = arg12 - v4 - this.checkedIconSize - v1;
            }

            boolean v12 = this.isCheckedIconBottom();
            v1 = this.checkedIconMargin;
            if(v12) {
                v1 = arg13 - v1 - this.checkedIconSize - v0;
            }

            int v8 = v1;
            if(ViewCompat.getLayoutDirection(this.materialCardView) == 1) {
                v9 = v3;
                v7 = v4;
            }
            else {
                v7 = v3;
                v9 = v4;
            }

            this.clickableForegroundDrawable.setLayerInset(2, v7, v8, v9, v10);
        }
    }

    void setBackgroundOverwritten(boolean arg1) {
        this.isBackgroundOverwritten = arg1;
    }

    void setCardBackgroundColor(ColorStateList arg1) {
        this.bgDrawable.setFillColor(arg1);
    }

    void setCardForegroundColor(ColorStateList arg1) {
        MaterialShapeDrawable v0 = this.foregroundContentDrawable;
        if(arg1 == null) {
            arg1 = ColorStateList.valueOf(0);
        }

        v0.setFillColor(arg1);
    }

    void setCheckable(boolean arg1) {
        this.checkable = arg1;
    }

    public void setChecked(boolean arg2, boolean arg3) {
        Drawable v0 = this.checkedIcon;
        if(v0 != null) {
            if(arg3) {
                this.animateCheckedIcon(arg2);
                return;
            }
            else {
                int v3 = arg2 ? 0xFF : 0;
                v0.setAlpha(v3);
                float v2 = arg2 ? 1f : 0f;
                this.checkedAnimationProgress = v2;
            }
        }
    }

    public void setChecked(boolean arg2) {
        this.setChecked(arg2, false);
    }

    void setCheckedIcon(Drawable arg2) {
        if(arg2 != null) {
            arg2 = DrawableCompat.wrap(arg2).mutate();
            this.checkedIcon = arg2;
            DrawableCompat.setTintList(arg2, this.checkedIconTint);
            this.setChecked(this.materialCardView.isChecked());
        }
        else {
            this.checkedIcon = MaterialCardViewHelper.CHECKED_ICON_NONE;
        }

        LayerDrawable v2 = this.clickableForegroundDrawable;
        if(v2 != null) {
            v2.setDrawableByLayerId(id.mtrl_card_checked_layer_id, this.checkedIcon);
        }
    }

    void setCheckedIconGravity(int arg2) {
        this.checkedIconGravity = arg2;
        this.recalculateCheckedIconPosition(this.materialCardView.getMeasuredWidth(), this.materialCardView.getMeasuredHeight());
    }

    void setCheckedIconMargin(int arg1) {
        this.checkedIconMargin = arg1;
    }

    void setCheckedIconSize(int arg1) {
        this.checkedIconSize = arg1;
    }

    void setCheckedIconTint(ColorStateList arg1) {
        this.checkedIconTint = arg1;
        Drawable v0 = this.checkedIcon;
        if(v0 != null) {
            DrawableCompat.setTintList(v0, arg1);
        }
    }

    void setCornerRadius(float arg2) {
        this.setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(arg2));
        this.fgDrawable.invalidateSelf();
        if((this.shouldAddCornerPaddingOutsideCardBackground()) || (this.shouldAddCornerPaddingInsideCardBackground())) {
            this.updateContentPadding();
        }

        if(this.shouldAddCornerPaddingOutsideCardBackground()) {
            this.updateInsets();
        }
    }

    void setProgress(float arg2) {
        this.bgDrawable.setInterpolation(arg2);
        MaterialShapeDrawable v0 = this.foregroundContentDrawable;
        if(v0 != null) {
            v0.setInterpolation(arg2);
        }

        MaterialShapeDrawable v1 = this.foregroundShapeDrawable;
        if(v1 != null) {
            v1.setInterpolation(arg2);
        }
    }

    void setRippleColor(ColorStateList arg1) {
        this.rippleColor = arg1;
        this.updateRippleColor();
    }

    void setShapeAppearanceModel(ShapeAppearanceModel arg3) {
        this.shapeAppearanceModel = arg3;
        this.bgDrawable.setShapeAppearanceModel(arg3);
        this.bgDrawable.setShadowBitmapDrawingEnable(this.bgDrawable.isRoundRect() ^ 1);
        MaterialShapeDrawable v0 = this.foregroundContentDrawable;
        if(v0 != null) {
            v0.setShapeAppearanceModel(arg3);
        }

        v0 = this.foregroundShapeDrawable;
        if(v0 != null) {
            v0.setShapeAppearanceModel(arg3);
        }

        MaterialShapeDrawable v2 = this.compatRippleDrawable;
        if(v2 != null) {
            v2.setShapeAppearanceModel(arg3);
        }
    }

    void setStrokeColor(ColorStateList arg2) {
        if(this.strokeColor == arg2) {
            return;
        }

        this.strokeColor = arg2;
        this.updateStroke();
    }

    void setStrokeWidth(int arg2) {
        if(arg2 == this.strokeWidth) {
            return;
        }

        this.strokeWidth = arg2;
        this.updateStroke();
    }

    void setUserContentPadding(int arg2, int arg3, int arg4, int arg5) {
        this.userContentPadding.set(arg2, arg3, arg4, arg5);
        this.updateContentPadding();
    }

    private boolean shouldAddCornerPaddingInsideCardBackground() {
        if((this.materialCardView.getPreventCornerOverlap()) && !this.canClipToOutline()) {
            return 1;
        }

        return 0;
    }

    private boolean shouldAddCornerPaddingOutsideCardBackground() {
        if((this.materialCardView.getPreventCornerOverlap()) && (this.canClipToOutline()) && (this.materialCardView.getUseCompatPadding())) {
            return 1;
        }

        return 0;
    }

    private boolean shouldUseClickableForeground() {
        ViewParent v1_1;
        if(this.materialCardView.isClickable()) {
            return 1;
        }

        MaterialCardView v1 = this.materialCardView;
        while(((View)v1).isDuplicateParentStateEnabled()) {
            if(!(((View)v1).getParent() instanceof View)) {
                break;
            }

            v1_1 = ((View)v1_1).getParent();
        }

        return ((View)v1_1).isClickable();
    }

    void updateClickable() {
        MaterialShapeDrawable v1_1;
        Drawable v0 = this.fgDrawable;
        if(this.shouldUseClickableForeground()) {
            Drawable v1 = this.getClickableForeground();
        }
        else {
            v1_1 = this.foregroundContentDrawable;
        }

        this.fgDrawable = ((Drawable)v1_1);
        if(v0 != (((Drawable)v1_1))) {
            this.updateInsetForeground(((Drawable)v1_1));
        }
    }

    void updateContentPadding() {
        float v0 = (this.shouldAddCornerPaddingInsideCardBackground()) || (this.shouldAddCornerPaddingOutsideCardBackground()) ? this.calculateActualCornerPadding() : 0f;
        int v0_1 = ((int)(v0 - this.getParentCardViewCalculatedCornerPadding()));
        this.materialCardView.setAncestorContentPadding(this.userContentPadding.left + v0_1, this.userContentPadding.top + v0_1, this.userContentPadding.right + v0_1, this.userContentPadding.bottom + v0_1);
    }

    void updateElevation() {
        this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
    }

    private void updateInsetForeground(Drawable arg3) {
        boolean v0 = this.materialCardView.getForeground() instanceof InsetDrawable;
        MaterialCardView v1 = this.materialCardView;
        if(v0) {
            v1.getForeground().setDrawable(arg3);
            return;
        }

        v1.setForeground(this.insetDrawable(arg3));
    }

    void updateInsets() {
        if(!this.isBackgroundOverwritten()) {
            this.materialCardView.setBackgroundInternal(this.insetDrawable(this.bgDrawable));
        }

        this.materialCardView.setForeground(this.insetDrawable(this.fgDrawable));
    }

    private void updateRippleColor() {
        if(RippleUtils.USE_FRAMEWORK_RIPPLE) {
            Drawable v0 = this.rippleDrawable;
            if(v0 != null) {
                ((RippleDrawable)v0).setColor(this.rippleColor);
                return;
            }
        }

        MaterialShapeDrawable v0_1 = this.compatRippleDrawable;
        if(v0_1 != null) {
            v0_1.setFillColor(this.rippleColor);
        }
    }

    void updateStroke() {
        this.foregroundContentDrawable.setStroke(((float)this.strokeWidth), this.strokeColor);
    }
}

