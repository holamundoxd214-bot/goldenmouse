package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ScrollIndicatorState;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollDeltaBetweenPasses;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000ÿ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001[\b\u0007\u0018\u0000 «\u00012\u00020\u0001:\u0002«\u0001B\'\b\u0007\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB%\b\u0017\u0012\u0006\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\u000BB\u001D\b\u0016\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\fJ\b\u0010]\u001A\u00020\u0003H\u0002J\"\u0010m\u001A\u00020n2\b\b\u0001\u0010o\u001A\u00020\u00032\b\b\u0002\u0010p\u001A\u00020\u0003H\u0086@¢\u0006\u0002\u0010qJ\u001A\u0010t\u001A\u00020n2\b\b\u0001\u0010o\u001A\u00020\u00032\b\b\u0002\u0010p\u001A\u00020\u0003J%\u0010u\u001A\u00020n2\u0006\u0010o\u001A\u00020\u00032\u0006\u0010p\u001A\u00020\u00032\u0006\u0010v\u001A\u00020\u0010H\u0000¢\u0006\u0002\bwJA\u0010x\u001A\u00020n2\u0006\u0010y\u001A\u00020z2(\u0010{\u001A$\b\u0001\u0012\u0004\u0012\u00020}\u0012\n\u0012\b\u0012\u0004\u0012\u00020n0~\u0012\u0006\u0012\u0004\u0018\u00010\u007F0|¢\u0006\u0003\b\u0080\u0001H\u0096@¢\u0006\u0003\u0010\u0081\u0001J\u0012\u0010\u0082\u0001\u001A\u00020,2\u0007\u0010\u0083\u0001\u001A\u00020,H\u0016J\u0018\u0010\u0096\u0001\u001A\u00020,2\u0007\u0010\u0097\u0001\u001A\u00020,H\u0000¢\u0006\u0003\b\u0098\u0001J\u001A\u0010\u0099\u0001\u001A\u00020n2\u0007\u0010\u0083\u0001\u001A\u00020,2\u0006\u0010 \u001A\u00020!H\u0002J#\u0010\u009C\u0001\u001A\u00020n2\b\b\u0001\u0010o\u001A\u00020\u00032\b\b\u0002\u0010p\u001A\u00020\u0003H\u0086@¢\u0006\u0002\u0010qJ,\u0010\u009D\u0001\u001A\u00020n2\u0007\u0010\u009E\u0001\u001A\u00020\u00142\u0007\u0010\u009F\u0001\u001A\u00020\u00102\t\b\u0002\u0010 \u0001\u001A\u00020\u0010H\u0000¢\u0006\u0003\b¡\u0001J\"\u0010¦\u0001\u001A\u00020\u00032\b\u0010§\u0001\u001A\u00030¨\u00012\u0007\u0010©\u0001\u001A\u00020\u0003H\u0000¢\u0006\u0003\bª\u0001R\u0014\u0010\u0005\u001A\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u001E\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u0010@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u000F\u001A\u0004\u0018\u00010\u0014@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u000E\u0010\u0018\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001A\u00020\u00038G¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0011\u0010\u0004\u001A\u00020\u00038G¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001CR\u0014\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00140\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001A\u00020!8G¢\u0006\u0006\u001A\u0004\b\"\u0010#R\u0011\u0010$\u001A\u00020%8F¢\u0006\u0006\u001A\u0004\b&\u0010\'R\u0014\u0010(\u001A\u00020)X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b*\u0010+R\u001E\u0010-\u001A\u00020,2\u0006\u0010\u000F\u001A\u00020,@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b.\u0010/R\u0014\u00100\u001A\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b1\u0010\u001CR\u0014\u00102\u001A\u0002038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b4\u00105R\u000E\u00106\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u00107\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0003@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b8\u0010\u001CR\u001A\u00109\u001A\u00020\u0010X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b:\u0010\u0013\"\u0004\b;\u0010<R\"\u0010>\u001A\u0004\u0018\u00010=2\b\u0010\u000F\u001A\u0004\u0018\u00010=@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b?\u0010@R\u0014\u0010A\u001A\u00020BX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bC\u0010DR\u0014\u0010E\u001A\u00020FX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bG\u0010HR\u001A\u0010I\u001A\b\u0012\u0004\u0012\u00020K0JX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bL\u0010MR\u0014\u0010N\u001A\u00020OX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bP\u0010QR\u001A\u0010R\u001A\u00020SX\u0080\u0004¢\u0006\u000E\n\u0000\u0012\u0004\bT\u0010U\u001A\u0004\bV\u0010WR\u000E\u0010X\u001A\u00020YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001A\u00020[X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\\R\u0014\u0010^\u001A\u00020_X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b`\u0010aR\u001B\u0010b\u001A\u00020c8@X\u0080\u0084\u0002¢\u0006\f\u001A\u0004\bf\u0010g*\u0004\bd\u0010eR\u0016\u0010h\u001A\u00020iX\u0080\u0004¢\u0006\n\n\u0002\u0010l\u001A\u0004\bj\u0010kR\u0016\u0010r\u001A\u00020iX\u0080\u0004¢\u0006\n\n\u0002\u0010l\u001A\u0004\bs\u0010kR\u0016\u0010\u0084\u0001\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b\u0084\u0001\u0010\u0013R0\u0010\u0086\u0001\u001A\u00020\u00102\u0007\u0010\u0085\u0001\u001A\u00020\u00108V@RX\u0096\u008E\u0002¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010l\u001A\u0005\b\u0087\u0001\u0010\u0013\"\u0005\b\u0088\u0001\u0010<R0\u0010\u008A\u0001\u001A\u00020\u00102\u0007\u0010\u0085\u0001\u001A\u00020\u00108V@RX\u0096\u008E\u0002¢\u0006\u0015\n\u0005\b\u008D\u0001\u0010l\u001A\u0005\b\u008B\u0001\u0010\u0013\"\u0005\b\u008C\u0001\u0010<R\u0016\u0010\u008E\u0001\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b\u008F\u0001\u0010\u0013R\u0016\u0010\u0090\u0001\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b\u0091\u0001\u0010\u0013R\u001A\u0010\u0092\u0001\u001A\u0005\u0018\u00010\u0093\u00018VX\u0096\u0004¢\u0006\b\u001A\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0016\u0010\u009A\u0001\u001A\u00020\u00038BX\u0082\u0004¢\u0006\u0007\u001A\u0005\b\u009B\u0001\u0010\u001CR\u0010\u0010¢\u0001\u001A\u00030£\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010¤\u0001\u001A\u00020,8@X\u0080\u0004¢\u0006\u0007\u001A\u0005\b¥\u0001\u0010/¨\u0006¬\u0001"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "prefetchStrategy", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "<init>", "(IILandroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;)V", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;II)V", "(II)V", "getPrefetchStrategy$foundation", "()Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "value", "", "hasLookaheadOccurred", "getHasLookaheadOccurred$foundation", "()Z", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "approachLayoutInfo", "getApproachLayoutInfo$foundation", "()Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "executeRequestsInHighPriorityMode", "scrollPosition", "Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation", "()F", "slotsPerLine", "getSlotsPerLine$foundation", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation", "()Landroidx/compose/ui/unit/Density;", "scrollableState", "numMeasurePasses", "getNumMeasurePasses$foundation", "prefetchingEnabled", "getPrefetchingEnabled$foundation", "setPrefetchingEnabled$foundation", "(Z)V", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "getItemAnimator$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation$annotations", "()V", "getPrefetchState$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchScope", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "_scrollIndicatorState", "androidx/compose/foundation/lazy/grid/LazyGridState$_scrollIndicatorState$1", "Landroidx/compose/foundation/lazy/grid/LazyGridState$_scrollIndicatorState$1;", "calculateScrollOffset", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation$delegate", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)Ljava/lang/Object;", "getNearestRange$foundation", "()Lkotlin/ranges/IntRange;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getPlacementScopeInvalidator-zYiylxw$foundation", "()Landroidx/compose/runtime/MutableState;", "Landroidx/compose/runtime/MutableState;", "scrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "measurementScopeInvalidator", "getMeasurementScopeInvalidator-zYiylxw$foundation", "requestScrollToItem", "snapToItemIndexInternal", "forceRemeasure", "snapToItemIndexInternal$foundation", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "isScrollInProgress", "<set-?>", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "canScrollBackward", "getCanScrollBackward", "setCanScrollBackward", "canScrollBackward$delegate", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "scrollIndicatorState", "Landroidx/compose/foundation/ScrollIndicatorState;", "getScrollIndicatorState", "()Landroidx/compose/foundation/ScrollIndicatorState;", "onScroll", "distance", "onScroll$foundation", "notifyPrefetchOnScroll", "numOfItemsToTeleport", "getNumOfItemsToTeleport", "animateScrollToItem", "applyMeasureResult", "result", "isLookingAhead", "visibleItemsStayedTheSame", "applyMeasureResult$foundation", "_lazyLayoutScrollDeltaBetweenPasses", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollDeltaBetweenPasses;", "scrollDeltaBetweenPasses", "getScrollDeltaBetweenPasses$foundation", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyGridState implements ScrollableState {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\n\u001A\u00020\u000BH\u0001¢\u0006\u0002\b\fJ\u001F\u0010\t\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\r\u001A\u00020\u000EH\u0001¢\u0006\u0002\b\fR\u001B\u0010\u0004\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "saver", "prefetchStrategy", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "saver$foundation", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver getSaver() {
            return LazyGridState.Saver;
        }

        public final Saver saver$foundation(LazyGridPrefetchStrategy arg2) {
            return ListSaverKt.listSaver(new LazyGridState$Companion$$ExternalSyntheticLambda2(), new LazyGridState$Companion$$ExternalSyntheticLambda3(arg2));
        }

        public final Saver saver$foundation(LazyLayoutCacheWindow arg2) {
            return ListSaverKt.listSaver(new LazyGridState$Companion$$ExternalSyntheticLambda0(), new LazyGridState$Companion$$ExternalSyntheticLambda1(arg2));
        }

        static final List saver$lambda$0(SaverScope arg2, LazyGridState arg3) {
            return CollectionsKt.listOf(new Integer[]{Integer.valueOf(arg3.getFirstVisibleItemIndex()), Integer.valueOf(arg3.getFirstVisibleItemScrollOffset())});
        }

        static final LazyGridState saver$lambda$1(LazyGridPrefetchStrategy arg3, List arg4) {
            return new LazyGridState(arg4.get(0).intValue(), arg4.get(1).intValue(), arg3);
        }

        static final List saver$lambda$2(SaverScope arg2, LazyGridState arg3) {
            return CollectionsKt.listOf(new Integer[]{Integer.valueOf(arg3.getFirstVisibleItemIndex()), Integer.valueOf(arg3.getFirstVisibleItemScrollOffset())});
        }

        static final LazyGridState saver$lambda$3(LazyLayoutCacheWindow arg3, List arg4) {
            return new LazyGridState(arg3, arg4.get(0).intValue(), arg4.get(1).intValue());
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Saver Saver;
    private final LazyLayoutScrollDeltaBetweenPasses _lazyLayoutScrollDeltaBetweenPasses;
    private final LazyGridState$_scrollIndicatorState$1 _scrollIndicatorState;
    private LazyGridMeasureResult approachLayoutInfo;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private boolean executeRequestsInHighPriorityMode;
    private boolean hasLookaheadOccurred;
    private final MutableInteractionSource internalInteractionSource;
    private final LazyLayoutItemAnimator itemAnimator;
    private final MutableState layoutInfoState;
    private final MutableState measurementScopeInvalidator;
    private int numMeasurePasses;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final MutableState placementScopeInvalidator;
    private final LazyGridPrefetchScope prefetchScope;
    private final LazyLayoutPrefetchState prefetchState;
    private final LazyGridPrefetchStrategy prefetchStrategy;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;

    static {
        LazyGridState.Companion = new Companion(null);
        LazyGridState.Saver = ListSaverKt.listSaver(new LazyGridState$$ExternalSyntheticLambda2(), new LazyGridState$$ExternalSyntheticLambda3());
    }

    public LazyGridState() {
        this(0, 0, null, 7, null);
    }

    public LazyGridState(int arg2, int arg3, LazyGridPrefetchStrategy arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 4) != 0) {
            arg4 = LazyGridPrefetchStrategyKt.LazyGridPrefetchStrategy$default(0, 1, null);
        }

        this(0, 0, arg4);
    }

    public LazyGridState(int arg4, int arg5) {
        this(arg4, arg5, LazyGridPrefetchStrategyKt.LazyGridPrefetchStrategy$default(0, 1, null));
    }

    public LazyGridState(int arg4, int arg5, LazyGridPrefetchStrategy arg6) {
        super();
        this.prefetchStrategy = arg6;
        LazyGridScrollPosition v0 = new LazyGridScrollPosition(arg4, arg5);
        this.scrollPosition = v0;
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyGridStateKt.access$getEmptyLazyGridLayoutInfo$p(), SnapshotStateKt.neverEqualPolicy());
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.scrollableState = ScrollableStateKt.ScrollableState(new LazyGridState$$ExternalSyntheticLambda0(this));
        this.prefetchingEnabled = true;
        this.remeasurementModifier = new LazyGridState$remeasurementModifier$1(this);
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.itemAnimator = new LazyLayoutItemAnimator();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.prefetchState = new LazyLayoutPrefetchState(arg6.getPrefetchScheduler(), new LazyGridState$$ExternalSyntheticLambda1(this, arg4));
        this.prefetchScope = new LazyGridState$prefetchScope$1(this);
        this._scrollIndicatorState = new LazyGridState$_scrollIndicatorState$1(this);
        this.pinnedItems = new LazyLayoutPinnedItemList();
        v0.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(null, 1, null);
        this.measurementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(null, 1, null);
        Boolean v5 = Boolean.valueOf(false);
        this.canScrollForward$delegate = SnapshotStateKt.mutableStateOf$default(v5, null, 2, null);
        this.canScrollBackward$delegate = SnapshotStateKt.mutableStateOf$default(v5, null, 2, null);
        this._lazyLayoutScrollDeltaBetweenPasses = new LazyLayoutScrollDeltaBetweenPasses();
    }

    public LazyGridState(int arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
        this(0, 0);
    }

    public LazyGridState(LazyLayoutCacheWindow arg2, int arg3, int arg4) {
        this(arg3, arg4, new LazyGridCacheWindowPrefetchStrategy(arg2));
    }

    public LazyGridState(LazyLayoutCacheWindow arg2, int arg3, int arg4, int arg5, DefaultConstructorMarker arg6) {
        this(arg2, 0, 0);
    }

    static final List Saver$lambda$0(SaverScope arg2, LazyGridState arg3) {
        return CollectionsKt.listOf(new Integer[]{Integer.valueOf(arg3.getFirstVisibleItemIndex()), Integer.valueOf(arg3.getFirstVisibleItemScrollOffset())});
    }

    static final LazyGridState Saver$lambda$1(List arg3) {
        return new LazyGridState(arg3.get(0).intValue(), arg3.get(1).intValue());
    }

    public static final int access$calculateScrollOffset(LazyGridState arg0) {
        return arg0.calculateScrollOffset();
    }

    public static final boolean access$getExecuteRequestsInHighPriorityMode$p(LazyGridState arg0) {
        return arg0.executeRequestsInHighPriorityMode;
    }

    public static final MutableState access$getLayoutInfoState$p(LazyGridState arg0) {
        return arg0.layoutInfoState;
    }

    public static final int access$getNumOfItemsToTeleport(LazyGridState arg0) {
        return arg0.getNumOfItemsToTeleport();
    }

    public static final Saver access$getSaver$cp() {
        return LazyGridState.Saver;
    }

    public static final void access$setRemeasurement$p(LazyGridState arg0, Remeasurement arg1) {
        arg0.remeasurement = arg1;
    }

    public final Object animateScrollToItem(int arg7, int arg8, Continuation arg9) {
        Object v6 = ScrollableState.scroll$default(this, null, new LazyGridState$animateScrollToItem$2(this, arg7, arg8, null), arg9, 1, null);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public static Object animateScrollToItem$default(LazyGridState arg0, int arg1, int arg2, Continuation arg3, int arg4, Object arg5) {
        return arg0.animateScrollToItem(arg1, 0, arg3);
    }

    public final void applyMeasureResult$foundation(LazyGridMeasureResult arg4, boolean arg5, boolean arg6) {
        this.prefetchState.setIdealNestedPrefetchCount$foundation(arg4.getVisibleItemsInfo().size());
        if(!arg5 && (this.hasLookaheadOccurred)) {
            this.approachLayoutInfo = arg4;
            return;
        }

        if(arg5) {
            this.hasLookaheadOccurred = true;
        }

        this.scrollToBeConsumed -= arg4.getConsumedScroll();
        this.layoutInfoState.setValue(arg4);
        this.setCanScrollBackward(arg4.getCanScrollBackward());
        this.setCanScrollForward(arg4.getCanScrollForward());
        LazyGridScrollPosition v1 = this.scrollPosition;
        if(arg6) {
            v1.updateScrollOffset(arg4.getFirstVisibleLineScrollOffset());
        }
        else {
            v1.updateFromMeasureResult(arg4);
            if(this.prefetchingEnabled) {
                this.prefetchStrategy.onVisibleItemsUpdated(this.prefetchScope, arg4);
            }
        }

        if(arg5) {
            this._lazyLayoutScrollDeltaBetweenPasses.updateScrollDeltaForApproach$foundation(arg4.getScrollBackAmount(), arg4.getDensity(), arg4.getCoroutineScope());
        }

        ++this.numMeasurePasses;
    }

    public static void applyMeasureResult$foundation$default(LazyGridState arg0, LazyGridMeasureResult arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        arg0.applyMeasureResult$foundation(arg1, arg2, false);
    }

    private final int calculateScrollOffset() {
        LazyGridLayoutInfo v0 = this.getLayoutInfo();
        return LazyGridLayoutInfoKt.visibleLinesAverageMainAxisSize(v0) * LazyGridLayoutInfoKt.getFirstVisibleItemLineIndex(v0) + this.getFirstVisibleItemScrollOffset();
    }

    public float dispatchRawDelta(float arg1) {
        return this.scrollableState.dispatchRawDelta(arg1);
    }

    public final LazyGridMeasureResult getApproachLayoutInfo$foundation() {
        return this.approachLayoutInfo;
    }

    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation() {
        return this.awaitLayoutModifier;
    }

    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo$foundation() {
        return this.beyondBoundsInfo;
    }

    public boolean getCanScrollBackward() {
        return this.canScrollBackward$delegate.getValue().booleanValue();
    }

    public boolean getCanScrollForward() {
        return this.canScrollForward$delegate.getValue().booleanValue();
    }

    public final Density getDensity$foundation() {
        return this.layoutInfoState.getValue().getDensity();
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.getIndex();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    public final boolean getHasLookaheadOccurred$foundation() {
        return this.hasLookaheadOccurred;
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    public final MutableInteractionSource getInternalInteractionSource$foundation() {
        return this.internalInteractionSource;
    }

    public final LazyLayoutItemAnimator getItemAnimator$foundation() {
        return this.itemAnimator;
    }

    public boolean getLastScrolledBackward() {
        return this.scrollableState.getLastScrolledBackward();
    }

    public boolean getLastScrolledForward() {
        return this.scrollableState.getLastScrolledForward();
    }

    public final LazyGridLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final MutableState getMeasurementScopeInvalidator-zYiylxw$foundation() {
        return this.measurementScopeInvalidator;
    }

    public final IntRange getNearestRange$foundation() {
        return this.scrollPosition.getNearestRangeState().getValue();
    }

    private static Object getNearestRange$foundation$delegate(LazyGridState arg0) {
        return arg0.scrollPosition.getNearestRangeState();
    }

    public final int getNumMeasurePasses$foundation() {
        return this.numMeasurePasses;
    }

    private final int getNumOfItemsToTeleport() {
        return this.getSlotsPerLine$foundation() * 100;
    }

    public final LazyLayoutPinnedItemList getPinnedItems$foundation() {
        return this.pinnedItems;
    }

    public final MutableState getPlacementScopeInvalidator-zYiylxw$foundation() {
        return this.placementScopeInvalidator;
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation() {
        return this.prefetchState;
    }

    public static void getPrefetchState$foundation$annotations() {
    }

    public final LazyGridPrefetchStrategy getPrefetchStrategy$foundation() {
        return this.prefetchStrategy;
    }

    public final boolean getPrefetchingEnabled$foundation() {
        return this.prefetchingEnabled;
    }

    public final Remeasurement getRemeasurement$foundation() {
        return this.remeasurement;
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation() {
        return this.remeasurementModifier;
    }

    public final float getScrollDeltaBetweenPasses$foundation() {
        return this._lazyLayoutScrollDeltaBetweenPasses.getScrollDeltaBetweenPasses$foundation();
    }

    public ScrollIndicatorState getScrollIndicatorState() {
        return this._scrollIndicatorState;
    }

    public final float getScrollToBeConsumed$foundation() {
        return this.scrollToBeConsumed;
    }

    public final int getSlotsPerLine$foundation() {
        return this.layoutInfoState.getValue().getSlotsPerLine();
    }

    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    private final void notifyPrefetchOnScroll(float arg2, LazyGridLayoutInfo arg3) {
        if(this.prefetchingEnabled) {
            this.prefetchStrategy.onScroll(this.prefetchScope, arg2, arg3);
        }
    }

    public final float onScroll$foundation(float arg9) {
        if(arg9 < 0f && !this.getCanScrollForward() || arg9 > 0f && !this.getCanScrollBackward()) {
            return 0;
        }

        float v2 = 0.5f;
        int v1 = Float.compare(Math.abs(this.scrollToBeConsumed), v2) <= 0 ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalStateException("entered drag with non-zero pending scroll");
        }

        float v1_1 = this.scrollToBeConsumed + arg9;
        this.scrollToBeConsumed = v1_1;
        if(Math.abs(v1_1) > v2) {
            v1_1 = this.scrollToBeConsumed;
            int v4 = MathKt.roundToInt(v1_1);
            LazyGridMeasureResult v5 = this.layoutInfoState.getValue().copyWithScrollDeltaWithoutRemeasure(v4, this.hasLookaheadOccurred ^ 1);
            if(v5 != null) {
                LazyGridMeasureResult v6 = this.approachLayoutInfo;
                if(v6 != null) {
                    LazyGridMeasureResult v7 = null;
                    LazyGridMeasureResult v4_1 = v6 != null ? v6.copyWithScrollDeltaWithoutRemeasure(v4, true) : v7;
                    if(v4_1 != null) {
                        this.approachLayoutInfo = v4_1;
                        goto label_44;
                    }

                    v5 = v7;
                }
            }

        label_44:
            if(v5 != null) {
                this.applyMeasureResult$foundation(v5, this.hasLookaheadOccurred, true);
                ObservableScopeInvalidator.invalidateScope-impl(this.placementScopeInvalidator);
                this.notifyPrefetchOnScroll(v1_1 - this.scrollToBeConsumed, ((LazyGridLayoutInfo)v5));
                goto label_60;
            }

            Remeasurement v3 = this.remeasurement;
            if(v3 != null) {
                v3.forceRemeasure();
            }

            this.notifyPrefetchOnScroll(v1_1 - this.scrollToBeConsumed, this.getLayoutInfo());
        }

    label_60:
        if(Math.abs(this.scrollToBeConsumed) <= v2) {
            return arg9;
        }

        arg9 -= this.scrollToBeConsumed;
        this.scrollToBeConsumed = 0f;
        return arg9;
    }

    static final Unit prefetchState$lambda$0(LazyGridState arg4, int arg5, NestedPrefetchScope arg6) {
        LazyGridPrefetchStrategy v4 = arg4.prefetchStrategy;
        androidx.compose.runtime.snapshots.Snapshot$Companion v0 = Snapshot.Companion;
        Snapshot v1 = v0.getCurrentThreadSnapshot();
        Function1 v2 = v1 != null ? v1.getReadObserver() : null;
        v0.restoreNonObservable(v1, v0.makeCurrentNonObservable(v1), v2);
        v4.onNestedPrefetch(arg6, arg5);
        return Unit.INSTANCE;
    }

    public final void requestScrollToItem(int arg8, int arg9) {
        if(this.isScrollInProgress()) {
            BuildersKt.launch$default(this.layoutInfoState.getValue().getCoroutineScope(), null, null, new LazyGridState$requestScrollToItem$1(this, null), 3, null);
        }

        this.snapToItemIndexInternal$foundation(arg8, arg9, false);
    }

    public static void requestScrollToItem$default(LazyGridState arg0, int arg1, int arg2, int arg3, Object arg4) {
        arg0.requestScrollToItem(arg1, 0);
    }

    public Object scroll(MutatePriority arg7, Function2 arg8, Continuation arg9) {
        int v2;
        Continuation v0;
        if((arg9 instanceof LazyGridState$scroll$1)) {
            v0 = arg9;
            v2 = 0x80000000;
            if((((LazyGridState$scroll$1)v0).label & v2) != 0) {
                ((LazyGridState$scroll$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            LazyGridState$scroll$1 v0_1 = new LazyGridState$scroll$1(this, arg9);
        }

        Object v9 = ((LazyGridState$scroll$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((LazyGridState$scroll$1)v0).label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            if(this.layoutInfoState.getValue() == LazyGridStateKt.access$getEmptyLazyGridLayoutInfo$p()) {
                AwaitFirstLayoutModifier v9_1 = this.awaitLayoutModifier;
                ((LazyGridState$scroll$1)v0).L$0 = arg7;
                ((LazyGridState$scroll$1)v0).L$1 = arg8;
                ((LazyGridState$scroll$1)v0).label = 1;
                if(v9_1.waitForFirstLayout(v0) == v1) {
                    return v1;
                }
                else {
                    goto label_46;
                }
            }
            else {
            label_46:
                ScrollableState v6 = this.scrollableState;
                ((LazyGridState$scroll$1)v0).L$0 = null;
                ((LazyGridState$scroll$1)v0).L$1 = null;
                ((LazyGridState$scroll$1)v0).label = v3;
                if(v6.scroll(((MutatePriority)v7), ((Function2)v8), v0) == v1) {
                    return v1;
                }
            }
        }
        else if(v2 == 1) {
            Object v7 = ((LazyGridState$scroll$1)v0).L$1;
            Object v8 = ((LazyGridState$scroll$1)v0).L$0;
            ResultKt.throwOnFailure(v9);
            Object v5 = v8;
            v8 = v7;
            v7 = v5;
            goto label_46;
        }
        else if(v2 == v3) {
            ResultKt.throwOnFailure(v9);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Unit.INSTANCE;
    }

    public final Object scrollToItem(int arg7, int arg8, Continuation arg9) {
        Object v6 = ScrollableState.scroll$default(this, null, new LazyGridState$scrollToItem$2(this, arg7, arg8, null), arg9, 1, null);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public static Object scrollToItem$default(LazyGridState arg0, int arg1, int arg2, Continuation arg3, int arg4, Object arg5) {
        return arg0.scrollToItem(arg1, 0, arg3);
    }

    static final float scrollableState$lambda$0(LazyGridState arg0, float arg1) {
        return -arg0.onScroll$foundation(-arg1);
    }

    private void setCanScrollBackward(boolean arg1) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(arg1));
    }

    private void setCanScrollForward(boolean arg1) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setPrefetchingEnabled$foundation(boolean arg1) {
        this.prefetchingEnabled = arg1;
    }

    public final void snapToItemIndexInternal$foundation(int arg3, int arg4, boolean arg5) {
        if(this.scrollPosition.getIndex() != arg3 || this.scrollPosition.getScrollOffset() != arg4) {
            this.itemAnimator.reset();
            LazyGridPrefetchStrategy v0 = this.prefetchStrategy;
            if((v0 instanceof CacheWindowLogic)) {
            }
            else {
                v0 = null;
            }

            if(v0 == null) {
                goto label_15;
            }

            ((CacheWindowLogic)v0).resetStrategy();
        }

    label_15:
        this.scrollPosition.requestPositionAndForgetLastKnownKey(arg3, arg4);
        if(arg5) {
            Remeasurement v2 = this.remeasurement;
            if(v2 != null) {
                v2.forceRemeasure();
            }

            return;
        }

        ObservableScopeInvalidator.invalidateScope-impl(this.measurementScopeInvalidator);
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved$foundation(LazyGridItemProvider arg1, int arg2) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(arg1, arg2);
    }
}

