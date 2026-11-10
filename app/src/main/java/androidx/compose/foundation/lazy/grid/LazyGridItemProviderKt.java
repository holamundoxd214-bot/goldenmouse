package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A4\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0017\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2={"rememberLazyGridItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyGridItemProviderKt {
    public static LazyGridIntervalContent $r8$lambda$-79MG9_1ciBbO96xaTHwA5RoFKk(State arg0) {
        return LazyGridItemProviderKt.rememberLazyGridItemProviderLambda$lambda$0$0(arg0);
    }

    public static LazyGridItemProviderImpl $r8$lambda$UkwXWb-wdGKFsTXPi_Ha1XwB85A(State arg0, LazyGridState arg1) {
        return LazyGridItemProviderKt.rememberLazyGridItemProviderLambda$lambda$0$1(arg0, arg1);
    }

    public static final Function0 rememberLazyGridItemProviderLambda(LazyGridState arg3, Function1 arg4, Composer arg5, int arg6) {
        LazyGridItemProviderKt$rememberLazyGridItemProviderLambda$1$1 v0_1;
        int v1 = -1898306282;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(rememberLazyGridItemProviderLambda)N(state,content)41@1638L29,42@1679L669:LazyGridItemProvider.kt#7791vq");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridItemProviderLambda (LazyGridItemProvider.kt:40)");
        }

        State v4 = SnapshotStateKt.rememberUpdatedState(arg4, arg5, arg6 >> 3 & 14);
        ComposerKt.sourceInformationMarkerStart(arg5, 1088770931, "CC(remember):LazyGridItemProvider.kt#9igjgp");
        v1 = 4;
        arg6 = (arg6 & 14 ^ 6) > v1 && (arg5.changed(arg3)) || (arg6 & 6) == v1 ? 1 : 0;
        Object v0 = arg5.rememberedValue();
        if(arg6 != 0 || v0 == Composer.Companion.getEmpty()) {
            v0_1 = new LazyGridItemProviderKt$rememberLazyGridItemProviderLambda$1$1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyGridItemProviderKt$$ExternalSyntheticLambda1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyGridItemProviderKt$$ExternalSyntheticLambda0(v4)), arg3)));
            arg5.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return ((Function0)v0_1);
    }

    private static final LazyGridIntervalContent rememberLazyGridItemProviderLambda$lambda$0$0(State arg1) {
        return new LazyGridIntervalContent(arg1.getValue());
    }

    private static final LazyGridItemProviderImpl rememberLazyGridItemProviderLambda$lambda$0$1(State arg3, LazyGridState arg4) {
        Object v3 = arg3.getValue();
        return new LazyGridItemProviderImpl(arg4, ((LazyGridIntervalContent)v3), new NearestRangeKeyIndexMap(arg4.getNearestRange$foundation(), v3));
    }
}

