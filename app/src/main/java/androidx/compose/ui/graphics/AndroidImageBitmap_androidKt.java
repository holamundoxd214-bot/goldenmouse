package androidx.compose.ui.graphics;

import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Metadata;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\u0010\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A7\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001A\n\u0010\u0012\u001A\u00020\u0002*\u00020\u0001\u001A\u0013\u0010\u0013\u001A\u00020\u0014*\u00020\u000BH\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001A\u0011\u0010\u0017\u001A\u00020\u000B*\u00020\u0014H\u0000¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2={"asImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroid/graphics/Bitmap;", "createImageBitmap", "bytes", "", "ActualImageBitmap", "width", "", "height", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ActualImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "asAndroidBitmap", "toBitmapConfig", "Landroid/graphics/Bitmap$Config;", "toBitmapConfig-1JJdX4A", "(I)Landroid/graphics/Bitmap$Config;", "toImageConfig", "(Landroid/graphics/Bitmap$Config;)I", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidImageBitmap_androidKt {
    public static final ImageBitmap ActualImageBitmap-x__-hDU(int arg0, int arg1, int arg2, boolean arg3, ColorSpace arg4) {
        AndroidImageBitmap_androidKt.toBitmapConfig-1JJdX4A(arg2);
        return new AndroidImageBitmap(Api26Bitmap.createBitmap-x__-hDU$ui_graphics(arg0, arg1, arg2, arg3, arg4));
    }

    public static final Bitmap asAndroidBitmap(ImageBitmap arg1) {
        if((arg1 instanceof AndroidImageBitmap)) {
            return ((AndroidImageBitmap)arg1).getBitmap$ui_graphics();
        }

        throw new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
    }

    public static final ImageBitmap asImageBitmap(Bitmap arg1) {
        return new AndroidImageBitmap(arg1);
    }

    public static final ImageBitmap createImageBitmap(byte[] arg2) {
        return AndroidImageBitmap_androidKt.asImageBitmap(BitmapFactory.decodeByteArray(arg2, 0, arg2.length));
    }

    public static final Bitmap$Config toBitmapConfig-1JJdX4A(int arg1) {
        if(ImageBitmapConfig.equals-impl0(arg1, ImageBitmapConfig.Companion.getArgb8888-_sVssgQ())) {
            return Bitmap$Config.ARGB_8888;
        }

        if(ImageBitmapConfig.equals-impl0(arg1, ImageBitmapConfig.Companion.getAlpha8-_sVssgQ())) {
            return Bitmap$Config.ALPHA_8;
        }

        if(ImageBitmapConfig.equals-impl0(arg1, ImageBitmapConfig.Companion.getRgb565-_sVssgQ())) {
            return Bitmap$Config.RGB_565;
        }

        if(ImageBitmapConfig.equals-impl0(arg1, ImageBitmapConfig.Companion.getF16-_sVssgQ())) {
            return Bitmap$Config.RGBA_F16;
        }

        if(ImageBitmapConfig.equals-impl0(arg1, ImageBitmapConfig.Companion.getGpu-_sVssgQ())) {
            return Bitmap$Config.HARDWARE;
        }

        return Bitmap$Config.ARGB_8888;
    }

    public static final int toImageConfig(Bitmap$Config arg1) {
        if(arg1 == Bitmap$Config.ALPHA_8) {
            return ImageBitmapConfig.Companion.getAlpha8-_sVssgQ();
        }

        if(arg1 == Bitmap$Config.RGB_565) {
            return ImageBitmapConfig.Companion.getRgb565-_sVssgQ();
        }

        if(arg1 == Bitmap$Config.ARGB_4444) {
            return ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
        }

        if(arg1 == Bitmap$Config.RGBA_F16) {
            return ImageBitmapConfig.Companion.getF16-_sVssgQ();
        }

        if(arg1 == Bitmap$Config.HARDWARE) {
            return ImageBitmapConfig.Companion.getGpu-_sVssgQ();
        }

        return ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
    }
}

