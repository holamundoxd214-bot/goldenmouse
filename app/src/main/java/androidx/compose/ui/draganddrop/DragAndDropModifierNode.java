package androidx.compose.ui.draganddrop;

import androidx.compose.ui.node.DelegatableNode;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Deprecated(message="This interface is deprecated in favor to DragAndDropSourceModifierNode and DragAndDropTargetModifierNode", replaceWith="<_subannotation>") @Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u0002J8\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0017\u0010\t\u001A\u0013\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0002\b\fH\'¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2={"Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "drag", "", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "drag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)V", "acceptDragAndDropTransfer", "", "startEvent", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface DragAndDropModifierNode extends DragAndDropTarget, DelegatableNode {
    boolean acceptDragAndDropTransfer(DragAndDropEvent arg1);

    @Deprecated(message="Use DragAndDropSourceModifierNode.requestDragAndDropTransfer instead") void drag-12SF9DM(DragAndDropTransferData arg1, long arg2, Function1 arg3);
}

