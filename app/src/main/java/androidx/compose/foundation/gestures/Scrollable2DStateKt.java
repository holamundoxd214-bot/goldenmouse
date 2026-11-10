package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u001A\u0010\u0000\u001A\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u001A!\u0010\u0005\u001A\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2={"Scrollable2DState", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "consumeScrollDelta", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "rememberScrollable2DState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/Scrollable2DState;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Scrollable2DStateKt {
    public static Offset $r8$lambda$VozlsmvRDviBRCQ1hB4MGvsyrl4(State arg0, Offset arg1) {
        return Scrollable2DStateKt.rememberScrollable2DState$lambda$0$0(arg0, arg1);
    }

    public static final Scrollable2DState Scrollable2DState(Function1 arg1) {
        return new DefaultScrollable2DState(arg1);
    }

    public static final Scrollable2DState rememberScrollable2DState(Function1 arg3, Composer arg4, int arg5) {
        Scrollable2DState v5_1;
        int v1 = 1315827064;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(rememberScrollable2DState)N(consumeScrollDelta)123@5880L40,124@5932L63:Scrollable2DState.kt#8bwon0");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.foundation.gestures.rememberScrollable2DState (Scrollable2DState.kt:122)");
        }

        State v3 = SnapshotStateKt.rememberUpdatedState(arg3, arg4, arg5 & 14);
        ComposerKt.sourceInformationMarkerStart(arg4, 0x6AA88457, "CC(remember):Scrollable2DState.kt#9igjgp");
        Object v5 = arg4.rememberedValue();
        if(v5 == Composer.Companion.getEmpty()) {
            v5_1 = Scrollable2DStateKt.Scrollable2DState(new Scrollable2DStateKt$$ExternalSyntheticLambda0(v3));
            arg4.updateRememberedValue(v5_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v5_1;
    }

    private static final Offset rememberScrollable2DState$lambda$0$0(State arg0, Offset arg1) {
        return arg0.getValue().invoke(arg1);
    }
}

