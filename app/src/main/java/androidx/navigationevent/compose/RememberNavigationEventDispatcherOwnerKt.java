package androidx.navigationevent.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\u001A#\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2={"rememberNavigationEventDispatcherOwner", "Landroidx/navigationevent/NavigationEventDispatcherOwner;", "enabled", "", "parent", "(ZLandroidx/navigationevent/NavigationEventDispatcherOwner;Landroidx/compose/runtime/Composer;II)Landroidx/navigationevent/NavigationEventDispatcherOwner;", "navigationevent-compose"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RememberNavigationEventDispatcherOwnerKt {
    public static final NavigationEventDispatcherOwner rememberNavigationEventDispatcherOwner(boolean arg8, NavigationEventDispatcherOwner arg9, Composer arg10, int arg11, int arg12) {
        NavigationEventDispatcher v3_1;
        int v1 = 0xEBEF554B;
        ComposerKt.sourceInformationMarkerStart(arg10, v1, "C(rememberNavigationEventDispatcherOwner)N(enabled,parent)61@3115L7,67@3406L325,76@3761L39,76@3737L63,79@3907L43,79@3873L77,81@3963L124:RememberNavigationEventDispatcherOwner.kt#wc8b4r");
        int v2 = 1;
        int v0 = 6;
        if((arg12 & 2) != 0) {
            arg9 = LocalNavigationEventDispatcherOwner.INSTANCE.getCurrent(arg10, v0);
            if(arg9 != null) {
            }
            else {
                throw new IllegalStateException("No NavigationEventDispatcherOwner provided in LocalNavigationEventDispatcherOwner. If you intended to create a root dispatcher, explicitly pass null as the parent.".toString());
            }
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg11, -1, "androidx.navigationevent.compose.rememberNavigationEventDispatcherOwner (RememberNavigationEventDispatcherOwner.kt:65)");
        }

        String v1_1 = "CC(remember):RememberNavigationEventDispatcherOwner.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg10, 0xAD6F6C90, v1_1);
        boolean v12 = arg10.changed(arg9);
        Object v3 = arg10.rememberedValue();
        if((v12) || v3 == Composer.Companion.getEmpty()) {
            v3_1 = arg9 != null ? new NavigationEventDispatcher(arg9.getNavigationEventDispatcher()) : new NavigationEventDispatcher();
            arg10.updateRememberedValue(v3_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        Boolean v9 = Boolean.valueOf(true);
        ComposerKt.sourceInformationMarkerStart(arg10, 0xAD6F97D2, v1_1);
        v12 = arg10.changedInstance(v3_1);
        int v4 = arg11 & 14;
        int v7 = 4;
        if((v4 ^ 6) <= v7 || !arg10.changed(true)) {
            if((arg11 & v0) == v7) {
            }
            else {
                v2 = 0;
            }
        }

        arg11 = (((int)v12)) | v2;
        Object v12_1 = arg10.rememberedValue();
        if(arg11 != 0 || v12_1 == Composer.Companion.getEmpty()) {
            RememberNavigationEventDispatcherOwnerKt$rememberNavigationEventDispatcherOwner$2$1 v12_2 = new RememberNavigationEventDispatcherOwnerKt$rememberNavigationEventDispatcherOwner$2$1(v3_1, true, null);
            arg10.updateRememberedValue(v12_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        EffectsKt.LaunchedEffect(v9, ((Function2)v12_1), arg10, v4);
        ComposerKt.sourceInformationMarkerStart(arg10, -1385190890, v1_1);
        arg8 = arg10.changedInstance(v3_1);
        Object v9_1 = arg10.rememberedValue();
        if((arg8) || v9_1 == Composer.Companion.getEmpty()) {
            RememberNavigationEventDispatcherOwnerKt$$ExternalSyntheticLambda0 v9_2 = new RememberNavigationEventDispatcherOwnerKt$$ExternalSyntheticLambda0(v3_1);
            arg10.updateRememberedValue(v9_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        EffectsKt.DisposableEffect(v3_1, ((Function1)v9_1), arg10, 0);
        ComposerKt.sourceInformationMarkerStart(arg10, 0xAD6FB167, v1_1);
        arg8 = arg10.changed(v3_1);
        v9_1 = arg10.rememberedValue();
        if((arg8) || v9_1 == Composer.Companion.getEmpty()) {
            ComposeNavigationEventDispatcherOwner v9_3 = new ComposeNavigationEventDispatcherOwner(v3_1);
            arg10.updateRememberedValue(v9_3);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        return ((NavigationEventDispatcherOwner)v9_1);
    }

    static final DisposableEffectResult rememberNavigationEventDispatcherOwner$lambda$5$lambda$4(NavigationEventDispatcher arg0, DisposableEffectScope arg1) {
        return new RememberNavigationEventDispatcherOwnerKt$rememberNavigationEventDispatcherOwner$lambda$5$lambda$4$$inlined$onDispose$1(arg0);
    }
}

