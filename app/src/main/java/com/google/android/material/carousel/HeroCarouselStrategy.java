package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;

public class HeroCarouselStrategy extends CarouselStrategy {
    private static final int[] MEDIUM_COUNTS;
    private static final int[] SMALL_COUNTS;
    private int keylineCount;

    static {
        HeroCarouselStrategy.SMALL_COUNTS = new int[]{1};
        HeroCarouselStrategy.MEDIUM_COUNTS = new int[]{0, 1};
    }

    public HeroCarouselStrategy() {
        super();
        this.keylineCount = 0;
    }

    KeylineState onFirstChildMeasuredWithMargins(Carousel arg18, View arg19) {
        int[] v10_1;
        int[] v13_1;
        int v0 = arg18.getContainerHeight();
        if(arg18.isHorizontal()) {
            v0 = arg18.getContainerWidth();
        }

        ViewGroup$LayoutParams v1 = arg19.getLayoutParams();
        float v2 = ((float)(((LayoutParams)v1).topMargin + ((LayoutParams)v1).bottomMargin));
        float v3 = ((float)(arg19.getMeasuredWidth() * 2));
        if(arg18.isHorizontal()) {
            v2 = ((float)(((LayoutParams)v1).leftMargin + ((LayoutParams)v1).rightMargin));
            v3 = ((float)(arg19.getMeasuredHeight() * 2));
        }

        float v6 = CarouselStrategyHelper.getSmallSizeMin(arg19.getContext()) + v2;
        float v7 = CarouselStrategyHelper.getSmallSizeMax(arg19.getContext()) + v2;
        float v4 = ((float)v0);
        float v11 = Math.min(v3 + v2, v4);
        float v5 = MathUtils.clamp(v3 / 3f + v2, CarouselStrategyHelper.getSmallSizeMin(arg19.getContext()) + v2, CarouselStrategyHelper.getSmallSizeMax(arg19.getContext()) + v2);
        float v9 = (v11 + v5) / 2f;
        int[] v0_1 = HeroCarouselStrategy.SMALL_COUNTS;
        int v3_1 = 0;
        int[] v1_1 = Float.compare(v4, 2f * v6) < 0 ? new int[]{0} : v0_1;
        v0 = ((int)Math.max(1, Math.floor(((double)((v4 - (((float)CarouselStrategyHelper.maxValue(v0_1))) * v7) / v11)))));
        int v10 = (((int)Math.ceil(((double)(v4 / v11))))) - v0 + 1;
        int[] v12 = new int[v10];
        int v13;
        for(v13 = 0; v13 < v10; ++v13) {
            v12[v13] = v0 + v13;
        }

        v0 = arg18.getCarouselAlignment() == 1 ? 1 : 0;
        int[] v8 = v0 != 0 ? HeroCarouselStrategy.doubleCounts(v1_1) : v1_1;
        if(v0 != 0) {
            v13_1 = HeroCarouselStrategy.MEDIUM_COUNTS;
            v10_1 = HeroCarouselStrategy.doubleCounts(HeroCarouselStrategy.MEDIUM_COUNTS);
        }
        else {
            v10_1 = HeroCarouselStrategy.MEDIUM_COUNTS;
            v13_1 = v10_1;
        }

        Arrangement v14 = Arrangement.findLowestCostArrangement(v4, v5, v6, v7, v8, v9, v10_1, v11, v12);
        this.keylineCount = v14.getItemCount();
        if(v14.getItemCount() > arg18.getItemCount()) {
            v14 = Arrangement.findLowestCostArrangement(v4, v5, v6, v7, v1_1, v9, v13_1, v11, v12);
        }
        else {
            v3_1 = v0;
        }

        return CarouselStrategyHelper.createKeylineState(arg19.getContext(), v2, v4, v14, v3_1);
    }

    boolean shouldRefreshKeylineState(Carousel arg4, int arg5) {
        if(arg4.getCarouselAlignment() == 1) {
            int v0 = this.keylineCount;
            if(arg5 < v0) {
                v0 = arg4.getItemCount();
                int v2 = this.keylineCount;
                if(v0 < v2) {
                    v0 = v2;
                    goto label_9;
                }
            }
            else {
            label_9:
                if(arg5 < v0) {
                }
                else if(arg4.getItemCount() < this.keylineCount) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }
}

