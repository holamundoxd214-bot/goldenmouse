package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0012\u0010\u000B\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\nR\u0012\u0010\r\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\nR\u0014\u0010\u000F\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\nR\u0014\u0010\u001D\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\nR\u0014\u0010\u001F\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b \u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006!À\u0006\u0003"}, d2={"Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "getVisibleItemsInfo", "()Ljava/util/List;", "viewportStartOffset", "", "getViewportStartOffset", "()I", "viewportEndOffset", "getViewportEndOffset", "totalItemsCount", "getTotalItemsCount", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "getReverseLayout", "()Z", "beforeContentPadding", "getBeforeContentPadding", "afterContentPadding", "getAfterContentPadding", "mainAxisItemSpacing", "getMainAxisItemSpacing", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LazyListLayoutInfo {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static int getAfterContentPadding(LazyListLayoutInfo arg0) {
            return arg0.getAfterContentPadding();
        }

        @Deprecated public static int getBeforeContentPadding(LazyListLayoutInfo arg0) {
            return arg0.getBeforeContentPadding();
        }

        @Deprecated public static int getMainAxisItemSpacing(LazyListLayoutInfo arg0) {
            return arg0.getMainAxisItemSpacing();
        }

        @Deprecated public static Orientation getOrientation(LazyListLayoutInfo arg0) {
            return arg0.getOrientation();
        }

        @Deprecated public static boolean getReverseLayout(LazyListLayoutInfo arg0) {
            return arg0.getReverseLayout();
        }

        @Deprecated public static long getViewportSize-YbymL2g(LazyListLayoutInfo arg2) {
            return arg2.getViewportSize-YbymL2g();
        }
    }

    static int access$getAfterContentPadding$jd(LazyListLayoutInfo arg0) {
        return super.getAfterContentPadding();
    }

    static int access$getBeforeContentPadding$jd(LazyListLayoutInfo arg0) {
        return super.getBeforeContentPadding();
    }

    static int access$getMainAxisItemSpacing$jd(LazyListLayoutInfo arg0) {
        return super.getMainAxisItemSpacing();
    }

    static Orientation access$getOrientation$jd(LazyListLayoutInfo arg0) {
        return super.getOrientation();
    }

    static boolean access$getReverseLayout$jd(LazyListLayoutInfo arg0) {
        return super.getReverseLayout();
    }

    static long access$getViewportSize-YbymL2g$jd(LazyListLayoutInfo arg2) {
        return super.getViewportSize-YbymL2g();
    }

    default int getAfterContentPadding() {
        return 0;
    }

    default int getBeforeContentPadding() {
        return 0;
    }

    default int getMainAxisItemSpacing() {
        return 0;
    }

    default Orientation getOrientation() {
        return Orientation.Vertical;
    }

    default boolean getReverseLayout() {
        return 0;
    }

    int getTotalItemsCount();

    int getViewportEndOffset();

    default long getViewportSize-YbymL2g() {
        return IntSize.Companion.getZero-YbymL2g();
    }

    int getViewportStartOffset();

    List getVisibleItemsInfo();
}

