package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.material3.tokens.NavigationBarVerticalItemTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
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
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u008C\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\u001A_\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\u001C\u0010\u000B\u001A\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000E¢\u0006\u0002\b\u000FH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001A\u0085\u0001\u0010\u0012\u001A\u00020\u0001*\u00020\r2\u0006\u0010\u0013\u001A\u00020\u00142\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00010\u00162\u0011\u0010\u0017\u001A\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000E2\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0018\u001A\u00020\u00142\u0015\b\u0002\u0010\u0019\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u000E2\b\b\u0002\u0010\u001A\u001A\u00020\u00142\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0007¢\u0006\u0002\u0010\u001F\u001A\u007F\u0010 \u001A\u00020\u00012\u0011\u0010!\u001A\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000E2\u0011\u0010\"\u001A\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000E2\u0011\u0010\u0017\u001A\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000E2\u0013\u0010\u0019\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u000E2\u0006\u0010\u001A\u001A\u00020\u00142\f\u0010#\u001A\b\u0012\u0004\u0012\u00020$0\u00162\f\u0010%\u001A\b\u0012\u0004\u0012\u00020$0\u0016H\u0003¢\u0006\u0002\u0010&\u001A5\u0010\'\u001A\u00020(*\u00020)2\u0006\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020+2\b\u0010-\u001A\u0004\u0018\u00010+2\u0006\u0010.\u001A\u00020/H\u0002¢\u0006\u0004\b0\u00101\u001AM\u00102\u001A\u00020(*\u00020)2\u0006\u00103\u001A\u00020+2\u0006\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020+2\b\u0010-\u001A\u0004\u0018\u00010+2\u0006\u0010.\u001A\u00020/2\u0006\u0010\u001A\u001A\u00020\u00142\u0006\u00104\u001A\u00020$H\u0002¢\u0006\u0004\b5\u00106\"\u000E\u00107\u001A\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u00109\u001A\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010:\u001A\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010;\u001A\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010<\u001A\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010=\"\u0016\u0010>\u001A\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001A\u0004\b?\u0010@\"\u0016\u0010A\u001A\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001A\u0004\bB\u0010@\"\u0010\u0010C\u001A\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010=\"\u0016\u0010D\u001A\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001A\u0004\bE\u0010@\"\u0010\u0010F\u001A\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010=\"\u0016\u0010G\u001A\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001A\u0004\bH\u0010@\"\u001A\u0010I\u001A\b\u0012\u0004\u0012\u00020K0JX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bL\u0010M¨\u0006N²\u0006\n\u0010O\u001A\u00020\u0005X\u008A\u0084\u0002²\u0006\n\u0010P\u001A\u00020\u0005X\u008A\u0084\u0002²\u0006\n\u0010Q\u001A\u00020RX\u008A\u008E\u0002"}, d2={"NavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItemLayout", "indicatorRipple", "indicator", "alphaAnimationProgress", "", "sizeAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "animationProgress", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "IndicatorRippleLayoutIdTag", "", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "NavigationBarHeight", "F", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "()F", "NavigationBarIndicatorToLabelPadding", "getNavigationBarIndicatorToLabelPadding", "IndicatorHorizontalPadding", "IndicatorVerticalPadding", "getIndicatorVerticalPadding", "IndicatorVerticalOffset", "NavigationBarItemToIconMinimumPadding", "getNavigationBarItemToIconMinimumPadding", "LocalNavigationBarOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/NavigationBarOverride;", "getLocalNavigationBarOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3", "iconColor", "textColor", "itemWidth", ""}, k=2, mv={2, 0, 0}, xi=0x30) public final class NavigationBarKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding = 0f;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset = 0f;
    private static final float IndicatorVerticalPadding = 0f;
    private static final String LabelLayoutIdTag = "label";
    private static final ProvidableCompositionLocal LocalNavigationBarOverride;
    private static final float NavigationBarHeight;
    private static final float NavigationBarIndicatorToLabelPadding;
    private static final float NavigationBarItemHorizontalPadding;
    private static final float NavigationBarItemToIconMinimumPadding;

    static {
        NavigationBarKt.NavigationBarHeight = NavigationBarTokens.INSTANCE.getTallContainerHeight-D9Ej5fM();
        NavigationBarKt.NavigationBarItemHorizontalPadding = Dp.constructor-impl(8f);
        NavigationBarKt.NavigationBarIndicatorToLabelPadding = Dp.constructor-impl(4f);
        NavigationBarKt.IndicatorHorizontalPadding = Dp.constructor-impl(Dp.constructor-impl(NavigationBarVerticalItemTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM() - NavigationBarVerticalItemTokens.INSTANCE.getIconSize-D9Ej5fM()) / 2f);
        NavigationBarKt.IndicatorVerticalPadding = Dp.constructor-impl(Dp.constructor-impl(NavigationBarVerticalItemTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM() - NavigationBarVerticalItemTokens.INSTANCE.getIconSize-D9Ej5fM()) / 2f);
        NavigationBarKt.IndicatorVerticalOffset = Dp.constructor-impl(12f);
        NavigationBarKt.NavigationBarItemToIconMinimumPadding = Dp.constructor-impl(44f);
        NavigationBarKt.LocalNavigationBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new NavigationBarKt$$ExternalSyntheticLambda0(), 1, null);
    }

    static final NavigationBarOverride LocalNavigationBarOverride$lambda$28() {
        return DefaultNavigationBarOverride.INSTANCE;
    }

    public static final void NavigationBar-HsRjFd4(Modifier arg24, long arg25, long arg27, float arg29, WindowInsets arg30, Function3 arg31, Composer arg32, int arg33, int arg34) {
        WindowInsets v7_2;
        float v6;
        long v4_1;
        long v2_5;
        Modifier v15_1;
        float v20;
        long v18;
        long v16;
        WindowInsets v21;
        Companion v15_2;
        Companion v2_1;
        Function3 v13_1;
        int v13;
        WindowInsets v12_1;
        float v11;
        int v10;
        long v7_1;
        int v7;
        long v5;
        Modifier v3;
        int v4;
        int v9 = arg33;
        Composer v1 = arg32.startRestartGroup(1054099326);
        ComposerKt.sourceInformation(v1, "C(NavigationBar)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,windowInsets,content)119@5618L7,*128@5952L15:NavigationBar.kt#uh7d8r");
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
            int v12 = v1.changed(v11) ? 0x800 : 0x400;
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
            ComposerKt.sourceInformation(v1, "113@5304L14,114@5360L11,116@5518L12");
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
                    v5 = NavigationBarDefaults.INSTANCE.getContainerColor(v1, v14);
                    v4 &= 0xFFFFFF8F;
                }

                if((arg34 & 4) != 0) {
                    v7_1 = ColorSchemeKt.contentColorFor-4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(v1, v14), v5);
                    v4 &= -897;
                }

                if(v10 != 0) {
                    v11 = NavigationBarDefaults.INSTANCE.getElevation-D9Ej5fM();
                }

                if((arg34 & 16) != 0) {
                    v4 &= v15;
                    v15_2 = v2_1;
                    v21 = NavigationBarDefaults.INSTANCE.getWindowInsets(v1, v14);
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
            v2 = 1054099326;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v4, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:118)");
            }

            ProvidableCompositionLocal v2_3 = NavigationBarKt.LocalNavigationBarOverride;
            ComposerKt.sourceInformationMarkerStart(v1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v2_4 = v1.consume(((CompositionLocal)v2_3));
            ComposerKt.sourceInformationMarkerEnd(v1);
            ((NavigationBarOverride)v2_4).NavigationBar(new NavigationBarOverrideScope(((Modifier)v15_2), v16, v18, v20, v21, v13_1, null), v1, 0);
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
            v11_1.updateScope(new NavigationBarKt$$ExternalSyntheticLambda2(((Modifier)v15_2), v2_5, v4_1, v6, v7_2, arg31, v9, arg34));
        }
    }

    public static final void NavigationBarItem(RowScope arg27, boolean arg28, Function0 arg29, Function2 arg30, Modifier arg31, boolean arg32, Function2 arg33, boolean arg34, NavigationBarItemColors arg35, MutableInteractionSource arg36, Composer arg37, int arg38, int arg39) {
        Function2 v7_3;
        boolean v8_1;
        MutableInteractionSource v10_4;
        NavigationBarItemColors v9_3;
        NavigationBarKt$$ExternalSyntheticLambda5 v4_8;
        NavigationBarKt$$ExternalSyntheticLambda4 v5_7;
        Composer v0_7;
        MutableIntState v1_5;
        ComposableLambda v22;
        Function2 v21;
        NavigationBarItemColors v2_1;
        MutableInteractionSource v18_2;
        MutableInteractionSource v0_4;
        NavigationBarItemColors v1_2;
        Function2 v5_1;
        Modifier v10_1;
        boolean v6_1;
        boolean v3_1;
        MutableInteractionSource v14_1;
        NavigationBarItemColors v0_2;
        int v19;
        boolean v10;
        int v16;
        Function2 v15_1;
        int v14;
        boolean v7_1;
        int v6;
        Modifier v5;
        Function2 v4;
        Function0 v13;
        int v3;
        int v1;
        boolean v2 = arg28;
        int v11 = arg38;
        int v12 = arg39;
        Composer v8 = arg37.startRestartGroup(974293026);
        ComposerKt.sourceInformation(v8, "C(NavigationBarItem)N(selected,onClick,icon,modifier,enabled,label,alwaysShowLabel,colors,interactionSource)209@9556L14,211@9612L618,241@10880L33,255@11322L24,243@10919L3178:NavigationBar.kt#uh7d8r");
        if((0x80000000 & v12) != 0) {
            v1 = v11 | 6;
        }
        else {
            RowScope v9 = arg27;
            if((v11 & 6) == 0) {
                v1 = v8.changed(v9) ? 4 : 2;
                v1 |= v11;
            }
            else {
                v1 = v11;
            }
        }

        if((v12 & 1) != 0) {
            v1 |= 0x30;
        }
        else if((v11 & 0x30) == 0) {
            v3 = v8.changed(v2) ? 0x20 : 16;
            v1 |= v3;
        }

        if((v12 & 2) != 0) {
            v1 |= 0x180;
            v13 = arg29;
        }
        else {
            v13 = arg29;
            if((v11 & 0x180) == 0) {
                v3 = v8.changedInstance(v13) ? 0x100 : 0x80;
                v1 |= v3;
            }
        }

        if((v12 & 4) != 0) {
            v1 |= 0xC00;
        }
        else {
            v4 = arg30;
            if((v11 & 0xC00) == 0) {
                v3 = v8.changedInstance(v4) ? 0x800 : 0x400;
                v1 |= v3;
            }
        }

        v3 = v12 & 8;
        if(v3 != 0) {
            v1 |= 0x6000;
            goto label_79;
        }
        else if((v11 & 0x6000) == 0) {
            v5 = arg31;
            v6 = v8.changed(v5) ? 0x4000 : 0x2000;
            v1 |= v6;
        }
        else {
        label_79:
            v5 = arg31;
        }

        v6 = v12 & 16;
        int v7 = 0x30000;
        if(v6 != 0) {
            v1 |= v7;
            goto label_95;
        }
        else if((v7 & v11) == 0) {
            v7_1 = arg32;
            v14 = v8.changed(v7_1) ? 0x20000 : 0x10000;
            v1 |= v14;
        }
        else {
        label_95:
            v7_1 = arg32;
        }

        v14 = v12 & 0x20;
        int v15 = 0x180000;
        if(v14 != 0) {
            v1 |= v15;
            goto label_111;
        }
        else if((v15 & v11) == 0) {
            v15_1 = arg33;
            v16 = v8.changedInstance(v15_1) ? 0x100000 : 0x80000;
            v1 |= v16;
        }
        else {
        label_111:
            v15_1 = arg33;
        }

        v16 = v12 & 0x40;
        int v17 = 0xC00000;
        if(v16 != 0) {
            v1 |= v17;
            v10 = arg34;
            goto label_129;
        }
        else {
            v10 = arg34;
            if((v11 & v17) == 0) {
                v17 = 0x20;
                int v18 = v8.changed(v10) ? 0x800000 : 0x400000;
                v1 |= v18;
            }
            else {
            label_129:
                v17 = 0x20;
            }
        }

        if((v11 & 0x6000000) == 0) {
            v19 = (v12 & 0x80) != 0 || !v8.changed(arg35) ? 0x2000000 : 0x4000000;
            v1 |= v19;
        }

        int v0 = v12 & 0x100;
        v19 = 0x30000000;
        if(v0 != 0) {
            v1 |= v19;
            goto label_161;
        }
        else if((v11 & v19) == 0) {
            v19 = v0;
            int v20 = v8.changed(arg36) ? 0x20000000 : 0x10000000;
            v1 |= v20;
        }
        else {
        label_161:
            v19 = v0;
        }

        int v37 = v1;
        boolean v0_1 = (v1 & 306783379) != 306783378 ? true : false;
        if(v8.shouldExecute(v0_1, v37 & 1)) {
            v8.startDefaults();
            ComposerKt.sourceInformation(v8, "203@9226L8");
            Function2 v1_1 = null;
            int v9_1 = 6;
            if((v11 & 1) == 0 || (v8.getDefaultsInvalid())) {
                if(v3 != 0) {
                    Companion v5_2 = Modifier.Companion;
                }

                if(v6 != 0) {
                    v7_1 = true;
                }

                if(v14 != 0) {
                    v15_1 = v1_1;
                }

                if(v16 != 0) {
                    v10 = true;
                }

                if((v12 & 0x80) != 0) {
                    v0_2 = NavigationBarItemDefaults.INSTANCE.colors(v8, v9_1);
                    v3 = v37 & 0xF1FFFFFF;
                }
                else {
                    v0_2 = arg35;
                    v3 = v37;
                }

                if(v19 != 0) {
                    v14_1 = ((MutableInteractionSource)v1_1);
                    v6_1 = v10;
                    v1_2 = v0_2;
                }
                else {
                    v1_2 = v0_2;
                    v14_1 = arg36;
                    v6_1 = v10;
                }

                v10_1 = v5;
                v5_1 = v15_1;
                v15 = v3;
                v3_1 = v7_1;
            }
            else {
                v8.skipToGroupEnd();
                if((v12 & 0x80) != 0) {
                    v14_1 = arg36;
                    v3_1 = v7_1;
                    v6_1 = v10;
                    v10_1 = v5;
                    v5_1 = v15_1;
                    v15 = v37 & 0xF1FFFFFF;
                    v1_2 = arg35;
                }
                else {
                    v14_1 = arg36;
                    v3_1 = v7_1;
                    v6_1 = v10;
                    v1_2 = arg35;
                    v10_1 = v5;
                    v5_1 = v15_1;
                    v15 = v37;
                }
            }

            v8.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(974293026, v15, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:205)");
            }

            String v9_2 = "CC(remember):NavigationBar.kt#9igjgp";
            if(v14_1 == null) {
                v8.startReplaceGroup(0xF2975459);
                ComposerKt.sourceInformation(v8, "207@9378L39");
                ComposerKt.sourceInformationMarkerStart(v8, 0xFF9144C9, v9_2);
                Object v0_3 = v8.rememberedValue();
                if(v0_3 == Composer.Companion.getEmpty()) {
                    v0_4 = InteractionSourceKt.MutableInteractionSource();
                    v8.updateRememberedValue(v0_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                v8.endReplaceGroup();
                Object v18_1 = v0_4;
            }
            else {
                v8.startReplaceGroup(0xFF91423E);
                v8.endReplaceGroup();
                v18_2 = v14_1;
            }

            FiniteAnimationSpec v4_1 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v8, 6);
            Modifier v37_1 = v10_1;
            Object v10_2 = null;
            NavigationBarKt$NavigationBarItem$styledIcon$1 v0_5 = new NavigationBarKt$NavigationBarItem$styledIcon$1(v1_2, v2, v3_1, v4_1, v5_1, v6_1, arg30);
            boolean v19_1 = v6_1;
            v6 = 54;
            ComposableLambda v0_6 = ComposableLambdaKt.rememberComposableLambda(0xCBBF93BC, true, v0_5, v8, v6);
            if(v5_1 == null) {
                v8.startReplaceGroup(-224036658);
                v8.endReplaceGroup();
                v2_1 = v1_2;
                v21 = v5_1;
                v22 = ((ComposableLambda)v10_2);
            }
            else {
                v8.startReplaceGroup(-224036657);
                ComposerKt.sourceInformation(v8, "*226@10326L521");
                v2_1 = v1_2;
                v21 = v5_1;
                ComposableLambda v1_3 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new NavigationBarKt$NavigationBarItem$styledLabel$1$1(v1_2, arg28, v3_1, v4_1, v5_1), v8, v6);
                v8.endReplaceGroup();
                v22 = v1_3;
            }

            ComposerKt.sourceInformationMarkerStart(v8, 0xFF920083, v9_2);
            Object v1_4 = v8.rememberedValue();
            if(v1_4 == Composer.Companion.getEmpty()) {
                v1_5 = SnapshotIntStateKt.mutableIntStateOf(0);
                v8.updateRememberedValue(v1_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            boolean v35 = v3_1;
            Modifier v3_2 = SelectableKt.selectable-O2vRcR0(v37_1, arg28, v18_2, null, v35, Role.box-impl(Role.Companion.getTab-o7Vup1c()), v13);
            Modifier v23 = v37_1;
            Object v13_1 = v18_2;
            boolean v18_3 = v35;
            v3_2 = RowScope.weight$default(arg27, SizeKt.defaultMinSize-VpY3zN4$default(v3_2, 0f, NavigationBarKt.NavigationBarHeight, 1, v10_2), 1f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(v8, 0xFF9237BA, v9_2);
            Object v4_2 = v8.rememberedValue();
            if(v4_2 == Composer.Companion.getEmpty()) {
                NavigationBarKt$$ExternalSyntheticLambda3 v4_3 = new NavigationBarKt$$ExternalSyntheticLambda3(v1_5);
                v8.updateRememberedValue(v4_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            v3_2 = OnRemeasuredModifierKt.onSizeChanged(v3_2, ((Function1)v4_2));
            Alignment v4_4 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(v8, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v4_5 = BoxKt.maybeCachedBoxMeasurePolicy(v4_4, true);
            ComposerKt.sourceInformationMarkerStart(v8, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int v5_3 = ComposablesKt.getCurrentCompositeKeyHash(v8, 0);
            CompositionLocalMap v7_2 = v8.getCurrentCompositionLocalMap();
            v3_2 = ComposedModifierKt.materializeModifier(v8, v3_2);
            Function0 v6_2 = ComposeUiNode.Companion.getConstructor();
            ComposableLambda v33 = v0_6;
            ComposerKt.sourceInformationMarkerStart(v8, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v8.startReusableNode();
            if(v8.getInserting()) {
                v8.createNode(v6_2);
            }
            else {
                v8.useNode();
            }

            v0_7 = Updater.constructor-impl(v8);
            Updater.set-impl(v0_7, v4_5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v0_7, v7_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            v4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v0_7.getInserting()) || !Intrinsics.areEqual(v0_7.rememberedValue(), Integer.valueOf(v5_3))) {
                v0_7.updateRememberedValue(Integer.valueOf(v5_3));
                v0_7.apply(Integer.valueOf(v5_3), v4);
            }

            Updater.set-impl(v0_7, v3_2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v8, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v8, 0xA2B513D5, "C263@11734L7,260@11504L252,269@12046L7,266@11819L249,275@12351L7,281@12645L128,288@12988L273,296@13310L404,313@13979L32,314@14049L31,307@13724L367:NavigationBar.kt#uh7d8r");
            float v0_8 = arg28 ? 1f : 0f;
            Composer v6_3 = v8;
            NavigationBarItemColors v10_3 = v2_1;
            Object v24 = v1_5;
            float v1_6 = v0_8;
            v0 = 54;
            State v1_7 = AnimateAsStateKt.animateFloatAsState(v1_6, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v8, 6), 0f, null, null, v6_3, 0, 28);
            float v5_4 = arg28 ? 1f : 0f;
            State v26 = v1_7;
            v1_7 = AnimateAsStateKt.animateFloatAsState(v5_4, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, v6_3, 6), 0f, null, null, v6_3, 0, 28);
            ProvidableCompositionLocal v2_2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v6_3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v2_3 = v6_3.consume(((CompositionLocal)v2_2));
            ComposerKt.sourceInformationMarkerEnd(v6_3);
            long v2_4 = Offset.constructor-impl((((long)Float.floatToRawIntBits((((float)(NavigationBarKt.NavigationBarItem$lambda$5(((MutableIntState)v24)) - ((Density)v2_3).roundToPx-0680j_4(NavigationBarVerticalItemTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM())))) / 2f))) << v17 | 0xFFFFFFFFL & (((long)Float.floatToRawIntBits(((Density)v2_3).toPx-0680j_4(NavigationBarKt.IndicatorVerticalOffset)))));
            ComposerKt.sourceInformationMarkerStart(v6_3, 0x4750B59C, v9_2);
            int v4_6 = v6_3.changed(v13_1) | v6_3.changed(v2_4);
            Object v5_5 = v6_3.rememberedValue();
            if(v4_6 != 0 || v5_5 == Composer.Companion.getEmpty()) {
                MappedInteractionSource v5_6 = new MappedInteractionSource(v13_1, v2_4, null);
                v6_3.updateRememberedValue(v5_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v6_3);
            ComposableLambda v2_5 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new NavigationBarKt$NavigationBarItem$2$indicatorRipple$1(((MappedInteractionSource)v5_5)), v6_3, v0);
            State v4_7 = v26;
            v0_6 = ComposableLambdaKt.rememberComposableLambda(0xD0583A65, true, new NavigationBarKt$NavigationBarItem$2$indicator$1(v4_7, v10_3), v6_3, v0);
            ComposerKt.sourceInformationMarkerStart(v6_3, 1196514300, v9_2);
            v3_1 = v6_3.changed(v4_7);
            v5_5 = v6_3.rememberedValue();
            if((v3_1) || v5_5 == Composer.Companion.getEmpty()) {
                v5_7 = new NavigationBarKt$$ExternalSyntheticLambda4(v4_7);
                v6_3.updateRememberedValue(v5_7);
            }

            ComposerKt.sourceInformationMarkerEnd(v6_3);
            ComposerKt.sourceInformationMarkerStart(v6_3, 0x475164BB, v9_2);
            v3_1 = v6_3.changed(v1_7);
            v4_2 = v6_3.rememberedValue();
            if((v3_1) || v4_2 == Composer.Companion.getEmpty()) {
                v4_8 = new NavigationBarKt$$ExternalSyntheticLambda5(v1_7);
                v6_3.updateRememberedValue(v4_8);
            }

            ComposerKt.sourceInformationMarkerEnd(v6_3);
            NavigationBarKt.NavigationBarItemLayout(v2_5, v0_6, v33, v22, v19_1, v5_7, v4_8, v6_3, v15 >> 9 & 0xE000 | 438);
            v6_3 = v6_3;
            ComposerKt.sourceInformationMarkerEnd(v6_3);
            ComposerKt.sourceInformationMarkerEnd(v6_3);
            v6_3.endNode();
            ComposerKt.sourceInformationMarkerEnd(v6_3);
            ComposerKt.sourceInformationMarkerEnd(v6_3);
            ComposerKt.sourceInformationMarkerEnd(v6_3);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v0_7 = v6_3;
            v9_3 = v10_3;
            v10_4 = v14_1;
            v6_1 = v18_3;
            v8_1 = v19_1;
            v7_3 = v21;
            v5 = v23;
        }
        else {
            v8.skipToGroupEnd();
            v9_3 = arg35;
            v0_7 = v8;
            v6_1 = v7_1;
            v8_1 = v10;
            v7_3 = v15_1;
            v10_4 = arg36;
        }

        ScopeUpdateScope v13_2 = v0_7.endRestartGroup();
        if(v13_2 != null) {
            v13_2.updateScope(new NavigationBarKt$$ExternalSyntheticLambda6(arg27, arg28, arg29, arg30, v5, v6_1, v7_3, v8_1, v9_3, v10_4, v11, v12));
        }
    }

    static final float NavigationBarItem$lambda$15$lambda$12$lambda$11(State arg0) {
        return arg0.getValue().floatValue();
    }

    static final float NavigationBarItem$lambda$15$lambda$14$lambda$13(State arg0) {
        return arg0.getValue().floatValue();
    }

    static final Unit NavigationBarItem$lambda$16(RowScope arg14, boolean arg15, Function0 arg16, Function2 arg17, Modifier arg18, boolean arg19, Function2 arg20, boolean arg21, NavigationBarItemColors arg22, MutableInteractionSource arg23, int arg24, int arg25, Composer arg26, int arg27) {
        NavigationBarKt.NavigationBarItem(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    private static final int NavigationBarItem$lambda$5(MutableIntState arg0) {
        return ((IntState)arg0).getIntValue();
    }

    private static final void NavigationBarItem$lambda$6(MutableIntState arg0, int arg1) {
        arg0.setIntValue(arg1);
    }

    static final Unit NavigationBarItem$lambda$8$lambda$7(MutableIntState arg2, IntSize arg3) {
        NavigationBarKt.NavigationBarItem$lambda$6(arg2, ((int)(arg3.unbox-impl() >> 0x20)));
        return Unit.INSTANCE;
    }

    private static final void NavigationBarItemLayout(Function2 arg20, Function2 arg21, Function2 arg22, Function2 arg23, boolean arg24, Function0 arg25, Function0 arg26, Composer arg27, int arg28) {
        NavigationBarKt$NavigationBarItemLayout$1$1 v15_2;
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
        int v0 = -1019541078;
        Composer v9 = arg27.startRestartGroup(v0);
        ComposerKt.sourceInformation(v9, "C(NavigationBarItemLayout)N(indicatorRipple,indicator,icon,label,alwaysShowLabel,alphaAnimationProgress,sizeAnimationProgress)572@25349L1844,554@24828L2365:NavigationBar.kt#uh7d8r");
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
                ComposerKt.traceEventStart(v0, v10, -1, "androidx.compose.material3.NavigationBarItemLayout (NavigationBar.kt:553)");
            }

            Modifier v0_1 = BadgeKt.badgeBounds(Modifier.Companion);
            String v14 = "CC(remember):NavigationBar.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v9, 0xE09FB7FE, v14);
            v11 = (0x380000 & v10) == v15 ? 1 : 0;
            v12 = (v10 & 0x1C00) == v12 ? 1 : 0;
            v11 |= v12;
            v12 = 0xE000 & v10;
            v15 = v12 == 0x4000 ? 1 : 0;
            v11 |= v15;
            Object v15_1 = v9.rememberedValue();
            if(v11 != 0 || v15_1 == Composer.Companion.getEmpty()) {
                v15_2 = new NavigationBarKt$NavigationBarItemLayout$1$1(v7, v4, v5);
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
            ComposerKt.sourceInformationMarkerStart(v9, 0xD89FFBDE, "C557@24911L17,558@24941L11,560@24966L50:NavigationBar.kt#uh7d8r");
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
            ComposerKt.sourceInformationMarkerStart(v9, 0x4AAB6476, "C560@25008L6:NavigationBar.kt#uh7d8r");
            v3.invoke(v9, Integer.valueOf(v18 >> 6 & 14));
            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            v9.endNode();
            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            if(v4 != null) {
                v9.startReplaceGroup(0xD8A201E7);
                ComposerKt.sourceInformation(v9, "564@25142L109,563@25067L250");
                Modifier v2_1 = LayoutIdKt.layoutId(Modifier.Companion, "label");
                ComposerKt.sourceInformationMarkerStart(v9, 0x61D3B86E, v14);
                v15 = v12 == 0x4000 ? 1 : 0;
                if((v18 & 0x70000) == 0x20000) {
                }
                else {
                    v16 = 0;
                }

                Object v12_1 = v9.rememberedValue();
                if((v15 | v16) != 0 || v12_1 == Composer.Companion.getEmpty()) {
                    NavigationBarKt$$ExternalSyntheticLambda8 v12_2 = new NavigationBarKt$$ExternalSyntheticLambda8(v5, v6);
                    v9.updateRememberedValue(v12_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v9);
                v2_1 = GraphicsLayerModifierKt.graphicsLayer(v2_1, ((Function1)v12_1));
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
                ComposerKt.sourceInformationMarkerStart(v9, 874979034, "C568@25292L7:NavigationBar.kt#uh7d8r");
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
                v9.startReplaceGroup(-660200319);
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
            v9_1.updateScope(new NavigationBarKt$$ExternalSyntheticLambda9(arg20, arg21, v3, v4, v5, v6, arg26, arg28));
        }
    }

    static final Unit NavigationBarItemLayout$lambda$22$lambda$20$lambda$19(boolean arg0, Function0 arg1, GraphicsLayerScope arg2) {
        float v0 = arg0 ? 1f : arg1.invoke().floatValue();
        arg2.setAlpha(v0);
        return Unit.INSTANCE;
    }

    static final Unit NavigationBarItemLayout$lambda$23(Function2 arg10, Function2 arg11, Function2 arg12, Function2 arg13, boolean arg14, Function0 arg15, Function0 arg16, int arg17, Composer arg18, int arg19) {
        NavigationBarKt.NavigationBarItemLayout(arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg18, RecomposeScopeImplKt.updateChangedFlags(arg17 | 1));
        return Unit.INSTANCE;
    }

    static final Unit NavigationBar_HsRjFd4$lambda$1(Modifier arg12, long arg13, long arg15, float arg17, WindowInsets arg18, Function3 arg19, int arg20, int arg21, Composer arg22, int arg23) {
        NavigationBarKt.NavigationBar-HsRjFd4(arg12, arg13, arg15, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    public static final float access$getIndicatorHorizontalPadding$p() {
        return NavigationBarKt.IndicatorHorizontalPadding;
    }

    public static final float access$getNavigationBarHeight$p() {
        return NavigationBarKt.NavigationBarHeight;
    }

    public static final MeasureResult access$placeIcon-X9ElhV4(MeasureScope arg0, Placeable arg1, Placeable arg2, Placeable arg3, long arg4) {
        return NavigationBarKt.placeIcon-X9ElhV4(arg0, arg1, arg2, arg3, arg4);
    }

    public static final MeasureResult access$placeLabelAndIcon-zUg2_y0(MeasureScope arg0, Placeable arg1, Placeable arg2, Placeable arg3, Placeable arg4, long arg5, boolean arg7, float arg8) {
        return NavigationBarKt.placeLabelAndIcon-zUg2_y0(arg0, arg1, arg2, arg3, arg4, arg5, arg7, arg8);
    }

    public static final float getIndicatorVerticalPadding() {
        return NavigationBarKt.IndicatorVerticalPadding;
    }

    public static final ProvidableCompositionLocal getLocalNavigationBarOverride() {
        return NavigationBarKt.LocalNavigationBarOverride;
    }

    public static final float getNavigationBarIndicatorToLabelPadding() {
        return NavigationBarKt.NavigationBarIndicatorToLabelPadding;
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarKt.NavigationBarItemHorizontalPadding;
    }

    public static final float getNavigationBarItemToIconMinimumPadding() {
        return NavigationBarKt.NavigationBarItemToIconMinimumPadding;
    }

    private static final MeasureResult placeIcon-X9ElhV4(MeasureScope arg11, Placeable arg12, Placeable arg13, Placeable arg14, long arg15) {
        int v0 = Constraints.getMaxWidth-impl(arg15) == 0x7FFFFFFF ? arg12.getWidth() + arg11.roundToPx-0680j_4(NavigationBarKt.NavigationBarItemToIconMinimumPadding) * 2 : Constraints.getMaxWidth-impl(arg15);
        int v10 = ConstraintsKt.constrainHeight-K40F9xA(arg15, arg11.roundToPx-0680j_4(NavigationBarKt.NavigationBarHeight));
        return MeasureScope.layout$default(arg11, v0, v10, null, new NavigationBarKt$$ExternalSyntheticLambda7(arg14, arg12, (v0 - arg12.getWidth()) / 2, (v10 - arg12.getHeight()) / 2, arg13, (v0 - arg13.getWidth()) / 2, (v10 - arg13.getHeight()) / 2, v0, v10), 4, null);
    }

    static final Unit placeIcon_X9ElhV4$lambda$25(Placeable arg15, Placeable arg16, int arg17, int arg18, Placeable arg19, int arg20, int arg21, int arg22, int arg23, PlacementScope arg24) {
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
        float v1 = NavigationBarKt.IndicatorVerticalPadding;
        v0 += v15.toPx-0680j_4(v1);
        float v2 = NavigationBarKt.NavigationBarIndicatorToLabelPadding;
        v0 = v0 + v15.toPx-0680j_4(v2) + (((float)arg18.getHeight()));
        float v4 = 2f;
        float v10 = RangesKt.coerceAtLeast(((((float)Constraints.getMinHeight-impl(arg22))) - v0) / v4, v15.toPx-0680j_4(v1));
        v0 += v10 * v4;
        float v3 = arg24 ? v10 : (v0 - (((float)arg19.getHeight()))) / v4;
        float v7 = (v3 - v10) * (1f - arg25);
        float v6 = (((float)arg19.getHeight())) + v10 + v15.toPx-0680j_4(v1) + v15.toPx-0680j_4(v2);
        int v2_1 = Constraints.getMaxWidth-impl(arg22) == 0x7FFFFFFF ? arg19.getWidth() + v15.roundToPx-0680j_4(NavigationBarKt.NavigationBarItemToIconMinimumPadding) * 2 : Constraints.getMaxWidth-impl(arg22);
        return MeasureScope.layout$default(arg17, v2_1, MathKt.roundToInt(v0), null, new NavigationBarKt$$ExternalSyntheticLambda1(arg21, arg24, arg25, arg18, (v2_1 - arg18.getWidth()) / 2, v6, v7, arg19, (v2_1 - arg19.getWidth()) / 2, v10, arg20, (v2_1 - arg20.getWidth()) / 2, v10 - v15.toPx-0680j_4(v1), v2_1, v15), 4, null);
    }

    static final Unit placeLabelAndIcon_zUg2_y0$lambda$27(Placeable arg15, boolean arg16, float arg17, Placeable arg18, int arg19, float arg20, float arg21, Placeable arg22, int arg23, float arg24, Placeable arg25, int arg26, float arg27, int arg28, MeasureScope arg29, PlacementScope arg30) {
        if(arg15 != null) {
            PlacementScope.placeRelative$default(arg30, arg15, (arg28 - arg15.getWidth()) / 2, MathKt.roundToInt(arg24 - (((float)arg29.roundToPx-0680j_4(NavigationBarKt.IndicatorVerticalPadding))) + arg21), 0f, 4, null);
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

