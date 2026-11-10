package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;

class TabIndicatorInterpolator {
    private static final int MIN_INDICATOR_WIDTH = 24;

    TabIndicatorInterpolator() {
        super();
    }

    static RectF calculateIndicatorWidthForTab(TabLayout arg3, View arg4) {
        if(arg4 == null) {
            return new RectF();
        }

        if(!arg3.isTabIndicatorFullWidth() && ((arg4 instanceof TabView))) {
            return TabIndicatorInterpolator.calculateTabViewContentBounds(((TabView)arg4), 24);
        }

        return new RectF(((float)arg4.getLeft()), ((float)arg4.getTop()), ((float)arg4.getRight()), ((float)arg4.getBottom()));
    }

    static RectF calculateTabViewContentBounds(TabView arg3, int arg4) {
        int v0 = arg3.getContentWidth();
        int v1 = arg3.getContentHeight();
        arg4 = ((int)ViewUtils.dpToPx(arg3.getContext(), arg4));
        if(v0 < arg4) {
            v0 = arg4;
        }

        arg4 = (arg3.getLeft() + arg3.getRight()) / 2;
        int v2 = (arg3.getTop() + arg3.getBottom()) / 2;
        v0 /= 2;
        return new RectF(((float)(arg4 - v0)), ((float)(v2 - v1 / 2)), ((float)(v0 + arg4)), ((float)(v2 + arg4 / 2)));
    }

    void setIndicatorBoundsForTab(TabLayout arg2, View arg3, Drawable arg4) {
        RectF v1 = TabIndicatorInterpolator.calculateIndicatorWidthForTab(arg2, arg3);
        arg4.setBounds(((int)v1.left), arg4.getBounds().top, ((int)v1.right), arg4.getBounds().bottom);
    }

    void updateIndicatorForOffset(TabLayout arg1, View arg2, View arg3, float arg4, Drawable arg5) {
        RectF v0 = TabIndicatorInterpolator.calculateIndicatorWidthForTab(arg1, arg2);
        RectF v1 = TabIndicatorInterpolator.calculateIndicatorWidthForTab(arg1, arg3);
        arg5.setBounds(AnimationUtils.lerp(((int)v0.left), ((int)v1.left), arg4), arg5.getBounds().top, AnimationUtils.lerp(((int)v0.right), ((int)v1.right), arg4), arg5.getBounds().bottom);
    }
}

