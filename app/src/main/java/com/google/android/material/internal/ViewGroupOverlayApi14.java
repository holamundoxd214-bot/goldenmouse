package com.google.android.material.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
    ViewGroupOverlayApi14(Context arg1, ViewGroup arg2, View arg3) {
        super(arg1, arg2, arg3);
    }

    public void add(View arg1) {
        this.overlayViewGroup.add(arg1);
    }

    static ViewGroupOverlayApi14 createFrom(ViewGroup arg0) {
        return ViewOverlayApi14.createFrom(((View)arg0));
    }

    public void remove(View arg1) {
        this.overlayViewGroup.remove(arg1);
    }
}

