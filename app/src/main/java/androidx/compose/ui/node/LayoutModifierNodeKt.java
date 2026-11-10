package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0003\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0004\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0005\u001A\u00020\u0001*\u00020\u0002\u001A\f\u0010\u0006\u001A\u00020\u0001*\u00020\u0002H\u0000\u001A%\u0010\u0007\u001A\u00020\u0001*\u00020\u00022\u0019\u0010\b\u001A\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\u000B¨\u0006\f"}, d2={"remeasureSync", "", "Landroidx/compose/ui/node/LayoutModifierNode;", "invalidateLayer", "invalidatePlacement", "invalidateMeasurement", "requestRemeasure", "updateLayerBlock", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LayoutModifierNodeKt {
    public static final void invalidateLayer(LayoutModifierNode arg1) {
        DelegatableNodeKt.requireCoordinator-64DMado(((DelegatableNode)arg1), NodeKind.constructor-impl(2)).invalidateLayer();
    }

    public static final void invalidateMeasurement(LayoutModifierNode arg0) {
        DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg0)).invalidateMeasurements$ui();
    }

    public static final void invalidatePlacement(LayoutModifierNode arg3) {
        LayoutNode.requestRelayout$ui$default(DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg3)), false, 1, null);
    }

    public static final void remeasureSync(LayoutModifierNode arg0) {
        DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg0)).forceRemeasure();
    }

    public static final void requestRemeasure(LayoutModifierNode arg6) {
        LayoutNode.requestRemeasure$ui$default(DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg6)), false, false, false, 7, null);
    }

    public static final void updateLayerBlock(LayoutModifierNode arg1, Function1 arg2) {
        if(!arg1.getNode().isAttached()) {
        }
        else {
            NodeCoordinator v1 = DelegatableNodeKt.requireCoordinator-64DMado(((DelegatableNode)arg1), NodeKind.constructor-impl(2)).getWrapped$ui();
            if(v1 != null) {
                v1.updateLayerBlock(arg2, true);
            }
        }
    }
}

