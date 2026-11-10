package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\r\u0010\u0000\u001A\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2={"rememberSaveableStateHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/saveable/SaveableStateHolder;", "runtime-saveable"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SaveableStateHolderKt {
    public static SaveableStateHolderImpl $r8$lambda$bh80QXkpjEQa2UqqZKCKlYJW4UI() {
        return SaveableStateHolderKt.rememberSaveableStateHolder$lambda$0$0();
    }

    public static final SaveableStateHolder rememberSaveableStateHolder(Composer arg3, int arg4) {
        SaveableStateHolderKt$$ExternalSyntheticLambda0 v1_2;
        int v1 = 0xEBD1AB;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(rememberSaveableStateHolder)57@2611L29,57@2555L85:SaveableStateHolder.kt#r2ddri");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.runtime.saveable.rememberSaveableStateHolder (SaveableStateHolder.kt:57)");
        }

        arg3.startReplaceGroup(1967007413);
        ComposerKt.sourceInformation(arg3, "*58@2715L7");
        Object[] v4 = new Object[0];
        Saver v0 = SaveableStateHolderImpl.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart(arg3, 1967006120, "CC(remember):SaveableStateHolder.kt#9igjgp");
        Object v1_1 = arg3.rememberedValue();
        if(v1_1 == Composer.Companion.getEmpty()) {
            v1_2 = new SaveableStateHolderKt$$ExternalSyntheticLambda0();
            arg3.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        Object v4_1 = RememberSaveableKt.rememberSaveable(v4, v0, ((Function0)v1_2), arg3, 0x180);
        ProvidableCompositionLocal v0_1 = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v0_2 = arg3.consume(((CompositionLocal)v0_1));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        ((SaveableStateHolderImpl)v4_1).setParentSaveableStateRegistry(((SaveableStateRegistry)v0_2));
        arg3.endReplaceGroup();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((SaveableStateHolder)v4_1);
    }

    private static final SaveableStateHolderImpl rememberSaveableStateHolder$lambda$0$0() {
        return new SaveableStateHolderImpl(null, 1, null);
    }
}

