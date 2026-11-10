package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;

class FadeTabIndicatorInterpolator extends TabIndicatorInterpolator {
    private static final float FADE_THRESHOLD = 0.5f;

    FadeTabIndicatorInterpolator() {
        super();
    }

    void updateIndicatorForOffset(TabLayout arg2, View arg3, View arg4, float arg5, Drawable arg6) {
        float v1 = 0.5f;
        int v0 = Float.compare(arg5, v1);
        if(v0 < 0) {
        }
        else {
            arg3 = arg4;
        }

        RectF v2 = FadeTabIndicatorInterpolator.calculateIndicatorWidthForTab(arg2, arg3);
        float v3 = 1f;
        v1 = v0 < 0 ? AnimationUtils.lerp(v3, 0f, 0f, v1, arg5) : AnimationUtils.lerp(0f, v3, v1, v3, arg5);
        arg6.setBounds(((int)v2.left), arg6.getBounds().top, ((int)v2.right), arg6.getBounds().bottom);
        arg6.setAlpha(((int)(v1 * 255f)));
    }
}

