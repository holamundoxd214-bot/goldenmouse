package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000M\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000*\u0001\u0013\u001A6\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u001D\u0010\u0004\u001A\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001A>\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u001D\u0010\u0004\u001A\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\r\u001A\u000E\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011\"\u0010\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014\"\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0017\u001A\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"SubcomposeLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "state", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SubcomposeSlotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "maxSlotsToRetainForReuse", "", "ReusedSlotId", "androidx/compose/ui/layout/SubcomposeLayoutKt$ReusedSlotId$1", "Landroidx/compose/ui/layout/SubcomposeLayoutKt$ReusedSlotId$1;", "UnspecifiedSlotId", "", "ExtraLoggingEnabled", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SubcomposeLayoutKt {
    private static final boolean ExtraLoggingEnabled = false;
    private static final SubcomposeLayoutKt$ReusedSlotId$1 ReusedSlotId;
    private static final Object UnspecifiedSlotId;

    static {
        SubcomposeLayoutKt.ReusedSlotId = new SubcomposeLayoutKt$ReusedSlotId$1();
        SubcomposeLayoutKt.UnspecifiedSlotId = new Object();
    }

    public static final void SubcomposeLayout(Modifier arg7, Function2 arg8, Composer arg9, int arg10, int arg11) {
        Function2 v3;
        Companion v7;
        int v1;
        int v0 = 0xB29CB430;
        Composer v4 = arg9.startRestartGroup(v0);
        ComposerKt.sourceInformation(v4, "C(SubcomposeLayout)P(1)97@4796L36,96@4762L145:SubcomposeLayout.kt#80mrfh");
        int v9 = arg11 & 1;
        if(v9 != 0) {
            v1 = arg10 | 6;
        }
        else if((arg10 & 6) == 0) {
            v1 = v4.changed(arg7) ? 4 : 2;
            v1 |= arg10;
        }
        else {
            v1 = arg10;
        }

        if((arg10 & 0x30) == 0) {
            int v2 = v4.changedInstance(arg8) ? 0x20 : 16;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 19) != 18 ? true : false;
        if(v4.shouldExecute(v2_1, v1 & 1)) {
            if(v9 != 0) {
                v7 = Modifier.Companion;
            }

            Modifier v2_2 = ((Modifier)v7);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:95)");
            }

            ComposerKt.sourceInformationMarkerStart(v4, 0x7E407DF4, "CC(remember):SubcomposeLayout.kt#9igjgp");
            Object v7_1 = v4.rememberedValue();
            if(v7_1 == Composer.Companion.getEmpty()) {
                SubcomposeLayoutState v7_2 = new SubcomposeLayoutState();
                v4.updateRememberedValue(v7_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            v3 = arg8;
            SubcomposeLayoutKt.SubcomposeLayout(v7_1, v2_2, v3, v4, v1 << 3 & 0x3F0, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            arg7 = v2_2;
        }
        else {
            v3 = arg8;
            v4.skipToGroupEnd();
        }

        ScopeUpdateScope v8 = v4.endRestartGroup();
        if(v8 != null) {
            v8.updateScope(new SubcomposeLayoutKt$SubcomposeLayout$2(arg7, v3, arg10, arg11));
        }
    }

    public static final void SubcomposeLayout(SubcomposeLayoutState arg8, Modifier arg9, Function2 arg10, Composer arg11, int arg12, int arg13) {
        SubcomposeLayoutKt$SubcomposeLayout$4$1 v1_3;
        Companion v9;
        int v3;
        int v1;
        int v0 = 0xE17BA7B9;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(SubcomposeLayout)P(2,1)129@6259L27,130@6327L28,133@6483L492:SubcomposeLayout.kt#80mrfh");
        if((arg12 & 6) == 0) {
            v1 = arg11.changedInstance(arg8) ? 4 : 2;
            v1 |= arg12;
        }
        else {
            v1 = arg12;
        }

        int v2 = arg13 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
        }
        else if((arg12 & 0x30) == 0) {
            v3 = arg11.changed(arg9) ? 0x20 : 16;
            v1 |= v3;
        }

        if((arg12 & 0x180) == 0) {
            v3 = arg11.changedInstance(arg10) ? 0x100 : 0x80;
            v1 |= v3;
        }

        boolean v3_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg11.shouldExecute(v3_1, v1 & 1)) {
            if(v2 != 0) {
                v9 = Modifier.Companion;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:128)");
            }

            v0 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg11, 0));
            CompositionContext v1_1 = ComposablesKt.rememberCompositionContext(arg11, 0);
            Modifier v2_1 = ComposedModifierKt.materializeModifier(arg11, ((Modifier)v9));
            CompositionLocalMap v3_2 = arg11.getCurrentCompositionLocalMap();
            Function0 v4 = LayoutNode.Companion.getConstructor$ui();
            ComposerKt.sourceInformationMarkerStart(arg11, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
            if(!(arg11.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg11.startReusableNode();
            if(arg11.getInserting()) {
                arg11.createNode(v4);
            }
            else {
                arg11.useNode();
            }

            Composer v4_1 = Updater.constructor-impl(arg11);
            Updater.set-impl(v4_1, arg8, arg8.getSetRoot$ui());
            Updater.set-impl(v4_1, v1_1, arg8.getSetCompositionContext$ui());
            Updater.set-impl(v4_1, arg10, arg8.getSetMeasurePolicy$ui());
            Updater.set-impl(v4_1, v3_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.reconcile-impl(v4_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v4_1, v2_1, ComposeUiNode.Companion.getSetModifier());
            Updater.init-impl(v4_1, Integer.valueOf(v0), ComposeUiNode.Companion.getSetCompositeKeyHash());
            arg11.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg11);
            if(!arg11.getSkipping()) {
                arg11.startReplaceGroup(0xB4F1728C);
                ComposerKt.sourceInformation(arg11, "146@7032L34,146@7021L45");
                ComposerKt.sourceInformationMarkerStart(arg11, 1899042491, "CC(remember):SubcomposeLayout.kt#9igjgp");
                boolean v0_1 = arg11.changedInstance(arg8);
                Object v1_2 = arg11.rememberedValue();
                if((v0_1) || v1_2 == Composer.Companion.getEmpty()) {
                    v1_3 = new SubcomposeLayoutKt$SubcomposeLayout$4$1(arg8);
                    arg11.updateRememberedValue(v1_3);
                }

                ComposerKt.sourceInformationMarkerEnd(arg11);
                EffectsKt.SideEffect(((Function0)v1_3), arg11, 0);
            }
            else {
                arg11.startReplaceGroup(-1266202711);
            }

            arg11.endReplaceGroup();
            if(!ComposerKt.isTraceInProgress()) {
                goto label_123;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_123:
        Modifier v3_3 = ((Modifier)v9);
        ScopeUpdateScope v9_1 = arg11.endRestartGroup();
        if(v9_1 != null) {
            v9_1.updateScope(new SubcomposeLayoutKt$SubcomposeLayout$5(arg8, v3_3, arg10, arg12, arg13));
        }
    }

    public static final SubcomposeSlotReusePolicy SubcomposeSlotReusePolicy(int arg1) {
        return new FixedCountSubcomposeSlotReusePolicy(arg1);
    }

    public static final SubcomposeLayoutKt$ReusedSlotId$1 access$getReusedSlotId$p() {
        return SubcomposeLayoutKt.ReusedSlotId;
    }

    public static final Object access$getUnspecifiedSlotId$p() {
        return SubcomposeLayoutKt.UnspecifiedSlotId;
    }
}

