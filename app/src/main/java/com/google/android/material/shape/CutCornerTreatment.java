package com.google.android.material.shape;

public class CutCornerTreatment extends CornerTreatment {
    float size;

    public CutCornerTreatment() {
        super();
        this.size = -1f;
    }

    @Deprecated public CutCornerTreatment(float arg1) {
        super();
        this.size = arg1;
    }

    public void getCornerPath(ShapePath arg5, float arg6, float arg7, float arg8) {
        arg5.reset(0f, arg8 * arg7, 180f, 180f - arg6);
        double v2 = ((double)arg8);
        double v7 = ((double)arg7);
        arg5.lineTo(((float)(Math.sin(Math.toRadians(((double)arg6))) * v2 * v7)), ((float)(Math.sin(Math.toRadians(((double)(90f - arg6)))) * v2 * v7)));
    }
}

