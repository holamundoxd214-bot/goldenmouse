package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build$VERSION;
import android.view.View;
import com.google.android.material.canvas.CanvasCompat$CanvasOperation;

public abstract class ShapeableDelegate {
    boolean forceCompatClippingEnabled;
    RectF maskBounds;
    boolean offsetZeroCornerEdgeBoundsEnabled;
    ShapeAppearanceModel shapeAppearanceModel;
    final Path shapePath;

    public ShapeableDelegate() {
        super();
        this.forceCompatClippingEnabled = false;
        this.offsetZeroCornerEdgeBoundsEnabled = false;
        this.maskBounds = new RectF();
        this.shapePath = new Path();
    }

    public static ShapeableDelegate create(View arg2) {
        if(Build$VERSION.SDK_INT >= 33) {
            return new ShapeableDelegateV33(arg2);
        }

        return new ShapeableDelegateV22(arg2);
    }

    abstract void invalidateClippingMethod(View arg1);

    public boolean isForceCompatClippingEnabled() {
        return this.forceCompatClippingEnabled;
    }

    private boolean isMaskBoundsValid() {
        if(this.maskBounds.left <= this.maskBounds.right && this.maskBounds.top <= this.maskBounds.bottom) {
            return 1;
        }

        return 0;
    }

    public void maybeClip(Canvas arg2, CanvasOperation arg3) {
        if((this.shouldUseCompatClipping()) && !this.shapePath.isEmpty()) {
            arg2.save();
            arg2.clipPath(this.shapePath);
            arg3.run(arg2);
            arg2.restore();
            return;
        }

        arg3.run(arg2);
    }

    public void onMaskChanged(View arg1, RectF arg2) {
        this.maskBounds = arg2;
        this.updateShapePath();
        this.invalidateClippingMethod(arg1);
    }

    public void onShapeAppearanceChanged(View arg1, ShapeAppearanceModel arg2) {
        this.shapeAppearanceModel = arg2;
        this.updateShapePath();
        this.invalidateClippingMethod(arg1);
    }

    public void setForceCompatClippingEnabled(View arg2, boolean arg3) {
        if(arg3 != this.forceCompatClippingEnabled) {
            this.forceCompatClippingEnabled = arg3;
            this.invalidateClippingMethod(arg2);
        }
    }

    public void setOffsetZeroCornerEdgeBoundsEnabled(View arg1, boolean arg2) {
        this.offsetZeroCornerEdgeBoundsEnabled = arg2;
        this.invalidateClippingMethod(arg1);
    }

    abstract boolean shouldUseCompatClipping();

    private void updateShapePath() {
        if((this.isMaskBoundsValid()) && this.shapeAppearanceModel != null) {
            ShapeAppearancePathProvider.getInstance().calculatePath(this.shapeAppearanceModel, 1f, this.maskBounds, this.shapePath);
        }
    }
}

