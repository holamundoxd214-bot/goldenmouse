package androidx.compose.material3;

import android.view.KeyEvent;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material3.internal.BackHandler_androidKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000\u008A\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001AQ\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u001C\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000BH\u0007¢\u0006\u0002\u0010\f\u001A\u001B\u0010\r\u001A\u00020\u0003*\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001Aa\u0010\u001B\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u001C2\u0006\u0010\u001D\u001A\u00020\u000E2\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00030\u001F2\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020!2\u0006\u0010#\u001A\u00020!2\b\u0010$\u001A\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b&\u0010\'\u001A\"\u0010.\u001A\u00020/2\u0006\u00100\u001A\u0002012\b\u00102\u001A\u0004\u0018\u0001032\u0006\u00104\u001A\u00020/H\u0002\u001A\u000E\u00105\u001A\u000203*\u0004\u0018\u000106H\u0002\"\u0018\u0010(\u001A\u00020\u0003*\u00020)8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b*\u0010+\"\u0018\u0010,\u001A\u00020\u0003*\u00020)8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b-\u0010+\"\u0010\u00107\u001A\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109*8\b\u0007\u0010\u0012\"\u00020\u000E2\u00020\u000EB*\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u001C\b\u0016\u0012\u0018\b\u000BB\u0014\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0006\b\u001A\u0012\u0002\b\f¨\u0006:²\u0006\f\u0010;\u001A\u0004\u0018\u000106X\u008A\u008E\u0002²\u0006\n\u0010<\u001A\u00020/X\u008A\u008E\u0002²\u0006\n\u0010=\u001A\u00020/X\u008A\u008E\u0002"}, d2={"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "hasGreaterOrEqualPriorityThan", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "that", "hasGreaterOrEqualPriorityThan-vVDBVkM", "(Ljava/lang/String;Ljava/lang/String;)Z", "MenuAnchorType", "Lkotlin/Deprecated;", "message", "Renamed to ExposedDropdownMenuAnchorType", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "ExposedDropdownMenuAnchorType", "imports", "expandable", "Lkotlin/Function0;", "anchorType", "alwaysFocusable", "Landroidx/compose/runtime/MutableState;", "expandedDescription", "", "collapsedDescription", "toggleDescription", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "expandable-3-2CpT8", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/MutableState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Landroidx/compose/ui/Modifier;", "isClick", "Landroidx/compose/ui/input/key/KeyEvent;", "isClick-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isEnterMinusSpacebar", "isEnterMinusSpacebar-ZmokQxo", "calculateMaxHeight", "", "windowBounds", "Landroidx/compose/ui/unit/IntRect;", "anchorBounds", "Landroidx/compose/ui/geometry/Rect;", "verticalMargin", "getAnchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "material3", "anchorCoordinates", "anchorWidth", "menuMaxHeight"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ExposedDropdownMenuKt {
    private static final float ExposedDropdownMenuItemHorizontalPadding;

    static {
        ExposedDropdownMenuKt.ExposedDropdownMenuItemHorizontalPadding = Dp.constructor-impl(16f);
    }

    public static final void ExposedDropdownMenuBox(boolean arg27, Function1 arg28, Modifier arg29, Function3 arg30, Composer arg31, int arg32, int arg33) {
        ExposedDropdownMenuKt$$ExternalSyntheticLambda4 v2_2;
        ExposedDropdownMenuKt$$ExternalSyntheticLambda2 v5_4;
        Function3 v4_5;
        Modifier v3_5;
        Object v0_3;
        WindowBoundsCalculator v15_2;
        int v25;
        int v23_1;
        Object v2_1;
        int v29_1;
        String v12_1;
        Companion v31;
        String v29;
        int v17;
        MutableState v8_2;
        MutableState v1_2;
        int v18;
        MutableIntState v11_2;
        Companion v4_1;
        int v7;
        Modifier v6;
        int v4;
        int v2;
        boolean v1 = arg27;
        Function1 v9 = arg28;
        Function3 v12 = arg30;
        int v13 = arg32;
        int v0 = 0x5F3457E4;
        Composer v14 = arg31.startRestartGroup(v0);
        ComposerKt.sourceInformation(v14, "C(ExposedDropdownMenuBox)N(expanded,onExpandedChange,modifier,content)142@6635L32,143@6699L7,147@6812L53,148@6889L33,149@6948L33,151@7008L29,152@7099L7,153@7137L31,154@7200L32,155@7261L37,156@7325L89,159@7441L34,162@7501L2786,217@10336L377,216@10293L458,242@11135L47,242@11124L58,246@11347L27,246@11315L59:ExposedDropdownMenu.kt#uh7d8r");
        int v3 = 2;
        if((arg33 & 1) != 0) {
            v2 = v13 | 6;
        }
        else if((v13 & 6) == 0) {
            v2 = v14.changed(v1) ? 4 : v3;
            v2 |= v13;
        }
        else {
            v2 = v13;
        }

        if((arg33 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v13 & 0x30) == 0) {
            v4 = v14.changedInstance(v9) ? 0x20 : 16;
            v2 |= v4;
        }

        v4 = arg33 & 4;
        if(v4 != 0) {
            v2 |= 0x180;
            goto label_50;
        }
        else if((v13 & 0x180) == 0) {
            v6 = arg29;
            v7 = v14.changed(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_50:
            v6 = arg29;
        }

        if((arg33 & 8) != 0) {
            v2 |= 0xC00;
        }
        else if((v13 & 0xC00) == 0) {
            v7 = v14.changedInstance(v12) ? 0x800 : 0x400;
            v2 |= v7;
        }

        boolean v7_1 = (v2 & 0x493) != 1170 ? true : false;
        if(v14.shouldExecute(v7_1, v2 & 1)) {
            if(v4 != 0) {
                v4_1 = Modifier.Companion;
            }
            else {
                Modifier v4_2 = v6;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:141)");
            }

            WindowBoundsCalculator v0_1 = ExposedDropdownMenu_androidKt.platformWindowBoundsCalculator(v14, 0);
            ProvidableCompositionLocal v6_1 = CompositionLocalsKt.getLocalDensity();
            v7 = 0x789C5F52;
            String v8 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v14, v7, v8);
            Object v6_2 = v14.consume(((CompositionLocal)v6_1));
            ComposerKt.sourceInformationMarkerEnd(v14);
            int v19 = ((Density)v6_2).roundToPx-0680j_4(MenuKt.getMenuVerticalMargin());
            String v5 = "CC(remember):ExposedDropdownMenu.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v14, 1669211801, v5);
            Object v11 = v14.rememberedValue();
            Object v10 = null;
            if(v11 == Composer.Companion.getEmpty()) {
                MutableState v11_1 = SnapshotStateKt.mutableStateOf$default(v10, ((SnapshotMutationPolicy)v10), v3, v10);
                v14.updateRememberedValue(v11_1);
            }

            Object v20 = v11;
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerStart(v14, 0x637E3025, v5);
            v11 = v14.rememberedValue();
            if(v11 == Composer.Companion.getEmpty()) {
                v11_2 = SnapshotIntStateKt.mutableIntStateOf(0);
                v14.updateRememberedValue(v11_2);
            }

            Object v21 = v11;
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerStart(v14, 0x637E3785, v5);
            v11 = v14.rememberedValue();
            if(v11 == Composer.Companion.getEmpty()) {
                v11_2 = SnapshotIntStateKt.mutableIntStateOf(0);
                v14.updateRememberedValue(v11_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerStart(v14, 0x637E3F01, v5);
            Object v15 = v14.rememberedValue();
            if(v15 == Composer.Companion.getEmpty()) {
                FocusRequester v15_1 = new FocusRequester();
                v14.updateRememberedValue(v15_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            ProvidableCompositionLocal v3_1 = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart(v14, v7, v8);
            Object v3_2 = v14.consume(((CompositionLocal)v3_1));
            ComposerKt.sourceInformationMarkerEnd(v14);
            Object v7_2 = v3_2;
            String v3_3 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_dropdown_menu_expanded), v14, 0);
            String v10_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_dropdown_menu_collapsed), v14, 0);
            String v1_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_dropdown_menu_toggle), v14, 0);
            ComposerKt.sourceInformationMarkerStart(v14, 0x637E66DD, v5);
            Object v8_1 = v14.rememberedValue();
            String v23 = v1_1;
            if(v8_1 == Composer.Companion.getEmpty()) {
                v18 = v2;
                v1_2 = SnapshotStateKt.mutableStateOf$default(ExposedDropdownMenuAnchorType.box-impl(ExposedDropdownMenuAnchorType.Companion.getPrimaryNotEditable-oYjWRB4()), null, 2, null);
                v14.updateRememberedValue(v1_2);
                v8_2 = v1_2;
            }
            else {
                v18 = v2;
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerStart(v14, 1669231910, v5);
            Object v1_3 = v14.rememberedValue();
            if(v1_3 == Composer.Companion.getEmpty()) {
                v17 = 0;
                v29 = v3_3;
                v1_2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
                v14.updateRememberedValue(v1_2);
            }
            else {
                v29 = v3_3;
                v17 = 0;
            }

            v3_2 = v1_2;
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerStart(v14, 0x637E8766, v5);
            int v1_4 = v18 & 14;
            v2 = v1_4 == 4 ? 1 : v17;
            v13 = v18 & 0x70;
            int v22 = v1_4;
            int v24 = v13 == 0x20 ? 1 : v17;
            v2 = v2 | v24 | v14.changed(v0_1) | v14.changed(v6_2);
            v6_2 = v14.rememberedValue();
            if(v2 != 0 || v6_2 == Composer.Companion.getEmpty()) {
                v31 = v4_1;
                v12_1 = v5;
                v5 = v10_1;
                v1_3 = v15;
                v10 = v21;
                v25 = v22;
                String v6_3 = v23;
                String v4_3 = v29;
                v15_2 = v0_1;
                v29_1 = v13;
                v23_1 = v18;
                v13 = v19;
                ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 v0_2 = new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(((FocusRequester)v1_3), arg27, ((MutableState)v3_2), v4_3, v5, v6_3, ((SoftwareKeyboardController)v7_2), v8_2, v9, ((MutableIntState)v10), ((MutableIntState)v11));
                v2_1 = v1_3;
                v1 = arg27;
                v14.updateRememberedValue(v0_2);
                ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 v6_4 = v0_2;
            }
            else {
                v1 = arg27;
                v31 = v4_1;
                v12_1 = v5;
                v29_1 = v13;
                v2_1 = v15;
                v23_1 = v18;
                v13 = v19;
                v10 = v21;
                v25 = v22;
                v15_2 = v0_1;
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerStart(v14, 0x637FE05D, v12_1);
            v0 = v14.changedInstance(v15_2) | v14.changed(v13);
            v3_2 = v14.rememberedValue();
            if(v0 != 0 || v3_2 == Composer.Companion.getEmpty()) {
                Object v22_1 = v11;
                ExposedDropdownMenuKt$$ExternalSyntheticLambda1 v3_4 = new ExposedDropdownMenuKt$$ExternalSyntheticLambda1(v15_2, v13, ((MutableState)v20), v10, ((MutableIntState)v22_1));
                v11 = v20;
                v0_3 = v22_1;
                v14.updateRememberedValue(v3_4);
            }
            else {
                v0_3 = v11;
                v11 = v20;
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            v3_5 = OnGloballyPositionedModifierKt.onGloballyPositioned(v31, ((Function1)v3_2));
            ComposerKt.sourceInformationMarkerStart(v14, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v5_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v14, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v7 = ComposablesKt.getCurrentCompositeKeyHash(v14, 0);
            CompositionLocalMap v8_3 = v14.getCurrentCompositionLocalMap();
            v3_5 = ComposedModifierKt.materializeModifier(v14, v3_5);
            Function0 v10_2 = ComposeUiNode.Companion.getConstructor();
            v17 = v7;
            ComposerKt.sourceInformationMarkerStart(v14, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v14.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v14.startReusableNode();
            if(v14.getInserting()) {
                v14.createNode(v10_2);
            }
            else {
                v14.useNode();
            }

            Composer v4_4 = Updater.constructor-impl(v14);
            Updater.set-impl(v4_4, v5_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v4_4, v8_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v5_2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v4_4.getInserting()) || !Intrinsics.areEqual(v4_4.rememberedValue(), Integer.valueOf(v17))) {
                v4_4.updateRememberedValue(Integer.valueOf(v17));
                v4_4.apply(Integer.valueOf(v17), v5_2);
            }

            Updater.set-impl(v4_4, v3_5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v14, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v14, 0x7F96176A, "C228@10736L9:ExposedDropdownMenu.kt#uh7d8r");
            v4_5 = arg30;
            v4_5.invoke(v6_2, v14, Integer.valueOf(v23_1 >> 6 & 0x70));
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            v14.endNode();
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            if(v1) {
                v14.startReplaceGroup(209894723);
                ComposerKt.sourceInformation(v14, "232@10810L302,232@10781L331");
                ComposerKt.sourceInformationMarkerStart(v14, 0x63801B52, v12_1);
                v3 = v14.changedInstance(v15_2) | v14.changed(v13);
                Object v5_3 = v14.rememberedValue();
                if(v3 != 0 || v5_3 == Composer.Companion.getEmpty()) {
                    v5_4 = new ExposedDropdownMenuKt$$ExternalSyntheticLambda2(v15_2, v13, ((MutableState)v11), ((MutableIntState)v0_3));
                    v14.updateRememberedValue(v5_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v14);
                ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange(((Function0)v5_4), v14, 0);
                v14.endReplaceGroup();
            }
            else {
                v14.startReplaceGroup(210228190);
                v14.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerStart(v14, 0x638042F3, v12_1);
            v0 = v25;
            int v10_3 = v0 == 4 ? 1 : 0;
            v3_2 = v14.rememberedValue();
            if(v10_3 != 0 || v3_2 == Composer.Companion.getEmpty()) {
                ExposedDropdownMenuKt$$ExternalSyntheticLambda3 v3_6 = new ExposedDropdownMenuKt$$ExternalSyntheticLambda3(v1, ((FocusRequester)v2_1));
                v14.updateRememberedValue(v3_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            EffectsKt.SideEffect(((Function0)v3_2), v14, 0);
            ComposerKt.sourceInformationMarkerStart(v14, 0x63805D5F, v12_1);
            v10_3 = v29_1 == 0x20 ? 1 : 0;
            v2_1 = v14.rememberedValue();
            if(v10_3 != 0 || v2_1 == Composer.Companion.getEmpty()) {
                v2_2 = new ExposedDropdownMenuKt$$ExternalSyntheticLambda4(v9);
                v14.updateRememberedValue(v2_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            BackHandler_androidKt.BackHandler(v1, ((Function0)v2_2), v14, v0, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Companion v3_7 = v31;
        }
        else {
            v4_5 = v12;
            v14.skipToGroupEnd();
            v3_5 = v6;
        }

        ScopeUpdateScope v7_3 = v14.endRestartGroup();
        if(v7_3 != null) {
            v7_3.updateScope(new ExposedDropdownMenuKt$$ExternalSyntheticLambda5(v1, v9, v3_5, v4_5, arg32, arg33));
        }
    }

    static final Unit ExposedDropdownMenuBox$lambda$15$lambda$14(WindowBoundsCalculator arg2, int arg3, MutableState arg4, MutableIntState arg5, MutableIntState arg6, LayoutCoordinates arg7) {
        ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$3(arg4, arg7);
        ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$6(arg5, ((int)(arg7.getSize-YbymL2g() >> 0x20)));
        ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$9(arg6, ExposedDropdownMenuKt.calculateMaxHeight(arg2.getVisibleWindowBounds(), ExposedDropdownMenuKt.getAnchorBounds(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$2(arg4)), arg3));
        return Unit.INSTANCE;
    }

    static final Unit ExposedDropdownMenuBox$lambda$18$lambda$17(WindowBoundsCalculator arg0, int arg1, MutableState arg2, MutableIntState arg3) {
        ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$9(arg3, ExposedDropdownMenuKt.calculateMaxHeight(arg0.getVisibleWindowBounds(), ExposedDropdownMenuKt.getAnchorBounds(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$2(arg2)), arg1));
        return Unit.INSTANCE;
    }

    private static final LayoutCoordinates ExposedDropdownMenuBox$lambda$2(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    static final Unit ExposedDropdownMenuBox$lambda$20$lambda$19(boolean arg2, FocusRequester arg3) {
        if(arg2) {
            FocusRequester.requestFocus-3ESFkO8$default(arg3, 0, 1, null);
        }

        return Unit.INSTANCE;
    }

    static final Unit ExposedDropdownMenuBox$lambda$22$lambda$21(Function1 arg1) {
        arg1.invoke(Boolean.valueOf(false));
        return Unit.INSTANCE;
    }

    static final Unit ExposedDropdownMenuBox$lambda$23(boolean arg7, Function1 arg8, Modifier arg9, Function3 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        ExposedDropdownMenuKt.ExposedDropdownMenuBox(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    private static final void ExposedDropdownMenuBox$lambda$3(MutableState arg0, LayoutCoordinates arg1) {
        arg0.setValue(arg1);
    }

    private static final int ExposedDropdownMenuBox$lambda$5(MutableIntState arg0) {
        return ((IntState)arg0).getIntValue();
    }

    private static final void ExposedDropdownMenuBox$lambda$6(MutableIntState arg0, int arg1) {
        arg0.setIntValue(arg1);
    }

    private static final int ExposedDropdownMenuBox$lambda$8(MutableIntState arg0) {
        return ((IntState)arg0).getIntValue();
    }

    private static final void ExposedDropdownMenuBox$lambda$9(MutableIntState arg0, int arg1) {
        arg0.setIntValue(arg1);
    }

    @Deprecated(message="Renamed to ExposedDropdownMenuAnchorType", replaceWith="<_subannotation>") public static void MenuAnchorType$annotations() {
    }

    public static final int access$ExposedDropdownMenuBox$lambda$5(MutableIntState arg0) {
        return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$5(arg0);
    }

    public static final int access$ExposedDropdownMenuBox$lambda$8(MutableIntState arg0) {
        return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$8(arg0);
    }

    public static final Modifier access$expandable-3-2CpT8(Modifier arg0, boolean arg1, Function0 arg2, String arg3, MutableState arg4, String arg5, String arg6, String arg7, SoftwareKeyboardController arg8) {
        return ExposedDropdownMenuKt.expandable-3-2CpT8(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static final float access$getExposedDropdownMenuItemHorizontalPadding$p() {
        return ExposedDropdownMenuKt.ExposedDropdownMenuItemHorizontalPadding;
    }

    public static final boolean access$hasGreaterOrEqualPriorityThan-vVDBVkM(String arg0, String arg1) {
        return ExposedDropdownMenuKt.hasGreaterOrEqualPriorityThan-vVDBVkM(arg0, arg1);
    }

    public static final boolean access$isClick-ZmokQxo(KeyEvent arg0) {
        return ExposedDropdownMenuKt.isClick-ZmokQxo(arg0);
    }

    public static final boolean access$isEnterMinusSpacebar-ZmokQxo(KeyEvent arg0) {
        return ExposedDropdownMenuKt.isEnterMinusSpacebar-ZmokQxo(arg0);
    }

    private static final int calculateMaxHeight(IntRect arg4, Rect arg5, int arg6) {
        if(arg5 == null) {
            return 0;
        }

        int v1 = arg4.getTop() + arg6;
        int v2 = arg4.getBottom() - arg6;
        int v4 = arg5.getTop() > (((float)arg4.getBottom())) || arg5.getBottom() < (((float)arg4.getTop())) ? v2 - v1 : MathKt.roundToInt(Math.max(arg5.getTop() - (((float)v1)), (((float)v2)) - arg5.getBottom()));
        return Math.max(v4, 0);
    }

    private static final Modifier expandable-3-2CpT8(Modifier arg1, boolean arg2, Function0 arg3, String arg4, MutableState arg5, String arg6, String arg7, String arg8, SoftwareKeyboardController arg9) {
        return SemanticsModifierKt.semantics$default(KeyInputModifierKt.onPreviewKeyEvent(SuspendingPointerInputFilterKt.pointerInput(arg1, arg3, new ExposedDropdownMenuKt$expandable$1(arg4, arg3)), new ExposedDropdownMenuKt$expandable$2(arg4, arg3, arg2, arg5)), false, new ExposedDropdownMenuKt$$ExternalSyntheticLambda6(arg4, arg2, arg6, arg7, arg8, arg3, arg9), 1, null);
    }

    static final Unit expandable_3_2CpT8$lambda$25(String arg1, boolean arg2, String arg3, String arg4, String arg5, Function0 arg6, SoftwareKeyboardController arg7, SemanticsPropertyReceiver arg8) {
        if(ExposedDropdownMenuAnchorType.equals-impl0(arg1, ExposedDropdownMenuAnchorType.Companion.getSecondaryEditable-oYjWRB4())) {
            SemanticsPropertiesKt.setRole-kuIjeqM(arg8, Role.Companion.getButton-o7Vup1c());
            if(arg2) {
            }
            else {
                arg3 = arg4;
            }

            SemanticsPropertiesKt.setStateDescription(arg8, arg3);
            SemanticsPropertiesKt.setContentDescription(arg8, arg5);
        }
        else {
            SemanticsPropertiesKt.setRole-kuIjeqM(arg8, Role.Companion.getDropdownList-o7Vup1c());
        }

        SemanticsPropertiesKt.onClick$default(arg8, null, new ExposedDropdownMenuKt$$ExternalSyntheticLambda0(arg6, arg1, arg7), 1, null);
        return Unit.INSTANCE;
    }

    static final boolean expandable_3_2CpT8$lambda$25$lambda$24(Function0 arg0, String arg1, SoftwareKeyboardController arg2) {
        arg0.invoke();
        if((ExposedDropdownMenuAnchorType.equals-impl0(arg1, ExposedDropdownMenuAnchorType.Companion.getPrimaryEditable-oYjWRB4())) && arg2 != null) {
            arg2.show();
        }

        return 1;
    }

    private static final Rect getAnchorBounds(LayoutCoordinates arg4) {
        if(arg4 != null) {
            if(!arg4.isAttached()) {
            }
            else {
                return RectKt.Rect-tz77jQw(LayoutCoordinatesKt.positionInWindow(arg4), IntSizeKt.toSize-ozmzZPI(arg4.getSize-YbymL2g()));
            }
        }

        return Rect.Companion.getZero();
    }

    private static final boolean hasGreaterOrEqualPriorityThan-vVDBVkM(String arg1, String arg2) {
        if(!ExposedDropdownMenuAnchorType.equals-impl0(arg1, ExposedDropdownMenuAnchorType.Companion.getPrimaryNotEditable-oYjWRB4())) {
            if(ExposedDropdownMenuAnchorType.equals-impl0(arg1, ExposedDropdownMenuAnchorType.Companion.getPrimaryEditable-oYjWRB4())) {
            }
            else if(ExposedDropdownMenuAnchorType.equals-impl0(arg1, ExposedDropdownMenuAnchorType.Companion.getSecondaryEditable-oYjWRB4())) {
                return ExposedDropdownMenuAnchorType.equals-impl0(arg2, ExposedDropdownMenuAnchorType.Companion.getSecondaryEditable-oYjWRB4());
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final boolean isClick-ZmokQxo(KeyEvent arg4) {
        if((KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(arg4), KeyEventType.Companion.getKeyUp-CS__XNY())) && ((ExposedDropdownMenuKt.isEnterMinusSpacebar-ZmokQxo(arg4)) || (Key.equals-impl0(KeyEvent_androidKt.getKey-ZmokQxo(arg4), Key.Companion.getSpacebar-EK5gGoQ())))) {
            return 1;
        }

        return 0;
    }

    private static final boolean isEnterMinusSpacebar-ZmokQxo(KeyEvent arg4) {
        long v0 = KeyEvent_androidKt.getKey-ZmokQxo(arg4);
        if(!Key.equals-impl0(v0, Key.Companion.getDirectionCenter-EK5gGoQ()) && !Key.equals-impl0(v0, Key.Companion.getEnter-EK5gGoQ())) {
            if(Key.equals-impl0(v0, Key.Companion.getNumPadEnter-EK5gGoQ())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

