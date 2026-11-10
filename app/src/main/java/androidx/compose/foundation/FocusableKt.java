package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\"\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005H\u0007\u001A\f\u0010\u0006\u001A\u00020\u0001*\u00020\u0001H\u0007¨\u0006\u0007"}, d2={"focusable", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "focusGroup", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusableKt {
    public static final Modifier focusGroup(Modifier arg1) {
        return arg1.then(FocusGroupElement.INSTANCE);
    }

    public static final Modifier focusable(Modifier arg0, boolean arg1, MutableInteractionSource arg2) {
        Companion v1_1;
        if(arg1) {
            FocusableElement v1 = new FocusableElement(arg2);
        }
        else {
            v1_1 = Modifier.Companion;
        }

        return arg0.then(((Modifier)v1_1));
    }

    public static Modifier focusable$default(Modifier arg0, boolean arg1, MutableInteractionSource arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        return FocusableKt.focusable(arg0, true, arg2);
    }
}

