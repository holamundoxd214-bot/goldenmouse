package com.google.android.material.floatingactionbutton;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader$TileMode;
import android.graphics.Shader;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

class BorderDrawable extends Drawable {
    class com.google.android.material.floatingactionbutton.BorderDrawable$1 {
    }

    class BorderState extends Drawable$ConstantState {
        BorderState(BorderDrawable arg1, com.google.android.material.floatingactionbutton.BorderDrawable$1 arg2) {
            this(arg1);
        }

        private BorderState(BorderDrawable arg1) {
            BorderDrawable.this = arg1;
            super();
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return BorderDrawable.this;
        }
    }

    private static final float DRAW_STROKE_WIDTH_MULTIPLE = 1.3333f;
    private ColorStateList borderTint;
    float borderWidth;
    private int bottomInnerStrokeColor;
    private int bottomOuterStrokeColor;
    private final RectF boundsRectF;
    private int currentBorderTintColor;
    private boolean invalidateShader;
    private final Paint paint;
    private final ShapeAppearancePathProvider pathProvider;
    private final Rect rect;
    private final RectF rectF;
    private ShapeAppearanceModel shapeAppearanceModel;
    private final Path shapePath;
    private final BorderState state;
    private int topInnerStrokeColor;
    private int topOuterStrokeColor;

    BorderDrawable(ShapeAppearanceModel arg3) {
        super();
        this.pathProvider = ShapeAppearancePathProvider.getInstance();
        this.shapePath = new Path();
        this.rect = new Rect();
        this.rectF = new RectF();
        this.boundsRectF = new RectF();
        this.state = new BorderState(this, null);
        this.invalidateShader = true;
        this.shapeAppearanceModel = arg3;
        Paint v3 = new Paint(1);
        this.paint = v3;
        v3.setStyle(Paint$Style.STROKE);
    }

    private Shader createGradientShader() {
        Rect v1 = this.rect;
        this.copyBounds(v1);
        float v2 = this.borderWidth / (((float)v1.height()));
        return new LinearGradient(0f, ((float)v1.top), 0f, ((float)v1.bottom), new int[]{ColorUtils.compositeColors(this.topOuterStrokeColor, this.currentBorderTintColor), ColorUtils.compositeColors(this.topInnerStrokeColor, this.currentBorderTintColor), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.topInnerStrokeColor, 0), this.currentBorderTintColor), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.bottomInnerStrokeColor, 0), this.currentBorderTintColor), ColorUtils.compositeColors(this.bottomInnerStrokeColor, this.currentBorderTintColor), ColorUtils.compositeColors(this.bottomOuterStrokeColor, this.currentBorderTintColor)}, new float[]{0f, v2, 0.5f, 0.5f, 1f - v2, 1f}, Shader$TileMode.CLAMP);
    }

    public void draw(Canvas arg5) {
        if(this.invalidateShader) {
            this.paint.setShader(this.createGradientShader());
            this.invalidateShader = false;
        }

        float v0 = this.paint.getStrokeWidth() / 2f;
        this.copyBounds(this.rect);
        this.rectF.set(this.rect);
        float v1 = Math.min(this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.getBoundsAsRectF()), this.rectF.width() / 2f);
        if(this.shapeAppearanceModel.isRoundRect(this.getBoundsAsRectF())) {
            this.rectF.inset(v0, v0);
            arg5.drawRoundRect(this.rectF, v1, v1, this.paint);
        }
    }

    protected RectF getBoundsAsRectF() {
        this.boundsRectF.set(this.getBounds());
        return this.boundsRectF;
    }

    public Drawable$ConstantState getConstantState() {
        return this.state;
    }

    public int getOpacity() {
        if(this.borderWidth > 0f) {
            return -3;
        }

        return -2;
    }

    public void getOutline(Outline arg6) {
        if(this.shapeAppearanceModel.isRoundRect(this.getBoundsAsRectF())) {
            arg6.setRoundRect(this.getBounds(), this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.getBoundsAsRectF()));
            return;
        }

        this.copyBounds(this.rect);
        this.rectF.set(this.rect);
        this.pathProvider.calculatePath(this.shapeAppearanceModel, 1f, this.rectF, this.shapePath);
        DrawableUtils.setOutlineToPath(arg6, this.shapePath);
    }

    public boolean getPadding(Rect arg3) {
        if(this.shapeAppearanceModel.isRoundRect(this.getBoundsAsRectF())) {
            int v2 = Math.round(this.borderWidth);
            arg3.set(v2, v2, v2, v2);
        }

        return 1;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    public boolean isStateful() {
        ColorStateList v0 = this.borderTint;
        if(v0 != null && (v0.isStateful()) || (super.isStateful())) {
            return 1;
        }

        return 0;
    }

    protected void onBoundsChange(Rect arg1) {
        this.invalidateShader = true;
    }

    protected boolean onStateChange(int[] arg3) {
        ColorStateList v0 = this.borderTint;
        if(v0 != null) {
            int v3 = v0.getColorForState(arg3, this.currentBorderTintColor);
            if(v3 != this.currentBorderTintColor) {
                this.invalidateShader = true;
                this.currentBorderTintColor = v3;
            }
        }

        if(this.invalidateShader) {
            this.invalidateSelf();
        }

        return this.invalidateShader;
    }

    public void setAlpha(int arg2) {
        this.paint.setAlpha(arg2);
        this.invalidateSelf();
    }

    void setBorderTint(ColorStateList arg3) {
        if(arg3 != null) {
            this.currentBorderTintColor = arg3.getColorForState(this.getState(), this.currentBorderTintColor);
        }

        this.borderTint = arg3;
        this.invalidateShader = true;
        this.invalidateSelf();
    }

    public void setBorderWidth(float arg3) {
        if(this.borderWidth != arg3) {
            this.borderWidth = arg3;
            this.paint.setStrokeWidth(arg3 * 1.3333f);
            this.invalidateShader = true;
            this.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter arg2) {
        this.paint.setColorFilter(arg2);
        this.invalidateSelf();
    }

    void setGradientColors(int arg1, int arg2, int arg3, int arg4) {
        this.topOuterStrokeColor = arg1;
        this.topInnerStrokeColor = arg2;
        this.bottomOuterStrokeColor = arg3;
        this.bottomInnerStrokeColor = arg4;
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel arg1) {
        this.shapeAppearanceModel = arg1;
        this.invalidateSelf();
    }
}

