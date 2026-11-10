package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class MatrixEvaluator implements TypeEvaluator {
    private final float[] tempEndValues;
    private final Matrix tempMatrix;
    private final float[] tempStartValues;

    public MatrixEvaluator() {
        super();
        this.tempStartValues = new float[9];
        this.tempEndValues = new float[9];
        this.tempMatrix = new Matrix();
    }

    public Matrix evaluate(float arg3, Matrix arg4, Matrix arg5) {
        arg4.getValues(this.tempStartValues);
        arg5.getValues(this.tempEndValues);
        int v4;
        for(v4 = 0; v4 < 9; ++v4) {
            this.tempEndValues[v4] = this.tempStartValues[v4] + (this.tempEndValues[v4] - this.tempStartValues[v4]) * arg3;
        }

        this.tempMatrix.setValues(this.tempEndValues);
        return this.tempMatrix;
    }

    public Object evaluate(float arg1, Object arg2, Object arg3) {
        return this.evaluate(arg1, ((Matrix)arg2), ((Matrix)arg3));
    }
}

