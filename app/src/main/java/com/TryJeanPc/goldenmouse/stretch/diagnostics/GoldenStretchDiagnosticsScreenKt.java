package com.TryJeanPc.goldenmouse.stretch.diagnostics;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.text.selection.SelectionContainerKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import com.TryJeanPc.goldenmouse.GoldenUiColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u001B\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005²\u0006\f\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u008A\u008E\u0002²\u0006\n\u0010\b\u001A\u00020\tX\u008A\u008E\u0002²\u0006\f\u0010\n\u001A\u0004\u0018\u00010\u000BX\u008A\u008E\u0002²\u0006\f\u0010\f\u001A\u0004\u0018\u00010\u0007X\u008A\u008E\u0002"}, d2={"GoldenStretchDiagnosticsScreen", "", "onBack", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app", "report", "", "running", "", "job", "Lkotlinx/coroutines/Job;", "shareError"}, k=2, mv={2, 2, 0}, xi=0x30) public final class GoldenStretchDiagnosticsScreenKt {
    public static final void GoldenStretchDiagnosticsScreen(Function0 arg50, Composer arg51, int arg52) {
        GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda12 v4_7;
        GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda11 v8_1;
        Object v18;
        Object v16;
        GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda10 v6_4;
        GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda9 v7_1;
        GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda7 v4_2;
        MutableState v9_3;
        GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda4 v10_2;
        CoroutineScope v9_1;
        int v3;
        Function0 v0 = arg50;
        Intrinsics.checkNotNullParameter(v0, "onBack");
        int v2 = 187937098;
        Composer v13 = arg51.startRestartGroup(v2);
        ComposerKt.sourceInformation(v13, "C(GoldenStretchDiagnosticsScreen)N(onBack)39@1757L7,41@1859L7,42@1883L24,43@1943L33,43@1926L50,44@1996L34,45@2046L39,46@2108L42,64@2969L27,65@3001L27,66@3066L263,66@3033L296,72@3435L21,71@3334L2478:GoldenStretchDiagnosticsScreen.kt#e575ws");
        int v4 = 4;
        int v5 = 2;
        if((arg52 & 6) == 0) {
            v3 = v13.changedInstance(v0) ? v4 : v5;
            v3 |= arg52;
        }
        else {
            v3 = arg52;
        }

        boolean v6 = (v3 & 3) != v5 ? true : false;
        if(v13.shouldExecute(v6, v3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v3, -1, "com.TryJeanPc.goldenmouse.stretch.diagnostics.GoldenStretchDiagnosticsScreen (GoldenStretchDiagnosticsScreen.kt:38)");
            }

            ProvidableCompositionLocal v2_1 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(v13, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v2_2 = v13.consume(((CompositionLocal)v2_1));
            ComposerKt.sourceInformationMarkerEnd(v13);
            Context v19 = ((Context)v2_2).getApplicationContext();
            ProvidableCompositionLocal v10 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(v13, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v6_1 = v13.consume(((CompositionLocal)v10));
            ComposerKt.sourceInformationMarkerEnd(v13);
            ComposerKt.sourceInformationMarkerStart(v13, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v13, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
            Object v9 = v13.rememberedValue();
            if(v9 == Composer.Companion.getEmpty()) {
                v9_1 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v13);
                v13.updateRememberedValue(v9_1);
            }

            Object v15 = v9_1;
            ComposerKt.sourceInformationMarkerEnd(v13);
            ComposerKt.sourceInformationMarkerEnd(v13);
            Object[] v9_2 = new Object[0];
            String v11 = "CC(remember):GoldenStretchDiagnosticsScreen.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v13, 0xD0CAAAB, v11);
            Object v10_1 = v13.rememberedValue();
            if(v10_1 == Composer.Companion.getEmpty()) {
                v10_2 = new GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda4();
                v13.updateRememberedValue(v10_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            Object v17 = RememberSaveableKt.rememberSaveable(v9_2, ((Function0)v10_2), v13, 0x30);
            ComposerKt.sourceInformationMarkerStart(v13, 0xD0CB14C, v11);
            v9 = v13.rememberedValue();
            SnapshotMutationPolicy v14 = null;
            if(v9 == Composer.Companion.getEmpty()) {
                v9_3 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), v14, v5, v14);
                v13.updateRememberedValue(v9_3);
            }

            Object v29 = v9;
            ComposerKt.sourceInformationMarkerEnd(v13);
            ComposerKt.sourceInformationMarkerStart(v13, 0xD0CB791, v11);
            v9 = v13.rememberedValue();
            if(v9 == Composer.Companion.getEmpty()) {
                v9_3 = SnapshotStateKt.mutableStateOf$default(v14, v14, v5, v14);
                v13.updateRememberedValue(v9_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            ComposerKt.sourceInformationMarkerStart(v13, 0xD0CBF54, v11);
            v10_1 = v13.rememberedValue();
            if(v10_1 == Composer.Companion.getEmpty()) {
                MutableState v10_3 = SnapshotStateKt.mutableStateOf$default(v14, v14, v5, v14);
                v13.updateRememberedValue(v10_3);
            }

            Object v30 = v10_1;
            ComposerKt.sourceInformationMarkerEnd(v13);
            ComposerKt.sourceInformationMarkerStart(v13, 0xD0D2AE5, v11);
            v3 = (v3 & 14) == v4 ? 1 : 0;
            Object v4_1 = v13.rememberedValue();
            if(v3 != 0 || v4_1 == Composer.Companion.getEmpty()) {
                v4_2 = new GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda7(v0, ((MutableState)v9));
                v13.updateRememberedValue(v4_2);
            }

            Object v3_1 = v4_2;
            ComposerKt.sourceInformationMarkerEnd(v13);
            BackHandlerKt.BackHandler(false, ((Function0)v3_1), v13, 0, 1);
            ComposerKt.sourceInformationMarkerStart(v13, 0xD0D37F1, v11);
            boolean v4_3 = v13.changedInstance(v6_1);
            v10_1 = v13.rememberedValue();
            if((v4_3) || v10_1 == Composer.Companion.getEmpty()) {
                GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda8 v10_4 = new GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda8(((LifecycleOwner)v6_1), ((MutableState)v9));
                v13.updateRememberedValue(v10_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            EffectsKt.DisposableEffect(v6_1, ((Function1)v10_1), v13, 0);
            Modifier v4_4 = PaddingKt.padding-3ABfNKs(ScrollKt.verticalScroll$default(WindowInsetsPadding_androidKt.safeDrawingPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0f, 1, v14), GoldenUiColorsKt.getObsidianBlack(), null, 2, null)), ScrollKt.rememberScrollState(0, v13, 0, 1), false, null, false, 14, null), Dp.constructor-impl(24f));
            HorizontalOrVertical v10_5 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(16f));
            ComposerKt.sourceInformationMarkerStart(v13, 0x4FF7456F, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy v5_1 = ColumnKt.columnMeasurePolicy(((Vertical)v10_5), Alignment.Companion.getStart(), v13, 6);
            ComposerKt.sourceInformationMarkerStart(v13, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int v10_6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v13, 0));
            CompositionLocalMap v12 = v13.getCurrentCompositionLocalMap();
            v4_4 = ComposedModifierKt.materializeModifier(v13, v4_4);
            Function0 v6_2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v13, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(v13.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v13.startReusableNode();
            if(v13.getInserting()) {
                v13.createNode(v6_2);
            }
            else {
                v13.useNode();
            }

            Composer v6_3 = Updater.constructor-impl(v13);
            Updater.set-impl(v6_3, v5_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v6_3, v12, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v6_3, Integer.valueOf(v10_6), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v6_3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v6_3, v4_4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v13, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v13, 0xB0FE66B0, "C73@3614L10,74@3682L13,73@3535L161,75@3705L91,77@3926L73,78@4023L16,76@3805L284,80@4213L15,79@4098L196,86@4660L557,94@5219L120,85@4527L812,95@5348L111,97@5613L193,97@5594L212:GoldenStretchDiagnosticsScreen.kt#e575ws");
            long v5_2 = GoldenUiColorsKt.getMetallicGold();
            TextStyle v24 = MaterialTheme.INSTANCE.getTypography(v13, MaterialTheme.$stable).getHeadlineSmall();
            Companion v4_5 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v13, 0xFD739941, v11);
            Object v7 = v13.rememberedValue();
            if(v7 == Composer.Companion.getEmpty()) {
                v7_1 = new GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda9();
                v13.updateRememberedValue(v7_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            Object v32 = v15;
            Object v35 = v9;
            Object v41 = v3_1;
            Object v51 = v2_2;
            Object v1 = v14;
            v2_2 = v17;
            TextKt.Text-Nvy7gAk("Diagnóstico Golden Stretch", SemanticsModifierKt.semantics$default(((Modifier)v4_5), false, ((Function1)v7_1), 1, v14), v5_2, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, v24, v13, 390, 0, 0x1FFF8);
            TextKt.Text-Nvy7gAk("Solo lectura. Las operaciones de pantalla permanecen bloqueadas.", null, GoldenUiColorsKt.getTextWhite(), null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, v13, 390, 0, 0x3FFFA);
            int v21 = GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$5(((MutableState)v29)) ^ 1;
            float v31 = 48f;
            int v15_1 = 2;
            Modifier v22 = SizeKt.heightIn-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0f, 1, v1), Dp.constructor-impl(v31), 0f, v15_1, v1);
            ButtonColors v7_2 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(GoldenUiColorsKt.getMetallicGold(), GoldenUiColorsKt.getObsidianBlack(), 0, 0, v13, ButtonDefaults.$stable << 12 | 54, 12);
            v13 = v13;
            String v4_6 = v11;
            ComposerKt.sourceInformationMarkerStart(v13, -42744860, v4_6);
            v9 = v32;
            Context v5_3 = v19;
            v3 = v13.changed(v2_2) | v13.changedInstance(v9) | v13.changedInstance(v5_3);
            v6_1 = v13.rememberedValue();
            if(v3 != 0 || v6_1 == Composer.Companion.getEmpty()) {
                v17 = v2_2;
                v19 = v5_3;
                v2 = v15_1;
                v16 = v29;
                v18 = v30;
                v15 = v9;
                GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda10 v14_1 = new GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda10(((CoroutineScope)v15), ((MutableState)v16), ((MutableState)v17), ((MutableState)v18), v19, v35);
                v13.updateRememberedValue(v14_1);
                v6_4 = v14_1;
            }
            else {
                v17 = v2_2;
                v19 = v5_3;
                v2 = v15_1;
                v16 = v29;
                v18 = v30;
                v15 = v9;
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            ButtonKt.Button(v6_4, v22, v21, null, v7_2, null, null, null, null, ComposableSingletons$GoldenStretchDiagnosticsScreenKt.INSTANCE.getLambda$1774586020$app(), v13, 0x30000030, 488);
            v5 = GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$5(((MutableState)v16)) ^ 1;
            Modifier v3_2 = SizeKt.heightIn-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0f, 1, v1), Dp.constructor-impl(v31), 0f, v2, v1);
            String v6_5 = v4_6;
            ComposerKt.sourceInformationMarkerStart(v13, 0xFD73DBA3, v6_5);
            v9 = v17;
            v15 = v15;
            Context v7_3 = v19;
            v4 = v13.changed(v9) | v13.changedInstance(v15) | v13.changedInstance(v7_3);
            Object v8 = v13.rememberedValue();
            if(v4 != 0 || v8 == Composer.Companion.getEmpty()) {
                v17 = v9;
                GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda11 v14_2 = new GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda11(((CoroutineScope)v15), ((MutableState)v16), ((MutableState)v17), ((MutableState)v18), v7_3, v35);
                v13.updateRememberedValue(v14_2);
                v8_1 = v14_2;
            }
            else {
                v17 = v9;
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            v29 = v16;
            Object v34 = v17;
            Object v48 = v18;
            String v2_3 = v6_5;
            ButtonKt.OutlinedButton(v8_1, v3_2, ((boolean)v5), null, null, null, null, null, null, ComposableSingletons$GoldenStretchDiagnosticsScreenKt.INSTANCE.getLambda$-163646878$app(), v13, 0x30000030, 504);
            if(GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$5(((MutableState)v29))) {
                v13.startReplaceGroup(0xB1093E84);
                ComposerKt.sourceInformation(v13, "82@4330L48,83@4469L38,83@4391L117");
                ProgressIndicatorKt.LinearProgressIndicator-rIrjwxo(SizeKt.fillMaxWidth$default(Modifier.Companion, 0f, 1, v1), 0, 0, 0, 0f, v13, 6, 30);
                v5_2 = GoldenUiColorsKt.getTextWhite();
                Companion v3_3 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(v13, 0xFD73FBBA, v2_3);
                v4_1 = v13.rememberedValue();
                if(v4_1 == Composer.Companion.getEmpty()) {
                    v4_7 = new GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda12();
                    v13.updateRememberedValue(v4_7);
                }

                ComposerKt.sourceInformationMarkerEnd(v13);
                TextKt.Text-Nvy7gAk("Leyendo diagnóstico…", SemanticsModifierKt.semantics$default(((Modifier)v3_3), false, ((Function1)v4_7), 1, v1), v5_2, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, v13, 390, 0, 0x3FFF8);
                v13 = v13;
            }
            else {
                v13.startReplaceGroup(0xB0C7CDAE);
            }

            v13.endReplaceGroup();
            boolean v5_4 = GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$2(((MutableState)v34)) == null || (GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$5(((MutableState)v29))) ? false : true;
            v3_2 = SizeKt.heightIn-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0f, 1, v1), Dp.constructor-impl(v31), 0f, 2, v1);
            ComposerKt.sourceInformationMarkerStart(v13, 0xFD7415A1, v2_3);
            v4_1 = v34;
            v7 = v51;
            int v6_6 = v13.changed(v4_1) | v13.changedInstance(v7);
            v8 = v13.rememberedValue();
            if(v6_6 != 0 || v8 == Composer.Companion.getEmpty()) {
                v6_1 = v48;
                GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda1 v8_2 = new GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda1(((MutableState)v4_1), ((Context)v7), ((MutableState)v6_1));
                v13.updateRememberedValue(v8_2);
            }
            else {
                v6_1 = v48;
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            Object v49 = v4_1;
            ButtonKt.OutlinedButton(v8, v3_2, v5_4, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(0xBB39D48B, true, new GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda2(((MutableState)v4_1), v29), v13, 54), v13, 0x30000030, 504);
            ButtonKt.TextButton(v41, SizeKt.heightIn-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(v31), 0f, 2, v1), false, null, null, null, null, null, null, ComposableSingletons$GoldenStretchDiagnosticsScreenKt.INSTANCE.getLambda$-381960713$app(), v13, 0x30000030, 508);
            String v3_4 = GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$11(v6_1);
            if(v3_4 == null) {
                v13.startReplaceGroup(0xB11AD144);
                v13.endReplaceGroup();
            }
            else {
                v13.startReplaceGroup(0xB11AD145);
                ComposerKt.sourceInformation(v13, "*96@5544L38,96@5486L97");
                v5_2 = GoldenUiColorsKt.getTextWhite();
                v4_5 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(v13, 0x3819FFF8, v2_3);
                v2_2 = v13.rememberedValue();
                if(v2_2 == Composer.Companion.getEmpty()) {
                    GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda3 v2_4 = new GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda3();
                    v13.updateRememberedValue(v2_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v13);
                TextKt.Text-Nvy7gAk(v3_4, SemanticsModifierKt.semantics$default(((Modifier)v4_5), false, ((Function1)v2_2), 1, v1), v5_2, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, v13, 0x180, 0, 0x3FFF8);
                v13 = v13;
                v13.endReplaceGroup();
            }

            SelectionContainerKt.SelectionContainer(((Modifier)v1), ComposableLambdaKt.rememberComposableLambda(0x8508EC51, true, new GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda5(v49), v13, 54), v13, 0x30, 1);
            ComposerKt.sourceInformationMarkerEnd(v13);
            ComposerKt.sourceInformationMarkerEnd(v13);
            v13.endNode();
            ComposerKt.sourceInformationMarkerEnd(v13);
            ComposerKt.sourceInformationMarkerEnd(v13);
            ComposerKt.sourceInformationMarkerEnd(v13);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_602;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v13.skipToGroupEnd();
        }

    label_602:
        ScopeUpdateScope v0_1 = v13.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda6(arg50, arg52));
        }
    }

    static final MutableState GoldenStretchDiagnosticsScreen$lambda$1$lambda$0() {
        return SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    private static final String GoldenStretchDiagnosticsScreen$lambda$11(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void GoldenStretchDiagnosticsScreen$lambda$12(MutableState arg0, String arg1) {
        arg0.setValue(arg1);
    }

    static final Unit GoldenStretchDiagnosticsScreen$lambda$14$lambda$13(Function0 arg2, MutableState arg3) {
        Job v3 = GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$8(arg3);
        if(v3 != null) {
            DefaultImpls.cancel$default(v3, null, 1, null);
        }

        arg2.invoke();
        return Unit.INSTANCE;
    }

    static final DisposableEffectResult GoldenStretchDiagnosticsScreen$lambda$18$lambda$17(LifecycleOwner arg2, MutableState arg3, DisposableEffectScope arg4) {
        Intrinsics.checkNotNullParameter(arg4, "$this$DisposableEffect");
        GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda0 v4 = new GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda0(arg3);
        arg2.getLifecycle().addObserver(v4);
        return new GoldenStretchDiagnosticsScreenKt$GoldenStretchDiagnosticsScreen$lambda$18$lambda$17$$inlined$onDispose$1(arg2, ((LifecycleEventObserver)v4), arg3);
    }

    static final void GoldenStretchDiagnosticsScreen$lambda$18$lambda$17$lambda$15(MutableState arg1, LifecycleOwner arg2, Event arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        Intrinsics.checkNotNullParameter(arg3, "event");
        if(arg3 == Event.ON_STOP) {
            Job v1 = GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$8(arg1);
            if(v1 != null) {
                DefaultImpls.cancel$default(v1, null, 1, null);
            }
        }
    }

    private static final String GoldenStretchDiagnosticsScreen$lambda$2(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void GoldenStretchDiagnosticsScreen$lambda$3(MutableState arg0, String arg1) {
        arg0.setValue(arg1);
    }

    static final Unit GoldenStretchDiagnosticsScreen$lambda$35$lambda$20$lambda$19(SemanticsPropertyReceiver arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$semantics");
        SemanticsPropertiesKt.heading(arg1);
        return Unit.INSTANCE;
    }

    static final Unit GoldenStretchDiagnosticsScreen$lambda$35$lambda$22$lambda$21(CoroutineScope arg7, MutableState arg8, MutableState arg9, MutableState arg10, Context arg11, MutableState arg12) {
        GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$start(arg7, arg8, arg9, arg10, arg11, arg12, false);
        return Unit.INSTANCE;
    }

    static final Unit GoldenStretchDiagnosticsScreen$lambda$35$lambda$24$lambda$23(CoroutineScope arg7, MutableState arg8, MutableState arg9, MutableState arg10, Context arg11, MutableState arg12) {
        GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$start(arg7, arg8, arg9, arg10, arg11, arg12, true);
        return Unit.INSTANCE;
    }

    static final Unit GoldenStretchDiagnosticsScreen$lambda$35$lambda$26$lambda$25(SemanticsPropertyReceiver arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$semantics");
        SemanticsPropertiesKt.setLiveRegion-hR3wRGc(arg1, LiveRegionMode.Companion.getPolite-0phEisY());
        return Unit.INSTANCE;
    }

    static final Unit GoldenStretchDiagnosticsScreen$lambda$35$lambda$29$lambda$28(MutableState arg2, Context arg3, MutableState arg4) {
        String v2 = GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$2(arg2);
        if(v2 != null) {
            try {
                Intent v2_1 = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", v2);
                Intrinsics.checkNotNullExpressionValue(v2_1, "putExtra(...)");
                arg3.startActivity(Intent.createChooser(v2_1, "Compartir diagnóstico"));
            }
            catch(SecurityException ) {
                GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$12(arg4, "Android no permitió compartir el informe.");
            }
            catch(ActivityNotFoundException ) {
                GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$12(arg4, "No hay una aplicación disponible para compartir texto.");
            }
        }

        return Unit.INSTANCE;
    }

    static final Unit GoldenStretchDiagnosticsScreen$lambda$35$lambda$30(MutableState arg26, MutableState arg27, RowScope arg28, Composer arg29, int arg30) {
        Composer v0 = arg29;
        int v1 = arg30;
        Intrinsics.checkNotNullParameter(arg28, "$this$OutlinedButton");
        ComposerKt.sourceInformation(v0, "C94@5221L116:GoldenStretchDiagnosticsScreen.kt#e575ws");
        boolean v2 = (v1 & 17) != 16 ? true : false;
        if(v0.shouldExecute(v2, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xBB39D48B, v1, -1, "com.TryJeanPc.goldenmouse.stretch.diagnostics.GoldenStretchDiagnosticsScreen.<anonymous>.<anonymous> (GoldenStretchDiagnosticsScreen.kt:94)");
            }

            long v1_1 = GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$2(arg26) == null || (GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$5(arg27)) ? Color.copy-wmQWz5c$default(GoldenUiColorsKt.getTextWhite(), 0.5f, 0f, 0f, 0f, 14, null) : GoldenUiColorsKt.getMetallicGold();
            TextKt.Text-Nvy7gAk("Compartir resultados", null, v1_1, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, arg29, 6, 0, 0x3FFFA);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_64;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg29.skipToGroupEnd();
        }

    label_64:
        return Unit.INSTANCE;
    }

    static final Unit GoldenStretchDiagnosticsScreen$lambda$35$lambda$33$lambda$32$lambda$31(SemanticsPropertyReceiver arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$semantics");
        SemanticsPropertiesKt.setLiveRegion-hR3wRGc(arg1, LiveRegionMode.Companion.getPolite-0phEisY());
        return Unit.INSTANCE;
    }

    static final Unit GoldenStretchDiagnosticsScreen$lambda$35$lambda$34(MutableState arg26, Composer arg27, int arg28) {
        Composer v0 = arg27;
        int v1 = arg28;
        ComposerKt.sourceInformation(v0, "C98@5627L169:GoldenStretchDiagnosticsScreen.kt#e575ws");
        boolean v2 = (v1 & 3) != 2 ? true : false;
        if(v0.shouldExecute(v2, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x8508EC51, v1, -1, "com.TryJeanPc.goldenmouse.stretch.diagnostics.GoldenStretchDiagnosticsScreen.<anonymous>.<anonymous> (GoldenStretchDiagnosticsScreen.kt:98)");
            }

            String v1_1 = GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$2(arg26);
            if(v1_1 == null) {
                v1_1 = "Aún no se ejecutó el diagnóstico. Pulsa el botón para comenzar.";
            }

            TextKt.Text-Nvy7gAk(v1_1, null, GoldenUiColorsKt.getTextWhite(), null, TextUnitKt.getSp(13), null, null, FontFamily.Companion.getMonospace(), 0, null, null, 0, 0, false, 0, 0, null, null, arg27, 0x6180, 0, 0x3FF6A);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_53;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg27.skipToGroupEnd();
        }

    label_53:
        return Unit.INSTANCE;
    }

    static final Unit GoldenStretchDiagnosticsScreen$lambda$36(Function0 arg0, int arg1, Composer arg2, int arg3) {
        GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    private static final boolean GoldenStretchDiagnosticsScreen$lambda$5(MutableState arg0) {
        return ((State)arg0).getValue().booleanValue();
    }

    private static final void GoldenStretchDiagnosticsScreen$lambda$6(MutableState arg0, boolean arg1) {
        arg0.setValue(Boolean.valueOf(arg1));
    }

    private static final Job GoldenStretchDiagnosticsScreen$lambda$8(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void GoldenStretchDiagnosticsScreen$lambda$9(MutableState arg0, Job arg1) {
        arg0.setValue(arg1);
    }

    private static final void GoldenStretchDiagnosticsScreen$start(CoroutineScope arg8, MutableState arg9, MutableState arg10, MutableState arg11, Context arg12, MutableState arg13, boolean arg14) {
        if(GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$5(arg9)) {
            return;
        }

        GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$6(arg9, true);
        GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$3(arg10, null);
        GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$12(arg11, null);
        GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$9(arg13, BuildersKt.launch$default(arg8, null, null, new GoldenStretchDiagnosticsScreenKt$GoldenStretchDiagnosticsScreen$start$1(arg14, arg12, arg10, arg9, null), 3, null));
    }

    public static final void access$GoldenStretchDiagnosticsScreen$lambda$3(MutableState arg0, String arg1) {
        GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$3(arg0, arg1);
    }

    public static final void access$GoldenStretchDiagnosticsScreen$lambda$6(MutableState arg0, boolean arg1) {
        GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$6(arg0, arg1);
    }

    public static final Job access$GoldenStretchDiagnosticsScreen$lambda$8(MutableState arg0) {
        return GoldenStretchDiagnosticsScreenKt.GoldenStretchDiagnosticsScreen$lambda$8(arg0);
    }
}

