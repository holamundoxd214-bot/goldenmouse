package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShapePath {
    class ArcShadowOperation extends ShadowCompatOperation {
        private final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation arg1) {
            super();
            this.operation = arg1;
        }

        public void draw(Matrix arg9, ShadowRenderer arg10, int arg11, Canvas arg12) {
            arg10.drawCornerShadow(arg12, arg9, new RectF(PathArcOperation.access$1000(this.operation), PathArcOperation.access$1100(this.operation), PathArcOperation.access$1200(this.operation), PathArcOperation.access$1300(this.operation)), arg11, PathArcOperation.access$800(this.operation), PathArcOperation.access$900(this.operation));
        }
    }

    class InnerCornerShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation1;
        private final PathLineOperation operation2;
        private final float startX;
        private final float startY;

        public InnerCornerShadowOperation(PathLineOperation arg1, PathLineOperation arg2, float arg3, float arg4) {
            super();
            this.operation1 = arg1;
            this.operation2 = arg2;
            this.startX = arg3;
            this.startY = arg4;
        }

        public void draw(Matrix arg18, ShadowRenderer arg19, int arg20, Canvas arg21) {
            int v11;
            InnerCornerShadowOperation v0 = this;
            Matrix v1 = arg18;
            ShadowRenderer v2 = arg19;
            int v10 = arg20;
            Canvas v3 = arg21;
            float v8 = v0.getSweepAngle();
            if(v8 > 0f) {
            }
            else {
                double v4 = Math.hypot(((double)(PathLineOperation.access$000(v0.operation1) - v0.startX)), ((double)(PathLineOperation.access$100(v0.operation1) - v0.startY)));
                double v12 = Math.hypot(((double)(PathLineOperation.access$000(v0.operation2) - PathLineOperation.access$000(v0.operation1))), ((double)(PathLineOperation.access$100(v0.operation2) - PathLineOperation.access$100(v0.operation1))));
                float v6 = ((float)Math.min(((double)v10), Math.min(v4, v12)));
                double v14 = ((double)v6);
                float v16 = 2f;
                double v9 = Math.tan(Math.toRadians(((double)(-v8 / 2f)))) * v14;
                if(v4 > v9) {
                    RectF v7 = new RectF(0f, 0f, ((float)(v4 - v9)), 0f);
                    v0.renderMatrix.set(v1);
                    v0.renderMatrix.preTranslate(v0.startX, v0.startY);
                    v0.renderMatrix.preRotate(v0.getStartAngle());
                    v11 = arg20;
                    v2.drawEdgeShadow(v3, v0.renderMatrix, v7, v11);
                }
                else {
                    v11 = arg20;
                }

                float v4_1 = v6 * v16;
                RectF v5 = new RectF(0f, 0f, v4_1, v4_1);
                v0.renderMatrix.set(v1);
                v0.renderMatrix.preTranslate(PathLineOperation.access$000(v0.operation1), PathLineOperation.access$100(v0.operation1));
                v0.renderMatrix.preRotate(v0.getStartAngle());
                float v7_1 = v4_1;
                v0.renderMatrix.preTranslate(((float)(-v9 - v14)), -2f * v6);
                Matrix v4_2 = v0.renderMatrix;
                float[] v3_1 = new float[]{((float)(v14 + v9)), v7_1};
                v2 = arg19;
                v14 = v9;
                float[] v9_1 = v3_1;
                v3 = arg21;
                v2.drawInnerCornerShadow(v3, v4_2, v5, ((int)v6), 450f, v8, v9_1);
                if(v12 <= v14) {
                    return;
                }

                RectF v4_3 = new RectF(0f, 0f, ((float)(v12 - v14)), 0f);
                v0.renderMatrix.set(v1);
                v0.renderMatrix.preTranslate(PathLineOperation.access$000(v0.operation1), PathLineOperation.access$100(v0.operation1));
                v0.renderMatrix.preRotate(v0.getEndAngle());
                v0.renderMatrix.preTranslate(((float)v14), 0f);
                v2.drawEdgeShadow(v3, v0.renderMatrix, v4_3, v11);
            }
        }

        float getEndAngle() {
            return ((float)Math.toDegrees(Math.atan(((double)((PathLineOperation.access$100(this.operation2) - PathLineOperation.access$100(this.operation1)) / (PathLineOperation.access$000(this.operation2) - PathLineOperation.access$000(this.operation1)))))));
        }

        float getStartAngle() {
            return ((float)Math.toDegrees(Math.atan(((double)((PathLineOperation.access$100(this.operation1) - this.startY) / (PathLineOperation.access$000(this.operation1) - this.startX))))));
        }

        float getSweepAngle() {
            float v0 = this.getEndAngle() - this.getStartAngle();
            float v2 = 360f;
            v0 = (v0 + v2) % v2;
            if(v0 <= 180f) {
                return v0;
            }

            return v0 - v2;
        }
    }

    class LineShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation;
        private final float startX;
        private final float startY;

        public LineShadowOperation(PathLineOperation arg1, float arg2, float arg3) {
            super();
            this.operation = arg1;
            this.startX = arg2;
            this.startY = arg3;
        }

        public void draw(Matrix arg6, ShadowRenderer arg7, int arg8, Canvas arg9) {
            RectF v2 = new RectF(0f, 0f, ((float)Math.hypot(((double)(PathLineOperation.access$100(this.operation) - this.startY)), ((double)(PathLineOperation.access$000(this.operation) - this.startX)))), 0f);
            this.renderMatrix.set(arg6);
            this.renderMatrix.preTranslate(this.startX, this.startY);
            this.renderMatrix.preRotate(this.getAngle());
            arg7.drawEdgeShadow(arg9, this.renderMatrix, v2, arg8);
        }

        float getAngle() {
            return ((float)Math.toDegrees(Math.atan(((double)((PathLineOperation.access$100(this.operation) - this.startY) / (PathLineOperation.access$000(this.operation) - this.startX))))));
        }
    }

    public class PathArcOperation extends PathOperation {
        @Deprecated public float bottom;
        @Deprecated public float left;
        private static final RectF rectF;
        @Deprecated public float right;
        @Deprecated public float startAngle;
        @Deprecated public float sweepAngle;
        @Deprecated public float top;

        static {
            PathArcOperation.rectF = new RectF();
        }

        public PathArcOperation(float arg1, float arg2, float arg3, float arg4) {
            super();
            this.setLeft(arg1);
            this.setTop(arg2);
            this.setRight(arg3);
            this.setBottom(arg4);
        }

        static float access$1000(PathArcOperation arg0) {
            return arg0.getLeft();
        }

        static float access$1100(PathArcOperation arg0) {
            return arg0.getTop();
        }

        static float access$1200(PathArcOperation arg0) {
            return arg0.getRight();
        }

        static float access$1300(PathArcOperation arg0) {
            return arg0.getBottom();
        }

        static void access$600(PathArcOperation arg0, float arg1) {
            arg0.setStartAngle(arg1);
        }

        static void access$700(PathArcOperation arg0, float arg1) {
            arg0.setSweepAngle(arg1);
        }

        static float access$800(PathArcOperation arg0) {
            return arg0.getStartAngle();
        }

        static float access$900(PathArcOperation arg0) {
            return arg0.getSweepAngle();
        }

        public void applyToPath(Matrix arg6, Path arg7) {
            Matrix v0 = this.matrix;
            arg6.invert(v0);
            arg7.transform(v0);
            RectF v0_1 = PathArcOperation.rectF;
            v0_1.set(this.getLeft(), this.getTop(), this.getRight(), this.getBottom());
            arg7.arcTo(v0_1, this.getStartAngle(), this.getSweepAngle(), false);
            arg7.transform(arg6);
        }

        private float getBottom() {
            return this.bottom;
        }

        private float getLeft() {
            return this.left;
        }

        private float getRight() {
            return this.right;
        }

        private float getStartAngle() {
            return this.startAngle;
        }

        private float getSweepAngle() {
            return this.sweepAngle;
        }

        private float getTop() {
            return this.top;
        }

        private void setBottom(float arg1) {
            this.bottom = arg1;
        }

        private void setLeft(float arg1) {
            this.left = arg1;
        }

        private void setRight(float arg1) {
            this.right = arg1;
        }

        private void setStartAngle(float arg1) {
            this.startAngle = arg1;
        }

        private void setSweepAngle(float arg1) {
            this.sweepAngle = arg1;
        }

        private void setTop(float arg1) {
            this.top = arg1;
        }
    }

    public class PathCubicOperation extends PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        public PathCubicOperation(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6) {
            super();
            this.setControlX1(arg1);
            this.setControlY1(arg2);
            this.setControlX2(arg3);
            this.setControlY2(arg4);
            this.setEndX(arg5);
            this.setEndY(arg6);
        }

        public void applyToPath(Matrix arg9, Path arg10) {
            Matrix v0 = this.matrix;
            arg9.invert(v0);
            arg10.transform(v0);
            arg10.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            arg10.transform(arg9);
        }

        private float getControlX1() {
            return this.controlX1;
        }

        private float getControlX2() {
            return this.controlX2;
        }

        private float getControlY1() {
            return this.controlY1;
        }

        private float getControlY2() {
            return this.controlY1;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX1(float arg1) {
            this.controlX1 = arg1;
        }

        private void setControlX2(float arg1) {
            this.controlX2 = arg1;
        }

        private void setControlY1(float arg1) {
            this.controlY1 = arg1;
        }

        private void setControlY2(float arg1) {
            this.controlY2 = arg1;
        }

        private void setEndX(float arg1) {
            this.endX = arg1;
        }

        private void setEndY(float arg1) {
            this.endY = arg1;
        }
    }

    public class PathLineOperation extends PathOperation {
        private float x;
        private float y;

        public PathLineOperation() {
            super();
        }

        static float access$000(PathLineOperation arg0) {
            return arg0.x;
        }

        static float access$002(PathLineOperation arg0, float arg1) {
            arg0.x = arg1;
            return arg1;
        }

        static float access$100(PathLineOperation arg0) {
            return arg0.y;
        }

        static float access$102(PathLineOperation arg0, float arg1) {
            arg0.y = arg1;
            return arg1;
        }

        public void applyToPath(Matrix arg2, Path arg3) {
            Matrix v0 = this.matrix;
            arg2.invert(v0);
            arg3.transform(v0);
            arg3.lineTo(this.x, this.y);
            arg3.transform(arg2);
        }
    }

    public abstract class PathOperation {
        protected final Matrix matrix;

        public PathOperation() {
            super();
            this.matrix = new Matrix();
        }

        public abstract void applyToPath(Matrix arg1, Path arg2);
    }

    public class PathQuadOperation extends PathOperation {
        @Deprecated public float controlX;
        @Deprecated public float controlY;
        @Deprecated public float endX;
        @Deprecated public float endY;

        public PathQuadOperation() {
            super();
        }

        static void access$200(PathQuadOperation arg0, float arg1) {
            arg0.setControlX(arg1);
        }

        static void access$300(PathQuadOperation arg0, float arg1) {
            arg0.setControlY(arg1);
        }

        static void access$400(PathQuadOperation arg0, float arg1) {
            arg0.setEndX(arg1);
        }

        static void access$500(PathQuadOperation arg0, float arg1) {
            arg0.setEndY(arg1);
        }

        public void applyToPath(Matrix arg4, Path arg5) {
            Matrix v0 = this.matrix;
            arg4.invert(v0);
            arg5.transform(v0);
            arg5.quadTo(this.getControlX(), this.getControlY(), this.getEndX(), this.getEndY());
            arg5.transform(arg4);
        }

        private float getControlX() {
            return this.controlX;
        }

        private float getControlY() {
            return this.controlY;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX(float arg1) {
            this.controlX = arg1;
        }

        private void setControlY(float arg1) {
            this.controlY = arg1;
        }

        private void setEndX(float arg1) {
            this.endX = arg1;
        }

        private void setEndY(float arg1) {
            this.endY = arg1;
        }
    }

    abstract class ShadowCompatOperation {
        static final Matrix IDENTITY_MATRIX;
        final Matrix renderMatrix;

        static {
            ShadowCompatOperation.IDENTITY_MATRIX = new Matrix();
        }

        ShadowCompatOperation() {
            super();
            this.renderMatrix = new Matrix();
        }

        public final void draw(ShadowRenderer arg2, int arg3, Canvas arg4) {
            this.draw(ShadowCompatOperation.IDENTITY_MATRIX, arg2, arg3, arg4);
        }

        public abstract void draw(Matrix arg1, ShadowRenderer arg2, int arg3, Canvas arg4);
    }

    protected static final float ANGLE_LEFT = 180f;
    private static final float ANGLE_UP = 270f;
    private boolean containsIncompatibleShadowOp;
    @Deprecated public float currentShadowAngle;
    @Deprecated public float endShadowAngle;
    @Deprecated public float endX;
    @Deprecated public float endY;
    private final List operations;
    private final List shadowCompatOperations;
    @Deprecated public float startX;
    @Deprecated public float startY;

    public ShapePath() {
        super();
        this.operations = new ArrayList();
        this.shadowCompatOperations = new ArrayList();
        this.reset(0f, 0f);
    }

    public ShapePath(float arg2, float arg3) {
        super();
        this.operations = new ArrayList();
        this.shadowCompatOperations = new ArrayList();
        this.reset(arg2, arg3);
    }

    public void addArc(float arg5, float arg6, float arg7, float arg8, float arg9, float arg10) {
        PathArcOperation v0 = new PathArcOperation(arg5, arg6, arg7, arg8);
        PathArcOperation.access$600(v0, arg9);
        PathArcOperation.access$700(v0, arg10);
        this.operations.add(v0);
        ArcShadowOperation v1 = new ArcShadowOperation(v0);
        float v0_1 = arg9 + arg10;
        int v10 = arg10 < 0f ? 1 : 0;
        float v2 = 360f;
        float v3 = 180f;
        if(v10 != 0) {
            arg9 = (arg9 + v3) % v2;
        }

        v3 = v10 != 0 ? (v3 + v0_1) % v2 : v0_1;
        this.addShadowCompatOperation(((ShadowCompatOperation)v1), arg9, v3);
        double v0_2 = ((double)v0_1);
        this.setEndX((arg5 + arg7) * 0.5f + (arg7 - arg5) / 2f * (((float)Math.cos(Math.toRadians(v0_2)))));
        this.setEndY((arg6 + arg8) * 0.5f + (arg8 - arg6) / 2f * (((float)Math.sin(Math.toRadians(v0_2)))));
    }

    private void addConnectingShadowIfNecessary(float arg7) {
        float v0;
        if(this.getCurrentShadowAngle() == arg7) {
        }
        else {
            v0 = (arg7 - this.getCurrentShadowAngle() + 360f) % 360f;
            if(v0 > 180f) {
                return;
            }

            goto label_11;
        }

        return;
    label_11:
        PathArcOperation v1 = new PathArcOperation(this.getEndX(), this.getEndY(), this.getEndX(), this.getEndY());
        PathArcOperation.access$600(v1, this.getCurrentShadowAngle());
        PathArcOperation.access$700(v1, v0);
        this.shadowCompatOperations.add(new ArcShadowOperation(v1));
        this.setCurrentShadowAngle(arg7);
    }

    private void addShadowCompatOperation(ShadowCompatOperation arg1, float arg2, float arg3) {
        this.addConnectingShadowIfNecessary(arg2);
        this.shadowCompatOperations.add(arg1);
        this.setCurrentShadowAngle(arg3);
    }

    public void applyToPath(Matrix arg4, Path arg5) {
        int v0 = this.operations.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.operations.get(v1).applyToPath(arg4, arg5);
        }
    }

    boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    ShadowCompatOperation createShadowCompatOperation(Matrix arg3) {
        this.addConnectingShadowIfNecessary(this.getEndShadowAngle());
        return new ShadowCompatOperation(new ArrayList(this.shadowCompatOperations), new Matrix(arg3)) {
            public void draw(Matrix arg3, ShadowRenderer arg4, int arg5, Canvas arg6) {
                Iterator v3 = this.val$operations.iterator();
                while(v3.hasNext()) {
                    v3.next().draw(this.val$transformCopy, arg4, arg5, arg6);
                }
            }
        };
    }

    public void cubicToPoint(float arg8, float arg9, float arg10, float arg11, float arg12, float arg13) {
        this.operations.add(new PathCubicOperation(arg8, arg9, arg10, arg11, arg12, arg13));
        this.containsIncompatibleShadowOp = true;
        this.setEndX(arg12);
        this.setEndY(arg13);
    }

    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    float getEndX() {
        return this.endX;
    }

    float getEndY() {
        return this.endY;
    }

    float getStartX() {
        return this.startX;
    }

    float getStartY() {
        return this.startY;
    }

    public void lineTo(float arg5, float arg6) {
        PathLineOperation v0 = new PathLineOperation();
        PathLineOperation.access$002(v0, arg5);
        PathLineOperation.access$102(v0, arg6);
        this.operations.add(v0);
        LineShadowOperation v1 = new LineShadowOperation(v0, this.getEndX(), this.getEndY());
        this.addShadowCompatOperation(((ShadowCompatOperation)v1), v1.getAngle() + 270f, v1.getAngle() + 270f);
        this.setEndX(arg5);
        this.setEndY(arg6);
    }

    public void lineTo(float arg6, float arg7, float arg8, float arg9) {
        float v1 = 0.001f;
        if(Math.abs(arg6 - this.getEndX()) < v1 && Math.abs(arg7 - this.getEndY()) < v1 || Math.abs(arg6 - arg8) < v1 && Math.abs(arg7 - arg9) < v1) {
            this.lineTo(arg8, arg9);
            return;
        }

        PathLineOperation v0 = new PathLineOperation();
        PathLineOperation.access$002(v0, arg6);
        PathLineOperation.access$102(v0, arg7);
        this.operations.add(v0);
        PathLineOperation v1_1 = new PathLineOperation();
        PathLineOperation.access$002(v1_1, arg8);
        PathLineOperation.access$102(v1_1, arg9);
        this.operations.add(v1_1);
        InnerCornerShadowOperation v2 = new InnerCornerShadowOperation(v0, v1_1, this.getEndX(), this.getEndY());
        if(v2.getSweepAngle() > 0f) {
            this.lineTo(arg6, arg7);
            this.lineTo(arg8, arg9);
            return;
        }

        this.addShadowCompatOperation(((ShadowCompatOperation)v2), v2.getStartAngle() + 270f, v2.getEndAngle() + 270f);
        this.setEndX(arg8);
        this.setEndY(arg9);
    }

    public void quadToPoint(float arg2, float arg3, float arg4, float arg5) {
        PathQuadOperation v0 = new PathQuadOperation();
        PathQuadOperation.access$200(v0, arg2);
        PathQuadOperation.access$300(v0, arg3);
        PathQuadOperation.access$400(v0, arg4);
        PathQuadOperation.access$500(v0, arg5);
        this.operations.add(v0);
        this.containsIncompatibleShadowOp = true;
        this.setEndX(arg4);
        this.setEndY(arg5);
    }

    public void reset(float arg1, float arg2, float arg3, float arg4) {
        this.setStartX(arg1);
        this.setStartY(arg2);
        this.setEndX(arg1);
        this.setEndY(arg2);
        this.setCurrentShadowAngle(arg3);
        this.setEndShadowAngle((arg3 + arg4) % 360f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }

    public void reset(float arg3, float arg4) {
        this.reset(arg3, arg4, 270f, 0f);
    }

    private void setCurrentShadowAngle(float arg1) {
        this.currentShadowAngle = arg1;
    }

    private void setEndShadowAngle(float arg1) {
        this.endShadowAngle = arg1;
    }

    private void setEndX(float arg1) {
        this.endX = arg1;
    }

    private void setEndY(float arg1) {
        this.endY = arg1;
    }

    private void setStartX(float arg1) {
        this.startX = arg1;
    }

    private void setStartY(float arg1) {
        this.startY = arg1;
    }
}

