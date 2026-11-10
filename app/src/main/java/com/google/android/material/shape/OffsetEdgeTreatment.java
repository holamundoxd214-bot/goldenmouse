package com.google.android.material.shape;

public final class OffsetEdgeTreatment extends EdgeTreatment {
    private final float offset;
    private final EdgeTreatment other;

    public OffsetEdgeTreatment(EdgeTreatment arg1, float arg2) {
        super();
        this.other = arg1;
        this.offset = arg2;
    }

    boolean forceIntersection() {
        return this.other.forceIntersection();
    }

    public void getEdgePath(float arg2, float arg3, float arg4, ShapePath arg5) {
        this.other.getEdgePath(arg2, arg3 - this.offset, arg4, arg5);
    }
}

