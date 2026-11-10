package androidx.transition;

import android.animation.TypeEvaluator;

class FloatArrayEvaluator implements TypeEvaluator {
    private float[] mArray;

    FloatArrayEvaluator(float[] arg1) {
        super();
        this.mArray = arg1;
    }

    public Object evaluate(float arg1, Object arg2, Object arg3) {
        return this.evaluate(arg1, ((float[])arg2), ((float[])arg3));
    }

    public float[] evaluate(float arg4, float[] arg5, float[] arg6) {
        float[] v3 = this.mArray;
        if(v3 == null) {
            v3 = new float[arg5.length];
        }

        int v0;
        for(v0 = 0; v0 < v3.length; ++v0) {
            v3[v0] = arg5[v0] + (arg6[v0] - arg5[v0]) * arg4;
        }

        return v3;
    }
}

