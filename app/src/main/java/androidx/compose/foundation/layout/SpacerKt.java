package androidx.compose.foundation.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0015\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2={"Spacer", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SpacerKt {
    public static final void Spacer(Modifier arg5, Composer arg6, int arg7) {
        int v1 = 0xFBA7E6DD;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(Spacer)N(modifier)38@1430L64:Spacer.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.foundation.layout.Spacer (Spacer.kt:37)");
        }

        SpacerMeasurePolicy v7 = SpacerMeasurePolicy.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(arg6, 0x207BAF9A, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
        int v0 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg6, 0));
        arg5 = ComposedModifierKt.materializeModifier(arg6, arg5);
        CompositionLocalMap v1_1 = arg6.getCurrentCompositionLocalMap();
        Function0 v2 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(arg6, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
        if(!(arg6.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }

        arg6.startReusableNode();
        if(arg6.getInserting()) {
            arg6.createNode(v2);
        }
        else {
            arg6.useNode();
        }

        Composer v2_1 = Updater.constructor-impl(arg6);
        Updater.set-impl(v2_1, v7, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(v2_1, v1_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.reconcile-impl(v2_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl(v2_1, arg5, ComposeUiNode.Companion.getSetModifier());
        Updater.init-impl(v2_1, Integer.valueOf(v0), ComposeUiNode.Companion.getSetCompositeKeyHash());
        arg6.endNode();
        ComposerKt.sourceInformationMarkerEnd(arg6);
        ComposerKt.sourceInformationMarkerEnd(arg6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
    }
}

