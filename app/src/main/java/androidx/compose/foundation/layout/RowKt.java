package androidx.compose.foundation.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001AJ\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u001C\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000B¢\u0006\u0002\b\fH\u0087\b¢\u0006\u0002\u0010\r\u001A\u001D\u0010\u0014\u001A\u00020\u000F2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0015\u001A5\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020\u001BH\u0000¢\u0006\u0002\u0010\u001F\"\u001C\u0010\u000E\u001A\u00020\u000F8\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2={"Row", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DefaultRowMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultRowMeasurePolicy$annotations", "()V", "getDefaultRowMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "rowMeasurePolicy", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "createRowConstraints", "Landroidx/compose/ui/unit/Constraints;", "isPrioritizing", "", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "(ZIIII)J", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RowKt {
    private static final MeasurePolicy DefaultRowMeasurePolicy;

    static {
        RowKt.DefaultRowMeasurePolicy = new RowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop());
    }

    public static final void Row(Modifier arg3, Horizontal arg4, Vertical arg5, Function3 arg6, Composer arg7, int arg8, int arg9) {
        Companion v3;
        ComposerKt.sourceInformationMarkerStart(arg7, 0x3255A44B, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        if((arg9 & 1) != 0) {
            v3 = Modifier.Companion;
        }

        if((arg9 & 2) != 0) {
            arg4 = Arrangement.INSTANCE.getStart();
        }

        if((arg9 & 4) != 0) {
            arg5 = Alignment.Companion.getTop();
        }

        MeasurePolicy v4 = RowKt.rowMeasurePolicy(arg4, arg5, arg7, arg8 >> 3 & 0x7E);
        ComposerKt.sourceInformationMarkerStart(arg7, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int v5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg7, 0));
        CompositionLocalMap v9 = arg7.getCurrentCompositionLocalMap();
        arg3 = ComposedModifierKt.materializeModifier(arg7, ((Modifier)v3));
        Function0 v0 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(arg7, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if(!(arg7.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }

        arg7.startReusableNode();
        if(arg7.getInserting()) {
            arg7.createNode(v0);
        }
        else {
            arg7.useNode();
        }

        Composer v0_1 = Updater.constructor-impl(arg7);
        Updater.set-impl(v0_1, v4, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(v0_1, v9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl(v0_1, Integer.valueOf(v5), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl(v0_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl(v0_1, arg3, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(arg7, 0x56CCD6F5, "C101@5233L9:Row.kt#2w3rfo");
        arg6.invoke(RowScopeInstance.INSTANCE, arg7, Integer.valueOf(arg8 >> 6 & 0x70 | 6));
        ComposerKt.sourceInformationMarkerEnd(arg7);
        arg7.endNode();
        ComposerKt.sourceInformationMarkerEnd(arg7);
        ComposerKt.sourceInformationMarkerEnd(arg7);
        ComposerKt.sourceInformationMarkerEnd(arg7);
    }

    public static final long createRowConstraints(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
        if(!arg0) {
            return ConstraintsKt.Constraints(arg1, arg3, arg2, arg4);
        }

        return Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(arg1, arg3, arg2, arg4);
    }

    public static final MeasurePolicy getDefaultRowMeasurePolicy() {
        return RowKt.DefaultRowMeasurePolicy;
    }

    public static void getDefaultRowMeasurePolicy$annotations() {
    }

    public static final MeasurePolicy rowMeasurePolicy(Horizontal arg5, Vertical arg6, Composer arg7, int arg8) {
        Object v5_1;
        int v1 = 0xCE1011B2;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(rowMeasurePolicy)N(horizontalArrangement,verticalAlignment):Row.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.foundation.layout.rowMeasurePolicy (Row.kt:118)");
        }

        if(!Intrinsics.areEqual(arg5, Arrangement.INSTANCE.getStart()) || !Intrinsics.areEqual(arg6, Alignment.Companion.getTop())) {
            arg7.startReplaceGroup(0xBFFF6C60);
            ComposerKt.sourceInformation(arg7, "121@5901L224");
            ComposerKt.sourceInformationMarkerStart(arg7, -1974300398, "CC(remember):Row.kt#9igjgp");
            v1 = 0;
            int v3 = 4;
            int v0 = (arg8 & 14 ^ 6) > v3 && (arg7.changed(arg5)) || (arg8 & 6) == v3 ? 1 : 0;
            int v4 = 0x20;
            if((arg8 & 0x70 ^ 0x30) > v4 && (arg7.changed(arg6)) || (arg8 & 0x30) == v4) {
                v1 = 1;
            }

            arg8 = v0 | v1;
            Object v0_1 = arg7.rememberedValue();
            if(arg8 != 0 || v0_1 == Composer.Companion.getEmpty()) {
                RowMeasurePolicy v0_2 = new RowMeasurePolicy(arg5, arg6);
                arg7.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg7);
            arg7.endReplaceGroup();
            v5_1 = v0_1;
        }
        else {
            arg7.startReplaceGroup(0xBFFEA5A9);
            arg7.endReplaceGroup();
            MeasurePolicy v5 = RowKt.DefaultRowMeasurePolicy;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return ((MeasurePolicy)v5_1);
    }
}

