package com.TryJeanPc.goldenmouse.gamespace;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;

public final class GoldenSpaceLayout$$ExternalSyntheticLambda3 implements ValueAnimator$AnimatorUpdateListener {
    public GoldenSpaceLayout$$ExternalSyntheticLambda3(GoldenCarouselLayoutManager arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onAnimationUpdate(ValueAnimator arg1) {
        GoldenSpaceLayout.startEntranceIfReady$lambda$10$lambda$9(this.f$0, arg1);
    }
}

