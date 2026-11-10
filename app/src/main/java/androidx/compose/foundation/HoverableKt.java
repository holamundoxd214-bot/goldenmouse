package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0007¨\u0006\u0006"}, d2={"hoverable", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class HoverableKt {
    public static final Modifier hoverable(Modifier arg0, MutableInteractionSource arg1, boolean arg2) {
        HoverableElement v2;
        if(arg2) {
            v2 = new HoverableElement(arg1);
        }
        else {
            Companion v2_1 = Modifier.Companion;
        }

        return arg0.then(((Modifier)v2));
    }

    public static Modifier hoverable$default(Modifier arg0, MutableInteractionSource arg1, boolean arg2, int arg3, Object arg4) {
        return HoverableKt.hoverable(arg0, arg1, true);
    }
}

