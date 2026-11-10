package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class CardViewBaseImpl implements CardViewImpl {
    final RectF mCornerRect;

    CardViewBaseImpl() {
        super();
        this.mCornerRect = new RectF();
    }

    private RoundRectDrawableWithShadow createBackground(Context arg1, ColorStateList arg2, float arg3, float arg4, float arg5) {
        return new RoundRectDrawableWithShadow(arg1.getResources(), arg2, arg3, arg4, arg5);
    }

    public ColorStateList getBackgroundColor(CardViewDelegate arg1) {
        return this.getShadowBackground(arg1).getColor();
    }

    public float getElevation(CardViewDelegate arg1) {
        return this.getShadowBackground(arg1).getShadowSize();
    }

    public float getMaxElevation(CardViewDelegate arg1) {
        return this.getShadowBackground(arg1).getMaxShadowSize();
    }

    public float getMinHeight(CardViewDelegate arg1) {
        return this.getShadowBackground(arg1).getMinHeight();
    }

    public float getMinWidth(CardViewDelegate arg1) {
        return this.getShadowBackground(arg1).getMinWidth();
    }

    public float getRadius(CardViewDelegate arg1) {
        return this.getShadowBackground(arg1).getCornerRadius();
    }

    private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate arg1) {
        return arg1.getCardBackground();
    }

    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectHelper() {
            public void drawRoundRect(Canvas arg15, RectF arg16, float arg17, Paint arg18) {
                RectF v6 = arg16;
                float v1 = 2f * arg17;
                float v7 = 1f;
                float v8 = v6.width() - v1 - v7;
                float v9 = v6.height() - v1 - v7;
                if(arg17 >= v7) {
                    float v10 = arg17 + 0.5f;
                    float v2 = -v10;
                    CardViewBaseImpl.this.mCornerRect.set(v2, v2, v10, v10);
                    int v11 = arg15.save();
                    arg15.translate(v6.left + v10, v6.top + v10);
                    arg15.drawArc(CardViewBaseImpl.this.mCornerRect, 180f, 90f, true, arg18);
                    arg15.translate(v8, 0f);
                    arg15.rotate(90f);
                    arg15.drawArc(CardViewBaseImpl.this.mCornerRect, 180f, 90f, true, arg18);
                    arg15.translate(v9, 0f);
                    arg15.rotate(90f);
                    arg15.drawArc(CardViewBaseImpl.this.mCornerRect, 180f, 90f, true, arg18);
                    arg15.translate(v8, 0f);
                    arg15.rotate(90f);
                    arg15.drawArc(CardViewBaseImpl.this.mCornerRect, 180f, 90f, true, arg18);
                    arg15.restoreToCount(v11);
                    arg15.drawRect(v6.left + v10 - v7, v6.top, v6.right - v10 + v7, v6.top + v10, arg18);
                    arg15.drawRect(v6.left + v10 - v7, v6.bottom - v10, v6.right - v10 + v7, v6.bottom, arg18);
                }

                arg15.drawRect(v6.left, v6.top + arg17, v6.right, v6.bottom - arg17, arg18);
            }
        };
    }

    public void initialize(CardViewDelegate arg7, Context arg8, ColorStateList arg9, float arg10, float arg11, float arg12) {
        CardViewBaseImpl v0 = this;
        RoundRectDrawableWithShadow v6 = v0.createBackground(arg8, arg9, arg10, arg11, arg12);
        v6.setAddPaddingForCorners(arg7.getPreventCornerOverlap());
        arg7.setCardBackground(((Drawable)v6));
        v0.updatePadding(arg7);
    }

    public void onCompatPaddingChanged(CardViewDelegate arg1) {
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate arg3) {
        this.getShadowBackground(arg3).setAddPaddingForCorners(arg3.getPreventCornerOverlap());
        this.updatePadding(arg3);
    }

    public void setBackgroundColor(CardViewDelegate arg1, ColorStateList arg2) {
        this.getShadowBackground(arg1).setColor(arg2);
    }

    public void setElevation(CardViewDelegate arg1, float arg2) {
        this.getShadowBackground(arg1).setShadowSize(arg2);
    }

    public void setMaxElevation(CardViewDelegate arg2, float arg3) {
        this.getShadowBackground(arg2).setMaxShadowSize(arg3);
        this.updatePadding(arg2);
    }

    public void setRadius(CardViewDelegate arg2, float arg3) {
        this.getShadowBackground(arg2).setCornerRadius(arg3);
        this.updatePadding(arg2);
    }

    public void updatePadding(CardViewDelegate arg5) {
        Rect v0 = new Rect();
        this.getShadowBackground(arg5).getMaxShadowAndCornerPadding(v0);
        arg5.setMinWidthHeightInternal(((int)Math.ceil(((double)this.getMinWidth(arg5)))), ((int)Math.ceil(((double)this.getMinHeight(arg5)))));
        arg5.setShadowPadding(v0.left, v0.top, v0.right, v0.bottom);
    }
}

