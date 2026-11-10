package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u001A\u0017\u0010\u0003\u001A\u00020\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082\b\u001A\f\u0010\b\u001A\u00020\t*\u00020\nH\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"NearestItemsSlidingWindowSize", "", "NearestItemsExtraItemCount", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "currentAbsoluteScrollOffset", "", "Landroidx/compose/foundation/pager/PagerState;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PagerScrollPositionKt {
    public static final int NearestItemsExtraItemCount = 100;
    public static final int NearestItemsSlidingWindowSize = 30;

    public static final long currentAbsoluteScrollOffset(PagerState arg4) {
        return (((long)arg4.getCurrentPage())) * (((long)arg4.getPageSizeWithSpacing$foundation())) + MathKt.roundToLong(arg4.getCurrentPageOffsetFraction() * (((float)arg4.getPageSizeWithSpacing$foundation())));
    }

    private static final void debugLog(Function0 arg0) {
    }
}

