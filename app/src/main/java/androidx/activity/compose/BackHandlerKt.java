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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A%\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2={"BackHandler", "", "enabled", "", "onBack", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "activity-compose"}, k=2, mv={2, 1, 0}, xi=0x30) public final class BackHandlerKt {
    public static DisposableEffectResult $r8$lambda$B1Fin5hf49c20rDAvK1Q7mhIkmo(BackHandlerDispatcherCompat arg0, ComposeBackHandler arg1, DisposableEffectScope arg2) {
        return BackHandlerKt.BackHandler$lambda$4$0(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$S8UlOnD71n3GOIFiR5ppWOIaAkk(ComposeBackHandler arg0, boolean arg1, Function0 arg2) {
        return BackHandlerKt.BackHandler$lambda$5$0(arg0, arg1, arg2);
    }

    public static LifecycleStopOrDisposeEffectResult $r8$lambda$kM0UcaP40dPddLQ78INQJof-AtI(ComposeBackHandler arg0, boolean arg1, LifecycleStartStopEffectScope arg2) {
        return BackHandlerKt.BackHandler$lambda$3$0(arg0, arg1, arg2);
    }

    public static LifecycleStopOrDisposeEffectResult $r8$lambda$lj-_TT9Ycs622xDrDAPZnwcLqwA(BackHandlerDispatcherCompat arg0, ComposeBackHandler arg1, LifecycleStartStopEffectScope arg2) {
        return BackHandlerKt.BackHandler$lambda$6$0(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$uh0XynCQ53WgWF1AJSb8Svr1cqM(ComposeBackHandler arg0, Function0 arg1) {
        return BackHandlerKt.BackHandler$lambda$2$0(arg0, arg1);
    }

    public static final void BackHandler(boolean arg16, Function0 arg17, Composer arg18, int arg19, int arg20) {
        Object v4_4;
        boolean v3_3;
        ComposeBackHandler v9_4;
        BackHandlerDispatcherCompat v6_2;
        OnBackPressedDispatcherOwner v3_2;
        boolean v11;
        int v9;
        boolean v6;
        int v7;
        Function0 v0 = arg17;
        int v1 = arg19;
        int v2 = arg20;
        int v3 = 0xEA74A72A;
        Composer v8 = arg18.startRestartGroup(v3);
        ComposerKt.sourceInformation(v8, "C(BackHandler)N(enabled,onBack)110@5097L7,119@5502L427,128@5954L27,130@6008L115:BackHandler.kt#q1dkbc");
        int v4 = v2 & 1;
        if(v4 != 0) {
            v7 = v1 | 6;
            v6 = arg16;
        }
        else if((v1 & 6) == 0) {
            v6 = arg16;
            v7 = v8.changed(v6) ? 4 : 2;
            v7 |= v1;
        }
        else {
            v6 = arg16;
            v7 = v1;
        }

        int v10 = 0x20;
        if((v1 & 0x30) == 0) {
            v9 = v8.changedInstance(v0) ? v10 : 16;
            v7 |= v9;
        }

        int v13 = 1;
        boolean v9_1 = (v7 & 19) != 18 ? true : false;
        if(v8.shouldExecute(v9_1, v7 & 1)) {
            v11 = v4 != 0 ? true : v6;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v7, -1, "androidx.activity.compose.BackHandler (BackHandler.kt:107)");
            }

            NavigationEventDispatcherOwner v3_1 = LocalNavigationEventDispatcherOwner.INSTANCE.getCurrent(v8, LocalNavigationEventDispatcherOwner.$stable);
            if(v3_1 == null) {
                v8.startReplaceGroup(0x1FE7A4B1);
                ComposerKt.sourceInformation(v8, "111@5154L7");
                v3_2 = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(v8, 6);
            }
            else {
                v8.startReplaceGroup(0x1FE7996E);
            }

            v8.endReplaceGroup();
            if((((NavigationEventDispatcherOwner)v3_2)) != null) {
                String v14 = "CC(remember):BackHandler.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(v8, 0x1FE7D1D5, v14);
                boolean v4_1 = v8.changed(v3_2);
                Object v6_1 = v8.rememberedValue();
                if((v4_1) || v6_1 == Composer.Companion.getEmpty()) {
                    OnBackPressedDispatcher v9_2 = null;
                    NavigationEventDispatcherOwner v4_2 = ((((NavigationEventDispatcherOwner)v3_2)) instanceof NavigationEventDispatcherOwner) ? ((NavigationEventDispatcherOwner)v3_2) : ((NavigationEventDispatcherOwner)v9_2);
                    NavigationEventDispatcher v4_3 = v4_2 != null ? v4_2.getNavigationEventDispatcher() : ((NavigationEventDispatcher)v9_2);
                    NavigationEventDispatcherOwner v15 = ((((NavigationEventDispatcherOwner)v3_2)) instanceof OnBackPressedDispatcherOwner) ? ((NavigationEventDispatcherOwner)v3_2) : ((NavigationEventDispatcherOwner)v9_2);
                    if(v15 != null) {
                        v9_2 = ((OnBackPressedDispatcherOwner)v15).getOnBackPressedDispatcher();
                    }

                    v6_2 = new BackHandlerDispatcherCompat(v4_3, v9_2);
                    v8.updateRememberedValue(v6_2);
                }

                Object v15_1 = v6_2;
                ComposerKt.sourceInformationMarkerEnd(v8);
                long v5 = ComposablesKt.getCurrentCompositeKeyHashCode(v8, 0);
                ComposerKt.sourceInformationMarkerStart(v8, 0x1FE80FDD, v14);
                v4 = v8.changed(v15_1) | v8.changed(v5);
                Object v9_3 = v8.rememberedValue();
                if(v4 != 0 || v9_3 == Composer.Companion.getEmpty()) {
                    v9_4 = new ComposeBackHandler(new BackHandlerInfo(v3_2, v5));
                    v8.updateRememberedValue(v9_4);
                }

                Object v5_1 = v9_4;
                ComposerKt.sourceInformationMarkerEnd(v8);
                if(ActivityFlags.isOnBackPressedLifecycleOrderMaintained) {
                    v8.startReplaceGroup(-585307852);
                    ComposerKt.sourceInformation(v8, "136@6310L43,136@6299L54,140@6579L117,140@6540L156,145@6744L114,145@6706L152");
                    ComposerKt.sourceInformationMarkerStart(v8, 0x1FE83555, v14);
                    v3_3 = v8.changedInstance(v5_1);
                    v4 = (v7 & 0x70) == v10 ? 1 : 0;
                    v3 = (((int)v3_3)) | v4;
                    v4_4 = v8.rememberedValue();
                    if(v3 != 0 || v4_4 == Composer.Companion.getEmpty()) {
                        BackHandlerKt$$ExternalSyntheticLambda0 v4_5 = new BackHandlerKt$$ExternalSyntheticLambda0(((ComposeBackHandler)v5_1), v0);
                        v8.updateRememberedValue(v4_5);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v8);
                    EffectsKt.SideEffect(((Function0)v4_4), v8, 0);
                    Boolean v4_6 = Boolean.valueOf(v11);
                    ComposerKt.sourceInformationMarkerStart(v8, 0x1FE8573F, v14);
                    v3_3 = v8.changedInstance(v5_1);
                    v9 = v7 & 14;
                    if(v9 == 4) {
                    }
                    else {
                        v13 = 0;
                    }

                    v6_1 = v8.rememberedValue();
                    if(((((int)v3_3)) | v13) != 0 || v6_1 == Composer.Companion.getEmpty()) {
                        BackHandlerKt$$ExternalSyntheticLambda1 v6_3 = new BackHandlerKt$$ExternalSyntheticLambda1(((ComposeBackHandler)v5_1), v11);
                        v8.updateRememberedValue(v6_3);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v8);
                    LifecycleEffectKt.LifecycleStartEffect(v4_6, v5_1, null, v6_1, v8, v9, 4);
                    ComposerKt.sourceInformationMarkerStart(v8, 0x1FE86BDC, v14);
                    v3 = v8.changedInstance(v15_1) | v8.changedInstance(v5_1);
                    v4_4 = v8.rememberedValue();
                    if(v3 != 0 || v4_4 == Composer.Companion.getEmpty()) {
                        BackHandlerKt$$ExternalSyntheticLambda2 v4_7 = new BackHandlerKt$$ExternalSyntheticLambda2(((BackHandlerDispatcherCompat)v15_1), ((ComposeBackHandler)v5_1));
                        v8.updateRememberedValue(v4_7);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v8);
                    EffectsKt.DisposableEffect(v15_1, v5_1, ((Function1)v4_4), v8, 0);
                    v8.endReplaceGroup();
                }
                else {
                    v8.startReplaceGroup(0xDD2730D0);
                    ComposerKt.sourceInformation(v8, "151@6992L107,151@6981L118,158@7328L120,158@7286L162");
                    ComposerKt.sourceInformationMarkerStart(v8, 0x1FE88AD5, v14);
                    v3_3 = v8.changedInstance(v5_1);
                    v4 = (v7 & 14) == 4 ? 1 : 0;
                    v3 = (((int)v3_3)) | v4;
                    if((v7 & 0x70) == v10) {
                    }
                    else {
                        v13 = 0;
                    }

                    v4_4 = v8.rememberedValue();
                    if((v3 | v13) != 0 || v4_4 == Composer.Companion.getEmpty()) {
                        BackHandlerKt$$ExternalSyntheticLambda3 v4_8 = new BackHandlerKt$$ExternalSyntheticLambda3(((ComposeBackHandler)v5_1), v11, v0);
                        v8.updateRememberedValue(v4_8);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v8);
                    EffectsKt.SideEffect(((Function0)v4_4), v8, 0);
                    ComposerKt.sourceInformationMarkerStart(v8, 0x1FE8B4E2, v14);
                    v3 = v8.changedInstance(v15_1) | v8.changedInstance(v5_1);
                    v4_4 = v8.rememberedValue();
                    if(v3 != 0 || v4_4 == Composer.Companion.getEmpty()) {
                        BackHandlerKt$$ExternalSyntheticLambda4 v4_9 = new BackHandlerKt$$ExternalSyntheticLambda4(((BackHandlerDispatcherCompat)v15_1), ((ComposeBackHandler)v5_1));
                        v8.updateRememberedValue(v4_9);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v8);
                    LifecycleEffectKt.LifecycleStartEffect(v15_1, v5_1, null, v4_4, v8, 0, 4);
                    v8.endReplaceGroup();
                }

                if(!ComposerKt.isTraceInProgress()) {
                    goto label_246;
                }

                ComposerKt.traceEventEnd();
                goto label_246;
            }

            throw new IllegalStateException("No NavigationEventDispatcherOwner was provided via LocalNavigationEventDispatcherOwner and no OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner. Please provide one of the two.".toString());
        }
        else {
            v8.skipToGroupEnd();
            v11 = v6;
        }

    label_246:
        ScopeUpdateScope v3_4 = v8.endRestartGroup();
        if(v3_4 != null) {
            v3_4.updateScope(new BackHandlerKt$$ExternalSyntheticLambda5(v11, v0, v1, v2));
        }
    }

    private static final Unit BackHandler$lambda$2$0(ComposeBackHandler arg0, Function0 arg1) {
        arg0.setCurrentOnBackCompleted(arg1);
        return Unit.INSTANCE;
    }

    private static final LifecycleStopOrDisposeEffectResult BackHandler$lambda$3$0(ComposeBackHandler arg0, boolean arg1, LifecycleStartStopEffectScope arg2) {
        arg0.setBackEnabled(arg1);
        return new BackHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1(arg2, arg0);
    }

    private static final DisposableEffectResult BackHandler$lambda$4$0(BackHandlerDispatcherCompat arg0, ComposeBackHandler arg1, DisposableEffectScope arg2) {
        arg0.addHandler(arg1);
        return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(arg0, arg1);
    }

    private static final Unit BackHandler$lambda$5$0(ComposeBackHandler arg0, boolean arg1, Function0 arg2) {
        arg0.setBackEnabled(arg1);
        arg0.setCurrentOnBackCompleted(arg2);
        return Unit.INSTANCE;
    }

    private static final LifecycleStopOrDisposeEffectResult BackHandler$lambda$6$0(BackHandlerDispatcherCompat arg1, ComposeBackHandler arg2, LifecycleStartStopEffectScope arg3) {
        arg1.addHandler(arg2);
        return new BackHandlerKt$BackHandler$lambda$6$0$$inlined$onStopOrDispose$1(arg3, arg1, arg2);
    }

    static final Unit BackHandler$lambda$7(boolean arg0, Function0 arg1, int arg2, int arg3, Composer arg4, int arg5) {
        BackHandlerKt.BackHandler(arg0, arg1, arg4, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1), arg3);
        return Unit.INSTANCE;
    }
}

