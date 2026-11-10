package com.google.android.material.shape;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

class ShapeableDelegateV22 extends ShapeableDelegate {
    private boolean canUseViewOutline;
    private float cornerRadius;

    ShapeableDelegateV22(View arg2) {
        super();
        this.canUseViewOutline = false;
        this.cornerRadius = 0f;
        this.initMaskOutlineProvider(arg2);
    }

    static float access$000(ShapeableDelegateV22 arg0) {
        return arg0.cornerRadius;
    }

    float getCornerRadius() {
        return this.cornerRadius;
    }

    private float getDefaultCornerRadius() {
        if(this.shapeAppearanceModel != null) {
            if(this.maskBounds == null) {
            }
            else {
                return this.shapeAppearanceModel.topRightCornerSize.getCornerSize(this.maskBounds);
            }
        }

        return 0;
    }

    private void initMaskOutlineProvider(View arg2) {
        arg2.setOutlineProvider(new ViewOutlineProvider() {
            public void getOutline(View arg7, Outline arg8) {
                if(ShapeableDelegateV22.this.shapeAppearanceModel != null && !ShapeableDelegateV22.this.maskBounds.isEmpty()) {
                    arg8.setRoundRect(((int)ShapeableDelegateV22.this.maskBounds.left), ((int)ShapeableDelegateV22.this.maskBounds.top), ((int)ShapeableDelegateV22.this.maskBounds.right), ((int)ShapeableDelegateV22.this.maskBounds.bottom), ShapeableDelegateV22.this.cornerRadius);
                }
            }
        });
    }

    void invalidateClippingMethod(View arg3) {
        this.cornerRadius = this.getDefaultCornerRadius();
        boolean v0 = (this.isShapeRoundRect()) || (this.offsetZeroCornerEdgeBoundsIfPossible()) ? true : false;
        this.canUseViewOutline = v0;
        arg3.setClipToOutline(this.shouldUseCompatClipping() ^ 1);
        if(this.shouldUseCompatClipping()) {
            arg3.invalidate();
            return;
        }

        arg3.invalidateOutline();
    }

    private boolean isShapeRoundRect() {
        if(!this.maskBounds.isEmpty()) {
            if(this.shapeAppearanceModel == null) {
            }
            else {
                return this.shapeAppearanceModel.isRoundRect(this.maskBounds);
            }
        }

        return 0;
    }

    private boolean offsetZeroCornerEdgeBoundsIfPossible() {
        if(!this.maskBounds.isEmpty() && this.shapeAppearanceModel != null && (this.offsetZeroCornerEdgeBoundsEnabled) && !this.shapeAppearanceModel.isRoundRect(this.maskBounds)) {
            if(!ShapeableDelegateV22.shapeUsesAllRoundedCornerTreatments(this.shapeAppearanceModel)) {
            }
            else {
                float v0 = this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.maskBounds);
                float v2 = this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.maskBounds);
                float v3 = this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.maskBounds);
                float v4 = this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.maskBounds);
                int v6 = Float.compare(v0, 0f);
                if(v6 != 0 || v3 != 0f || v2 != v4) {
                    if(v6 == 0 && v2 == 0f && v3 == v4) {
                        this.maskBounds.set(this.maskBounds.left, this.maskBounds.top - v3, this.maskBounds.right, this.maskBounds.bottom);
                        this.cornerRadius = v3;
                        return 1;
                    }

                    if(v2 == 0f && v4 == 0f && v0 == v3) {
                        this.maskBounds.set(this.maskBounds.left, this.maskBounds.top, this.maskBounds.right + v0, this.maskBounds.bottom);
                        this.cornerRadius = v0;
                        return 1;
                    }

                    if(v3 != 0f) {
                        return 0;
                    }

                    if(v4 != 0f) {
                        return 0;
                    }

                    if(v0 != v2) {
                        return 0;
                    }

                    this.maskBounds.set(this.maskBounds.left, this.maskBounds.top, this.maskBounds.right, this.maskBounds.bottom + v0);
                    this.cornerRadius = v0;
                }
                else {
                    this.maskBounds.set(this.maskBounds.left - v2, this.maskBounds.top, this.maskBounds.right, this.maskBounds.bottom);
                    this.cornerRadius = v2;
                }

                return 1;
            }
        }

        return 0;
    }

    private static boolean shapeUsesAllRoundedCornerTreatments(ShapeAppearanceModel arg1) {
        if(((arg1.getTopLeftCorner() instanceof RoundedCornerTreatment)) && ((arg1.getTopRightCorner() instanceof RoundedCornerTreatment)) && ((arg1.getBottomLeftCorner() instanceof RoundedCornerTreatment)) && ((arg1.getBottomRightCorner() instanceof RoundedCornerTreatment))) {
            return 1;
        }

        return 0;
    }

    boolean shouldUseCompatClipping() {
        if(this.canUseViewOutline) {
            if(this.forceCompatClippingEnabled) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

