package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Metadata;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\bf\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CJL\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u0018\u001A\u00020\u00032\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0019\u001A\u00020\u00032\b\b\u0002\u0010\u001A\u001A\u00020\u0003H&J\b\u0010\u001B\u001A\u00020\u0014H&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001A\u00020\tX¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0012\u0010\f\u001A\u00020\rX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0012\u0010\u0010\u001A\u00020\u0011X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001DÀ\u0006\u0003"}, d2={"Landroidx/compose/ui/graphics/ImageBitmap;", "", "width", "", "getWidth", "()I", "height", "getHeight", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "hasAlpha", "", "getHasAlpha", "()Z", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getConfig-_sVssgQ", "readPixels", "", "buffer", "", "startX", "startY", "bufferOffset", "stride", "prepareToDraw", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ImageBitmap {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/ui/graphics/ImageBitmap$Companion;", "", "<init>", "()V", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static void readPixels$default(ImageBitmap arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, Object arg9) {
            ImageBitmap.readPixels$default(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
        }
    }

    public static final Companion Companion;

    static {
        ImageBitmap.Companion = Companion.$$INSTANCE;
    }

    ColorSpace getColorSpace();

    int getConfig-_sVssgQ();

    boolean getHasAlpha();

    int getHeight();

    int getWidth();

    void prepareToDraw();

    void readPixels(int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7);

    static void readPixels$default(ImageBitmap arg1, int[] arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, Object arg10) {
        if(arg10 == null) {
            if((arg9 & 8) != 0) {
                arg5 = arg1.getWidth();
            }

            if((arg9 & 16) != 0) {
                arg6 = arg1.getHeight();
            }

            if((arg9 & 0x40) != 0) {
                arg8 = arg5;
            }

            arg1.readPixels(arg2, 0, 0, arg5, arg6, 0, arg8);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readPixels");
    }
}

