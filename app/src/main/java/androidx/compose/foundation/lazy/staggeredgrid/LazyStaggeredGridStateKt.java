package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001A!\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2={"rememberLazyStaggeredGridState", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridStateKt {
    public static LazyStaggeredGridState $r8$lambda$NwZpvzII4xxQiwu8OLtlAlrTgxk(int arg0, int arg1) {
        return LazyStaggeredGridStateKt.rememberLazyStaggeredGridState$lambda$0$0(arg0, arg1);
    }

    public static final LazyStaggeredGridState rememberLazyStaggeredGridState(int arg6, int arg7, Composer arg8, int arg9, int arg10) {
        LazyStaggeredGridStateKt$$ExternalSyntheticLambda0 v1_2;
        int v1 = 0x99AE3C4;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(rememberLazyStaggeredGridState)N(initialFirstVisibleItemIndex,initialFirstVisibleItemScrollOffset)80@4005L105,80@3950L160:LazyStaggeredGridState.kt#fzvcnm");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState (LazyStaggeredGridState.kt:80)");
        }

        Object[] v10 = new Object[0];
        Saver v0 = LazyStaggeredGridState.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart(arg8, 0xE711E2D, "CC(remember):LazyStaggeredGridState.kt#9igjgp");
        int v3 = 4;
        int v4 = 1;
        v1 = (arg9 & 14 ^ 6) > v3 && (arg8.changed(0)) || (arg9 & 6) == v3 ? 1 : 0;
        int v5 = 0x20;
        if((arg9 & 0x70 ^ 0x30) <= v5 || !arg8.changed(0)) {
            if((arg9 & 0x30) == v5) {
            }
            else {
                v4 = 0;
            }
        }

        arg9 = v1 | v4;
        Object v1_1 = arg8.rememberedValue();
        if(arg9 != 0 || v1_1 == Composer.Companion.getEmpty()) {
            v1_2 = new LazyStaggeredGridStateKt$$ExternalSyntheticLambda0(0, 0);
            arg8.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        Object v6 = RememberSaveableKt.rememberSaveable(v10, v0, ((Function0)v1_2), arg8, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return ((LazyStaggeredGridState)v6);
    }

    private static final LazyStaggeredGridState rememberLazyStaggeredGridState$lambda$0$0(int arg1, int arg2) {
        return new LazyStaggeredGridState(arg1, arg2);
    }
}

