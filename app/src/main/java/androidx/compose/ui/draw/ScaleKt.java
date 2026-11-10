package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0007\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001A\u00020\u0003H\u0007¨\u0006\u0005"}, d2={"scale", "Landroidx/compose/ui/Modifier;", "scaleX", "", "scaleY", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ScaleKt {
    public static final Modifier scale(Modifier arg26, float arg27, float arg28) {
        float v0 = 1f;
        if(arg27 == v0 && arg28 == v0) {
            return arg26;
        }

        return GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(arg26, arg27, arg28, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0, null, false, null, 0, 0, 0, 0, null, 0x7FFFC, null);
    }

    public static final Modifier scale(Modifier arg0, float arg1) {
        return ScaleKt.scale(arg0, arg1, arg1);
    }
}

