package com.google.android.material.shape;

@Deprecated public class ShapePathModel extends ShapeAppearanceModel {
    public ShapePathModel() {
        super();
    }

    @Deprecated public void setAllCorners(CornerTreatment arg1) {
        this.topLeftCorner = arg1;
        this.topRightCorner = arg1;
        this.bottomRightCorner = arg1;
        this.bottomLeftCorner = arg1;
    }

    @Deprecated public void setAllEdges(EdgeTreatment arg1) {
        this.leftEdge = arg1;
        this.topEdge = arg1;
        this.rightEdge = arg1;
        this.bottomEdge = arg1;
    }

    @Deprecated public void setBottomEdge(EdgeTreatment arg1) {
        this.bottomEdge = arg1;
    }

    @Deprecated public void setBottomLeftCorner(CornerTreatment arg1) {
        this.bottomLeftCorner = arg1;
    }

    @Deprecated public void setBottomRightCorner(CornerTreatment arg1) {
        this.bottomRightCorner = arg1;
    }

    @Deprecated public void setCornerTreatments(CornerTreatment arg1, CornerTreatment arg2, CornerTreatment arg3, CornerTreatment arg4) {
        this.topLeftCorner = arg1;
        this.topRightCorner = arg2;
        this.bottomRightCorner = arg3;
        this.bottomLeftCorner = arg4;
    }

    @Deprecated public void setEdgeTreatments(EdgeTreatment arg1, EdgeTreatment arg2, EdgeTreatment arg3, EdgeTreatment arg4) {
        this.leftEdge = arg1;
        this.topEdge = arg2;
        this.rightEdge = arg3;
        this.bottomEdge = arg4;
    }

    @Deprecated public void setLeftEdge(EdgeTreatment arg1) {
        this.leftEdge = arg1;
    }

    @Deprecated public void setRightEdge(EdgeTreatment arg1) {
        this.rightEdge = arg1;
    }

    @Deprecated public void setTopEdge(EdgeTreatment arg1) {
        this.topEdge = arg1;
    }

    @Deprecated public void setTopLeftCorner(CornerTreatment arg1) {
        this.topLeftCorner = arg1;
    }

    @Deprecated public void setTopRightCorner(CornerTreatment arg1) {
        this.topRightCorner = arg1;
    }
}

