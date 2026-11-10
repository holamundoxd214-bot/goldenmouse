package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
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

@Metadata(d1={"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BÑ\u0001\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\u0007\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\u0007\u0012\u0006\u0010\r\u001A\u00020\u0007\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0007\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001A\u00020\u0014\u0012\u0006\u0010\u0015\u001A\u00020\u0007\u0012\u0006\u0010\u0016\u001A\u00020\u000F\u0012\u0006\u0010\u0017\u001A\u00020\u0018\u0012\u0006\u0010\u0019\u001A\u00020\u0002\u0012\u0006\u0010\u001A\u001A\u00020\u000F\u0012\u000E\b\u0002\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000E\b\u0002\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u001D\u001A\u00020\u001E\u0012\u0006\u0010\u001F\u001A\u00020 \u0012\u0006\u0010!\u001A\u00020\"¢\u0006\u0004\b#\u0010$J\u0010\u0010L\u001A\u0004\u0018\u00010\u00002\u0006\u0010M\u001A\u00020\u0007J\t\u0010N\u001A\u00020OH\u0096\u0001R\u001A\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010(R\u0014\u0010\b\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b)\u0010(R\u0014\u0010\t\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b*\u0010(R\u0014\u0010\n\u001A\u00020\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b+\u0010,R\u0014\u0010\f\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b-\u0010(R\u0014\u0010\r\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b.\u0010(R\u0014\u0010\u000E\u001A\u00020\u000FX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b/\u00100R\u0014\u0010\u0010\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b1\u0010(R\u0013\u0010\u0011\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b2\u00103R\u0013\u0010\u0012\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b4\u00103R\u0011\u0010\u0013\u001A\u00020\u0014¢\u0006\b\n\u0000\u001A\u0004\b5\u00106R\u0011\u0010\u0015\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b7\u0010(R\u0011\u0010\u0016\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b8\u00100R\u0014\u0010\u0017\u001A\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b9\u0010:R\u000E\u0010\u0019\u001A\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001A\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b;\u00100R\u0017\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001A\u0004\b<\u0010&R\u0017\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001A\u0004\b=\u0010&R\u0011\u0010\u001D\u001A\u00020\u001E¢\u0006\b\n\u0000\u001A\u0004\b>\u0010?R\u0011\u0010\u001F\u001A\u00020 ¢\u0006\b\n\u0000\u001A\u0004\b@\u0010AR\u0013\u0010!\u001A\u00020\"¢\u0006\n\n\u0002\u0010D\u001A\u0004\bB\u0010CR\u0014\u0010E\u001A\u00020F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bG\u0010CR\u0014\u0010H\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bI\u0010(R\u0011\u0010J\u001A\u00020\u000F8F¢\u0006\u0006\u001A\u0004\bK\u00100R\u001E\u0010P\u001A\u000E\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020\u00070QX\u0096\u0005¢\u0006\u0006\u001A\u0004\bS\u0010TR\u0012\u0010U\u001A\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001A\u0004\bV\u0010(R\'\u0010W\u001A\u0015\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020O\u0018\u00010X¢\u0006\u0002\bZ8VX\u0096\u0005¢\u0006\u0006\u001A\u0004\b[\u0010\\R\u0012\u0010]\u001A\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001A\u0004\b^\u0010(¨\u0006_"}, d2={"Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "visiblePagesInfo", "", "Landroidx/compose/foundation/pager/MeasuredPage;", "pageSize", "", "pageSpacing", "afterContentPadding", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "viewportStartOffset", "viewportEndOffset", "reverseLayout", "", "beyondViewportPageCount", "firstVisiblePage", "currentPage", "currentPageOffsetFraction", "", "firstVisiblePageScrollOffset", "canScrollForward", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "measureResult", "remeasureNeeded", "extraPagesBefore", "extraPagesAfter", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "density", "Landroidx/compose/ui/unit/Density;", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(Ljava/util/List;IIILandroidx/compose/foundation/gestures/Orientation;IIZILandroidx/compose/foundation/pager/MeasuredPage;Landroidx/compose/foundation/pager/MeasuredPage;FIZLandroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/ui/layout/MeasureResult;ZLjava/util/List;Ljava/util/List;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/unit/Density;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getVisiblePagesInfo", "()Ljava/util/List;", "getPageSize", "()I", "getPageSpacing", "getAfterContentPadding", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getViewportStartOffset", "getViewportEndOffset", "getReverseLayout", "()Z", "getBeyondViewportPageCount", "getFirstVisiblePage", "()Landroidx/compose/foundation/pager/MeasuredPage;", "getCurrentPage", "getCurrentPageOffsetFraction", "()F", "getFirstVisiblePageScrollOffset", "getCanScrollForward", "getSnapPosition", "()Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "getRemeasureNeeded", "getExtraPagesBefore", "getExtraPagesAfter", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getChildConstraints-msEJaDk", "()J", "J", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "beforeContentPadding", "getBeforeContentPadding", "canScrollBackward", "getCanScrollBackward", "copyWithScrollDeltaWithoutRemeasure", "delta", "placeChildren", "", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "width", "getWidth", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PagerMeasureResult implements PagerLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final int beyondViewportPageCount;
    private final boolean canScrollForward;
    private final long childConstraints;
    private final CoroutineScope coroutineScope;
    private final MeasuredPage currentPage;
    private final float currentPageOffsetFraction;
    private final Density density;
    private final List extraPagesAfter;
    private final List extraPagesBefore;
    private final MeasuredPage firstVisiblePage;
    private final int firstVisiblePageScrollOffset;
    private final MeasureResult measureResult;
    private final Orientation orientation;
    private final int pageSize;
    private final int pageSpacing;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final SnapPosition snapPosition;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List visiblePagesInfo;

    static {
    }

    public PagerMeasureResult(List arg27, int arg28, int arg29, int arg30, Orientation arg31, int arg32, int arg33, boolean arg34, int arg35, MeasuredPage arg36, MeasuredPage arg37, float arg38, int arg39, boolean arg40, SnapPosition arg41, MeasureResult arg42, boolean arg43, List arg44, List arg45, CoroutineScope arg46, Density arg47, long arg48, int arg50, DefaultConstructorMarker arg51) {
        List v19 = (arg50 & 0x20000) != 0 ? CollectionsKt.emptyList() : arg44;
        List v20 = (arg50 & 0x40000) != 0 ? CollectionsKt.emptyList() : arg45;
        this(arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, v19, v20, arg46, arg47, arg48, null);
    }

    public PagerMeasureResult(List arg1, int arg2, int arg3, int arg4, Orientation arg5, int arg6, int arg7, boolean arg8, int arg9, MeasuredPage arg10, MeasuredPage arg11, float arg12, int arg13, boolean arg14, SnapPosition arg15, MeasureResult arg16, boolean arg17, List arg18, List arg19, CoroutineScope arg20, Density arg21, long arg22, DefaultConstructorMarker arg24) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22);
    }

    private PagerMeasureResult(List arg1, int arg2, int arg3, int arg4, Orientation arg5, int arg6, int arg7, boolean arg8, int arg9, MeasuredPage arg10, MeasuredPage arg11, float arg12, int arg13, boolean arg14, SnapPosition arg15, MeasureResult arg16, boolean arg17, List arg18, List arg19, CoroutineScope arg20, Density arg21, long arg22) {
        super();
        this.visiblePagesInfo = arg1;
        this.pageSize = arg2;
        this.pageSpacing = arg3;
        this.afterContentPadding = arg4;
        this.orientation = arg5;
        this.viewportStartOffset = arg6;
        this.viewportEndOffset = arg7;
        this.reverseLayout = arg8;
        this.beyondViewportPageCount = arg9;
        this.firstVisiblePage = arg10;
        this.currentPage = arg11;
        this.currentPageOffsetFraction = arg12;
        this.firstVisiblePageScrollOffset = arg13;
        this.canScrollForward = arg14;
        this.snapPosition = arg15;
        this.measureResult = arg16;
        this.remeasureNeeded = arg17;
        this.extraPagesBefore = arg18;
        this.extraPagesAfter = arg19;
        this.coroutineScope = arg20;
        this.density = arg21;
        this.childConstraints = arg22;
    }

    public final PagerMeasureResult copyWithScrollDeltaWithoutRemeasure(int arg33) {
        PagerMeasureResult v0 = this;
        int v1 = arg33;
        int v2 = v0.getPageSize() + v0.getPageSpacing();
        PagerMeasureResult v4 = null;
        if(!v0.remeasureNeeded && !v0.getVisiblePagesInfo().isEmpty() && v0.firstVisiblePage != null) {
            int v3 = v0.firstVisiblePageScrollOffset - v1;
            if(v3 >= 0 && v3 < v2) {
                float v3_1 = v2 != 0 ? (((float)v1)) / (((float)v2)) : 0f;
                float v5 = v0.currentPageOffsetFraction - v3_1;
                if(v0.currentPage == null) {
                    return v4;
                }

                if(v5 >= 0.5f) {
                    return v4;
                }

                if(v5 <= -0.5f) {
                    return v4;
                }

                Object v5_1 = CollectionsKt.first(v0.getVisiblePagesInfo());
                Object v6 = CollectionsKt.last(v0.getVisiblePagesInfo());
                if(v1 >= 0) {
                    if(Math.min(v0.getViewportStartOffset() - ((MeasuredPage)v5_1).getOffset(), v0.getViewportEndOffset() - ((MeasuredPage)v6).getOffset()) > v1) {
                        goto label_57;
                    }

                    return v4;
                }
                else if(Math.min(((MeasuredPage)v5_1).getOffset() + v2 - v0.getViewportStartOffset(), ((MeasuredPage)v6).getOffset() + v2 - v0.getViewportEndOffset()) > -v1) {
                }
                else {
                    return v4;
                }

            label_57:
                List v2_1 = v0.getVisiblePagesInfo();
                int v4_1 = v2_1.size();
                boolean v5_2 = false;
                int v6_1;
                for(v6_1 = 0; v6_1 < v4_1; ++v6_1) {
                    v2_1.get(v6_1).applyScrollDelta(v1);
                }

                v2_1 = v0.extraPagesBefore;
                v4_1 = v2_1.size();
                for(v6_1 = 0; v6_1 < v4_1; ++v6_1) {
                    v2_1.get(v6_1).applyScrollDelta(v1);
                }

                v2_1 = v0.extraPagesAfter;
                v4_1 = v2_1.size();
                for(v6_1 = 0; v6_1 < v4_1; ++v6_1) {
                    v2_1.get(v6_1).applyScrollDelta(v1);
                }

                List v8 = v0.getVisiblePagesInfo();
                int v9 = v0.getPageSize();
                int v10 = v0.getPageSpacing();
                int v11 = v0.getAfterContentPadding();
                Orientation v12 = v0.getOrientation();
                int v13 = v0.getViewportStartOffset();
                int v14 = v0.getViewportEndOffset();
                boolean v15 = v0.getReverseLayout();
                int v16 = v0.getBeyondViewportPageCount();
                MeasuredPage v2_2 = v0.firstVisiblePage;
                MeasuredPage v4_2 = v0.currentPage;
                float v19 = v0.currentPageOffsetFraction - v3_1;
                int v20 = v0.firstVisiblePageScrollOffset - v1;
                if((v0.canScrollForward) || v1 > 0) {
                    v5_2 = true;
                }

                return new PagerMeasureResult(v8, v9, v10, v11, v12, v13, v14, v15, v16, v2_2, v4_2, v19, v20, v5_2, v0.getSnapPosition(), v0.measureResult, v0.remeasureNeeded, v0.extraPagesBefore, v0.extraPagesAfter, v0.coroutineScope, v0.density, v0.childConstraints, null);
            }
        }

        return v4;
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

    public int getBeyondViewportPageCount() {
        return this.beyondViewportPageCount;
    }

    public final boolean getCanScrollBackward() {
        MeasuredPage v0 = this.firstVisiblePage;
        int v0_1 = v0 != null ? v0.getIndex() : 0;
        if(v0_1 == 0) {
            if(this.firstVisiblePageScrollOffset != 0) {
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

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final MeasuredPage getCurrentPage() {
        return this.currentPage;
    }

    public final float getCurrentPageOffsetFraction() {
        return this.currentPageOffsetFraction;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final List getExtraPagesAfter() {
        return this.extraPagesAfter;
    }

    public final List getExtraPagesBefore() {
        return this.extraPagesBefore;
    }

    public final MeasuredPage getFirstVisiblePage() {
        return this.firstVisiblePage;
    }

    public final int getFirstVisiblePageScrollOffset() {
        return this.firstVisiblePageScrollOffset;
    }

    public int getHeight() {
        return this.measureResult.getHeight();
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getPageSpacing() {
        return this.pageSpacing;
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

    public SnapPosition getSnapPosition() {
        return this.snapPosition;
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

    public List getVisiblePagesInfo() {
        return this.visiblePagesInfo;
    }

    public int getWidth() {
        return this.measureResult.getWidth();
    }

    public void placeChildren() {
        this.measureResult.placeChildren();
    }
}

