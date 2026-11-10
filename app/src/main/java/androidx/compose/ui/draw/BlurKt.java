package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A-\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001A%\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"blur", "Landroidx/compose/ui/Modifier;", "radiusX", "Landroidx/compose/ui/unit/Dp;", "radiusY", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "radius", "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BlurKt {
    public static final Modifier blur-1fqS-gw(Modifier arg8, float arg9, float arg10, Shape arg11) {
        boolean v1;
        int v0;
        if(arg11 != null) {
            v0 = TileMode.Companion.getClamp-3opZhB0();
            v1 = true;
        }
        else {
            v0 = TileMode.Companion.getDecal-3opZhB0();
            v1 = false;
        }

        int v5 = v0;
        boolean v7 = v1;
        if(Dp.compareTo-0680j_4(arg9, Dp.constructor-impl(0f)) > 0 && Dp.compareTo-0680j_4(arg10, Dp.constructor-impl(0f)) > 0 || (v7)) {
            arg8 = GraphicsLayerModifierKt.graphicsLayer(arg8, new BlurKt$blur$1(arg9, arg10, v5, arg11, v7));
        }

        return arg8;
    }

    public static Modifier blur-1fqS-gw$default(Modifier arg0, float arg1, float arg2, BlurredEdgeTreatment arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = BlurredEdgeTreatment.box-impl(BlurredEdgeTreatment.Companion.getRectangle---Goahg());
        }

        return BlurKt.blur-1fqS-gw(arg0, arg1, arg2, arg3.unbox-impl());
    }

    public static final Modifier blur-F8QBwvs(Modifier arg0, float arg1, Shape arg2) {
        return BlurKt.blur-1fqS-gw(arg0, arg1, arg1, arg2);
    }

    public static Modifier blur-F8QBwvs$default(Modifier arg0, float arg1, BlurredEdgeTreatment arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = BlurredEdgeTreatment.box-impl(BlurredEdgeTreatment.Companion.getRectangle---Goahg());
        }

        return BlurKt.blur-F8QBwvs(arg0, arg1, arg2.unbox-impl());
    }
}

