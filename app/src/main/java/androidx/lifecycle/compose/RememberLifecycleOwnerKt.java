package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A#\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2={"rememberLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "maxLifecycle", "Landroidx/lifecycle/Lifecycle$State;", "parent", "(Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/LifecycleOwner;Landroidx/compose/runtime/Composer;II)Landroidx/lifecycle/LifecycleOwner;", "lifecycle-runtime-compose"}, k=2, mv={2, 1, 0}, xi=0x30) public final class RememberLifecycleOwnerKt {
    public static void $r8$lambda$0hrbeT26lEfIKGSpz-zHtCY4jIs(ComposeLifecycleOwner arg0, LifecycleOwner arg1, Event arg2) {
        RememberLifecycleOwnerKt.rememberLifecycleOwner$lambda$1$0$0(arg0, arg1, arg2);
    }

    public static DisposableEffectResult $r8$lambda$vBHoW7NavqSLRgsSYO-rN8QcXx4(LifecycleOwner arg0, ComposeLifecycleOwner arg1, DisposableEffectScope arg2) {
        return RememberLifecycleOwnerKt.rememberLifecycleOwner$lambda$1$0(arg0, arg1, arg2);
    }

    public static final LifecycleOwner rememberLifecycleOwner(State arg3, LifecycleOwner arg4, Composer arg5, int arg6, int arg7) {
        ComposeLifecycleOwner v1_2;
        Object v4_1;
        int v1 = 0xA680C9D0;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(rememberLifecycleOwner)N(maxLifecycle,parent)77@3569L7,79@3628L44,82@3787L899,82@3741L945,107@4812L68,107@4762L118:RememberLifecycleOwner.kt#2vxrgp");
        if((arg7 & 1) != 0) {
            arg3 = State.RESUMED;
        }

        if((arg7 & 2) != 0) {
            ProvidableCompositionLocal v4 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(arg5, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v4_1 = arg5.consume(((CompositionLocal)v4));
            ComposerKt.sourceInformationMarkerEnd(arg5);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.lifecycle.compose.rememberLifecycleOwner (RememberLifecycleOwner.kt:78)");
        }

        String v0 = "CC(remember):RememberLifecycleOwner.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg5, 158706556, v0);
        boolean v7 = arg5.changed(v4_1);
        Object v1_1 = arg5.rememberedValue();
        if((v7) || v1_1 == Composer.Companion.getEmpty()) {
            v1_2 = new ComposeLifecycleOwner();
            arg5.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        ComposerKt.sourceInformationMarkerStart(arg5, 0x975C2B3, v0);
        arg7 = arg5.changedInstance(v1_2) | arg5.changedInstance(v4_1);
        Object v2 = arg5.rememberedValue();
        if(arg7 != 0 || v2 == Composer.Companion.getEmpty()) {
            RememberLifecycleOwnerKt$$ExternalSyntheticLambda1 v2_1 = new RememberLifecycleOwnerKt$$ExternalSyntheticLambda1(((LifecycleOwner)v4_1), v1_2);
            arg5.updateRememberedValue(v2_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        EffectsKt.DisposableEffect(v1_2, v4_1, ((Function1)v2), arg5, arg6 & 0x70);
        ComposerKt.sourceInformationMarkerStart(arg5, 0x9763F94, v0);
        boolean v4_2 = arg5.changedInstance(v1_2);
        int v0_1 = 4;
        arg7 = (arg6 & 14 ^ 6) > v0_1 && (arg5.changed(arg3.ordinal())) || (arg6 & 6) == v0_1 ? 1 : 0;
        int v4_3 = (((int)v4_2)) | arg7;
        Object v7_1 = arg5.rememberedValue();
        if(v4_3 != 0 || v7_1 == Composer.Companion.getEmpty()) {
            RememberLifecycleOwnerKt$rememberLifecycleOwner$2$1 v7_2 = new RememberLifecycleOwnerKt$rememberLifecycleOwner$2$1(v1_2, arg3, null);
            arg5.updateRememberedValue(v7_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        EffectsKt.LaunchedEffect(v1_2, arg3, ((Function2)v7_1), arg5, arg6 << 3 & 0x70);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return ((LifecycleOwner)v1_2);
    }

    private static final DisposableEffectResult rememberLifecycleOwner$lambda$1$0(LifecycleOwner arg2, ComposeLifecycleOwner arg3, DisposableEffectScope arg4) {
        RememberLifecycleOwnerKt$$ExternalSyntheticLambda0 v4 = new RememberLifecycleOwnerKt$$ExternalSyntheticLambda0(arg3);
        if(arg2 != null) {
            Lifecycle v0 = arg2.getLifecycle();
            if(v0 != null) {
                v0.addObserver(v4);
            }
        }

        if(arg2 == null) {
            arg3.handleLifecycleEvent(Event.ON_RESUME);
        }

        return new RememberLifecycleOwnerKt$rememberLifecycleOwner$lambda$1$0$$inlined$onDispose$1(arg2, ((LifecycleEventObserver)v4), arg3);
    }

    private static final void rememberLifecycleOwner$lambda$1$0$0(ComposeLifecycleOwner arg0, LifecycleOwner arg1, Event arg2) {
        arg0.handleLifecycleEvent(arg2);
    }
}

