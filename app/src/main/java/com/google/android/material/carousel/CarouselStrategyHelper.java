package com.google.android.material.carousel;

import android.content.Context;
import com.google.android.material.R$dimen;

final class CarouselStrategyHelper {
    private CarouselStrategyHelper() {
        super();
    }

    static float addEnd(float arg1, float arg2, int arg3) {
        return arg1 + (((float)Math.max(0, arg3 - 1))) * arg2;
    }

    static float addStart(float arg0, float arg1, int arg2) {
        if(arg2 > 0) {
            arg0 += arg1 / 2f;
        }

        return arg0;
    }

    static KeylineState createCenterAlignedKeylineState(Context arg18, float arg19, float arg20, Arrangement arg21) {
        Arrangement v2 = arg21;
        float v3 = Math.min(CarouselStrategyHelper.getExtraSmallSize(arg18) + arg19, v2.largeSize);
        float v4 = 2f;
        float v5 = v3 / v4;
        float v7 = 0f - v5;
        float v8 = CarouselStrategyHelper.addStart(0f, v2.smallSize, v2.smallCount);
        float v6 = CarouselStrategyHelper.updateCurPosition(0f, CarouselStrategyHelper.addEnd(v8, v2.smallSize, ((int)Math.floor(((double)((((float)v2.smallCount)) / v4))))), v2.smallSize, v2.smallCount);
        float v9 = CarouselStrategyHelper.addStart(v6, v2.mediumSize, v2.mediumCount);
        v6 = CarouselStrategyHelper.updateCurPosition(v6, CarouselStrategyHelper.addEnd(v9, v2.mediumSize, ((int)Math.floor(((double)((((float)v2.mediumCount)) / v4))))), v2.mediumSize, v2.mediumCount);
        float v13 = CarouselStrategyHelper.addStart(v6, v2.largeSize, v2.largeCount);
        v6 = CarouselStrategyHelper.updateCurPosition(v6, CarouselStrategyHelper.addEnd(v13, v2.largeSize, v2.largeCount), v2.largeSize, v2.largeCount);
        float v10 = CarouselStrategyHelper.addStart(v6, v2.mediumSize, v2.mediumCount);
        v6 = CarouselStrategyHelper.addStart(CarouselStrategyHelper.updateCurPosition(v6, CarouselStrategyHelper.addEnd(v10, v2.mediumSize, ((int)Math.ceil(((double)((((float)v2.mediumCount)) / v4))))), v2.mediumSize, v2.mediumCount), v2.smallSize, v2.smallCount);
        v5 += arg20;
        float v11 = CarouselStrategy.getChildMaskPercentage(v3, v2.largeSize, arg19);
        float v12 = CarouselStrategy.getChildMaskPercentage(v2.smallSize, v2.largeSize, arg19);
        float v0 = CarouselStrategy.getChildMaskPercentage(v2.mediumSize, v2.largeSize, arg19);
        Builder v1 = new Builder(v2.largeSize, arg20).addAnchorKeyline(v7, v11, v3);
        if(v2.smallCount > 0) {
            v1.addKeylineRange(v8, v12, v2.smallSize, ((int)Math.floor(((double)((((float)v2.smallCount)) / v4)))));
        }

        if(v2.mediumCount > 0) {
            v1.addKeylineRange(v9, v0, v2.mediumSize, ((int)Math.floor(((double)((((float)v2.mediumCount)) / v4)))));
        }

        float v16 = v12;
        Builder v12_1 = v1;
        float v1_1 = v16;
        v12_1.addKeylineRange(v13, 0f, v2.largeSize, v2.largeCount, true);
        if(v2.mediumCount > 0) {
            v12_1.addKeylineRange(v10, v0, v2.mediumSize, ((int)Math.ceil(((double)((((float)v2.mediumCount)) / v4)))));
        }

        if(v2.smallCount > 0) {
            v12_1.addKeylineRange(v6, v1_1, v2.smallSize, ((int)Math.ceil(((double)((((float)v2.smallCount)) / v4)))));
        }

        v12_1.addAnchorKeyline(v5, v11, v3);
        return v12_1.build();
    }

    static KeylineState createKeylineState(Context arg1, float arg2, float arg3, Arrangement arg4, int arg5) {
        if(arg5 == 1) {
            return CarouselStrategyHelper.createCenterAlignedKeylineState(arg1, arg2, arg3, arg4);
        }

        return CarouselStrategyHelper.createLeftAlignedKeylineState(arg1, arg2, arg3, arg4);
    }

    static KeylineState createLeftAlignedKeylineState(Context arg12, float arg13, float arg14, Arrangement arg15) {
        float v12 = Math.min(CarouselStrategyHelper.getExtraSmallSize(arg12) + arg13, arg15.largeSize);
        float v0 = v12 / 2f;
        float v2 = 0f - v0;
        float v6 = CarouselStrategyHelper.addStart(0f, arg15.largeSize, arg15.largeCount);
        float v1 = CarouselStrategyHelper.updateCurPosition(0f, CarouselStrategyHelper.addEnd(v6, arg15.largeSize, arg15.largeCount), arg15.largeSize, arg15.largeCount);
        float v3 = CarouselStrategyHelper.addStart(v1, arg15.mediumSize, arg15.mediumCount);
        v1 = CarouselStrategyHelper.addStart(CarouselStrategyHelper.updateCurPosition(v1, v3, arg15.mediumSize, arg15.mediumCount), arg15.smallSize, arg15.smallCount);
        v0 += arg14;
        float v4 = CarouselStrategy.getChildMaskPercentage(v12, arg15.largeSize, arg13);
        float v11 = CarouselStrategy.getChildMaskPercentage(arg15.smallSize, arg15.largeSize, arg13);
        arg13 = CarouselStrategy.getChildMaskPercentage(arg15.mediumSize, arg15.largeSize, arg13);
        Builder v14 = new Builder(arg15.largeSize, arg14).addAnchorKeyline(v2, v4, v12).addKeylineRange(v6, 0f, arg15.largeSize, arg15.largeCount, true);
        if(arg15.mediumCount > 0) {
            v14.addKeyline(v3, arg13, arg15.mediumSize);
        }

        if(arg15.smallCount > 0) {
            v14.addKeylineRange(v1, v11, arg15.smallSize, arg15.smallCount);
        }

        v14.addAnchorKeyline(v0, v4, v12);
        return v14.build();
    }

    static float getExtraSmallSize(Context arg1) {
        return arg1.getResources().getDimension(dimen.m3_carousel_gone_size);
    }

    static float getSmallSizeMax(Context arg1) {
        return arg1.getResources().getDimension(dimen.m3_carousel_small_item_size_max);
    }

    static float getSmallSizeMin(Context arg1) {
        return arg1.getResources().getDimension(dimen.m3_carousel_small_item_size_min);
    }

    static int maxValue(int[] arg4) {
        int v0 = arg4.length;
        int v1 = 0x80000000;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            int v3 = arg4[v2];
            if(v3 > v1) {
                v1 = v3;
            }
        }

        return v1;
    }

    static float updateCurPosition(float arg0, float arg1, float arg2, int arg3) {
        if(arg3 > 0) {
            return arg1 + arg2 / 2f;
        }

        return arg0;
    }
}

