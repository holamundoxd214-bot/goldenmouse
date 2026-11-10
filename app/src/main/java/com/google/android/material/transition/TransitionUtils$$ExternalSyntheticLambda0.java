package com.google.android.material.transition;

import android.graphics.RectF;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel$CornerSizeUnaryOperator;

public final class TransitionUtils$$ExternalSyntheticLambda0 implements CornerSizeUnaryOperator {
    public TransitionUtils$$ExternalSyntheticLambda0(RectF arg1) {
        super();
        this.f$0 = arg1;
    }

    public final CornerSize apply(CornerSize arg1) {
        return TransitionUtils.lambda$convertToRelativeCornerSizes$0(this.f$0, arg1);
    }
}

