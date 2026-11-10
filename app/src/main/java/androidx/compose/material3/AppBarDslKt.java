package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\r\u0010\u0000\u001A\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2={"rememberAppBarOverflowState", "Landroidx/compose/material3/AppBarOverflowState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/AppBarOverflowState;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AppBarDslKt {
    public static final AppBarOverflowState rememberAppBarOverflowState(Composer arg3, int arg4) {
        AppBarDslKt$$ExternalSyntheticLambda0 v1_2;
        int v1 = 0xC81DDCF;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(rememberAppBarOverflowState)265@8053L29,265@7997L85:AppBarDsl.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.material3.rememberAppBarOverflowState (AppBarDsl.kt:264)");
        }

        Object[] v4 = new Object[0];
        Saver v0 = AppBarOverflowStateImpl.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart(arg3, -209602484, "CC(remember):AppBarDsl.kt#9igjgp");
        Object v1_1 = arg3.rememberedValue();
        if(v1_1 == Composer.Companion.getEmpty()) {
            v1_2 = new AppBarDslKt$$ExternalSyntheticLambda0();
            arg3.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        Object v4_1 = RememberSaveableKt.rememberSaveable(v4, v0, ((Function0)v1_2), arg3, 0x180);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((AppBarOverflowState)v4_1);
    }

    static final AppBarOverflowStateImpl rememberAppBarOverflowState$lambda$1$lambda$0() {
        return new AppBarOverflowStateImpl();
    }
}

