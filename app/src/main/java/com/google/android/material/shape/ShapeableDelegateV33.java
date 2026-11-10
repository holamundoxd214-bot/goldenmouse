package com.google.android.material.shape;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

class ShapeableDelegateV33 extends ShapeableDelegate {
    ShapeableDelegateV33(View arg1) {
        super();
        this.initMaskOutlineProvider(arg1);
    }

    private void initMaskOutlineProvider(View arg2) {
        arg2.setOutlineProvider(new ViewOutlineProvider() {
            public void getOutline(View arg1, Outline arg2) {
                if(!ShapeableDelegateV33.this.shapePath.isEmpty()) {
                    arg2.setPath(ShapeableDelegateV33.this.shapePath);
                }
            }
        });
    }

    void invalidateClippingMethod(View arg2) {
        arg2.setClipToOutline(this.shouldUseCompatClipping() ^ 1);
        if(this.shouldUseCompatClipping()) {
            arg2.invalidate();
            return;
        }

        arg2.invalidateOutline();
    }

    boolean shouldUseCompatClipping() {
        return this.forceCompatClippingEnabled;
    }
}

