package com.TryJeanPc.goldenmouse.sharksettings;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.TryJeanPc.goldenmouse.R$dimen;
import com.TryJeanPc.goldenmouse.R$style;
import com.TryJeanPc.goldenmouse.R$styleable;

public class CardLayoutHelp {
    private Context mContext;
    private int mHeight;
    private float mLeft;
    private float mLength;
    private Paint mPaint;
    private PaintFlagsDrawFilter mPaintFlagsDrawFilter;
    private Path mPath;
    private RectF mRectF;
    private float mRight;
    private int mStrokeColor;
    private RectF mStrokeRectF;
    private float mStrokeWidth;
    private View mView;
    private int mWidth;

    public CardLayoutHelp() {
        super();
    }

    public void drawPath(Canvas arg30) {
        this.mPaint.reset();
        this.mPath.reset();
        arg30.setDrawFilter(this.mPaintFlagsDrawFilter);
        this.mPath.moveTo(this.mLeft, 0f);
        Path v5 = this.mPath;
        float v8 = ((float)this.mWidth);
        v5.arcTo(v8 - this.mRight, 0f, v8, this.mRight, -90f, 90f, false);
        Path v13 = this.mPath;
        int v2 = this.mWidth;
        float v3 = this.mLength;
        float v2_1 = ((float)v2);
        float v14 = v2_1 - v3;
        float v4 = (((float)this.mHeight)) - this.mLeft;
        v3 /= 2f;
        v13.arcTo(v14, v4 - v3, v2_1, v4 + v3, 0f, 45f, false);
        Path v2_2 = this.mPath;
        int v3_1 = this.mWidth;
        v4 = this.mLeft;
        float v6 = this.mLength;
        v3 = (((float)v3_1)) - v4;
        v4 = v6 / 2f;
        float v7 = ((float)this.mHeight);
        v2_2.arcTo(v3 - v4, v7 - v6, v3 + v4, v7, 45f, 45f, false);
        Path v8_1 = this.mPath;
        float v12 = ((float)this.mHeight);
        v8_1.arcTo(0f, v12 - this.mRight, this.mRight, v12, 90f, 90f, false);
        v2_2 = this.mPath;
        v3 = this.mLeft;
        v6 = this.mLength / 2f;
        v2_2.arcTo(0f, v3 - v6, this.mLength, v3 + v6, 180f, 45f, false);
        Path v6_1 = this.mPath;
        v2_1 = this.mLeft;
        v3 = this.mLength / 2f;
        v6_1.arcTo(v2_1 - v3, 0f, v2_1 + v3, this.mLength, 225f, 45f, false);
        arg30.clipPath(this.mPath);
    }

    public void drawStroke(Canvas arg3) {
        if(this.mStrokeWidth > 0f) {
            this.mPaint.setStyle(Paint$Style.STROKE);
            this.mPaint.setStrokeWidth(this.mStrokeWidth);
            this.mPaint.setColor(this.mStrokeColor);
            arg3.drawPath(this.mPath, this.mPaint);
        }

        arg3.restore();
    }

    public void init(Context arg3, AttributeSet arg4, View arg5) {
        arg5.setWillNotDraw(false);
        this.mContext = arg3;
        this.mView = arg5;
        this.mPaint = new Paint();
        this.mRectF = new RectF();
        this.mStrokeRectF = new RectF();
        this.mPath = new Path();
        this.mStrokeColor = -1;
        this.mLeft = ((float)this.mContext.getResources().getDimensionPixelOffset(dimen.shark_settings_gxd_dimen_25));
        this.mRight = ((float)this.mContext.getResources().getDimensionPixelOffset(dimen.shark_settings_gxd_dimen_18));
        this.mLength = ((float)this.mContext.getResources().getDimensionPixelOffset(dimen.shark_settings_gxd_dimen_14));
        TypedArray v3 = arg3.obtainStyledAttributes(arg4, styleable.SharkSettingsCard, 0, style.SharkSettingsCardDefault);
        this.mPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
        this.mStrokeWidth = v3.getDimension(styleable.SharkSettingsCard_shark_settings_stroke_width, 0f);
        this.mStrokeColor = v3.getColor(styleable.SharkSettingsCard_shark_settings_stroke_color, this.mStrokeColor);
        v3.recycle();
    }

    public void onSizeChanged(int arg5, int arg6) {
        this.mWidth = arg5;
        this.mHeight = arg6;
        RectF v0 = this.mRectF;
        if(v0 != null) {
            v0.set(0f, 0f, ((float)arg5), ((float)arg6));
        }

        v0 = this.mStrokeRectF;
        if(v0 != null) {
            float v4 = this.mStrokeWidth / 2f;
            v0.set(v4, v4, (((float)arg5)) - v4, (((float)arg6)) - v4);
        }
    }

    public void preDraw(Canvas arg3) {
        arg3.saveLayer(this.mRectF, null, 0x1F);
    }

    public void setStrokeColor(int arg1) {
        this.mStrokeColor = arg1;
        View v0 = this.mView;
        if(v0 != null) {
            v0.invalidate();
        }
    }

    public void setStrokeWidth(float arg2) {
        if(this.mContext == null) {
        }
        else {
            this.mStrokeWidth = arg2;
            if(this.mView != null) {
                this.onSizeChanged(this.mWidth, this.mHeight);
                this.mView.invalidate();
            }
        }
    }

    public void setStrokeWidthColor(float arg2, int arg3) {
        if(this.mContext == null) {
        }
        else {
            this.mStrokeWidth = arg2;
            this.mStrokeColor = arg3;
            if(this.mView != null) {
                this.onSizeChanged(this.mWidth, this.mHeight);
                this.mView.invalidate();
            }
        }
    }
}

