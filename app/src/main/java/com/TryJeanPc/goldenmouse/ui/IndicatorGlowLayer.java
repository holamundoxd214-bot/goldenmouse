package com.TryJeanPc.goldenmouse.ui;

import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public final class IndicatorGlowLayer {
    private Bitmap bitmap;
    private Canvas canvas;

    public IndicatorGlowLayer() {
        super();
    }

    public Canvas begin() {
        if(this.bitmap == null) {
            this.bitmap = Bitmap.createBitmap(280, 320, Bitmap$Config.ARGB_8888);
            this.canvas = new Canvas(this.bitmap);
        }

        this.bitmap.eraseColor(0);
        return this.canvas;
    }

    public void drawTo(Canvas arg3) {
        arg3.drawBitmap(this.bitmap, 0f, 0f, null);
    }

    public void release() {
        Bitmap v0 = this.bitmap;
        if(v0 != null) {
            v0.recycle();
        }

        this.bitmap = null;
        this.canvas = null;
    }
}

