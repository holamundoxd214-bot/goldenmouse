package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\u001AF\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0017\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000B¢\u0006\u0002\b\rH\u0001¢\u0006\u0002\u0010\u000E\u001AN\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u00102\u0017\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000B¢\u0006\u0002\b\rH\u0001¢\u0006\u0002\u0010\u0011\u001A:\u0010\u0012\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\u0017\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000B¢\u0006\u0002\b\rH\u0001¢\u0006\u0002\u0010\u0013\u001A=\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\b\u001A\u00020\t2\u001C\u0010\u0015\u001A\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u000B¢\u0006\u0002\b\u0017¢\u0006\u0002\b\rH\u0001¢\u0006\u0002\u0010\u0018\u001Ai\u0010\u0019\u001A\u00020\u00032\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\b\u001A\u00020\t2*\b\u0002\u0010\u001E\u001A$\u0012\u0013\u0012\u00110\u001F¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000B¢\u0006\u0002\b\u00172\f\u0010#\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0001¢\u0006\u0002\u0010$\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010%\u001A\u00020&X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\'\u001A\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b(\u0010)¨\u0006*"}, d2={"DefaultPopupProperties", "Landroidx/compose/ui/window/PopupProperties;", "ContextMenuPopup", "", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "onDismiss", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "contextMenuBuilderBlock", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "colors", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/contextmenu/ContextMenuColors;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ContextMenuColumnBuilder", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/contextmenu/ContextMenuColors;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ContextMenuColumn", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ContextMenuItem", "label", "", "enabled", "", "leadingIcon", "Landroidx/compose/ui/graphics/Color;", "Lkotlin/ParameterName;", "name", "iconColor", "onClick", "(Ljava/lang/String;ZLandroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DisabledAlpha", "", "DefaultContextMenuColors", "getDefaultContextMenuColors", "()Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ContextMenuUiKt {
    private static final ContextMenuColors DefaultContextMenuColors = null;
    private static final PopupProperties DefaultPopupProperties = null;
    private static final float DisabledAlpha = 0.38f;

    public static Unit $r8$lambda$ViyJhNCHV1lbMmXWjZzWDd1lOCY(boolean arg0, Function0 arg1) {
        return ContextMenuUiKt.ContextMenuItem$lambda$0$0(arg0, arg1);
    }

    static {
        ContextMenuUiKt.DefaultPopupProperties = new PopupProperties(true, false, false, false, 14, null);
        ContextMenuUiKt.DefaultContextMenuColors = new ContextMenuColors(Color.Companion.getWhite-0d7_KjU(), Color.Companion.getBlack-0d7_KjU(), Color.Companion.getBlack-0d7_KjU(), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.38f, 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.38f, 0f, 0f, 0f, 14, null), null);
    }

    public static final void ContextMenuColumn(ContextMenuColors arg28, Modifier arg29, Function3 arg30, Composer arg31, int arg32, int arg33) {
        Modifier v12_1;
        Companion v12;
        int v8;
        Modifier v7;
        int v5;
        ContextMenuColors v2;
        Function3 v3 = arg30;
        int v4 = arg32;
        int v0 = 0xE0896EF1;
        Composer v1 = arg31.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(ContextMenuColumn)N(colors,modifier,content)164@5827L21,154@5411L472:ContextMenuUi.kt#3xeu6s");
        if((v4 & 6) == 0) {
            v2 = arg28;
            v5 = v1.changed(v2) ? 4 : 2;
            v5 |= v4;
        }
        else {
            v2 = arg28;
            v5 = v4;
        }

        int v6 = arg33 & 2;
        if(v6 != 0) {
            v5 |= 0x30;
            goto label_33;
        }
        else if((v4 & 0x30) == 0) {
            v7 = arg29;
            v8 = v1.changed(v7) ? 0x20 : 16;
            v5 |= v8;
        }
        else {
        label_33:
            v7 = arg29;
        }

        if((v4 & 0x180) == 0) {
            v8 = v1.changedInstance(v3) ? 0x100 : 0x80;
            v5 |= v8;
        }

        boolean v8_1 = (v5 & 0x93) != 0x92 ? true : false;
        if(v1.shouldExecute(v8_1, v5 & 1)) {
            if(v6 != 0) {
                v12 = Modifier.Companion;
            }
            else {
                v12_1 = v7;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v5, -1, "androidx.compose.foundation.contextmenu.ContextMenuColumn (ContextMenuUi.kt:153)");
            }

            Modifier v0_1 = ScrollKt.verticalScroll$default(PaddingKt.padding-VpY3zN4$default(IntrinsicKt.width(BackgroundKt.background-bw27NRU$default(ShadowKt.shadow-s4CzXII$default(((Modifier)v12), ContextMenuSpec.INSTANCE.getMenuContainerElevation-D9Ej5fM(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ContextMenuSpec.INSTANCE.getCornerRadius-D9Ej5fM()), false, 0, 0, 28, null), v2.getBackgroundColor-0d7_KjU(), null, 2, null), IntrinsicSize.Max), 0f, ContextMenuSpec.INSTANCE.getVerticalPadding-D9Ej5fM(), 1, null), ScrollKt.rememberScrollState(0, v1, 0, 1), false, null, false, 14, null);
            v5 = v5 << 3 & 0x1C00;
            ComposerKt.sourceInformationMarkerStart(v1, 0x4FF7456F, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy v6_1 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), v1, 0);
            ComposerKt.sourceInformationMarkerStart(v1, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int v7_1 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v1, 0));
            CompositionLocalMap v8_2 = v1.getCurrentCompositionLocalMap();
            v0_1 = ComposedModifierKt.materializeModifier(v1, v0_1);
            Function0 v9 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v1, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(v1.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v1.startReusableNode();
            if(v1.getInserting()) {
                v1.createNode(v9);
            }
            else {
                v1.useNode();
            }

            Composer v9_1 = Updater.constructor-impl(v1);
            Updater.set-impl(v9_1, v6_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v9_1, v8_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v9_1, Integer.valueOf(v7_1), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v9_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v9_1, v0_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v1, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            v3.invoke(ColumnScopeInstance.INSTANCE, v1, Integer.valueOf(v5 >> 6 & 0x70 | 6));
            ComposerKt.sourceInformationMarkerEnd(v1);
            v1.endNode();
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_162;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
            v12_1 = v7;
        }

    label_162:
        ScopeUpdateScope v6_2 = v1.endRestartGroup();
        if(v6_2 != null) {
            v6_2.updateScope(new ContextMenuUiKt$$ExternalSyntheticLambda0(v2, v12, v3, v4, arg33));
        }
    }

    static final Unit ContextMenuColumn$lambda$0(ContextMenuColors arg6, Modifier arg7, Function3 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        ContextMenuUiKt.ContextMenuColumn(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    public static final void ContextMenuColumnBuilder(Modifier arg11, ContextMenuColors arg12, Function1 arg13, Composer arg14, int arg15, int arg16) {
        Modifier v1_1;
        ContextMenuColors v2_1;
        Companion v11;
        int v5;
        int v2;
        int v0 = 0xDAB72E6F;
        Composer v8 = arg14.startRestartGroup(v0);
        ComposerKt.sourceInformation(v8, "C(ContextMenuColumnBuilder)N(modifier,colors,contextMenuBuilderBlock)133@4864L357,133@4828L393:ContextMenuUi.kt#3xeu6s");
        int v1 = arg16 & 1;
        if(v1 != 0) {
            v2 = arg15 | 6;
        }
        else if((arg15 & 6) == 0) {
            v2 = v8.changed(arg11) ? 4 : 2;
            v2 |= arg15;
        }
        else {
            v2 = arg15;
        }

        int v3 = arg16 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
        }
        else if((arg15 & 0x30) == 0) {
            v5 = v8.changed(arg12) ? 0x20 : 16;
            v2 |= v5;
        }

        if((arg15 & 0x180) == 0) {
            v5 = v8.changedInstance(arg13) ? 0x100 : 0x80;
            v2 |= v5;
        }

        boolean v5_1 = (v2 & 0x93) != 0x92 ? true : false;
        if(v8.shouldExecute(v5_1, v2 & 1)) {
            if(v1 != 0) {
                v11 = Modifier.Companion;
            }

            Modifier v6 = ((Modifier)v11);
            if(v3 != 0) {
                arg12 = ContextMenuUiKt.DefaultContextMenuColors;
            }

            ContextMenuColors v5_2 = arg12;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.foundation.contextmenu.ContextMenuColumnBuilder (ContextMenuUi.kt:132)");
            }

            ContextMenuUiKt.ContextMenuColumn(v5_2, v6, ComposableLambdaKt.rememberComposableLambda(-250345048, true, new ContextMenuUiKt$$ExternalSyntheticLambda1(arg13, v5_2), v8, 54), v8, v2 >> 3 & 14 | 0x180 | v2 << 3 & 0x70, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v5_2;
            v1_1 = v6;
        }
        else {
            v8.skipToGroupEnd();
            v1_1 = arg11;
            v2_1 = arg12;
        }

        ScopeUpdateScope v11_1 = v8.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new ContextMenuUiKt$$ExternalSyntheticLambda2(v1_1, v2_1, arg13, arg15, arg16));
        }
    }

    static final Unit ContextMenuColumnBuilder$lambda$0(Function1 arg3, ContextMenuColors arg4, ColumnScope arg5, Composer arg6, int arg7) {
        ContextMenuScope v5_2;
        ComposerKt.sourceInformation(arg6, "C134@4886L211,*142@5190L15:ContextMenuUi.kt#3xeu6s");
        boolean v5 = (arg7 & 17) != 16 ? true : false;
        if(arg6.shouldExecute(v5, arg7 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-250345048, arg7, -1, "androidx.compose.foundation.contextmenu.ContextMenuColumnBuilder.<anonymous> (ContextMenuUi.kt:134)");
            }

            ComposerKt.sourceInformationMarkerStart(arg6, 0xFC38433B, "CC(remember):ContextMenuUi.kt#9igjgp");
            Object v5_1 = arg6.rememberedValue();
            if(v5_1 == Composer.Companion.getEmpty()) {
                v5_2 = new ContextMenuScope(ComposableSingletons$ContextMenuUiKt.INSTANCE.getLambda$-1571120048$foundation());
                arg6.updateRememberedValue(v5_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg6);
            v5_2.clear$foundation();
            arg3.invoke(v5_2);
            v5_2.Content$foundation(arg4, arg6, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_39;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_39:
        return Unit.INSTANCE;
    }

    static final Unit ContextMenuColumnBuilder$lambda$1(Modifier arg6, ContextMenuColors arg7, Function1 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        ContextMenuUiKt.ContextMenuColumnBuilder(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    public static final void ContextMenuItem(String arg25, boolean arg26, ContextMenuColors arg27, Modifier arg28, Function3 arg29, Function0 arg30, Composer arg31, int arg32, int arg33) {
        Function3 v5_1;
        Companion v4_3;
        Composer v20;
        ContextMenuUiKt$$ExternalSyntheticLambda4 v6_3;
        Companion v3_2;
        int v14;
        Function3 v13;
        int v7;
        Modifier v6;
        int v4;
        int v3;
        String v2;
        boolean v1 = arg26;
        Function0 v8 = arg30;
        int v9 = arg32;
        int v0 = -2001167027;
        Composer v10 = arg31.startRestartGroup(v0);
        ComposerKt.sourceInformation(v10, "C(ContextMenuItem)N(label,enabled,colors,modifier,leadingIcon,onClick)197@6989L237,192@6715L1694:ContextMenuUi.kt#3xeu6s");
        if((v9 & 6) == 0) {
            v2 = arg25;
            v3 = v10.changed(v2) ? 4 : 2;
            v3 |= v9;
        }
        else {
            v2 = arg25;
            v3 = v9;
        }

        int v5 = 0x20;
        if((v9 & 0x30) == 0) {
            v4 = v10.changed(v1) ? v5 : 16;
            v3 |= v4;
        }

        ContextMenuColors v12 = arg27;
        if((v9 & 0x180) == 0) {
            v4 = v10.changed(v12) ? 0x100 : 0x80;
            v3 |= v4;
        }

        v4 = arg33 & 8;
        if(v4 != 0) {
            v3 |= 0xC00;
            goto label_52;
        }
        else if((v9 & 0xC00) == 0) {
            v6 = arg28;
            v7 = v10.changed(v6) ? 0x800 : 0x400;
            v3 |= v7;
        }
        else {
        label_52:
            v6 = arg28;
        }

        v7 = arg33 & 16;
        if(v7 != 0) {
            v3 |= 0x6000;
            goto label_67;
        }
        else if((v9 & 0x6000) == 0) {
            v13 = arg29;
            v14 = v10.changedInstance(v13) ? 0x4000 : 0x2000;
            v3 |= v14;
        }
        else {
        label_67:
            v13 = arg29;
        }

        int v15 = 0x20000;
        if((0x30000 & v9) == 0) {
            v14 = v10.changedInstance(v8) ? v15 : 0x10000;
            v3 |= v14;
        }

        v14 = v3;
        int v16 = v4;
        boolean v3_1 = (74899 & v14) != 74898 ? true : false;
        if(v10.shouldExecute(v3_1, v14 & 1)) {
            if(v16 != 0) {
                v3_2 = Modifier.Companion;
            }
            else {
                Modifier v3_3 = v6;
            }

            Object v11 = null;
            if(v7 != 0) {
                v13 = ((Function3)v11);
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v14, -1, "androidx.compose.foundation.contextmenu.ContextMenuItem (ContextMenuUi.kt:191)");
            }

            Vertical v0_1 = ContextMenuSpec.INSTANCE.getLabelVerticalTextAlignment();
            HorizontalOrVertical v16_1 = Arrangement.INSTANCE.spacedBy-0680j_4(ContextMenuSpec.INSTANCE.getHorizontalPadding-D9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(v10, 0x3D06F81A, "CC(remember):ContextMenuUi.kt#9igjgp");
            v5 = (v14 & 0x70) == v5 ? 1 : 0;
            int v6_1 = (0x70000 & v14) == v15 ? 1 : 0;
            v5 |= v6_1;
            Object v6_2 = v10.rememberedValue();
            if(v5 != 0 || v6_2 == Composer.Companion.getEmpty()) {
                v6_3 = new ContextMenuUiKt$$ExternalSyntheticLambda4(v1, v8);
                v10.updateRememberedValue(v6_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v10);
            Vertical v15_1 = v0_1;
            Companion v0_2 = v3_2;
            Modifier v1_1 = PaddingKt.padding-VpY3zN4$default(SizeKt.sizeIn-qDBjuR0(SizeKt.fillMaxWidth$default(ClickableKt.clickable-oSLSa3U$default(((Modifier)v0_2), v1, v2, null, null, v6_3, 12, null), 0f, 1, v11), ContextMenuSpec.INSTANCE.getContainerWidthMin-D9Ej5fM(), ContextMenuSpec.INSTANCE.getListItemHeight-D9Ej5fM(), ContextMenuSpec.INSTANCE.getContainerWidthMax-D9Ej5fM(), ContextMenuSpec.INSTANCE.getListItemHeight-D9Ej5fM()), ContextMenuSpec.INSTANCE.getHorizontalPadding-D9Ej5fM(), 0f, 2, v11);
            ComposerKt.sourceInformationMarkerStart(v10, 0x3255A44B, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy v2_1 = RowKt.rowMeasurePolicy(v16_1, v15_1, v10, 54);
            v3 = 0xBAE1EBD9;
            String v4_1 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v10, v3, v4_1);
            v6_1 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v10, 0));
            CompositionLocalMap v7_1 = v10.getCurrentCompositionLocalMap();
            v1_1 = ComposedModifierKt.materializeModifier(v10, v1_1);
            Function0 v11_1 = ComposeUiNode.Companion.getConstructor();
            String v8_1 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v10, 0xDF082A64, v8_1);
            if(!(v10.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v10.startReusableNode();
            if(v10.getInserting()) {
                v10.createNode(v11_1);
            }
            else {
                v10.useNode();
            }

            Composer v11_2 = Updater.constructor-impl(v10);
            Updater.set-impl(v11_2, v2_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v11_2, v7_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v11_2, Integer.valueOf(v6_1), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v11_2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v11_2, v1_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v10, 0x56CCD6F5, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance v1_2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(v10, -1597950037, "C223@8104L299:ContextMenuUi.kt#3xeu6s");
            if(v13 == null) {
                v10.startReplaceGroup(0xA0C1432A);
            }
            else {
                v10.startReplaceGroup(0xA0C1432B);
                ComposerKt.sourceInformation(v10, "*212@7691L394");
                Modifier v2_2 = SizeKt.requiredSizeIn-qDBjuR0$default(Modifier.Companion, ContextMenuSpec.INSTANCE.getIconSize-D9Ej5fM(), 0f, ContextMenuSpec.INSTANCE.getIconSize-D9Ej5fM(), ContextMenuSpec.INSTANCE.getIconSize-D9Ej5fM(), 2, null);
                ComposerKt.sourceInformationMarkerStart(v10, 0x3E277F0A, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy v6_4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v10, v3, v4_1);
                v3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v10, 0));
                CompositionLocalMap v4_2 = v10.getCurrentCompositionLocalMap();
                v2_2 = ComposedModifierKt.materializeModifier(v10, v2_2);
                Function0 v7_2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v10, 0xDF082A64, v8_1);
                if(!(v10.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v10.startReusableNode();
                if(v10.getInserting()) {
                    v10.createNode(v7_2);
                }
                else {
                    v10.useNode();
                }

                Composer v7_3 = Updater.constructor-impl(v10);
                Updater.set-impl(v7_3, v6_4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v7_3, v4_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(v7_3, Integer.valueOf(v3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(v7_3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(v7_3, v2_2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v10, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(v10, 431264902, "C220@8006L65:ContextMenuUi.kt#3xeu6s");
                long v2_3 = arg26 ? v12.getIconColor-0d7_KjU() : v12.getDisabledIconColor-0d7_KjU();
                v13.invoke(Color.box-impl(v2_3), v10, Integer.valueOf(0));
                ComposerKt.sourceInformationMarkerEnd(v10);
                ComposerKt.sourceInformationMarkerEnd(v10);
                v10.endNode();
                ComposerKt.sourceInformationMarkerEnd(v10);
                ComposerKt.sourceInformationMarkerEnd(v10);
                ComposerKt.sourceInformationMarkerEnd(v10);
            }

            v10.endReplaceGroup();
            ContextMenuSpec v2_4 = ContextMenuSpec.INSTANCE;
            long v3_4 = arg26 ? v12.getTextColor-0d7_KjU() : v12.getDisabledTextColor-0d7_KjU();
            TextStyle v2_5 = v2_4.textStyle-8_81llA(v3_4);
            Modifier v11_3 = ((RowScope)v1_2).weight(Modifier.Companion, 1f, true);
            Function3 v1_3 = v13;
            v20 = v10;
            BasicTextKt.BasicText-RWo7tUw(arg25, v11_3, v2_5, null, 0, false, 1, 0, null, null, v20, v14 & 14 | 0x180000, 952);
            ComposerKt.sourceInformationMarkerEnd(v20);
            ComposerKt.sourceInformationMarkerEnd(v20);
            v20.endNode();
            ComposerKt.sourceInformationMarkerEnd(v20);
            ComposerKt.sourceInformationMarkerEnd(v20);
            ComposerKt.sourceInformationMarkerEnd(v20);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_3 = v0_2;
            v5_1 = v1_3;
        }
        else {
            v20 = v10;
            v20.skipToGroupEnd();
            Modifier v4_4 = v6;
            v5_1 = v13;
        }

        ScopeUpdateScope v10_1 = v20.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new ContextMenuUiKt$$ExternalSyntheticLambda5(arg25, arg26, arg27, ((Modifier)v4_3), v5_1, arg30, v9, arg33));
        }
    }

    private static final Unit ContextMenuItem$lambda$0$0(boolean arg0, Function0 arg1) {
        if(arg0) {
            arg1.invoke();
        }

        return Unit.INSTANCE;
    }

    static final Unit ContextMenuItem$lambda$2(String arg10, boolean arg11, ContextMenuColors arg12, Modifier arg13, Function3 arg14, Function0 arg15, int arg16, int arg17, Composer arg18, int arg19) {
        ContextMenuUiKt.ContextMenuItem(arg10, arg11, arg12, arg13, arg14, arg15, arg18, RecomposeScopeImplKt.updateChangedFlags(arg16 | 1), arg17);
        return Unit.INSTANCE;
    }

    public static final void ContextMenuPopup(PopupPositionProvider arg9, Function0 arg10, Modifier arg11, Function1 arg12, Composer arg13, int arg14, int arg15) {
        Modifier v12;
        Function1 v13_1;
        PopupPositionProvider v10;
        Function0 v2_2;
        Companion v11;
        int v2;
        int v1;
        int v13;
        int v0 = 307841774;
        Composer v6 = arg13.startRestartGroup(v0);
        ComposerKt.sourceInformation(v6, "C(ContextMenuPopup)N(popupPositionProvider,onDismiss,modifier,contextMenuBuilderBlock)104@4013L26,100@3863L242:ContextMenuUi.kt#3xeu6s");
        if((arg14 & 6) == 0) {
            v13 = v6.changed(arg9) ? 4 : 2;
            v13 |= arg14;
        }
        else {
            v13 = arg14;
        }

        if((arg14 & 0x30) == 0) {
            v1 = v6.changedInstance(arg10) ? 0x20 : 16;
            v13 |= v1;
        }

        v1 = arg15 & 4;
        if(v1 != 0) {
            v13 |= 0x180;
        }
        else if((arg14 & 0x180) == 0) {
            v2 = v6.changed(arg11) ? 0x100 : 0x80;
            v13 |= v2;
        }

        if((arg14 & 0xC00) == 0) {
            v2 = v6.changedInstance(arg12) ? 0x800 : 0x400;
            v13 |= v2;
        }

        boolean v2_1 = (v13 & 0x493) != 1170 ? true : false;
        if(v6.shouldExecute(v2_1, v13 & 1)) {
            if(v1 != 0) {
                v11 = Modifier.Companion;
            }

            Modifier v3 = ((Modifier)v11);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v13, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.kt:99)");
            }

            v2_2 = arg10;
            ContextMenuUiKt.ContextMenuPopup(arg9, v2_2, v3, ContextMenuUi_androidKt.computeContextMenuColors(v6, 0), arg12, v6, v13 & 0x3FE | v13 << 3 & 0xE000, 0);
            v10 = arg9;
            v13_1 = arg12;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v12 = v3;
        }
        else {
            v2_2 = arg10;
            v13_1 = arg12;
            v10 = arg9;
            v6.skipToGroupEnd();
            v12 = arg11;
        }

        ScopeUpdateScope v0_1 = v6.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new ContextMenuUiKt$$ExternalSyntheticLambda3(v10, v2_2, v12, v13_1, arg14, arg15));
        }
    }

    public static final void ContextMenuPopup(PopupPositionProvider arg14, Function0 arg15, Modifier arg16, ContextMenuColors arg17, Function1 arg18, Composer arg19, int arg20, int arg21) {
        Companion v3_1;
        Modifier v2_2;
        int v7;
        Modifier v3;
        int v2;
        int v1;
        ContextMenuColors v4 = arg17;
        Function1 v5 = arg18;
        int v6 = arg20;
        int v0 = -305401220;
        Composer v11 = arg19.startRestartGroup(v0);
        ComposerKt.sourceInformation(v11, "C(ContextMenuPopup)N(popupPositionProvider,onDismiss,modifier,colors,contextMenuBuilderBlock)122@4531L83,118@4380L234:ContextMenuUi.kt#3xeu6s");
        if((v6 & 6) == 0) {
            v1 = v11.changed(arg14) ? 4 : 2;
            v1 |= v6;
        }
        else {
            v1 = v6;
        }

        if((v6 & 0x30) == 0) {
            v2 = v11.changedInstance(arg15) ? 0x20 : 16;
            v1 |= v2;
        }

        v2 = arg21 & 4;
        if(v2 != 0) {
            v1 |= 0x180;
            goto label_40;
        }
        else if((v6 & 0x180) == 0) {
            v3 = arg16;
            v7 = v11.changed(v3) ? 0x100 : 0x80;
            v1 |= v7;
        }
        else {
        label_40:
            v3 = arg16;
        }

        if((v6 & 0xC00) == 0) {
            v7 = v11.changed(v4) ? 0x800 : 0x400;
            v1 |= v7;
        }

        if((v6 & 0x6000) == 0) {
            v7 = v11.changedInstance(v5) ? 0x4000 : 0x2000;
            v1 |= v7;
        }

        boolean v7_1 = (v1 & 9363) != 9362 ? true : false;
        if(v11.shouldExecute(v7_1, v1 & 1)) {
            if(v2 != 0) {
                Companion v2_1 = Modifier.Companion;
            }
            else {
                v2_2 = v3;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.kt:117)");
            }

            AndroidPopup_androidKt.Popup(arg14, arg15, ContextMenuUiKt.DefaultPopupProperties, ComposableLambdaKt.rememberComposableLambda(0xB438779E, true, new ContextMenuUiKt$$ExternalSyntheticLambda6(v2_2, v4, v5), v11, 54), v11, v1 & 14 | 0xD80 | v1 & 0x70, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = ((Companion)v2_2);
        }
        else {
            v11.skipToGroupEnd();
        }

        ScopeUpdateScope v8 = v11.endRestartGroup();
        if(v8 != null) {
            v8.updateScope(new ContextMenuUiKt$$ExternalSyntheticLambda7(arg14, arg15, ((Modifier)v3_1), v4, v5, v6, arg21));
        }
    }

    static final Unit ContextMenuPopup$lambda$0(PopupPositionProvider arg7, Function0 arg8, Modifier arg9, Function1 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        ContextMenuUiKt.ContextMenuPopup(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    static final Unit ContextMenuPopup$lambda$1(Modifier arg9, ContextMenuColors arg10, Function1 arg11, Composer arg12, int arg13) {
        ComposerKt.sourceInformation(arg12, "C123@4541L67:ContextMenuUi.kt#3xeu6s");
        boolean v0 = (arg13 & 3) != 2 ? true : false;
        if(arg12.shouldExecute(v0, arg13 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xB438779E, arg13, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup.<anonymous> (ContextMenuUi.kt:123)");
            }

            ContextMenuUiKt.ContextMenuColumnBuilder(arg9, arg10, arg11, arg12, 0, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_30;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg12.skipToGroupEnd();
        }

    label_30:
        return Unit.INSTANCE;
    }

    static final Unit ContextMenuPopup$lambda$2(PopupPositionProvider arg8, Function0 arg9, Modifier arg10, ContextMenuColors arg11, Function1 arg12, int arg13, int arg14, Composer arg15, int arg16) {
        ContextMenuUiKt.ContextMenuPopup(arg8, arg9, arg10, arg11, arg12, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    public static final ContextMenuColors getDefaultContextMenuColors() {
        return ContextMenuUiKt.DefaultContextMenuColors;
    }
}

