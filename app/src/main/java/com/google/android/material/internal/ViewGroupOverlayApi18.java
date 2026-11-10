package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {
    private final ViewGroupOverlay viewGroupOverlay;

    ViewGroupOverlayApi18(ViewGroup arg1) {
        super();
        this.viewGroupOverlay = arg1.getOverlay();
    }

    public void add(Drawable arg1) {
        this.viewGroupOverlay.add(arg1);
    }

    public void add(View arg1) {
        this.viewGroupOverlay.add(arg1);
    }

    public void remove(Drawable arg1) {
        this.viewGroupOverlay.remove(arg1);
    }

    public void remove(View arg1) {
        this.viewGroupOverlay.remove(arg1);
    }
}

