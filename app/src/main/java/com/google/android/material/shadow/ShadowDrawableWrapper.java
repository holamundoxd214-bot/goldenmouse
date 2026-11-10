package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path$FillType;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader$TileMode;
import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.R$color;

@Deprecated public class ShadowDrawableWrapper extends DrawableWrapperCompat {
    static final double COS_45 = 0;
    static final float SHADOW_BOTTOM_SCALE = 1f;
    static final float SHADOW_HORIZ_SCALE = 0.5f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean addPaddingForCorners;
    final RectF contentBounds;
    float cornerRadius;
    final Paint cornerShadowPaint;
    Path cornerShadowPath;
    private boolean dirty;
    final Paint edgeShadowPaint;
    float maxShadowSize;
    private boolean printedShadowClipWarning;
    float rawMaxShadowSize;
    float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    float shadowSize;
    private final int shadowStartColor;

    static {
        ShadowDrawableWrapper.COS_45 = Math.cos(Math.toRadians(45));
    }

    public ShadowDrawableWrapper(Context arg2, Drawable arg3, float arg4, float arg5, float arg6) {
        super(arg3);
        this.dirty = true;
        this.addPaddingForCorners = true;
        this.printedShadowClipWarning = false;
        this.shadowStartColor = ContextCompat.getColor(arg2, color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.getColor(arg2, color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.getColor(arg2, color.design_fab_shadow_end_color);
        Paint v2 = new Paint(5);
        this.cornerShadowPaint = v2;
        v2.setStyle(Paint$Style.FILL);
        this.cornerRadius = ((float)Math.round(arg4));
        this.contentBounds = new RectF();
        Paint v4 = new Paint(v2);
        this.edgeShadowPaint = v4;
        v4.setAntiAlias(false);
        this.setShadowSize(arg5, arg6);
    }

    private void buildComponents(Rect arg7) {
        float v0 = this.rawMaxShadowSize * 1.5f;
        this.contentBounds.set((((float)arg7.left)) + this.rawMaxShadowSize, (((float)arg7.top)) + v0, (((float)arg7.right)) - this.rawMaxShadowSize, (((float)arg7.bottom)) - v0);
        this.getDrawable().setBounds(((int)this.contentBounds.left), ((int)this.contentBounds.top), ((int)this.contentBounds.right), ((int)this.contentBounds.bottom));
        this.buildShadowCorners();
    }

    private void buildShadowCorners() {
        RectF v0 = new RectF(-this.cornerRadius, -this.cornerRadius, this.cornerRadius, this.cornerRadius);
        RectF v1 = new RectF(v0);
        v1.inset(-this.shadowSize, -this.shadowSize);
        Path v2 = this.cornerShadowPath;
        if(v2 == null) {
            this.cornerShadowPath = new Path();
        }
        else {
            v2.reset();
        }

        this.cornerShadowPath.setFillType(Path$FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-this.cornerRadius, 0f);
        this.cornerShadowPath.rLineTo(-this.shadowSize, 0f);
        this.cornerShadowPath.arcTo(v1, 180f, 90f, false);
        this.cornerShadowPath.arcTo(v0, 270f, -90f, false);
        this.cornerShadowPath.close();
        float v10 = -v1.top;
        int v3 = 3;
        if(Float.compare(v10, 0f) > 0) {
            float v2_1 = this.cornerRadius / v10;
            Paint v14 = this.cornerShadowPaint;
            int[] v11 = new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor};
            float[] v12 = new float[4];
            v12[0] = 0f;
            v12[1] = v2_1;
            v12[2] = (1f - v2_1) / 2f + v2_1;
            v12[v3] = 1f;
            v14.setShader(new RadialGradient(0f, 0f, v10, v11, v12, Shader$TileMode.CLAMP));
        }

        this.edgeShadowPaint.setShader(new LinearGradient(0f, v0.top, 0f, v1.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0f, 0.5f, 1f}, Shader$TileMode.CLAMP));
        this.edgeShadowPaint.setAntiAlias(false);
    }

    public static float calculateHorizontalPadding(float arg6, float arg7, boolean arg8) {
        if(arg8) {
            arg6 = ((float)((((double)arg6)) + (1 - ShadowDrawableWrapper.COS_45) * (((double)arg7))));
        }

        return arg6;
    }

    public static float calculateVerticalPadding(float arg6, float arg7, boolean arg8) {
        float v0 = 1.5f;
        if(arg8) {
            return ((float)((((double)(arg6 * v0))) + (1 - ShadowDrawableWrapper.COS_45) * (((double)arg7))));
        }

        return arg6 * v0;
    }

    public void draw(Canvas arg2) {
        if(this.dirty) {
            this.buildComponents(this.getBounds());
            this.dirty = false;
        }

        this.drawShadow(arg2);
        super.draw(arg2);
    }

