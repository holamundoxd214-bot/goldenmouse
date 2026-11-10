package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path$Direction;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;

final class LinearDrawingDelegate extends DrawingDelegate {
    private float displayedCornerRadius;
    private Path displayedTrackPath;
    private float displayedTrackThickness;
    private float trackLength;

    public LinearDrawingDelegate(LinearProgressIndicatorSpec arg1) {
        super(((BaseProgressIndicatorSpec)arg1));
        this.trackLength = 300f;
    }

    public void adjustCanvas(Canvas arg7, Rect arg8, float arg9) {
        this.trackLength = ((float)arg8.width());
        float v0 = ((float)this.spec.trackThickness);
        float v3 = 2f;
        arg7.translate((((float)arg8.left)) + (((float)arg8.width())) / v3, (((float)arg8.top)) + (((float)arg8.height())) / v3 + Math.max(0f, (((float)(arg8.height() - this.spec.trackThickness))) / v3));
        float v1 = -1f;
        float v2 = 1f;
        if(this.spec.drawHorizontallyInverse) {
            arg7.scale(v1, v2);
        }

        if((this.drawable.isShowing()) && this.spec.showAnimationBehavior == 1 || (this.drawable.isHiding()) && this.spec.hideAnimationBehavior == 2) {
            arg7.scale(v2, v1);
        }

        if((this.drawable.isShowing()) || (this.drawable.isHiding())) {
            arg7.translate(0f, (((float)this.spec.trackThickness)) * (arg9 - v2) / v3);
        }

        arg7.clipRect(-this.trackLength / v3, -v0 / v3, this.trackLength / v3, v0 / v3);
        this.displayedTrackThickness = (((float)this.spec.trackThickness)) * arg9;
        this.displayedCornerRadius = (((float)this.spec.trackCornerRadius)) * arg9;
    }

    public void fillIndicator(Canvas arg5, Paint arg6, float arg7, float arg8, int arg9) {
        if(arg7 == arg8) {
            return;
        }

        float v0 = this.trackLength;
        float v1 = -v0 / 2f;
        arg7 = arg7 * v0 + v1 - this.displayedCornerRadius * 2f;
        arg6.setStyle(Paint$Style.FILL);
        arg6.setAntiAlias(true);
        arg6.setColor(arg9);
        arg5.save();
        arg5.clipPath(this.displayedTrackPath);
        arg5.drawRoundRect(new RectF(arg7, -this.displayedTrackThickness / 2f, v1 + arg8 * v0, this.displayedTrackThickness / 2f), this.displayedCornerRadius, this.displayedCornerRadius, arg6);
        arg5.restore();
    }

    void fillTrack(Canvas arg8, Paint arg9) {
        int v0 = MaterialColors.compositeARGBWithAlpha(this.spec.trackColor, this.drawable.getAlpha());
        arg9.setStyle(Paint$Style.FILL);
        arg9.setAntiAlias(true);
        arg9.setColor(v0);
        Path v0_1 = new Path();
        this.displayedTrackPath = v0_1;
        v0_1.addRoundRect(new RectF(-this.trackLength / 2f, -this.displayedTrackThickness / 2f, this.trackLength / 2f, this.displayedTrackThickness / 2f), this.displayedCornerRadius, this.displayedCornerRadius, Path$Direction.CCW);
        arg8.drawPath(this.displayedTrackPath, arg9);
    }

    public int getPreferredHeight() {
        return this.spec.trackThickness;
    }

    public int getPreferredWidth() {
        return -1;
    }
}

