package androidx.compose.material3.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\r\u0010\u0000\u001A\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001A-\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00012\b\b\u0002\u0010\u0006\u001A\u00020\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00040\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000B²\u0006\u0010\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00040\tX\u008A\u0084\u0002"}, d2={"rememberPredictiveBackState", "Landroidx/compose/material3/internal/PredictiveBackState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/internal/PredictiveBackState;", "PredictiveBackStateHandler", "", "state", "enabled", "", "onBack", "Lkotlin/Function0;", "(Landroidx/compose/material3/internal/PredictiveBackState;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "material3", "currentOnBack"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BasicEdgeToEdgeDialogKt {
    public static final void PredictiveBackStateHandler(PredictiveBackState arg8, boolean arg9, Function0 arg10, Composer arg11, int arg12, int arg13) {
        int v4;
        int v1;
        int v0 = 0x29A62A33;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(PredictiveBackStateHandler)N(state,enabled,onBack)92@3116L28:BasicEdgeToEdgeDialog.kt#mqatfk");
        int v2 = 4;
        if((arg13 & 1) != 0) {
            v1 = arg12 | 6;
        }
        else if((arg12 & 6) == 0) {
            boolean v1_1 = (arg12 & 8) == 0 ? arg11.changed(arg8) : arg11.changedInstance(arg8);
            v1 = v1_1 ? v2 : 2;
            v1 |= arg12;
        }
        else {
            v1 = arg12;
        }

        if((arg13 & 2) != 0) {
            v1 |= 0x30;
        }
        else if((arg12 & 0x30) == 0) {
            v4 = arg11.changed(arg9) ? 0x20 : 16;
            v1 |= v4;
        }

        if((arg13 & 4) != 0) {
            v1 |= 0x180;
        }
        else if((arg12 & 0x180) == 0) {
            v4 = arg11.changedInstance(arg10) ? 0x100 : 0x80;
            v1 |= v4;
        }

        int v7 = 1;
        boolean v4_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg11.shouldExecute(v4_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.internal.PredictiveBackStateHandler (BasicEdgeToEdgeDialog.kt:90)");
            }

            State v0_1 = SnapshotStateKt.rememberUpdatedState(arg10, arg11, v1 >> 6 & 14);
            arg11.startMovableGroup(0x58C49039, arg8);
            ComposerKt.sourceInformation(arg11, "96@3300L906,96@3212L994");
            Intrinsics.checkNotNull(arg8, "null cannot be cast to non-null type androidx.compose.material3.internal.PredictiveBackStateImpl");
            PredictiveBackState v3 = arg8;
            boolean v3_1 = 1 == 0 || ((((PredictiveBackStateImpl)v3).getValue() instanceof Completed)) ? false : true;
            ComposerKt.sourceInformationMarkerStart(arg11, 0x58C4A25D, "CC(remember):BasicEdgeToEdgeDialog.kt#9igjgp");
            if((v1 & 14) != v2 && ((v1 & 8) == 0 || !arg11.changedInstance(arg8))) {
                v7 = 0;
            }

            v1 = arg11.changed(v0_1) | v7;
            Object v2_1 = arg11.rememberedValue();
            if(v1 != 0 || v2_1 == Composer.Companion.getEmpty()) {
                BasicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1 v2_2 = new BasicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1(arg8, v0_1, null);
                arg11.updateRememberedValue(v2_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg11);
            BackHandler_androidKt.PredictiveBackHandler(v3_1, ((Function2)v2_1), arg11, 0, 0);
            arg11.endMovableGroup();
            if(!ComposerKt.isTraceInProgress()) {
                goto label_113;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_113:
        ScopeUpdateScope v9 = arg11.endRestartGroup();
        if(v9 != null) {
            v9.updateScope(new BasicEdgeToEdgeDialogKt$$ExternalSyntheticLambda0(arg8, true, arg10, arg12, arg13));
        }
    }

    private static final Function0 PredictiveBackStateHandler$lambda$1(State arg0) {
        return arg0.getValue();
    }

    static final Unit PredictiveBackStateHandler$lambda$3(PredictiveBackState arg6, boolean arg7, Function0 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        BasicEdgeToEdgeDialogKt.PredictiveBackStateHandler(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    public static final Function0 access$PredictiveBackStateHandler$lambda$1(State arg0) {
        return BasicEdgeToEdgeDialogKt.PredictiveBackStateHandler$lambda$1(arg0);
    }

    public static final PredictiveBackState rememberPredictiveBackState(Composer arg3, int arg4) {
        int v1 = 0x70431098;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(rememberPredictiveBackState)77@2674L42:BasicEdgeToEdgeDialog.kt#mqatfk");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.material3.internal.rememberPredictiveBackState (BasicEdgeToEdgeDialog.kt:77)");
        }

        ComposerKt.sourceInformationMarkerStart(arg3, 1807832194, "CC(remember):BasicEdgeToEdgeDialog.kt#9igjgp");
        Object v4 = arg3.rememberedValue();
        if(v4 == Composer.Companion.getEmpty()) {
            PredictiveBackStateImpl v4_1 = new PredictiveBackStateImpl();
            arg3.updateRememberedValue(v4_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((PredictiveBackState)v4);
    }
}

