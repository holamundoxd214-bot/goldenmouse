package com.TryJeanPc.goldenmouse;

import android.content.Context;
import android.graphics.BlurMaskFilter$Blur;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.MaskFilter;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Join;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader$TileMode;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Choreographer$FrameCallback;
import android.view.Choreographer;
import android.view.View$MeasureSpec;
import android.view.View;
import androidx.core.graphics.PathParser;
import com.TryJeanPc.goldenmouse.ui.IndicatorGlowLayer;
import java.util.ArrayList;
import java.util.Arrays;

public class RamIndicatorView extends View {
    public class W81 {
        public Path a;
        public int b;

        public W81() {
            super();
        }
    }

    private static final float[] GRADIENT_STOPS;
    public final Paint a;
    public final Paint b;
    public final Paint c;
    public final ArrayList d;
    public final ArrayList e;
    public final ArrayList f;
    private int[] fillColors;
    public final Paint g;
    private int[] glowColors;
    private boolean glowDirty;
    private final IndicatorGlowLayer glowLayer;
    public final Paint h;
    public final Paint i;
    public float j;
    public float k;
    public float l;
    public long m;
    private float modeSweepProgress;
    public Choreographer$FrameCallback n;
    private final Paint neonCore;
    private boolean progressAnimationEnabled;

    static {
        RamIndicatorView.GRADIENT_STOPS = new float[]{0f, 0.5f, 1f};
    }

