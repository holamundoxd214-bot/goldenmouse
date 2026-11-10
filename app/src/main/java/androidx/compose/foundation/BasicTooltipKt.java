package androidx.compose.foundation;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001Aa\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\f2\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u000F\u001A:\u0010\u0010\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0011\u001A@\u0010\u0012\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u000B\u001A\u00020\f2\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0015\u001A\u001C\u0010\u0016\u001A\u00020\n*\u00020\n2\u0006\u0010\u0017\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00020\bH\u0002\u001A,\u0010\u0018\u001A\u00020\n*\u00020\n2\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0017\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0014H\u0002\u001A+\u0010\u001B\u001A\u00020\b2\b\b\u0002\u0010\u001C\u001A\u00020\f2\b\b\u0002\u0010\u001D\u001A\u00020\f2\b\b\u0002\u0010\u001E\u001A\u00020\u001FH\u0007¢\u0006\u0002\u0010 \u001A&\u0010!\u001A\u00020\b2\b\b\u0002\u0010\u001C\u001A\u00020\f2\b\b\u0002\u0010\u001D\u001A\u00020\f2\b\b\u0002\u0010\u001E\u001A\u00020\u001FH\u0007¨\u0006\""}, d2={"BasicTooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/foundation/BasicTooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "WrappedAnchor", "(ZLandroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipPopup", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/foundation/BasicTooltipState;Lkotlinx/coroutines/CoroutineScope;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "handleGestures", "enabled", "anchorSemantics", "label", "", "rememberBasicTooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BasicTooltipState;", "BasicTooltipState", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BasicTooltipKt {
    public static DisposableEffectResult $r8$lambda$1pdEden7YFoHt3ULBzPRKT3vRDI(BasicTooltipState arg0, DisposableEffectScope arg1) {
        return BasicTooltipKt.BasicTooltipBox$lambda$1$0(arg0, arg1);
    }

    public static boolean $r8$lambda$3iP3VMMtXU_A5c7wOnMj1GsfXsU(CoroutineScope arg0, BasicTooltipState arg1) {
        return BasicTooltipKt.anchorSemantics$lambda$0$0(arg0, arg1);
    }

    public static Unit $r8$lambda$J82dIPuIG80ULXSQWQi2EBp0XSQ(String arg0, SemanticsPropertyReceiver arg1) {
        return BasicTooltipKt.TooltipPopup$lambda$1$0$0(arg0, arg1);
    }

    public static Unit $r8$lambda$eR67hVqdel337jirzOGCObniBjw(BasicTooltipState arg0, CoroutineScope arg1) {
        return BasicTooltipKt.TooltipPopup$lambda$0$0(arg0, arg1);
    }

    public static final void BasicTooltipBox(PopupPositionProvider arg19, Function2 arg20, BasicTooltipState arg21, Modifier arg22, boolean arg23, boolean arg24, Function2 arg25, Composer arg26, int arg27, int arg28) {
        boolean v6_3;
        int v18;
        int v1_1;
        CoroutineScope v6_2;
        Companion v9_1;
        int v15;
        Function2 v14_1;
        boolean v13_1;
        int v12;
        boolean v11;
        int v10;
        Modifier v9;
        int v6;
        Function2 v5;
        int v3;
        BasicTooltipState v1 = arg21;
        int v8 = arg27;
        Composer v4 = arg26.startRestartGroup(196062260);
        ComposerKt.sourceInformation(v4, "C(BasicTooltipBox)N(positionProvider,tooltip,state,modifier,focusable,enableUserInput,content)82@3723L24,83@3752L453,102@4235L35,102@4211L59:BasicTooltip.kt#71ulvw");
        if((v8 & 6) == 0) {
            v3 = v4.changed(arg19) ? 4 : 2;
            v3 |= v8;
        }
        else {
            v3 = v8;
        }

        if((v8 & 0x30) == 0) {
            v5 = arg20;
            v6 = v4.changedInstance(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
            v5 = arg20;
        }

        if((v8 & 0x180) == 0) {
            v6 = v4.changed(v1) ? 0x100 : 0x80;
            v3 |= v6;
        }

        v6 = arg28 & 8;
        if(v6 != 0) {
            v3 |= 0xC00;
            goto label_52;
        }
        else if((v8 & 0xC00) == 0) {
            v9 = arg22;
            v10 = v4.changed(v9) ? 0x800 : 0x400;
            v3 |= v10;
        }
        else {
        label_52:
            v9 = arg22;
        }

        v10 = arg28 & 16;
        if(v10 != 0) {
            v3 |= 0x6000;
            goto label_67;
        }
        else if((v8 & 0x6000) == 0) {
            v11 = arg23;
            v12 = v4.changed(v11) ? 0x4000 : 0x2000;
            v3 |= v12;
        }
        else {
        label_67:
            v11 = arg23;
        }

        v12 = arg28 & 0x20;
        int v13 = 0x30000;
        if(v12 != 0) {
            v3 |= v13;
            goto label_83;
        }
        else if((v13 & v8) == 0) {
            v13_1 = arg24;
            int v14 = v4.changed(v13_1) ? 0x20000 : 0x10000;
            v3 |= v14;
        }
        else {
        label_83:
            v13_1 = arg24;
        }

        if((0x180000 & v8) == 0) {
            v14_1 = arg25;
            v15 = v4.changedInstance(v14_1) ? 0x100000 : 0x80000;
            v3 |= v15;
        }
        else {
            v14_1 = arg25;
        }

        v15 = v3;
        int v17 = 1;
        boolean v3_1 = (0x92493 & v15) != 0x92492 ? true : false;
        if(v4.shouldExecute(v3_1, v15 & 1)) {
            if(v6 != 0) {
                v9_1 = Modifier.Companion;
            }

            v3_1 = v10 != 0 ? true : v11;
            if(v12 != 0) {
                v13_1 = true;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(196062260, v15, -1, "androidx.compose.foundation.BasicTooltipBox (BasicTooltip.kt:81)");
            }

            ComposerKt.sourceInformationMarkerStart(v4, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v4, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
            Object v6_1 = v4.rememberedValue();
            if(v6_1 == Composer.Companion.getEmpty()) {
                v6_2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v4);
                v4.updateRememberedValue(v6_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerStart(v4, 0x3E277F0A, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Companion v7 = Modifier.Companion;
            MeasurePolicy v10_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v4, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int v11_1 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v4, 0));
            CompositionLocalMap v12_1 = v4.getCurrentCompositionLocalMap();
            Modifier v7_1 = ComposedModifierKt.materializeModifier(v4, ((Modifier)v7));
            Function0 v0 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v4, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(v4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v4.startReusableNode();
            if(v4.getInserting()) {
                v4.createNode(v0);
            }
            else {
                v4.useNode();
            }

            Composer v0_1 = Updater.constructor-impl(v4);
            Updater.set-impl(v0_1, v10_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v0_1, v12_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v0_1, Integer.valueOf(v11_1), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v0_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v0_1, v7_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v4, 0x6D468784, "C94@4037L162:BasicTooltip.kt#71ulvw");
            if(arg21.isVisible()) {
                v4.startReplaceGroup(1833353604);
                ComposerKt.sourceInformation(v4, "85@3801L216");
                v1_1 = v15 >> 3;
                v18 = 0;
                BasicTooltipKt.TooltipPopup(arg19, arg21, v6_2, v3_1, v5, v4, v15 & 14 | v1_1 & 0x70 | v1_1 & 0x1C00 | v15 << 9 & 0xE000);
                v11 = v3_1;
                v4 = v4;
            }
            else {
                v11 = v3_1;
                v18 = 0;
                v4.startReplaceGroup(0x6D0D4DF4);
            }

            v4.endReplaceGroup();
            v1_1 = v15 >> 3;
            int v5_1 = v15 >> 15 & 14 | v1_1 & 0x70 | v1_1 & 0x380 | v15 >> 9 & 0x1C00;
            v1 = arg21;
            Modifier v2 = ((Modifier)v9_1);
            boolean v0_2 = v13_1;
            BasicTooltipKt.WrappedAnchor(v0_2, v1, v2, v14_1, v4, v5_1, 0);
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            v4.endNode();
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerStart(v4, 0xDE75D3F7, "CC(remember):BasicTooltip.kt#9igjgp");
            if((v15 & 0x380) == 0x100) {
            }
            else {
                v17 = v18;
            }

            Object v3_2 = v4.rememberedValue();
            if(v17 != 0 || v3_2 == Composer.Companion.getEmpty()) {
                BasicTooltipKt$$ExternalSyntheticLambda6 v3_3 = new BasicTooltipKt$$ExternalSyntheticLambda6(v1);
                v4.updateRememberedValue(v3_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            EffectsKt.DisposableEffect(v1, ((Function1)v3_2), v4, v15 >> 6 & 14);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6_3 = v0_2;
            v9 = v2;
        }
        else {
            v4.skipToGroupEnd();
            v6_3 = v13_1;
        }

        boolean v5_2 = v11;
        ScopeUpdateScope v10_2 = v4.endRestartGroup();
        if(v10_2 != null) {
            v10_2.updateScope(new BasicTooltipKt$$ExternalSyntheticLambda7(arg19, arg20, v1, v9, v5_2, v6_3, arg25, v8, arg28));
        }
    }

    private static final DisposableEffectResult BasicTooltipBox$lambda$1$0(BasicTooltipState arg0, DisposableEffectScope arg1) {
        return new BasicTooltipKt$BasicTooltipBox$lambda$1$0$$inlined$onDispose$1(arg0);
    }

    static final Unit BasicTooltipBox$lambda$2(PopupPositionProvider arg11, Function2 arg12, BasicTooltipState arg13, Modifier arg14, boolean arg15, boolean arg16, Function2 arg17, int arg18, int arg19, Composer arg20, int arg21) {
        BasicTooltipKt.BasicTooltipBox(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    public static final BasicTooltipState BasicTooltipState(boolean arg1, boolean arg2, MutatorMutex arg3) {
        return new BasicTooltipStateImpl(arg1, arg2, arg3);
    }

    public static BasicTooltipState BasicTooltipState$default(boolean arg0, boolean arg1, MutatorMutex arg2, int arg3, Object arg4) {
        if((arg3 & 4) != 0) {
            arg2 = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }

        return BasicTooltipKt.BasicTooltipState(false, true, arg2);
    }

    private static final void TooltipPopup(PopupPositionProvider arg19, BasicTooltipState arg20, CoroutineScope arg21, boolean arg22, Function2 arg23, Composer arg24, int arg25) {
        BasicTooltipKt$$ExternalSyntheticLambda1 v8_2;
        int v7;
        int v4;
        PopupPositionProvider v1;
        BasicTooltipState v2 = arg20;
        CoroutineScope v3 = arg21;
        Function2 v5 = arg23;
        int v6 = arg25;
        int v0 = 0x8FCAAFAD;
        Composer v11 = arg24.startRestartGroup(v0);
        ComposerKt.sourceInformation(v11, "C(TooltipPopup)N(positionProvider,state,scope,focusable,content)134@5099L13,137@5201L109,143@5379L251,135@5117L513:BasicTooltip.kt#71ulvw");
        if((v6 & 6) == 0) {
            v1 = arg19;
            v4 = v11.changed(v1) ? 4 : 2;
            v4 |= v6;
        }
        else {
            v1 = arg19;
            v4 = v6;
        }

        int v8 = 0x20;
        if((v6 & 0x30) == 0) {
            v7 = v11.changed(v2) ? v8 : 16;
            v4 |= v7;
        }

        if((v6 & 0x180) == 0) {
            v7 = v11.changedInstance(v3) ? 0x100 : 0x80;
            v4 |= v7;
        }

        boolean v13 = arg22;
        if((v6 & 0xC00) == 0) {
            v7 = v11.changed(v13) ? 0x800 : 0x400;
            v4 |= v7;
        }

        if((v6 & 0x6000) == 0) {
            v7 = v11.changedInstance(v5) ? 0x4000 : 0x2000;
            v4 |= v7;
        }

        int v10 = 0;
        boolean v7_1 = (v4 & 9363) != 9362 ? true : false;
        if(v11.shouldExecute(v7_1, v4 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.foundation.TooltipPopup (BasicTooltip.kt:133)");
            }

            String v0_1 = BasicTooltipStrings.INSTANCE.description(v11, 6);
            ComposerKt.sourceInformationMarkerStart(v11, 0xC7DDA2DA, "CC(remember):BasicTooltip.kt#9igjgp");
            if((v4 & 0x70) == v8) {
                v10 = 1;
            }

            v7 = v11.changedInstance(v3) | v10;
            Object v8_1 = v11.rememberedValue();
            if(v7 != 0 || v8_1 == Composer.Companion.getEmpty()) {
                v8_2 = new BasicTooltipKt$$ExternalSyntheticLambda1(v2, v3);
                v11.updateRememberedValue(v8_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            AndroidPopup_androidKt.Popup(v1, ((Function0)v8_2), new PopupProperties(v13, false, false, false, 14, null), ComposableLambdaKt.rememberComposableLambda(0x36A70DCB, true, new BasicTooltipKt$$ExternalSyntheticLambda2(v0_1, v5), v11, 54), v11, v4 & 14 | 0xC00, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_117;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v11.skipToGroupEnd();
        }

    label_117:
        ScopeUpdateScope v7_2 = v11.endRestartGroup();
        if(v7_2 != null) {
            v7_2.updateScope(new BasicTooltipKt$$ExternalSyntheticLambda3(arg19, v2, v3, arg22, v5, v6));
        }
    }

    private static final Unit TooltipPopup$lambda$0$0(BasicTooltipState arg8, CoroutineScope arg9) {
        if(arg8.isVisible()) {
            BuildersKt.launch$default(arg9, null, null, new BasicTooltipKt$TooltipPopup$1$1$1(arg8, null), 3, null);
        }

        return Unit.INSTANCE;
    }

    static final Unit TooltipPopup$lambda$1(String arg6, Function2 arg7, Composer arg8, int arg9) {
        BasicTooltipKt$$ExternalSyntheticLambda0 v1_1;
        ComposerKt.sourceInformation(arg8, "C146@5452L128,144@5389L235:BasicTooltip.kt#71ulvw");
        boolean v0 = (arg9 & 3) != 2 ? true : false;
        if(arg8.shouldExecute(v0, arg9 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x36A70DCB, arg9, -1, "androidx.compose.foundation.TooltipPopup.<anonymous> (BasicTooltip.kt:144)");
            }

            Companion v9 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(arg8, 0x291AD0AB, "CC(remember):BasicTooltip.kt#9igjgp");
            v0 = arg8.changed(arg6);
            Object v1 = arg8.rememberedValue();
            if((v0) || v1 == Composer.Companion.getEmpty()) {
                v1_1 = new BasicTooltipKt$$ExternalSyntheticLambda0(arg6);
                arg8.updateRememberedValue(v1_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg8);
            Modifier v6 = SemanticsModifierKt.semantics$default(((Modifier)v9), false, ((Function1)v1_1), 1, null);
            ComposerKt.sourceInformationMarkerStart(arg8, 0x3E277F0A, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy v9_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(arg8, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int v0_1 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg8, 0));
            CompositionLocalMap v1_2 = arg8.getCurrentCompositionLocalMap();
            v6 = ComposedModifierKt.materializeModifier(arg8, v6);
            Function0 v2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(arg8, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(arg8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg8.startReusableNode();
            if(arg8.getInserting()) {
                arg8.createNode(v2);
            }
            else {
                arg8.useNode();
            }

            Composer v2_1 = Updater.constructor-impl(arg8);
            Updater.set-impl(v2_1, v9_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v2_1, v1_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v2_1, Integer.valueOf(v0_1), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v2_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v2_1, v6, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(arg8, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(arg8, 1506788405, "C151@5605L9:BasicTooltip.kt#71ulvw");
            arg7.invoke(arg8, Integer.valueOf(0));
            ComposerKt.sourceInformationMarkerEnd(arg8);
            ComposerKt.sourceInformationMarkerEnd(arg8);
            arg8.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg8);
            ComposerKt.sourceInformationMarkerEnd(arg8);
            ComposerKt.sourceInformationMarkerEnd(arg8);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_100;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg8.skipToGroupEnd();
        }

    label_100:
        return Unit.INSTANCE;
    }

    private static final Unit TooltipPopup$lambda$1$0$0(String arg1, SemanticsPropertyReceiver arg2) {
        SemanticsPropertiesKt.setLiveRegion-hR3wRGc(arg2, LiveRegionMode.Companion.getAssertive-0phEisY());
        SemanticsPropertiesKt.setPaneTitle(arg2, arg1);
        return Unit.INSTANCE;
    }

    static final Unit TooltipPopup$lambda$2(PopupPositionProvider arg7, BasicTooltipState arg8, CoroutineScope arg9, boolean arg10, Function2 arg11, int arg12, Composer arg13, int arg14) {
        BasicTooltipKt.TooltipPopup(arg7, arg8, arg9, arg10, arg11, arg13, RecomposeScopeImplKt.updateChangedFlags(arg12 | 1));
        return Unit.INSTANCE;
    }

    private static final void WrappedAnchor(boolean arg8, BasicTooltipState arg9, Modifier arg10, Function2 arg11, Composer arg12, int arg13, int arg14) {
        CoroutineScope v0_2;
        Companion v10;
        int v3;
        int v2;
        int v1;
        int v0 = 0x52582FB5;
        arg12 = arg12.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg12, "C(WrappedAnchor)N(enableUserInput,state,modifier,content)113@4506L24,114@4576L7,115@4588L212:BasicTooltip.kt#71ulvw");
        if((arg13 & 6) == 0) {
            v1 = arg12.changed(arg8) ? 4 : 2;
            v1 |= arg13;
        }
        else {
            v1 = arg13;
        }

        if((arg13 & 0x30) == 0) {
            v2 = arg12.changed(arg9) ? 0x20 : 16;
            v1 |= v2;
        }

        v2 = arg14 & 4;
        if(v2 != 0) {
            v1 |= 0x180;
        }
        else if((arg13 & 0x180) == 0) {
            v3 = arg12.changed(arg10) ? 0x100 : 0x80;
            v1 |= v3;
        }

        if((arg13 & 0xC00) == 0) {
            v3 = arg12.changedInstance(arg11) ? 0x800 : 0x400;
            v1 |= v3;
        }

        boolean v3_1 = (v1 & 0x493) != 1170 ? true : false;
        if(arg12.shouldExecute(v3_1, v1 & 1)) {
            if(v2 != 0) {
                v10 = Modifier.Companion;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.WrappedAnchor (BasicTooltip.kt:112)");
            }

            ComposerKt.sourceInformationMarkerStart(arg12, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(arg12, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
            Object v0_1 = arg12.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, arg12);
                arg12.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg12);
            ComposerKt.sourceInformationMarkerEnd(arg12);
            Modifier v0_3 = BasicTooltipKt.anchorSemantics(BasicTooltipKt.handleGestures(((Modifier)v10), arg8, arg9), BasicTooltipStrings.INSTANCE.label(arg12, 6), arg8, arg9, v0_2);
            ComposerKt.sourceInformationMarkerStart(arg12, 0x3E277F0A, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy v2_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(arg12, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            v3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg12, 0));
            CompositionLocalMap v4 = arg12.getCurrentCompositionLocalMap();
            v0_3 = ComposedModifierKt.materializeModifier(arg12, v0_3);
            Function0 v5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(arg12, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(arg12.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg12.startReusableNode();
            if(arg12.getInserting()) {
                arg12.createNode(v5);
            }
            else {
                arg12.useNode();
            }

            Composer v5_1 = Updater.constructor-impl(arg12);
            Updater.set-impl(v5_1, v2_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_1, v4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v5_1, Integer.valueOf(v3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v5_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v5_1, v0_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(arg12, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(arg12, 0xE0736C0B, "C121@4785L9:BasicTooltip.kt#71ulvw");
            arg11.invoke(arg12, Integer.valueOf(v1 >> 9 & 14));
            ComposerKt.sourceInformationMarkerEnd(arg12);
            ComposerKt.sourceInformationMarkerEnd(arg12);
            arg12.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg12);
            ComposerKt.sourceInformationMarkerEnd(arg12);
            ComposerKt.sourceInformationMarkerEnd(arg12);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_146;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg12.skipToGroupEnd();
        }

    label_146:
        Modifier v4_1 = ((Modifier)v10);
        ScopeUpdateScope v10_1 = arg12.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new BasicTooltipKt$$ExternalSyntheticLambda4(arg8, arg9, v4_1, arg11, arg13, arg14));
        }
    }

    static final Unit WrappedAnchor$lambda$1(boolean arg7, BasicTooltipState arg8, Modifier arg9, Function2 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        BasicTooltipKt.WrappedAnchor(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    private static final Modifier anchorSemantics(Modifier arg0, String arg1, boolean arg2, BasicTooltipState arg3, CoroutineScope arg4) {
        if(arg2) {
            arg0 = SemanticsModifierKt.semantics(arg0, true, new BasicTooltipKt$$ExternalSyntheticLambda8(arg1, arg4, arg3));
        }

        return arg0;
    }

    static final Unit anchorSemantics$lambda$0(String arg1, CoroutineScope arg2, BasicTooltipState arg3, SemanticsPropertyReceiver arg4) {
        SemanticsPropertiesKt.onLongClick(arg4, arg1, new BasicTooltipKt$$ExternalSyntheticLambda5(arg2, arg3));
        return Unit.INSTANCE;
    }

    private static final boolean anchorSemantics$lambda$0$0(CoroutineScope arg8, BasicTooltipState arg9) {
        BuildersKt.launch$default(arg8, null, null, new BasicTooltipKt$anchorSemantics$1$1$1(arg9, null), 3, null);
        return 1;
    }

    private static final Modifier handleGestures(Modifier arg0, boolean arg1, BasicTooltipState arg2) {
        if(arg1) {
            arg0 = SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(arg0, arg2, new BasicTooltipKt$handleGestures$1(arg2)), arg2, new BasicTooltipKt$handleGestures$2(arg2));
        }

        return arg0;
    }

    public static final BasicTooltipState rememberBasicTooltipState(boolean arg4, boolean arg5, MutatorMutex arg6, Composer arg7, int arg8, int arg9) {
        BasicTooltipStateImpl v9_1;
        int v1 = 0x42FCBC9D;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(rememberBasicTooltipState)N(initialIsVisible,isPersistent,mutatorMutex)245@9396L216:BasicTooltip.kt#71ulvw");
        int v2 = 0;
        if((arg9 & 4) != 0) {
            arg6 = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.foundation.rememberBasicTooltipState (BasicTooltip.kt:245)");
        }

        ComposerKt.sourceInformationMarkerStart(arg7, 0x76C023D5, "CC(remember):BasicTooltip.kt#9igjgp");
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
        return ((BasicTooltipState)v9_1);
    }
}

