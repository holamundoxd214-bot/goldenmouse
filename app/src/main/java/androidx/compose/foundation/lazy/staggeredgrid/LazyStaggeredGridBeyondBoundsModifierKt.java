package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0015\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2={"rememberLazyStaggeredGridBeyondBoundsState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridBeyondBoundsModifierKt {
    public static final LazyLayoutBeyondBoundsState rememberLazyStaggeredGridBeyondBoundsState(LazyStaggeredGridState arg3, Composer arg4, int arg5) {
        int v1 = 0xEA5BFC0B;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(rememberLazyStaggeredGridBeyondBoundsState)N(state)26@980L61:LazyStaggeredGridBeyondBoundsModifier.kt#fzvcnm");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridBeyondBoundsState (LazyStaggeredGridBeyondBoundsModifier.kt:25)");
        }

        ComposerKt.sourceInformationMarkerStart(arg4, -1018350264, "CC(remember):LazyStaggeredGridBeyondBoundsModifier.kt#9igjgp");
        v1 = 4;
        arg5 = (arg5 & 14 ^ 6) > v1 && (arg4.changed(arg3)) || (arg5 & 6) == v1 ? 1 : 0;
        Object v0 = arg4.rememberedValue();
        if(arg5 != 0 || v0 == Composer.Companion.getEmpty()) {
            LazyStaggeredGridBeyondBoundsState v0_1 = new LazyStaggeredGridBeyondBoundsState(arg3);
            arg4.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return ((LazyLayoutBeyondBoundsState)v0);
    }
}

