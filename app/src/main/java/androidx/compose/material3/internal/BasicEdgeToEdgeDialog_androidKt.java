package androidx.compose.material3.internal;

import androidx.compose.material3.ContentColorKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\\\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\t2\u0017\u0010\u000B\u001A\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000EH\u0001¢\u0006\u0002\u0010\u000F\u001A\u0014\u0010\u0010\u001A\u00020\t*\u00020\u00112\u0006\u0010\u0012\u001A\u00020\tH\u0000¨\u0006\u0013²\u0006\u001B\u0010\u0014\u001A\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000EX\u008A\u0084\u0002²\u0006\u0010\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00010\u0003X\u008A\u0084\u0002²\u0006\n\u0010\u0016\u001A\u00020\tX\u008A\u0084\u0002"}, d2={"BasicEdgeToEdgeDialog", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "lightStatusBars", "", "lightNavigationBars", "content", "Lkotlin/Function1;", "Landroidx/compose/material3/internal/PredictiveBackState;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "shouldApplySecureFlag", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isSecureFlagSetOnParent", "material3", "currentContent", "currentOnDismissRequest", "currentDismissOnBackPress"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BasicEdgeToEdgeDialog_androidKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[SecureFlagPolicy.values().length];
            try {
                v0[SecureFlagPolicy.SecureOff.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[SecureFlagPolicy.SecureOn.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[SecureFlagPolicy.Inherit.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    public static final void BasicEdgeToEdgeDialog(Function0 arg24, Modifier arg25, DialogProperties arg26, boolean arg27, boolean arg28, Function3 arg29, Composer arg30, int arg31, int arg32) {
        Modifier v2_2;
        DialogProperties v3_6;
        BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda1 v3_4;
        int v19;
        DialogWrapper v0_3;
        BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda0 v15_2;
        DialogProperties v2_1;
        Companion v14_2;
        boolean v4_3;
        Object v4_2;
        ProvidableCompositionLocal v4_1;
        Modifier v3_2;
        int v16;
        boolean v8_1;
        int v8;
        boolean v7_1;
        DialogProperties v6;
        int v5;
        Modifier v4;
        int v2;
        Function0 v1 = arg24;
        Function3 v9 = arg29;
        int v10 = arg31;
        int v0 = 0x308D86A1;
        Composer v11 = arg30.startRestartGroup(v0);
        ComposerKt.sourceInformation(v11, "C(BasicEdgeToEdgeDialog)N(onDismissRequest,modifier,properties,lightStatusBars,lightNavigationBars,content)91@3820L7,92@3859L7,93@3914L7,94@3944L28,95@4009L21,95@3992L38,97@4058L29,98@4123L38,99@4199L51,102@4277L1031,128@5339L129,128@5314L154,137@5485L285,137@5474L296:BasicEdgeToEdgeDialog.android.kt#mqatfk");
        if((arg32 & 1) != 0) {
            v2 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v2 = v11.changedInstance(v1) ? 4 : 2;
            v2 |= v10;
        }
        else {
            v2 = v10;
        }

        int v3 = arg32 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_36;
        }
        else if((v10 & 0x30) == 0) {
            v4 = arg25;
            v5 = v11.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_36:
            v4 = arg25;
        }

        v5 = arg32 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_51;
        }
        else if((v10 & 0x180) == 0) {
            v6 = arg26;
            int v7 = v11.changed(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_51:
            v6 = arg26;
        }

        if((v10 & 0xC00) == 0) {
            if((arg32 & 8) == 0) {
                v7_1 = arg27;
                if(v11.changed(v7_1)) {
                    v8 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v7_1 = arg27;
            label_62:
                v8 = 0x400;
            }

            v2 |= v8;
        }
        else {
            v7_1 = arg27;
        }

        if((v10 & 0x6000) == 0) {
            if((arg32 & 16) == 0) {
                v8_1 = arg28;
                if(v11.changed(v8_1)) {
                    v16 = 0x4000;
                }
                else {
                    goto label_76;
                }
            }
            else {
                v8_1 = arg28;
            label_76:
                v16 = 0x2000;
            }

            v2 |= v16;
        }
        else {
            v8_1 = arg28;
        }

        int v17 = 0x30000;
        if((arg32 & 0x20) != 0) {
            v2 |= v17;
        }
        else if((v10 & v17) == 0) {
            v16 = v11.changedInstance(v9) ? 0x20000 : 0x10000;
            v2 |= v16;
        }

        boolean v14 = (v2 & 74899) != 74898 ? true : false;
        if(v11.shouldExecute(v14, v2 & 1)) {
            v11.startDefaults();
            ComposerKt.sourceInformation(v11, "37@1426L7,39@1507L7");
            String v15 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            int v12 = 0x789C5F52;
            if((v10 & 1) == 0 || (v11.getDefaultsInvalid())) {
                if(v3 != 0) {
                    Companion v3_1 = Modifier.Companion;
                }
                else {
                    v3_2 = v4;
                }

                DialogProperties v18 = v5 != 0 ? new DialogProperties(false, false, false, 7, null) : v6;
                float v5_1 = 0.5f;
                if((arg32 & 8) != 0) {
                    v4_1 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(v11, v12, v15);
                    v4_2 = v11.consume(((CompositionLocal)v4_1));
                    ComposerKt.sourceInformationMarkerEnd(v11);
                    v4_3 = ColorKt.luminance-8_81llA(((Color)v4_2).unbox-impl()) < v5_1 ? true : false;
                    v2 &= 0xFFFFE3FF;
                    v7_1 = v4_3;
                }

                if((arg32 & 16) != 0) {
                    v4_1 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(v11, v12, v15);
                    v4_2 = v11.consume(((CompositionLocal)v4_1));
                    ComposerKt.sourceInformationMarkerEnd(v11);
                    v4_3 = ColorKt.luminance-8_81llA(((Color)v4_2).unbox-impl()) < v5_1 ? true : false;
                    v2 &= 0xFFFF1FFF;
                    v14_2 = ((Companion)v3_2);
                    v8_1 = v4_3;
                }
                else {
                    v14_2 = ((Companion)v3_2);
                }

                v3 = v2;
                v2_1 = v18;
            }
            else {
                v11.skipToGroupEnd();
                if((arg32 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                if((arg32 & 16) != 0) {
                    v2 &= 0xFFFF1FFF;
                }

                v3 = v2;
                Modifier v14_1 = v4;
                v2_1 = v6;
            }

            v11.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.internal.BasicEdgeToEdgeDialog (BasicEdgeToEdgeDialog.android.kt:90)");
            }

            ProvidableCompositionLocal v0_1 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(v11, v12, v15);
            Object v0_2 = v11.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v11);
            v4_1 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v11, v12, v15);
            v4_2 = v11.consume(((CompositionLocal)v4_1));
            ComposerKt.sourceInformationMarkerEnd(v11);
            Object v5_2 = v4_2;
            v4_1 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v11, v12, v15);
            v4_2 = v11.consume(((CompositionLocal)v4_1));
            ComposerKt.sourceInformationMarkerEnd(v11);
            CompositionContext v12_1 = ComposablesKt.rememberCompositionContext(v11, 0);
            Object[] v6_1 = new Object[0];
            String v13 = "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v11, 0x43469F16, v13);
            Object v15_1 = v11.rememberedValue();
            DialogProperties v25 = v2_1;
            if(v15_1 == Composer.Companion.getEmpty()) {
                v15_2 = new BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda0();
                v11.updateRememberedValue(v15_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            Object v6_2 = RememberSaveableKt.rememberSaveable(v6_1, ((Function0)v15_2), v11, 0x30);
            State v15_3 = SnapshotStateKt.rememberUpdatedState(v9, v11, v3 >> 15 & 14);
            v2 = v3 & 14;
            State v9_1 = SnapshotStateKt.rememberUpdatedState(v1, v11, v2);
            int v26 = v2;
            State v1_1 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(v25.getDismissOnBackPress()), v11, 0);
            ComposerKt.sourceInformationMarkerStart(v11, 1128711304, v13);
            v2 = v11.changed(v0_2) | v11.changed(v5_2);
            Object v27 = v0_2;
            v0_2 = v11.rememberedValue();
            if(v2 != 0 || v0_2 == Composer.Companion.getEmpty()) {
                v2_1 = v25;
                v19 = v3;
                v0_3 = new DialogWrapper(arg24, v2_1, v27, ((LayoutDirection)v4_2), ((Density)v5_2), ((UUID)v6_2), v7_1, v8_1);
                v5 = 1;
                v0_3.setContent(v12_1, ComposableLambdaKt.composableLambdaInstance(0xDA185962, true, new BasicEdgeToEdgeDialog_androidKt$BasicEdgeToEdgeDialog$dialog$1$1$1(((Modifier)v14_2), v1_1, v9_1, v15_3)));
                v11.updateRememberedValue(v0_3);
            }
            else {
                v2_1 = v25;
                v19 = v3;
                v5 = 1;
            }

            Object v1_2 = v0_3;
            ComposerKt.sourceInformationMarkerEnd(v11);
            ComposerKt.sourceInformationMarkerStart(v11, 0x434745C2, v13);
            boolean v0_4 = v11.changedInstance(v1_2);
            Object v3_3 = v11.rememberedValue();
            if((v0_4) || v3_3 == Composer.Companion.getEmpty()) {
                v3_4 = new BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda1(((DialogWrapper)v1_2));
                v11.updateRememberedValue(v3_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            EffectsKt.DisposableEffect(v1_2, ((Function1)v3_4), v11, 0);
            ComposerKt.sourceInformationMarkerStart(v11, 0x4347589E, v13);
            v0_4 = v11.changedInstance(v1_2);
            v3 = v26 == 4 ? v5 : 0;
            v0 = (((int)v0_4)) | v3;
            v3 = v19;
            int v6_3 = (v3 & 0x380) == 0x100 ? v5 : 0;
            v0 = v0 | v6_3 | v11.changed(v4_2.ordinal());
            int v9_2 = 0x800;
            v6_3 = (v3 & 0x1C00 ^ 0xC00) > v9_2 && (v11.changed(v7_1)) || (v3 & 0xC00) == v9_2 ? v5 : 0;
            v0 |= v6_3;
            v9_2 = 0x4000;
            v12 = (0xE000 & v3 ^ 0x6000) > v9_2 && (v11.changed(v8_1)) || (v3 & 0x6000) == v9_2 ? v5 : 0;
            v3_3 = v11.rememberedValue();
            if((v0 | v12) != 0 || v3_3 == Composer.Companion.getEmpty()) {
                BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda2 v0_5 = new BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda2(((DialogWrapper)v1_2), arg24, v2_1, ((LayoutDirection)v4_2), v7_1, v8_1);
                v2_1 = v2_1;
                v11.updateRememberedValue(v0_5);
                BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda2 v3_5 = v0_5;
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            EffectsKt.SideEffect(((Function0)v3_3), v11, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_6 = v2_1;
            v2_2 = ((Modifier)v14_2);
        }
        else {
            v11.skipToGroupEnd();
            v2_2 = v4;
            v3_6 = v6;
        }

        v4_3 = v7_1;
        boolean v5_3 = v8_1;
        ScopeUpdateScope v9_3 = v11.endRestartGroup();
        if(v9_3 != null) {
            v9_3.updateScope(new BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda3(arg24, v2_2, v3_6, v4_3, v5_3, arg29, arg31, arg32));
        }
    }

    static final UUID BasicEdgeToEdgeDialog$lambda$1$lambda$0() {
        return UUID.randomUUID();
    }

    static final Unit BasicEdgeToEdgeDialog$lambda$11$lambda$10(DialogWrapper arg0, Function0 arg1, DialogProperties arg2, LayoutDirection arg3, boolean arg4, boolean arg5) {
        arg0.updateParameters(arg1, arg2, arg3, arg4, arg5);
        return Unit.INSTANCE;
    }

    static final Unit BasicEdgeToEdgeDialog$lambda$12(Function0 arg10, Modifier arg11, DialogProperties arg12, boolean arg13, boolean arg14, Function3 arg15, int arg16, int arg17, Composer arg18, int arg19) {
        BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog(arg10, arg11, arg12, arg13, arg14, arg15, arg18, RecomposeScopeImplKt.updateChangedFlags(arg16 | 1), arg17);
        return Unit.INSTANCE;
    }

    private static final Function3 BasicEdgeToEdgeDialog$lambda$2(State arg0) {
        return arg0.getValue();
    }

    private static final Function0 BasicEdgeToEdgeDialog$lambda$3(State arg0) {
        return arg0.getValue();
    }

    private static final boolean BasicEdgeToEdgeDialog$lambda$4(State arg0) {
        return arg0.getValue().booleanValue();
    }

    static final DisposableEffectResult BasicEdgeToEdgeDialog$lambda$9$lambda$8(DialogWrapper arg0, DisposableEffectScope arg1) {
        arg0.show();
        return new BasicEdgeToEdgeDialog_androidKt$BasicEdgeToEdgeDialog$lambda$9$lambda$8$$inlined$onDispose$1(arg0);
    }

    public static final Function3 access$BasicEdgeToEdgeDialog$lambda$2(State arg0) {
        return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$2(arg0);
    }

    public static final Function0 access$BasicEdgeToEdgeDialog$lambda$3(State arg0) {
        return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$3(arg0);
    }

    public static final boolean access$BasicEdgeToEdgeDialog$lambda$4(State arg0) {
        return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$4(arg0);
    }

    public static final boolean shouldApplySecureFlag(SecureFlagPolicy arg2, boolean arg3) {
        int v2 = WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()];
        if(v2 != 1) {
            if(v2 != 2) {
                if(v2 == 3) {
                    return arg3;
                }

                throw new NoWhenBranchMatchedException();
            }

            return 1;
        }

        return 0;
    }
}

