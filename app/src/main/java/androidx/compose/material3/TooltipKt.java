package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.BasicTooltipDefaults;
import androidx.compose.material3.internal.BasicTooltipKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000¬\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000F\u001Al\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u001C\u0010\u0004\u001A\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u0012\u001A~\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u001C\u0010\u0004\u001A\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\u0010\b\u0002\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00112\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u0014\u001A\u0088\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u001C\u0010\u0004\u001A\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\u0010\b\u0002\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00112\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0015\u001A\u00020\u000E2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u0016\u001Av\u0010\u0017\u001A\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010 \u001A\u00020\u001F2\b\b\u0002\u0010!\u001A\u00020\u001B2\b\b\u0002\u0010\"\u001A\u00020\u001B2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b#\u0010$\u001Ax\u0010\u0017\u001A\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000B\u001A\u00020\f2\n\b\u0002\u0010%\u001A\u0004\u0018\u00010\u001D2\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010 \u001A\u00020\u001F2\b\b\u0002\u0010!\u001A\u00020\u001B2\b\b\u0002\u0010\"\u001A\u00020\u001B2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b&\u0010\'\u001A\u009A\u0001\u0010(\u001A\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000B\u001A\u00020\f2\u0015\b\u0002\u0010)\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00072\u0015\b\u0002\u0010*\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00072\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010+\u001A\u00020,2\b\b\u0002\u0010!\u001A\u00020\u001B2\b\b\u0002\u0010\"\u001A\u00020\u001B2\u0011\u0010-\u001A\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b.\u0010/\u001A\u009C\u0001\u0010(\u001A\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000B\u001A\u00020\f2\u0015\b\u0002\u0010)\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00072\u0015\b\u0002\u0010*\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00072\n\b\u0002\u0010%\u001A\u0004\u0018\u00010\u001D2\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010+\u001A\u00020,2\b\b\u0002\u0010!\u001A\u00020\u001B2\b\b\u0002\u0010\"\u001A\u00020\u001B2\u0011\u0010-\u001A\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b0\u00101\u001A+\u00102\u001A\u00020\n2\b\b\u0002\u00103\u001A\u00020\u000E2\b\b\u0002\u00104\u001A\u00020\u000E2\b\b\u0002\u00105\u001A\u000206H\u0007¢\u0006\u0002\u00107\u001A&\u00108\u001A\u00020\n2\b\b\u0002\u00103\u001A\u00020\u000E2\b\b\u0002\u00104\u001A\u00020\u000E2\b\b\u0002\u00105\u001A\u000206H\u0007\u001A\u001C\u00109\u001A\u00020\f*\u00020\f2\u0006\u0010:\u001A\u00020\u000E2\u0006\u0010;\u001A\u00020\u000EH\u0001\u001A\u001A\u0010<\u001A\u00020\f*\u00020\f2\f\u0010=\u001A\b\u0012\u0004\u0012\u00020\u000E0>H\u0000\u001A \u0010?\u001A\u00020@2\u0006\u0010A\u001A\u00020@2\u0006\u0010B\u001A\u00020C2\u0006\u0010D\u001A\u00020EH\u0000\u001AT\u0010F\u001A\u00020\f*\u00020\f2\f\u0010G\u001A\b\u0012\u0004\u0012\u00020I0H2\u0006\u0010J\u001A\u00020K2\u0006\u0010L\u001A\u00020M2\u0019\u0010N\u001A\u0015\u0012\u0004\u0012\u00020O\u0012\u0006\u0012\u0004\u0018\u00010P0\u0005¢\u0006\u0002\b\b2\u0006\u0010\u0002\u001A\u00020\u0003H\u0002¢\u0006\u0004\bQ\u0010R\"\u0016\u0010S\u001A\u00020\u001BX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001A\u0004\bT\u0010U\"\u0016\u0010W\u001A\u00020\u001BX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001A\u0004\bX\u0010U\"\u0016\u0010Y\u001A\u00020\u001BX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001A\u0004\bZ\u0010U\"\u0010\u0010[\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010V\"\u0010\u0010\\\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010V\"\u0014\u0010]\u001A\u00020^X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b_\u0010`\"\u0016\u0010a\u001A\u00020\u001BX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001A\u0004\bb\u0010U\"\u0016\u0010c\u001A\u00020\u001BX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001A\u0004\bd\u0010U\"\u0010\u0010e\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010V\"\u0010\u0010f\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010V\"\u0016\u0010g\u001A\u00020\u001BX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001A\u0004\bh\u0010U\"\u0016\u0010i\u001A\u00020\u001BX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001A\u0004\bj\u0010U¨\u0006k²\u0006\n\u0010l\u001A\u00020@X\u008A\u0084\u0002²\u0006\n\u0010m\u001A\u00020@X\u008A\u0084\u0002"}, d2={"TooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/material3/TooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "Lkotlin/Function0;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "onDismissRequest", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "hasAction", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PlainTooltip", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "maxWidth", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "tonalElevation", "shadowElevation", "PlainTooltip-m9Er-Xc", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;JFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "caretShape", "PlainTooltip-gv3ox5I", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "RichTooltip", "title", "action", "colors", "Landroidx/compose/material3/RichTooltipColors;", "text", "RichTooltip-ZuUcA3Q", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JFLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "RichTooltip-EkvW5A0", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "rememberTooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TooltipState;", "TooltipState", "textVerticalPadding", "subheadExists", "actionExists", "animateTooltip", "transition", "Landroidx/compose/animation/core/Transition;", "caretX", "", "tooltipWidth", "screenWidthPx", "", "anchorBounds", "Landroidx/compose/ui/geometry/Rect;", "layoutCaret", "transformationMatrix", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/Matrix;", "density", "Landroidx/compose/ui/unit/Density;", "windowContainerSize", "Landroidx/compose/ui/unit/IntSize;", "getAnchorLayoutCoordinates", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCaret-J5j9r9c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/unit/Density;JLkotlin/jvm/functions/Function1;Landroidx/compose/ui/window/PopupPositionProvider;)Landroidx/compose/ui/Modifier;", "SpacingBetweenTooltipAndAnchor", "getSpacingBetweenTooltipAndAnchor", "()F", "F", "TooltipMinHeight", "getTooltipMinHeight", "TooltipMinWidth", "getTooltipMinWidth", "PlainTooltipVerticalPadding", "PlainTooltipHorizontalPadding", "PlainTooltipContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getPlainTooltipContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "RichTooltipHorizontalPadding", "getRichTooltipHorizontalPadding", "HeightToSubheadFirstLine", "getHeightToSubheadFirstLine", "HeightFromSubheadToTextFirstLine", "TextBottomPadding", "ActionLabelMinHeight", "getActionLabelMinHeight", "ActionLabelBottomPadding", "getActionLabelBottomPadding", "material3", "scale", "alpha"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TooltipKt {
    private static final float ActionLabelBottomPadding;
    private static final float ActionLabelMinHeight;
    private static final float HeightFromSubheadToTextFirstLine;
    private static final float HeightToSubheadFirstLine;
    private static final PaddingValues PlainTooltipContentPadding;
    private static final float PlainTooltipHorizontalPadding;
    private static final float PlainTooltipVerticalPadding;
    private static final float RichTooltipHorizontalPadding;
    private static final float SpacingBetweenTooltipAndAnchor;
    private static final float TextBottomPadding;
    private static final float TooltipMinHeight;
    private static final float TooltipMinWidth;

    static {
        TooltipKt.SpacingBetweenTooltipAndAnchor = Dp.constructor-impl(4f);
        TooltipKt.TooltipMinHeight = Dp.constructor-impl(24f);
        TooltipKt.TooltipMinWidth = Dp.constructor-impl(40f);
        float v0 = Dp.constructor-impl(4f);
        TooltipKt.PlainTooltipVerticalPadding = v0;
        float v3 = Dp.constructor-impl(8f);
        TooltipKt.PlainTooltipHorizontalPadding = v3;
        TooltipKt.PlainTooltipContentPadding = PaddingKt.PaddingValues-YgX7TsA(v3, v0);
        TooltipKt.RichTooltipHorizontalPadding = Dp.constructor-impl(16f);
        TooltipKt.HeightToSubheadFirstLine = Dp.constructor-impl(28f);
        TooltipKt.HeightFromSubheadToTextFirstLine = Dp.constructor-impl(24f);
        TooltipKt.TextBottomPadding = Dp.constructor-impl(16f);
        TooltipKt.ActionLabelMinHeight = Dp.constructor-impl(36f);
        TooltipKt.ActionLabelBottomPadding = Dp.constructor-impl(8f);
    }

    public static final void PlainTooltip-gv3ox5I(TooltipScope arg28, Modifier arg29, Shape arg30, float arg31, Shape arg32, long arg33, long arg35, float arg37, float arg38, Function2 arg39, Composer arg40, int arg41, int arg42) {
        float v4_1;
        long v8_3;
        Shape v5;
        long v6_1;
        float v11_4;
        float v10_1;
        Shape v3_4;
        Modifier v2_1;
        Composer v25_2;
        Object v16_1;
        Modifier v15_2;
        TooltipCaretShape v11_3;
        TooltipKt$$ExternalSyntheticLambda0 v1_6;
        int v15_1;
        TooltipScope v3_3;
        float v21_1;
        float v22_1;
        long v17_1;
        long v25_1;
        Companion v7_1;
        int v1_1;
        float v0_1;
        int v20;
        long v4;
        int v17;
        Shape v9;
        float v15;
        int v11;
        Shape v10;
        int v8;
        Modifier v7;
        int v3;
        TooltipScope v1 = arg28;
        Function2 v12 = arg39;
        int v13 = arg41;
        int v14 = arg42;
        Composer v2 = arg40.startRestartGroup(0xEB82A792);
        ComposerKt.sourceInformation(v2, "C(PlainTooltip)N(modifier,caretShape,maxWidth:c#ui.unit.Dp,shape,contentColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)461@19351L596,455@19154L793:Tooltip.kt#uh7d8r");
        if((0x80000000 & v14) != 0) {
            v3 = v13 | 6;
        }
        else if((v13 & 6) == 0) {
            boolean v3_1 = (v13 & 8) == 0 ? v2.changed(v1) : v2.changedInstance(v1);
            v3 = v3_1 ? 4 : 2;
            v3 |= v13;
        }
        else {
            v3 = v13;
        }

        int v6 = v14 & 1;
        if(v6 != 0) {
            v3 |= 0x30;
            goto label_42;
        }
        else if((v13 & 0x30) == 0) {
            v7 = arg29;
            v8 = v2.changed(v7) ? 0x20 : 16;
            v3 |= v8;
        }
        else {
        label_42:
            v7 = arg29;
        }

        v8 = v14 & 2;
        if(v8 != 0) {
            v3 |= 0x180;
            goto label_57;
        }
        else if((v13 & 0x180) == 0) {
            v10 = arg30;
            v11 = v2.changed(v10) ? 0x100 : 0x80;
            v3 |= v11;
        }
        else {
        label_57:
            v10 = arg30;
        }

        v11 = v14 & 4;
        if(v11 != 0) {
            v3 |= 0xC00;
            goto label_72;
        }
        else if((v13 & 0xC00) == 0) {
            v15 = arg31;
            int v16 = v2.changed(v15) ? 0x800 : 0x400;
            v3 |= v16;
        }
        else {
        label_72:
            v15 = arg31;
        }

        if((v13 & 0x6000) == 0) {
            if((v14 & 8) == 0) {
                v9 = arg32;
                if(v2.changed(v9)) {
                    v17 = 0x4000;
                }
                else {
                    goto label_83;
                }
            }
            else {
                v9 = arg32;
            label_83:
                v17 = 0x2000;
            }

            v3 |= v17;
        }
        else {
            v9 = arg32;
        }

        if((v13 & 0x30000) == 0) {
            v4 = arg33;
            int v19 = (v14 & 16) != 0 || !v2.changed(v4) ? 0x10000 : 0x20000;
            v3 |= v19;
        }
        else {
            v4 = arg33;
        }

        if((v13 & 0x180000) == 0) {
            long v0 = arg35;
            v20 = (v14 & 0x20) != 0 || !v2.changed(v0) ? 0x80000 : 0x100000;
            v3 |= v20;
        }

        v20 = v14 & 0x40;
        int v21 = 0xC00000;
        if(v20 != 0) {
            v3 |= v21;
        }
        else {
            v0_1 = arg37;
            if((v13 & v21) == 0) {
                v1_1 = v2.changed(v0_1) ? 0x800000 : 0x400000;
                v3 |= v1_1;
            }
        }

        v1_1 = v14 & 0x80;
        int v22 = 0x6000000;
        if(v1_1 != 0) {
            v3 |= v22;
        }
        else {
            v0_1 = arg38;
            if((v13 & v22) == 0) {
                v22 = v2.changed(v0_1) ? 0x4000000 : 0x2000000;
                v3 |= v22;
            }
        }

        v22 = 0x30000000;
        if((v14 & 0x100) != 0) {
            v3 |= v22;
        }
        else if((v13 & v22) == 0) {
            int v0_2 = v2.changedInstance(v12) ? 0x20000000 : 0x10000000;
            v3 |= v0_2;
        }

        v22 = v1_1;
        int v23 = 0;
        int v24 = v3;
        boolean v0_3 = (306783379 & v3) != 306783378 ? true : false;
        if(v2.shouldExecute(v0_3, v24 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "424@18046L26,425@18116L24,426@18186L26");
            int v25 = 0xFFFF1FFF;
            float[] v1_2 = null;
            if((v13 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v6 != 0) {
                    v7_1 = Modifier.Companion;
                }

                if(v8 != 0) {
                    v10 = ((Shape)v1_2);
                }

                if(v11 != 0) {
                    v15 = TooltipDefaults.INSTANCE.getPlainTooltipMaxWidth-D9Ej5fM();
                }

                v6 = 6;
                if((v14 & 8) != 0) {
                    v9 = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(v2, v6);
                    v24 &= v25;
                }

                if((v14 & 16) != 0) {
                    v4 = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(v2, v6);
                    v24 &= 0xFFF8FFFF;
                }

                if((v14 & 0x20) != 0) {
                    v25_1 = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(v2, v6);
                    v24 &= 0xFFC7FFFF;
                }
                else {
                    v25_1 = arg35;
                }

                v0_1 = v20 != 0 ? Dp.constructor-impl(0f) : arg37;
                v22_1 = v22 != 0 ? Dp.constructor-impl(0f) : arg38;
                v8 = v21;
                v6 = v24;
                v17_1 = v25_1;
                v21_1 = v0_1;
                v0_1 = v15;
            }
            else {
                v2.skipToGroupEnd();
                if((v14 & 8) != 0) {
                    v24 &= v25;
                }

                if((v14 & 16) != 0) {
                    v24 &= 0xFFF8FFFF;
                }

                if((v14 & 0x20) != 0) {
                    v24 &= 0xFFC7FFFF;
                }

                v17_1 = arg35;
                v22_1 = arg38;
                v0_1 = v15;
                v8 = v21;
                v6 = v24;
                v21_1 = arg37;
            }

            v2.endDefaults();
            int v29 = v8;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xEB82A792, v6, -1, "androidx.compose.material3.PlainTooltip (Tooltip.kt:430)");
            }

            if(v10 != null) {
                v2.startReplaceGroup(-1720477287);
                ComposerKt.sourceInformation(v2, "434@18445L37,435@18518L7,436@18576L7,442@18790L24,447@18947L118");
                String v11_1 = "CC(remember):Tooltip.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(v2, 360143287, v11_1);
                Object v8_1 = v2.rememberedValue();
                if(v8_1 == Composer.Companion.getEmpty()) {
                    MutableState v8_2 = SnapshotStateKt.mutableStateOf$default(Matrix.box-impl(Matrix.constructor-impl$default(v1_2, 1, ((DefaultConstructorMarker)v1_2))), ((SnapshotMutationPolicy)v1_2), 2, v1_2);
                    v2.updateRememberedValue(v8_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v2);
                ProvidableCompositionLocal v1_3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(v2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object v1_4 = v2.consume(((CompositionLocal)v1_3));
                ComposerKt.sourceInformationMarkerEnd(v2);
                ProvidableCompositionLocal v3_2 = CompositionLocalsKt.getLocalWindowInfo();
                Object v33 = v1_4;
                ComposerKt.sourceInformationMarkerStart(v2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                v1_4 = v2.consume(((CompositionLocal)v3_2));
                ComposerKt.sourceInformationMarkerEnd(v2);
                long v24_1 = ((WindowInfo)v1_4).getContainerSize-YbymL2g();
                Companion v1_5 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(v2, 360154314, v11_1);
                if((v6 & 14) != 4) {
                    if((v6 & 8) != 0) {
                        v3_3 = arg28;
                        if(v2.changedInstance(v3_3)) {
                            goto label_309;
                        }
                    }
                    else {
                        v3_3 = arg28;
                    }

                    v15_1 = 0;
                }
                else {
                    v3_3 = arg28;
                label_309:
                    v15_1 = 1;
                }

                Companion v31 = v1_5;
                v1_4 = v2.rememberedValue();
                if(v15_1 != 0 || v1_4 == Composer.Companion.getEmpty()) {
                    v1_6 = new TooltipKt$$ExternalSyntheticLambda0(v3_3);
                    v2.updateRememberedValue(v1_6);
                }

                ComposerKt.sourceInformationMarkerEnd(v2);
                Modifier v1_7 = TooltipKt.layoutCaret-J5j9r9c(((Modifier)v31), v8_1, ((Density)v33), v24_1, v1_6, v3_3.obtainPositionProvider()).then(((Modifier)v7_1));
                ComposerKt.sourceInformationMarkerStart(v2, 360159432, v11_1);
                v15_1 = 0x4000;
                v11 = (0xE000 & v6 ^ 0x6000) > v15_1 && (v2.changed(v9)) || (v6 & 0x6000) == v15_1 ? 1 : 0;
                Modifier v30 = v1_7;
                if((v6 & 0x380) == 0x100) {
                    v23 = 1;
                }

                v1_1 = v11 | v23;
                Object v11_2 = v2.rememberedValue();
                if(v1_1 != 0 || v11_2 == Composer.Companion.getEmpty()) {
                    v11_3 = new TooltipCaretShape(((MutableState)v8_1), v9, v10);
                    v2.updateRememberedValue(v11_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v2);
                v2.endReplaceGroup();
                v15_2 = v30;
                v16_1 = v11_3;
            }
            else {
                v2.startReplaceGroup(0x997D7249);
                v2.endReplaceGroup();
                v15_2 = ((Modifier)v7_1);
                Shape v16_2 = v9;
            }

            float v30_1 = v0_1;
            v1_1 = v6 >> 9;
            v25_2 = v2;
            SurfaceKt.Surface-T9BRK9s(v15_2, ((Shape)v16_1), v17_1, 0, v21_1, v22_1, null, ComposableLambdaKt.rememberComposableLambda(0xA22EAE6D, true, new TooltipKt$PlainTooltip$4(v0_1, v4, v12), v2, 54), v25_2, v6 >> 12 & 0x380 | v29 | 0xE000 & v1_1 | v1_1 & 0x70000, 72);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v7_1);
            v3_4 = v10;
            v10_1 = v21_1;
            v11_4 = v22_1;
            v6_1 = v4;
            v5 = v9;
            v8_3 = v17_1;
            v4_1 = v30_1;
        }
        else {
            v25_2 = v2;
            v25_2.skipToGroupEnd();
            v11_4 = arg38;
            v2_1 = v7;
            v3_4 = v10;
            v10_1 = arg37;
            v6_1 = v4;
            v5 = v9;
            v4_1 = v15;
            v8_3 = arg35;
        }

        ScopeUpdateScope v15_3 = v25_2.endRestartGroup();
        if(v15_3 != null) {
            v15_3.updateScope(new TooltipKt$$ExternalSyntheticLambda3(arg28, v2_1, v3_4, v4_1, v5, v6_1, v8_3, v10_1, v11_4, v12, v13, v14));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public static final void PlainTooltip-m9Er-Xc(TooltipScope arg23, Modifier arg24, long arg25, float arg27, Shape arg28, long arg29, long arg31, float arg33, float arg34, Function2 arg35, Composer arg36, int arg37, int arg38) {
        long v3_3;
        Shape v6_3;
        float v5_3;
        float v12_1;
        Composer v0_4;
        Modifier v2_2;
        float v24;
        long v7;
        long v9_1;
        Shape v4_1;
        float v6_2;
        Modifier v1_2;
        float v0_2;
        int v5_1;
        float v3_2;
        Shape v7_1;
        long v4_2;
        int v19;
        float v11_1;
        int v16;
        long v2;
        long v13;
        int v11;
        Shape v10_1;
        float v9;
        int v8;
        long v6_1;
        Modifier v5;
        int v3;
        TooltipScope v0 = arg23;
        int v15 = arg37;
        int v1 = arg38;
        Composer v12 = arg36.startRestartGroup(0x8FDE89FC);
        ComposerKt.sourceInformation(v12, "C(PlainTooltip)N(modifier,caretSize:c#ui.unit.DpSize,maxWidth:c#ui.unit.Dp,shape,contentColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)389@16632L229:Tooltip.kt#uh7d8r");
        if((0x80000000 & v1) != 0) {
            v3 = v15 | 6;
        }
        else if((v15 & 6) == 0) {
            boolean v3_1 = (v15 & 8) == 0 ? v12.changed(v0) : v12.changedInstance(v0);
            v3 = v3_1 ? 4 : 2;
            v3 |= v15;
        }
        else {
            v3 = v15;
        }

        int v4 = v1 & 1;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_41;
        }
        else if((v15 & 0x30) == 0) {
            v5 = arg24;
            int v6 = v12.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_41:
            v5 = arg24;
        }

        if((v15 & 0x180) == 0) {
            if((v1 & 2) == 0) {
                v6_1 = arg25;
                if(v12.changed(v6_1)) {
                    v8 = 0x100;
                }
                else {
                    goto label_52;
                }
            }
            else {
                v6_1 = arg25;
            label_52:
                v8 = 0x80;
            }

            v3 |= v8;
        }
        else {
            v6_1 = arg25;
        }

        v8 = v1 & 4;
        if(v8 != 0) {
            v3 |= 0xC00;
            goto label_70;
        }
        else if((v15 & 0xC00) == 0) {
            v9 = arg27;
            int v10 = v12.changed(v9) ? 0x800 : 0x400;
            v3 |= v10;
        }
        else {
        label_70:
            v9 = arg27;
        }

        if((v15 & 0x6000) == 0) {
            if((v1 & 8) == 0) {
                v10_1 = arg28;
                if(v12.changed(v10_1)) {
                    v11 = 0x4000;
                }
                else {
                    goto label_81;
                }
            }
            else {
                v10_1 = arg28;
            label_81:
                v11 = 0x2000;
            }

            v3 |= v11;
        }
        else {
            v10_1 = arg28;
        }

        if((0x30000 & v15) == 0) {
            v13 = arg29;
            v11 = (v1 & 16) != 0 || !v12.changed(v13) ? 0x10000 : 0x20000;
            v3 |= v11;
        }
        else {
            v13 = arg29;
        }

        if((0x180000 & v15) == 0) {
            int v36 = v3;
            v2 = arg31;
            v16 = (v1 & 0x20) != 0 || !v12.changed(v2) ? 0x80000 : 0x100000;
            v16 |= v36;
        }
        else {
            v16 = v3;
        }

        int v17 = v1 & 0x40;
        int v18 = 0xC00000;
        if(v17 != 0) {
            v16 |= v18;
            v11_1 = arg33;
        }
        else {
            v11_1 = arg33;
            if((v15 & v18) == 0) {
                v18 = v12.changed(v11_1) ? 0x800000 : 0x400000;
                v16 |= v18;
            }
        }

        int v0_1 = v1 & 0x80;
        v18 = 0x6000000;
        if(v0_1 != 0) {
            v16 |= v18;
            goto label_147;
        }
        else if((v15 & v18) == 0) {
            v18 = v0_1;
            v19 = v12.changed(arg34) ? 0x4000000 : 0x2000000;
            v16 |= v19;
        }
        else {
        label_147:
            v18 = v0_1;
        }

        v19 = 0x30000000;
        if((v1 & 0x100) != 0) {
        label_152:
            v16 |= v19;
        }
        else if((v15 & v19) == 0) {
            v19 = v12.changedInstance(arg35) ? 0x20000000 : 0x10000000;
            goto label_152;
        }

        v0_1 = v16;
        boolean v1_1 = (v0_1 & 306783379) != 306783378 ? true : false;
        if(v12.shouldExecute(v1_1, v0_1 & 1)) {
            v12.startDefaults();
            ComposerKt.sourceInformation(v12, "382@16356L26,383@16426L24,384@16496L26");
            int v2_1 = 0xFFC7FFFF;
            v3 = 0xFFF8FFFF;
            v16 = 0xFFFF1FFF;
            if((v15 & 1) == 0 || (v12.getDefaultsInvalid())) {
                if(v4 != 0) {
                    Companion v1_3 = Modifier.Companion;
                }
                else {
                    v1_2 = v5;
                }

                if((arg38 & 2) != 0) {
                    v4_2 = DpSize.Companion.getUnspecified-MYxV2XQ();
                    v0_1 &= -897;
                }
                else {
                    v4_2 = v6_1;
                }

                v6_2 = v8 != 0 ? TooltipDefaults.INSTANCE.getPlainTooltipMaxWidth-D9Ej5fM() : v9;
                v8 = 6;
                if((arg38 & 8) != 0) {
                    v7_1 = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(v12, v8);
                    v0_1 &= v16;
                }
                else {
                    v7_1 = v10_1;
                }

                if((arg38 & 16) != 0) {
                    v9_1 = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(v12, v8);
                    v0_1 &= v3;
                }
                else {
                    v9_1 = v13;
                }

                if((arg38 & 0x20) != 0) {
                    v13 = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(v12, v8);
                    v0_1 &= v2_1;
                }
                else {
                    v13 = arg31;
                }

                v3_2 = v17 != 0 ? Dp.constructor-impl(0f) : v11_1;
                if(v18 != 0) {
                    v11_1 = v3_2;
                    long v21 = v4_2;
                    v5_1 = v0_1;
                    v0_2 = Dp.constructor-impl(0f);
                    v2 = v21;
                    v4_1 = v7_1;
                    v7 = v13;
                    goto label_266;
                }

                v11_1 = v3_2;
                v2 = v4_2;
                v4_1 = v7_1;
                v7 = v13;
            label_205:
                v5_1 = v0_1;
                v0_2 = arg34;
            }
            else {
                v12.skipToGroupEnd();
                if((arg38 & 2) != 0) {
                    v0_1 &= -897;
                }

                if((arg38 & 8) != 0) {
                    v0_1 &= v16;
                }

                if((arg38 & 16) != 0) {
                    v0_1 &= v3;
                }

                if((arg38 & 0x20) != 0) {
                    v0_1 &= v2_1;
                }

                v1_2 = v5;
                v2 = v6_1;
                v6_2 = v9;
                v4_1 = v10_1;
                v9_1 = v13;
                v7 = arg31;
                goto label_205;
            }

        label_266:
            v12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                v24 = v0_2;
                ComposerKt.traceEventStart(0x8FDE89FC, v5_1, -1, "androidx.compose.material3.PlainTooltip (Tooltip.kt:389)");
            }
            else {
                v24 = v0_2;
            }

            Shape v0_3 = TooltipDefaults.INSTANCE.caretShape-EaSLcWc(v2);
            int v13_1 = 0x7FFFFC7E & v5_1;
            long v16_1 = v2;
            v3_2 = v6_2;
            long v5_2 = v9_1;
            v9 = v11_1;
            float v10_2 = v24;
            TooltipKt.PlainTooltip-gv3ox5I(arg23, v1_2, v0_3, v3_2, v4_1, v5_2, v7, v9, v10_2, arg35, v12, v13_1, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2 = v1_2;
            v11_1 = v9;
            v0_4 = v12;
            v12_1 = v10_2;
            v9_1 = v7;
            v7 = v5_2;
            v5_3 = v3_2;
            v6_3 = v4_1;
            v3_3 = v16_1;
        }
        else {
            v12.skipToGroupEnd();
            v2_2 = v5;
            v3_3 = v6_1;
            v5_3 = v9;
            v6_3 = v10_1;
            v0_4 = v12;
            v7 = v13;
            v9_1 = arg31;
            v12_1 = arg34;
        }

        ScopeUpdateScope v0_5 = v0_4.endRestartGroup();
        if(v0_5 != null) {
            v0_5.updateScope(new TooltipKt$$ExternalSyntheticLambda9(arg23, v2_2, v3_3, v5_3, v6_3, v7, v9_1, v11_1, v12_1, arg35, v15, arg38));
        }
    }

    static final Unit PlainTooltip_gv3ox5I$lambda$11(TooltipScope arg16, Modifier arg17, Shape arg18, float arg19, Shape arg20, long arg21, long arg23, float arg25, float arg26, Function2 arg27, int arg28, int arg29, Composer arg30, int arg31) {
        TooltipKt.PlainTooltip-gv3ox5I(arg16, arg17, arg18, arg19, arg20, arg21, arg23, arg25, arg26, arg27, arg30, RecomposeScopeImplKt.updateChangedFlags(arg28 | 1), arg29);
        return Unit.INSTANCE;
    }

    static final LayoutCoordinates PlainTooltip_gv3ox5I$lambda$9$lambda$8(TooltipScope arg0, MeasureScope arg1) {
        return arg0.obtainAnchorBounds(arg1);
    }

    static final Unit PlainTooltip_m9Er_Xc$lambda$6(TooltipScope arg17, Modifier arg18, long arg19, float arg21, Shape arg22, long arg23, long arg25, float arg27, float arg28, Function2 arg29, int arg30, int arg31, Composer arg32, int arg33) {
        TooltipKt.PlainTooltip-m9Er-Xc(arg17, arg18, arg19, arg21, arg22, arg23, arg25, arg27, arg28, arg29, arg32, RecomposeScopeImplKt.updateChangedFlags(arg30 | 1), arg31);
        return Unit.INSTANCE;
    }

    public static final void RichTooltip-EkvW5A0(TooltipScope arg33, Modifier arg34, Function2 arg35, Function2 arg36, Shape arg37, float arg38, Shape arg39, RichTooltipColors arg40, float arg41, float arg42, Function2 arg43, Composer arg44, int arg45, int arg46, int arg47) {
        float v10_2;
        float v9_1;
        RichTooltipColors v8_2;
        Function2 v3_4;
        Shape v7_3;
        float v6_2;
        Modifier v2_1;
        Composer v25_1;
        Shape v16_1;
        Modifier v0_6;
        TooltipKt$$ExternalSyntheticLambda7 v5_2;
        float v37;
        float v7_1;
        Modifier v3_2;
        float v22_1;
        float v21;
        RichTooltipColors v10_1;
        Shape v8_1;
        Shape v6_1;
        Companion v3_3;
        int v24;
        int v23;
        int v22;
        Shape v5;
        int v19;
        int v17;
        int v15;
        Function2 v13;
        int v10;
        Function2 v9;
        int v8;
        Modifier v7;
        boolean v3_1;
        int v3;
        TooltipScope v1 = arg33;
        Function2 v11 = arg43;
        int v12 = arg45;
        int v14 = arg47;
        Composer v2 = arg44.startRestartGroup(236290785);
        ComposerKt.sourceInformation(v2, "C(RichTooltip)N(modifier,title,action,caretShape,maxWidth:c#ui.unit.Dp,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,text)578@23684L1598,567@23319L1963:Tooltip.kt#uh7d8r");
        if((0x80000000 & v14) != 0) {
            v3 = v12 | 6;
        }
        else if((v12 & 6) == 0) {
            v3_1 = (v12 & 8) == 0 ? v2.changed(v1) : v2.changedInstance(v1);
            v3 = v3_1 ? 4 : 2;
            v3 |= v12;
        }
        else {
            v3 = v12;
        }

        int v6 = v14 & 1;
        if(v6 != 0) {
            v3 |= 0x30;
            goto label_42;
        }
        else if((v12 & 0x30) == 0) {
            v7 = arg34;
            v8 = v2.changed(v7) ? 0x20 : 16;
            v3 |= v8;
        }
        else {
        label_42:
            v7 = arg34;
        }

        v8 = v14 & 2;
        if(v8 != 0) {
            v3 |= 0x180;
            goto label_57;
        }
        else if((v12 & 0x180) == 0) {
            v9 = arg35;
            v10 = v2.changedInstance(v9) ? 0x100 : 0x80;
            v3 |= v10;
        }
        else {
        label_57:
            v9 = arg35;
        }

        v10 = v14 & 4;
        if(v10 != 0) {
            v3 |= 0xC00;
            goto label_72;
        }
        else if((v12 & 0xC00) == 0) {
            v13 = arg36;
            v15 = v2.changedInstance(v13) ? 0x800 : 0x400;
            v3 |= v15;
        }
        else {
        label_72:
            v13 = arg36;
        }

        v15 = v14 & 8;
        if(v15 != 0) {
            v3 |= 0x6000;
        }
        else if((v12 & 0x6000) == 0) {
            v17 = v2.changed(arg37) ? 0x4000 : 0x2000;
            v3 |= v17;
        }

        v17 = v14 & 16;
        int v18 = 0x30000;
        if(v17 != 0) {
            v3 |= v18;
        }
        else {
            float v0 = arg38;
            if((v12 & v18) == 0) {
                v19 = v2.changed(v0) ? 0x20000 : 0x10000;
                v3 |= v19;
            }
        }

        v19 = 0x180000;
        if((v12 & v19) == 0) {
            v5 = arg39;
            v22 = (v14 & 0x20) != 0 || !v2.changed(v5) ? 0x80000 : 0x100000;
            v3 |= v22;
        }

        if((v12 & 0xC00000) == 0) {
            RichTooltipColors v0_1 = arg40;
            v22 = (v14 & 0x40) != 0 || !v2.changed(v0_1) ? 0x400000 : 0x800000;
            v3 |= v22;
        }

        int v0_2 = v14 & 0x80;
        v22 = 0x6000000;
        if(v0_2 != 0) {
            v3 |= v22;
            goto label_147;
        }
        else if((v12 & v22) == 0) {
            v22 = v0_2;
            v23 = v2.changed(arg41) ? 0x4000000 : 0x2000000;
            v3 |= v23;
        }
        else {
        label_147:
            v22 = v0_2;
        }

        v0_2 = v14 & 0x100;
        v23 = 0x30000000;
        if(v0_2 != 0) {
            v3 |= v23;
            goto label_165;
        }
        else if((v12 & v23) == 0) {
            v23 = v0_2;
            v24 = v2.changed(arg42) ? 0x20000000 : 0x10000000;
            v3 |= v24;
        }
        else {
        label_165:
            v23 = v0_2;
        }

        if((v14 & 0x200) != 0) {
            v0_2 = arg46 | 6;
        }
        else if((arg46 & 6) == 0) {
            v0_2 = v2.changedInstance(v11) ? 4 : 2;
            v0_2 |= arg46;
        }
        else {
            v0_2 = arg46;
        }

        int v25 = v3;
        v24 = 0;
        v3_1 = (v25 & 306783379) != 306783378 || (v0_2 & 3) != 2 ? true : false;
        if(v2.shouldExecute(v3_1, v25 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "537@22236L25,538@22311L19");
            if((v12 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v6 != 0) {
                    v3_3 = Modifier.Companion;
                }
                else {
                    v3_2 = v7;
                }

                if(v8 != 0) {
                    v9 = null;
                }

                if(v10 != 0) {
                    v13 = null;
                }

                v6_1 = v15 != 0 ? null : arg37;
                v7_1 = v17 != 0 ? TooltipDefaults.INSTANCE.getRichTooltipMaxWidth-D9Ej5fM() : arg38;
                v10 = 6;
                if((v14 & 0x20) != 0) {
                    v8_1 = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(v2, v10);
                    v25 &= 0xFFC7FFFF;
                }
                else {
                    v8_1 = arg39;
                }

                if((v14 & 0x40) != 0) {
                    v10_1 = TooltipDefaults.INSTANCE.richTooltipColors(v2, v10);
                    v25 &= 0xFE3FFFFF;
                }
                else {
                    v10_1 = arg40;
                }

                float v15_1 = v22 != 0 ? ElevationTokens.INSTANCE.getLevel0-D9Ej5fM() : arg41;
                if(v23 != 0) {
                    v21 = v15_1;
                    v22_1 = RichTooltipTokens.INSTANCE.getContainerElevation-D9Ej5fM();
                }
                else {
                    v22_1 = arg42;
                    v21 = v15_1;
                }

                v15 = v25;
                v17 = 2;
            }
            else {
                v2.skipToGroupEnd();
                v3 = (v14 & 0x20) != 0 ? v25 & 0xFFC7FFFF : v25;
                if((v14 & 0x40) != 0) {
                    v3 &= 0xFE3FFFFF;
                }

                v6_1 = arg37;
                v8_1 = arg39;
                v10_1 = arg40;
                v21 = arg41;
                v22_1 = arg42;
                v15 = v3;
                v3_2 = v7;
                v17 = 2;
                v7_1 = arg38;
            }

            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(236290785, v15, v0_2, "androidx.compose.material3.RichTooltip (Tooltip.kt:542)");
            }

            if(v6_1 != null) {
                v2.startReplaceGroup(0xF953BFEA);
                ComposerKt.sourceInformation(v2, "546@22610L37,547@22683L7,548@22741L7,554@22955L24,559@23112L118");
                String v4 = "CC(remember):Tooltip.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(v2, -557800122, v4);
                Object v0_3 = v2.rememberedValue();
                if(v0_3 == Composer.Companion.getEmpty()) {
                    v37 = v7_1;
                    MutableState v0_4 = SnapshotStateKt.mutableStateOf$default(Matrix.box-impl(Matrix.constructor-impl$default(null, 1, null)), null, v17, null);
                    v2.updateRememberedValue(v0_4);
                }
                else {
                    v37 = v7_1;
                }

                Object v27 = v0_3;
                ComposerKt.sourceInformationMarkerEnd(v2);
                ProvidableCompositionLocal v0_5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(v2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                v0_3 = v2.consume(((CompositionLocal)v0_5));
                ComposerKt.sourceInformationMarkerEnd(v2);
                Object v28 = v0_3;
                v0_5 = CompositionLocalsKt.getLocalWindowInfo();
                ComposerKt.sourceInformationMarkerStart(v2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                v0_3 = v2.consume(((CompositionLocal)v0_5));
                ComposerKt.sourceInformationMarkerEnd(v2);
                long v29 = ((WindowInfo)v0_3).getContainerSize-YbymL2g();
                Companion v26 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(v2, 0xDEC0D059, v4);
                if((v15 & 14) != 4) {
                    if((v15 & 8) != 0 && (v2.changedInstance(v1))) {
                        goto label_335;
                    }

                    v0_2 = 0;
                }
                else {
                label_335:
                    v0_2 = 1;
                }

                Object v5_1 = v2.rememberedValue();
                if(v0_2 != 0 || v5_1 == Composer.Companion.getEmpty()) {
                    v5_2 = new TooltipKt$$ExternalSyntheticLambda7(v1);
                    v2.updateRememberedValue(v5_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v2);
                v0_6 = TooltipKt.layoutCaret-J5j9r9c(((Modifier)v26), ((MutableState)v27), ((Density)v28), v29, v5_2, v1.obtainPositionProvider());
                v5_1 = v27;
                v0_6 = v0_6.then(((Modifier)v3_3));
                ComposerKt.sourceInformationMarkerStart(v2, 0xDEC0E457, v4);
                int v7_2 = 0x100000;
                int v4_1 = (0x380000 & v15 ^ v19) > v7_2 && (v2.changed(v8_1)) || (v15 & v19) == v7_2 ? 1 : 0;
                arg34 = v0_6;
                if((0xE000 & v15) == 0x4000) {
                    v24 = 1;
                }

                v0_2 = v4_1 | v24;
                Object v4_2 = v2.rememberedValue();
                if(v0_2 != 0 || v4_2 == Composer.Companion.getEmpty()) {
                    TooltipCaretShape v4_3 = new TooltipCaretShape(((MutableState)v5_1), v8_1, v6_1);
                    v2.updateRememberedValue(v4_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v2);
                v2.endReplaceGroup();
                v0_6 = arg34;
                Object v16 = v4_2;
            }
            else {
                v37 = v7_1;
                v2.startReplaceGroup(-111306598);
                v2.endReplaceGroup();
                v0_6 = ((Modifier)v3_3);
                v16_1 = v8_1;
            }

            v7_1 = v37;
            arg34 = SizeKt.sizeIn-qDBjuR0$default(v0_6, TooltipKt.TooltipMinWidth, TooltipKt.TooltipMinHeight, v37, 0f, 8, null);
            v0_2 = v15 >> 12;
            v25_1 = v2;
            SurfaceKt.Surface-T9BRK9s(arg34, v16_1, v10_1.getContainerColor-0d7_KjU(), 0, v21, v22_1, null, ComposableLambdaKt.rememberComposableLambda(0xB58163E6, true, new TooltipKt$RichTooltip$4(v9, v13, v10_1, v11), v2, 54), v25_1, 0xE000 & v0_2 | 0xC00000 | v0_2 & 0x70000, 72);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v3_3);
            v5 = v6_1;
            v6_2 = v7_1;
            v7_3 = v8_1;
            v3_4 = v9;
            v8_2 = v10_1;
            v9_1 = v21;
            v10_2 = v22_1;
        }
        else {
            v25_1 = v2;
            v25_1.skipToGroupEnd();
            v5 = arg37;
            v6_2 = arg38;
            v8_2 = arg40;
            v10_2 = arg42;
            v2_1 = v7;
            v3_4 = v9;
            v7_3 = arg39;
            v9_1 = arg41;
        }

        Function2 v4_4 = v13;
        ScopeUpdateScope v15_2 = v25_1.endRestartGroup();
        if(v15_2 != null) {
            v15_2.updateScope(new TooltipKt$$ExternalSyntheticLambda8(arg33, v2_1, v3_4, v4_4, v5, v6_2, v7_3, v8_2, v9_1, v10_2, v11, v12, arg46, v14));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public static final void RichTooltip-ZuUcA3Q(TooltipScope arg26, Modifier arg27, Function2 arg28, Function2 arg29, long arg30, float arg32, Shape arg33, RichTooltipColors arg34, float arg35, float arg36, Function2 arg37, Composer arg38, int arg39, int arg40, int arg41) {
        long v5_2;
        float v7_3;
        RichTooltipColors v9_2;
        Modifier v2_4;
        float v11_1;
        Shape v8_2;
        Composer v0_2;
        float v10_2;
        Function2 v4_2;
        long v4_1;
        RichTooltipColors v7_1;
        float v9_1;
        Function2 v2_2;
        Modifier v1_3;
        float v6_1;
        float v8_1;
        Shape v10_1;
        Function2 v3_2;
        int v12_1;
        long v7_2;
        int v21;
        int v20;
        int v19;
        RichTooltipColors v5;
        int v18;
        float v4;
        int v16;
        long v13_1;
        Function2 v12;
        int v10;
        Function2 v9;
        int v8;
        Modifier v7;
        int v3;
        TooltipScope v0 = arg26;
        int v15 = arg39;
        int v1 = arg41;
        Composer v11 = arg38.startRestartGroup(0x814C00A7);
        ComposerKt.sourceInformation(v11, "C(RichTooltip)N(modifier,title,action,caretSize:c#ui.unit.DpSize,maxWidth:c#ui.unit.Dp,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,text)497@20615L226:Tooltip.kt#uh7d8r");
        if((0x80000000 & v1) != 0) {
            v3 = v15 | 6;
        }
        else if((v15 & 6) == 0) {
            boolean v3_1 = (v15 & 8) == 0 ? v11.changed(v0) : v11.changedInstance(v0);
            v3 = v3_1 ? 4 : 2;
            v3 |= v15;
        }
        else {
            v3 = v15;
        }

        int v6 = v1 & 1;
        if(v6 != 0) {
            v3 |= 0x30;
            goto label_41;
        }
        else if((v15 & 0x30) == 0) {
            v7 = arg27;
            v8 = v11.changed(v7) ? 0x20 : 16;
            v3 |= v8;
        }
        else {
        label_41:
            v7 = arg27;
        }

        v8 = v1 & 2;
        if(v8 != 0) {
            v3 |= 0x180;
            goto label_56;
        }
        else if((v15 & 0x180) == 0) {
            v9 = arg28;
            v10 = v11.changedInstance(v9) ? 0x100 : 0x80;
            v3 |= v10;
        }
        else {
        label_56:
            v9 = arg28;
        }

        v10 = v1 & 4;
        if(v10 != 0) {
            v3 |= 0xC00;
            goto label_71;
        }
        else if((v15 & 0xC00) == 0) {
            v12 = arg29;
            int v13 = v11.changedInstance(v12) ? 0x800 : 0x400;
            v3 |= v13;
        }
        else {
        label_71:
            v12 = arg29;
        }

        if((v15 & 0x6000) == 0) {
            if((v1 & 8) == 0) {
                v13_1 = arg30;
                if(v11.changed(v13_1)) {
                    v16 = 0x4000;
                }
                else {
                    goto label_82;
                }
            }
            else {
                v13_1 = arg30;
            label_82:
                v16 = 0x2000;
            }

            v3 |= v16;
        }
        else {
            v13_1 = arg30;
        }

        v16 = v1 & 16;
        int v17 = 0x30000;
        if(v16 != 0) {
            v3 |= v17;
            v4 = arg32;
        }
        else {
            v4 = arg32;
            if((v15 & v17) == 0) {
                v17 = v11.changed(v4) ? 0x20000 : 0x10000;
                v3 |= v17;
            }
        }

        if((v15 & 0x180000) == 0) {
            Shape v2 = arg33;
            v18 = (v1 & 0x20) != 0 || !v11.changed(v2) ? 0x80000 : 0x100000;
            v3 |= v18;
        }

        if((v15 & 0xC00000) == 0) {
            v5 = arg34;
            v19 = (v1 & 0x40) != 0 || !v11.changed(v5) ? 0x400000 : 0x800000;
            v3 |= v19;
        }
        else {
            v5 = arg34;
        }

        int v0_1 = v1 & 0x80;
        v19 = 0x6000000;
        if(v0_1 != 0) {
            v3 |= v19;
            goto label_145;
        }
        else if((v15 & v19) == 0) {
            v19 = v0_1;
            v20 = v11.changed(arg35) ? 0x4000000 : 0x2000000;
            v3 |= v20;
        }
        else {
        label_145:
            v19 = v0_1;
        }

        v0_1 = v1 & 0x100;
        v20 = 0x30000000;
        if(v0_1 != 0) {
            v3 |= v20;
            goto label_163;
        }
        else if((v15 & v20) == 0) {
            v20 = v0_1;
            v21 = v11.changed(arg36) ? 0x20000000 : 0x10000000;
            v3 |= v21;
        }
        else {
        label_163:
            v20 = v0_1;
        }

        if((v1 & 0x200) != 0) {
            v0_1 = arg40 | 6;
        }
        else if((arg40 & 6) == 0) {
            v21 = v11.changedInstance(arg37) ? 4 : 2;
            v0_1 = arg40 | v21;
        }
        else {
            v0_1 = arg40;
        }

        boolean v1_1 = (v3 & 306783379) != 306783378 || (v0_1 & 3) != 2 ? true : false;
        if(v11.shouldExecute(v1_1, v3 & 1)) {
            v11.startDefaults();
            ComposerKt.sourceInformation(v11, "491@20364L25,492@20439L19");
            int v2_1 = 0xFE3FFFFF;
            v18 = 0xFFC7FFFF;
            v21 = 0xFFFF1FFF;
            if((v15 & 1) == 0 || (v11.getDefaultsInvalid())) {
                if(v6 != 0) {
                    Companion v1_4 = Modifier.Companion;
                }
                else {
                    v1_3 = v7;
                }

                Function2 v6_2 = null;
                if(v8 != 0) {
                    v9 = v6_2;
                }

                if(v10 != 0) {
                }
                else {
                    v6_2 = v12;
                }

                if((arg41 & 8) != 0) {
                    v7_2 = DpSize.Companion.getUnspecified-MYxV2XQ();
                    v3 &= v21;
                }
                else {
                    v7_2 = v13_1;
                }

                if(v16 != 0) {
                    v4 = TooltipDefaults.INSTANCE.getRichTooltipMaxWidth-D9Ej5fM();
                }

                v12_1 = 6;
                if((arg41 & 0x20) != 0) {
                    v10_1 = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(v11, v12_1);
                    v3 &= v18;
                }
                else {
                    v10_1 = arg33;
                }

                if((arg41 & 0x40) != 0) {
                    v5 = TooltipDefaults.INSTANCE.richTooltipColors(v11, v12_1);
                    v3 &= v2_1;
                }

                float v2_3 = v19 != 0 ? ElevationTokens.INSTANCE.getLevel0-D9Ej5fM() : arg35;
                if(v20 != 0) {
                    long v23 = v7_2;
                    v8_1 = v2_3;
                    v7_1 = v5;
                    v2_2 = v9;
                    v9_1 = RichTooltipTokens.INSTANCE.getContainerElevation-D9Ej5fM();
                    v12_1 = v3;
                    v3_2 = v6_2;
                    v6_1 = v4;
                    v4_1 = v23;
                    goto label_291;
                }

                v12_1 = v3;
                v3_2 = v6_2;
                v6_1 = v4;
                Function2 v23_1 = v9;
                v9_1 = arg36;
                long v24 = v7_2;
                v8_1 = v2_3;
                v7_1 = v5;
                v4_1 = v24;
                v2_2 = v23_1;
            }
            else {
                v11.skipToGroupEnd();
                if((arg41 & 8) != 0) {
                    v3 &= v21;
                }

                if((arg41 & 0x20) != 0) {
                    v3 &= v18;
                }

                if((arg41 & 0x40) != 0) {
                    v3 &= v2_1;
                }

                Function2 v1_2 = v12;
                v12_1 = v3;
                v3_2 = v1_2;
                v10_1 = arg33;
                v8_1 = arg35;
                v6_1 = v4;
                v1_3 = v7;
                v2_2 = v9;
                v9_1 = arg36;
                v7_1 = v5;
                v4_1 = v13_1;
            }

        label_291:
            v11.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x814C00A7, v12_1, v0_1, "androidx.compose.material3.RichTooltip (Tooltip.kt:497)");
            }

            Shape v13_2 = TooltipDefaults.INSTANCE.caretShape-EaSLcWc(v4_1);
            long v16_1 = v4_1;
            float v5_1 = v6_1;
            Shape v6_3 = v10_1;
            TooltipKt.RichTooltip-EkvW5A0(arg26, v1_3, v2_2, v3_2, v13_2, v5_1, v6_3, v7_1, v8_1, v9_1, arg37, v11, v12_1 & 0x7FFF1FFE, v0_1 & 14, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_2 = v3_2;
            v10_2 = v8_1;
            v0_2 = v11;
            v3_2 = v2_2;
            v8_2 = v6_3;
            v11_1 = v9_1;
            v2_4 = v1_3;
            v9_2 = v7_1;
            v7_3 = v5_1;
            v5_2 = v16_1;
        }
        else {
            v11.skipToGroupEnd();
            v8_2 = arg33;
            v10_2 = arg35;
            v2_4 = v7;
            v3_2 = v9;
            v0_2 = v11;
            v11_1 = arg36;
            v7_3 = v4;
            v9_2 = v5;
            v4_2 = v12;
            v5_2 = v13_1;
        }

        ScopeUpdateScope v0_3 = v0_2.endRestartGroup();
        if(v0_3 != null) {
            v0_3.updateScope(new TooltipKt$$ExternalSyntheticLambda2(arg26, v2_4, v3_2, v4_2, v5_2, v7_3, v8_2, v9_2, v10_2, v11_1, arg37, v15, arg40, arg41));
        }
    }

    static final LayoutCoordinates RichTooltip_EkvW5A0$lambda$15$lambda$14(TooltipScope arg0, MeasureScope arg1) {
        return arg0.obtainAnchorBounds(arg1);
    }

    static final Unit RichTooltip_EkvW5A0$lambda$17(TooltipScope arg16, Modifier arg17, Function2 arg18, Function2 arg19, Shape arg20, float arg21, Shape arg22, RichTooltipColors arg23, float arg24, float arg25, Function2 arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        TooltipKt.RichTooltip-EkvW5A0(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    static final Unit RichTooltip_ZuUcA3Q$lambda$12(TooltipScope arg17, Modifier arg18, Function2 arg19, Function2 arg20, long arg21, float arg23, Shape arg24, RichTooltipColors arg25, float arg26, float arg27, Function2 arg28, int arg29, int arg30, int arg31, Composer arg32, int arg33) {
        TooltipKt.RichTooltip-ZuUcA3Q(arg17, arg18, arg19, arg20, arg21, arg23, arg24, arg25, arg26, arg27, arg28, arg32, RecomposeScopeImplKt.updateChangedFlags(arg29 | 1), RecomposeScopeImplKt.updateChangedFlags(arg30), arg31);
        return Unit.INSTANCE;
    }

    public static final void TooltipBox(PopupPositionProvider arg20, Function3 arg21, TooltipState arg22, Modifier arg23, Function0 arg24, boolean arg25, boolean arg26, boolean arg27, Function2 arg28, Composer arg29, int arg30, int arg31) {
        Modifier v4_4;
        Function0 v5_2;
        boolean v8_2;
        MutableState v4_2;
        boolean v7_1;
        boolean v6_2;
        int v19;
        int v16;
        boolean v11_1;
        int v10;
        Function0 v8;
        int v7;
        Modifier v6;
        boolean v5_1;
        int v5;
        int v3;
        PopupPositionProvider v0 = arg20;
        Function3 v12 = arg21;
        TooltipState v2 = arg22;
        Function2 v13 = arg28;
        int v14 = arg30;
        int v15 = arg31;
        Composer v9 = arg29.startRestartGroup(0xEE7DAB80);
        ComposerKt.sourceInformation(v9, "C(TooltipBox)N(positionProvider,tooltip,state,modifier,onDismissRequest,focusable,enableUserInput,hasAction,content)311@13450L64,312@13572L33,313@13622L71,315@13744L103,321@13933L64,319@13853L387:Tooltip.kt#uh7d8r");
        if((v15 & 1) != 0) {
            v3 = v14 | 6;
        }
        else if((v14 & 6) == 0) {
            v3 = v9.changed(v0) ? 4 : 2;
            v3 |= v14;
        }
        else {
            v3 = v14;
        }

        if((v15 & 2) != 0) {
            v3 |= 0x30;
        }
        else if((v14 & 0x30) == 0) {
            v5 = v9.changedInstance(v12) ? 0x20 : 16;
            v3 |= v5;
        }

        if((v15 & 4) != 0) {
            v3 |= 0x180;
        }
        else if((v14 & 0x180) == 0) {
            v5_1 = (v14 & 0x200) == 0 ? v9.changed(v2) : v9.changedInstance(v2);
            v5 = v5_1 ? 0x100 : 0x80;
            v3 |= v5;
        }

        v5 = v15 & 8;
        if(v5 != 0) {
            v3 |= 0xC00;
            goto label_67;
        }
        else if((v14 & 0xC00) == 0) {
            v6 = arg23;
            v7 = v9.changed(v6) ? 0x800 : 0x400;
            v3 |= v7;
        }
        else {
        label_67:
            v6 = arg23;
        }

        v7 = v15 & 16;
        if(v7 != 0) {
            v3 |= 0x6000;
            goto label_82;
        }
        else if((v14 & 0x6000) == 0) {
            v8 = arg24;
            v10 = v9.changedInstance(v8) ? 0x4000 : 0x2000;
            v3 |= v10;
        }
        else {
        label_82:
            v8 = arg24;
        }

        v10 = v15 & 0x20;
        int v11 = 0x30000;
        if(v10 != 0) {
            v3 |= v11;
            goto label_98;
        }
        else if((v11 & v14) == 0) {
            v11_1 = arg25;
            v16 = v9.changed(v11_1) ? 0x20000 : 0x10000;
            v3 |= v16;
        }
        else {
        label_98:
            v11_1 = arg25;
        }

        v16 = v15 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v3 |= v17;
        }
        else {
            boolean v4 = arg26;
            if((v14 & v17) == 0) {
                v17 = v9.changed(v4) ? 0x100000 : 0x80000;
                v3 |= v17;
            }
        }

        int v1 = v15 & 0x80;
        int v18 = 0xC00000;
        if(v1 != 0) {
            v3 |= v18;
            goto label_130;
        }
        else if((v14 & v18) == 0) {
            v18 = v1;
            v19 = v9.changed(arg27) ? 0x800000 : 0x400000;
            v3 |= v19;
        }
        else {
        label_130:
            v18 = v1;
        }

        v19 = 0x6000000;
        if((v15 & 0x100) != 0) {
            v3 |= v19;
        }
        else if((v14 & v19) == 0) {
            v1 = v9.changedInstance(v13) ? 0x4000000 : 0x2000000;
            v3 |= v1;
        }

        boolean v1_1 = (0x2492493 & v3) != 0x2492492 ? true : false;
        if(v9.shouldExecute(v1_1, v3 & 1)) {
            if(v5 != 0) {
                Companion v6_1 = Modifier.Companion;
            }

            if(v7 != 0) {
                v8 = null;
            }

            v5_1 = v10 != 0 ? false : v11_1;
            Modifier v2_1 = v6;
            v6_2 = v16 != 0 ? true : arg26;
            v7_1 = v18 != 0 ? false : arg27;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xEE7DAB80, v3, -1, "androidx.compose.material3.TooltipBox (Tooltip.kt:309)");
            }

            Transition v1_2 = TransitionKt.updateTransition(arg22.getTransition(), "tooltip transition", v9, MutableTransitionState.$stable | 0x30, 0);
            String v10_1 = "CC(remember):Tooltip.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v9, 1170281089, v10_1);
            Object v4_1 = v9.rememberedValue();
            if(v4_1 == Composer.Companion.getEmpty()) {
                arg23 = v2_1;
                v4_2 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                v9.updateRememberedValue(v4_2);
            }
            else {
                arg23 = v2_1;
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerStart(v9, 1170282727, v10_1);
            Object v2_2 = v9.rememberedValue();
            if(v2_2 == Composer.Companion.getEmpty()) {
                TooltipScopeImpl v2_3 = new TooltipScopeImpl(new TooltipKt$$ExternalSyntheticLambda11(v4_2), v0);
                v9.updateRememberedValue(v2_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            Function0 v0_1 = v8;
            ComposableLambda v8_1 = ComposableLambdaKt.rememberComposableLambda(-23901870, true, new TooltipKt$TooltipBox$wrappedContent$1(v4_2, v13), v9, 54);
            Function0 v4_3 = v0_1;
            BasicTooltipKt.BasicTooltipBox(arg20, ComposableLambdaKt.rememberComposableLambda(0xE0907DB6, true, new TooltipKt$TooltipBox$3(v1_2, v12, ((TooltipScopeImpl)v2_2)), v9, 54), arg22, arg23, v4_3, v5_1, v6_2, v7_1, ((Function2)v8_1), v9, v3 & 14 | 0x6000030 | v3 & 0x380 | v3 & 0x1C00 | 0xE000 & v3 | 0x70000 & v3 | 0x380000 & v3 | 0x1C00000 & v3, 0);
            v2_1 = arg23;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8_2 = v7_1;
            v7_1 = v6_2;
            v6_2 = v5_1;
            v5_2 = v4_3;
            v4_4 = v2_1;
        }
        else {
            v9.skipToGroupEnd();
            v7_1 = arg26;
            v4_4 = v6;
            v5_2 = v8;
            v6_2 = v11_1;
            v8_2 = arg27;
        }

        ScopeUpdateScope v0_2 = v9.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new TooltipKt$$ExternalSyntheticLambda1(arg20, v12, arg22, v4_4, v5_2, v6_2, v7_1, v8_2, v13, v14, v15));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in favor of TooltipBox API that contains hasAction param.") public static final void TooltipBox(PopupPositionProvider arg17, Function3 arg18, TooltipState arg19, Modifier arg20, Function0 arg21, boolean arg22, boolean arg23, Function2 arg24, Composer arg25, int arg26, int arg27) {
        Function0 v5_2;
        boolean v7_1;
        Modifier v4;
        boolean v6_2;
        Companion v6_1;
        Function2 v14_1;
        boolean v11_1;
        int v10;
        boolean v8_1;
        int v7;
        Modifier v6;
        boolean v5_1;
        int v5;
        PopupPositionProvider v1;
        int v3;
        TooltipState v2 = arg19;
        int v12 = arg26;
        int v13 = arg27;
        Composer v9 = arg25.startRestartGroup(2055306788);
        ComposerKt.sourceInformation(v9, "C(TooltipBox)N(positionProvider,tooltip,state,modifier,onDismissRequest,focusable,enableUserInput,content)209@9135L302:Tooltip.kt#uh7d8r");
        if((v13 & 1) != 0) {
            v3 = v12 | 6;
            v1 = arg17;
        }
        else if((v12 & 6) == 0) {
            v1 = arg17;
            v3 = v9.changed(v1) ? 4 : 2;
            v3 |= v12;
        }
        else {
            v1 = arg17;
            v3 = v12;
        }

        if((v13 & 2) != 0) {
            v3 |= 0x30;
        }
        else if((v12 & 0x30) == 0) {
            v5 = v9.changedInstance(arg18) ? 0x20 : 16;
            v3 |= v5;
        }

        if((v13 & 4) != 0) {
            v3 |= 0x180;
        }
        else if((v12 & 0x180) == 0) {
            v5_1 = (v12 & 0x200) == 0 ? v9.changed(v2) : v9.changedInstance(v2);
            v5 = v5_1 ? 0x100 : 0x80;
            v3 |= v5;
        }

        v5 = v13 & 8;
        if(v5 != 0) {
            v3 |= 0xC00;
            goto label_71;
        }
        else if((v12 & 0xC00) == 0) {
            v6 = arg20;
            v7 = v9.changed(v6) ? 0x800 : 0x400;
            v3 |= v7;
        }
        else {
        label_71:
            v6 = arg20;
        }

        v7 = v13 & 0x20;
        int v8 = 0x30000;
        if(v7 != 0) {
            v3 |= v8;
            goto label_87;
        }
        else if((v8 & v12) == 0) {
            v8_1 = arg22;
            v10 = v9.changed(v8_1) ? 0x20000 : 0x10000;
            v3 |= v10;
        }
        else {
        label_87:
            v8_1 = arg22;
        }

        v10 = v13 & 0x40;
        int v11 = 0x180000;
        if(v10 != 0) {
            v3 |= v11;
            goto label_103;
        }
        else if((v11 & v12) == 0) {
            v11_1 = arg23;
            int v14 = v9.changed(v11_1) ? 0x100000 : 0x80000;
            v3 |= v14;
        }
        else {
        label_103:
            v11_1 = arg23;
        }

        int v15 = 0xC00000;
        if((v13 & 0x80) != 0) {
            v3 |= v15;
            goto label_119;
        }
        else if((v12 & v15) == 0) {
            v14_1 = arg24;
            v15 = v9.changedInstance(v14_1) ? 0x800000 : 0x400000;
            v3 |= v15;
        }
        else {
        label_119:
            v14_1 = arg24;
        }

        boolean v0 = (0x490493 & v3) != 0x490492 ? true : false;
        if(v9.shouldExecute(v0, v3 & 1)) {
            if(v5 != 0) {
                v6_1 = Modifier.Companion;
            }

            Function0 v15_1 = (v13 & 16) != 0 ? null : arg21;
            v5_1 = v7 != 0 ? true : v8_1;
            Modifier v0_1 = ((Modifier)v6_1);
            v6_2 = v10 != 0 ? true : v11_1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2055306788, v3, -1, "androidx.compose.material3.TooltipBox (Tooltip.kt:208)");
            }

            TooltipKt.TooltipBox(v1, arg18, v2, v0_1, null, v5_1, v6_2, false, v14_1, v9, v3 & 14 | 0xC06000 | v3 & 0x70 | v3 & 0x380 | v3 & 0x1C00 | 0x70000 & v3 | 0x380000 & v3 | v3 << 3 & 0xE000000, 0);
            v0_1 = v0_1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4 = v0_1;
            v7_1 = v6_2;
            v6_2 = v5_1;
            v5_2 = v15_1;
        }
        else {
            v9.skipToGroupEnd();
            v5_2 = arg21;
            v4 = v6;
            v6_2 = v8_1;
            v7_1 = v11_1;
        }

        ScopeUpdateScope v11_2 = v9.endRestartGroup();
        if(v11_2 != null) {
            v11_2.updateScope(new TooltipKt$$ExternalSyntheticLambda4(arg17, arg18, arg19, v4, v5_2, v6_2, v7_1, arg24, v12, v13));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in favor of TooltipBox API that contains onDismissRequest and hasAction params.") public static final void TooltipBox(PopupPositionProvider arg17, Function3 arg18, TooltipState arg19, Modifier arg20, boolean arg21, boolean arg22, Function2 arg23, Composer arg24, int arg25, int arg26) {
        Modifier v4;
        boolean v6_2;
        Companion v6_1;
        Function2 v13_1;
        boolean v11_1;
        int v10;
        boolean v8;
        int v7;
        Modifier v6;
        boolean v5_1;
        int v5;
        PopupPositionProvider v1;
        int v3;
        TooltipState v2 = arg19;
        int v12 = arg25;
        int v0 = 0xE99741D8;
        Composer v9 = arg24.startRestartGroup(v0);
        ComposerKt.sourceInformation(v9, "C(TooltipBox)N(positionProvider,tooltip,state,modifier,focusable,enableUserInput,content)118@5365L302:Tooltip.kt#uh7d8r");
        if((arg26 & 1) != 0) {
            v3 = v12 | 6;
            v1 = arg17;
        }
        else if((v12 & 6) == 0) {
            v1 = arg17;
            v3 = v9.changed(v1) ? 4 : 2;
            v3 |= v12;
        }
        else {
            v1 = arg17;
            v3 = v12;
        }

        if((arg26 & 2) != 0) {
            v3 |= 0x30;
        }
        else if((v12 & 0x30) == 0) {
            v5 = v9.changedInstance(arg18) ? 0x20 : 16;
            v3 |= v5;
        }

        if((arg26 & 4) != 0) {
            v3 |= 0x180;
        }
        else if((v12 & 0x180) == 0) {
            v5_1 = (v12 & 0x200) == 0 ? v9.changed(v2) : v9.changedInstance(v2);
            v5 = v5_1 ? 0x100 : 0x80;
            v3 |= v5;
        }

        v5 = arg26 & 8;
        if(v5 != 0) {
            v3 |= 0xC00;
            goto label_70;
        }
        else if((v12 & 0xC00) == 0) {
            v6 = arg20;
            v7 = v9.changed(v6) ? 0x800 : 0x400;
            v3 |= v7;
        }
        else {
        label_70:
            v6 = arg20;
        }

        v7 = arg26 & 16;
        if(v7 != 0) {
            v3 |= 0x6000;
            goto label_85;
        }
        else if((v12 & 0x6000) == 0) {
            v8 = arg21;
            v10 = v9.changed(v8) ? 0x4000 : 0x2000;
            v3 |= v10;
        }
        else {
        label_85:
            v8 = arg21;
        }

        v10 = arg26 & 0x20;
        int v11 = 0x30000;
        if(v10 != 0) {
            v3 |= v11;
            goto label_101;
        }
        else if((v11 & v12) == 0) {
            v11_1 = arg22;
            int v13 = v9.changed(v11_1) ? 0x20000 : 0x10000;
            v3 |= v13;
        }
        else {
        label_101:
            v11_1 = arg22;
        }

        int v14 = 0x180000;
        if((arg26 & 0x40) != 0) {
            v3 |= v14;
            goto label_117;
        }
        else if((v12 & v14) == 0) {
            v13_1 = arg23;
            v14 = v9.changedInstance(v13_1) ? 0x100000 : 0x80000;
            v3 |= v14;
        }
        else {
        label_117:
            v13_1 = arg23;
        }

        boolean v14_1 = (0x92493 & v3) != 0x92492 ? true : false;
        if(v9.shouldExecute(v14_1, v3 & 1)) {
            if(v5 != 0) {
                v6_1 = Modifier.Companion;
            }

            v5_1 = v7 != 0 ? true : v8;
            Modifier v7_1 = ((Modifier)v6_1);
            v6_2 = v10 != 0 ? true : v11_1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.TooltipBox (Tooltip.kt:118)");
            }

            int v8_1 = v3 << 3;
            v10 = v3 & 14 | 0xC06000 | v3 & 0x70 | v3 & 0x380 | v3 & 0x1C00 | 0x70000 & v8_1 | v8_1 & 0x380000 | v3 << 6 & 0xE000000;
            Modifier v3_1 = v7_1;
            TooltipKt.TooltipBox(v1, arg18, v2, v3_1, null, v5_1, v6_2, false, v13_1, v9, v10, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4 = v3_1;
        }
        else {
            v9.skipToGroupEnd();
            v4 = v6;
            v5_1 = v8;
            v6_2 = v11_1;
        }

        ScopeUpdateScope v10_1 = v9.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new TooltipKt$$ExternalSyntheticLambda6(arg17, arg18, arg19, v4, v5_1, v6_2, arg23, v12, arg26));
        }
    }

    static final Unit TooltipBox$lambda$0(PopupPositionProvider arg11, Function3 arg12, TooltipState arg13, Modifier arg14, boolean arg15, boolean arg16, Function2 arg17, int arg18, int arg19, Composer arg20, int arg21) {
        TooltipKt.TooltipBox(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    static final Unit TooltipBox$lambda$1(PopupPositionProvider arg12, Function3 arg13, TooltipState arg14, Modifier arg15, Function0 arg16, boolean arg17, boolean arg18, Function2 arg19, int arg20, int arg21, Composer arg22, int arg23) {
        TooltipKt.TooltipBox(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    static final LayoutCoordinates TooltipBox$lambda$4$lambda$3(MutableState arg0) {
        return arg0.getValue();
    }

    static final Unit TooltipBox$lambda$5(PopupPositionProvider arg13, Function3 arg14, TooltipState arg15, Modifier arg16, Function0 arg17, boolean arg18, boolean arg19, boolean arg20, Function2 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        TooltipKt.TooltipBox(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    public static final TooltipState TooltipState(boolean arg1, boolean arg2, MutatorMutex arg3) {
        return new TooltipStateImpl(arg1, arg2, arg3);
    }

    public static TooltipState TooltipState$default(boolean arg0, boolean arg1, MutatorMutex arg2, int arg3, Object arg4) {
        if((arg3 & 4) != 0) {
            arg2 = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }

        return TooltipKt.TooltipState(false, true, arg2);
    }

    public static final Modifier animateTooltip(Modifier arg2, Transition arg3) {
        Function1 v0_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            TooltipKt$animateTooltip$$inlined$debugInspectorInfo$1 v0 = new TooltipKt$animateTooltip$$inlined$debugInspectorInfo$1(arg3);
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg2, v0_1, new TooltipKt$animateTooltip$2(arg3));
    }

    public static final float caretX(float arg5, int arg6, Rect arg7) {
        float v0 = arg7.getLeft();
        float v7 = arg7.getRight();
        float v2 = 2f;
        float v1 = (v0 + v7) / v2;
        float v6 = ((float)arg6);
        if(arg5 >= v6) {
            return v1;
        }

        v2 = arg5 / v2;
        if(v1 - v2 < 0f) {
            arg5 = Math.max(arg5 - v6, -v0);
        }
        else if(v1 + v2 > v6) {
            arg5 = Math.min(arg5 - v7, 0f);
        }
        else {
            return v2;
        }

        return v1 + arg5;
    }

    public static final float getActionLabelBottomPadding() {
        return TooltipKt.ActionLabelBottomPadding;
    }

    public static final float getActionLabelMinHeight() {
        return TooltipKt.ActionLabelMinHeight;
    }

    public static final float getHeightToSubheadFirstLine() {
        return TooltipKt.HeightToSubheadFirstLine;
    }

    public static final PaddingValues getPlainTooltipContentPadding() {
        return TooltipKt.PlainTooltipContentPadding;
    }

    public static final float getRichTooltipHorizontalPadding() {
        return TooltipKt.RichTooltipHorizontalPadding;
    }

    public static final float getSpacingBetweenTooltipAndAnchor() {
        return TooltipKt.SpacingBetweenTooltipAndAnchor;
    }

    public static final float getTooltipMinHeight() {
        return TooltipKt.TooltipMinHeight;
    }

    public static final float getTooltipMinWidth() {
        return TooltipKt.TooltipMinWidth;
    }

    private static final Modifier layoutCaret-J5j9r9c(Modifier arg7, MutableState arg8, Density arg9, long arg10, Function1 arg12, PopupPositionProvider arg13) {
        return LayoutModifierKt.layout(arg7, new TooltipKt$$ExternalSyntheticLambda5(arg10, arg12, arg9, arg13, arg8));
    }

    static final MeasureResult layoutCaret_J5j9r9c$lambda$22(long arg24, Function1 arg26, Density arg27, PopupPositionProvider arg28, MutableState arg29, MeasureScope arg30, Measurable arg31, Constraints arg32) {
        long v7_2;
        float v7_1;
        int v25;
        int v7;
        float v24;
        PopupPositionProvider v0 = arg28;
        Placeable v1 = arg31.measure-BRTryo0(arg32.unbox-impl());
        int v3 = v1.getWidth();
        int v4 = v1.getHeight();
        int v5 = ((int)(arg24 >> 0x20));
        long v6 = 0xFFFFFFFFL;
        int v8 = ((int)(arg24 & v6));
        float v9 = ((float)v3);
        float v10 = ((float)v4);
        int v12 = 0x20;
        MeasureScope v2 = arg30;
        Object v11 = arg26.invoke(v2);
        if(v11 != null) {
            int v13 = arg27.roundToPx-0680j_4(TooltipKt.SpacingBetweenTooltipAndAnchor);
            Rect v11_1 = LayoutCoordinatesKt.boundsInWindow(((LayoutCoordinates)v11));
            float v14 = v11_1.getTop();
            float v15 = v11_1.getBottom();
            float v16 = v11_1.getRight();
            float v17 = v11_1.getLeft();
            long v31 = v6;
            boolean v6_1 = v0 instanceof TooltipPositionProviderImpl;
            if(v6_1) {
                v24 = 0f;
                v7 = v0.getType-lOKsHw4();
                v25 = v12;
                if(!TooltipAnchorPosition.equals-impl0(v7, TooltipAnchorPosition.Companion.getLeft-lOKsHw4()) && !TooltipAnchorPosition.equals-impl0(v7, TooltipAnchorPosition.Companion.getRight-lOKsHw4()) && !TooltipAnchorPosition.equals-impl0(v7, TooltipAnchorPosition.Companion.getStart-lOKsHw4())) {
                    if(TooltipAnchorPosition.equals-impl0(v7, TooltipAnchorPosition.Companion.getEnd-lOKsHw4())) {
                    }
                    else if(TooltipAnchorPosition.equals-impl0(v7, TooltipAnchorPosition.Companion.getAbove-lOKsHw4())) {
                        if(v14 - v10 - (((float)v13)) < 0f) {
                            goto label_84;
                        }
                        else {
                            goto label_85;
                        }
                    }
                    else if(TooltipAnchorPosition.equals-impl0(v7, TooltipAnchorPosition.Companion.getBelow-lOKsHw4())) {
                        if(v15 + v10 + (((float)v13)) > (((float)v8))) {
                            goto label_85;
                        }
                        else {
                            goto label_84;
                        }
                    }
                    else if(v14 - v10 - (((float)v13)) < 0f) {
                        goto label_84;
                    }
                    else {
                        goto label_85;
                    }
                }

                v10 /= 2f;
            }
            else {
                v25 = v12;
                v24 = 0f;
                if(v14 - v10 - (((float)v13)) >= 0f) {
                    goto label_85;
                }

            label_84:
                v10 = v24;
            }

        label_85:
            if(v6_1) {
                v7 = v0.getType-lOKsHw4();
                if(TooltipAnchorPosition.equals-impl0(v7, TooltipAnchorPosition.Companion.getLeft-lOKsHw4())) {
                    v7_1 = v17 - (((float)v13)) - v9 < v24 ? v24 : v9;
                    v7_2 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v7_1))) << v25 | (((long)Float.floatToRawIntBits(v10))) & v31);
                }
                else {
                    if(TooltipAnchorPosition.equals-impl0(v7, TooltipAnchorPosition.Companion.getRight-lOKsHw4())) {
                        v7_1 = v16 + (((float)v13)) + v9 > (((float)v5)) ? v9 : v24;
                        v7_2 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v7_1))) << v25 | (((long)Float.floatToRawIntBits(v10))) & v31);
                        goto label_206;
                    }

                    if(TooltipAnchorPosition.equals-impl0(v7, TooltipAnchorPosition.Companion.getStart-lOKsHw4())) {
                        if(v2.getLayoutDirection() == LayoutDirection.Ltr) {
                            if(v17 - (((float)v13)) - v9 < v24) {
                                goto label_148;
                            }
                            else {
                                goto label_146;
                            }
                        }
                        else if(v16 + (((float)v13)) + v9 > (((float)v5))) {
                        label_146:
                            v7_1 = v9;
                        }
                        else {
                        label_148:
                            v7_1 = v24;
                        }

                        v7_2 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v7_1))) << v25 | (((long)Float.floatToRawIntBits(v10))) & v31);
                        goto label_206;
                    }

                    if(TooltipAnchorPosition.equals-impl0(v7, TooltipAnchorPosition.Companion.getEnd-lOKsHw4())) {
                        if(v2.getLayoutDirection() == LayoutDirection.Ltr) {
                            if(v16 + (((float)v13)) + v9 > (((float)v5))) {
                                goto label_177;
                            }
                            else {
                                goto label_175;
                            }
                        }
                        else if(v17 - (((float)v13)) - v9 < v24) {
                        label_175:
                            v7_1 = v24;
                        }
                        else {
                        label_177:
                            v7_1 = v9;
                        }

                        v7_2 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v7_1))) << v25 | (((long)Float.floatToRawIntBits(v10))) & v31);
                        goto label_206;
                    }

                    v7_2 = Offset.constructor-impl((((long)Float.floatToRawIntBits(TooltipKt.caretX(v9, v5, v11_1)))) << v25 | (((long)Float.floatToRawIntBits(v10))) & v31);
                }
            }
            else {
                v7_2 = Offset.constructor-impl((((long)Float.floatToRawIntBits(TooltipKt.caretX(v9, v5, v11_1)))) << v25 | (((long)Float.floatToRawIntBits(v10))) & v31);
            }

        label_206:
            float[] v18 = Matrix.constructor-impl$default(null, 1, null);
            Matrix.translate-impl$default(v18, Float.intBitsToFloat(((int)(v7_2 >> v25))), Float.intBitsToFloat(((int)(v7_2 & v31))), 0f, 4, null);
            float[] v7_3 = v18;
            float v8_1 = 180f;
            if(v6_1) {
                int v0_1 = ((TooltipPositionProviderImpl)v0).getType-lOKsHw4();
                float v11_2 = 90f;
                float v12_1 = -90f;
                if(TooltipAnchorPosition.equals-impl0(v0_1, TooltipAnchorPosition.Companion.getLeft-lOKsHw4())) {
                    if(v17 - (((float)v13)) - v9 < v24) {
                        Matrix.rotateZ-impl(v7_3, v11_2);
                    }
                    else {
                        Matrix.rotateZ-impl(v7_3, v12_1);
                    }
                }
                else if(TooltipAnchorPosition.equals-impl0(v0_1, TooltipAnchorPosition.Companion.getRight-lOKsHw4())) {
                    if(v16 + (((float)v13)) + v9 > (((float)v5))) {
                        Matrix.rotateZ-impl(v7_3, v12_1);
                    }
                    else {
                        Matrix.rotateZ-impl(v7_3, v11_2);
                    }
                }
                else if(TooltipAnchorPosition.equals-impl0(v0_1, TooltipAnchorPosition.Companion.getStart-lOKsHw4())) {
                    if(v2.getLayoutDirection() == LayoutDirection.Ltr) {
                        if(v17 - (((float)v13)) - v9 < v24) {
                            Matrix.rotateZ-impl(v7_3, v11_2);
                        }
                        else {
                            Matrix.rotateZ-impl(v7_3, v12_1);
                        }
                    }
                    else if(v16 + (((float)v13)) + v9 > (((float)v5))) {
                        Matrix.rotateZ-impl(v7_3, v12_1);
                    }
                    else {
                        Matrix.rotateZ-impl(v7_3, v11_2);
                    }
                }
                else if(TooltipAnchorPosition.equals-impl0(v0_1, TooltipAnchorPosition.Companion.getEnd-lOKsHw4())) {
                    if(v2.getLayoutDirection() == LayoutDirection.Ltr) {
                        if(v16 + (((float)v13)) + v9 > (((float)v5))) {
                            Matrix.rotateZ-impl(v7_3, v12_1);
                        }
                        else {
                            Matrix.rotateZ-impl(v7_3, v11_2);
                        }
                    }
                    else if(v17 - (((float)v13)) - v9 < v24) {
                        Matrix.rotateZ-impl(v7_3, v11_2);
                    }
                    else {
                        Matrix.rotateZ-impl(v7_3, v12_1);
                    }
                }
                else if(v10 == v24) {
                    Matrix.rotateX-impl(v7_3, v8_1);
                }
            }
            else if(v10 == v24) {
                Matrix.rotateX-impl(v7_3, v8_1);
            }

            arg29.setValue(Matrix.box-impl(v7_3));
        }

        return MeasureScope.layout$default(v2, v3, v4, null, new TooltipKt$$ExternalSyntheticLambda10(v1), 4, null);
    }

    static final Unit layoutCaret_J5j9r9c$lambda$22$lambda$21(Placeable arg7, PlacementScope arg8) {
        PlacementScope.place$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public static final TooltipState rememberTooltipState(boolean arg4, boolean arg5, MutatorMutex arg6, Composer arg7, int arg8, int arg9) {
        int v1 = -1413230530;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(rememberTooltipState)N(initialIsVisible,isPersistent,mutatorMutex)962@39859L211:Tooltip.kt#uh7d8r");
        int v2 = 0;
        if((arg9 & 4) != 0) {
            arg6 = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.material3.rememberTooltipState (Tooltip.kt:962)");
        }

        ComposerKt.sourceInformationMarkerStart(arg7, 0xCA10D6D1, "CC(remember):Tooltip.kt#9igjgp");
        int v0 = 0x20;
        arg9 = (arg8 & 0x70 ^ 0x30) > v0 && (arg7.changed(false)) || (arg8 & 0x30) == v0 ? 1 : 0;
        int v3 = 0x100;
        if((arg8 & 0x380 ^ 0x180) > v3 && (arg7.changed(arg6)) || (arg8 & 0x180) == v3) {
            v2 = 1;
        }

        arg8 = arg9 | v2;
        Object v9 = arg7.rememberedValue();
        if(arg8 != 0 || v9 == Composer.Companion.getEmpty()) {
            TooltipStateImpl v9_1 = new TooltipStateImpl(false, false, arg6);
            arg7.updateRememberedValue(v9_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return ((TooltipState)v9);
    }

    public static final Modifier textVerticalPadding(Modifier arg9, boolean arg10, boolean arg11) {
        Object v0 = null;
        if(!arg10 && !arg11) {
            return PaddingKt.padding-VpY3zN4$default(arg9, 0f, TooltipKt.PlainTooltipVerticalPadding, 1, v0);
        }

        return PaddingKt.padding-qDBjuR0$default(AlignmentLineKt.paddingFromBaseline-VpY3zN4$default(arg9, TooltipKt.HeightFromSubheadToTextFirstLine, 0f, 2, v0), 0f, 0f, 0f, TooltipKt.TextBottomPadding, 7, null);
    }
}

