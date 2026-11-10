package com.google.android.material.shape;

public class RoundedCornerTreatment extends CornerTreatment {
    float radius;

    public RoundedCornerTreatment() {
        super();
        this.radius = -1f;
    }

    @Deprecated public RoundedCornerTreatment(float arg1) {
        super();
        this.radius = arg1;
    }

    public void getCornerPath(ShapePath arg8, float arg9, float arg10, float arg11) {
        arg8.reset(0f, arg11 * arg10, 180f, 180f - arg9);
        float v3 = arg11 * 2f * arg10;
        arg8.addArc(0f, 0f, v3, v3, 180f, arg9);
    }
}

