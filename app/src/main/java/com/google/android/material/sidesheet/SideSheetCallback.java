package com.google.android.material.sidesheet;

import android.view.View;

public abstract class SideSheetCallback implements SheetCallback {
    public SideSheetCallback() {
        super();
    }

    void onLayout(View arg1) {
    }

    public abstract void onSlide(View arg1, float arg2);

    public abstract void onStateChanged(View arg1, int arg2);
}

