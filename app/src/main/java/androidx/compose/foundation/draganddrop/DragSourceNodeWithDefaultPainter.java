package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001BJ\u0012+\u0010\u0002\u001A\'\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003j\u0002`\t¢\u0006\u0002\b\b\u0012\u0014\u0010\n\u001A\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000B¢\u0006\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000Ru\u0010\u0002\u001A\'\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003j\u0002`\t¢\u0006\u0002\b\b2+\u0010\u0014\u001A\'\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003j\u0002`\t¢\u0006\u0002\b\b8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A*\u0004\b\u0015\u0010\u0016RG\u0010\n\u001A\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000B2\u0014\u0010\u0014\u001A\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000B8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001F*\u0004\b\u001B\u0010\u0016¨\u0006 "}, d2={"Landroidx/compose/foundation/draganddrop/DragSourceNodeWithDefaultPainter;", "Landroidx/compose/ui/node/DelegatingNode;", "detectDragStart", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropStartDetectorScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/foundation/draganddrop/DragAndDropStartDetector;", "transferData", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "cacheDrawScopeDragShadowCallback", "Landroidx/compose/foundation/draganddrop/CacheDrawScopeDragShadowCallback;", "dragAndDropModifierNode", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceNode;", "<set-?>", "getDetectDragStart$delegate", "(Landroidx/compose/foundation/draganddrop/DragSourceNodeWithDefaultPainter;)Ljava/lang/Object;", "getDetectDragStart", "()Lkotlin/jvm/functions/Function2;", "setDetectDragStart", "(Lkotlin/jvm/functions/Function2;)V", "getTransferData$delegate", "getTransferData", "()Lkotlin/jvm/functions/Function1;", "setTransferData", "(Lkotlin/jvm/functions/Function1;)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DragSourceNodeWithDefaultPainter extends DelegatingNode {
    private final CacheDrawScopeDragShadowCallback cacheDrawScopeDragShadowCallback;
    private final DragAndDropSourceNode dragAndDropModifierNode;

    public DragSourceNodeWithDefaultPainter(Function2 arg3, Function1 arg4) {
        super();
        CacheDrawScopeDragShadowCallback v0 = new CacheDrawScopeDragShadowCallback();
        this.delegate(DrawModifierKt.CacheDrawModifierNode(new DragSourceNodeWithDefaultPainter$cacheDrawScopeDragShadowCallback$1$1(v0)));
        this.cacheDrawScopeDragShadowCallback = v0;
        this.dragAndDropModifierNode = this.delegate(new DragAndDropSourceNode(new DragSourceNodeWithDefaultPainter$$ExternalSyntheticLambda0(this), arg3, arg4));
    }

    static final Unit dragAndDropModifierNode$lambda$0(DragSourceNodeWithDefaultPainter arg0, DrawScope arg1) {
        arg0.cacheDrawScopeDragShadowCallback.drawDragShadow(arg1);
        return Unit.INSTANCE;
    }

    public final Function2 getDetectDragStart() {
        return this.dragAndDropModifierNode.getDetectDragStart();
    }

    private static Object getDetectDragStart$delegate(DragSourceNodeWithDefaultPainter arg6) {
        return Reflection.mutableProperty0(new MutablePropertyReference0Impl(arg6.dragAndDropModifierNode, DragAndDropSourceNode.class, "detectDragStart", "getDetectDragStart()Lkotlin/jvm/functions/Function2;", 0));
    }

    public final Function1 getTransferData() {
        return this.dragAndDropModifierNode.getTransferData();
    }

    private static Object getTransferData$delegate(DragSourceNodeWithDefaultPainter arg6) {
        return Reflection.mutableProperty0(new MutablePropertyReference0Impl(arg6.dragAndDropModifierNode, DragAndDropSourceNode.class, "transferData", "getTransferData()Lkotlin/jvm/functions/Function1;", 0));
    }

    public final void setDetectDragStart(Function2 arg1) {
        this.dragAndDropModifierNode.setDetectDragStart(arg1);
    }

    public final void setTransferData(Function1 arg1) {
        this.dragAndDropModifierNode.setTransferData(arg1);
    }
}

