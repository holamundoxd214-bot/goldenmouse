package androidx.compose.ui.graphics;

import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build$VERSION;
import kotlin.Metadata;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0002\u001A\n\u0010\u0002\u001A\u00020\u0001*\u00020\u0003\u001A\n\u0010\u0004\u001A\u00020\u0003*\u00020\u0001\u001A#\u0010\u0005\u001A\u00060\u0001j\u0002`\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0000¢\u0006\u0004\b\u000B\u0010\f\u001A\u001B\u0010\r\u001A\u00060\u0001j\u0002`\u00062\u0006\u0010\u000E\u001A\u00020\u000FH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001A#\u0010\u0012\u001A\u00060\u0001j\u0002`\u00062\u0006\u0010\u0013\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\bH\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001A\u0019\u0010\u0017\u001A\u00020\u000F2\n\u0010\u0018\u001A\u00060\u0001j\u0002`\u0006H\u0000¢\u0006\u0002\u0010\u0019\u001A\b\u0010\u001A\u001A\u00020\u001BH\u0000\u001A\b\u0010\u001C\u001A\u00020\u001BH\u0000*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u001D"}, d2={"NativeColorFilter", "Landroid/graphics/ColorFilter;", "asAndroidColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "asComposeColorFilter", "actualTintColorFilter", "Landroidx/compose/ui/graphics/NativeColorFilter;", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "actualTintColorFilter-xETnrds", "(JI)Landroid/graphics/ColorFilter;", "actualColorMatrixColorFilter", "colorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "actualColorMatrixColorFilter-jHG-Opc", "([F)Landroid/graphics/ColorFilter;", "actualLightingColorFilter", "multiply", "add", "actualLightingColorFilter--OWjLjI", "(JJ)Landroid/graphics/ColorFilter;", "actualColorMatrixFromFilter", "filter", "(Landroid/graphics/ColorFilter;)[F", "supportsColorMatrixQuery", "", "supportsLightingColorFilterQuery", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidColorFilter_androidKt {
    public static final ColorFilter actualColorMatrixColorFilter-jHG-Opc(float[] arg1) {
        return new ColorMatrixColorFilter(arg1);
    }

    public static final float[] actualColorMatrixFromFilter(ColorFilter arg1) {
        if(((arg1 instanceof ColorMatrixColorFilter)) && (AndroidColorFilter_androidKt.supportsColorMatrixQuery())) {
            return ColorMatrixFilterHelper.INSTANCE.getColorMatrix-8unuwjk(((ColorMatrixColorFilter)arg1));
        }

        throw new IllegalArgumentException("Unable to obtain ColorMatrix from Android ColorMatrixColorFilter. This method was invoked on an unsupported Android version");
    }

    public static final ColorFilter actualLightingColorFilter--OWjLjI(long arg1, long arg3) {
        return new LightingColorFilter(ColorKt.toArgb-8_81llA(arg1), ColorKt.toArgb-8_81llA(arg3));
    }

    public static final ColorFilter actualTintColorFilter-xETnrds(long arg2, int arg4) {
        if(Build$VERSION.SDK_INT >= 29) {
            return BlendModeColorFilterHelper.INSTANCE.BlendModeColorFilter-xETnrds(arg2, arg4);
        }

        return new PorterDuffColorFilter(ColorKt.toArgb-8_81llA(arg2), AndroidBlendMode_androidKt.toPorterDuffMode-s9anfk8(arg4));
    }

    public static final ColorFilter asAndroidColorFilter(androidx.compose.ui.graphics.ColorFilter arg0) {
        return arg0.getNativeColorFilter$ui_graphics();
    }

    public static final androidx.compose.ui.graphics.ColorFilter asComposeColorFilter(ColorFilter arg8) {
        if(29 <= Build$VERSION.SDK_INT && ((arg8 instanceof BlendModeColorFilter))) {
            return BlendModeColorFilterHelper.INSTANCE.createBlendModeColorFilter(((BlendModeColorFilter)arg8));
        }

        if(((arg8 instanceof LightingColorFilter)) && (AndroidColorFilter_androidKt.supportsLightingColorFilterQuery())) {
            return new androidx.compose.ui.graphics.LightingColorFilter(ColorKt.Color(arg8.getColorMultiply()), ColorKt.Color(arg8.getColorAdd()), arg8, null);
        }

        ColorFilter v6 = arg8;
        if(((v6 instanceof ColorMatrixColorFilter)) && (AndroidColorFilter_androidKt.supportsColorMatrixQuery())) {
            return new androidx.compose.ui.graphics.ColorMatrixColorFilter(null, v6, null);
        }

        return new androidx.compose.ui.graphics.ColorFilter(v6);
    }

    public static final boolean supportsColorMatrixQuery() {
        return 1;
    }

    public static final boolean supportsLightingColorFilterQuery() {
        return 1;
    }
}

