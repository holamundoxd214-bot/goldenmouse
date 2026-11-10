package com.google.android.material.shape;

import android.graphics.RectF;

public class CornerTreatment {
    public CornerTreatment() {
        super();
    }

    @Deprecated public void getCornerPath(float arg1, float arg2, ShapePath arg3) {
    }

    public void getCornerPath(ShapePath arg1, float arg2, float arg3, float arg4) {
        this.getCornerPath(arg2, arg3, arg1);
    }

    public void getCornerPath(ShapePath arg1, float arg2, float arg3, RectF arg4, CornerSize arg5) {
        this.getCornerPath(arg1, arg2, arg3, arg5.getCornerSize(arg4));
    }
}

