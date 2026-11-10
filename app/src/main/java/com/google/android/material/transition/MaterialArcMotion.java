package com.google.android.material.transition;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.transition.PathMotion;

public final class MaterialArcMotion extends PathMotion {
    public MaterialArcMotion() {
        super();
    }

    private static PointF getControlPoint(float arg1, float arg2, float arg3, float arg4) {
        if(arg2 > arg4) {
            return new PointF(arg3, arg2);
        }

        return new PointF(arg1, arg4);
    }

    public Path getPath(float arg1, float arg2, float arg3, float arg4) {
        Path v0 = new Path();
        v0.moveTo(arg1, arg2);
        PointF v1 = MaterialArcMotion.getControlPoint(arg1, arg2, arg3, arg4);
        v0.quadTo(v1.x, v1.y, arg3, arg4);
        return v0;
    }
}

