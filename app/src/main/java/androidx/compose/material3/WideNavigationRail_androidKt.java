package androidx.compose.material3;

import androidx.compose.foundation.DarkThemeKt;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\b\u0010\u0000\u001A\u00020\u0001H\u0000\u001A`\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0006\u001A\u00020\u00012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u000B\u001A\u00020\f2\u0011\u0010\r\u001A\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u000EH\u0001¢\u0006\u0002\u0010\u000F¨\u0006\u0010²\u0006\u0015\u0010\u0011\u001A\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u000EX\u008A\u0084\u0002"}, d2={"createDefaultModalWideNavigationRailProperties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "ModalWideNavigationRailDialog", "", "onDismissRequest", "Lkotlin/Function0;", "properties", "onPredictiveBack", "Lkotlin/Function1;", "", "onPredictiveBackCancelled", "predictiveBackState", "Landroidx/compose/material3/RailPredictiveBackState;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/ModalWideNavigationRailProperties;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/RailPredictiveBackState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3", "currentContent"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WideNavigationRail_androidKt {
    public static final void ModalWideNavigationRailDialog(Function0 arg19, ModalWideNavigationRailProperties arg20, Function1 arg21, Function0 arg22, RailPredictiveBackState arg23, Function2 arg24, Composer arg25, int arg26) {
        WideNavigationRail_androidKt$$ExternalSyntheticLambda2 v5_4;
        WideNavigationRail_androidKt$$ExternalSyntheticLambda1 v5_2;
        int v6_2;
        int v17;
        Object v5_1;
        int v4;
        int v3;
        Function0 v1 = arg19;
        ModalWideNavigationRailProperties v2 = arg20;
        Function2 v11 = arg24;
        int v12 = arg26;
        int v0 = 2015914411;
        Composer v13 = arg25.startRestartGroup(v0);
        ComposerKt.sourceInformation(v13, "C(ModalWideNavigationRailDialog)N(onDismissRequest,properties,onPredictiveBack,onPredictiveBackCancelled,predictiveBackState,content)125@5147L7,126@5186L7,127@5241L7,128@5271L28,129@5326L29,130@5392L21,130@5375L38,131@5441L21,133@5488L652,153@6171L129,153@6146L154,162@6317L183,162@6306L194:WideNavigationRail.android.kt#uh7d8r");
        if((v12 & 6) == 0) {
            v3 = v13.changedInstance(v1) ? 4 : 2;
            v3 |= v12;
        }
        else {
            v3 = v12;
        }

        if((v12 & 0x30) == 0) {
            v4 = v13.changed(v2) ? 0x20 : 16;
            v3 |= v4;
        }

        Function1 v7 = arg21;
        if((v12 & 0x180) == 0) {
            v4 = v13.changedInstance(v7) ? 0x100 : 0x80;
            v3 |= v4;
        }

        Function0 v8 = arg22;
        if((v12 & 0xC00) == 0) {
            v4 = v13.changedInstance(v8) ? 0x800 : 0x400;
            v3 |= v4;
        }

        RailPredictiveBackState v9 = arg23;
        if((v12 & 0x6000) == 0) {
            v4 = v13.changed(v9) ? 0x4000 : 0x2000;
            v3 |= v4;
        }

        if((0x30000 & v12) == 0) {
            v4 = v13.changedInstance(v11) ? 0x20000 : 0x10000;
            v3 |= v4;
        }

        boolean v4_1 = (74899 & v3) != 74898 ? true : false;
        if(v13.shouldExecute(v4_1, v3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.ModalWideNavigationRailDialog (WideNavigationRail.android.kt:124)");
            }

            ProvidableCompositionLocal v0_1 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(v13, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = v13.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v13);
            ProvidableCompositionLocal v6 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v13, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v6_1 = v13.consume(((CompositionLocal)v6));
            ComposerKt.sourceInformationMarkerEnd(v13);
            ProvidableCompositionLocal v15 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v13, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v4_2 = v13.consume(((CompositionLocal)v15));
            ComposerKt.sourceInformationMarkerEnd(v13);
            CompositionContext v15_1 = ComposablesKt.rememberCompositionContext(v13, 0);
            State v5 = SnapshotStateKt.rememberUpdatedState(v11, v13, v3 >> 15 & 14);
            Object[] v14 = new Object[0];
            String v11_1 = "CC(remember):WideNavigationRail.android.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v13, 0xFB4F4E0, v11_1);
            Object v10 = v13.rememberedValue();
            if(v10 == Composer.Companion.getEmpty()) {
                WideNavigationRail_androidKt$$ExternalSyntheticLambda0 v10_1 = new WideNavigationRail_androidKt$$ExternalSyntheticLambda0();
                v13.updateRememberedValue(v10_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            Object v1_1 = RememberSaveableKt.rememberSaveable(v14, ((Function0)v10), v13, 0x30);
            boolean v14_1 = DarkThemeKt.isSystemInDarkTheme(v13, 0);
            ComposerKt.sourceInformationMarkerStart(v13, 0xFB50357, v11_1);
            int v10_2 = v13.changed(v0_2) | v13.changed(v6_1);
            Object v18 = v0_2;
            v0_2 = v13.rememberedValue();
            if(v10_2 != 0 || v0_2 == Composer.Companion.getEmpty()) {
                v12 = 0;
                v17 = v3;
                boolean v10_3 = v14_1;
                State v14_2 = v5;
                v5_1 = v6_1;
                v6_1 = v1_1;
                v1 = arg19;
                ModalWideNavigationRailDialogWrapper v0_3 = new ModalWideNavigationRailDialogWrapper(v1, v2, v18, ((LayoutDirection)v4_2), ((Density)v5_1), ((UUID)v6_1), v7, v8, v9, v10_3);
                v6_2 = 1;
                v0_3.setContent(v15_1, ComposableLambdaKt.composableLambdaInstance(-406777160, true, new WideNavigationRail_androidKt$ModalWideNavigationRailDialog$dialog$1$1$1(v14_2)));
                v13.updateRememberedValue(v0_3);
            }
            else {
                v17 = v3;
                v6_2 = 1;
                v12 = 0;
                v1 = arg19;
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            ComposerKt.sourceInformationMarkerStart(v13, 0xFB556AC, v11_1);
            boolean v3_1 = v13.changedInstance(v0_2);
            v5_1 = v13.rememberedValue();
            if((v3_1) || v5_1 == Composer.Companion.getEmpty()) {
                v5_2 = new WideNavigationRail_androidKt$$ExternalSyntheticLambda1(((ModalWideNavigationRailDialogWrapper)v0_2));
                v13.updateRememberedValue(v5_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            EffectsKt.DisposableEffect(v0_2, ((Function1)v5_2), v13, v12);
            ComposerKt.sourceInformationMarkerStart(v13, 0xFB56922, v11_1);
            v3_1 = v13.changedInstance(v0_2);
            int v5_3 = (v17 & 14) == 4 ? v6_2 : v12;
            v3 = (((int)v3_1)) | v5_3;
            if((v17 & 0x70) == 0x20) {
            }
            else {
                v6_2 = v12;
            }

            v3 = v3 | v6_2 | v13.changed(v4_2.ordinal());
            v5_1 = v13.rememberedValue();
            if(v3 != 0 || v5_1 == Composer.Companion.getEmpty()) {
                v5_4 = new WideNavigationRail_androidKt$$ExternalSyntheticLambda2(((ModalWideNavigationRailDialogWrapper)v0_2), v1, v2, ((LayoutDirection)v4_2));
                v13.updateRememberedValue(v5_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            EffectsKt.SideEffect(((Function0)v5_4), v13, v12);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_198;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v13.skipToGroupEnd();
        }

    label_198:
        ScopeUpdateScope v8_1 = v13.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new WideNavigationRail_androidKt$$ExternalSyntheticLambda3(v1, v2, arg21, arg22, arg23, arg24, arg26));
        }
    }

    private static final Function2 ModalWideNavigationRailDialog$lambda$0(State arg0) {
        return arg0.getValue();
    }

    static final Unit ModalWideNavigationRailDialog$lambda$10(Function0 arg8, ModalWideNavigationRailProperties arg9, Function1 arg10, Function0 arg11, RailPredictiveBackState arg12, Function2 arg13, int arg14, Composer arg15, int arg16) {
        WideNavigationRail_androidKt.ModalWideNavigationRailDialog(arg8, arg9, arg10, arg11, arg12, arg13, arg15, RecomposeScopeImplKt.updateChangedFlags(arg14 | 1));
        return Unit.INSTANCE;
    }

    static final UUID ModalWideNavigationRailDialog$lambda$2$lambda$1() {
        return UUID.randomUUID();
    }

    static final DisposableEffectResult ModalWideNavigationRailDialog$lambda$7$lambda$6(ModalWideNavigationRailDialogWrapper arg0, DisposableEffectScope arg1) {
        arg0.show();
        return new WideNavigationRail_androidKt$ModalWideNavigationRailDialog$lambda$7$lambda$6$$inlined$onDispose$1(arg0);
    }

    static final Unit ModalWideNavigationRailDialog$lambda$9$lambda$8(ModalWideNavigationRailDialogWrapper arg0, Function0 arg1, ModalWideNavigationRailProperties arg2, LayoutDirection arg3) {
        arg0.updateParameters(arg1, arg2, arg3);
        return Unit.INSTANCE;
    }

    public static final Function2 access$ModalWideNavigationRailDialog$lambda$0(State arg0) {
        return WideNavigationRail_androidKt.ModalWideNavigationRailDialog$lambda$0(arg0);
    }

    public static final ModalWideNavigationRailProperties createDefaultModalWideNavigationRailProperties() {
        return new ModalWideNavigationRailProperties(false, 1, null);
    }
}

