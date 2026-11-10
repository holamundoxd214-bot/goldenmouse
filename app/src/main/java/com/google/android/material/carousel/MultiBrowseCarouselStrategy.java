package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;

public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private static final int[] MEDIUM_COUNTS;
    private static final int[] SMALL_COUNTS;
    private int keylineCount;

    static {
        MultiBrowseCarouselStrategy.SMALL_COUNTS = new int[]{1};
        MultiBrowseCarouselStrategy.MEDIUM_COUNTS = new int[]{1, 0};
    }

    public MultiBrowseCarouselStrategy() {
        super();
        this.keylineCount = 0;
    }

    boolean ensureArrangementFitsItemCount(Arrangement arg3, int arg4) {
        boolean v0;
        int v2 = arg3.getItemCount() - arg4;
        if(v2 > 0) {
            if(arg3.smallCount <= 0 && arg3.mediumCount <= 1) {
                goto label_10;
            }

            v0 = true;
        }
        else {
        label_10:
            v0 = false;
        }

        while(v2 > 0) {
            if(arg3.smallCount > 0) {
                --arg3.smallCount;
            }
            else if(arg3.mediumCount > 1) {
                --arg3.mediumCount;
            }

            --v2;
        }

        return v0;
    }

    KeylineState onFirstChildMeasuredWithMargins(Carousel arg18, View arg19) {
        MultiBrowseCarouselStrategy v0 = this;
        float v1 = ((float)arg18.getContainerHeight());
        if(arg18.isHorizontal()) {
            v1 = ((float)arg18.getContainerWidth());
        }

        float v2 = v1;
        ViewGroup$LayoutParams v1_1 = arg19.getLayoutParams();
        float v3 = ((float)(((LayoutParams)v1_1).topMargin + ((LayoutParams)v1_1).bottomMargin));
        float v4 = ((float)arg19.getMeasuredHeight());
        if(arg18.isHorizontal()) {
            v3 = ((float)(((LayoutParams)v1_1).leftMargin + ((LayoutParams)v1_1).rightMargin));
            v4 = ((float)arg19.getMeasuredWidth());
        }

        v1 = v3;
        v3 = CarouselStrategyHelper.getSmallSizeMin(arg19.getContext()) + v1;
        float v5 = CarouselStrategyHelper.getSmallSizeMax(arg19.getContext()) + v1;
        float v9 = Math.min(v4 + v1, v2);
        v4 = MathUtils.clamp(v4 / 3f + v1, CarouselStrategyHelper.getSmallSizeMin(arg19.getContext()) + v1, CarouselStrategyHelper.getSmallSizeMax(arg19.getContext()) + v1);
        float v6 = (v9 + v4) / 2f;
        int[] v8 = MultiBrowseCarouselStrategy.SMALL_COUNTS;
        if(Float.compare(v2, 2f * v3) < 0) {
            v8 = new int[]{0};
        }

        int[] v7 = MultiBrowseCarouselStrategy.MEDIUM_COUNTS;
        if(arg18.getCarouselAlignment() == 1) {
            v8 = MultiBrowseCarouselStrategy.doubleCounts(v8);
            v7 = MultiBrowseCarouselStrategy.doubleCounts(v7);
        }

        int[] v16 = v7;
        float v7_1 = v6;
        int[] v6_1 = v8;
        v8 = v16;
        int v12 = ((int)Math.max(1, Math.floor(((double)((v2 - (((float)CarouselStrategyHelper.maxValue(v8))) * v7_1 - (((float)CarouselStrategyHelper.maxValue(v6_1))) * v5) / v9)))));
        int v13 = ((int)Math.ceil(((double)(v2 / v9))));
        v12 = v13 - v12 + 1;
        int v11 = 0;
        int[] v10 = new int[v12];
        while(v11 < v12) {
            v10[v11] = v13 - v11;
            ++v11;
        }

        float v16_1 = v4;
        v4 = v3;
        v3 = v16_1;
        Arrangement v6_2 = Arrangement.findLowestCostArrangement(v2, v3, v4, v5, v6_1, v7_1, v8, v9, v10);
        v0.keylineCount = v6_2.getItemCount();
        if(v0.ensureArrangementFitsItemCount(v6_2, arg18.getItemCount())) {
            v6_2 = Arrangement.findLowestCostArrangement(v2, v3, v4, v5, new int[]{v6_2.smallCount}, v7_1, new int[]{v6_2.mediumCount}, v9, new int[]{v6_2.largeCount});
        }

        return CarouselStrategyHelper.createKeylineState(arg19.getContext(), v1, v2, v6_2, arg18.getCarouselAlignment());
    }

    boolean shouldRefreshKeylineState(Carousel arg3, int arg4) {
        int v0 = this.keylineCount;
        if(arg4 < v0) {
            v0 = arg3.getItemCount();
            int v1 = this.keylineCount;
            if(v0 < v1) {
                v0 = v1;
                goto label_6;
            }
        }
        else {
        label_6:
            if(arg4 >= v0 && arg3.getItemCount() < this.keylineCount) {
                return 1;
            }

            return 0;
        }

        return 1;
    }
}

