package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0014\u0010\u0005\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0001H\u0000\"\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2={"mainAxisViewportSize", "", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getMainAxisViewportSize", "(Landroidx/compose/foundation/pager/PagerLayoutInfo;)I", "calculateContentSize", "pageCount", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PagerLayoutInfoKt {
    public static final int calculateContentSize(PagerLayoutInfo arg7, int arg8) {
        int v0 = arg7.getBeforeContentPadding() + arg7.getAfterContentPadding();
        if(arg8 == 0) {
            return v0;
        }

        long v3 = ((long)arg8);
        long v1 = (((long)arg7.getPageSize())) * v3 + (v3 - 1) * (((long)arg7.getPageSpacing())) + (((long)v0));
        long v7 = 0x7FFFFFFF;
        if(v1 > v7) {
            v1 = v7;
        }

        return ((int)v1);
    }

    public static final int getMainAxisViewportSize(PagerLayoutInfo arg4) {
        long v0 = arg4.getOrientation() == Orientation.Vertical ? arg4.getViewportSize-YbymL2g() & 0xFFFFFFFFL : arg4.getViewportSize-YbymL2g() >> 0x20;
        return ((int)v0);
    }
}

