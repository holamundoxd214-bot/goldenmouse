package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A4\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0017\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2={"rememberStaggeredGridItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridItemProviderKt {
    public static LazyStaggeredGridItemProviderImpl $r8$lambda$2xiuuK4rT1NnGErDa6RKAHKg5cg(State arg0, LazyStaggeredGridState arg1) {
        return LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda$lambda$0$1(arg0, arg1);
    }

    public static LazyStaggeredGridIntervalContent $r8$lambda$GYZnHYxfojEfNqCBvtQ8M8m2-3E(State arg0) {
        return LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda$lambda$0$0(arg0);
    }

    public static final Function0 rememberStaggeredGridItemProviderLambda(LazyStaggeredGridState arg3, Function1 arg4, Composer arg5, int arg6) {
        LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProviderLambda$1$1 v0_1;
        int v1 = 690901732;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(rememberStaggeredGridItemProviderLambda)N(state,content)38@1584L29,39@1625L687:LazyStaggeredGridItemProvider.kt#fzvcnm");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridItemProviderLambda (LazyStaggeredGridItemProvider.kt:37)");
        }

        State v4 = SnapshotStateKt.rememberUpdatedState(arg4, arg5, arg6 >> 3 & 14);
        ComposerKt.sourceInformationMarkerStart(arg5, 0x96E549D3, "CC(remember):LazyStaggeredGridItemProvider.kt#9igjgp");
        v1 = 4;
        arg6 = (arg6 & 14 ^ 6) > v1 && (arg5.changed(arg3)) || (arg6 & 6) == v1 ? 1 : 0;
        Object v0 = arg5.rememberedValue();
        if(arg6 != 0 || v0 == Composer.Companion.getEmpty()) {
            v0_1 = new LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProviderLambda$1$1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyStaggeredGridItemProviderKt$$ExternalSyntheticLambda1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyStaggeredGridItemProviderKt$$ExternalSyntheticLambda0(v4)), arg3)));
            arg5.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return ((Function0)v0_1);
    }

    private static final LazyStaggeredGridIntervalContent rememberStaggeredGridItemProviderLambda$lambda$0$0(State arg1) {
        return new LazyStaggeredGridIntervalContent(arg1.getValue());
    }

    private static final LazyStaggeredGridItemProviderImpl rememberStaggeredGridItemProviderLambda$lambda$0$1(State arg3, LazyStaggeredGridState arg4) {
        Object v3 = arg3.getValue();
        return new LazyStaggeredGridItemProviderImpl(arg4, ((LazyStaggeredGridIntervalContent)v3), new NearestRangeKeyIndexMap(arg4.getNearestRange$foundation(), v3));
    }
}

