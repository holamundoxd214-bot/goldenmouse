package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
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
import androidx.cardview.R$color;
import androidx.cardview.R$dimen;

class RoundRectDrawableWithShadow extends Drawable {
    interface RoundRectHelper {
        void drawRoundRect(Canvas arg1, RectF arg2, float arg3, Paint arg4);
    }

    private static final double COS_45 = 0;
    private static final float SHADOW_MULTIPLIER = 1.5f;
    private boolean mAddPaddingForCorners;
    private ColorStateList mBackground;
    private final RectF mCardBounds;
    private float mCornerRadius;
    private Paint mCornerShadowPaint;
    private Path mCornerShadowPath;
    private boolean mDirty;
    private Paint mEdgeShadowPaint;
    private final int mInsetShadow;
    private Paint mPaint;
    private boolean mPrintedShadowClipWarning;
    private float mRawMaxShadowSize;
    private float mRawShadowSize;
    private final int mShadowEndColor;
    private float mShadowSize;
    private final int mShadowStartColor;
    static RoundRectHelper sRoundRectHelper;

    static {
        RoundRectDrawableWithShadow.COS_45 = Math.cos(Math.toRadians(45));
    }

    RoundRectDrawableWithShadow(Resources arg3, ColorStateList arg4, float arg5, float arg6, float arg7) {
        super();
        this.mDirty = true;
        this.mAddPaddingForCorners = true;
        this.mPrintedShadowClipWarning = false;
        this.mShadowStartColor = arg3.getColor(color.cardview_shadow_start_color);
        this.mShadowEndColor = arg3.getColor(color.cardview_shadow_end_color);
        this.mInsetShadow = arg3.getDimensionPixelSize(dimen.cardview_compat_inset_shadow);
        this.mPaint = new Paint(5);
        this.setBackground(arg4);
        Paint v3 = new Paint(5);
        this.mCornerShadowPaint = v3;
        v3.setStyle(Paint$Style.FILL);
        this.mCornerRadius = ((float)(((int)(arg5 + 0.5f))));
        this.mCardBounds = new RectF();
        v3 = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint = v3;
        v3.setAntiAlias(false);
        this.setShadowSize(arg6, arg7);
    }

    private void buildComponents(Rect arg7) {
        float v0 = this.mRawMaxShadowSize * 1.5f;
        this.mCardBounds.set((((float)arg7.left)) + this.mRawMaxShadowSize, (((float)arg7.top)) + v0, (((float)arg7.right)) - this.mRawMaxShadowSize, (((float)arg7.bottom)) - v0);
        this.buildShadowCorners();
    }

