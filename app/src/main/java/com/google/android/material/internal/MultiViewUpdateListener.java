package com.google.android.material.internal;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.Collection;

public class MultiViewUpdateListener implements ValueAnimator$AnimatorUpdateListener {
    interface Listener {
        void onAnimationUpdate(ValueAnimator arg1, View arg2);
    }

    private final Listener listener;
    private final View[] views;

    public static void $r8$lambda$WkRITrIg1eLk2gv__5iwocHDqeg(ValueAnimator arg0, View arg1) {
        MultiViewUpdateListener.setScale(arg0, arg1);
    }

    public static void $r8$lambda$kNR6Np3RAVUjjKtQJR0ljE_6vq8(ValueAnimator arg0, View arg1) {
        MultiViewUpdateListener.setTranslationY(arg0, arg1);
    }

    public static void $r8$lambda$l3sYajCeVVvEXOGqzrBJyGlXVps(ValueAnimator arg0, View arg1) {
        MultiViewUpdateListener.setAlpha(arg0, arg1);
    }

    public static void $r8$lambda$tf5oGWUNf6tQQxMTGg7FpP3COoI(ValueAnimator arg0, View arg1) {
        MultiViewUpdateListener.setTranslationX(arg0, arg1);
    }

    public MultiViewUpdateListener(Listener arg1, Collection arg2) {
        super();
        this.listener = arg1;
        this.views = arg2.toArray(new View[0]);
    }

    public MultiViewUpdateListener(Listener arg1, View[] arg2) {
        super();
        this.listener = arg1;
        this.views = arg2;
    }

    public static MultiViewUpdateListener alphaListener(Collection arg2) {
        return new MultiViewUpdateListener(new MultiViewUpdateListener$$ExternalSyntheticLambda3(), arg2);
    }

    public static MultiViewUpdateListener alphaListener(View[] arg2) {
        return new MultiViewUpdateListener(new MultiViewUpdateListener$$ExternalSyntheticLambda3(), arg2);
    }

    public void onAnimationUpdate(ValueAnimator arg6) {
        View[] v0 = this.views;
        int v1 = v0.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            this.listener.onAnimationUpdate(arg6, v0[v2]);
        }
    }

    public static MultiViewUpdateListener scaleListener(Collection arg2) {
        return new MultiViewUpdateListener(new MultiViewUpdateListener$$ExternalSyntheticLambda1(), arg2);
    }

    public static MultiViewUpdateListener scaleListener(View[] arg2) {
        return new MultiViewUpdateListener(new MultiViewUpdateListener$$ExternalSyntheticLambda1(), arg2);
    }

    private static void setAlpha(ValueAnimator arg0, View arg1) {
        arg1.setAlpha(arg0.getAnimatedValue().floatValue());
    }

    private static void setScale(ValueAnimator arg1, View arg2) {
        Object v1 = arg1.getAnimatedValue();
        arg2.setScaleX(((Float)v1).floatValue());
        arg2.setScaleY(((Float)v1).floatValue());
    }

    private static void setTranslationX(ValueAnimator arg0, View arg1) {
        arg1.setTranslationX(arg0.getAnimatedValue().floatValue());
    }

    private static void setTranslationY(ValueAnimator arg0, View arg1) {
        arg1.setTranslationY(arg0.getAnimatedValue().floatValue());
    }

    public static MultiViewUpdateListener translationXListener(Collection arg2) {
        return new MultiViewUpdateListener(new MultiViewUpdateListener$$ExternalSyntheticLambda0(), arg2);
    }

    public static MultiViewUpdateListener translationXListener(View[] arg2) {
        return new MultiViewUpdateListener(new MultiViewUpdateListener$$ExternalSyntheticLambda0(), arg2);
    }

    public static MultiViewUpdateListener translationYListener(Collection arg2) {
        return new MultiViewUpdateListener(new MultiViewUpdateListener$$ExternalSyntheticLambda2(), arg2);
    }

    public static MultiViewUpdateListener translationYListener(View[] arg2) {
        return new MultiViewUpdateListener(new MultiViewUpdateListener$$ExternalSyntheticLambda2(), arg2);
    }
}

