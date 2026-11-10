package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

class CardViewApi21Impl implements CardViewImpl {
    CardViewApi21Impl() {
        super();
    }

    public ColorStateList getBackgroundColor(CardViewDelegate arg1) {
        return this.getCardBackground(arg1).getColor();
    }

    private RoundRectDrawable getCardBackground(CardViewDelegate arg1) {
        return arg1.getCardBackground();
    }

    public float getElevation(CardViewDelegate arg1) {
        return arg1.getCardView().getElevation();
    }

    public float getMaxElevation(CardViewDelegate arg1) {
        return this.getCardBackground(arg1).getPadding();
    }

    public float getMinHeight(CardViewDelegate arg1) {
        return this.getRadius(arg1) * 2f;
    }

    public float getMinWidth(CardViewDelegate arg1) {
        return this.getRadius(arg1) * 2f;
    }

    public float getRadius(CardViewDelegate arg1) {
        return this.getCardBackground(arg1).getRadius();
    }

    public void initStatic() {
    }

    public void initialize(CardViewDelegate arg1, Context arg2, ColorStateList arg3, float arg4, float arg5, float arg6) {
        arg1.setCardBackground(new RoundRectDrawable(arg3, arg4));
        View v2 = arg1.getCardView();
        v2.setClipToOutline(true);
        v2.setElevation(arg5);
        this.setMaxElevation(arg1, arg6);
    }

    public void onCompatPaddingChanged(CardViewDelegate arg2) {
        this.setMaxElevation(arg2, this.getMaxElevation(arg2));
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate arg2) {
        this.setMaxElevation(arg2, this.getMaxElevation(arg2));
    }

    public void setBackgroundColor(CardViewDelegate arg1, ColorStateList arg2) {
        this.getCardBackground(arg1).setColor(arg2);
    }

    public void setElevation(CardViewDelegate arg1, float arg2) {
        arg1.getCardView().setElevation(arg2);
    }

    public void setMaxElevation(CardViewDelegate arg4, float arg5) {
        this.getCardBackground(arg4).setPadding(arg5, arg4.getUseCompatPadding(), arg4.getPreventCornerOverlap());
        this.updatePadding(arg4);
    }

    public void setRadius(CardViewDelegate arg1, float arg2) {
        this.getCardBackground(arg1).setRadius(arg2);
    }

    public void updatePadding(CardViewDelegate arg5) {
        if(!arg5.getUseCompatPadding()) {
            arg5.setShadowPadding(0, 0, 0, 0);
            return;
        }

        float v0 = this.getMaxElevation(arg5);
        float v4 = this.getRadius(arg5);
        int v1 = ((int)Math.ceil(((double)RoundRectDrawableWithShadow.calculateHorizontalPadding(v0, v4, arg5.getPreventCornerOverlap()))));
        int v4_1 = ((int)Math.ceil(((double)RoundRectDrawableWithShadow.calculateVerticalPadding(v0, v4, arg5.getPreventCornerOverlap()))));
        arg5.setShadowPadding(v1, v4_1, v1, v4_1);
    }
}

