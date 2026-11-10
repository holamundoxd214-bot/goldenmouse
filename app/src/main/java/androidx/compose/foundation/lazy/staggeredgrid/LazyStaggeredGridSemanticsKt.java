package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u001A\u001D\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2={"rememberLazyStaggeredGridSemanticState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "reverseScrolling", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridSemanticsKt {
    public static final LazyLayoutSemanticState rememberLazyStaggeredGridSemanticState(LazyStaggeredGridState arg5, boolean arg6, Composer arg7, int arg8) {
        int v1 = 0x611DFB97;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(rememberLazyStaggeredGridSemanticState)N(state,reverseScrolling)31@1250L1315:LazyStaggeredGridSemantics.kt#fzvcnm");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridSemanticState (LazyStaggeredGridSemantics.kt:31)");
        }

        ComposerKt.sourceInformationMarkerStart(arg7, 0x918D88DA, "CC(remember):LazyStaggeredGridSemantics.kt#9igjgp");
        v1 = 0;
        int v3 = 4;
        int v0 = (arg8 & 14 ^ 6) > v3 && (arg7.changed(arg5)) || (arg8 & 6) == v3 ? 1 : 0;
        int v4 = 0x20;
        if((arg8 & 0x70 ^ 0x30) > v4 && (arg7.changed(arg6)) || (arg8 & 0x30) == v4) {
            v1 = 1;
        }

        Object v8 = arg7.rememberedValue();
        if((v0 | v1) != 0 || v8 == Composer.Companion.getEmpty()) {
            LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1 v8_1 = new LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1(arg5);
            arg7.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return ((LazyLayoutSemanticState)v8);
    }
}

