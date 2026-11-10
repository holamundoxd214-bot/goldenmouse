package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0006\u001A\u0083\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0013\u001A\u0004\u0018\u00010\u00142\u001C\u0010\u0015\u001A\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0004\b\u001A\u0010\u001B\u001A\u0082\u0001\u0010\u001C\u001A\u00020\u00012\u0011\u0010\u001D\u001A\r\u0012\u0004\u0012\u00020\u00010\u001E¢\u0006\u0002\b\u00182\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00010\u001E2\u0006\u0010\u0002\u001A\u00020\u00032\u0013\u0010 \u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001E¢\u0006\u0002\b\u00182\u0013\u0010!\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001E¢\u0006\u0002\b\u00182\u0006\u0010\"\u001A\u00020\u00062\u0006\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020&2\b\u0010\'\u001A\u0004\u0018\u00010(H\u0001¢\u0006\u0002\u0010)\u001A\u001D\u0010*\u001A\u00020\t2\u0006\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020,H\u0000¢\u0006\u0002\u0010.\"\u0016\u0010/\u001A\u00020\u0011X\u0080\u0004¢\u0006\n\n\u0002\u00102\u001A\u0004\b0\u00101\"\u0010\u00103\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00104\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0016\u00105\u001A\u00020\u0011X\u0080\u0004¢\u0006\n\n\u0002\u00102\u001A\u0004\b6\u00101\"\u0010\u00107\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00108\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u000E\u00109\u001A\u00020:X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010;\u001A\u00020:X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010<\u001A\u00020:X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010=\u001A\u00020:X\u0080T¢\u0006\u0002\n\u0000¨\u0006>²\u0006\n\u0010?\u001A\u00020:X\u008A\u0084\u0002²\u0006\n\u0010@\u001A\u00020:X\u008A\u0084\u0002"}, d2={"DropdownMenuContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "expandedState", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenuContent-Qj0Zi0g", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "DropdownMenuItemContent", "text", "Lkotlin/Function0;", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "calculateTransformOrigin", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "MenuVerticalMargin", "getMenuVerticalMargin", "()F", "F", "MenuListItemContainerHeight", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemDefaultMaxWidth", "ExpandedScaleTarget", "", "ClosedScaleTarget", "ExpandedAlphaTarget", "ClosedAlphaTarget", "material3", "scale", "alpha"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MenuKt {
    public static final float ClosedAlphaTarget = 0f;
    public static final float ClosedScaleTarget = 0.8f;
    private static final float DropdownMenuItemDefaultMaxWidth = 0f;
    private static final float DropdownMenuItemDefaultMinWidth = 0f;
    private static final float DropdownMenuItemHorizontalPadding = 0f;
    private static final float DropdownMenuVerticalPadding = 0f;
    public static final float ExpandedAlphaTarget = 1f;
    public static final float ExpandedScaleTarget = 1f;
    private static final float MenuListItemContainerHeight;
    private static final float MenuVerticalMargin;

    static {
        MenuKt.MenuVerticalMargin = Dp.constructor-impl(48f);
        MenuKt.MenuListItemContainerHeight = Dp.constructor-impl(48f);
        MenuKt.DropdownMenuItemHorizontalPadding = Dp.constructor-impl(12f);
        MenuKt.DropdownMenuVerticalPadding = Dp.constructor-impl(8f);
        MenuKt.DropdownMenuItemDefaultMinWidth = Dp.constructor-impl(112f);
        MenuKt.DropdownMenuItemDefaultMaxWidth = Dp.constructor-impl(280f);
    }

    public static final void DropdownMenuContent-Qj0Zi0g(Modifier arg28, MutableTransitionState arg29, MutableState arg30, ScrollState arg31, Shape arg32, long arg33, float arg35, float arg36, BorderStroke arg37, Function3 arg38, Composer arg39, int arg40) {
        MenuKt$$ExternalSyntheticLambda1 v2_6;
        Composer v19_1;
        Float v20;
        boolean v19;
        int v16;
        int v10;
        int v9;
        int v6_1;
        int v5;
        Modifier v1 = arg28;
        MutableTransitionState v4 = arg29;
        ScrollState v0 = arg31;
        Function3 v11 = arg38;
        int v12 = arg40;
        Composer v3 = arg39.startRestartGroup(0x329A8275);
        ComposerKt.sourceInformation(v3, "C(DropdownMenuContent)N(modifier,expandedState,transformOriginState,scrollState,shape,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,content)371@17333L47,373@17516L14,374@17594L14,376@17645L146,381@17829L146,385@18020L7,388@18095L587,405@18854L277,386@18032L1099:Menu.kt#uh7d8r");
        if((v12 & 6) == 0) {
            v5 = v3.changed(v1) ? 4 : 2;
            v5 |= v12;
        }
        else {
            v5 = v12;
        }

        if((v12 & 0x30) == 0) {
            boolean v6 = (v12 & 0x40) == 0 ? v3.changed(v4) : v3.changedInstance(v4);
            v6_1 = v6 ? 0x20 : 16;
            v5 |= v6_1;
        }

        if((v12 & 0x180) == 0) {
            v9 = v3.changed(arg30) ? 0x100 : 0x80;
            v5 |= v9;
        }

        if((v12 & 0xC00) == 0) {
            v9 = v3.changed(v0) ? 0x800 : 0x400;
            v5 |= v9;
        }

        if((v12 & 0x6000) == 0) {
            v10 = v3.changed(arg32) ? 0x4000 : 0x2000;
            v5 |= v10;
        }

        long v13 = arg33;
        if((0x30000 & v12) == 0) {
            v10 = v3.changed(v13) ? 0x20000 : 0x10000;
            v5 |= v10;
        }

        if((0x180000 & v12) == 0) {
            int v15 = v3.changed(arg35) ? 0x100000 : 0x80000;
            v5 |= v15;
        }

        int v21 = 0xC00000;
        if((v12 & v21) == 0) {
            v16 = v3.changed(arg36) ? 0x800000 : 0x400000;
            v5 |= v16;
        }

        BorderStroke v8 = arg37;
        if((v12 & 0x6000000) == 0) {
            v16 = v3.changed(v8) ? 0x4000000 : 0x2000000;
            v5 |= v16;
        }

        if((v12 & 0x30000000) == 0) {
            v16 = v3.changedInstance(v11) ? 0x20000000 : 0x10000000;
            v5 |= v16;
        }

        boolean v2 = (v5 & 306783379) != 306783378 ? true : false;
        if(v3.shouldExecute(v2, v5 & 1)) {
            int v7 = -1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x329A8275, v5, v7, "androidx.compose.material3.DropdownMenuContent (Menu.kt:369)");
            }

            Transition v2_1 = TransitionKt.updateTransition(v4, "DropDownMenu", v3, MutableTransitionState.$stable | 0x30 | v5 >> 3 & 14, 0);
            FiniteAnimationSpec v7_1 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, v3, 6);
            Transition v16_1 = v2_1;
            FiniteAnimationSpec v2_2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, v3, 6);
            MenuKt$DropdownMenuContent$scale$2 v8_1 = new MenuKt$DropdownMenuContent$scale$2(v7_1);
            String v6_2 = "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli";
            ComposerKt.sourceInformationMarkerStart(v3, 0xB03404EB, v6_2);
            TwoWayConverter v17 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            String v9_1 = "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli";
            ComposerKt.sourceInformationMarkerStart(v3, 0xF77F2E11, v9_1);
            boolean v18 = v16_1.getCurrentState().booleanValue();
            v3.startReplaceGroup(143964305);
            String v7_2 = "CN(expanded):Menu.kt#uh7d8r";
            ComposerKt.sourceInformation(v3, v7_2);
            String v10_1 = "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:377)";
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(143964305, 0, -1, v10_1);
            }

            float v27 = 1f;
            float v13_1 = v18 ? v27 : 0.8f;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3.endReplaceGroup();
            Float v14 = Float.valueOf(v13_1);
            boolean v13_2 = v16_1.getTargetState().booleanValue();
            v12 = 143964305;
            v3.startReplaceGroup(v12);
            ComposerKt.sourceInformation(v3, v7_2);
            if(ComposerKt.isTraceInProgress()) {
                v19 = v13_2;
                v20 = v14;
                ComposerKt.traceEventStart(v12, 0, -1, v10_1);
            }
            else {
                v19 = v13_2;
                v20 = v14;
            }

            float v12_1 = v19 ? v27 : 0.8f;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3.endReplaceGroup();
            v19_1 = v3;
            Transition v13_3 = v16_1;
            State v3_1 = TransitionKt.createTransitionAnimation(v13_3, v20, Float.valueOf(v12_1), ((Function3)v8_1).invoke(v16_1.getSegment(), v3, Integer.valueOf(0)), v17, "FloatAnimation", v19_1, 0);
            Composer v8_2 = v19_1;
            ComposerKt.sourceInformationMarkerEnd(v8_2);
            ComposerKt.sourceInformationMarkerEnd(v8_2);
            MenuKt$DropdownMenuContent$alpha$2 v10_2 = new MenuKt$DropdownMenuContent$alpha$2(v2_2);
            ComposerKt.sourceInformationMarkerStart(v8_2, 0xB03404EB, v6_2);
            v17 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(v8_2, 0xF77F2E11, v9_1);
            v2 = v13_3.getCurrentState().booleanValue();
            v6_1 = 892761509;
            v8_2.startReplaceGroup(v6_1);
            ComposerKt.sourceInformation(v8_2, v7_2);
            String v12_2 = "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:382)";
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v6_1, 0, -1, v12_2);
            }

            float v2_3 = v2 ? v27 : 0f;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8_2.endReplaceGroup();
            v14 = Float.valueOf(v2_3);
            v2 = v13_3.getTargetState().booleanValue();
            v8_2.startReplaceGroup(v6_1);
            ComposerKt.sourceInformation(v8_2, v7_2);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v6_1, 0, -1, v12_2);
            }

            if(v2) {
            }
            else {
                v27 = 0f;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8_2.endReplaceGroup();
            int v24 = 0;
            State v7_3 = TransitionKt.createTransitionAnimation(v13_3, v14, Float.valueOf(v27), ((Function3)v10_2).invoke(v13_3.getSegment(), v8_2, Integer.valueOf(0)), v17, "FloatAnimation", v8_2, 0);
            ComposerKt.sourceInformationMarkerEnd(v8_2);
            ComposerKt.sourceInformationMarkerEnd(v8_2);
            ProvidableCompositionLocal v2_4 = InspectionModeKt.getLocalInspectionMode();
            ComposerKt.sourceInformationMarkerStart(v8_2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v2_5 = v8_2.consume(((CompositionLocal)v2_4));
            ComposerKt.sourceInformationMarkerEnd(v8_2);
            v2 = ((Boolean)v2_5).booleanValue();
            Companion v9_2 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v8_2, 0xF60454A0, "CC(remember):Menu.kt#9igjgp");
            v6_1 = v8_2.changed(v2) | v8_2.changed(v3_1);
            if((v5 & 0x70) != 0x20) {
                if((v5 & 0x40) != 0 && (v8_2.changedInstance(v4))) {
                    goto label_299;
                }

                v10 = 0;
            }
            else {
            label_299:
                v10 = 1;
            }

            v6_1 = v6_1 | v10 | v8_2.changed(v7_3);
            if((v5 & 0x380) == 0x100) {
                v24 = 1;
            }

            Object v10_3 = v8_2.rememberedValue();
            if((v6_1 | v24) != 0 || v10_3 == Composer.Companion.getEmpty()) {
                v10 = v5;
                v2_6 = new MenuKt$$ExternalSyntheticLambda1(v2, v4, arg30, v3_1, v7_3);
                v8_2.updateRememberedValue(v2_6);
            }
            else {
                v2_5 = v10_3;
                v10 = v5;
            }

            ComposerKt.sourceInformationMarkerEnd(v8_2);
            Modifier v13_4 = GraphicsLayerModifierKt.graphicsLayer(((Modifier)v9_2), ((Function1)v2_6));
            int v2_7 = v10 >> 9;
            int v3_2 = v10 >> 6;
            SurfaceKt.Surface-T9BRK9s(v13_4, arg32, arg33, 0, arg35, arg36, arg37, ComposableLambdaKt.rememberComposableLambda(-1463404422, true, new MenuKt$DropdownMenuContent$2(v1, v0, v11), v8_2, 54), v8_2, v2_7 & 0x380 | (v2_7 & 0x70 | v21) | 0xE000 & v3_2 | 0x70000 & v3_2 | v3_2 & 0x380000, 8);
            v19_1 = v8_2;
            if(!ComposerKt.isTraceInProgress()) {
                goto label_364;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v19_1 = v3;
            v19_1.skipToGroupEnd();
        }

    label_364:
        ScopeUpdateScope v13_5 = v19_1.endRestartGroup();
        if(v13_5 != null) {
            v13_5.updateScope(new MenuKt$$ExternalSyntheticLambda2(v1, arg29, arg30, arg31, arg32, arg33, arg35, arg36, arg37, v11, arg40));
        }
    }

    private static final float DropdownMenuContent_Qj0Zi0g$lambda$1(State arg0) {
        return arg0.getValue().floatValue();
    }

    private static final float DropdownMenuContent_Qj0Zi0g$lambda$3(State arg0) {
        return arg0.getValue().floatValue();
    }

    static final Unit DropdownMenuContent_Qj0Zi0g$lambda$5$lambda$4(boolean arg3, MutableTransitionState arg4, MutableState arg5, State arg6, State arg7, GraphicsLayerScope arg8) {
        float v2;
        float v0 = 0.8f;
        float v1 = 1f;
        if(!arg3) {
            v2 = MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$1(arg6);
        }
        else if(arg4.getTargetState().booleanValue()) {
            v2 = v1;
        }
        else {
            v2 = v0;
        }

        arg8.setScaleX(v2);
        if(!arg3) {
            v0 = MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$1(arg6);
        }
        else if(arg4.getTargetState().booleanValue()) {
            v0 = v1;
        }

        arg8.setScaleY(v0);
        if(!arg3) {
            v1 = MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$3(arg7);
        }
        else if(arg4.getTargetState().booleanValue()) {
        }
        else {
            v1 = 0f;
        }

        arg8.setAlpha(v1);
        arg8.setTransformOrigin-__ExYCQ(arg5.getValue().unbox-impl());
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenuContent_Qj0Zi0g$lambda$6(Modifier arg14, MutableTransitionState arg15, MutableState arg16, ScrollState arg17, Shape arg18, long arg19, float arg21, float arg22, BorderStroke arg23, Function3 arg24, int arg25, Composer arg26, int arg27) {
        MenuKt.DropdownMenuContent-Qj0Zi0g(arg14, arg15, arg16, arg17, arg18, arg19, arg21, arg22, arg23, arg24, arg26, RecomposeScopeImplKt.updateChangedFlags(arg25 | 1));
        return Unit.INSTANCE;
    }

    public static final void DropdownMenuItemContent(Function2 arg22, Function0 arg23, Modifier arg24, Function2 arg25, Function2 arg26, boolean arg27, MenuItemColors arg28, PaddingValues arg29, MutableInteractionSource arg30, Composer arg31, int arg32) {
        int v12;
        MutableInteractionSource v9_1;
        int v9;
        MenuItemColors v7_1;
        int v7;
        Function2 v6_1;
        Function2 v5_1;
        int v5;
        Function0 v4;
        int v3;
        Function2 v2;
        PaddingValues v8 = arg29;
        int v10 = arg32;
        int v0 = 0xB1032924;
        Composer v1 = arg31.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(DropdownMenuItemContent)N(text,onClick,modifier,leadingIcon,trailingIcon,enabled,colors,contentPadding,interactionSource)429@19500L2499:Menu.kt#uh7d8r");
        if((v10 & 6) == 0) {
            v2 = arg22;
            v3 = v1.changedInstance(v2) ? 4 : 2;
            v3 |= v10;
        }
        else {
            v2 = arg22;
            v3 = v10;
        }

        if((v10 & 0x30) == 0) {
            v4 = arg23;
            v5 = v1.changedInstance(v4) ? 0x20 : 16;
            v3 |= v5;
        }
        else {
            v4 = arg23;
        }

        Modifier v11 = arg24;
        if((v10 & 0x180) == 0) {
            v5 = v1.changed(v11) ? 0x100 : 0x80;
            v3 |= v5;
        }

        if((v10 & 0xC00) == 0) {
            v5_1 = arg25;
            int v6 = v1.changedInstance(v5_1) ? 0x800 : 0x400;
            v3 |= v6;
        }
        else {
            v5_1 = arg25;
        }

        if((v10 & 0x6000) == 0) {
            v6_1 = arg26;
            v7 = v1.changedInstance(v6_1) ? 0x4000 : 0x2000;
            v3 |= v7;
        }
        else {
            v6_1 = arg26;
        }

        boolean v14 = arg27;
        if((0x30000 & v10) == 0) {
            v7 = v1.changed(v14) ? 0x20000 : 0x10000;
            v3 |= v7;
        }

        if((0x180000 & v10) == 0) {
            v7_1 = arg28;
            v9 = v1.changed(v7_1) ? 0x100000 : 0x80000;
            v3 |= v9;
        }
        else {
            v7_1 = arg28;
        }

        if((0xC00000 & v10) == 0) {
            v9 = v1.changed(v8) ? 0x800000 : 0x400000;
            v3 |= v9;
        }

        if((0x6000000 & v10) == 0) {
            v9_1 = arg30;
            v12 = v1.changed(v9_1) ? 0x4000000 : 0x2000000;
            v3 |= v12;
        }
        else {
            v9_1 = arg30;
        }

        boolean v12_1 = (0x2492493 & v3) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v12_1, v3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.DropdownMenuItemContent (Menu.kt:428)");
            }

            Modifier v4_1 = PaddingKt.padding(SizeKt.sizeIn-qDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.clickable-O2vRcR0$default(v11, v9_1, RippleKt.ripple-H2RKhps$default(true, 0f, 0, 6, null), v14, null, null, v4, 24, null), 0f, 1, null), MenuKt.DropdownMenuItemDefaultMinWidth, MenuKt.MenuListItemContainerHeight, MenuKt.DropdownMenuItemDefaultMaxWidth, 0f, 8, null), v8);
            Vertical v9_2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(v1, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            v12 = 0x30;
            MeasurePolicy v9_3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), v9_2, v1, v12);
            ComposerKt.sourceInformationMarkerStart(v1, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v0 = ComposablesKt.getCurrentCompositeKeyHash(v1, 0);
            CompositionLocalMap v11_1 = v1.getCurrentCompositionLocalMap();
            v4_1 = ComposedModifierKt.materializeModifier(v1, v4_1);
            Function0 v13 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v1, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v1.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v1.startReusableNode();
            if(v1.getInserting()) {
                v1.createNode(v13);
            }
            else {
                v1.useNode();
            }

            Composer v13_1 = Updater.constructor-impl(v1);
            Updater.set-impl(v13_1, v9_3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v13_1, v11_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v9_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v13_1.getInserting()) || !Intrinsics.areEqual(v13_1.rememberedValue(), Integer.valueOf(v0))) {
                v13_1.updateRememberedValue(Integer.valueOf(v0));
                v13_1.apply(Integer.valueOf(v0), v9_4);
            }

            Updater.set-impl(v13_1, v4_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v1, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance v16 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(v1, 0x21B8338, "C449@20357L10,449@20380L1613,449@20326L1667:Menu.kt#uh7d8r");
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(v1, 6).getLabelLarge(), ComposableLambdaKt.rememberComposableLambda(0x339E1C39, true, new MenuKt$DropdownMenuItemContent$1$1(v5_1, v7_1, arg27, v6_1, ((RowScope)v16), v2), v1, 54), v1, v12);
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            v1.endNode();
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_235;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
        }

    label_235:
        ScopeUpdateScope v11_2 = v1.endRestartGroup();
        if(v11_2 != null) {
            v11_2.updateScope(new MenuKt$$ExternalSyntheticLambda0(arg22, arg23, arg24, arg25, arg26, arg27, arg28, v8, arg30, v10));
        }
    }

    static final Unit DropdownMenuItemContent$lambda$8(Function2 arg12, Function0 arg13, Modifier arg14, Function2 arg15, Function2 arg16, boolean arg17, MenuItemColors arg18, PaddingValues arg19, MutableInteractionSource arg20, int arg21, Composer arg22, int arg23) {
        MenuKt.DropdownMenuItemContent(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg22, RecomposeScopeImplKt.updateChangedFlags(arg21 | 1));
        return Unit.INSTANCE;
    }

    public static final float access$getDropdownMenuItemHorizontalPadding$p() {
        return MenuKt.DropdownMenuItemHorizontalPadding;
    }

    public static final long calculateTransformOrigin(IntRect arg5, IntRect arg6) {
        float v0;
        float v2 = 1f;
        if(arg6.getLeft() >= arg5.getRight() || arg6.getWidth() == 0) {
            v0 = 0f;
            goto label_29;
        label_15:
            v0 = (((float)((Math.max(arg5.getLeft(), arg6.getLeft()) + Math.min(arg5.getRight(), arg6.getRight())) / 2 - arg6.getLeft()))) / (((float)arg6.getWidth()));
        }
        else if(arg6.getRight() <= arg5.getLeft()) {
            v0 = v2;
        }
        else {
            goto label_15;
        }

    label_29:
        if(arg6.getTop() >= arg5.getBottom() || arg6.getHeight() == 0) {
            v2 = 0f;
            goto label_55;
        label_41:
            v2 = (((float)((Math.max(arg5.getTop(), arg6.getTop()) + Math.min(arg5.getBottom(), arg6.getBottom())) / 2 - arg6.getTop()))) / (((float)arg6.getHeight()));
        }
        else if(arg6.getBottom() <= arg5.getTop()) {
        }
        else {
            goto label_41;
        }

    label_55:
        return TransformOriginKt.TransformOrigin(v0, v2);
    }

    public static final float getDropdownMenuVerticalPadding() {
        return MenuKt.DropdownMenuVerticalPadding;
    }

    public static final float getMenuVerticalMargin() {
        return MenuKt.MenuVerticalMargin;
    }
}