    public RamIndicatorView(Context arg11, AttributeSet arg12) {
        super(arg11, arg12);
        this.modeSweepProgress = NaNf;
        this.progressAnimationEnabled = true;
        this.glowLayer = new IndicatorGlowLayer();
        this.glowDirty = true;
        Paint v12 = new Paint(1);
        this.neonCore = v12;
        Paint v0 = new Paint(1);
        this.a = v0;
        Paint v1 = new Paint(1);
        this.b = v1;
        Paint v2 = new Paint(1);
        this.c = v2;
        this.d = new ArrayList();
        this.e = new ArrayList();
        ArrayList v3 = new ArrayList();
        this.f = v3;
        BlurMaskFilter$Blur v4 = BlurMaskFilter$Blur.NORMAL;
        BlurMaskFilter v5 = new BlurMaskFilter(15f, v4);
        BlurMaskFilter v6 = new BlurMaskFilter(10f, v4);
        BlurMaskFilter v7 = new BlurMaskFilter(5f, v4);
        Paint v4_1 = new Paint(1);
        this.g = v4_1;
        Paint v8 = new Paint(1);
        this.h = v8;
        Paint v9 = new Paint(1);
        this.i = v9;
        this.j = 0f;
        this.k = 0f;
        this.l = 0f;
        Paint$Style v11 = Paint$Style.FILL;
        v0.setStyle(v11);
        RamIndicatorView.e(v4_1, v5);
        RamIndicatorView.e(v8, v6);
        RamIndicatorView.e(v9, v7);
        v12.setStyle(Paint$Style.STROKE);
        v12.setStrokeWidth(1f);
        v12.setStrokeJoin(Paint$Join.ROUND);
        v1.setStyle(v11);
        v1.setColor(Color.parseColor("#2B3737"));
        v2.setStyle(v11);
        v2.setColor(Color.parseColor("#000000"));
        v2.setAlpha(0x80);
        this.c("M143.24,304.05l-7.75,15.95l-4.37,-0.14l8.04,-16.09z");
        this.c("M147.75,284.86l5.08,0.56l-8.18,16.09l-4.37,-0.42z");
        this.c("M156.07,266.23l6.63,0.42l-8.32,16.23l-5.5,-0.42z");
        this.c("M172.14,247.31l-8.04,16.09l-6.91,-0.28l7.33,-15.81z");
        this.c("M181.73,228.4l-8.04,15.81l-8.18,-0.14l7.19,-15.95z");
        this.c("M191.6,209.49l-8.32,15.95l-9.59,-0.14l7.47,-16.23z");
        this.c("M201.18,190.72l-8.04,16.23l-10.86,-0.28l7.19,-16.51z");
        this.c("M197.52,171.52l13.39,0.14l-8.18,16.23l-11.98,-0.56z");
        this.c("M220.92,152.75l-8.46,16.09l-13.39,-0.14l7.19,-16.23z");
        this.c("M230.65,133.84l-8.32,15.95h-14.8l7.19,-16.23z");
        this.c("M240.23,114.93l-8.18,15.67h-16.07l7.33,-15.81z");
        this.c("M242.38,95.18c0,0 1.63,5.35 1.35,8.17c-0.29,2.95 -2.51,8.72 -2.51,8.72l-16.73,-0.18c0,0 1.67,-6.18 1.72,-9c0.05,-2.57 -0.97,-7.12 -0.97,-7.12z");
        this.c("M217.18,77.23l16.77,-0.61l7.5,15.72l-16.81,0.75z");
        this.c("M207.87,58.55l16.77,-0.44l8.1,15.53l-16.95,0.35z");
        this.c("M198.08,39.43l16.77,-0.44l8.39,15.86l-17.24,0.49z");
        this.c("M188.3,20.78l16.77,-0.44l7.92,15.39l-16.77,0.49z");
        this.c("M178.05,0l16.77,0.05l8.39,16.79l-16.77,0.05z");
        this.b("M139.15,303.77l-8.04,16.09l4.37,0.14l7.75,-15.95z");
        this.b("M147.75,284.86l5.08,0.56l-8.18,16.09l-4.37,-0.42z");
        this.b("M156.07,266.23l6.63,0.42l-8.32,16.23l-5.5,-0.42z");
        this.b("M164.53,247.31l-7.33,15.81l6.91,0.28l8.04,-16.09z");
        this.b("M172.71,228.12l-7.19,15.95l8.18,0.14l8.04,-15.81z");
        this.b("M181.16,209.07l-7.47,16.23l9.59,0.14l8.32,-15.95z");
        this.b("M189.48,190.15l-7.19,16.51l10.86,0.28l8.04,-16.23z");
        this.b("M197.52,171.52l13.39,0.14l-8.18,16.23l-11.98,-0.56z");
        this.b("M206.26,152.47l-7.19,16.23l13.39,0.14l8.46,-16.09z");
        this.b("M214.72,133.56l-7.19,16.23h14.8l8.32,-15.95z");
        this.b("M223.32,114.79l-7.33,15.81h16.07l8.18,-15.67z");
        this.b("M225.24,95.76c0,0 1.03,4.55 0.97,7.12c-0.06,2.83 -1.72,9 -1.72,9l16.73,0.18c0,0 2.22,-5.77 2.51,-8.72c0.28,-2.82 -1.35,-8.17 -1.35,-8.17z");
        this.b("M217.18,77.23l16.77,-0.61l7.5,15.72l-16.81,0.75z");
        this.b("M215.79,73.99l16.95,-0.35l-8.1,-15.53l-16.77,0.44z");
        this.b("M206,55.34l17.24,-0.49l-8.39,-15.86l-16.77,0.44z");
        this.b("M196.22,36.22l16.77,-0.49l-7.92,-15.39l-16.77,0.44z");
        this.b("M186.44,16.89l16.77,-0.05l-8.39,-16.79l-16.77,-0.05z");
        v3.add(PathParser.createPathFromPathData("M178.38,0.3c7.32,15.8 26.97,52.93 28.6,56.82c7.21,12.21 11.83,22.72 16.67,33.62c4.13,11.37 3.83,14.04 -0.16,23.8c-10.31,22.63 -37.7,84.17 -49.97,111.56c-3.75,8.37 -8.17,17.8 -8.69,20.11c-0.67,2.67 -4.2,10.47 -7.99,18.03c-9.49,23.3 -21.9,48.44 -25.8,55.72c2.2,-0.04 4.17,-0.28 4.17,-0.28c0,0 56.53,-110.6 76.15,-149.03c6.61,-12.58 17.62,-33.6 19.77,-38.19c4.03,-8 9.58,-18.47 10.4,-20.99c3.67,-10.79 1.18,-15.17 -0.32,-19.13c-7.76,-18.64 -47.04,-92.27 -47.04,-92.27c0,0 -11.44,0.05 -15.78,0.22z"));
        this.d(new int[]{Color.parseColor("#FFFF00"), Color.parseColor("#FFD700"), Color.parseColor("#E58A00")}, new int[]{Color.parseColor("#FFFF00"), Color.parseColor("#FFD700"), Color.parseColor("#E58A00")});
        float v12_1 = 0.8f;
        if(this.isInEditMode()) {
            this.j = v12_1;
            RamIndicatorView.a(this, v12_1);
            return;
        }

        this.setProgress(v12_1);
    }

