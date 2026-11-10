package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ScrollIndicatorState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollDeltaBetweenPasses;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000\u008B\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001&\b\u0007\u0018\u0000 ²\u00012\u00020\u0001:\u0002²\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001D\b\u0016\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\u0007\u0010\fJ\b\u0010(\u001A\u00020\nH\u0002J\u0015\u0010X\u001A\u00020Y2\u0006\u0010Z\u001A\u00020\u000EH\u0000¢\u0006\u0002\b[JK\u0010\u0081\u0001\u001A\u00030\u0082\u00012\b\u0010\u0083\u0001\u001A\u00030\u0084\u00012.\u0010\u0085\u0001\u001A)\b\u0001\u0012\u0005\u0012\u00030\u0087\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0082\u00010\u0088\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0089\u00010\u0086\u0001¢\u0006\u0003\b\u008A\u0001H\u0096@¢\u0006\u0003\u0010\u008B\u0001J\u0012\u0010\u008D\u0001\u001A\u00020Y2\u0007\u0010\u008E\u0001\u001A\u00020YH\u0002J%\u0010\u008F\u0001\u001A\u00030\u0082\u00012\u0007\u0010\u0090\u0001\u001A\u00020\n2\t\b\u0002\u0010\u0091\u0001\u001A\u00020\nH\u0086@¢\u0006\u0003\u0010\u0092\u0001J%\u0010\u0093\u0001\u001A\u00030\u0082\u00012\u0007\u0010\u0090\u0001\u001A\u00020\n2\t\b\u0002\u0010\u0091\u0001\u001A\u00020\nH\u0086@¢\u0006\u0003\u0010\u0092\u0001J\u001E\u0010\u0096\u0001\u001A\u00030\u0082\u00012\t\b\u0001\u0010\u0090\u0001\u001A\u00020\n2\t\b\u0002\u0010\u0091\u0001\u001A\u00020\nJ+\u0010\u0097\u0001\u001A\u00030\u0082\u00012\u0007\u0010\u0090\u0001\u001A\u00020\n2\u0007\u0010\u0091\u0001\u001A\u00020\n2\u0007\u0010\u0098\u0001\u001A\u00020\u000EH\u0000¢\u0006\u0003\b\u0099\u0001J\"\u0010\u009A\u0001\u001A\u00020\u00032\b\u0010\u009B\u0001\u001A\u00030\u009C\u00012\u0007\u0010\u009D\u0001\u001A\u00020\u0003H\u0000¢\u0006\u0003\b\u009E\u0001J\u0012\u0010\u009F\u0001\u001A\u00020Y2\u0007\u0010 \u0001\u001A\u00020YH\u0016J\u001E\u0010¡\u0001\u001A\u00030\u0082\u00012\u0007\u0010 \u0001\u001A\u00020Y2\t\b\u0002\u0010¢\u0001\u001A\u00020\u0012H\u0002J\u001A\u0010£\u0001\u001A\u00030\u0082\u00012\u000E\u0010¤\u0001\u001A\t\u0012\u0004\u0012\u00020\n0¥\u0001H\u0002J\u0013\u0010¦\u0001\u001A\u00030\u0082\u00012\u0007\u0010¢\u0001\u001A\u00020 H\u0002J,\u0010§\u0001\u001A\u00030\u0082\u00012\u0007\u0010¨\u0001\u001A\u00020\u00122\u0006\u0010Z\u001A\u00020\u000E2\t\b\u0002\u0010©\u0001\u001A\u00020\u000EH\u0000¢\u0006\u0003\bª\u0001J\u001A\u0010°\u0001\u001A\u00020\u00032\u0007\u0010±\u0001\u001A\u00020\n2\u0006\u0010d\u001A\u00020\nH\u0002R\u001E\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u000E@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001A\u0004\u0018\u00010\u00122\b\u0010\r\u001A\u0004\u0018\u00010\u0012@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0018R\u0014\u0010\u001B\u001A\u00020\u001CX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0011\u0010\u001F\u001A\u00020 8F¢\u0006\u0006\u001A\u0004\b!\u0010\"R\u0014\u0010#\u001A\b\u0012\u0004\u0012\u00020\u00120$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001A\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\'R\u0014\u0010)\u001A\u00020*X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b+\u0010,R+\u0010.\u001A\u00020\u000E2\u0006\u0010-\u001A\u00020\u000E8V@RX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b2\u00103\u001A\u0004\b/\u0010\u0011\"\u0004\b0\u00101R+\u00104\u001A\u00020\u000E2\u0006\u0010-\u001A\u00020\u000E8V@RX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b7\u00103\u001A\u0004\b5\u0010\u0011\"\u0004\b6\u00101R\u0014\u00108\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b9\u0010\u0011R\u0014\u0010:\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b;\u0010\u0011R\u0016\u0010<\u001A\u0004\u0018\u00010=8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b>\u0010?R\"\u0010A\u001A\u0004\u0018\u00010@2\b\u0010\r\u001A\u0004\u0018\u00010@@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\bB\u0010CR\u0014\u0010D\u001A\u00020EX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bF\u0010GR\u0014\u0010H\u001A\u00020IX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bJ\u0010KR\u0014\u0010L\u001A\u00020MX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bN\u0010OR\u001A\u0010P\u001A\u00020\u000EX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bQ\u0010\u0011\"\u0004\bR\u00101R\u0014\u0010S\u001A\u00020TX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bU\u0010VR\u000E\u0010W\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010X\u001A\u00020YX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\\\u001A\u00020\nX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b]\u0010\u0018\"\u0004\b^\u0010_R\u000E\u0010`\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010a\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020c0bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010d\u001A\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\be\u0010\u0018R\u0011\u0010f\u001A\u00020g8F¢\u0006\u0006\u001A\u0004\bh\u0010iR\u0014\u0010j\u001A\u00020kX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bl\u0010mR\u0014\u0010n\u001A\u00020oX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bp\u0010qR\u001A\u0010r\u001A\b\u0012\u0004\u0012\u00020t0sX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bu\u0010vR\u001B\u0010w\u001A\u00020x8@X\u0080\u0084\u0002¢\u0006\f\u001A\u0004\b{\u0010|*\u0004\by\u0010zR\u0017\u0010}\u001A\u00020~X\u0080\u0004¢\u0006\u000B\n\u0002\u00103\u001A\u0005\b\u007F\u0010\u0080\u0001R\u0016\u0010\u008C\u0001\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b\u008C\u0001\u0010\u0011R\u0019\u0010\u0094\u0001\u001A\u00020~X\u0080\u0004¢\u0006\f\n\u0002\u00103\u001A\u0006\b\u0095\u0001\u0010\u0080\u0001R\u0017\u0010«\u0001\u001A\u00020Y8@X\u0080\u0004¢\u0006\b\u001A\u0006\b¬\u0001\u0010­\u0001R\u0010\u0010®\u0001\u001A\u00030¯\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006³\u0001"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initialFirstVisibleItems", "", "initialFirstVisibleOffsets", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "<init>", "([I[ILandroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemOffset", "(II)V", "value", "", "hasLookaheadOccurred", "getHasLookaheadOccurred$foundation", "()Z", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "approachLayoutInfo", "getApproachLayoutInfo$foundation", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "firstVisibleItemIndex", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "scrollPosition", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "getScrollPosition$foundation", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "layoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "_scrollIndicatorState", "androidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState$_scrollIndicatorState$1", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState$_scrollIndicatorState$1;", "calculateScrollOffset", "laneInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getLaneInfo$foundation", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "<set-?>", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "(Z)V", "canScrollForward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollBackward", "getCanScrollBackward", "setCanScrollBackward", "canScrollBackward$delegate", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "scrollIndicatorState", "Landroidx/compose/foundation/ScrollIndicatorState;", "getScrollIndicatorState", "()Landroidx/compose/foundation/ScrollIndicatorState;", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "prefetchingEnabled", "getPrefetchingEnabled$foundation", "setPrefetchingEnabled$foundation", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "scrollableState", "scrollToBeConsumed", "", "isLookingAhead", "scrollToBeConsumed$foundation", "measurePassCount", "getMeasurePassCount$foundation", "setMeasurePassCount$foundation", "(I)V", "prefetchBaseIndex", "currentItemPrefetchHandles", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "laneCount", "getLaneCount$foundation", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "mutableInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getMutableInteractionSource$foundation", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "getItemAnimator$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation$delegate", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;)Ljava/lang/Object;", "getNearestRange$foundation", "()Lkotlin/ranges/IntRange;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getPlacementScopeInvalidator-zYiylxw$foundation", "()Landroidx/compose/runtime/MutableState;", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isScrollInProgress", "onScroll", "distance", "scrollToItem", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateScrollToItem", "measurementScopeInvalidator", "getMeasurementScopeInvalidator-zYiylxw$foundation", "requestScrollToItem", "snapToItemInternal", "forceRemeasure", "snapToItemInternal$foundation", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation", "dispatchRawDelta", "delta", "notifyPrefetch", "info", "clearLeftoverPrefetchHandles", "prefetchHandlesUsed", "", "cancelPrefetchIfVisibleItemsChanged", "applyMeasureResult", "result", "visibleItemsStayedTheSame", "applyMeasureResult$foundation", "scrollDeltaBetweenPasses", "getScrollDeltaBetweenPasses$foundation", "()F", "_lazyLayoutScrollDeltaBetweenPasses", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollDeltaBetweenPasses;", "fillNearestIndices", "itemIndex", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridState implements ScrollableState {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001D\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver getSaver() {
            return LazyStaggeredGridState.Saver;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Saver Saver;
    private final LazyLayoutScrollDeltaBetweenPasses _lazyLayoutScrollDeltaBetweenPasses;
    private final LazyStaggeredGridState$_scrollIndicatorState$1 _scrollIndicatorState;
    private LazyStaggeredGridMeasureResult approachLayoutInfo;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private final Map currentItemPrefetchHandles;
    private boolean hasLookaheadOccurred;
    private final LazyLayoutItemAnimator itemAnimator;
    private final LazyStaggeredGridLaneInfo laneInfo;
    private final MutableState layoutInfoState;
    private int measurePassCount;
    private final MutableState measurementScopeInvalidator;
    private final MutableInteractionSource mutableInteractionSource;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final MutableState placementScopeInvalidator;
    private int prefetchBaseIndex;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyStaggeredGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;

    static {
        LazyStaggeredGridState.Companion = new Companion(null);
        LazyStaggeredGridState.Saver = ListSaverKt.listSaver(new LazyStaggeredGridState$$ExternalSyntheticLambda0(), new LazyStaggeredGridState$$ExternalSyntheticLambda1());
    }

    public LazyStaggeredGridState(int arg2, int arg3) {
        this(new int[]{arg2}, new int[]{arg3}, null);
    }

    public LazyStaggeredGridState(int[] arg4, int[] arg5, PrefetchScheduler arg6) {
        super();
        LazyStaggeredGridScrollPosition v0 = new LazyStaggeredGridScrollPosition(arg4, arg5, new LazyStaggeredGridState$scrollPosition$1(this));
        this.scrollPosition = v0;
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyStaggeredGridMeasureResultKt.getEmptyLazyStaggeredGridLayoutInfo(), SnapshotStateKt.neverEqualPolicy());
        this._scrollIndicatorState = new LazyStaggeredGridState$_scrollIndicatorState$1(this);
        this.laneInfo = new LazyStaggeredGridLaneInfo();
        Boolean v4 = Boolean.valueOf(false);
        this.canScrollForward$delegate = SnapshotStateKt.mutableStateOf$default(v4, null, 2, null);
        this.canScrollBackward$delegate = SnapshotStateKt.mutableStateOf$default(v4, null, 2, null);
        this.remeasurementModifier = new LazyStaggeredGridState$remeasurementModifier$1(this);
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.prefetchingEnabled = true;
        this.prefetchState = new LazyLayoutPrefetchState(arg6, null, 2, null);
        this.scrollableState = ScrollableStateKt.ScrollableState(new LazyStaggeredGridState$$ExternalSyntheticLambda2(this));
        this.prefetchBaseIndex = -1;
        this.currentItemPrefetchHandles = new LinkedHashMap();
        this.mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.pinnedItems = new LazyLayoutPinnedItemList();
        this.itemAnimator = new LazyLayoutItemAnimator();
        v0.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(null, 1, null);
        this.measurementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(null, 1, null);
        this._lazyLayoutScrollDeltaBetweenPasses = new LazyLayoutScrollDeltaBetweenPasses();
    }

    public LazyStaggeredGridState(int arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
        this(0, 0);
    }

    static final List Saver$lambda$0(SaverScope arg0, LazyStaggeredGridState arg1) {
        return CollectionsKt.listOf(new int[][]{arg1.scrollPosition.getIndices(), arg1.scrollPosition.getScrollOffsets()});
    }

    static final LazyStaggeredGridState Saver$lambda$1(List arg3) {
        return new LazyStaggeredGridState(arg3.get(0), arg3.get(1), null);
    }

    public static final int access$calculateScrollOffset(LazyStaggeredGridState arg0) {
        return arg0.calculateScrollOffset();
    }

    public static final int[] access$fillNearestIndices(LazyStaggeredGridState arg0, int arg1, int arg2) {
        return arg0.fillNearestIndices(arg1, arg2);
    }

    public static final Saver access$getSaver$cp() {
        return LazyStaggeredGridState.Saver;
    }

    public static final void access$setRemeasurement$p(LazyStaggeredGridState arg0, Remeasurement arg1) {
        arg0.remeasurement = arg1;
    }

    public final Object animateScrollToItem(int arg13, int arg14, Continuation arg15) {
        Object v5 = this.layoutInfoState.getValue();
        Object v0 = ScrollableState.scroll$default(this, null, new LazyStaggeredGridState$animateScrollToItem$2(this, arg13, arg14, ((LazyStaggeredGridMeasureResult)v5).getSlots().getSizes().length * 100, ((LazyStaggeredGridMeasureResult)v5), null), arg15, 1, null);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public static Object animateScrollToItem$default(LazyStaggeredGridState arg0, int arg1, int arg2, Continuation arg3, int arg4, Object arg5) {
        return arg0.animateScrollToItem(arg1, 0, arg3);
    }

    public final void applyMeasureResult$foundation(LazyStaggeredGridMeasureResult arg4, boolean arg5, boolean arg6) {
        if(!arg5 && (this.hasLookaheadOccurred)) {
            this.approachLayoutInfo = arg4;
            return;
        }

        if(arg5) {
            this.hasLookaheadOccurred = true;
        }

        this.scrollToBeConsumed -= arg4.getConsumedScroll();
        this.layoutInfoState.setValue(arg4);
        LazyStaggeredGridScrollPosition v1 = this.scrollPosition;
        if(arg6) {
            v1.updateScrollOffset(arg4.getFirstVisibleItemScrollOffsets());
        }
        else {
            v1.updateFromMeasureResult(arg4);
            this.cancelPrefetchIfVisibleItemsChanged(arg4);
        }

        this.setCanScrollBackward(arg4.getCanScrollBackward());
        this.setCanScrollForward(arg4.getCanScrollForward());
        if(arg5) {
            this._lazyLayoutScrollDeltaBetweenPasses.updateScrollDeltaForApproach$foundation(arg4.getScrollBackAmount(), arg4.getDensity(), arg4.getCoroutineScope());
        }

        ++this.measurePassCount;
    }

    public static void applyMeasureResult$foundation$default(LazyStaggeredGridState arg0, LazyStaggeredGridMeasureResult arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        arg0.applyMeasureResult$foundation(arg1, arg2, false);
    }

    private final int calculateScrollOffset() {
        LazyStaggeredGridLayoutInfo v0 = this.getLayoutInfo();
        if(v0.getTotalItemsCount() == 0) {
            return 0;
        }

        return LazyStaggeredGridMeasureResultKt.visibleItemsAverageSize(v0) * this.getFirstVisibleItemIndex() / this.getLaneCount$foundation() + this.getFirstVisibleItemScrollOffset();
    }

    private final void cancelPrefetchIfVisibleItemsChanged(LazyStaggeredGridLayoutInfo arg4) {
        List v4 = arg4.getVisibleItemsInfo();
        int v1 = -1;
        if(this.prefetchBaseIndex != v1 && !v4.isEmpty()) {
            int v0 = CollectionsKt.first(v4).getIndex();
            int v4_1 = CollectionsKt.last(v4).getIndex();
            int v2 = this.prefetchBaseIndex;
            if(v0 <= v2 && v2 <= v4_1) {
                return;
            }

            this.prefetchBaseIndex = v1;
            Iterator v4_2 = this.currentItemPrefetchHandles.values().iterator();
            while(v4_2.hasNext()) {
                v4_2.next().cancel();
            }

            this.currentItemPrefetchHandles.clear();
        }
    }

    private final void clearLeftoverPrefetchHandles(Set arg3) {
        Iterator v2 = this.currentItemPrefetchHandles.entrySet().iterator();
        while(v2.hasNext()) {
            Object v0 = v2.next();
            if(arg3.contains(((Map$Entry)v0).getKey())) {
                continue;
            }

            ((Map$Entry)v0).getValue().cancel();
            v2.remove();
        }
    }

    public float dispatchRawDelta(float arg1) {
        return this.scrollableState.dispatchRawDelta(arg1);
    }

    private final int[] fillNearestIndices(int arg9, int arg10) {
        int[] v0 = new int[arg10];
        if(this.layoutInfoState.getValue().getSpanProvider().isFullSpan(arg9)) {
            ArraysKt.fill$default(v0, arg9, 0, 0, 6, null);
            return v0;
        }

        this.laneInfo.ensureValidIndex(arg9 + arg10);
        int v1 = this.laneInfo.getLane(arg9);
        int v3 = 0;
        int v4 = -1;
        if(v1 != -2 && v1 != v4) {
            if(v1 >= 0) {
                v3 = 1;
            }

            if(v3 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("Expected positive lane number, got " + v1 + " instead.");
            }

            v3 = Math.min(v1, arg10);
        }

        int v7 = v3;
        v3 = v7 - 1;
        v1 = arg9;
        while(v4 < v3) {
            v1 = this.laneInfo.findPreviousItemIndex(v1, v3);
            v0[v3] = v1;
            if(v1 == v4) {
                ArraysKt.fill$default(v0, -1, 0, v3, 2, null);
            }
            else {
                --v3;
                continue;
            }

            break;
        }

        v0[v7] = arg9;
        ++v7;
        while(v7 < arg10) {
            arg9 = this.laneInfo.findNextItemIndex(arg9, v7);
            v0[v7] = arg9;
            ++v7;
        }

        return v0;
    }

    public final LazyStaggeredGridMeasureResult getApproachLayoutInfo$foundation() {
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
        return this.mutableInteractionSource;
    }

    public final LazyLayoutItemAnimator getItemAnimator$foundation() {
        return this.itemAnimator;
    }

    public final int getLaneCount$foundation() {
        return this.layoutInfoState.getValue().getSlots().getSizes().length;
    }

    public final LazyStaggeredGridLaneInfo getLaneInfo$foundation() {
        return this.laneInfo;
    }

    public boolean getLastScrolledBackward() {
        return this.scrollableState.getLastScrolledBackward();
    }

    public boolean getLastScrolledForward() {
        return this.scrollableState.getLastScrolledForward();
    }

    public final LazyStaggeredGridLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final int getMeasurePassCount$foundation() {
        return this.measurePassCount;
    }

    public final MutableState getMeasurementScopeInvalidator-zYiylxw$foundation() {
        return this.measurementScopeInvalidator;
    }

    public final MutableInteractionSource getMutableInteractionSource$foundation() {
        return this.mutableInteractionSource;
    }

    public final IntRange getNearestRange$foundation() {
        return this.scrollPosition.getNearestRangeState().getValue();
    }

    private static Object getNearestRange$foundation$delegate(LazyStaggeredGridState arg0) {
        return arg0.scrollPosition.getNearestRangeState();
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

    public final LazyStaggeredGridScrollPosition getScrollPosition$foundation() {
        return this.scrollPosition;
    }

    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    private final void notifyPrefetch(float arg18, LazyStaggeredGridMeasureResult arg19) {
        LazyStaggeredGridState v0 = this;
        if((v0.prefetchingEnabled) && !arg19.getVisibleItemsInfo().isEmpty()) {
            int v1 = Float.compare(arg18, 0f) < 0 ? 1 : 0;
            int v4 = v1 != 0 ? CollectionsKt.last(arg19.getVisibleItemsInfo()).getIndex() : CollectionsKt.first(arg19.getVisibleItemsInfo()).getIndex();
            if(v4 == v0.prefetchBaseIndex) {
                return;
            }

            v0.prefetchBaseIndex = v4;
            LinkedHashSet v5 = new LinkedHashSet();
            LazyStaggeredGridSlots v6 = arg19.getSlots();
            int v7 = v6.getSizes().length;
            int v8 = 0;
            while(v8 < v7) {
                LazyStaggeredGridLaneInfo v9 = v0.laneInfo;
                v4 = v1 != 0 ? v9.findNextItemIndex(v4, v8) : v9.findPreviousItemIndex(v4, v8);
                int v10 = v4;
                if(v10 < 0) {
                    break;
                }

                if(v10 >= arg19.getTotalItemsCount()) {
                    break;
                }

                if(((Set)v5).contains(Integer.valueOf(v10))) {
                    break;
                }

                v5.add(Integer.valueOf(v10));
                if(v0.currentItemPrefetchHandles.containsKey(Integer.valueOf(v10))) {
                }
                else {
                    boolean v4_1 = arg19.getSpanProvider().isFullSpan(v10);
                    int v9_1 = v4_1 ? 0 : v8;
                    v4 = v4_1 ? v7 : 1;
                    if(v4 == 1) {
                        v4 = v6.getSizes()[v9_1];
                    }
                    else {
                        int v11 = v6.getPositions()[v9_1];
                        v9_1 = v9_1 + v4 - 1;
                        v4 = v6.getPositions()[v9_1] + v6.getSizes()[v9_1] - v11;
                    }

                    long v11_1 = arg19.getOrientation() == Orientation.Vertical ? Constraints.Companion.fixedWidth-OenEA2s(v4) : Constraints.Companion.fixedHeight-OenEA2s(v4);
                    v0.currentItemPrefetchHandles.put(Integer.valueOf(v10), LazyLayoutPrefetchState.schedulePrecompositionAndPremeasure-VKLhPVY$default(v0.prefetchState, v10, v11_1, null, 4, null));
                }

                ++v8;
                v4 = v10;
            }

            v0.clearLeftoverPrefetchHandles(((Set)v5));
        }
    }

    static void notifyPrefetch$default(LazyStaggeredGridState arg0, float arg1, LazyStaggeredGridMeasureResult arg2, int arg3, Object arg4) {
        Object v2;
        if((arg3 & 2) != 0) {
            v2 = arg0.layoutInfoState.getValue();
        }

        arg0.notifyPrefetch(arg1, ((LazyStaggeredGridMeasureResult)v2));
    }

    private final float onScroll(float arg9) {
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
            LazyStaggeredGridMeasureResult v5 = this.layoutInfoState.getValue().copyWithScrollDeltaWithoutRemeasure(v4, this.hasLookaheadOccurred ^ 1);
            LazyStaggeredGridMeasureResult v6 = null;
            if(v5 != null) {
                LazyStaggeredGridMeasureResult v7 = this.approachLayoutInfo;
                if(v7 != null) {
                    LazyStaggeredGridMeasureResult v4_1 = v7 != null ? v7.copyWithScrollDeltaWithoutRemeasure(v4, true) : v6;
                    if(v4_1 != null) {
                        this.approachLayoutInfo = v4_1;
                        goto label_44;
                    }

                    v5 = v6;
                }
            }

        label_44:
            if(v5 != null) {
                this.applyMeasureResult$foundation(v5, this.hasLookaheadOccurred, true);
                ObservableScopeInvalidator.invalidateScope-impl(this.placementScopeInvalidator);
                this.notifyPrefetch(v1_1 - this.scrollToBeConsumed, v5);
                goto label_60;
            }

            Remeasurement v3 = this.remeasurement;
            if(v3 != null) {
                v3.forceRemeasure();
            }

            LazyStaggeredGridState.notifyPrefetch$default(this, v1_1 - this.scrollToBeConsumed, v6, 2, v6);
        }

    label_60:
        if(Math.abs(this.scrollToBeConsumed) <= v2) {
            return arg9;
        }

        arg9 -= this.scrollToBeConsumed;
        this.scrollToBeConsumed = 0f;
        return arg9;
    }

    public final void requestScrollToItem(int arg8, int arg9) {
        if(this.isScrollInProgress()) {
            BuildersKt.launch$default(this.layoutInfoState.getValue().getCoroutineScope(), null, null, new LazyStaggeredGridState$requestScrollToItem$1(this, null), 3, null);
        }

        this.snapToItemInternal$foundation(arg8, arg9, false);
    }

    public static void requestScrollToItem$default(LazyStaggeredGridState arg0, int arg1, int arg2, int arg3, Object arg4) {
        arg0.requestScrollToItem(arg1, 0);
    }

    public Object scroll(MutatePriority arg7, Function2 arg8, Continuation arg9) {
        int v2;
        Continuation v0;
        if((arg9 instanceof LazyStaggeredGridState$scroll$1)) {
            v0 = arg9;
            v2 = 0x80000000;
            if((((LazyStaggeredGridState$scroll$1)v0).label & v2) != 0) {
                ((LazyStaggeredGridState$scroll$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            LazyStaggeredGridState$scroll$1 v0_1 = new LazyStaggeredGridState$scroll$1(this, arg9);
        }

        Object v9 = ((LazyStaggeredGridState$scroll$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((LazyStaggeredGridState$scroll$1)v0).label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            if(this.layoutInfoState.getValue() == LazyStaggeredGridMeasureResultKt.getEmptyLazyStaggeredGridLayoutInfo()) {
                AwaitFirstLayoutModifier v9_1 = this.awaitLayoutModifier;
                ((LazyStaggeredGridState$scroll$1)v0).L$0 = arg7;
                ((LazyStaggeredGridState$scroll$1)v0).L$1 = arg8;
                ((LazyStaggeredGridState$scroll$1)v0).label = 1;
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
                ((LazyStaggeredGridState$scroll$1)v0).L$0 = null;
                ((LazyStaggeredGridState$scroll$1)v0).L$1 = null;
                ((LazyStaggeredGridState$scroll$1)v0).label = v3;
                if(v6.scroll(((MutatePriority)v7), ((Function2)v8), v0) == v1) {
                    return v1;
                }
            }
        }
        else if(v2 == 1) {
            Object v7 = ((LazyStaggeredGridState$scroll$1)v0).L$1;
            Object v8 = ((LazyStaggeredGridState$scroll$1)v0).L$0;
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

    public final float scrollToBeConsumed$foundation(boolean arg1) {
        if(!arg1) {
            if(!this.hasLookaheadOccurred) {
            }
            else {
                return this.getScrollDeltaBetweenPasses$foundation();
            }
        }

        return this.scrollToBeConsumed;
    }

    public final Object scrollToItem(int arg7, int arg8, Continuation arg9) {
        Object v6 = ScrollableState.scroll$default(this, null, new LazyStaggeredGridState$scrollToItem$2(this, arg7, arg8, null), arg9, 1, null);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public static Object scrollToItem$default(LazyStaggeredGridState arg0, int arg1, int arg2, Continuation arg3, int arg4, Object arg5) {
        return arg0.scrollToItem(arg1, 0, arg3);
    }

    static final float scrollableState$lambda$0(LazyStaggeredGridState arg0, float arg1) {
        return -arg0.onScroll(-arg1);
    }

    private void setCanScrollBackward(boolean arg1) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(arg1));
    }

    private void setCanScrollForward(boolean arg1) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setMeasurePassCount$foundation(int arg1) {
        this.measurePassCount = arg1;
    }

    public final void setPrefetchingEnabled$foundation(boolean arg1) {
        this.prefetchingEnabled = arg1;
    }

    public final void snapToItemInternal$foundation(int arg6, int arg7, boolean arg8) {
        int v1 = 0;
        int v0 = this.scrollPosition.getIndex() != arg6 || this.scrollPosition.getScrollOffset() != arg7 ? 1 : 0;
        if(v0 != 0) {
            this.itemAnimator.reset();
        }

        Object v2 = this.layoutInfoState.getValue();
        LazyStaggeredGridItemInfo v3 = LazyStaggeredGridMeasureResultKt.findVisibleItem(v2, arg6);
        if(v3 == null || v0 == 0) {
            this.scrollPosition.requestPositionAndForgetLastKnownKey(arg6, arg7);
        }
        else {
            arg6 = ((LazyStaggeredGridMeasureResult)v2).getOrientation() == Orientation.Vertical ? IntOffset.getY-impl(v3.getOffset-nOcc-ac()) : IntOffset.getX-impl(v3.getOffset-nOcc-ac());
            arg6 += arg7;
            arg7 = ((LazyStaggeredGridMeasureResult)v2).getFirstVisibleItemScrollOffsets().length;
            int[] v0_1 = new int[arg7];
            while(v1 < arg7) {
                v0_1[v1] = ((LazyStaggeredGridMeasureResult)v2).getFirstVisibleItemScrollOffsets()[v1] + arg6;
                ++v1;
            }

            this.scrollPosition.updateScrollOffset(v0_1);
        }

        if(arg8) {
            Remeasurement v5 = this.remeasurement;
            if(v5 != null) {
                v5.forceRemeasure();
            }

            return;
        }

        ObservableScopeInvalidator.invalidateScope-impl(this.measurementScopeInvalidator);
    }

    public final int[] updateScrollPositionIfTheFirstItemWasMoved$foundation(LazyLayoutItemProvider arg1, int[] arg2) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(arg1, arg2);
    }
}

