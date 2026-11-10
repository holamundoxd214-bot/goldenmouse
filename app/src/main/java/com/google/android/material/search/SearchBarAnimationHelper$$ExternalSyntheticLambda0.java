package com.google.android.material.search;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.view.View;

public final class SearchBarAnimationHelper$$ExternalSyntheticLambda0 implements ValueAnimator$AnimatorUpdateListener {
    public SearchBarAnimationHelper$$ExternalSyntheticLambda0(View arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onAnimationUpdate(ValueAnimator arg1) {
        SearchBarAnimationHelper.lambda$getFadeOutChildrenAnimator$2(this.f$0, arg1);
    }
}

