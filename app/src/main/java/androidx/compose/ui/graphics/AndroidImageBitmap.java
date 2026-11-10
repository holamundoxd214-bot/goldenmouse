package androidx.compose.ui.graphics;

import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J@\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\t2\u0006\u0010\u001A\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\t2\u0006\u0010\u001C\u001A\u00020\tH\u0016J\b\u0010!\u001A\u00020\u0016H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000BR\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u000BR\u0014\u0010\u0011\u001A\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u0014\u0010\u001D\u001A\u00020\u001E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010 ¨\u0006\""}, d2={"Landroidx/compose/ui/graphics/AndroidImageBitmap;", "Landroidx/compose/ui/graphics/ImageBitmap;", "bitmap", "Landroid/graphics/Bitmap;", "<init>", "(Landroid/graphics/Bitmap;)V", "getBitmap$ui_graphics", "()Landroid/graphics/Bitmap;", "width", "", "getWidth", "()I", "height", "getHeight", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getConfig-_sVssgQ", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "readPixels", "", "buffer", "", "startX", "startY", "bufferOffset", "stride", "hasAlpha", "", "getHasAlpha", "()Z", "prepareToDraw", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidImageBitmap implements ImageBitmap {
    public static final int $stable = 8;
    private final Bitmap bitmap;

    static {
    }

    public AndroidImageBitmap(Bitmap arg1) {
        super();
        this.bitmap = arg1;
    }

    public final Bitmap getBitmap$ui_graphics() {
        return this.bitmap;
    }

    public ColorSpace getColorSpace() {
        return Api26Bitmap.composeColorSpace$ui_graphics(this.bitmap);
    }

    public int getConfig-_sVssgQ() {
        Bitmap$Config v0 = this.bitmap.getConfig();
        Intrinsics.checkNotNull(v0);
        return AndroidImageBitmap_androidKt.toImageConfig(v0);
    }

    public boolean getHasAlpha() {
        return this.bitmap.hasAlpha();
    }

    public int getHeight() {
        return this.bitmap.getHeight();
    }

    public int getWidth() {
        return this.bitmap.getWidth();
    }

    public void prepareToDraw() {
        this.bitmap.prepareToDraw();
    }

    public void readPixels(int[] arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18) {
        Bitmap v11 = AndroidImageBitmap_androidKt.asAndroidBitmap(((ImageBitmap)this));
        int v2 = 0;
        if(v11.getConfig() == Bitmap$Config.HARDWARE) {
            v11 = v11.copy(Bitmap$Config.ARGB_8888, false);
            v2 = 1;
        }

        Bitmap v3 = v11;
        int[] v4 = arg12;
        int v7 = arg13;
        int v8 = arg14;
        int v9 = arg15;
        int v10 = arg16;
        int v5 = arg17;
        int v6 = arg18;
        v3.getPixels(v4, v5, v6, v7, v8, v9, v10);
        v11 = v3;
        if(v2 != 0) {
            v11.recycle();
        }
    }
}

