package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u001A\u001F\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\b\u001A\u0019\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0000¢\u0006\u0002\u0010\u0013\"\u0018\u0010\t\u001A\u00020\n*\u00020\u000B8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u0014"}, d2={"SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;)I", "calculateFinalSnappingItem", "Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem;", "Landroidx/compose/ui/unit/Density;", "velocity", "", "(Landroidx/compose/ui/unit/Density;F)I", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyListSnapLayoutInfoProviderKt {
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(LazyListState arg1, SnapPosition arg2) {
        return new LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1(arg1, arg2);
    }

    public static SnapLayoutInfoProvider SnapLayoutInfoProvider$default(LazyListState arg0, SnapPosition arg1, int arg2, Object arg3) {
        Center v1;
        if((arg2 & 2) != 0) {
            v1 = Center.INSTANCE;
        }

        return LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider(arg0, ((SnapPosition)v1));
    }

    public static final int calculateFinalSnappingItem(Density arg2, float arg3) {
        if(Math.abs(arg3) < arg2.toPx-0680j_4(SnapFlingBehaviorKt.getMinFlingVelocityDp())) {
            return FinalSnappingItem.Companion.getClosestItem-bbeMdSM();
        }

        if(arg3 > 0f) {
            return FinalSnappingItem.Companion.getNextItem-bbeMdSM();
        }

        return FinalSnappingItem.Companion.getPreviousItem-bbeMdSM();
    }

    public static final int getSingleAxisViewportSize(LazyListLayoutInfo arg4) {
        long v0 = arg4.getOrientation() == Orientation.Vertical ? arg4.getViewportSize-YbymL2g() & 0xFFFFFFFFL : arg4.getViewportSize-YbymL2g() >> 0x20;
        return ((int)v0);
    }

    public static final FlingBehavior rememberSnapFlingBehavior(LazyListState arg2, SnapPosition arg3, Composer arg4, int arg5, int arg6) {
        SnapLayoutInfoProvider v6_1;
        Center v3;
        int v1 = 0xEBD10C96;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(rememberSnapFlingBehavior)N(lazyListState,snapPosition)117@4794L79,118@4885L41:LazyListSnapLayoutInfoProvider.kt#ppz6w6");
        if((arg6 & 2) != 0) {
            v3 = Center.INSTANCE;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (LazyListSnapLayoutInfoProvider.kt:115)");
        }

        ComposerKt.sourceInformationMarkerStart(arg4, 1002460357, "CC(remember):LazyListSnapLayoutInfoProvider.kt#9igjgp");
        v1 = 4;
        arg5 = (arg5 & 14 ^ 6) > v1 && (arg4.changed(arg2)) || (arg5 & 6) == v1 ? 1 : 0;
        Object v6 = arg4.rememberedValue();
        if(arg5 != 0 || v6 == Composer.Companion.getEmpty()) {
            v6_1 = LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider(arg2, ((SnapPosition)v3));
            arg4.updateRememberedValue(v6_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        TargetedFlingBehavior v2 = SnapFlingBehaviorKt.rememberSnapFlingBehavior(v6_1, arg4, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return ((FlingBehavior)v2);
    }
}

