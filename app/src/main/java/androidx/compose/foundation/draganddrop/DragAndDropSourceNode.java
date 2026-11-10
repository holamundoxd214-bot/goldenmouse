package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropSourceModifierNode;
import androidx.compose.ui.draganddrop.DragAndDropStartTransferScope;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002Bc\u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012+\u0010\b\u001A\'\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000B\u0012\u0006\u0012\u0004\u0018\u00010\f0\tj\u0002`\r¢\u0006\u0002\b\u0007\u0012\u0014\u0010\u000E\u001A\u0010\u0012\u0004\u0012\u00020\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010%\u001A\u00020\u0006H\u0016J\b\u0010&\u001A\u00020\u0006H\u0016J\u0010\u0010\'\u001A\u00020\u00062\u0006\u0010(\u001A\u00020)H\u0016J\u0017\u0010*\u001A\u00020\u00062\u0006\u0010\u001E\u001A\u00020\u001FH\u0016¢\u0006\u0004\b+\u0010,R+\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016RA\u0010\b\u001A\'\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000B\u0012\u0006\u0012\u0004\u0018\u00010\f0\tj\u0002`\r¢\u0006\u0002\b\u0007X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u001B\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR(\u0010\u000E\u001A\u0010\u0012\u0004\u0012\u00020\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u0014\"\u0004\b\u001D\u0010\u0016R\u0010\u0010\u001E\u001A\u00020\u001FX\u0082\u000E¢\u0006\u0004\n\u0002\u0010 R\u000E\u0010!\u001A\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001A\u0004\u0018\u00010$X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006-"}, d2={"Landroidx/compose/foundation/draganddrop/DragAndDropSourceNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "drawDragDecoration", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "detectDragStart", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropStartDetectorScope;", "Lkotlin/coroutines/Continuation;", "", "Landroidx/compose/foundation/draganddrop/DragAndDropStartDetector;", "transferData", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "getDrawDragDecoration", "()Lkotlin/jvm/functions/Function1;", "setDrawDragDecoration", "(Lkotlin/jvm/functions/Function1;)V", "getDetectDragStart", "()Lkotlin/jvm/functions/Function2;", "setDetectDragStart", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getTransferData", "setTransferData", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "dragAndDropModifierNode", "Landroidx/compose/ui/draganddrop/DragAndDropSourceModifierNode;", "inputModifierNode", "Landroidx/compose/ui/node/PointerInputModifierNode;", "onAttach", "onDetach", "onPlaced", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onRemeasured", "onRemeasured-ozmzZPI", "(J)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DragAndDropSourceNode extends DelegatingNode implements LayoutAwareModifierNode {
    public static final int $stable = 8;
    private Function2 detectDragStart;
    private final DragAndDropSourceModifierNode dragAndDropModifierNode;
    private Function1 drawDragDecoration;
    private PointerInputModifierNode inputModifierNode;
    private long size;
    private Function1 transferData;

    static {
    }

    public DragAndDropSourceNode(Function1 arg1, Function2 arg2, Function1 arg3) {
        super();
        this.drawDragDecoration = arg1;
        this.detectDragStart = arg2;
        this.transferData = arg3;
        this.size = IntSize.Companion.getZero-YbymL2g();
        this.dragAndDropModifierNode = this.delegate(DragAndDropNodeKt.DragAndDropSourceModifierNode(new DragAndDropSourceNode$$ExternalSyntheticLambda0(this)));
    }

    public static final DragAndDropSourceModifierNode access$getDragAndDropModifierNode$p(DragAndDropSourceNode arg0) {
        return arg0.dragAndDropModifierNode;
    }

    static final Unit dragAndDropModifierNode$lambda$0(DragAndDropSourceNode arg2, DragAndDropStartTransferScope arg3, Offset arg4) {
        Object v4 = arg2.transferData.invoke(arg4);
        if(v4 != null) {
            arg3.startDragAndDropTransfer-12SF9DM(((DragAndDropTransferData)v4), IntSizeKt.toSize-ozmzZPI(arg2.size), arg2.drawDragDecoration);
        }

        return Unit.INSTANCE;
    }

    public final Function2 getDetectDragStart() {
        return this.detectDragStart;
    }

    public final Function1 getDrawDragDecoration() {
        return this.drawDragDecoration;
    }

    public final Function1 getTransferData() {
        return this.transferData;
    }

    public void onAttach() {
        if(this.dragAndDropModifierNode.isRequestDragAndDropTransferRequired()) {
            this.inputModifierNode = this.delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new DragAndDropSourceNode$onAttach$1(this)));
        }
    }

    public void onDetach() {
        PointerInputModifierNode v0 = this.inputModifierNode;
        if(v0 != null) {
            this.undelegate(((DelegatableNode)v0));
        }
    }

    public void onPlaced(LayoutCoordinates arg1) {
        this.dragAndDropModifierNode.onPlaced(arg1);
    }

    public void onRemeasured-ozmzZPI(long arg1) {
        this.size = arg1;
        this.dragAndDropModifierNode.onRemeasured-ozmzZPI(arg1);
    }

    public final void setDetectDragStart(Function2 arg1) {
        this.detectDragStart = arg1;
    }

    public final void setDrawDragDecoration(Function1 arg1) {
        this.drawDragDecoration = arg1;
    }

    public final void setTransferData(Function1 arg1) {
        this.transferData = arg1;
    }
}

