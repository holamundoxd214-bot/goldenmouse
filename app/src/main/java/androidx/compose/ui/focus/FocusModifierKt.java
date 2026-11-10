package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0001\u001A\f\u0010\u0002\u001A\u00020\u0001*\u00020\u0001H\u0007¨\u0006\u0003"}, d2={"focusTarget", "Landroidx/compose/ui/Modifier;", "focusModifier", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusModifierKt {
    @Deprecated(message="Replaced by focusTarget", replaceWith="<_subannotation>") public static final Modifier focusModifier(Modifier arg0) {
        return FocusModifierKt.focusTarget(arg0);
    }

    public static final Modifier focusTarget(Modifier arg1) {
        return arg1.then(FocusTargetElement.INSTANCE);
    }
}

