package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.DensityKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A!\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001A+\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001A)\u0010\u0000\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000B\"\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u000E\u001A\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"rememberLazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/LazyListState;", "prefetchStrategy", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "(IILandroidx/compose/foundation/lazy/LazyListPrefetchStrategy;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/LazyListState;", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/LazyListState;", "EmptyLazyListMeasureResult", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "NumberOfItemsToTeleport", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyListStateKt {
    private static final LazyListMeasureResult EmptyLazyListMeasureResult = null;
    private static final int NumberOfItemsToTeleport = 100;

    public static LazyListState $r8$lambda$NyPfUbvPPDvChCjfsx626jbnIx8(int arg0, int arg1) {
        return LazyListStateKt.rememberLazyListState$lambda$0$0(arg0, arg1);
    }

    public static LazyListState $r8$lambda$PNNtKPuLDTP1steNVY3dDdrnOPs(LazyLayoutCacheWindow arg0, int arg1, int arg2) {
        return LazyListStateKt.rememberLazyListState$lambda$3$0(arg0, arg1, arg2);
    }

    public static LazyListState $r8$lambda$YOqKA7tOrhO3TREDmjC7WzLoFBo(int arg0, int arg1, LazyListPrefetchStrategy arg2) {
        return LazyListStateKt.rememberLazyListState$lambda$2$0(arg0, arg1, arg2);
    }

    static {
        LazyListStateKt.EmptyLazyListMeasureResult = new LazyListMeasureResult(null, 0, false, 0f, new LazyListStateKt$EmptyLazyListMeasureResult$1(), 0f, false, CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), DensityKt.Density$default(1f, 0f, 2, null), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), CollectionsKt.emptyList(), 0, 0, 0, false, Orientation.Vertical, 0, 0, null);
    }

    public static final LazyListMeasureResult access$getEmptyLazyListMeasureResult$p() {
        return LazyListStateKt.EmptyLazyListMeasureResult;
    }

    public static final LazyListState rememberLazyListState(int arg6, int arg7, Composer arg8, int arg9, int arg10) {
        LazyListStateKt$$ExternalSyntheticLambda0 v1_2;
        int v1 = 1470655220;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(rememberLazyListState)N(initialFirstVisibleItemIndex,initialFirstVisibleItemScrollOffset)79@3788L96,79@3742L142:LazyListState.kt#428nma");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.foundation.lazy.rememberLazyListState (LazyListState.kt:78)");
        }

        Object[] v10 = new Object[0];
        Saver v0 = LazyListState.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart(arg8, 0xF3996D4, "CC(remember):LazyListState.kt#9igjgp");
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
            v1_2 = new LazyListStateKt$$ExternalSyntheticLambda0(0, 0);
            arg8.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        Object v6 = RememberSaveableKt.rememberSaveable(v10, v0, ((Function0)v1_2), arg8, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return ((LazyListState)v6);
    }

    public static final LazyListState rememberLazyListState(int arg6, int arg7, LazyListPrefetchStrategy arg8, Composer arg9, int arg10, int arg11) {
        LazyListStateKt$$ExternalSyntheticLambda1 v0_2;
        int v1 = 1287535208;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(rememberLazyListState)N(initialFirstVisibleItemIndex,initialFirstVisibleItemScrollOffset,prefetchStrategy)101@4651L39,103@4804L161,103@4722L243:LazyListState.kt#428nma");
        int v0 = 4;
        String v3 = "CC(remember):LazyListState.kt#9igjgp";
        int v4 = 1;
        if((arg11 & v0) != 0) {
            ComposerKt.sourceInformationMarkerStart(arg9, 370759087, v3);
            Object v8 = arg9.rememberedValue();
            if(v8 == Composer.Companion.getEmpty()) {
                arg8 = LazyListPrefetchStrategyKt.LazyListPrefetchStrategy$default(0, 1, null);
                arg9.updateRememberedValue(arg8);
            }

            ComposerKt.sourceInformationMarkerEnd(arg9);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.foundation.lazy.rememberLazyListState (LazyListState.kt:102)");
        }

        Object[] v11 = new Object[]{arg8};
        Saver v1_1 = LazyListState.Companion.saver$foundation(arg8);
        ComposerKt.sourceInformationMarkerStart(arg9, 370764105, v3);
        v0 = (arg10 & 14 ^ 6) > v0 && (arg9.changed(0)) || (arg10 & 6) == v0 ? 1 : 0;
        int v5 = 0x20;
        int v3_1 = (arg10 & 0x70 ^ 0x30) > v5 && (arg9.changed(0)) || (arg10 & 0x30) == v5 ? 1 : 0;
        v0 |= v3_1;
        v5 = 0x100;
        if((arg10 & 0x380 ^ 0x180) <= v5 || !arg9.changedInstance(arg8)) {
            if((arg10 & 0x180) == v5) {
            }
            else {
                v4 = 0;
            }
        }

        arg10 = v0 | v4;
        Object v0_1 = arg9.rememberedValue();
        if(arg10 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            v0_2 = new LazyListStateKt$$ExternalSyntheticLambda1(0, 0, arg8);
            arg9.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        Object v6 = RememberSaveableKt.rememberSaveable(v11, v1_1, ((Function0)v0_2), arg9, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        return ((LazyListState)v6);
    }

    public static final LazyListState rememberLazyListState(LazyLayoutCacheWindow arg6, int arg7, int arg8, Composer arg9, int arg10, int arg11) {
        int v1 = 0x5EAF5B4C;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(rememberLazyListState)N(cacheWindow,initialFirstVisibleItemIndex,initialFirstVisibleItemScrollOffset)131@5838L156,131@5766L228:LazyListState.kt#428nma");
        int v0 = 4;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.foundation.lazy.rememberLazyListState (LazyListState.kt:130)");
        }

        Object[] v11 = new Object[]{arg6};
        Saver v1_1 = LazyListState.Companion.saver$foundation(arg6);
        ComposerKt.sourceInformationMarkerStart(arg9, 0x7045D9A8, "CC(remember):LazyListState.kt#9igjgp");
        int v4 = 1;
        v0 = (arg10 & 14 ^ 6) > v0 && (arg9.changed(arg6)) || (arg10 & 6) == v0 ? 1 : 0;
        int v5 = 0x20;
        int v3 = (arg10 & 0x70 ^ 0x30) > v5 && (arg9.changed(0)) || (arg10 & 0x30) == v5 ? 1 : 0;
        v0 |= v3;
        v5 = 0x100;
        if((arg10 & 0x380 ^ 0x180) <= v5 || !arg9.changed(0)) {
            if((arg10 & 0x180) == v5) {
            }
            else {
                v4 = 0;
            }
        }

        arg10 = v0 | v4;
        Object v0_1 = arg9.rememberedValue();
        if(arg10 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            LazyListStateKt$$ExternalSyntheticLambda2 v0_2 = new LazyListStateKt$$ExternalSyntheticLambda2(arg6, 0, 0);
            arg9.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        Object v6 = RememberSaveableKt.rememberSaveable(v11, v1_1, ((Function0)v0_1), arg9, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        return ((LazyListState)v6);
    }

    private static final LazyListState rememberLazyListState$lambda$0$0(int arg1, int arg2) {
        return new LazyListState(arg1, arg2);
    }

    private static final LazyListState rememberLazyListState$lambda$2$0(int arg1, int arg2, LazyListPrefetchStrategy arg3) {
        return new LazyListState(arg1, arg2, arg3);
    }

    private static final LazyListState rememberLazyListState$lambda$3$0(LazyLayoutCacheWindow arg1, int arg2, int arg3) {
        return new LazyListState(arg1, arg2, arg3);
    }
}

