package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    protected LookupTableInterpolator(float[] arg2) {
        super();
        this.mValues = arg2;
        this.mStepSize = 1f / (((float)(arg2.length - 1)));
    }
}

