package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0011\u0010\u0011\u001A\u00020\u000E*\u00020\u0005H\u0001¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2={"Landroidx/compose/ui/graphics/Api26Bitmap;", "", "<init>", "()V", "createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "bitmapConfig", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "createBitmap-x__-hDU$ui_graphics", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroid/graphics/Bitmap;", "composeColorSpace", "composeColorSpace$ui_graphics", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Api26Bitmap {
    public static final int $stable;
    public static final Api26Bitmap INSTANCE;

    static {
        Api26Bitmap.INSTANCE = new Api26Bitmap();
    }

    private Api26Bitmap() {
        super();
    }

    @JvmStatic public static final ColorSpace composeColorSpace$ui_graphics(Bitmap arg0) {
        android.graphics.ColorSpace v0 = arg0.getColorSpace();
        if(v0 != null) {
            ColorSpace v0_1 = AndroidColorSpace_androidKt.toComposeColorSpace(v0);
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        return ColorSpaces.INSTANCE.getSrgb();
    }

    @JvmStatic public static final Bitmap createBitmap-x__-hDU$ui_graphics(int arg6, int arg7, int arg8, boolean arg9, ColorSpace arg10) {
        return Bitmap.createBitmap(null, arg6, arg7, AndroidImageBitmap_androidKt.toBitmapConfig-1JJdX4A(arg8), arg9, AndroidColorSpace_androidKt.toAndroidColorSpace(arg10));
    }
}

