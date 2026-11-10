package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B­\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\u0007\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\u000B\u0012\u0006\u0010\r\u001A\u00020\u000B\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\u0006\u0010\u0014\u001A\u00020\u0015\u0012\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0010\u0019\u001A\u00020\u001A\u0012\u0006\u0010\u001B\u001A\u00020\u0015\u0012\u0006\u0010\u001C\u001A\u00020\u0015\u0012\u0006\u0010\u001D\u001A\u00020\u0015\u0012\u0006\u0010\u001E\u001A\u00020\u0015\u0012\u0006\u0010\u001F\u001A\u00020\u0015\u0012\u0006\u0010 \u001A\u00020!¢\u0006\u0004\b\"\u0010#J\u0018\u0010I\u001A\u0004\u0018\u00010\u00002\u0006\u0010J\u001A\u00020\u00152\u0006\u0010K\u001A\u00020\u000BJ\t\u0010L\u001A\u00020MH\u0096\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u0011\u0010\u0005\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b&\u0010%R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010(R\u0011\u0010\b\u001A\u00020\u0002¢\u0006\b\n\u0000\u001A\u0004\b)\u0010*R\u0011\u0010\t\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b+\u0010(R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b,\u0010-R\u0011\u0010\f\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010-R\u0011\u0010\r\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b.\u0010-R\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b/\u00100R\u0011\u0010\u0010\u001A\u00020\u0011¢\u0006\b\n\u0000\u001A\u0004\b1\u00102R\u0011\u0010\u0012\u001A\u00020\u0013¢\u0006\b\n\u0000\u001A\u0004\b3\u00104R\u0014\u0010\u0014\u001A\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b5\u00106R\u001A\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b7\u00108R\u0016\u0010\u0019\u001A\u00020\u001AX\u0096\u0004¢\u0006\n\n\u0002\u0010;\u001A\u0004\b9\u0010:R\u0014\u0010\u001B\u001A\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b<\u00106R\u0014\u0010\u001C\u001A\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b=\u00106R\u0014\u0010\u001D\u001A\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b>\u00106R\u0014\u0010\u001E\u001A\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b?\u00106R\u0014\u0010\u001F\u001A\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b@\u00106R\u0011\u0010 \u001A\u00020!¢\u0006\b\n\u0000\u001A\u0004\bA\u0010BR\u0011\u0010C\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\bD\u0010-R\u0014\u0010E\u001A\u00020FX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\bG\u0010HR\u001E\u0010N\u001A\u000E\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00150OX\u0096\u0005¢\u0006\u0006\u001A\u0004\bQ\u0010RR\u0012\u0010S\u001A\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001A\u0004\bT\u00106R\'\u0010U\u001A\u0015\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020M\u0018\u00010V¢\u0006\u0002\bX8VX\u0096\u0005¢\u0006\u0006\u001A\u0004\bY\u0010ZR\u0012\u0010[\u001A\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001A\u0004\b\\\u00106¨\u0006]"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleItemIndices", "", "firstVisibleItemScrollOffsets", "consumedScroll", "", "measureResult", "scrollBackAmount", "canScrollForward", "", "isVertical", "remeasureNeeded", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "spanProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "density", "Landroidx/compose/ui/unit/Density;", "totalItemsCount", "", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "viewportStartOffset", "viewportEndOffset", "beforeContentPadding", "afterContentPadding", "mainAxisItemSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "([I[IFLandroidx/compose/ui/layout/MeasureResult;FZZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;Landroidx/compose/ui/unit/Density;ILjava/util/List;JIIIIILkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFirstVisibleItemIndices", "()[I", "getFirstVisibleItemScrollOffsets", "getConsumedScroll", "()F", "getMeasureResult", "()Landroidx/compose/ui/layout/MeasureResult;", "getScrollBackAmount", "getCanScrollForward", "()Z", "getRemeasureNeeded", "getSlots", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "getSpanProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getTotalItemsCount", "()I", "getVisibleItemsInfo", "()Ljava/util/List;", "getViewportSize-YbymL2g", "()J", "J", "getViewportStartOffset", "getViewportEndOffset", "getBeforeContentPadding", "getAfterContentPadding", "getMainAxisItemSpacing", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "canScrollBackward", "getCanScrollBackward", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "copyWithScrollDeltaWithoutRemeasure", "delta", "updateAnimations", "placeChildren", "", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "width", "getWidth", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridMeasureResult implements LazyStaggeredGridLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final boolean canScrollForward;
    private final float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final int[] firstVisibleItemIndices;
    private final int[] firstVisibleItemScrollOffsets;
    private final boolean isVertical;
    private final int mainAxisItemSpacing;
    private final MeasureResult measureResult;
    private final Orientation orientation;
    private final boolean remeasureNeeded;
    private final float scrollBackAmount;
    private final LazyStaggeredGridSlots slots;
    private final LazyStaggeredGridSpanProvider spanProvider;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final long viewportSize;
    private final int viewportStartOffset;
    private final List visibleItemsInfo;

    static {
    }

    public LazyStaggeredGridMeasureResult(int[] arg1, int[] arg2, float arg3, MeasureResult arg4, float arg5, boolean arg6, boolean arg7, boolean arg8, LazyStaggeredGridSlots arg9, LazyStaggeredGridSpanProvider arg10, Density arg11, int arg12, List arg13, long arg14, int arg16, int arg17, int arg18, int arg19, int arg20, CoroutineScope arg21, DefaultConstructorMarker arg22) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg16, arg17, arg18, arg19, arg20, arg21);
    }

    private LazyStaggeredGridMeasureResult(int[] arg1, int[] arg2, float arg3, MeasureResult arg4, float arg5, boolean arg6, boolean arg7, boolean arg8, LazyStaggeredGridSlots arg9, LazyStaggeredGridSpanProvider arg10, Density arg11, int arg12, List arg13, long arg14, int arg16, int arg17, int arg18, int arg19, int arg20, CoroutineScope arg21) {
        super();
        this.firstVisibleItemIndices = arg1;
        this.firstVisibleItemScrollOffsets = arg2;
        this.consumedScroll = arg3;
        this.measureResult = arg4;
        this.scrollBackAmount = arg5;
        this.canScrollForward = arg6;
        this.isVertical = arg7;
        this.remeasureNeeded = arg8;
        this.slots = arg9;
        this.spanProvider = arg10;
        this.density = arg11;
        this.totalItemsCount = arg12;
        this.visibleItemsInfo = arg13;
        this.viewportSize = arg14;
        this.viewportStartOffset = arg16;
        this.viewportEndOffset = arg17;
        this.beforeContentPadding = arg18;
        this.afterContentPadding = arg19;
        this.mainAxisItemSpacing = arg20;
        this.coroutineScope = arg21;
        Orientation v1 = arg7 ? Orientation.Vertical : Orientation.Horizontal;
        this.orientation = v1;
    }

    public final LazyStaggeredGridMeasureResult copyWithScrollDeltaWithoutRemeasure(int arg33, boolean arg34) {
        LazyStaggeredGridMeasureResult v0 = this;
        int v1 = arg33;
        LazyStaggeredGridMeasureResult v3 = null;
        if(!v0.remeasureNeeded && !v0.getVisibleItemsInfo().isEmpty()) {
            if(v0.firstVisibleItemIndices.length == 0) {
            }
            else if(v0.firstVisibleItemScrollOffsets.length == 0) {
            }
            else {
                int v2 = v0.getViewportEndOffset() - v0.getAfterContentPadding();
                List v4 = v0.getVisibleItemsInfo();
                int v5 = v4.size();
                int v7 = 0;
                while(true) {
                    int v8 = 1;
                    if(v7 < v5) {
                        Object v9 = v4.get(v7);
                        if(!((LazyStaggeredGridMeasuredItem)v9).getNonScrollableItem()) {
                            int v10 = ((LazyStaggeredGridMeasuredItem)v9).getMainAxisOffset() <= 0 ? 1 : 0;
                            if(((LazyStaggeredGridMeasuredItem)v9).getMainAxisOffset() + v1 <= 0) {
                            }
                            else {
                                v8 = 0;
                            }

                            if(v10 != v8) {
                                return v3;
                            }

                            if(((LazyStaggeredGridMeasuredItem)v9).getMainAxisOffset() <= v0.getViewportStartOffset()) {
                                if(v1 < 0) {
                                    if(((LazyStaggeredGridMeasuredItem)v9).getMainAxisOffset() + ((LazyStaggeredGridMeasuredItem)v9).getMainAxisSizeWithSpacings() - v0.getViewportStartOffset() > -v1) {
                                        goto label_59;
                                    }
                                }
                                else if(v0.getViewportStartOffset() - ((LazyStaggeredGridMeasuredItem)v9).getMainAxisOffset() > v1) {
                                    goto label_59;
                                }

                                return v3;
                            }

                        label_59:
                            if(((LazyStaggeredGridMeasuredItem)v9).getMainAxisOffset() + ((LazyStaggeredGridMeasuredItem)v9).getMainAxisSizeWithSpacings() >= v2) {
                                if(v1 < 0) {
                                    if(((LazyStaggeredGridMeasuredItem)v9).getMainAxisOffset() + ((LazyStaggeredGridMeasuredItem)v9).getMainAxisSizeWithSpacings() - v0.getViewportEndOffset() > -v1) {
                                        goto label_78;
                                    }
                                }
                                else if(v0.getViewportEndOffset() - ((LazyStaggeredGridMeasuredItem)v9).getMainAxisOffset() > v1) {
                                    goto label_78;
                                }

                                return v3;
                            }

                        label_78:
                            ++v7;
                            continue;
                        }

                        return v3;
                    }
                    else {
                        goto label_81;
                    }
                }

                return v3;
            label_81:
                List v2_1 = v0.getVisibleItemsInfo();
                int v3_1 = v2_1.size();
                int v4_1;
                for(v4_1 = 0; v4_1 < v3_1; ++v4_1) {
                    v2_1.get(v4_1).applyScrollDelta(v1, arg34);
                }

                int[] v10_1 = v0.firstVisibleItemIndices;
                v2 = v0.firstVisibleItemScrollOffsets.length;
                int[] v11 = new int[v2];
                for(v3_1 = 0; v3_1 < v2; ++v3_1) {
                    v11[v3_1] = v0.firstVisibleItemScrollOffsets[v3_1] - v1;
                }

                float v12 = ((float)v1);
                float v14 = v0.scrollBackAmount;
                MeasureResult v13 = v0.measureResult;
                boolean v15 = (v0.canScrollForward) || v1 > 0 ? true : false;
                return new LazyStaggeredGridMeasureResult(v10_1, v11, v12, v13, v14, v15, v0.isVertical, v0.remeasureNeeded, v0.slots, v0.spanProvider, v0.density, v0.getTotalItemsCount(), v0.getVisibleItemsInfo(), v0.getViewportSize-YbymL2g(), v0.getViewportStartOffset(), v0.getViewportEndOffset(), v0.getBeforeContentPadding(), v0.getAfterContentPadding(), v0.getMainAxisItemSpacing(), v0.coroutineScope, null);
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
        return this.beforeContentPadding;
    }

    public final boolean getCanScrollBackward() {
        if(this.firstVisibleItemIndices[0] == 0) {
            if(this.firstVisibleItemScrollOffsets[0] > 0) {
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

    public final int[] getFirstVisibleItemIndices() {
        return this.firstVisibleItemIndices;
    }

    public final int[] getFirstVisibleItemScrollOffsets() {
        return this.firstVisibleItemScrollOffsets;
    }

    public int getHeight() {
        return this.measureResult.getHeight();
    }

    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    public final MeasureResult getMeasureResult() {
        return this.measureResult;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    public Function1 getRulers() {
        return this.measureResult.getRulers();
    }

    public final float getScrollBackAmount() {
        return this.scrollBackAmount;
    }

    public final LazyStaggeredGridSlots getSlots() {
        return this.slots;
    }

    public final LazyStaggeredGridSpanProvider getSpanProvider() {
        return this.spanProvider;
    }

    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    public long getViewportSize-YbymL2g() {
        return this.viewportSize;
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

    public final boolean isVertical() {
        return this.isVertical;
    }

    public void placeChildren() {
        this.measureResult.placeChildren();
    }
}

