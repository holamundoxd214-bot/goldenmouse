package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

class MaterialButtonHelper {
    private static final boolean IS_LOLLIPOP;
    private static final boolean IS_MIN_LOLLIPOP;
    private boolean backgroundOverwritten;
    private ColorStateList backgroundTint;
    private PorterDuff$Mode backgroundTintMode;
    private boolean checkable;
    private int cornerRadius;
    private boolean cornerRadiusSet;
    private int elevation;
    private int insetBottom;
    private int insetLeft;
    private int insetRight;
    private int insetTop;
    private Drawable maskDrawable;
    private final MaterialButton materialButton;
    private ColorStateList rippleColor;
    private LayerDrawable rippleDrawable;
    private ShapeAppearanceModel shapeAppearanceModel;
    private boolean shouldDrawSurfaceColorStroke;
    private ColorStateList strokeColor;
    private int strokeWidth;
    private boolean toggleCheckedStateOnClick;

    static {
        MaterialButtonHelper.IS_MIN_LOLLIPOP = true;
        MaterialButtonHelper.IS_LOLLIPOP = false;
    }

    MaterialButtonHelper(MaterialButton arg2, ShapeAppearanceModel arg3) {
        super();
        this.shouldDrawSurfaceColorStroke = false;
        this.backgroundOverwritten = false;
        this.cornerRadiusSet = false;
        this.toggleCheckedStateOnClick = true;
        this.materialButton = arg2;
        this.shapeAppearanceModel = arg3;
    }

    private Drawable createBackground() {
        MaterialShapeDrawable v0 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        v0.initializeElevationOverlay(this.materialButton.getContext());
        DrawableCompat.setTintList(((Drawable)v0), this.backgroundTint);
        PorterDuff$Mode v1 = this.backgroundTintMode;
        if(v1 != null) {
            DrawableCompat.setTintMode(((Drawable)v0), v1);
        }

        v0.setStroke(((float)this.strokeWidth), this.strokeColor);
        MaterialShapeDrawable v1_1 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        v1_1.setTint(0);
        float v3 = ((float)this.strokeWidth);
        int v4 = this.shouldDrawSurfaceColorStroke ? MaterialColors.getColor(this.materialButton, attr.colorSurface) : 0;
        v1_1.setStroke(v3, v4);
        v4 = 2;
        if(MaterialButtonHelper.IS_MIN_LOLLIPOP) {
            MaterialShapeDrawable v3_1 = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.maskDrawable = ((Drawable)v3_1);
            DrawableCompat.setTint(((Drawable)v3_1), -1);
            ColorStateList v6 = RippleUtils.sanitizeRippleDrawableColor(this.rippleColor);
            Drawable[] v4_1 = new Drawable[v4];
            v4_1[0] = v1_1;
            v4_1[1] = v0;
            RippleDrawable v3_2 = new RippleDrawable(v6, this.wrapDrawableWithInset(new LayerDrawable(v4_1)), this.maskDrawable);
            this.rippleDrawable = ((LayerDrawable)v3_2);
            return ((Drawable)v3_2);
        }

        RippleDrawableCompat v3_3 = new RippleDrawableCompat(this.shapeAppearanceModel);
        this.maskDrawable = ((Drawable)v3_3);
        DrawableCompat.setTintList(((Drawable)v3_3), RippleUtils.sanitizeRippleDrawableColor(this.rippleColor));
        Drawable[] v6_1 = new Drawable[3];
        v6_1[0] = v1_1;
        v6_1[1] = v0;
        v6_1[v4] = this.maskDrawable;
        LayerDrawable v3_4 = new LayerDrawable(v6_1);
        this.rippleDrawable = v3_4;
        return this.wrapDrawableWithInset(((Drawable)v3_4));
    }

    int getCornerRadius() {
        return this.cornerRadius;
    }

    public int getInsetBottom() {
        return this.insetBottom;
    }

    public int getInsetTop() {
        return this.insetTop;
    }

    public Shapeable getMaskDrawable() {
        LayerDrawable v0 = this.rippleDrawable;
        if(v0 != null && v0.getNumberOfLayers() > 1) {
            int v0_1 = this.rippleDrawable.getNumberOfLayers();
            LayerDrawable v3 = this.rippleDrawable;
            int v2 = 2;
            if(v0_1 > v2) {
                return v3.getDrawable(v2);
            }
            else {
                return v3.getDrawable(1);
            }
        }

        return null;
    }

    MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.getMaterialShapeDrawable(false);
    }

    private MaterialShapeDrawable getMaterialShapeDrawable(boolean arg2) {
        LayerDrawable v0 = this.rippleDrawable;
        if(v0 != null && v0.getNumberOfLayers() > 0) {
            boolean v0_1 = MaterialButtonHelper.IS_MIN_LOLLIPOP;
            LayerDrawable v1 = this.rippleDrawable;
            if(v0_1) {
                return v1.getDrawable(0).getDrawable().getDrawable((((int)arg2)) ^ 1);
            }
            else {
                return v1.getDrawable((((int)arg2)) ^ 1);
            }
        }

        return null;
    }

    ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    int getStrokeWidth() {
        return this.strokeWidth;
    }

    ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    PorterDuff$Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    private MaterialShapeDrawable getSurfaceColorStrokeDrawable() {
        return this.getMaterialShapeDrawable(true);
    }

    boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    boolean isCheckable() {
        return this.checkable;
    }

    boolean isToggleCheckedStateOnClick() {
        return this.toggleCheckedStateOnClick;
    }

    void loadFromAttributes(TypedArray arg6) {
        int v0;
        this.insetLeft = arg6.getDimensionPixelOffset(styleable.MaterialButton_android_insetLeft, 0);
        this.insetRight = arg6.getDimensionPixelOffset(styleable.MaterialButton_android_insetRight, 0);
        this.insetTop = arg6.getDimensionPixelOffset(styleable.MaterialButton_android_insetTop, 0);
        this.insetBottom = arg6.getDimensionPixelOffset(styleable.MaterialButton_android_insetBottom, 0);
        int v3 = -1;
        if(arg6.hasValue(styleable.MaterialButton_cornerRadius)) {
            v0 = arg6.getDimensionPixelSize(styleable.MaterialButton_cornerRadius, v3);
            this.cornerRadius = v0;
            this.setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(((float)v0)));
            this.cornerRadiusSet = true;
        }

        this.strokeWidth = arg6.getDimensionPixelSize(styleable.MaterialButton_strokeWidth, 0);
        this.backgroundTintMode = ViewUtils.parseTintMode(arg6.getInt(styleable.MaterialButton_backgroundTintMode, v3), PorterDuff$Mode.SRC_IN);
        this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), arg6, styleable.MaterialButton_backgroundTint);
        this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), arg6, styleable.MaterialButton_strokeColor);
        this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), arg6, styleable.MaterialButton_rippleColor);
        this.checkable = arg6.getBoolean(styleable.MaterialButton_android_checkable, false);
        this.elevation = arg6.getDimensionPixelSize(styleable.MaterialButton_elevation, 0);
        this.toggleCheckedStateOnClick = arg6.getBoolean(styleable.MaterialButton_toggleCheckedStateOnClick, true);
        v0 = ViewCompat.getPaddingStart(this.materialButton);
        int v1 = this.materialButton.getPaddingTop();
        int v2 = ViewCompat.getPaddingEnd(this.materialButton);
        v3 = this.materialButton.getPaddingBottom();
        if(arg6.hasValue(styleable.MaterialButton_android_background)) {
            this.setBackgroundOverwritten();
        }
        else {
            this.updateBackground();
        }

        ViewCompat.setPaddingRelative(this.materialButton, v0 + this.insetLeft, v1 + this.insetTop, v2 + this.insetRight, v3 + this.insetBottom);
    }

    void setBackgroundColor(int arg2) {
        if(this.getMaterialShapeDrawable() != null) {
            this.getMaterialShapeDrawable().setTint(arg2);
        }
    }

    void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
        this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
    }

    void setCheckable(boolean arg1) {
        this.checkable = arg1;
    }

    void setCornerRadius(int arg2) {
        if(this.cornerRadiusSet) {
            if(this.cornerRadius != arg2) {
            }
            else {
                return;
            }
        }

        this.cornerRadius = arg2;
        this.cornerRadiusSet = true;
        this.setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(((float)arg2)));
    }

    public void setInsetBottom(int arg2) {
        this.setVerticalInsets(this.insetTop, arg2);
    }

    public void setInsetTop(int arg2) {
        this.setVerticalInsets(arg2, this.insetBottom);
    }

    void setRippleColor(ColorStateList arg3) {
        if(this.rippleColor != arg3) {
            this.rippleColor = arg3;
            boolean v0 = MaterialButtonHelper.IS_MIN_LOLLIPOP;
            if((v0) && ((this.materialButton.getBackground() instanceof RippleDrawable))) {
                this.materialButton.getBackground().setColor(RippleUtils.sanitizeRippleDrawableColor(arg3));
                return;
            }

            if(v0) {
                return;
            }

            if(!(this.materialButton.getBackground() instanceof RippleDrawableCompat)) {
                return;
            }

            this.materialButton.getBackground().setTintList(RippleUtils.sanitizeRippleDrawableColor(arg3));
        }
    }

    void setShapeAppearanceModel(ShapeAppearanceModel arg1) {
        this.shapeAppearanceModel = arg1;
        this.updateButtonShape(arg1);
    }

    void setShouldDrawSurfaceColorStroke(boolean arg1) {
        this.shouldDrawSurfaceColorStroke = arg1;
        this.updateStroke();
    }

    void setStrokeColor(ColorStateList arg2) {
        if(this.strokeColor != arg2) {
            this.strokeColor = arg2;
            this.updateStroke();
        }
    }

    void setStrokeWidth(int arg2) {
        if(this.strokeWidth != arg2) {
            this.strokeWidth = arg2;
            this.updateStroke();
        }
    }

    void setSupportBackgroundTintList(ColorStateList arg2) {
        if(this.backgroundTint != arg2) {
            this.backgroundTint = arg2;
            if(this.getMaterialShapeDrawable() != null) {
                DrawableCompat.setTintList(this.getMaterialShapeDrawable(), this.backgroundTint);
            }
        }
    }

    void setSupportBackgroundTintMode(PorterDuff$Mode arg2) {
        if(this.backgroundTintMode != arg2) {
            this.backgroundTintMode = arg2;
            if(this.getMaterialShapeDrawable() != null && this.backgroundTintMode != null) {
                DrawableCompat.setTintMode(this.getMaterialShapeDrawable(), this.backgroundTintMode);
            }
        }
    }

    void setToggleCheckedStateOnClick(boolean arg1) {
        this.toggleCheckedStateOnClick = arg1;
    }

    private void setVerticalInsets(int arg8, int arg9) {
        int v0 = ViewCompat.getPaddingStart(this.materialButton);
        int v1 = this.materialButton.getPaddingTop();
        int v2 = ViewCompat.getPaddingEnd(this.materialButton);
        int v3 = this.materialButton.getPaddingBottom();
        int v4 = this.insetTop;
        int v5 = this.insetBottom;
        this.insetBottom = arg9;
        this.insetTop = arg8;
        if(!this.backgroundOverwritten) {
            this.updateBackground();
        }

        ViewCompat.setPaddingRelative(this.materialButton, v0, v1 + arg8 - v4, v2, v3 + arg9 - v5);
    }

    private void updateBackground() {
        this.materialButton.setInternalBackground(this.createBackground());
        MaterialShapeDrawable v0 = this.getMaterialShapeDrawable();
        if(v0 != null) {
            v0.setElevation(((float)this.elevation));
            v0.setState(this.materialButton.getDrawableState());
        }
    }

    private void updateButtonShape(ShapeAppearanceModel arg4) {
        if((MaterialButtonHelper.IS_LOLLIPOP) && !this.backgroundOverwritten) {
            int v4 = ViewCompat.getPaddingStart(this.materialButton);
            int v0 = this.materialButton.getPaddingTop();
            int v1 = ViewCompat.getPaddingEnd(this.materialButton);
            int v2 = this.materialButton.getPaddingBottom();
            this.updateBackground();
            ViewCompat.setPaddingRelative(this.materialButton, v4, v0, v1, v2);
            return;
        }

        if(this.getMaterialShapeDrawable() != null) {
            this.getMaterialShapeDrawable().setShapeAppearanceModel(arg4);
        }

        if(this.getSurfaceColorStrokeDrawable() != null) {
            this.getSurfaceColorStrokeDrawable().setShapeAppearanceModel(arg4);
        }

        if(this.getMaskDrawable() != null) {
            this.getMaskDrawable().setShapeAppearanceModel(arg4);
        }
    }

    void updateMaskBounds(int arg5, int arg6) {
        Drawable v0 = this.maskDrawable;
        if(v0 != null) {
            v0.setBounds(this.insetLeft, this.insetTop, arg6 - this.insetRight, arg5 - this.insetBottom);
        }
    }

    private void updateStroke() {
        MaterialShapeDrawable v0 = this.getMaterialShapeDrawable();
        MaterialShapeDrawable v1 = this.getSurfaceColorStrokeDrawable();
        if(v0 != null) {
            v0.setStroke(((float)this.strokeWidth), this.strokeColor);
            if(v1 != null) {
                float v0_1 = ((float)this.strokeWidth);
                int v4 = this.shouldDrawSurfaceColorStroke ? MaterialColors.getColor(this.materialButton, attr.colorSurface) : 0;
                v1.setStroke(v0_1, v4);
            }
        }
    }

    private InsetDrawable wrapDrawableWithInset(Drawable arg7) {
        return new InsetDrawable(arg7, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
    }
}

