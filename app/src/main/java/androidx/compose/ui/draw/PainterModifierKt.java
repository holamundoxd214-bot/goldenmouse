package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001AF\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r¨\u0006\u000E"}, d2={"paint", "Landroidx/compose/ui/Modifier;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PainterModifierKt {
    public static final Modifier paint(Modifier arg7, Painter arg8, boolean arg9, Alignment arg10, ContentScale arg11, float arg12, ColorFilter arg13) {
        return arg7.then(new PainterElement(arg8, arg9, arg10, arg11, arg12, arg13));
    }

    public static Modifier paint$default(Modifier arg7, Painter arg8, boolean arg9, Alignment arg10, ContentScale arg11, float arg12, ColorFilter arg13, int arg14, Object arg15) {
        if((arg14 & 4) != 0) {
            arg10 = Alignment.Companion.getCenter();
        }

        Alignment v3 = arg10;
        if((arg14 & 8) != 0) {
            arg11 = ContentScale.Companion.getInside();
        }

        ContentScale v4 = arg11;
        if((arg14 & 16) != 0) {
            arg12 = 1f;
        }

        float v5 = arg12;
        if((arg14 & 0x20) != 0) {
            arg13 = null;
        }

        return PainterModifierKt.paint(arg7, arg8, true, v3, v4, v5, arg13);
    }
}

