package com.google.android.material.shape;

import android.view.View;

class ShapeableDelegateV14 extends ShapeableDelegate {
    ShapeableDelegateV14() {
        super();
    }

    void invalidateClippingMethod(View arg2) {
        if(this.shapeAppearanceModel != null) {
            if(this.maskBounds.isEmpty()) {
            }
            else if(this.shouldUseCompatClipping()) {
                arg2.invalidate();
            }
        }
    }

    boolean shouldUseCompatClipping() {
        return 1;
    }
}

