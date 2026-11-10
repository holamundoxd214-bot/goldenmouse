package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0000\n\u0002\b9\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002½\u0001B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u001A\u001A\u00020\u001BH\u0000¢\u0006\u0002\b\u001CJ\r\u0010\u001D\u001A\u00020\u001BH\u0000¢\u0006\u0002\b\u001EJ\r\u0010\\\u001A\u00020\u001BH\u0000¢\u0006\u0002\b]J\u001D\u0010i\u001A\u00020\u001B2\u0012\u0010j\u001A\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001B0KH\u0082\bJ\b\u0010m\u001A\u00020\u001BH\u0016J\b\u0010p\u001A\u00020\u001BH\u0002J\u0015\u0010q\u001A\u00020\u001B2\u0006\u0010r\u001A\u00020\nH\u0000¢\u0006\u0002\bsJ\u0014\u0010t\u001A\u000E\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020!0uH\u0016J\u001C\u0010z\u001A\u00020\u001B2\u0012\u0010j\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001B0KH\u0016J\b\u0010{\u001A\u00020\u001BH\u0016J\b\u0010|\u001A\u00020\u001BH\u0016J\u0006\u0010}\u001A\u00020\u001BJ\u0019\u0010~\u001A\u00020\u00012\u0006\u0010\u007F\u001A\u00020AH\u0016¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0012\u0010\u0082\u0001\u001A\u00020\u001B2\u0007\u0010\u0083\u0001\u001A\u00020\u0017H\u0002J\u001A\u0010\u008D\u0001\u001A\u00020\u001B2\u0006\u0010\u007F\u001A\u00020AH\u0000¢\u0006\u0006\b\u008E\u0001\u0010\u008F\u0001J\u0018\u0010\u0090\u0001\u001A\u00020\n2\u0006\u0010\u007F\u001A\u00020A¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J@\u0010\u0093\u0001\u001A\u00020\u001B2\u0007\u0010\u0094\u0001\u001A\u00020F2\u0007\u0010\u0095\u0001\u001A\u00020I2\u001A\u0010\u0096\u0001\u001A\u0015\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001B\u0018\u00010K¢\u0006\u0002\bMH\u0014¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J-\u0010\u0093\u0001\u001A\u00020\u001B2\u0007\u0010\u0094\u0001\u001A\u00020F2\u0007\u0010\u0095\u0001\u001A\u00020I2\u0007\u0010\u0099\u0001\u001A\u00020OH\u0014¢\u0006\u0006\b\u0097\u0001\u0010\u009A\u0001J\u0012\u0010\u009D\u0001\u001A\u00020\u001B2\u0007\u0010\u009E\u0001\u001A\u00020\nH\u0016JK\u0010 \u0001\u001A\u00020\u001B2\u0007\u0010\u0094\u0001\u001A\u00020F2\u0007\u0010\u0095\u0001\u001A\u00020I2\u001A\u0010\u0096\u0001\u001A\u0015\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001B\u0018\u00010K¢\u0006\u0002\bM2\t\u0010\u0099\u0001\u001A\u0004\u0018\u00010OH\u0002¢\u0006\u0006\b¡\u0001\u0010¢\u0001J\u0013\u0010§\u0001\u001A\u00020!2\u0007\u0010¨\u0001\u001A\u00020vH\u0096\u0002J\u0012\u0010©\u0001\u001A\u00020!2\u0007\u0010ª\u0001\u001A\u00020!H\u0016J\u0012\u0010«\u0001\u001A\u00020!2\u0007\u0010ª\u0001\u001A\u00020!H\u0016J\u0012\u0010¬\u0001\u001A\u00020!2\u0007\u0010­\u0001\u001A\u00020!H\u0016J\u0012\u0010®\u0001\u001A\u00020!2\u0007\u0010­\u0001\u001A\u00020!H\u0016J\t\u0010¯\u0001\u001A\u00020\u001BH\u0002J\u0010\u0010°\u0001\u001A\u00020\u001B2\u0007\u0010±\u0001\u001A\u00020\nJ\u0007\u0010²\u0001\u001A\u00020\u001BJ\u0007\u0010³\u0001\u001A\u00020\nJ\u000F\u0010µ\u0001\u001A\u00020\u001BH\u0000¢\u0006\u0003\b¶\u0001J\t\u0010·\u0001\u001A\u00020\u001BH\u0002J\t\u0010¸\u0001\u001A\u00020\u001BH\u0002J\t\u0010¹\u0001\u001A\u00020\u001BH\u0002J\u0007\u0010º\u0001\u001A\u00020\u001BJ\u0007\u0010»\u0001\u001A\u00020\u001BJ\u0007\u0010¼\u0001\u001A\u00020\u001BR\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\n8B@BX\u0082\u000E¢\u0006\f\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR$\u0010\u0010\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\n8B@BX\u0082\u000E¢\u0006\f\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR$\u0010\u0013\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\n8B@BX\u0082\u000E¢\u0006\f\u001A\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000FR\u0014\u0010\u0016\u001A\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u000E\u0010\u001F\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020!X\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\"\u001A\u00020!2\u0006\u0010\t\u001A\u00020!@PX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001A\u0010\'\u001A\u00020(X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010-\u001A\u00020.8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b/\u00100R\u0014\u00101\u001A\u0002028BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b3\u00104R$\u00106\u001A\u0002052\u0006\u0010\t\u001A\u0002058B@BX\u0082\u000E¢\u0006\f\u001A\u0004\b7\u00108\"\u0004\b9\u0010:R\u000E\u0010;\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010<\u001A\u00020\nX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b=\u0010\r\"\u0004\b>\u0010\u000FR\u000E\u0010?\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0013\u0010@\u001A\u0004\u0018\u00010A8F¢\u0006\u0006\u001A\u0004\bB\u0010CR\u0010\u0010D\u001A\u0004\u0018\u00010AX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010E\u001A\u00020FX\u0082\u000E¢\u0006\u0004\n\u0002\u0010GR\u000E\u0010H\u001A\u00020IX\u0082\u000E¢\u0006\u0002\n\u0000R!\u0010J\u001A\u0015\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001B\u0018\u00010K¢\u0006\u0002\bMX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010N\u001A\u0004\u0018\u00010OX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010P\u001A\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bQ\u0010\rR\u000E\u0010R\u001A\u00020SX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010T\u001A\u0002028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bU\u00104R\u0014\u0010V\u001A\u00020WX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\bX\u0010YR\u0014\u0010Z\u001A\b\u0012\u0004\u0012\u00020\u00000[X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010^\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b_\u0010\rR\u001A\u0010`\u001A\u00020\nX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\ba\u0010\r\"\u0004\bb\u0010\u000FR\u001A\u0010c\u001A\b\u0012\u0004\u0012\u00020\u00000d8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\be\u0010fR\u001E\u0010g\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\n@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\bh\u0010\rR\u0014\u0010k\u001A\b\u0012\u0004\u0012\u00020\u001B0lX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010n\u001A\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bo\u0010\rR\u0016\u0010w\u001A\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bx\u0010yR\u000F\u0010\u0084\u0001\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\'\u0010\u0086\u0001\u001A\u0005\u0018\u00010\u0085\u00012\t\u0010\t\u001A\u0005\u0018\u00010\u0085\u0001@RX\u0096\u000E¢\u0006\n\n\u0000\u001A\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0011\u0010\u0089\u0001\u001A\u00020AX\u0082\u000E¢\u0006\u0004\n\u0002\u0010GR\u001D\u0010\u008A\u0001\u001A\b\u0012\u0004\u0012\u00020\u001B0lX\u0080\u0004¢\u0006\n\n\u0000\u001A\u0006\b\u008B\u0001\u0010\u008C\u0001R\u001D\u0010\u009B\u0001\u001A\u00020\nX\u0096\u000E¢\u0006\u0010\n\u0000\u001A\u0005\b\u009B\u0001\u0010\r\"\u0005\b\u009C\u0001\u0010\u000FR\u0015\u0010\u009F\u0001\u001A\b\u0012\u0004\u0012\u00020\u001B0lX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010£\u0001\u001A\u00020!8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b¤\u0001\u0010$R\u0016\u0010¥\u0001\u001A\u00020!8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b¦\u0001\u0010$R\u000F\u0010´\u0001\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006¾\u0001"}, d2={"Landroidx/compose/ui/node/LookaheadPassDelegate;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "layoutNodeLayoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "<init>", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "value", "", "measurePending", "getMeasurePending", "()Z", "setMeasurePending", "(Z)V", "layoutPending", "getLayoutPending", "setLayoutPending", "layoutPendingForAlignment", "getLayoutPendingForAlignment", "setLayoutPendingForAlignment", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "markLayoutPending", "", "markLayoutPending$ui", "markMeasurePending", "markMeasurePending$ui", "relayoutWithoutParentInProgress", "previousPlaceOrder", "", "placeOrder", "getPlaceOrder", "()I", "setPlaceOrder$ui", "(I)V", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "measurePassDelegate", "Landroidx/compose/ui/node/MeasurePassDelegate;", "getMeasurePassDelegate$ui", "()Landroidx/compose/ui/node/MeasurePassDelegate;", "outerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getOuterCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "layoutState", "getLayoutState", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "setLayoutState", "(Landroidx/compose/ui/node/LayoutNode$LayoutState;)V", "duringAlignmentLinesQuery", "placedOnce", "getPlacedOnce$ui", "setPlacedOnce$ui", "measuredOnce", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lookaheadConstraints", "lastPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "lastZIndex", "", "lastLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "lastExplicitLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "isPlaced", "isPlaced$ui", "_placedState", "Landroidx/compose/ui/node/LookaheadPassDelegate$PlacedState;", "innerCoordinator", "getInnerCoordinator", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "_childDelegates", "Landroidx/compose/runtime/collection/MutableVector;", "onApproachPlacement", "onApproachPlacement$ui", "needsToBePlacedInApproach", "getNeedsToBePlacedInApproach", "childDelegatesDirty", "getChildDelegatesDirty$ui", "setChildDelegatesDirty$ui", "childDelegates", "", "getChildDelegates$ui", "()Ljava/util/List;", "layingOutChildren", "getLayingOutChildren", "forEachChildDelegate", "block", "layoutChildrenBlock", "Lkotlin/Function0;", "layoutChildren", "detachedFromParentLookaheadPlacement", "getDetachedFromParentLookaheadPlacement", "checkChildrenPlaceOrderForUpdates", "markNodeAndSubtreeAsNotPlaced", "inLookahead", "markNodeAndSubtreeAsNotPlaced$ui", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "forEachChildAlignmentLinesOwner", "requestLayout", "requestMeasure", "notifyChildrenUsingLookaheadCoordinatesWhilePlacing", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "trackLookaheadMeasurementByParent", "node", "parentDataDirty", "", "parentData", "getParentData", "()Ljava/lang/Object;", "performMeasureConstraints", "performMeasureBlock", "getPerformMeasureBlock$ui", "()Lkotlin/jvm/functions/Function0;", "performMeasure", "performMeasure-BRTryo0$ui", "(J)V", "remeasure", "remeasure-BRTryo0", "(J)Z", "placeAt", "position", "zIndex", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "layer", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "updatePlacedUnderMotionFrameOfReference", "newMFR", "layoutModifierBlock", "placeSelf", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "measuredWidth", "getMeasuredWidth", "measuredHeight", "getMeasuredHeight", "get", "alignmentLine", "minIntrinsicWidth", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "onIntrinsicsQueried", "invalidateIntrinsicsParent", "forceRequest", "invalidateParentData", "updateParentData", "onNodePlacedCalled", "onNodePlaced", "onNodePlaced$ui", "clearPlaceOrder", "markNodeAndSubtreeAsPlaced", "onBeforeLayoutChildren", "replace", "onNodeDetached", "onAttachedToNullParent", "PlacedState", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LookaheadPassDelegate extends Placeable implements Measurable, AlignmentLinesOwner, MotionReferencePlacementDelegate {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/ui/node/LookaheadPassDelegate$PlacedState;", "", "<init>", "(Ljava/lang/String;I)V", "IsPlacedInLookahead", "IsPlacedInApproach", "IsNotPlaced", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) enum PlacedState {
        public static final enum PlacedState IsNotPlaced;
        public static final enum PlacedState IsPlacedInApproach;
        public static final enum PlacedState IsPlacedInLookahead;

        private static final PlacedState[] $values() {
            return new PlacedState[]{PlacedState.IsPlacedInLookahead, PlacedState.IsPlacedInApproach, PlacedState.IsNotPlaced};
        }

        static {
            PlacedState.IsPlacedInLookahead = new PlacedState("IsPlacedInLookahead", 0);
            PlacedState.IsPlacedInApproach = new PlacedState("IsPlacedInApproach", 1);
            PlacedState.IsNotPlaced = new PlacedState("IsNotPlaced", 2);
            PlacedState[] v0 = PlacedState.$values();
            PlacedState.$VALUES = v0;
            PlacedState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private PlacedState(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return PlacedState.$ENTRIES;
        }

        public static PlacedState valueOf(String arg1) {
            return Enum.valueOf(PlacedState.class, arg1);
        }

        public static PlacedState[] values() {
            return PlacedState.$VALUES.clone();
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[LayoutState.values().length];
            try {
                v0[LayoutState.LookaheadMeasuring.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
            label_7:
                int v2 = 2;
                try {
                    v0[LayoutState.Measuring.ordinal()] = v2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[LayoutState.LayingOut.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[LayoutState.LookaheadLayingOut.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            v0 = new int[UsageByParent.values().length];
                            try {
                                v0[UsageByParent.InMeasureBlock.ordinal()] = 1;
                                goto label_26;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_26:
                                    v0[UsageByParent.InLayoutBlock.ordinal()] = v2;
                                    goto label_29;
                                }
                                catch(NoSuchFieldError ) {
                                label_29:
                                    WhenMappings.$EnumSwitchMapping$1 = v0;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private final MutableVector _childDelegates;
    private PlacedState _placedState;
    private final AlignmentLines alignmentLines;
    private boolean childDelegatesDirty;
    private boolean duringAlignmentLinesQuery;
    private boolean isPlacedUnderMotionFrameOfReference;
    private GraphicsLayer lastExplicitLayer;
    private Function1 lastLayerBlock;
    private long lastPosition;
    private float lastZIndex;
    private boolean layingOutChildren;
    private final Function0 layoutChildrenBlock;
    private final Function0 layoutModifierBlock;
    private final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
    private Constraints lookaheadConstraints;
    private UsageByParent measuredByParent;
    private boolean measuredOnce;
    private boolean onNodePlacedCalled;
    private Object parentData;
    private boolean parentDataDirty;
    private final Function0 performMeasureBlock;
    private long performMeasureConstraints;
    private int placeOrder;
    private boolean placedOnce;
    private int previousPlaceOrder;
    private boolean relayoutWithoutParentInProgress;

    static {
    }

    public LookaheadPassDelegate(LayoutNodeLayoutDelegate arg7) {
        super();
        this.layoutNodeLayoutDelegate = arg7;
        this.previousPlaceOrder = 0x7FFFFFFF;
        this.placeOrder = 0x7FFFFFFF;
        this.measuredByParent = UsageByParent.NotUsed;
        this.lastPosition = IntOffset.Companion.getZero-nOcc-ac();
        this._placedState = PlacedState.IsNotPlaced;
        this.alignmentLines = new LookaheadAlignmentLines(this);
        this._childDelegates = new MutableVector(new LookaheadPassDelegate[16], 0);
        this.childDelegatesDirty = true;
        this.layoutChildrenBlock = new LookaheadPassDelegate$layoutChildrenBlock$1(this);
        this.parentDataDirty = true;
        this.parentData = this.getMeasurePassDelegate$ui().getParentData();
        this.performMeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        this.performMeasureBlock = new LookaheadPassDelegate$performMeasureBlock$1(this);
        this.layoutModifierBlock = new LookaheadPassDelegate$layoutModifierBlock$1(this);
    }

    public static final void access$checkChildrenPlaceOrderForUpdates(LookaheadPassDelegate arg0) {
        arg0.checkChildrenPlaceOrderForUpdates();
    }

    public static final void access$clearPlaceOrder(LookaheadPassDelegate arg0) {
        arg0.clearPlaceOrder();
    }

    public static final long access$getLastPosition$p(LookaheadPassDelegate arg2) {
        return arg2.lastPosition;
    }

    public static final LayoutNode access$getLayoutNode(LookaheadPassDelegate arg0) {
        return arg0.getLayoutNode();
    }

    public static final LayoutNodeLayoutDelegate access$getLayoutNodeLayoutDelegate$p(LookaheadPassDelegate arg0) {
        return arg0.layoutNodeLayoutDelegate;
    }

    public static final NodeCoordinator access$getOuterCoordinator(LookaheadPassDelegate arg0) {
        return arg0.getOuterCoordinator();
    }

    public static final long access$getPerformMeasureConstraints$p(LookaheadPassDelegate arg2) {
        return arg2.performMeasureConstraints;
    }

    public Map calculateAlignmentLines() {
        if(!this.duringAlignmentLinesQuery) {
            if(this.getLayoutState() == LayoutState.LookaheadMeasuring) {
                this.getAlignmentLines().setUsedByModifierMeasurement$ui(true);
                if(this.getAlignmentLines().getDirty$ui()) {
                    this.layoutNodeLayoutDelegate.markLookaheadLayoutPending$ui();
                }
            }
            else {
                this.getAlignmentLines().setUsedByModifierLayout$ui(true);
            }
        }

        LookaheadDelegate v0 = this.getInnerCoordinator().getLookaheadDelegate();
        if(v0 != null) {
            v0.setPlacingForAlignment$ui(true);
        }

        this.layoutChildren();
        v0 = this.getInnerCoordinator().getLookaheadDelegate();
        if(v0 != null) {
            v0.setPlacingForAlignment$ui(false);
        }

        return this.getAlignmentLines().getLastCalculation();
    }

    private final void checkChildrenPlaceOrderForUpdates() {
        MutableVector v5 = this.getLayoutNode().get_children$ui();
        Object[] v0 = v5.content;
        int v5_1 = v5.getSize();
        int v1;
        for(v1 = 0; v1 < v5_1; ++v1) {
            LookaheadPassDelegate v2 = v0[v1].getLayoutDelegate$ui().getLookaheadPassDelegate$ui();
            Intrinsics.checkNotNull(v2);
            if(v2.previousPlaceOrder != v2.getPlaceOrder() && v2.getPlaceOrder() == 0x7FFFFFFF) {
                v2.markNodeAndSubtreeAsNotPlaced$ui(true);
            }
        }
    }

    private final void clearPlaceOrder() {
        int v1 = 0;
        this.layoutNodeLayoutDelegate.setNextChildLookaheadPlaceOrder$ui(0);
        MutableVector v5 = this.getLayoutNode().get_children$ui();
        Object[] v0 = v5.content;
        int v5_1 = v5.getSize();
        while(v1 < v5_1) {
            LookaheadPassDelegate v2 = v0[v1].getLayoutDelegate$ui().getLookaheadPassDelegate$ui();
            Intrinsics.checkNotNull(v2);
            v2.previousPlaceOrder = v2.getPlaceOrder();
            v2.setPlaceOrder$ui(0x7FFFFFFF);
            if(v2.measuredByParent == UsageByParent.InLayoutBlock) {
                v2.measuredByParent = UsageByParent.NotUsed;
            }

            ++v1;
        }
    }

    public void forEachChildAlignmentLinesOwner(Function1 arg4) {
        MutableVector v3 = this.getLayoutNode().get_children$ui();
        Object[] v0 = v3.content;
        int v3_1 = v3.getSize();
        int v1;
        for(v1 = 0; v1 < v3_1; ++v1) {
            AlignmentLinesOwner v2 = v0[v1].getLayoutDelegate$ui().getLookaheadAlignmentLinesOwner$ui();
            Intrinsics.checkNotNull(v2);
            arg4.invoke(v2);
        }
    }

    private final void forEachChildDelegate(Function1 arg4) {
        MutableVector v3 = this.getLayoutNode().get_children$ui();
        Object[] v0 = v3.content;
        int v3_1 = v3.getSize();
        int v1;
        for(v1 = 0; v1 < v3_1; ++v1) {
            LookaheadPassDelegate v2 = v0[v1].getLayoutDelegate$ui().getLookaheadPassDelegate$ui();
            Intrinsics.checkNotNull(v2);
            arg4.invoke(v2);
        }
    }

    public int get(AlignmentLine arg5) {
        LayoutNode v0 = this.getLayoutNode().getParent$ui();
        LayoutState v1 = null;
        LayoutState v0_1 = v0 != null ? v0.getLayoutState$ui() : v1;
        if(v0_1 == LayoutState.LookaheadMeasuring) {
            this.getAlignmentLines().setUsedDuringParentMeasurement$ui(true);
        }
        else {
            v0 = this.getLayoutNode().getParent$ui();
            if(v0 != null) {
                v1 = v0.getLayoutState$ui();
            }

            if(v1 != LayoutState.LookaheadLayingOut) {
                goto label_21;
            }

            this.getAlignmentLines().setUsedDuringParentLayout$ui(true);
        }

    label_21:
        this.duringAlignmentLinesQuery = true;
        LookaheadDelegate v0_2 = this.getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(v0_2);
        int v5 = v0_2.get(arg5);
        this.duringAlignmentLinesQuery = false;
        return v5;
    }

    public AlignmentLines getAlignmentLines() {
        return this.alignmentLines;
    }

    public final List getChildDelegates$ui() {
        LookaheadPassDelegate v6_1;
        this.getLayoutNode().getChildren$ui();
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
                v6_1 = ((LayoutNode)v6).getLayoutDelegate$ui().getLookaheadPassDelegate$ui();
                Intrinsics.checkNotNull(v6_1);
                v1.add(v6_1);
            }
            else {
                v6_1 = ((LayoutNode)v6).getLayoutDelegate$ui().getLookaheadPassDelegate$ui();
                Intrinsics.checkNotNull(v6_1);
                v1.set(v5, v6_1);
            }
        }

        v1.removeRange(v0.getChildren$ui().size(), v1.getSize());
        this.childDelegatesDirty = false;
        return this._childDelegates.asMutableList();
    }

    public final boolean getChildDelegatesDirty$ui() {
        return this.childDelegatesDirty;
    }

    private final boolean getDetachedFromParentLookaheadPlacement() {
        return this.layoutNodeLayoutDelegate.getDetachedFromParentLookaheadPlacement$ui();
    }

    public NodeCoordinator getInnerCoordinator() {
        return this.getLayoutNode().getInnerCoordinator$ui();
    }

    public final Constraints getLastConstraints-DWUhwKw() {
        return this.lookaheadConstraints;
    }

    public final boolean getLayingOutChildren() {
        return this.layingOutChildren;
    }

    private final LayoutNode getLayoutNode() {
        return this.layoutNodeLayoutDelegate.getLayoutNode$ui();
    }

    private final boolean getLayoutPending() {
        return this.layoutNodeLayoutDelegate.getLookaheadLayoutPending$ui();
    }

    private final boolean getLayoutPendingForAlignment() {
        return this.layoutNodeLayoutDelegate.getLookaheadLayoutPendingForAlignment$ui();
    }

    private final LayoutState getLayoutState() {
        return this.layoutNodeLayoutDelegate.getLayoutState$ui();
    }

    public final MeasurePassDelegate getMeasurePassDelegate$ui() {
        return this.layoutNodeLayoutDelegate.getMeasurePassDelegate$ui();
    }

    private final boolean getMeasurePending() {
        return this.layoutNodeLayoutDelegate.getLookaheadMeasurePending$ui();
    }

    public final UsageByParent getMeasuredByParent$ui() {
        return this.measuredByParent;
    }

    public int getMeasuredHeight() {
        LookaheadDelegate v0 = this.getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(v0);
        return v0.getMeasuredHeight();
    }

    public int getMeasuredWidth() {
        LookaheadDelegate v0 = this.getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(v0);
        return v0.getMeasuredWidth();
    }

    public final boolean getNeedsToBePlacedInApproach() {
        if(!LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.getLayoutNode())) {
            if(this.getDetachedFromParentLookaheadPlacement()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final NodeCoordinator getOuterCoordinator() {
        return this.layoutNodeLayoutDelegate.getOuterCoordinator();
    }

    public AlignmentLinesOwner getParentAlignmentLinesOwner() {
        LayoutNode v0 = this.getLayoutNode().getParent$ui();
        if(v0 != null) {
            LayoutNodeLayoutDelegate v0_1 = v0.getLayoutDelegate$ui();
            if(v0_1 != null) {
                return v0_1.getLookaheadAlignmentLinesOwner$ui();
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

    public final boolean getPlacedOnce$ui() {
        return this.placedOnce;
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
                    if(v2.getLookaheadRoot$ui() != null) {
                        v2.requestLookaheadRelayout$ui(arg9);
                        return;
                    }

                    v2.requestRelayout$ui(arg9);
                    return;
                }

                throw new IllegalStateException("Intrinsics isn\'t used by the parent".toString());
            }

            if(v2.getLookaheadRoot$ui() != null) {
                LayoutNode.requestLookaheadRemeasure$ui$default(v2, arg9, false, false, 6, null);
                return;
            }

            LayoutNode.requestRemeasure$ui$default(v2, arg9, false, false, 6, null);
        }
    }

    public final void invalidateParentData() {
        this.parentDataDirty = true;
    }

    public final boolean isPlaced$ui() {
        if(this._placedState != PlacedState.IsNotPlaced) {
            return 1;
        }

        return 0;
    }

    public boolean isPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    public void layoutChildren() {
        this.layingOutChildren = true;
        this.getAlignmentLines().recalculateQueryOwner();
        if(this.getLayoutPending()) {
            this.onBeforeLayoutChildren();
        }

        LookaheadDelegate v1 = this.getInnerCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(v1);
        if((this.getLayoutPendingForAlignment()) || !this.duringAlignmentLinesQuery && !v1.isPlacingForAlignment$ui() && (this.getLayoutPending())) {
            this.setLayoutPending(false);
            LayoutState v2 = this.getLayoutState();
            this.setLayoutState(LayoutState.LookaheadLayingOut);
            this.layoutNodeLayoutDelegate.setLookaheadCoordinatesAccessedDuringPlacement(false);
            OwnerSnapshotObserver v4 = LayoutNodeKt.requireOwner(this.getLayoutNode()).getSnapshotObserver();
            OwnerSnapshotObserver.access$getObserver$p(v4).observeReads(this.getLayoutNode(), OwnerSnapshotObserver.access$getOnCommitAffectingLookahead$p(v4), this.layoutChildrenBlock);
            this.setLayoutState(v2);
            if((this.layoutNodeLayoutDelegate.getLookaheadCoordinatesAccessedDuringPlacement()) && (v1.isPlacingForAlignment$ui())) {
                this.requestLayout();
            }

            this.setLayoutPendingForAlignment(false);
        }

        if(this.getAlignmentLines().getUsedDuringParentLayout$ui()) {
            this.getAlignmentLines().setPreviousUsedDuringParentLayout$ui(true);
        }

        if((this.getAlignmentLines().getDirty$ui()) && (this.getAlignmentLines().getRequired$ui())) {
            this.getAlignmentLines().recalculate();
        }

        this.layingOutChildren = false;
    }

    public final void markLayoutPending$ui() {
        this.setLayoutPending(true);
        this.setLayoutPendingForAlignment(true);
    }

    public final void markMeasurePending$ui() {
        this.setMeasurePending(true);
    }

    public final void markNodeAndSubtreeAsNotPlaced$ui(boolean arg4) {
        if((!arg4 || !this.getNeedsToBePlacedInApproach()) && ((arg4) || (this.getNeedsToBePlacedInApproach()))) {
            this._placedState = PlacedState.IsNotPlaced;
            MutableVector v3 = this.getLayoutNode().get_children$ui();
            Object[] v4 = v3.content;
            int v3_1 = v3.getSize();
            int v0;
            for(v0 = 0; v0 < v3_1; ++v0) {
                LookaheadPassDelegate v1 = v4[v0].getLayoutDelegate$ui().getLookaheadPassDelegate$ui();
                Intrinsics.checkNotNull(v1);
                v1.markNodeAndSubtreeAsNotPlaced$ui(true);
            }
        }
    }

    private final void markNodeAndSubtreeAsPlaced() {
        PlacedState v0 = this._placedState;
        this._placedState = this.getDetachedFromParentLookaheadPlacement() ? PlacedState.IsPlacedInApproach : PlacedState.IsPlacedInLookahead;
        if(v0 != PlacedState.IsPlacedInLookahead && (this.layoutNodeLayoutDelegate.getLookaheadMeasurePending$ui())) {
            LayoutNode.requestLookaheadRemeasure$ui$default(this.getLayoutNode(), true, false, false, 6, null);
        }

        MutableVector v7 = this.getLayoutNode().get_children$ui();
        Object[] v0_1 = v7.content;
        int v7_1 = v7.getSize();
        int v1;
        for(v1 = 0; true; ++v1) {
            if(v1 >= v7_1) {
                return;
            }

            Object v2 = v0_1[v1];
            LookaheadPassDelegate v3 = ((LayoutNode)v2).getLookaheadPassDelegate$ui();
            if(v3 == null) {
                break;
            }

            if(v3.getPlaceOrder() != 0x7FFFFFFF) {
                v3.markNodeAndSubtreeAsPlaced();
                ((LayoutNode)v2).rescheduleRemeasureOrRelayout$ui(((LayoutNode)v2));
            }
        }

        throw new IllegalArgumentException("Error: Child node\'s lookahead pass delegate cannot be null when in a lookahead scope.".toString());
    }

    public int maxIntrinsicHeight(int arg1) {
        this.onIntrinsicsQueried();
        LookaheadDelegate v0 = this.getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(v0);
        return v0.maxIntrinsicHeight(arg1);
    }

    public int maxIntrinsicWidth(int arg1) {
        this.onIntrinsicsQueried();
        LookaheadDelegate v0 = this.getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(v0);
        return v0.maxIntrinsicWidth(arg1);
    }

    public Placeable measure-BRTryo0(long arg4) {
        LayoutNode v0 = this.getLayoutNode().getParent$ui();
        LayoutState v1 = null;
        LayoutState v0_1 = v0 != null ? v0.getLayoutState$ui() : v1;
        if(v0_1 != LayoutState.LookaheadMeasuring) {
            v0 = this.getLayoutNode().getParent$ui();
            if(v0 != null) {
                v1 = v0.getLayoutState$ui();
            }

            if(v1 != LayoutState.LookaheadLayingOut) {
                goto label_18;
            }

            goto label_15;
        }
        else {
        label_15:
            this.layoutNodeLayoutDelegate.setDetachedFromParentLookaheadPass$ui(false);
        }

    label_18:
        this.trackLookaheadMeasurementByParent(this.getLayoutNode());
        if(this.getLayoutNode().getIntrinsicsUsageByParent$ui() == UsageByParent.NotUsed) {
            this.getLayoutNode().clearSubtreeIntrinsicsUsage$ui();
        }

        this.remeasure-BRTryo0(arg4);
        return this;
    }

    public int minIntrinsicHeight(int arg1) {
        this.onIntrinsicsQueried();
        LookaheadDelegate v0 = this.getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(v0);
        return v0.minIntrinsicHeight(arg1);
    }

    public int minIntrinsicWidth(int arg1) {
        this.onIntrinsicsQueried();
        LookaheadDelegate v0 = this.getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(v0);
        return v0.minIntrinsicWidth(arg1);
    }

    public final void notifyChildrenUsingLookaheadCoordinatesWhilePlacing() {
        if(this.layoutNodeLayoutDelegate.getChildrenAccessingLookaheadCoordinatesDuringPlacement() > 0) {
            MutableVector v7 = this.getLayoutNode().get_children$ui();
            Object[] v0 = v7.content;
            int v7_1 = v7.getSize();
            int v2;
            for(v2 = 0; v2 < v7_1; ++v2) {
                Object v3 = v0[v2];
                LayoutNodeLayoutDelegate v4 = ((LayoutNode)v3).getLayoutDelegate$ui();
                if(((v4.getLookaheadCoordinatesAccessedDuringPlacement()) || (v4.getLookaheadCoordinatesAccessedDuringModifierPlacement())) && !v4.getLookaheadLayoutPending$ui()) {
                    LayoutNode.requestLookaheadRelayout$ui$default(((LayoutNode)v3), false, 1, null);
                }

                LookaheadPassDelegate v3_1 = v4.getLookaheadPassDelegate$ui();
                if(v3_1 != null) {
                    v3_1.notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
                }
            }
        }
    }

    public final void onApproachPlacement$ui() {
        if(this._placedState == PlacedState.IsNotPlaced) {
            if(LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.getLayoutNode())) {
            }
            else {
                this.layoutNodeLayoutDelegate.setDetachedFromParentLookaheadPlacement$ui(true);
            }
        }
    }

    public final void onAttachedToNullParent() {
        this._placedState = PlacedState.IsPlacedInLookahead;
    }

    private final void onBeforeLayoutChildren() {
        MutableVector v0 = this.getLayoutNode().get_children$ui();
        Object[] v1 = v0.content;
        int v0_1 = v0.getSize();
        int v2;
        for(v2 = 0; v2 < v0_1; ++v2) {
            Object v3 = v1[v2];
            if((((LayoutNode)v3).getLookaheadMeasurePending$ui()) && ((LayoutNode)v3).getMeasuredByParentInLookahead$ui() == UsageByParent.InMeasureBlock) {
                LookaheadPassDelegate v4 = ((LayoutNode)v3).getLayoutDelegate$ui().getLookaheadPassDelegate$ui();
                Intrinsics.checkNotNull(v4);
                Constraints v3_1 = ((LayoutNode)v3).getLayoutDelegate$ui().getLastLookaheadConstraints-DWUhwKw();
                Intrinsics.checkNotNull(v3_1);
                if(v4.remeasure-BRTryo0(v3_1.unbox-impl())) {
                    LayoutNode.requestLookaheadRemeasure$ui$default(this.getLayoutNode(), false, false, false, 7, null);
                }
            }
        }
    }

    private final void onIntrinsicsQueried() {
        UsageByParent v0_1;
        LayoutNode.requestLookaheadRemeasure$ui$default(this.getLayoutNode(), false, false, false, 7, null);
        LayoutNode v0 = this.getLayoutNode().getParent$ui();
        if(v0 != null && this.getLayoutNode().getIntrinsicsUsageByParent$ui() == UsageByParent.NotUsed) {
            LayoutNode v6 = this.getLayoutNode();
            int v1 = WhenMappings.$EnumSwitchMapping$0[v0.getLayoutState$ui().ordinal()];
            if(v1 == 2) {
                v0_1 = UsageByParent.InMeasureBlock;
            }
            else if(v1 != 3) {
                v0_1 = v0.getIntrinsicsUsageByParent$ui();
            }
            else {
                v0_1 = UsageByParent.InLayoutBlock;
            }

            v6.setIntrinsicsUsageByParent$ui(v0_1);
        }
    }

    public final void onNodeDetached() {
        this.setPlaceOrder$ui(0x7FFFFFFF);
        this.previousPlaceOrder = 0x7FFFFFFF;
        this._placedState = PlacedState.IsNotPlaced;
    }

    public final void onNodePlaced$ui() {
        this.onNodePlacedCalled = true;
        LayoutNode v1 = this.getLayoutNode().getParent$ui();
        int v4 = 0;
        if(this._placedState != PlacedState.IsPlacedInLookahead && !this.getDetachedFromParentLookaheadPlacement() || this._placedState != PlacedState.IsPlacedInApproach && (this.getDetachedFromParentLookaheadPlacement())) {
            this.markNodeAndSubtreeAsPlaced();
            if((this.relayoutWithoutParentInProgress) && v1 != null) {
                LayoutNode.requestLookaheadRelayout$ui$default(v1, false, 1, null);
            }
        }

        if(v1 == null) {
            this.setPlaceOrder$ui(0);
        }
        else if(!this.relayoutWithoutParentInProgress) {
            if(v1.getLayoutState$ui() != LayoutState.LayingOut && v1.getLayoutState$ui() != LayoutState.LookaheadLayingOut) {
                goto label_46;
            }

            if(this.getPlaceOrder() == 0x7FFFFFFF) {
                v4 = 1;
            }

            if(v4 == 0) {
                InlineClassHelperKt.throwIllegalStateException("Place was called on a node which was placed already");
            }

            this.setPlaceOrder$ui(v1.getLayoutDelegate$ui().getNextChildLookaheadPlaceOrder$ui());
            LayoutNodeLayoutDelegate v1_1 = v1.getLayoutDelegate$ui();
            v1_1.setNextChildLookaheadPlaceOrder$ui(v1_1.getNextChildLookaheadPlaceOrder$ui() + 1);
        }

    label_46:
        this.layoutChildren();
    }

    public final void performMeasure-BRTryo0$ui(long arg3) {
        this.setLayoutState(LayoutState.LookaheadMeasuring);
        this.setMeasurePending(false);
        this.performMeasureConstraints = arg3;
        OwnerSnapshotObserver v3 = LayoutNodeKt.requireOwner(this.getLayoutNode()).getSnapshotObserver();
        OwnerSnapshotObserver.access$getObserver$p(v3).observeReads(this.getLayoutNode(), OwnerSnapshotObserver.access$getOnCommitAffectingLookaheadMeasure$p(v3), this.performMeasureBlock);
        this.markLayoutPending$ui();
        if(LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.getLayoutNode())) {
            this.getMeasurePassDelegate$ui().markLayoutPending();
        }
        else {
            this.getMeasurePassDelegate$ui().markMeasurePending$ui();
        }

        this.setLayoutState(LayoutState.Idle);
    }

    protected void placeAt-f8xVGno(long arg7, float arg9, GraphicsLayer arg10) {
        this.placeSelf-MLgxB_4(arg7, arg9, null, arg10);
    }

    protected void placeAt-f8xVGno(long arg7, float arg9, Function1 arg10) {
        this.placeSelf-MLgxB_4(arg7, arg9, arg10, null);
    }

    private final void placeSelf-MLgxB_4(long arg7, float arg9, Function1 arg10, GraphicsLayer arg11) {
        LayoutNode v0 = this.getLayoutNode();
        try {
            LayoutNode v1 = this.getLayoutNode().getParent$ui();
            LayoutState v1_1 = v1 != null ? v1.getLayoutState$ui() : null;
            if(v1_1 == LayoutState.LookaheadLayingOut) {
                this.layoutNodeLayoutDelegate.setDetachedFromParentLookaheadPlacement$ui(false);
            }

            if(this.getLayoutNode().isDeactivated()) {
                InlineClassHelperKt.throwIllegalArgumentException("place is called on a deactivated node");
            }

            this.setLayoutState(LayoutState.LookaheadLayingOut);
            this.placedOnce = true;
            this.onNodePlacedCalled = false;
            if(!IntOffset.equals-impl0(arg7, this.lastPosition)) {
                if((this.layoutNodeLayoutDelegate.getLookaheadCoordinatesAccessedDuringModifierPlacement()) || (this.layoutNodeLayoutDelegate.getLookaheadCoordinatesAccessedDuringPlacement())) {
                    this.setLayoutPending(true);
                }

                this.notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
            }

            Owner v1_2 = LayoutNodeKt.requireOwner(this.getLayoutNode());
            this.lastPosition = arg7;
            if((this.getLayoutPending()) || !this.isPlaced$ui()) {
                this.layoutNodeLayoutDelegate.setLookaheadCoordinatesAccessedDuringModifierPlacement(false);
                this.getAlignmentLines().setUsedByModifierLayout$ui(false);
                OwnerSnapshotObserver v7 = v1_2.getSnapshotObserver();
                OwnerSnapshotObserver.access$getObserver$p(v7).observeReads(this.getLayoutNode(), OwnerSnapshotObserver.access$getOnCommitAffectingLayoutModifierInLookahead$p(v7), this.layoutModifierBlock);
            }
            else {
                LookaheadDelegate v1_3 = this.getOuterCoordinator().getLookaheadDelegate();
                Intrinsics.checkNotNull(v1_3);
                v1_3.placeSelfApparentToRealOffset--gyyYBs$ui(arg7);
                this.onNodePlaced$ui();
            }

            this.lastZIndex = arg9;
            this.lastLayerBlock = arg10;
            this.lastExplicitLayer = arg11;
            this.setLayoutState(LayoutState.Idle);
            return;
        }
        catch(Throwable v6) {
            v0.rethrowWithComposeStackTrace(v6);
            throw new KotlinNothingValueException();
        }
    }

    public final boolean remeasure-BRTryo0(long arg13) {
        boolean v1_1;
        LayoutNode v0 = this.getLayoutNode();
        try {
            if(this.getLayoutNode().isDeactivated()) {
                InlineClassHelperKt.throwIllegalArgumentException("measure is called on a deactivated node");
            }

            LayoutNode v1 = this.getLayoutNode().getParent$ui();
            LayoutNode v2 = this.getLayoutNode();
            if(!this.getLayoutNode().getCanMultiMeasure$ui()) {
                if(v1 != null && (v1.getCanMultiMeasure$ui())) {
                    goto label_20;
                }

                v1_1 = false;
            }
            else {
            label_20:
                v1_1 = true;
            }

            v2.setCanMultiMeasure$ui(v1_1);
            if(!this.getLayoutNode().getLookaheadMeasurePending$ui()) {
                Constraints v1_2 = this.lookaheadConstraints;
                v1_1 = v1_2 == null ? false : Constraints.equals-impl0(v1_2.unbox-impl(), arg13);
                if(!v1_1) {
                    goto label_41;
                }

                Owner v13 = this.getLayoutNode().getOwner$ui();
                if(v13 != null) {
                    v13.forceMeasureTheSubtree(this.getLayoutNode(), true);
                }

                this.getLayoutNode().resetSubtreeIntrinsicsUsage$ui();
                return 0;
            }

        label_41:
            this.lookaheadConstraints = Constraints.box-impl(arg13);
            this.setMeasurementConstraints-BRTryo0(arg13);
            this.getAlignmentLines().setUsedByModifierMeasurement$ui(false);
            this.forEachChildAlignmentLinesOwner(LookaheadPassDelegate$remeasure$1$2.INSTANCE);
            long v1_3 = this.measuredOnce ? this.getMeasuredSize-YbymL2g() : IntSize.constructor-impl(-9223372034707292160L);
            this.measuredOnce = true;
            LookaheadDelegate v3 = this.getOuterCoordinator().getLookaheadDelegate();
            int v6 = v3 != null ? 1 : 0;
            if(v6 == 0) {
                InlineClassHelperKt.throwIllegalStateException("Lookahead result from lookaheadRemeasure cannot be null");
            }

            this.layoutNodeLayoutDelegate.performLookaheadMeasure-BRTryo0$ui(arg13);
            long v10 = 0xFFFFFFFFL;
            this.setMeasuredSize-ozmzZPI(IntSize.constructor-impl((((long)v3.getWidth())) << 0x20 | (((long)v3.getHeight())) & v10));
            if((((int)(v1_3 >> 0x20))) == v3.getWidth()) {
                if((((int)(v1_3 & v10))) == v3.getHeight()) {
                    return 0;
                }

                return 1;
            }

            return 1;
        }
        catch(Throwable v12) {
            v0.rethrowWithComposeStackTrace(v12);
            throw new KotlinNothingValueException();
        }

        return 1;
    }

    public final void replace() {
        LookaheadPassDelegate v3;
        GraphicsLayer v8;
        Function1 v7;
        long v4;
        try {
            this.relayoutWithoutParentInProgress = true;
            if(!this.placedOnce) {
                InlineClassHelperKt.throwIllegalStateException("replace() called on item that was not placed");
            }

            this.onNodePlacedCalled = false;
            boolean v2 = this.isPlaced$ui();
            v4 = this.lastPosition;
            v7 = this.lastLayerBlock;
            v8 = this.lastExplicitLayer;
            v3 = this;
        }
        catch(Throwable v0) {
            v3 = this;
            goto label_29;
        }

        try {
            v3.placeSelf-MLgxB_4(v4, 0f, v7, v8);
            if((v2) && !v3.onNodePlacedCalled) {
                LayoutNode v9 = v3.getLayoutNode().getParent$ui();
                if(v9 != null) {
                    LayoutNode.requestLookaheadRelayout$ui$default(v9, false, 1, null);
                }
            }

            goto label_23;
        }
        catch(Throwable v0) {
        }

    label_29:
        v3.relayoutWithoutParentInProgress = false;
        throw v0;
    label_23:
        v3.relayoutWithoutParentInProgress = false;
    }

    public void requestLayout() {
        LayoutNode.requestLookaheadRelayout$ui$default(this.getLayoutNode(), false, 1, null);
    }

    public void requestMeasure() {
        LayoutNode.requestLookaheadRemeasure$ui$default(this.getLayoutNode(), false, false, false, 7, null);
    }

    public final void setChildDelegatesDirty$ui(boolean arg1) {
        this.childDelegatesDirty = arg1;
    }

    private final void setLayoutPending(boolean arg1) {
        this.layoutNodeLayoutDelegate.setLookaheadLayoutPending$ui(arg1);
    }

    private final void setLayoutPendingForAlignment(boolean arg1) {
        this.layoutNodeLayoutDelegate.setLookaheadLayoutPendingForAlignment$ui(arg1);
    }

    private final void setLayoutState(LayoutState arg1) {
        this.layoutNodeLayoutDelegate.setLayoutState$ui(arg1);
    }

    private final void setMeasurePending(boolean arg1) {
        this.layoutNodeLayoutDelegate.setLookaheadMeasurePending$ui(arg1);
    }

    public final void setMeasuredByParent$ui(UsageByParent arg1) {
        this.measuredByParent = arg1;
    }

    public void setPlaceOrder$ui(int arg1) {
        this.placeOrder = arg1;
    }

    public final void setPlacedOnce$ui(boolean arg1) {
        this.placedOnce = arg1;
    }

    public void setPlacedUnderMotionFrameOfReference(boolean arg1) {
        this.isPlacedUnderMotionFrameOfReference = arg1;
    }

    private final void trackLookaheadMeasurementByParent(LayoutNode arg5) {
        UsageByParent v5_1;
        LayoutNode v0 = arg5.getParent$ui();
        if(v0 != null) {
            int v5 = this.measuredByParent == UsageByParent.NotUsed || (arg5.getCanMultiMeasure$ui()) ? 1 : 0;
            if(v5 == 0) {
                InlineClassHelperKt.throwIllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }

            v5 = WhenMappings.$EnumSwitchMapping$0[v0.getLayoutState$ui().ordinal()];
            if(v5 == 1 || v5 == 2) {
                v5_1 = UsageByParent.InMeasureBlock;
            }
            else {
                if(v5 != 3) {
                    if(v5 == 4) {
                    }
                    else {
                        throw new IllegalStateException("Measurable could be only measured from the parent\'s measure or layout block. Parents state is " + v0.getLayoutState$ui());
                    }
                }

                v5_1 = UsageByParent.InLayoutBlock;
            }

            this.measuredByParent = v5_1;
            return;
        }

        this.measuredByParent = UsageByParent.NotUsed;
    }

    public final boolean updateParentData() {
        LookaheadDelegate v0;
        if(this.getParentData() == null) {
            v0 = this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(v0);
            if(v0.getParentData() == null) {
                return 0;
            }
        }

        if(!this.parentDataDirty) {
            return 0;
        }

        this.parentDataDirty = false;
        v0 = this.getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(v0);
        this.parentData = v0.getParentData();
        return 1;
    }

    public void updatePlacedUnderMotionFrameOfReference(boolean arg3) {
        LookaheadDelegate v0 = this.getOuterCoordinator().getLookaheadDelegate();
        if(v0 != null) {
            Boolean v0_1 = Boolean.valueOf(v0.isPlacedUnderMotionFrameOfReference());
        }
        else {
            Object v0_2 = null;
        }

        if(!Intrinsics.areEqual(Boolean.valueOf(arg3), v0_2)) {
            v0 = this.getOuterCoordinator().getLookaheadDelegate();
            if(v0 != null) {
                v0.setPlacedUnderMotionFrameOfReference(arg3);
            }
        }

        this.setPlacedUnderMotionFrameOfReference(arg3);
    }
}

