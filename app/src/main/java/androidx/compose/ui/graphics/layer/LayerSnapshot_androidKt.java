package androidx.compose.ui.graphics.layer;

import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.media.Image$Plane;
import android.media.Image;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2={"toBitmap", "Landroid/graphics/Bitmap;", "Landroid/media/Image;", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LayerSnapshot_androidKt {
    public static final Bitmap access$toBitmap(Image arg0) {
        return LayerSnapshot_androidKt.toBitmap(arg0);
    }

    private static final Bitmap toBitmap(Image arg7) {
        Image$Plane[] v0 = arg7.getPlanes();
        Intrinsics.checkNotNull(v0);
        int v1 = 0;
        Image$Plane v0_1 = v0[0];
        int v2 = arg7.getWidth() * arg7.getHeight();
        int[] v3 = new int[v2];
        v0_1.getBuffer().asIntBuffer().get(v3);
        while(v1 < v2) {
            v3[v1] = ColorKt.toArgb-8_81llA(ColorKt.Color(v3[v1] & 0xFF, v3[v1] >> 8 & 0xFF, v3[v1] >> 16 & 0xFF, v3[v1] >> 24 & 0xFF));
            ++v1;
        }

        return Bitmap.createBitmap(v3, arg7.getWidth(), arg7.getHeight(), Bitmap$Config.ARGB_8888);
    }
}

