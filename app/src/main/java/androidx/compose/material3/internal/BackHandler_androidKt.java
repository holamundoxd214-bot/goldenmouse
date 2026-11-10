package androidx.compose.material3.internal;

import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.PredictiveBackHandlerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A%\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0001¢\u0006\u0002\u0010\b\u001AT\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052;\u0010\u0006\u001A7\b\u0001\u0012\u001D\u0012\u001B\u0012\b\u0012\u00060\u0001j\u0002`\f0\u000B¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\nH\u0001¢\u0006\u0002\u0010\u0012*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0013"}, d2={"BackEventCompat", "Landroidx/activity/BackEventCompat;", "BackHandler", "", "enabled", "", "onBack", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PredictiveBackHandler", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/material3/internal/BackEventCompat;", "Lkotlin/ParameterName;", "name", "progress", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BackHandler_androidKt {
    public static final void BackHandler(boolean arg7, Function0 arg8, Composer arg9, int arg10, int arg11) {
        int v2;
        int v0 = 0xB02DAF71;
        arg9 = arg9.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg9, "C(BackHandler)N(enabled,onBack)25@935L28:BackHandler.android.kt#mqatfk");
        if((arg11 & 1) != 0) {
            v2 = arg10 | 6;
        }
        else if((arg10 & 6) == 0) {
            v2 = arg9.changed(arg7) ? 4 : 2;
            v2 |= arg10;
        }
        else {
            v2 = arg10;
        }

        if((arg11 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((arg10 & 0x30) == 0) {
            int v3 = arg9.changedInstance(arg8) ? 0x20 : 16;
            v2 |= v3;
        }

        boolean v3_1 = (v2 & 19) != 18 ? true : false;
        if(arg9.shouldExecute(v3_1, v2 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.internal.BackHandler (BackHandler.android.kt:24)");
            }

            BackHandlerKt.BackHandler(true, arg8, arg9, v2 & 0x7E, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_55;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg9.skipToGroupEnd();
        }

    label_55:
        ScopeUpdateScope v9 = arg9.endRestartGroup();
        if(v9 != null) {
            v9.updateScope(new BackHandler_androidKt$$ExternalSyntheticLambda0(true, arg8, arg10, arg11));
        }
    }

    static final Unit BackHandler$lambda$0(boolean arg0, Function0 arg1, int arg2, int arg3, Composer arg4, int arg5) {
        BackHandler_androidKt.BackHandler(arg0, arg1, arg4, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1), arg3);
        return Unit.INSTANCE;
    }

    public static final void PredictiveBackHandler(boolean arg7, Function2 arg8, Composer arg9, int arg10, int arg11) {
        int v2;
        int v0 = 0xAA4B23BF;
        arg9 = arg9.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg9, "C(PredictiveBackHandler)N(enabled,onBack)33@1141L38:BackHandler.android.kt#mqatfk");
        if((arg11 & 1) != 0) {
            v2 = arg10 | 6;
        }
        else if((arg10 & 6) == 0) {
            v2 = arg9.changed(arg7) ? 4 : 2;
            v2 |= arg10;
        }
        else {
            v2 = arg10;
        }

        if((arg11 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((arg10 & 0x30) == 0) {
            int v3 = arg9.changedInstance(arg8) ? 0x20 : 16;
            v2 |= v3;
        }

        boolean v3_1 = (v2 & 19) != 18 ? true : false;
        if(arg9.shouldExecute(v3_1, v2 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.internal.PredictiveBackHandler (BackHandler.android.kt:32)");
            }

            PredictiveBackHandlerKt.PredictiveBackHandler(true, arg8, arg9, v2 & 0x7E, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_55;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg9.skipToGroupEnd();
        }

    label_55:
        ScopeUpdateScope v9 = arg9.endRestartGroup();
        if(v9 != null) {
            v9.updateScope(new BackHandler_androidKt$$ExternalSyntheticLambda1(true, arg8, arg10, arg11));
        }
    }

    static final Unit PredictiveBackHandler$lambda$1(boolean arg0, Function2 arg1, int arg2, int arg3, Composer arg4, int arg5) {
        BackHandler_androidKt.PredictiveBackHandler(arg0, arg1, arg4, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1), arg3);
        return Unit.INSTANCE;
    }
}

