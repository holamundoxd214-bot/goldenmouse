package androidx.compose.foundation.text.selection;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/text/selection/HandlePositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "handleReferencePoint", "Landroidx/compose/ui/Alignment;", "positionProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "<init>", "(Landroidx/compose/ui/Alignment;Landroidx/compose/foundation/text/selection/OffsetProvider;)V", "prevPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class HandlePositionProvider implements PopupPositionProvider {
    public static final int $stable;
    private final Alignment handleReferencePoint;
    private final OffsetProvider positionProvider;
    private long prevPosition;

    static {
    }

    public HandlePositionProvider(Alignment arg1, OffsetProvider arg2) {
        super();
        this.handleReferencePoint = arg1;
        this.positionProvider = arg2;
        this.prevPosition = Offset.Companion.getZero-F1C5BW0();
    }

    public long calculatePosition-llwVHH4(IntRect arg7, long arg8, LayoutDirection arg10, long arg11) {
        arg8 = this.positionProvider.provide-F1C5BW0();
        if((0x7FFFFFFF7FFFFFFFL & arg8) != 0x7FC000007FC00000L) {
        }
        else {
            arg8 = this.prevPosition;
        }

        this.prevPosition = arg8;
        return IntOffset.plus-qkQi6aY(IntOffset.plus-qkQi6aY(arg7.getTopLeft-nOcc-ac(), IntOffsetKt.round-k-4lQ0M(arg8)), this.handleReferencePoint.align-KFBX0sM(arg11, IntSize.Companion.getZero-YbymL2g(), arg10));
    }
}

