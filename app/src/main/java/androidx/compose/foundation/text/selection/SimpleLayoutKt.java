package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A*\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"SimpleLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SimpleLayoutKt {
    public static final void SimpleLayout(Modifier arg8, Function2 arg9, Composer arg10, int arg11, int arg12) {
        Companion v8;
        int v2;
        int v0 = 0x91717CFD;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(SimpleLayout)N(modifier,content)31@1175L460,31@1128L507:SimpleLayout.kt#eksfi3");
        int v1 = arg12 & 1;
        if(v1 != 0) {
            v2 = arg11 | 6;
        }
        else if((arg11 & 6) == 0) {
            v2 = arg10.changed(arg8) ? 4 : 2;
            v2 |= arg11;
        }
        else {
            v2 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            int v3 = arg10.changedInstance(arg9) ? 0x20 : 16;
            v2 |= v3;
        }

        boolean v3_1 = (v2 & 19) != 18 ? true : false;
        if(arg10.shouldExecute(v3_1, v2 & 1)) {
            if(v1 != 0) {
                v8 = Modifier.Companion;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.foundation.text.selection.SimpleLayout (SimpleLayout.kt:30)");
            }

            ComposerKt.sourceInformationMarkerStart(arg10, 0xFB064449, "CC(remember):SimpleLayout.kt#9igjgp");
            Object v0_1 = arg10.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                SimpleLayoutKt$SimpleLayout$1$1 v0_2 = SimpleLayoutKt$SimpleLayout$1$1.INSTANCE;
                arg10.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg10);
            v1 = v2 >> 3 & 14 | 0x180 | v2 << 3 & 0x70;
            ComposerKt.sourceInformationMarkerStart(arg10, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            v2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg10, 0));
            CompositionLocalMap v3_2 = arg10.getCurrentCompositionLocalMap();
            Modifier v4 = ComposedModifierKt.materializeModifier(arg10, ((Modifier)v8));
            Function0 v5 = ComposeUiNode.Companion.getConstructor();
            v1 = v1 << 6 & 0x380 | 6;
            ComposerKt.sourceInformationMarkerStart(arg10, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(arg10.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg10.startReusableNode();
            if(arg10.getInserting()) {
                arg10.createNode(v5);
            }
            else {
                arg10.useNode();
            }

            Composer v5_1 = Updater.constructor-impl(arg10);
            Updater.set-impl(v5_1, v0_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_1, v3_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v5_1, Integer.valueOf(v2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v5_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v5_1, v4, ComposeUiNode.Companion.getSetModifier());
            arg9.invoke(arg10, Integer.valueOf(v1 >> 6 & 14));
            arg10.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg10);
            ComposerKt.sourceInformationMarkerEnd(arg10);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_113;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_113:
        ScopeUpdateScope v10 = arg10.endRestartGroup();
        if(v10 != null) {
            v10.updateScope(new SimpleLayoutKt$$ExternalSyntheticLambda0(((Modifier)v8), arg9, arg11, arg12));
        }
    }

    static final Unit SimpleLayout$lambda$1(Modifier arg0, Function2 arg1, int arg2, int arg3, Composer arg4, int arg5) {
        SimpleLayoutKt.SimpleLayout(arg0, arg1, arg4, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1), arg3);
        return Unit.INSTANCE;
    }
}

