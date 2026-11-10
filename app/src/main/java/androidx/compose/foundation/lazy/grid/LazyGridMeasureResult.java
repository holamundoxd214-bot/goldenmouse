package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B÷\u0001\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\u0002\u0012\u0006\u0010\f\u001A\u00020\n\u0012\u0006\u0010\r\u001A\u00020\b\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0006\u0010\u0012\u001A\u00020\u0006\u00123\u0010\u0013\u001A/\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001A0\u00190\u00180\u0014\u0012!\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\u00060\u0014\u0012\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001E0\u0018\u0012\u0006\u0010\u001F\u001A\u00020\u0006\u0012\u0006\u0010 \u001A\u00020\u0006\u0012\u0006\u0010!\u001A\u00020\u0006\u0012\u0006\u0010\"\u001A\u00020\b\u0012\u0006\u0010#\u001A\u00020$\u0012\u0006\u0010%\u001A\u00020\u0006\u0012\u0006\u0010&\u001A\u00020\u0006¢\u0006\u0004\b\'\u0010(J\u0018\u0010O\u001A\u0004\u0018\u00010\u00002\u0006\u0010P\u001A\u00020\u00062\u0006\u0010Q\u001A\u00020\bJ\t\u0010R\u001A\u00020SH\u0096\u0001R\u0013\u0010\u0003\u001A\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001A\u0004\b)\u0010*R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b+\u0010,R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b-\u0010.R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b/\u00100R\u000E\u0010\u000B\u001A\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b1\u00100R\u0011\u0010\r\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b2\u0010.R\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b3\u00104R\u0011\u0010\u0010\u001A\u00020\u0011¢\u0006\b\n\u0000\u001A\u0004\b5\u00106R\u0011\u0010\u0012\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b7\u0010,R>\u0010\u0013\u001A/\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001A0\u00190\u00180\u0014¢\u0006\b\n\u0000\u001A\u0004\b8\u00109R,\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\u00060\u0014¢\u0006\b\n\u0000\u001A\u0004\b:\u00109R\u001A\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001E0\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b;\u0010<R\u0014\u0010\u001F\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b=\u0010,R\u0014\u0010 \u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b>\u0010,R\u0014\u0010!\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b?\u0010,R\u0014\u0010\"\u001A\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b@\u0010.R\u0014\u0010#\u001A\u00020$X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\bA\u0010BR\u0014\u0010%\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\bC\u0010,R\u0014\u0010&\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\bD\u0010,R\u0011\u0010E\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\bF\u0010.R\u0014\u0010G\u001A\u00020H8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bI\u0010JR\u0014\u0010K\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bL\u0010,R\u0014\u0010M\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bN\u0010,R\u001E\u0010T\u001A\u000E\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020\u00060UX\u0096\u0005¢\u0006\u0006\u001A\u0004\bW\u0010XR\u0012\u0010Y\u001A\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001A\u0004\bZ\u0010,R\'\u0010[\u001A\u0015\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020S\u0018\u00010\u0014¢\u0006\u0002\b]8VX\u0096\u0005¢\u0006\u0006\u001A\u0004\b^\u00109R\u0012\u0010_\u001A\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001A\u0004\b`\u0010,¨\u0006a"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleLine", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "firstVisibleLineScrollOffset", "", "canScrollForward", "", "consumedScroll", "", "measureResult", "scrollBackAmount", "remeasureNeeded", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "density", "Landroidx/compose/ui/unit/Density;", "slotsPerLine", "prefetchInfoRetriever", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/Constraints;", "lineIndexProvider", "itemIndex", "visibleItemsInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "viewportStartOffset", "viewportEndOffset", "totalItemsCount", "reverseLayout", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "afterContentPadding", "mainAxisItemSpacing", "<init>", "(Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;IZFLandroidx/compose/ui/layout/MeasureResult;FZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/util/List;IIIZLandroidx/compose/foundation/gestures/Orientation;II)V", "getFirstVisibleLine", "()Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "getFirstVisibleLineScrollOffset", "()I", "getCanScrollForward", "()Z", "getConsumedScroll", "()F", "getScrollBackAmount", "getRemeasureNeeded", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getSlotsPerLine", "getPrefetchInfoRetriever", "()Lkotlin/jvm/functions/Function1;", "getLineIndexProvider", "getVisibleItemsInfo", "()Ljava/util/List;", "getViewportStartOffset", "getViewportEndOffset", "getTotalItemsCount", "getReverseLayout", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getAfterContentPadding", "getMainAxisItemSpacing", "canScrollBackward", "getCanScrollBackward", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "beforeContentPadding", "getBeforeContentPadding", "maxSpan", "getMaxSpan", "copyWithScrollDeltaWithoutRemeasure", "delta", "updateAnimations", "placeChildren", "", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "rulers", "Landroidx/compose/ui/layout/RulerScope;", "Lkotlin/ExtensionFunctionType;", "getRulers", "width", "getWidth", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyGridMeasureResult implements LazyGridLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final boolean canScrollForward;
    private final float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final LazyGridMeasuredLine firstVisibleLine;
    private final int firstVisibleLineScrollOffset;
    private final Function1 lineIndexProvider;
    private final int mainAxisItemSpacing;
    private final MeasureResult measureResult;
    private final Orientation orientation;
    private final Function1 prefetchInfoRetriever;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final float scrollBackAmount;
    private final int slotsPerLine;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List visibleItemsInfo;

    static {
    }

    public LazyGridMeasureResult(LazyGridMeasuredLine arg1, int arg2, boolean arg3, float arg4, MeasureResult arg5, float arg6, boolean arg7, CoroutineScope arg8, Density arg9, int arg10, Function1 arg11, Function1 arg12, List arg13, int arg14, int arg15, int arg16, boolean arg17, Orientation arg18, int arg19, int arg20) {
        super();
        this.firstVisibleLine = arg1;
        this.firstVisibleLineScrollOffset = arg2;
        this.canScrollForward = arg3;
        this.consumedScroll = arg4;
        this.measureResult = arg5;
        this.scrollBackAmount = arg6;
        this.remeasureNeeded = arg7;
        this.coroutineScope = arg8;
        this.density = arg9;
        this.slotsPerLine = arg10;
        this.prefetchInfoRetriever = arg11;
        this.lineIndexProvider = arg12;
        this.visibleItemsInfo = arg13;
        this.viewportStartOffset = arg14;
        this.viewportEndOffset = arg15;
        this.totalItemsCount = arg16;
        this.reverseLayout = arg17;
        this.orientation = arg18;
        this.afterContentPadding = arg19;
        this.mainAxisItemSpacing = arg20;
    }

    public final LazyGridMeasureResult copyWithScrollDeltaWithoutRemeasure(int arg28, boolean arg29) {
        LazyGridMeasureResult v0 = this;
        int v1 = arg28;
        LazyGridMeasureResult v3 = null;
        if(!v0.remeasureNeeded && !v0.getVisibleItemsInfo().isEmpty()) {
            LazyGridMeasuredLine v2 = v0.firstVisibleLine;
            if(v2 != null) {
                int v2_1 = v2.getMainAxisSizeWithSpacings();
                int v4 = v0.firstVisibleLineScrollOffset - v1;
                if(v4 >= 0 && v4 < v2_1) {
                    Object v2_2 = CollectionsKt.first(v0.getVisibleItemsInfo());
                    Object v4_1 = CollectionsKt.last(v0.getVisibleItemsInfo());
                    if(!((LazyGridMeasuredItem)v2_2).getNonScrollableItem()) {
                        if(((LazyGridMeasuredItem)v4_1).getNonScrollableItem()) {
                        }
                        else {
                            if(v1 >= 0) {
                                if(Math.min(v0.getViewportStartOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(((LazyGridItemInfo)v2_2), v0.getOrientation()), v0.getViewportEndOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(((LazyGridItemInfo)v4_1), v0.getOrientation())) > v1) {
                                    goto label_53;
                                }

                                return v3;
                            }
                            else if(Math.min(LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(v2_2, v0.getOrientation()) + ((LazyGridMeasuredItem)v2_2).getMainAxisSizeWithSpacings() - v0.getViewportStartOffset(), LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(v4_1, v0.getOrientation()) + ((LazyGridMeasuredItem)v4_1).getMainAxisSizeWithSpacings() - v0.getViewportEndOffset()) > -v1) {
                            }
                            else {
                                return v3;
                            }

                        label_53:
                            List v2_3 = v0.getVisibleItemsInfo();
                            int v3_1 = v2_3.size();
                            boolean v4_2 = false;
                            int v5;
                            for(v5 = 0; v5 < v3_1; ++v5) {
                                v2_3.get(v5).applyScrollDelta(v1, arg29);
                            }

                            LazyGridMeasuredLine v7 = v0.firstVisibleLine;
                            int v8 = v0.firstVisibleLineScrollOffset - v1;
                            if((v0.canScrollForward) || v1 > 0) {
                                v4_2 = true;
                            }

                            return new LazyGridMeasureResult(v7, v8, v4_2, ((float)v1), v0.measureResult, v0.scrollBackAmount, v0.remeasureNeeded, v0.coroutineScope, v0.density, v0.slotsPerLine, v0.prefetchInfoRetriever, v0.lineIndexProvider, v0.getVisibleItemsInfo(), v0.getViewportStartOffset(), v0.getViewportEndOffset(), v0.getTotalItemsCount(), v0.getReverseLayout(), v0.getOrientation(), v0.getAfterContentPadding(), v0.getMainAxisItemSpacing());
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
        LazyGridMeasuredLine v0 = this.firstVisibleLine;
        int v0_1 = v0 != null ? v0.getIndex() : 0;
        if(v0_1 == 0) {
            if(this.firstVisibleLineScrollOffset != 0) {
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

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final LazyGridMeasuredLine getFirstVisibleLine() {
        return this.firstVisibleLine;
    }

    public final int getFirstVisibleLineScrollOffset() {
        return this.firstVisibleLineScrollOffset;
    }

    public int getHeight() {
        return this.measureResult.getHeight();
    }

    public final Function1 getLineIndexProvider() {
        return this.lineIndexProvider;
    }

    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    public int getMaxSpan() {
        return this.slotsPerLine;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public final Function1 getPrefetchInfoRetriever() {
        return this.prefetchInfoRetriever;
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

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
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

