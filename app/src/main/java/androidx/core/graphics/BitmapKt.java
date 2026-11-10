package androidx.core.graphics;

import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace$Named;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A)\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001A\u001D\u0010\u0007\u001A\u00020\b*\u00020\u00012\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0086\n\u001A\'\u0010\u000B\u001A\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\b\b\u0001\u0010\f\u001A\u00020\bH\u0086\n\u001A\'\u0010\r\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\b2\b\b\u0002\u0010\u0010\u001A\u00020\u0011H\u0086\b\u001A#\u0010\u0012\u001A\u00020\u00012\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\b2\b\b\u0002\u0010\u0013\u001A\u00020\u0014H\u0086\b\u001A7\u0010\u0012\u001A\u00020\u00012\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\b2\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u0015\u001A\u00020\u00112\b\b\u0002\u0010\u0016\u001A\u00020\u0017H\u0087\b\u001A\u0015\u0010\u0018\u001A\u00020\u0011*\u00020\u00012\u0006\u0010\u0019\u001A\u00020\u001AH\u0086\n\u001A\u0015\u0010\u0018\u001A\u00020\u0011*\u00020\u00012\u0006\u0010\u0019\u001A\u00020\u001BH\u0086\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001C"}, d2={"applyCanvas", "Landroid/graphics/Bitmap;", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "get", "", "x", "y", "set", "color", "scale", "width", "height", "filter", "", "createBitmap", "config", "Landroid/graphics/Bitmap$Config;", "hasAlpha", "colorSpace", "Landroid/graphics/ColorSpace;", "contains", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "block");
        arg2.invoke(new Canvas(arg1));
        return arg1;
    }

    public static final boolean contains(Bitmap arg2, Point arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "p");
        int v0 = arg2.getWidth();
        int v1 = arg3.x;
        if(v1 >= 0 && v1 < v0 && arg3.y >= 0 && arg3.y < arg2.getHeight()) {
            return 1;
        }

        return 0;
    }

    public static final boolean contains(Bitmap arg3, PointF arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "p");
        if(arg4.x >= 0f && arg4.x < (((float)arg3.getWidth())) && arg4.y >= 0f && arg4.y < (((float)arg3.getHeight()))) {
            return 1;
        }

        return 0;
    }

    public static final Bitmap createBitmap(int arg1, int arg2, Bitmap$Config arg3) {
        Intrinsics.checkNotNullParameter(arg3, "config");
        Bitmap v1 = Bitmap.createBitmap(arg1, arg2, arg3);
        Intrinsics.checkNotNullExpressionValue(v1, "createBitmap(...)");
        return v1;
    }

    public static final Bitmap createBitmap(int arg1, int arg2, Bitmap$Config arg3, boolean arg4, ColorSpace arg5) {
        Intrinsics.checkNotNullParameter(arg3, "config");
        Intrinsics.checkNotNullParameter(arg5, "colorSpace");
        Bitmap v1 = Bitmap.createBitmap(arg1, arg2, arg3, arg4, arg5);
        Intrinsics.checkNotNullExpressionValue(v1, "createBitmap(...)");
        return v1;
    }

    public static Bitmap createBitmap$default(int arg0, int arg1, Bitmap$Config arg2, int arg3, Object arg4) {
        if((arg3 & 4) != 0) {
            arg2 = Bitmap$Config.ARGB_8888;
        }

        Intrinsics.checkNotNullParameter(arg2, "config");
        Bitmap v0 = Bitmap.createBitmap(arg0, arg1, arg2);
        Intrinsics.checkNotNullExpressionValue(v0, "createBitmap(...)");
        return v0;
    }

    public static Bitmap createBitmap$default(int arg0, int arg1, Bitmap$Config arg2, boolean arg3, ColorSpace arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg2 = Bitmap$Config.ARGB_8888;
        }

        if((arg5 & 16) != 0) {
            arg4 = ColorSpace.get(ColorSpace$Named.SRGB);
            Intrinsics.checkNotNullExpressionValue(arg4, "get(...)");
        }

        Intrinsics.checkNotNullParameter(arg2, "config");
        Intrinsics.checkNotNullParameter(arg4, "colorSpace");
        Bitmap v0 = Bitmap.createBitmap(arg0, arg1, arg2, true, arg4);
        Intrinsics.checkNotNullExpressionValue(v0, "createBitmap(...)");
        return v0;
    }

    public static final int get(Bitmap arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getPixel(arg2, arg3);
    }

    public static final Bitmap scale(Bitmap arg1, int arg2, int arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = Bitmap.createScaledBitmap(arg1, arg2, arg3, arg4);
        Intrinsics.checkNotNullExpressionValue(arg1, "createScaledBitmap(...)");
        return arg1;
    }

    public static Bitmap scale$default(Bitmap arg0, int arg1, int arg2, boolean arg3, int arg4, Object arg5) {
        Intrinsics.checkNotNullParameter(arg0, "<this>");
        arg0 = Bitmap.createScaledBitmap(arg0, arg1, arg2, true);
        Intrinsics.checkNotNullExpressionValue(arg0, "createScaledBitmap(...)");
        return arg0;
    }

    public static final void set(Bitmap arg1, int arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.setPixel(arg2, arg3, arg4);
    }
}

