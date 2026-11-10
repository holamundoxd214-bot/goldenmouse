package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.ViewUtils;

public class MaterialShapeUtils {
    private MaterialShapeUtils() {
        super();
    }

    static CornerTreatment createCornerTreatment(int arg1) {
        if(arg1 != 0) {
            if(arg1 != 1) {
                return MaterialShapeUtils.createDefaultCornerTreatment();
            }

            return new CutCornerTreatment();
        }

        return new RoundedCornerTreatment();
    }

    static CornerTreatment createDefaultCornerTreatment() {
        return new RoundedCornerTreatment();
    }

    static EdgeTreatment createDefaultEdgeTreatment() {
        return new EdgeTreatment();
    }

    public static void setElevation(View arg1, float arg2) {
        Drawable v1 = arg1.getBackground();
        if((v1 instanceof MaterialShapeDrawable)) {
            ((MaterialShapeDrawable)v1).setElevation(arg2);
        }
    }

    public static void setParentAbsoluteElevation(View arg2) {
        Drawable v0 = arg2.getBackground();
        if((v0 instanceof MaterialShapeDrawable)) {
            MaterialShapeUtils.setParentAbsoluteElevation(arg2, ((MaterialShapeDrawable)v0));
        }
    }

    public static void setParentAbsoluteElevation(View arg1, MaterialShapeDrawable arg2) {
        if(arg2.isElevationOverlayEnabled()) {
            arg2.setParentAbsoluteElevation(ViewUtils.getParentAbsoluteElevation(arg1));
        }
    }
}

