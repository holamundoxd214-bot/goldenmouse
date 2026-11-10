package androidx.transition;

import androidx.dynamicanimation.animation.DynamicAnimation$OnAnimationEndListener;
import androidx.dynamicanimation.animation.DynamicAnimation;

public final class Transition$SeekController$$ExternalSyntheticLambda0 implements OnAnimationEndListener {
    public Transition$SeekController$$ExternalSyntheticLambda0(SeekController arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onAnimationEnd(DynamicAnimation arg1, boolean arg2, float arg3, float arg4) {
        this.f$0.lambda$ensureAnimation$0$androidx-transition-Transition$SeekController(arg1, arg2, arg3, arg4);
    }
}

