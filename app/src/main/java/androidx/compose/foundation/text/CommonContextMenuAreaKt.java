package androidx.compose.foundation.text;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.contextmenu.ContextMenuAreaKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState$Status;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuStateKt;
import androidx.compose.foundation.text.contextmenu.internal.PlatformDefaultTextContextMenuProviders_androidKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGesturesModifierKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A(\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001A0\u0010\u0000\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\f\u001A(\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\r2\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u000E\u001A5\u0010\u000F\u001A\u00020\u0001*\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\n\u001A\u00020\u000B2\u000E\b\u0004\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\b\u001A\u0012\u0010\u0016\u001A\u00020\u0017*\u00020\tH\u0080@¢\u0006\u0002\u0010\u0018\u001A\u0012\u0010\u0016\u001A\u00020\u0017*\u00020\u0003H\u0080@¢\u0006\u0002\u0010\u0019¨\u0006\u001A"}, d2={"CommonContextMenuArea", "", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "enabled", "", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/text/selection/SelectionManager;", "(Landroidx/compose/foundation/text/selection/SelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TextItem", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "label", "Landroidx/compose/foundation/text/TextContextMenuItems;", "operation", "getContextMenuItemsAvailability", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CommonContextMenuAreaKt {
    public static Unit $r8$lambda$7Kd9DUsLd96HwVVeZYX0xWg2slQ(ContextMenuState arg0) {
        return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$9$0(arg0);
    }

    public static Unit $r8$lambda$ElF7O5cTiMNV7hTo7TfB0LLoDNU(ContextMenuState arg0) {
        return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$2$0(arg0);
    }

    public static Unit $r8$lambda$P4pMq0yx5ahjjAZym6rAu2XsSRQ(CoroutineScope arg0, MutableState arg1, TextFieldSelectionManager arg2) {
        return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$3$0(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$mn7ROyjdcDwO0opv5GCQ0gtJzy0(CoroutineScope arg0, TextFieldSelectionState arg1, TextContextMenuItems arg2) {
        return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$8$0(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$ubWdRTKdTcMfY-AfVqRtnnuwCaE(ContextMenuState arg0) {
        return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$13$0(arg0);
    }

    public static Unit $r8$lambda$ukLoWPPxr-eWUUM4LXPi_ROpxcQ(CoroutineScope arg0, MutableState arg1, TextFieldSelectionState arg2) {
        return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$10$0(arg0, arg1, arg2);
    }

    public static final void CommonContextMenuArea(TextFieldSelectionState arg11, boolean arg12, Function2 arg13, Composer arg14, int arg15) {
        CommonContextMenuAreaKt$$ExternalSyntheticLambda7 v6_2;
        CommonContextMenuAreaKt$$ExternalSyntheticLambda6 v2_4;
        CommonContextMenuAreaKt$$ExternalSyntheticLambda5 v6_1;
        Function2 v7;
        boolean v5;
        Modifier v0_2;
        Companion v0_1;
        int v2;
        int v14;
        int v0 = 0xAA01585A;
        Composer v8 = arg14.startRestartGroup(v0);
        ComposerKt.sourceInformation(v8, "C(CommonContextMenuArea)N(selectionState,enabled,content):CommonContextMenuArea.kt#423gt5");
        int v1 = 2;
        if((arg15 & 6) == 0) {
            v14 = v8.changedInstance(arg11) ? 4 : v1;
            v14 |= arg15;
        }
        else {
            v14 = arg15;
        }

        if((arg15 & 0x30) == 0) {
            v2 = v8.changed(arg12) ? 0x20 : 16;
            v14 |= v2;
        }

        if((arg15 & 0x180) == 0) {
            v2 = v8.changedInstance(arg13) ? 0x100 : 0x80;
            v14 |= v2;
        }

        boolean v2_1 = (v14 & 0x93) != 0x92 ? true : false;
        if(v8.shouldExecute(v2_1, v14 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v14, -1, "androidx.compose.foundation.text.CommonContextMenuArea (CommonContextMenuArea.kt:75)");
            }

            Continuation v2_2 = null;
            String v3 = "CC(remember):CommonContextMenuArea.kt#9igjgp";
            if(ComposeFoundationFlags.isNewContextMenuEnabled) {
                v8.startReplaceGroup(0xB28BD2E5);
                ComposerKt.sourceInformation(v8, "92@4044L65");
                if(arg12) {
                    v8.startReplaceGroup(0xB28C7F55);
                    ComposerKt.sourceInformation(v8, "80@3501L456");
                    v0_1 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(v8, 0x2F0CD722, v3);
                    boolean v1_1 = v8.changedInstance(arg11);
                    Object v3_1 = v8.rememberedValue();
                    if((v1_1) || v3_1 == Composer.Companion.getEmpty()) {
                        CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1 v3_2 = new CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1(arg11, v2_2);
                        v8.updateRememberedValue(v3_2);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v8);
                    v0_2 = TextContextMenuGesturesModifierKt.showTextContextMenuOnSecondaryClick(((Modifier)v0_1), ((Function2)v3_1));
                    v8.endReplaceGroup();
                }
                else {
                    v8.startReplaceGroup(0xB2955500);
                    v8.endReplaceGroup();
                    v0_1 = Modifier.Companion;
                }

                PlatformDefaultTextContextMenuProviders_androidKt.ProvideDefaultPlatformTextContextMenuProviders(v0_2, arg13, v8, v14 >> 3 & 0x70, 0);
                v8.endReplaceGroup();
                v5 = arg12;
                v7 = arg13;
            }
            else {
                v8.startReplaceGroup(0xB297E899);
                ComposerKt.sourceInformation(v8, "94@4143L31,95@4204L24,96@4265L55,101@4520L537,116@5190L17,119@5319L209,114@5122L448");
                ComposerKt.sourceInformationMarkerStart(v8, 0x2F0D25B9, v3);
                Object v0_3 = v8.rememberedValue();
                if(v0_3 == Composer.Companion.getEmpty()) {
                    ContextMenuState v0_4 = new ContextMenuState(((Status)v2_2), 1, ((DefaultConstructorMarker)v2_2));
                    v8.updateRememberedValue(v0_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                ComposerKt.sourceInformationMarkerStart(v8, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(v8, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
                Object v4 = v8.rememberedValue();
                if(v4 == Composer.Companion.getEmpty()) {
                    CoroutineScope v4_1 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v8);
                    v8.updateRememberedValue(v4_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                ComposerKt.sourceInformationMarkerEnd(v8);
                ComposerKt.sourceInformationMarkerStart(v8, 0x2F0D3511, v3);
                Object v5_1 = v8.rememberedValue();
                if(v5_1 == Composer.Companion.getEmpty()) {
                    MutableState v5_2 = SnapshotStateKt.mutableStateOf$default(MenuItemsAvailability.box-impl(MenuItemsAvailability.Companion.getNone-JKCFgKw()), ((SnapshotMutationPolicy)v2_2), v1, v2_2);
                    v8.updateRememberedValue(v5_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                Object v1_2 = v5_1;
                ComposerKt.sourceInformationMarkerStart(v8, 0x2F0D56D3, v3);
                v2_1 = v8.changedInstance(v4);
                Object v6 = v8.rememberedValue();
                if((v2_1) || v6 == Composer.Companion.getEmpty()) {
                    v6_1 = new CommonContextMenuAreaKt$$ExternalSyntheticLambda5(((CoroutineScope)v4));
                    v8.updateRememberedValue(v6_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                Function1 v1_3 = TextFieldSelectionStateKt.contextMenuBuilder(arg11, ((ContextMenuState)v0_3), ((State)v1_2), ((Function2)v6_1));
                ComposerKt.sourceInformationMarkerStart(v8, 0x2F0DA88B, v3);
                Object v2_3 = v8.rememberedValue();
                if(v2_3 == Composer.Companion.getEmpty()) {
                    v2_4 = new CommonContextMenuAreaKt$$ExternalSyntheticLambda6(((ContextMenuState)v0_3));
                    v8.updateRememberedValue(v2_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                ComposerKt.sourceInformationMarkerStart(v8, 0x2F0DB96B, v3);
                int v3_3 = v8.changedInstance(v4) | v8.changedInstance(arg11);
                v6 = v8.rememberedValue();
                if(v3_3 != 0 || v6 == Composer.Companion.getEmpty()) {
                    v6_2 = new CommonContextMenuAreaKt$$ExternalSyntheticLambda7(((CoroutineScope)v4), ((MutableState)v5_1), arg11);
                    v8.updateRememberedValue(v6_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                v5 = arg12;
                v7 = arg13;
                ContextMenuAreaKt.ContextMenuArea(v0_3, ((Function0)v2_4), v1_3, null, v5, ((Function0)v6_2), v7, v8, v14 << 9 & 0xE000 | 54 | v14 << 12 & 0x380000, 8);
                v8.endReplaceGroup();
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_190;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v5 = arg12;
            v7 = arg13;
            v8.skipToGroupEnd();
        }

    label_190:
        ScopeUpdateScope v12 = v8.endRestartGroup();
        if(v12 != null) {
            v12.updateScope(new CommonContextMenuAreaKt$$ExternalSyntheticLambda8(arg11, v5, v7, arg15));
        }
    }

    public static final void CommonContextMenuArea(SelectionManager arg11, Function2 arg12, Composer arg13, int arg14) {
        ContextMenuState v0_2;
        Function2 v7;
        int v13;
        int v0 = -614342087;
        Composer v8 = arg13.startRestartGroup(v0);
        ComposerKt.sourceInformation(v8, "C(CommonContextMenuArea)N(manager,content):CommonContextMenuArea.kt#423gt5");
        if((arg14 & 6) == 0) {
            v13 = v8.changedInstance(arg11) ? 4 : 2;
            v13 |= arg14;
        }
        else {
            v13 = arg14;
        }

        if((arg14 & 0x30) == 0) {
            int v1 = v8.changedInstance(arg12) ? 0x20 : 16;
            v13 |= v1;
        }

        boolean v1_1 = (v13 & 19) != 18 ? true : false;
        if(v8.shouldExecute(v1_1, v13 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v13, -1, "androidx.compose.foundation.text.CommonContextMenuArea (CommonContextMenuArea.kt:131)");
            }

            if(ComposeFoundationFlags.isNewContextMenuEnabled) {
                v8.startReplaceGroup(0xC3D701C1);
                ComposerKt.sourceInformation(v8, "133@5796L88");
                PlatformDefaultTextContextMenuProviders_androidKt.ProvideDefaultPlatformTextContextMenuProviders(arg11.getContextMenuAreaModifier(), arg12, v8, v13 & 0x70, 0);
                v8.endReplaceGroup();
                v7 = arg12;
            }
            else {
                v8.startReplaceGroup(-1009204043);
                ComposerKt.sourceInformation(v8, "135@5918L31,138@6066L17,136@5998L200");
                String v1_2 = "CC(remember):CommonContextMenuArea.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(v8, 0x8A725A98, v1_2);
                Object v0_1 = v8.rememberedValue();
                if(v0_1 == Composer.Companion.getEmpty()) {
                    v0_2 = new ContextMenuState(null, 1, null);
                    v8.updateRememberedValue(v0_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                ComposerKt.sourceInformationMarkerStart(v8, 0x8A726D0A, v1_2);
                Object v1_3 = v8.rememberedValue();
                if(v1_3 == Composer.Companion.getEmpty()) {
                    CommonContextMenuAreaKt$$ExternalSyntheticLambda3 v1_4 = new CommonContextMenuAreaKt$$ExternalSyntheticLambda3(v0_2);
                    v8.updateRememberedValue(v1_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                v7 = arg12;
                ContextMenuAreaKt.ContextMenuArea(v0_2, v1_3, SelectionManagerKt.contextMenuBuilder(arg11, v0_2), null, false, null, v7, v8, v13 << 15 & 0x380000 | 54, 56);
                v8.endReplaceGroup();
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_96;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v7 = arg12;
            v8.skipToGroupEnd();
        }

    label_96:
        ScopeUpdateScope v12 = v8.endRestartGroup();
        if(v12 != null) {
            v12.updateScope(new CommonContextMenuAreaKt$$ExternalSyntheticLambda4(arg11, v7, arg14));
        }
    }

    public static final void CommonContextMenuArea(TextFieldSelectionManager arg11, Function2 arg12, Composer arg13, int arg14) {
        CommonContextMenuAreaKt$$ExternalSyntheticLambda0 v1_2;
        CoroutineScope v3_1;
        ContextMenuState v0_2;
        Function2 v7;
        int v2;
        int v13;
        int v0 = 1533506138;
        Composer v8 = arg13.startRestartGroup(v0);
        ComposerKt.sourceInformation(v8, "C(CommonContextMenuArea)N(manager,content):CommonContextMenuArea.kt#423gt5");
        int v1 = 2;
        if((arg14 & 6) == 0) {
            v13 = v8.changedInstance(arg11) ? 4 : v1;
            v13 |= arg14;
        }
        else {
            v13 = arg14;
        }

        if((arg14 & 0x30) == 0) {
            v2 = v8.changedInstance(arg12) ? 0x20 : 16;
            v13 |= v2;
        }

        boolean v2_1 = (v13 & 19) != 18 ? true : false;
        if(v8.shouldExecute(v2_1, v13 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v13, -1, "androidx.compose.foundation.text.CommonContextMenuArea (CommonContextMenuArea.kt:46)");
            }

            if(ComposeFoundationFlags.isNewContextMenuEnabled) {
                v8.startReplaceGroup(0xCB36BF80);
                ComposerKt.sourceInformation(v8, "48@2238L88");
                PlatformDefaultTextContextMenuProviders_androidKt.ProvideDefaultPlatformTextContextMenuProviders(arg11.getContextMenuAreaModifier(), arg12, v8, v13 & 0x70, 0);
                v8.endReplaceGroup();
                v7 = arg12;
            }
            else {
                v8.startReplaceGroup(0xCB38B7DB);
                ComposerKt.sourceInformation(v8, "50@2360L31,51@2421L24,52@2482L55,56@2655L17,59@2837L202,54@2587L494");
                String v2_2 = "CC(remember):CommonContextMenuArea.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(v8, 0x1F5468F9, v2_2);
                Object v0_1 = v8.rememberedValue();
                Status v4 = null;
                if(v0_1 == Composer.Companion.getEmpty()) {
                    v0_2 = new ContextMenuState(v4, 1, ((DefaultConstructorMarker)v4));
                    v8.updateRememberedValue(v0_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                ComposerKt.sourceInformationMarkerStart(v8, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(v8, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
                Object v3 = v8.rememberedValue();
                if(v3 == Composer.Companion.getEmpty()) {
                    v3_1 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v8);
                    v8.updateRememberedValue(v3_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                ComposerKt.sourceInformationMarkerEnd(v8);
                ComposerKt.sourceInformationMarkerStart(v8, 0x1F547851, v2_2);
                Object v5 = v8.rememberedValue();
                if(v5 == Composer.Companion.getEmpty()) {
                    MutableState v5_1 = SnapshotStateKt.mutableStateOf$default(MenuItemsAvailability.box-impl(MenuItemsAvailability.Companion.getNone-JKCFgKw()), ((SnapshotMutationPolicy)v4), v1, v4);
                    v8.updateRememberedValue(v5_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                ComposerKt.sourceInformationMarkerStart(v8, 0x1F548DCB, v2_2);
                Object v1_1 = v8.rememberedValue();
                if(v1_1 == Composer.Companion.getEmpty()) {
                    v1_2 = new CommonContextMenuAreaKt$$ExternalSyntheticLambda0(v0_2);
                    v8.updateRememberedValue(v1_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                Function1 v4_1 = TextFieldSelectionManagerKt.contextMenuBuilder(arg11, v0_2, v5);
                Object v6 = v5;
                boolean v5_2 = arg11.getEnabled();
                ComposerKt.sourceInformationMarkerStart(v8, 0x1F54A544, v2_2);
                v2 = v8.changedInstance(v3_1) | v8.changedInstance(arg11);
                Object v7_1 = v8.rememberedValue();
                if(v2 != 0 || v7_1 == Composer.Companion.getEmpty()) {
                    CommonContextMenuAreaKt$$ExternalSyntheticLambda1 v7_2 = new CommonContextMenuAreaKt$$ExternalSyntheticLambda1(v3_1, ((MutableState)v6), arg11);
                    v8.updateRememberedValue(v7_2);
                }

                v6 = v7_1;
                ComposerKt.sourceInformationMarkerEnd(v8);
                v7 = arg12;
                ContextMenuAreaKt.ContextMenuArea(v0_2, v1_2, v4_1, null, v5_2, ((Function0)v6), v7, v8, v13 << 15 & 0x380000 | 54, 8);
                v8.endReplaceGroup();
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_141;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v7 = arg12;
            v8.skipToGroupEnd();
        }

    label_141:
        ScopeUpdateScope v12 = v8.endRestartGroup();
        if(v12 != null) {
            v12.updateScope(new CommonContextMenuAreaKt$$ExternalSyntheticLambda2(arg11, v7, arg14));
        }
    }

    private static final Unit CommonContextMenuArea$lambda$10$0(CoroutineScope arg6, MutableState arg7, TextFieldSelectionState arg8) {
        BuildersKt.launch$default(arg6, null, CoroutineStart.UNDISPATCHED, new CommonContextMenuAreaKt$CommonContextMenuArea$5$1$1(arg7, arg8, null), 1, null);
        return Unit.INSTANCE;
    }

    static final Unit CommonContextMenuArea$lambda$11(TextFieldSelectionState arg0, boolean arg1, Function2 arg2, int arg3, Composer arg4, int arg5) {
        CommonContextMenuAreaKt.CommonContextMenuArea(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit CommonContextMenuArea$lambda$13$0(ContextMenuState arg0) {
        ContextMenuStateKt.close(arg0);
        return Unit.INSTANCE;
    }

    static final Unit CommonContextMenuArea$lambda$14(SelectionManager arg0, Function2 arg1, int arg2, Composer arg3, int arg4) {
        CommonContextMenuAreaKt.CommonContextMenuArea(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit CommonContextMenuArea$lambda$2$0(ContextMenuState arg0) {
        ContextMenuStateKt.close(arg0);
        return Unit.INSTANCE;
    }

    private static final Unit CommonContextMenuArea$lambda$3$0(CoroutineScope arg6, MutableState arg7, TextFieldSelectionManager arg8) {
        BuildersKt.launch$default(arg6, null, CoroutineStart.UNDISPATCHED, new CommonContextMenuAreaKt$CommonContextMenuArea$2$1$1(arg7, arg8, null), 1, null);
        return Unit.INSTANCE;
    }

    static final Unit CommonContextMenuArea$lambda$4(TextFieldSelectionManager arg0, Function2 arg1, int arg2, Composer arg3, int arg4) {
        CommonContextMenuAreaKt.CommonContextMenuArea(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit CommonContextMenuArea$lambda$8$0(CoroutineScope arg6, TextFieldSelectionState arg7, TextContextMenuItems arg8) {
        BuildersKt.launch$default(arg6, null, CoroutineStart.UNDISPATCHED, new CommonContextMenuAreaKt$CommonContextMenuArea$menuBuilder$1$1$1(arg8, arg7, null), 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit CommonContextMenuArea$lambda$9$0(ContextMenuState arg0) {
        ContextMenuStateKt.close(arg0);
        return Unit.INSTANCE;
    }

    public static final void TextItem(ContextMenuScope arg8, ContextMenuState arg9, TextContextMenuItems arg10, boolean arg11, Function0 arg12) {
        if(arg11) {
            ContextMenuScope.item$default(arg8, new CommonContextMenuAreaKt$TextItem$1(arg10), null, false, null, new CommonContextMenuAreaKt$TextItem$2(arg12, arg9), 14, null);
        }
    }

    public static final Object getContextMenuItemsAvailability(TextFieldSelectionState arg4, Continuation arg5) {
        Object v4;
        CommonContextMenuAreaKt$getContextMenuItemsAvailability$1 v0_1;
        int v2;
        if((arg5 instanceof CommonContextMenuAreaKt$getContextMenuItemsAvailability$1)) {
            Continuation v0 = arg5;
            v2 = 0x80000000;
            if((((CommonContextMenuAreaKt$getContextMenuItemsAvailability$1)v0).label & v2) != 0) {
                ((CommonContextMenuAreaKt$getContextMenuItemsAvailability$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new CommonContextMenuAreaKt$getContextMenuItemsAvailability$1(arg5);
        }

        Object v5 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            v0_1.L$0 = arg4;
            v0_1.label = 1;
            if(arg4.updateClipboardEntry(((Continuation)v0_1)) == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            v4 = v0_1.L$0;
            ResultKt.throwOnFailure(v5);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return MenuItemsAvailability.box-impl(MenuItemsAvailability.constructor-impl(((TextFieldSelectionState)v4).canShowCopyMenuItem(), ((TextFieldSelectionState)v4).canShowPasteMenuItem(), ((TextFieldSelectionState)v4).canShowCutMenuItem(), ((TextFieldSelectionState)v4).canShowSelectAllMenuItem(), ((TextFieldSelectionState)v4).canShowAutofillMenuItem()));
    }

    public static final Object getContextMenuItemsAvailability(TextFieldSelectionManager arg4, Continuation arg5) {
        Object v4;
        int v2;
        Continuation v0;
        if((arg5 instanceof CommonContextMenuAreaKt$getContextMenuItemsAvailability$2)) {
            v0 = arg5;
            v2 = 0x80000000;
            if((((CommonContextMenuAreaKt$getContextMenuItemsAvailability$2)v0).label & v2) != 0) {
                ((CommonContextMenuAreaKt$getContextMenuItemsAvailability$2)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            CommonContextMenuAreaKt$getContextMenuItemsAvailability$2 v0_1 = new CommonContextMenuAreaKt$getContextMenuItemsAvailability$2(arg5);
        }

        Object v5 = ((CommonContextMenuAreaKt$getContextMenuItemsAvailability$2)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((CommonContextMenuAreaKt$getContextMenuItemsAvailability$2)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            ((CommonContextMenuAreaKt$getContextMenuItemsAvailability$2)v0).L$0 = arg4;
            ((CommonContextMenuAreaKt$getContextMenuItemsAvailability$2)v0).label = 1;
            if(arg4.updateClipboardEntry$foundation(v0) == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            v4 = ((CommonContextMenuAreaKt$getContextMenuItemsAvailability$2)v0).L$0;
            ResultKt.throwOnFailure(v5);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return MenuItemsAvailability.box-impl(MenuItemsAvailability.constructor-impl(((TextFieldSelectionManager)v4).canShowCopyMenuItem$foundation(), ((TextFieldSelectionManager)v4).canShowPasteMenuItem$foundation(), ((TextFieldSelectionManager)v4).canShowCutMenuItem$foundation(), ((TextFieldSelectionManager)v4).canShowSelectAllMenuItem$foundation(), ((TextFieldSelectionManager)v4).canShowAutofillMenuItem$foundation()));
    }
}

