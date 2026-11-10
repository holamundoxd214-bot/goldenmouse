package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.unit.IntOffset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\r\u001A\u00020\t*\u00020\n2\u0006\u0010\u000E\u001A\u00020\bH\u0014J\u001B\u0010\u000F\u001A\u00020\u0010*\u00020\n2\u0006\u0010\u0011\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007*\u00020\n8TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\u0014"}, d2={"Landroidx/compose/ui/node/LookaheadAlignmentLines;", "Landroidx/compose/ui/node/AlignmentLines;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "<init>", "(Landroidx/compose/ui/node/AlignmentLinesOwner;)V", "alignmentLinesMap", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "Landroidx/compose/ui/node/NodeCoordinator;", "getAlignmentLinesMap", "(Landroidx/compose/ui/node/NodeCoordinator;)Ljava/util/Map;", "getPositionFor", "alignmentLine", "calculatePositionInParent", "Landroidx/compose/ui/geometry/Offset;", "position", "calculatePositionInParent-R5De75A", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LookaheadAlignmentLines extends AlignmentLines {
    public static final int $stable = 8;

    static {
    }

    public LookaheadAlignmentLines(AlignmentLinesOwner arg2) {
        super(arg2, null);
    }

    protected long calculatePositionInParent-R5De75A(NodeCoordinator arg5, long arg6) {
        LookaheadDelegate v4 = arg5.getLookaheadDelegate();
        Intrinsics.checkNotNull(v4);
        long v4_1 = v4.getPosition-nOcc-ac();
        return Offset.plus-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(((float)IntOffset.getY-impl(v4_1))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(((float)IntOffset.getX-impl(v4_1))))) << 0x20), arg6);
    }

    protected Map getAlignmentLinesMap(NodeCoordinator arg1) {
        LookaheadDelegate v0 = arg1.getLookaheadDelegate();
        Intrinsics.checkNotNull(v0);
        return v0.getMeasureResult$ui().getAlignmentLines();
    }

    protected int getPositionFor(NodeCoordinator arg1, AlignmentLine arg2) {
        LookaheadDelegate v0 = arg1.getLookaheadDelegate();
        Intrinsics.checkNotNull(v0);
        return v0.get(arg2);
    }
}

