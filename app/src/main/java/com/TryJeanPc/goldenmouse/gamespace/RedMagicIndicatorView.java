package com.TryJeanPc.goldenmouse.gamespace;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.TryJeanPc.goldenmouse.R$drawable;

public class RedMagicIndicatorView extends View {
    private int currentIndicator;
    private int indicatorCount;
    private final int indicatorWidth;
    private final Bitmap mLightBitmap;
    private final Bitmap mNormalBitmap;
    private final int marginWidth;
    private final Paint paint;

    public RedMagicIndicatorView(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.paint = new Paint(1);
        this.mLightBitmap = BitmapFactory.decodeResource(this.getResources(), drawable.gspace_rm_indicator_light);
        Bitmap v1 = BitmapFactory.decodeResource(this.getResources(), drawable.gspace_rm_indicator_normal);
        this.mNormalBitmap = v1;
        this.indicatorWidth = v1.getWidth();
        this.marginWidth = ((int)(this.getResources().getDisplayMetrics().density * 4f));
    }

    protected void onDraw(Canvas arg9) {
        int v0 = this.getWidth();
        int v1 = this.getHeight();
        int v2 = this.indicatorWidth;
        int v3 = this.indicatorCount;
        int v4 = v2 * v3 + this.marginWidth * (v3 - 1);
        if(v3 > 1) {
            v1 = (v1 - v2) / 2;
            for(v2 = 0; v2 < this.indicatorCount; ++v2) {
                v3 = (v0 - v4) / 2 + (this.indicatorWidth + this.marginWidth) * v2;
                Bitmap v5 = v2 == this.currentIndicator ? this.mLightBitmap : this.mNormalBitmap;
                arg9.drawBitmap(v5, ((float)v3), ((float)v1), this.paint);
            }
        }
    }

    public void setCurrentIndicator(int arg1) {
        this.currentIndicator = arg1;
        this.invalidate();
    }

    public void setIndicatorCount(int arg1) {
        this.indicatorCount = arg1;
    }
}

