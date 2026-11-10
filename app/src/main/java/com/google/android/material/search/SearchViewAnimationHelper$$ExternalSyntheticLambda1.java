package com.google.android.material.search;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;

public final class SearchViewAnimationHelper$$ExternalSyntheticLambda1 implements ValueAnimator$AnimatorUpdateListener {
    public SearchViewAnimationHelper$$ExternalSyntheticLambda1(DrawerArrowDrawable arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onAnimationUpdate(ValueAnimator arg1) {
        SearchViewAnimationHelper.lambda$addDrawerArrowDrawableAnimatorIfNeeded$3(this.f$0, arg1);
    }
}

