package androidx.compose.foundation.lazy;

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
import androidx.compose.ui.util.AndroidTrace_androidKt;
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
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000ÿ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001Y\b\u0007\u0018\u0000 ©\u00012\u00020\u0001:\u0002©\u0001B\'\b\u0007\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB%\b\u0017\u0012\u0006\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\u000BB\u001D\b\u0016\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\fJ\b\u0010[\u001A\u00020\u0003H\u0002J\"\u0010f\u001A\u00020g2\b\b\u0001\u0010h\u001A\u00020\u00032\b\b\u0002\u0010i\u001A\u00020\u0003H\u0086@¢\u0006\u0002\u0010jJ\u001A\u0010p\u001A\u00020g2\b\b\u0001\u0010h\u001A\u00020\u00032\b\b\u0002\u0010i\u001A\u00020\u0003J%\u0010q\u001A\u00020g2\u0006\u0010h\u001A\u00020\u00032\u0006\u0010i\u001A\u00020\u00032\u0006\u0010r\u001A\u00020\u0010H\u0000¢\u0006\u0002\bsJ?\u0010t\u001A\u00020g2\u0006\u0010u\u001A\u00020v2\'\u0010w\u001A#\b\u0001\u0012\u0004\u0012\u00020y\u0012\n\u0012\b\u0012\u0004\u0012\u00020g0z\u0012\u0006\u0012\u0004\u0018\u00010{0x¢\u0006\u0002\b|H\u0096@¢\u0006\u0002\u0010}J\u0010\u0010~\u001A\u00020,2\u0006\u0010\u007F\u001A\u00020,H\u0016J\u0018\u0010\u0094\u0001\u001A\u00020,2\u0007\u0010\u0095\u0001\u001A\u00020,H\u0000¢\u0006\u0003\b\u0096\u0001J\u0019\u0010\u0097\u0001\u001A\u00020g2\u0006\u0010\u007F\u001A\u00020,2\u0006\u0010 \u001A\u00020!H\u0002J#\u0010\u0098\u0001\u001A\u00020g2\b\b\u0001\u0010h\u001A\u00020\u00032\b\b\u0002\u0010i\u001A\u00020\u0003H\u0086@¢\u0006\u0002\u0010jJ,\u0010\u0099\u0001\u001A\u00020g2\u0007\u0010\u009A\u0001\u001A\u00020\u00142\u0007\u0010\u009B\u0001\u001A\u00020\u00102\t\b\u0002\u0010\u009C\u0001\u001A\u00020\u0010H\u0000¢\u0006\u0003\b\u009D\u0001J\u0012\u0010\u009E\u0001\u001A\u00020g2\u0007\u0010\u009F\u0001\u001A\u00020\u0014H\u0002J\"\u0010¤\u0001\u001A\u00020\u00032\b\u0010¥\u0001\u001A\u00030¦\u00012\u0007\u0010§\u0001\u001A\u00020\u0003H\u0000¢\u0006\u0003\b¨\u0001R\u0014\u0010\u0005\u001A\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u001E\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u0010@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u000F\u001A\u0004\u0018\u00010\u0014@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u000E\u0010\u0018\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001A\u00020\u00038G¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0011\u0010\u0004\u001A\u00020\u00038G¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001CR\u0014\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00140\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001A\u00020!8G¢\u0006\u0006\u001A\u0004\b\"\u0010#R\u0011\u0010$\u001A\u00020%8F¢\u0006\u0006\u001A\u0004\b&\u0010\'R\u0014\u0010(\u001A\u00020)X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b*\u0010+R\u001E\u0010-\u001A\u00020,2\u0006\u0010\u000F\u001A\u00020,@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b.\u0010/R\u0014\u00100\u001A\u0002018@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b2\u00103R\u000E\u00104\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u00105\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0003@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b6\u0010\u001CR\u001A\u00107\u001A\u00020\u0010X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b8\u0010\u0013\"\u0004\b9\u0010:R\"\u0010<\u001A\u0004\u0018\u00010;2\b\u0010\u000F\u001A\u0004\u0018\u00010;@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b=\u0010>R\u0014\u0010?\u001A\u00020@X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bA\u0010BR\u0014\u0010C\u001A\u00020DX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bE\u0010FR\u001A\u0010G\u001A\b\u0012\u0004\u0012\u00020I0HX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bJ\u0010KR\u0014\u0010L\u001A\u00020MX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bN\u0010OR\u001A\u0010P\u001A\u00020QX\u0080\u0004¢\u0006\u000E\n\u0000\u0012\u0004\bR\u0010S\u001A\u0004\bT\u0010UR\u000E\u0010V\u001A\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010X\u001A\u00020YX\u0082\u0004¢\u0006\u0004\n\u0002\u0010ZR\u0014\u0010\\\u001A\u00020]X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b^\u0010_R\u001B\u0010`\u001A\u00020a8@X\u0080\u0084\u0002¢\u0006\f\u001A\u0004\bd\u0010e*\u0004\bb\u0010cR\u0016\u0010k\u001A\u00020lX\u0080\u0004¢\u0006\n\n\u0002\u0010o\u001A\u0004\bm\u0010nR\u0016\u0010\u0080\u0001\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b\u0080\u0001\u0010\u0013R0\u0010\u0082\u0001\u001A\u00020\u00102\u0007\u0010\u0081\u0001\u001A\u00020\u00108V@RX\u0096\u008E\u0002¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010o\u001A\u0005\b\u0083\u0001\u0010\u0013\"\u0005\b\u0084\u0001\u0010:R0\u0010\u0086\u0001\u001A\u00020\u00102\u0007\u0010\u0081\u0001\u001A\u00020\u00108V@RX\u0096\u008E\u0002¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010o\u001A\u0005\b\u0087\u0001\u0010\u0013\"\u0005\b\u0088\u0001\u0010:R\u0016\u0010\u008A\u0001\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b\u008B\u0001\u0010\u0013R\u0016\u0010\u008C\u0001\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b\u008D\u0001\u0010\u0013R\u001A\u0010\u008E\u0001\u001A\u0005\u0018\u00010\u008F\u00018VX\u0096\u0004¢\u0006\b\u001A\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0092\u0001\u001A\u00020lX\u0080\u0004¢\u0006\u000B\n\u0002\u0010o\u001A\u0005\b\u0093\u0001\u0010nR\u0016\u0010 \u0001\u001A\u00020,8@X\u0080\u0004¢\u0006\u0007\u001A\u0005\b¡\u0001\u0010/R\u0010\u0010¢\u0001\u001A\u00030£\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ª\u0001"}, d2={"Landroidx/compose/foundation/lazy/LazyListState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "prefetchStrategy", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "<init>", "(IILandroidx/compose/foundation/lazy/LazyListPrefetchStrategy;)V", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;II)V", "(II)V", "getPrefetchStrategy$foundation", "()Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "value", "", "hasLookaheadOccurred", "getHasLookaheadOccurred$foundation", "()Z", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "approachLayoutInfo", "getApproachLayoutInfo$foundation", "()Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "executeRequestsInHighPriorityMode", "scrollPosition", "Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation", "()F", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation", "()Landroidx/compose/ui/unit/Density;", "scrollableState", "numMeasurePasses", "getNumMeasurePasses$foundation", "prefetchingEnabled", "getPrefetchingEnabled$foundation", "setPrefetchingEnabled$foundation", "(Z)V", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "getItemAnimator$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation$annotations", "()V", "getPrefetchState$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchScope", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "_scrollIndicatorState", "androidx/compose/foundation/lazy/LazyListState$_scrollIndicatorState$1", "Landroidx/compose/foundation/lazy/LazyListState$_scrollIndicatorState$1;", "calculateScrollOffset", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation$delegate", "(Landroidx/compose/foundation/lazy/LazyListState;)Ljava/lang/Object;", "getNearestRange$foundation", "()Lkotlin/ranges/IntRange;", "scrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "measurementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getMeasurementScopeInvalidator-zYiylxw$foundation", "()Landroidx/compose/runtime/MutableState;", "Landroidx/compose/runtime/MutableState;", "requestScrollToItem", "snapToItemIndexInternal", "forceRemeasure", "snapToItemIndexInternal$foundation", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "isScrollInProgress", "<set-?>", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "canScrollBackward", "getCanScrollBackward", "setCanScrollBackward", "canScrollBackward$delegate", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "scrollIndicatorState", "Landroidx/compose/foundation/ScrollIndicatorState;", "getScrollIndicatorState", "()Landroidx/compose/foundation/ScrollIndicatorState;", "placementScopeInvalidator", "getPlacementScopeInvalidator-zYiylxw$foundation", "onScroll", "distance", "onScroll$foundation", "notifyPrefetchOnScroll", "animateScrollToItem", "applyMeasureResult", "result", "isLookingAhead", "visibleItemsStayedTheSame", "applyMeasureResult$foundation", "traceVisibleItems", "measureResult", "scrollDeltaBetweenPasses", "getScrollDeltaBetweenPasses$foundation", "_lazyLayoutScrollDeltaBetweenPasses", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollDeltaBetweenPasses;", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyListState implements ScrollableState {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\n\u001A\u00020\u000BH\u0000¢\u0006\u0002\b\fJ\u001F\u0010\t\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\r\u001A\u00020\u000EH\u0000¢\u0006\u0002\b\fR\u001B\u0010\u0004\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/lazy/LazyListState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/LazyListState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "saver", "prefetchStrategy", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "saver$foundation", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver getSaver() {
            return LazyListState.Saver;
        }

        public final Saver saver$foundation(LazyListPrefetchStrategy arg2) {
            return ListSaverKt.listSaver(new LazyListState$Companion$$ExternalSyntheticLambda0(), new LazyListState$Companion$$ExternalSyntheticLambda1(arg2));
        }

        public final Saver saver$foundation(LazyLayoutCacheWindow arg2) {
            return ListSaverKt.listSaver(new LazyListState$Companion$$ExternalSyntheticLambda2(), new LazyListState$Companion$$ExternalSyntheticLambda3(arg2));
        }

        static final List saver$lambda$0(SaverScope arg2, LazyListState arg3) {
            return CollectionsKt.listOf(new Integer[]{Integer.valueOf(arg3.getFirstVisibleItemIndex()), Integer.valueOf(arg3.getFirstVisibleItemScrollOffset())});
        }

        static final LazyListState saver$lambda$1(LazyListPrefetchStrategy arg3, List arg4) {
            return new LazyListState(arg4.get(0).intValue(), arg4.get(1).intValue(), arg3);
        }

        static final List saver$lambda$2(SaverScope arg2, LazyListState arg3) {
            return CollectionsKt.listOf(new Integer[]{Integer.valueOf(arg3.getFirstVisibleItemIndex()), Integer.valueOf(arg3.getFirstVisibleItemScrollOffset())});
        }

        static final LazyListState saver$lambda$3(LazyLayoutCacheWindow arg2, List arg3) {
            return new LazyListState(arg2, arg3.get(0).intValue(), arg3.get(1).intValue());
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Saver Saver;
    private final LazyLayoutScrollDeltaBetweenPasses _lazyLayoutScrollDeltaBetweenPasses;
    private final LazyListState$_scrollIndicatorState$1 _scrollIndicatorState;
    private LazyListMeasureResult approachLayoutInfo;
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
    private final LazyListPrefetchScope prefetchScope;
    private final LazyLayoutPrefetchState prefetchState;
    private final LazyListPrefetchStrategy prefetchStrategy;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyListScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;

    static {
        LazyListState.Companion = new Companion(null);
        LazyListState.Saver = ListSaverKt.listSaver(new LazyListState$$ExternalSyntheticLambda0(), new LazyListState$$ExternalSyntheticLambda1());
    }

    public LazyListState() {
        this(0, 0, null, 7, null);
    }

    public LazyListState(int arg2, int arg3, LazyListPrefetchStrategy arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 4) != 0) {
            arg4 = LazyListPrefetchStrategyKt.LazyListPrefetchStrategy$default(0, 1, null);
        }

        this(0, 0, arg4);
    }

    public LazyListState(int arg4, int arg5) {
        this(arg4, arg5, LazyListPrefetchStrategyKt.LazyListPrefetchStrategy$default(0, 1, null));
    }

    public LazyListState(int arg4, int arg5, LazyListPrefetchStrategy arg6) {
        super();
        this.prefetchStrategy = arg6;
        LazyListScrollPosition v0 = new LazyListScrollPosition(arg4, arg5);
        this.scrollPosition = v0;
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyListStateKt.access$getEmptyLazyListMeasureResult$p(), SnapshotStateKt.neverEqualPolicy());
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.scrollableState = ScrollableStateKt.ScrollableState(new LazyListState$$ExternalSyntheticLambda2(this));
        this.prefetchingEnabled = true;
        this.remeasurementModifier = new LazyListState$remeasurementModifier$1(this);
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.itemAnimator = new LazyLayoutItemAnimator();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.prefetchState = new LazyLayoutPrefetchState(arg6.getPrefetchScheduler(), new LazyListState$$ExternalSyntheticLambda3(this, arg4));
        this.prefetchScope = new LazyListState$prefetchScope$1(this);
        this._scrollIndicatorState = new LazyListState$_scrollIndicatorState$1(this);
        this.pinnedItems = new LazyLayoutPinnedItemList();
        v0.getNearestRangeState();
        this.measurementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(null, 1, null);
        Boolean v6 = Boolean.valueOf(false);
        this.canScrollForward$delegate = SnapshotStateKt.mutableStateOf$default(v6, null, 2, null);
        this.canScrollBackward$delegate = SnapshotStateKt.mutableStateOf$default(v6, null, 2, null);
        this.placementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(null, 1, null);
        this._lazyLayoutScrollDeltaBetweenPasses = new LazyLayoutScrollDeltaBetweenPasses();
    }

    public LazyListState(int arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
        this(0, 0);
    }

    public LazyListState(LazyLayoutCacheWindow arg2, int arg3, int arg4) {
        this(arg3, arg4, new LazyListCacheWindowStrategy(arg2));
    }

    public LazyListState(LazyLayoutCacheWindow arg2, int arg3, int arg4, int arg5, DefaultConstructorMarker arg6) {
        this(arg2, 0, 0);
    }

    static final List Saver$lambda$0(SaverScope arg2, LazyListState arg3) {
        return CollectionsKt.listOf(new Integer[]{Integer.valueOf(arg3.getFirstVisibleItemIndex()), Integer.valueOf(arg3.getFirstVisibleItemScrollOffset())});
    }

    static final LazyListState Saver$lambda$1(List arg3) {
        return new LazyListState(arg3.get(0).intValue(), arg3.get(1).intValue());
    }

    public static final int access$calculateScrollOffset(LazyListState arg0) {
        return arg0.calculateScrollOffset();
    }

    public static final boolean access$getExecuteRequestsInHighPriorityMode$p(LazyListState arg0) {
        return arg0.executeRequestsInHighPriorityMode;
    }

    public static final MutableState access$getLayoutInfoState$p(LazyListState arg0) {
        return arg0.layoutInfoState;
    }

    public static final Saver access$getSaver$cp() {
        return LazyListState.Saver;
    }

    public static final void access$setRemeasurement$p(LazyListState arg0, Remeasurement arg1) {
        arg0.remeasurement = arg1;
    }

    public final Object animateScrollToItem(int arg7, int arg8, Continuation arg9) {
        Object v6 = ScrollableState.scroll$default(this, null, new LazyListState$animateScrollToItem$2(this, arg7, arg8, null), arg9, 1, null);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public static Object animateScrollToItem$default(LazyListState arg0, int arg1, int arg2, Continuation arg3, int arg4, Object arg5) {
        return arg0.animateScrollToItem(arg1, 0, arg3);
    }

    public final void applyMeasureResult$foundation(LazyListMeasureResult arg5, boolean arg6, boolean arg7) {
        this.prefetchState.setIdealNestedPrefetchCount$foundation(arg5.getVisibleItemsInfo().size());
        if(!arg6 && (this.hasLookaheadOccurred)) {
            this.approachLayoutInfo = arg5;
            androidx.compose.runtime.snapshots.Snapshot$Companion v6 = Snapshot.Companion;
            Snapshot v7 = v6.getCurrentThreadSnapshot();
            Function1 v0 = v7 != null ? v7.getReadObserver() : null;
            Snapshot v1 = v6.makeCurrentNonObservable(v7);
            try {
                if(this._lazyLayoutScrollDeltaBetweenPasses.isActive$foundation()) {
                    LazyListMeasuredItem v2 = arg5.getFirstVisibleItem();
                    if(v2 != null && v2.getIndex() == this.scrollPosition.getIndex() && arg5.getFirstVisibleItemScrollOffset() == this.scrollPosition.getScrollOffset()) {
                        this._lazyLayoutScrollDeltaBetweenPasses.stop$foundation();
                    }
                }
            }
            catch(Throwable v4) {
                v6.restoreNonObservable(v7, v1, v0);
                throw v4;
            }

            v6.restoreNonObservable(v7, v1, v0);
            return;
        }

        if(arg6) {
            this.hasLookaheadOccurred = true;
        }

        this.setCanScrollBackward(arg5.getCanScrollBackward());
        this.setCanScrollForward(arg5.getCanScrollForward());
        this.scrollToBeConsumed -= arg5.getConsumedScroll();
        this.layoutInfoState.setValue(arg5);
        if(arg7) {
            this.scrollPosition.updateScrollOffset(arg5.getFirstVisibleItemScrollOffset());
        }
        else {
            this.traceVisibleItems(arg5);
            this.scrollPosition.updateFromMeasureResult(arg5);
            if(this.prefetchingEnabled) {
                this.prefetchStrategy.onVisibleItemsUpdated(this.prefetchScope, arg5);
            }
        }

        if(arg6) {
            this._lazyLayoutScrollDeltaBetweenPasses.updateScrollDeltaForApproach$foundation(arg5.getScrollBackAmount(), arg5.getDensity(), arg5.getCoroutineScope());
        }

        ++this.numMeasurePasses;
    }

    public static void applyMeasureResult$foundation$default(LazyListState arg0, LazyListMeasureResult arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        arg0.applyMeasureResult$foundation(arg1, arg2, false);
    }

    private final int calculateScrollOffset() {
        return LazyListLayoutInfoKt.visibleItemsAverageSize(this.getLayoutInfo()) * this.getFirstVisibleItemIndex() + this.getFirstVisibleItemScrollOffset();
    }

    public float dispatchRawDelta(float arg1) {
        return this.scrollableState.dispatchRawDelta(arg1);
    }

    public final LazyListMeasureResult getApproachLayoutInfo$foundation() {
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

    public final LazyListLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final MutableState getMeasurementScopeInvalidator-zYiylxw$foundation() {
        return this.measurementScopeInvalidator;
    }

    public final IntRange getNearestRange$foundation() {
        return this.scrollPosition.getNearestRangeState().getValue();
    }

    private static Object getNearestRange$foundation$delegate(LazyListState arg0) {
        return arg0.scrollPosition.getNearestRangeState();
    }

    public final int getNumMeasurePasses$foundation() {
        return this.numMeasurePasses;
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

    public final LazyListPrefetchStrategy getPrefetchStrategy$foundation() {
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

    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    private final void notifyPrefetchOnScroll(float arg2, LazyListLayoutInfo arg3) {
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

        this.executeRequestsInHighPriorityMode = true;
        float v1_1 = this.scrollToBeConsumed + arg9;
        this.scrollToBeConsumed = v1_1;
        if(Math.abs(v1_1) > v2) {
            v1_1 = this.scrollToBeConsumed;
            int v4 = Math.round(v1_1);
            LazyListMeasureResult v5 = this.layoutInfoState.getValue().copyWithScrollDeltaWithoutRemeasure(v4, this.hasLookaheadOccurred ^ 1);
            if(v5 != null) {
                LazyListMeasureResult v6 = this.approachLayoutInfo;
                if(v6 != null) {
                    LazyListMeasureResult v7 = null;
                    LazyListMeasureResult v4_1 = v6 != null ? v6.copyWithScrollDeltaWithoutRemeasure(v4, true) : v7;
                    if(v4_1 != null) {
                        this.approachLayoutInfo = v4_1;
                        goto label_45;
                    }

                    v5 = v7;
                }
            }

        label_45:
            if(v5 != null) {
                this.applyMeasureResult$foundation(v5, this.hasLookaheadOccurred, true);
                ObservableScopeInvalidator.invalidateScope-impl(this.placementScopeInvalidator);
                this.notifyPrefetchOnScroll(v1_1 - this.scrollToBeConsumed, ((LazyListLayoutInfo)v5));
                goto label_61;
            }

            Remeasurement v3 = this.remeasurement;
            if(v3 != null) {
                v3.forceRemeasure();
            }

            this.notifyPrefetchOnScroll(v1_1 - this.scrollToBeConsumed, this.getLayoutInfo());
        }

    label_61:
        if(Math.abs(this.scrollToBeConsumed) <= v2) {
            return arg9;
        }

        arg9 -= this.scrollToBeConsumed;
        this.scrollToBeConsumed = 0f;
        return arg9;
    }

    static final Unit prefetchState$lambda$0(LazyListState arg4, int arg5, NestedPrefetchScope arg6) {
        LazyListPrefetchStrategy v4 = arg4.prefetchStrategy;
        androidx.compose.runtime.snapshots.Snapshot$Companion v0 = Snapshot.Companion;
        Snapshot v1 = v0.getCurrentThreadSnapshot();
        Function1 v2 = v1 != null ? v1.getReadObserver() : null;
        v0.restoreNonObservable(v1, v0.makeCurrentNonObservable(v1), v2);
        v4.onNestedPrefetch(arg6, arg5);
        return Unit.INSTANCE;
    }

    public final void requestScrollToItem(int arg8, int arg9) {
        if(this.isScrollInProgress()) {
            BuildersKt.launch$default(this.layoutInfoState.getValue().getCoroutineScope(), null, null, new LazyListState$requestScrollToItem$1(this, null), 3, null);
        }

        this.snapToItemIndexInternal$foundation(arg8, arg9, false);
    }

    public static void requestScrollToItem$default(LazyListState arg0, int arg1, int arg2, int arg3, Object arg4) {
        arg0.requestScrollToItem(arg1, 0);
    }

    public Object scroll(MutatePriority arg7, Function2 arg8, Continuation arg9) {
        LazyListState$scroll$1 v0_1;
        int v2;
        if((arg9 instanceof LazyListState$scroll$1)) {
            Continuation v0 = arg9;
            v2 = 0x80000000;
            if((((LazyListState$scroll$1)v0).label & v2) != 0) {
                ((LazyListState$scroll$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new LazyListState$scroll$1(this, arg9);
        }

        Object v9 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            if(this.layoutInfoState.getValue() == LazyListStateKt.access$getEmptyLazyListMeasureResult$p()) {
                AwaitFirstLayoutModifier v9_1 = this.awaitLayoutModifier;
                v0_1.L$0 = arg7;
                v0_1.L$1 = arg8;
                v0_1.label = 1;
                if(v9_1.waitForFirstLayout(((Continuation)v0_1)) == v1) {
                    return v1;
                }
                else {
                    goto label_46;
                }
            }
            else {
            label_46:
                ScrollableState v6 = this.scrollableState;
                v0_1.L$0 = null;
                v0_1.L$1 = null;
                v0_1.label = v3;
                if(v6.scroll(((MutatePriority)v7), ((Function2)v8), ((Continuation)v0_1)) == v1) {
                    return v1;
                }
            }
        }
        else if(v2 == 1) {
            Object v7 = v0_1.L$1;
            Object v8 = v0_1.L$0;
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
        Object v6 = ScrollableState.scroll$default(this, null, new LazyListState$scrollToItem$2(this, arg7, arg8, null), arg9, 1, null);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public static Object scrollToItem$default(LazyListState arg0, int arg1, int arg2, Continuation arg3, int arg4, Object arg5) {
        return arg0.scrollToItem(arg1, 0, arg3);
    }

    static final float scrollableState$lambda$0(LazyListState arg0, float arg1) {
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
            LazyListPrefetchStrategy v0 = this.prefetchStrategy;
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

    private final void traceVisibleItems(LazyListMeasureResult arg5) {
        Object v4 = CollectionsKt.firstOrNull(arg5.getVisibleItemsInfo());
        Object v5 = CollectionsKt.lastOrNull(arg5.getVisibleItemsInfo());
        long v0 = -1;
        long v2 = v4 != null ? ((long)((LazyListMeasuredItem)v4).getIndex()) : v0;
        AndroidTrace_androidKt.traceValue("firstVisibleItem:index", v2);
        if(v5 != null) {
            v0 = ((long)((LazyListMeasuredItem)v5).getIndex());
        }

        AndroidTrace_androidKt.traceValue("lastVisibleItem:index", v0);
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved$foundation(LazyListItemProvider arg1, int arg2) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(arg1, arg2);
    }
}

