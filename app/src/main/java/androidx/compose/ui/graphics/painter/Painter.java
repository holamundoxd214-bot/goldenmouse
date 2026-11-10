package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\b\'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0005H\u0002J\u0012\u0010\u000B\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000F\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0002J\u0010\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u0011H\u0002J\f\u0010\u001C\u001A\u00020\f*\u00020\u0016H$J\u0010\u0010\u001D\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u000EH\u0014J\u0012\u0010\u001E\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u001F\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u0011H\u0014J/\u0010 \u001A\u00020\f*\u00020\u00162\u0006\u0010!\u001A\u00020\u00192\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\"\u0010#R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u001F\u0010\u0014\u001A\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u0015¢\u0006\u0002\b\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001A\u00020\u0019X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001B¨\u0006$"}, d2={"Landroidx/compose/ui/graphics/painter/Painter;", "", "<init>", "()V", "layerPaint", "Landroidx/compose/ui/graphics/Paint;", "obtainPaint", "useLayer", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "configureColorFilter", "", "alpha", "", "configureAlpha", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "configureLayoutDirection", "rtl", "drawLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "onDraw", "applyAlpha", "applyColorFilter", "applyLayoutDirection", "draw", "size", "draw-x_KDEd0", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/ui/graphics/ColorFilter;)V", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class Painter {
    public static final int $stable = 8;
    private float alpha;
    private ColorFilter colorFilter;
    private final Function1 drawLambda;
    private Paint layerPaint;
    private LayoutDirection layoutDirection;
    private boolean useLayer;

    static {
    }

    public Painter() {
        super();
        this.alpha = 1f;
        this.layoutDirection = LayoutDirection.Ltr;
        this.drawLambda = new Painter$drawLambda$1(this);
    }

    protected boolean applyAlpha(float arg1) {
        return 0;
    }

    protected boolean applyColorFilter(ColorFilter arg1) {
        return 0;
    }

    protected boolean applyLayoutDirection(LayoutDirection arg1) {
        return 0;
    }

    private final void configureAlpha(float arg2) {
        if(this.alpha == arg2) {
            return;
        }

        if(!this.applyAlpha(arg2)) {
            if(arg2 == 1f) {
                Paint v0 = this.layerPaint;
                if(v0 != null) {
                    v0.setAlpha(arg2);
                }

                this.useLayer = false;
            }
            else {
                this.obtainPaint().setAlpha(arg2);
                this.useLayer = true;
            }
        }

        this.alpha = arg2;
    }

    private final void configureColorFilter(ColorFilter arg3) {
        if(!Intrinsics.areEqual(this.colorFilter, arg3)) {
            if(!this.applyColorFilter(arg3)) {
                if(arg3 == null) {
                    Paint v0 = this.layerPaint;
                    if(v0 != null) {
                        v0.setColorFilter(null);
                    }

                    this.useLayer = false;
                }
                else {
                    this.obtainPaint().setColorFilter(arg3);
                    this.useLayer = true;
                }
            }

            this.colorFilter = arg3;
        }
    }

    private final void configureLayoutDirection(LayoutDirection arg2) {
        if(this.layoutDirection != arg2) {
            this.applyLayoutDirection(arg2);
            this.layoutDirection = arg2;
        }
    }

    public final void draw-x_KDEd0(DrawScope arg11, long arg12, float arg14, ColorFilter arg15) {
        Paint v15_1;
        Canvas v13_1;
        Rect v12_1;
        this.configureAlpha(arg14);
        this.configureColorFilter(arg15);
        this.configureLayoutDirection(arg11.getLayoutDirection());
        int v15 = 0x20;
        int v1 = ((int)(arg12 >> v15));
        float v0 = Float.intBitsToFloat(((int)(arg11.getSize-NH-jbRc() >> v15))) - Float.intBitsToFloat(v1);
        long v4 = 0xFFFFFFFFL;
        int v12 = ((int)(arg12 & v4));
        float v2 = Float.intBitsToFloat(((int)(arg11.getSize-NH-jbRc() & v4))) - Float.intBitsToFloat(v12);
        arg11.getDrawContext().getTransform().inset(0f, 0f, v0, v2);
        int v13 = Float.compare(arg14, 0f);
        arg14 = -0f;
        if(v13 > 0) {
            try {
                if(Float.intBitsToFloat(v1) > 0f && Float.intBitsToFloat(v12) > 0f) {
                    if(this.useLayer) {
                        v12_1 = RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), Size.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(v12)))) & v4 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(v1)))) << v15));
                        v13_1 = arg11.getDrawContext().getCanvas();
                        v15_1 = this.obtainPaint();
                        goto label_51;
                    }
                    else {
                        goto label_58;
                    }
                }

                goto label_67;
            }
            catch(Throwable v10) {
                goto label_65;
            }

            try {
            label_51:
                v13_1.saveLayer(v12_1, v15_1);
                this.onDraw(arg11);
                goto label_53;
            }
            catch(Throwable v10) {
                try {
                    v13_1.restore();
                    throw v10;
                label_53:
                    v13_1.restore();
                    goto label_67;
                label_58:
                    this.onDraw(arg11);
                }
                catch(Throwable v10) {
                label_65:
                    arg11.getDrawContext().getTransform().inset(arg14, arg14, -v0, -v2);
                    throw v10;
                }
            }
        }

    label_67:
        arg11.getDrawContext().getTransform().inset(arg14, arg14, -v0, -v2);
    }

    public static void draw-x_KDEd0$default(Painter arg6, DrawScope arg7, long arg8, float arg10, ColorFilter arg11, int arg12, Object arg13) {
        if(arg13 == null) {
            if((arg12 & 2) != 0) {
                arg10 = 1f;
            }

            float v4 = arg10;
            if((arg12 & 4) != 0) {
                arg11 = null;
            }

            arg6.draw-x_KDEd0(arg7, arg8, v4, arg11);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: draw-x_KDEd0");
    }

    public abstract long getIntrinsicSize-NH-jbRc();

    private final Paint obtainPaint() {
        Paint v0 = this.layerPaint;
        if(v0 == null) {
            v0 = AndroidPaint_androidKt.Paint();
            this.layerPaint = v0;
        }

        return v0;
    }

    protected abstract void onDraw(DrawScope arg1);
}