    private void buildShadowCorners() {
        RectF v0 = new RectF(-this.mCornerRadius, -this.mCornerRadius, this.mCornerRadius, this.mCornerRadius);
        RectF v1 = new RectF(v0);
        v1.inset(-this.mShadowSize, -this.mShadowSize);
        Path v2 = this.mCornerShadowPath;
        if(v2 == null) {
            this.mCornerShadowPath = new Path();
        }
        else {
            v2.reset();
        }

        this.mCornerShadowPath.setFillType(Path$FillType.EVEN_ODD);
        this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0f);
        this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0f);
        this.mCornerShadowPath.arcTo(v1, 180f, 90f, false);
        this.mCornerShadowPath.arcTo(v0, 270f, -90f, false);
        this.mCornerShadowPath.close();
        this.mCornerShadowPaint.setShader(new RadialGradient(0f, 0f, this.mCornerRadius + this.mShadowSize, new int[]{this.mShadowStartColor, this.mShadowStartColor, this.mShadowEndColor}, new float[]{0f, this.mCornerRadius / (this.mShadowSize + this.mCornerRadius), 1f}, Shader$TileMode.CLAMP));
        this.mEdgeShadowPaint.setShader(new LinearGradient(0f, -this.mCornerRadius + this.mShadowSize, 0f, -this.mCornerRadius - this.mShadowSize, new int[]{this.mShadowStartColor, this.mShadowStartColor, this.mShadowEndColor}, new float[]{0f, 0.5f, 1f}, Shader$TileMode.CLAMP));
        this.mEdgeShadowPaint.setAntiAlias(false);
    }

    static float calculateHorizontalPadding(float arg6, float arg7, boolean arg8) {
        if(arg8) {
            arg6 = ((float)((((double)arg6)) + (1 - RoundRectDrawableWithShadow.COS_45) * (((double)arg7))));
        }

        return arg6;
    }

    static float calculateVerticalPadding(float arg6, float arg7, boolean arg8) {
        float v0 = 1.5f;
        if(arg8) {
            return ((float)((((double)(arg6 * v0))) + (1 - RoundRectDrawableWithShadow.COS_45) * (((double)arg7))));
        }

        return arg6 * v0;
    }

    public void draw(Canvas arg4) {
        if(this.mDirty) {
            this.buildComponents(this.getBounds());
            this.mDirty = false;
        }

        arg4.translate(0f, this.mRawShadowSize / 2f);
        this.drawShadow(arg4);
        arg4.translate(0f, -this.mRawShadowSize / 2f);
        RoundRectDrawableWithShadow.sRoundRectHelper.drawRoundRect(arg4, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    private void drawShadow(Canvas arg12) {
        Canvas v3;
        float v0 = this.mCornerRadius;
        float v5 = -v0 - this.mShadowSize;
        v0 = v0 + (((float)this.mInsetShadow)) + this.mRawShadowSize / 2f;
        float v2 = 2f * v0;
        int v1 = Float.compare(this.mCardBounds.width() - v2, 0f) > 0 ? 1 : 0;
        int v9 = this.mCardBounds.height() - v2 > 0f ? 1 : 0;
        int v10 = arg12.save();
        arg12.translate(this.mCardBounds.left + v0, this.mCardBounds.top + v0);
        arg12.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if(v1 != 0) {
            v3 = arg12;
            v3.drawRect(0f, v5, this.mCardBounds.width() - v2, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        else {
            v3 = arg12;
        }

        v3.restoreToCount(v10);
        int v12 = v3.save();
        v3.translate(this.mCardBounds.right - v0, this.mCardBounds.bottom - v0);
        v3.rotate(180f);
        v3.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if(v1 != 0) {
            v3.drawRect(0f, v5, this.mCardBounds.width() - v2, -this.mCornerRadius + this.mShadowSize, this.mEdgeShadowPaint);
        }

        v3.restoreToCount(v12);
        v12 = v3.save();
        v3.translate(this.mCardBounds.left + v0, this.mCardBounds.bottom - v0);
        v3.rotate(270f);
        v3.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if(v9 != 0) {
            v3.drawRect(0f, v5, this.mCardBounds.height() - v2, -this.mCornerRadius, this.mEdgeShadowPaint);
        }

        v3.restoreToCount(v12);
        v12 = v3.save();
        v3.translate(this.mCardBounds.right - v0, this.mCardBounds.top + v0);
        v3.rotate(90f);
        v3.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if(v9 != 0) {
            v3.drawRect(0f, v5, this.mCardBounds.height() - v2, -this.mCornerRadius, this.mEdgeShadowPaint);
        }

        v3.restoreToCount(v12);
    }

    ColorStateList getColor() {
        return this.mBackground;
    }

    float getCornerRadius() {
        return this.mCornerRadius;
    }

    void getMaxShadowAndCornerPadding(Rect arg1) {
        this.getPadding(arg1);
    }

    float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    float getMinHeight() {
        return Math.max(this.mRawMaxShadowSize, this.mCornerRadius + (((float)this.mInsetShadow)) + this.mRawMaxShadowSize * 1.5f / 2f) * 2f + (this.mRawMaxShadowSize * 1.5f + (((float)this.mInsetShadow))) * 2f;
    }

    float getMinWidth() {
        return Math.max(this.mRawMaxShadowSize, this.mCornerRadius + (((float)this.mInsetShadow)) + this.mRawMaxShadowSize / 2f) * 2f + (this.mRawMaxShadowSize + (((float)this.mInsetShadow))) * 2f;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect arg4) {
        int v0 = ((int)Math.ceil(((double)RoundRectDrawableWithShadow.calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners))));
        int v3 = ((int)Math.ceil(((double)RoundRectDrawableWithShadow.calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners))));
        arg4.set(v3, v0, v3, v0);
        return 1;
    }

    float getShadowSize() {
        return this.mRawShadowSize;
    }

    public boolean isStateful() {
        ColorStateList v0 = this.mBackground;
        if(v0 != null && (v0.isStateful()) || (super.isStateful())) {
            return 1;
        }

        return 0;
    }

    protected void onBoundsChange(Rect arg1) {
        super.onBoundsChange(arg1);
        this.mDirty = true;
    }

    protected boolean onStateChange(int[] arg3) {
        int v3 = this.mBackground.getColorForState(arg3, this.mBackground.getDefaultColor());
        if(this.mPaint.getColor() == v3) {
            return 0;
        }

        this.mPaint.setColor(v3);
        this.mDirty = true;
        this.invalidateSelf();
        return 1;
    }

    void setAddPaddingForCorners(boolean arg1) {
        this.mAddPaddingForCorners = arg1;
        this.invalidateSelf();
    }

    public void setAlpha(int arg2) {
        this.mPaint.setAlpha(arg2);
        this.mCornerShadowPaint.setAlpha(arg2);
        this.mEdgeShadowPaint.setAlpha(arg2);
    }

    private void setBackground(ColorStateList arg3) {
        if(arg3 == null) {
            arg3 = ColorStateList.valueOf(0);
        }

        this.mBackground = arg3;
        this.mPaint.setColor(arg3.getColorForState(this.getState(), this.mBackground.getDefaultColor()));
    }

    void setColor(ColorStateList arg1) {
        this.setBackground(arg1);
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter arg1) {
        this.mPaint.setColorFilter(arg1);
    }

    void setCornerRadius(float arg3) {
        if(arg3 >= 0f) {
            arg3 = ((float)(((int)(arg3 + 0.5f))));
            if(this.mCornerRadius == arg3) {
                return;
            }

            this.mCornerRadius = arg3;
            this.mDirty = true;
            this.invalidateSelf();
            return;
        }

        throw new IllegalArgumentException("Invalid radius " + arg3 + ". Must be >= 0");
    }

    void setMaxShadowSize(float arg2) {
        this.setShadowSize(this.mRawShadowSize, arg2);
    }

    void setShadowSize(float arg2) {
        this.setShadowSize(arg2, this.mRawMaxShadowSize);
    }

    private void setShadowSize(float arg4, float arg5) {
        String v2 = ". Must be >= 0";
        if(Float.compare(arg4, 0f) >= 0) {
            if(arg5 >= 0f) {
                arg4 = ((float)this.toEven(arg4));
                arg5 = ((float)this.toEven(arg5));
                if(Float.compare(arg4, arg5) > 0) {
                    if(!this.mPrintedShadowClipWarning) {
                        this.mPrintedShadowClipWarning = true;
                    }

                    arg4 = arg5;
                }

                if(this.mRawShadowSize == arg4 && this.mRawMaxShadowSize == arg5) {
                    return;
                }

                this.mRawShadowSize = arg4;
                this.mRawMaxShadowSize = arg5;
                this.mShadowSize = ((float)(((int)(arg4 * 1.5f + (((float)this.mInsetShadow)) + 0.5f))));
                this.mDirty = true;
                this.invalidateSelf();
                return;
            }

            throw new IllegalArgumentException("Invalid max shadow size " + arg5 + v2);
        }

        throw new IllegalArgumentException("Invalid shadow size " + arg4 + v2);
    }

    private int toEven(float arg2) {
        int v1 = ((int)(arg2 + 0.5f));
        if(v1 % 2 == 1) {
            --v1;
        }

        return v1;
    }
}

