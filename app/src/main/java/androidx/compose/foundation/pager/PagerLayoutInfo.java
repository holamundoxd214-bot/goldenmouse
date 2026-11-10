package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0012\u0010\u000B\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\nR\u0012\u0010\r\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\nR\u0012\u0010\u000F\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\nR\u0012\u0010\u0011\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\nR\u0012\u0010\u0013\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\nR\u0012\u0010\u0015\u001A\u00020\u0016X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001A\u00020\u001AX¦\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0018\u0010\u001D\u001A\u00020\u001EX¦\u0004¢\u0006\f\u0012\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"R\u0012\u0010#\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b$\u0010\nR\u0012\u0010%\u001A\u00020&X¦\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010(\u0082\u0001\u0001)ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006*À\u0006\u0001"}, d2={"Landroidx/compose/foundation/pager/PagerLayoutInfo;", "", "visiblePagesInfo", "", "Landroidx/compose/foundation/pager/PageInfo;", "getVisiblePagesInfo", "()Ljava/util/List;", "pageSize", "", "getPageSize", "()I", "pageSpacing", "getPageSpacing", "viewportStartOffset", "getViewportStartOffset", "viewportEndOffset", "getViewportEndOffset", "beforeContentPadding", "getBeforeContentPadding", "afterContentPadding", "getAfterContentPadding", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "getReverseLayout$annotations", "()V", "getReverseLayout", "()Z", "beyondViewportPageCount", "getBeyondViewportPageCount", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "getSnapPosition", "()Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PagerLayoutInfo {
    int getAfterContentPadding();

    int getBeforeContentPadding();

    int getBeyondViewportPageCount();

    Orientation getOrientation();

    int getPageSize();

    int getPageSpacing();

    boolean getReverseLayout();

    static void getReverseLayout$annotations() {
    }

    SnapPosition getSnapPosition();

    int getViewportEndOffset();

    long getViewportSize-YbymL2g();

    int getViewportStartOffset();

    List getVisiblePagesInfo();
}

