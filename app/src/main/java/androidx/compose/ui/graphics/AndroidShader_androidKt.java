package androidx.compose.ui.graphics;

import android.graphics.BitmapShader;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Build$VERSION;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AI\u0010\u0002\u001A\u00060\u0001j\u0002`\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\b2\u0006\u0010\f\u001A\u00020\rH\u0000¢\u0006\u0004\b\u000E\u0010\u000F\u001AI\u0010\u0010\u001A\u00060\u0001j\u0002`\u00032\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u000B2\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\b2\u0006\u0010\f\u001A\u00020\rH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001A9\u0010\u0015\u001A\u00060\u0001j\u0002`\u00032\u0006\u0010\u0011\u001A\u00020\u00052\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\bH\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001A+\u0010\u0018\u001A\u00060\u0001j\u0002`\u00032\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\r2\u0006\u0010\u001C\u001A\u00020\rH\u0000¢\u0006\u0004\b\u001D\u0010\u001E\u001A\u0016\u0010\u001F\u001A\u00020 2\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0001\u001A\u001E\u0010!\u001A\u00020\"2\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010#\u001A\u00020 H\u0001\u001A0\u0010$\u001A\u0004\u0018\u00010%2\u000E\u0010&\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\b2\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010#\u001A\u00020 H\u0001\u001A&\u0010\'\u001A\u00020(2\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\bH\u0002\u001A3\u0010)\u001A\u00060\u0001j\u0002`\u00032\n\u0010*\u001A\u00060\u0001j\u0002`\u00032\n\u0010+\u001A\u00060\u0001j\u0002`\u00032\u0006\u0010,\u001A\u00020-H\u0000¢\u0006\u0004\b.\u0010/*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u00060"}, d2={"Shader", "Landroid/graphics/Shader;", "ActualLinearGradientShader", "Landroidx/compose/ui/graphics/Shader;", "from", "Landroidx/compose/ui/geometry/Offset;", "to", "colors", "", "Landroidx/compose/ui/graphics/Color;", "colorStops", "", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "ActualLinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualRadialGradientShader", "center", "radius", "ActualRadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualSweepGradientShader", "ActualSweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "ActualImageShader", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "tileModeX", "tileModeY", "ActualImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "countTransparentColors", "", "makeTransparentColors", "", "numTransparentColors", "makeTransparentStops", "", "stops", "validateColorStops", "", "ActualCompositeShader", "dst", "src", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "ActualCompositeShader-7EN7VTw", "(Landroid/graphics/Shader;Landroid/graphics/Shader;I)Landroid/graphics/Shader;", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidShader_androidKt {
    public static final Shader ActualCompositeShader-7EN7VTw(Shader arg2, Shader arg3, int arg4) {
        if(Build$VERSION.SDK_INT >= 29) {
            return new ComposeShader(arg2, arg3, AndroidBlendMode_androidKt.toAndroidBlendMode-s9anfk8(arg4));
        }

        return new ComposeShader(arg2, arg3, AndroidBlendMode_androidKt.toPorterDuffMode-s9anfk8(arg4));
    }

    public static final Shader ActualImageShader-F49vj9s(ImageBitmap arg1, int arg2, int arg3) {
        return new BitmapShader(AndroidImageBitmap_androidKt.asAndroidBitmap(arg1), AndroidTileMode_androidKt.toAndroidTileMode-0vamqd0(arg2), AndroidTileMode_androidKt.toAndroidTileMode-0vamqd0(arg3));
    }

    public static final Shader ActualLinearGradientShader-VjE6UOU(long arg9, long arg11, List arg13, List arg14, int arg15) {
        AndroidShader_androidKt.validateColorStops(arg13, arg14);
        int v0 = AndroidShader_androidKt.countTransparentColors(arg13);
        return new LinearGradient(Float.intBitsToFloat(((int)(arg9 >> 0x20))), Float.intBitsToFloat(((int)(arg9 & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(arg11 >> 0x20))), Float.intBitsToFloat(((int)(arg11 & 0xFFFFFFFFL))), AndroidShader_androidKt.makeTransparentColors(arg13, v0), AndroidShader_androidKt.makeTransparentStops(arg14, arg13, v0), AndroidTileMode_androidKt.toAndroidTileMode-0vamqd0(arg15));
    }

    public static final Shader ActualRadialGradientShader-8uybcMk(long arg8, float arg10, List arg11, List arg12, int arg13) {
        AndroidShader_androidKt.validateColorStops(arg11, arg12);
        int v0 = AndroidShader_androidKt.countTransparentColors(arg11);
        return new RadialGradient(Float.intBitsToFloat(((int)(arg8 >> 0x20))), Float.intBitsToFloat(((int)(arg8 & 0xFFFFFFFFL))), arg10, AndroidShader_androidKt.makeTransparentColors(arg11, v0), AndroidShader_androidKt.makeTransparentStops(arg12, arg11, v0), AndroidTileMode_androidKt.toAndroidTileMode-0vamqd0(arg13));
    }

    public static final Shader ActualSweepGradientShader-9KIMszo(long arg5, List arg7, List arg8) {
        AndroidShader_androidKt.validateColorStops(arg7, arg8);
        int v0 = AndroidShader_androidKt.countTransparentColors(arg7);
        return new SweepGradient(Float.intBitsToFloat(((int)(arg5 >> 0x20))), Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL))), AndroidShader_androidKt.makeTransparentColors(arg7, v0), AndroidShader_androidKt.makeTransparentStops(arg8, arg7, v0));
    }

    public static final int countTransparentColors(List arg0) {
        return 0;
    }

    public static final int[] makeTransparentColors(List arg4, int arg5) {
        arg5 = arg4.size();
        int[] v0 = new int[arg5];
        int v1;
        for(v1 = 0; v1 < arg5; ++v1) {
            v0[v1] = ColorKt.toArgb-8_81llA(arg4.get(v1).unbox-impl());
        }

        return v0;
    }

    public static final float[] makeTransparentStops(List arg8, List arg9, int arg10) {
        if(arg10 == 0) {
            if(arg8 != null) {
                return CollectionsKt.toFloatArray(((Collection)arg8));
            }

            return null;
        }

        float[] v10 = new float[arg9.size() + arg10];
        float v2 = arg8 != null ? arg8.get(0).floatValue() : 0f;
        v10[0] = v2;
        int v1 = CollectionsKt.getLastIndex(arg9);
        int v2_1 = 1;
        int v3 = 1;
        while(v2_1 < v1) {
            long v4 = arg9.get(v2_1).unbox-impl();
            float v6 = arg8 != null ? arg8.get(v2_1).floatValue() : (((float)v2_1)) / (((float)CollectionsKt.getLastIndex(arg9)));
            int v7 = v3 + 1;
            v10[v3] = v6;
            if(Color.getAlpha-impl(v4) == 0f) {
                v3 += 2;
                v10[v7] = v6;
            }
            else {
                v3 = v7;
            }

            ++v2_1;
        }

        float v8 = arg8 != null ? arg8.get(CollectionsKt.getLastIndex(arg9)).floatValue() : 1f;
        v10[v3] = v8;
        return v10;
    }

    private static final void validateColorStops(List arg0, List arg1) {
        if(arg1 != null) {
            if(arg0.size() == arg1.size()) {
                return;
            }

            goto label_13;
        }
        else if(arg0.size() >= 2) {
        }
        else {
            throw new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
        }

        return;
    label_13:
        throw new IllegalArgumentException("colors and colorStops arguments must have equal length.");
    }
}

