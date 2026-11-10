package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001A\u001D\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2={"rememberPagerBeyondBoundsState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "state", "Landroidx/compose/foundation/pager/PagerState;", "beyondViewportPageCount", "", "(Landroidx/compose/foundation/pager/PagerState;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PagerBeyondBoundsModifierKt {
    public static final LazyLayoutBeyondBoundsState rememberPagerBeyondBoundsState(PagerState arg5, int arg6, Composer arg7, int arg8) {
        PagerBeyondBoundsState v0_2;
        int v1 = 0x16440BEE;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(rememberPagerBeyondBoundsState)N(state,beyondViewportPageCount)26@977L111:PagerBeyondBoundsModifier.kt#g6yjnt");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.foundation.pager.rememberPagerBeyondBoundsState (PagerBeyondBoundsModifier.kt:25)");
        }

        ComposerKt.sourceInformationMarkerStart(arg7, 0x9570D9FD, "CC(remember):PagerBeyondBoundsModifier.kt#9igjgp");
        v1 = 0;
        int v3 = 4;
        int v0 = (arg8 & 14 ^ 6) > v3 && (arg7.changed(arg5)) || (arg8 & 6) == v3 ? 1 : 0;
        int v4 = 0x20;
        if((arg8 & 0x70 ^ 0x30) > v4 && (arg7.changed(arg6)) || (arg8 & 0x30) == v4) {
            v1 = 1;
        }

        arg8 = v0 | v1;
        Object v0_1 = arg7.rememberedValue();
        if(arg8 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            v0_2 = new PagerBeyondBoundsState(arg5, arg6);
            arg7.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return ((LazyLayoutBeyondBoundsState)v0_2);
    }
}

