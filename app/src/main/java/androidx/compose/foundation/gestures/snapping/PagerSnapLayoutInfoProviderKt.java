package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.pager.PagerSnapDistance;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A8\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u001E\u0010\u0006\u001A\u001A\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u001A\u0014\u0010\t\u001A\u00020\n*\u00020\u00032\u0006\u0010\u000B\u001A\u00020\bH\u0002\u001A\f\u0010\f\u001A\u00020\b*\u00020\u0003H\u0002\u001A\u0017\u0010\r\u001A\u00020\u000E2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0082\b\u001A8\u0010\u0006\u001A\u00020\b2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\bH\u0000¨\u0006\u0018"}, d2={"SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "calculateFinalSnappingBound", "Lkotlin/Function3;", "", "isScrollingForward", "", "velocity", "dragGestureDelta", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "snapPositionalThreshold", "flingVelocity", "lowerBoundOffset", "upperBoundOffset", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PagerSnapLayoutInfoProviderKt {
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(PagerState arg1, PagerSnapDistance arg2, Function3 arg3) {
        return new PagerSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1(arg1, arg3, arg2);
    }

    public static final boolean access$isScrollingForward(PagerState arg0, float arg1) {
        return PagerSnapLayoutInfoProviderKt.isScrollingForward(arg0, arg1);
    }

    public static final float calculateFinalSnappingBound(PagerState arg4, LayoutDirection arg5, float arg6, float arg7, float arg8, float arg9) {
        boolean v0 = PagerSnapLayoutInfoProviderKt.isScrollingForward(arg4, arg7);
        if(arg4.getLayoutInfo().getOrientation() == Orientation.Vertical) {
        }
        else if(arg5 == LayoutDirection.Ltr) {
        }
        else if(!v0) {
            v0 = true;
        }
        else {
            v0 = false;
        }

        int v5 = arg4.getLayoutInfo().getPageSize();
        float v2 = v5 == 0 ? 0f : PagerSnapLayoutInfoProviderKt.dragGestureDelta(arg4) / (((float)v5));
        float v5_1 = v2 - (((float)(((int)v2))));
        int v7 = LazyListSnapLayoutInfoProviderKt.calculateFinalSnappingItem(arg4.getDensity$foundation(), arg7);
        if(FinalSnappingItem.equals-impl0(v7, FinalSnappingItem.Companion.getClosestItem-bbeMdSM())) {
            if(Math.abs(v5_1) > arg6) {
                if(v0) {
                    return arg9;
                }
            }
            else if(Math.abs(v2) >= Math.abs(arg4.getPositionThresholdFraction$foundation())) {
                if(v0) {
                }
                else {
                    return arg9;
                }
            }
            else if(Math.abs(arg8) < Math.abs(arg9)) {
            }
            else {
                return arg9;
            }
        }
        else if(FinalSnappingItem.equals-impl0(v7, FinalSnappingItem.Companion.getNextItem-bbeMdSM())) {
            return arg9;
        }
        else {
            if(FinalSnappingItem.equals-impl0(v7, FinalSnappingItem.Companion.getPreviousItem-bbeMdSM())) {
                return arg8;
            }

            return 0;
        }

        return arg8;
    }

    private static final void debugLog(Function0 arg0) {
    }

    private static final float dragGestureDelta(PagerState arg4) {
        if(arg4.getLayoutInfo().getOrientation() == Orientation.Horizontal) {
            return Float.intBitsToFloat(((int)(arg4.getUpDownDifference-F1C5BW0$foundation() >> 0x20)));
        }

        return Float.intBitsToFloat(((int)(arg4.getUpDownDifference-F1C5BW0$foundation() & 0xFFFFFFFFL)));
    }

    private static final boolean isScrollingForward(PagerState arg2, float arg3) {
        boolean v0 = arg2.getLayoutInfo().getReverseLayout();
        float v2 = arg2.isNotGestureAction$foundation() ? -arg3 : PagerSnapLayoutInfoProviderKt.dragGestureDelta(arg2);
        int v2_1 = Float.compare(v2, 0f) > 0 ? 1 : 0;
        if(v2_1 != 0 && (v0) || v2_1 == 0 && !v0) {
            return 1;
        }

        return 0;
    }
}

