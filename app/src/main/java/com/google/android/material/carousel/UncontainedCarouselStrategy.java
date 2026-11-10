package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;

public final class UncontainedCarouselStrategy extends CarouselStrategy {
    private static final float MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD = 0.85f;

    public UncontainedCarouselStrategy() {
        super();
    }

    private float calculateMediumChildSize(float arg2, float arg3, float arg4) {
        float v1 = Math.max(1.5f * arg4, arg2);
        arg2 = 0.85f * arg3;
        if(v1 > arg2) {
            v1 = Math.max(arg2, arg4 * 1.2f);
        }

        return Math.min(arg3, v1);
    }

    private KeylineState createCenterAlignedKeylineState(float arg14, float arg15, float arg16, int arg17, float arg18, float arg19, float arg20) {
        float v7 = Math.min(arg19, arg16);
        float v8 = UncontainedCarouselStrategy.getChildMaskPercentage(v7, arg16, arg15);
        float v13 = UncontainedCarouselStrategy.getChildMaskPercentage(arg18, arg16, arg15);
        float v9 = arg18 / 2f;
        float v0 = arg20 + 0f - v9;
        float v2 = v0 + v9;
        float v10 = v7 / 2f;
        float v11 = (((float)arg17)) * arg16 + v2;
        Builder v14 = new Builder(arg16, arg14).addAnchorKeyline(v0 - v9 - v10, v8, v7).addKeyline(v0, v13, arg18, false).addKeylineRange(arg16 / 2f + v2, 0f, arg16, arg17, true);
        v14.addKeyline(v9 + v11, v13, arg18, false);
        v14.addAnchorKeyline(v11 + arg18 + v10, v8, v7);
        return v14.build();
    }

    private KeylineState createLeftAlignedKeylineState(Context arg14, float arg15, float arg16, float arg17, int arg18, float arg19, int arg20, float arg21) {
        float v6 = arg19;
        float v7 = Math.min(arg21, arg17);
        float v0 = Math.max(v7, 0.5f * v6);
        float v1 = UncontainedCarouselStrategy.getChildMaskPercentage(v0, arg17, arg15);
        float v8 = UncontainedCarouselStrategy.getChildMaskPercentage(v7, arg17, arg15);
        float v13 = UncontainedCarouselStrategy.getChildMaskPercentage(v6, arg17, arg15);
        float v9 = 2f;
        float v11 = (((float)arg18)) * arg17 + 0f;
        Builder v0_1 = new Builder(arg17, arg16).addAnchorKeyline(0f - v0 / v9, v1, v0).addKeylineRange(arg17 / v9, 0f, arg17, arg18, true);
        if(arg20 > 0) {
            v1 = v6 / v9 + v11;
            v11 += v6;
            v0_1.addKeyline(v1, v13, v6, false);
        }

        v0_1.addAnchorKeyline(v11 + CarouselStrategyHelper.getExtraSmallSize(arg14) / v9, v8, v7);
        return v0_1.build();
    }

    boolean isContained() {
        return 0;
    }

    KeylineState onFirstChildMeasuredWithMargins(Carousel arg12, View arg13) {
        int v0 = arg12.isHorizontal() ? arg12.getContainerWidth() : arg12.getContainerHeight();
        float v2 = ((float)v0);
        ViewGroup$LayoutParams v0_1 = arg13.getLayoutParams();
        float v1 = ((float)(((LayoutParams)v0_1).topMargin + ((LayoutParams)v0_1).bottomMargin));
        float v3 = ((float)arg13.getMeasuredHeight());
        if(arg12.isHorizontal()) {
            v1 = ((float)(((LayoutParams)v0_1).leftMargin + ((LayoutParams)v0_1).rightMargin));
            v3 = ((float)arg13.getMeasuredWidth());
        }

        float v0_2 = v3;
        v3 = v1;
        float v4 = v0_2 + v3;
        v0_2 = CarouselStrategyHelper.getExtraSmallSize(arg13.getContext()) + v3;
        float v7 = CarouselStrategyHelper.getExtraSmallSize(arg13.getContext()) + v3;
        int v5 = 1;
        int v6 = Math.max(1, ((int)Math.floor(((double)(v2 / v4)))));
        v1 = v2 - (((float)v6)) * v4;
        if(arg12.getCarouselAlignment() == 1) {
            float v8 = v1 / 2f;
            return this.createCenterAlignedKeylineState(v2, v3, v4, v6, Math.max(Math.min(3f * v8, v4), CarouselStrategyHelper.getSmallSizeMin(arg13.getContext()) + v3), v7, v8);
        }

        float v10 = v1;
        UncontainedCarouselStrategy v1_1 = this;
        float v11 = v10;
        if(v11 > 0f) {
        }
        else {
            v5 = 0;
        }

        return v1_1.createLeftAlignedKeylineState(arg13.getContext(), v3, v2, v4, v6, v1_1.calculateMediumChildSize(v0_2, v4, v11), v5, v7);
    }
}

