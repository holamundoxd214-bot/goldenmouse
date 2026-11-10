package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A!\u0010\u0000\u001A\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2={"TestModifierUpdaterLayout", "", "onAttached", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/TestModifierUpdater;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TestModifierUpdaterKt {
    @Deprecated(level=DeprecationLevel.ERROR, message="It is a test API, do not use it in the real applications") public static final void TestModifierUpdaterLayout(Function1 arg5, Composer arg6, int arg7) {
        TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$1 v1_2;
        int v1;
        int v0 = -1673066036;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(TestModifierUpdaterLayout)49@1770L27,50@1833L102,53@1940L280:TestModifierUpdater.kt#80mrfh");
        int v2 = 2;
        if((arg7 & 6) == 0) {
            v1 = arg6.changedInstance(arg5) ? 4 : v2;
            v1 |= arg7;
        }
        else {
            v1 = arg7;
        }

        boolean v2_1 = (v1 & 3) != v2 ? true : false;
        if(arg6.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.ui.layout.TestModifierUpdaterLayout (TestModifierUpdater.kt:48)");
            }

            v0 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg6, 0));
            ComposerKt.sourceInformationMarkerStart(arg6, -1498686510, "CC(remember):TestModifierUpdater.kt#9igjgp");
            Object v1_1 = arg6.rememberedValue();
            if(v1_1 == Composer.Companion.getEmpty()) {
                v1_2 = TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$1.INSTANCE;
                arg6.updateRememberedValue(v1_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg6);
            Function0 v2_2 = LayoutNode.Companion.getConstructor$ui();
            ComposerKt.sourceInformationMarkerStart(arg6, 0x7076B8D0, "CC(ComposeNode)N(factory,update):Composables.kt#9igjgp");
            if(!(arg6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg6.startNode();
            if(arg6.getInserting()) {
                arg6.createNode(v2_2);
            }
            else {
                arg6.useNode();
            }

            Composer v2_3 = Updater.constructor-impl(arg6);
            Updater.set-impl(v2_3, v1_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.init-impl(v2_3, Integer.valueOf(v0), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.init-impl(v2_3, new TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1(arg5));
            arg6.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg6);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_74;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_74:
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new TestModifierUpdaterKt$TestModifierUpdaterLayout$2(arg5, arg7));
        }
    }
}

