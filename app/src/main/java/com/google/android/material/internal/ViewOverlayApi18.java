package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class ViewOverlayApi18 implements ViewOverlayImpl {
    private final ViewOverlay viewOverlay;

    ViewOverlayApi18(View arg1) {
        super();
        this.viewOverlay = arg1.getOverlay();
    }

    public void add(Drawable arg1) {
        this.viewOverlay.add(arg1);
    }

    public void remove(Drawable arg1) {
        this.viewOverlay.remove(arg1);
    }
}

