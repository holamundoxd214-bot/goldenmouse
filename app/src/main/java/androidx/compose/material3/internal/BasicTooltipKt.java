package androidx.compose.material3.internal;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A}\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\u0010\b\u0002\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\r2\b\b\u0002\u0010\u000F\u001A\u00020\r2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0011\u001AP\u0010\u0012\u001A\u00020\u00012\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0007\u001A\u00020\b2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\r0\u00142\u0006\u0010\u000F\u001A\u00020\r2\b\b\u0002\u0010\t\u001A\u00020\n2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0015\u001A^\u0010\u0016\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\b2\u000E\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\f\u001A\u00020\r2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\r0\u00142\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0019\u001A\u001C\u0010\u001A\u001A\u00020\n*\u00020\n2\u0006\u0010\u001B\u001A\u00020\r2\u0006\u0010\u0007\u001A\u00020\bH\u0002\u001A,\u0010\u001C\u001A\u00020\n*\u00020\n2\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001B\u001A\u00020\r2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\u0018H\u0002\u001A:\u0010\u001F\u001A\u00020\n*\u00020\n2\u0006\u0010\u001B\u001A\u00020\r2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u000F\u001A\u00020\r2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\r0\u0014H\u0002\u001A+\u0010 \u001A\u00020\b2\b\b\u0002\u0010!\u001A\u00020\r2\b\b\u0002\u0010\"\u001A\u00020\r2\b\b\u0002\u0010#\u001A\u00020$H\u0001¢\u0006\u0002\u0010%\u001A&\u0010&\u001A\u00020\b2\b\b\u0002\u0010!\u001A\u00020\r2\b\b\u0002\u0010\"\u001A\u00020\r2\b\b\u0002\u0010#\u001A\u00020$H\u0001\u001A\u0013\u0010\'\u001A\b\u0012\u0004\u0012\u00020\r0(H\u0003¢\u0006\u0002\u0010)¨\u0006*"}, d2={"BasicTooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/material3/TooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "onDismissRequest", "focusable", "", "enableUserInput", "hasAction", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "WrappedAnchor", "forceKeyboardFocusable", "Landroidx/compose/runtime/MutableState;", "(ZLandroidx/compose/material3/TooltipState;Landroidx/compose/runtime/MutableState;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipPopup", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/material3/TooltipState;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CoroutineScope;ZLandroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "handleGestures", "enabled", "anchorSemantics", "label", "", "keyboardBehavior", "rememberBasicTooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TooltipState;", "BasicTooltipState", "rememberTouchExplorationOrSwitchAccessServiceState", "Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BasicTooltipKt {
    public static final void BasicTooltipBox(PopupPositionProvider arg22, Function2 arg23, TooltipState arg24, Modifier arg25, Function0 arg26, boolean arg27, boolean arg28, boolean arg29, Function2 arg30, Composer arg31, int arg32, int arg33) {
        Function0 v5_2;
        boolean v8_2;
        BasicTooltipKt$$ExternalSyntheticLambda2 v2_2;
        Companion v4_2;
        Function0 v14_2;
        Object v5_1;
        int v9_2;
        boolean v4_1;
        Composer v0_3;
        int v0_2;
        MutableState v1_3;
        Modifier v21_1;
        int v20;
        boolean v0;
        int v16;
        boolean v15_1;
        int v31;
        int v14;
        Function0 v13;
        int v12;
        Modifier v8;
        boolean v7_1;
        int v7;
        Function2 v5;
        int v4;
        TooltipState v1 = arg24;
        int v10 = arg32;
        int v11 = arg33;
        Composer v6 = arg31.startRestartGroup(0xB72BA0F0);
        ComposerKt.sourceInformation(v6, "C(BasicTooltipBox)N(positionProvider,tooltip,state,modifier,onDismissRequest,focusable,enableUserInput,hasAction,content)104@4929L24,105@4993L34,109@5201L52,112@5320L710,135@6060L35,135@6036L59:BasicTooltip.kt#mqatfk");
        if((v11 & 1) != 0) {
            v4 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v4 = v6.changed(arg22) ? 4 : 2;
            v4 |= v10;
        }
        else {
            v4 = v10;
        }

        if((v11 & 2) != 0) {
            v4 |= 0x30;
            goto label_40;
        }
        else if((v10 & 0x30) == 0) {
            v5 = arg23;
            v7 = v6.changedInstance(v5) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_40:
            v5 = arg23;
        }

        if((v11 & 4) != 0) {
            v4 |= 0x180;
        }
        else if((v10 & 0x180) == 0) {
            v7_1 = (v10 & 0x200) == 0 ? v6.changed(v1) : v6.changedInstance(v1);
            v7 = v7_1 ? 0x100 : 0x80;
            v4 |= v7;
        }

        v7 = v11 & 8;
        if(v7 != 0) {
            v4 |= 0xC00;
            goto label_71;
        }
        else if((v10 & 0xC00) == 0) {
            v8 = arg25;
            v12 = v6.changed(v8) ? 0x800 : 0x400;
            v4 |= v12;
        }
        else {
        label_71:
            v8 = arg25;
        }

        v12 = v11 & 16;
        if(v12 != 0) {
            v4 |= 0x6000;
            goto label_86;
        }
        else if((v10 & 0x6000) == 0) {
            v13 = arg26;
            v14 = v6.changedInstance(v13) ? 0x4000 : 0x2000;
            v4 |= v14;
        }
        else {
        label_86:
            v13 = arg26;
        }

        v14 = v11 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v4 |= v15;
            v31 = v15;
            v15_1 = arg27;
        }
        else {
            v16 = v10 & v15;
            v31 = v15;
            v15_1 = arg27;
            if(v16 == 0) {
                v16 = v6.changed(v15_1) ? 0x20000 : 0x10000;
                v4 |= v16;
            }
        }

        v16 = v11 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v4 |= v17;
        }
        else {
            boolean v9 = arg28;
            if((v10 & v17) == 0) {
                int v18 = v6.changed(v9) ? 0x100000 : 0x80000;
                v4 |= v18;
            }
        }

        int v3 = v11 & 0x80;
        int v19 = 0xC00000;
        if(v3 != 0) {
            v4 |= v19;
        }
        else {
            v0 = arg29;
            if((v10 & v19) == 0) {
                v20 = v6.changed(v0) ? 0x800000 : 0x400000;
                v4 |= v20;
            }
        }

        v20 = 0x6000000;
        if((v11 & 0x100) != 0) {
            v4 |= v20;
        }
        else if((v10 & v20) == 0) {
            v20 = v6.changedInstance(arg30) ? 0x4000000 : 0x2000000;
            v4 |= v20;
        }

        v20 = 1;
        v0 = (v4 & 0x2492493) != 0x2492492 ? true : false;
        if(v6.shouldExecute(v0, v4 & 1)) {
            if(v7 != 0) {
                Companion v21 = Modifier.Companion;
            }
            else {
                v21_1 = v8;
            }

            SnapshotMutationPolicy v0_1 = null;
            Function0 v2 = v12 != 0 ? ((Function0)v0_1) : v13;
            if(v14 != 0) {
                v15_1 = false;
            }

            boolean v12_1 = v16 != 0 ? true : arg28;
            boolean v13_1 = v3 != 0 ? false : arg29;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xB72BA0F0, v4, -1, "androidx.compose.material3.internal.BasicTooltipBox (BasicTooltip.kt:103)");
            }

            ComposerKt.sourceInformationMarkerStart(v6, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v6, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
            Object v1_1 = v6.rememberedValue();
            if(v1_1 == Composer.Companion.getEmpty()) {
                CoroutineScope v1_2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v6);
                v6.updateRememberedValue(v1_2);
            }

            Object v3_1 = v1_1;
            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerStart(v6, -1698210478, "CC(remember):BasicTooltip.kt#9igjgp");
            v1_1 = v6.rememberedValue();
            if(v1_1 == Composer.Companion.getEmpty()) {
                v1_3 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), v0_1, 2, v0_1);
                v6.updateRememberedValue(v1_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            if(v13_1) {
                if(!BasicTooltipKt.rememberTouchExplorationOrSwitchAccessServiceState(v6, 0).getValue().booleanValue() && !v1_3.getValue().booleanValue()) {
                    goto label_226;
                }

                v0_2 = 1;
            }
            else {
            label_226:
                v0_2 = 0;
            }

            ComposerKt.sourceInformationMarkerStart(v6, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Companion v7_2 = Modifier.Companion;
            MeasurePolicy v8_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            int v25 = v0_2;
            ComposerKt.sourceInformationMarkerStart(v6, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v0_2 = ComposablesKt.getCurrentCompositeKeyHash(v6, 0);
            CompositionLocalMap v14_1 = v6.getCurrentCompositionLocalMap();
            Modifier v7_3 = ComposedModifierKt.materializeModifier(v6, ((Modifier)v7_2));
            Function0 v9_1 = ComposeUiNode.Companion.getConstructor();
            int v26 = v0_2;
            Object v27 = v1_3;
            ComposerKt.sourceInformationMarkerStart(v6, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v6.startReusableNode();
            if(v6.getInserting()) {
                v6.createNode(v9_1);
            }
            else {
                v6.useNode();
            }

            v0_3 = Updater.constructor-impl(v6);
            Updater.set-impl(v0_3, v8_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v0_3, v14_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v1_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v0_3.getInserting()) || !Intrinsics.areEqual(v0_3.rememberedValue(), Integer.valueOf(v26))) {
                v0_3.updateRememberedValue(Integer.valueOf(v26));
                v0_3.apply(Integer.valueOf(v26), v1_4);
            }

            Updater.set-impl(v0_3, v7_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v6, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v6, 0x8F45BE1B, "C125@5760L264:BasicTooltip.kt#mqatfk");
            if(arg24.isVisible()) {
                v6.startReplaceGroup(0x8F45EBC1);
                ComposerKt.sourceInformation(v6, "114@5369L371");
                if((v15_1) || v25 != 0) {
                    v0_2 = v4;
                    v4_1 = true;
                }
                else {
                    v0_2 = v4;
                    v4_1 = false;
                }

                v9_2 = v0_2;
                Composer v7_4 = v6;
                Function2 v6_1 = v5;
                v5_1 = v27;
                BasicTooltipKt.TooltipPopup(arg22, arg24, v2, ((CoroutineScope)v3_1), v4_1, ((MutableState)v5_1), v6_1, v7_4, v0_2 & 14 | v31 | v0_2 >> 3 & 0x70 | v0_2 >> 6 & 0x380 | v0_2 << 15 & 0x380000);
                v14_2 = v2;
                v6 = v7_4;
                v6.endReplaceGroup();
            }
            else {
                v5_1 = v27;
                v14_2 = v2;
                v9_2 = v4;
                v6.startReplaceGroup(0x8F4BB68C);
                v6.endReplaceGroup();
            }

            v1 = arg24;
            v0 = v12_1;
            boolean v3_2 = v13_1;
            v4_2 = ((Companion)v21_1);
            BasicTooltipKt.WrappedAnchor(v0, v1, v5_1, v3_2, ((Modifier)v4_2), arg30, v6, v9_2 >> 18 & 14 | 0x180 | v9_2 >> 3 & 0x70 | v9_2 >> 12 & 0x1C00 | v9_2 << 3 & 0xE000 | v9_2 >> 9 & 0x70000, 0);
            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerEnd(v6);
            v6.endNode();
            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerStart(v6, 0x9AC7E2B3, "CC(remember):BasicTooltip.kt#9igjgp");
            if((v9_2 & 0x380) != 0x100 && ((v9_2 & 0x200) == 0 || !v6.changedInstance(v1))) {
                v20 = 0;
            }

            Object v2_1 = v6.rememberedValue();
            if(v20 != 0 || v2_1 == Composer.Companion.getEmpty()) {
                v2_2 = new BasicTooltipKt$$ExternalSyntheticLambda2(v1);
                v6.updateRememberedValue(v2_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            EffectsKt.DisposableEffect(v1, ((Function1)v2_2), v6, v9_2 >> 6 & 14);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7_1 = v0;
            v8_2 = v3_2;
            v5_2 = v14_2;
        }
        else {
            v1 = arg24;
            v6.skipToGroupEnd();
            v7_1 = arg28;
            Modifier v4_3 = v8;
            v5_2 = v13;
            v8_2 = arg29;
        }

        v0_3 = v6;
        boolean v6_2 = v15_1;
        ScopeUpdateScope v12_2 = v0_3.endRestartGroup();
        if(v12_2 != null) {
            v12_2.updateScope(new BasicTooltipKt$$ExternalSyntheticLambda3(arg22, arg23, v1, ((Modifier)v4_2), v5_2, v6_2, v7_1, v8_2, arg30, v10, v11));
        }
    }

    static final DisposableEffectResult BasicTooltipBox$lambda$4$lambda$3(TooltipState arg0, DisposableEffectScope arg1) {
        return new BasicTooltipKt$BasicTooltipBox$lambda$4$lambda$3$$inlined$onDispose$1(arg0);
    }

    static final Unit BasicTooltipBox$lambda$5(PopupPositionProvider arg13, Function2 arg14, TooltipState arg15, Modifier arg16, Function0 arg17, boolean arg18, boolean arg19, boolean arg20, Function2 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        BasicTooltipKt.BasicTooltipBox(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    public static final TooltipState BasicTooltipState(boolean arg1, boolean arg2, MutatorMutex arg3) {
        return new BasicTooltipStateImpl(arg1, arg2, arg3);
    }

    public static TooltipState BasicTooltipState$default(boolean arg0, boolean arg1, MutatorMutex arg2, int arg3, Object arg4) {
        if((arg3 & 4) != 0) {
            arg2 = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }

        return BasicTooltipKt.BasicTooltipState(false, true, arg2);
    }

    private static final void TooltipPopup(PopupPositionProvider arg21, TooltipState arg22, Function0 arg23, CoroutineScope arg24, boolean arg25, MutableState arg26, Function2 arg27, Composer arg28, int arg29) {
        BasicTooltipKt$$ExternalSyntheticLambda0 v10_2;
        int v5_1;
        boolean v5;
        int v1;
        TooltipState v2 = arg22;
        Function0 v3 = arg23;
        CoroutineScope v4 = arg24;
        MutableState v6 = arg26;
        Function2 v7 = arg27;
        int v8 = arg29;
        int v0 = -1413720282;
        Composer v13 = arg28.startRestartGroup(v0);
        ComposerKt.sourceInformation(v13, "C(TooltipPopup)N(positionProvider,state,onDismissRequest,scope,focusable,forceKeyboardFocusable,content)170@7095L13,173@7197L382,185@7648L251,171@7113L786:BasicTooltip.kt#mqatfk");
        PopupPositionProvider v9 = arg21;
        if((v8 & 6) == 0) {
            v1 = v13.changed(v9) ? 4 : 2;
            v1 |= v8;
        }
        else {
            v1 = v8;
        }

        int v10 = 0x20;
        if((v8 & 0x30) == 0) {
            v5 = (v8 & 0x40) == 0 ? v13.changed(v2) : v13.changedInstance(v2);
            v5_1 = v5 ? v10 : 16;
            v1 |= v5_1;
        }

        int v11 = 0x100;
        if((v8 & 0x180) == 0) {
            v5_1 = v13.changedInstance(v3) ? v11 : 0x80;
            v1 |= v5_1;
        }

        if((v8 & 0xC00) == 0) {
            v5_1 = v13.changedInstance(v4) ? 0x800 : 0x400;
            v1 |= v5_1;
        }

        boolean v15 = arg25;
        if((v8 & 0x6000) == 0) {
            v5_1 = v13.changed(v15) ? 0x4000 : 0x2000;
            v1 |= v5_1;
        }

        if((0x30000 & v8) == 0) {
            v5_1 = v13.changed(v6) ? 0x20000 : 0x10000;
            v1 |= v5_1;
        }

        if((0x180000 & v8) == 0) {
            v5_1 = v13.changedInstance(v7) ? 0x100000 : 0x80000;
            v1 |= v5_1;
        }

        int v16 = 0;
        v5 = (0x92493 & v1) != 0x92492 ? true : false;
        if(v13.shouldExecute(v5, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.internal.TooltipPopup (BasicTooltip.kt:169)");
            }

            String v0_1 = BasicTooltipStrings.INSTANCE.description(v13, 6);
            ComposerKt.sourceInformationMarkerStart(v13, 0xAE035E04, "CC(remember):BasicTooltip.kt#9igjgp");
            v5_1 = (v1 & 0x380) == v11 ? 1 : 0;
            if((v1 & 0x70) != v10) {
                if((v1 & 0x40) != 0 && (v13.changedInstance(v2))) {
                    goto label_116;
                }

                v10 = 0;
            }
            else {
            label_116:
                v10 = 1;
            }

            v5_1 = v5_1 | v10 | v13.changedInstance(v4);
            if((0x70000 & v1) == 0x20000) {
                v16 = 1;
            }

            Object v10_1 = v13.rememberedValue();
            if((v5_1 | v16) != 0 || v10_1 == Composer.Companion.getEmpty()) {
                v10_2 = new BasicTooltipKt$$ExternalSyntheticLambda0(v3, v2, v4, v6);
                v13.updateRememberedValue(v10_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            AndroidPopup_androidKt.Popup(v9, ((Function0)v10_2), new PopupProperties(v15, false, false, false, 14, null), ComposableLambdaKt.rememberComposableLambda(-1287705660, true, new BasicTooltipKt$TooltipPopup$2(v0_1, v7), v13, 54), v13, v1 & 14 | 0xC00, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_159;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v13.skipToGroupEnd();
        }

    label_159:
        ScopeUpdateScope v9_1 = v13.endRestartGroup();
        if(v9_1 != null) {
            v9_1.updateScope(new BasicTooltipKt$$ExternalSyntheticLambda1(arg21, v2, v3, v4, arg25, v6, v7, v8));
        }
    }

    static final Unit TooltipPopup$lambda$10(PopupPositionProvider arg10, TooltipState arg11, Function0 arg12, CoroutineScope arg13, boolean arg14, MutableState arg15, Function2 arg16, int arg17, Composer arg18, int arg19) {
        BasicTooltipKt.TooltipPopup(arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg18, RecomposeScopeImplKt.updateChangedFlags(arg17 | 1));
        return Unit.INSTANCE;
    }

    static final Unit TooltipPopup$lambda$9$lambda$8(Function0 arg7, TooltipState arg8, CoroutineScope arg9, MutableState arg10) {
        if(arg7 != null) {
            arg7.invoke();
        }
        else if(arg8.isVisible()) {
            BuildersKt.launch$default(arg9, null, null, new BasicTooltipKt$TooltipPopup$1$1$1(arg8, null), 3, null);
            arg10.setValue(Boolean.valueOf(false));
        }

        return Unit.INSTANCE;
    }

    private static final void WrappedAnchor(boolean arg14, TooltipState arg15, MutableState arg16, boolean arg17, Modifier arg18, Function2 arg19, Composer arg20, int arg21, int arg22) {
        CoroutineScope v0_2;
        int v11;
        Modifier v10;
        int v9;
        MutableState v5;
        int v4_1;
        boolean v4;
        int v3;
        Function2 v6 = arg19;
        int v7 = arg21;
        int v0 = 0x6FA740C0;
        Composer v8 = arg20.startRestartGroup(v0);
        ComposerKt.sourceInformation(v8, "C(WrappedAnchor)N(enableUserInput,state,forceKeyboardFocusable,hasAction,modifier,content)147@6360L24,148@6430L7,149@6442L312:BasicTooltip.kt#mqatfk");
        if((arg22 & 1) != 0) {
            v3 = v7 | 6;
        }
        else if((v7 & 6) == 0) {
            v3 = v8.changed(arg14) ? 4 : 2;
            v3 |= v7;
        }
        else {
            v3 = v7;
        }

        if((arg22 & 2) != 0) {
            v3 |= 0x30;
        }
        else if((v7 & 0x30) == 0) {
            v4 = (v7 & 0x40) == 0 ? v8.changed(arg15) : v8.changedInstance(arg15);
            v4_1 = v4 ? 0x20 : 16;
            v3 |= v4_1;
        }

        if((arg22 & 4) != 0) {
            v3 |= 0x180;
            v5 = arg16;
        }
        else {
            v5 = arg16;
            if((v7 & 0x180) == 0) {
                v4_1 = v8.changed(v5) ? 0x100 : 0x80;
                v3 |= v4_1;
            }
        }

        if((arg22 & 8) != 0) {
            v3 |= 0xC00;
            goto label_65;
        }
        else if((v7 & 0xC00) == 0) {
            v4 = arg17;
            v9 = v8.changed(v4) ? 0x800 : 0x400;
            v3 |= v9;
        }
        else {
        label_65:
            v4 = arg17;
        }

        v9 = arg22 & 16;
        if(v9 != 0) {
            v3 |= 0x6000;
            goto label_80;
        }
        else if((v7 & 0x6000) == 0) {
            v10 = arg18;
            v11 = v8.changed(v10) ? 0x4000 : 0x2000;
            v3 |= v11;
        }
        else {
        label_80:
            v10 = arg18;
        }

        int v12 = 0x30000;
        if((arg22 & 0x20) != 0) {
            v3 |= v12;
        }
        else if((v7 & v12) == 0) {
            v11 = v8.changedInstance(v6) ? 0x20000 : 0x10000;
            v3 |= v11;
        }

        v11 = v3;
        boolean v3_1 = (74899 & v11) != 74898 ? true : false;
        if(v8.shouldExecute(v3_1, v11 & 1)) {
            if(v9 != 0) {
                Companion v10_1 = Modifier.Companion;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v11, -1, "androidx.compose.material3.internal.WrappedAnchor (BasicTooltip.kt:146)");
            }

            ComposerKt.sourceInformationMarkerStart(v8, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v8, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
            Object v0_1 = v8.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v8);
                v8.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            Modifier v0_3 = BasicTooltipKt.keyboardBehavior(BasicTooltipKt.anchorSemantics(BasicTooltipKt.handleGestures(v10, arg14, arg15), BasicTooltipStrings.INSTANCE.label(v8, 6), arg14, arg15, v0_2), arg14, arg15, v0_2, v4, v5);
            ComposerKt.sourceInformationMarkerStart(v8, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v8, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int v2 = ComposablesKt.getCurrentCompositeKeyHash(v8, 0);
            CompositionLocalMap v3_2 = v8.getCurrentCompositionLocalMap();
            v0_3 = ComposedModifierKt.materializeModifier(v8, v0_3);
            Function0 v4_2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v8, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v8.startReusableNode();
            if(v8.getInserting()) {
                v8.createNode(v4_2);
            }
            else {
                v8.useNode();
            }

            Composer v4_3 = Updater.constructor-impl(v8);
            Updater.set-impl(v4_3, v1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v4_3, v3_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v1_1 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v4_3.getInserting()) || !Intrinsics.areEqual(v4_3.rememberedValue(), Integer.valueOf(v2))) {
                v4_3.updateRememberedValue(Integer.valueOf(v2));
                v4_3.apply(Integer.valueOf(v2), v1_1);
            }

            Updater.set-impl(v4_3, v0_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v8, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v8, 0x36C18920, "C156@6739L9:BasicTooltip.kt#mqatfk");
            v6.invoke(v8, Integer.valueOf(v11 >> 15 & 14));
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            v8.endNode();
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_209;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v8.skipToGroupEnd();
        }

    label_209:
        Modifier v5_1 = v10;
        ScopeUpdateScope v9_1 = v8.endRestartGroup();
        if(v9_1 != null) {
            v9_1.updateScope(new BasicTooltipKt$$ExternalSyntheticLambda7(arg14, arg15, arg16, arg17, v5_1, v6, v7, arg22));
        }
    }

    static final Unit WrappedAnchor$lambda$7(boolean arg10, TooltipState arg11, MutableState arg12, boolean arg13, Modifier arg14, Function2 arg15, int arg16, int arg17, Composer arg18, int arg19) {
        BasicTooltipKt.WrappedAnchor(arg10, arg11, arg12, arg13, arg14, arg15, arg18, RecomposeScopeImplKt.updateChangedFlags(arg16 | 1), arg17);
        return Unit.INSTANCE;
    }

    private static final Modifier anchorSemantics(Modifier arg0, String arg1, boolean arg2, TooltipState arg3, CoroutineScope arg4) {
        if(arg2) {
            arg0 = ChildParentSemanticsKt.parentSemantics(arg0, new BasicTooltipKt$$ExternalSyntheticLambda5(arg1, arg4, arg3));
        }

        return arg0;
    }

    static final Unit anchorSemantics$lambda$12(String arg1, CoroutineScope arg2, TooltipState arg3, SemanticsPropertyReceiver arg4) {
        SemanticsPropertiesKt.onLongClick(arg4, arg1, new BasicTooltipKt$$ExternalSyntheticLambda6(arg2, arg3));
        return Unit.INSTANCE;
    }

    static final boolean anchorSemantics$lambda$12$lambda$11(CoroutineScope arg8, TooltipState arg9) {
        BuildersKt.launch$default(arg8, null, null, new BasicTooltipKt$anchorSemantics$1$1$1(arg9, null), 3, null);
        return 1;
    }

    private static final Modifier handleGestures(Modifier arg0, boolean arg1, TooltipState arg2) {
        if(arg1) {
            arg0 = SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(arg0, arg2, new BasicTooltipKt$handleGestures$1(arg2)), arg2, new BasicTooltipKt$handleGestures$2(arg2));
        }

        return arg0;
    }

    private static final Modifier keyboardBehavior(Modifier arg0, boolean arg1, TooltipState arg2, CoroutineScope arg3, boolean arg4, MutableState arg5) {
        if(arg1) {
            return KeyInputModifierKt.onPreviewKeyEvent(FocusChangedModifierKt.onFocusChanged(arg0, new BasicTooltipKt$$ExternalSyntheticLambda4(arg3, arg2)), new BasicTooltipKt$keyboardBehavior$2(arg2, arg5, arg4));
        }

        arg5.setValue(Boolean.valueOf(false));
        return arg0;
    }

    static final Unit keyboardBehavior$lambda$13(CoroutineScope arg8, TooltipState arg9, FocusState arg10) {
        BuildersKt.launch$default(arg8, null, null, new BasicTooltipKt$keyboardBehavior$1$1(arg10, arg9, null), 3, null);
        return Unit.INSTANCE;
    }

    public static final TooltipState rememberBasicTooltipState(boolean arg4, boolean arg5, MutatorMutex arg6, Composer arg7, int arg8, int arg9) {
        BasicTooltipStateImpl v9_1;
        int v1 = -1483057531;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(rememberBasicTooltipState)N(initialIsVisible,isPersistent,mutatorMutex)346@14311L216:BasicTooltip.kt#mqatfk");
        int v2 = 0;
        if((arg9 & 4) != 0) {
            arg6 = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.material3.internal.rememberBasicTooltipState (BasicTooltip.kt:346)");
        }

        ComposerKt.sourceInformationMarkerStart(arg7, 710862269, "CC(remember):BasicTooltip.kt#9igjgp");
        int v0 = 0x20;
        arg9 = (arg8 & 0x70 ^ 0x30) > v0 && (arg7.changed(true)) || (arg8 & 0x30) == v0 ? 1 : 0;
        v1 = 0x100;
        if((arg8 & 0x380 ^ 0x180) > v1 && (arg7.changed(arg6)) || (arg8 & 0x180) == v1) {
            v2 = 1;
        }

        arg8 = arg9 | v2;
        Object v9 = arg7.rememberedValue();
        if(arg8 != 0 || v9 == Composer.Companion.getEmpty()) {
            v9_1 = new BasicTooltipStateImpl(false, true, arg6);
            arg7.updateRememberedValue(v9_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return ((TooltipState)v9_1);
    }

    private static final State rememberTouchExplorationOrSwitchAccessServiceState(Composer arg9, int arg10) {
        int v1 = 0x74DEAFF6;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(rememberTouchExplorationOrSwitchAccessServiceState)456@18433L170:BasicTooltip.kt#mqatfk");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.material3.internal.rememberTouchExplorationOrSwitchAccessServiceState (BasicTooltip.kt:456)");
        }

        Composer v6 = arg9;
        State v9 = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(true, true, false, v6, 438, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        return v9;
    }
}

