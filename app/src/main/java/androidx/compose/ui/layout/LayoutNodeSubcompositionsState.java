package androidx.compose.ui.layout;

import androidx.collection.IntList;
import androidx.collection.MutableIntList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PausableComposition;
import androidx.compose.runtime.PausedComposition;
import androidx.compose.runtime.ReusableComposition;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot$Companion;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LayoutNode$LayoutState;
import androidx.compose.ui.node.LayoutNode$UsageByParent;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.LookaheadPassDelegate;
import androidx.compose.ui.node.OutOfFrameExecutor;
import androidx.compose.ui.platform.SubcompositionKt;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u00002\u00020\u0001:\u0003opqB\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010(\u001A\u00020)H\u0016J\b\u0010*\u001A\u00020)H\u0016J\b\u0010+\u001A\u00020)H\u0016J.\u0010,\u001A\b\u0012\u0004\u0012\u00020.0-2\b\u0010/\u001A\u0004\u0018\u00010\u001A2\u0011\u00100\u001A\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b2¢\u0006\u0002\u00103J:\u0010,\u001A\u00020)2\u0006\u00104\u001A\u00020\u00032\b\u0010/\u001A\u0004\u0018\u00010\u001A2\u0006\u00105\u001A\u0002062\u0011\u00100\u001A\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b2H\u0002¢\u0006\u0002\u00107J \u0010,\u001A\u00020)2\u0006\u00104\u001A\u00020\u00032\u0006\u0010<\u001A\u00020\u00182\u0006\u00105\u001A\u000206H\u0002J \u0010=\u001A\u0004\u0018\u00010\u001A2\f\u0010>\u001A\b\u0012\u0004\u0012\u00020\u00030-2\u0006\u0010?\u001A\u00020\u0014H\u0002J\u000E\u0010@\u001A\u00020)2\u0006\u0010A\u001A\u00020\u0014J\u0014\u0010B\u001A\u00020)*\u00020\u00182\u0006\u0010C\u001A\u000209H\u0002J\u0010\u0010D\u001A\u00020)2\u0006\u0010E\u001A\u000206H\u0002J\b\u0010F\u001A\u00020)H\u0002J\u0006\u0010G\u001A\u00020)J\f\u0010H\u001A\u00020)*\u00020\u0003H\u0002J\u0014\u0010I\u001A\u0004\u0018\u00010\u00032\b\u0010/\u001A\u0004\u0018\u00010\u001AH\u0002J%\u0010J\u001A\u00020K2\u001D\u0010L\u001A\u0019\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P0M¢\u0006\u0002\bQJ\b\u0010R\u001A\u00020)H\u0002J!\u0010S\u001A\u00020P2\u0006\u0010T\u001A\u00020P2\u000E\b\u0004\u0010U\u001A\b\u0012\u0004\u0012\u00020)01H\u0082\bJ(\u0010X\u001A\u00020#2\b\u0010/\u001A\u0004\u0018\u00010\u001A2\u0011\u00100\u001A\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b2¢\u0006\u0002\u0010YJ2\u0010X\u001A\u00020)2\b\u0010/\u001A\u0004\u0018\u00010\u001A2\u0011\u00100\u001A\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b22\u0006\u00105\u001A\u000206H\u0002¢\u0006\u0002\u0010ZJ\u0014\u0010[\u001A\u00020)*\u00020\u00182\u0006\u0010\\\u001A\u000206H\u0002J\f\u0010]\u001A\u00020)*\u00020\u0018H\u0002J\u0012\u0010^\u001A\u00020)2\b\u0010/\u001A\u0004\u0018\u00010\u001AH\u0002J\u0012\u0010_\u001A\u00020#2\b\u0010/\u001A\u0004\u0018\u00010\u001AH\u0002J(\u0010`\u001A\u00020a2\b\u0010/\u001A\u0004\u0018\u00010\u001A2\u0011\u00100\u001A\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b2¢\u0006\u0002\u0010bJ\u0006\u0010c\u001A\u00020)J\u0010\u0010d\u001A\u00020\u00032\u0006\u0010?\u001A\u00020\u0014H\u0002J\"\u0010e\u001A\u00020)2\u0006\u0010f\u001A\u00020\u00142\u0006\u0010g\u001A\u00020\u00142\b\b\u0002\u0010h\u001A\u00020\u0014H\u0002J\"\u0010i\u001A\u0002Hj\"\u0004\b\u0000\u0010j2\f\u0010L\u001A\b\u0012\u0004\u0012\u0002Hj01H\u0082\b¢\u0006\u0002\u0010kJ\u0014\u0010l\u001A\u00020)*\u00020\u00182\u0006\u0010m\u001A\u000206H\u0002J0\u0010n\u001A\b\u0012\u0004\u0012\u00020.0-2\b\u0010/\u001A\u0004\u0018\u00010\u001A2\u0011\u00100\u001A\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b2H\u0002¢\u0006\u0002\u00103R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\b\u001A\u0004\u0018\u00010\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR$\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u0005@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0019\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001A\u0012\u0004\u0012\u00020\u00030\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001B\u001A\u00060\u001CR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001D\u001A\u00060\u001ER\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u001F\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001A\u0012\u0004\u0012\u00020\u00030\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\"\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001A\u0012\u0004\u0012\u00020#0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001A0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u00108\u001A\u0004\u0018\u0001098BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b:\u0010;R\u000E\u0010V\u001A\u00020WX\u0082D¢\u0006\u0002\n\u0000¨\u0006r"}, d2={"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "root", "Landroidx/compose/ui/node/LayoutNode;", "slotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "compositionContext", "Landroidx/compose/runtime/CompositionContext;", "getCompositionContext", "()Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroidx/compose/runtime/CompositionContext;)V", "value", "getSlotReusePolicy", "()Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "setSlotReusePolicy", "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "currentIndex", "", "currentApproachIndex", "nodeToNodeState", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "slotIdToNode", "", "scope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "approachMeasureScope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$ApproachMeasureScopeImpl;", "precomposeMap", "reusableSlotIdsSet", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "approachPrecomposeSlotHandleMap", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "slotIdsOfCompositionsNeededInApproach", "Landroidx/compose/runtime/collection/MutableVector;", "reusableCount", "precomposedCount", "onReuse", "", "onDeactivate", "onRelease", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "node", "pausable", "", "(Landroidx/compose/ui/node/LayoutNode;Ljava/lang/Object;ZLkotlin/jvm/functions/Function2;)V", "outOfFrameExecutor", "Landroidx/compose/ui/node/OutOfFrameExecutor;", "getOutOfFrameExecutor", "()Landroidx/compose/ui/node/OutOfFrameExecutor;", "nodeState", "getSlotIdAtIndex", "foldedChildren", "index", "disposeOrReuseStartingFromIndex", "startIndex", "deactivateOutOfFrame", "executor", "markActiveNodesAsReused", "deactivate", "disposeCurrentNodes", "makeSureStateIsConsistent", "resetLayoutState", "takeNodeFromReusables", "createMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "disposeUnusedSlotsInApproach", "createMeasureResult", "result", "placeChildrenBlock", "NoIntrinsicsMessage", "", "precompose", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Z)V", "reuseComposition", "forceDeactivate", "cancelPausedPrecomposition", "disposePrecomposedSlot", "createPrecomposedSlotHandle", "precomposePaused", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "forceRecomposeChildren", "createNodeAt", "move", "from", "to", "count", "ignoreRemeasureRequests", "T", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "applyPausedPrecomposition", "shouldComplete", "approachSubcompose", "NodeState", "Scope", "ApproachMeasureScopeImpl", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayoutNodeSubcompositionsState implements ComposeNodeLifecycleCallback {
    @Metadata(d1={"\u0000\u009C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J0\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001A\u0004\u0018\u00010\t2\u0011\u0010\n\u001A\r\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\u0002\b\rH\u0016¢\u0006\u0002\u0010\u000EJF\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00122\u0012\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u00152\u0017\u0010\u0017\u001A\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001AH\u0096\u0001Ja\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00122\u0012\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u00152\u0019\u0010\u001B\u001A\u0015\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\f\u0018\u00010\u0018¢\u0006\u0002\b\u001A2\u0017\u0010\u0017\u001A\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001AH\u0096\u0001J\u0014\u0010\u001D\u001A\u00020\u0012*\u00020\u001EH\u0097\u0001¢\u0006\u0004\b\u001F\u0010 J\u0014\u0010\u001D\u001A\u00020\u0012*\u00020!H\u0097\u0001¢\u0006\u0004\b\"\u0010#J\u0014\u0010$\u001A\u00020\u001E*\u00020\u0012H\u0097\u0001¢\u0006\u0004\b%\u0010&J\u0014\u0010$\u001A\u00020\u001E*\u00020\'H\u0097\u0001¢\u0006\u0004\b%\u0010(J\u0014\u0010$\u001A\u00020\u001E*\u00020!H\u0097\u0001¢\u0006\u0004\b)\u0010*J\u0014\u0010+\u001A\u00020,*\u00020-H\u0097\u0001¢\u0006\u0004\b.\u0010/J\u0014\u00100\u001A\u00020\'*\u00020\u001EH\u0097\u0001¢\u0006\u0004\b1\u0010(J\u0014\u00100\u001A\u00020\'*\u00020!H\u0097\u0001¢\u0006\u0004\b2\u0010*J\r\u00103\u001A\u000204*\u000205H\u0097\u0001J\u0014\u00106\u001A\u00020-*\u00020,H\u0097\u0001¢\u0006\u0004\b7\u0010/J\u0014\u00108\u001A\u00020!*\u00020\u0012H\u0097\u0001¢\u0006\u0004\b9\u0010:J\u0014\u00108\u001A\u00020!*\u00020\'H\u0097\u0001¢\u0006\u0004\b9\u0010;J\u0014\u00108\u001A\u00020!*\u00020\u001EH\u0097\u0001¢\u0006\u0004\b<\u0010;R\u0014\u0010=\u001A\u00020\'8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b>\u0010?R\u0014\u0010@\u001A\u00020\'8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\bA\u0010?R\u0014\u0010B\u001A\u00020C8VX\u0096\u0005¢\u0006\u0006\u001A\u0004\bB\u0010DR\u0012\u0010E\u001A\u00020FX\u0096\u0005¢\u0006\u0006\u001A\u0004\bG\u0010H¨\u0006I"}, d2={"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$ApproachMeasureScopeImpl;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "<init>", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "rulers", "Landroidx/compose/ui/layout/RulerScope;", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "", "(F)F", "toDp-GaN1DYA", "(J)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toSp-0xMU5do", "density", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class ApproachMeasureScopeImpl implements MeasureScope, SubcomposeMeasureScope {
        public ApproachMeasureScopeImpl(LayoutNodeSubcompositionsState arg1) {
            LayoutNodeSubcompositionsState.this = arg1;
            super();
            this.$$delegate_0 = arg1.scope;
        }

        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        public LayoutDirection getLayoutDirection() {
            return this.$$delegate_0.getLayoutDirection();
        }

        public boolean isLookingAhead() {
            return this.$$delegate_0.isLookingAhead();
        }

        public MeasureResult layout(int arg1, int arg2, Map arg3, Function1 arg4) {
            return this.$$delegate_0.layout(arg1, arg2, arg3, arg4);
        }

        public MeasureResult layout(int arg1, int arg2, Map arg3, Function1 arg4, Function1 arg5) {
            return this.$$delegate_0.layout(arg1, arg2, arg3, arg4, arg5);
        }

        public int roundToPx--R2X_6o(long arg1) {
            return this.$$delegate_0.roundToPx--R2X_6o(arg1);
        }

        public int roundToPx-0680j_4(float arg1) {
            return this.$$delegate_0.roundToPx-0680j_4(arg1);
        }

        public List subcompose(Object arg4, Function2 arg5) {
            Object v0 = LayoutNodeSubcompositionsState.this.slotIdToNode.get(arg4);
            if(v0 != null && LayoutNodeSubcompositionsState.this.root.getFoldedChildren$ui().indexOf(v0) < LayoutNodeSubcompositionsState.this.currentIndex) {
                return ((LayoutNode)v0).getChildMeasurables$ui();
            }

            return LayoutNodeSubcompositionsState.this.approachSubcompose(arg4, arg5);
        }

        public float toDp-GaN1DYA(long arg1) {
            return this.$$delegate_0.toDp-GaN1DYA(arg1);
        }

        public float toDp-u2uoSUM(float arg1) {
            return this.$$delegate_0.toDp-u2uoSUM(arg1);
        }

        public float toDp-u2uoSUM(int arg1) {
            return this.$$delegate_0.toDp-u2uoSUM(arg1);
        }

        public long toDpSize-k-rfVVM(long arg1) {
            return this.$$delegate_0.toDpSize-k-rfVVM(arg1);
        }

        public float toPx--R2X_6o(long arg1) {
            return this.$$delegate_0.toPx--R2X_6o(arg1);
        }

        public float toPx-0680j_4(float arg1) {
            return this.$$delegate_0.toPx-0680j_4(arg1);
        }

        public Rect toRect(DpRect arg1) {
            return this.$$delegate_0.toRect(arg1);
        }

        public long toSize-XkaWNTQ(long arg1) {
            return this.$$delegate_0.toSize-XkaWNTQ(arg1);
        }

        public long toSp-0xMU5do(float arg1) {
            return this.$$delegate_0.toSp-0xMU5do(arg1);
        }

        public long toSp-kPz2Gy4(float arg1) {
            return this.$$delegate_0.toSp-kPz2Gy4(arg1);
        }

        public long toSp-kPz2Gy4(int arg1) {
            return this.$$delegate_0.toSp-kPz2Gy4(arg1);
        }
    }

    @Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B0\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0001\u0012\u0011\u0010\u0003\u001A\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u00108\u001A\u00020\u00052\u0006\u00109\u001A\u00020:¢\u0006\u0004\b;\u0010<R\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0001X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\'\u0010\u0003\u001A\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0013\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\u00020\u0019X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u001A\u0010\u001E\u001A\u00020\u0019X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010\u001B\"\u0004\b \u0010\u001DR\u001C\u0010!\u001A\u0004\u0018\u00010\"X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010\'\u001A\b\u0012\u0004\u0012\u00020\u00190(X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001A\u0010-\u001A\u00020\u0019X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b.\u0010\u001B\"\u0004\b/\u0010\u001DR$\u00101\u001A\u00020\u00192\u0006\u00100\u001A\u00020\u00198F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b2\u0010\u001B\"\u0004\b3\u0010\u001DR\u0013\u00104\u001A\u0004\u0018\u000105¢\u0006\b\n\u0000\u001A\u0004\b6\u00107¨\u0006="}, d2={"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "", "slotId", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "composition", "Landroidx/compose/runtime/ReusableComposition;", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/ReusableComposition;)V", "getSlotId", "()Ljava/lang/Object;", "setSlotId", "(Ljava/lang/Object;)V", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getComposition", "()Landroidx/compose/runtime/ReusableComposition;", "setComposition", "(Landroidx/compose/runtime/ReusableComposition;)V", "forceRecompose", "", "getForceRecompose", "()Z", "setForceRecompose", "(Z)V", "forceReuse", "getForceReuse", "setForceReuse", "pausedComposition", "Landroidx/compose/runtime/PausedComposition;", "getPausedComposition", "()Landroidx/compose/runtime/PausedComposition;", "setPausedComposition", "(Landroidx/compose/runtime/PausedComposition;)V", "activeState", "Landroidx/compose/runtime/MutableState;", "getActiveState", "()Landroidx/compose/runtime/MutableState;", "setActiveState", "(Landroidx/compose/runtime/MutableState;)V", "composedWithReusableContentHost", "getComposedWithReusableContentHost", "setComposedWithReusableContentHost", "value", "active", "getActive", "setActive", "operations", "Landroidx/collection/MutableIntList;", "getOperations", "()Landroidx/collection/MutableIntList;", "record", "op", "Landroidx/compose/ui/layout/SLOperation;", "record-Fsph7yY", "(I)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class NodeState {
        private MutableState activeState;
        private boolean composedWithReusableContentHost;
        private ReusableComposition composition;
        private Function2 content;
        private boolean forceRecompose;
        private boolean forceReuse;
        private final MutableIntList operations;
        private PausedComposition pausedComposition;
        private Object slotId;

        public NodeState(Object arg1, Function2 arg2, ReusableComposition arg3, int arg4, DefaultConstructorMarker arg5) {
            if((arg4 & 4) != 0) {
                arg3 = null;
            }

            this(arg1, arg2, arg3);
        }

        public NodeState(Object arg1, Function2 arg2, ReusableComposition arg3) {
            super();
            this.slotId = arg1;
            this.content = arg2;
            this.composition = arg3;
            this.activeState = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(true), null, 2, null);
            this.operations = null;
        }

        public final boolean getActive() {
            return this.activeState.getValue().booleanValue();
        }

        public final MutableState getActiveState() {
            return this.activeState;
        }

        public final boolean getComposedWithReusableContentHost() {
            return this.composedWithReusableContentHost;
        }

        public final ReusableComposition getComposition() {
            return this.composition;
        }

        public final Function2 getContent() {
            return this.content;
        }

        public final boolean getForceRecompose() {
            return this.forceRecompose;
        }

        public final boolean getForceReuse() {
            return this.forceReuse;
        }

        public final MutableIntList getOperations() {
            return this.operations;
        }

        public final PausedComposition getPausedComposition() {
            return this.pausedComposition;
        }

        public final Object getSlotId() {
            return this.slotId;
        }

        public final void record-Fsph7yY(int arg2) {
            MutableIntList v1 = this.operations;
            if(v1 == null) {
            }
            else {
                v1.add(arg2);
                if(v1._size >= 50) {
                    v1.removeRange(0, 10);
                }
            }
        }

        public final void setActive(boolean arg1) {
            this.activeState.setValue(Boolean.valueOf(arg1));
        }

        public final void setActiveState(MutableState arg1) {
            this.activeState = arg1;
        }

        public final void setComposedWithReusableContentHost(boolean arg1) {
            this.composedWithReusableContentHost = arg1;
        }

        public final void setComposition(ReusableComposition arg1) {
            this.composition = arg1;
        }

        public final void setContent(Function2 arg1) {
            this.content = arg1;
        }

        public final void setForceRecompose(boolean arg1) {
            this.forceRecompose = arg1;
        }

        public final void setForceReuse(boolean arg1) {
            this.forceReuse = arg1;
        }

        public final void setPausedComposition(PausedComposition arg1) {
            this.pausedComposition = arg1;
        }

        public final void setSlotId(Object arg1) {
            this.slotId = arg1;
        }
    }

    @Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\u0011\u0010\u001B\u001A\r\u0012\u0004\u0012\u00020\u001D0\u001C¢\u0006\u0002\b\u001EH\u0016¢\u0006\u0002\u0010\u001FJ`\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020#2\u0012\u0010%\u001A\u000E\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020#0&2\u0019\u0010(\u001A\u0015\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001D\u0018\u00010)¢\u0006\u0002\b+2\u0017\u0010,\u001A\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u001D0)¢\u0006\u0002\b+H\u0016R\u001A\u0010\u0004\u001A\u00020\u0005X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000BX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u000BX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR\u0014\u0010\u0013\u001A\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0015¨\u0006."}, d2={"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "<init>", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "density", "", "getDensity", "()F", "setDensity", "(F)V", "fontScale", "getFontScale", "setFontScale", "isLookingAhead", "", "()Z", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "Lkotlin/ExtensionFunctionType;", "placementBlock", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class Scope implements SubcomposeMeasureScope {
        private float density;
        private float fontScale;
        private LayoutDirection layoutDirection;

        public Scope(LayoutNodeSubcompositionsState arg1) {
            LayoutNodeSubcompositionsState.this = arg1;
            super();
            this.layoutDirection = LayoutDirection.Rtl;
        }

        public float getDensity() {
            return this.density;
        }

        public float getFontScale() {
            return this.fontScale;
        }

        public LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public boolean isLookingAhead() {
            if(LayoutNodeSubcompositionsState.this.root.getLayoutState$ui() != LayoutState.LookaheadLayingOut) {
                if(LayoutNodeSubcompositionsState.this.root.getLayoutState$ui() == LayoutState.LookaheadMeasuring) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public MeasureResult layout(int arg10, int arg11, Map arg12, Function1 arg13, Function1 arg14) {
            int v0 = 0xFF000000;
            v0 = (arg10 & v0) != 0 || (v0 & arg11) != 0 ? 0 : 1;
            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalStateException("Size(" + arg10 + " x " + arg11 + ") is out of range. Each dimension must be between 0 and 16777215.");
            }

            return new LayoutNodeSubcompositionsState$Scope$layout$1(arg10, arg11, arg12, arg13, this, LayoutNodeSubcompositionsState.this, arg14);
        }

        public void setDensity(float arg1) {
            this.density = arg1;
        }

        public void setFontScale(float arg1) {
            this.fontScale = arg1;
        }

        public void setLayoutDirection(LayoutDirection arg1) {
            this.layoutDirection = arg1;
        }

        public List subcompose(Object arg1, Function2 arg2) {
            return LayoutNodeSubcompositionsState.this.subcompose(arg1, arg2);
        }
    }

    public static final int $stable = 8;
    private final String NoIntrinsicsMessage;
    private final ApproachMeasureScopeImpl approachMeasureScope;
    private final MutableScatterMap approachPrecomposeSlotHandleMap;
    private CompositionContext compositionContext;
    private int currentApproachIndex;
    private int currentIndex;
    private final MutableScatterMap nodeToNodeState;
    private final MutableScatterMap precomposeMap;
    private int precomposedCount;
    private int reusableCount;
    private final SlotIdsSet reusableSlotIdsSet;
    private final LayoutNode root;
    private final Scope scope;
    private final MutableScatterMap slotIdToNode;
    private final MutableVector slotIdsOfCompositionsNeededInApproach;
    private SubcomposeSlotReusePolicy slotReusePolicy;

    public static boolean $r8$lambda$I9S4Oy4uvsJFCZpX9_LGbxS5mDc() {
        return LayoutNodeSubcompositionsState.applyPausedPrecomposition$lambda$0$0$0();
    }

    static {
    }

    public LayoutNodeSubcompositionsState(LayoutNode arg2, SubcomposeSlotReusePolicy arg3) {
        super();
        this.root = arg2;
        this.slotReusePolicy = arg3;
        this.nodeToNodeState = ScatterMapKt.mutableScatterMapOf();
        this.slotIdToNode = ScatterMapKt.mutableScatterMapOf();
        this.scope = new Scope(this);
        this.approachMeasureScope = new ApproachMeasureScopeImpl(this);
        this.precomposeMap = ScatterMapKt.mutableScatterMapOf();
        this.reusableSlotIdsSet = new SlotIdsSet(null, 1, null);
        this.approachPrecomposeSlotHandleMap = ScatterMapKt.mutableScatterMapOf();
        this.slotIdsOfCompositionsNeededInApproach = new MutableVector(new Object[16], 0);
        this.NoIntrinsicsMessage = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve \'match parent\' sizing, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";
    }

    public static final void access$applyPausedPrecomposition(LayoutNodeSubcompositionsState arg0, NodeState arg1, boolean arg2) {
        arg0.applyPausedPrecomposition(arg1, arg2);
    }

    public static final List access$approachSubcompose(LayoutNodeSubcompositionsState arg0, Object arg1, Function2 arg2) {
        return arg0.approachSubcompose(arg1, arg2);
    }

    public static final PrecomposedSlotHandle access$createPrecomposedSlotHandle(LayoutNodeSubcompositionsState arg0, Object arg1) {
        return arg0.createPrecomposedSlotHandle(arg1);
    }

    public static final void access$disposePrecomposedSlot(LayoutNodeSubcompositionsState arg0, Object arg1) {
        arg0.disposePrecomposedSlot(arg1);
    }

    public static final void access$disposeUnusedSlotsInApproach(LayoutNodeSubcompositionsState arg0) {
        arg0.disposeUnusedSlotsInApproach();
    }

    public static final ApproachMeasureScopeImpl access$getApproachMeasureScope$p(LayoutNodeSubcompositionsState arg0) {
        return arg0.approachMeasureScope;
    }

    public static final int access$getCurrentApproachIndex$p(LayoutNodeSubcompositionsState arg0) {
        return arg0.currentApproachIndex;
    }

    public static final int access$getCurrentIndex$p(LayoutNodeSubcompositionsState arg0) {
        return arg0.currentIndex;
    }

    public static final MutableScatterMap access$getNodeToNodeState$p(LayoutNodeSubcompositionsState arg0) {
        return arg0.nodeToNodeState;
    }

    public static final MutableScatterMap access$getPrecomposeMap$p(LayoutNodeSubcompositionsState arg0) {
        return arg0.precomposeMap;
    }

    public static final LayoutNode access$getRoot$p(LayoutNodeSubcompositionsState arg0) {
        return arg0.root;
    }

    public static final Scope access$getScope$p(LayoutNodeSubcompositionsState arg0) {
        return arg0.scope;
    }

    public static final MutableScatterMap access$getSlotIdToNode$p(LayoutNodeSubcompositionsState arg0) {
        return arg0.slotIdToNode;
    }

    public static final void access$setCurrentApproachIndex$p(LayoutNodeSubcompositionsState arg0, int arg1) {
        arg0.currentApproachIndex = arg1;
    }

    public static final void access$setCurrentIndex$p(LayoutNodeSubcompositionsState arg0, int arg1) {
        arg0.currentIndex = arg1;
    }

    private final void applyPausedPrecomposition(NodeState arg8, boolean arg9) {
        LayoutNode v7_1;
        PausedComposition v0 = arg8.getPausedComposition();
        if(v0 != null) {
            Companion v1 = Snapshot.Companion;
            Snapshot v2 = v1.getCurrentThreadSnapshot();
            PausedComposition v3 = null;
            Function1 v4 = v2 != null ? v2.getReadObserver() : ((Function1)v3);
            Snapshot v5 = v1.makeCurrentNonObservable(v2);
            try {
                v7_1 = this.root;
                LayoutNode.access$setIgnoreRemeasureRequests$p(v7_1, true);
                if(arg9) {
                    goto label_14;
                }

                goto label_22;
            }
            catch(Throwable v7) {
                goto label_38;
            }

            try {
            label_14:
                while(!v0.isComplete()) {
                    v0.resume(new LayoutNodeSubcompositionsState$$ExternalSyntheticLambda0());
                }

            label_22:
                v0.apply();
                goto label_23;
            label_21:
            }
            catch(Throwable v7) {
                goto label_21;
            }

            try {
                MutableIntList v9 = arg8.getOperations();
                if(v9 != null) {
                    throw new SubcomposeLayoutPausableCompositionException(((IntList)v9), arg8.getSlotId(), v7);
                }

                throw v7;
            label_23:
                arg8.setPausedComposition(v3);
                LayoutNode.access$setIgnoreRemeasureRequests$p(v7_1, false);
            }
            catch(Throwable v7) {
            label_38:
                v1.restoreNonObservable(v2, v5, v4);
                throw v7;
            }

            v1.restoreNonObservable(v2, v5, v4);
            return;
        }
    }

    private static final boolean applyPausedPrecomposition$lambda$0$0$0() {
        return 0;
    }

    private final List approachSubcompose(Object arg7, Function2 arg8) {
        int v2 = 0;
        int v0 = this.slotIdsOfCompositionsNeededInApproach.getSize() >= this.currentApproachIndex ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Error: currentApproachIndex cannot be greater than the size of theapproachComposedSlotIds list.");
        }

        Object v0_1 = this.slotIdToNode.get(arg7);
        int v1 = this.slotIdsOfCompositionsNeededInApproach.getSize();
        int v4 = this.currentApproachIndex;
        MutableVector v5 = this.slotIdsOfCompositionsNeededInApproach;
        if(v1 == v4) {
            v5.add(arg7);
        }
        else {
            v5.set(v4, arg7);
        }

        ++this.currentApproachIndex;
        boolean v1_1 = this.precomposeMap.contains(arg7);
        if((v1_1) || v0_1 != null) {
            if(!v1_1 && v0_1 != null) {
                this.move(this.root.getFoldedChildren$ui().indexOf(v0_1), this.root.getFoldedChildren$ui().size(), 1);
                ++this.precomposedCount;
                this.slotIdToNode.remove(arg7);
                this.precomposeMap.set(arg7, v0_1);
                this.approachPrecomposeSlotHandleMap.set(arg7, this.createPrecomposedSlotHandle(arg7));
                if(this.root.isAttached()) {
                    this.makeSureStateIsConsistent();
                }
            }

            v0_1 = this.precomposeMap.get(arg7);
            PausedComposition v1_2 = null;
            Object v4_1 = v0_1 != null ? this.nodeToNodeState.get(v0_1) : v1_2;
            if(v4_1 != null && (((NodeState)v4_1).getForceRecompose())) {
                this.subcompose(((LayoutNode)v0_1), arg7, false, arg8);
            }

            if(v4_1 != null) {
                v1_2 = ((NodeState)v4_1).getPausedComposition();
            }

            if(v1_2 == null) {
                goto label_72;
            }

            this.applyPausedPrecomposition(((NodeState)v4_1), true);
        }
        else {
            this.approachPrecomposeSlotHandleMap.set(arg7, this.precompose(arg7, arg8));
        }

    label_72:
        Object v6 = this.precomposeMap.get(arg7);
        if(v6 != null) {
            List v6_1 = ((LayoutNode)v6).getMeasurePassDelegate$ui().getChildDelegates$ui();
            int v7 = v6_1.size();
            while(v2 < v7) {
                v6_1.get(v2).markDetachedFromParentLookaheadPass$ui();
                ++v2;
            }

            if(v6_1 == null) {
            }
            else {
                return v6_1;
            }
        }

        return CollectionsKt.emptyList();
    }

    private final void cancelPausedPrecomposition(NodeState arg2) {
        PausedComposition v1 = arg2.getPausedComposition();
        if(v1 != null) {
            v1.cancel();
            v1 = null;
            arg2.setPausedComposition(v1);
            ReusableComposition v0 = arg2.getComposition();
            if(v0 != null) {
                v0.dispose();
            }

            arg2.setComposition(((ReusableComposition)v1));
        }
    }

    public final MeasurePolicy createMeasurePolicy(Function2 arg3) {
        return new LayoutNodeSubcompositionsState$createMeasurePolicy$1(this, arg3, this.NoIntrinsicsMessage);
    }

    private final MeasureResult createMeasureResult(MeasureResult arg1, Function0 arg2) {
        return new LayoutNodeSubcompositionsState$createMeasureResult$1(arg1, arg2);
    }

    private final LayoutNode createNodeAt(int arg6) {
        LayoutNode v0 = new LayoutNode(true, 0, 2, null);
        LayoutNode v1 = this.root;
        LayoutNode.access$setIgnoreRemeasureRequests$p(v1, true);
        this.root.insertAt$ui(arg6, v0);
        LayoutNode.access$setIgnoreRemeasureRequests$p(v1, false);
        return v0;
    }

    private final PrecomposedSlotHandle createPrecomposedSlotHandle(Object arg2) {
        if(!this.root.isAttached()) {
            return new LayoutNodeSubcompositionsState$createPrecomposedSlotHandle$1();
        }

        return new LayoutNodeSubcompositionsState$createPrecomposedSlotHandle$2(this, arg2);
    }

    private final void deactivateOutOfFrame(NodeState arg1, OutOfFrameExecutor arg2) {
        arg2.schedule(new LayoutNodeSubcompositionsState$deactivateOutOfFrame$1(arg1));
    }

    private final void disposeCurrentNodes() {
        LayoutNode v0 = this.root;
        LayoutNode.access$setIgnoreRemeasureRequests$p(v0, true);
        MutableScatterMap v1 = this.nodeToNodeState;
        Object[] v2 = ((ScatterMap)v1).values;
        long[] v1_1 = ((ScatterMap)v1).metadata;
        int v3 = v1_1.length - 2;
        if(v3 >= 0) {
            int v5;
            for(v5 = 0; true; ++v5) {
                long v6 = v1_1[v5];
                if((~v6 << 7 & v6 & -9187201950435737472L) != -9187201950435737472L) {
                    int v9 = 8;
                    int v8 = 8 - (~(v5 - v3) >>> 0x1F);
                    int v10;
                    for(v10 = 0; v10 < v8; ++v10) {
                        if((0xFF & v6) < 0x80) {
                            ReusableComposition v11 = v2[(v5 << 3) + v10].getComposition();
                            if(v11 != null) {
                                v11.dispose();
                            }
                        }

                        v6 >>= v9;
                    }

                    if(v8 != v9) {
                        break;
                    }
                }

                if(v5 == v3) {
                    break;
                }
            }
        }

        this.root.removeAll$ui();
        LayoutNode.access$setIgnoreRemeasureRequests$p(v0, false);
        this.nodeToNodeState.clear();
        this.slotIdToNode.clear();
        this.precomposedCount = 0;
        this.reusableCount = 0;
        this.precomposeMap.clear();
        this.makeSureStateIsConsistent();
    }

    public final void disposeOrReuseStartingFromIndex(int arg15) {
        int v0 = 0;
        this.reusableCount = 0;
        List v1 = this.root.getFoldedChildren$ui();
        int v2 = v1.size() - this.precomposedCount - 1;
        if(arg15 <= v2) {
            this.reusableSlotIdsSet.clear();
            if(arg15 <= v2) {
                int v4 = arg15;
                while(true) {
                    this.reusableSlotIdsSet.add$ui(this.getSlotIdAtIndex(v1, v4));
                    if(v4 != v2) {
                        ++v4;
                        continue;
                    }

                    break;
                }
            }

            this.slotReusePolicy.getSlotsToRetain(this.reusableSlotIdsSet);
            Companion v4_1 = Snapshot.Companion;
            Snapshot v5 = v4_1.getCurrentThreadSnapshot();
            Function1 v6 = v5 != null ? v5.getReadObserver() : null;
            Snapshot v7 = v4_1.makeCurrentNonObservable(v5);
            int v8 = 0;
            while(true) {
                if(v2 < arg15) {
                    goto label_66;
                }

                try {
                    Object v9 = v1.get(v2);
                    Object v10 = this.nodeToNodeState.get(v9);
                    Intrinsics.checkNotNull(v10);
                    Object v11 = ((NodeState)v10).getSlotId();
                    if(this.reusableSlotIdsSet.contains(v11)) {
                        ++this.reusableCount;
                        if(((NodeState)v10).getActive()) {
                            this.resetLayoutState(((LayoutNode)v9));
                            this.reuseComposition(((NodeState)v10), false);
                            if(((NodeState)v10).getComposedWithReusableContentHost()) {
                                v8 = 1;
                            }
                        }
                    }
                    else {
                        LayoutNode v12 = this.root;
                        LayoutNode.access$setIgnoreRemeasureRequests$p(v12, true);
                        this.nodeToNodeState.remove(v9);
                        ReusableComposition v9_1 = ((NodeState)v10).getComposition();
                        if(v9_1 != null) {
                            v9_1.dispose();
                        }

                        this.root.removeAt$ui(v2, 1);
                        LayoutNode.access$setIgnoreRemeasureRequests$p(v12, false);
                    }

                    this.slotIdToNode.remove(v11);
                    --v2;
                    continue;
                label_66:
                    break;
                }
                catch(Throwable v14) {
                    v4_1.restoreNonObservable(v5, v7, v6);
                    throw v14;
                }
            }

            v4_1.restoreNonObservable(v5, v7, v6);
            v0 = v8;
        }

        if(v0 != 0) {
            Snapshot.Companion.sendApplyNotifications();
        }

        this.makeSureStateIsConsistent();
    }

    private final void disposePrecomposedSlot(Object arg7) {
        this.makeSureStateIsConsistent();
        Object v0 = this.precomposeMap.remove(arg7);
        if(v0 != null) {
            int v2 = 0;
            int v1 = this.precomposedCount > 0 ? 1 : 0;
            if(v1 == 0) {
                InlineClassHelperKt.throwIllegalStateException("No pre-composed items to dispose");
            }

            v1 = this.root.getFoldedChildren$ui().indexOf(v0);
            if(v1 >= this.root.getFoldedChildren$ui().size() - this.precomposedCount) {
                v2 = 1;
            }

            if(v2 == 0) {
                InlineClassHelperKt.throwIllegalStateException("Item is not in pre-composed item range");
            }

            ++this.reusableCount;
            --this.precomposedCount;
            v0 = this.nodeToNodeState.get(v0);
            if(v0 != null) {
                this.cancelPausedPrecomposition(((NodeState)v0));
            }

            int v0_1 = this.root.getFoldedChildren$ui().size() - this.precomposedCount - this.reusableCount;
            this.move(v1, v0_1, 1);
            this.disposeOrReuseStartingFromIndex(v0_1);
        }

        if(this.slotIdsOfCompositionsNeededInApproach.contains(arg7)) {
            LayoutNode.requestRemeasure$ui$default(this.root, true, false, false, 6, null);
        }
    }

    private final void disposeUnusedSlotsInApproach() {
        LayoutNodeSubcompositionsState v0 = this;
        MutableScatterMap v1 = v0.approachPrecomposeSlotHandleMap;
        long[] v2 = v1.metadata;
        int v3 = v2.length - 2;
        if(v3 >= 0) {
            int v5;
            for(v5 = 0; true; ++v5) {
                long v6 = v2[v5];
                if((~v6 << 7 & v6 & -9187201950435737472L) != -9187201950435737472L) {
                    int v9 = 8;
                    int v8 = 8 - (~(v5 - v3) >>> 0x1F);
                    int v10;
                    for(v10 = 0; v10 < v8; ++v10) {
                        if((0xFF & v6) < 0x80) {
                            int v11 = (v5 << 3) + v10;
                            Object v12 = v1.keys[v11];
                            Object v13 = v1.values[v11];
                            int v14 = v0.slotIdsOfCompositionsNeededInApproach.indexOf(v12);
                            if(v14 >= 0 && v14 < v0.currentApproachIndex) {
                                goto label_47;
                            }

                            if(v14 >= 0) {
                                v0.slotIdsOfCompositionsNeededInApproach.set(v14, SubcomposeLayoutKt.access$getUnspecifiedSlotId$p());
                            }

                            if(v0.precomposeMap.contains(v12)) {
                                ((PrecomposedSlotHandle)v13).dispose();
                            }

                            v1.removeValueAt(v11);
                        }

                    label_47:
                        v6 >>= v9;
                    }

                    if(v8 != v9) {
                        return;
                    }
                }

                if(v5 == v3) {
                    return;
                }
            }
        }
    }

    public final void forceRecomposeChildren() {
        if(this.reusableCount != this.root.getFoldedChildren$ui().size()) {
            MutableScatterMap v0 = this.nodeToNodeState;
            Object[] v1 = ((ScatterMap)v0).values;
            long[] v0_1 = ((ScatterMap)v0).metadata;
            int v2 = v0_1.length - 2;
            if(v2 >= 0) {
                int v4;
                for(v4 = 0; true; ++v4) {
                    long v5 = v0_1[v4];
                    if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                        int v8 = 8;
                        int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                        int v9;
                        for(v9 = 0; v9 < v7; ++v9) {
                            if((0xFF & v5) < 0x80) {
                                v1[(v4 << 3) + v9].setForceRecompose(true);
                            }

                            v5 >>= v8;
                        }

                        if(v7 != v8) {
                            break;
                        }
                    }

                    if(v4 == v2) {
                        break;
                    }
                }
            }

            LayoutNode v0_2 = this.root.getLookaheadRoot$ui();
            LayoutNode v1_1 = this.root;
            if(v0_2 != null) {
                if(v1_1.getLookaheadMeasurePending$ui()) {
                    return;
                }

                LayoutNode.requestLookaheadRemeasure$ui$default(this.root, false, false, false, 7, null);
                return;
            }

            if(v1_1.getMeasurePending$ui()) {
                return;
            }

            LayoutNode.requestRemeasure$ui$default(this.root, false, false, false, 7, null);
        }
    }

    public final CompositionContext getCompositionContext() {
        return this.compositionContext;
    }

    private final OutOfFrameExecutor getOutOfFrameExecutor() {
        return LayoutNodeKt.requireOwner(this.root).getOutOfFrameExecutor();
    }

    private final Object getSlotIdAtIndex(List arg1, int arg2) {
        Object v0 = this.nodeToNodeState.get(arg1.get(arg2));
        Intrinsics.checkNotNull(v0);
        return ((NodeState)v0).getSlotId();
    }

    public final SubcomposeSlotReusePolicy getSlotReusePolicy() {
        return this.slotReusePolicy;
    }

    private final Object ignoreRemeasureRequests(Function0 arg2) {
        LayoutNode v1 = this.root;
        LayoutNode.access$setIgnoreRemeasureRequests$p(v1, true);
        Object v2 = arg2.invoke();
        LayoutNode.access$setIgnoreRemeasureRequests$p(v1, false);
        return v2;
    }

    public final void makeSureStateIsConsistent() {
        int v0 = this.root.getFoldedChildren$ui().size();
        int v2 = 1;
        int v1 = this.nodeToNodeState.getSize() == v0 ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Inconsistency between the count of nodes tracked by the state (" + this.nodeToNodeState.getSize() + ") and the children count on the SubcomposeLayout (" + v0 + "). Are you trying to use the state of the disposed SubcomposeLayout?");
        }

        v1 = v0 - this.reusableCount - this.precomposedCount >= 0 ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Incorrect state. Total children " + v0 + ". Reusable children " + this.reusableCount + ". Precomposed children " + this.precomposedCount);
        }

        if(this.precomposeMap.getSize() == this.precomposedCount) {
        }
        else {
            v2 = 0;
        }

        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Incorrect state. Precomposed children " + this.precomposedCount + ". Map size " + this.precomposeMap.getSize());
        }
    }

    private final void markActiveNodesAsReused(boolean arg11) {
        int v0 = 0;
        this.precomposedCount = 0;
        this.precomposeMap.clear();
        List v1 = this.root.getFoldedChildren$ui();
        int v2 = v1.size();
        if(this.reusableCount != v2) {
            this.reusableCount = v2;
            Companion v3 = Snapshot.Companion;
            Snapshot v4 = v3.getCurrentThreadSnapshot();
            Function1 v5 = v4 != null ? v4.getReadObserver() : null;
            Snapshot v6 = v3.makeCurrentNonObservable(v4);
            while(true) {
                if(v0 >= v2) {
                    goto label_30;
                }

                try {
                    Object v7 = v1.get(v0);
                    Object v8 = this.nodeToNodeState.get(v7);
                    if(v8 != null && (((NodeState)v8).getActive())) {
                        this.resetLayoutState(((LayoutNode)v7));
                        this.reuseComposition(((NodeState)v8), arg11);
                        ((NodeState)v8).setSlotId(SubcomposeLayoutKt.access$getReusedSlotId$p());
                    }

                    ++v0;
                    continue;
                label_30:
                    break;
                }
                catch(Throwable v10) {
                    v3.restoreNonObservable(v4, v6, v5);
                    throw v10;
                }
            }

            v3.restoreNonObservable(v4, v6, v5);
            this.slotIdToNode.clear();
        }

        this.makeSureStateIsConsistent();
    }

    private final void move(int arg3, int arg4, int arg5) {
        LayoutNode v0 = this.root;
        LayoutNode.access$setIgnoreRemeasureRequests$p(v0, true);
        this.root.move$ui(arg3, arg4, arg5);
        LayoutNode.access$setIgnoreRemeasureRequests$p(v0, false);
    }

    static void move$default(LayoutNodeSubcompositionsState arg0, int arg1, int arg2, int arg3, int arg4, Object arg5) {
        arg0.move(arg1, arg2, 1);
    }

    public void onDeactivate() {
        this.markActiveNodesAsReused(true);
    }

    public void onRelease() {
        this.disposeCurrentNodes();
    }

    public void onReuse() {
        this.markActiveNodesAsReused(false);
    }

    public final PrecomposedSlotHandle precompose(Object arg2, Function2 arg3) {
        this.precompose(arg2, arg3, false);
        return this.createPrecomposedSlotHandle(arg2);
    }

    private final void precompose(Object arg6, Function2 arg7, boolean arg8) {
        if(!this.root.isAttached()) {
        }
        else {
            this.makeSureStateIsConsistent();
            if(!this.slotIdToNode.containsKey(arg6)) {
                this.approachPrecomposeSlotHandleMap.remove(arg6);
                MutableScatterMap v0 = this.precomposeMap;
                Object v1 = v0.get(arg6);
                if(v1 == null) {
                    LayoutNode v1_1 = this.takeNodeFromReusables(arg6);
                    LayoutNode v2 = this.root;
                    if(v1_1 != null) {
                        this.move(v2.getFoldedChildren$ui().indexOf(v1_1), this.root.getFoldedChildren$ui().size(), 1);
                        ++this.precomposedCount;
                    }
                    else {
                        v1_1 = this.createNodeAt(v2.getFoldedChildren$ui().size());
                        ++this.precomposedCount;
                    }

                    v0.set(arg6, v1_1);
                }

                this.subcompose(((LayoutNode)v1), arg6, arg8, arg7);
            }
        }
    }

    public final PausedPrecomposition precomposePaused(Object arg2, Function2 arg3) {
        if(!this.root.isAttached()) {
            return new LayoutNodeSubcompositionsState$precomposePaused$1(this, arg2);
        }

        this.precompose(arg2, arg3, true);
        return new LayoutNodeSubcompositionsState$precomposePaused$2(this, arg2);
    }

    private final void resetLayoutState(LayoutNode arg2) {
        arg2.getMeasurePassDelegate$ui().setMeasuredByParent$ui(UsageByParent.NotUsed);
        LookaheadPassDelegate v1 = arg2.getLookaheadPassDelegate$ui();
        if(v1 != null) {
            v1.setMeasuredByParent$ui(UsageByParent.NotUsed);
        }
    }

    private final void reuseComposition(NodeState arg4, boolean arg5) {
        ReusableComposition v3;
        if((arg5) || !arg4.getComposedWithReusableContentHost()) {
            arg4.setActiveState(SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null));
        }
        else {
            arg4.setActive(false);
        }

        if(arg4.getPausedComposition() != null) {
            this.cancelPausedPrecomposition(arg4);
            return;
        }

        if(arg5) {
            v3 = arg4.getComposition();
            if(v3 != null) {
                v3.deactivate();
                return;
            }
        }
        else {
            OutOfFrameExecutor v5 = this.getOutOfFrameExecutor();
            if(v5 != null) {
                this.deactivateOutOfFrame(arg4, v5);
                return;
            }
            else if(!arg4.getComposedWithReusableContentHost()) {
                v3 = arg4.getComposition();
                if(v3 != null) {
                    v3.deactivate();
                }
            }
        }
    }

    public final void setCompositionContext(CompositionContext arg1) {
        this.compositionContext = arg1;
    }

    public final void setSlotReusePolicy(SubcomposeSlotReusePolicy arg7) {
        if(this.slotReusePolicy != arg7) {
            this.slotReusePolicy = arg7;
            this.markActiveNodesAsReused(false);
            LayoutNode.requestRemeasure$ui$default(this.root, false, false, false, 7, null);
        }
    }

    private final void subcompose(LayoutNode arg9, Object arg10, boolean arg11, Function2 arg12) {
        NodeState v1_1;
        MutableScatterMap v0 = this.nodeToNodeState;
        Object v1 = v0.get(arg9);
        if(v1 == null) {
            NodeState v2 = new NodeState(arg10, ComposableSingletons$SubcomposeLayoutKt.INSTANCE.getLambda$641200809$ui(), null, 4, null);
            v0.set(arg9, v2);
            v1_1 = v2;
        }

        boolean v2_1 = true;
        int v10 = v1_1.getContent() != arg12 ? 1 : 0;
        if(v1_1.getPausedComposition() == null) {
        label_28:
            ReusableComposition v3 = v1_1.getComposition();
            if(v3 != null) {
                v2_1 = v3.getHasInvalidations();
            }

            if(v10 == 0 && !v2_1) {
                if(v1_1.getForceRecompose()) {
                }
                else {
                    return;
                }
            }

            goto label_37;
        }
        else if(v10 != 0) {
            this.cancelPausedPrecomposition(v1_1);
            goto label_28;
        }
        else if(arg11) {
        }
        else {
            this.applyPausedPrecomposition(v1_1, true);
            goto label_28;
        }

        return;
    label_37:
        v1_1.setContent(arg12);
        this.subcompose(arg9, v1_1, arg11);
        v1_1.setForceRecompose(false);
    }

    private final void subcompose(LayoutNode arg11, NodeState arg12, boolean arg13) {
        ComposableLambda v11_1;
        int v0 = arg12.getPausedComposition() == null ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("new subcompose call while paused composition is still active");
        }

        Companion v0_1 = Snapshot.Companion;
        Snapshot v3 = v0_1.getCurrentThreadSnapshot();
        Function1 v4 = v3 != null ? v3.getReadObserver() : null;
        Snapshot v5 = v0_1.makeCurrentNonObservable(v3);
        try {
            LayoutNode v6 = this.root;
            LayoutNode.access$setIgnoreRemeasureRequests$p(v6, true);
            ReusableComposition v7 = arg12.getComposition();
            CompositionContext v8 = this.compositionContext;
            if(v8 == null) {
                goto label_65;
            }

            if(v7 == null || (v7.isDisposed())) {
                if(arg13) {
                    PausableComposition v7_1 = SubcompositionKt.createPausableSubcomposition(arg11, v8);
                }
                else {
                    v7 = SubcompositionKt.createSubcomposition(arg11, v8);
                }
            }

            arg12.setComposition(v7);
            Function2 v11 = arg12.getContent();
            if(this.getOutOfFrameExecutor() != null) {
                arg12.setComposedWithReusableContentHost(false);
            }
            else {
                arg12.setComposedWithReusableContentHost(true);
                v11_1 = ComposableLambdaKt.composableLambdaInstance(0x5AD8C84E, true, new LayoutNodeSubcompositionsState$subcompose$4$1$composable$1(arg12, v11));
            }

            if(arg13) {
                Intrinsics.checkNotNull(v7, "null cannot be cast to non-null type androidx.compose.runtime.PausableComposition");
                if(arg12.getForceReuse()) {
                    arg12.setPausedComposition(((PausableComposition)v7).setPausableContentWithReuse(((Function2)v11_1)));
                }
                else {
                    arg12.setPausedComposition(((PausableComposition)v7).setPausableContent(((Function2)v11_1)));
                }
            }
            else if(arg12.getForceReuse()) {
                v7.setContentWithReuse(((Function2)v11_1));
            }
            else {
                v7.setContent(((Function2)v11_1));
            }

            arg12.setForceReuse(false);
            LayoutNode.access$setIgnoreRemeasureRequests$p(v6, false);
        }
        catch(Throwable v10) {
            goto label_71;
        }

        v0_1.restoreNonObservable(v3, v5, v4);
        return;
        try {
        label_65:
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("parent composition reference not set");
            throw new KotlinNothingValueException();
        }
        catch(Throwable v10) {
        label_71:
            v0_1.restoreNonObservable(v3, v5, v4);
            throw v10;
        }
    }

    public final List subcompose(Object arg12, Function2 arg13) {
        LayoutNodeSubcompositionsState v5_1;
        this.makeSureStateIsConsistent();
        LayoutState v0 = this.root.getLayoutState$ui();
        int v1 = v0 == LayoutState.Measuring || v0 == LayoutState.LayingOut || v0 == LayoutState.LookaheadMeasuring || v0 == LayoutState.LookaheadLayingOut ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalStateException("subcompose can only be used inside the measure or layout blocks");
        }

        MutableScatterMap v1_1 = this.slotIdToNode;
        Object v4 = v1_1.get(arg12);
        if(v4 == null) {
            v4 = this.precomposeMap.remove(arg12);
            if(v4 != null) {
                this.nodeToNodeState.get(v4);
                int v5 = this.precomposedCount > 0 ? 1 : 0;
                if(v5 == 0) {
                    InlineClassHelperKt.throwIllegalStateException("Check failed.");
                }

                --this.precomposedCount;
            }
            else {
                LayoutNode v4_1 = this.takeNodeFromReusables(arg12);
                if(v4_1 != null) {
                    goto label_44;
                }

                v4_1 = this.createNodeAt(this.currentIndex);
            }

        label_44:
            v1_1.set(arg12, v4);
        }

        if(CollectionsKt.getOrNull(this.root.getFoldedChildren$ui(), this.currentIndex) != v4) {
            int v6 = this.root.getFoldedChildren$ui().indexOf(v4);
            v1 = v6 >= this.currentIndex ? 1 : 0;
            if(v1 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("Key \"" + arg12 + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.");
            }

            int v7 = this.currentIndex;
            if(v7 == v6) {
                goto label_75;
            }

            v5_1 = this;
            LayoutNodeSubcompositionsState.move$default(v5_1, v6, v7, 0, 4, null);
        }
        else {
        label_75:
            v5_1 = this;
        }

        ++v5_1.currentIndex;
        v5_1.subcompose(((LayoutNode)v4), arg12, false, arg13);
        if(v0 != LayoutState.Measuring) {
            if(v0 == LayoutState.LayingOut) {
            }
            else {
                return ((LayoutNode)v4).getChildLookaheadMeasurables$ui();
            }
        }

        return ((LayoutNode)v4).getChildMeasurables$ui();
    }

    private final LayoutNode takeNodeFromReusables(Object arg11) {
        Object v5_1;
        int v7;
        int v6;
        LayoutNode v1 = null;
        if(this.reusableCount == 0) {
            return v1;
        }

        List v0 = this.root.getFoldedChildren$ui();
        int v2 = v0.size() - this.precomposedCount;
        int v3 = v2 - this.reusableCount;
        --v2;
        int v5 = v2;
        while(true) {
            v6 = -1;
            if(v5 < v3) {
                break;
            }
            else if(Intrinsics.areEqual(this.getSlotIdAtIndex(v0, v5), arg11)) {
                v7 = v5;
            }
            else {
                --v5;
                continue;
            }

            goto label_24;
        }

        v7 = v6;
    label_24:
        if(v7 == v6) {
            while(true) {
                if(v2 >= v3) {
                    v5_1 = this.nodeToNodeState.get(v0.get(v2));
                    Intrinsics.checkNotNull(v5_1);
                    if(((NodeState)v5_1).getSlotId() != SubcomposeLayoutKt.access$getReusedSlotId$p()) {
                        if(this.slotReusePolicy.areCompatible(arg11, ((NodeState)v5_1).getSlotId())) {
                        }
                        else {
                            --v2;
                            continue;
                        }
                    }

                    break;
                }
                else {
                    goto label_44;
                }
            }

            ((NodeState)v5_1).setSlotId(arg11);
            v5 = v2;
            v7 = v5;
            goto label_45;
        label_44:
            v5 = v2;
        }

    label_45:
        if(v7 == v6) {
            return v1;
        }

        if(v5 != v3) {
            this.move(v5, v3, 1);
        }

        this.reusableCount += v6;
        arg11 = v0.get(v3);
        Object v10 = this.nodeToNodeState.get(arg11);
        Intrinsics.checkNotNull(v10);
        ((NodeState)v10).setActiveState(SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(true), ((SnapshotMutationPolicy)v1), 2, v1));
        ((NodeState)v10).setForceReuse(true);
        ((NodeState)v10).setForceRecompose(true);
        return ((LayoutNode)arg11);
    }
}