    public static void a(RamIndicatorView arg9, float arg10) {
        ArrayList v0 = arg9.e;
        arg10 *= ((float)v0.size());
        int v2 = 0;
        int v3 = 0;
        while(true) {
            int v5 = 1;
            if(v2 >= v0.size()) {
                break;
            }

            int v4 = v0.get(v2).b;
            float v6 = arg10 - (((float)v2));
            if(v6 <= 0f) {
                v0.get(v2).b = 0;
            }
            else if(v6 >= 1f) {
                v0.get(v2).b = 0xFF;
            }
            else {
                v0.get(v2).b = ((int)(v6 * 255f));
            }

            if(v4 != v0.get(v2).b) {
            }
            else {
                v5 = 0;
            }

            v3 |= v5;
            ++v2;
        }

        if(v3 != 0) {
            arg9.glowDirty = true;
            arg9.postInvalidateOnAnimation();
        }
    }

    public final void b(String arg1) {
        this.d.add(PathParser.createPathFromPathData(arg1));
    }

    public final void c(String arg3) {
        W81 v0 = new W81();
        v0.b = 0;
        v0.a = PathParser.createPathFromPathData(arg3);
        this.e.add(v0);
    }

    public void clearModeSweep() {
        if(Float.isNaN(this.modeSweepProgress)) {
            return;
        }

        this.modeSweepProgress = NaNf;
        this.glowDirty = true;
        this.postInvalidateOnAnimation();
    }

    public final void d(int[] arg10, int[] arg11) {
        if((Arrays.equals(this.fillColors, arg10)) && (Arrays.equals(this.glowColors, arg11))) {
            return;
        }

        this.fillColors = arg10.clone();
        this.glowColors = arg11.clone();
        this.glowDirty = true;
        Shader$TileMode v8 = Shader$TileMode.CLAMP;
        Paint v0 = this.a;
        float[] v7 = RamIndicatorView.GRADIENT_STOPS;
        v0.setShader(new LinearGradient(0f, 0f, 0f, 320f, arg10, v7, v8));
        LinearGradient v1 = new LinearGradient(0f, 0f, 0f, 320f, arg11, v7, v8);
        this.g.setShader(((Shader)v1));
        this.h.setShader(((Shader)v1));
        this.i.setShader(((Shader)v1));
        this.neonCore.setShader(((Shader)v1));
    }

    public static void e(Paint arg1, BlurMaskFilter arg2) {
        arg1.setStyle(Paint$Style.STROKE);
        arg1.setStrokeWidth(5f);
        arg1.setStrokeJoin(Paint$Join.ROUND);
        arg1.setStrokeCap(Paint$Cap.ROUND);
        arg1.setAntiAlias(true);
        arg1.setMaskFilter(((MaskFilter)arg2));
    }

    public float getDisplayedProgress() {
        if(Float.isNaN(this.modeSweepProgress)) {
            return this.j;
        }

        return this.modeSweepProgress;
    }

    protected void onDetachedFromWindow() {
        this.stopVisualAnimation();
        super.onDetachedFromWindow();
    }

    public final void onDraw(Canvas arg9) {
        super.onDraw(arg9);
        arg9.save();
        arg9.scale((((float)this.getWidth())) / 280f, (((float)this.getHeight())) / 320f);
        arg9.translate(282.5f, 0f);
        arg9.scale(-1f, 1f);
        ArrayList v0 = this.e;
        int v2 = 0;
        if(this.glowDirty) {
            Canvas v1 = this.glowLayer.begin();
            int v3;
            for(v3 = v0.size() - 1; v3 >= 0; --v3) {
                Object v4 = v0.get(v3);
                int v5 = this.renderedAlpha(v3);
                if(v5 == 0) {
                }
                else {
                    float v5_1 = ((float)v5);
                    Paint v6 = this.g;
                    v6.setAlpha(((int)(0.22f * v5_1)));
                    v1.drawPath(((W81)v4).a, v6);
                    v6 = this.h;
                    v6.setAlpha(((int)(0.48f * v5_1)));
                    v1.drawPath(((W81)v4).a, v6);
                    v6 = this.i;
                    v6.setAlpha(((int)(v5_1 * 0.72f)));
                    v1.drawPath(((W81)v4).a, v6);
                }
            }

            this.glowDirty = false;
        }

        this.glowLayer.drawTo(arg9);
        ArrayList v1_1 = this.f;
        v3 = v1_1.size();
        int v4_1;
        for(v4_1 = 0; v4_1 < v3; ++v4_1) {
            arg9.drawPath(v1_1.get(v4_1), this.c);
        }

        v1_1 = this.d;
        v3 = v1_1.size();
        while(v2 < v3) {
            arg9.drawPath(v1_1.get(v2), this.b);
            ++v2;
        }

        int v1_2;
        for(v1_2 = v0.size() - 1; v1_2 >= 0; --v1_2) {
            Object v2_1 = v0.get(v1_2);
            v3 = this.renderedAlpha(v1_2);
            Paint v4_2 = this.a;
            v4_2.setAlpha(v3);
            arg9.drawPath(((W81)v2_1).a, v4_2);
            this.neonCore.setAlpha(((int)((((float)v3)) * 0.65f)));
            arg9.drawPath(((W81)v2_1).a, this.neonCore);
        }

        arg9.restore();
    }

