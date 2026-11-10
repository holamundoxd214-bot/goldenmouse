package androidx.compose.ui.graphics.layer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004\u001A\u0012\u0010\u0007\u001A\u00020\u0001*\u00020\u00042\u0006\u0010\b\u001A\u00020\t\"\u000E\u0010\u0005\u001A\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"drawLayer", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "DefaultCameraDistance", "", "setOutline", "outline", "Landroidx/compose/ui/graphics/Outline;", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class GraphicsLayerKt {
    public static final float DefaultCameraDistance = 8f;

    public static final void drawLayer(DrawScope arg1, GraphicsLayer arg2) {
        arg2.draw$ui_graphics(arg1.getDrawContext().getCanvas(), arg1.getDrawContext().getGraphicsLayer());
    }

    public static final void setOutline(GraphicsLayer arg12, Outline arg13) {
        long v1 = 0xFFFFFFFFL;
        int v3 = 0x20;
        if((arg13 instanceof Rectangle)) {
            long v4 = Offset.constructor-impl((((long)Float.floatToRawIntBits(((Rectangle)arg13).getRect().getLeft()))) << v3 | (((long)Float.floatToRawIntBits(((Rectangle)arg13).getRect().getTop()))) & v1);
            Rect v0 = ((Rectangle)arg13).getRect();
            float v6 = v0.getRight() - v0.getLeft();
            Rect v13 = ((Rectangle)arg13).getRect();
            arg12.setRectOutline-tz77jQw(v4, Size.constructor-impl((((long)Float.floatToRawIntBits(v13.getBottom() - v13.getTop()))) & v1 | (((long)Float.floatToRawIntBits(v6))) << v3));
            return;
        }

        if((arg13 instanceof Generic)) {
            arg12.setPathOutline(((Generic)arg13).getPath());
            return;
        }

        if((arg13 instanceof Rounded)) {
            if(((Rounded)arg13).getRoundRectPath$ui_graphics() != null) {
                arg12.setPathOutline(((Rounded)arg13).getRoundRectPath$ui_graphics());
                return;
            }

            RoundRect v13_1 = ((Rounded)arg13).getRoundRect();
            arg12.setRoundRectOutline-TNW_H78(Offset.constructor-impl((((long)Float.floatToRawIntBits(v13_1.getLeft()))) << v3 | (((long)Float.floatToRawIntBits(v13_1.getTop()))) & v1), Size.constructor-impl((((long)Float.floatToRawIntBits(v13_1.getHeight()))) & v1 | (((long)Float.floatToRawIntBits(v13_1.getWidth()))) << v3), Float.intBitsToFloat(((int)(v13_1.getBottomLeftCornerRadius-kKHJgLs() >> v3))));
            return;
        }

        throw new NoWhenBranchMatchedException();
    }
}

