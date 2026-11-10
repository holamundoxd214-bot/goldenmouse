package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u009F\u0001\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\u0002\u0012\u0006\u0010\f\u001A\u00020\n\u0012\u0006\u0010\r\u001A\u00020\b\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00040\u0015\u0012\u0006\u0010\u0016\u001A\u00020\u0006\u0012\u0006\u0010\u0017\u001A\u00020\u0006\u0012\u0006\u0010\u0018\u001A\u00020\u0006\u0012\u0006\u0010\u0019\u001A\u00020\b\u0012\u0006\u0010\u001A\u001A\u00020\u001B\u0012\u0006\u0010\u001C\u001A\u00020\u0006\u0012\u0006\u0010\u001D\u001A\u00020\u0006¢\u0006\u0004\b\u001E\u0010\u001FJ\u0018\u0010B\u001A\u0004\u0018\u00010\u00002\u0006\u0010C\u001A\u00020\u00062\u0006\u0010D\u001A\u00020\bJ\t\u0010E\u001A\u00020FH\u0096\u0001R\u0013\u0010\u0003\u001A\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001A\u0004\b \u0010!R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u000E\u0010\u000B\u001A\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b(\u0010\'R\u0011\u0010\r\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b)\u0010%R\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b*\u0010+R\u0011\u0010\u0010\u001A\u00020\u0011¢\u0006\b\n\u0000\u001A\u0004\b,\u0010-R\u0013\u0010\u0012\u001A\u00020\u0013¢\u0006\n\n\u0002\u00100\u001A\u0004\b.\u0010/R\u001A\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00040\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b1\u00102R\u0014\u0010\u0016\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b3\u0010#R\u0014\u0010\u0017\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b4\u0010#R\u0014\u0010\u0018\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b5\u0010#R\u0014\u0010\u0019\u001A\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b6\u0010%R\u0014\u0010\u001A\u001A\u00020\u001BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b7\u00108R\u0014\u0010\u001C\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b9\u0010#R\u0014\u0010\u001D\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b:\u0010#R\u0011\u0010;\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b<\u0010%R\u0014\u0010=\u001A\u00020>8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b?\u0010/R\u0014\u0010@\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bA\u0010#R\u001E\u0010G\u001A\u000E\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00060HX\u0096\u0005¢\u0006\u0006\u001A\u0004\bJ\u0010KR\u0012\u0010L\u001A\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001A\u0004\bM\u0010#R\'\u0010N\u001A\u0015\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020F\u0018\u00010O¢\u0006\u0002\bQ8VX\u0096\u0005¢\u0006\u0006\u001A\u0004\bR\u0010SR\u0012\u0010T\u001A\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001A\u0004\bU\u0010#¨\u0006V"}, d2={"Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleItem", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "firstVisibleItemScrollOffset", "", "canScrollForward", "", "consumedScroll", "", "measureResult", "scrollBackAmount", "remeasureNeeded", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "density", "Landroidx/compose/ui/unit/Density;", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "visibleItemsInfo", "", "viewportStartOffset", "viewportEndOffset", "totalItemsCount", "reverseLayout", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "afterContentPadding", "mainAxisItemSpacing", "<init>", "(Landroidx/compose/foundation/lazy/LazyListMeasuredItem;IZFLandroidx/compose/ui/layout/MeasureResult;FZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/unit/Density;JLjava/util/List;IIIZLandroidx/compose/foundation/gestures/Orientation;IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFirstVisibleItem", "()Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "getFirstVisibleItemScrollOffset", "()I", "getCanScrollForward", "()Z", "getConsumedScroll", "()F", "getScrollBackAmount", "getRemeasureNeeded", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getChildConstraints-msEJaDk", "()J", "J", "getVisibleItemsInfo", "()Ljava/util/List;", "getViewportStartOffset", "getViewportEndOffset", "getTotalItemsCount", "getReverseLayout", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getAfterContentPadding", "getMainAxisItemSpacing", "canScrollBackward", "getCanScrollBackward", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "beforeContentPadding", "getBeforeContentPadding", "copyWithScrollDeltaWithoutRemeasure", "delta", "updateAnimations", "placeChildren", "", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "width", "getWidth", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyListMeasureResult implements LazyListLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final boolean canScrollForward;
    private final long childConstraints;
    private final float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final LazyListMeasuredItem firstVisibleItem;
    private final int firstVisibleItemScrollOffset;
    private final int mainAxisItemSpacing;
    private final MeasureResult measureResult;
    private final Orientation orientation;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final float scrollBackAmount;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List visibleItemsInfo;

    static {
    }

    public LazyListMeasureResult(LazyListMeasuredItem arg1, int arg2, boolean arg3, float arg4, MeasureResult arg5, float arg6, boolean arg7, CoroutineScope arg8, Density arg9, long arg10, List arg12, int arg13, int arg14, int arg15, boolean arg16, Orientation arg17, int arg18, int arg19, DefaultConstructorMarker arg20) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
    }

    private LazyListMeasureResult(LazyListMeasuredItem arg1, int arg2, boolean arg3, float arg4, MeasureResult arg5, float arg6, boolean arg7, CoroutineScope arg8, Density arg9, long arg10, List arg12, int arg13, int arg14, int arg15, boolean arg16, Orientation arg17, int arg18, int arg19) {
        super();
        this.firstVisibleItem = arg1;
        this.firstVisibleItemScrollOffset = arg2;
        this.canScrollForward = arg3;
        this.consumedScroll = arg4;
        this.measureResult = arg5;
        this.scrollBackAmount = arg6;
        this.remeasureNeeded = arg7;
        this.coroutineScope = arg8;
        this.density = arg9;
        this.childConstraints = arg10;
        this.visibleItemsInfo = arg12;
        this.viewportStartOffset = arg13;
        this.viewportEndOffset = arg14;
        this.totalItemsCount = arg15;
        this.reverseLayout = arg16;
        this.orientation = arg17;
        this.afterContentPadding = arg18;
        this.mainAxisItemSpacing = arg19;
    }

    public final LazyListMeasureResult copyWithScrollDeltaWithoutRemeasure(int arg28, boolean arg29) {
        LazyListMeasureResult v0 = this;
        int v1 = arg28;
        LazyListMeasureResult v3 = null;
        if(!v0.remeasureNeeded && !v0.getVisibleItemsInfo().isEmpty()) {
            LazyListMeasuredItem v2 = v0.firstVisibleItem;
            if(v2 != null) {
                int v2_1 = v2.getMainAxisSizeWithSpacings();
                int v4 = v0.firstVisibleItemScrollOffset - v1;
                if(v4 >= 0 && v4 < v2_1) {
                    Object v2_2 = CollectionsKt.first(v0.getVisibleItemsInfo());
                    Object v4_1 = CollectionsKt.last(v0.getVisibleItemsInfo());
                    if(!((LazyListMeasuredItem)v2_2).getNonScrollableItem()) {
                        if(((LazyListMeasuredItem)v4_1).getNonScrollableItem()) {
                        }
                        else {
                            if(v1 >= 0) {
                                if(Math.min(v0.getViewportStartOffset() - ((LazyListMeasuredItem)v2_2).getOffset(), v0.getViewportEndOffset() - ((LazyListMeasuredItem)v4_1).getOffset()) > v1) {
                                    goto label_47;
                                }

                                return v3;
                            }
                            else if(Math.min(((LazyListMeasuredItem)v2_2).getOffset() + ((LazyListMeasuredItem)v2_2).getMainAxisSizeWithSpacings() - v0.getViewportStartOffset(), ((LazyListMeasuredItem)v4_1).getOffset() + ((LazyListMeasuredItem)v4_1).getMainAxisSizeWithSpacings() - v0.getViewportEndOffset()) > -v1) {
                            }
                            else {
                                return v3;
                            }

                        label_47:
                            List v2_3 = v0.getVisibleItemsInfo();
                            int v3_1 = v2_3.size();
                            boolean v4_2 = false;
                            int v5;
                            for(v5 = 0; v5 < v3_1; ++v5) {
                                v2_3.get(v5).applyScrollDelta(v1, arg29);
                            }

                            LazyListMeasuredItem v7 = v0.firstVisibleItem;
                            int v8 = v0.firstVisibleItemScrollOffset - v1;
                            if((v0.canScrollForward) || v1 > 0) {
                                v4_2 = true;
                            }

                            return new LazyListMeasureResult(v7, v8, v4_2, ((float)v1), v0.measureResult, v0.scrollBackAmount, v0.remeasureNeeded, v0.coroutineScope, v0.density, v0.childConstraints, v0.getVisibleItemsInfo(), v0.getViewportStartOffset(), v0.getViewportEndOffset(), v0.getTotalItemsCount(), v0.getReverseLayout(), v0.getOrientation(), v0.getAfterContentPadding(), v0.getMainAxisItemSpacing(), null);
                        }
                    }
                }
            }
        }

        return v3;
    }

    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public Map getAlignmentLines() {
        return this.measureResult.getAlignmentLines();
    }

    public int getBeforeContentPadding() {
        return -this.getViewportStartOffset();
    }

    public final boolean getCanScrollBackward() {
        LazyListMeasuredItem v0 = this.firstVisibleItem;
        int v0_1 = v0 != null ? v0.getIndex() : 0;
        if(v0_1 == 0) {
            if(this.firstVisibleItemScrollOffset != 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final long getChildConstraints-msEJaDk() {
        return this.childConstraints;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final LazyListMeasuredItem getFirstVisibleItem() {
        return this.firstVisibleItem;
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.firstVisibleItemScrollOffset;
    }

    public int getHeight() {
        return this.measureResult.getHeight();
    }

    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public Function1 getRulers() {
        return this.measureResult.getRulers();
    }

    public final float getScrollBackAmount() {
        return this.scrollBackAmount;
    }

    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    public long getViewportSize-YbymL2g() {
        return IntSize.constructor-impl((((long)this.getWidth())) << 0x20 | (((long)this.getHeight())) & 0xFFFFFFFFL);
    }

    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    public List getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    public int getWidth() {
        return this.measureResult.getWidth();
    }

    public void placeChildren() {
        this.measureResult.placeChildren();
    }
}

