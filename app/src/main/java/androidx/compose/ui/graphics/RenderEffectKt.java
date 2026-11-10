package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A)\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001A\u0018\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u0003H\u0007¨\u0006\r"}, d2={"BlurEffect", "Landroidx/compose/ui/graphics/BlurEffect;", "radiusX", "", "radiusY", "edgeTreatment", "Landroidx/compose/ui/graphics/TileMode;", "BlurEffect-3YTHUZs", "(FFI)Landroidx/compose/ui/graphics/BlurEffect;", "OffsetEffect", "Landroidx/compose/ui/graphics/OffsetEffect;", "offsetX", "offsetY", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RenderEffectKt {
    public static final BlurEffect BlurEffect-3YTHUZs(float arg6, float arg7, int arg8) {
        return new BlurEffect(null, arg6, arg7, arg8, null);
    }

    public static BlurEffect BlurEffect-3YTHUZs$default(float arg0, float arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 4) != 0) {
            arg2 = TileMode.Companion.getClamp-3opZhB0();
        }

        return RenderEffectKt.BlurEffect-3YTHUZs(arg0, arg1, arg2);
    }

    public static final OffsetEffect OffsetEffect(float arg5, float arg6) {
        return new OffsetEffect(null, Offset.constructor-impl((((long)Float.floatToRawIntBits(arg6))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg5))) << 0x20), null);
    }
}

