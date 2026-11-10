package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A4\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0017\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2={"rememberLazyListItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyListItemProviderKt {
    public static LazyListIntervalContent $r8$lambda$GQ63crjUVLvqXTyy49WzLdmrSNA(State arg0) {
        return LazyListItemProviderKt.rememberLazyListItemProviderLambda$lambda$0$0(arg0);
    }

    public static LazyListItemProviderImpl $r8$lambda$j65Hw0Tp5FiBazMiAUYUI-ewfzY(State arg0, LazyListState arg1, LazyItemScopeImpl arg2) {
        return LazyListItemProviderKt.rememberLazyListItemProviderLambda$lambda$0$1(arg0, arg1, arg2);
    }

    public static final Function0 rememberLazyListItemProviderLambda(LazyListState arg3, Function1 arg4, Composer arg5, int arg6) {
        int v1 = 0xEB8300AC;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(rememberLazyListItemProviderLambda)N(state,content)42@1692L29,43@1733L748:LazyListItemProvider.kt#428nma");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.foundation.lazy.rememberLazyListItemProviderLambda (LazyListItemProvider.kt:41)");
        }

        State v4 = SnapshotStateKt.rememberUpdatedState(arg4, arg5, arg6 >> 3 & 14);
        ComposerKt.sourceInformationMarkerStart(arg5, 382050776, "CC(remember):LazyListItemProvider.kt#9igjgp");
        v1 = 4;
        arg6 = (arg6 & 14 ^ 6) > v1 && (arg5.changed(arg3)) || (arg6 & 6) == v1 ? 1 : 0;
        Object v0 = arg5.rememberedValue();
        if(arg6 != 0 || v0 == Composer.Companion.getEmpty()) {
            LazyListItemProviderKt$rememberLazyListItemProviderLambda$1$1 v0_1 = new LazyListItemProviderKt$rememberLazyListItemProviderLambda$1$1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyListItemProviderKt$$ExternalSyntheticLambda1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyListItemProviderKt$$ExternalSyntheticLambda0(v4)), arg3, new LazyItemScopeImpl())));
            arg5.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return ((Function0)v0);
    }

    private static final LazyListIntervalContent rememberLazyListItemProviderLambda$lambda$0$0(State arg1) {
        return new LazyListIntervalContent(arg1.getValue());
    }

    private static final LazyListItemProviderImpl rememberLazyListItemProviderLambda$lambda$0$1(State arg3, LazyListState arg4, LazyItemScopeImpl arg5) {
        Object v3 = arg3.getValue();
        return new LazyListItemProviderImpl(arg4, ((LazyListIntervalContent)v3), arg5, new NearestRangeKeyIndexMap(arg4.getNearestRange$foundation(), v3));
    }
}

