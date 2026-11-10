package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A&\u0010\u0000\u001A\u00020\u00012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2={"LazySaveableStateHolderProvider", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazySaveableStateHolderKt {
    public static LazySaveableStateHolder $r8$lambda$FOE7NTRFNnu8lTPB5CEuARZY_8U(SaveableStateRegistry arg0, SaveableStateHolder arg1) {
        return LazySaveableStateHolderKt.LazySaveableStateHolderProvider$lambda$0$0(arg0, arg1);
    }

    public static final void LazySaveableStateHolderProvider(Function3 arg8, Composer arg9, int arg10) {
        LazySaveableStateHolderKt$$ExternalSyntheticLambda0 v7_1;
        int v1;
        int v0 = -709502251;
        arg9 = arg9.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg9, "C(LazySaveableStateHolderProvider)N(content)40@2007L7,41@2039L29,46@2234L91,43@2094L231,49@2399L19,49@2330L88:LazySaveableStateHolder.kt#wow0x6");
        int v2 = 2;
        if((arg10 & 6) == 0) {
            v1 = arg9.changedInstance(arg8) ? 4 : v2;
            v1 |= arg10;
        }
        else {
            v1 = arg10;
        }

        boolean v2_1 = (v1 & 3) != v2 ? true : false;
        if(arg9.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider (LazySaveableStateHolder.kt:39)");
            }

            ProvidableCompositionLocal v0_1 = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
            ComposerKt.sourceInformationMarkerStart(arg9, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = arg9.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(arg9);
            SaveableStateHolder v1_1 = SaveableStateHolderKt.rememberSaveableStateHolder(arg9, 0);
            Object[] v2_2 = new Object[]{v0_2};
            Saver v3 = LazySaveableStateHolder.Companion.saver(((SaveableStateRegistry)v0_2), v1_1);
            ComposerKt.sourceInformationMarkerStart(arg9, 0x3FAAA830, "CC(remember):LazySaveableStateHolder.kt#9igjgp");
            int v6 = arg9.changedInstance(v0_2) | arg9.changedInstance(v1_1);
            Object v7 = arg9.rememberedValue();
            if(v6 != 0 || v7 == Composer.Companion.getEmpty()) {
                v7_1 = new LazySaveableStateHolderKt$$ExternalSyntheticLambda0(((SaveableStateRegistry)v0_2), v1_1);
                arg9.updateRememberedValue(v7_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg9);
            v0_2 = RememberSaveableKt.rememberSaveable(v2_2, v3, ((Function0)v7_1), arg9, 0);
            CompositionLocalKt.CompositionLocalProvider(SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(v0_2), ComposableLambdaKt.rememberComposableLambda(-412824043, true, new LazySaveableStateHolderKt$$ExternalSyntheticLambda1(arg8, ((LazySaveableStateHolder)v0_2)), arg9, 54), arg9, ProvidedValue.$stable | 0x30);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_71;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg9.skipToGroupEnd();
        }

    label_71:
        ScopeUpdateScope v9 = arg9.endRestartGroup();
        if(v9 != null) {
            v9.updateScope(new LazySaveableStateHolderKt$$ExternalSyntheticLambda2(arg8, arg10));
        }
    }

    private static final LazySaveableStateHolder LazySaveableStateHolderProvider$lambda$0$0(SaveableStateRegistry arg2, SaveableStateHolder arg3) {
        return new LazySaveableStateHolder(arg2, MapsKt.emptyMap(), arg3);
    }

    static final Unit LazySaveableStateHolderProvider$lambda$1(Function3 arg4, LazySaveableStateHolder arg5, Composer arg6, int arg7) {
        ComposerKt.sourceInformation(arg6, "C49@2401L15:LazySaveableStateHolder.kt#wow0x6");
        boolean v0 = (arg7 & 3) != 2 ? true : false;
        if(arg6.shouldExecute(v0, arg7 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-412824043, arg7, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider.<anonymous> (LazySaveableStateHolder.kt:49)");
            }

            arg4.invoke(arg5, arg6, Integer.valueOf(0));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_25;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_25:
        return Unit.INSTANCE;
    }

    static final Unit LazySaveableStateHolderProvider$lambda$2(Function3 arg0, int arg1, Composer arg2, int arg3) {
        LazySaveableStateHolderKt.LazySaveableStateHolderProvider(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }
}

