package com.google.android.material.search;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import com.google.android.material.internal.FadeThroughDrawable;

public final class SearchViewAnimationHelper$$ExternalSyntheticLambda3 implements ValueAnimator$AnimatorUpdateListener {
    public SearchViewAnimationHelper$$ExternalSyntheticLambda3(FadeThroughDrawable arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onAnimationUpdate(ValueAnimator arg1) {
        SearchViewAnimationHelper.lambda$addFadeThroughDrawableAnimatorIfNeeded$4(this.f$0, arg1);
    }
}

