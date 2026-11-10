package com.google.android.material.search;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable;

public final class SearchBarAnimationHelper$$ExternalSyntheticLambda4 implements ValueAnimator$AnimatorUpdateListener {
    public SearchBarAnimationHelper$$ExternalSyntheticLambda4(MaterialShapeDrawable arg1, View arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onAnimationUpdate(ValueAnimator arg2) {
        SearchBarAnimationHelper.lambda$getExpandedViewBackgroundUpdateListener$1(this.f$0, this.f$1, arg2);
    }
}

