package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u001A\u001D\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2={"rememberPagerSemanticState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "state", "Landroidx/compose/foundation/pager/PagerState;", "isVertical", "", "(Landroidx/compose/foundation/pager/PagerState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PagerSemanticsKt {
    public static final LazyLayoutSemanticState rememberPagerSemanticState(PagerState arg5, boolean arg6, Composer arg7, int arg8) {
        LazyLayoutSemanticState v0_2;
        int v1 = 0xD121569F;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(rememberPagerSemanticState)N(state,isVertical)27@957L74:PagerSemantics.kt#g6yjnt");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.foundation.pager.rememberPagerSemanticState (PagerSemantics.kt:26)");
        }

        ComposerKt.sourceInformationMarkerStart(arg7, 0xE263A29, "CC(remember):PagerSemantics.kt#9igjgp");
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
            v0_2 = LazyLayoutSemanticStateKt.LazyLayoutSemanticState(arg5, arg6);
            arg7.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return v0_2;
    }
}

