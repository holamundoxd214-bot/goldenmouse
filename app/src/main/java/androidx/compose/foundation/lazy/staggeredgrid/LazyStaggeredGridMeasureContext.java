package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.graphics.GraphicsContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u009F\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\u0006\u0010\u0011\u001A\u00020\u0006\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\u0006\u0010\u0014\u001A\u00020\u0006\u0012\u0006\u0010\u0015\u001A\u00020\u0006\u0012\u0006\u0010\u0016\u001A\u00020\u000E\u0012\u0006\u0010\u0017\u001A\u00020\u0006\u0012\u0006\u0010\u0018\u001A\u00020\u0019\u0012\u0006\u0010\u001A\u001A\u00020\u000E\u0012\u0006\u0010\u001B\u001A\u00020\u000E\u0012\b\u0010\u001C\u001A\u0004\u0018\u00010\u001D\u0012\u0006\u0010\u001E\u001A\u00020\u001F¢\u0006\u0004\b \u0010!J\u0012\u0010G\u001A\u00020\u000E*\u00020\b2\u0006\u0010H\u001A\u00020\u0006J!\u0010I\u001A\u00020J*\u00020\b2\u0006\u0010H\u001A\u00020\u00062\u0006\u0010K\u001A\u00020\u0006¢\u0006\u0004\bL\u0010MR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b(\u0010)R\u0013\u0010\u000B\u001A\u00020\f¢\u0006\n\n\u0002\u0010,\u001A\u0004\b*\u0010+R\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010-R\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b.\u0010/R\u0011\u0010\u0011\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b0\u00101R\u0013\u0010\u0012\u001A\u00020\u0013¢\u0006\n\n\u0002\u0010,\u001A\u0004\b2\u0010+R\u0011\u0010\u0014\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b3\u00101R\u0011\u0010\u0015\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b4\u00101R\u0011\u0010\u0016\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b5\u0010-R\u0011\u0010\u0017\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b6\u00101R\u0011\u0010\u0018\u001A\u00020\u0019¢\u0006\b\n\u0000\u001A\u0004\b7\u00108R\u0011\u0010\u001A\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010-R\u0011\u0010\u001B\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010-R\u0013\u0010\u001C\u001A\u0004\u0018\u00010\u001D¢\u0006\b\n\u0000\u001A\u0004\b9\u0010:R\u0011\u0010\u001E\u001A\u00020\u001F¢\u0006\b\n\u0000\u001A\u0004\b;\u0010<R\u0011\u0010=\u001A\u00020>¢\u0006\b\n\u0000\u001A\u0004\b?\u0010@R\u0011\u0010A\u001A\u00020B¢\u0006\b\n\u0000\u001A\u0004\bC\u0010DR\u0011\u0010E\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\bF\u00101R\u0016\u0010G\u001A\u00020\u000E*\u00020J8Æ\u0002¢\u0006\u0006\u001A\u0004\bN\u0010OR\u0016\u0010A\u001A\u00020\u0006*\u00020J8Æ\u0002¢\u0006\u0006\u001A\u0004\bP\u0010Q¨\u0006R"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "mainAxisAvailableSize", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "beforeContentPadding", "afterContentPadding", "reverseLayout", "mainAxisSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "<init>", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZLandroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJIIZILkotlinx/coroutines/CoroutineScope;ZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getState", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "getPinnedItems", "()Ljava/util/List;", "getItemProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "getResolvedSlots", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "getConstraints-msEJaDk", "()J", "J", "()Z", "getMeasureScope", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "getMainAxisAvailableSize", "()I", "getContentOffset-nOcc-ac", "getBeforeContentPadding", "getAfterContentPadding", "getReverseLayout", "getMainAxisSpacing", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getApproachLayoutInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "getMeasuredItemProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "laneInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getLaneInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "laneCount", "getLaneCount", "isFullSpan", "itemIndex", "getSpanRange", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "lane", "getSpanRange-lOCCd4c", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;II)J", "isFullSpan-SZVOQXA", "(J)Z", "getLaneInfo-SZVOQXA", "(J)I", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridMeasureContext {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyStaggeredGridLayoutInfo approachLayoutInfo;
    private final int beforeContentPadding;
    private final long constraints;
    private final long contentOffset;
    private final CoroutineScope coroutineScope;
    private final GraphicsContext graphicsContext;
    private final boolean isInLookaheadScope;
    private final boolean isLookingAhead;
    private final boolean isVertical;
    private final LazyStaggeredGridItemProvider itemProvider;
    private final int laneCount;
    private final LazyStaggeredGridLaneInfo laneInfo;
    private final int mainAxisAvailableSize;
    private final int mainAxisSpacing;
    private final LazyLayoutMeasureScope measureScope;
    private final LazyStaggeredGridMeasureProvider measuredItemProvider;
    private final List pinnedItems;
    private final LazyStaggeredGridSlots resolvedSlots;
    private final boolean reverseLayout;
    private final LazyStaggeredGridState state;

    static {
    }

    private LazyStaggeredGridMeasureContext(LazyStaggeredGridState arg1, List arg2, LazyStaggeredGridItemProvider arg3, LazyStaggeredGridSlots arg4, long arg5, boolean arg7, LazyLayoutMeasureScope arg8, int arg9, long arg10, int arg12, int arg13, boolean arg14, int arg15, CoroutineScope arg16, boolean arg17, boolean arg18, LazyStaggeredGridLayoutInfo arg19, GraphicsContext arg20) {
        super();
        this.state = arg1;
        this.pinnedItems = arg2;
        this.itemProvider = arg3;
        this.resolvedSlots = arg4;
        this.constraints = arg5;
        this.isVertical = arg7;
        this.measureScope = arg8;
        this.mainAxisAvailableSize = arg9;
        this.contentOffset = arg10;
        this.beforeContentPadding = arg12;
        this.afterContentPadding = arg13;
        this.reverseLayout = arg14;
        this.mainAxisSpacing = arg15;
        this.coroutineScope = arg16;
        this.isInLookaheadScope = arg17;
        this.isLookingAhead = arg18;
        this.approachLayoutInfo = arg19;
        this.graphicsContext = arg20;
        this.measuredItemProvider = new LazyStaggeredGridMeasureContext$measuredItemProvider$1(this, arg7, arg3, arg8, arg4);
        this.laneInfo = arg1.getLaneInfo$foundation();
        this.laneCount = arg4.getSizes().length;
    }

    public LazyStaggeredGridMeasureContext(LazyStaggeredGridState arg1, List arg2, LazyStaggeredGridItemProvider arg3, LazyStaggeredGridSlots arg4, long arg5, boolean arg7, LazyLayoutMeasureScope arg8, int arg9, long arg10, int arg12, int arg13, boolean arg14, int arg15, CoroutineScope arg16, boolean arg17, boolean arg18, LazyStaggeredGridLayoutInfo arg19, GraphicsContext arg20, DefaultConstructorMarker arg21) {
        this(arg1, arg2, arg3, arg4, arg5, arg7, arg8, arg9, arg10, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20);
    }

    public final int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public final LazyStaggeredGridLayoutInfo getApproachLayoutInfo() {
        return this.approachLayoutInfo;
    }

    public final int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    public final long getConstraints-msEJaDk() {
        return this.constraints;
    }

    public final long getContentOffset-nOcc-ac() {
        return this.contentOffset;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public final LazyStaggeredGridItemProvider getItemProvider() {
        return this.itemProvider;
    }

    public final int getLaneCount() {
        return this.laneCount;
    }

    public final LazyStaggeredGridLaneInfo getLaneInfo() {
        return this.laneInfo;
    }

    public final int getLaneInfo-SZVOQXA(long arg3) {
        int v2 = ((int)(0xFFFFFFFFL & arg3));
        int v3 = ((int)(arg3 >> 0x20));
        if(v2 - v3 != 1) {
            return -2;
        }

        return v3;
    }

    public final int getMainAxisAvailableSize() {
        return this.mainAxisAvailableSize;
    }

    public final int getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    public final LazyLayoutMeasureScope getMeasureScope() {
        return this.measureScope;
    }

    public final LazyStaggeredGridMeasureProvider getMeasuredItemProvider() {
        return this.measuredItemProvider;
    }

    public final List getPinnedItems() {
        return this.pinnedItems;
    }

    public final LazyStaggeredGridSlots getResolvedSlots() {
        return this.resolvedSlots;
    }

    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public final long getSpanRange-lOCCd4c(LazyStaggeredGridItemProvider arg1, int arg2, int arg3) {
        int v0 = arg1.getSpanProvider().isFullSpan(arg2) ? this.laneCount : 1;
        return SpanRange.constructor-impl(0, v0);
    }

    public final LazyStaggeredGridState getState() {
        return this.state;
    }

    public final boolean isFullSpan(LazyStaggeredGridItemProvider arg1, int arg2) {
        return arg1.getSpanProvider().isFullSpan(arg2);
    }

    public final boolean isFullSpan-SZVOQXA(long arg3) {
        if((((int)(0xFFFFFFFFL & arg3))) - (((int)(arg3 >> 0x20))) != 1) {
            return 1;
        }

        return 0;
    }

    public final boolean isInLookaheadScope() {
        return this.isInLookaheadScope;
    }

    public final boolean isLookingAhead() {
        return this.isLookingAhead;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }
}

