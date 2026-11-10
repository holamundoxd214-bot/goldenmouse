package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\u001A8\u0010\u0000\u001A\u00020\u00012\u0016\u0010\u0002\u001A\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0087\b¢\u0006\u0002\u0010\n\u001A \u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0087\b¢\u0006\u0002\u0010\u000B\u001A>\u0010\u0000\u001A\u00020\u00012\u001C\u0010\f\u001A\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00050\r2\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u000EH\u0087\b¢\u0006\u0002\u0010\u000F\u001A;\u0010\u0010\u001A\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u001C\u0010\f\u001A\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00050\rH\u0001¢\u0006\u0002\u0010\u0011\u001A3\u0010\u0012\u001A\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00162\u0006\u0010\u0006\u001A\u00020\u0007H\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001A3\u0010\u0019\u001A\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00162\u0006\u0010\u0006\u001A\u00020\u0007H\u0001¢\u0006\u0004\b\u0012\u0010\u0018\u001A7\u0010\u001A\u001A\u00020\u00012\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0016\u0010\u0002\u001A\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u0006\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0002\u0010\u001B\"\u000E\u0010\u001C\u001A\u00020\u001DX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Layout", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "contents", "", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MultiContentMeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "combineAsVirtualLayouts", "(Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "materializerOf", "Lkotlin/Function1;", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "Lkotlin/ExtensionFunctionType;", "modifierMaterializerOf", "(Landroidx/compose/ui/Modifier;)Lkotlin/jvm/functions/Function3;", "materializerOfWithCompositionLocalInjection", "MultiMeasureLayout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "LargeDimension", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LayoutKt {
    public static final int LargeDimension = 0x7FFF;

    public static final void Layout(Modifier arg3, MeasurePolicy arg4, Composer arg5, int arg6, int arg7) {
        Companion v3;
        ComposerKt.sourceInformationMarkerStart(arg5, 0x207BAF9A, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
        if((arg7 & 1) != 0) {
            v3 = Modifier.Companion;
        }

        arg6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg5, 0));
        arg3 = ComposedModifierKt.materializeModifier(arg5, ((Modifier)v3));
        CompositionLocalMap v7 = arg5.getCurrentCompositionLocalMap();
        Function0 v0 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(arg5, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
        if(!(arg5.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }

        arg5.startReusableNode();
        if(arg5.getInserting()) {
            arg5.createNode(v0);
        }
        else {
            arg5.useNode();
        }

        Composer v0_1 = Updater.constructor-impl(arg5);
        Updater.set-impl(v0_1, arg4, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(v0_1, v7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.reconcile-impl(v0_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl(v0_1, arg3, ComposeUiNode.Companion.getSetModifier());
        Updater.init-impl(v0_1, Integer.valueOf(arg6), ComposeUiNode.Companion.getSetCompositeKeyHash());
        arg5.endNode();
        ComposerKt.sourceInformationMarkerEnd(arg5);
        ComposerKt.sourceInformationMarkerEnd(arg5);
    }

    public static final void Layout(List arg4, Modifier arg5, MultiContentMeasurePolicy arg6, Composer arg7, int arg8, int arg9) {
        Companion v5;
        ComposerKt.sourceInformationMarkerStart(arg7, 0x5365E06C, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
        if((arg9 & 2) != 0) {
            v5 = Modifier.Companion;
        }

        Function2 v4 = LayoutKt.combineAsVirtualLayouts(arg4);
        ComposerKt.sourceInformationMarkerStart(arg7, 0x116F97CA, "CC(remember):Layout.kt#9igjgp");
        int v0 = 0x100;
        arg8 = (arg8 & 0x380 ^ 0x180) > v0 && (arg7.changed(arg6)) || (arg8 & 0x180) == v0 ? 1 : 0;
        Object v9 = arg7.rememberedValue();
        if(arg8 != 0 || v9 == Composer.Companion.getEmpty()) {
            MeasurePolicy v9_1 = MultiContentMeasurePolicyKt.createMeasurePolicy(arg6);
            arg7.updateRememberedValue(v9_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        ComposerKt.sourceInformationMarkerStart(arg7, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int v6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg7, 0));
        CompositionLocalMap v8 = arg7.getCurrentCompositionLocalMap();
        arg5 = ComposedModifierKt.materializeModifier(arg7, ((Modifier)v5));
        Function0 v0_1 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(arg7, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if(!(arg7.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }

        arg7.startReusableNode();
        if(arg7.getInserting()) {
            arg7.createNode(v0_1);
        }
        else {
            arg7.useNode();
        }

        Composer v0_2 = Updater.constructor-impl(arg7);
        Updater.set-impl(v0_2, v9, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(v0_2, v8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl(v0_2, Integer.valueOf(v6), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl(v0_2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl(v0_2, arg5, ComposeUiNode.Companion.getSetModifier());
        v4.invoke(arg7, Integer.valueOf(0));
        arg7.endNode();
        ComposerKt.sourceInformationMarkerEnd(arg7);
        ComposerKt.sourceInformationMarkerEnd(arg7);
        ComposerKt.sourceInformationMarkerEnd(arg7);
    }

    public static final void Layout(Function2 arg4, Modifier arg5, MeasurePolicy arg6, Composer arg7, int arg8, int arg9) {
        Companion v5;
        ComposerKt.sourceInformationMarkerStart(arg7, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        if((arg9 & 2) != 0) {
            v5 = Modifier.Companion;
        }

        arg9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg7, 0));
        CompositionLocalMap v0 = arg7.getCurrentCompositionLocalMap();
        arg5 = ComposedModifierKt.materializeModifier(arg7, ((Modifier)v5));
        Function0 v1 = ComposeUiNode.Companion.getConstructor();
        arg8 = arg8 << 6 & 0x380 | 6;
        ComposerKt.sourceInformationMarkerStart(arg7, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if(!(arg7.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }

        arg7.startReusableNode();
        if(arg7.getInserting()) {
            arg7.createNode(v1);
        }
        else {
            arg7.useNode();
        }

        Composer v1_1 = Updater.constructor-impl(arg7);
        Updater.set-impl(v1_1, arg6, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(v1_1, v0, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl(v1_1, Integer.valueOf(arg9), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl(v1_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl(v1_1, arg5, ComposeUiNode.Companion.getSetModifier());
        arg4.invoke(arg7, Integer.valueOf(arg8 >> 6 & 14));
        arg7.endNode();
        ComposerKt.sourceInformationMarkerEnd(arg7);
        ComposerKt.sourceInformationMarkerEnd(arg7);
    }

    @Deprecated(message="This API is unsafe for UI performance at scale - using it incorrectly will lead to exponential performance issues. This API should be avoided whenever possible.") public static final void MultiMeasureLayout(Modifier arg7, Function2 arg8, MeasurePolicy arg9, Composer arg10, int arg11, int arg12) {
        Companion v7;
        int v3;
        int v2;
        int v0 = 0x9CDBC280;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(MultiMeasureLayout)P(2)242@9686L23,246@9849L484:Layout.kt#80mrfh");
        int v1 = arg12 & 1;
        if(v1 != 0) {
            v2 = arg11 | 6;
        }
        else if((arg11 & 6) == 0) {
            v2 = arg10.changed(arg7) ? 4 : 2;
            v2 |= arg11;
        }
        else {
            v2 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            v3 = arg10.changedInstance(arg8) ? 0x20 : 16;
            v2 |= v3;
        }

        if((arg11 & 0x180) == 0) {
            v3 = arg10.changed(arg9) ? 0x100 : 0x80;
            v2 |= v3;
        }

        boolean v3_1 = (v2 & 0x93) != 0x92 ? true : false;
        if(arg10.shouldExecute(v3_1, v2 & 1)) {
            if(v1 != 0) {
                v7 = Modifier.Companion;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.ui.layout.MultiMeasureLayout (Layout.kt:241)");
            }

            v0 = Integer.hashCode(ComposablesKt.getCurrentCompositeKeyHash(arg10, 0));
            Modifier v1_1 = ComposedModifierKt.materializeModifier(arg10, ((Modifier)v7));
            CompositionLocalMap v3_2 = arg10.getCurrentCompositionLocalMap();
            Function0 v4 = LayoutNode.Companion.getConstructor$ui();
            v2 = v2 << 3 & 0x380 | 6;
            ComposerKt.sourceInformationMarkerStart(arg10, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(arg10.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg10.startReusableNode();
            if(arg10.getInserting()) {
                arg10.createNode(v4);
            }
            else {
                arg10.useNode();
            }

            Composer v4_1 = Updater.constructor-impl(arg10);
            Updater.set-impl(v4_1, arg9, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v4_1, v3_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v4_1, LayoutKt$MultiMeasureLayout$1$1.INSTANCE);
            Updater.reconcile-impl(v4_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v4_1, v1_1, ComposeUiNode.Companion.getSetModifier());
            Updater.init-impl(v4_1, Integer.valueOf(v0), ComposeUiNode.Companion.getSetCompositeKeyHash());
            arg8.invoke(arg10, Integer.valueOf(v2 >> 6 & 14));
            arg10.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg10);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_103;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_103:
        Modifier v2_1 = ((Modifier)v7);
        ScopeUpdateScope v7_1 = arg10.endRestartGroup();
        if(v7_1 != null) {
            v7_1.updateScope(new LayoutKt$MultiMeasureLayout$2(v2_1, arg8, arg9, arg11, arg12));
        }
    }

    public static final Function2 combineAsVirtualLayouts(List arg2) {
        return ComposableLambdaKt.composableLambdaInstance(0x4BCECE3C, true, new LayoutKt$combineAsVirtualLayouts$1(arg2));
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Needed only for backwards compatibility. Do not use.") public static final Function3 materializerOf(Modifier arg2) {
        return ComposableLambdaKt.composableLambdaInstance(0x816FC1A5, true, new LayoutKt$materializerOfWithCompositionLocalInjection$1(arg2));
    }

    public static final Function3 modifierMaterializerOf(Modifier arg2) {
        return ComposableLambdaKt.composableLambdaInstance(0xE184107F, true, new LayoutKt$materializerOf$1(arg2));
    }
}

