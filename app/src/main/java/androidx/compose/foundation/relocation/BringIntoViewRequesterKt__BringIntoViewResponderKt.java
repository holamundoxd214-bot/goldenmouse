package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007\u001A!\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0005H\u0002¢\u0006\u0002\b\t¨\u0006\n"}, d2={"bringIntoViewResponder", "Landroidx/compose/ui/Modifier;", "responder", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "localRectOf", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "sourceCoordinates", "rect", "localRectOf$BringIntoViewRequesterKt__BringIntoViewResponderKt", "foundation"}, k=5, mv={2, 0, 0}, xi=0x30, xs="androidx/compose/foundation/relocation/BringIntoViewRequesterKt") final class BringIntoViewRequesterKt__BringIntoViewResponderKt {
    public static final Rect access$localRectOf(LayoutCoordinates arg0, LayoutCoordinates arg1, Rect arg2) {
        return BringIntoViewRequesterKt__BringIntoViewResponderKt.localRectOf$BringIntoViewRequesterKt__BringIntoViewResponderKt(arg0, arg1, arg2);
    }

    @Deprecated(message="Use BringIntoViewModifierNode instead") public static final Modifier bringIntoViewResponder(Modifier arg1, BringIntoViewResponder arg2) {
        return arg1.then(new BringIntoViewResponderElement(arg2));
    }

    private static final Rect localRectOf$BringIntoViewRequesterKt__BringIntoViewResponderKt(LayoutCoordinates arg1, LayoutCoordinates arg2, Rect arg3) {
        return arg3.translate-k-4lQ0M(arg1.localBoundingBoxOf(arg2, false).getTopLeft-F1C5BW0());
    }
}

