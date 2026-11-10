package androidx.activity.compose;

import androidx.activity.ActivityFlags;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.compose.internal.BackHandlerDispatcherCompat;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.lifecycle.compose.LifecycleStartStopEffectScope;
import androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult;
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.compose.LocalNavigationEventDispatcherOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001AZ\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032A\u0010\u0004\u001A=\b\u0001\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u000F\u0012\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005H\u0007¢\u0006\u0002\u0010\u000E¨\u0006\u000F"}, d2={"PredictiveBackHandler", "", "enabled", "", "onBack", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lkotlin/ParameterName;", "name", "progress", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "activity-compose"}, k=2, mv={2, 1, 0}, xi=0x30) public final class PredictiveBackHandlerKt {
    public static Unit $r8$lambda$-I2Xi7-mOChmMAZ9qZZEwheaxs4(ComposePredictiveBackHandler arg0, Function2 arg1) {
        return PredictiveBackHandlerKt.PredictiveBackHandler$lambda$2$0(arg0, arg1);
    }

    public static LifecycleStopOrDisposeEffectResult $r8$lambda$D8a2kH5mKpDy4Fdrtpqcav0aLMg(ComposePredictiveBackHandler arg0, boolean arg1, LifecycleStartStopEffectScope arg2) {
        return PredictiveBackHandlerKt.PredictiveBackHandler$lambda$3$0(arg0, arg1, arg2);
    }

    public static DisposableEffectResult $r8$lambda$Qyg5QBqA91q-6Cfl0DPwFa5-Xpg(BackHandlerDispatcherCompat arg0, ComposePredictiveBackHandler arg1, DisposableEffectScope arg2) {
        return PredictiveBackHandlerKt.PredictiveBackHandler$lambda$4$0(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$cQVN4tRfSnIQmf_oO7lMYiB3VMs(ComposePredictiveBackHandler arg0, boolean arg1, Function2 arg2) {
        return PredictiveBackHandlerKt.PredictiveBackHandler$lambda$5$0(arg0, arg1, arg2);
    }

    public static LifecycleStopOrDisposeEffectResult $r8$lambda$nQooPx1G5uRDz4nlmkTLRPyb09k(BackHandlerDispatcherCompat arg0, ComposePredictiveBackHandler arg1, LifecycleStartStopEffectScope arg2) {
        return PredictiveBackHandlerKt.PredictiveBackHandler$lambda$6$0(arg0, arg1, arg2);
    }

    public static final void PredictiveBackHandler(boolean arg17, Function2 arg18, Composer arg19, int arg20, int arg21) {
        PredictiveBackHandlerKt$$ExternalSyntheticLambda4 v4_10;
        boolean v3_3;
        OnBackPressedDispatcherOwner v3_2;
        boolean v13;
        int v9;
        boolean v6;
        int v7;
        Function2 v0 = arg18;
        int v1 = arg20;
        int v2 = arg21;
        int v3 = -642000585;
        Composer v8 = arg19.startRestartGroup(v3);
        ComposerKt.sourceInformation(v8, "C(PredictiveBackHandler)N(enabled,onBack)121@5572L7,130@5977L427,139@6422L24,140@6470L27,142@6524L196:PredictiveBackHandler.kt#q1dkbc");
        int v4 = v2 & 1;
        int v5 = 4;
        if(v4 != 0) {
            v7 = v1 | 6;
            v6 = arg17;
        }
        else if((v1 & 6) == 0) {
            v6 = arg17;
            v7 = v8.changed(v6) ? v5 : 2;
            v7 |= v1;
        }
        else {
            v6 = arg17;
            v7 = v1;
        }

        if((v1 & 0x30) == 0) {
            v9 = v8.changedInstance(v0) ? 0x20 : 16;
            v7 |= v9;
        }

        boolean v9_1 = (v7 & 19) != 18 ? true : false;
        if(v8.shouldExecute(v9_1, v7 & 1)) {
            v13 = v4 != 0 ? true : v6;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v7, -1, "androidx.activity.compose.PredictiveBackHandler (PredictiveBackHandler.kt:118)");
            }

            NavigationEventDispatcherOwner v3_1 = LocalNavigationEventDispatcherOwner.INSTANCE.getCurrent(v8, LocalNavigationEventDispatcherOwner.$stable);
            if(v3_1 == null) {
                v8.startReplaceGroup(1512740606);
                ComposerKt.sourceInformation(v8, "122@5629L7");
                v3_2 = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(v8, 6);
            }
            else {
                v8.startReplaceGroup(0x5A2A8BBB);
            }

            v8.endReplaceGroup();
            if((((NavigationEventDispatcherOwner)v3_2)) != null) {
                String v14 = "CC(remember):PredictiveBackHandler.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(v8, 0x5A2AC422, v14);
                boolean v4_1 = v8.changed(v3_2);
                Object v6_1 = v8.rememberedValue();
                if((v4_1) || v6_1 == Composer.Companion.getEmpty()) {
                    OnBackPressedDispatcher v9_2 = null;
                    NavigationEventDispatcherOwner v4_2 = ((((NavigationEventDispatcherOwner)v3_2)) instanceof NavigationEventDispatcherOwner) ? ((NavigationEventDispatcherOwner)v3_2) : ((NavigationEventDispatcherOwner)v9_2);
                    NavigationEventDispatcher v4_3 = v4_2 != null ? v4_2.getNavigationEventDispatcher() : ((NavigationEventDispatcher)v9_2);
                    NavigationEventDispatcherOwner v10 = ((((NavigationEventDispatcherOwner)v3_2)) instanceof OnBackPressedDispatcherOwner) ? ((NavigationEventDispatcherOwner)v3_2) : ((NavigationEventDispatcherOwner)v9_2);
                    if(v10 != null) {
                        v9_2 = ((OnBackPressedDispatcherOwner)v10).getOnBackPressedDispatcher();
                    }

                    BackHandlerDispatcherCompat v6_2 = new BackHandlerDispatcherCompat(v4_3, v9_2);
                    v8.updateRememberedValue(v6_2);
                }

                Object v15 = v6_1;
                ComposerKt.sourceInformationMarkerEnd(v8);
                ComposerKt.sourceInformationMarkerStart(v8, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(v8, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
                Object v4_4 = v8.rememberedValue();
                if(v4_4 == Composer.Companion.getEmpty()) {
                    CoroutineScope v4_5 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v8);
                    v8.updateRememberedValue(v4_5);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                ComposerKt.sourceInformationMarkerEnd(v8);
                long v9_3 = ComposablesKt.getCurrentCompositeKeyHashCode(v8, 0);
                ComposerKt.sourceInformationMarkerStart(v8, 0x5A2B079B, v14);
                int v6_3 = v8.changed(v15) | v8.changed(v9_3);
                Object v12 = v8.rememberedValue();
                if(v6_3 != 0 || v12 == Composer.Companion.getEmpty()) {
                    ComposePredictiveBackHandler v12_1 = new ComposePredictiveBackHandler(((CoroutineScope)v4_4), new PredictiveBackHandlerInfo(v3_2, v9_3));
                    v8.updateRememberedValue(v12_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                if(ActivityFlags.isOnBackPressedLifecycleOrderMaintained) {
                    v8.startReplaceGroup(0xEB3A1830);
                    ComposerKt.sourceInformation(v8, "151@6907L34,151@6896L45,155@7167L117,155@7128L156,160@7332L114,160@7294L152");
                    ComposerKt.sourceInformationMarkerStart(v8, 0x5A2B36D9, v14);
                    v3 = v8.changedInstance(v12) | v8.changedInstance(v0);
                    v4_4 = v8.rememberedValue();
                    if(v3 != 0 || v4_4 == Composer.Companion.getEmpty()) {
                        PredictiveBackHandlerKt$$ExternalSyntheticLambda0 v4_6 = new PredictiveBackHandlerKt$$ExternalSyntheticLambda0(((ComposePredictiveBackHandler)v12), v0);
                        v8.updateRememberedValue(v4_6);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v8);
                    EffectsKt.SideEffect(((Function0)v4_4), v8, 0);
                    Boolean v4_7 = Boolean.valueOf(v13);
                    ComposerKt.sourceInformationMarkerStart(v8, 0x5A2B57AC, v14);
                    v3_3 = v8.changedInstance(v12);
                    v9 = v7 & 14;
                    v5 = v9 == v5 ? 1 : 0;
                    v3 = (((int)v3_3)) | v5;
                    Object v5_1 = v8.rememberedValue();
                    if(v3 != 0 || v5_1 == Composer.Companion.getEmpty()) {
                        PredictiveBackHandlerKt$$ExternalSyntheticLambda1 v5_2 = new PredictiveBackHandlerKt$$ExternalSyntheticLambda1(((ComposePredictiveBackHandler)v12), v13);
                        v8.updateRememberedValue(v5_2);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v8);
                    LifecycleEffectKt.LifecycleStartEffect(v4_7, v12, null, v5_1, v8, v9, 4);
                    ComposerKt.sourceInformationMarkerStart(v8, 1512795209, v14);
                    v3 = v8.changedInstance(v15) | v8.changedInstance(v12);
                    v4_4 = v8.rememberedValue();
                    if(v3 != 0 || v4_4 == Composer.Companion.getEmpty()) {
                        PredictiveBackHandlerKt$$ExternalSyntheticLambda2 v4_8 = new PredictiveBackHandlerKt$$ExternalSyntheticLambda2(((BackHandlerDispatcherCompat)v15), ((ComposePredictiveBackHandler)v12));
                        v8.updateRememberedValue(v4_8);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v8);
                    EffectsKt.DisposableEffect(v15, v12, ((Function1)v4_4), v8, 0);
                    v8.endReplaceGroup();
                }
                else {
                    v8.startReplaceGroup(0xEB443CEC);
                    ComposerKt.sourceInformation(v8, "166@7580L98,166@7569L109,173@7907L120,173@7865L162");
                    ComposerKt.sourceInformationMarkerStart(v8, 1512803129, v14);
                    v3_3 = v8.changedInstance(v12);
                    v4 = (v7 & 14) == v5 ? 1 : 0;
                    v3 = (((int)v3_3)) | v4 | v8.changedInstance(v0);
                    v4_4 = v8.rememberedValue();
                    if(v3 != 0 || v4_4 == Composer.Companion.getEmpty()) {
                        PredictiveBackHandlerKt$$ExternalSyntheticLambda3 v4_9 = new PredictiveBackHandlerKt$$ExternalSyntheticLambda3(((ComposePredictiveBackHandler)v12), v13, v0);
                        v8.updateRememberedValue(v4_9);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v8);
                    EffectsKt.SideEffect(((Function0)v4_4), v8, 0);
                    ComposerKt.sourceInformationMarkerStart(v8, 0x5A2BB42F, v14);
                    v3 = v8.changedInstance(v15) | v8.changedInstance(v12);
                    v4_4 = v8.rememberedValue();
                    if(v3 != 0 || v4_4 == Composer.Companion.getEmpty()) {
                        v4_10 = new PredictiveBackHandlerKt$$ExternalSyntheticLambda4(((BackHandlerDispatcherCompat)v15), ((ComposePredictiveBackHandler)v12));
                        v8.updateRememberedValue(v4_10);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v8);
                    LifecycleEffectKt.LifecycleStartEffect(v15, v12, null, v4_10, v8, 0, 4);
                    v8.endReplaceGroup();
                }

                if(!ComposerKt.isTraceInProgress()) {
                    goto label_253;
                }

                ComposerKt.traceEventEnd();
                goto label_253;
            }

            throw new IllegalStateException("No NavigationEventDispatcherOwner was provided via LocalNavigationEventDispatcherOwner and no OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner. Please provide one of the two.".toString());
        }
        else {
            v8.skipToGroupEnd();
            v13 = v6;
        }

    label_253:
        ScopeUpdateScope v3_4 = v8.endRestartGroup();
        if(v3_4 != null) {
            v3_4.updateScope(new PredictiveBackHandlerKt$$ExternalSyntheticLambda5(v13, v0, v1, v2));
        }
    }

    private static final Unit PredictiveBackHandler$lambda$2$0(ComposePredictiveBackHandler arg0, Function2 arg1) {
        arg0.setCurrentOnBack(arg1);
        return Unit.INSTANCE;
    }

    private static final LifecycleStopOrDisposeEffectResult PredictiveBackHandler$lambda$3$0(ComposePredictiveBackHandler arg0, boolean arg1, LifecycleStartStopEffectScope arg2) {
        arg0.setBackEnabled(arg1);
        return new PredictiveBackHandlerKt$PredictiveBackHandler$lambda$3$0$$inlined$onStopOrDispose$1(arg2, arg0);
    }

    private static final DisposableEffectResult PredictiveBackHandler$lambda$4$0(BackHandlerDispatcherCompat arg0, ComposePredictiveBackHandler arg1, DisposableEffectScope arg2) {
        arg0.addHandler(arg1);
        return new PredictiveBackHandlerKt$PredictiveBackHandler$lambda$4$0$$inlined$onDispose$1(arg0, arg1);
    }

    private static final Unit PredictiveBackHandler$lambda$5$0(ComposePredictiveBackHandler arg0, boolean arg1, Function2 arg2) {
        arg0.setBackEnabled(arg1);
        arg0.setCurrentOnBack(arg2);
        return Unit.INSTANCE;
    }

    private static final LifecycleStopOrDisposeEffectResult PredictiveBackHandler$lambda$6$0(BackHandlerDispatcherCompat arg1, ComposePredictiveBackHandler arg2, LifecycleStartStopEffectScope arg3) {
        arg1.addHandler(arg2);
        return new PredictiveBackHandlerKt$PredictiveBackHandler$lambda$6$0$$inlined$onStopOrDispose$1(arg3, arg1, arg2);
    }

    static final Unit PredictiveBackHandler$lambda$7(boolean arg0, Function2 arg1, int arg2, int arg3, Composer arg4, int arg5) {
        PredictiveBackHandlerKt.PredictiveBackHandler(arg0, arg1, arg4, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1), arg3);
        return Unit.INSTANCE;
    }
}