    private void drawShadow(Canvas arg19) {
        int v12_1;
        float v17;
        ShadowDrawableWrapper v0 = this;
        Canvas v1 = arg19;
        int v7 = v1.save();
        v1.rotate(v0.rotation, v0.contentBounds.centerX(), v0.contentBounds.centerY());
        float v8 = v0.cornerRadius;
        float v3 = -v8 - v0.shadowSize;
        float v9 = v8 * 2f;
        int v10 = Float.compare(v0.contentBounds.width() - v9, 0f) > 0 ? 1 : 0;
        int v11 = v0.contentBounds.height() - v9 > 0f ? 1 : 0;
        float v4 = v0.rawShadowSize - 0.25f * v0.rawShadowSize;
        float v12 = 1f;
        float v13 = v8 / (v0.rawShadowSize - 0.5f * v0.rawShadowSize + v8);
        float v14 = v8 / (v4 + v8);
        float v15 = v8 / (v0.rawShadowSize - v0.rawShadowSize * v12 + v8);
        int v2 = v1.save();
        v1.translate(v0.contentBounds.left + v8, v0.contentBounds.top + v8);
        v1.scale(v13, v14);
        v1.drawPath(v0.cornerShadowPath, v0.cornerShadowPaint);
        if(v10 != 0) {
            v1.scale(v12 / v13, v12);
            v17 = v12;
            v12_1 = v2;
            v1.drawRect(0f, v3, v0.contentBounds.width() - v9, -v0.cornerRadius, v0.edgeShadowPaint);
        }
        else {
            v17 = v12;
            v12_1 = v2;
        }

        v1.restoreToCount(v12_1);
        v12_1 = v1.save();
        v1.translate(v0.contentBounds.right - v8, v0.contentBounds.bottom - v8);
        v1.scale(v13, v15);
        v1.rotate(180f);
        v1.drawPath(v0.cornerShadowPath, v0.cornerShadowPaint);
        if(v10 != 0) {
            v1.scale(v17 / v13, v17);
            v1.drawRect(0f, v3, v0.contentBounds.width() - v9, v0.shadowSize + -v0.cornerRadius, v0.edgeShadowPaint);
        }

        v1.restoreToCount(v12_1);
        v10 = v1.save();
        v1.translate(v0.contentBounds.left + v8, v0.contentBounds.bottom - v8);
        v1.scale(v13, v15);
        v1.rotate(270f);
        v1.drawPath(v0.cornerShadowPath, v0.cornerShadowPaint);
        if(v11 != 0) {
            v1.scale(1f / v15, 1f);
            v1.drawRect(0f, v3, v0.contentBounds.height() - v9, -v0.cornerRadius, v0.edgeShadowPaint);
        }

        v1.restoreToCount(v10);
        int v6 = v1.save();
        v1.translate(v0.contentBounds.right - v8, v0.contentBounds.top + v8);
        v1.scale(v13, v14);
        v1.rotate(90f);
        v1.drawPath(v0.cornerShadowPath, v0.cornerShadowPaint);
        if(v11 != 0) {
            v1.scale(1f / v14, 1f);
            arg19.drawRect(0f, v3, v0.contentBounds.height() - v9, -v0.cornerRadius, v0.edgeShadowPaint);
            v1 = arg19;
        }

        v1.restoreToCount(v6);
        v1.restoreToCount(v7);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getMinHeight() {
        return Math.max(this.rawMaxShadowSize, this.cornerRadius + this.rawMaxShadowSize * 1.5f / 2f) * 2f + this.rawMaxShadowSize * 1.5f * 2f;
    }

    public float getMinWidth() {
        return Math.max(this.rawMaxShadowSize, this.cornerRadius + this.rawMaxShadowSize / 2f) * 2f + this.rawMaxShadowSize * 2f;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect arg4) {
        int v0 = ((int)Math.ceil(((double)ShadowDrawableWrapper.calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners))));
        int v3 = ((int)Math.ceil(((double)ShadowDrawableWrapper.calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners))));
        arg4.set(v3, v0, v3, v0);
        return 1;
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    protected void onBoundsChange(Rect arg1) {
        this.dirty = true;
    }

    public void setAddPaddingForCorners(boolean arg1) {
        this.addPaddingForCorners = arg1;
        this.invalidateSelf();
    }

    public void setAlpha(int arg2) {
        super.setAlpha(arg2);
        this.cornerShadowPaint.setAlpha(arg2);
        this.edgeShadowPaint.setAlpha(arg2);
    }

    public void setCornerRadius(float arg2) {
        arg2 = ((float)Math.round(arg2));
        if(this.cornerRadius == arg2) {
            return;
        }

        this.cornerRadius = arg2;
        this.dirty = true;
        this.invalidateSelf();
    }

    public void setMaxShadowSize(float arg2) {
        this.setShadowSize(this.rawShadowSize, arg2);
    }

    public final void setRotation(float arg2) {
        if(this.rotation != arg2) {
            this.rotation = arg2;
            this.invalidateSelf();
        }
    }

    public void setShadowSize(float arg3, float arg4) {
        if(arg3 >= 0f && arg4 >= 0f) {
            arg3 = ((float)ShadowDrawableWrapper.toEven(arg3));
            arg4 = ((float)ShadowDrawableWrapper.toEven(arg4));
            if(Float.compare(arg3, arg4) > 0) {
                if(!this.printedShadowClipWarning) {
                    this.printedShadowClipWarning = true;
                }

                arg3 = arg4;
            }

            if(this.rawShadowSize == arg3 && this.rawMaxShadowSize == arg4) {
                return;
            }

            this.rawShadowSize = arg3;
            this.rawMaxShadowSize = arg4;
            this.shadowSize = ((float)Math.round(arg3 * 1.5f));
            this.maxShadowSize = arg4;
            this.dirty = true;
            this.invalidateSelf();
            return;
        }

        throw new IllegalArgumentException("invalid shadow size");
    }

    public void setShadowSize(float arg2) {
        this.setShadowSize(arg2, this.rawMaxShadowSize);
    }

    private static int toEven(float arg2) {
        int v2 = Math.round(arg2);
        if(v2 % 2 == 1) {
            --v2;
        }

        return v2;
    }
}

