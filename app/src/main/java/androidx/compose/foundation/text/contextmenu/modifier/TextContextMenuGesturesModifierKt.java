package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001AH\u0010\u0000\u001A\u00020\u0001*\u00020\u000125\b\u0002\u0010\u0002\u001A/\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u000B¨\u0006\f"}, d2={"showTextContextMenuOnSecondaryClick", "Landroidx/compose/ui/Modifier;", "onPreShowContextMenu", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "clickLocation", "Lkotlin/coroutines/Continuation;", "", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextContextMenuGesturesModifierKt {
    public static final Modifier showTextContextMenuOnSecondaryClick(Modifier arg1, Function2 arg2) {
        return arg1.then(new TextContextMenuGestureElement(arg2));
    }

    public static Modifier showTextContextMenuOnSecondaryClick$default(Modifier arg0, Function2 arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        return TextContextMenuGesturesModifierKt.showTextContextMenuOnSecondaryClick(arg0, arg1);
    }
}

