package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A:\u0010\u0000\u001A\u00020\u00012\b\u0010\u0002\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0011\u0010\b\u001A\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000B¨\u0006\f"}, d2={"LazyLayoutPinnableItem", "", "key", "", "index", "", "pinnedItemList", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;ILandroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutPinnableItemKt {
    public static DisposableEffectResult $r8$lambda$5jm4A6PjFFmmZ7DFMctFagtkUsE(LazyLayoutPinnableItem arg0, DisposableEffectScope arg1) {
        return LazyLayoutPinnableItemKt.LazyLayoutPinnableItem$lambda$1$0(arg0, arg1);
    }

    public static final void LazyLayoutPinnableItem(Object arg7, int arg8, LazyLayoutPinnedItemList arg9, Function2 arg10, Composer arg11, int arg12) {
        LazyLayoutPinnableItemKt$$ExternalSyntheticLambda0 v2_4;
        int v2;
        int v1;
        int v0 = 0x340208E3;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(LazyLayoutPinnableItem)N(key,index,pinnedItemList,content)51@2044L77,53@2219L7,54@2262L43,54@2231L74,55@2310L89:LazyLayoutPinnableItem.kt#wow0x6");
        if((arg12 & 6) == 0) {
            v1 = arg11.changedInstance(arg7) ? 4 : 2;
            v1 |= arg12;
        }
        else {
            v1 = arg12;
        }

        if((arg12 & 0x30) == 0) {
            v2 = arg11.changed(arg8) ? 0x20 : 16;
            v1 |= v2;
        }

        if((arg12 & 0x180) == 0) {
            v2 = arg11.changedInstance(arg9) ? 0x100 : 0x80;
            v1 |= v2;
        }

        if((arg12 & 0xC00) == 0) {
            v2 = arg11.changedInstance(arg10) ? 0x800 : 0x400;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 0x493) != 1170 ? true : false;
        if(arg11.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem (LazyLayoutPinnableItem.kt:50)");
            }

            String v2_2 = "CC(remember):LazyLayoutPinnableItem.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(arg11, 1000567184, v2_2);
            v0 = arg11.changed(arg7) | arg11.changed(arg9);
            Object v3 = arg11.rememberedValue();
            if(v0 != 0 || v3 == Composer.Companion.getEmpty()) {
                LazyLayoutPinnableItem v3_1 = new LazyLayoutPinnableItem(arg7, arg9);
                arg11.updateRememberedValue(v3_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg11);
            ((LazyLayoutPinnableItem)v3).setIndex(arg8);
            ProvidableCompositionLocal v0_1 = PinnableContainerKt.getLocalPinnableContainer();
            ComposerKt.sourceInformationMarkerStart(arg11, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = arg11.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ((LazyLayoutPinnableItem)v3).setParentPinnableContainer(((PinnableContainer)v0_2));
            ComposerKt.sourceInformationMarkerStart(arg11, 1000574126, v2_2);
            boolean v0_3 = arg11.changed(v3);
            Object v2_3 = arg11.rememberedValue();
            if((v0_3) || v2_3 == Composer.Companion.getEmpty()) {
                v2_4 = new LazyLayoutPinnableItemKt$$ExternalSyntheticLambda0(((LazyLayoutPinnableItem)v3));
                arg11.updateRememberedValue(v2_4);
            }

            ComposerKt.sourceInformationMarkerEnd(arg11);
            EffectsKt.DisposableEffect(v3, ((Function1)v2_4), arg11, 0);
            CompositionLocalKt.CompositionLocalProvider(PinnableContainerKt.getLocalPinnableContainer().provides(v3), arg10, arg11, v1 >> 6 & 0x70 | ProvidedValue.$stable);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_101;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_101:
        ScopeUpdateScope v11 = arg11.endRestartGroup();
        if(v11 != null) {
            v11.updateScope(new LazyLayoutPinnableItemKt$$ExternalSyntheticLambda1(arg7, arg8, arg9, arg10, arg12));
        }
    }

    private static final DisposableEffectResult LazyLayoutPinnableItem$lambda$1$0(LazyLayoutPinnableItem arg0, DisposableEffectScope arg1) {
        return new LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$lambda$1$0$$inlined$onDispose$1(arg0);
    }

    static final Unit LazyLayoutPinnableItem$lambda$2(Object arg6, int arg7, LazyLayoutPinnedItemList arg8, Function2 arg9, int arg10, Composer arg11, int arg12) {
        LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(arg6, arg7, arg8, arg9, arg11, RecomposeScopeImplKt.updateChangedFlags(arg10 | 1));
        return Unit.INSTANCE;
    }
}

