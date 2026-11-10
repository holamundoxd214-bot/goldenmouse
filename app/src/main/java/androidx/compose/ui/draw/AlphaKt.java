package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001A\u00020\u0002H\u0007¨\u0006\u0003"}, d2={"alpha", "Landroidx/compose/ui/Modifier;", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AlphaKt {
    public static final Modifier alpha(Modifier arg26, float arg27) {
        if(arg27 == 1f) {
            return arg26;
        }

        return GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(arg26, 0f, 0f, arg27, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0, null, true, null, 0, 0, 0, 0, null, 0x7EFFB, null);
    }
}

