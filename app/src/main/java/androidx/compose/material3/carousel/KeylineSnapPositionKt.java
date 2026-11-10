package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.snapping.SnapPosition;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A \u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0000\u001A\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0000¨\u0006\n"}, d2={"getSnapPositionOffset", "", "strategy", "Landroidx/compose/material3/carousel/Strategy;", "itemIndex", "itemCount", "KeylineSnapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageSize", "Landroidx/compose/material3/carousel/CarouselPageSize;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class KeylineSnapPositionKt {
    public static final SnapPosition KeylineSnapPosition(CarouselPageSize arg1) {
        return new KeylineSnapPositionKt$KeylineSnapPosition$1(arg1);
    }

    public static final int getSnapPositionOffset(Strategy arg5, int arg6, int arg7) {
        if(!arg5.isValid()) {
            return 0;
        }

        float v3 = 2f;
        int v0 = MathKt.roundToInt(arg5.getDefaultKeylines().getFirstFocal().getUnadjustedOffset() - arg5.getItemMainAxisSize() / v3);
        if(arg6 <= CollectionsKt.getLastIndex(arg5.getStartKeylineSteps())) {
            v0 = MathKt.roundToInt(arg5.getStartKeylineSteps().get(RangesKt.coerceIn(CollectionsKt.getLastIndex(arg5.getStartKeylineSteps()) - arg6, 0, CollectionsKt.getLastIndex(arg5.getStartKeylineSteps()))).getFirstFocal().getUnadjustedOffset() - arg5.getItemMainAxisSize() / v3);
        }

        int v2 = arg7 - 1;
        if(arg6 >= v2 - CollectionsKt.getLastIndex(arg5.getEndKeylineSteps()) && arg7 > arg5.getDefaultKeylines().getFocalCount()) {
            return MathKt.roundToInt(arg5.getEndKeylineSteps().get(RangesKt.coerceIn(CollectionsKt.getLastIndex(arg5.getEndKeylineSteps()) - (v2 - arg6), 0, CollectionsKt.getLastIndex(arg5.getEndKeylineSteps()))).getFirstFocal().getUnadjustedOffset() - arg5.getItemMainAxisSize() / v3);
        }

        return v0;
    }
}

