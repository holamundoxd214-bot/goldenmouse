package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

class CutoutDrawable extends MaterialShapeDrawable {
    class com.google.android.material.textfield.CutoutDrawable$1 {
    }

    final class CutoutDrawableState extends MaterialShapeDrawableState {
        private final RectF cutoutBounds;

        CutoutDrawableState(ShapeAppearanceModel arg1, RectF arg2, com.google.android.material.textfield.CutoutDrawable$1 arg3) {
            this(arg1, arg2);
        }

        CutoutDrawableState(CutoutDrawableState arg1, com.google.android.material.textfield.CutoutDrawable$1 arg2) {
            this(arg1);
        }

        private CutoutDrawableState(ShapeAppearanceModel arg2, RectF arg3) {
            super(arg2, null);
            this.cutoutBounds = arg3;
        }

        private CutoutDrawableState(CutoutDrawableState arg1) {
            super(((MaterialShapeDrawableState)arg1));
            this.cutoutBounds = arg1.cutoutBounds;
        }

        static RectF access$200(CutoutDrawableState arg0) {
            return arg0.cutoutBounds;
        }

        public Drawable newDrawable() {
            CutoutDrawable v0 = CutoutDrawable.create(this);
            v0.invalidateSelf();
            return ((Drawable)v0);
        }
    }

    class ImplApi14 extends CutoutDrawable {
        private Paint cutoutPaint;
        private int savedLayer;

        ImplApi14(CutoutDrawableState arg2) {
            super(arg2, null);
        }

        public void draw(Canvas arg1) {
            this.preDraw(arg1);
            super.draw(arg1);
            this.postDraw(arg1);
        }

        protected void drawStrokeShape(Canvas arg2) {
            super.drawStrokeShape(arg2);
            arg2.drawRect(this.drawableState.cutoutBounds, this.getCutoutPaint());
        }

        private Paint getCutoutPaint() {
            if(this.cutoutPaint == null) {
                Paint v0 = new Paint(1);
                this.cutoutPaint = v0;
                v0.setStyle(Paint$Style.FILL_AND_STROKE);
                this.cutoutPaint.setColor(-1);
                this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff$Mode.DST_OUT));
            }

            return this.cutoutPaint;
        }

        private void postDraw(Canvas arg2) {
            if(!this.useHardwareLayer(this.getCallback())) {
                arg2.restoreToCount(this.savedLayer);
            }
        }

        private void preDraw(Canvas arg3) {
            Drawable$Callback v0 = this.getCallback();
            if(this.useHardwareLayer(v0)) {
                int v3 = 2;
                if(((View)v0).getLayerType() != v3) {
                    ((View)v0).setLayerType(v3, null);
                }

                return;
            }

            this.saveCanvasLayer(arg3);
        }

        private void saveCanvasLayer(Canvas arg8) {
            this.savedLayer = arg8.saveLayer(0f, 0f, ((float)arg8.getWidth()), ((float)arg8.getHeight()), null);
        }

        private boolean useHardwareLayer(Drawable$Callback arg1) {
            return arg1 instanceof View;
        }
    }

    class ImplApi18 extends CutoutDrawable {
        ImplApi18(CutoutDrawableState arg2) {
            super(arg2, null);
        }

        protected void drawStrokeShape(Canvas arg2) {
            if(this.drawableState.cutoutBounds.isEmpty()) {
                super.drawStrokeShape(arg2);
                return;
            }

            arg2.save();
            arg2.clipOutRect(this.drawableState.cutoutBounds);
            super.drawStrokeShape(arg2);
            arg2.restore();
        }
    }

    CutoutDrawableState drawableState;

    private CutoutDrawable(CutoutDrawableState arg1) {
        super(((MaterialShapeDrawableState)arg1));
        this.drawableState = arg1;
    }

    CutoutDrawable(CutoutDrawableState arg1, com.google.android.material.textfield.CutoutDrawable$1 arg2) {
        this(arg1);
    }

    static CutoutDrawable access$400(CutoutDrawableState arg0) {
        return CutoutDrawable.create(arg0);
    }

    private static CutoutDrawable create(CutoutDrawableState arg1) {
        return new ImplApi18(arg1);
    }

    static CutoutDrawable create(ShapeAppearanceModel arg3) {
        if(arg3 != null) {
        }
        else {
            arg3 = new ShapeAppearanceModel();
        }

        return CutoutDrawable.create(new CutoutDrawableState(arg3, new RectF(), null));
    }

    boolean hasCutout() {
        return CutoutDrawableState.access$200(this.drawableState).isEmpty() ^ 1;
    }

    public Drawable mutate() {
        this.drawableState = new CutoutDrawableState(this.drawableState, null);
        return this;
    }

    void removeCutout() {
        this.setCutout(0f, 0f, 0f, 0f);
    }

    void setCutout(float arg2, float arg3, float arg4, float arg5) {
        if(arg2 == CutoutDrawableState.access$200(this.drawableState).left && arg3 == CutoutDrawableState.access$200(this.drawableState).top && arg4 == CutoutDrawableState.access$200(this.drawableState).right) {
            if(arg5 != CutoutDrawableState.access$200(this.drawableState).bottom) {
            }
            else {
                return;
            }
        }

        CutoutDrawableState.access$200(this.drawableState).set(arg2, arg3, arg4, arg5);
        this.invalidateSelf();
    }

    void setCutout(RectF arg4) {
        this.setCutout(arg4.left, arg4.top, arg4.right, arg4.bottom);
    }
}

