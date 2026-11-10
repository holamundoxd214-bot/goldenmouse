package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R,\u0010\u0004\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u00058G¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/material3/SwipeToDismissBoxDefaults;", "", "<init>", "()V", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "getPositionalThreshold", "(Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function1;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SwipeToDismissBoxDefaults {
    public static final int $stable;
    public static final SwipeToDismissBoxDefaults INSTANCE;

    static {
        SwipeToDismissBoxDefaults.INSTANCE = new SwipeToDismissBoxDefaults();
    }

    private SwipeToDismissBoxDefaults() {
        super();
    }

    static final float _get_positionalThreshold_$lambda$2$lambda$1$lambda$0(Density arg0, float arg1) {
        return arg0.toPx-0680j_4(Dp.constructor-impl(56f));
    }

    public final Function1 getPositionalThreshold(Composer arg3, int arg4) {
        int v0 = 0x5C23F999;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-positionalThreshold>)362@15187L7:SwipeToDismissBox.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.SwipeToDismissBoxDefaults.<get-positionalThreshold> (SwipeToDismissBox.kt:362)");
        }

        arg3.startReplaceGroup(0xE30BFA08);
        ComposerKt.sourceInformation(arg3, "*362@15198L16");
        ProvidableCompositionLocal v2 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v2_1 = arg3.consume(((CompositionLocal)v2));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        ComposerKt.sourceInformationMarkerStart(arg3, 0x2E672AFC, "CC(remember):SwipeToDismissBox.kt#9igjgp");
        boolean v4 = arg3.changed(v2_1);
        Object v0_1 = arg3.rememberedValue();
        if((v4) || v0_1 == Composer.Companion.getEmpty()) {
            SwipeToDismissBoxDefaults$$ExternalSyntheticLambda0 v0_2 = new SwipeToDismissBoxDefaults$$ExternalSyntheticLambda0(((Density)v2_1));
            arg3.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        arg3.endReplaceGroup();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((Function1)v0_1);
    }
}