    public final void onMeasure(int arg4, int arg5) {
        arg4 = View$MeasureSpec.getSize(arg4);
        int v0 = ((int)((((float)arg4)) * 1.142857f));
        if(View$MeasureSpec.getMode(arg5) == 0x40000000) {
            v0 = View$MeasureSpec.getSize(arg5);
        }

        this.setMeasuredDimension(arg4, v0);
    }

    public void releaseVisualResources() {
        this.stopVisualAnimation();
        this.glowLayer.release();
        this.glowDirty = true;
    }

    private int renderedAlpha(int arg2) {
        if(Float.isNaN(this.modeSweepProgress)) {
            return this.e.get(arg2).b;
        }

        return ((int)(Math.max(0f, Math.min(1f, this.modeSweepProgress * (((float)this.e.size())) - (((float)arg2)))) * 255f));
    }

    public void setModeSweepProgress(float arg2) {
        arg2 = Math.max(0f, Math.min(1f, arg2));
        if(this.modeSweepProgress == arg2) {
            return;
        }

        this.modeSweepProgress = arg2;
        this.glowDirty = true;
        this.postInvalidateOnAnimation();
    }

    public void setProgress(float arg3) {
        arg3 = Math.max(0f, Math.min(1f, arg3));
        if(!this.progressAnimationEnabled) {
            this.l = arg3;
            this.setProgressInstant(arg3);
            return;
        }

        this.k = this.j;
        this.l = arg3;
        if(this.n != null) {
            Choreographer.getInstance().removeFrameCallback(this.n);
        }

        if((this.isAttachedToWindow()) && (this.isShown())) {
            if(this.j == arg3) {
            }
            else {
                this.m = SystemClock.uptimeMillis();
                this.n = new Choreographer$FrameCallback() {
                    public void doFrame(long arg4) {
                        if(RamIndicatorView.this.isAttachedToWindow()) {
                            if(!RamIndicatorView.this.isShown()) {
                            }
                            else {
                                float v4 = (((float)(SystemClock.uptimeMillis() - RamIndicatorView.this.m))) / 1000f;
                                int v5 = Float.compare(v4, 1f);
                                RamIndicatorView v0 = RamIndicatorView.this;
                                if(v5 >= 0) {
                                    v0.j = v0.l;
                                }
                                else {
                                    v0.j = v0.k + (RamIndicatorView.this.l - RamIndicatorView.this.k) * v4;
                                    Choreographer.getInstance().postFrameCallback(((Choreographer$FrameCallback)this));
                                }

                                RamIndicatorView.a(RamIndicatorView.this, RamIndicatorView.this.j);
                                return;
                            }
                        }

                        RamIndicatorView.this.n = null;
                    }
                };
                Choreographer.getInstance().postFrameCallback(this.n);
                return;
            }
        }

        this.n = null;
        this.j = arg3;
        RamIndicatorView.a(this, arg3);
    }

    public void setProgressAnimationEnabled(boolean arg2) {
        if(this.progressAnimationEnabled == arg2) {
        }
        else {
            this.progressAnimationEnabled = arg2;
            if(!arg2 && this.n != null) {
                this.setProgressInstant(this.l);
            }
        }
    }

    public void setProgressInstant(float arg3) {
        if(this.n != null) {
            Choreographer.getInstance().removeFrameCallback(this.n);
            this.n = null;
        }

        arg3 = Math.max(0f, Math.min(1f, arg3));
        if(this.j == arg3) {
            return;
        }

        this.j = arg3;
        RamIndicatorView.a(this, arg3);
    }

    public void stopVisualAnimation() {
        if(this.n != null) {
            Choreographer.getInstance().removeFrameCallback(this.n);
        }

        this.n = null;
        this.clearModeSweep();
    }
}

