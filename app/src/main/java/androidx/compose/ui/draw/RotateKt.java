package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007¨\u0006\u0004"}, d2={"rotate", "Landroidx/compose/ui/Modifier;", "degrees", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RotateKt {
    public static final Modifier rotate(Modifier arg26, float arg27) {
        if(arg27 == 0f) {
            return arg26;
        }

        return GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(arg26, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, arg27, 0f, 0, null, false, null, 0, 0, 0, 0, null, 0x7FEFF, null);
    }
}

