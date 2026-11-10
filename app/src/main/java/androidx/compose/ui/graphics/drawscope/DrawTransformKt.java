package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.DegreesKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A!\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0004H\u0086\b\u001A\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001A\u00020\u0004H\u0086\b\u001A&\u0010\u0006\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u00042\b\b\u0002\u0010\b\u001A\u00020\tH\u0086\b¢\u0006\u0004\b\n\u0010\u000B\u001A&\u0010\f\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001A\u00020\u00042\b\b\u0002\u0010\b\u001A\u00020\tH\u0086\b¢\u0006\u0004\b\r\u0010\u000B¨\u0006\u000E"}, d2={"inset", "", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "horizontal", "", "vertical", "rotateRad", "radians", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotateRad-0AR0LA0", "(Landroidx/compose/ui/graphics/drawscope/DrawTransform;FJ)V", "scale", "scale-0AR0LA0", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DrawTransformKt {
    public static final void inset(DrawTransform arg0, float arg1) {
        arg0.inset(arg1, arg1, arg1, arg1);
    }

    public static final void inset(DrawTransform arg0, float arg1, float arg2) {
        arg0.inset(arg1, arg2, arg1, arg2);
    }

    public static void inset$default(DrawTransform arg1, float arg2, float arg3, int arg4, Object arg5) {
        arg1.inset(0f, 0f, 0f, 0f);
    }

    public static final void rotateRad-0AR0LA0(DrawTransform arg0, float arg1, long arg2) {
        arg0.rotate-Uv8p0NA(DegreesKt.degrees(arg1), arg2);
    }

    public static void rotateRad-0AR0LA0$default(DrawTransform arg0, float arg1, long arg2, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = arg0.getCenter-F1C5BW0();
        }

        arg0.rotate-Uv8p0NA(DegreesKt.degrees(arg1), arg2);
    }

    public static final void scale-0AR0LA0(DrawTransform arg0, float arg1, long arg2) {
        arg0.scale-0AR0LA0(arg1, arg1, arg2);
    }

    public static void scale-0AR0LA0$default(DrawTransform arg0, float arg1, long arg2, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = arg0.getCenter-F1C5BW0();
        }

        arg0.scale-0AR0LA0(arg1, arg1, arg2);
    }
}

