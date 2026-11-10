package com.google.android.material.carousel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.ClampedCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.shape.ShapeableDelegate;

public class MaskableFrameLayout extends FrameLayout implements Maskable, Shapeable {
    private static final int NOT_SET = -1;
    private final RectF maskRect;
    private float maskXPercentage;
    private OnMaskChangedListener onMaskChangedListener;
    private Boolean savedForceCompatClippingEnabled;
    private ShapeAppearanceModel shapeAppearanceModel;
    private final ShapeableDelegate shapeableDelegate;

    public MaskableFrameLayout(Context arg2) {
        this(arg2, null);
    }

    public MaskableFrameLayout(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public MaskableFrameLayout(Context arg2, AttributeSet arg3, int arg4) {
        super(arg2, arg3, arg4);
        this.maskXPercentage = -1f;
        this.maskRect = new RectF();
        this.shapeableDelegate = ShapeableDelegate.create(((View)this));
        this.savedForceCompatClippingEnabled = null;
        this.setShapeAppearanceModel(ShapeAppearanceModel.builder(arg2, arg3, arg4, 0, 0).build());
    }

    protected void dispatchDraw(Canvas arg3) {
        this.shapeableDelegate.maybeClip(arg3, new MaskableFrameLayout$$ExternalSyntheticLambda1(this));
    }

    public void getFocusedRect(Rect arg4) {
        arg4.set(((int)this.maskRect.left), ((int)this.maskRect.top), ((int)this.maskRect.right), ((int)this.maskRect.bottom));
    }

    public RectF getMaskRectF() {
        return this.maskRect;
    }

    @Deprecated public float getMaskXPercentage() {
        return this.maskXPercentage;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    void lambda$dispatchDraw$1$com-google-android-material-carousel-MaskableFrameLayout(Canvas arg1) {
        super.dispatchDraw(arg1);
    }

    static CornerSize lambda$setShapeAppearanceModel$0(CornerSize arg1) {
        ClampedCornerSize v1;
        if((arg1 instanceof AbsoluteCornerSize)) {
            v1 = ClampedCornerSize.createFromCornerSize(((AbsoluteCornerSize)arg1));
        }

        return ((CornerSize)v1);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean v0 = this.savedForceCompatClippingEnabled;
        if(v0 != null) {
            this.shapeableDelegate.setForceCompatClippingEnabled(((View)this), v0.booleanValue());
        }
    }

    protected void onDetachedFromWindow() {
        this.savedForceCompatClippingEnabled = Boolean.valueOf(this.shapeableDelegate.isForceCompatClippingEnabled());
        this.shapeableDelegate.setForceCompatClippingEnabled(((View)this), true);
        super.onDetachedFromWindow();
    }

    private void onMaskChanged() {
        this.shapeableDelegate.onMaskChanged(((View)this), this.maskRect);
        OnMaskChangedListener v0 = this.onMaskChangedListener;
        if(v0 != null) {
            v0.onMaskChanged(this.maskRect);
        }
    }

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        super.onSizeChanged(arg1, arg2, arg3, arg4);
        if(this.maskXPercentage != -1f) {
            this.updateMaskRectForMaskXPercentage();
        }
    }

    public boolean onTouchEvent(MotionEvent arg4) {
        if(!this.maskRect.isEmpty() && arg4.getAction() == 0 && !this.maskRect.contains(arg4.getX(), arg4.getY())) {
            return 0;
        }

        return super.onTouchEvent(arg4);
    }

    public void setForceCompatClipping(boolean arg2) {
        this.shapeableDelegate.setForceCompatClippingEnabled(((View)this), arg2);
    }

    public void setMaskRectF(RectF arg2) {
        this.maskRect.set(arg2);
        this.onMaskChanged();
    }

    @Deprecated public void setMaskXPercentage(float arg3) {
        arg3 = MathUtils.clamp(arg3, 0f, 1f);
        if(this.maskXPercentage != arg3) {
            this.maskXPercentage = arg3;
            this.updateMaskRectForMaskXPercentage();
        }
    }

    public void setOnMaskChangedListener(OnMaskChangedListener arg1) {
        this.onMaskChangedListener = arg1;
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel arg2) {
        arg2 = arg2.withTransformedCornerSizes(new MaskableFrameLayout$$ExternalSyntheticLambda0());
        this.shapeAppearanceModel = arg2;
        this.shapeableDelegate.onShapeAppearanceChanged(((View)this), arg2);
    }

    private void updateMaskRectForMaskXPercentage() {
        if(this.maskXPercentage != -1f) {
            float v0 = AnimationUtils.lerp(0f, (((float)this.getWidth())) / 2f, 0f, 1f, this.maskXPercentage);
            this.setMaskRectF(new RectF(v0, 0f, (((float)this.getWidth())) - v0, ((float)this.getHeight())));
        }
    }
}

