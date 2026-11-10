package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path$Direction;
import android.graphics.Path$Op;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

public class ShapeAppearancePathProvider {
    class Lazy {
        static final ShapeAppearancePathProvider INSTANCE;

        static {
            Lazy.INSTANCE = new ShapeAppearancePathProvider();
        }

        private Lazy() {
            super();
        }
    }

    public interface PathListener {
        void onCornerPathCreated(ShapePath arg1, Matrix arg2, int arg3);

        void onEdgePathCreated(ShapePath arg1, Matrix arg2, int arg3);
    }

    final class ShapeAppearancePathSpec {
        public final RectF bounds;
        public final float interpolation;
        public final Path path;
        public final PathListener pathListener;
        public final ShapeAppearanceModel shapeAppearanceModel;

        ShapeAppearancePathSpec(ShapeAppearanceModel arg1, float arg2, RectF arg3, PathListener arg4, Path arg5) {
            super();
            this.pathListener = arg4;
            this.shapeAppearanceModel = arg1;
            this.interpolation = arg2;
            this.bounds = arg3;
            this.path = arg5;
        }
    }

    private final Path boundsPath;
    private final Path cornerPath;
    private final ShapePath[] cornerPaths;
    private final Matrix[] cornerTransforms;
    private boolean edgeIntersectionCheckEnabled;
    private final Path edgePath;
    private final Matrix[] edgeTransforms;
    private final Path overlappedEdgePath;
    private final PointF pointF;
    private final float[] scratch;
    private final float[] scratch2;
    private final ShapePath shapePath;

