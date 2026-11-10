package com.google.android.material.shape;

public final class MarkerEdgeTreatment extends EdgeTreatment {
    private final float radius;

    public MarkerEdgeTreatment(float arg2) {
        super();
        this.radius = arg2 - 0.001f;
    }

    boolean forceIntersection() {
        return 1;
    }

    public void getEdgePath(float arg9, float arg10, float arg11, ShapePath arg12) {
        arg9 = ((float)((((double)this.radius)) * Math.sqrt(2) / 2));
        arg11 = ((float)Math.sqrt(Math.pow(((double)this.radius), 2) - Math.pow(((double)arg9), 2)));
        arg12.reset(arg10 - arg9, (((float)(-((((double)this.radius)) * Math.sqrt(2) - (((double)this.radius)))))) + arg11);
        arg12.lineTo(arg10, ((float)(-((((double)this.radius)) * Math.sqrt(2) - (((double)this.radius))))));
        arg12.lineTo(arg10 + arg9, (((float)(-((((double)this.radius)) * Math.sqrt(2) - (((double)this.radius)))))) + arg11);
    }
}

