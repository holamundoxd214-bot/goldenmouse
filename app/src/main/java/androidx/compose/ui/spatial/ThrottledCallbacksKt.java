package androidx.compose.ui.spatial;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AK\u0010\u0000\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u00052\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2={"rectInfoFor", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "topLeft", "", "bottomRight", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "screenOffset", "windowSize", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "rectInfoFor-Dg36KO4", "(Landroidx/compose/ui/node/DelegatableNode;JJJJJ[F)Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ThrottledCallbacksKt {
    public static final RelativeLayoutBounds rectInfoFor-Dg36KO4(DelegatableNode arg17, long arg18, long arg20, long arg22, long arg24, long arg26, float[] arg28) {
        DelegatableNode v13 = arg17;
        NodeCoordinator v0 = DelegatableNodeKt.requireCoordinator-64DMado(v13, NodeKind.constructor-impl(2));
        LayoutNode v1 = DelegatableNodeKt.requireLayoutNode(v13);
        if(!v1.isPlaced()) {
            return null;
        }

        if(v1.getOuterCoordinator$ui() != v0) {
            long v2 = IntOffset.constructor-impl(arg18);
            long v3 = Offset.constructor-impl((((long)Float.floatToRawIntBits(((float)IntOffset.getX-impl(v2))))) << 0x20 | (((long)Float.floatToRawIntBits(((float)IntOffset.getY-impl(v2))))) & 0xFFFFFFFFL);
            long v5 = v0.getCoordinates().getSize-YbymL2g();
            long v15 = IntOffsetKt.round-k-4lQ0M(v1.getOuterCoordinator$ui().getCoordinates().localPositionOf-R5De75A(((LayoutCoordinates)v0), v3));
            return new RelativeLayoutBounds(v15, IntOffset.constructor-impl((((long)(IntOffset.getX-impl(v15) + (((int)(v5 >> 0x20)))))) << 0x20 | (((long)(IntOffset.getY-impl(v15) + (((int)(v5 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL), arg22, arg24, arg26, arg28, v13, null);
        }

        return new RelativeLayoutBounds(arg18, arg20, arg22, arg24, arg26, arg28, arg17, null);
    }
}

