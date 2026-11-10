package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0007\u001A(\u0010\u0006\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b¨\u0006\t"}, d2={"pointerHoverIcon", "Landroidx/compose/ui/Modifier;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "stylusHoverIcon", "touchBoundsExpansion", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PointerIconKt {
    public static final Modifier pointerHoverIcon(Modifier arg1, PointerIcon arg2, boolean arg3) {
        return arg1.then(new PointerHoverIconModifierElement(arg2, arg3));
    }

    public static Modifier pointerHoverIcon$default(Modifier arg0, PointerIcon arg1, boolean arg2, int arg3, Object arg4) {
        return PointerIconKt.pointerHoverIcon(arg0, arg1, false);
    }

    public static final Modifier stylusHoverIcon(Modifier arg1, PointerIcon arg2, boolean arg3, DpTouchBoundsExpansion arg4) {
        return arg1.then(new StylusHoverIconModifierElement(arg2, arg3, arg4));
    }

    public static Modifier stylusHoverIcon$default(Modifier arg0, PointerIcon arg1, boolean arg2, DpTouchBoundsExpansion arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        return PointerIconKt.stylusHoverIcon(arg0, arg1, false, arg3);
    }
}

