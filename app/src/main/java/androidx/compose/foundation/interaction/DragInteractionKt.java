package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0017\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2={"collectIsDraggedAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DragInteractionKt {
    public static final State collectIsDraggedAsState(InteractionSource arg6, Composer arg7, int arg8) {
        int v1 = 0x6095CA1;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(collectIsDraggedAsState)78@2752L34,79@2812L492,79@2791L513:DragInteraction.kt#ywyzhk");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.foundation.interaction.collectIsDraggedAsState (DragInteraction.kt:77)");
        }

        String v1_1 = "CC(remember):DragInteraction.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg7, -1457208509, v1_1);
        Object v0 = arg7.rememberedValue();
        int v3 = 0;
        SnapshotMutationPolicy v4 = null;
        if(v0 == Composer.Companion.getEmpty()) {
            MutableState v0_1 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), v4, 2, v4);
            arg7.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        ComposerKt.sourceInformationMarkerStart(arg7, -1457206131, v1_1);
        v1 = arg8 & 14;
        int v5 = 4;
        if((v1 ^ 6) > v5 && (arg7.changed(arg6)) || (arg8 & 6) == v5) {
            v3 = 1;
        }

        Object v8 = arg7.rememberedValue();
        if(v3 != 0 || v8 == Composer.Companion.getEmpty()) {
            DragInteractionKt$collectIsDraggedAsState$1$1 v8_1 = new DragInteractionKt$collectIsDraggedAsState$1$1(arg6, ((MutableState)v0), ((Continuation)v4));
            arg7.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        EffectsKt.LaunchedEffect(arg6, ((Function2)v8), arg7, v1);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return ((State)v0);
    }
}

