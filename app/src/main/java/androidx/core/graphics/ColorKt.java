package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace$Named;
import android.graphics.ColorSpace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\n\u001A\r\u0010\u0003\u001A\u00020\u0001*\u00020\u0002H\u0087\n\u001A\r\u0010\u0004\u001A\u00020\u0001*\u00020\u0002H\u0087\n\u001A\r\u0010\u0005\u001A\u00020\u0001*\u00020\u0002H\u0087\n\u001A\u0015\u0010\u0006\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0002H\u0087\u0002\u001A\r\u0010\u0000\u001A\u00020\t*\u00020\tH\u0086\n\u001A\r\u0010\u0003\u001A\u00020\t*\u00020\tH\u0086\n\u001A\r\u0010\u0004\u001A\u00020\t*\u00020\tH\u0086\n\u001A\r\u0010\u0005\u001A\u00020\t*\u00020\tH\u0086\n\u001A\r\u0010\u0015\u001A\u00020\u0002*\u00020\tH\u0087\b\u001A\r\u0010\u0016\u001A\u00020\u0017*\u00020\tH\u0087\b\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0017H\u0087\n\u001A\r\u0010\u0003\u001A\u00020\u0001*\u00020\u0017H\u0087\n\u001A\r\u0010\u0004\u001A\u00020\u0001*\u00020\u0017H\u0087\n\u001A\r\u0010\u0005\u001A\u00020\u0001*\u00020\u0017H\u0087\n\u001A\r\u0010\u0015\u001A\u00020\u0002*\u00020\u0017H\u0087\b\u001A\r\u0010\u0019\u001A\u00020\t*\u00020\u0017H\u0087\b\u001A\u0015\u0010\"\u001A\u00020\u0017*\u00020\t2\u0006\u0010\u001E\u001A\u00020#H\u0087\f\u001A\u0015\u0010\"\u001A\u00020\u0017*\u00020\t2\u0006\u0010\u001E\u001A\u00020\u001FH\u0087\f\u001A\u0015\u0010\"\u001A\u00020\u0017*\u00020\u00172\u0006\u0010\u001E\u001A\u00020#H\u0087\f\u001A\u0015\u0010\"\u001A\u00020\u0017*\u00020\u00172\u0006\u0010\u001E\u001A\u00020\u001FH\u0087\f\u001A\u0015\u0010\"\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u001E\u001A\u00020#H\u0087\f\u001A\u0015\u0010\"\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u001E\u001A\u00020\u001FH\u0087\f\u001A\r\u0010\u0019\u001A\u00020\t*\u00020$H\u0087\b\"\u0016\u0010\b\u001A\u00020\t*\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B\"\u0016\u0010\f\u001A\u00020\t*\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\r\u0010\u000B\"\u0016\u0010\u000E\u001A\u00020\t*\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u000B\"\u0016\u0010\u0010\u001A\u00020\t*\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000B\"\u0016\u0010\u0012\u001A\u00020\u0001*\u00020\t8Ç\u0002¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014\"\u0016\u0010\b\u001A\u00020\u0001*\u00020\u00178Ç\u0002¢\u0006\u0006\u001A\u0004\b\n\u0010\u0018\"\u0016\u0010\f\u001A\u00020\u0001*\u00020\u00178Ç\u0002¢\u0006\u0006\u001A\u0004\b\r\u0010\u0018\"\u0016\u0010\u000E\u001A\u00020\u0001*\u00020\u00178Ç\u0002¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0018\"\u0016\u0010\u0010\u001A\u00020\u0001*\u00020\u00178Ç\u0002¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0018\"\u0016\u0010\u0012\u001A\u00020\u0001*\u00020\u00178Ç\u0002¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0018\"\u0016\u0010\u001A\u001A\u00020\u001B*\u00020\u00178Ç\u0002¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001C\"\u0016\u0010\u001D\u001A\u00020\u001B*\u00020\u00178Ç\u0002¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001C\"\u0016\u0010\u001E\u001A\u00020\u001F*\u00020\u00178Ç\u0002¢\u0006\u0006\u001A\u0004\b \u0010!¨\u0006%"}, d2={"component1", "", "Landroid/graphics/Color;", "component2", "component3", "component4", "plus", "c", "alpha", "", "getAlpha", "(I)I", "red", "getRed", "green", "getGreen", "blue", "getBlue", "luminance", "getLuminance", "(I)F", "toColor", "toColorLong", "", "(J)F", "toColorInt", "isSrgb", "", "(J)Z", "isWideGamut", "colorSpace", "Landroid/graphics/ColorSpace;", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "convertTo", "Landroid/graphics/ColorSpace$Named;", "", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ColorKt {
    public static final float component1(long arg0) {
        return Color.red(arg0);
    }

    public static final float component1(Color arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getComponent(0);
    }

    public static final int component1(int arg0) {
        return arg0 >> 24 & 0xFF;
    }

    public static final float component2(long arg0) {
        return Color.green(arg0);
    }

    public static final float component2(Color arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getComponent(1);
    }

    public static final int component2(int arg0) {
        return arg0 >> 16 & 0xFF;
    }

    public static final float component3(long arg0) {
        return Color.blue(arg0);
    }

    public static final float component3(Color arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getComponent(2);
    }

    public static final int component3(int arg0) {
        return arg0 >> 8 & 0xFF;
    }

    public static final float component4(long arg0) {
        return Color.alpha(arg0);
    }

    public static final float component4(Color arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getComponent(3);
    }

    public static final int component4(int arg0) {
        return arg0 & 0xFF;
    }

    public static final long convertTo(int arg1, ColorSpace$Named arg2) {
        Intrinsics.checkNotNullParameter(arg2, "colorSpace");
        return Color.convert(arg1, ColorSpace.get(arg2));
    }

    public static final long convertTo(int arg1, ColorSpace arg2) {
        Intrinsics.checkNotNullParameter(arg2, "colorSpace");
        return Color.convert(arg1, arg2);
    }

    public static final long convertTo(long arg1, ColorSpace$Named arg3) {
        Intrinsics.checkNotNullParameter(arg3, "colorSpace");
        return Color.convert(arg1, ColorSpace.get(arg3));
    }

    public static final long convertTo(long arg1, ColorSpace arg3) {
        Intrinsics.checkNotNullParameter(arg3, "colorSpace");
        return Color.convert(arg1, arg3);
    }

    public static final Color convertTo(Color arg1, ColorSpace$Named arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "colorSpace");
        arg1 = arg1.convert(ColorSpace.get(arg2));
        Intrinsics.checkNotNullExpressionValue(arg1, "convert(...)");
        return arg1;
    }

    public static final Color convertTo(Color arg1, ColorSpace arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "colorSpace");
        arg1 = arg1.convert(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "convert(...)");
        return arg1;
    }

    public static final float getAlpha(long arg0) {
        return Color.alpha(arg0);
    }

    public static final int getAlpha(int arg0) {
        return arg0 >> 24 & 0xFF;
    }

    public static final float getBlue(long arg0) {
        return Color.blue(arg0);
    }

    public static final int getBlue(int arg0) {
        return arg0 & 0xFF;
    }

    public static final ColorSpace getColorSpace(long arg0) {
        ColorSpace v0 = Color.colorSpace(arg0);
        Intrinsics.checkNotNullExpressionValue(v0, "colorSpace(...)");
        return v0;
    }

    public static final float getGreen(long arg0) {
        return Color.green(arg0);
    }

    public static final int getGreen(int arg0) {
        return arg0 >> 8 & 0xFF;
    }

    public static final float getLuminance(int arg0) {
        return Color.luminance(arg0);
    }

    public static final float getLuminance(long arg0) {
        return Color.luminance(arg0);
    }

    public static final float getRed(long arg0) {
        return Color.red(arg0);
    }

    public static final int getRed(int arg0) {
        return arg0 >> 16 & 0xFF;
    }

    public static final boolean isSrgb(long arg0) {
        return Color.isSrgb(arg0);
    }

    public static final boolean isWideGamut(long arg0) {
        return Color.isWideGamut(arg0);
    }

    public static final Color plus(Color arg1, Color arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "c");
        arg1 = ColorUtils.compositeColors(arg2, arg1);
        Intrinsics.checkNotNullExpressionValue(arg1, "compositeColors(...)");
        return arg1;
    }

    public static final Color toColor(int arg1) {
        Color v1 = Color.valueOf(arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "valueOf(...)");
        return v1;
    }

    public static final Color toColor(long arg0) {
        Color v0 = Color.valueOf(arg0);
        Intrinsics.checkNotNullExpressionValue(v0, "valueOf(...)");
        return v0;
    }

    public static final int toColorInt(long arg0) {
        return Color.toArgb(arg0);
    }

    public static final int toColorInt(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Color.parseColor(arg1);
    }

    public static final long toColorLong(int arg2) {
        return Color.pack(arg2);
    }
}

