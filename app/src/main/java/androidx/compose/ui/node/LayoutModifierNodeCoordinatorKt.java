package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0002¨\u0006\u0005"}, d2={"calculateAlignmentAndPlaceChildAsNeeded", "", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LayoutModifierNodeCoordinatorKt {
    public static final int access$calculateAlignmentAndPlaceChildAsNeeded(LookaheadCapablePlaceable arg0, AlignmentLine arg1) {
        return LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(arg0, arg1);
    }

    private static final int calculateAlignmentAndPlaceChildAsNeeded(LookaheadCapablePlaceable arg5, AlignmentLine arg6) {
        LookaheadCapablePlaceable v0 = arg5.getChild();
        int v3 = v0 != null ? 1 : 0;
        if(v3 == 0) {
            InlineClassHelperKt.throwIllegalStateException("Child of " + arg5 + " cannot be null when calculating alignment line");
        }

        int v4 = 0x80000000;
        if(arg5.getMeasureResult$ui().getAlignmentLines().containsKey(arg6)) {
            Object v5 = arg5.getMeasureResult$ui().getAlignmentLines().get(arg6);
            if(v5 != null) {
                return ((Integer)v5).intValue();
            }

            return v4;
        }

        v3 = v0.get(arg6);
        if(v3 == v4) {
            return v4;
        }

        v0.setShallowPlacing$ui(true);
        arg5.setPlacingForAlignment$ui(true);
        arg5.replace$ui();
        v0.setShallowPlacing$ui(false);
        arg5.setPlacingForAlignment$ui(false);
        int v5_1 = (arg6 instanceof HorizontalAlignmentLine) ? IntOffset.getY-impl(v0.getPosition-nOcc-ac()) : IntOffset.getX-impl(v0.getPosition-nOcc-ac());
        return v3 + v5_1;
    }
}

