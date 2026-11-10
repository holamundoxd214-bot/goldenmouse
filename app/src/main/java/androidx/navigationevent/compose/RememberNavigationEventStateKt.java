package androidx.navigationevent.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.navigationevent.NavigationEventInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001AE\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001A\u0002H\u00022\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00062\u000E\b\u0002\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2={"rememberNavigationEventState", "Landroidx/navigationevent/compose/NavigationEventState;", "T", "Landroidx/navigationevent/NavigationEventInfo;", "currentInfo", "backInfo", "", "forwardInfo", "(Landroidx/navigationevent/NavigationEventInfo;Ljava/util/List;Ljava/util/List;Landroidx/compose/runtime/Composer;II)Landroidx/navigationevent/compose/NavigationEventState;", "navigationevent-compose"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RememberNavigationEventStateKt {
    public static final NavigationEventState rememberNavigationEventState(NavigationEventInfo arg3, List arg4, List arg5, Composer arg6, int arg7, int arg8) {
        RememberNavigationEventStateKt$$ExternalSyntheticLambda0 v0_2;
        NavigationEventState v8_1;
        int v1 = 0x6F3602A;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(rememberNavigationEventState)N(currentInfo,backInfo,forwardInfo)45@1902L69,46@1987L121,46@1976L132:RememberNavigationEventState.kt#wc8b4r");
        if((arg8 & 2) != 0) {
            arg4 = CollectionsKt.emptyList();
        }

        int v0 = 4;
        if((arg8 & v0) != 0) {
            arg5 = CollectionsKt.emptyList();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.navigationevent.compose.rememberNavigationEventState (RememberNavigationEventState.kt:44)");
        }

        String v1_1 = "CC(remember):RememberNavigationEventState.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg6, 0x179C198F, v1_1);
        Object v8 = arg6.rememberedValue();
        if(v8 == Composer.Companion.getEmpty()) {
            v8_1 = new NavigationEventState(arg3, arg4, arg5);
            arg6.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        ComposerKt.sourceInformationMarkerStart(arg6, 396108899, v1_1);
        arg7 = (arg7 & 14 ^ 6) > v0 && (arg6.changedInstance(arg3)) || (arg7 & 6) == v0 ? 1 : 0;
        arg7 = arg7 | arg6.changedInstance(arg4) | arg6.changedInstance(arg5);
        Object v0_1 = arg6.rememberedValue();
        if(arg7 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            v0_2 = new RememberNavigationEventStateKt$$ExternalSyntheticLambda0(v8_1, arg3, arg4, arg5);
            arg6.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        EffectsKt.SideEffect(((Function0)v0_2), arg6, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return v8_1;
    }

    static final Unit rememberNavigationEventState$lambda$2$lambda$1(NavigationEventState arg0, NavigationEventInfo arg1, List arg2, List arg3) {
        arg0.setCurrentInfo$navigationevent_compose(arg1);
        arg0.setBackInfo$navigationevent_compose(arg2);
        arg0.setForwardInfo$navigationevent_compose(arg3);
        return Unit.INSTANCE;
    }
}

