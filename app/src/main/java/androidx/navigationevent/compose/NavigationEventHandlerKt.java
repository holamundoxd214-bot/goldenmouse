package androidx.navigationevent.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.NavigationEventTransitionState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001Aq\u0010\u0000\u001A\u00020\u00012\u000E\u0010\u0002\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u000E\b\u0002\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00010\b2\u000E\b\u0002\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\n\u001A\u00020\u00062\u000E\b\u0002\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00010\b2\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\r\u001AE\u0010\u000E\u001A\u00020\u00012\u000E\u0010\u0002\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\b\b\u0002\u0010\n\u001A\u00020\u00062\u000E\b\u0002\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\u000F\u001AE\u0010\u0010\u001A\u00020\u00012\u000E\u0010\u0002\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u000E\b\u0002\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\u000F¨\u0006\u0011"}, d2={"NavigationEventHandler", "", "state", "Landroidx/navigationevent/compose/NavigationEventState;", "Landroidx/navigationevent/NavigationEventInfo;", "isForwardEnabled", "", "onForwardCancelled", "Lkotlin/Function0;", "onForwardCompleted", "isBackEnabled", "onBackCancelled", "onBackCompleted", "(Landroidx/navigationevent/compose/NavigationEventState;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "NavigationBackHandler", "(Landroidx/navigationevent/compose/NavigationEventState;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "NavigationForwardHandler", "navigationevent-compose"}, k=2, mv={2, 0, 0}, xi=0x30) public final class NavigationEventHandlerKt {
    public static final void NavigationBackHandler(NavigationEventState arg16, boolean arg17, Function0 arg18, Function0 arg19, Composer arg20, int arg21, int arg22) {
        Function0 v3_3;
        boolean v2_1;
        Object v11;
        NavigationEventHandlerKt$$ExternalSyntheticLambda10 v4_2;
        int v8;
        Function0 v7;
        int v6;
        boolean v4;
        int v2;
        NavigationEventState v1;
        int v5 = arg21;
        int v0 = 1220469155;
        Composer v13 = arg20.startRestartGroup(v0);
        ComposerKt.sourceInformation(v13, "C(NavigationBackHandler)N(state,isBackEnabled,onBackCancelled,onBackCompleted)144@6491L2,149@6612L2,150@6645L2,147@6536L296:NavigationEventHandler.kt#wc8b4r");
        if((v5 & 6) == 0) {
            v1 = arg16;
            v2 = v13.changed(v1) ? 4 : 2;
            v2 |= v5;
        }
        else {
            v1 = arg16;
            v2 = v5;
        }

        int v3 = arg22 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_32;
        }
        else if((v5 & 0x30) == 0) {
            v4 = arg17;
            v6 = v13.changed(v4) ? 0x20 : 16;
            v2 |= v6;
        }
        else {
        label_32:
            v4 = arg17;
        }

        v6 = arg22 & 4;
        if(v6 != 0) {
            v2 |= 0x180;
            goto label_47;
        }
        else if((v5 & 0x180) == 0) {
            v7 = arg18;
            v8 = v13.changedInstance(v7) ? 0x100 : 0x80;
            v2 |= v8;
        }
        else {
        label_47:
            v7 = arg18;
        }

        Function0 v12 = arg19;
        if((v5 & 0xC00) == 0) {
            v8 = v13.changedInstance(v12) ? 0x800 : 0x400;
            v2 |= v8;
        }

        boolean v10 = true;
        boolean v8_1 = (v2 & 0x493) != 1170 ? true : false;
        if(v13.shouldExecute(v8_1, v2 & 1)) {
            if(v3 != 0) {
            }
            else {
                v10 = v4;
            }

            String v3_1 = "CC(remember):NavigationEventHandler.kt#9igjgp";
            if(v6 != 0) {
                ComposerKt.sourceInformationMarkerStart(v13, 0x148D1A85, v3_1);
                Object v4_1 = v13.rememberedValue();
                if(v4_1 == Composer.Companion.getEmpty()) {
                    v4_2 = new NavigationEventHandlerKt$$ExternalSyntheticLambda10();
                    v13.updateRememberedValue(v4_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v13);
                v11 = v4_2;
            }
            else {
                Function0 v11_1 = v7;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.navigationevent.compose.NavigationBackHandler (NavigationEventHandler.kt:146)");
            }

            ComposerKt.sourceInformationMarkerStart(v13, 0x148D29A5, v3_1);
            Object v0_1 = v13.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                NavigationEventHandlerKt$$ExternalSyntheticLambda11 v0_2 = new NavigationEventHandlerKt$$ExternalSyntheticLambda11();
                v13.updateRememberedValue(v0_2);
            }

            Object v8_2 = v0_1;
            ComposerKt.sourceInformationMarkerEnd(v13);
            ComposerKt.sourceInformationMarkerStart(v13, 0x148D2DC5, v3_1);
            v0_1 = v13.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                NavigationEventHandlerKt$$ExternalSyntheticLambda12 v0_3 = new NavigationEventHandlerKt$$ExternalSyntheticLambda12();
                v13.updateRememberedValue(v0_3);
            }

            Object v9 = v0_1;
            ComposerKt.sourceInformationMarkerEnd(v13);
            v0 = v2 & 14 | 0xDB0;
            v2 <<= 9;
            NavigationEventHandlerKt.NavigationEventHandler(v1, false, ((Function0)v8_2), ((Function0)v9), v10, ((Function0)v11), v12, v13, v0 | 0xE000 & v2 | 0x70000 & v2 | v2 & 0x380000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v10;
            Object v3_2 = v11;
        }
        else {
            v13.skipToGroupEnd();
            v2_1 = v4;
            v3_3 = v7;
        }

        ScopeUpdateScope v7_1 = v13.endRestartGroup();
        if(v7_1 != null) {
            v7_1.updateScope(new NavigationEventHandlerKt$$ExternalSyntheticLambda13(arg16, v2_1, v3_3, arg19, v5, arg22));
        }
    }

    static final Unit NavigationBackHandler$lambda$19$lambda$18() {
        return Unit.INSTANCE;
    }

    static final Unit NavigationBackHandler$lambda$21$lambda$20() {
        return Unit.INSTANCE;
    }

    static final Unit NavigationBackHandler$lambda$23$lambda$22() {
        return Unit.INSTANCE;
    }

    static final Unit NavigationBackHandler$lambda$24(NavigationEventState arg7, boolean arg8, Function0 arg9, Function0 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        NavigationEventHandlerKt.NavigationBackHandler(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    public static final void NavigationEventHandler(NavigationEventState arg22, boolean arg23, Function0 arg24, Function0 arg25, boolean arg26, Function0 arg27, Function0 arg28, Composer arg29, int arg30, int arg31) {
        NavigationEventHandlerKt$$ExternalSyntheticLambda4 v0_8;
        Object v7_1;
        NavigationEventHandlerKt$$ExternalSyntheticLambda2 v0_5;
        NavigationEventHandlerKt$$ExternalSyntheticLambda1 v0_4;
        boolean v5_1;
        Function0 v4_2;
        Object v4_1;
        NavigationEventHandlerKt$$ExternalSyntheticLambda15 v0_3;
        Object v3_1;
        NavigationEventHandlerKt$$ExternalSyntheticLambda14 v0_2;
        Object v0_1;
        boolean v2_1;
        Function0 v3;
        int v18;
        Function0 v6;
        int v16;
        boolean v13;
        int v15;
        Function0 v14;
        int v12;
        Function0 v7;
        int v5;
        boolean v4;
        int v1;
        NavigationEventState v8 = arg22;
        int v9 = arg30;
        Composer v10 = arg29.startRestartGroup(0x358B6FE0);
        ComposerKt.sourceInformation(v10, "C(NavigationEventHandler)N(state,isForwardEnabled,onForwardCancelled,onForwardCompleted,isBackEnabled,onBackCancelled,onBackCompleted)73@3839L2,74@3880L2,77@3982L2,78@4020L2,81@4106L7,87@4303L276,96@4596L467,96@4585L478,108@5093L373,108@5069L397:NavigationEventHandler.kt#wc8b4r");
        if((v9 & 6) == 0) {
            v1 = v10.changed(v8) ? 4 : 2;
            v1 |= v9;
        }
        else {
            v1 = v9;
        }

        int v2 = arg31 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
            goto label_31;
        }
        else if((v9 & 0x30) == 0) {
            v4 = arg23;
            v5 = v10.changed(v4) ? 0x20 : 16;
            v1 |= v5;
        }
        else {
        label_31:
            v4 = arg23;
        }

        v5 = arg31 & 4;
        if(v5 != 0) {
            v1 |= 0x180;
            goto label_46;
        }
        else if((v9 & 0x180) == 0) {
            v7 = arg24;
            v12 = v10.changedInstance(v7) ? 0x100 : 0x80;
            v1 |= v12;
        }
        else {
        label_46:
            v7 = arg24;
        }

        v12 = arg31 & 8;
        if(v12 != 0) {
            v1 |= 0xC00;
            goto label_61;
        }
        else if((v9 & 0xC00) == 0) {
            v14 = arg25;
            v15 = v10.changedInstance(v14) ? 0x800 : 0x400;
            v1 |= v15;
        }
        else {
        label_61:
            v14 = arg25;
        }

        v15 = arg31 & 16;
        if(v15 != 0) {
            v1 |= 0x6000;
            goto label_76;
        }
        else if((v9 & 0x6000) == 0) {
            v13 = arg26;
            v16 = v10.changed(v13) ? 0x4000 : 0x2000;
            v1 |= v16;
        }
        else {
        label_76:
            v13 = arg26;
        }

        v16 = arg31 & 0x20;
        int v17 = 0x30000;
        if(v16 != 0) {
            v1 |= v17;
            v6 = arg27;
        }
        else {
            v6 = arg27;
            if((v9 & v17) == 0) {
                v18 = v10.changedInstance(v6) ? 0x20000 : 0x10000;
                v1 |= v18;
            }
        }

        v18 = arg31 & 0x40;
        int v19 = 0x180000;
        if(v18 != 0) {
            v1 |= v19;
        }
        else {
            v3 = arg28;
            if((v9 & v19) == 0) {
                int v20 = v10.changedInstance(v3) ? 0x100000 : 0x80000;
                v1 |= v20;
            }
        }

        boolean v0 = (v1 & 0x92493) != 0x92492 ? true : false;
        if(v10.shouldExecute(v0, v1 & 1)) {
            v2_1 = v2 != 0 ? true : v4;
            String v11 = "CC(remember):NavigationEventHandler.kt#9igjgp";
            if(v5 != 0) {
                ComposerKt.sourceInformationMarkerStart(v10, 0x6F1262, v11);
                v0_1 = v10.rememberedValue();
                if(v0_1 == Composer.Companion.getEmpty()) {
                    v0_2 = new NavigationEventHandlerKt$$ExternalSyntheticLambda14();
                    v10.updateRememberedValue(v0_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v10);
                v3_1 = v0_2;
            }
            else {
                v3 = v7;
            }

            if(v12 != 0) {
                ComposerKt.sourceInformationMarkerStart(v10, 0x6F1782, v11);
                v0_1 = v10.rememberedValue();
                if(v0_1 == Composer.Companion.getEmpty()) {
                    v0_3 = new NavigationEventHandlerKt$$ExternalSyntheticLambda15();
                    v10.updateRememberedValue(v0_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v10);
                v4_1 = v0_3;
            }
            else {
                v4_2 = v14;
            }

            v5_1 = v15 != 0 ? true : v13;
            if(v16 != 0) {
                ComposerKt.sourceInformationMarkerStart(v10, 0x6F2442, v11);
                v0_1 = v10.rememberedValue();
                if(v0_1 == Composer.Companion.getEmpty()) {
                    v0_4 = new NavigationEventHandlerKt$$ExternalSyntheticLambda1();
                    v10.updateRememberedValue(v0_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v10);
                Object v6_1 = v0_4;
            }

            if(v18 != 0) {
                ComposerKt.sourceInformationMarkerStart(v10, 0x6F2902, v11);
                v0_1 = v10.rememberedValue();
                if(v0_1 == Composer.Companion.getEmpty()) {
                    v0_5 = new NavigationEventHandlerKt$$ExternalSyntheticLambda2();
                    v10.updateRememberedValue(v0_5);
                }

                ComposerKt.sourceInformationMarkerEnd(v10);
                v7_1 = v0_5;
            }
            else {
                v7 = arg28;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x358B6FE0, v1, -1, "androidx.navigationevent.compose.NavigationEventHandler (NavigationEventHandler.kt:79)");
            }

            NavigationEventDispatcherOwner v0_6 = LocalNavigationEventDispatcherOwner.INSTANCE.getCurrent(v10, 6);
            if(v0_6 != null) {
                NavigationEventDispatcher v12_1 = v0_6.getNavigationEventDispatcher();
                ComposerKt.sourceInformationMarkerStart(v10, 0x6F4D74, v11);
                int v13_1 = v1 & 14;
                int v0_7 = v13_1 == 4 ? 1 : 0;
                Object v14_1 = v10.rememberedValue();
                if(v0_7 != 0 || v14_1 == Composer.Companion.getEmpty()) {
                    ComposeNavigationEventHandler v14_2 = new ComposeNavigationEventHandler(v8.getCurrentInfo(), new NavigationEventHandlerKt$$ExternalSyntheticLambda3(v8));
                    v10.updateRememberedValue(v14_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v10);
                ComposerKt.sourceInformationMarkerStart(v10, 0x6F72D3, v11);
                v0 = v10.changedInstance(v14_1);
                v9 = (v1 & 0x70) == 0x20 ? 1 : 0;
                v0_7 = (((int)v0)) | v9;
                v9 = (v1 & 0x380) == 0x100 ? 1 : 0;
                v0_7 |= v9;
                v9 = (v1 & 0x1C00) == 0x800 ? 1 : 0;
                v0_7 |= v9;
                v9 = (0xE000 & v1) == 0x4000 ? 1 : 0;
                v0_7 |= v9;
                v9 = (0x70000 & v1) == 0x20000 ? 1 : 0;
                v0_7 |= v9;
                v1 = (v1 & 0x380000) == 0x100000 ? 1 : 0;
                v0_7 |= v1;
                v1 = v13_1 == 4 ? 1 : 0;
                v0_7 |= v1;
                Object v1_1 = v10.rememberedValue();
                if(v0_7 != 0 || v1_1 == Composer.Companion.getEmpty()) {
                    v1_1 = v14_1;
                    v0_8 = new NavigationEventHandlerKt$$ExternalSyntheticLambda4(((ComposeNavigationEventHandler)v1_1), v2_1, ((Function0)v3_1), ((Function0)v4_1), v5_1, v6, ((Function0)v7_1), v8);
                    v10.updateRememberedValue(v0_8);
                }
                else {
                    v0_1 = v1_1;
                    v1_1 = v14_1;
                }

                ComposerKt.sourceInformationMarkerEnd(v10);
                v9 = 0;
                EffectsKt.SideEffect(((Function0)v0_8), v10, 0);
                ComposerKt.sourceInformationMarkerStart(v10, 0x6FB095, v11);
                if(v13_1 == 4) {
                    v9 = 1;
                }

                v0_7 = v10.changedInstance(v1_1) | v9 | v10.changedInstance(v12_1);
                Object v9_1 = v10.rememberedValue();
                if(v0_7 != 0 || v9_1 == Composer.Companion.getEmpty()) {
                    NavigationEventHandlerKt$$ExternalSyntheticLambda5 v9_2 = new NavigationEventHandlerKt$$ExternalSyntheticLambda5(v8, ((ComposeNavigationEventHandler)v1_1), v12_1);
                    v10.updateRememberedValue(v9_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v10);
                EffectsKt.DisposableEffect(v8, ((Function1)v9_1), v10, v13_1);
                if(!ComposerKt.isTraceInProgress()) {
                    goto label_316;
                }

                ComposerKt.traceEventEnd();
                goto label_316;
            }

            throw new IllegalStateException("No NavigationEventDispatcher was provided via LocalNavigationEventDispatcherOwner".toString());
        }
        else {
            v10.skipToGroupEnd();
            v2_1 = v4;
            v3 = v7;
            v5_1 = v13;
            v4_2 = v14;
            v7 = arg28;
        }

    label_316:
        ScopeUpdateScope v10_1 = v10.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new NavigationEventHandlerKt$$ExternalSyntheticLambda6(v8, v2_1, ((Function0)v3_1), ((Function0)v4_1), v5_1, v6, ((Function0)v7_1), arg30, arg31));
        }
    }

    static final Unit NavigationEventHandler$lambda$1$lambda$0() {
        return Unit.INSTANCE;
    }

    static final Unit NavigationEventHandler$lambda$10$lambda$9(NavigationEventState arg0, NavigationEventTransitionState arg1) {
        arg0.setTransitionState$navigationevent_compose(arg1);
        return Unit.INSTANCE;
    }

    static final Unit NavigationEventHandler$lambda$12$lambda$11(ComposeNavigationEventHandler arg0, boolean arg1, Function0 arg2, Function0 arg3, boolean arg4, Function0 arg5, Function0 arg6, NavigationEventState arg7) {
        arg0.setForwardEnabled(arg1);
        arg0.setCurrentOnForwardCancelled(arg2);
        arg0.setCurrentOnForwardCompleted(arg3);
        arg0.setBackEnabled(arg4);
        arg0.setCurrentOnBackCancelled(arg5);
        arg0.setCurrentOnBackCompleted(arg6);
        arg0.setInfo(arg7.getCurrentInfo(), arg7.getBackInfo(), arg7.getForwardInfo());
        return Unit.INSTANCE;
    }

    static final DisposableEffectResult NavigationEventHandler$lambda$16$lambda$15(NavigationEventState arg3, ComposeNavigationEventHandler arg4, NavigationEventDispatcher arg5, DisposableEffectScope arg6) {
        if(arg3.getSourceHandler$navigationevent_compose() == null) {
            arg3.setSourceHandler$navigationevent_compose(arg4);
            NavigationEventDispatcher.addHandler$default(arg5, arg4, 0, 2, null);
            return new NavigationEventHandlerKt$NavigationEventHandler$lambda$16$lambda$15$$inlined$onDispose$1(arg4, arg3);
        }

        throw new IllegalArgumentException("NavigationEventState \'" + arg3 + "\' is already registered with a NavigationEventHandler \'" + arg4 + "\'.".toString());
    }

    static final Unit NavigationEventHandler$lambda$17(NavigationEventState arg11, boolean arg12, Function0 arg13, Function0 arg14, boolean arg15, Function0 arg16, Function0 arg17, int arg18, int arg19, Composer arg20, int arg21) {
        NavigationEventHandlerKt.NavigationEventHandler(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    static final Unit NavigationEventHandler$lambda$3$lambda$2() {
        return Unit.INSTANCE;
    }

    static final Unit NavigationEventHandler$lambda$5$lambda$4() {
        return Unit.INSTANCE;
    }

    static final Unit NavigationEventHandler$lambda$7$lambda$6() {
        return Unit.INSTANCE;
    }

    public static final void NavigationForwardHandler(NavigationEventState arg16, boolean arg17, Function0 arg18, Function0 arg19, Composer arg20, int arg21, int arg22) {
        Object v3_2;
        boolean v2_1;
        NavigationEventHandlerKt$$ExternalSyntheticLambda8 v0_3;
        NavigationEventHandlerKt$$ExternalSyntheticLambda7 v0_2;
        Function0 v8_3;
        NavigationEventHandlerKt$$ExternalSyntheticLambda0 v4_2;
        int v8;
        int v6;
        boolean v4;
        int v2;
        NavigationEventState v1;
        int v5 = arg21;
        int v0 = 0x986DC709;
        Composer v13 = arg20.startRestartGroup(v0);
        ComposerKt.sourceInformation(v13, "C(NavigationForwardHandler)N(state,isForwardEnabled,onForwardCancelled,onForwardCompleted)179@7856L2,187@8120L2,188@8150L2,182@7904L302:NavigationEventHandler.kt#wc8b4r");
        if((v5 & 6) == 0) {
            v1 = arg16;
            v2 = v13.changed(v1) ? 4 : 2;
            v2 |= v5;
        }
        else {
            v1 = arg16;
            v2 = v5;
        }

        int v3 = arg22 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_32;
        }
        else if((v5 & 0x30) == 0) {
            v4 = arg17;
            v6 = v13.changed(v4) ? 0x20 : 16;
            v2 |= v6;
        }
        else {
        label_32:
            v4 = arg17;
        }

        v6 = arg22 & 4;
        if(v6 != 0) {
            v2 |= 0x180;
        }
        else if((v5 & 0x180) == 0) {
            v8 = v13.changedInstance(arg18) ? 0x100 : 0x80;
            v2 |= v8;
        }

        Function0 v9 = arg19;
        if((v5 & 0xC00) == 0) {
            v8 = v13.changedInstance(v9) ? 0x800 : 0x400;
            v2 |= v8;
        }

        boolean v8_1 = (v2 & 0x493) != 1170 ? true : false;
        if(v13.shouldExecute(v8_1, v2 & 1)) {
            boolean v7 = v3 != 0 ? true : v4;
            String v3_1 = "CC(remember):NavigationEventHandler.kt#9igjgp";
            if(v6 != 0) {
                ComposerKt.sourceInformationMarkerStart(v13, 874004363, v3_1);
                Object v4_1 = v13.rememberedValue();
                if(v4_1 == Composer.Companion.getEmpty()) {
                    v4_2 = new NavigationEventHandlerKt$$ExternalSyntheticLambda0();
                    v13.updateRememberedValue(v4_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v13);
                Object v8_2 = v4_2;
            }
            else {
                v8_3 = arg18;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.navigationevent.compose.NavigationForwardHandler (NavigationEventHandler.kt:181)");
            }

            ComposerKt.sourceInformationMarkerStart(v13, 0x3418608B, v3_1);
            Object v0_1 = v13.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = new NavigationEventHandlerKt$$ExternalSyntheticLambda7();
                v13.updateRememberedValue(v0_2);
            }

            Object v11 = v0_2;
            ComposerKt.sourceInformationMarkerEnd(v13);
            ComposerKt.sourceInformationMarkerStart(v13, 874013771, v3_1);
            v0_1 = v13.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_3 = new NavigationEventHandlerKt$$ExternalSyntheticLambda8();
                v13.updateRememberedValue(v0_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            NavigationEventHandlerKt.NavigationEventHandler(v1, v7, v8_3, v9, false, ((Function0)v11), v0_3, v13, v2 & 14 | 0x1B6000 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v7;
            v3_2 = v8_3;
        }
        else {
            v13.skipToGroupEnd();
            Function0 v3_3 = arg18;
            v2_1 = v4;
        }

        ScopeUpdateScope v7_1 = v13.endRestartGroup();
        if(v7_1 != null) {
            v7_1.updateScope(new NavigationEventHandlerKt$$ExternalSyntheticLambda9(arg16, v2_1, ((Function0)v3_2), arg19, v5, arg22));
        }
    }

    static final Unit NavigationForwardHandler$lambda$26$lambda$25() {
        return Unit.INSTANCE;
    }

    static final Unit NavigationForwardHandler$lambda$28$lambda$27() {
        return Unit.INSTANCE;
    }

    static final Unit NavigationForwardHandler$lambda$30$lambda$29() {
        return Unit.INSTANCE;
    }

    static final Unit NavigationForwardHandler$lambda$31(NavigationEventState arg7, boolean arg8, Function0 arg9, Function0 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        NavigationEventHandlerKt.NavigationForwardHandler(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }
}

