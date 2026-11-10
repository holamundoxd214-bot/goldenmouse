package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;

class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    ElasticTabIndicatorInterpolator() {
        super();
    }

    private static float accInterp(float arg4) {
        return ((float)(1 - Math.cos((((double)arg4)) * 3.141593 / 2)));
    }

    private static float decInterp(float arg4) {
        return ((float)Math.sin((((double)arg4)) * 3.141593 / 2));
    }

    void updateIndicatorForOffset(TabLayout arg2, View arg3, View arg4, float arg5, Drawable arg6) {
        float v4;
        float v3;
        RectF v1 = ElasticTabIndicatorInterpolator.calculateIndicatorWidthForTab(arg2, arg3);
        RectF v2 = ElasticTabIndicatorInterpolator.calculateIndicatorWidthForTab(arg2, arg4);
        if(v1.left < v2.left) {
            v3 = ElasticTabIndicatorInterpolator.accInterp(arg5);
            v4 = ElasticTabIndicatorInterpolator.decInterp(arg5);
        }
        else {
            v3 = ElasticTabIndicatorInterpolator.decInterp(arg5);
            v4 = ElasticTabIndicatorInterpolator.accInterp(arg5);
        }

        arg6.setBounds(AnimationUtils.lerp(((int)v1.left), ((int)v2.left), v3), arg6.getBounds().top, AnimationUtils.lerp(((int)v1.right), ((int)v2.right), v4), arg6.getBounds().bottom);
    }
}

