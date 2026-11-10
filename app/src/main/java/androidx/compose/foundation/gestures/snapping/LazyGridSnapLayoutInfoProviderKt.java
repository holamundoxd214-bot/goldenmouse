package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u001A\u001F\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\b\u001A\u0014\u0010\u000E\u001A\u00020\n*\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0000\u001A\u0014\u0010\u0012\u001A\u00020\n*\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0000\"\u0018\u0010\t\u001A\u00020\n*\u00020\u000B8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u0013"}, d2={"SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "lazyGridState", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;)I", "sizeOnMainAxis", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "offsetOnMainAxis", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyGridSnapLayoutInfoProviderKt {
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(LazyGridState arg1, SnapPosition arg2) {
        return new LazyGridSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1(arg1, arg2);
    }

    public static SnapLayoutInfoProvider SnapLayoutInfoProvider$default(LazyGridState arg0, SnapPosition arg1, int arg2, Object arg3) {
        Center v1;
        if((arg2 & 2) != 0) {
            v1 = Center.INSTANCE;
        }

        return LazyGridSnapLayoutInfoProviderKt.SnapLayoutInfoProvider(arg0, ((SnapPosition)v1));
    }

    public static final int getSingleAxisViewportSize(LazyGridLayoutInfo arg4) {
        long v0 = arg4.getOrientation() == Orientation.Vertical ? arg4.getViewportSize-YbymL2g() & 0xFFFFFFFFL : arg4.getViewportSize-YbymL2g() >> 0x20;
        return ((int)v0);
    }

    public static final int offsetOnMainAxis(LazyGridItemInfo arg1, Orientation arg2) {
        if(arg2 == Orientation.Vertical) {
            return IntOffset.getY-impl(arg1.getOffset-nOcc-ac());
        }

        return IntOffset.getX-impl(arg1.getOffset-nOcc-ac());
    }

    public static final FlingBehavior rememberSnapFlingBehavior(LazyGridState arg2, SnapPosition arg3, Composer arg4, int arg5, int arg6) {
        SnapLayoutInfoProvider v6_1;
        Center v3;
        int v1 = 0xF206D146;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(rememberSnapFlingBehavior)N(lazyGridState,snapPosition)116@4911L79,117@5002L41:LazyGridSnapLayoutInfoProvider.kt#ppz6w6");
        if((arg6 & 2) != 0) {
            v3 = Center.INSTANCE;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (LazyGridSnapLayoutInfoProvider.kt:114)");
        }

        ComposerKt.sourceInformationMarkerStart(arg4, 0x8B97AD75, "CC(remember):LazyGridSnapLayoutInfoProvider.kt#9igjgp");
        v1 = 4;
        arg5 = (arg5 & 14 ^ 6) > v1 && (arg4.changed(arg2)) || (arg5 & 6) == v1 ? 1 : 0;
        Object v6 = arg4.rememberedValue();
        if(arg5 != 0 || v6 == Composer.Companion.getEmpty()) {
            v6_1 = LazyGridSnapLayoutInfoProviderKt.SnapLayoutInfoProvider(arg2, ((SnapPosition)v3));
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

    public static final int sizeOnMainAxis(LazyGridItemInfo arg2, Orientation arg3) {
        long v2 = arg3 == Orientation.Vertical ? arg2.getSize-YbymL2g() & 0xFFFFFFFFL : arg2.getSize-YbymL2g() >> 0x20;
        return ((int)v2);
    }
}

