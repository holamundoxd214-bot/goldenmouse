package com.google.android.material.shape;

public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float arg1, boolean arg2) {
        super();
        this.size = arg1;
        this.inside = arg2;
    }

    public void getEdgePath(float arg4, float arg5, float arg6, ShapePath arg7) {
        boolean v0 = this.inside;
        float v1 = this.size;
        if(v0) {
            arg7.lineTo(arg5 - v1 * arg6, 0f);
            arg7.lineTo(arg5, this.size * arg6, this.size * arg6 + arg5, 0f);
            arg7.lineTo(arg4, 0f);
            return;
        }

        arg7.lineTo(arg5 - v1 * arg6, 0f, arg5, -v1 * arg6);
        arg7.lineTo(arg5 + this.size * arg6, 0f, arg4, 0f);
    }
}

