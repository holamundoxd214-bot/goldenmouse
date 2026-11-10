package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.unit.DensityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A!\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001A+\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001A)\u0010\u0000\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000B\"\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"rememberLazyGridState", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/grid/LazyGridState;", "prefetchStrategy", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "(IILandroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/grid/LazyGridState;", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/grid/LazyGridState;", "EmptyLazyGridLayoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyGridStateKt {
    private static final LazyGridMeasureResult EmptyLazyGridLayoutInfo;

    public static LazyGridState $r8$lambda$3ixFdUCfZbLFklUSG46db99CeD8(LazyLayoutCacheWindow arg0, int arg1, int arg2) {
        return LazyGridStateKt.rememberLazyGridState$lambda$3$0(arg0, arg1, arg2);
    }

    public static LazyGridState $r8$lambda$TpLE_bjko8ZHnFp57NnN2I3cJf8(int arg0, int arg1, LazyGridPrefetchStrategy arg2) {
        return LazyGridStateKt.rememberLazyGridState$lambda$2$0(arg0, arg1, arg2);
    }

    public static LazyGridState $r8$lambda$dDu9Ax-PeFSz4-6rWgPOzyp7-sQ(int arg0, int arg1) {
        return LazyGridStateKt.rememberLazyGridState$lambda$0$0(arg0, arg1);
    }

    static {
        LazyGridStateKt.EmptyLazyGridLayoutInfo = new LazyGridMeasureResult(null, 0, false, 0f, new LazyGridStateKt$EmptyLazyGridLayoutInfo$1(), 0f, false, CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), DensityKt.Density$default(1f, 0f, 2, null), 0, new LazyGridStateKt$$ExternalSyntheticLambda3(), new LazyGridStateKt$$ExternalSyntheticLambda4(), CollectionsKt.emptyList(), 0, 0, 0, false, Orientation.Vertical, 0, 0);
    }

    static final List EmptyLazyGridLayoutInfo$lambda$0(int arg0) {
        return CollectionsKt.emptyList();
    }

    static final int EmptyLazyGridLayoutInfo$lambda$1(int arg0) {
        return -1;
    }

    public static final LazyGridMeasureResult access$getEmptyLazyGridLayoutInfo$p() {
        return LazyGridStateKt.EmptyLazyGridLayoutInfo;
    }

    public static final LazyGridState rememberLazyGridState(int arg6, int arg7, Composer arg8, int arg9, int arg10) {
        LazyGridStateKt$$ExternalSyntheticLambda1 v1_2;
        int v1 = 0x1BD5B8C;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(rememberLazyGridState)N(initialFirstVisibleItemIndex,initialFirstVisibleItemScrollOffset)80@3856L96,80@3810L142:LazyGridState.kt#7791vq");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:79)");
        }

        Object[] v10 = new Object[0];
        Saver v0 = LazyGridState.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart(arg8, -2016099988, "CC(remember):LazyGridState.kt#9igjgp");
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
            v1_2 = new LazyGridStateKt$$ExternalSyntheticLambda1(0, 0);
            arg8.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        Object v6 = RememberSaveableKt.rememberSaveable(v10, v0, ((Function0)v1_2), arg8, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return ((LazyGridState)v6);
    }

    public static final LazyGridState rememberLazyGridState(int arg6, int arg7, LazyGridPrefetchStrategy arg8, Composer arg9, int arg10, int arg11) {
        Object v8;
        int v1 = 0xFEC9B390;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(rememberLazyGridState)N(initialFirstVisibleItemIndex,initialFirstVisibleItemScrollOffset,prefetchStrategy)102@4719L39,104@4872L161,104@4790L243:LazyGridState.kt#7791vq");
        int v0 = 4;
        String v3 = "CC(remember):LazyGridState.kt#9igjgp";
        int v4 = 1;
        if((arg11 & v0) != 0) {
            ComposerKt.sourceInformationMarkerStart(arg9, 1932207319, v3);
            v8 = arg9.rememberedValue();
            if(v8 == Composer.Companion.getEmpty()) {
                arg8 = LazyGridPrefetchStrategyKt.LazyGridPrefetchStrategy$default(0, 1, null);
                arg9.updateRememberedValue(arg8);
            }

            ComposerKt.sourceInformationMarkerEnd(arg9);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:103)");
        }

        Object[] v11 = new Object[]{v8};
        Saver v1_1 = LazyGridState.Companion.saver$foundation(((LazyGridPrefetchStrategy)v8));
        ComposerKt.sourceInformationMarkerStart(arg9, 0x732B3871, v3);
        v0 = (arg10 & 14 ^ 6) > v0 && (arg9.changed(0)) || (arg10 & 6) == v0 ? 1 : 0;
        int v5 = 0x20;
        int v3_1 = (arg10 & 0x70 ^ 0x30) > v5 && (arg9.changed(0)) || (arg10 & 0x30) == v5 ? 1 : 0;
        v0 |= v3_1;
        v5 = 0x100;
        if((arg10 & 0x380 ^ 0x180) <= v5 || !arg9.changedInstance(v8)) {
            if((arg10 & 0x180) == v5) {
            }
            else {
                v4 = 0;
            }
        }

        arg10 = v0 | v4;
        Object v0_1 = arg9.rememberedValue();
        if(arg10 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            LazyGridStateKt$$ExternalSyntheticLambda2 v0_2 = new LazyGridStateKt$$ExternalSyntheticLambda2(0, 0, ((LazyGridPrefetchStrategy)v8));
            arg9.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        Object v6 = RememberSaveableKt.rememberSaveable(v11, v1_1, ((Function0)v0_1), arg9, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        return ((LazyGridState)v6);
    }

    public static final LazyGridState rememberLazyGridState(LazyLayoutCacheWindow arg6, int arg7, int arg8, Composer arg9, int arg10, int arg11) {
        int v1 = 0xA45E9034;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(rememberLazyGridState)N(cacheWindow,initialFirstVisibleItemIndex,initialFirstVisibleItemScrollOffset)132@5906L156,132@5834L228:LazyGridState.kt#7791vq");
        int v0 = 4;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:131)");
        }

        Object[] v11 = new Object[]{arg6};
        Saver v1_1 = LazyGridState.Companion.saver$foundation(arg6);
        ComposerKt.sourceInformationMarkerStart(arg9, 0x6FB7490, "CC(remember):LazyGridState.kt#9igjgp");
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
            LazyGridStateKt$$ExternalSyntheticLambda0 v0_2 = new LazyGridStateKt$$ExternalSyntheticLambda0(arg6, 0, 0);
            arg9.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        Object v6 = RememberSaveableKt.rememberSaveable(v11, v1_1, ((Function0)v0_1), arg9, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        return ((LazyGridState)v6);
    }

    private static final LazyGridState rememberLazyGridState$lambda$0$0(int arg1, int arg2) {
        return new LazyGridState(arg1, arg2);
    }

    private static final LazyGridState rememberLazyGridState$lambda$2$0(int arg1, int arg2, LazyGridPrefetchStrategy arg3) {
        return new LazyGridState(arg1, arg2, arg3);
    }

    private static final LazyGridState rememberLazyGridState$lambda$3$0(LazyLayoutCacheWindow arg1, int arg2, int arg3) {
        return new LazyGridState(arg1, arg2, arg3);
    }
}

