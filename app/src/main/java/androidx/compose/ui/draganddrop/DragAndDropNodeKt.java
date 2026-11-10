package androidx.compose.ui.draganddrop;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\b\u0010\u0000\u001A\u00020\u0001H\u0007\u001A3\u0010\u0000\u001A\u00020\u00012!\u0010\u0002\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001A\u00020\nH\u0007\u001A%\u0010\u000B\u001A\u00020\f2\u001D\u0010\r\u001A\u0019\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000E¢\u0006\u0002\b\u0012\u001A1\u0010\u0013\u001A\u00020\u00142!\u0010\u0002\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001A\u00020\n\u001A\u0014\u0010\u0015\u001A\u00020\u0011*\u00020\n2\u0006\u0010\u0007\u001A\u00020\u0004H\u0002\u001A\u001B\u0010\u0016\u001A\u00020\b*\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u001A\u001A/\u0010\u001B\u001A\u00020\u0011\"\b\b\u0000\u0010\u001C*\u00020\u001D*\u0002H\u001C2\u0012\u0010\u001E\u001A\u000E\u0012\u0004\u0012\u0002H\u001C\u0012\u0004\u0012\u00020\u001F0\u0003H\u0002¢\u0006\u0002\u0010 \u001A4\u0010!\u001A\u0004\u0018\u0001H\u001C\"\b\b\u0000\u0010\u001C*\u00020\u001D*\u0002H\u001C2\u0014\b\u0004\u0010\"\u001A\u000E\u0012\u0004\u0012\u0002H\u001C\u0012\u0004\u0012\u00020\b0\u0003H\u0082\b¢\u0006\u0002\u0010#¨\u0006$"}, d2={"DragAndDropModifierNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "shouldStartDragAndDrop", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", "name", "event", "", "target", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "DragAndDropSourceModifierNode", "Landroidx/compose/ui/draganddrop/DragAndDropSourceModifierNode;", "onStartTransfer", "Lkotlin/Function2;", "Landroidx/compose/ui/draganddrop/DragAndDropStartTransferScope;", "Landroidx/compose/ui/geometry/Offset;", "", "Lkotlin/ExtensionFunctionType;", "DragAndDropTargetModifierNode", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "dispatchEntered", "contains", "Landroidx/compose/ui/draganddrop/DragAndDropNode;", "positionInRoot", "contains-Uv8p0NA", "(Landroidx/compose/ui/draganddrop/DragAndDropNode;J)Z", "traverseSelfAndDescendants", "T", "Landroidx/compose/ui/node/TraversableNode;", "block", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)V", "firstDescendantOrNull", "predicate", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/node/TraversableNode;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DragAndDropNodeKt {
    @Deprecated(message="Use DragAndDropSourceModifierNode instead", replaceWith="<_subannotation>") public static final DragAndDropModifierNode DragAndDropModifierNode() {
        return new DragAndDropNode(null, null, 2, null);
    }

    @Deprecated(message="Use DragAndDropTargetModifierNode instead", replaceWith="<_subannotation>") public static final DragAndDropModifierNode DragAndDropModifierNode(Function1 arg2, DragAndDropTarget arg3) {
        return new DragAndDropNode(null, new DragAndDropNodeKt$DragAndDropModifierNode$1(arg2, arg3), 1, null);
    }

    public static final DragAndDropSourceModifierNode DragAndDropSourceModifierNode(Function2 arg3) {
        return new DragAndDropNode(arg3, null, 2, null);
    }

    public static final DragAndDropTargetModifierNode DragAndDropTargetModifierNode(Function1 arg2, DragAndDropTarget arg3) {
        return new DragAndDropNode(null, new DragAndDropNodeKt$DragAndDropTargetModifierNode$1(arg2, arg3), 1, null);
    }

    public static final boolean access$contains-Uv8p0NA(DragAndDropNode arg0, long arg1) {
        return DragAndDropNodeKt.contains-Uv8p0NA(arg0, arg1);
    }

    public static final void access$dispatchEntered(DragAndDropTarget arg0, DragAndDropEvent arg1) {
        DragAndDropNodeKt.dispatchEntered(arg0, arg1);
    }

    public static final void access$traverseSelfAndDescendants(TraversableNode arg0, Function1 arg1) {
        DragAndDropNodeKt.traverseSelfAndDescendants(arg0, arg1);
    }

    private static final boolean contains-Uv8p0NA(DragAndDropNode arg9, long arg10) {
        if(!arg9.getNode().isAttached()) {
            return 0;
        }

        LayoutCoordinates v0 = DelegatableNodeKt.requireLayoutNode(arg9).getCoordinates();
        if(!v0.isAttached()) {
            return 0;
        }

        long v2 = LayoutCoordinatesKt.positionInRoot(v0);
        float v4 = Float.intBitsToFloat(((int)(v2 >> 0x20)));
        long v5 = 0xFFFFFFFFL;
        float v2_1 = Float.intBitsToFloat(((int)(v2 & v5)));
        float v3 = (((float)(((int)(arg9.getSize-YbymL2g$ui() >> 0x20))))) + v4;
        float v9 = (((float)(((int)(arg9.getSize-YbymL2g$ui() & v5))))) + v2_1;
        float v0_1 = Float.intBitsToFloat(((int)(arg10 >> 0x20)));
        if(v4 <= v0_1 && v0_1 <= v3) {
            float v10 = Float.intBitsToFloat(((int)(arg10 & v5)));
            if(v2_1 <= v10 && v10 <= v9) {
                return 1;
            }
        }

        return 0;
    }

    private static final void dispatchEntered(DragAndDropTarget arg0, DragAndDropEvent arg1) {
        arg0.onEntered(arg1);
        arg0.onMoved(arg1);
    }

    private static final TraversableNode firstDescendantOrNull(TraversableNode arg2, Function1 arg3) {
        if(!arg2.getNode().isAttached()) {
            return null;
        }

        ObjectRef v0 = new ObjectRef();
        TraversableNodeKt.traverseDescendants(arg2, new DragAndDropNodeKt$firstDescendantOrNull$1(arg3, v0));
        return v0.element;
    }

    private static final void traverseSelfAndDescendants(TraversableNode arg2, Function1 arg3) {
        if(arg3.invoke(arg2) != TraverseDescendantsAction.ContinueTraversal) {
            return;
        }

        TraversableNodeKt.traverseDescendants(arg2, arg3);
    }
}

