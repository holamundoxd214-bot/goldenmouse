package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001A\u001A\u0010\u0000\u001A\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u001A!\u0010\u0005\u001A\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2={"ScrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "consumeScrollDelta", "Lkotlin/Function1;", "", "rememberScrollableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/ScrollableState;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ScrollableStateKt {
    public static float $r8$lambda$-nIndNxwTv7CO9DphDZcKG_DD_U(State arg0, float arg1) {
        return ScrollableStateKt.rememberScrollableState$lambda$0$0(arg0, arg1);
    }

    public static final ScrollableState ScrollableState(Function1 arg1) {
        return new DefaultScrollableState(arg1);
    }

    public static final ScrollableState rememberScrollableState(Function1 arg3, Composer arg4, int arg5) {
        ScrollableState v5_1;
        int v1 = -180460798;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(rememberScrollableState)N(consumeScrollDelta)170@8013L40,171@8065L61:ScrollableState.kt#8bwon0");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.foundation.gestures.rememberScrollableState (ScrollableState.kt:169)");
        }

        State v3 = SnapshotStateKt.rememberUpdatedState(arg3, arg4, arg5 & 14);
        ComposerKt.sourceInformationMarkerStart(arg4, 0x9F31BE9F, "CC(remember):ScrollableState.kt#9igjgp");
        Object v5 = arg4.rememberedValue();
        if(v5 == Composer.Companion.getEmpty()) {
            v5_1 = ScrollableStateKt.ScrollableState(new ScrollableStateKt$$ExternalSyntheticLambda0(v3));
            arg4.updateRememberedValue(v5_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v5_1;
    }

    private static final float rememberScrollableState$lambda$0$0(State arg0, float arg1) {
        return arg0.getValue().invoke(Float.valueOf(arg1)).floatValue();
    }
}

