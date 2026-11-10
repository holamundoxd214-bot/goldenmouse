package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\'\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0010$\n\u0002\b\u000F\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010b\u001A\u000200H\u0000¢\u0006\u0002\bcJ\b\u0010l\u001A\u000200H\u0016J\b\u0010m\u001A\u000200H\u0002J\b\u0010n\u001A\u000200H\u0002J\b\u0010o\u001A\u000200H\u0002J\r\u0010y\u001A\u000200H\u0000¢\u0006\u0002\bzJ\b\u0010{\u001A\u000200H\u0002J\u001D\u0010|\u001A\u0002002\u0012\u0010}\u001A\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002000.H\u0082\bJ\u001A\u0010~\u001A\u0002002\u0006\u0010\u007F\u001A\u00020\u0017H\u0080\b¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001A\u0010\u0082\u0001\u001A\u00020\u00022\u0006\u0010\u007F\u001A\u00020\u0017H\u0016¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0018\u0010\u0085\u0001\u001A\u00020\n2\u0006\u0010\u007F\u001A\u00020\u0017¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0012\u0010\u0088\u0001\u001A\u0002002\u0007\u0010\u0089\u0001\u001A\u00020\u001BH\u0002J\u0014\u0010\u008E\u0001\u001A\u00020\f2\b\u0010\u008F\u0001\u001A\u00030\u0090\u0001H\u0096\u0002J?\u0010\u0091\u0001\u001A\u0002002\u0007\u0010\u0092\u0001\u001A\u00020(2\u0006\u0010p\u001A\u0002052\u001A\u0010\u0093\u0001\u001A\u0015\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.¢\u0006\u0002\b1H\u0014¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J,\u0010\u0091\u0001\u001A\u0002002\u0007\u0010\u0092\u0001\u001A\u00020(2\u0006\u0010p\u001A\u0002052\u0007\u0010\u0096\u0001\u001A\u000203H\u0014¢\u0006\u0006\b\u0094\u0001\u0010\u0097\u0001J\u0012\u0010\u009B\u0001\u001A\u0002002\u0007\u0010\u009C\u0001\u001A\u00020\nH\u0016JJ\u0010\u009D\u0001\u001A\u0002002\u0007\u0010\u0092\u0001\u001A\u00020(2\u0006\u0010p\u001A\u0002052\u001A\u0010\u0093\u0001\u001A\u0015\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.¢\u0006\u0002\b12\t\u0010\u0096\u0001\u001A\u0004\u0018\u000103H\u0002¢\u0006\u0006\b\u009E\u0001\u0010\u009F\u0001JJ\u0010 \u0001\u001A\u0002002\u0007\u0010\u0092\u0001\u001A\u00020(2\u0006\u0010p\u001A\u0002052\u001A\u0010\u0093\u0001\u001A\u0015\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.¢\u0006\u0002\b12\t\u0010\u0096\u0001\u001A\u0004\u0018\u000103H\u0002¢\u0006\u0006\b¡\u0001\u0010\u009F\u0001J\u0007\u0010¢\u0001\u001A\u000200J\u0012\u0010£\u0001\u001A\u00020\f2\u0007\u0010¤\u0001\u001A\u00020\fH\u0016J\u0012\u0010¥\u0001\u001A\u00020\f2\u0007\u0010¤\u0001\u001A\u00020\fH\u0016J\u0012\u0010¦\u0001\u001A\u00020\f2\u0007\u0010§\u0001\u001A\u00020\fH\u0016J\u0012\u0010¨\u0001\u001A\u00020\f2\u0007\u0010§\u0001\u001A\u00020\fH\u0016J\t\u0010©\u0001\u001A\u000200H\u0002J\u0007\u0010ª\u0001\u001A\u000200J\u0007\u0010«\u0001\u001A\u00020\nJ\u0017\u0010¬\u0001\u001A\u0010\u0012\u0005\u0012\u00030\u0090\u0001\u0012\u0004\u0012\u00020\f0­\u0001H\u0016J\u001D\u0010±\u0001\u001A\u0002002\u0012\u0010}\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002000.H\u0016J\t\u0010²\u0001\u001A\u000200H\u0016J\t\u0010³\u0001\u001A\u000200H\u0016J\u0007\u0010´\u0001\u001A\u000200J\t\u0010µ\u0001\u001A\u000200H\u0002J\u0010\u0010¶\u0001\u001A\u0002002\u0007\u0010·\u0001\u001A\u00020\nJ\u0007\u0010¸\u0001\u001A\u000200J\u0007\u0010¹\u0001\u001A\u000200J\u000F\u0010º\u0001\u001A\u000200H\u0000¢\u0006\u0003\b»\u0001R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\f@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u001E\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\f@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000FR\u000E\u0010\u0012\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u0013\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001A\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001A\u001A\u00020\u001B8F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u001A\u0010\u001E\u001A\u00020\u001FX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001A\u0010$\u001A\u00020\nX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b%\u0010\u0015\"\u0004\b&\u0010\'R \u0010)\u001A\u00020(2\u0006\u0010\u000B\u001A\u00020(@BX\u0080\u000E¢\u0006\n\n\u0002\u0010,\u001A\u0004\b*\u0010+R!\u0010-\u001A\u0015\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.¢\u0006\u0002\b1X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00102\u001A\u0004\u0018\u000103X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00104\u001A\u000205X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00106\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\"\u00108\u001A\u0004\u0018\u0001072\b\u0010\u000B\u001A\u0004\u0018\u000107@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b9\u0010:R\u0016\u0010;\u001A\u0004\u0018\u00010<8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b=\u0010>R\u001A\u0010?\u001A\u00020\nX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b@\u0010\u0015\"\u0004\bA\u0010\'R$\u0010B\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bB\u0010\u0015\"\u0004\bC\u0010\'R\u001E\u0010D\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\bE\u0010\u0015R\u001E\u0010F\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\bG\u0010\u0015R\u000E\u0010H\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010J\u001A\u00020I2\u0006\u0010\u000B\u001A\u00020I8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0011\u0010O\u001A\u00020P8F¢\u0006\u0006\u001A\u0004\bQ\u0010RR\u0014\u0010S\u001A\u00020P8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bT\u0010RR\u0014\u0010U\u001A\u00020VX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\bW\u0010XR\u0014\u0010Y\u001A\b\u0012\u0004\u0012\u00020\u00000ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010[\u001A\u00020\nX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\\\u0010\u0015\"\u0004\b]\u0010\'R\u001A\u0010^\u001A\b\u0012\u0004\u0012\u00020\u00000_8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b`\u0010aR\u001E\u0010d\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\be\u0010\u0015R\u0010\u0010f\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0004\n\u0002\u0010,R\u001A\u0010g\u001A\b\u0012\u0004\u0012\u0002000hX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bi\u0010jR\u0014\u0010k\u001A\b\u0012\u0004\u0012\u0002000hX\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010p\u001A\u0002052\u0006\u0010\u000B\u001A\u000205@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\bq\u0010rR\u000E\u0010s\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R!\u0010t\u001A\u0015\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.¢\u0006\u0002\b1X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010u\u001A\u0004\u0018\u000103X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010v\u001A\u00020(X\u0082\u000E¢\u0006\u0004\n\u0002\u0010,R\u000E\u0010w\u001A\u000205X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010x\u001A\b\u0012\u0004\u0012\u0002000hX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u008A\u0001\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b\u008B\u0001\u0010\u000FR\u0016\u0010\u008C\u0001\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b\u008D\u0001\u0010\u000FR\u000F\u0010\u0098\u0001\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u001D\u0010\u0099\u0001\u001A\u00020\nX\u0096\u000E¢\u0006\u0010\n\u0000\u001A\u0005\b\u0099\u0001\u0010\u0015\"\u0005\b\u009A\u0001\u0010\'R\u0019\u0010®\u0001\u001A\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\b\u001A\u0006\b¯\u0001\u0010°\u0001¨\u0006¼\u0001"}, d2={"Landroidx/compose/ui/node/MeasurePassDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "layoutNodeLayoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "<init>", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "relayoutWithoutParentInProgress", "", "value", "", "previousPlaceOrder", "getPreviousPlaceOrder$ui", "()I", "placeOrder", "getPlaceOrder", "measuredOnce", "placedOnce", "getPlacedOnce", "()Z", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui", "setDuringAlignmentLinesQuery$ui", "(Z)V", "Landroidx/compose/ui/unit/IntOffset;", "lastPosition", "getLastPosition-nOcc-ac$ui", "()J", "J", "lastLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "lastExplicitLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "lastZIndex", "", "parentDataDirty", "", "parentData", "getParentData", "()Ljava/lang/Object;", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LookaheadPassDelegate;", "getLookaheadPassDelegate", "()Landroidx/compose/ui/node/LookaheadPassDelegate;", "isPlaced", "isPlaced$ui", "setPlaced$ui", "isPlacedByParent", "setPlacedByParent$ui", "measurePending", "getMeasurePending$ui", "layoutPending", "getLayoutPending$ui", "layoutPendingForAlignment", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "layoutState", "getLayoutState", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "setLayoutState", "(Landroidx/compose/ui/node/LayoutNode$LayoutState;)V", "outerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getOuterCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerCoordinator", "getInnerCoordinator", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "_childDelegates", "Landroidx/compose/runtime/collection/MutableVector;", "childDelegatesDirty", "getChildDelegatesDirty$ui", "setChildDelegatesDirty$ui", "childDelegates", "", "getChildDelegates$ui", "()Ljava/util/List;", "markDetachedFromParentLookaheadPass", "markDetachedFromParentLookaheadPass$ui", "layingOutChildren", "getLayingOutChildren", "performMeasureConstraints", "performMeasureBlock", "Lkotlin/Function0;", "getPerformMeasureBlock$ui", "()Lkotlin/jvm/functions/Function0;", "layoutChildrenBlock", "layoutChildren", "checkChildrenPlaceOrderForUpdates", "markSubtreeAsNotPlaced", "markNodeAndSubtreeAsPlaced", "zIndex", "getZIndex$ui", "()F", "onNodePlacedCalled", "placeOuterCoordinatorLayerBlock", "placeOuterCoordinatorLayer", "placeOuterCoordinatorPosition", "placeOuterCoordinatorZIndex", "placeOuterCoordinatorBlock", "onNodePlaced", "onNodePlaced$ui", "clearPlaceOrder", "forEachChildDelegate", "block", "performMeasure", "constraints", "performMeasure-BRTryo0$ui", "(J)V", "measure", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "remeasure", "remeasure-BRTryo0", "(J)Z", "trackMeasurementByParent", "node", "measuredWidth", "getMeasuredWidth", "measuredHeight", "getMeasuredHeight", "get", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "placeAt", "position", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "layer", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "needsCoordinatesUpdate", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "updatePlacedUnderMotionFrameOfReference", "newMFR", "placeSelf", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeOuterCoordinator", "placeOuterCoordinator-MLgxB_4", "replace", "minIntrinsicWidth", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "onIntrinsicsQueried", "invalidateParentData", "updateParentData", "calculateAlignmentLines", "", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "forEachChildAlignmentLinesOwner", "requestLayout", "requestMeasure", "notifyChildrenUsingCoordinatesWhilePlacing", "onBeforeLayoutChildren", "invalidateIntrinsicsParent", "forceRequest", "onNodeDetached", "markLayoutPending", "markMeasurePending", "markMeasurePending$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MeasurePassDelegate extends Placeable implements Measurable, AlignmentLinesOwner, MotionReferencePlacementDelegate {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[LayoutState.values().length];
            try {
                v0[LayoutState.Measuring.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
            label_7:
                int v2 = 2;
                try {
                    v0[LayoutState.LayingOut.ordinal()] = v2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    v0 = new int[UsageByParent.values().length];
                    try {
                        v0[UsageByParent.InMeasureBlock.ordinal()] = 1;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            v0[UsageByParent.InLayoutBlock.ordinal()] = v2;
                            goto label_21;
                        }
                        catch(NoSuchFieldError ) {
                        label_21:
                            WhenMappings.$EnumSwitchMapping$1 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private final MutableVector _childDelegates;
    private final AlignmentLines alignmentLines;
    private boolean childDelegatesDirty;
    private boolean duringAlignmentLinesQuery;
    private boolean isPlaced;
    private boolean isPlacedByParent;
    private boolean isPlacedUnderMotionFrameOfReference;
    private GraphicsLayer lastExplicitLayer;
    private Function1 lastLayerBlock;
    private long lastPosition;
    private float lastZIndex;
    private boolean layingOutChildren;
    private final Function0 layoutChildrenBlock;
    private final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
    private boolean layoutPending;
    private boolean layoutPendingForAlignment;
    private boolean measurePending;
    private UsageByParent measuredByParent;
    private boolean measuredOnce;
    private boolean needsCoordinatesUpdate;
    private boolean onNodePlacedCalled;
    private Object parentData;
    private boolean parentDataDirty;
    private final Function0 performMeasureBlock;
    private long performMeasureConstraints;
    private int placeOrder;
    private final Function0 placeOuterCoordinatorBlock;
    private GraphicsLayer placeOuterCoordinatorLayer;
    private Function1 placeOuterCoordinatorLayerBlock;
    private long placeOuterCoordinatorPosition;
    private float placeOuterCoordinatorZIndex;
    private boolean placedOnce;
    private int previousPlaceOrder;
    private boolean relayoutWithoutParentInProgress;
    private float zIndex;

    static {
    }

    public MeasurePassDelegate(LayoutNodeLayoutDelegate arg10) {
        super();
        this.layoutNodeLayoutDelegate = arg10;
        this.previousPlaceOrder = 0x7FFFFFFF;
        this.placeOrder = 0x7FFFFFFF;
        this.measuredByParent = UsageByParent.NotUsed;
        this.lastPosition = IntOffset.Companion.getZero-nOcc-ac();
        this.parentDataDirty = true;
        this.alignmentLines = new LayoutNodeAlignmentLines(this);
        this._childDelegates = new MutableVector(new MeasurePassDelegate[16], 0);
        this.childDelegatesDirty = true;
        this.performMeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        this.performMeasureBlock = new MeasurePassDelegate$performMeasureBlock$1(this);
        this.layoutChildrenBlock = new MeasurePassDelegate$layoutChildrenBlock$1(this);
        this.placeOuterCoordinatorPosition = IntOffset.Companion.getZero-nOcc-ac();
        this.placeOuterCoordinatorBlock = new MeasurePassDelegate$placeOuterCoordinatorBlock$1(this);
    }

    public static final void access$checkChildrenPlaceOrderForUpdates(MeasurePassDelegate arg0) {
        arg0.checkChildrenPlaceOrderForUpdates();
    }

    public static final void access$clearPlaceOrder(MeasurePassDelegate arg0) {
        arg0.clearPlaceOrder();
    }

    public static final long access$getPerformMeasureConstraints$p(MeasurePassDelegate arg2) {
        return arg2.performMeasureConstraints;
    }

    public static final GraphicsLayer access$getPlaceOuterCoordinatorLayer$p(MeasurePassDelegate arg0) {
        return arg0.placeOuterCoordinatorLayer;
    }

    public static final Function1 access$getPlaceOuterCoordinatorLayerBlock$p(MeasurePassDelegate arg0) {
        return arg0.placeOuterCoordinatorLayerBlock;
    }

    public static final long access$getPlaceOuterCoordinatorPosition$p(MeasurePassDelegate arg2) {
        return arg2.placeOuterCoordinatorPosition;
    }

    public static final float access$getPlaceOuterCoordinatorZIndex$p(MeasurePassDelegate arg0) {
        return arg0.placeOuterCoordinatorZIndex;
    }

    public static final void access$setMeasurePending$p(MeasurePassDelegate arg0, boolean arg1) {
        arg0.measurePending = arg1;
    }

    public static final void access$setPerformMeasureConstraints$p(MeasurePassDelegate arg0, long arg1) {
        arg0.performMeasureConstraints = arg1;
    }

    public Map calculateAlignmentLines() {
        if(!this.duringAlignmentLinesQuery) {
            if(this.getLayoutState() == LayoutState.Measuring) {
                this.getAlignmentLines().setUsedByModifierMeasurement$ui(true);
                if(this.getAlignmentLines().getDirty$ui()) {
                    this.markLayoutPending();
                }
            }
            else {
                this.getAlignmentLines().setUsedByModifierLayout$ui(true);
            }
        }

        NodeCoordinator v0 = this.getInnerCoordinator();
        boolean v2 = v0.isPlacingForAlignment$ui();
        v0.setPlacingForAlignment$ui(true);
        this.layoutChildren();
        v0.setPlacingForAlignment$ui(v2);
        return this.getAlignmentLines().getLastCalculation();
    }

    private final void checkChildrenPlaceOrderForUpdates() {
        LayoutNode v7 = this.getLayoutNode();
        MutableVector v0 = v7.get_children$ui();
        Object[] v1 = v0.content;
        int v0_1 = v0.getSize();
        int v3;
        for(v3 = 0; v3 < v0_1; ++v3) {
            Object v4 = v1[v3];
            if(((LayoutNode)v4).getMeasurePassDelegate$ui().previousPlaceOrder != ((LayoutNode)v4).getPlaceOrder$ui()) {
                v7.onZSortedChildrenInvalidated$ui();
                v7.invalidateLayer$ui();
                if(((LayoutNode)v4).getPlaceOrder$ui() == 0x7FFFFFFF) {
                    if((((LayoutNode)v4).getLayoutDelegate$ui().getDetachedFromParentLookaheadPlacement$ui()) || (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(((LayoutNode)v4)))) {
                        LookaheadPassDelegate v5 = ((LayoutNode)v4).getLookaheadPassDelegate$ui();
                        Intrinsics.checkNotNull(v5);
                        v5.markNodeAndSubtreeAsNotPlaced$ui(false);
                    }

                    ((LayoutNode)v4).getMeasurePassDelegate$ui().markSubtreeAsNotPlaced();
                }
            }
        }
    }

    private final void clearPlaceOrder() {
        this.layoutNodeLayoutDelegate.setNextChildPlaceOrder$ui(0);
        MutableVector v6 = this.getLayoutNode().get_children$ui();
        Object[] v0 = v6.content;
        int v6_1 = v6.getSize();
        int v2;
        for(v2 = 0; v2 < v6_1; ++v2) {
            MeasurePassDelegate v3 = v0[v2].getMeasurePassDelegate$ui();
            v3.previousPlaceOrder = v3.getPlaceOrder();
            v3.placeOrder = 0x7FFFFFFF;
            v3.isPlacedByParent = false;
            if(v3.measuredByParent == UsageByParent.InLayoutBlock) {
                v3.measuredByParent = UsageByParent.NotUsed;
            }
        }
    }

    public void forEachChildAlignmentLinesOwner(Function1 arg4) {
        MutableVector v3 = this.getLayoutNode().get_children$ui();
        Object[] v0 = v3.content;
        int v3_1 = v3.getSize();
        int v1;
        for(v1 = 0; v1 < v3_1; ++v1) {
            arg4.invoke(v0[v1].getLayoutDelegate$ui().getAlignmentLinesOwner$ui());
        }
    }

    private final void forEachChildDelegate(Function1 arg4) {
        MutableVector v3 = this.getLayoutNode().get_children$ui();
        Object[] v0 = v3.content;
        int v3_1 = v3.getSize();
        int v1;
        for(v1 = 0; v1 < v3_1; ++v1) {
            arg4.invoke(v0[v1].getMeasurePassDelegate$ui());
        }
    }

    public int get(AlignmentLine arg5) {
        LayoutNode v0 = this.getLayoutNode().getParent$ui();
        LayoutState v1 = null;
        LayoutState v0_1 = v0 != null ? v0.getLayoutState$ui() : v1;
        if(v0_1 == LayoutState.Measuring) {
            this.getAlignmentLines().setUsedDuringParentMeasurement$ui(true);
        }
        else {
            v0 = this.getLayoutNode().getParent$ui();
            if(v0 != null) {
                v1 = v0.getLayoutState$ui();
            }

            if(v1 != LayoutState.LayingOut) {
                goto label_21;
            }

            this.getAlignmentLines().setUsedDuringParentLayout$ui(true);
        }

    label_21:
        this.duringAlignmentLinesQuery = true;
        int v5 = this.getOuterCoordinator().get(arg5);
        this.duringAlignmentLinesQuery = false;
        return v5;
    }

    public AlignmentLines getAlignmentLines() {
        return this.alignmentLines;
    }

    public final List getChildDelegates$ui() {
        this.getLayoutNode().updateChildrenIfDirty$ui();
        if(!this.childDelegatesDirty) {
            return this._childDelegates.asMutableList();
        }

        LayoutNode v0 = this.getLayoutNode();
        MutableVector v1 = this._childDelegates;
        MutableVector v2 = v0.get_children$ui();
        Object[] v3 = v2.content;
        int v2_1 = v2.getSize();
        int v5;
        for(v5 = 0; v5 < v2_1; ++v5) {
            Object v6 = v3[v5];
            if(v1.getSize() <= v5) {
                v1.add(((LayoutNode)v6).getLayoutDelegate$ui().getMeasurePassDelegate$ui());
            }
            else {
                v1.set(v5, ((LayoutNode)v6).getLayoutDelegate$ui().getMeasurePassDelegate$ui());
            }
        }

        v1.removeRange(v0.getChildren$ui().size(), v1.getSize());
        this.childDelegatesDirty = false;
        return this._childDelegates.asMutableList();
    }

    public final boolean getChildDelegatesDirty$ui() {
        return this.childDelegatesDirty;
    }

    public final boolean getDuringAlignmentLinesQuery$ui() {
        return this.duringAlignmentLinesQuery;
    }

    public NodeCoordinator getInnerCoordinator() {
        return this.getLayoutNode().getInnerCoordinator$ui();
    }

    public final Constraints getLastConstraints-DWUhwKw() {
        if(this.measuredOnce) {
            return Constraints.box-impl(this.getMeasurementConstraints-msEJaDk());
        }

        return null;
    }

    public final long getLastPosition-nOcc-ac$ui() {
        return this.lastPosition;
    }

    public final boolean getLayingOutChildren() {
        return this.layingOutChildren;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNodeLayoutDelegate.getLayoutNode$ui();
    }

    public final boolean getLayoutPending$ui() {
        return this.layoutPending;
    }

    public final LayoutState getLayoutState() {
        return this.layoutNodeLayoutDelegate.getLayoutState$ui();
    }

    private final LookaheadPassDelegate getLookaheadPassDelegate() {
        return this.layoutNodeLayoutDelegate.getLookaheadPassDelegate$ui();
    }

    public final boolean getMeasurePending$ui() {
        return this.measurePending;
    }

    public final UsageByParent getMeasuredByParent$ui() {
        return this.measuredByParent;
    }

    public int getMeasuredHeight() {
        return this.getOuterCoordinator().getMeasuredHeight();
    }

    public int getMeasuredWidth() {
        return this.getOuterCoordinator().getMeasuredWidth();
    }

    public final NodeCoordinator getOuterCoordinator() {
        return this.layoutNodeLayoutDelegate.getOuterCoordinator();
    }

    public AlignmentLinesOwner getParentAlignmentLinesOwner() {
        LayoutNode v0 = this.getLayoutNode().getParent$ui();
        if(v0 != null) {
            LayoutNodeLayoutDelegate v0_1 = v0.getLayoutDelegate$ui();
            if(v0_1 != null) {
                return v0_1.getAlignmentLinesOwner$ui();
            }
        }

        return null;
    }

    public Object getParentData() {
        return this.parentData;
    }

    public final Function0 getPerformMeasureBlock$ui() {
        return this.performMeasureBlock;
    }

    public int getPlaceOrder() {
        return this.placeOrder;
    }

    public final boolean getPlacedOnce() {
        return this.placedOnce;
    }

    public final int getPreviousPlaceOrder$ui() {
        return this.previousPlaceOrder;
    }

    public final float getZIndex$ui() {
        return this.zIndex;
    }

    public final void invalidateIntrinsicsParent(boolean arg9) {
        LayoutNode v2;
        LayoutNode v0 = this.getLayoutNode().getParent$ui();
        UsageByParent v8 = this.getLayoutNode().getIntrinsicsUsageByParent$ui();
        if(v0 != null && v8 != UsageByParent.NotUsed) {
            do {
                v2 = v0;
                if(v2.getIntrinsicsUsageByParent$ui() != v8) {
                    break;
                }

                v0 = v2.getParent$ui();
            }
            while(v0 != null);

            int v8_1 = WhenMappings.$EnumSwitchMapping$1[v8.ordinal()];
            if(v8_1 != 1) {
                if(v8_1 == 2) {
                    v2.requestRelayout$ui(arg9);
                    return;
                }

                throw new IllegalStateException("Intrinsics isn\'t used by the parent".toString());
            }

            LayoutNode.requestRemeasure$ui$default(v2, arg9, false, false, 6, null);
        }
    }

    public final void invalidateParentData() {
        this.parentDataDirty = true;
    }

    public final boolean isPlaced$ui() {
        return this.isPlaced;
    }

    public final boolean isPlacedByParent() {
        return this.isPlacedByParent;
    }

    public boolean isPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    public void layoutChildren() {
        this.layingOutChildren = true;
        this.getAlignmentLines().recalculateQueryOwner();
        if(this.layoutPending) {
            this.onBeforeLayoutChildren();
        }

        if((this.layoutPendingForAlignment) || !this.duringAlignmentLinesQuery && !this.getInnerCoordinator().isPlacingForAlignment$ui() && (this.layoutPending)) {
            this.layoutPending = false;
            LayoutState v1 = this.getLayoutState();
            this.setLayoutState(LayoutState.LayingOut);
            this.layoutNodeLayoutDelegate.setCoordinatesAccessedDuringPlacement(false);
            LayoutNode v3 = this.getLayoutNode();
            OwnerSnapshotObserver v4 = LayoutNodeKt.requireOwner(v3).getSnapshotObserver();
            OwnerSnapshotObserver.access$getObserver$p(v4).observeReads(v3, OwnerSnapshotObserver.access$getOnCommitAffectingLayout$p(v4), this.layoutChildrenBlock);
            this.setLayoutState(v1);
            this.layoutPendingForAlignment = false;
        }

        if(this.getAlignmentLines().getUsedDuringParentLayout$ui()) {
            this.getAlignmentLines().setPreviousUsedDuringParentLayout$ui(true);
        }

        if((this.getAlignmentLines().getDirty$ui()) && (this.getAlignmentLines().getRequired$ui())) {
            this.getAlignmentLines().recalculate();
        }

        this.layingOutChildren = false;
    }

    public final void markDetachedFromParentLookaheadPass$ui() {
        this.layoutNodeLayoutDelegate.setDetachedFromParentLookaheadPass$ui(true);
    }

    public final void markLayoutPending() {
        this.layoutPending = true;
        this.layoutPendingForAlignment = true;
    }

    public final void markMeasurePending$ui() {
        this.measurePending = true;
    }

    private final void markNodeAndSubtreeAsPlaced() {
        boolean v0 = this.isPlaced;
        this.isPlaced = true;
        LayoutNode v2 = this.getLayoutNode();
        if(!v0) {
            v2.getInnerCoordinator$ui().onPlaced();
            LayoutNodeKt.requireOwner(v2).getRectManager().onLayoutPositionChanged(this.getLayoutNode(), true);
            if(v2.getMeasurePending$ui()) {
                LayoutNode.requestRemeasure$ui$default(v2, true, false, false, 6, null);
            }
            else if(v2.getLookaheadMeasurePending$ui()) {
                LayoutNode.requestLookaheadRemeasure$ui$default(v2, true, false, false, 6, null);
            }
        }

        NodeCoordinator v8 = v2.getOuterCoordinator$ui();
        NodeCoordinator v0_1 = v2.getInnerCoordinator$ui().getWrapped$ui();
        while(!Intrinsics.areEqual(v8, v0_1)) {
            if(v8 == null) {
                break;
            }

            if(v8.getLastLayerDrawingWasSkipped$ui()) {
                v8.invalidateLayer();
            }

            v8 = v8.getWrapped$ui();
        }

        MutableVector v8_1 = v2.get_children$ui();
        Object[] v0_2 = v8_1.content;
        int v8_2 = v8_1.getSize();
        int v1;
        for(v1 = 0; v1 < v8_2; ++v1) {
            Object v3 = v0_2[v1];
            if(((LayoutNode)v3).getPlaceOrder$ui() != 0x7FFFFFFF) {
                ((LayoutNode)v3).getMeasurePassDelegate$ui().markNodeAndSubtreeAsPlaced();
                v2.rescheduleRemeasureOrRelayout$ui(((LayoutNode)v3));
            }
        }
    }

    private final void markSubtreeAsNotPlaced() {
        if(this.isPlaced) {
            int v0 = 0;
            this.isPlaced = false;
            LayoutNodeKt.requireOwner(this.getLayoutNode()).getRectManager().remove(this.getLayoutNode());
            LayoutNode v1 = this.getLayoutNode();
            NodeCoordinator v2 = v1.getOuterCoordinator$ui();
            NodeCoordinator v1_1 = v1.getInnerCoordinator$ui().getWrapped$ui();
            while(!Intrinsics.areEqual(v2, v1_1)) {
                if(v2 == null) {
                    break;
                }

                v2.onUnplaced();
                v2.releaseLayer();
                v2 = v2.getWrapped$ui();
            }

            MutableVector v4 = this.getLayoutNode().get_children$ui();
            Object[] v1_2 = v4.content;
            int v4_1 = v4.getSize();
            while(v0 < v4_1) {
                v1_2[v0].getMeasurePassDelegate$ui().markSubtreeAsNotPlaced();
                ++v0;
            }
        }
    }

    public int maxIntrinsicHeight(int arg2) {
        if(LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.getLayoutNode())) {
            LookaheadPassDelegate v1 = this.getLookaheadPassDelegate();
            Intrinsics.checkNotNull(v1);
            return v1.maxIntrinsicHeight(arg2);
        }

        this.onIntrinsicsQueried();
        return this.getOuterCoordinator().maxIntrinsicHeight(arg2);
    }

    public int maxIntrinsicWidth(int arg2) {
        if(LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.getLayoutNode())) {
            LookaheadPassDelegate v1 = this.getLookaheadPassDelegate();
            Intrinsics.checkNotNull(v1);
            return v1.maxIntrinsicWidth(arg2);
        }

        this.onIntrinsicsQueried();
        return this.getOuterCoordinator().maxIntrinsicWidth(arg2);
    }

    public Placeable measure-BRTryo0(long arg3) {
        if(this.getLayoutNode().getIntrinsicsUsageByParent$ui() == UsageByParent.NotUsed) {
            this.getLayoutNode().clearSubtreeIntrinsicsUsage$ui();
        }

        if(LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.getLayoutNode())) {
            LookaheadPassDelegate v0 = this.getLookaheadPassDelegate();
            Intrinsics.checkNotNull(v0);
            v0.setMeasuredByParent$ui(UsageByParent.NotUsed);
            v0.measure-BRTryo0(arg3);
        }

        this.trackMeasurementByParent(this.getLayoutNode());
        this.remeasure-BRTryo0(arg3);
        return this;
    }

    public int minIntrinsicHeight(int arg2) {
        if(LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.getLayoutNode())) {
            LookaheadPassDelegate v1 = this.getLookaheadPassDelegate();
            Intrinsics.checkNotNull(v1);
            return v1.minIntrinsicHeight(arg2);
        }

        this.onIntrinsicsQueried();
        return this.getOuterCoordinator().minIntrinsicHeight(arg2);
    }

    public int minIntrinsicWidth(int arg2) {
        if(LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.getLayoutNode())) {
            LookaheadPassDelegate v1 = this.getLookaheadPassDelegate();
            Intrinsics.checkNotNull(v1);
            return v1.minIntrinsicWidth(arg2);
        }

        this.onIntrinsicsQueried();
        return this.getOuterCoordinator().minIntrinsicWidth(arg2);
    }

    public final void notifyChildrenUsingCoordinatesWhilePlacing() {
        if(this.layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            MutableVector v7 = this.getLayoutNode().get_children$ui();
            Object[] v0 = v7.content;
            int v7_1 = v7.getSize();
            int v2;
            for(v2 = 0; v2 < v7_1; ++v2) {
                Object v3 = v0[v2];
                LayoutNodeLayoutDelegate v4 = ((LayoutNode)v3).getLayoutDelegate$ui();
                if(((v4.getCoordinatesAccessedDuringPlacement()) || (v4.getCoordinatesAccessedDuringModifierPlacement())) && !v4.getLayoutPending$ui()) {
                    LayoutNode.requestRelayout$ui$default(((LayoutNode)v3), false, 1, null);
                }

                v4.getMeasurePassDelegate$ui().notifyChildrenUsingCoordinatesWhilePlacing();
            }
        }
    }

    private final void onBeforeLayoutChildren() {
        MutableVector v0 = this.getLayoutNode().get_children$ui();
        Object[] v1 = v0.content;
        int v0_1 = v0.getSize();
        int v2;
        for(v2 = 0; v2 < v0_1; ++v2) {
            Object v3 = v1[v2];
            if((((LayoutNode)v3).getMeasurePending$ui()) && ((LayoutNode)v3).getMeasuredByParent$ui() == UsageByParent.InMeasureBlock && (LayoutNode.remeasure-_Sx5XlM$ui$default(((LayoutNode)v3), null, 1, null))) {
                LayoutNode.requestRemeasure$ui$default(this.getLayoutNode(), false, false, false, 7, null);
            }
        }
    }

    private final void onIntrinsicsQueried() {
        UsageByParent v0_1;
        LayoutNode.requestRemeasure$ui$default(this.getLayoutNode(), false, false, false, 7, null);
        LayoutNode v0 = this.getLayoutNode().getParent$ui();
        if(v0 != null && this.getLayoutNode().getIntrinsicsUsageByParent$ui() == UsageByParent.NotUsed) {
            LayoutNode v6 = this.getLayoutNode();
            int v1 = WhenMappings.$EnumSwitchMapping$0[v0.getLayoutState$ui().ordinal()];
            if(v1 == 1) {
                v0_1 = UsageByParent.InMeasureBlock;
            }
            else if(v1 != 2) {
                v0_1 = v0.getIntrinsicsUsageByParent$ui();
            }
            else {
                v0_1 = UsageByParent.InLayoutBlock;
            }

            v6.setIntrinsicsUsageByParent$ui(v0_1);
        }
    }

    public final void onNodeDetached() {
        this.placeOrder = 0x7FFFFFFF;
        this.previousPlaceOrder = 0x7FFFFFFF;
        this.isPlaced = false;
    }

    public final void onNodePlaced$ui() {
        this.onNodePlacedCalled = true;
        LayoutNode v1 = this.getLayoutNode().getParent$ui();
        float v2 = this.getInnerCoordinator().getZIndex();
        LayoutNode v3 = this.getLayoutNode();
        NodeCoordinator v4 = v3.getOuterCoordinator$ui();
        NodeCoordinator v3_1 = v3.getInnerCoordinator$ui();
        while(v4 != v3_1) {
            Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            v2 += ((LayoutModifierNodeCoordinator)v4).getZIndex();
            v4 = ((LayoutModifierNodeCoordinator)v4).getWrapped$ui();
        }

        if(v2 == this.zIndex) {
        }
        else {
            this.zIndex = v2;
            if(v1 != null) {
                v1.onZSortedChildrenInvalidated$ui();
            }

            if(v1 == null) {
                goto label_24;
            }

            v1.invalidateLayer$ui();
        }

    label_24:
        int v3_2 = 0;
        if(!this.getInnerCoordinator().isPlacingForAlignment$ui()) {
            boolean v2_1 = this.isPlaced;
            if(!v2_1 || (this.getAlignmentLines().getQueried$ui())) {
                this.markNodeAndSubtreeAsPlaced();
            }

            if(!v2_1) {
                if(v1 != null) {
                    v1.invalidateLayer$ui();
                }

                if(!this.relayoutWithoutParentInProgress) {
                    goto label_46;
                }

                if(v1 == null) {
                    goto label_46;
                }

                LayoutNode.requestRelayout$ui$default(v1, false, 1, null);
                goto label_46;
            }

            this.getLayoutNode().getInnerCoordinator$ui().onPlaced();
        }

    label_46:
        if(v1 == null) {
            this.placeOrder = 0;
        }
        else if(!this.relayoutWithoutParentInProgress && v1.getLayoutState$ui() == LayoutState.LayingOut) {
            if(this.getPlaceOrder() == 0x7FFFFFFF) {
                v3_2 = 1;
            }

            if(v3_2 == 0) {
                InlineClassHelperKt.throwIllegalStateException("Place was called on a node which was placed already");
            }

            this.placeOrder = v1.getLayoutDelegate$ui().getNextChildPlaceOrder$ui();
            LayoutNodeLayoutDelegate v1_1 = v1.getLayoutDelegate$ui();
            v1_1.setNextChildPlaceOrder$ui(v1_1.getNextChildPlaceOrder$ui() + 1);
        }

        this.layoutChildren();
    }

    public final void performMeasure-BRTryo0$ui(long arg4) {
        int v0 = this.getLayoutState() == LayoutState.Idle ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("layout state is not idle before measure starts");
        }

        this.performMeasureConstraints = arg4;
        this.setLayoutState(LayoutState.Measuring);
        this.measurePending = false;
        OwnerSnapshotObserver v4 = LayoutNodeKt.requireOwner(this.getLayoutNode()).getSnapshotObserver();
        OwnerSnapshotObserver.access$getObserver$p(v4).observeReads(this.getLayoutNode(), OwnerSnapshotObserver.access$getOnCommitAffectingMeasure$p(v4), this.getPerformMeasureBlock$ui());
        if(this.getLayoutState() == LayoutState.Measuring) {
            this.markLayoutPending();
            this.setLayoutState(LayoutState.Idle);
        }
    }

    protected void placeAt-f8xVGno(long arg7, float arg9, GraphicsLayer arg10) {
        this.placeSelf-MLgxB_4(arg7, arg9, null, arg10);
    }

    protected void placeAt-f8xVGno(long arg7, float arg9, Function1 arg10) {
        this.placeSelf-MLgxB_4(arg7, arg9, arg10, null);
    }

    private final void placeOuterCoordinator-MLgxB_4(long arg10, float arg12, Function1 arg13, GraphicsLayer arg14) {
        if(this.getLayoutNode().isDeactivated()) {
            InlineClassHelperKt.throwIllegalArgumentException("place is called on a deactivated node");
        }

        this.setLayoutState(LayoutState.LayingOut);
        this.lastPosition = arg10;
        this.lastZIndex = arg12;
        this.lastLayerBlock = arg13;
        this.lastExplicitLayer = arg14;
        this.onNodePlacedCalled = false;
        Owner v1 = LayoutNodeKt.requireOwner(this.getLayoutNode());
        if((this.layoutPending) || !this.isPlaced) {
            this.getAlignmentLines().setUsedByModifierLayout$ui(false);
            this.layoutNodeLayoutDelegate.setCoordinatesAccessedDuringModifierPlacement(false);
            this.placeOuterCoordinatorLayerBlock = arg13;
            this.placeOuterCoordinatorPosition = arg10;
            this.placeOuterCoordinatorZIndex = arg12;
            this.placeOuterCoordinatorLayer = arg14;
            OwnerSnapshotObserver v10 = v1.getSnapshotObserver();
            OwnerSnapshotObserver.access$getObserver$p(v10).observeReads(this.getLayoutNode(), OwnerSnapshotObserver.access$getOnCommitAffectingLayoutModifier$p(v10), this.placeOuterCoordinatorBlock);
        }
        else {
            this.getOuterCoordinator().placeSelfApparentToRealOffset-MLgxB_4(arg10, arg12, arg13, arg14);
            this.onNodePlaced$ui();
        }

        this.setLayoutState(LayoutState.Idle);
        if((this.getOuterCoordinator().isPlacingForAlignment$ui()) && ((this.layoutNodeLayoutDelegate.getCoordinatesAccessedDuringModifierPlacement()) || (this.layoutNodeLayoutDelegate.getCoordinatesAccessedDuringPlacement()))) {
            this.requestLayout();
        }

        this.placedOnce = true;
    }

    private final void placeSelf-MLgxB_4(long arg12, float arg14, Function1 arg15, GraphicsLayer arg16) {
        PlacementScope v2_2;
        LayoutNode v1 = this.getLayoutNode();
        int v0 = 1;
        try {
            this.isPlacedByParent = true;
            if(!IntOffset.equals-impl0(arg12, this.lastPosition) || (this.needsCoordinatesUpdate)) {
                if((this.layoutNodeLayoutDelegate.getCoordinatesAccessedDuringModifierPlacement()) || (this.layoutNodeLayoutDelegate.getCoordinatesAccessedDuringPlacement()) || (this.needsCoordinatesUpdate)) {
                    this.layoutPending = true;
                    this.needsCoordinatesUpdate = false;
                }

                this.notifyChildrenUsingCoordinatesWhilePlacing();
            }

            LookaheadPassDelegate v2 = this.getLookaheadPassDelegate();
            if(v2 != null) {
                v2.onApproachPlacement$ui();
            }

            v2 = this.getLookaheadPassDelegate();
            if(v2 != null && (v2.getNeedsToBePlacedInApproach())) {
                NodeCoordinator v2_1 = this.getOuterCoordinator().getWrappedBy$ui();
                if(v2_1 != null) {
                    v2_2 = v2_1.getPlacementScope();
                    if(v2_2 == null) {
                        goto label_35;
                    }
                }
                else {
                label_35:
                    v2_2 = LayoutNodeKt.requireOwner(this.getLayoutNode()).getPlacementScope();
                }

                PlacementScope v4 = v2_2;
                v2 = this.getLookaheadPassDelegate();
                Intrinsics.checkNotNull(v2);
                LayoutNode v5 = this.getLayoutNode().getParent$ui();
                if(v5 != null) {
                    v5.getLayoutDelegate$ui().setNextChildLookaheadPlaceOrder$ui(0);
                }

                v2.setPlaceOrder$ui(0x7FFFFFFF);
                PlacementScope.place$default(v4, v2, IntOffset.getX-impl(arg12), IntOffset.getY-impl(arg12), 0f, 4, null);
            }

            v2 = this.getLookaheadPassDelegate();
            if(v2 == null || (v2.getPlacedOnce$ui())) {
                v0 = 0;
            }
            else {
            }

            if(v0 != 0) {
                InlineClassHelperKt.throwIllegalStateException("Error: Placement happened before lookahead.");
            }

            this.placeOuterCoordinator-MLgxB_4(arg12, arg14, arg15, arg16);
            return;
        }
        catch(Throwable v0_1) {
            v1.rethrowWithComposeStackTrace(v0_1);
            throw new KotlinNothingValueException();
        }
    }

    public final boolean remeasure-BRTryo0(long arg8) {
        boolean v2_1;
        LayoutNode v0 = this.getLayoutNode();
        try {
            if(this.getLayoutNode().isDeactivated()) {
                InlineClassHelperKt.throwIllegalArgumentException("measure is called on a deactivated node");
            }

            Owner v1 = LayoutNodeKt.requireOwner(this.getLayoutNode());
            LayoutNode v2 = this.getLayoutNode().getParent$ui();
            LayoutNode v3 = this.getLayoutNode();
            boolean v5 = true;
            if(!this.getLayoutNode().getCanMultiMeasure$ui()) {
                if(v2 != null && (v2.getCanMultiMeasure$ui())) {
                    goto label_22;
                }

                v2_1 = false;
            }
            else {
            label_22:
                v2_1 = true;
            }

            v3.setCanMultiMeasure$ui(v2_1);
            if(!this.getLayoutNode().getMeasurePending$ui()) {
                if(!Constraints.equals-impl0(this.getMeasurementConstraints-msEJaDk(), arg8)) {
                }
                else {
                    Owner.forceMeasureTheSubtree$default(v1, this.getLayoutNode(), false, 2, null);
                    this.getLayoutNode().resetSubtreeIntrinsicsUsage$ui();
                    return 0;
                }
            }

            this.getAlignmentLines().setUsedByModifierMeasurement$ui(false);
            this.forEachChildAlignmentLinesOwner(MeasurePassDelegate$remeasure$1$2.INSTANCE);
            this.measuredOnce = true;
            long v1_1 = this.getOuterCoordinator().getSize-YbymL2g();
            this.setMeasurementConstraints-BRTryo0(arg8);
            int v3_1 = this.getLayoutState() == LayoutState.Idle ? 1 : 0;
            if(v3_1 == 0) {
                InlineClassHelperKt.throwIllegalStateException("layout state is not idle before measure starts");
            }

            this.performMeasureConstraints = arg8;
            this.setLayoutState(LayoutState.Measuring);
            this.measurePending = false;
            OwnerSnapshotObserver v8 = LayoutNodeKt.requireOwner(this.getLayoutNode()).getSnapshotObserver();
            OwnerSnapshotObserver.access$getObserver$p(v8).observeReads(this.getLayoutNode(), OwnerSnapshotObserver.access$getOnCommitAffectingMeasure$p(v8), this.getPerformMeasureBlock$ui());
            if(this.getLayoutState() == LayoutState.Measuring) {
                this.markLayoutPending();
                this.setLayoutState(LayoutState.Idle);
            }

            if((IntSize.equals-impl0(this.getOuterCoordinator().getSize-YbymL2g(), v1_1)) && this.getOuterCoordinator().getWidth() == this.getWidth()) {
                if(this.getOuterCoordinator().getHeight() != this.getHeight()) {
                }
                else {
                    v5 = false;
                }
            }

            this.setMeasuredSize-ozmzZPI(IntSize.constructor-impl((((long)this.getOuterCoordinator().getHeight())) & 0xFFFFFFFFL | (((long)this.getOuterCoordinator().getWidth())) << 0x20));
            return v5;
        }
        catch(Throwable v7) {
            v0.rethrowWithComposeStackTrace(v7);
            throw new KotlinNothingValueException();
        }
    }

    public final void replace() {
        MeasurePassDelegate v3;
        GraphicsLayer v8;
        Function1 v7;
        float v6;
        long v4;
        try {
            this.relayoutWithoutParentInProgress = true;
            if(!this.placedOnce) {
                InlineClassHelperKt.throwIllegalStateException("replace called on unplaced item");
            }

            boolean v2 = this.isPlaced;
            v4 = this.lastPosition;
            v6 = this.lastZIndex;
            v7 = this.lastLayerBlock;
            v8 = this.lastExplicitLayer;
            v3 = this;
        }
        catch(Throwable v0) {
            v3 = this;
            goto label_28;
        }

        try {
            v3.placeOuterCoordinator-MLgxB_4(v4, v6, v7, v8);
            if((v2) && !v3.onNodePlacedCalled) {
                LayoutNode v9 = v3.getLayoutNode().getParent$ui();
                if(v9 != null) {
                    LayoutNode.requestRelayout$ui$default(v9, false, 1, null);
                }
            }

            goto label_22;
        }
        catch(Throwable v0) {
        }

        try {
        label_28:
            v3.getLayoutNode().rethrowWithComposeStackTrace(v0);
            throw new KotlinNothingValueException();
        }
        catch(Throwable v0) {
            v3.relayoutWithoutParentInProgress = false;
            throw v0;
        }

    label_22:
        v3.relayoutWithoutParentInProgress = false;
    }

    public void requestLayout() {
        LayoutNode.requestRelayout$ui$default(this.getLayoutNode(), false, 1, null);
    }

    public void requestMeasure() {
        LayoutNode.requestRemeasure$ui$default(this.getLayoutNode(), false, false, false, 7, null);
    }

    public final void setChildDelegatesDirty$ui(boolean arg1) {
        this.childDelegatesDirty = arg1;
    }

    public final void setDuringAlignmentLinesQuery$ui(boolean arg1) {
        this.duringAlignmentLinesQuery = arg1;
    }

    public final void setLayoutState(LayoutState arg1) {
        this.layoutNodeLayoutDelegate.setLayoutState$ui(arg1);
    }

    public final void setMeasuredByParent$ui(UsageByParent arg1) {
        this.measuredByParent = arg1;
    }

    public final void setPlaced$ui(boolean arg1) {
        this.isPlaced = arg1;
    }

    public final void setPlacedByParent$ui(boolean arg1) {
        this.isPlacedByParent = arg1;
    }

    public void setPlacedUnderMotionFrameOfReference(boolean arg1) {
        this.isPlacedUnderMotionFrameOfReference = arg1;
    }

    private final void trackMeasurementByParent(LayoutNode arg5) {
        UsageByParent v5_1;
        LayoutNode v0 = arg5.getParent$ui();
        if(v0 != null) {
            int v5 = this.measuredByParent == UsageByParent.NotUsed || (arg5.getCanMultiMeasure$ui()) ? 1 : 0;
            if(v5 == 0) {
                InlineClassHelperKt.throwIllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }

            v5 = WhenMappings.$EnumSwitchMapping$0[v0.getLayoutState$ui().ordinal()];
            if(v5 == 1) {
                v5_1 = UsageByParent.InMeasureBlock;
            }
            else if(v5 == 2) {
                v5_1 = UsageByParent.InLayoutBlock;
            }
            else {
                throw new IllegalStateException("Measurable could be only measured from the parent\'s measure or layout block. Parents state is " + v0.getLayoutState$ui());
            }

            this.measuredByParent = v5_1;
            return;
        }

        this.measuredByParent = UsageByParent.NotUsed;
    }

    public final boolean updateParentData() {
        if(this.getParentData() == null && this.getOuterCoordinator().getParentData() == null) {
            return 0;
        }

        if(!this.parentDataDirty) {
            return 0;
        }

        this.parentDataDirty = false;
        this.parentData = this.getOuterCoordinator().getParentData();
        return 1;
    }

    public void updatePlacedUnderMotionFrameOfReference(boolean arg2) {
        if(arg2 != this.getOuterCoordinator().isPlacedUnderMotionFrameOfReference()) {
            this.getOuterCoordinator().setPlacedUnderMotionFrameOfReference(arg2);
            this.needsCoordinatesUpdate = true;
        }

        this.setPlacedUnderMotionFrameOfReference(arg2);
    }
}

