package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A0\u0010\u0000\u001A\u00020\u00012!\u0010\u0002\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0003H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2={"WindowFocusObserver", "", "onWindowFocusChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isWindowFocused", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WindowInfoKt {
    public static final void WindowFocusObserver(Function1 arg5, Composer arg6, int arg7) {
        int v1;
        int v0 = 0x79E8727;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(WindowFocusObserver)68@2941L7,69@2968L42,70@3042L90,70@3015L117:WindowInfo.kt#itgzvw");
        int v2 = 2;
        if((arg7 & 6) == 0) {
            v1 = arg6.changedInstance(arg5) ? 4 : v2;
            v1 |= arg7;
        }
        else {
            v1 = arg7;
        }

        boolean v2_1 = (v1 & 3) != v2 ? true : false;
        if(arg6.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.ui.platform.WindowFocusObserver (WindowInfo.kt:67)");
            }

            ProvidableCompositionLocal v0_1 = CompositionLocalsKt.getLocalWindowInfo();
            ComposerKt.sourceInformationMarkerStart(arg6, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = arg6.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(arg6);
            State v1_1 = SnapshotStateKt.rememberUpdatedState(arg5, arg6, v1 & 14);
            ComposerKt.sourceInformationMarkerStart(arg6, -1709607551, "CC(remember):WindowInfo.kt#9igjgp");
            v2 = arg6.changed(v0_2) | arg6.changed(v1_1);
            Object v3 = arg6.rememberedValue();
            if(v2 != 0 || v3 == Composer.Companion.getEmpty()) {
                WindowInfoKt$WindowFocusObserver$1$1 v3_1 = new WindowInfoKt$WindowFocusObserver$1$1(((WindowInfo)v0_2), v1_1, null);
                arg6.updateRememberedValue(v3_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg6);
            EffectsKt.LaunchedEffect(v0_2, ((Function2)v3), arg6, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_60;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_60:
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new WindowInfoKt$WindowFocusObserver$2(arg5, arg7));
        }
    }
}

