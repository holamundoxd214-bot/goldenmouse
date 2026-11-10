package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R$styleable;

public class ShapeAppearanceModel {
    class com.google.android.material.shape.ShapeAppearanceModel$1 {
    }

    public final class Builder {
        private EdgeTreatment bottomEdge;
        private CornerTreatment bottomLeftCorner;
        private CornerSize bottomLeftCornerSize;
        private CornerTreatment bottomRightCorner;
        private CornerSize bottomRightCornerSize;
        private EdgeTreatment leftEdge;
        private EdgeTreatment rightEdge;
        private EdgeTreatment topEdge;
        private CornerTreatment topLeftCorner;
        private CornerSize topLeftCornerSize;
        private CornerTreatment topRightCorner;
        private CornerSize topRightCornerSize;

        public Builder() {
            super();
            this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0f);
            this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        }

        public Builder(ShapeAppearanceModel arg3) {
            super();
            this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0f);
            this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.topLeftCorner = arg3.topLeftCorner;
            this.topRightCorner = arg3.topRightCorner;
            this.bottomRightCorner = arg3.bottomRightCorner;
            this.bottomLeftCorner = arg3.bottomLeftCorner;
            this.topLeftCornerSize = arg3.topLeftCornerSize;
            this.topRightCornerSize = arg3.topRightCornerSize;
            this.bottomRightCornerSize = arg3.bottomRightCornerSize;
            this.bottomLeftCornerSize = arg3.bottomLeftCornerSize;
            this.topEdge = arg3.topEdge;
            this.rightEdge = arg3.rightEdge;
            this.bottomEdge = arg3.bottomEdge;
            this.leftEdge = arg3.leftEdge;
        }

        static CornerTreatment access$100(Builder arg0) {
            return arg0.topLeftCorner;
        }

        static EdgeTreatment access$1000(Builder arg0) {
            return arg0.rightEdge;
        }

        static EdgeTreatment access$1100(Builder arg0) {
            return arg0.bottomEdge;
        }

        static EdgeTreatment access$1200(Builder arg0) {
            return arg0.leftEdge;
        }

        static CornerTreatment access$200(Builder arg0) {
            return arg0.topRightCorner;
        }

        static CornerTreatment access$300(Builder arg0) {
            return arg0.bottomRightCorner;
        }

        static CornerTreatment access$400(Builder arg0) {
            return arg0.bottomLeftCorner;
        }

        static CornerSize access$500(Builder arg0) {
            return arg0.topLeftCornerSize;
        }

        static CornerSize access$600(Builder arg0) {
            return arg0.topRightCornerSize;
        }

        static CornerSize access$700(Builder arg0) {
            return arg0.bottomRightCornerSize;
        }

        static CornerSize access$800(Builder arg0) {
            return arg0.bottomLeftCornerSize;
        }

        static EdgeTreatment access$900(Builder arg0) {
            return arg0.topEdge;
        }

        public ShapeAppearanceModel build() {
            return new ShapeAppearanceModel(this, null);
        }

        private static float compatCornerTreatmentSize(CornerTreatment arg1) {
            if((arg1 instanceof RoundedCornerTreatment)) {
                return ((RoundedCornerTreatment)arg1).radius;
            }

            if((arg1 instanceof CutCornerTreatment)) {
                return ((CutCornerTreatment)arg1).size;
            }

            return -1f;
        }

        public Builder setAllCornerSizes(float arg1) {
            return this.setTopLeftCornerSize(arg1).setTopRightCornerSize(arg1).setBottomRightCornerSize(arg1).setBottomLeftCornerSize(arg1);
        }

        public Builder setAllCornerSizes(CornerSize arg1) {
            return this.setTopLeftCornerSize(arg1).setTopRightCornerSize(arg1).setBottomRightCornerSize(arg1).setBottomLeftCornerSize(arg1);
        }

        public Builder setAllCorners(int arg1, float arg2) {
            return this.setAllCorners(MaterialShapeUtils.createCornerTreatment(arg1)).setAllCornerSizes(arg2);
        }

        public Builder setAllCorners(CornerTreatment arg1) {
            return this.setTopLeftCorner(arg1).setTopRightCorner(arg1).setBottomRightCorner(arg1).setBottomLeftCorner(arg1);
        }

        public Builder setAllEdges(EdgeTreatment arg1) {
            return this.setLeftEdge(arg1).setTopEdge(arg1).setRightEdge(arg1).setBottomEdge(arg1);
        }

        public Builder setBottomEdge(EdgeTreatment arg1) {
            this.bottomEdge = arg1;
            return this;
        }

        public Builder setBottomLeftCorner(int arg1, CornerSize arg2) {
            return this.setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(arg1)).setBottomLeftCornerSize(arg2);
        }

        public Builder setBottomLeftCorner(CornerTreatment arg2) {
            this.bottomLeftCorner = arg2;
            float v2 = Builder.compatCornerTreatmentSize(arg2);
            if(v2 != -1f) {
                this.setBottomLeftCornerSize(v2);
            }

            return this;
        }

        public Builder setBottomLeftCorner(int arg1, float arg2) {
            return this.setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(arg1)).setBottomLeftCornerSize(arg2);
        }

        public Builder setBottomLeftCornerSize(CornerSize arg1) {
            this.bottomLeftCornerSize = arg1;
            return this;
        }

        public Builder setBottomLeftCornerSize(float arg2) {
            this.bottomLeftCornerSize = new AbsoluteCornerSize(arg2);
            return this;
        }

        public Builder setBottomRightCorner(int arg1, CornerSize arg2) {
            return this.setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(arg1)).setBottomRightCornerSize(arg2);
        }

        public Builder setBottomRightCorner(CornerTreatment arg2) {
            this.bottomRightCorner = arg2;
            float v2 = Builder.compatCornerTreatmentSize(arg2);
            if(v2 != -1f) {
                this.setBottomRightCornerSize(v2);
            }

            return this;
        }

        public Builder setBottomRightCorner(int arg1, float arg2) {
            return this.setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(arg1)).setBottomRightCornerSize(arg2);
        }

        public Builder setBottomRightCornerSize(CornerSize arg1) {
            this.bottomRightCornerSize = arg1;
            return this;
        }

        public Builder setBottomRightCornerSize(float arg2) {
            this.bottomRightCornerSize = new AbsoluteCornerSize(arg2);
            return this;
        }

        public Builder setLeftEdge(EdgeTreatment arg1) {
            this.leftEdge = arg1;
            return this;
        }

        public Builder setRightEdge(EdgeTreatment arg1) {
            this.rightEdge = arg1;
            return this;
        }

        public Builder setTopEdge(EdgeTreatment arg1) {
            this.topEdge = arg1;
            return this;
        }

        public Builder setTopLeftCorner(int arg1, CornerSize arg2) {
            return this.setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(arg1)).setTopLeftCornerSize(arg2);
        }

        public Builder setTopLeftCorner(CornerTreatment arg2) {
            this.topLeftCorner = arg2;
            float v2 = Builder.compatCornerTreatmentSize(arg2);
            if(v2 != -1f) {
                this.setTopLeftCornerSize(v2);
            }

            return this;
        }

        public Builder setTopLeftCorner(int arg1, float arg2) {
            return this.setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(arg1)).setTopLeftCornerSize(arg2);
        }

        public Builder setTopLeftCornerSize(CornerSize arg1) {
            this.topLeftCornerSize = arg1;
            return this;
        }

        public Builder setTopLeftCornerSize(float arg2) {
            this.topLeftCornerSize = new AbsoluteCornerSize(arg2);
            return this;
        }

        public Builder setTopRightCorner(int arg1, CornerSize arg2) {
            return this.setTopRightCorner(MaterialShapeUtils.createCornerTreatment(arg1)).setTopRightCornerSize(arg2);
        }

        public Builder setTopRightCorner(CornerTreatment arg2) {
            this.topRightCorner = arg2;
            float v2 = Builder.compatCornerTreatmentSize(arg2);
            if(v2 != -1f) {
                this.setTopRightCornerSize(v2);
            }

            return this;
        }

        public Builder setTopRightCorner(int arg1, float arg2) {
            return this.setTopRightCorner(MaterialShapeUtils.createCornerTreatment(arg1)).setTopRightCornerSize(arg2);
        }

        public Builder setTopRightCornerSize(CornerSize arg1) {
            this.topRightCornerSize = arg1;
            return this;
        }

        public Builder setTopRightCornerSize(float arg2) {
            this.topRightCornerSize = new AbsoluteCornerSize(arg2);
            return this;
        }
    }

    public interface CornerSizeUnaryOperator {
        CornerSize apply(CornerSize arg1);
    }

    public static final CornerSize PILL;
    EdgeTreatment bottomEdge;
    CornerTreatment bottomLeftCorner;
    CornerSize bottomLeftCornerSize;
    CornerTreatment bottomRightCorner;
    CornerSize bottomRightCornerSize;
    EdgeTreatment leftEdge;
    EdgeTreatment rightEdge;
    EdgeTreatment topEdge;
    CornerTreatment topLeftCorner;
    CornerSize topLeftCornerSize;
    CornerTreatment topRightCorner;
    CornerSize topRightCornerSize;

    static {
        ShapeAppearanceModel.PILL = new RelativeCornerSize(0.5f);
    }

    public ShapeAppearanceModel() {
        super();
        this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topLeftCornerSize = new AbsoluteCornerSize(0f);
        this.topRightCornerSize = new AbsoluteCornerSize(0f);
        this.bottomRightCornerSize = new AbsoluteCornerSize(0f);
        this.bottomLeftCornerSize = new AbsoluteCornerSize(0f);
        this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
    }

    private ShapeAppearanceModel(Builder arg2) {
        super();
        this.topLeftCorner = Builder.access$100(arg2);
        this.topRightCorner = Builder.access$200(arg2);
        this.bottomRightCorner = Builder.access$300(arg2);
        this.bottomLeftCorner = Builder.access$400(arg2);
        this.topLeftCornerSize = Builder.access$500(arg2);
        this.topRightCornerSize = Builder.access$600(arg2);
        this.bottomRightCornerSize = Builder.access$700(arg2);
        this.bottomLeftCornerSize = Builder.access$800(arg2);
        this.topEdge = Builder.access$900(arg2);
        this.rightEdge = Builder.access$1000(arg2);
        this.bottomEdge = Builder.access$1100(arg2);
        this.leftEdge = Builder.access$1200(arg2);
    }

    ShapeAppearanceModel(Builder arg1, com.google.android.material.shape.ShapeAppearanceModel$1 arg2) {
        this(arg1);
    }

    public static Builder builder(Context arg1, int arg2, int arg3) {
        return ShapeAppearanceModel.builder(arg1, arg2, arg3, 0);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        return ShapeAppearanceModel.builder(arg1, arg2, arg3, arg4, 0);
    }

    public static Builder builder(Context arg1, AttributeSet arg2, int arg3, int arg4, int arg5) {
        return ShapeAppearanceModel.builder(arg1, arg2, arg3, arg4, new AbsoluteCornerSize(((float)arg5)));
    }

    public static Builder builder(Context arg1, AttributeSet arg2, int arg3, int arg4, CornerSize arg5) {
        TypedArray v2 = arg1.obtainStyledAttributes(arg2, styleable.MaterialShape, arg3, arg4);
        arg3 = v2.getResourceId(styleable.MaterialShape_shapeAppearance, 0);
        arg4 = v2.getResourceId(styleable.MaterialShape_shapeAppearanceOverlay, 0);
        v2.recycle();
        return ShapeAppearanceModel.builder(arg1, arg3, arg4, arg5);
    }

    private static Builder builder(Context arg1, int arg2, int arg3, int arg4) {
        return ShapeAppearanceModel.builder(arg1, arg2, arg3, new AbsoluteCornerSize(((float)arg4)));
    }

    private static Builder builder(Context arg6, int arg7, int arg8, CornerSize arg9) {
        Builder v7_1;
        ContextThemeWrapper v0 = new ContextThemeWrapper(arg6, arg7);
        if(arg8 != 0) {
            v0 = new ContextThemeWrapper(((Context)v0), arg8);
        }

        TypedArray v6 = ((Context)v0).obtainStyledAttributes(styleable.ShapeAppearance);
        try {
            arg7 = v6.getInt(styleable.ShapeAppearance_cornerFamily, 0);
            arg8 = v6.getInt(styleable.ShapeAppearance_cornerFamilyTopLeft, arg7);
            int v0_1 = v6.getInt(styleable.ShapeAppearance_cornerFamilyTopRight, arg7);
            int v1 = v6.getInt(styleable.ShapeAppearance_cornerFamilyBottomRight, arg7);
            arg7 = v6.getInt(styleable.ShapeAppearance_cornerFamilyBottomLeft, arg7);
            arg9 = ShapeAppearanceModel.getCornerSize(v6, styleable.ShapeAppearance_cornerSize, arg9);
            v7_1 = new Builder().setTopLeftCorner(arg8, ShapeAppearanceModel.getCornerSize(v6, styleable.ShapeAppearance_cornerSizeTopLeft, arg9)).setTopRightCorner(v0_1, ShapeAppearanceModel.getCornerSize(v6, styleable.ShapeAppearance_cornerSizeTopRight, arg9)).setBottomRightCorner(v1, ShapeAppearanceModel.getCornerSize(v6, styleable.ShapeAppearance_cornerSizeBottomRight, arg9)).setBottomLeftCorner(arg7, ShapeAppearanceModel.getCornerSize(v6, styleable.ShapeAppearance_cornerSizeBottomLeft, arg9));
        }
        catch(Throwable v7) {
            v6.recycle();
            throw v7;
        }

        v6.recycle();
        return v7_1;
    }

    public EdgeTreatment getBottomEdge() {
        return this.bottomEdge;
    }

    public CornerTreatment getBottomLeftCorner() {
        return this.bottomLeftCorner;
    }

    public CornerSize getBottomLeftCornerSize() {
        return this.bottomLeftCornerSize;
    }

    public CornerTreatment getBottomRightCorner() {
        return this.bottomRightCorner;
    }

    public CornerSize getBottomRightCornerSize() {
        return this.bottomRightCornerSize;
    }

    private static CornerSize getCornerSize(TypedArray arg2, int arg3, CornerSize arg4) {
        TypedValue v3 = arg2.peekValue(arg3);
        if(v3 == null) {
        }
        else if(v3.type == 5) {
            return new AbsoluteCornerSize(((float)TypedValue.complexToDimensionPixelSize(v3.data, arg2.getResources().getDisplayMetrics())));
        }
        else if(v3.type == 6) {
            return new RelativeCornerSize(v3.getFraction(1f, 1f));
        }

        return arg4;
    }

    public EdgeTreatment getLeftEdge() {
        return this.leftEdge;
    }

    public EdgeTreatment getRightEdge() {
        return this.rightEdge;
    }

    public EdgeTreatment getTopEdge() {
        return this.topEdge;
    }

    public CornerTreatment getTopLeftCorner() {
        return this.topLeftCorner;
    }

    public CornerSize getTopLeftCornerSize() {
        return this.topLeftCornerSize;
    }

    public CornerTreatment getTopRightCorner() {
        return this.topRightCorner;
    }

    public CornerSize getTopRightCornerSize() {
        return this.topRightCornerSize;
    }

    public boolean isRoundRect(RectF arg6) {
        Class v0 = this.leftEdge.getClass();
        Class v1 = EdgeTreatment.class;
        int v0_1 = !v0.equals(v1) || !this.rightEdge.getClass().equals(v1) || !this.topEdge.getClass().equals(v1) || !this.bottomEdge.getClass().equals(v1) ? 0 : 1;
        float v1_1 = this.topLeftCornerSize.getCornerSize(arg6);
        int v6 = this.topRightCornerSize.getCornerSize(arg6) != v1_1 || this.bottomLeftCornerSize.getCornerSize(arg6) != v1_1 || this.bottomRightCornerSize.getCornerSize(arg6) != v1_1 ? 0 : 1;
        int v5 = !(this.topRightCorner instanceof RoundedCornerTreatment) || !(this.topLeftCorner instanceof RoundedCornerTreatment) || !(this.bottomRightCorner instanceof RoundedCornerTreatment) || !(this.bottomLeftCorner instanceof RoundedCornerTreatment) ? 0 : 1;
        if(v0_1 != 0 && v6 != 0 && v5 != 0) {
            return 1;
        }

        return 0;
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public ShapeAppearanceModel withCornerSize(float arg1) {
        return this.toBuilder().setAllCornerSizes(arg1).build();
    }

    public ShapeAppearanceModel withCornerSize(CornerSize arg1) {
        return this.toBuilder().setAllCornerSizes(arg1).build();
    }

    public ShapeAppearanceModel withTransformedCornerSizes(CornerSizeUnaryOperator arg3) {
        return this.toBuilder().setTopLeftCornerSize(arg3.apply(this.getTopLeftCornerSize())).setTopRightCornerSize(arg3.apply(this.getTopRightCornerSize())).setBottomLeftCornerSize(arg3.apply(this.getBottomLeftCornerSize())).setBottomRightCornerSize(arg3.apply(this.getBottomRightCornerSize())).build();
    }
}

