package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path$Op;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

class MaskEvaluator {
    private ShapeAppearanceModel currentShapeAppearanceModel;
    private final Path endPath;
    private final Path path;
    private final ShapeAppearancePathProvider pathProvider;
    private final Path startPath;

    MaskEvaluator() {
        super();
        this.path = new Path();
        this.startPath = new Path();
        this.endPath = new Path();
        this.pathProvider = ShapeAppearancePathProvider.getInstance();
    }

    void clip(Canvas arg1) {
        arg1.clipPath(this.path);
    }

    void evaluate(float arg8, ShapeAppearanceModel arg9, ShapeAppearanceModel arg10, RectF arg11, RectF arg12, RectF arg13, ProgressThresholds arg14) {
        ShapeAppearanceModel v8 = TransitionUtils.lerp(arg9, arg10, arg11, arg13, arg14.getStart(), arg14.getEnd(), arg8);
        this.currentShapeAppearanceModel = v8;
        this.pathProvider.calculatePath(v8, 1f, arg12, this.startPath);
        this.pathProvider.calculatePath(this.currentShapeAppearanceModel, 1f, arg13, this.endPath);
        this.path.op(this.startPath, this.endPath, Path$Op.UNION);
    }

    ShapeAppearanceModel getCurrentShapeAppearanceModel() {
        return this.currentShapeAppearanceModel;
    }

    Path getPath() {
        return this.path;
    }
}

