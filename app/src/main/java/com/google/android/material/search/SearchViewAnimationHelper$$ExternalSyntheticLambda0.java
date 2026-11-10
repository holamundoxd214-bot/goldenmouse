package com.google.android.material.search;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.graphics.Rect;

public final class SearchViewAnimationHelper$$ExternalSyntheticLambda0 implements ValueAnimator$AnimatorUpdateListener {
    public SearchViewAnimationHelper$$ExternalSyntheticLambda0(SearchViewAnimationHelper arg1, float arg2, float arg3, Rect arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final void onAnimationUpdate(ValueAnimator arg4) {
        this.f$0.lambda$getRootViewAnimator$2$com-google-android-material-search-SearchViewAnimationHelper(this.f$1, this.f$2, this.f$3, arg4);
    }
}

