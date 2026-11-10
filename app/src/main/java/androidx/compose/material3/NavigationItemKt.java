package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\b\u001Aµ\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u0006\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00032\u0013\u0010\u0018\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CH\u0001¢\u0006\u0004\b\u001D\u0010\u001E\u001AÕ\u0001\u0010\u001F\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u0006\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020\r2\u0006\u0010!\u001A\u00020\t2\u0006\u0010\"\u001A\u00020\t2\u0006\u0010#\u001A\u00020\r2\u0006\u0010$\u001A\u00020\r2\u0006\u0010%\u001A\u00020\r2\u0006\u0010&\u001A\u00020\r2\u0006\u0010\'\u001A\u00020\r2\u0006\u0010(\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010)\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00032\u0013\u0010\u0018\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CH\u0001¢\u0006\u0004\b*\u0010+\u001A\u008D\u0001\u0010,\u001A\u00020\u00012\u0006\u0010\u001B\u001A\u00020-2\u0006\u0010.\u001A\u00020/2\u0006\u0010\n\u001A\u00020\u000B2\u0011\u0010\u0006\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001A\u00020\u001A2\u0013\u0010\u0018\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\f\u00100\u001A\b\u0012\u0004\u0012\u0002010\u00052\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\rH\u0003¢\u0006\u0004\b2\u00103\u001A³\u0001\u00104\u001A\u00020\u00012\u0006\u0010\u001B\u001A\u00020-2\u0006\u0010.\u001A\u00020/2\u0006\u0010\n\u001A\u00020\u000B2\f\u00100\u001A\b\u0012\u0004\u0012\u0002010\u00052\u0011\u0010\u0006\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001A\u00020\u001A2\f\u00105\u001A\b\u0012\u0004\u0012\u0002010\u00052\u0013\u0010\u0018\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010#\u001A\u00020\r2\u0006\u0010$\u001A\u00020\r2\u0006\u0010%\u001A\u00020\r2\u0006\u0010&\u001A\u00020\r2\u0006\u0010\'\u001A\u00020\r2\u0006\u0010(\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010)\u001A\u00020\rH\u0003¢\u0006\u0004\b6\u00107\u001A3\u00108\u001A\u000209*\u00020:2\u0006\u0010;\u001A\u00020<2\u0006\u0010=\u001A\u00020<2\u0006\u0010>\u001A\u00020<2\u0006\u0010?\u001A\u00020@H\u0002¢\u0006\u0004\bA\u0010B\u001AS\u0010C\u001A\u000209*\u00020:2\u0006\u0010D\u001A\u00020<2\u0006\u0010;\u001A\u00020<2\u0006\u0010=\u001A\u00020<2\u0006\u0010>\u001A\u00020<2\u0006\u0010?\u001A\u00020@2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\rH\u0002¢\u0006\u0004\bE\u0010F\u001AC\u0010G\u001A\u000209*\u00020:2\u0006\u0010D\u001A\u00020<2\u0006\u0010;\u001A\u00020<2\u0006\u0010=\u001A\u00020<2\u0006\u0010>\u001A\u00020<2\u0006\u0010?\u001A\u00020@2\u0006\u0010\u0011\u001A\u00020\rH\u0002¢\u0006\u0004\bH\u0010I\u001A\u0091\u0001\u0010J\u001A\u000209*\u00020:2\u0006\u0010\u0019\u001A\u00020\u001A2\f\u00105\u001A\b\u0012\u0004\u0012\u0002010\u00052\u0006\u0010D\u001A\u00020<2\u0006\u0010;\u001A\u00020<2\u0006\u0010=\u001A\u00020<2\u0006\u0010>\u001A\u00020<2\u0006\u0010 \u001A\u00020K2\u0006\u0010?\u001A\u00020@2\u0006\u0010%\u001A\u00020\r2\u0006\u0010$\u001A\u00020\r2\u0006\u0010#\u001A\u00020\r2\u0006\u0010&\u001A\u00020\r2\u0006\u0010\'\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010)\u001A\u00020\rH\u0002¢\u0006\u0004\bL\u0010M\u001A@\u0010N\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00032\u0011\u0010O\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007H\u0003¢\u0006\u0002\u0010P\u001A\u001B\u0010Q\u001A\b\u0012\u0004\u0012\u0002010R2\u0006\u0010\u0002\u001A\u00020\u0003H\u0003¢\u0006\u0002\u0010S\u001A\u001D\u0010T\u001A\u00020\u00012\u0006\u0010\u001B\u001A\u00020-2\u0006\u0010\n\u001A\u00020\u000BH\u0003¢\u0006\u0002\u0010U\u001A-\u0010V\u001A\u00020\u00012\u0006\u0010.\u001A\u00020/2\u0006\u0010\n\u001A\u00020\u000B2\f\u00100\u001A\b\u0012\u0004\u0012\u0002010\u0005H\u0003¢\u0006\u0004\bW\u0010X\"\u000E\u0010Y\u001A\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010[\u001A\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\\\u001A\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010]\u001A\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010^\u001A\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010_¨\u0006`²\u0006\n\u0010a\u001A\u00020KX\u008A\u008E\u0002²\u0006\n\u0010a\u001A\u00020KX\u008A\u008E\u0002²\u0006\n\u00105\u001A\u000201X\u008A\u0084\u0002²\u0006\n\u0010b\u001A\u00020\tX\u008A\u0084\u0002"}, d2={"NavigationItem", "", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "Landroidx/compose/runtime/Composable;", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "indicatorShape", "Landroidx/compose/ui/graphics/Shape;", "indicatorWidth", "Landroidx/compose/ui/unit/Dp;", "indicatorHorizontalPadding", "indicatorVerticalPadding", "indicatorToLabelVerticalPadding", "startIconToLabelHorizontalPadding", "topIconItemVerticalPadding", "colors", "Landroidx/compose/material3/NavigationItemColors;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "label", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "NavigationItem-8Df7sds", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/graphics/Shape;FFFFFFLandroidx/compose/material3/NavigationItemColors;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "AnimatedNavigationItem", "topIconIndicatorWidth", "topIconLabelTextStyle", "startIconLabelTextStyle", "topIconIndicatorHorizontalPadding", "topIconIndicatorVerticalPadding", "topIconIndicatorToLabelVerticalPadding", "startIconIndicatorHorizontalPadding", "startIconIndicatorVerticalPadding", "noLabelIndicatorPadding", "itemHorizontalPadding", "AnimatedNavigationItem-DQd_Gtc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;FFFFFFFFLandroidx/compose/material3/NavigationItemColors;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "NavigationItemLayout", "Landroidx/compose/foundation/interaction/InteractionSource;", "indicatorColor", "Landroidx/compose/ui/graphics/Color;", "indicatorAnimationProgress", "", "NavigationItemLayout-KmRX-Dg", "(Landroidx/compose/foundation/interaction/InteractionSource;JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;FFFFFLandroidx/compose/runtime/Composer;II)V", "AnimatedNavigationItemLayout", "iconPositionProgress", "AnimatedNavigationItemLayout-he0WsC4", "(Landroidx/compose/foundation/interaction/InteractionSource;JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;FFFFFFFFLandroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndTopIcon", "labelPlaceable", "placeLabelAndTopIcon-qoqLrGI", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JFFF)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndStartIcon", "placeLabelAndStartIcon-nru01g4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "placeAnimatedLabelAndIcon", "", "placeAnimatedLabelAndIcon-2QYhCQ8", "(Landroidx/compose/ui/layout/MeasureScope;ILkotlin/jvm/functions/Function0;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;IJFFFFFFF)Landroidx/compose/ui/layout/MeasureResult;", "StyledLabel", "content", "(ZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/material3/NavigationItemColors;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "animateIndicatorProgressAsState", "Landroidx/compose/runtime/State;", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "IndicatorRipple", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "Indicator", "Indicator-3J-VO9M", "(JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "IndicatorRippleLayoutIdTag", "", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "IndicatorVerticalOffset", "F", "material3", "itemWidth", "textStyle"}, k=2, mv={2, 0, 0}, xi=0x30) public final class NavigationItemKt {
    private static final String IconLayoutIdTag = "icon";
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset = 0f;
    private static final String LabelLayoutIdTag = "label";

    static {
        NavigationItemKt.IndicatorVerticalOffset = Dp.constructor-impl(12f);
    }

    public static final void AnimatedNavigationItem-DQd_Gtc(boolean arg33, Function0 arg34, Function2 arg35, Shape arg36, float arg37, TextStyle arg38, TextStyle arg39, float arg40, float arg41, float arg42, float arg43, float arg44, float arg45, float arg46, float arg47, NavigationItemColors arg48, Modifier arg49, boolean arg50, Function2 arg51, int arg52, MutableInteractionSource arg53, Composer arg54, int arg55, int arg56, int arg57) {
        NavigationItemKt$$ExternalSyntheticLambda6 v4_4;
        NavigationItemKt$$ExternalSyntheticLambda5 v3_8;
        long v0_9;
        ComposableLambda v19_1;
        int v26;
        String v9_1;
        Composer v6_2;
        boolean v16;
        State v2_4;
        Composer v21_1;
        int v25;
        int v0_1;
        int v22;
        int v5;
        boolean v1 = arg33;
        Function2 v7 = arg35;
        float v8 = arg37;
        TextStyle v9 = arg38;
        TextStyle v10 = arg39;
        NavigationItemColors v11 = arg48;
        boolean v3 = arg50;
        Function2 v12 = arg51;
        int v13 = arg52;
        MutableInteractionSource v2 = arg53;
        int v14 = arg55;
        int v15 = arg56;
        Composer v4 = arg54.startRestartGroup(-1114086313);
        ComposerKt.sourceInformation(v4, "C(AnimatedNavigationItem)N(selected,onClick,icon,indicatorShape,topIconIndicatorWidth:c#ui.unit.Dp,topIconLabelTextStyle,startIconLabelTextStyle,topIconIndicatorHorizontalPadding:c#ui.unit.Dp,topIconIndicatorVerticalPadding:c#ui.unit.Dp,topIconIndicatorToLabelVerticalPadding:c#ui.unit.Dp,startIconIndicatorHorizontalPadding:c#ui.unit.Dp,startIconIndicatorVerticalPadding:c#ui.unit.Dp,noLabelIndicatorPadding:c#ui.unit.Dp,startIconToLabelHorizontalPadding:c#ui.unit.Dp,itemHorizontalPadding:c#ui.unit.Dp,colors,modifier,enabled,label,iconPosition:c#material3.NavigationItemIconPosition,interactionSource)345@14658L94,349@14775L33,362@15198L7,363@15272L7,365@15322L24,351@14814L3783:NavigationItem.kt#uh7d8r");
        if((v14 & 6) == 0) {
            v5 = v4.changed(v1) ? 4 : 2;
            v5 |= v14;
        }
        else {
            v5 = v14;
        }

        int v17 = 16;
        int v24 = 0x20;
        Function0 v0 = arg34;
        if((v14 & 0x30) == 0) {
            int v18 = v4.changedInstance(v0) ? v24 : v17;
            v5 |= v18;
        }

        int v19 = 0x100;
        int v20 = 0x80;
        if((v14 & 0x180) == 0) {
            int v6 = v4.changedInstance(v7) ? v19 : v20;
            v5 |= v6;
        }

        int v21 = 0x400;
        if((v14 & 0xC00) == 0) {
            v22 = v4.changed(arg36) ? 0x800 : v21;
            v5 |= v22;
        }

        if((v14 & 0x6000) == 0) {
            v0_1 = v4.changed(v8) ? 0x4000 : 0x2000;
            v5 |= v0_1;
        }

        v0_1 = 0x30000;
        if((v14 & v0_1) == 0) {
            v22 = v4.changed(v9) ? 0x20000 : 0x10000;
            v5 |= v22;
        }

        if((v14 & 0x180000) == 0) {
            v22 = v4.changed(v10) ? 0x100000 : 0x80000;
            v5 |= v22;
        }

        v22 = v14 & 0xC00000;
        float v14_1 = arg40;
        if(v22 == 0) {
            v22 = v4.changed(v14_1) ? 0x800000 : 0x400000;
            v5 |= v22;
        }

        v14_1 = arg41;
        if((arg55 & 0x6000000) == 0) {
            v22 = v4.changed(v14_1) ? 0x4000000 : 0x2000000;
            v5 |= v22;
        }

        v14_1 = arg42;
        if((arg55 & 0x30000000) == 0) {
            v22 = v4.changed(v14_1) ? 0x20000000 : 0x10000000;
            v5 |= v22;
        }

        v14_1 = arg43;
        if((v15 & 6) == 0) {
            v22 = v4.changed(v14_1) ? 4 : 2;
            v22 |= v15;
        }
        else {
            v22 = v15;
        }

        v14_1 = arg44;
        if((v15 & 0x30) == 0) {
            if(v4.changed(v14_1)) {
                v17 = v24;
            }

            v22 |= v17;
        }

        v17 = v0_1;
        if((v15 & 0x180) == 0) {
            if(v4.changed(arg45)) {
            }
            else {
                v19 = v20;
            }

            v22 |= v19;
        }

        if((v15 & 0xC00) == 0) {
            if(v4.changed(arg46)) {
                v21 = 0x800;
            }

            v22 |= v21;
        }

        if((v15 & 0x6000) == 0) {
            v19 = v4.changed(arg47) ? 0x4000 : 0x2000;
            v22 |= v19;
        }

        if((v15 & v17) == 0) {
            v17 = v4.changed(v11) ? 0x20000 : 0x10000;
            v22 |= v17;
        }

        Modifier v0_2 = arg49;
        if((v15 & 0x180000) == 0) {
            v17 = v4.changed(v0_2) ? 0x100000 : 0x80000;
            v22 |= v17;
        }

        if((v15 & 0xC00000) == 0) {
            v17 = v4.changed(v3) ? 0x800000 : 0x400000;
            v22 |= v17;
        }

        if((v15 & 0x6000000) == 0) {
            v17 = v4.changedInstance(v12) ? 0x4000000 : 0x2000000;
            v22 |= v17;
        }

        if((v15 & 0x30000000) == 0) {
            v17 = v4.changed(v13) ? 0x20000000 : 0x10000000;
            v22 |= v17;
        }

        int v12_1 = v22;
        if((arg57 & 6) == 0) {
            v17 = v4.changed(v2) ? 4 : 2;
            v25 = arg57 | v17;
        }
        else {
            v25 = arg57;
        }

        boolean v0_3 = (v5 & 306783379) != 306783378 || (306783379 & v12_1) != 306783378 || (v25 & 3) != 2 ? true : false;
        if(v4.shouldExecute(v0_3, v5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1114086313, v5, v12_1, "androidx.compose.material3.AnimatedNavigationItem (NavigationItem.kt:343)");
            }

            ComposableLambda v14_2 = ComposableLambdaKt.rememberComposableLambda(0x32BB2171, true, new NavigationItemKt$AnimatedNavigationItem$styledIcon$1(v11.iconColor-WaAFU9c(v1, v3), v7), v4, 54);
            String v15_1 = "CC(remember):NavigationItem.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v4, -1190056456, v15_1);
            Object v0_4 = v4.rememberedValue();
            if(v0_4 == Composer.Companion.getEmpty()) {
                MutableIntState v0_5 = SnapshotIntStateKt.mutableIntStateOf(0);
                v4.updateRememberedValue(v0_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            Object v11_1 = v0_4;
            Composer v7_1 = v4;
            int v28 = v5;
            int v54 = v12_1;
            Modifier v3_1 = SelectableKt.selectable-O2vRcR0(arg49, v1, arg53, null, arg50, Role.box-impl(Role.Companion.getTab-o7Vup1c()), arg34);
            ProvidableCompositionLocal v0_6 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            String v2_1 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v7_1, 0x789C5F52, v2_1);
            v0_4 = v7_1.consume(((CompositionLocal)v0_6));
            ComposerKt.sourceInformationMarkerEnd(v7_1);
            float v0_7 = ((Dp)v0_4).unbox-impl();
            ProvidableCompositionLocal v4_1 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            ComposerKt.sourceInformationMarkerStart(v7_1, 0x789C5F52, v2_1);
            Object v4_2 = v7_1.consume(((CompositionLocal)v4_1));
            ComposerKt.sourceInformationMarkerEnd(v7_1);
            v0_2 = SizeKt.defaultMinSize-VpY3zN4(v3_1, v0_7, ((Dp)v4_2).unbox-impl());
            ComposerKt.sourceInformationMarkerStart(v7_1, -1190038961, v15_1);
            Object v3_2 = v7_1.rememberedValue();
            if(v3_2 == Composer.Companion.getEmpty()) {
                NavigationItemKt$$ExternalSyntheticLambda3 v3_3 = new NavigationItemKt$$ExternalSyntheticLambda3(((MutableIntState)v11_1));
                v7_1.updateRememberedValue(v3_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v7_1);
            v0_2 = OnRemeasuredModifierKt.onSizeChanged(v0_2, ((Function1)v3_2));
            Alignment v3_4 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(v7_1, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v3_5 = BoxKt.maybeCachedBoxMeasurePolicy(v3_4, true);
            ComposerKt.sourceInformationMarkerStart(v7_1, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v5 = ComposablesKt.getCurrentCompositeKeyHash(v7_1, 0);
            CompositionLocalMap v4_3 = v7_1.getCurrentCompositionLocalMap();
            v0_2 = ComposedModifierKt.materializeModifier(v7_1, v0_2);
            Function0 v12_2 = ComposeUiNode.Companion.getConstructor();
            String v31 = v2_1;
            ComposerKt.sourceInformationMarkerStart(v7_1, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v7_1.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v7_1.startReusableNode();
            if(v7_1.getInserting()) {
                v7_1.createNode(v12_2);
            }
            else {
                v7_1.useNode();
            }

            Composer v2_2 = Updater.constructor-impl(v7_1);
            Updater.set-impl(v2_2, v3_5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v2_2, v4_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v3_6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v2_2.getInserting()) || !Intrinsics.areEqual(v2_2.rememberedValue(), Integer.valueOf(v5))) {
                v2_2.updateRememberedValue(Integer.valueOf(v5));
                v2_2.apply(Integer.valueOf(v5), v3_6);
            }

            Updater.set-impl(v2_2, v0_2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v7_1, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v7_1, 0x2880D28C, "C370@15561L41,375@15890L7,372@15651L261,378@15939L200,422@17712L54,425@17875L42,418@17458L1133:NavigationItem.kt#uh7d8r");
            boolean v6_1 = NavigationItemIconPosition.equals-impl0(v13, NavigationItemIconPosition.Companion.getTop--xw1Ddg());
            State v12_3 = NavigationItemKt.animateIndicatorProgressAsState(v1, v7_1, v28 & 14);
            v0_7 = v6_1 ? 0f : 1f;
            v21_1 = v7_1;
            State v7_2 = AnimateAsStateKt.animateFloatAsState(v0_7, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, v7_1, 6), 0f, null, null, v21_1, 0, 28);
            Composer v0_8 = v21_1;
            ComposerKt.sourceInformationMarkerStart(v0_8, 0xE0466A19, v15_1);
            Object v2_3 = v0_8.rememberedValue();
            if(v2_3 == Composer.Companion.getEmpty()) {
                v2_4 = SnapshotStateKt.derivedStateOf(new NavigationItemKt$$ExternalSyntheticLambda4(v6_1, v9, v10, v7_2));
                v0_8.updateRememberedValue(v2_4);
            }

            Object v5_1 = v2_4;
            ComposerKt.sourceInformationMarkerEnd(v0_8);
            if(arg51 != null) {
                v0_8.startReplaceGroup(680212713);
                ComposerKt.sourceInformation(v0_8, "386@16242L296");
                v16 = v6_1;
                v6_2 = v0_8;
                v9_1 = v31;
                v26 = 0;
                ComposableLambda v2_5 = ComposableLambdaKt.rememberComposableLambda(0x156F40D, true, new NavigationItemKt$AnimatedNavigationItem$2$styledLabel$1(v1, arg48, arg50, arg51, ((State)v5_1)), v6_2, 54);
                v6_2.endReplaceGroup();
                v19_1 = v2_5;
            }
            else {
                v16 = v6_1;
                v9_1 = v31;
                v26 = 0;
                v6_2 = v0_8;
                v6_2.startReplaceGroup(0x289023CD);
                v6_2.endReplaceGroup();
                Function2 v19_2 = null;
            }

            if(v16) {
                v6_2.startReplaceGroup(680694081);
                ComposerKt.sourceInformation(v6_2, "405@17000L7,413@17302L136");
                v0_6 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(v6_2, 0x789C5F52, v9_1);
                v0_4 = v6_2.consume(((CompositionLocal)v0_6));
                ComposerKt.sourceInformationMarkerEnd(v6_2);
                v0_9 = Offset.constructor-impl((((long)Float.floatToRawIntBits((((float)(NavigationItemKt.AnimatedNavigationItem_DQd_Gtc$lambda$12(((MutableIntState)v11_1)) - ((Density)v0_4).roundToPx-0680j_4(v8)))) / 2f))) << v24 | 0xFFFFFFFFL & (((long)Float.floatToRawIntBits(((Density)v0_4).toPx-0680j_4(NavigationItemKt.IndicatorVerticalOffset)))));
                ComposerKt.sourceInformationMarkerStart(v6_2, 0xE0471439, v15_1);
                if((v25 & 14) == 4) {
                    v26 = 1;
                }

                int v2_6 = v26 | v6_2.changed(v0_9);
                v3_2 = v6_2.rememberedValue();
                if(v2_6 != 0 || v3_2 == Composer.Companion.getEmpty()) {
                    MappedInteractionSource v3_7 = new MappedInteractionSource(arg53, v0_9, null);
                    v6_2.updateRememberedValue(v3_7);
                }

                v2_3 = v3_2;
                ComposerKt.sourceInformationMarkerEnd(v6_2);
                v6_2.endReplaceGroup();
            }
            else {
                v6_2.startReplaceGroup(0x289D9831);
                v6_2.endReplaceGroup();
                v2_3 = null;
            }

            if(v2_3 != null) {
            }
            else {
                v2 = arg53;
            }

            v11_1 = v2;
            v0_9 = arg48.getSelectedIndicatorColor-0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(v6_2, 0xE0474727, v15_1);
            boolean v2_7 = v6_2.changed(v12_3);
            v3_2 = v6_2.rememberedValue();
            if((v2_7) || v3_2 == Composer.Companion.getEmpty()) {
                v3_8 = new NavigationItemKt$$ExternalSyntheticLambda5(v12_3);
                v6_2.updateRememberedValue(v3_8);
            }

            ComposerKt.sourceInformationMarkerEnd(v6_2);
            ComposerKt.sourceInformationMarkerStart(v6_2, 0xE0475B7B, v15_1);
            v2_7 = v6_2.changed(v7_2);
            v4_2 = v6_2.rememberedValue();
            if((v2_7) || v4_2 == Composer.Companion.getEmpty()) {
                v4_4 = new NavigationItemKt$$ExternalSyntheticLambda6(v7_2);
                v6_2.updateRememberedValue(v4_4);
            }

            Object v18_1 = v4_4;
            ComposerKt.sourceInformationMarkerEnd(v6_2);
            int v4_5 = v28 << 3;
            int v29 = v28 >> 3 & 0x380 | 0x6000 | v54 >> 12 & 0x70000 | 0xE000000 & v4_5 | v4_5 & 0x70000000;
            v4_5 = v54 << 3;
            NavigationItemKt.AnimatedNavigationItemLayout-he0WsC4(((InteractionSource)v11_1), v0_9, arg36, v3_8, v14_2, v13, ((Function0)v18_1), ((Function2)v19_1), arg40, arg41, arg42, arg43, arg44, arg45, arg46, arg47, v6_2, v29, v28 >> 27 & 14 | v4_5 & 0x70 | v4_5 & 0x380 | v4_5 & 0x1C00 | 0xE000 & v4_5 | v4_5 & 0x70000);
            v21_1 = v6_2;
            ComposerKt.sourceInformationMarkerEnd(v21_1);
            ComposerKt.sourceInformationMarkerEnd(v21_1);
            v21_1.endNode();
            ComposerKt.sourceInformationMarkerEnd(v21_1);
            ComposerKt.sourceInformationMarkerEnd(v21_1);
            ComposerKt.sourceInformationMarkerEnd(v21_1);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_571;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v21_1 = v4;
            v21_1.skipToGroupEnd();
        }

    label_571:
        ScopeUpdateScope v0_10 = v21_1.endRestartGroup();
        if(v0_10 != null) {
            v0_10.updateScope(new NavigationItemKt$$ExternalSyntheticLambda7(arg33, arg34, arg35, arg36, v8, arg38, v10, arg40, arg41, arg42, arg43, arg44, arg45, arg46, arg47, arg48, arg49, arg50, arg51, arg52, arg53, arg55, arg56, arg57));
        }
    }

    private static final void AnimatedNavigationItemLayout-he0WsC4(InteractionSource arg33, long arg34, Shape arg36, Function0 arg37, Function2 arg38, int arg39, Function0 arg40, Function2 arg41, float arg42, float arg43, float arg44, float arg45, float arg46, float arg47, float arg48, float arg49, Composer arg50, int arg51, int arg52) {
        AnimatedMeasurePolicy v20_1;
        int v23;
        int v22;
        int v21;
        int v5;
        int v20;
        Function0 v11_1;
        int v11;
        int v3;
        InteractionSource v1 = arg33;
        Shape v4 = arg36;
        Function2 v0 = arg38;
        Function2 v9 = arg41;
        int v8 = arg51;
        int v10 = arg52;
        Composer v6 = arg50.startRestartGroup(0x5A0F07E);
        ComposerKt.sourceInformation(v6, "C(AnimatedNavigationItemLayout)N(interactionSource,indicatorColor:c#ui.graphics.Color,indicatorShape,indicatorAnimationProgress,icon,iconPosition:c#material3.NavigationItemIconPosition,iconPositionProgress,label,topIconIndicatorHorizontalPadding:c#ui.unit.Dp,topIconIndicatorVerticalPadding:c#ui.unit.Dp,topIconIndicatorToLabelVerticalPadding:c#ui.unit.Dp,startIconIndicatorHorizontalPadding:c#ui.unit.Dp,startIconIndicatorVerticalPadding:c#ui.unit.Dp,noLabelIndicatorPadding:c#ui.unit.Dp,startIconToLabelHorizontalPadding:c#ui.unit.Dp,itemHorizontalPadding:c#ui.unit.Dp)509@21184L2129:NavigationItem.kt#uh7d8r");
        if((v8 & 6) == 0) {
            v3 = v6.changed(v1) ? 4 : 2;
            v3 |= v8;
        }
        else {
            v3 = v8;
        }

        long v14 = arg34;
        if((v8 & 0x30) == 0) {
            v11 = v6.changed(v14) ? 0x20 : 16;
            v3 |= v11;
        }

        int v16 = 0x100;
        int v17 = 0x80;
        if((v8 & 0x180) == 0) {
            v11 = v6.changed(v4) ? v16 : v17;
            v3 |= v11;
        }

        int v18 = 0x800;
        int v19 = 0x400;
        if((v8 & 0xC00) == 0) {
            v11_1 = arg37;
            v20 = v6.changedInstance(v11_1) ? v18 : v19;
            v3 |= v20;
        }
        else {
            v11_1 = arg37;
        }

        v20 = 0x2000;
        if((v8 & 0x6000) == 0) {
            v5 = v6.changedInstance(v0) ? 0x4000 : v20;
            v3 |= v5;
        }

        v5 = 0x30000;
        if((v8 & v5) == 0) {
            v21 = v5;
            v22 = v6.changed(arg39) ? 0x20000 : 0x10000;
            v3 |= v22;
        }
        else {
            v21 = v5;
        }

        Function0 v7 = arg40;
        if((v8 & 0x180000) == 0) {
            v23 = v6.changedInstance(v7) ? 0x100000 : 0x80000;
            v3 |= v23;
        }

        if((v8 & 0xC00000) == 0) {
            v23 = v6.changedInstance(v9) ? 0x800000 : 0x400000;
            v3 |= v23;
        }

        float v12 = arg42;
        if((v8 & 0x6000000) == 0) {
            int v24 = v6.changed(v12) ? 0x4000000 : 0x2000000;
            v3 |= v24;
        }

        float v13 = arg43;
        if((v8 & 0x30000000) == 0) {
            int v25 = v6.changed(v13) ? 0x20000000 : 0x10000000;
            v3 |= v25;
        }

        float v2 = arg44;
        if((v10 & 6) == 0) {
            v22 = v6.changed(v2) ? 4 : 2;
            v22 |= v10;
        }
        else {
            v22 = v10;
        }

        v2 = arg45;
        if((v10 & 0x30) == 0) {
            v23 = v6.changed(v2) ? 0x20 : 16;
            v22 |= v23;
        }

        if((v10 & 0x180) == 0) {
            if(v6.changed(arg46)) {
            }
            else {
                v16 = v17;
            }

            v22 |= v16;
        }

        if((v10 & 0xC00) == 0) {
            if(v6.changed(arg47)) {
            }
            else {
                v18 = v19;
            }

            v22 |= v18;
        }

        if((v10 & 0x6000) == 0) {
            if(v6.changed(arg48)) {
                v20 = 0x4000;
            }

            v22 |= v20;
        }

        v2 = arg49;
        if((v10 & v21) == 0) {
            v16 = v6.changed(v2) ? 0x20000 : 0x10000;
            v22 |= v16;
        }

        int v2_1 = v22;
        boolean v5_1 = (v3 & 306783379) != 306783378 || (74899 & v2_1) != 74898 ? true : false;
        if(v6.shouldExecute(v5_1, v3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x5A0F07E, v3, v2_1, "androidx.compose.material3.AnimatedNavigationItemLayout (NavigationItem.kt:508)");
            }

            Modifier v2_2 = BadgeKt.badgeBounds(Modifier.Companion);
            if(v9 != null) {
                v20_1 = new AnimatedMeasurePolicy(arg39, arg40, v11_1, v12, v13, arg44, arg45, arg46, arg48, arg49, null);
            }
            else {
                TopIconOrIconOnlyMeasurePolicy v20_2 = new TopIconOrIconOnlyMeasurePolicy(false, arg37, arg47, arg47, Dp.constructor-impl(0f), Dp.constructor-impl(0f), null);
            }

            AnimatedMeasurePolicy v5_2 = v20_1;
            String v12_1 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v6, -1323940314, v12_1);
            int v7_1 = ComposablesKt.getCurrentCompositeKeyHash(v6, 0);
            CompositionLocalMap v13_1 = v6.getCurrentCompositionLocalMap();
            v2_2 = ComposedModifierKt.materializeModifier(v6, v2_2);
            v11_1 = ComposeUiNode.Companion.getConstructor();
            String v10_1 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v6, 0xD6BD0031, v10_1);
            if(!(v6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v6.startReusableNode();
            if(v6.getInserting()) {
                v6.createNode(v11_1);
            }
            else {
                v6.useNode();
            }

            Composer v8_1 = Updater.constructor-impl(v6);
            Updater.set-impl(v8_1, v5_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v8_1, v13_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v5_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v8_1.getInserting()) || !Intrinsics.areEqual(v8_1.rememberedValue(), Integer.valueOf(v7_1))) {
                v8_1.updateRememberedValue(Integer.valueOf(v7_1));
                v8_1.apply(Integer.valueOf(v7_1), v5_3);
            }

            Updater.set-impl(v8_1, v2_2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v6, 0xC51703A5, "C513@21311L50,516@21564L69,518@21647L50:NavigationItem.kt#uh7d8r");
            v5 = v3 >> 3;
            NavigationItemKt.IndicatorRipple(v1, v4, v6, v3 & 14 | v5 & 0x70);
            v8 = v3;
            NavigationItemKt.Indicator-3J-VO9M(v14, v4, arg37, v6, v5 & 0x3FE);
            v2_2 = LayoutIdKt.layoutId(Modifier.Companion, "icon");
            ComposerKt.sourceInformationMarkerStart(v6, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v3_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v6, -1323940314, v12_1);
            v5 = ComposablesKt.getCurrentCompositeKeyHash(v6, 0);
            CompositionLocalMap v4_1 = v6.getCurrentCompositionLocalMap();
            v2_2 = ComposedModifierKt.materializeModifier(v6, v2_2);
            v7 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v6, 0xD6BD0031, v10_1);
            if(!(v6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v6.startReusableNode();
            if(v6.getInserting()) {
                v6.createNode(v7);
            }
            else {
                v6.useNode();
            }

            Composer v7_2 = Updater.constructor-impl(v6);
            Updater.set-impl(v7_2, v3_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v7_2, v4_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v3_2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v7_2.getInserting()) || !Intrinsics.areEqual(v7_2.rememberedValue(), Integer.valueOf(v5))) {
                v7_2.updateRememberedValue(Integer.valueOf(v5));
                v7_2.apply(Integer.valueOf(v5), v3_2);
            }

            Updater.set-impl(v7_2, v2_2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v6, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v6, 0xAB9297FC, "C518@21689L6:NavigationItem.kt#uh7d8r");
            v0.invoke(v6, Integer.valueOf(v8 >> 12 & 14));
            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerEnd(v6);
            v6.endNode();
            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerEnd(v6);
            if(v9 != null) {
                v6.startReplaceGroup(0xC51D2887);
                ComposerKt.sourceInformation(v6, "521@21748L52");
                v2_2 = LayoutIdKt.layoutId(Modifier.Companion, "label");
                ComposerKt.sourceInformationMarkerStart(v6, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                v3_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v6, -1323940314, v12_1);
                int v4_2 = ComposablesKt.getCurrentCompositeKeyHash(v6, 0);
                CompositionLocalMap v5_4 = v6.getCurrentCompositionLocalMap();
                v2_2 = ComposedModifierKt.materializeModifier(v6, v2_2);
                v7 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v6, 0xD6BD0031, v10_1);
                if(!(v6.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v6.startReusableNode();
                if(v6.getInserting()) {
                    v6.createNode(v7);
                }
                else {
                    v6.useNode();
                }

                v7_2 = Updater.constructor-impl(v6);
                Updater.set-impl(v7_2, v3_1, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v7_2, v5_4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                v3_2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v7_2.getInserting()) || !Intrinsics.areEqual(v7_2.rememberedValue(), Integer.valueOf(v4_2))) {
                    v7_2.updateRememberedValue(Integer.valueOf(v4_2));
                    v7_2.apply(Integer.valueOf(v4_2), v3_2);
                }

                Updater.set-impl(v7_2, v2_2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v6, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(v6, 0x96007B6, "C521@21791L7:NavigationItem.kt#uh7d8r");
                v9.invoke(v6, Integer.valueOf(v8 >> 21 & 14));
                ComposerKt.sourceInformationMarkerEnd(v6);
                ComposerKt.sourceInformationMarkerEnd(v6);
                v6.endNode();
                ComposerKt.sourceInformationMarkerEnd(v6);
                ComposerKt.sourceInformationMarkerEnd(v6);
                ComposerKt.sourceInformationMarkerEnd(v6);
                v6.endReplaceGroup();
            }
            else {
                v6.startReplaceGroup(-987864101);
                v6.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            v6.endNode();
            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerEnd(v6);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_434;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v6.skipToGroupEnd();
        }

    label_434:
        ScopeUpdateScope v2_3 = v6.endRestartGroup();
        if(v2_3 != null) {
            v2_3.updateScope(new NavigationItemKt$$ExternalSyntheticLambda14(v1, arg34, arg36, arg37, arg38, arg39, arg40, v9, arg42, arg43, arg44, arg45, arg46, arg47, arg48, arg49, arg51, arg52));
        }
    }

    static final Unit AnimatedNavigationItemLayout_he0WsC4$lambda$35(InteractionSource arg21, long arg22, Shape arg24, Function0 arg25, Function2 arg26, int arg27, Function0 arg28, Function2 arg29, float arg30, float arg31, float arg32, float arg33, float arg34, float arg35, float arg36, float arg37, int arg38, int arg39, Composer arg40, int arg41) {
        NavigationItemKt.AnimatedNavigationItemLayout-he0WsC4(arg21, arg22, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg40, RecomposeScopeImplKt.updateChangedFlags(arg38 | 1), RecomposeScopeImplKt.updateChangedFlags(arg39));
        return Unit.INSTANCE;
    }

    private static final int AnimatedNavigationItem_DQd_Gtc$lambda$12(MutableIntState arg0) {
        return ((IntState)arg0).getIntValue();
    }

    private static final void AnimatedNavigationItem_DQd_Gtc$lambda$13(MutableIntState arg0, int arg1) {
        arg0.setIntValue(arg1);
    }

    static final Unit AnimatedNavigationItem_DQd_Gtc$lambda$15$lambda$14(MutableIntState arg2, IntSize arg3) {
        NavigationItemKt.AnimatedNavigationItem_DQd_Gtc$lambda$13(arg2, ((int)(arg3.unbox-impl() >> 0x20)));
        return Unit.INSTANCE;
    }

    private static final float AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$16(State arg0) {
        return arg0.getValue().floatValue();
    }

    static final TextStyle AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$18$lambda$17(boolean arg0, TextStyle arg1, TextStyle arg2, State arg3) {
        if((arg0) && NavigationItemKt.AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$16(arg3) < 0.5f) {
            return arg1;
        }

        return arg2;
    }

    private static final TextStyle AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$19(State arg0) {
        return arg0.getValue();
    }

    static final float AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$23$lambda$22(State arg1) {
        return RangesKt.coerceAtLeast(arg1.getValue().floatValue(), 0f);
    }

    static final float AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$25$lambda$24(State arg1) {
        return RangesKt.coerceAtLeast(NavigationItemKt.AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$16(arg1), 0f);
    }

    static final Unit AnimatedNavigationItem_DQd_Gtc$lambda$27(boolean arg26, Function0 arg27, Function2 arg28, Shape arg29, float arg30, TextStyle arg31, TextStyle arg32, float arg33, float arg34, float arg35, float arg36, float arg37, float arg38, float arg39, float arg40, NavigationItemColors arg41, Modifier arg42, boolean arg43, Function2 arg44, int arg45, MutableInteractionSource arg46, int arg47, int arg48, int arg49, Composer arg50, int arg51) {
        NavigationItemKt.AnimatedNavigationItem-DQd_Gtc(arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg45, arg46, arg50, RecomposeScopeImplKt.updateChangedFlags(arg47 | 1), RecomposeScopeImplKt.updateChangedFlags(arg48), RecomposeScopeImplKt.updateChangedFlags(arg49));
        return Unit.INSTANCE;
    }

    private static final void Indicator-3J-VO9M(long arg7, Shape arg9, Function0 arg10, Composer arg11, int arg12) {
        int v2;
        int v1;
        int v0 = 0xEFB48343;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(Indicator)N(indicatorColor:c#ui.graphics.Color,indicatorShape,indicatorAnimationProgress)1117@46816L40,1115@46736L198:NavigationItem.kt#uh7d8r");
        if((arg12 & 6) == 0) {
            v1 = arg11.changed(arg7) ? 4 : 2;
            v1 |= arg12;
        }
        else {
            v1 = arg12;
        }

        if((arg12 & 0x30) == 0) {
            v2 = arg11.changed(arg9) ? 0x20 : 16;
            v1 |= v2;
        }

        int v3 = 0x100;
        if((arg12 & 0x180) == 0) {
            v2 = arg11.changedInstance(arg10) ? v3 : 0x80;
            v1 |= v2;
        }

        int v5 = 1;
        boolean v2_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg11.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.Indicator (NavigationItem.kt:1114)");
            }

            Modifier v0_1 = LayoutIdKt.layoutId(Modifier.Companion, "indicator");
            ComposerKt.sourceInformationMarkerStart(arg11, 0xD4A0DA6B, "CC(remember):NavigationItem.kt#9igjgp");
            if((v1 & 0x380) == v3) {
            }
            else {
                v5 = 0;
            }

            Object v1_1 = arg11.rememberedValue();
            if(v5 != 0 || v1_1 == Composer.Companion.getEmpty()) {
                NavigationItemKt$$ExternalSyntheticLambda12 v1_2 = new NavigationItemKt$$ExternalSyntheticLambda12(arg10);
                arg11.updateRememberedValue(v1_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg11);
            BoxKt.Box(BackgroundKt.background-bw27NRU(GraphicsLayerModifierKt.graphicsLayer(v0_1, ((Function1)v1_1)), arg7, arg9), arg11, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_74;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_74:
        ScopeUpdateScope v11 = arg11.endRestartGroup();
        if(v11 != null) {
            v11.updateScope(new NavigationItemKt$$ExternalSyntheticLambda13(arg7, arg9, arg10, arg12));
        }
    }

    private static final void IndicatorRipple(InteractionSource arg11, Shape arg12, Composer arg13, int arg14) {
        int v1;
        int v0 = -629069867;
        arg13 = arg13.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg13, "C(IndicatorRipple)N(interactionSource,indicatorShape)1102@46439L151:NavigationItem.kt#uh7d8r");
        if((arg14 & 6) == 0) {
            v1 = arg13.changed(arg11) ? 4 : 2;
            v1 |= arg14;
        }
        else {
            v1 = arg14;
        }

        if((arg14 & 0x30) == 0) {
            int v2 = arg13.changed(arg12) ? 0x20 : 16;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 19) != 18 ? true : false;
        if(arg13.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.IndicatorRipple (NavigationItem.kt:1101)");
            }

            BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.Companion, "indicatorRipple"), arg12), arg11, RippleKt.ripple-H2RKhps$default(false, 0f, 0, 7, null)), arg13, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_54;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg13.skipToGroupEnd();
        }

    label_54:
        ScopeUpdateScope v13 = arg13.endRestartGroup();
        if(v13 != null) {
            v13.updateScope(new NavigationItemKt$$ExternalSyntheticLambda16(arg11, arg12, arg14));
        }
    }

    static final Unit IndicatorRipple$lambda$42(InteractionSource arg0, Shape arg1, int arg2, Composer arg3, int arg4) {
        NavigationItemKt.IndicatorRipple(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit Indicator_3J_VO9M$lambda$44$lambda$43(Function0 arg0, GraphicsLayerScope arg1) {
        arg1.setAlpha(arg0.invoke().floatValue());
        return Unit.INSTANCE;
    }

    static final Unit Indicator_3J_VO9M$lambda$45(long arg6, Shape arg8, Function0 arg9, int arg10, Composer arg11, int arg12) {
        NavigationItemKt.Indicator-3J-VO9M(arg6, arg8, arg9, arg11, RecomposeScopeImplKt.updateChangedFlags(arg10 | 1));
        return Unit.INSTANCE;
    }

    public static final void NavigationItem-8Df7sds(boolean arg26, Function0 arg27, Function2 arg28, TextStyle arg29, Shape arg30, float arg31, float arg32, float arg33, float arg34, float arg35, float arg36, NavigationItemColors arg37, Modifier arg38, boolean arg39, Function2 arg40, int arg41, MutableInteractionSource arg42, Composer arg43, int arg44, int arg45) {
        Composer v22_1;
        NavigationItemKt$$ExternalSyntheticLambda10 v6_4;
        Object v2_4;
        MutableIntState v0_3;
        ComposableLambda v19_1;
        int v12_1;
        int v0;
        int v23;
        int v22;
        int v21;
        int v18;
        Function0 v13;
        int v2;
        boolean v1 = arg26;
        Function2 v7 = arg28;
        float v8 = arg31;
        NavigationItemColors v12 = arg37;
        boolean v4 = arg39;
        Function2 v15 = arg40;
        int v14 = arg41;
        MutableInteractionSource v6 = arg42;
        int v9 = arg44;
        int v10 = arg45;
        Composer v11 = arg43.startRestartGroup(0x7BB05BDA);
        ComposerKt.sourceInformation(v11, "C(NavigationItem)N(selected,onClick,icon,labelTextStyle,indicatorShape,indicatorWidth:c#ui.unit.Dp,indicatorHorizontalPadding:c#ui.unit.Dp,indicatorVerticalPadding:c#ui.unit.Dp,indicatorToLabelVerticalPadding:c#ui.unit.Dp,startIconToLabelHorizontalPadding:c#ui.unit.Dp,topIconItemVerticalPadding:c#ui.unit.Dp,colors,modifier,enabled,label,iconPosition:c#material3.NavigationItemIconPosition,interactionSource)247@10748L94,257@11065L33,270@11488L7,271@11562L7,273@11612L24,259@11104L2381:NavigationItem.kt#uh7d8r");
        if((v9 & 6) == 0) {
            v2 = v11.changed(v1) ? 4 : 2;
            v2 |= v9;
        }
        else {
            v2 = v9;
        }

        int v16 = 16;
        int v17 = 0x20;
        if((v9 & 0x30) == 0) {
            v13 = arg27;
            v18 = v11.changedInstance(v13) ? v17 : v16;
            v2 |= v18;
        }
        else {
            v13 = arg27;
        }

        v18 = 0x100;
        int v19 = 0x80;
        if((v9 & 0x180) == 0) {
            int v3 = v11.changedInstance(v7) ? v18 : v19;
            v2 |= v3;
        }

        int v20 = 0x400;
        if((v9 & 0xC00) == 0) {
            v21 = v11.changed(arg29) ? 0x800 : v20;
            v2 |= v21;
        }

        if((v9 & 0x6000) == 0) {
            v22 = v11.changed(arg30) ? 0x4000 : 0x2000;
            v2 |= v22;
        }

        v22 = 0x30000;
        if((v9 & v22) == 0) {
            v23 = v11.changed(v8) ? 0x20000 : 0x10000;
            v2 |= v23;
        }

        v23 = v9 & 0x180000;
        float v9_1 = arg32;
        if(v23 == 0) {
            v23 = v11.changed(v9_1) ? 0x100000 : 0x80000;
            v2 |= v23;
        }

        v9_1 = arg33;
        if((arg44 & 0xC00000) == 0) {
            v23 = v11.changed(v9_1) ? 0x800000 : 0x400000;
            v2 |= v23;
        }

        v9_1 = arg34;
        if((arg44 & 0x6000000) == 0) {
            v23 = v11.changed(v9_1) ? 0x4000000 : 0x2000000;
            v2 |= v23;
        }

        v9_1 = arg35;
        if((arg44 & 0x30000000) == 0) {
            v23 = v11.changed(v9_1) ? 0x20000000 : 0x10000000;
            v2 |= v23;
        }

        v9_1 = arg36;
        if((v10 & 6) == 0) {
            v21 = v11.changed(v9_1) ? 4 : 2;
            v21 |= v10;
        }
        else {
            v21 = v10;
        }

        if((v10 & 0x30) == 0) {
            if(v11.changed(v12)) {
                v16 = v17;
            }

            v21 |= v16;
        }

        if((v10 & 0x180) == 0) {
            if(v11.changed(arg38)) {
            }
            else {
                v18 = v19;
            }

            v21 |= v18;
        }

        if((v10 & 0xC00) == 0) {
            if(v11.changed(v4)) {
                v20 = 0x800;
            }

            v21 |= v20;
        }

        if((v10 & 0x6000) == 0) {
            v0 = v11.changedInstance(v15) ? 0x4000 : 0x2000;
            v21 |= v0;
        }

        if((v10 & v22) == 0) {
            v0 = v11.changed(v14) ? 0x20000 : 0x10000;
            v21 |= v0;
        }

        if((0x180000 & v10) == 0) {
            v0 = v11.changed(v6) ? 0x100000 : 0x80000;
            v21 |= v0;
        }

        v0 = v21;
        boolean v3_1 = (v2 & 306783379) != 306783378 || (0x92493 & v0) != 0x92492 ? true : false;
        if(v11.shouldExecute(v3_1, v2 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x7BB05BDA, v2, v0, "androidx.compose.material3.NavigationItem (NavigationItem.kt:245)");
            }

            ComposableLambda v9_2 = ComposableLambdaKt.rememberComposableLambda(0x42BFD700, true, new NavigationItemKt$NavigationItem$styledIcon$1(v12.iconColor-WaAFU9c(v1, v4), v7), v11, 54);
            if(v15 == null) {
                v11.startReplaceGroup(-803302356);
                v11.endReplaceGroup();
                v21 = v0;
                v12_1 = v2;
                v19_1 = null;
            }
            else {
                v11.startReplaceGroup(0xD01F1F4F);
                ComposerKt.sourceInformation(v11, "254@10967L65");
                v21 = v0;
                NavigationItemColors v3_2 = v12;
                v12_1 = v2;
                ComposableLambda v0_1 = ComposableLambdaKt.rememberComposableLambda(0x3F4FFAA7, true, new NavigationItemKt$NavigationItem$styledLabel$1(v1, arg29, v3_2, v4, v15), v11, 54);
                v11.endReplaceGroup();
                v19_1 = v0_1;
            }

            String v1_1 = "CC(remember):NavigationItem.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v11, 0x510950DB, v1_1);
            Object v0_2 = v11.rememberedValue();
            if(v0_2 == Composer.Companion.getEmpty()) {
                v0_3 = SnapshotIntStateKt.mutableIntStateOf(0);
                v11.updateRememberedValue(v0_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            String v10_1 = v1_1;
            MutableInteractionSource v2_1 = v6;
            Function0 v6_1 = v13;
            v1 = arg26;
            Object v13_1 = v0_3;
            Modifier v3_3 = SelectableKt.selectable-O2vRcR0(arg38, v1, v2_1, null, arg39, Role.box-impl(Role.Companion.getTab-o7Vup1c()), v6_1);
            ProvidableCompositionLocal v0_4 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            String v4_1 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v11, 0x789C5F52, v4_1);
            v0_2 = v11.consume(((CompositionLocal)v0_4));
            ComposerKt.sourceInformationMarkerEnd(v11);
            float v0_5 = ((Dp)v0_2).unbox-impl();
            ProvidableCompositionLocal v5 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            ComposerKt.sourceInformationMarkerStart(v11, 0x789C5F52, v4_1);
            Object v5_1 = v11.consume(((CompositionLocal)v5));
            ComposerKt.sourceInformationMarkerEnd(v11);
            Modifier v0_6 = SizeKt.defaultMinSize-VpY3zN4(v3_3, v0_5, ((Dp)v5_1).unbox-impl());
            ComposerKt.sourceInformationMarkerStart(v11, 0x51099532, v10_1);
            Object v3_4 = v11.rememberedValue();
            if(v3_4 == Composer.Companion.getEmpty()) {
                NavigationItemKt$$ExternalSyntheticLambda0 v3_5 = new NavigationItemKt$$ExternalSyntheticLambda0(((MutableIntState)v13_1));
                v11.updateRememberedValue(v3_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            v0_6 = OnRemeasuredModifierKt.onSizeChanged(v0_6, ((Function1)v3_4));
            Alignment v3_6 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(v11, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v3_7 = BoxKt.maybeCachedBoxMeasurePolicy(v3_6, true);
            ComposerKt.sourceInformationMarkerStart(v11, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int v6_2 = ComposablesKt.getCurrentCompositeKeyHash(v11, 0);
            CompositionLocalMap v5_2 = v11.getCurrentCompositionLocalMap();
            v0_6 = ComposedModifierKt.materializeModifier(v11, v0_6);
            Function0 v15_1 = ComposeUiNode.Companion.getConstructor();
            v23 = v6_2;
            ComposerKt.sourceInformationMarkerStart(v11, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v11.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v11.startReusableNode();
            if(v11.getInserting()) {
                v11.createNode(v15_1);
            }
            else {
                v11.useNode();
            }

            Composer v2_2 = Updater.constructor-impl(v11);
            Updater.set-impl(v2_2, v3_7, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v2_2, v5_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v3_8 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v2_2.getInserting()) || !Intrinsics.areEqual(v2_2.rememberedValue(), Integer.valueOf(v23))) {
                v2_2.updateRememberedValue(Integer.valueOf(v23));
                v2_2.apply(Integer.valueOf(v23), v3_8);
            }

            Updater.set-impl(v2_2, v0_6, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v11, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v11, 0x1CE22C17, "C277@11772L41,304@13049L54,297@12698L781:NavigationItem.kt#uh7d8r");
            State v0_7 = NavigationItemKt.animateIndicatorProgressAsState(v1, v11, v12_1 & 14);
            if(NavigationItemIconPosition.equals-impl0(v14, NavigationItemIconPosition.Companion.getTop--xw1Ddg())) {
                v11.startReplaceGroup(0x1CE4CA19);
                ComposerKt.sourceInformation(v11, "284@12247L7,292@12542L136");
                ProvidableCompositionLocal v2_3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(v11, 0x789C5F52, v4_1);
                v2_4 = v11.consume(((CompositionLocal)v2_3));
                ComposerKt.sourceInformationMarkerEnd(v11);
                long v2_5 = Offset.constructor-impl((((long)Float.floatToRawIntBits((((float)(NavigationItemKt.NavigationItem_8Df7sds$lambda$1(((MutableIntState)v13_1)) - ((Density)v2_4).roundToPx-0680j_4(v8)))) / 2f))) << v17 | (((long)Float.floatToRawIntBits(((Density)v2_4).toPx-0680j_4(NavigationItemKt.IndicatorVerticalOffset)))) & 0xFFFFFFFFL);
                ComposerKt.sourceInformationMarkerStart(v11, -1092722808, v10_1);
                v16 = (v21 & 0x380000) == 0x100000 ? 1 : 0;
                int v4_2 = v16 | v11.changed(v2_5);
                v5_1 = v11.rememberedValue();
                if(v4_2 != 0 || v5_1 == Composer.Companion.getEmpty()) {
                    MappedInteractionSource v5_3 = new MappedInteractionSource(arg42, v2_5, null);
                    v11.updateRememberedValue(v5_3);
                }

                v2_4 = v5_1;
                ComposerKt.sourceInformationMarkerEnd(v11);
                v11.endReplaceGroup();
            }
            else {
                v11.startReplaceGroup(0x1CEFB6C2);
                v11.endReplaceGroup();
                v2_4 = null;
            }

            if(v2_4 != null) {
            }
            else {
                v2_1 = arg42;
            }

            long v3_9 = arg37.getSelectedIndicatorColor-0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(v11, -1092706666, v10_1);
            boolean v5_4 = v11.changed(v0_7);
            Object v6_3 = v11.rememberedValue();
            if((v5_4) || v6_3 == Composer.Companion.getEmpty()) {
                v6_4 = new NavigationItemKt$$ExternalSyntheticLambda10(v0_7);
                v11.updateRememberedValue(v6_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            int v5_5 = v12_1 << 3;
            v22_1 = v11;
            NavigationItemKt.NavigationItemLayout-KmRX-Dg(v2_4, v3_9, arg30, v9_2, v14, v19_1, v6_4, arg32, arg33, arg34, arg35, arg36, v22_1, v12_1 >> 6 & 0x380 | 0xC00 | v21 >> 3 & 0xE000 | 0x1C00000 & v5_5 | 0xE000000 & v5_5 | v5_5 & 0x70000000, v12_1 >> 27 & 14 | v21 << 3 & 0x70);
            ComposerKt.sourceInformationMarkerEnd(v22_1);
            ComposerKt.sourceInformationMarkerEnd(v22_1);
            v22_1.endNode();
            ComposerKt.sourceInformationMarkerEnd(v22_1);
            ComposerKt.sourceInformationMarkerEnd(v22_1);
            ComposerKt.sourceInformationMarkerEnd(v22_1);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_466;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v22_1 = v11;
            v22_1.skipToGroupEnd();
        }

    label_466:
        ScopeUpdateScope v0_8 = v22_1.endRestartGroup();
        if(v0_8 != null) {
            v0_8.updateScope(new NavigationItemKt$$ExternalSyntheticLambda11(v1, arg27, v7, arg29, arg30, v8, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg44, arg45));
        }
    }

    private static final void NavigationItemLayout-KmRX-Dg(InteractionSource arg24, long arg25, Shape arg27, Function2 arg28, int arg29, Function2 arg30, Function0 arg31, float arg32, float arg33, float arg34, float arg35, float arg36, Composer arg37, int arg38, int arg39) {
        TopIconOrIconOnlyMeasurePolicy v15_2;
        int v18;
        int v16;
        Function0 v13_1;
        int v13;
        int v3;
        InteractionSource v1 = arg24;
        Shape v4 = arg27;
        Function2 v0 = arg28;
        int v8 = arg29;
        Function2 v9 = arg30;
        int v14 = arg38;
        Composer v6 = arg37.startRestartGroup(-1473868071);
        ComposerKt.sourceInformation(v6, "C(NavigationItemLayout)N(interactionSource,indicatorColor:c#ui.graphics.Color,indicatorShape,icon,iconPosition:c#material3.NavigationItemIconPosition,label,indicatorAnimationProgress,indicatorHorizontalPadding:c#ui.unit.Dp,indicatorVerticalPadding:c#ui.unit.Dp,indicatorToLabelVerticalPadding:c#ui.unit.Dp,startIconToLabelHorizontalPadding:c#ui.unit.Dp,topIconItemVerticalPadding:c#ui.unit.Dp)454@19104L1389:NavigationItem.kt#uh7d8r");
        if((v14 & 6) == 0) {
            v3 = v6.changed(v1) ? 4 : 2;
            v3 |= v14;
        }
        else {
            v3 = v14;
        }

        long v11 = arg25;
        if((v14 & 0x30) == 0) {
            v13 = v6.changed(v11) ? 0x20 : 16;
            v3 |= v13;
        }

        if((v14 & 0x180) == 0) {
            v13 = v6.changed(v4) ? 0x100 : 0x80;
            v3 |= v13;
        }

        if((v14 & 0xC00) == 0) {
            v13 = v6.changedInstance(v0) ? 0x800 : 0x400;
            v3 |= v13;
        }

        if((v14 & 0x6000) == 0) {
            v13 = v6.changed(v8) ? 0x4000 : 0x2000;
            v3 |= v13;
        }

        if((0x30000 & v14) == 0) {
            v13 = v6.changedInstance(v9) ? 0x20000 : 0x10000;
            v3 |= v13;
        }

        if((0x180000 & v14) == 0) {
            v13_1 = arg31;
            int v15 = v6.changedInstance(v13_1) ? 0x100000 : 0x80000;
            v3 |= v15;
        }
        else {
            v13_1 = arg31;
        }

        if((0xC00000 & v14) == 0) {
            v16 = v6.changed(arg32) ? 0x800000 : 0x400000;
            v3 |= v16;
        }

        float v5 = arg33;
        if((v14 & 0x6000000) == 0) {
            int v17 = v6.changed(v5) ? 0x4000000 : 0x2000000;
            v3 |= v17;
        }

        float v7 = arg34;
        if((v14 & 0x30000000) == 0) {
            v18 = v6.changed(v7) ? 0x20000000 : 0x10000000;
            v3 |= v18;
        }

        float v10 = arg35;
        if((arg39 & 6) == 0) {
            v16 = v6.changed(v10) ? 4 : 2;
            v16 |= arg39;
        }
        else {
            v16 = arg39;
        }

        float v2 = arg36;
        if((arg39 & 0x30) == 0) {
            v18 = v6.changed(v2) ? 0x20 : 16;
            v16 |= v18;
        }

        int v2_1 = v16;
        boolean v16_1 = true;
        boolean v5_1 = (v3 & 306783379) != 306783378 || (v2_1 & 19) != 18 ? true : false;
        if(v6.shouldExecute(v5_1, v3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1473868071, v3, v2_1, "androidx.compose.material3.NavigationItemLayout (NavigationItem.kt:453)");
            }

            Modifier v2_2 = BadgeKt.badgeBounds(Modifier.Companion);
            if(v9 == null || (NavigationItemIconPosition.equals-impl0(v8, NavigationItemIconPosition.Companion.getTop--xw1Ddg()))) {
                if(v9 != null) {
                }
                else {
                    v16_1 = false;
                }

                v15_2 = new TopIconOrIconOnlyMeasurePolicy(v16_1, arg31, arg32, arg33, arg34, arg36, null);
            }
            else {
                StartIconMeasurePolicy v15_1 = new StartIconMeasurePolicy(v13_1, arg32, arg33, arg35, null);
            }

            String v5_2 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v6, -1323940314, v5_2);
            int v7_1 = ComposablesKt.getCurrentCompositeKeyHash(v6, 0);
            CompositionLocalMap v13_2 = v6.getCurrentCompositionLocalMap();
            v2_2 = ComposedModifierKt.materializeModifier(v6, v2_2);
            Function0 v10_1 = ComposeUiNode.Companion.getConstructor();
            v8 = 0xD6BD0031;
            String v11_1 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v6, v8, v11_1);
            if(!(v6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v6.startReusableNode();
            if(v6.getInserting()) {
                v6.createNode(v10_1);
            }
            else {
                v6.useNode();
            }

            Composer v10_2 = Updater.constructor-impl(v6);
            Updater.set-impl(v10_2, v15_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v10_2, v13_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v12 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v10_2.getInserting()) || !Intrinsics.areEqual(v10_2.rememberedValue(), Integer.valueOf(v7_1))) {
                v10_2.updateRememberedValue(Integer.valueOf(v7_1));
                v10_2.apply(Integer.valueOf(v7_1), v12);
            }

            Updater.set-impl(v10_2, v2_2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v6, -2087603364, "C458@19231L50,461@19484L69,463@19567L50:NavigationItem.kt#uh7d8r");
            v7_1 = v3 >> 3;
            NavigationItemKt.IndicatorRipple(v1, v4, v6, v3 & 14 | v7_1 & 0x70);
            int v10_3 = v3;
            String v12_1 = v5_2;
            NavigationItemKt.Indicator-3J-VO9M(arg25, v4, arg31, v6, v3 >> 12 & 0x380 | v7_1 & 0x7E);
            v2_2 = LayoutIdKt.layoutId(Modifier.Companion, "icon");
            v3 = 0x2BB5B5D7;
            String v4_1 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v6, v3, v4_1);
            MeasurePolicy v5_3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v6, -1323940314, v12_1);
            v13 = ComposablesKt.getCurrentCompositeKeyHash(v6, 0);
            CompositionLocalMap v7_2 = v6.getCurrentCompositionLocalMap();
            v2_2 = ComposedModifierKt.materializeModifier(v6, v2_2);
            Function0 v15_3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v6, v8, v11_1);
            if(!(v6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v6.startReusableNode();
            if(v6.getInserting()) {
                v6.createNode(v15_3);
            }
            else {
                v6.useNode();
            }

            Composer v8_1 = Updater.constructor-impl(v6);
            Updater.set-impl(v8_1, v5_3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v8_1, v7_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v5_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v8_1.getInserting()) || !Intrinsics.areEqual(v8_1.rememberedValue(), Integer.valueOf(v13))) {
                v8_1.updateRememberedValue(Integer.valueOf(v13));
                v8_1.apply(Integer.valueOf(v13), v5_4);
            }

            Updater.set-impl(v8_1, v2_2, ComposeUiNode.Companion.getSetModifier());
            v2_1 = 0x800B7D29;
            v5_2 = "C72@3468L9:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v6, v2_1, v5_2);
            ComposerKt.sourceInformationMarkerStart(v6, 0x26E66067, "C463@19609L6:NavigationItem.kt#uh7d8r");
            v0.invoke(v6, Integer.valueOf(v10_3 >> 9 & 14));
            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerEnd(v6);
            v6.endNode();
            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerEnd(v6);
            if(v9 != null) {
                v6.startReplaceGroup(-2087200706);
                ComposerKt.sourceInformation(v6, "466@19668L52");
                Modifier v7_3 = LayoutIdKt.layoutId(Modifier.Companion, "label");
                ComposerKt.sourceInformationMarkerStart(v6, v3, v4_1);
                MeasurePolicy v3_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v6, -1323940314, v12_1);
                int v4_2 = ComposablesKt.getCurrentCompositeKeyHash(v6, 0);
                CompositionLocalMap v8_2 = v6.getCurrentCompositionLocalMap();
                v7_3 = ComposedModifierKt.materializeModifier(v6, v7_3);
                Function0 v12_2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v6, 0xD6BD0031, v11_1);
                if(!(v6.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v6.startReusableNode();
                if(v6.getInserting()) {
                    v6.createNode(v12_2);
                }
                else {
                    v6.useNode();
                }

                Composer v11_2 = Updater.constructor-impl(v6);
                Updater.set-impl(v11_2, v3_1, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v11_2, v8_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 v3_2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v11_2.getInserting()) || !Intrinsics.areEqual(v11_2.rememberedValue(), Integer.valueOf(v4_2))) {
                    v11_2.updateRememberedValue(Integer.valueOf(v4_2));
                    v11_2.apply(Integer.valueOf(v4_2), v3_2);
                }

                Updater.set-impl(v11_2, v7_3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v6, v2_1, v5_2);
                ComposerKt.sourceInformationMarkerStart(v6, -2123117109, "C466@19711L7:NavigationItem.kt#uh7d8r");
                v9.invoke(v6, Integer.valueOf(v10_3 >> 15 & 14));
                ComposerKt.sourceInformationMarkerEnd(v6);
                ComposerKt.sourceInformationMarkerEnd(v6);
                v6.endNode();
                ComposerKt.sourceInformationMarkerEnd(v6);
                ComposerKt.sourceInformationMarkerEnd(v6);
                ComposerKt.sourceInformationMarkerEnd(v6);
                v6.endReplaceGroup();
            }
            else {
                v6.startReplaceGroup(-2087119982);
                v6.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            v6.endNode();
            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerEnd(v6);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_386;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v6.skipToGroupEnd();
        }

    label_386:
        ScopeUpdateScope v2_3 = v6.endRestartGroup();
        if(v2_3 != null) {
            v2_3.updateScope(new NavigationItemKt$$ExternalSyntheticLambda17(v1, arg25, arg27, arg28, arg29, v9, arg31, arg32, arg33, arg34, arg35, arg36, v14, arg39));
        }
    }

    static final Unit NavigationItemLayout_KmRX_Dg$lambda$31(InteractionSource arg17, long arg18, Shape arg20, Function2 arg21, int arg22, Function2 arg23, Function0 arg24, float arg25, float arg26, float arg27, float arg28, float arg29, int arg30, int arg31, Composer arg32, int arg33) {
        NavigationItemKt.NavigationItemLayout-KmRX-Dg(arg17, arg18, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg32, RecomposeScopeImplKt.updateChangedFlags(arg30 | 1), RecomposeScopeImplKt.updateChangedFlags(arg31));
        return Unit.INSTANCE;
    }

    private static final int NavigationItem_8Df7sds$lambda$1(MutableIntState arg0) {
        return ((IntState)arg0).getIntValue();
    }

    static final Unit NavigationItem_8Df7sds$lambda$10(boolean arg21, Function0 arg22, Function2 arg23, TextStyle arg24, Shape arg25, float arg26, float arg27, float arg28, float arg29, float arg30, float arg31, NavigationItemColors arg32, Modifier arg33, boolean arg34, Function2 arg35, int arg36, MutableInteractionSource arg37, int arg38, int arg39, Composer arg40, int arg41) {
        NavigationItemKt.NavigationItem-8Df7sds(arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg40, RecomposeScopeImplKt.updateChangedFlags(arg38 | 1), RecomposeScopeImplKt.updateChangedFlags(arg39));
        return Unit.INSTANCE;
    }

    private static final void NavigationItem_8Df7sds$lambda$2(MutableIntState arg0, int arg1) {
        arg0.setIntValue(arg1);
    }

    static final Unit NavigationItem_8Df7sds$lambda$4$lambda$3(MutableIntState arg2, IntSize arg3) {
        NavigationItemKt.NavigationItem_8Df7sds$lambda$2(arg2, ((int)(arg3.unbox-impl() >> 0x20)));
        return Unit.INSTANCE;
    }

    static final float NavigationItem_8Df7sds$lambda$9$lambda$8$lambda$7(State arg1) {
        return RangesKt.coerceAtLeast(arg1.getValue().floatValue(), 0f);
    }

    private static final void StyledLabel(boolean arg7, TextStyle arg8, NavigationItemColors arg9, boolean arg10, Function2 arg11, Composer arg12, int arg13) {
        Function2 v12_1;
        TextStyle v3;
        int v1;
        int v12;
        int v0 = 0x80AB254D;
        Composer v5 = arg12.startRestartGroup(v0);
        ComposerKt.sourceInformation(v5, "C(StyledLabel)N(selected,labelTextStyle,colors,enabled,content)1085@45893L132:NavigationItem.kt#uh7d8r");
        if((arg13 & 6) == 0) {
            v12 = v5.changed(arg7) ? 4 : 2;
            v12 |= arg13;
        }
        else {
            v12 = arg13;
        }

        if((arg13 & 0x30) == 0) {
            v1 = v5.changed(arg8) ? 0x20 : 16;
            v12 |= v1;
        }

        if((arg13 & 0x180) == 0) {
            v1 = v5.changed(arg9) ? 0x100 : 0x80;
            v12 |= v1;
        }

        if((arg13 & 0xC00) == 0) {
            v1 = v5.changed(arg10) ? 0x800 : 0x400;
            v12 |= v1;
        }

        if((arg13 & 0x6000) == 0) {
            v1 = v5.changedInstance(arg11) ? 0x4000 : 0x2000;
            v12 |= v1;
        }

        boolean v1_1 = (v12 & 9363) != 9362 ? true : false;
        if(v5.shouldExecute(v1_1, v12 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v12, -1, "androidx.compose.material3.StyledLabel (NavigationItem.kt:1083)");
            }

            v3 = arg8;
            ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(arg9.textColor-WaAFU9c(arg7, arg10), v3, arg11, v5, v12 & 0x70 | v12 >> 6 & 0x380);
            v12_1 = arg11;
            if(!ComposerKt.isTraceInProgress()) {
                goto label_76;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v3 = arg8;
            v12_1 = arg11;
            v5.skipToGroupEnd();
        }

    label_76:
        ScopeUpdateScope v0_1 = v5.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new NavigationItemKt$$ExternalSyntheticLambda9(arg7, v3, arg9, arg10, v12_1, arg13));
        }
    }

    static final Unit StyledLabel$lambda$41(boolean arg7, TextStyle arg8, NavigationItemColors arg9, boolean arg10, Function2 arg11, int arg12, Composer arg13, int arg14) {
        NavigationItemKt.StyledLabel(arg7, arg8, arg9, arg10, arg11, arg13, RecomposeScopeImplKt.updateChangedFlags(arg12 | 1));
        return Unit.INSTANCE;
    }

    public static final TextStyle access$AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$19(State arg0) {
        return NavigationItemKt.AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$19(arg0);
    }

    public static final void access$StyledLabel(boolean arg0, TextStyle arg1, NavigationItemColors arg2, boolean arg3, Function2 arg4, Composer arg5, int arg6) {
        NavigationItemKt.StyledLabel(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static final MeasureResult access$placeAnimatedLabelAndIcon-2QYhCQ8(MeasureScope arg0, int arg1, Function0 arg2, Placeable arg3, Placeable arg4, Placeable arg5, Placeable arg6, int arg7, long arg8, float arg10, float arg11, float arg12, float arg13, float arg14, float arg15, float arg16) {
        return NavigationItemKt.placeAnimatedLabelAndIcon-2QYhCQ8(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
    }

    public static final MeasureResult access$placeIcon-X9ElhV4(MeasureScope arg0, Placeable arg1, Placeable arg2, Placeable arg3, long arg4) {
        return NavigationItemKt.placeIcon-X9ElhV4(arg0, arg1, arg2, arg3, arg4);
    }

    public static final MeasureResult access$placeLabelAndStartIcon-nru01g4(MeasureScope arg0, Placeable arg1, Placeable arg2, Placeable arg3, Placeable arg4, long arg5, float arg7) {
        return NavigationItemKt.placeLabelAndStartIcon-nru01g4(arg0, arg1, arg2, arg3, arg4, arg5, arg7);
    }

    public static final MeasureResult access$placeLabelAndTopIcon-qoqLrGI(MeasureScope arg0, Placeable arg1, Placeable arg2, Placeable arg3, Placeable arg4, long arg5, float arg7, float arg8, float arg9) {
        return NavigationItemKt.placeLabelAndTopIcon-qoqLrGI(arg0, arg1, arg2, arg3, arg4, arg5, arg7, arg8, arg9);
    }

    private static final State animateIndicatorProgressAsState(boolean arg8, Composer arg9, int arg10) {
        int v1 = 0xBE18FD71;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(animateIndicatorProgressAsState)N(selected)1097@46316L7,1094@46110L220:NavigationItem.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.material3.animateIndicatorProgressAsState (NavigationItem.kt:1094)");
        }

        float v8 = arg8 ? 1f : 0f;
        Composer v5 = arg9;
        State v8_1 = AnimateAsStateKt.animateFloatAsState(v8, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, arg9, 6), 0f, null, null, v5, 0, 28);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v5);
        return v8_1;
    }

    private static final MeasureResult placeAnimatedLabelAndIcon-2QYhCQ8(MeasureScope arg19, int arg20, Function0 arg21, Placeable arg22, Placeable arg23, Placeable arg24, Placeable arg25, int arg26, long arg27, float arg29, float arg30, float arg31, float arg32, float arg33, float arg34, float arg35) {
        Float v5_2;
        MeasureScope v0 = arg19;
        float v3 = arg29;
        float v4 = arg31;
        float v5 = arg35;
        float v6 = arg21.invoke().floatValue();
        boolean v7 = NavigationItemIconPosition.equals-impl0(arg20, NavigationItemIconPosition.Companion.getTop--xw1Ddg());
        float v9 = 2f;
        float v10 = v5 * v9;
        int v8 = ConstraintsKt.constrainWidth-K40F9xA(arg27, Math.max(arg22.getWidth(), arg26 + v0.roundToPx-0680j_4(Dp.constructor-impl(v10))));
        float v12 = (((float)v8)) + (((float)(ConstraintsKt.constrainWidth-K40F9xA(arg27, arg24.getWidth() + v0.roundToPx-0680j_4(v5)) - v8))) * v6;
        int v1 = MathHelpersKt.lerp(ConstraintsKt.constrainHeight-K40F9xA(arg27, MathKt.roundToInt((((float)arg24.getHeight())) + v0.toPx-0680j_4(v3) + (((float)arg22.getHeight())))), ConstraintsKt.constrainHeight-K40F9xA(arg27, arg24.getHeight()), v6);
        int v2 = v0.roundToPx-0680j_4(v5);
        v8 = MathKt.roundToInt((v12 - (((float)arg25.getWidth()))) / v9);
        int v11 = MathKt.roundToInt(((((float)v2)) + v12 - (((float)arg25.getWidth()))) / v9);
        float v15 = 1f;
        v8 = Float.compare(v6, 0f) == 0 || v6 == v15 ? MathHelpersKt.lerp(v8, v11, v6) : v0.roundToPx-0680j_4(v5);
        v11 = v0.roundToPx-0680j_4(v4) + v2;
        int v14 = v0.roundToPx-0680j_4(arg32) + v2;
        float v20 = v9;
        int v9_1 = v0.roundToPx-0680j_4(arg30);
        int v13 = v0.roundToPx-0680j_4(arg33);
        v11 = MathHelpersKt.lerp(v11, v14, v6);
        v9_1 = MathHelpersKt.lerp(v9_1, v13, v6);
        v13 = (arg23.getWidth() + v0.roundToPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(v4 * v20) + Dp.constructor-impl(v10))) - arg22.getWidth()) / 2;
        int v4_1 = arg23.getHeight() + v9_1 + v0.roundToPx-0680j_4(Dp.constructor-impl(v3 + v3));
        v3 = !v7 || v6 <= 0f ? (((float)v0.roundToPx-0680j_4(v5))) * (v15 - v6) : 0f;
        v5 = (((float)(arg23.getWidth() + v11 + v0.roundToPx-0680j_4(arg34)))) - v3;
        int v3_1 = (v1 - arg22.getHeight()) / 2;
        int v7_1 = Float.compare(v6, 0.5f);
        if(v7_1 < 0) {
            Integer v5_1 = Integer.valueOf(v13);
        }
        else {
            v5_2 = Float.valueOf(v5 * v6);
        }

        Integer v14_1 = ((Integer)v5_2);
        int v15_1 = v7_1 < 0 ? v4_1 : v3_1;
        return MeasureScope.layout$default(v0, MathKt.roundToInt(v12), v1, null, new NavigationItemKt$$ExternalSyntheticLambda18(arg25, v8, arg23, v11, v9_1, arg22, v14_1, v15_1, arg24, v2, v6), 4, null);
    }

    static final Unit placeAnimatedLabelAndIcon_2QYhCQ8$lambda$40(Placeable arg16, int arg17, Placeable arg18, int arg19, int arg20, Placeable arg21, Object arg22, int arg23, Placeable arg24, int arg25, float arg26, PlacementScope arg27) {
        PlacementScope.placeRelativeWithLayer$default(arg27, arg16, arg17, 0, 0f, null, 12, null);
        PlacementScope.placeRelativeWithLayer$default(arg27, arg18, arg19, arg20, 0f, null, 12, null);
        PlacementScope.placeRelativeWithLayer$default(arg27, arg21, arg22.intValue(), arg23, 0f, new NavigationItemKt$$ExternalSyntheticLambda15(arg26), 4, null);
        PlacementScope.placeRelativeWithLayer$default(arg27, arg24, arg25, 0, 0f, null, 12, null);
        return Unit.INSTANCE;
    }

    static final Unit placeAnimatedLabelAndIcon_2QYhCQ8$lambda$40$lambda$39(float arg1, GraphicsLayerScope arg2) {
        arg1 -= 0.5f;
        arg2.setAlpha(4f * arg1 * arg1);
        return Unit.INSTANCE;
    }

    private static final MeasureResult placeIcon-X9ElhV4(MeasureScope arg16, Placeable arg17, Placeable arg18, Placeable arg19, long arg20) {
        int v4 = ConstraintsKt.constrainWidth-K40F9xA(arg20, arg18.getWidth());
        int v5 = ConstraintsKt.constrainHeight-K40F9xA(arg20, arg18.getHeight());
        return MeasureScope.layout$default(arg16, v4, v5, null, new NavigationItemKt$$ExternalSyntheticLambda1(arg19, (v4 - arg19.getWidth()) / 2, (v5 - arg19.getHeight()) / 2, arg17, (v4 - arg17.getWidth()) / 2, (v5 - arg17.getHeight()) / 2, arg18, (v4 - arg18.getWidth()) / 2, (v5 - arg18.getHeight()) / 2), 4, null);
    }

    static final Unit placeIcon_X9ElhV4$lambda$36(Placeable arg14, int arg15, int arg16, Placeable arg17, int arg18, int arg19, Placeable arg20, int arg21, int arg22, PlacementScope arg23) {
        PlacementScope.placeRelative$default(arg23, arg14, arg15, arg16, 0f, 4, null);
        PlacementScope.placeRelative$default(arg23, arg17, arg18, arg19, 0f, 4, null);
        PlacementScope.placeRelative$default(arg23, arg20, arg21, arg22, 0f, 4, null);
        return Unit.INSTANCE;
    }

    private static final MeasureResult placeLabelAndStartIcon-nru01g4(MeasureScope arg18, Placeable arg19, Placeable arg20, Placeable arg21, Placeable arg22, long arg23, float arg25) {
        int v4 = ConstraintsKt.constrainWidth-K40F9xA(arg23, arg21.getWidth());
        int v1 = ConstraintsKt.constrainHeight-K40F9xA(arg23, arg21.getHeight());
        int v7 = (v4 - arg22.getWidth()) / 2;
        int v8 = (v1 - arg22.getHeight()) / 2;
        int v14 = (v1 - arg20.getHeight()) / 2;
        int v11 = (v1 - arg19.getHeight()) / 2;
        int v13 = (v4 - (arg20.getWidth() + arg18.roundToPx-0680j_4(arg25) + arg19.getWidth())) / 2;
        return MeasureScope.layout$default(arg18, v4, v1, null, new NavigationItemKt$$ExternalSyntheticLambda8(arg22, v7, v8, arg19, arg20.getWidth() + v13 + arg18.roundToPx-0680j_4(arg25), v11, arg20, v13, v14, arg21, (v4 - arg21.getWidth()) / 2, (v1 - arg21.getHeight()) / 2), 4, null);
    }

    static final Unit placeLabelAndStartIcon_nru01g4$lambda$38(Placeable arg14, int arg15, int arg16, Placeable arg17, int arg18, int arg19, Placeable arg20, int arg21, int arg22, Placeable arg23, int arg24, int arg25, PlacementScope arg26) {
        PlacementScope.placeRelative$default(arg26, arg14, arg15, arg16, 0f, 4, null);
        PlacementScope.placeRelative$default(arg26, arg17, arg18, arg19, 0f, 4, null);
        PlacementScope.placeRelative$default(arg26, arg20, arg21, arg22, 0f, 4, null);
        PlacementScope.placeRelative$default(arg26, arg23, arg24, arg25, 0f, 4, null);
        return Unit.INSTANCE;
    }

    private static final MeasureResult placeLabelAndTopIcon-qoqLrGI(MeasureScope arg20, Placeable arg21, Placeable arg22, Placeable arg23, Placeable arg24, long arg25, float arg27, float arg28, float arg29) {
        int v6 = ConstraintsKt.constrainWidth-K40F9xA(arg25, Math.max(arg21.getWidth(), arg23.getWidth()));
        int v1 = ConstraintsKt.constrainHeight-K40F9xA(arg25, MathKt.roundToInt((((float)arg23.getHeight())) + arg20.toPx-0680j_4(arg27) + (((float)arg21.getHeight())) + arg20.toPx-0680j_4(arg29) * 2f));
        int v16 = arg20.roundToPx-0680j_4(Dp.constructor-impl(arg29 + arg28));
        int v15 = (v6 - arg22.getWidth()) / 2;
        int v9 = (v6 - arg24.getWidth()) / 2;
        int v10 = v16 - arg20.roundToPx-0680j_4(arg28);
        return MeasureScope.layout$default(arg20, v6, v1, null, new NavigationItemKt$$ExternalSyntheticLambda2(arg24, v9, v10, arg21, (v6 - arg21.getWidth()) / 2, v16 + arg22.getHeight() + arg20.roundToPx-0680j_4(Dp.constructor-impl(arg27 + arg28)), arg22, v15, v16, arg23, (v6 - arg23.getWidth()) / 2, v10), 4, null);
    }

    static final Unit placeLabelAndTopIcon_qoqLrGI$lambda$37(Placeable arg14, int arg15, int arg16, Placeable arg17, int arg18, int arg19, Placeable arg20, int arg21, int arg22, Placeable arg23, int arg24, int arg25, PlacementScope arg26) {
        PlacementScope.placeRelative$default(arg26, arg14, arg15, arg16, 0f, 4, null);
        PlacementScope.placeRelative$default(arg26, arg17, arg18, arg19, 0f, 4, null);
        PlacementScope.placeRelative$default(arg26, arg20, arg21, arg22, 0f, 4, null);
        PlacementScope.placeRelative$default(arg26, arg23, arg24, arg25, 0f, 4, null);
        return Unit.INSTANCE;
    }
}

