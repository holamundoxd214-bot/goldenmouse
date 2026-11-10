package androidx.compose.ui.spatial;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0017\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2={"RectListDebugger", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RectListDebugger_androidKt {
    public static final void RectListDebugger(Modifier arg7, Composer arg8, int arg9, int arg10) {
        Companion v7;
        int v3;
        int v0 = 949081399;
        arg8 = arg8.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg8, "C(RectListDebugger)39@1564L78:RectListDebugger.android.kt#2zyoiz");
        int v1 = arg10 & 1;
        int v2 = 2;
        if(v1 != 0) {
            v3 = arg9 | 6;
        }
        else if((arg9 & 6) == 0) {
            v3 = arg8.changed(arg7) ? 4 : v2;
            v3 |= arg9;
        }
        else {
            v3 = arg9;
        }

        boolean v2_1 = (v3 & 3) != v2 ? true : false;
        if(arg8.shouldExecute(v2_1, v3 & 1)) {
            if(v1 != 0) {
                v7 = Modifier.Companion;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.ui.spatial.RectListDebugger (RectListDebugger.android.kt:38)");
            }

            Modifier v0_1 = ((Modifier)v7).then(RectListDebuggerModifierElement.INSTANCE);
            EmptyFillMeasurePolicy v1_1 = EmptyFillMeasurePolicy.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(arg8, 0x207BAF9A, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
            v2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg8, 0));
            v0_1 = ComposedModifierKt.materializeModifier(arg8, v0_1);
            CompositionLocalMap v3_1 = arg8.getCurrentCompositionLocalMap();
            Function0 v4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(arg8, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
            if(!(arg8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg8.startReusableNode();
            if(arg8.getInserting()) {
                arg8.createNode(v4);
            }
            else {
                arg8.useNode();
            }

            Composer v4_1 = Updater.constructor-impl(arg8);
            Updater.set-impl(v4_1, v1_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v4_1, v3_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.reconcile-impl(v4_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v4_1, v0_1, ComposeUiNode.Companion.getSetModifier());
            Updater.init-impl(v4_1, Integer.valueOf(v2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            arg8.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg8);
            ComposerKt.sourceInformationMarkerEnd(arg8);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_85;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg8.skipToGroupEnd();
        }

    label_85:
        ScopeUpdateScope v8 = arg8.endRestartGroup();
        if(v8 != null) {
            v8.updateScope(new RectListDebugger_androidKt$RectListDebugger$1(((Modifier)v7), arg9, arg10));
        }
    }
}

