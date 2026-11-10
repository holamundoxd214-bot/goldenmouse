package androidx.compose.ui.graphics;

import android.graphics.Paint$Cap;
import android.graphics.Paint$Join;
import android.graphics.Paint$Style;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build$VERSION;
import kotlin.Metadata;

@Metadata(d1={"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0006\u0010\u0002\u001A\u00020\u0003\u001A\n\u0010\u0004\u001A\u00020\u0003*\u00020\u0001\u001A\b\u0010\u0005\u001A\u00020\u0001H\u0000\u001A\u001F\u0010\u0006\u001A\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\t\u001A\u00020\nH\u0000¢\u0006\u0004\b\u000B\u0010\f\u001A\u001A\u0010\r\u001A\u00020\u0007*\u00060\u0001j\u0002`\b2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0000\u001A\u0010\u0010\u0010\u001A\u00020\u0011*\u00060\u0001j\u0002`\bH\u0000\u001A\u0018\u0010\u0012\u001A\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000E\u001A\u00020\u0011H\u0000\u001A\u0010\u0010\u0013\u001A\u00020\u0014*\u00060\u0001j\u0002`\bH\u0000\u001A\u0018\u0010\u0015\u001A\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000E\u001A\u00020\u0014H\u0000\u001A\u0015\u0010\u0016\u001A\u00020\u0017*\u00060\u0001j\u0002`\bH\u0000¢\u0006\u0002\u0010\u0018\u001A\u001F\u0010\u0019\u001A\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000E\u001A\u00020\u0017H\u0000¢\u0006\u0004\b\u001A\u0010\u001B\u001A\u001F\u0010\u001C\u001A\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000E\u001A\u00020\u001DH\u0000¢\u0006\u0004\b\u001E\u0010\f\u001A\u0015\u0010\u001F\u001A\u00020\u001D*\u00060\u0001j\u0002`\bH\u0000¢\u0006\u0002\u0010 \u001A\u0010\u0010!\u001A\u00020\u0011*\u00060\u0001j\u0002`\bH\u0000\u001A\u0018\u0010\"\u001A\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000E\u001A\u00020\u0011H\u0000\u001A\u0015\u0010#\u001A\u00020$*\u00060\u0001j\u0002`\bH\u0000¢\u0006\u0002\u0010 \u001A\u001F\u0010%\u001A\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000E\u001A\u00020$H\u0000¢\u0006\u0004\b&\u0010\f\u001A\u0015\u0010\'\u001A\u00020(*\u00060\u0001j\u0002`\bH\u0000¢\u0006\u0002\u0010 \u001A\u001F\u0010)\u001A\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000E\u001A\u00020(H\u0000¢\u0006\u0004\b*\u0010\f\u001A\u0010\u0010+\u001A\u00020\u0011*\u00060\u0001j\u0002`\bH\u0000\u001A\u0018\u0010,\u001A\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000E\u001A\u00020\u0011H\u0000\u001A\u0015\u0010-\u001A\u00020.*\u00060\u0001j\u0002`\bH\u0000¢\u0006\u0002\u0010 \u001A\u001F\u0010/\u001A\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000E\u001A\u00020.H\u0000¢\u0006\u0004\b0\u0010\f\u001A \u00101\u001A\u00020\u0007*\u00060\u0001j\u0002`\b2\u000E\u0010\u000E\u001A\n\u0018\u000102j\u0004\u0018\u0001`3H\u0000\u001A\u001A\u00104\u001A\u00020\u0007*\u00060\u0001j\u0002`\b2\b\u0010\u000E\u001A\u0004\u0018\u000105H\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u00066"}, d2={"NativePaint", "Landroid/graphics/Paint;", "Paint", "Landroidx/compose/ui/graphics/Paint;", "asComposePaint", "makeNativePaint", "setNativeBlendMode", "", "Landroidx/compose/ui/graphics/NativePaint;", "mode", "Landroidx/compose/ui/graphics/BlendMode;", "setNativeBlendMode-GB0RdKg", "(Landroid/graphics/Paint;I)V", "setNativeColorFilter", "value", "Landroidx/compose/ui/graphics/ColorFilter;", "getNativeAlpha", "", "setNativeAlpha", "getNativeAntiAlias", "", "setNativeAntiAlias", "getNativeColor", "Landroidx/compose/ui/graphics/Color;", "(Landroid/graphics/Paint;)J", "setNativeColor", "setNativeColor-4WTKRHQ", "(Landroid/graphics/Paint;J)V", "setNativeStyle", "Landroidx/compose/ui/graphics/PaintingStyle;", "setNativeStyle--5YerkU", "getNativeStyle", "(Landroid/graphics/Paint;)I", "getNativeStrokeWidth", "setNativeStrokeWidth", "getNativeStrokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "setNativeStrokeCap", "setNativeStrokeCap-CSYIeUk", "getNativeStrokeJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "setNativeStrokeJoin", "setNativeStrokeJoin-kLtJ_vA", "getNativeStrokeMiterLimit", "setNativeStrokeMiterLimit", "getNativeFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "setNativeFilterQuality", "setNativeFilterQuality-50PEsBU", "setNativeShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "setNativePathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidPaint_androidKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Paint$Style.values().length];
            try {
                v0[Paint$Style.STROKE.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
            label_7:
                WhenMappings.$EnumSwitchMapping$0 = v0;
                v0 = new int[Paint$Cap.values().length];
                try {
                    v0[Paint$Cap.BUTT.ordinal()] = 1;
                    goto label_14;
                }
                catch(NoSuchFieldError ) {
                label_14:
                    int v2 = 2;
                    try {
                        v0[Paint$Cap.ROUND.ordinal()] = v2;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                    label_18:
                        int v3 = 3;
                        try {
                            v0[Paint$Cap.SQUARE.ordinal()] = v3;
                            goto label_22;
                        }
                        catch(NoSuchFieldError ) {
                        label_22:
                            WhenMappings.$EnumSwitchMapping$1 = v0;
                            v0 = new int[Paint$Join.values().length];
                            try {
                                v0[Paint$Join.MITER.ordinal()] = 1;
                                goto label_29;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_29:
                                    v0[Paint$Join.BEVEL.ordinal()] = v2;
                                    goto label_32;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_32:
                                        v0[Paint$Join.ROUND.ordinal()] = v3;
                                        goto label_35;
                                    }
                                    catch(NoSuchFieldError ) {
                                    label_35:
                                        WhenMappings.$EnumSwitchMapping$2 = v0;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final Paint Paint() {
        return new AndroidPaint();
    }

    public static final Paint asComposePaint(android.graphics.Paint arg1) {
        return new AndroidPaint(arg1);
    }

    public static final float getNativeAlpha(android.graphics.Paint arg1) {
        return (((float)arg1.getAlpha())) / 255f;
    }

    public static final boolean getNativeAntiAlias(android.graphics.Paint arg0) {
        return arg0.isAntiAlias();
    }

    public static final long getNativeColor(android.graphics.Paint arg2) {
        return ColorKt.Color(arg2.getColor());
    }

    public static final int getNativeFilterQuality(android.graphics.Paint arg0) {
        if(!arg0.isFilterBitmap()) {
            return FilterQuality.Companion.getNone-f-v9h1I();
        }

        return FilterQuality.Companion.getLow-f-v9h1I();
    }

    public static final int getNativeStrokeCap(android.graphics.Paint arg1) {
        Paint$Cap v1 = arg1.getStrokeCap();
        int v1_1 = v1 == null ? -1 : WhenMappings.$EnumSwitchMapping$1[v1.ordinal()];
        if(v1_1 != 1) {
            if(v1_1 != 2) {
                if(v1_1 != 3) {
                    return StrokeCap.Companion.getButt-KaPHkGw();
                }

                return StrokeCap.Companion.getSquare-KaPHkGw();
            }

            return StrokeCap.Companion.getRound-KaPHkGw();
        }

        return StrokeCap.Companion.getButt-KaPHkGw();
    }

    public static final int getNativeStrokeJoin(android.graphics.Paint arg1) {
        Paint$Join v1 = arg1.getStrokeJoin();
        int v1_1 = v1 == null ? -1 : WhenMappings.$EnumSwitchMapping$2[v1.ordinal()];
        if(v1_1 != 1) {
            if(v1_1 != 2) {
                if(v1_1 != 3) {
                    return StrokeJoin.Companion.getMiter-LxFBmk8();
                }

                return StrokeJoin.Companion.getRound-LxFBmk8();
            }

            return StrokeJoin.Companion.getBevel-LxFBmk8();
        }

        return StrokeJoin.Companion.getMiter-LxFBmk8();
    }

    public static final float getNativeStrokeMiterLimit(android.graphics.Paint arg0) {
        return arg0.getStrokeMiter();
    }

    public static final float getNativeStrokeWidth(android.graphics.Paint arg0) {
        return arg0.getStrokeWidth();
    }

    public static final int getNativeStyle(android.graphics.Paint arg1) {
        Paint$Style v1 = arg1.getStyle();
        int v1_1 = v1 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[v1.ordinal()];
        if(v1_1 == 1) {
            return PaintingStyle.Companion.getStroke-TiuSbCo();
        }

        return PaintingStyle.Companion.getFill-TiuSbCo();
    }

    public static final android.graphics.Paint makeNativePaint() {
        return new android.graphics.Paint(7);
    }

    public static final void setNativeAlpha(android.graphics.Paint arg2, float arg3) {
        arg2.setAlpha(((int)(((float)Math.rint(((double)(arg3 * 255f)))))));
    }

    public static final void setNativeAntiAlias(android.graphics.Paint arg0, boolean arg1) {
        arg0.setAntiAlias(arg1);
    }

    public static final void setNativeBlendMode-GB0RdKg(android.graphics.Paint arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            WrapperVerificationHelperMethods.INSTANCE.setBlendMode-GB0RdKg(arg2, arg3);
            return;
        }

        arg2.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.toPorterDuffMode-s9anfk8(arg3)));
    }

    public static final void setNativeColor-4WTKRHQ(android.graphics.Paint arg0, long arg1) {
        arg0.setColor(ColorKt.toArgb-8_81llA(arg1));
    }

    public static final void setNativeColorFilter(android.graphics.Paint arg0, ColorFilter arg1) {
        android.graphics.ColorFilter v1 = arg1 != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(arg1) : null;
        arg0.setColorFilter(v1);
    }

    public static final void setNativeFilterQuality-50PEsBU(android.graphics.Paint arg1, int arg2) {
        arg1.setFilterBitmap(FilterQuality.equals-impl0(arg2, FilterQuality.Companion.getNone-f-v9h1I()) ^ 1);
    }

    public static final void setNativePathEffect(android.graphics.Paint arg0, PathEffect arg1) {
        android.graphics.PathEffect v1 = arg1 != null ? ((AndroidPathEffect)arg1).getNativePathEffect() : null;
        arg0.setPathEffect(v1);
    }

    public static final void setNativeShader(android.graphics.Paint arg0, Shader arg1) {
        arg0.setShader(arg1);
    }

    public static final void setNativeStrokeCap-CSYIeUk(android.graphics.Paint arg1, int arg2) {
        Paint$Cap v2;
        if(StrokeCap.equals-impl0(arg2, StrokeCap.Companion.getSquare-KaPHkGw())) {
            v2 = Paint$Cap.SQUARE;
        }
        else if(StrokeCap.equals-impl0(arg2, StrokeCap.Companion.getRound-KaPHkGw())) {
            v2 = Paint$Cap.ROUND;
        }
        else if(StrokeCap.equals-impl0(arg2, StrokeCap.Companion.getButt-KaPHkGw())) {
            v2 = Paint$Cap.BUTT;
        }
        else {
            v2 = Paint$Cap.BUTT;
        }

        arg1.setStrokeCap(v2);
    }

    public static final void setNativeStrokeJoin-kLtJ_vA(android.graphics.Paint arg1, int arg2) {
        Paint$Join v2;
        if(StrokeJoin.equals-impl0(arg2, StrokeJoin.Companion.getMiter-LxFBmk8())) {
            v2 = Paint$Join.MITER;
        }
        else if(StrokeJoin.equals-impl0(arg2, StrokeJoin.Companion.getBevel-LxFBmk8())) {
            v2 = Paint$Join.BEVEL;
        }
        else if(StrokeJoin.equals-impl0(arg2, StrokeJoin.Companion.getRound-LxFBmk8())) {
            v2 = Paint$Join.ROUND;
        }
        else {
            v2 = Paint$Join.MITER;
        }

        arg1.setStrokeJoin(v2);
    }

    public static final void setNativeStrokeMiterLimit(android.graphics.Paint arg0, float arg1) {
        arg0.setStrokeMiter(arg1);
    }

    public static final void setNativeStrokeWidth(android.graphics.Paint arg0, float arg1) {
        arg0.setStrokeWidth(arg1);
    }

    public static final void setNativeStyle--5YerkU(android.graphics.Paint arg1, int arg2) {
        Paint$Style v2 = PaintingStyle.equals-impl0(arg2, PaintingStyle.Companion.getStroke-TiuSbCo()) ? Paint$Style.STROKE : Paint$Style.FILL;
        arg1.setStyle(v2);
    }
}

