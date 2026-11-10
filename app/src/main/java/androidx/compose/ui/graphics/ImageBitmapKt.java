package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\u001AP\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00042\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u00042\b\b\u0002\u0010\u000B\u001A\u00020\u0004\u001A;\u0010\f\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00042\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014\u001A\n\u0010\u0015\u001A\u00020\u0002*\u00020\u0016¨\u0006\u0017"}, d2={"toPixelMap", "Landroidx/compose/ui/graphics/PixelMap;", "Landroidx/compose/ui/graphics/ImageBitmap;", "startX", "", "startY", "width", "height", "buffer", "", "bufferOffset", "stride", "ImageBitmap", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "decodeToImageBitmap", "", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ImageBitmapKt {
    public static final ImageBitmap ImageBitmap-x__-hDU(int arg0, int arg1, int arg2, boolean arg3, ColorSpace arg4) {
        return AndroidImageBitmap_androidKt.ActualImageBitmap-x__-hDU(arg0, arg1, arg2, arg3, arg4);
    }

    public static ImageBitmap ImageBitmap-x__-hDU$default(int arg0, int arg1, int arg2, boolean arg3, ColorSpace arg4, int arg5, Object arg6) {
        Rgb v4;
        if((arg5 & 4) != 0) {
            arg2 = ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
        }

        if((arg5 & 16) != 0) {
            v4 = ColorSpaces.INSTANCE.getSrgb();
        }

        return ImageBitmapKt.ImageBitmap-x__-hDU(arg0, arg1, arg2, true, ((ColorSpace)v4));
    }

    public static final ImageBitmap decodeToImageBitmap(byte[] arg0) {
        return AndroidImageBitmap_androidKt.createImageBitmap(arg0);
    }

    public static final PixelMap toPixelMap(ImageBitmap arg1, int arg2, int arg3, int arg4, int arg5, int[] arg6, int arg7, int arg8) {
        arg1.readPixels(arg6, arg2, arg3, arg4, arg5, arg7, arg8);
        return new PixelMap(arg6, arg4, arg5, arg7, arg8);
    }

    public static PixelMap toPixelMap$default(ImageBitmap arg1, int arg2, int arg3, int arg4, int arg5, int[] arg6, int arg7, int arg8, int arg9, Object arg10) {
        if((arg9 & 4) != 0) {
            arg4 = arg1.getWidth();
        }

        if((arg9 & 8) != 0) {
            arg5 = arg1.getHeight();
        }

        if((arg9 & 16) != 0) {
            arg6 = new int[arg4 * arg5];
        }

        if((arg9 & 0x40) != 0) {
            arg8 = arg4;
        }

        return ImageBitmapKt.toPixelMap(arg1, 0, 0, arg4, arg5, arg6, 0, arg8);
    }
}

