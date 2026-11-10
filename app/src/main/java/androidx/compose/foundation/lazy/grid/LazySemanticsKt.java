package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u001A\u001D\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2={"rememberLazyGridSemanticState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "reverseScrolling", "", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazySemanticsKt {
    public static final LazyLayoutSemanticState rememberLazyGridSemanticState(LazyGridState arg5, boolean arg6, Composer arg7, int arg8) {
        int v1 = -1247008005;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(rememberLazyGridSemanticState)N(state,reverseScrolling)31@1223L1455:LazySemantics.kt#7791vq");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridSemanticState (LazySemantics.kt:31)");
        }

        ComposerKt.sourceInformationMarkerStart(arg7, 0xFB4D6D8A, "CC(remember):LazySemantics.kt#9igjgp");
        v1 = 0;
        int v3 = 4;
        int v0 = (arg8 & 14 ^ 6) > v3 && (arg7.changed(arg5)) || (arg8 & 6) == v3 ? 1 : 0;
        int v4 = 0x20;
        if((arg8 & 0x70 ^ 0x30) > v4 && (arg7.changed(arg6)) || (arg8 & 0x30) == v4) {
            v1 = 1;
        }

        Object v8 = arg7.rememberedValue();
        if((v0 | v1) != 0 || v8 == Composer.Companion.getEmpty()) {
            LazySemanticsKt$rememberLazyGridSemanticState$1$1 v8_1 = new LazySemanticsKt$rememberLazyGridSemanticState$1$1(arg5);
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

