package com.TryJeanPc.goldenmouse.gamespace;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;

public final class GoldenGameCardView$$ExternalSyntheticLambda0 implements ValueAnimator$AnimatorUpdateListener {
    public GoldenGameCardView$$ExternalSyntheticLambda0(GoldenGameCardView arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onAnimationUpdate(ValueAnimator arg1) {
        GoldenGameCardView.showCaption$lambda$2$lambda$1(this.f$0, arg1);
    }
}

