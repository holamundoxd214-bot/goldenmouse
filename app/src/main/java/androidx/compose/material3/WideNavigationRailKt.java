package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationRailBaselineItemTokens;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.material3.tokens.NavigationRailExpandedTokens;
import androidx.compose.material3.tokens.NavigationRailHorizontalItemTokens;
import androidx.compose.material3.tokens.NavigationRailVerticalItemTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000Ê\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001As\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0015\b\u0002\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000B¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\u0011\u0010\u0011\u001A\r\u0012\u0004\u0012\u00020\u00010\u000B¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0012\u001Am\u0010\u0013\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0013\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000B¢\u0006\u0002\b\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0011\u0010\u0011\u001A\r\u0012\u0004\u0012\u00020\u00010\u000B¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010\u0017\u001A\u009D\u0001\u0010\u0018\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0019\u001A\u00020\u00152\b\b\u0002\u0010\u001A\u001A\u00020\u00072\b\b\u0002\u0010\u001B\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0015\b\u0002\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000B¢\u0006\u0002\b\f2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\u0011\u0010\u0011\u001A\r\u0012\u0004\u0012\u00020\u00010\u000B¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b \u0010!\u001A\u0089\u0001\u0010\"\u001A\u00020\u00012\u0006\u0010#\u001A\u00020\u00152\f\u0010$\u001A\b\u0012\u0004\u0012\u00020\u00010\u000B2\u0011\u0010%\u001A\r\u0012\u0004\u0012\u00020\u00010\u000B¢\u0006\u0002\b\f2\u0013\u0010&\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000B¢\u0006\u0002\b\f2\u0006\u0010\'\u001A\u00020\u00152\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010(\u001A\u00020\u00152\b\b\u0002\u0010)\u001A\u00020*2\b\b\u0002\u0010\b\u001A\u00020+2\n\b\u0002\u0010,\u001A\u0004\u0018\u00010-H\u0007¢\u0006\u0004\b.\u0010/\u001AÖ\u0001\u00100\u001A\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u00101\u001A\u00020\u00152\u0012\u00102\u001A\u000E\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0006\u00106\u001A\u00020721\u00108\u001A-\b\u0001\u0012\u0013\u0012\u001104¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010=\u0012\u0006\u0012\u0004\u0018\u00010>092\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010?\u001A\u00020@2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010A\u001A\u00020\u001D2\u0013\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000B¢\u0006\u0002\b\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010B\u001A\u00020\u00152\u0006\u0010\u000F\u001A\u00020\u00102\u0011\u0010\u0011\u001A\r\u0012\u0004\u0012\u00020\u00010\u000B¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\bC\u0010D\u001A\u001C\u0010E\u001A\u000204*\u00020F2\u0006\u0010G\u001A\u0002042\u0006\u0010H\u001A\u00020\u0015H\u0002\u001A\u0014\u0010I\u001A\u000204*\u00020F2\u0006\u0010G\u001A\u000204H\u0002\u001A=\u0010J\u001A\u00020\u00012\u0006\u0010K\u001A\u00020L2\u001C\u0010M\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010=\u0012\u0006\u0012\u0004\u0018\u00010>0N2\u0006\u0010O\u001A\u00020\u0015H\u0003¢\u0006\u0004\bP\u0010Q\"\u0016\u0010R\u001A\u00020\u001DX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001A\u0004\bS\u0010T\"\u0010\u0010V\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010W\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010X\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010Y\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010Z\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010[\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010\\\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010]\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010^\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010_\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010`\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010a\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u000E\u0010b\u001A\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010c\u001A\u00020dX\u0082T¢\u0006\u0002\n\u0000\"\u001A\u0010e\u001A\b\u0012\u0004\u0012\u00020g0fX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bh\u0010i\"\u001A\u0010j\u001A\b\u0012\u0004\u0012\u00020k0fX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bl\u0010i¨\u0006m²\u0006\n\u0010n\u001A\u00020oX\u008A\u008E\u0002²\u0006\n\u0010p\u001A\u00020oX\u008A\u008E\u0002²\u0006\n\u0010q\u001A\u00020\u001DX\u008A\u0084\u0002²\u0006\n\u0010r\u001A\u00020\u001DX\u008A\u0084\u0002²\u0006\n\u0010s\u001A\u00020\u001DX\u008A\u0084\u0002²\u0006\n\u0010t\u001A\u00020\u001DX\u008A\u0084\u0002²\u0006\n\u0010u\u001A\u000204X\u008A\u0084\u0002²\u0006\n\u0010v\u001A\u00020\u0015X\u008A\u008E\u0002"}, d2={"WideNavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/WideNavigationRailState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/WideNavigationRailColors;", "header", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/WideNavigationRailState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/WideNavigationRailColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "WideNavigationRailLayout", "isModal", "", "expanded", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/WideNavigationRailColors;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ModalWideNavigationRail", "hideOnCollapse", "collapsedShape", "expandedShape", "expandedHeaderTopPadding", "Landroidx/compose/ui/unit/Dp;", "expandedProperties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "ModalWideNavigationRail-k3FuEkE", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/WideNavigationRailState;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/WideNavigationRailColors;Lkotlin/jvm/functions/Function2;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/material3/ModalWideNavigationRailProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "WideNavigationRailItem", "selected", "onClick", "icon", "label", "railExpanded", "enabled", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "Landroidx/compose/material3/NavigationItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "WideNavigationRailItem-pli-t6k", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/Modifier;ZILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ModalWideNavigationRailContent", "isStandaloneModal", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "predictiveBackState", "Landroidx/compose/material3/RailPredictiveBackState;", "settleToDismiss", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "velocity", "Lkotlin/coroutines/Continuation;", "", "railState", "Landroidx/compose/material3/ModalWideNavigationRailState;", "openModalRailMaxWidth", "gesturesEnabled", "ModalWideNavigationRailContent-pU6N4AM", "(ZZLandroidx/compose/animation/core/Animatable;Landroidx/compose/material3/RailPredictiveBackState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/ModalWideNavigationRailState;Landroidx/compose/material3/WideNavigationRailColors;Landroidx/compose/ui/graphics/Shape;FLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "progress", "swipeEdgeMatchesRail", "calculatePredictiveBackScaleY", "Scrim", "color", "Landroidx/compose/ui/graphics/Color;", "onDismissRequest", "Lkotlin/Function1;", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;I)V", "WNRItemNoLabelIndicatorPadding", "getWNRItemNoLabelIndicatorPadding", "()F", "F", "ItemHorizontalPadding", "WNRVerticalPadding", "WNRHeaderPadding", "CollapsedRailWidth", "ExpandedRailMinWidth", "ExpandedRailMaxWidth", "TopIconItemMinHeight", "ItemTopIconIndicatorVerticalPadding", "ItemTopIconIndicatorHorizontalPadding", "ItemStartIconIndicatorVerticalPadding", "PredictiveBackMaxScaleXDistance", "PredictiveBackMaxScaleYDistance", "PredictiveBackPivotFractionY", "HeaderLayoutIdTag", "", "LocalWideNavigationRailOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/WideNavigationRailOverride;", "getLocalWideNavigationRailOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalModalWideNavigationRailOverride", "Landroidx/compose/material3/ModalWideNavigationRailOverride;", "getLocalModalWideNavigationRailOverride", "material3", "currentWidth", "", "actualMaxExpandedWidth", "minWidth", "widthFullRange", "itemVerticalSpacedBy", "itemMinHeight", "alpha", "dismiss"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WideNavigationRailKt {
    private static final float CollapsedRailWidth = 0f;
    private static final float ExpandedRailMaxWidth = 0f;
    private static final float ExpandedRailMinWidth = 0f;
    private static final String HeaderLayoutIdTag = "header";
    private static final float ItemHorizontalPadding = 0f;
    private static final float ItemStartIconIndicatorVerticalPadding = 0f;
    private static final float ItemTopIconIndicatorHorizontalPadding = 0f;
    private static final float ItemTopIconIndicatorVerticalPadding = 0f;
    private static final ProvidableCompositionLocal LocalModalWideNavigationRailOverride = null;
    private static final ProvidableCompositionLocal LocalWideNavigationRailOverride = null;
    private static final float PredictiveBackMaxScaleXDistance = 0f;
    private static final float PredictiveBackMaxScaleYDistance = 0f;
    private static final float PredictiveBackPivotFractionY = 0.5f;
    private static final float TopIconItemMinHeight;
    private static final float WNRHeaderPadding;
    private static final float WNRItemNoLabelIndicatorPadding;
    private static final float WNRVerticalPadding;

    static {
        WideNavigationRailKt.WNRItemNoLabelIndicatorPadding = Dp.constructor-impl(Dp.constructor-impl(NavigationRailVerticalItemTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.getIconSize-D9Ej5fM()) / 2f);
        WideNavigationRailKt.ItemHorizontalPadding = Dp.constructor-impl(20f);
        WideNavigationRailKt.WNRVerticalPadding = NavigationRailCollapsedTokens.INSTANCE.getTopSpace-D9Ej5fM();
        WideNavigationRailKt.WNRHeaderPadding = NavigationRailBaselineItemTokens.INSTANCE.getHeaderSpaceMinimum-D9Ej5fM();
        WideNavigationRailKt.CollapsedRailWidth = NavigationRailCollapsedTokens.INSTANCE.getContainerWidth-D9Ej5fM();
        WideNavigationRailKt.ExpandedRailMinWidth = NavigationRailExpandedTokens.INSTANCE.getContainerWidthMinimum-D9Ej5fM();
        WideNavigationRailKt.ExpandedRailMaxWidth = NavigationRailExpandedTokens.INSTANCE.getContainerWidthMaximum-D9Ej5fM();
        WideNavigationRailKt.TopIconItemMinHeight = NavigationRailBaselineItemTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        WideNavigationRailKt.ItemTopIconIndicatorVerticalPadding = Dp.constructor-impl(Dp.constructor-impl(NavigationRailVerticalItemTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.getIconSize-D9Ej5fM()) / 2f);
        WideNavigationRailKt.ItemTopIconIndicatorHorizontalPadding = Dp.constructor-impl(Dp.constructor-impl(NavigationRailVerticalItemTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.getIconSize-D9Ej5fM()) / 2f);
        WideNavigationRailKt.ItemStartIconIndicatorVerticalPadding = Dp.constructor-impl(Dp.constructor-impl(NavigationRailHorizontalItemTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.getIconSize-D9Ej5fM()) / 2f);
        WideNavigationRailKt.PredictiveBackMaxScaleXDistance = Dp.constructor-impl(24f);
        WideNavigationRailKt.PredictiveBackMaxScaleYDistance = Dp.constructor-impl(48f);
        WideNavigationRailKt.LocalWideNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new WideNavigationRailKt$$ExternalSyntheticLambda11(), 1, null);
        WideNavigationRailKt.LocalModalWideNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new WideNavigationRailKt$$ExternalSyntheticLambda12(), 1, null);
    }

    static final ModalWideNavigationRailOverride LocalModalWideNavigationRailOverride$lambda$39() {
        return DefaultModalWideNavigationRailOverride.INSTANCE;
    }

    static final WideNavigationRailOverride LocalWideNavigationRailOverride$lambda$38() {
        return DefaultWideNavigationRailOverride.INSTANCE;
    }

    public static final void ModalWideNavigationRail-k3FuEkE(Modifier arg37, WideNavigationRailState arg38, boolean arg39, Shape arg40, Shape arg41, WideNavigationRailColors arg42, Function2 arg43, float arg44, WindowInsets arg45, Vertical arg46, ModalWideNavigationRailProperties arg47, Function2 arg48, Composer arg49, int arg50, int arg51, int arg52) {
        ModalWideNavigationRailProperties v11_1;
        Vertical v10_1;
        WindowInsets v9_2;
        float v8_3;
        Function2 v7_1;
        WideNavigationRailColors v6_3;
        Shape v5_1;
        Shape v4_2;
        boolean v3_2;
        WideNavigationRailState v2_1;
        Composer v0_3;
        Shape v27;
        Shape v26;
        boolean v25;
        float v30;
        Modifier v23;
        Function2 v29;
        ModalWideNavigationRailProperties v33;
        Vertical v32;
        WindowInsets v31;
        WideNavigationRailColors v28;
        WideNavigationRailState v24;
        Companion v23_1;
        Vertical v9_1;
        WindowInsets v8_2;
        WideNavigationRailColors v14_2;
        Shape v3_1;
        WideNavigationRailState v4_1;
        Modifier v1_2;
        int v21;
        float v10;
        int v18;
        Function2 v5;
        int v16;
        Shape v14_1;
        int v14;
        Shape v12_1;
        boolean v11;
        int v8_1;
        Modifier v6;
        int v7;
        WideNavigationRailState v0 = arg38;
        int v13 = arg50;
        int v15 = arg52;
        Composer v2 = arg49.startRestartGroup(0xFDB3A255);
        ComposerKt.sourceInformation(v2, "C(ModalWideNavigationRail)N(modifier,state,hideOnCollapse,collapsedShape,expandedShape,colors,header,expandedHeaderTopPadding:c#ui.unit.Dp,windowInsets,arrangement,expandedProperties,content)493@24484L7,*493@24501L25:WideNavigationRail.kt#uh7d8r");
        int v3 = v15 & 1;
        if(v3 != 0) {
            v7 = v13 | 6;
            v6 = arg37;
        }
        else if((v13 & 6) == 0) {
            v6 = arg37;
            v7 = v2.changed(v6) ? 4 : 2;
            v7 |= v13;
        }
        else {
            v6 = arg37;
            v7 = v13;
        }

        if((v13 & 0x30) == 0) {
            if((v15 & 2) == 0) {
                boolean v8 = (v13 & 0x40) == 0 ? v2.changed(v0) : v2.changedInstance(v0);
                if(!v8) {
                    goto label_38;
                }

                v8_1 = 0x20;
            }
            else {
            label_38:
                v8_1 = 16;
            }

            v7 |= v8_1;
        }

        v8_1 = v15 & 4;
        if(v8_1 != 0) {
            v7 |= 0x180;
            goto label_54;
        }
        else if((v13 & 0x180) == 0) {
            v11 = arg39;
            int v12 = v2.changed(v11) ? 0x100 : 0x80;
            v7 |= v12;
        }
        else {
        label_54:
            v11 = arg39;
        }

        if((v13 & 0xC00) == 0) {
            if((v15 & 8) == 0) {
                v12_1 = arg40;
                if(v2.changed(v12_1)) {
                    v14 = 0x800;
                }
                else {
                    goto label_65;
                }
            }
            else {
                v12_1 = arg40;
            label_65:
                v14 = 0x400;
            }

            v7 |= v14;
        }
        else {
            v12_1 = arg40;
        }

        if((v13 & 0x6000) == 0) {
            if((v15 & 16) == 0) {
                v14_1 = arg41;
                if(v2.changed(v14_1)) {
                    v16 = 0x4000;
                }
                else {
                    goto label_79;
                }
            }
            else {
                v14_1 = arg41;
            label_79:
                v16 = 0x2000;
            }

            v7 |= v16;
        }
        else {
            v14_1 = arg41;
        }

        if((v13 & 0x30000) == 0) {
            WideNavigationRailColors v4 = arg42;
            v16 = (v15 & 0x20) != 0 || !v2.changed(v4) ? 0x10000 : 0x20000;
            v7 |= v16;
        }

        v16 = v15 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v7 |= v17;
            v5 = arg43;
        }
        else {
            v5 = arg43;
            if((v13 & v17) == 0) {
                v18 = v2.changedInstance(v5) ? 0x100000 : 0x80000;
                v7 |= v18;
            }
        }

        int v9 = v15 & 0x80;
        int v19 = 0xC00000;
        if(v9 != 0) {
            v7 |= v19;
            v10 = arg44;
        }
        else {
            v10 = arg44;
            if((v13 & v19) == 0) {
                int v20 = v2.changed(v10) ? 0x800000 : 0x400000;
                v7 |= v20;
            }
        }

        if((v13 & 0x6000000) == 0) {
            v21 = (v15 & 0x100) != 0 || !v2.changed(arg45) ? 0x2000000 : 0x4000000;
            v7 |= v21;
        }

        if((v13 & 0x30000000) == 0) {
            v21 = (v15 & 0x200) != 0 || !v2.changed(arg46) ? 0x10000000 : 0x20000000;
            v7 |= v21;
        }

        int v0_1 = v15 & 0x400;
        if(v0_1 != 0) {
            v17 = arg51 | 6;
            v21 = v0_1;
        }
        else if((arg51 & 6) == 0) {
            v21 = v0_1;
            v17 = v2.changed(arg47) ? 4 : 2;
            v17 |= arg51;
        }
        else {
            v21 = v0_1;
            v17 = arg51;
        }

        if((v15 & 0x800) != 0) {
            v17 |= 0x30;
        }
        else if((arg51 & 0x30) == 0) {
            v18 = v2.changedInstance(arg48) ? 0x20 : 16;
            v17 |= v18;
        }

        v0_1 = v17;
        int v49 = v3;
        boolean v1 = (v7 & 306783379) != 306783378 || (v0_1 & 19) != 18 ? true : false;
        if(v2.shouldExecute(v1, v7 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "465@23180L33,467@23307L19,468@23382L18,469@23468L8,472@23625L12");
            if((v13 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v49 != 0) {
                    Companion v1_1 = Modifier.Companion;
                }
                else {
                    v1_2 = v6;
                }

                WideNavigationRailValue v6_1 = null;
                if((v15 & 2) != 0) {
                    v4_1 = WideNavigationRailStateKt.rememberWideNavigationRailState(v6_1, v2, 0, 1);
                    v7 &= 0xFFFFFF8F;
                }
                else {
                    v4_1 = arg38;
                }

                if(v8_1 != 0) {
                    v11 = false;
                }

                v8_1 = 6;
                if((v15 & 8) != 0) {
                    v3_1 = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(v2, v8_1);
                    v7 &= 0xFFFFE3FF;
                }
                else {
                    v3_1 = v12_1;
                }

                if((v15 & 16) != 0) {
                    v12_1 = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(v2, v8_1);
                    v7 &= 0xFFFF1FFF;
                }
                else {
                    v12_1 = v14_1;
                }

                if((v15 & 0x20) != 0) {
                    v14_2 = WideNavigationRailDefaults.INSTANCE.colors(v2, v8_1);
                    v7 &= 0xFFF8FFFF;
                }
                else {
                    v14_2 = arg42;
                }

                if(v16 != 0) {
                    v5 = ((Function2)v6_1);
                }

                float v6_2 = v9 != 0 ? Dp.constructor-impl(0f) : v10;
                if((v15 & 0x100) != 0) {
                    v8_2 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(v2, v8_1);
                    v7 &= 0xF1FFFFFF;
                }
                else {
                    v8_2 = arg45;
                }

                if((v15 & 0x200) != 0) {
                    v9_1 = WideNavigationRailDefaults.INSTANCE.getArrangement();
                    v7 &= 0x8FFFFFFF;
                }
                else {
                    v9_1 = arg46;
                }

                if(v21 != 0) {
                    v23_1 = ((Companion)v1_2);
                    v26 = v3_1;
                    v24 = v4_1;
                    v29 = v5;
                    v30 = v6_2;
                    v31 = v8_2;
                    v32 = v9_1;
                    v33 = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                }
                else {
                    v33 = arg47;
                    v23_1 = ((Companion)v1_2);
                    v26 = v3_1;
                    v24 = v4_1;
                    v29 = v5;
                    v30 = v6_2;
                    v31 = v8_2;
                    v32 = v9_1;
                }

                v25 = v11;
                v27 = v12_1;
                v28 = v14_2;
            }
            else {
                v2.skipToGroupEnd();
                if((v15 & 2) != 0) {
                    v7 &= 0xFFFFFF8F;
                }

                if((v15 & 8) != 0) {
                    v7 &= 0xFFFFE3FF;
                }

                if((v15 & 16) != 0) {
                    v7 &= 0xFFFF1FFF;
                }

                if((v15 & 0x20) != 0) {
                    v7 &= 0xFFF8FFFF;
                }

                if((v15 & 0x100) != 0) {
                    v7 &= 0xF1FFFFFF;
                }

                if((v15 & 0x200) != 0) {
                    v7 &= 0x8FFFFFFF;
                }

                v24 = arg38;
                v28 = arg42;
                v31 = arg45;
                v32 = arg46;
                v33 = arg47;
                v29 = v5;
                v23 = v6;
                v30 = v10;
                v25 = v11;
                v26 = v12_1;
                v27 = v14_1;
            }

            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xFDB3A255, v7, v0_1, "androidx.compose.material3.ModalWideNavigationRail (WideNavigationRail.kt:477)");
            }

            ModalWideNavigationRailOverrideScope v0_2 = new ModalWideNavigationRailOverrideScope(v23, v24, v25, v26, v27, v28, v29, v30, v31, v32, v33, arg48, null);
            ProvidableCompositionLocal v1_3 = WideNavigationRailKt.LocalModalWideNavigationRailOverride;
            ComposerKt.sourceInformationMarkerStart(v2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v1_4 = v2.consume(((CompositionLocal)v1_3));
            ComposerKt.sourceInformationMarkerEnd(v2);
            ((ModalWideNavigationRailOverride)v1_4).ModalWideNavigationRail(v0_2, v2, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v0_3 = v2;
            v1_2 = v23;
            v2_1 = v24;
            v3_2 = v25;
            v4_2 = v26;
            v5_1 = v27;
            v6_3 = v28;
            v7_1 = v29;
            v8_3 = v30;
            v9_2 = v31;
            v10_1 = v32;
            v11_1 = v33;
        }
        else {
            v2.skipToGroupEnd();
            v9_2 = arg45;
            v0_3 = v2;
            v7_1 = v5;
            v1_2 = v6;
            v8_3 = v10;
            v3_2 = v11;
            v4_2 = v12_1;
            v5_1 = v14_1;
            v2_1 = arg38;
            v6_3 = arg42;
            v10_1 = arg46;
            v11_1 = arg47;
        }

        ScopeUpdateScope v0_4 = v0_3.endRestartGroup();
        if(v0_4 != null) {
            v0_4.updateScope(new WideNavigationRailKt$$ExternalSyntheticLambda7(v1_2, v2_1, v3_2, v4_2, v5_1, v6_3, v7_1, v8_3, v9_2, v10_1, v11_1, arg48, v13, arg51, v15));
        }
    }

    private static final void ModalWideNavigationRailContent-pU6N4AM(boolean arg39, boolean arg40, Animatable arg41, RailPredictiveBackState arg42, Function2 arg43, Modifier arg44, ModalWideNavigationRailState arg45, WideNavigationRailColors arg46, Shape arg47, float arg48, Function2 arg49, WindowInsets arg50, boolean arg51, Vertical arg52, Function2 arg53, Composer arg54, int arg55, int arg56) {
        Composer v1_2;
        WideNavigationRailKt$ModalWideNavigationRailContent$4$1 v5_5;
        WideNavigationRailKt$$ExternalSyntheticLambda1 v11_2;
        WideNavigationRailKt$$ExternalSyntheticLambda14 v7_4;
        WideNavigationRailKt$$ExternalSyntheticLambda13 v10_2;
        int v18;
        int v25;
        WideNavigationRailColors v13_2;
        int v13;
        int v12;
        boolean v2 = arg40;
        Animatable v3 = arg41;
        RailPredictiveBackState v4 = arg42;
        Function2 v0 = arg43;
        Modifier v1 = arg44;
        ModalWideNavigationRailState v14 = arg45;
        float v15 = arg48;
        int v5 = arg55;
        int v6 = arg56;
        Composer v8 = arg54.startRestartGroup(0xA10610CB);
        ComposerKt.sourceInformation(v8, "C(ModalWideNavigationRailContent)N(expanded,isStandaloneModal,predictiveBackProgress,predictiveBackState,settleToDismiss,modifier,railState,colors,shape,openModalRailMaxWidth:c#ui.unit.Dp,header,windowInsets,gesturesEnabled,arrangement,content)989@47315L7,990@47370L55,1000@47710L29,1001@47771L904,1020@48768L649,1041@49760L23,1043@49810L1311,992@47431L3690:WideNavigationRail.kt#uh7d8r");
        if((v5 & 6) == 0) {
            v12 = v8.changed(arg39) ? 4 : 2;
            v12 |= v5;
        }
        else {
            v12 = v5;
        }

        int v16 = 16;
        if((v5 & 0x30) == 0) {
            v13 = v8.changed(v2) ? 0x20 : v16;
            v12 |= v13;
        }

        int v17 = 0x80;
        if((v5 & 0x180) == 0) {
            boolean v13_1 = (v5 & 0x200) == 0 ? v8.changed(v3) : v8.changedInstance(v3);
            v13 = v13_1 ? 0x100 : v17;
            v12 |= v13;
        }

        int v19 = 0x400;
        if((v5 & 0xC00) == 0) {
            v13 = v8.changed(v4) ? 0x800 : v19;
            v12 |= v13;
        }

        int v21 = 0x4000;
        int v22 = 0x2000;
        if((v5 & 0x6000) == 0) {
            v13 = v8.changedInstance(v0) ? v21 : v22;
            v12 |= v13;
        }

        if((0x30000 & v5) == 0) {
            v13 = v8.changed(v1) ? 0x20000 : 0x10000;
            v12 |= v13;
        }

        if((0x180000 & v5) == 0) {
            v13 = v8.changedInstance(v14) ? 0x100000 : 0x80000;
            v12 |= v13;
        }

        int v23 = 0xC00000;
        if((v5 & v23) == 0) {
            v13_2 = arg46;
            int v24 = v8.changed(v13_2) ? 0x800000 : 0x400000;
            v12 |= v24;
        }
        else {
            v13_2 = arg46;
        }

        Shape v10 = arg47;
        if((v5 & 0x6000000) == 0) {
            v25 = v8.changed(v10) ? 0x4000000 : 0x2000000;
            v12 |= v25;
        }

        if((v5 & 0x30000000) == 0) {
            v25 = v8.changed(v15) ? 0x20000000 : 0x10000000;
            v12 |= v25;
        }

        Function2 v11 = arg49;
        if((v6 & 6) == 0) {
            v18 = v8.changedInstance(v11) ? 4 : 2;
            v18 |= v6;
        }
        else {
            v18 = v6;
        }

        WindowInsets v7 = arg50;
        if((v6 & 0x30) == 0) {
            if(v8.changed(v7)) {
                v16 = 0x20;
            }

            v18 |= v16;
        }

        if((v6 & 0x180) == 0) {
            if(v8.changed(arg51)) {
                v17 = 0x100;
            }

            v18 |= v17;
        }

        if((v6 & 0xC00) == 0) {
            if(v8.changed(arg52)) {
                v19 = 0x800;
            }

            v18 |= v19;
        }

        if((v6 & 0x6000) == 0) {
            if(v8.changedInstance(arg53)) {
            }
            else {
                v21 = v22;
            }

            v18 |= v21;
        }

        v5 = v18;
        boolean v6_1 = (v12 & 306783379) != 306783378 || (v5 & 9363) != 9362 ? true : false;
        if(v8.shouldExecute(v6_1, v12 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xA10610CB, v12, v5, "androidx.compose.material3.ModalWideNavigationRailContent (WideNavigationRail.kt:988)");
            }

            ProvidableCompositionLocal v5_1 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v8, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v5_2 = v8.consume(((CompositionLocal)v5_1));
            ComposerKt.sourceInformationMarkerEnd(v8);
            v6_1 = v5_2 == LayoutDirection.Rtl ? true : false;
            String v5_3 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_wide_navigation_rail_pane_title), v8, 0);
            long v18_1 = v13_2.getModalContainerColor-0d7_KjU();
            long v20 = v13_2.getModalContentColor-0d7_KjU();
            v1 = SizeKt.fillMaxHeight$default(SizeKt.widthIn-VpY3zN4$default(v1, 0f, v15, 1, null), 0f, 1, null);
            String v9 = "CC(remember):WideNavigationRail.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v8, 2009435560, v9);
            boolean v7_1 = v8.changed(v5_3);
            Object v10_1 = v8.rememberedValue();
            if((v7_1) || v10_1 == Composer.Companion.getEmpty()) {
                v10_2 = new WideNavigationRailKt$$ExternalSyntheticLambda13(v5_3);
                v8.updateRememberedValue(v10_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            v1 = SemanticsModifierKt.semantics$default(v1, false, ((Function1)v10_2), 1, null);
            ComposerKt.sourceInformationMarkerStart(v8, 2009438387, v9);
            if((v12 & 0x380) != 0x100) {
                if((v12 & 0x200) != 0 && (v8.changedInstance(v3))) {
                    goto label_236;
                }

                v5 = 0;
            }
            else {
            label_236:
                v5 = 1;
            }

            v5 |= v8.changedInstance(v14);
            int v7_2 = (v12 & 0x1C00) == 0x800 ? 1 : 0;
            v5 = v5 | v7_2 | v8.changed(v6_1);
            Object v7_3 = v8.rememberedValue();
            if(v5 != 0 || v7_3 == Composer.Companion.getEmpty()) {
                v7_4 = new WideNavigationRailKt$$ExternalSyntheticLambda14(v3, v14, v4, v6_1);
                v8.updateRememberedValue(v7_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            v1 = GraphicsLayerModifierKt.graphicsLayer(v1, ((Function1)v7_4));
            AnchoredDraggableState v5_4 = v14.getAnchoredDraggableState$material3();
            Orientation v7_5 = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart(v8, 2009470036, v9);
            int v10_3 = (v12 & 0x70) == 0x20 ? 1 : 0;
            v10_3 = v10_3 | v8.changed(v6_1) | v8.changedInstance(v14);
            Object v11_1 = v8.rememberedValue();
            if(v10_3 != 0 || v11_1 == Composer.Companion.getEmpty()) {
                v11_2 = new WideNavigationRailKt$$ExternalSyntheticLambda1(v2, v6_1, v14);
                v8.updateRememberedValue(v11_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            Modifier v27 = AnchoredDraggableKt.draggableAnchors(v1, v5_4, v7_5, ((Function2)v11_2));
            DraggableState v28 = v14.getAnchoredDraggableState$material3().getDraggableState$material3();
            Orientation v29 = Orientation.Horizontal;
            boolean v32 = v14.getAnchoredDraggableState$material3().isAnimationRunning();
            ComposerKt.sourceInformationMarkerStart(v8, 2009501154, v9);
            boolean v1_1 = v8.changedInstance(v0);
            v5_2 = v8.rememberedValue();
            if((v1_1) || v5_2 == Composer.Companion.getEmpty()) {
                v5_5 = new WideNavigationRailKt$ModalWideNavigationRailContent$4$1(v0, null);
                v8.updateRememberedValue(v5_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            v1_2 = v8;
            SurfaceKt.Surface-T9BRK9s(DraggableKt.draggable$default(v27, v28, v29, arg51, null, v32, null, v5_5, false, 0xA8, null), arg47, v18_1, v20, 0f, 0f, null, ComposableLambdaKt.rememberComposableLambda(-1043835354, true, new WideNavigationRailKt$ModalWideNavigationRailContent$5(arg41, v4, v6_1, arg39, v13_2, arg47, arg49, arg50, arg52, arg53), v1_2, 54), v1_2, v12 >> 21 & 0x70 | v23, 0x70);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_343;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1_2 = v8;
            v1_2.skipToGroupEnd();
        }

    label_343:
        ScopeUpdateScope v0_1 = v1_2.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new WideNavigationRailKt$$ExternalSyntheticLambda2(arg39, v2, arg41, arg42, arg43, arg44, v14, arg46, arg47, v15, arg49, arg50, arg51, arg52, arg53, arg55, arg56));
        }
    }

    static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$18$lambda$17(String arg0, SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setPaneTitle(arg1, arg0);
        return Unit.INSTANCE;
    }

    static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$20$lambda$19(Animatable arg4, ModalWideNavigationRailState arg5, RailPredictiveBackState arg6, boolean arg7, GraphicsLayerScope arg8) {
        float v4 = arg4.getValue().floatValue();
        float v0 = 0f;
        if(v4 <= 0f) {
            return Unit.INSTANCE;
        }

        float v5 = arg5.getCurrentOffset();
        float v1 = Float.intBitsToFloat(((int)(arg8.getSize-NH-jbRc() >> 0x20)));
        if(!Float.isNaN(v5) && !Float.isNaN(v1)) {
            if(v1 == 0f) {
            }
            else {
                arg8.setScaleX(WideNavigationRailKt.calculatePredictiveBackScaleX(arg8, v4, arg6.getSwipeEdgeMatchesRail()));
                arg8.setScaleY(WideNavigationRailKt.calculatePredictiveBackScaleY(arg8, v4));
                if(arg7) {
                    v0 = 1f;
                }

                arg8.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(v0, 0.5f));
            }
        }

        return Unit.INSTANCE;
    }

    static final Pair ModalWideNavigationRailContent_pU6N4AM$lambda$23$lambda$22(boolean arg1, boolean arg2, ModalWideNavigationRailState arg3, IntSize arg4, Constraints arg5) {
        float v4 = ((float)(((int)(arg4.unbox-impl() >> 0x20))));
        if(!arg1) {
            v4 = 0f;
        }
        else if(arg2) {
        }
        else {
            v4 = -v4;
        }

        return TuplesKt.to(AnchoredDraggableKt.DraggableAnchors(new WideNavigationRailKt$$ExternalSyntheticLambda6(v4, 0f)), arg3.getTargetValue());
    }

    static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$23$lambda$22$lambda$21(float arg1, float arg2, DraggableAnchorsConfig arg3) {
        arg3.at(WideNavigationRailValue.Collapsed, arg1);
        arg3.at(WideNavigationRailValue.Expanded, arg2);
        return Unit.INSTANCE;
    }

    static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$25(boolean arg19, boolean arg20, Animatable arg21, RailPredictiveBackState arg22, Function2 arg23, Modifier arg24, ModalWideNavigationRailState arg25, WideNavigationRailColors arg26, Shape arg27, float arg28, Function2 arg29, WindowInsets arg30, boolean arg31, Vertical arg32, Function2 arg33, int arg34, int arg35, Composer arg36, int arg37) {
        WideNavigationRailKt.ModalWideNavigationRailContent-pU6N4AM(arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg36, RecomposeScopeImplKt.updateChangedFlags(arg34 | 1), RecomposeScopeImplKt.updateChangedFlags(arg35));
        return Unit.INSTANCE;
    }

    static final Unit ModalWideNavigationRail_k3FuEkE$lambda$14(Modifier arg17, WideNavigationRailState arg18, boolean arg19, Shape arg20, Shape arg21, WideNavigationRailColors arg22, Function2 arg23, float arg24, WindowInsets arg25, Vertical arg26, ModalWideNavigationRailProperties arg27, Function2 arg28, int arg29, int arg30, int arg31, Composer arg32, int arg33) {
        WideNavigationRailKt.ModalWideNavigationRail-k3FuEkE(arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg32, RecomposeScopeImplKt.updateChangedFlags(arg29 | 1), RecomposeScopeImplKt.updateChangedFlags(arg30), arg31);
        return Unit.INSTANCE;
    }

    private static final void Scrim-3J-VO9M(long arg19, Function1 arg21, boolean arg22, Composer arg23, int arg24) {
        WideNavigationRailKt$$ExternalSyntheticLambda4 v12_2;
        Companion v9_2;
        WideNavigationRailKt$$ExternalSyntheticLambda3 v15_3;
        MutableState v7_4;
        int v7;
        int v6;
        long v1 = arg19;
        Function1 v3 = arg21;
        boolean v4 = arg22;
        int v5 = arg24;
        int v0 = 0x89FDFDD;
        Composer v11 = arg23.startRestartGroup(v0);
        ComposerKt.sourceInformation(v11, "C(Scrim)N(color:c#ui.graphics.Color,onDismissRequest,visible):WideNavigationRail.kt#uh7d8r");
        int v15 = 2;
        if((v5 & 6) == 0) {
            v6 = v11.changed(v1) ? 4 : v15;
            v6 |= v5;
        }
        else {
            v6 = v5;
        }

        if((v5 & 0x30) == 0) {
            v7 = v11.changedInstance(v3) ? 0x20 : 16;
            v6 |= v7;
        }

        if((v5 & 0x180) == 0) {
            v7 = v11.changed(v4) ? 0x100 : 0x80;
            v6 |= v7;
        }

        boolean v7_1 = (v6 & 0x93) != 0x92 ? true : false;
        if(v11.shouldExecute(v7_1, v6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v6, -1, "androidx.compose.material3.Scrim (WideNavigationRail.kt:1102)");
            }

            if(v1 != 16) {
                v11.startReplaceGroup(-1530482291);
                ComposerKt.sourceInformation(v11, "1108@52256L7,1105@52025L253,1110@52302L34,1111@52366L28,1125@52948L79,1125@52894L133,1129@53061L35,1129@53037L59");
                float v7_2 = v4 ? 1f : 0f;
                int v16 = v6;
                Function1 v10 = null;
                State v6_1 = AnimateAsStateKt.animateFloatAsState(v7_2, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v11, 6), 0f, null, v10, v11, 0, 28);
                String v8 = "CC(remember):WideNavigationRail.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(v11, 0x602793DF, v8);
                Object v7_3 = v11.rememberedValue();
                if(v7_3 == Composer.Companion.getEmpty()) {
                    v7_4 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), ((SnapshotMutationPolicy)v10), v15, v10);
                    v11.updateRememberedValue(v7_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v11);
                String v9 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_wide_navigation_rail_close_rail), v11, 0);
                if(v4) {
                    v11.startReplaceGroup(-1530047423);
                    ComposerKt.sourceInformation(v11, "1114@52509L40,1115@52606L219");
                    Companion v13 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(v11, 0x6027ADC5, v8);
                    Object v15_1 = v11.rememberedValue();
                    if(v15_1 == Composer.Companion.getEmpty()) {
                        WideNavigationRailKt$Scrim$dismissModalRail$1$1 v15_2 = new WideNavigationRailKt$Scrim$dismissModalRail$1$1(v7_4);
                        v11.updateRememberedValue(v15_2);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v11);
                    Modifier v12 = SuspendingPointerInputFilterKt.pointerInput(((Modifier)v13), v3, ((PointerInputEventHandler)v15_1));
                    ComposerKt.sourceInformationMarkerStart(v11, 0x6027BA98, v8);
                    boolean v13_1 = v11.changed(v9);
                    v15_1 = v11.rememberedValue();
                    if((v13_1) || v15_1 == Composer.Companion.getEmpty()) {
                        v15_3 = new WideNavigationRailKt$$ExternalSyntheticLambda3(v9, v7_4);
                        v11.updateRememberedValue(v15_3);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v11);
                    Modifier v9_1 = SemanticsModifierKt.semantics(v12, true, ((Function1)v15_3));
                    v11.endReplaceGroup();
                }
                else {
                    v11.startReplaceGroup(0xA4D320DD);
                    v11.endReplaceGroup();
                    v9_2 = Modifier.Companion;
                }

                Modifier v0_1 = SizeKt.fillMaxSize$default(Modifier.Companion, 0f, 1, v10).then(((Modifier)v9_2));
                ComposerKt.sourceInformationMarkerStart(v11, 0x6027E4CC, v8);
                int v9_3 = (v16 & 14) == 4 ? 1 : 0;
                v9_3 |= v11.changed(v6_1);
                Object v12_1 = v11.rememberedValue();
                if(v9_3 != 0 || v12_1 == Composer.Companion.getEmpty()) {
                    v12_2 = new WideNavigationRailKt$$ExternalSyntheticLambda4(v1, v6_1);
                    v11.updateRememberedValue(v12_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v11);
                CanvasKt.Canvas(v0_1, ((Function1)v12_2), v11, 0);
                Boolean v0_2 = Boolean.valueOf(WideNavigationRailKt.Scrim_3J_VO9M$lambda$28(v7_4));
                ComposerKt.sourceInformationMarkerStart(v11, 0x6027F2C0, v8);
                boolean v6_2 = v11.changedInstance(v3);
                Object v8_1 = v11.rememberedValue();
                if((v6_2) || v8_1 == Composer.Companion.getEmpty()) {
                    WideNavigationRailKt$Scrim$2$1 v8_2 = new WideNavigationRailKt$Scrim$2$1(v3, v7_4, ((Continuation)v10));
                    v11.updateRememberedValue(v8_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v11);
                EffectsKt.LaunchedEffect(v0_2, ((Function2)v8_1), v11, 0);
                v11.endReplaceGroup();
            }
            else {
                v11.startReplaceGroup(0xA4D6FFE5);
                v11.endReplaceGroup();
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_182;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v11.skipToGroupEnd();
        }

    label_182:
        ScopeUpdateScope v6_3 = v11.endRestartGroup();
        if(v6_3 != null) {
            v6_3.updateScope(new WideNavigationRailKt$$ExternalSyntheticLambda5(v1, v3, v4, v5));
        }
    }

    private static final float Scrim_3J_VO9M$lambda$26(State arg0) {
        return arg0.getValue().floatValue();
    }

    private static final boolean Scrim_3J_VO9M$lambda$28(MutableState arg0) {
        return ((State)arg0).getValue().booleanValue();
    }

    private static final void Scrim_3J_VO9M$lambda$29(MutableState arg0, boolean arg1) {
        arg0.setValue(Boolean.valueOf(arg1));
    }

    static final Unit Scrim_3J_VO9M$lambda$33$lambda$32(String arg1, MutableState arg2, SemanticsPropertyReceiver arg3) {
        SemanticsPropertiesKt.setContentDescription(arg3, arg1);
        SemanticsPropertiesKt.onClick$default(arg3, null, new WideNavigationRailKt$$ExternalSyntheticLambda9(arg2), 1, null);
        return Unit.INSTANCE;
    }

    static final boolean Scrim_3J_VO9M$lambda$33$lambda$32$lambda$31(MutableState arg1) {
        WideNavigationRailKt.Scrim_3J_VO9M$lambda$29(arg1, true);
        return 1;
    }

    static final Unit Scrim_3J_VO9M$lambda$35$lambda$34(long arg16, State arg18, DrawScope arg19) {
        DrawScope.drawRect-n-J9OG0$default(arg19, arg16, 0, 0, RangesKt.coerceIn(WideNavigationRailKt.Scrim_3J_VO9M$lambda$26(arg18), 0f, 1f), null, null, 0, 0x76, null);
        return Unit.INSTANCE;
    }

    static final Unit Scrim_3J_VO9M$lambda$37(long arg6, Function1 arg8, boolean arg9, int arg10, Composer arg11, int arg12) {
        WideNavigationRailKt.Scrim-3J-VO9M(arg6, arg8, arg9, arg11, RecomposeScopeImplKt.updateChangedFlags(arg10 | 1));
        return Unit.INSTANCE;
    }

    public static final void WideNavigationRail(Modifier arg24, WideNavigationRailState arg25, Shape arg26, WideNavigationRailColors arg27, Function2 arg28, WindowInsets arg29, Vertical arg30, Function2 arg31, Composer arg32, int arg33, int arg34) {
        Vertical v7_2;
        WindowInsets v6_3;
        Function2 v5_1;
        WideNavigationRailColors v4_3;
        Shape v3_1;
        WideNavigationRailState v2_1;
        Composer v0_3;
        Modifier v1_1;
        WideNavigationRailState v17_1;
        WindowInsets v21;
        Function2 v20;
        WideNavigationRailColors v19;
        Shape v18;
        Vertical v22;
        Function2 v14_1;
        int v14;
        Vertical v13_1;
        int v13;
        WindowInsets v12_1;
        Function2 v11;
        int v8;
        WideNavigationRailColors v7_1;
        int v7;
        Shape v6_2;
        int v6_1;
        Modifier v4;
        int v5;
        WideNavigationRailState v0 = arg25;
        int v9 = arg33;
        int v10 = arg34;
        Composer v2 = arg32.startRestartGroup(0x9C963A4);
        ComposerKt.sourceInformation(v2, "C(WideNavigationRail)N(modifier,state,shape,colors,header,windowInsets,arrangement,content)170@8485L7,*181@8852L20:WideNavigationRail.kt#uh7d8r");
        int v3 = v10 & 1;
        if(v3 != 0) {
            v5 = v9 | 6;
            v4 = arg24;
        }
        else if((v9 & 6) == 0) {
            v4 = arg24;
            v5 = v2.changed(v4) ? 4 : 2;
            v5 |= v9;
        }
        else {
            v4 = arg24;
            v5 = v9;
        }

        if((v9 & 0x30) == 0) {
            if((v10 & 2) == 0) {
                boolean v6 = (v9 & 0x40) == 0 ? v2.changed(v0) : v2.changedInstance(v0);
                if(!v6) {
                    goto label_38;
                }

                v6_1 = 0x20;
            }
            else {
            label_38:
                v6_1 = 16;
            }

            v5 |= v6_1;
        }

        if((v9 & 0x180) == 0) {
            if((v10 & 4) == 0) {
                v6_2 = arg26;
                if(v2.changed(v6_2)) {
                    v7 = 0x100;
                }
                else {
                    goto label_50;
                }
            }
            else {
                v6_2 = arg26;
            label_50:
                v7 = 0x80;
            }

            v5 |= v7;
        }
        else {
            v6_2 = arg26;
        }

        if((v9 & 0xC00) == 0) {
            if((v10 & 8) == 0) {
                v7_1 = arg27;
                if(v2.changed(v7_1)) {
                    v8 = 0x800;
                }
                else {
                    goto label_64;
                }
            }
            else {
                v7_1 = arg27;
            label_64:
                v8 = 0x400;
            }

            v5 |= v8;
        }
        else {
            v7_1 = arg27;
        }

        v8 = v10 & 16;
        if(v8 != 0) {
            v5 |= 0x6000;
            goto label_82;
        }
        else if((v9 & 0x6000) == 0) {
            v11 = arg28;
            int v12 = v2.changedInstance(v11) ? 0x4000 : 0x2000;
            v5 |= v12;
        }
        else {
        label_82:
            v11 = arg28;
        }

        if((0x30000 & v9) == 0) {
            if((v10 & 0x20) == 0) {
                v12_1 = arg29;
                if(v2.changed(v12_1)) {
                    v13 = 0x20000;
                }
                else {
                    goto label_94;
                }
            }
            else {
                v12_1 = arg29;
            label_94:
                v13 = 0x10000;
            }

            v5 |= v13;
        }
        else {
            v12_1 = arg29;
        }

        if((0x180000 & v9) == 0) {
            if((v10 & 0x40) == 0) {
                v13_1 = arg30;
                if(v2.changed(v13_1)) {
                    v14 = 0x100000;
                }
                else {
                    goto label_109;
                }
            }
            else {
                v13_1 = arg30;
            label_109:
                v14 = 0x80000;
            }

            v5 |= v14;
        }
        else {
            v13_1 = arg30;
        }

        int v15 = 0xC00000;
        if((v10 & 0x80) != 0) {
            v5 |= v15;
            goto label_128;
        }
        else if((v9 & v15) == 0) {
            v14_1 = arg31;
            v15 = v2.changedInstance(v14_1) ? 0x800000 : 0x400000;
            v5 |= v15;
        }
        else {
        label_128:
            v14_1 = arg31;
        }

        boolean v1 = (0x492493 & v5) != 4793490 ? true : false;
        if(v2.shouldExecute(v1, v5 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "162@8039L33,163@8120L5,164@8193L8,166@8309L12");
            v15 = 0xFFC7FFFF;
            int v17 = 0xFFF8FFFF;
            if((v9 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v3 != 0) {
                    Companion v1_2 = Modifier.Companion;
                }
                else {
                    v1_1 = v4;
                }

                WideNavigationRailValue v4_1 = null;
                if((v10 & 2) != 0) {
                    v0 = WideNavigationRailStateKt.rememberWideNavigationRailState(v4_1, v2, 0, 1);
                    v5 &= 0xFFFFFF8F;
                }
                else {
                    v0 = arg25;
                }

                int v4_2 = 6;
                if((v10 & 4) != 0) {
                    v5 &= -897;
                    v6_2 = WideNavigationRailDefaults.INSTANCE.getShape(v2, v4_2);
                }

                if((v10 & 8) != 0) {
                    v5 &= 0xFFFFE3FF;
                    v7_1 = WideNavigationRailDefaults.INSTANCE.colors(v2, v4_2);
                }

                if(v8 != 0) {
                    v11 = null;
                }

                if((v10 & 0x20) != 0) {
                    v12_1 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(v2, v4_2);
                    v5 &= v17;
                }

                if((v10 & 0x40) != 0) {
                    v5 &= v15;
                    v17_1 = v0;
                    v22 = WideNavigationRailDefaults.INSTANCE.getArrangement();
                    v18 = v6_2;
                    v19 = v7_1;
                    v20 = v11;
                    v21 = v12_1;
                    goto label_222;
                }

                v17_1 = v0;
            label_168:
                v18 = v6_2;
                v19 = v7_1;
                v20 = v11;
                v21 = v12_1;
                v22 = v13_1;
            }
            else {
                v2.skipToGroupEnd();
                if((v10 & 2) != 0) {
                    v5 &= 0xFFFFFF8F;
                }

                if((v10 & 4) != 0) {
                    v5 &= -897;
                }

                if((v10 & 8) != 0) {
                    v5 &= 0xFFFFE3FF;
                }

                if((v10 & 0x20) != 0) {
                    v5 &= v17;
                }

                if((v10 & 0x40) != 0) {
                    v5 &= v15;
                }

                v17_1 = arg25;
                v1_1 = v4;
                goto label_168;
            }

        label_222:
            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x9C963A4, v5, -1, "androidx.compose.material3.WideNavigationRail (WideNavigationRail.kt:169)");
            }

            ProvidableCompositionLocal v0_1 = WideNavigationRailKt.LocalWideNavigationRailOverride;
            ComposerKt.sourceInformationMarkerStart(v2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = v2.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v2);
            Modifier v16 = v1_1;
            ((WideNavigationRailOverride)v0_2).WideNavigationRail(new WideNavigationRailOverrideScope(v16, v17_1, v18, v19, v20, v21, v22, v14_1), v2, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v0_3 = v2;
            v1_1 = v16;
            v2_1 = v17_1;
            v3_1 = v18;
            v4_3 = v19;
            v5_1 = v20;
            v6_3 = v21;
            v7_2 = v22;
        }
        else {
            v2.skipToGroupEnd();
            v0_3 = v2;
            v1_1 = v4;
            v3_1 = v6_2;
            v4_3 = v7_1;
            v5_1 = v11;
            v6_3 = v12_1;
            v7_2 = v13_1;
            v2_1 = arg25;
        }

        ScopeUpdateScope v11_1 = v0_3.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new WideNavigationRailKt$$ExternalSyntheticLambda10(v1_1, v2_1, v3_1, v4_3, v5_1, v6_3, v7_2, arg31, v9, v10));
        }
    }

    static final Unit WideNavigationRail$lambda$1(Modifier arg12, WideNavigationRailState arg13, Shape arg14, WideNavigationRailColors arg15, Function2 arg16, WindowInsets arg17, Vertical arg18, Function2 arg19, int arg20, int arg21, Composer arg22, int arg23) {
        WideNavigationRailKt.WideNavigationRail(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    public static final void WideNavigationRailItem-pli-t6k(boolean arg38, Function0 arg39, Function2 arg40, Function2 arg41, boolean arg42, Modifier arg43, boolean arg44, int arg45, NavigationItemColors arg46, MutableInteractionSource arg47, Composer arg48, int arg49, int arg50) {
        boolean v7_5;
        Modifier v6_2;
        NavigationItemColors v9_2;
        MutableInteractionSource v10_1;
        Composer v34;
        Object v33;
        MutableInteractionSource v6_1;
        Companion v7_2;
        int v16;
        NavigationItemColors v15_1;
        int v15;
        int v10;
        boolean v9_1;
        int v8;
        Modifier v7_1;
        int v6;
        Function2 v4_1;
        Function2 v3_1;
        Function0 v14;
        boolean v13;
        int v2;
        boolean v5 = arg42;
        int v11 = arg49;
        int v12 = arg50;
        Composer v1 = arg48.startRestartGroup(0x8F10AA08);
        ComposerKt.sourceInformation(v1, "C(WideNavigationRailItem)N(selected,onClick,icon,label,railExpanded,modifier,enabled,iconPosition:c#material3.NavigationItemIconPosition,colors,interactionSource)696@33504L5,698@33677L5,699@33767L5,692@33324L1318:WideNavigationRail.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v2 = v11 | 6;
            v13 = arg38;
        }
        else {
            v13 = arg38;
            if((v11 & 6) == 0) {
                v2 = v1.changed(v13) ? 4 : 2;
                v2 |= v11;
            }
            else {
                v2 = v11;
            }
        }

        if((v12 & 2) != 0) {
            v2 |= 0x30;
            v14 = arg39;
        }
        else {
            v14 = arg39;
            if((v11 & 0x30) == 0) {
                int v3 = v1.changedInstance(v14) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        if((v12 & 4) != 0) {
            v2 |= 0x180;
            goto label_52;
        }
        else if((v11 & 0x180) == 0) {
            v3_1 = arg40;
            int v4 = v1.changedInstance(v3_1) ? 0x100 : 0x80;
            v2 |= v4;
        }
        else {
        label_52:
            v3_1 = arg40;
        }

        if((v12 & 8) != 0) {
            v2 |= 0xC00;
            goto label_67;
        }
        else if((v11 & 0xC00) == 0) {
            v4_1 = arg41;
            v6 = v1.changedInstance(v4_1) ? 0x800 : 0x400;
            v2 |= v6;
        }
        else {
        label_67:
            v4_1 = arg41;
        }

        if((v12 & 16) != 0) {
            v2 |= 0x6000;
        }
        else if((v11 & 0x6000) == 0) {
            v6 = v1.changed(v5) ? 0x4000 : 0x2000;
            v2 |= v6;
        }

        v6 = v12 & 0x20;
        int v7 = 0x30000;
        if(v6 != 0) {
            v2 |= v7;
            goto label_95;
        }
        else if((v7 & v11) == 0) {
            v7_1 = arg43;
            v8 = v1.changed(v7_1) ? 0x20000 : 0x10000;
            v2 |= v8;
        }
        else {
        label_95:
            v7_1 = arg43;
        }

        v8 = v12 & 0x40;
        int v9 = 0x180000;
        if(v8 != 0) {
            v2 |= v9;
            goto label_111;
        }
        else if((v9 & v11) == 0) {
            v9_1 = arg44;
            v10 = v1.changed(v9_1) ? 0x100000 : 0x80000;
            v2 |= v10;
        }
        else {
        label_111:
            v9_1 = arg44;
        }

        if((0xC00000 & v11) == 0) {
            if((v12 & 0x80) == 0) {
                v10 = arg45;
                if(v1.changed(v10)) {
                    v15 = 0x800000;
                }
                else {
                    goto label_123;
                }
            }
            else {
                v10 = arg45;
            label_123:
                v15 = 0x400000;
            }

            v2 |= v15;
        }
        else {
            v10 = arg45;
        }

        if((0x6000000 & v11) == 0) {
            if((v12 & 0x100) == 0) {
                v15_1 = arg46;
                if(v1.changed(v15_1)) {
                    v16 = 0x4000000;
                }
                else {
                    goto label_138;
                }
            }
            else {
                v15_1 = arg46;
            label_138:
                v16 = 0x2000000;
            }

            v2 |= v16;
        }
        else {
            v15_1 = arg46;
        }

        int v0 = v12 & 0x200;
        int v17 = 0x30000000;
        if(v0 != 0) {
            v2 |= v17;
            goto label_158;
        }
        else if((v11 & v17) == 0) {
            v17 = v0;
            int v18 = v1.changed(arg47) ? 0x20000000 : 0x10000000;
            v2 |= v18;
        }
        else {
        label_158:
            v17 = v0;
        }

        int v48 = v2;
        boolean v0_1 = (v2 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0_1, v48 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "686@33127L8");
            int v19 = 0xFE3FFFFF;
            int v20 = 0xF1FFFFFF;
            v2 = 6;
            if((v11 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v6 != 0) {
                    v7_2 = Modifier.Companion;
                }

                if(v8 != 0) {
                    v9_1 = true;
                }

                if((v12 & 0x80) != 0) {
                    v6 = v48 & v19;
                    v10 = WideNavigationRailItemDefaults.INSTANCE.iconPositionFor-s8pcRp0(v5);
                }
                else {
                    v6 = v48;
                }

                if((v12 & 0x100) != 0) {
                    v6 &= v20;
                    v15_1 = WideNavigationRailItemDefaults.INSTANCE.colors(v1, v2);
                }

                v0 = v6;
                if(v17 != 0) {
                    v6_1 = null;
                    goto label_193;
                }

            label_192:
                v6_1 = arg47;
            }
            else {
                v1.skipToGroupEnd();
                v0 = (v12 & 0x80) != 0 ? v48 & v19 : v48;
                if((v12 & 0x100) == 0) {
                    goto label_192;
                }

                v0 &= v20;
                goto label_192;
            }

        label_193:
            Modifier v29 = ((Modifier)v7_2);
            boolean v30 = v9_1;
            int v32 = v10;
            NavigationItemColors v28 = v15_1;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x8F10AA08, v0, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:688)");
            }

            if(v6_1 == null) {
                v1.startReplaceGroup(-1539072909);
                ComposerKt.sourceInformation(v1, "690@33279L39");
                ComposerKt.sourceInformationMarkerStart(v1, 0xD8E916F, "CC(remember):WideNavigationRail.kt#9igjgp");
                Object v7_3 = v1.rememberedValue();
                if(v7_3 == Composer.Companion.getEmpty()) {
                    MutableInteractionSource v7_4 = InteractionSourceKt.MutableInteractionSource();
                    v1.updateRememberedValue(v7_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v1);
                v1.endReplaceGroup();
                v33 = v7_3;
            }
            else {
                v1.startReplaceGroup(227446500);
                v1.endReplaceGroup();
                MutableInteractionSource v33_1 = v6_1;
            }

            v8 = v0 << 3;
            v34 = v1;
            NavigationItemKt.AnimatedNavigationItem-DQd_Gtc(v13, v14, v3_1, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), v1, v2), NavigationRailVerticalItemTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), v1, v2), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), v1, v2), WideNavigationRailKt.ItemTopIconIndicatorHorizontalPadding, WideNavigationRailKt.ItemTopIconIndicatorVerticalPadding, NavigationRailVerticalItemTokens.INSTANCE.getIconLabelSpace-D9Ej5fM(), NavigationRailHorizontalItemTokens.INSTANCE.getFullWidthLeadingSpace-D9Ej5fM(), WideNavigationRailKt.ItemStartIconIndicatorVerticalPadding, WideNavigationRailKt.WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.getIconLabelSpace-D9Ej5fM(), WideNavigationRailKt.ItemHorizontalPadding, v28, v29, v30, v4_1, v32, ((MutableInteractionSource)v33), v34, v0 & 14 | 0x36C06000 | v0 & 0x70 | v0 & 0x380, v0 >> 9 & 0x70000 | 28086 | 0x380000 & v8 | v8 & 0x1C00000 | v0 << 15 & 0xE000000 | v0 << v2 & 0x70000000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v10_1 = v6_1;
            v9_2 = v28;
            v6_2 = v29;
            v7_5 = v30;
            v8 = v32;
        }
        else {
            v34 = v1;
            v34.skipToGroupEnd();
            v6_2 = v7_1;
            v7_5 = v9_1;
            v8 = v10;
            v9_2 = v15_1;
            v10_1 = arg47;
        }

        ScopeUpdateScope v13_1 = v34.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new WideNavigationRailKt$$ExternalSyntheticLambda0(arg38, arg39, arg40, arg41, v5, v6_2, v7_5, v8, v9_2, v10_1, v11, v12));
        }
    }

    static final Unit WideNavigationRailItem_pli_t6k$lambda$16(boolean arg14, Function0 arg15, Function2 arg16, Function2 arg17, boolean arg18, Modifier arg19, boolean arg20, int arg21, NavigationItemColors arg22, MutableInteractionSource arg23, int arg24, int arg25, Composer arg26, int arg27) {
        WideNavigationRailKt.WideNavigationRailItem-pli-t6k(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    private static final void WideNavigationRailLayout(Modifier arg27, boolean arg28, boolean arg29, WideNavigationRailColors arg30, Shape arg31, Function2 arg32, WindowInsets arg33, Vertical arg34, Function2 arg35, Composer arg36, int arg37) {
        float v10_6;
        MutableIntState v1_2;
        int v7;
        WideNavigationRailColors v5_1;
        int v5;
        int v4;
        boolean v2 = arg28;
        boolean v6 = arg29;
        int v0 = arg37;
        int v1 = -1004308036;
        Composer v11 = arg36.startRestartGroup(v1);
        ComposerKt.sourceInformation(v11, "C(WideNavigationRailLayout)N(modifier,isModal,expanded,colors,shape,header,windowInsets,arrangement,content)219@9930L33,220@9998L33,222@10107L7,229@10373L11,230@10448L11,232@10488L195,237@10718L195,242@10954L170,247@11158L154,257@11558L8819,252@11318L9059:WideNavigationRail.kt#uh7d8r");
        if((v0 & 6) == 0) {
            v4 = v11.changed(arg27) ? 4 : 2;
            v4 |= v0;
        }
        else {
            v4 = v0;
        }

        if((v0 & 0x30) == 0) {
            v5 = v11.changed(v2) ? 0x20 : 16;
            v4 |= v5;
        }

        if((v0 & 0x180) == 0) {
            v5 = v11.changed(v6) ? 0x100 : 0x80;
            v4 |= v5;
        }

        if((v0 & 0xC00) == 0) {
            v5_1 = arg30;
            v7 = v11.changed(v5_1) ? 0x800 : 0x400;
            v4 |= v7;
        }
        else {
            v5_1 = arg30;
        }

        Shape v14 = arg31;
        if((v0 & 0x6000) == 0) {
            v7 = v11.changed(v14) ? 0x4000 : 0x2000;
            v4 |= v7;
        }

        Function2 v15 = arg32;
        if((0x30000 & v0) == 0) {
            v7 = v11.changedInstance(v15) ? 0x20000 : 0x10000;
            v4 |= v7;
        }

        if((0x180000 & v0) == 0) {
            int v8 = v11.changed(arg33) ? 0x100000 : 0x80000;
            v4 |= v8;
        }

        int v16 = 0xC00000;
        if((v0 & v16) == 0) {
            int v9 = v11.changed(arg34) ? 0x800000 : 0x400000;
            v4 |= v9;
        }

        if((0x6000000 & v0) == 0) {
            int v10 = v11.changedInstance(arg35) ? 0x4000000 : 0x2000000;
            v4 |= v10;
        }

        boolean v10_1 = (0x2492493 & v4) != 0x2492492 ? true : false;
        if(v11.shouldExecute(v10_1, v4 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v1, v4, -1, "androidx.compose.material3.WideNavigationRailLayout (WideNavigationRail.kt:218)");
            }

            String v10_2 = "CC(remember):WideNavigationRail.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v11, 1227630237, v10_2);
            Object v1_1 = v11.rememberedValue();
            if(v1_1 == Composer.Companion.getEmpty()) {
                v1_2 = SnapshotIntStateKt.mutableIntStateOf(0);
                v11.updateRememberedValue(v1_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            ComposerKt.sourceInformationMarkerStart(v11, 0x492C2F1D, v10_2);
            Object v10_3 = v11.rememberedValue();
            if(v10_3 == Composer.Companion.getEmpty()) {
                MutableIntState v10_4 = SnapshotIntStateKt.mutableIntStateOf(0);
                v11.updateRememberedValue(v10_4);
            }

            Object v17 = v10_3;
            ComposerKt.sourceInformationMarkerEnd(v11);
            ProvidableCompositionLocal v10_5 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            String v13 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v11, 0x789C5F52, v13);
            v10_3 = v11.consume(((CompositionLocal)v10_5));
            ComposerKt.sourceInformationMarkerEnd(v11);
            if(Dp.equals-impl0(((Dp)v10_3).unbox-impl(), Dp.Companion.getUnspecified-D9Ej5fM())) {
                v11.startReplaceGroup(-597966102);
                v11.endReplaceGroup();
                v10_6 = Dp.constructor-impl(0f);
            }
            else {
                v11.startReplaceGroup(0xDC5C4B82);
                ComposerKt.sourceInformation(v11, "225@10219L7");
                v10_5 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                ComposerKt.sourceInformationMarkerStart(v11, 0x789C5F52, v13);
                v10_3 = v11.consume(((CompositionLocal)v10_5));
                ComposerKt.sourceInformationMarkerEnd(v11);
                v10_6 = ((Dp)v10_3).unbox-impl();
                v11.endReplaceGroup();
            }

            float v19 = v10_6;
            FiniteAnimationSpec v20 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, v11, 6);
            FiniteAnimationSpec v21 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, v11, 6);
            v10_6 = !v6 ? WideNavigationRailKt.CollapsedRailWidth : WideNavigationRailKt.ExpandedRailMinWidth;
            FiniteAnimationSpec v12 = !v2 ? v20 : v21;
            State v22 = AnimateAsStateKt.animateDpAsState-AjpBEmI(v10_6, v12, null, null, v11, 0, 12);
            float v7_1 = !v6 ? WideNavigationRailKt.CollapsedRailWidth : WideNavigationRailKt.ExpandedRailMaxWidth;
            if(!v2) {
                v21 = v20;
            }

            State v21_1 = AnimateAsStateKt.animateDpAsState-AjpBEmI(v7_1, v21, null, null, v11, 0, 12);
            v7_1 = !v6 ? NavigationRailCollapsedTokens.INSTANCE.getItemVerticalSpace-D9Ej5fM() : Dp.constructor-impl(0f);
            FiniteAnimationSpec v8_1 = v20;
            State v18 = AnimateAsStateKt.animateDpAsState-AjpBEmI(v7_1, ((AnimationSpec)v8_1), null, null, v11, 0, 12);
            v7_1 = !v6 ? WideNavigationRailKt.TopIconItemMinHeight : v19;
            State v9_1 = AnimateAsStateKt.animateDpAsState-AjpBEmI(v7_1, ((AnimationSpec)v8_1), null, null, v11, 0, 12);
            long v7_2 = !v2 ? v5_1.getContainerColor-0d7_KjU() : v5_1.getModalContainerColor-0d7_KjU();
            long v23 = v7_2;
            v7_2 = !v2 ? v5_1.getContentColor-0d7_KjU() : v5_1.getModalContentColor-0d7_KjU();
            SurfaceKt.Surface-T9BRK9s(arg27, arg31, v23, v7_2, 0f, 0f, null, ComposableLambdaKt.rememberComposableLambda(0xA73ADDD7, true, new WideNavigationRailKt$WideNavigationRailLayout$1(arg33, v15, v6, v22, v19, v9_1, v21_1, v17, v1_2, arg34, v18, arg35), v11, 54), v11, v4 & 14 | v16 | v4 >> 9 & 0x70, 0x70);
            v11 = v11;
            if(!ComposerKt.isTraceInProgress()) {
                goto label_269;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v11.skipToGroupEnd();
        }

    label_269:
        ScopeUpdateScope v11_1 = v11.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new WideNavigationRailKt$$ExternalSyntheticLambda8(arg27, v2, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg37));
        }
    }

    private static final float WideNavigationRailLayout$lambda$10(State arg0) {
        return arg0.getValue().unbox-impl();
    }

    private static final float WideNavigationRailLayout$lambda$11(State arg0) {
        return arg0.getValue().unbox-impl();
    }

    static final Unit WideNavigationRailLayout$lambda$12(Modifier arg12, boolean arg13, boolean arg14, WideNavigationRailColors arg15, Shape arg16, Function2 arg17, WindowInsets arg18, Vertical arg19, Function2 arg20, int arg21, Composer arg22, int arg23) {
        WideNavigationRailKt.WideNavigationRailLayout(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg22, RecomposeScopeImplKt.updateChangedFlags(arg21 | 1));
        return Unit.INSTANCE;
    }

    private static final int WideNavigationRailLayout$lambda$3(MutableIntState arg0) {
        return ((IntState)arg0).getIntValue();
    }

    private static final void WideNavigationRailLayout$lambda$4(MutableIntState arg0, int arg1) {
        arg0.setIntValue(arg1);
    }

    private static final int WideNavigationRailLayout$lambda$6(MutableIntState arg0) {
        return ((IntState)arg0).getIntValue();
    }

    private static final void WideNavigationRailLayout$lambda$7(MutableIntState arg0, int arg1) {
        arg0.setIntValue(arg1);
    }

    private static final float WideNavigationRailLayout$lambda$8(State arg0) {
        return arg0.getValue().unbox-impl();
    }

    private static final float WideNavigationRailLayout$lambda$9(State arg0) {
        return arg0.getValue().unbox-impl();
    }

    public static final void access$ModalWideNavigationRailContent-pU6N4AM(boolean arg0, boolean arg1, Animatable arg2, RailPredictiveBackState arg3, Function2 arg4, Modifier arg5, ModalWideNavigationRailState arg6, WideNavigationRailColors arg7, Shape arg8, float arg9, Function2 arg10, WindowInsets arg11, boolean arg12, Vertical arg13, Function2 arg14, Composer arg15, int arg16, int arg17) {
        WideNavigationRailKt.ModalWideNavigationRailContent-pU6N4AM(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
    }

    public static final void access$Scrim-3J-VO9M(long arg0, Function1 arg2, boolean arg3, Composer arg4, int arg5) {
        WideNavigationRailKt.Scrim-3J-VO9M(arg0, arg2, arg3, arg4, arg5);
    }

    public static final boolean access$Scrim_3J_VO9M$lambda$28(MutableState arg0) {
        return WideNavigationRailKt.Scrim_3J_VO9M$lambda$28(arg0);
    }

    public static final void access$Scrim_3J_VO9M$lambda$29(MutableState arg0, boolean arg1) {
        WideNavigationRailKt.Scrim_3J_VO9M$lambda$29(arg0, arg1);
    }

    public static final void access$WideNavigationRailLayout(Modifier arg0, boolean arg1, boolean arg2, WideNavigationRailColors arg3, Shape arg4, Function2 arg5, WindowInsets arg6, Vertical arg7, Function2 arg8, Composer arg9, int arg10) {
        WideNavigationRailKt.WideNavigationRailLayout(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static final float access$WideNavigationRailLayout$lambda$10(State arg0) {
        return WideNavigationRailKt.WideNavigationRailLayout$lambda$10(arg0);
    }

    public static final float access$WideNavigationRailLayout$lambda$11(State arg0) {
        return WideNavigationRailKt.WideNavigationRailLayout$lambda$11(arg0);
    }

    public static final int access$WideNavigationRailLayout$lambda$3(MutableIntState arg0) {
        return WideNavigationRailKt.WideNavigationRailLayout$lambda$3(arg0);
    }

    public static final void access$WideNavigationRailLayout$lambda$4(MutableIntState arg0, int arg1) {
        WideNavigationRailKt.WideNavigationRailLayout$lambda$4(arg0, arg1);
    }

    public static final int access$WideNavigationRailLayout$lambda$6(MutableIntState arg0) {
        return WideNavigationRailKt.WideNavigationRailLayout$lambda$6(arg0);
    }

    public static final void access$WideNavigationRailLayout$lambda$7(MutableIntState arg0, int arg1) {
        WideNavigationRailKt.WideNavigationRailLayout$lambda$7(arg0, arg1);
    }

    public static final float access$WideNavigationRailLayout$lambda$8(State arg0) {
        return WideNavigationRailKt.WideNavigationRailLayout$lambda$8(arg0);
    }

    public static final float access$WideNavigationRailLayout$lambda$9(State arg0) {
        return WideNavigationRailKt.WideNavigationRailLayout$lambda$9(arg0);
    }

    public static final float access$calculatePredictiveBackScaleX(GraphicsLayerScope arg0, float arg1, boolean arg2) {
        return WideNavigationRailKt.calculatePredictiveBackScaleX(arg0, arg1, arg2);
    }

    public static final float access$calculatePredictiveBackScaleY(GraphicsLayerScope arg0, float arg1) {
        return WideNavigationRailKt.calculatePredictiveBackScaleY(arg0, arg1);
    }

    public static final float access$getCollapsedRailWidth$p() {
        return WideNavigationRailKt.CollapsedRailWidth;
    }

    public static final float access$getExpandedRailMaxWidth$p() {
        return WideNavigationRailKt.ExpandedRailMaxWidth;
    }

    public static final float access$getExpandedRailMinWidth$p() {
        return WideNavigationRailKt.ExpandedRailMinWidth;
    }

    public static final float access$getItemHorizontalPadding$p() {
        return WideNavigationRailKt.ItemHorizontalPadding;
    }

    public static final float access$getWNRHeaderPadding$p() {
        return WideNavigationRailKt.WNRHeaderPadding;
    }

    public static final float access$getWNRVerticalPadding$p() {
        return WideNavigationRailKt.WNRVerticalPadding;
    }

    private static final float calculatePredictiveBackScaleX(GraphicsLayerScope arg4, float arg5, boolean arg6) {
        float v0 = Float.intBitsToFloat(((int)(arg4.getSize-NH-jbRc() >> 0x20)));
        float v2 = 1f;
        if(!Float.isNaN(v0)) {
            if(v0 == 0f) {
            }
            else {
                float v6 = arg6 ? v2 : -1f;
                return v6 * MathHelpersKt.lerp(0f, Math.min(arg4.toPx-0680j_4(WideNavigationRailKt.PredictiveBackMaxScaleXDistance), v0), arg5) / v0 + v2;
            }
        }

        return v2;
    }

    private static final float calculatePredictiveBackScaleY(GraphicsLayerScope arg4, float arg5) {
        float v0 = Float.intBitsToFloat(((int)(arg4.getSize-NH-jbRc() & 0xFFFFFFFFL)));
        float v2 = 1f;
        if(!Float.isNaN(v0)) {
            if(v0 == 0f) {
            }
            else {
                v2 -= MathHelpersKt.lerp(0f, Math.min(arg4.toPx-0680j_4(WideNavigationRailKt.PredictiveBackMaxScaleYDistance), v0), arg5) / v0;
            }
        }

        return v2;
    }

    public static final ProvidableCompositionLocal getLocalModalWideNavigationRailOverride() {
        return WideNavigationRailKt.LocalModalWideNavigationRailOverride;
    }

    public static final ProvidableCompositionLocal getLocalWideNavigationRailOverride() {
        return WideNavigationRailKt.LocalWideNavigationRailOverride;
    }

    public static final float getWNRItemNoLabelIndicatorPadding() {
        return WideNavigationRailKt.WNRItemNoLabelIndicatorPadding;
    }
}

