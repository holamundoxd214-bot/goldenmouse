package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003¨\u0006\u0004"}, d2={"layoutBounds", "Landroidx/compose/ui/Modifier;", "holder", "Landroidx/compose/ui/layout/LayoutBoundsHolder;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LayoutBoundsHolderKt {
    public static final Modifier layoutBounds(Modifier arg1, LayoutBoundsHolder arg2) {
        return arg1.then(new LayoutBoundsElement(arg2));
    }
}

