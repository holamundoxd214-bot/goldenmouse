package androidx.compose.ui.window;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A8\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0011\u0010\u0006\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b\u001A*\u0010\t\u001A\u00020\u00012\b\b\u0002\u0010\n\u001A\u00020\u000B2\u0011\u0010\u0006\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0003¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\u0015\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007X\u008A\u0084\u0002"}, d2={"Dialog", "", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DialogLayout", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui", "currentContent"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidDialog_androidKt {
    public static final void Dialog(Function0 arg21, DialogProperties arg22, Function2 arg23, Composer arg24, int arg25, int arg26) {
        AndroidDialog_androidKt$Dialog$dialogId$1$1 v11_1;
        DialogProperties v2_2;
        int v5;
        DialogProperties v4;
        int v2;
        Function0 v1 = arg21;
        Function2 v7 = arg23;
        int v8 = arg25;
        int v0 = 0x3145F7AD;
        Composer v9 = arg24.startRestartGroup(v0);
        ComposerKt.sourceInformation(v9, "C(Dialog)P(1,2)202@8819L7,203@8858L7,204@8913L7,205@8943L28,206@8998L29,207@9064L21,207@9047L38,209@9111L330,218@9472L129,218@9447L154,227@9618L183,227@9607L194:AndroidDialog.android.kt#2oxthz");
        if((v8 & 6) == 0) {
            v2 = v9.changedInstance(v1) ? 4 : 2;
            v2 |= v8;
        }
        else {
            v2 = v8;
        }

        int v3 = arg26 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_32;
        }
        else if((v8 & 0x30) == 0) {
            v4 = arg22;
            v5 = v9.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_32:
            v4 = arg22;
        }

        if((v8 & 0x180) == 0) {
            v5 = v9.changedInstance(v7) ? 0x100 : 0x80;
            v2 |= v5;
        }

        int v12 = v2;
        int v13 = 1;
        boolean v2_1 = (v12 & 0x93) != 0x92 ? true : false;
        if(v9.shouldExecute(v2_1, v12 & 1)) {
            v2_2 = v3 != 0 ? new DialogProperties(false, false, false, 7, null) : v4;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v12, -1, "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:201)");
            }

            ProvidableCompositionLocal v0_1 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(v9, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = v9.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v9);
            ProvidableCompositionLocal v5_1 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v9, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v5_2 = v9.consume(((CompositionLocal)v5_1));
            ComposerKt.sourceInformationMarkerEnd(v9);
            ProvidableCompositionLocal v6 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v9, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v3_1 = v9.consume(((CompositionLocal)v6));
            ComposerKt.sourceInformationMarkerEnd(v9);
            Object v4_1 = v3_1;
            CompositionContext v15 = ComposablesKt.rememberCompositionContext(v9, 0);
            State v3_2 = SnapshotStateKt.rememberUpdatedState(v7, v9, v12 >> 6 & 14);
            Object[] v6_1 = new Object[0];
            String v10 = "CC(remember):AndroidDialog.android.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v9, -140054174, v10);
            Object v11 = v9.rememberedValue();
            if(v11 == Composer.Companion.getEmpty()) {
                v11_1 = AndroidDialog_androidKt$Dialog$dialogId$1$1.INSTANCE;
                v9.updateRememberedValue(v11_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            Object v6_2 = RememberSaveableKt.rememberSaveable(v6_1, ((Function0)v11_1), v9, 0x30);
            ComposerKt.sourceInformationMarkerStart(v9, -140052361, v10);
            int v11_2 = v9.changed(v0_2) | v9.changed(v5_2);
            Object v14 = v9.rememberedValue();
            if(v11_2 != 0 || v14 == Composer.Companion.getEmpty()) {
                DialogWrapper v0_3 = new DialogWrapper(v1, v2_2, v0_2, ((LayoutDirection)v4_1), ((Density)v5_2), ((UUID)v6_2));
                v0_3.setContent(v15, ComposableLambdaKt.composableLambdaInstance(346960332, true, new AndroidDialog_androidKt$Dialog$dialog$1$1$1(v3_2)));
                v9.updateRememberedValue(v0_3);
                DialogWrapper v14_1 = v0_3;
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerStart(v9, -140041010, v10);
            boolean v0_4 = v9.changedInstance(v14);
            v3_1 = v9.rememberedValue();
            if((v0_4) || v3_1 == Composer.Companion.getEmpty()) {
                AndroidDialog_androidKt$Dialog$1$1 v3_3 = new AndroidDialog_androidKt$Dialog$1$1(((DialogWrapper)v14));
                v9.updateRememberedValue(v3_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            EffectsKt.DisposableEffect(v14, ((Function1)v3_1), v9, 0);
            ComposerKt.sourceInformationMarkerStart(v9, -140036284, v10);
            v0_4 = v9.changedInstance(v14);
            v3 = (v12 & 14) == 4 ? 1 : 0;
            v0 = (((int)v0_4)) | v3;
            if((v12 & 0x70) == 0x20) {
            }
            else {
                v13 = 0;
            }

            v0 = v0 | v13 | v9.changed(v4_1.ordinal());
            v3_1 = v9.rememberedValue();
            if(v0 != 0 || v3_1 == Composer.Companion.getEmpty()) {
                AndroidDialog_androidKt$Dialog$2$1 v3_4 = new AndroidDialog_androidKt$Dialog$2$1(((DialogWrapper)v14), v1, v2_2, ((LayoutDirection)v4_1));
                v9.updateRememberedValue(v3_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            EffectsKt.SideEffect(((Function0)v3_1), v9, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_176;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v9.skipToGroupEnd();
            v2_2 = v4;
        }

    label_176:
        ScopeUpdateScope v6_3 = v9.endRestartGroup();
        if(v6_3 != null) {
            v6_3.updateScope(new AndroidDialog_androidKt$Dialog$3(v1, v2_2, v7, v8, arg26));
        }
    }

    private static final Function2 Dialog$lambda$0(State arg0) {
        return arg0.getValue();
    }

    private static final void DialogLayout(Modifier arg8, Function2 arg9, Composer arg10, int arg11, int arg12) {
        AndroidDialog_androidKt$DialogLayout$1$1 v0_2;
        Companion v8;
        int v2;
        int v0 = 0x4100086B;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(DialogLayout)P(1)688@28193L559,688@28146L606:AndroidDialog.android.kt#2oxthz");
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
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.ui.window.DialogLayout (AndroidDialog.android.kt:687)");
            }

            ComposerKt.sourceInformationMarkerStart(arg10, 0x11FAC9A, "CC(remember):AndroidDialog.android.kt#9igjgp");
            Object v0_1 = arg10.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = AndroidDialog_androidKt$DialogLayout$1$1.INSTANCE;
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
            Updater.set-impl(v5_1, v0_2, ComposeUiNode.Companion.getSetMeasurePolicy());
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
            v10.updateScope(new AndroidDialog_androidKt$DialogLayout$2(((Modifier)v8), arg9, arg11, arg12));
        }
    }

    public static final Function2 access$Dialog$lambda$0(State arg0) {
        return AndroidDialog_androidKt.Dialog$lambda$0(arg0);
    }

    public static final void access$DialogLayout(Modifier arg0, Function2 arg1, Composer arg2, int arg3, int arg4) {
        AndroidDialog_androidKt.DialogLayout(arg0, arg1, arg2, arg3, arg4);
    }
}

