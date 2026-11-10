package com.TryJeanPc.goldenmouse.sharksettings;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;

public class RoundGroupView extends RelativeLayout {
    private Context mContext;
    private Paint mImagePaint;
    private float mRadius;
    private Paint mRoundPaint;

    public RoundGroupView(Context arg2) {
        this(arg2, null);
    }

    public RoundGroupView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public RoundGroupView(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.mRadius = 0f;
        this.mContext = arg1;
        this.init();
    }

    protected void dispatchDraw(Canvas arg5) {
        if(this.mRadius > 0f) {
            arg5.saveLayer(new RectF(0f, 0f, ((float)arg5.getWidth()), ((float)arg5.getHeight())), this.mImagePaint, 0x1F);
            super.dispatchDraw(arg5);
            this.drawTopLeft(arg5);
            this.drawTopRight(arg5);
            this.drawBottomLeft(arg5);
            this.drawBottomRight(arg5);
            arg5.restore();
            return;
        }

        super.dispatchDraw(arg5);
    }

    private void drawBottomLeft(Canvas arg7) {
        int v0 = this.getHeight();
        Path v1 = new Path();
        float v0_1 = ((float)v0);
        v1.moveTo(0f, v0_1 - this.mRadius);
        v1.lineTo(0f, v0_1);
        v1.lineTo(this.mRadius, v0_1);
        float v2 = this.mRadius * 2f;
        v1.arcTo(new RectF(0f, v0_1 - v2, v2, v0_1), 90f, 90f);
        v1.close();
        arg7.drawPath(v1, this.mRoundPaint);
    }

    private void drawBottomRight(Canvas arg7) {
        int v0 = this.getHeight();
        int v1 = this.getWidth();
        Path v2 = new Path();
        float v1_1 = ((float)v1);
        float v0_1 = ((float)v0);
        v2.moveTo(v1_1 - this.mRadius, v0_1);
        v2.lineTo(v1_1, v0_1);
        v2.lineTo(v1_1, v0_1 - this.mRadius);
        float v3 = this.mRadius * 2f;
        v2.arcTo(new RectF(v1_1 - v3, v0_1 - v3, v1_1, v0_1), 0f, 90f);
        v2.close();
        arg7.drawPath(v2, this.mRoundPaint);
    }

    private void drawTopLeft(Canvas arg6) {
        Path v0 = new Path();
        v0.moveTo(0f, this.mRadius);
        v0.lineTo(0f, 0f);
        v0.lineTo(this.mRadius, 0f);
        float v1 = this.mRadius * 2f;
        v0.arcTo(new RectF(0f, 0f, v1, v1), -90f, -90f);
        v0.close();
        arg6.drawPath(v0, this.mRoundPaint);
    }

    private void drawTopRight(Canvas arg7) {
        int v0 = this.getWidth();
        Path v1 = new Path();
        float v0_1 = ((float)v0);
        v1.moveTo(v0_1 - this.mRadius, 0f);
        v1.lineTo(v0_1, 0f);
        v1.lineTo(v0_1, this.mRadius);
        float v2 = this.mRadius * 2f;
        v1.arcTo(new RectF(v0_1 - v2, 0f, v0_1, v2), 0f, -90f);
        v1.close();
        arg7.drawPath(v1, this.mRoundPaint);
    }

    private void init() {
        this.mRadius = TypedValue.applyDimension(1, 8f, this.mContext.getResources().getDisplayMetrics());
        Paint v0 = new Paint();
        this.mRoundPaint = v0;
        v0.setColor(-1);
        this.mRoundPaint.setAntiAlias(true);
        this.mRoundPaint.setStyle(Paint$Style.FILL);
        this.mRoundPaint.setXfermode(new PorterDuffXfermode(PorterDuff$Mode.DST_OUT));
        v0 = new Paint();
        this.mImagePaint = v0;
        v0.setXfermode(null);
    }

    public void setRoundedCorners(float arg3) {
        this.mRadius = TypedValue.applyDimension(1, arg3, this.mContext.getResources().getDisplayMetrics());
        this.postInvalidate();
    }
}

