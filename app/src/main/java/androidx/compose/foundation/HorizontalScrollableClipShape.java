package androidx.compose.foundation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/HorizontalScrollableClipShape;", "Landroidx/compose/ui/graphics/Shape;", "<init>", "()V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class HorizontalScrollableClipShape implements Shape {
    public static final HorizontalScrollableClipShape INSTANCE;

    static {
        HorizontalScrollableClipShape.INSTANCE = new HorizontalScrollableClipShape();
    }

    private HorizontalScrollableClipShape() {
        super();
    }

    public Outline createOutline-Pq9zytI(long arg5, LayoutDirection arg7, Density arg8) {
        float v4 = ((float)arg8.roundToPx-0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation()));
        return new Rectangle(new Rect(0f, -v4, Float.intBitsToFloat(((int)(arg5 >> 0x20))), Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL))) + v4));
    }
}

