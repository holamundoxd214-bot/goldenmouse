package com.google.android.material.shape;

public class EdgeTreatment {
    public EdgeTreatment() {
        super();
    }

    boolean forceIntersection() {
        return 0;
    }

    public void getEdgePath(float arg1, float arg2, float arg3, ShapePath arg4) {
        arg4.lineTo(arg1, 0f);
    }

    @Deprecated public void getEdgePath(float arg2, float arg3, ShapePath arg4) {
        this.getEdgePath(arg2, arg2 / 2f, arg3, arg4);
    }
}

