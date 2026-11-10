package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u001A$\u0010\u0007\u001A\u00020\b*\u00020\t2\u0006\u0010\n\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\rH\u0002\u001A\f\u0010\u000E\u001A\u00020\u000F*\u00020\u000FH\u0002\"\u0010\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0018\u0010\u0003\u001A\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0006¨\u0006\u0010"}, d2={"DefaultCursorThickness", "Landroidx/compose/ui/unit/Dp;", "F", "isSpecified", "", "Landroidx/compose/ui/graphics/Brush;", "(Landroidx/compose/ui/graphics/Brush;)Z", "getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorRect", "rtl", "textLayoutSize", "", "roundToNext", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldCoreModifierKt {
    private static final float DefaultCursorThickness;

    static {
        TextFieldCoreModifierKt.DefaultCursorThickness = Dp.constructor-impl(2f);
    }

    public static final Rect access$getCursorRectInScroller(Density arg0, Rect arg1, boolean arg2, int arg3) {
        return TextFieldCoreModifierKt.getCursorRectInScroller(arg0, arg1, arg2, arg3);
    }

    public static final boolean access$isSpecified(Brush arg0) {
        return TextFieldCoreModifierKt.isSpecified(arg0);
    }

    public static final float access$roundToNext(float arg0) {
        return TextFieldCoreModifierKt.roundToNext(arg0);
    }

    private static final Rect getCursorRectInScroller(Density arg8, Rect arg9, boolean arg10, int arg11) {
        int v8 = arg8.roundToPx-0680j_4(TextFieldCoreModifierKt.DefaultCursorThickness);
        float v0 = arg10 ? (((float)arg11)) - arg9.getRight() : arg9.getLeft();
        float v2 = v0;
        float v10 = arg10 ? (((float)arg11)) - arg9.getRight() : arg9.getLeft();
        return Rect.copy$default(arg9, v2, 0f, v10 + (((float)v8)), 0f, 10, null);
    }

    private static final boolean isSpecified(Brush arg4) {
        if(((arg4 instanceof SolidColor)) && ((SolidColor)arg4).getValue-0d7_KjU() == 16) {
            return 0;
        }

        return 1;
    }

    private static final float roundToNext(float arg2) {
        if(!Float.isNaN(arg2)) {
            if(Float.isInfinite(arg2)) {
            }
            else {
                double v0 = arg2 > 0f ? Math.ceil(((double)arg2)) : Math.floor(((double)arg2));
                return ((float)v0);
            }
        }

        return arg2;
    }
}

