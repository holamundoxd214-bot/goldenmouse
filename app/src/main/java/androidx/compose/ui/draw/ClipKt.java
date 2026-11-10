package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0001H\u0007\u001A\u0014\u0010\u0002\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0007¨\u0006\u0005"}, d2={"clipToBounds", "Landroidx/compose/ui/Modifier;", "clip", "shape", "Landroidx/compose/ui/graphics/Shape;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ClipKt {
    public static final Modifier clip(Modifier arg26, Shape arg27) {
        return GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(arg26, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0, arg27, true, null, 0, 0, 0, 0, null, 0x7E7FF, null);
    }

    public static final Modifier clipToBounds(Modifier arg26) {
        return GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(arg26, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0, null, true, null, 0, 0, 0, 0, null, 0x7EFFF, null);
    }
}

