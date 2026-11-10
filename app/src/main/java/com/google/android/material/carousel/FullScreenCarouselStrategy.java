package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;

public class FullScreenCarouselStrategy extends CarouselStrategy {
    public FullScreenCarouselStrategy() {
        super();
    }

    KeylineState onFirstChildMeasuredWithMargins(Carousel arg12, View arg13) {
        int v11_1;
        int v0;
        float v12;
        ViewGroup$LayoutParams v11 = arg13.getLayoutParams();
        if(arg12.isHorizontal()) {
            v12 = ((float)arg12.getContainerWidth());
            v0 = ((LayoutParams)v11).leftMargin;
            v11_1 = ((LayoutParams)v11).rightMargin;
        }
        else {
            v12 = ((float)arg12.getContainerHeight());
            v0 = ((LayoutParams)v11).topMargin;
            v11_1 = ((LayoutParams)v11).bottomMargin;
        }

        float v11_2 = ((float)(v0 + v11_1));
        return CarouselStrategyHelper.createLeftAlignedKeylineState(arg13.getContext(), v11_2, v12, new Arrangement(0, 0f, 0f, 0f, 0, 0f, 0, Math.min(v12 + v11_2, v12), 1, v12));
    }
}