    public ShapeAppearancePathProvider() {
        super();
        int v0 = 4;
        this.cornerPaths = new ShapePath[v0];
        this.cornerTransforms = new Matrix[v0];
        this.edgeTransforms = new Matrix[v0];
        this.pointF = new PointF();
        this.overlappedEdgePath = new Path();
        this.boundsPath = new Path();
        this.shapePath = new ShapePath();
        this.scratch = new float[2];
        this.scratch2 = new float[2];
        this.edgePath = new Path();
        this.cornerPath = new Path();
        this.edgeIntersectionCheckEnabled = true;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.cornerPaths[v1] = new ShapePath();
            this.cornerTransforms[v1] = new Matrix();
            this.edgeTransforms[v1] = new Matrix();
        }
    }

    private float angleOfEdge(int arg1) {
        return ((float)((arg1 + 1) % 4 * 90));
    }

    private void appendCornerPath(ShapeAppearancePathSpec arg5, int arg6) {
        this.scratch[0] = this.cornerPaths[arg6].getStartX();
        this.scratch[1] = this.cornerPaths[arg6].getStartY();
        this.cornerTransforms[arg6].mapPoints(this.scratch);
        if(arg6 == 0) {
            arg5.path.moveTo(this.scratch[0], this.scratch[1]);
        }
        else {
            arg5.path.lineTo(this.scratch[0], this.scratch[1]);
        }

        this.cornerPaths[arg6].applyToPath(this.cornerTransforms[arg6], arg5.path);
        if(arg5.pathListener != null) {
            arg5.pathListener.onCornerPathCreated(this.cornerPaths[arg6], this.cornerTransforms[arg6], arg6);
        }
    }

    private void appendEdgePath(ShapeAppearancePathSpec arg9, int arg10) {
        int v0 = (arg10 + 1) % 4;
        this.scratch[0] = this.cornerPaths[arg10].getEndX();
        this.scratch[1] = this.cornerPaths[arg10].getEndY();
        this.cornerTransforms[arg10].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[v0].getStartX();
        this.scratch2[1] = this.cornerPaths[v0].getStartY();
        this.cornerTransforms[v0].mapPoints(this.scratch2);
        float v1 = Math.max((((float)Math.hypot(((double)(this.scratch[0] - this.scratch2[0])), ((double)(this.scratch[1] - this.scratch2[1]))))) - 0.001f, 0f);
        float v5 = this.getEdgeCenterForIndex(arg9.bounds, arg10);
        this.shapePath.reset(0f, 0f);
        EdgeTreatment v2 = this.getEdgeTreatmentForIndex(arg10, arg9.shapeAppearanceModel);
        v2.getEdgePath(v1, v5, arg9.interpolation, this.shapePath);
        this.edgePath.reset();
        this.shapePath.applyToPath(this.edgeTransforms[arg10], this.edgePath);
        if(this.edgeIntersectionCheckEnabled) {
            if(!v2.forceIntersection() && !this.pathOverlapsCorner(this.edgePath, arg10) && !this.pathOverlapsCorner(this.edgePath, v0)) {
                goto label_101;
            }

            this.edgePath.op(this.edgePath, this.boundsPath, Path$Op.DIFFERENCE);
            this.scratch[0] = this.shapePath.getStartX();
            this.scratch[1] = this.shapePath.getStartY();
            this.edgeTransforms[arg10].mapPoints(this.scratch);
            this.overlappedEdgePath.moveTo(this.scratch[0], this.scratch[1]);
            this.shapePath.applyToPath(this.edgeTransforms[arg10], this.overlappedEdgePath);
        }
        else {
        label_101:
            this.shapePath.applyToPath(this.edgeTransforms[arg10], arg9.path);
        }

        if(arg9.pathListener != null) {
            arg9.pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[arg10], arg10);
        }
    }

    public void calculatePath(ShapeAppearanceModel arg7, float arg8, RectF arg9, Path arg10) {
        this.calculatePath(arg7, arg8, arg9, null, arg10);
    }

    public void calculatePath(ShapeAppearanceModel arg9, float arg10, RectF arg11, PathListener arg12, Path arg13) {
        arg13.rewind();
        this.overlappedEdgePath.rewind();
        this.boundsPath.rewind();
        this.boundsPath.addRect(arg11, Path$Direction.CW);
        Path v7 = arg13;
        ShapeAppearancePathSpec v2 = new ShapeAppearancePathSpec(arg9, arg10, arg11, arg12, v7);
        int v9 = 0;
        int v10 = 0;
        while(true) {
            int v11 = 4;
            if(v10 < v11) {
                this.setCornerPathAndTransform(v2, v10);
                this.setEdgePathAndTransform(v10);
                ++v10;
                continue;
            }

            break;
        }

        while(v9 < v11) {
            this.appendCornerPath(v2, v9);
            this.appendEdgePath(v2, v9);
            ++v9;
        }

        v7.close();
        this.overlappedEdgePath.close();
        if(!this.overlappedEdgePath.isEmpty()) {
            v7.op(this.overlappedEdgePath, Path$Op.UNION);
        }
    }

    private void getCoordinatesOfCorner(int arg1, RectF arg2, PointF arg3) {
        if(arg1 != 1) {
            if(arg1 != 2) {
                if(arg1 != 3) {
                    arg3.set(arg2.right, arg2.top);
                    return;
                }

                arg3.set(arg2.left, arg2.top);
                return;
            }

            arg3.set(arg2.left, arg2.bottom);
            return;
        }

        arg3.set(arg2.right, arg2.bottom);
    }

    private CornerSize getCornerSizeForIndex(int arg1, ShapeAppearanceModel arg2) {
        if(arg1 != 1) {
            if(arg1 != 2) {
                if(arg1 != 3) {
                    return arg2.getTopRightCornerSize();
                }

                return arg2.getTopLeftCornerSize();
            }

            return arg2.getBottomLeftCornerSize();
        }

        return arg2.getBottomRightCornerSize();
    }

    private CornerTreatment getCornerTreatmentForIndex(int arg1, ShapeAppearanceModel arg2) {
        if(arg1 != 1) {
            if(arg1 != 2) {
                if(arg1 != 3) {
                    return arg2.getTopRightCorner();
                }

                return arg2.getTopLeftCorner();
            }

            return arg2.getBottomLeftCorner();
        }

        return arg2.getBottomRightCorner();
    }

    private float getEdgeCenterForIndex(RectF arg5, int arg6) {
        this.scratch[0] = this.cornerPaths[arg6].endX;
        this.scratch[1] = this.cornerPaths[arg6].endY;
        this.cornerTransforms[arg6].mapPoints(this.scratch);
        if(arg6 != 1 && arg6 != 3) {
            return Math.abs(arg5.centerY() - this.scratch[1]);
        }

        return Math.abs(arg5.centerX() - this.scratch[0]);
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int arg1, ShapeAppearanceModel arg2) {
        if(arg1 != 1) {
            if(arg1 != 2) {
                if(arg1 != 3) {
                    return arg2.getRightEdge();
                }

                return arg2.getTopEdge();
            }

            return arg2.getLeftEdge();
        }

        return arg2.getBottomEdge();
    }

    public static ShapeAppearancePathProvider getInstance() {
        return Lazy.INSTANCE;
    }

    private boolean pathOverlapsCorner(Path arg3, int arg4) {
        this.cornerPath.reset();
        this.cornerPaths[arg4].applyToPath(this.cornerTransforms[arg4], this.cornerPath);
        RectF v4 = new RectF();
        arg3.computeBounds(v4, true);
        this.cornerPath.computeBounds(v4, true);
        arg3.op(this.cornerPath, Path$Op.INTERSECT);
        arg3.computeBounds(v4, true);
        if(v4.isEmpty()) {
            float v3 = 1f;
            if(v4.width() > v3 && v4.height() > v3) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    private void setCornerPathAndTransform(ShapeAppearancePathSpec arg8, int arg9) {
        this.getCornerTreatmentForIndex(arg9, arg8.shapeAppearanceModel).getCornerPath(this.cornerPaths[arg9], 90f, arg8.interpolation, arg8.bounds, this.getCornerSizeForIndex(arg9, arg8.shapeAppearanceModel));
        float v0 = this.angleOfEdge(arg9);
        this.cornerTransforms[arg9].reset();
        this.getCoordinatesOfCorner(arg9, arg8.bounds, this.pointF);
        this.cornerTransforms[arg9].setTranslate(this.pointF.x, this.pointF.y);
        this.cornerTransforms[arg9].preRotate(v0);
    }

    void setEdgeIntersectionCheckEnable(boolean arg1) {
        this.edgeIntersectionCheckEnabled = arg1;
    }

    private void setEdgePathAndTransform(int arg6) {
        this.scratch[0] = this.cornerPaths[arg6].getEndX();
        this.scratch[1] = this.cornerPaths[arg6].getEndY();
        this.cornerTransforms[arg6].mapPoints(this.scratch);
        float v0 = this.angleOfEdge(arg6);
        this.edgeTransforms[arg6].reset();
        this.edgeTransforms[arg6].setTranslate(this.scratch[0], this.scratch[1]);
        this.edgeTransforms[arg6].preRotate(v0);
    }
}

