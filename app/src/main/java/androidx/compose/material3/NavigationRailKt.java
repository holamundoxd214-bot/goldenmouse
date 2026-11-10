package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationRailBaselineItemTokens;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.material3.tokens.NavigationRailVerticalItemTokens;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u008A\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001Aw\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052 \b\u0002\u0010\u0007\u001A\u001A\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\u001C\u0010\u000E\u001A\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000BH\u0007¢\u0006\u0004\b\u000F\u0010\u0010\u001A\u0081\u0001\u0010\u0011\u001A\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u00132\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00010\u00152\u0011\u0010\u0016\u001A\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0017\u001A\u00020\u00132\u0015\b\u0002\u0010\u0018\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0019\u001A\u00020\u00132\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0007¢\u0006\u0002\u0010\u001E\u001A\u007F\u0010\u001F\u001A\u00020\u00012\u0011\u0010 \u001A\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\u0011\u0010!\u001A\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\u0011\u0010\u0016\u001A\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\u0013\u0010\u0018\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\n2\u0006\u0010\u0019\u001A\u00020\u00132\f\u0010\"\u001A\b\u0012\u0004\u0012\u00020#0\u00152\f\u0010$\u001A\b\u0012\u0004\u0012\u00020#0\u0015H\u0003¢\u0006\u0002\u0010%\u001A5\u0010&\u001A\u00020\'*\u00020(2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\b\u0010,\u001A\u0004\u0018\u00010*2\u0006\u0010-\u001A\u00020.H\u0002¢\u0006\u0004\b/\u00100\u001AM\u00101\u001A\u00020\'*\u00020(2\u0006\u00102\u001A\u00020*2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\b\u0010,\u001A\u0004\u0018\u00010*2\u0006\u0010-\u001A\u00020.2\u0006\u0010\u0019\u001A\u00020\u00132\u0006\u00103\u001A\u00020#H\u0002¢\u0006\u0004\b4\u00105\"\u000E\u00106\u001A\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u00108\u001A\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u00109\u001A\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010:\u001A\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010;\u001A\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001A\u0004\b=\u0010>\"\u0010\u0010@\u001A\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0016\u0010A\u001A\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001A\u0004\bB\u0010>\"\u0016\u0010C\u001A\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001A\u0004\bD\u0010>\"\u0016\u0010E\u001A\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001A\u0004\bF\u0010>\"\u0010\u0010G\u001A\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010H\u001A\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010I\u001A\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u001A\u0010J\u001A\b\u0012\u0004\u0012\u00020L0KX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bM\u0010N¨\u0006O²\u0006\n\u0010P\u001A\u00020\u0005X\u008A\u0084\u0002²\u0006\n\u0010Q\u001A\u00020\u0005X\u008A\u0084\u0002"}, d2={"NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "NavigationRail-qi6gXK8", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationRailItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItemLayout", "indicatorRipple", "indicator", "alphaAnimationProgress", "", "sizeAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "animationProgress", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "IndicatorRippleLayoutIdTag", "", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "NavigationRailVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getNavigationRailVerticalPadding", "()F", "F", "NavigationRailHeaderPadding", "NavigationRailItemWidth", "getNavigationRailItemWidth", "NavigationRailItemHeight", "getNavigationRailItemHeight", "NavigationRailItemVerticalPadding", "getNavigationRailItemVerticalPadding", "IndicatorHorizontalPadding", "IndicatorVerticalPaddingWithLabel", "IndicatorVerticalPaddingNoLabel", "LocalNavigationRailOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/NavigationRailOverride;", "getLocalNavigationRailOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3", "iconColor", "textColor"}, k=2, mv={2, 0, 0}, xi=0x30) public final class NavigationRailKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding = 0f;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalPaddingNoLabel = 0f;
    private static final float IndicatorVerticalPaddingWithLabel = 0f;
    private static final String LabelLayoutIdTag = "label";
    private static final ProvidableCompositionLocal LocalNavigationRailOverride;
    private static final float NavigationRailHeaderPadding;
    private static final float NavigationRailItemHeight;
    private static final float NavigationRailItemVerticalPadding;
    private static final float NavigationRailItemWidth;
    private static final float NavigationRailVerticalPadding;

    static {
        NavigationRailKt.NavigationRailVerticalPadding = Dp.constructor-impl(4f);
        NavigationRailKt.NavigationRailHeaderPadding = Dp.constructor-impl(8f);
        NavigationRailKt.NavigationRailItemWidth = NavigationRailCollapsedTokens.INSTANCE.getNarrowContainerWidth-D9Ej5fM();
        NavigationRailKt.NavigationRailItemHeight = NavigationRailVerticalItemTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM();
        NavigationRailKt.NavigationRailItemVerticalPadding = Dp.constructor-impl(4f);
        NavigationRailKt.IndicatorHorizontalPadding = Dp.constructor-impl(Dp.constructor-impl(NavigationRailVerticalItemTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.getIconSize-D9Ej5fM()) / 2f);
        NavigationRailKt.IndicatorVerticalPaddingWithLabel = Dp.constructor-impl(Dp.constructor-impl(NavigationRailVerticalItemTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.getIconSize-D9Ej5fM()) / 2f);
        NavigationRailKt.IndicatorVerticalPaddingNoLabel = Dp.constructor-impl(Dp.constructor-impl(NavigationRailVerticalItemTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.getIconSize-D9Ej5fM()) / 2f);
        NavigationRailKt.LocalNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new NavigationRailKt$$ExternalSyntheticLambda4(), 1, null);
    }

    static final NavigationRailOverride LocalNavigationRailOverride$lambda$23() {
        return DefaultNavigationRailOverride.INSTANCE;
    }

    public static final void NavigationRail-qi6gXK8(Modifier arg24, long arg25, long arg27, Function3 arg29, WindowInsets arg30, Function3 arg31, Composer arg32, int arg33, int arg34) {
        WindowInsets v7_2;
        Function3 v6;
        long v4_1;
        long v2_5;
        Modifier v15_1;
        Function3 v20;
        long v18;
        long v16;
        WindowInsets v21;
        Companion v15_2;
        Companion v2_1;
        Function3 v13_1;
        int v13;
        WindowInsets v12_1;
        Function3 v11;
        int v10;
        long v7_1;
        int v7;
        long v5;
        Modifier v3;
        int v4;
        int v9 = arg33;
        Composer v1 = arg32.startRestartGroup(0x13C08DA8);
        ComposerKt.sourceInformation(v1, "C(NavigationRail)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,header,windowInsets,content)127@5999L7,*136@6318L16:NavigationRail.kt#uh7d8r");
        int v2 = arg34 & 1;
        if(v2 != 0) {
            v4 = v9 | 6;
            v3 = arg24;
        }
        else if((v9 & 6) == 0) {
            v3 = arg24;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v9;
        }
        else {
            v3 = arg24;
            v4 = v9;
        }

        if((v9 & 0x30) == 0) {
            if((arg34 & 2) == 0) {
                v5 = arg25;
                if(v1.changed(v5)) {
                    v7 = 0x20;
                }
                else {
                    goto label_34;
                }
            }
            else {
                v5 = arg25;
            label_34:
                v7 = 16;
            }

            v4 |= v7;
        }
        else {
            v5 = arg25;
        }

        if((v9 & 0x180) == 0) {
            if((arg34 & 4) == 0) {
                v7_1 = arg27;
                if(v1.changed(v7_1)) {
                    v10 = 0x100;
                }
                else {
                    goto label_48;
                }
            }
            else {
                v7_1 = arg27;
            label_48:
                v10 = 0x80;
            }

            v4 |= v10;
        }
        else {
            v7_1 = arg27;
        }

        v10 = arg34 & 8;
        if(v10 != 0) {
            v4 |= 0xC00;
            goto label_66;
        }
        else if((v9 & 0xC00) == 0) {
            v11 = arg29;
            int v12 = v1.changedInstance(v11) ? 0x800 : 0x400;
            v4 |= v12;
        }
        else {
        label_66:
            v11 = arg29;
        }

        if((v9 & 0x6000) == 0) {
            if((arg34 & 16) == 0) {
                v12_1 = arg30;
                if(v1.changed(v12_1)) {
                    v13 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v12_1 = arg30;
            label_77:
                v13 = 0x2000;
            }

            v4 |= v13;
        }
        else {
            v12_1 = arg30;
        }

        int v14 = 0x30000;
        if((arg34 & 0x20) != 0) {
            v4 |= v14;
            goto label_96;
        }
        else if((v9 & v14) == 0) {
            v13_1 = arg31;
            v14 = v1.changedInstance(v13_1) ? 0x20000 : 0x10000;
            v4 |= v14;
        }
        else {
        label_96:
            v13_1 = arg31;
        }

        boolean v14_1 = (74899 & v4) != 74898 ? true : false;
        if(v1.shouldExecute(v14_1, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "121@5706L14,122@5748L31,124@5895L12");
            int v15 = 0xFFFF1FFF;
            if((v9 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v2 != 0) {
                    v2_1 = Modifier.Companion;
                }
                else {
                    Modifier v2_2 = v3;
                }

                v14 = 6;
                if((arg34 & 2) != 0) {
                    v5 = NavigationRailDefaults.INSTANCE.getContainerColor(v1, v14);
                    v4 &= 0xFFFFFF8F;
                }

                if((arg34 & 4) != 0) {
                    v7_1 = ColorSchemeKt.contentColorFor-ek8zF_U(v5, v1, v4 >> 3 & 14);
                    v4 &= -897;
                }

                if(v10 != 0) {
                    v11 = null;
                }

                if((arg34 & 16) != 0) {
                    v4 &= v15;
                    v15_2 = v2_1;
                    v21 = NavigationRailDefaults.INSTANCE.getWindowInsets(v1, v14);
                    v16 = v5;
                    v18 = v7_1;
                    v20 = v11;
                    goto label_132;
                }

                v15_2 = v2_1;
            label_128:
                v16 = v5;
                v18 = v7_1;
                v20 = v11;
                v21 = v12_1;
            }
            else {
                v1.skipToGroupEnd();
                if((arg34 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }

                if((arg34 & 4) != 0) {
                    v4 &= -897;
                }

                if((arg34 & 16) != 0) {
                    v4 &= v15;
                }

                v15_1 = v3;
                goto label_128;
            }

        label_132:
            v2 = 0x13C08DA8;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v4, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:126)");
            }

            ProvidableCompositionLocal v2_3 = NavigationRailKt.LocalNavigationRailOverride;
            ComposerKt.sourceInformationMarkerStart(v1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v2_4 = v1.consume(((CompositionLocal)v2_3));
            ComposerKt.sourceInformationMarkerEnd(v1);
            ((NavigationRailOverride)v2_4).NavigationRail(new NavigationRailOverrideScope(v15_1, v16, v18, v20, v21, v13_1, null), v1, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_5 = v16;
            v4_1 = v18;
            v6 = v20;
            v7_2 = v21;
        }
        else {
            v1.skipToGroupEnd();
            v15_1 = v3;
            v2_5 = v5;
            v4_1 = v7_1;
            v6 = v11;
            v7_2 = v12_1;
        }

        ScopeUpdateScope v11_1 = v1.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new NavigationRailKt$$ExternalSyntheticLambda6(v15_1, v2_5, v4_1, v6, v7_2, arg31, v9, arg34));
        }
    }

    public static final void NavigationRailItem(boolean arg25, Function0 arg26, Function2 arg27, Modifier arg28, boolean arg29, Function2 arg30, boolean arg31, NavigationRailItemColors arg32, MutableInteractionSource arg33, Composer arg34, int arg35, int arg36) {
        Function2 v6_4;
        MutableInteractionSource v9_2;
        boolean v7_5;
        NavigationRailItemColors v8_1;
        boolean v5_6;
        NavigationRailKt$$ExternalSyntheticLambda2 v4_8;
        Shape v0_8;
        MappedInteractionSource v5_4;
        Composer v0_6;
        ComposableLambda v23;
        int v7_1;
        Function2 v20_1;
        NavigationRailItemColors v2_3;
        Object v16_1;
        MutableInteractionSource v2_2;
        Object v2_1;
        MutableInteractionSource v14_1;
        NavigationRailItemColors v1_2;
        Function2 v5_1;
        boolean v3_1;
        NavigationRailItemColors v0_2;
        Companion v4_1;
        boolean v12;
        int v16;
        Function2 v15_1;
        int v14;
        boolean v6;
        int v5;
        Modifier v4;
        Function2 v7;
        int v3;
        Function0 v13;
        int v2;
        boolean v1 = arg25;
        int v10 = arg35;
        int v11 = arg36;
        Composer v8 = arg34.startRestartGroup(0x9F6BE9FB);
        ComposerKt.sourceInformation(v8, "C(NavigationRailItem)N(selected,onClick,icon,modifier,enabled,label,alwaysShowLabel,colors,interactionSource)213@9696L14,215@9752L618,245@11016L3249:NavigationRail.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v2 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v2 = v8.changed(v1) ? 4 : 2;
            v2 |= v10;
        }
        else {
            v2 = v10;
        }

        if((v11 & 2) != 0) {
            v2 |= 0x30;
            v13 = arg26;
        }
        else {
            v13 = arg26;
            if((v10 & 0x30) == 0) {
                v3 = v8.changedInstance(v13) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        if((v11 & 4) != 0) {
            v2 |= 0x180;
            v7 = arg27;
        }
        else {
            v7 = arg27;
            if((v10 & 0x180) == 0) {
                v3 = v8.changedInstance(v7) ? 0x100 : 0x80;
                v2 |= v3;
            }
        }

        v3 = v11 & 8;
        if(v3 != 0) {
            v2 |= 0xC00;
            goto label_64;
        }
        else if((v10 & 0xC00) == 0) {
            v4 = arg28;
            v5 = v8.changed(v4) ? 0x800 : 0x400;
            v2 |= v5;
        }
        else {
        label_64:
            v4 = arg28;
        }

        v5 = v11 & 16;
        if(v5 != 0) {
            v2 |= 0x6000;
            goto label_79;
        }
        else if((v10 & 0x6000) == 0) {
            v6 = arg29;
            v14 = v8.changed(v6) ? 0x4000 : 0x2000;
            v2 |= v14;
        }
        else {
        label_79:
            v6 = arg29;
        }

        v14 = v11 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v2 |= v15;
            goto label_95;
        }
        else if((v15 & v10) == 0) {
            v15_1 = arg30;
            v16 = v8.changedInstance(v15_1) ? 0x20000 : 0x10000;
            v2 |= v16;
        }
        else {
        label_95:
            v15_1 = arg30;
        }

        v16 = v11 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v2 |= v17;
            v12 = arg31;
            goto label_113;
        }
        else {
            v12 = arg31;
            if((v10 & v17) == 0) {
                v17 = 0x20;
                int v18 = v8.changed(v12) ? 0x100000 : 0x80000;
                v2 |= v18;
            }
            else {
            label_113:
                v17 = 0x20;
            }
        }

        if((v10 & 0xC00000) == 0) {
            int v19 = (v11 & 0x80) != 0 || !v8.changed(arg32) ? 0x400000 : 0x800000;
            v2 |= v19;
        }

        int v0 = v11 & 0x100;
        int v20 = 0x6000000;
        if(v0 != 0) {
            v2 |= v20;
            goto label_145;
        }
        else if((v10 & v20) == 0) {
            v20 = v0;
            int v21 = v8.changed(arg33) ? 0x4000000 : 0x2000000;
            v2 |= v21;
        }
        else {
        label_145:
            v20 = v0;
        }

        boolean v0_1 = (v2 & 0x2492493) != 0x2492492 ? true : false;
        if(v8.shouldExecute(v0_1, v2 & 1)) {
            v8.startDefaults();
            ComposerKt.sourceInformation(v8, "207@9366L8");
            int v1_1 = 0xFE3FFFFF;
            int v9 = 6;
            if((v10 & 1) == 0 || (v8.getDefaultsInvalid())) {
                if(v3 != 0) {
                    v4_1 = Modifier.Companion;
                }

                if(v5 != 0) {
                    v6 = true;
                }

                if(v14 != 0) {
                    v15_1 = null;
                }

                if(v16 != 0) {
                    v12 = true;
                }

                if((v11 & 0x80) != 0) {
                    v0_2 = NavigationRailItemDefaults.INSTANCE.colors(v8, v9);
                    v2 &= v1_1;
                }
                else {
                    v0_2 = arg32;
                }

                if(v20 != 0) {
                    v1_2 = v0_2;
                    v3_1 = v6;
                    v6 = v12;
                    v5_1 = v15_1;
                    v14_1 = null;
                    goto label_176;
                }

                v14_1 = arg33;
                v1_2 = v0_2;
            label_173:
                v3_1 = v6;
                v6 = v12;
                v5_1 = v15_1;
            }
            else {
                v8.skipToGroupEnd();
                if((v11 & 0x80) != 0) {
                    v2 &= v1_1;
                }

                v1_2 = arg32;
                v14_1 = arg33;
                goto label_173;
            }

        label_176:
            v15 = v2;
            Modifier v12_1 = ((Modifier)v4_1);
            v8.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x9F6BE9FB, v15, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:209)");
            }

            String v0_3 = "CC(remember):NavigationRail.kt#9igjgp";
            if(v14_1 == null) {
                v8.startReplaceGroup(0xF18E0A0);
                ComposerKt.sourceInformation(v8, "211@9518L39");
                ComposerKt.sourceInformationMarkerStart(v8, 1947833250, v0_3);
                v2_1 = v8.rememberedValue();
                if(v2_1 == Composer.Companion.getEmpty()) {
                    v2_2 = InteractionSourceKt.MutableInteractionSource();
                    v8.updateRememberedValue(v2_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                v8.endReplaceGroup();
                v16_1 = v2_2;
            }
            else {
                v8.startReplaceGroup(0x74199117);
                v8.endReplaceGroup();
                MutableInteractionSource v16_2 = v14_1;
            }

            FiniteAnimationSpec v4_2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v8, v9);
            String v22 = v0_3;
            NavigationRailKt$NavigationRailItem$styledIcon$1 v0_4 = new NavigationRailKt$NavigationRailItem$styledIcon$1(v1_2, arg25, v3_1, v4_2, v5_1, v6, v7);
            boolean v19_1 = v6;
            int v6_1 = 54;
            ComposableLambda v0_5 = ComposableLambdaKt.rememberComposableLambda(206057749, true, v0_4, v8, v6_1);
            if(v5_1 == null) {
                v8.startReplaceGroup(0xF2706A8);
                v8.endReplaceGroup();
                v2_3 = v1_2;
                v20_1 = v5_1;
                v7_1 = 1;
                v23 = null;
            }
            else {
                v8.startReplaceGroup(0xF2706A9);
                ComposerKt.sourceInformation(v8, "*230@10466L534");
                v2_3 = v1_2;
                v20_1 = v5_1;
                v7_1 = 1;
                ComposableLambda v1_3 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new NavigationRailKt$NavigationRailItem$styledLabel$1$1(v1_2, arg25, v3_1, v4_2, v5_1), v8, v6_1);
                v8.endReplaceGroup();
                v23 = v1_3;
            }

            Object v30 = v16_1;
            Modifier v1_4 = SelectableKt.selectable-O2vRcR0(v12_1, arg25, ((MutableInteractionSource)v30), null, v3_1, Role.box-impl(Role.Companion.getTab-o7Vup1c()), v13);
            Modifier v16_3 = v12_1;
            Object v12_2 = v30;
            boolean v13_1 = v3_1;
            v1_4 = SizeKt.defaultMinSize-VpY3zN4$default(v1_4, 0f, NavigationRailKt.NavigationRailItemHeight, v7_1, null);
            float v3_2 = NavigationRailKt.NavigationRailItemWidth;
            v1_4 = SizeKt.widthIn-VpY3zN4$default(v1_4, v3_2, 0f, 2, null);
            Alignment v5_2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(v8, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v4_3 = BoxKt.maybeCachedBoxMeasurePolicy(v5_2, ((boolean)v7_1));
            ComposerKt.sourceInformationMarkerStart(v8, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v5 = ComposablesKt.getCurrentCompositeKeyHash(v8, 0);
            CompositionLocalMap v6_2 = v8.getCurrentCompositionLocalMap();
            v1_4 = ComposedModifierKt.materializeModifier(v8, v1_4);
            Function0 v7_2 = ComposeUiNode.Companion.getConstructor();
            ComposableLambda v30_1 = v0_5;
            ComposerKt.sourceInformationMarkerStart(v8, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v8.startReusableNode();
            if(v8.getInserting()) {
                v8.createNode(v7_2);
            }
            else {
                v8.useNode();
            }

            v0_6 = Updater.constructor-impl(v8);
            Updater.set-impl(v0_6, v4_3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v0_6, v6_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v4_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v0_6.getInserting()) || !Intrinsics.areEqual(v0_6.rememberedValue(), Integer.valueOf(v5))) {
                v0_6.updateRememberedValue(Integer.valueOf(v5));
                v0_6.apply(Integer.valueOf(v5), v4_4);
            }

            Updater.set-impl(v0_6, v1_4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v8, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v8, 0x931B1EC2, "C264@11812L7,261@11582L252,270@12124L7,267@11897L249,277@12430L7,283@12745L128,297@13310L237,305@13596L285,319@14147L32,320@14217L31,313@13891L368:NavigationRail.kt#uh7d8r");
            float v1_5 = arg25 ? 1f : 0f;
            Composer v6_3 = v8;
            float v0_7 = v3_2;
            NavigationRailItemColors v9_1 = v2_3;
            v10 = 54;
            State v1_6 = AnimateAsStateKt.animateFloatAsState(v1_5, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v8, 6), 0f, null, null, v6_3, 0, 28);
            float v4_5 = arg25 ? 1f : 0f;
            State v24 = v1_6;
            v1_6 = AnimateAsStateKt.animateFloatAsState(v4_5, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, v6_3, 6), 0f, null, null, v6_3, 0, 28);
            ProvidableCompositionLocal v2_4 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v6_3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v2_1 = v6_3.consume(((CompositionLocal)v2_4));
            ComposerKt.sourceInformationMarkerEnd(v6_3);
            long v2_5 = Offset.constructor-impl((((long)Float.floatToRawIntBits((((float)(((Density)v2_1).roundToPx-0680j_4(v0_7) - ((Density)v2_1).roundToPx-0680j_4(NavigationRailVerticalItemTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM())))) / 2f))) << v17 | (((long)Float.floatToRawIntBits(0f))) & 0xFFFFFFFFL);
            String v4_6 = v22;
            ComposerKt.sourceInformationMarkerStart(v6_3, 0xE3B71B75, v4_6);
            v0 = v6_3.changed(v12_2) | v6_3.changed(v2_5);
            Object v5_3 = v6_3.rememberedValue();
            if(v0 != 0 || v5_3 == Composer.Companion.getEmpty()) {
                v5_4 = new MappedInteractionSource(v12_2, v2_5, null);
                v6_3.updateRememberedValue(v5_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v6_3);
            if(v20_1 != null) {
                v6_3.startReplaceGroup(0x932F2EF2);
                ComposerKt.sourceInformation(v6_3, "289@13007L5");
                v0_8 = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), v6_3, 6);
                v6_3.endReplaceGroup();
            }
            else {
                v6_3.startReplaceGroup(0x9330A36E);
                ComposerKt.sourceInformation(v6_3, "291@13076L5");
                v0_8 = ShapesKt.getValue(ShapeKeyTokens.CornerFull, v6_3, 6);
                v6_3.endReplaceGroup();
            }

            ComposableLambda v2_6 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new NavigationRailKt$NavigationRailItem$1$indicatorRipple$1(v0_8, v5_4), v6_3, v10);
            State v5_5 = v24;
            v0_5 = ComposableLambdaKt.rememberComposableLambda(0x7F694A7E, true, new NavigationRailKt$NavigationRailItem$1$indicator$1(v5_5, v9_1, v0_8), v6_3, v10);
            ComposerKt.sourceInformationMarkerStart(v6_3, 0xE3B7CA55, v4_6);
            v3_1 = v6_3.changed(v5_5);
            Object v7_3 = v6_3.rememberedValue();
            if((v3_1) || v7_3 == Composer.Companion.getEmpty()) {
                NavigationRailKt$$ExternalSyntheticLambda1 v7_4 = new NavigationRailKt$$ExternalSyntheticLambda1(v5_5);
                v6_3.updateRememberedValue(v7_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v6_3);
            ComposerKt.sourceInformationMarkerStart(v6_3, -474492140, v4_6);
            v3_1 = v6_3.changed(v1_6);
            Object v4_7 = v6_3.rememberedValue();
            if((v3_1) || v4_7 == Composer.Companion.getEmpty()) {
                v4_8 = new NavigationRailKt$$ExternalSyntheticLambda2(v1_6);
                v6_3.updateRememberedValue(v4_8);
            }

            ComposerKt.sourceInformationMarkerEnd(v6_3);
            ComposableLambda v3_3 = v2_6;
            v2_6 = v0_5;
            v0_2 = v9_1;
            v8 = v6_3;
            v5_6 = v19_1;
            NavigationRailKt.NavigationRailItemLayout(v3_3, ((Function2)v2_6), v30_1, v23, v5_6, v7_3, v4_8, v8, 0xE000 & v15 >> 6 | 438);
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            v8.endNode();
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Composer v4_9 = v8;
            v8_1 = v0_2;
            v0_6 = v4_9;
            v7_5 = v5_6;
            v5_6 = v13_1;
            v9_2 = v14_1;
            v4 = v16_3;
            v6_4 = v20_1;
        }
        else {
            v8.skipToGroupEnd();
            v9_2 = arg33;
            v5_6 = v6;
            v0_6 = v8;
            v7_5 = v12;
            v6_4 = v15_1;
            v8_1 = arg32;
        }

        ScopeUpdateScope v12_3 = v0_6.endRestartGroup();
        if(v12_3 != null) {
            v12_3.updateScope(new NavigationRailKt$$ExternalSyntheticLambda3(arg25, arg26, arg27, v4, v5_6, v6_4, v7_5, v8_1, v9_2, arg35, v11));
        }
    }

    static final float NavigationRailItem$lambda$10$lambda$7$lambda$6(State arg0) {
        return arg0.getValue().floatValue();
    }

    static final float NavigationRailItem$lambda$10$lambda$9$lambda$8(State arg0) {
        return arg0.getValue().floatValue();
    }

    static final Unit NavigationRailItem$lambda$11(boolean arg13, Function0 arg14, Function2 arg15, Modifier arg16, boolean arg17, Function2 arg18, boolean arg19, NavigationRailItemColors arg20, MutableInteractionSource arg21, int arg22, int arg23, Composer arg24, int arg25) {
        NavigationRailKt.NavigationRailItem(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    private static final void NavigationRailItemLayout(Function2 arg20, Function2 arg21, Function2 arg22, Function2 arg23, boolean arg24, Function0 arg25, Function0 arg26, Composer arg27, int arg28) {
        NavigationRailKt$$ExternalSyntheticLambda7 v12_2;
        NavigationRailKt$NavigationRailItemLayout$1$1 v15_2;
        int v11;
        int v10;
        Function2 v1 = arg20;
        Function2 v2 = arg21;
        Function2 v3 = arg22;
        Function2 v4 = arg23;
        boolean v5 = arg24;
        Function0 v6 = arg25;
        Function0 v7 = arg26;
        int v8 = arg28;
        int v0 = 0xD2BE7F5C;
        Composer v9 = arg27.startRestartGroup(v0);
        ComposerKt.sourceInformation(v9, "C(NavigationRailItemLayout)N(indicatorRipple,indicator,icon,label,alwaysShowLabel,alphaAnimationProgress,sizeAnimationProgress)576@25709L2050,558@25188L2571:NavigationRail.kt#uh7d8r");
        if((v8 & 6) == 0) {
            v10 = v9.changedInstance(v1) ? 4 : 2;
            v10 |= v8;
        }
        else {
            v10 = v8;
        }

        if((v8 & 0x30) == 0) {
            v11 = v9.changedInstance(v2) ? 0x20 : 16;
            v10 |= v11;
        }

        if((v8 & 0x180) == 0) {
            v11 = v9.changedInstance(v3) ? 0x100 : 0x80;
            v10 |= v11;
        }

        int v12 = 0x800;
        if((v8 & 0xC00) == 0) {
            v11 = v9.changedInstance(v4) ? v12 : 0x400;
            v10 |= v11;
        }

        if((v8 & 0x6000) == 0) {
            v11 = v9.changed(v5) ? 0x4000 : 0x2000;
            v10 |= v11;
        }

        if((0x30000 & v8) == 0) {
            v11 = v9.changedInstance(v6) ? 0x20000 : 0x10000;
            v10 |= v11;
        }

        int v15 = 0x100000;
        if((0x180000 & v8) == 0) {
            v11 = v9.changedInstance(v7) ? v15 : 0x80000;
            v10 |= v11;
        }

        int v16 = 1;
        boolean v11_1 = (0x92493 & v10) != 0x92492 ? true : false;
        if(v9.shouldExecute(v11_1, v10 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v10, -1, "androidx.compose.material3.NavigationRailItemLayout (NavigationRail.kt:557)");
            }

            Modifier v0_1 = BadgeKt.badgeBounds(Modifier.Companion);
            String v14 = "CC(remember):NavigationRail.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v9, 488409630, v14);
            v11 = (0x380000 & v10) == v15 ? 1 : 0;
            v12 = (v10 & 0x1C00) == v12 ? 1 : 0;
            v11 |= v12;
            v12 = 0xE000 & v10;
            v15 = v12 == 0x4000 ? 1 : 0;
            v11 |= v15;
            Object v15_1 = v9.rememberedValue();
            if(v11 != 0 || v15_1 == Composer.Companion.getEmpty()) {
                v15_2 = new NavigationRailKt$NavigationRailItemLayout$1$1(v7, v4, v5);
                v9.updateRememberedValue(v15_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            String v7_1 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v9, -1323940314, v7_1);
            int v17 = ComposablesKt.getCurrentCompositeKeyHash(v9, 0);
            CompositionLocalMap v11_2 = v9.getCurrentCompositionLocalMap();
            v0_1 = ComposedModifierKt.materializeModifier(v9, v0_1);
            Function0 v13 = ComposeUiNode.Companion.getConstructor();
            int v18 = v10;
            String v10_1 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v9, 0xD6BD0031, v10_1);
            if(!(v9.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v9.startReusableNode();
            if(v9.getInserting()) {
                v9.createNode(v13);
            }
            else {
                v9.useNode();
            }

            Composer v8_1 = Updater.constructor-impl(v9);
            Updater.set-impl(v8_1, v15_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v8_1, v11_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v11_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v8_1.getInserting()) || !Intrinsics.areEqual(v8_1.rememberedValue(), Integer.valueOf(v17))) {
                v8_1.updateRememberedValue(Integer.valueOf(v17));
                v8_1.apply(Integer.valueOf(v17), v11_3);
            }

            Updater.set-impl(v8_1, v0_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v9, 0x2E12CAAC, "C561@25271L17,562@25301L11,564@25326L50:NavigationRail.kt#uh7d8r");
            v1.invoke(v9, Integer.valueOf(v18 & 14));
            v2.invoke(v9, Integer.valueOf(v18 >> 3 & 14));
            v0_1 = LayoutIdKt.layoutId(Modifier.Companion, "icon");
            String v11_4 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v9, 0x2BB5B5D7, v11_4);
            MeasurePolicy v13_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v9, -1323940314, v7_1);
            v8 = ComposablesKt.getCurrentCompositeKeyHash(v9, 0);
            CompositionLocalMap v15_3 = v9.getCurrentCompositionLocalMap();
            v0_1 = ComposedModifierKt.materializeModifier(v9, v0_1);
            Function0 v1_1 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v9, 0xD6BD0031, v10_1);
            if(!(v9.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v9.startReusableNode();
            if(v9.getInserting()) {
                v9.createNode(v1_1);
            }
            else {
                v9.useNode();
            }

            Composer v1_2 = Updater.constructor-impl(v9);
            Updater.set-impl(v1_2, v13_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v1_2, v15_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            v2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v1_2.getInserting()) || !Intrinsics.areEqual(v1_2.rememberedValue(), Integer.valueOf(v8))) {
                v1_2.updateRememberedValue(Integer.valueOf(v8));
                v1_2.apply(Integer.valueOf(v8), v2);
            }

            Updater.set-impl(v1_2, v0_1, ComposeUiNode.Companion.getSetModifier());
            v0 = 0x800B7D29;
            String v1_3 = "C72@3468L9:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v9, v0, v1_3);
            ComposerKt.sourceInformationMarkerStart(v9, 0x4C50CCC4, "C564@25368L6:NavigationRail.kt#uh7d8r");
            v3.invoke(v9, Integer.valueOf(v18 >> 6 & 14));
            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            v9.endNode();
            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            if(v4 != null) {
                v9.startReplaceGroup(0x2E14D0B5);
                ComposerKt.sourceInformation(v9, "568@25502L109,567@25427L250");
                Modifier v2_1 = LayoutIdKt.layoutId(Modifier.Companion, "label");
                ComposerKt.sourceInformationMarkerStart(v9, 0x2284D7E0, v14);
                v15 = v12 == 0x4000 ? 1 : 0;
                if((v18 & 0x70000) == 0x20000) {
                }
                else {
                    v16 = 0;
                }

                Object v12_1 = v9.rememberedValue();
                if((v15 | v16) != 0 || v12_1 == Composer.Companion.getEmpty()) {
                    v12_2 = new NavigationRailKt$$ExternalSyntheticLambda7(v5, v6);
                    v9.updateRememberedValue(v12_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v9);
                v2_1 = GraphicsLayerModifierKt.graphicsLayer(v2_1, ((Function1)v12_2));
                ComposerKt.sourceInformationMarkerStart(v9, 0x2BB5B5D7, v11_4);
                MeasurePolicy v8_2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v9, -1323940314, v7_1);
                int v7_2 = ComposablesKt.getCurrentCompositeKeyHash(v9, 0);
                v11_2 = v9.getCurrentCompositionLocalMap();
                v2_1 = ComposedModifierKt.materializeModifier(v9, v2_1);
                Function0 v12_3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v9, 0xD6BD0031, v10_1);
                if(!(v9.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v9.startReusableNode();
                if(v9.getInserting()) {
                    v9.createNode(v12_3);
                }
                else {
                    v9.useNode();
                }

                Composer v10_2 = Updater.constructor-impl(v9);
                Updater.set-impl(v10_2, v8_2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v10_2, v11_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 v8_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v10_2.getInserting()) || !Intrinsics.areEqual(v10_2.rememberedValue(), Integer.valueOf(v7_2))) {
                    v10_2.updateRememberedValue(Integer.valueOf(v7_2));
                    v10_2.apply(Integer.valueOf(v7_2), v8_3);
                }

                Updater.set-impl(v10_2, v2_1, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v9, v0, v1_3);
                ComposerKt.sourceInformationMarkerStart(v9, 0xC4A469E8, "C572@25652L7:NavigationRail.kt#uh7d8r");
                v4.invoke(v9, Integer.valueOf(v18 >> 9 & 14));
                ComposerKt.sourceInformationMarkerEnd(v9);
                ComposerKt.sourceInformationMarkerEnd(v9);
                v9.endNode();
                ComposerKt.sourceInformationMarkerEnd(v9);
                ComposerKt.sourceInformationMarkerEnd(v9);
                ComposerKt.sourceInformationMarkerEnd(v9);
                v9.endReplaceGroup();
            }
            else {
                v9.startReplaceGroup(0x2E18F34F);
                v9.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            v9.endNode();
            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_357;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v9.skipToGroupEnd();
        }

    label_357:
        ScopeUpdateScope v9_1 = v9.endRestartGroup();
        if(v9_1 != null) {
            v9_1.updateScope(new NavigationRailKt$$ExternalSyntheticLambda8(arg20, arg21, v3, v4, v5, v6, arg26, arg28));
        }
    }

    static final Unit NavigationRailItemLayout$lambda$17$lambda$15$lambda$14(boolean arg0, Function0 arg1, GraphicsLayerScope arg2) {
        float v0 = arg0 ? 1f : arg1.invoke().floatValue();
        arg2.setAlpha(v0);
        return Unit.INSTANCE;
    }

    static final Unit NavigationRailItemLayout$lambda$18(Function2 arg10, Function2 arg11, Function2 arg12, Function2 arg13, boolean arg14, Function0 arg15, Function0 arg16, int arg17, Composer arg18, int arg19) {
        NavigationRailKt.NavigationRailItemLayout(arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg18, RecomposeScopeImplKt.updateChangedFlags(arg17 | 1));
        return Unit.INSTANCE;
    }

    static final Unit NavigationRail_qi6gXK8$lambda$1(Modifier arg12, long arg13, long arg15, Function3 arg17, WindowInsets arg18, Function3 arg19, int arg20, int arg21, Composer arg22, int arg23) {
        NavigationRailKt.NavigationRail-qi6gXK8(arg12, arg13, arg15, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    public static final float access$getIndicatorHorizontalPadding$p() {
        return NavigationRailKt.IndicatorHorizontalPadding;
    }

    public static final float access$getIndicatorVerticalPaddingNoLabel$p() {
        return NavigationRailKt.IndicatorVerticalPaddingNoLabel;
    }

    public static final float access$getIndicatorVerticalPaddingWithLabel$p() {
        return NavigationRailKt.IndicatorVerticalPaddingWithLabel;
    }

    public static final float access$getNavigationRailHeaderPadding$p() {
        return NavigationRailKt.NavigationRailHeaderPadding;
    }

    public static final MeasureResult access$placeIcon-X9ElhV4(MeasureScope arg0, Placeable arg1, Placeable arg2, Placeable arg3, long arg4) {
        return NavigationRailKt.placeIcon-X9ElhV4(arg0, arg1, arg2, arg3, arg4);
    }

    public static final MeasureResult access$placeLabelAndIcon-zUg2_y0(MeasureScope arg0, Placeable arg1, Placeable arg2, Placeable arg3, Placeable arg4, long arg5, boolean arg7, float arg8) {
        return NavigationRailKt.placeLabelAndIcon-zUg2_y0(arg0, arg1, arg2, arg3, arg4, arg5, arg7, arg8);
    }

    public static final ProvidableCompositionLocal getLocalNavigationRailOverride() {
        return NavigationRailKt.LocalNavigationRailOverride;
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailKt.NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailKt.NavigationRailItemVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailKt.NavigationRailItemWidth;
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailKt.NavigationRailVerticalPadding;
    }

    private static final MeasureResult placeIcon-X9ElhV4(MeasureScope arg13, Placeable arg14, Placeable arg15, Placeable arg16, long arg17) {
        long v0 = arg17;
        int v2 = arg14.getWidth();
        int v3 = arg15.getWidth();
        int v4 = arg16 != null ? arg16.getWidth() : 0;
        int v11 = ConstraintsKt.constrainWidth-K40F9xA(v0, Math.max(v2, Math.max(v3, v4)));
        int v12 = ConstraintsKt.constrainHeight-K40F9xA(v0, arg13.roundToPx-0680j_4(NavigationRailKt.NavigationRailItemHeight));
        return MeasureScope.layout$default(arg13, v11, v12, null, new NavigationRailKt$$ExternalSyntheticLambda5(arg16, arg14, (v11 - arg14.getWidth()) / 2, (v12 - arg14.getHeight()) / 2, arg15, (v11 - arg15.getWidth()) / 2, (v12 - arg15.getHeight()) / 2, v11, v12), 4, null);
    }

    static final Unit placeIcon_X9ElhV4$lambda$20(Placeable arg15, Placeable arg16, int arg17, int arg18, Placeable arg19, int arg20, int arg21, int arg22, int arg23, PlacementScope arg24) {
        if(arg15 != null) {
            PlacementScope.placeRelative$default(arg24, arg15, (arg22 - arg15.getWidth()) / 2, (arg23 - arg15.getHeight()) / 2, 0f, 4, null);
        }

        PlacementScope.placeRelative$default(arg24, arg16, arg17, arg18, 0f, 4, null);
        PlacementScope.placeRelative$default(arg24, arg19, arg20, arg21, 0f, 4, null);
        return Unit.INSTANCE;
    }

    private static final MeasureResult placeLabelAndIcon-zUg2_y0(MeasureScope arg17, Placeable arg18, Placeable arg19, Placeable arg20, Placeable arg21, long arg22, boolean arg24, float arg25) {
        MeasureScope v15 = arg17;
        float v0 = ((float)arg19.getHeight());
        float v1 = NavigationRailKt.IndicatorVerticalPaddingWithLabel;
        v0 += v15.toPx-0680j_4(v1);
        float v2 = NavigationRailKt.NavigationRailItemVerticalPadding;
        v0 = v0 + v15.toPx-0680j_4(v2) + (((float)arg18.getHeight()));
        float v4 = 2f;
        float v10 = RangesKt.coerceAtLeast(((((float)Constraints.getMinHeight-impl(arg22))) - v0) / v4, v15.toPx-0680j_4(v1));
        v0 += v10 * v4;
        float v3 = arg24 ? v10 : (v0 - (((float)arg19.getHeight()))) / v4;
        float v7 = (v3 - v10) * (1f - arg25);
        float v6 = (((float)arg19.getHeight())) + v10 + v15.toPx-0680j_4(v1) + v15.toPx-0680j_4(v2);
        int v2_1 = arg19.getWidth();
        int v3_1 = arg18.getWidth();
        int v4_1 = arg21 != null ? arg21.getWidth() : 0;
        int v14 = ConstraintsKt.constrainWidth-K40F9xA(arg22, Math.max(v2_1, Math.max(v3_1, v4_1)));
        return MeasureScope.layout$default(arg17, v14, MathKt.roundToInt(v0), null, new NavigationRailKt$$ExternalSyntheticLambda0(arg21, arg24, arg25, arg18, (v14 - arg18.getWidth()) / 2, v6, v7, arg19, (v14 - arg19.getWidth()) / 2, v10, arg20, (v14 - arg20.getWidth()) / 2, v10 - v15.toPx-0680j_4(v1), v14, v15), 4, null);
    }

    static final Unit placeLabelAndIcon_zUg2_y0$lambda$22(Placeable arg15, boolean arg16, float arg17, Placeable arg18, int arg19, float arg20, float arg21, Placeable arg22, int arg23, float arg24, Placeable arg25, int arg26, float arg27, int arg28, MeasureScope arg29, PlacementScope arg30) {
        if(arg15 != null) {
            PlacementScope.placeRelative$default(arg30, arg15, (arg28 - arg15.getWidth()) / 2, MathKt.roundToInt(arg24 - arg29.toPx-0680j_4(NavigationRailKt.IndicatorVerticalPaddingWithLabel) + arg21), 0f, 4, null);
        }

        if((arg16) || arg17 != 0f) {
            PlacementScope.placeRelative$default(arg30, arg18, arg19, MathKt.roundToInt(arg20 + arg21), 0f, 4, null);
        }
        else {
        }

        PlacementScope.placeRelative$default(arg30, arg22, arg23, MathKt.roundToInt(arg24 + arg21), 0f, 4, null);
        PlacementScope.placeRelative$default(arg30, arg25, arg26, MathKt.roundToInt(arg27 + arg21), 0f, 4, null);
        return Unit.INSTANCE;
    }
}

