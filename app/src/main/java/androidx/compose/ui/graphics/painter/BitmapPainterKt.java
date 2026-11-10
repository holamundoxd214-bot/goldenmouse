package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A3\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"BitmapPainter", "Landroidx/compose/ui/graphics/painter/BitmapPainter;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "BitmapPainter-QZhYCtY", "(Landroidx/compose/ui/graphics/ImageBitmap;JJI)Landroidx/compose/ui/graphics/painter/BitmapPainter;", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BitmapPainterKt {
    public static final BitmapPainter BitmapPainter-QZhYCtY(ImageBitmap arg7, long arg8, long arg10, int arg12) {
        BitmapPainter v0 = new BitmapPainter(arg7, arg8, arg10, null);
        v0.setFilterQuality-vDHp3xo$ui_graphics(arg12);
        return v0;
    }

    public static BitmapPainter BitmapPainter-QZhYCtY$default(ImageBitmap arg6, long arg7, long arg9, int arg11, int arg12, Object arg13) {
        if((arg12 & 2) != 0) {
            arg7 = IntOffset.Companion.getZero-nOcc-ac();
        }

        long v1 = arg7;
        if((arg12 & 4) != 0) {
            arg9 = IntSize.constructor-impl((((long)arg6.getHeight())) & 0xFFFFFFFFL | (((long)arg6.getWidth())) << 0x20);
        }

        long v3 = arg9;
        if((arg12 & 8) != 0) {
            arg11 = FilterQuality.Companion.getLow-f-v9h1I();
        }

        return BitmapPainterKt.BitmapPainter-QZhYCtY(arg6, v1, v3, arg11);
    }
}

