package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001As\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u00052\u0017\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\u000E\b\u0002\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u000F\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001AF\u0010\u0012\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\n\u001A\u00020\u000B2\u0017\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\tH\u0001¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2={"ContextMenuArea", "", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "onDismiss", "Lkotlin/Function0;", "contextMenuBuilderBlock", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "onOpenGesture", "content", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/contextmenu/ContextMenuState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ContextMenu", "(Landroidx/compose/foundation/contextmenu/ContextMenuState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ContextMenuAreaKt {
    public static Unit $r8$lambda$E45JQyHDO2U9gdoYrME_KlsZOes() {
        return ContextMenuAreaKt.ContextMenuArea$lambda$0$0();
    }

    public static Unit $r8$lambda$kggTOENSgMwNPzBaLs7Gw7wlPE8(Function0 arg0, ContextMenuState arg1, Offset arg2) {
        return ContextMenuAreaKt.ContextMenuArea$lambda$1$0(arg0, arg1, arg2);
    }

    public static final void ContextMenu(ContextMenuState arg11, Function0 arg12, Modifier arg13, Function1 arg14, Composer arg15, int arg16, int arg17) {
        Composer v5_2;
        ContextMenuPopupPositionProvider v4_2;
        ContextMenuAreaKt$$ExternalSyntheticLambda3 v0_1;
        ScopeUpdateScope v13_2;
        Modifier v3_1;
        Companion v13;
        int v3;
        int v2;
        int v5 = arg16;
        int v0 = 0xF45FB156;
        Composer v1 = arg15.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(ContextMenu)N(state,onDismiss,modifier,contextMenuBuilderBlock)78@2706L76,80@2788L197:ContextMenuArea.kt#3xeu6s");
        if((v5 & 6) == 0) {
            v2 = v1.changed(arg11) ? 4 : 2;
            v2 |= v5;
        }
        else {
            v2 = v5;
        }

        if((v5 & 0x30) == 0) {
            v3 = v1.changedInstance(arg12) ? 0x20 : 16;
            v2 |= v3;
        }

        v3 = arg17 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
        }
        else if((v5 & 0x180) == 0) {
            int v4 = v1.changed(arg13) ? 0x100 : 0x80;
            v2 |= v4;
        }

        if((v5 & 0xC00) == 0) {
            int v6 = v1.changedInstance(arg14) ? 0x800 : 0x400;
            v2 |= v6;
        }

        boolean v6_1 = (v2 & 0x493) != 1170 ? true : false;
        if(v1.shouldExecute(v6_1, v2 & 1)) {
            if(v3 != 0) {
                v13 = Modifier.Companion;
            }

            v3_1 = ((Modifier)v13);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.foundation.contextmenu.ContextMenu (ContextMenuArea.kt:73)");
            }

            Status v13_1 = arg11.getStatus();
            if(!(v13_1 instanceof Open)) {
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }

                v13_2 = v1.endRestartGroup();
                if(v13_2 == null) {
                    return;
                }

                v0_1 = new ContextMenuAreaKt$$ExternalSyntheticLambda3(arg11, arg12, v3_1, arg14, v5, arg17);
                goto label_74;
            }

            ComposerKt.sourceInformationMarkerStart(v1, 1530451746, "CC(remember):ContextMenuArea.kt#9igjgp");
            boolean v0_2 = v1.changed(v13_1);
            Object v4_1 = v1.rememberedValue();
            if((v0_2) || v4_1 == Composer.Companion.getEmpty()) {
                ContextMenuPopupPositionProvider v5_1 = new ContextMenuPopupPositionProvider(IntOffsetKt.round-k-4lQ0M(((Open)v13_1).getOffset-F1C5BW0()), null, 2, null);
                v1.updateRememberedValue(v5_1);
                v4_2 = v5_1;
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v5_2 = v1;
            ContextMenuUiKt.ContextMenuPopup(v4_2, arg12, v3_1, arg14, v5_2, v2 & 0x1FF0, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_109;
            }

            ComposerKt.traceEventEnd();
            goto label_109;
        }
        else {
            v5_2 = v1;
            v5_2.skipToGroupEnd();
            v3_1 = arg13;
        label_109:
            v13_2 = v5_2.endRestartGroup();
            if(v13_2 == null) {
                return;
            }

            ContextMenuAreaKt$$ExternalSyntheticLambda4 v0_3 = new ContextMenuAreaKt$$ExternalSyntheticLambda4(arg11, arg12, v3_1, arg14, arg16, arg17);
        label_74:
            v13_2.updateScope(((Function2)v0_1));
            return;
        }
    }

    static final Unit ContextMenu$lambda$0(ContextMenuState arg7, Function0 arg8, Modifier arg9, Function1 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        ContextMenuAreaKt.ContextMenu(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    static final Unit ContextMenu$lambda$2(ContextMenuState arg7, Function0 arg8, Modifier arg9, Function1 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        ContextMenuAreaKt.ContextMenu(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    public static final void ContextMenuArea(ContextMenuState arg17, Function0 arg18, Function1 arg19, Modifier arg20, boolean arg21, Function0 arg22, Function2 arg23, Composer arg24, int arg25, int arg26) {
        Object v6_1;
        Modifier v3_3;
        ContextMenuAreaKt$$ExternalSyntheticLambda1 v11_2;
        Object v9_1;
        int v16;
        Function0 v15_1;
        int v13;
        boolean v12;
        int v11;
        Modifier v10;
        int v9;
        Function0 v5;
        int v2;
        ContextMenuState v0 = arg17;
        Function2 v7 = arg23;
        int v8 = arg25;
        Composer v4 = arg24.startRestartGroup(1195420540);
        ComposerKt.sourceInformation(v4, "C(ContextMenuArea)N(state,onDismiss,contextMenuBuilderBlock,modifier,enabled,onOpenGesture,content)44@1861L2,56@2150L232:ContextMenuArea.kt#3xeu6s");
        if((v8 & 6) == 0) {
            v2 = v4.changed(v0) ? 4 : 2;
            v2 |= v8;
        }
        else {
            v2 = v8;
        }

        if((v8 & 0x30) == 0) {
            v5 = arg18;
            int v6 = v4.changedInstance(v5) ? 0x20 : 16;
            v2 |= v6;
        }
        else {
            v5 = arg18;
        }

        if((v8 & 0x180) == 0) {
            v9 = v4.changedInstance(arg19) ? 0x100 : 0x80;
            v2 |= v9;
        }

        v9 = arg26 & 8;
        if(v9 != 0) {
            v2 |= 0xC00;
            goto label_54;
        }
        else if((v8 & 0xC00) == 0) {
            v10 = arg20;
            v11 = v4.changed(v10) ? 0x800 : 0x400;
            v2 |= v11;
        }
        else {
        label_54:
            v10 = arg20;
        }

        v11 = arg26 & 16;
        if(v11 != 0) {
            v2 |= 0x6000;
            goto label_69;
        }
        else if((v8 & 0x6000) == 0) {
            v12 = arg21;
            v13 = v4.changed(v12) ? 0x4000 : 0x2000;
            v2 |= v13;
        }
        else {
        label_69:
            v12 = arg21;
        }

        v13 = arg26 & 0x20;
        int v15 = 0x30000;
        if(v13 != 0) {
            v2 |= v15;
            goto label_85;
        }
        else if((v15 & v8) == 0) {
            v15_1 = arg22;
            v16 = v4.changedInstance(v15_1) ? 0x20000 : 0x10000;
            v2 |= v16;
        }
        else {
        label_85:
            v15_1 = arg22;
        }

        if((v8 & 0x180000) == 0) {
            v16 = v4.changedInstance(v7) ? 0x100000 : 0x80000;
            v2 |= v16;
        }

        boolean v3 = (v2 & 0x92493) != 0x92492 ? true : false;
        if(v4.shouldExecute(v3, v2 & 1)) {
            if(v9 != 0) {
                Companion v10_1 = Modifier.Companion;
            }

            if(v11 != 0) {
                v12 = true;
            }

            String v3_1 = "CC(remember):ContextMenuArea.kt#9igjgp";
            if(v13 != 0) {
                ComposerKt.sourceInformationMarkerStart(v4, 2042878302, v3_1);
                v9_1 = v4.rememberedValue();
                if(v9_1 == Composer.Companion.getEmpty()) {
                    ContextMenuAreaKt$$ExternalSyntheticLambda0 v9_2 = new ContextMenuAreaKt$$ExternalSyntheticLambda0();
                    v4.updateRememberedValue(v9_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
            }
            else {
                Function0 v9_3 = v15_1;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1195420540, v2, -1, "androidx.compose.foundation.contextmenu.ContextMenuArea (ContextMenuArea.kt:46)");
            }

            if(v12) {
                v4.startReplaceGroup(-1095188022);
                ComposerKt.sourceInformation(v4, "49@1994L103");
                ComposerKt.sourceInformationMarkerStart(v4, 2042882659, v3_1);
                int v3_2 = (0x70000 & v2) == 0x20000 ? 1 : 0;
                v11 = (v2 & 14) == 4 ? 1 : 0;
                v3_2 |= v11;
                Object v11_1 = v4.rememberedValue();
                if(v3_2 != 0 || v11_1 == Composer.Companion.getEmpty()) {
                    v11_2 = new ContextMenuAreaKt$$ExternalSyntheticLambda1(((Function0)v9_1), v0);
                    v4.updateRememberedValue(v11_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v3_3 = ContextMenuGesturesKt.contextMenuGestures(v10, ((Function1)v11_2));
                v4.endReplaceGroup();
            }
            else {
                v4.startReplaceGroup(-1095031162);
                v4.endReplaceGroup();
                v3_3 = v10;
            }

            ComposerKt.sourceInformationMarkerStart(v4, 0x3E277F0A, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy v1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(v4, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            v11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v4, 0));
            CompositionLocalMap v13_1 = v4.getCurrentCompositionLocalMap();
            v3_3 = ComposedModifierKt.materializeModifier(v4, v3_3);
            Function0 v14 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v4, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(v4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v4.startReusableNode();
            if(v4.getInserting()) {
                v4.createNode(v14);
            }
            else {
                v4.useNode();
            }

            Composer v0_1 = Updater.constructor-impl(v4);
            Updater.set-impl(v0_1, v1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v0_1, v13_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v0_1, Integer.valueOf(v11), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v0_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v0_1, v3_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v4, 0xB1577F48, "C57@2211L9,58@2229L147:ContextMenuArea.kt#3xeu6s");
            v7.invoke(v4, Integer.valueOf(v2 >> 18 & 14));
            ContextMenuAreaKt.ContextMenu(arg17, v5, null, arg19, v4, v2 & 0x7E | v2 << 3 & 0x1C00, 4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            v4.endNode();
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6_1 = v9_1;
        }
        else {
            v4.skipToGroupEnd();
            Function0 v6_2 = v15_1;
        }

        boolean v5_1 = v12;
        ScopeUpdateScope v11_3 = v4.endRestartGroup();
        if(v11_3 != null) {
            v11_3.updateScope(new ContextMenuAreaKt$$ExternalSyntheticLambda2(arg17, arg18, arg19, v10, v5_1, ((Function0)v6_1), v7, v8, arg26));
        }
    }

    private static final Unit ContextMenuArea$lambda$0$0() {
        return Unit.INSTANCE;
    }

    private static final Unit ContextMenuArea$lambda$1$0(Function0 arg2, ContextMenuState arg3, Offset arg4) {
        arg2.invoke();
        arg3.setStatus(new Open(arg4.unbox-impl(), null));
        return Unit.INSTANCE;
    }

    static final Unit ContextMenuArea$lambda$3(ContextMenuState arg11, Function0 arg12, Function1 arg13, Modifier arg14, boolean arg15, Function0 arg16, Function2 arg17, int arg18, int arg19, Composer arg20, int arg21) {
        ContextMenuAreaKt.ContextMenuArea(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }
}

