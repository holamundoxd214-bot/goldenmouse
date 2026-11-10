package com.google.android.material.bottomappbar;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float arg2, float arg3, float arg4) {
        super();
        this.fabCornerSize = -1f;
        this.fabMargin = arg2;
        this.roundedCornerRadius = arg3;
        this.setCradleVerticalOffset(arg4);
        this.horizontalOffset = 0f;
    }

    float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    public void getEdgePath(float arg22, float arg23, float arg24, ShapePath arg25) {
        float v16;
        BottomAppBarTopEdgeTreatment v0 = this;
        float v1 = arg22;
        ShapePath v2 = arg25;
        float v3 = v0.fabDiameter;
        if(v3 == 0f) {
            v2.lineTo(v1, 0f);
            return;
        }

        float v10 = 2f;
        float v11 = (v0.fabMargin * v10 + v3) / v10;
        float v12 = arg24 * v0.roundedCornerRadius;
        float v13 = arg23 + v0.horizontalOffset;
        float v4 = v0.cradleVerticalOffset * arg24 + (1f - arg24) * v11;
        if(v4 / v11 >= 1f) {
            v2.lineTo(v1, 0f);
            return;
        }

        float v5 = v0.fabCornerSize;
        float v14 = v5 * arg24;
        int v3_1 = v5 == -1f || Math.abs(v5 * v10 - v3) < 0.1f ? 1 : 0;
        int v15 = v3_1;
        if(v15 == 0) {
            v3 = 1.75f;
            v16 = 0f;
        }
        else {
            v16 = v4;
            v3 = 0f;
        }

        v4 = v11 + v12;
        v5 = v16 + v12;
        v4 = ((float)Math.sqrt(((double)(v4 * v4 - v5 * v5))));
        float v6 = v13 - v4;
        float v17 = v13 + v4;
        float v8 = ((float)Math.toDegrees(Math.atan(((double)(v4 / v5)))));
        float v18 = 90f - v8 + v3;
        v2.lineTo(v6, 0f);
        v3 = v6 - v12;
        v5 = v6 + v12;
        v6 = v12 * v10;
        v2.addArc(v3, 0f, v5, v6, 270f, v8);
        float v20 = v6;
        float v19 = v8;
        float v2_1 = 180f;
        if(v15 != 0) {
            arg25.addArc(v13 - v11, -v11 - v16, v13 + v11, v11 - v16, v2_1 - v18, v18 * v10 - v2_1);
        }
        else {
            float v15_1 = v14 * v10;
            v3 = v13 - v11;
            arg25.addArc(v3, -(v14 + v0.fabMargin), v0.fabMargin + v15_1 + v3, v0.fabMargin + v14, v2_1 - v18, (v18 * v10 - v2_1) / v10);
            v5 = v13 + v11;
            arg25.lineTo(v5 - (v0.fabMargin / v10 + v14), v0.fabMargin + v14);
            arg25.addArc(v5 - (v15_1 + v0.fabMargin), -(v14 + v0.fabMargin), v5, v0.fabMargin + v14, 90f, v18 - 90f);
        }

        arg25.addArc(v17 - v12, 0f, v17 + v12, v20, 270f - v19, v19);
        arg25.lineTo(v1, 0f);
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    float getFabCradleMargin() {
        return this.fabMargin;
    }

    float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    public float getFabDiameter() {
        return this.fabDiameter;
    }

    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    void setCradleVerticalOffset(float arg2) {
        if(arg2 >= 0f) {
            this.cradleVerticalOffset = arg2;
            return;
        }

        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void setFabCornerSize(float arg1) {
        this.fabCornerSize = arg1;
    }

    void setFabCradleMargin(float arg1) {
        this.fabMargin = arg1;
    }

    void setFabCradleRoundedCornerRadius(float arg1) {
        this.roundedCornerRadius = arg1;
    }

    public void setFabDiameter(float arg1) {
        this.fabDiameter = arg1;
    }

    void setHorizontalOffset(float arg1) {
        this.horizontalOffset = arg1;
    }
}

