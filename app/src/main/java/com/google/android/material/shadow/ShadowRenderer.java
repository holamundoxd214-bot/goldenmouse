package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region$Op;
import android.graphics.Shader$TileMode;
import androidx.core.graphics.ColorUtils;

public class ShadowRenderer {
    private static final int COLOR_ALPHA_END = 0;
    private static final int COLOR_ALPHA_MIDDLE = 20;
    private static final int COLOR_ALPHA_START = 68;
    private static final int[] cornerColors;
    private static final float[] cornerPositions;
    private final Paint cornerShadowPaint;
    private static final int[] edgeColors;
    private static final float[] edgePositions;
    private final Paint edgeShadowPaint;
    private final Path scratch;
    private int shadowEndColor;
    private int shadowMiddleColor;
    private final Paint shadowPaint;
    private int shadowStartColor;
    private final Paint transparentPaint;

    static {
        ShadowRenderer.edgeColors = new int[3];
        ShadowRenderer.edgePositions = new float[]{0f, 0.5f, 1f};
        ShadowRenderer.cornerColors = new int[4];
        ShadowRenderer.cornerPositions = new float[]{0f, 0f, 0.5f, 1f};
    }

    public ShadowRenderer() {
        this(0xFF000000);
    }

    public ShadowRenderer(int arg3) {
        super();
        this.scratch = new Path();
        Paint v0 = new Paint();
        this.transparentPaint = v0;
        this.shadowPaint = new Paint();
        this.setShadowColor(arg3);
        v0.setColor(0);
        Paint v3 = new Paint(4);
        this.cornerShadowPaint = v3;
        v3.setStyle(Paint$Style.FILL);
        this.edgeShadowPaint = new Paint(v3);
    }

    public void drawCornerShadow(Canvas arg22, Matrix arg23, RectF arg24, int arg25, float arg26, float arg27) {
        float v12_1;
        int[] v18;
        ShadowRenderer v0 = this;
        Canvas v1 = arg22;
        RectF v2 = arg24;
        int v3 = arg25;
        float v4 = arg27;
        int v6 = Float.compare(v4, 0f) < 0 ? 1 : 0;
        Path v9 = v0.scratch;
        int v10 = 3;
        int v11 = 2;
        if(v6 != 0) {
            int[] v12 = ShadowRenderer.cornerColors;
            v12[0] = 0;
            v12[1] = v0.shadowEndColor;
            v12[v11] = v0.shadowMiddleColor;
            v12[v10] = v0.shadowStartColor;
            v18 = v12;
            v12_1 = arg26;
        }
        else {
            v9.rewind();
            v9.moveTo(v2.centerX(), v2.centerY());
            v12_1 = arg26;
            v9.arcTo(v2, v12_1, v4);
            v9.close();
            float v13 = ((float)(-v3));
            v2.inset(v13, v13);
            int[] v13_1 = ShadowRenderer.cornerColors;
            v13_1[0] = 0;
            v13_1[1] = v0.shadowStartColor;
            v13_1[v11] = v0.shadowMiddleColor;
            v13_1[v10] = v0.shadowEndColor;
            v18 = v13_1;
        }

        float v10_1 = 2f;
        float v17 = v2.width() / v10_1;
        if(v17 <= 0f) {
            return;
        }

        float v3_1 = 1f - (((float)v3)) / v17;
        float[] v19 = ShadowRenderer.cornerPositions;
        v19[1] = v3_1;
        v19[v11] = (1f - v3_1) / v10_1 + v3_1;
        v0.cornerShadowPaint.setShader(new RadialGradient(v2.centerX(), v2.centerY(), v17, v18, v19, Shader$TileMode.CLAMP));
        v1.save();
        arg22.concat(arg23);
        v1.scale(1f, v2.height() / v2.width());
        if(v6 == 0) {
            v1.clipPath(v9, Region$Op.DIFFERENCE);
            v1.drawPath(v9, v0.transparentPaint);
        }

        v1.drawArc(v2, v12_1, arg27, true, v0.cornerShadowPaint);
        arg22.restore();
    }

    public void drawEdgeShadow(Canvas arg10, Matrix arg11, RectF arg12, int arg13) {
        arg12.bottom += ((float)arg13);
        arg12.offset(0f, ((float)(-arg13)));
        int[] v6 = ShadowRenderer.edgeColors;
        v6[0] = this.shadowEndColor;
        v6[1] = this.shadowMiddleColor;
        v6[2] = this.shadowStartColor;
        this.edgeShadowPaint.setShader(new LinearGradient(arg12.left, arg12.top, arg12.left, arg12.bottom, v6, ShadowRenderer.edgePositions, Shader$TileMode.CLAMP));
        arg10.save();
        arg10.concat(arg11);
        arg10.drawRect(arg12, this.edgeShadowPaint);
        arg10.restore();
    }

    public void drawInnerCornerShadow(Canvas arg8, Matrix arg9, RectF arg10, int arg11, float arg12, float arg13, float[] arg14) {
        if(arg13 > 0f) {
            arg12 += arg13;
            arg13 = -arg13;
        }

        ShadowRenderer v0 = this;
        v0.drawCornerShadow(arg8, arg9, arg10, arg11, arg12, arg13);
        Path v7 = v0.scratch;
        v7.rewind();
        v7.moveTo(arg14[0], arg14[1]);
        v7.arcTo(arg10, arg12, arg13);
        v7.close();
        arg8.save();
        arg8.concat(arg9);
        arg8.scale(1f, arg10.height() / arg10.width());
        arg8.drawPath(v7, v0.transparentPaint);
        arg8.drawPath(v7, v0.shadowPaint);
        arg8.restore();
    }

    public Paint getShadowPaint() {
        return this.shadowPaint;
    }

    public void setShadowColor(int arg2) {
        this.shadowStartColor = ColorUtils.setAlphaComponent(arg2, 68);
        this.shadowMiddleColor = ColorUtils.setAlphaComponent(arg2, 20);
        this.shadowEndColor = ColorUtils.setAlphaComponent(arg2, 0);
        this.shadowPaint.setColor(this.shadowStartColor);
    }
}

