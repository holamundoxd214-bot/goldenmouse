package androidx.compose.runtime.retain;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A(\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00022\u0011\u0010\b\u001A\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000B\"\u0017\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004¨\u0006\f"}, d2={"LocalRetainedValuesStore", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/runtime/retain/RetainedValuesStore;", "getLocalRetainedValuesStore", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalRetainedValuesStoreProvider", "", "store", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/retain/RetainedValuesStore;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "runtime-retain"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LocalRetainedValuesStoreKt {
    private static final ProvidableCompositionLocal LocalRetainedValuesStore;

    static {
        LocalRetainedValuesStoreKt.LocalRetainedValuesStore = CompositionLocalKt.staticCompositionLocalOf(new LocalRetainedValuesStoreKt$$ExternalSyntheticLambda1());
    }

    static final RetainedValuesStore LocalRetainedValuesStore$lambda$0() {
        return ForgetfulRetainedValuesStore.INSTANCE;
    }

    public static final void LocalRetainedValuesStoreProvider(RetainedValuesStore arg7, Function2 arg8, Composer arg9, int arg10) {
        int v1_1;
        int v0 = 0xEAA1396D;
        arg9 = arg9.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg9, "C(LocalRetainedValuesStoreProvider)N(store,content)78@3847L74,83@4142L67:LocalRetainedValuesStore.kt#3my55w");
        int v2 = 4;
        if((arg10 & 6) == 0) {
            boolean v1 = (arg10 & 8) == 0 ? arg9.changed(arg7) : arg9.changedInstance(arg7);
            v1_1 = v1 ? v2 : 2;
            v1_1 |= arg10;
        }
        else {
            v1_1 = arg10;
        }

        if((arg10 & 0x30) == 0) {
            int v3 = arg9.changedInstance(arg8) ? 0x20 : 16;
            v1_1 |= v3;
        }

        int v5 = 0;
        boolean v3_1 = (v1_1 & 19) != 18 ? true : false;
        if(arg9.shouldExecute(v3_1, v1_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1_1, -1, "androidx.compose.runtime.retain.LocalRetainedValuesStoreProvider (LocalRetainedValuesStore.kt:77)");
            }

            CompositionLocalKt.CompositionLocalProvider(LocalRetainedValuesStoreKt.LocalRetainedValuesStore.provides(arg7), arg8, arg9, ProvidedValue.$stable | v1_1 & 0x70);
            ComposerKt.sourceInformationMarkerStart(arg9, 0xC738C5B0, "CC(remember):LocalRetainedValuesStore.kt#9igjgp");
            if((v1_1 & 14) == v2 || (v1_1 & 8) != 0 && (arg9.changed(arg7))) {
                v5 = 1;
            }

            Object v0_1 = arg9.rememberedValue();
            if(v5 != 0 || v0_1 == Composer.Companion.getEmpty()) {
                RetainContentPresenceIndicator v0_2 = new RetainContentPresenceIndicator(arg7, arg9);
                arg9.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg9);
            ((RetainContentPresenceIndicator)v0_1).setComposer(arg9);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_74;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg9.skipToGroupEnd();
        }

    label_74:
        ScopeUpdateScope v9 = arg9.endRestartGroup();
        if(v9 != null) {
            v9.updateScope(new LocalRetainedValuesStoreKt$$ExternalSyntheticLambda0(arg7, arg8, arg10));
        }
    }

    static final Unit LocalRetainedValuesStoreProvider$lambda$2(RetainedValuesStore arg0, Function2 arg1, int arg2, Composer arg3, int arg4) {
        LocalRetainedValuesStoreKt.LocalRetainedValuesStoreProvider(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public static final ProvidableCompositionLocal getLocalRetainedValuesStore() {
        return LocalRetainedValuesStoreKt.LocalRetainedValuesStore;
    }
}

