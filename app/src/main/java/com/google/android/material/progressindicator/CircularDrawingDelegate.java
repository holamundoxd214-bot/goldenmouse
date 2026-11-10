package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;

final class CircularDrawingDelegate extends DrawingDelegate {
    private float adjustedRadius;
    private int arcDirectionFactor;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    public CircularDrawingDelegate(CircularProgressIndicatorSpec arg1) {
        super(((BaseProgressIndicatorSpec)arg1));
        this.arcDirectionFactor = 1;
    }

    public void adjustCanvas(Canvas arg8, Rect arg9, float arg10) {
        float v0 = (((float)arg9.width())) / (((float)this.getPreferredWidth()));
        float v1 = (((float)arg9.height())) / (((float)this.getPreferredHeight()));
        float v3 = 2f;
        float v2 = (((float)this.spec.indicatorSize)) / v3 + (((float)this.spec.indicatorInset));
        arg8.translate(v2 * v0 + (((float)arg9.left)), v2 * v1 + (((float)arg9.top)));
        arg8.scale(v0, v1);
        arg8.rotate(-90f);
        float v9 = -v2;
        arg8.clipRect(v9, v9, v2, v2);
        int v8 = this.spec.indicatorDirection == 0 ? 1 : -1;
        this.arcDirectionFactor = v8;
        this.displayedTrackThickness = (((float)this.spec.trackThickness)) * arg10;
        this.displayedCornerRadius = (((float)this.spec.trackCornerRadius)) * arg10;
        this.adjustedRadius = (((float)(this.spec.indicatorSize - this.spec.trackThickness))) / v3;
        v0 = 1f;
        int v1_1 = 2;
        if((this.drawable.isShowing()) && this.spec.showAnimationBehavior == v1_1 || (this.drawable.isHiding()) && this.spec.hideAnimationBehavior == 1) {
            this.adjustedRadius += (v0 - arg10) * (((float)this.spec.trackThickness)) / v3;
            return;
        }

        if((this.drawable.isShowing()) && this.spec.showAnimationBehavior == 1 || (this.drawable.isHiding()) && this.spec.hideAnimationBehavior == v1_1) {
            this.adjustedRadius -= (v0 - arg10) * (((float)this.spec.trackThickness)) / v3;
        }
    }

    private void drawRoundedEnd(Canvas arg2, Paint arg3, float arg4, float arg5, float arg6) {
        arg2.save();
        arg2.rotate(arg6);
        arg4 /= 2f;
        arg2.drawRoundRect(new RectF(this.adjustedRadius - arg4, arg5, this.adjustedRadius + arg4, -arg5), arg5, arg5, arg3);
        arg2.restore();
    }

    void fillIndicator(Canvas arg9, Paint arg10, float arg11, float arg12, int arg13) {
        if(arg11 == arg12) {
        }
        else {
            arg10.setStyle(Paint$Style.STROKE);
            arg10.setStrokeCap(Paint$Cap.BUTT);
            arg10.setAntiAlias(true);
            arg10.setColor(arg13);
            arg10.setStrokeWidth(this.displayedTrackThickness);
            float v7 = 360f;
            int v3 = this.arcDirectionFactor;
            float v5 = arg11 * v7 * (((float)v3));
            float v1 = arg12 >= arg11 ? arg12 - arg11 : 1f + arg12 - arg11;
            float v4 = v1 * v7 * (((float)v3));
            float v3_1 = v5;
            arg9.drawArc(new RectF(-this.adjustedRadius, -this.adjustedRadius, this.adjustedRadius, this.adjustedRadius), v3_1, v4, false, arg10);
            float v6 = v4;
            if(this.displayedCornerRadius <= 0f) {
                return;
            }

            if(Math.abs(v6) >= v7) {
                return;
            }

            arg10.setStyle(Paint$Style.FILL);
            this.drawRoundedEnd(arg9, arg10, this.displayedTrackThickness, this.displayedCornerRadius, v3_1);
            this.drawRoundedEnd(arg9, arg10, this.displayedTrackThickness, this.displayedCornerRadius, v3_1 + v6);
        }
    }

    void fillTrack(Canvas arg8, Paint arg9) {
        int v0 = MaterialColors.compositeARGBWithAlpha(this.spec.trackColor, this.drawable.getAlpha());
        arg9.setStyle(Paint$Style.STROKE);
        arg9.setStrokeCap(Paint$Cap.BUTT);
        arg9.setAntiAlias(true);
        arg9.setColor(v0);
        arg9.setStrokeWidth(this.displayedTrackThickness);
        arg8.drawArc(new RectF(-this.adjustedRadius, -this.adjustedRadius, this.adjustedRadius, this.adjustedRadius), 0f, 360f, false, arg9);
    }

    public int getPreferredHeight() {
        return this.getSize();
    }

    public int getPreferredWidth() {
        return this.getSize();
    }

    private int getSize() {
        return this.spec.indicatorSize + this.spec.indicatorInset * 2;
    }
}

