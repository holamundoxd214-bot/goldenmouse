package androidx.core.view;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.view.View;

public final class ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0 implements ValueAnimator$AnimatorUpdateListener {
    public ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(ViewPropertyAnimatorUpdateListener arg1, View arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onAnimationUpdate(ValueAnimator arg2) {
        ViewPropertyAnimatorCompat.lambda$setUpdateListener$0(this.f$0, this.f$1, arg2);
    }
}

