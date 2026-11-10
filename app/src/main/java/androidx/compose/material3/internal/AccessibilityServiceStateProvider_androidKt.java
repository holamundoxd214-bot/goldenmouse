package androidx.compose.material3.internal;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\u001A1\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0002H\u0001¢\u0006\u0002\u0010\u0006\u001A;\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0014\b\u0002\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\f2\u000E\b\u0002\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\b0\u000FH\u0003¢\u0006\u0002\u0010\u0010\"\u000E\u0010\u0011\u001A\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0013\u001A\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"rememberAccessibilityServiceState", "Landroidx/compose/runtime/State;", "", "listenToTouchExplorationState", "listenToSwitchAccessState", "listenToVoiceAccessState", "(ZZZLandroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "ObserveState", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "handleEvent", "Lkotlin/Function1;", "Landroidx/lifecycle/Lifecycle$Event;", "onDispose", "Lkotlin/Function0;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SwitchAccessActivityName", "", "VoiceAccessActivityName", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AccessibilityServiceStateProvider_androidKt {
    private static final String SwitchAccessActivityName = "SwitchAccess";
    private static final String VoiceAccessActivityName = "VoiceAccess";

    private static final void ObserveState(LifecycleOwner arg10, Function1 arg11, Function0 arg12, Composer arg13, int arg14, int arg15) {
        AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda2 v12_1;
        Object v11;
        int v4;
        int v1;
        int v0 = 0x90A396B3;
        arg13 = arg13.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg13, "C(ObserveState)N(lifecycleOwner,handleEvent,onDispose)80@3016L2,81@3048L2,83@3093L259,83@3060L292:AccessibilityServiceStateProvider.android.kt#mqatfk");
        if((arg15 & 1) != 0) {
            v1 = arg14 | 6;
        }
        else if((arg14 & 6) == 0) {
            v1 = arg13.changedInstance(arg10) ? 4 : 2;
            v1 |= arg14;
        }
        else {
            v1 = arg14;
        }

        int v2 = arg15 & 2;
        int v3 = 0x20;
        if(v2 != 0) {
            v1 |= 0x30;
        }
        else if((arg14 & 0x30) == 0) {
            v4 = arg13.changedInstance(arg11) ? v3 : 16;
            v1 |= v4;
        }

        v4 = arg15 & 4;
        int v5 = 0x100;
        if(v4 != 0) {
            v1 |= 0x180;
        }
        else if((arg14 & 0x180) == 0) {
            int v6 = arg13.changedInstance(arg12) ? v5 : 0x80;
            v1 |= v6;
        }

        int v8 = 0;
        boolean v6_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg13.shouldExecute(v6_1, v1 & 1)) {
            String v6_2 = "CC(remember):AccessibilityServiceStateProvider.android.kt#9igjgp";
            if(v2 != 0) {
                ComposerKt.sourceInformationMarkerStart(arg13, -166148907, v6_2);
                v11 = arg13.rememberedValue();
                if(v11 == Composer.Companion.getEmpty()) {
                    AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda1 v11_1 = new AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda1();
                    arg13.updateRememberedValue(v11_1);
                }

                ComposerKt.sourceInformationMarkerEnd(arg13);
            }

            if(v4 != 0) {
                ComposerKt.sourceInformationMarkerStart(arg13, 0xF618C8D5, v6_2);
                Object v12 = arg13.rememberedValue();
                if(v12 == Composer.Companion.getEmpty()) {
                    v12_1 = new AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda2();
                    arg13.updateRememberedValue(v12_1);
                }

                ComposerKt.sourceInformationMarkerEnd(arg13);
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.internal.ObserveState (AccessibilityServiceStateProvider.android.kt:82)");
            }

            ComposerKt.sourceInformationMarkerStart(arg13, 0xF618CF76, v6_2);
            v0 = (v1 & 0x70) == v3 ? 1 : 0;
            v0 |= arg13.changedInstance(arg10);
            if((v1 & 0x380) == v5) {
                v8 = 1;
            }

            Object v2_1 = arg13.rememberedValue();
            if((v0 | v8) != 0 || v2_1 == Composer.Companion.getEmpty()) {
                AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda3 v2_2 = new AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda3(arg10, ((Function1)v11), ((Function0)v12_1));
                arg13.updateRememberedValue(v2_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg13);
            EffectsKt.DisposableEffect(arg10, ((Function1)v2_1), arg13, v1 & 14);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_112;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg13.skipToGroupEnd();
        }

    label_112:
        Function1 v3_1 = ((Function1)v11);
        Function0 v4_1 = ((Function0)v12_1);
        ScopeUpdateScope v11_2 = arg13.endRestartGroup();
        if(v11_2 != null) {
            v11_2.updateScope(new AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda4(arg10, v3_1, v4_1, arg14, arg15));
        }
    }

    static final DisposableEffectResult ObserveState$lambda$12$lambda$11(LifecycleOwner arg1, Function1 arg2, Function0 arg3, DisposableEffectScope arg4) {
        AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda0 v4 = new AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda0(arg2);
        arg1.getLifecycle().addObserver(v4);
        return new AccessibilityServiceStateProvider_androidKt$ObserveState$lambda$12$lambda$11$$inlined$onDispose$1(arg3, arg1, ((LifecycleEventObserver)v4));
    }

    static final void ObserveState$lambda$12$lambda$11$lambda$9(Function1 arg0, LifecycleOwner arg1, Event arg2) {
        arg0.invoke(arg2);
    }

    static final Unit ObserveState$lambda$13(LifecycleOwner arg6, Function1 arg7, Function0 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        AccessibilityServiceStateProvider_androidKt.ObserveState(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    static final Unit ObserveState$lambda$6$lambda$5(Event arg0) {
        return Unit.INSTANCE;
    }

    static final Unit ObserveState$lambda$8$lambda$7() {
        return Unit.INSTANCE;
    }

    public static final State rememberAccessibilityServiceState(boolean arg12, boolean arg13, boolean arg14, Composer arg15, int arg16, int arg17) {
        AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda5 v1_3;
        Listener v1_2;
        int v0 = arg16;
        int v2 = 0x19C37C1C;
        ComposerKt.sourceInformationMarkerStart(arg15, v2, "C(rememberAccessibilityServiceState)N(listenToTouchExplorationState,listenToSwitchAccessState,listenToVoiceAccessState)47@1997L7,52@2152L406,65@2623L7,66@2654L144,71@2820L45,64@2564L308:AccessibilityServiceStateProvider.android.kt#mqatfk");
        int v4 = 1;
        int v1 = 4;
        boolean v5 = (arg17 & 4) != 0 ? true : arg14;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.material3.internal.rememberAccessibilityServiceState (AccessibilityServiceStateProvider.android.kt:46)");
        }

        ProvidableCompositionLocal v2_1 = AndroidCompositionLocals_androidKt.getLocalContext();
        int v6 = 0x789C5F52;
        String v7 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg15, v6, v7);
        Object v2_2 = arg15.consume(((CompositionLocal)v2_1));
        ComposerKt.sourceInformationMarkerEnd(arg15);
        v2_2 = ((Context)v2_2).getSystemService("accessibility");
        Intrinsics.checkNotNull(v2_2, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        String v9 = "CC(remember):AccessibilityServiceStateProvider.android.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg15, 0xB6D51832, v9);
        v1 = (v0 & 14 ^ 6) > v1 && (arg15.changed(true)) || (v0 & 6) == v1 ? 1 : 0;
        int v11 = 0x20;
        int v8 = (v0 & 0x70 ^ 0x30) > v11 && (arg15.changed(true)) || (v0 & 0x30) == v11 ? 1 : 0;
        v1 |= v8;
        v11 = 0x100;
        if((v0 & 0x380 ^ 0x180) <= v11 || !arg15.changed(v5)) {
            if((v0 & 0x180) == v11) {
            }
            else {
                v4 = 0;
            }
        }

        v0 = v1 | v4;
        Object v1_1 = arg15.rememberedValue();
        if(v0 != 0 || v1_1 == Composer.Companion.getEmpty()) {
            v1_2 = new Listener(true, true, v5);
            arg15.updateRememberedValue(v1_2);
        }

        Object v12 = v1_2;
        ComposerKt.sourceInformationMarkerEnd(arg15);
        ProvidableCompositionLocal v13 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart(arg15, v6, v7);
        Object v13_1 = arg15.consume(((CompositionLocal)v13));
        ComposerKt.sourceInformationMarkerEnd(arg15);
        Object v0_1 = v13_1;
        ComposerKt.sourceInformationMarkerStart(arg15, -1227532820, v9);
        int v13_2 = arg15.changed(v12) | arg15.changedInstance(v2_2);
        v1_1 = arg15.rememberedValue();
        if(v13_2 != 0 || v1_1 == Composer.Companion.getEmpty()) {
            v1_3 = new AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda5(((Listener)v12), ((AccessibilityManager)v2_2));
            arg15.updateRememberedValue(v1_3);
        }

        ComposerKt.sourceInformationMarkerEnd(arg15);
        ComposerKt.sourceInformationMarkerStart(arg15, -1227527607, v9);
        v13_2 = arg15.changed(v12) | arg15.changedInstance(v2_2);
        Object v4_1 = arg15.rememberedValue();
        if(v13_2 != 0 || v4_1 == Composer.Companion.getEmpty()) {
            AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda6 v4_2 = new AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda6(((Listener)v12), ((AccessibilityManager)v2_2));
            arg15.updateRememberedValue(v4_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg15);
        AccessibilityServiceStateProvider_androidKt.ObserveState(((LifecycleOwner)v0_1), ((Function1)v1_3), v4_1, arg15, 0, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg15);
        return ((State)v12);
    }

    static final Unit rememberAccessibilityServiceState$lambda$2$lambda$1(Listener arg1, AccessibilityManager arg2, Event arg3) {
        if(arg3 == Event.ON_RESUME) {
            arg1.register(arg2);
        }

        return Unit.INSTANCE;
    }

    static final Unit rememberAccessibilityServiceState$lambda$4$lambda$3(Listener arg0, AccessibilityManager arg1) {
        arg0.unregister(arg1);
        return Unit.INSTANCE;
    }
}

