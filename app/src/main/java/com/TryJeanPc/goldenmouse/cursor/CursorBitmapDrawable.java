package com.TryJeanPc.goldenmouse.cursor;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000F\u001A\u00020\u0010H\u0002J\b\u0010\u0011\u001A\u00020\u0007H\u0016J\b\u0010\u0012\u001A\u00020\u0007H\u0016J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J\u0010\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u0007H\u0016J\u0012\u0010\u0019\u001A\u00020\u00142\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0016J\b\u0010\u001C\u001A\u00020\u0007H\u0017R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\tR\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/CursorBitmapDrawable;", "Landroid/graphics/drawable/Drawable;", "bitmap", "Landroid/graphics/Bitmap;", "<init>", "(Landroid/graphics/Bitmap;)V", "imageWidth", "", "getImageWidth$app", "()I", "imageHeight", "getImageHeight$app", "paint", "Landroid/graphics/Paint;", "side", "hasVisiblePixel", "", "getIntrinsicWidth", "getIntrinsicHeight", "draw", "", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class CursorBitmapDrawable extends Drawable {
    public static final int $stable = 8;
    private final Bitmap bitmap;
    private final Paint paint;
    private final int side;

    static {
    }

    public CursorBitmapDrawable(Bitmap arg3) {
        Intrinsics.checkNotNullParameter(arg3, "bitmap");
        super();
        this.bitmap = arg3;
        this.paint = new Paint(3);
        this.side = Math.max(arg3.getWidth(), arg3.getHeight());
        if(this.hasVisiblePixel()) {
            return;
        }

        throw new IllegalArgumentException("La imagen es completamente transparente".toString());
    }

    public void draw(Canvas arg8) {
        Intrinsics.checkNotNullParameter(arg8, "canvas");
        float v0 = (((float)Math.min(this.getBounds().width(), this.getBounds().height()))) / (((float)this.side));
        float v1 = ((float)this.getBounds().left);
        float v2 = ((float)this.getBounds().top);
        arg8.drawBitmap(this.bitmap, null, new RectF(v1, v2, (((float)this.bitmap.getWidth())) * v0 + v1, (((float)this.bitmap.getHeight())) * v0 + v2), this.paint);
    }

    public final int getImageHeight$app() {
        return this.bitmap.getHeight();
    }

    public final int getImageWidth$app() {
        return this.bitmap.getWidth();
    }

    public int getIntrinsicHeight() {
        return this.side;
    }

    public int getIntrinsicWidth() {
        return this.side;
    }

    @Deprecated(message="Deprecated in Android") public int getOpacity() {
        return -3;
    }

    private final boolean hasVisiblePixel() {
        int v0 = this.bitmap.getWidth();
        int[] v2 = new int[v0];
        int v9 = this.bitmap.getHeight();
        int v6;
        for(v6 = 0; v6 < v9; ++v6) {
            this.bitmap.getPixels(v2, 0, this.bitmap.getWidth(), 0, v6, this.bitmap.getWidth(), 1);
            int v1 = 0;
            while(true) {
                if(v1 >= v0) {
                    break;
                }
                else if(v2[v1] >>> 24 != 0) {
                }
                else {
                    ++v1;
                    continue;
                }

                goto label_25;
            }

            v1 = -1;
        label_25:
            if(v1 >= 0) {
                return 1;
            }
        }

        return 0;
    }

    public void setAlpha(int arg2) {
        this.paint.setAlpha(arg2);
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter arg2) {
        this.paint.setColorFilter(arg2);
        this.invalidateSelf();
    }
}

