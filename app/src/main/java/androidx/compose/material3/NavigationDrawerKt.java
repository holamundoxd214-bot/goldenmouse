package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.BackHandler_androidKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R$string;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000\u008C\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A+\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0014\b\u0002\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001A]\u0010\b\u001A\u00020\t2\u0011\u0010\n\u001A\r\u0012\u0004\u0012\u00020\t0\u000B¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00012\b\b\u0002\u0010\u0010\u001A\u00020\u00062\b\b\u0002\u0010\u0011\u001A\u00020\u00122\u0011\u0010\u0013\u001A\r\u0012\u0004\u0012\u00020\t0\u000B¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001AQ\u0010\u0016\u001A\u00020\t2\u0011\u0010\n\u001A\r\u0012\u0004\u0012\u00020\t0\u000B¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00012\b\b\u0002\u0010\u0010\u001A\u00020\u00062\u0011\u0010\u0013\u001A\r\u0012\u0004\u0012\u00020\t0\u000B¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0017\u001A=\u0010\u0018\u001A\u00020\t2\u0011\u0010\n\u001A\r\u0012\u0004\u0012\u00020\t0\u000B¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\u0011\u0010\u0013\u001A\r\u0012\u0004\u0012\u00020\t0\u000B¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0019\u001Ai\u0010\u001A\u001A\u00020\t2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u00122\b\b\u0002\u0010\u001E\u001A\u00020\u00122\b\b\u0002\u0010\u001F\u001A\u00020 2\b\b\u0002\u0010!\u001A\u00020\"2\u001C\u0010\u0013\u001A\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b%\u0010&\u001Aq\u0010\u001A\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u00012\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u00122\b\b\u0002\u0010\u001E\u001A\u00020\u00122\b\b\u0002\u0010\u001F\u001A\u00020 2\b\b\u0002\u0010!\u001A\u00020\"2\u001C\u0010\u0013\u001A\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b\'\u0010(\u001Ai\u0010)\u001A\u00020\t2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u00122\b\b\u0002\u0010\u001E\u001A\u00020\u00122\b\b\u0002\u0010\u001F\u001A\u00020 2\b\b\u0002\u0010!\u001A\u00020\"2\u001C\u0010\u0013\u001A\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b*\u0010&\u001Aq\u0010)\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u00012\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u00122\b\b\u0002\u0010\u001E\u001A\u00020\u00122\b\b\u0002\u0010\u001F\u001A\u00020 2\b\b\u0002\u0010!\u001A\u00020\"2\u001C\u0010\u0013\u001A\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b+\u0010(\u001Ai\u0010,\u001A\u00020\t2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u00122\b\b\u0002\u0010\u001E\u001A\u00020\u00122\b\b\u0002\u0010\u001F\u001A\u00020 2\b\b\u0002\u0010!\u001A\u00020\"2\u001C\u0010\u0013\u001A\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b-\u0010&\u001A{\u0010.\u001A\u00020\t2\b\u0010/\u001A\u0004\u0018\u0001002\u0006\u0010!\u001A\u00020\"2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u00122\b\b\u0002\u0010\u001E\u001A\u00020\u00122\b\b\u0002\u0010\u001F\u001A\u00020 2\b\b\u0002\u00101\u001A\u0002022\u001C\u0010\u0013\u001A\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0001¢\u0006\u0004\b3\u00104\u001A$\u00105\u001A\u00020\u000E*\u00020\u000E2\u0006\u00101\u001A\u0002022\u0006\u00106\u001A\u0002072\u0006\u00108\u001A\u00020\u0006H\u0002\u001A$\u00109\u001A\u00020\u000E*\u00020\u000E2\u0006\u00101\u001A\u0002022\u0006\u00106\u001A\u0002072\u0006\u00108\u001A\u00020\u0006H\u0002\u001A\u001C\u0010:\u001A\u00020\u000E*\u00020\u000E2\u0006\u0010/\u001A\u0002002\u0006\u00108\u001A\u00020\u0006H\u0002\u001A\u001C\u0010;\u001A\u00020\u000E*\u00020\u000E2\u0006\u0010/\u001A\u0002002\u0006\u00108\u001A\u00020\u0006H\u0002\u001A\u0014\u0010<\u001A\u000207*\u00020=2\u0006\u0010/\u001A\u000200H\u0002\u001A\u0014\u0010>\u001A\u000207*\u00020=2\u0006\u0010/\u001A\u000200H\u0002\u001A.\u0010?\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u00012\u0017\u0010\u0013\u001A\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010@\u001A\u008E\u0001\u0010A\u001A\u00020\t2\u0011\u0010B\u001A\r\u0012\u0004\u0012\u00020\t0\u000B¢\u0006\u0002\b\f2\u0006\u0010C\u001A\u00020\u00062\f\u0010D\u001A\b\u0012\u0004\u0012\u00020\t0\u000B2\b\b\u0002\u0010\r\u001A\u00020\u000E2\u0015\b\u0002\u0010E\u001A\u000F\u0012\u0004\u0012\u00020\t\u0018\u00010\u000B¢\u0006\u0002\b\f2\u0015\b\u0002\u0010F\u001A\u000F\u0012\u0004\u0012\u00020\t\u0018\u00010\u000B¢\u0006\u0002\b\f2\b\b\u0002\u0010G\u001A\u00020\u001C2\b\b\u0002\u0010H\u001A\u00020I2\n\b\u0002\u0010J\u001A\u0004\u0018\u00010KH\u0007¢\u0006\u0002\u0010L\u001A \u0010M\u001A\u0002072\u0006\u0010N\u001A\u0002072\u0006\u0010O\u001A\u0002072\u0006\u0010P\u001A\u000207H\u0002\u001A;\u0010Q\u001A\u00020\t2\u0006\u0010R\u001A\u00020\u00062\f\u0010S\u001A\b\u0012\u0004\u0012\u00020\t0\u000B2\f\u0010T\u001A\b\u0012\u0004\u0012\u0002070\u000B2\u0006\u0010U\u001A\u00020\u0012H\u0003¢\u0006\u0004\bV\u0010W\"\u000E\u0010X\u001A\u000207X\u0082D¢\u0006\u0002\n\u0000\"\u0010\u0010Y\u001A\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010[\u001A\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0016\u0010\\\u001A\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001A\u0004\b]\u0010^\"\u0016\u0010_\u001A\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001A\u0004\b`\u0010^\"\u0016\u0010a\u001A\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001A\u0004\bb\u0010^\"\u0014\u0010c\u001A\b\u0012\u0004\u0012\u0002070dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006e²\u0006\n\u0010f\u001A\u00020\u0006X\u008A\u008E\u0002²\u0006\n\u0010g\u001A\u000207X\u008A\u008E\u0002²\u0006\n\u0010f\u001A\u00020\u0006X\u008A\u008E\u0002"}, d2={"rememberDrawerState", "Landroidx/compose/material3/DrawerState;", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "ModalNavigationDrawer", "", "drawerContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "gesturesEnabled", "scrimColor", "Landroidx/compose/ui/graphics/Color;", "content", "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "drawerContentColor", "drawerTonalElevation", "Landroidx/compose/ui/unit/Dp;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet-Snr_uVM", "(Landroidx/compose/material3/DrawerState;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleDrawerSheet", "DismissibleDrawerSheet-afqeVBk", "DismissibleDrawerSheet-Snr_uVM", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "DrawerSheet", "drawerPredictiveBackState", "Landroidx/compose/material3/DrawerPredictiveBackState;", "drawerOffset", "Landroidx/compose/material3/internal/FloatProducer;", "DrawerSheet-cm3T3N0", "(Landroidx/compose/material3/DrawerPredictiveBackState;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/material3/internal/FloatProducer;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "horizontalScaleUp", "drawerWidth", "", "isRtl", "horizontalScaleDown", "predictiveBackDrawerContainer", "predictiveBackDrawerChild", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "calculatePredictiveBackScaleY", "DrawerPredictiveBackHandler", "(Landroidx/compose/material3/DrawerState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "NavigationDrawerItem", "label", "selected", "onClick", "icon", "badge", "shape", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "calculateFraction", "a", "b", "pos", "Scrim", "open", "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "DrawerPositionalThreshold", "DrawerVelocityThreshold", "F", "MinimumDrawerWidth", "PredictiveBackDrawerMaxScaleXDistanceGrow", "getPredictiveBackDrawerMaxScaleXDistanceGrow", "()F", "PredictiveBackDrawerMaxScaleXDistanceShrink", "getPredictiveBackDrawerMaxScaleXDistanceShrink", "PredictiveBackDrawerMaxScaleYDistance", "getPredictiveBackDrawerMaxScaleYDistance", "AnchoredDraggableDefaultAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "material3", "anchorsInitialized", "minValue"}, k=2, mv={2, 0, 0}, xi=0x30) public final class NavigationDrawerKt {
    private static final TweenSpec AnchoredDraggableDefaultAnimationSpec = null;
    private static final float DrawerPositionalThreshold = 0.5f;
    private static final float DrawerVelocityThreshold;
    private static final float MinimumDrawerWidth;
    private static final float PredictiveBackDrawerMaxScaleXDistanceGrow;
    private static final float PredictiveBackDrawerMaxScaleXDistanceShrink;
    private static final float PredictiveBackDrawerMaxScaleYDistance;

    static {
        NavigationDrawerKt.DrawerVelocityThreshold = Dp.constructor-impl(400f);
        NavigationDrawerKt.MinimumDrawerWidth = Dp.constructor-impl(240f);
        NavigationDrawerKt.PredictiveBackDrawerMaxScaleXDistanceGrow = Dp.constructor-impl(12f);
        NavigationDrawerKt.PredictiveBackDrawerMaxScaleXDistanceShrink = Dp.constructor-impl(24f);
        NavigationDrawerKt.PredictiveBackDrawerMaxScaleYDistance = Dp.constructor-impl(48f);
        NavigationDrawerKt.AnchoredDraggableDefaultAnimationSpec = new TweenSpec(0x100, 0, null, 6, null);
    }

    public static final void DismissibleDrawerSheet-Snr_uVM(DrawerState arg18, Modifier arg19, Shape arg20, long arg21, long arg23, float arg25, WindowInsets arg26, Function3 arg27, Composer arg28, int arg29, int arg30) {
        WindowInsets v9_1;
        WindowInsets v1_1;
        int v14_1;
        float v8_1;
        long v4_1;
        Shape v3_2;
        Modifier v2_1;
        Companion v3_1;
        int v17;
        WindowInsets v0;
        float v10_1;
        long v14;
        int v8;
        long v6_1;
        Shape v5;
        int v4;
        Modifier v3;
        int v1;
        DrawerState v9 = arg18;
        int v11 = arg29;
        int v12 = arg30;
        Composer v13 = arg28.startRestartGroup(496605370);
        ComposerKt.sourceInformation(v13, "C(DismissibleDrawerSheet)N(drawerState,modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)731@31451L519,731@31410L560:NavigationDrawer.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v1 = v11 | 6;
        }
        else if((v11 & 6) == 0) {
            v1 = v13.changed(v9) ? 4 : 2;
            v1 |= v11;
        }
        else {
            v1 = v11;
        }

        int v2 = v12 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
            goto label_36;
        }
        else if((v11 & 0x30) == 0) {
            v3 = arg19;
            v4 = v13.changed(v3) ? 0x20 : 16;
            v1 |= v4;
        }
        else {
        label_36:
            v3 = arg19;
        }

        v4 = v12 & 4;
        if(v4 != 0) {
            v1 |= 0x180;
            goto label_51;
        }
        else if((v11 & 0x180) == 0) {
            v5 = arg20;
            int v6 = v13.changed(v5) ? 0x100 : 0x80;
            v1 |= v6;
        }
        else {
        label_51:
            v5 = arg20;
        }

        if((v11 & 0xC00) == 0) {
            if((v12 & 8) == 0) {
                v6_1 = arg21;
                if(v13.changed(v6_1)) {
                    v8 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v6_1 = arg21;
            label_62:
                v8 = 0x400;
            }

            v1 |= v8;
        }
        else {
            v6_1 = arg21;
        }

        if((v11 & 0x6000) == 0) {
            v14 = arg23;
            v8 = (v12 & 16) != 0 || !v13.changed(v14) ? 0x2000 : 0x4000;
            v1 |= v8;
        }
        else {
            v14 = arg23;
        }

        v8 = v12 & 0x20;
        int v10 = 0x30000;
        if(v8 != 0) {
            v1 |= v10;
            goto label_94;
        }
        else if((v10 & v11) == 0) {
            v10_1 = arg25;
            int v16 = v13.changed(v10_1) ? 0x20000 : 0x10000;
            v1 |= v16;
        }
        else {
        label_94:
            v10_1 = arg25;
        }

        if((v11 & 0x180000) == 0) {
            v0 = arg26;
            v17 = (v12 & 0x40) != 0 || !v13.changed(v0) ? 0x80000 : 0x100000;
            v1 |= v17;
        }

        v17 = 0xC00000;
        if((v12 & 0x80) != 0) {
            v1 |= v17;
        }
        else if((v11 & v17) == 0) {
            v17 = v13.changedInstance(arg27) ? 0x800000 : 0x400000;
            v1 |= v17;
        }

        int v28 = v2;
        boolean v0_1 = (v1 & 0x492493) != 4793490 ? true : false;
        if(v13.shouldExecute(v0_1, v1 & 1)) {
            v13.startDefaults();
            ComposerKt.sourceInformation(v13, "725@31122L22,726@31178L37,728@31339L12");
            v2 = 0xFFC7FFFF;
            v17 = 0xFFFF1FFF;
            if((arg29 & 1) == 0 || (v13.getDefaultsInvalid())) {
                if(v28 != 0) {
                    v3_1 = Modifier.Companion;
                }

                if(v4 != 0) {
                    v5 = RectangleShapeKt.getRectangleShape();
                }

                v4 = 6;
                if((v12 & 8) != 0) {
                    v6_1 = DrawerDefaults.INSTANCE.getStandardContainerColor(v13, v4);
                    v1 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v14 = ColorSchemeKt.contentColorFor-ek8zF_U(v6_1, v13, v1 >> 9 & 14);
                    v1 &= v17;
                }

                if(v8 != 0) {
                    v10_1 = DrawerDefaults.INSTANCE.getDismissibleDrawerElevation-D9Ej5fM();
                }

                if((v12 & 0x40) != 0) {
                    v0 = DrawerDefaults.INSTANCE.getWindowInsets(v13, v4);
                    v1 &= v2;
                    v2_1 = ((Modifier)v3_1);
                    v3_2 = v5;
                    v4_1 = v6_1;
                    v8_1 = v10_1;
                    v6_1 = v14;
                    v14_1 = v1;
                    v1_1 = v0;
                    goto label_200;
                }

            label_157:
                v2_1 = ((Modifier)v3_1);
                v3_2 = v5;
                v4_1 = v6_1;
                v8_1 = v10_1;
                v6_1 = v14;
                v14_1 = v1;
                v1_1 = arg26;
            }
            else {
                v13.skipToGroupEnd();
                if((v12 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v1 &= v17;
                }

                if((v12 & 0x40) == 0) {
                    goto label_157;
                }

                v1 &= v2;
                goto label_157;
            }

        label_200:
            v13.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(496605370, v14_1, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:730)");
            }

            NavigationDrawerKt.DrawerPredictiveBackHandler(v9, ComposableLambdaKt.rememberComposableLambda(0x60C3F72F, true, new NavigationDrawerKt$DismissibleDrawerSheet$2(v1_1, v2_1, v3_2, v4_1, v6_1, v8_1, v9, arg27), v13, 54), v13, v14_1 & 14 | 0x30);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v9_1 = v1_1;
        }
        else {
            v13.skipToGroupEnd();
            v9_1 = arg26;
            v2_1 = v3;
            v3_2 = v5;
            v4_1 = v6_1;
            v8_1 = v10_1;
            v6_1 = v14;
        }

        ScopeUpdateScope v13_1 = v13.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new NavigationDrawerKt$$ExternalSyntheticLambda17(arg18, v2_1, v3_2, v4_1, v6_1, v8_1, v9_1, arg27, arg29, v12));
        }
    }

    public static final void DismissibleDrawerSheet-afqeVBk(Modifier arg25, Shape arg26, long arg27, long arg29, float arg31, WindowInsets arg32, Function3 arg33, Composer arg34, int arg35, int arg36) {
        float v7_2;
        long v5_1;
        long v3_1;
        Shape v2_1;
        Modifier v1_1;
        WindowInsets v8;
        Composer v22;
        Shape v14_2;
        int v0_1;
        WindowInsets v12;
        float v19;
        long v17;
        long v15_1;
        Companion v13_2;
        Modifier v0_3;
        int v15;
        WindowInsets v14_1;
        float v13;
        long v11;
        int v9;
        long v7_1;
        Shape v6;
        Modifier v3;
        int v4;
        int v10 = arg35;
        Composer v1 = arg34.startRestartGroup(0xA6CEC666);
        ComposerKt.sourceInformation(v1, "C(DismissibleDrawerSheet)N(modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)687@29311L343:NavigationDrawer.kt#uh7d8r");
        int v2 = arg36 & 1;
        if(v2 != 0) {
            v4 = v10 | 6;
            v3 = arg25;
        }
        else if((v10 & 6) == 0) {
            v3 = arg25;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v10;
        }
        else {
            v3 = arg25;
            v4 = v10;
        }

        int v5 = arg36 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_38;
        }
        else if((v10 & 0x30) == 0) {
            v6 = arg26;
            int v7 = v1.changed(v6) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_38:
            v6 = arg26;
        }

        if((v10 & 0x180) == 0) {
            if((arg36 & 4) == 0) {
                v7_1 = arg27;
                if(v1.changed(v7_1)) {
                    v9 = 0x100;
                }
                else {
                    goto label_49;
                }
            }
            else {
                v7_1 = arg27;
            label_49:
                v9 = 0x80;
            }

            v4 |= v9;
        }
        else {
            v7_1 = arg27;
        }

        if((v10 & 0xC00) == 0) {
            v11 = arg29;
            v9 = (arg36 & 8) != 0 || !v1.changed(v11) ? 0x400 : 0x800;
            v4 |= v9;
        }
        else {
            v11 = arg29;
        }

        v9 = arg36 & 16;
        if(v9 != 0) {
            v4 |= 0x6000;
            goto label_80;
        }
        else if((v10 & 0x6000) == 0) {
            v13 = arg31;
            int v14 = v1.changed(v13) ? 0x4000 : 0x2000;
            v4 |= v14;
        }
        else {
        label_80:
            v13 = arg31;
        }

        if((0x30000 & v10) == 0) {
            if((arg36 & 0x20) == 0) {
                v14_1 = arg32;
                if(v1.changed(v14_1)) {
                    v15 = 0x20000;
                }
                else {
                    goto label_92;
                }
            }
            else {
                v14_1 = arg32;
            label_92:
                v15 = 0x10000;
            }

            v4 |= v15;
        }
        else {
            v14_1 = arg32;
        }

        int v16 = 0x180000;
        if((arg36 & 0x40) != 0) {
            v4 |= v16;
        }
        else if((v10 & v16) == 0) {
            v16 = v1.changedInstance(arg33) ? 0x100000 : 0x80000;
            v4 |= v16;
        }

        int v34 = v2;
        boolean v0 = (v4 & 0x92493) != 0x92492 ? true : false;
        if(v1.shouldExecute(v0, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "681@29023L22,682@29079L37,684@29240L12");
            v16 = 0xFFF8FFFF;
            v2 = 6;
            if((v10 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v34 != 0) {
                    Companion v0_2 = Modifier.Companion;
                }
                else {
                    v0_3 = v3;
                }

                if(v5 != 0) {
                    v6 = RectangleShapeKt.getRectangleShape();
                }

                if((arg36 & 4) != 0) {
                    v7_1 = DrawerDefaults.INSTANCE.getStandardContainerColor(v1, v2);
                    v4 &= -897;
                }

                if((arg36 & 8) != 0) {
                    v11 = ColorSchemeKt.contentColorFor-ek8zF_U(v7_1, v1, v4 >> 6 & 14);
                    v4 &= 0xFFFFE3FF;
                }

                if(v9 != 0) {
                    v13 = DrawerDefaults.INSTANCE.getDismissibleDrawerElevation-D9Ej5fM();
                }

                if((arg36 & 0x20) != 0) {
                    v4 &= v16;
                    v14_2 = v6;
                    v15_1 = v7_1;
                    v17 = v11;
                    v19 = v13;
                    v13_2 = ((Companion)v0_3);
                    v12 = DrawerDefaults.INSTANCE.getWindowInsets(v1, v2);
                }
                else {
                    v15_1 = v7_1;
                    v17 = v11;
                    v19 = v13;
                    v12 = v14_1;
                    v13_2 = ((Companion)v0_3);
                    v14_2 = v6;
                }

                v0_1 = 0xA6CEC666;
            }
            else {
                v1.skipToGroupEnd();
                if((arg36 & 4) != 0) {
                    v4 &= -897;
                }

                if((arg36 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                if((arg36 & 0x20) != 0) {
                    v4 &= v16;
                }

                v15_1 = v7_1;
                v17 = v11;
                v19 = v13;
                v12 = v14_1;
                v0_1 = 0xA6CEC666;
                Modifier v13_1 = v3;
                v14_2 = v6;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_1, v4, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:686)");
            }

            v0_1 = v4 >> 12 & 0x70 | v2;
            v2 = v4 << 6;
            v22 = v1;
            NavigationDrawerKt.DrawerSheet-cm3T3N0(null, v12, ((Modifier)v13_2), v14_2, v15_1, v17, v19, null, arg33, v22, v0_1 | v2 & 0x380 | v2 & 0x1C00 | 0xE000 & v2 | 0x70000 & v2 | 0x380000 & v2 | v2 & 0xE000000, 0x80);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8 = v12;
            v1_1 = ((Modifier)v13_2);
            v2_1 = v14_2;
            v3_1 = v15_1;
            v5_1 = v17;
            v7_2 = v19;
        }
        else {
            v22 = v1;
            v22.skipToGroupEnd();
            v1_1 = v3;
            v2_1 = v6;
            v3_1 = v7_1;
            v5_1 = v11;
            v7_2 = v13;
            v8 = v14_1;
        }

        ScopeUpdateScope v12_1 = v22.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new NavigationDrawerKt$$ExternalSyntheticLambda11(v1_1, v2_1, v3_1, v5_1, v7_2, v8, arg33, v10, arg36));
        }
    }

    static final Unit DismissibleDrawerSheet_Snr_uVM$lambda$46(DrawerState arg14, Modifier arg15, Shape arg16, long arg17, long arg19, float arg21, WindowInsets arg22, Function3 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        NavigationDrawerKt.DismissibleDrawerSheet-Snr_uVM(arg14, arg15, arg16, arg17, arg19, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit DismissibleDrawerSheet_afqeVBk$lambda$45(Modifier arg13, Shape arg14, long arg15, long arg17, float arg19, WindowInsets arg20, Function3 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        NavigationDrawerKt.DismissibleDrawerSheet-afqeVBk(arg13, arg14, arg15, arg17, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    public static final void DismissibleNavigationDrawer(Function2 arg26, Modifier arg27, DrawerState arg28, boolean arg29, Function2 arg30, Composer arg31, int arg32, int arg33) {
        boolean v4_6;
        NavigationDrawerKt$$ExternalSyntheticLambda23 v7_3;
        NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1 v13_4;
        MutableState v0_2;
        boolean v20;
        Modifier v16;
        Companion v8_1;
        int v13;
        boolean v12;
        int v11;
        DrawerState v9_1;
        Modifier v8;
        int v3;
        Function2 v1 = arg26;
        Function2 v5 = arg30;
        int v6 = arg32;
        int v0 = 1150092038;
        Composer v2 = arg31.startRestartGroup(v0);
        ComposerKt.sourceInformation(v2, "C(DismissibleNavigationDrawer)N(drawerContent,modifier,drawerState,gesturesEnabled,content)464@19353L34,465@19419L7,468@19586L7,469@19678L7,471@19702L155,471@19691L166,477@19875L24,478@19925L33,480@19997L7,481@20032L2189:NavigationDrawer.kt#uh7d8r");
        int v4 = 2;
        if((arg33 & 1) != 0) {
            v3 = v6 | 6;
        }
        else if((v6 & 6) == 0) {
            v3 = v2.changedInstance(v1) ? 4 : v4;
            v3 |= v6;
        }
        else {
            v3 = v6;
        }

        int v7 = arg33 & 2;
        if(v7 != 0) {
            v3 |= 0x30;
            goto label_37;
        }
        else if((v6 & 0x30) == 0) {
            v8 = arg27;
            int v9 = v2.changed(v8) ? 0x20 : 16;
            v3 |= v9;
        }
        else {
        label_37:
            v8 = arg27;
        }

        int v10 = 0x100;
        if((v6 & 0x180) == 0) {
            if((arg33 & 4) == 0) {
                v9_1 = arg28;
                if(v2.changed(v9_1)) {
                    v11 = v10;
                }
                else {
                    goto label_49;
                }
            }
            else {
                v9_1 = arg28;
            label_49:
                v11 = 0x80;
            }

            v3 |= v11;
        }
        else {
            v9_1 = arg28;
        }

        v11 = arg33 & 8;
        if(v11 != 0) {
            v3 |= 0xC00;
            goto label_67;
        }
        else if((v6 & 0xC00) == 0) {
            v12 = arg29;
            v13 = v2.changed(v12) ? 0x800 : 0x400;
            v3 |= v13;
        }
        else {
        label_67:
            v12 = arg29;
        }

        if((arg33 & 16) != 0) {
            v3 |= 0x6000;
        }
        else if((v6 & 0x6000) == 0) {
            v13 = v2.changedInstance(v5) ? 0x4000 : 0x2000;
            v3 |= v13;
        }

        boolean v13_1 = (v3 & 9363) != 9362 ? true : false;
        if(v2.shouldExecute(v13_1, v3 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "460@19204L39");
            Function1 v14 = null;
            int v15 = 6;
            if((v6 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v7 != 0) {
                    v8_1 = Modifier.Companion;
                }

                if((arg33 & 4) != 0) {
                    v3 &= -897;
                    v9_1 = NavigationDrawerKt.rememberDrawerState(DrawerValue.Closed, v14, v2, v15, v4);
                }

                if(v11 != 0) {
                    v16 = ((Modifier)v8_1);
                    v20 = true;
                    goto label_119;
                }

            label_104:
                v16 = ((Modifier)v8_1);
                v20 = v12;
            }
            else {
                v2.skipToGroupEnd();
                if((arg33 & 4) != 0) {
                    v3 &= -897;
                }
                else {
                }

                goto label_104;
            }

        label_119:
            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:463)");
            }

            String v7_1 = "CC(remember):NavigationDrawer.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v2, 0x55587F88, v7_1);
            Object v0_1 = v2.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), ((SnapshotMutationPolicy)v14), v4, v14);
                v2.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            ProvidableCompositionLocal v4_1 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v4_2 = v2.consume(((CompositionLocal)v4_1));
            ComposerKt.sourceInformationMarkerEnd(v2);
            FiniteAnimationSpec v8_2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, v2, v15);
            FiniteAnimationSpec v11_1 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, v2, v15);
            ComposerKt.sourceInformationMarkerStart(v2, 0x5558ABA1, v7_1);
            int v12_1 = v3 & 0x380 ^ 0x180;
            v13 = v12_1 > v10 && (v2.changed(v9_1)) || (v3 & 0x180) == v10 ? 1 : 0;
            v13 = v13 | v2.changed(v4_2) | v2.changedInstance(v8_2) | v2.changedInstance(v11_1);
            Object v15_1 = v2.rememberedValue();
            if(v13 != 0 || v15_1 == Composer.Companion.getEmpty()) {
                NavigationDrawerKt$$ExternalSyntheticLambda21 v15_2 = new NavigationDrawerKt$$ExternalSyntheticLambda21(v9_1, ((Density)v4_2), v8_2, v11_1);
                v2.updateRememberedValue(v15_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            EffectsKt.SideEffect(((Function0)v15_1), v2, 0);
            ComposerKt.sourceInformationMarkerStart(v2, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v2, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
            v4_2 = v2.rememberedValue();
            if(v4_2 == Composer.Companion.getEmpty()) {
                CoroutineScope v4_3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v2);
                v2.updateRememberedValue(v4_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            String v8_3 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.navigation_menu), v2, 0);
            ProvidableCompositionLocal v11_2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v11_3 = v2.consume(((CompositionLocal)v11_2));
            ComposerKt.sourceInformationMarkerEnd(v2);
            boolean v18 = v11_3 == LayoutDirection.Rtl ? true : false;
            Modifier v11_4 = AnchoredDraggableKt.anchoredDraggable$default(v16, v9_1.getAnchoredDraggableState$material3(), v18, Orientation.Horizontal, v20, null, null, null, 0x70, null);
            String v15_3 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v2, 0x2BB5B5D7, v15_3);
            MeasurePolicy v13_2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            String v6_1 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v2, -1323940314, v6_1);
            int v19 = ComposablesKt.getCurrentCompositeKeyHash(v2, 0);
            CompositionLocalMap v14_1 = v2.getCurrentCompositionLocalMap();
            v11_4 = ComposedModifierKt.materializeModifier(v2, v11_4);
            Function0 v10_1 = ComposeUiNode.Companion.getConstructor();
            String v1_1 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v2, 0xD6BD0031, v1_1);
            if(!(v2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v2.startReusableNode();
            if(v2.getInserting()) {
                v2.createNode(v10_1);
            }
            else {
                v2.useNode();
            }

            Composer v5_1 = Updater.constructor-impl(v2);
            Updater.set-impl(v5_1, v13_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_1, v14_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v10_2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v5_1.getInserting()) || !Intrinsics.areEqual(v5_1.rememberedValue(), Integer.valueOf(v19))) {
                v5_1.updateRememberedValue(Integer.valueOf(v19));
                v5_1.apply(Integer.valueOf(v19), v10_2);
            }

            Updater.set-impl(v5_1, v11_4, ComposeUiNode.Companion.getSetModifier());
            String v10_3 = "C72@3468L9:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v2, 0x800B7D29, v10_3);
            ComposerKt.sourceInformationMarkerStart(v2, -901227702, "C508@20959L1256,489@20282L1933:NavigationDrawer.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(v2, 0x9B2BF1D4, v7_1);
            v11 = 0x100;
            v11 = v12_1 > v11 && (v2.changed(v9_1)) || (v3 & 0x180) == v11 ? 1 : 0;
            Object v13_3 = v2.rememberedValue();
            if(v11 != 0 || v13_3 == Composer.Companion.getEmpty()) {
                v13_4 = new NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1(v9_1, v0_2);
                v2.updateRememberedValue(v13_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerStart(v2, -1323940314, v6_1);
            Companion v0_3 = Modifier.Companion;
            int v14_2 = ComposablesKt.getCurrentCompositeKeyHash(v2, 0);
            CompositionLocalMap v11_5 = v2.getCurrentCompositionLocalMap();
            Modifier v0_4 = ComposedModifierKt.materializeModifier(v2, ((Modifier)v0_3));
            Function0 v5_2 = ComposeUiNode.Companion.getConstructor();
            v19 = v14_2;
            ComposerKt.sourceInformationMarkerStart(v2, 0xD6BD0031, v1_1);
            if(!(v2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v2.startReusableNode();
            if(v2.getInserting()) {
                v2.createNode(v5_2);
            }
            else {
                v2.useNode();
            }

            v5_1 = Updater.constructor-impl(v2);
            Updater.set-impl(v5_1, v13_4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_1, v11_5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v11_6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v5_1.getInserting()) || !Intrinsics.areEqual(v5_1.rememberedValue(), Integer.valueOf(v19))) {
                v5_1.updateRememberedValue(Integer.valueOf(v19));
                v5_1.apply(Integer.valueOf(v19), v11_6);
            }

            Updater.set-impl(v5_1, v0_4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v2, 0x69FBF244, "C492@20374L452,491@20330L570,506@20917L17:NavigationDrawer.kt#uh7d8r");
            v0_3 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v2, -2020850041, v7_1);
            boolean v5_3 = v2.changed(v8_3);
            v11 = 0x100;
            v7 = v12_1 > v11 && (v2.changed(v9_1)) || (v3 & 0x180) == v11 ? 1 : 0;
            int v5_4 = (((int)v5_3)) | v7 | v2.changedInstance(v4_2);
            Object v7_2 = v2.rememberedValue();
            if(v5_4 != 0 || v7_2 == Composer.Companion.getEmpty()) {
                v7_3 = new NavigationDrawerKt$$ExternalSyntheticLambda23(v8_3, v9_1, ((CoroutineScope)v4_2));
                v2.updateRememberedValue(v7_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            v0_4 = SemanticsModifierKt.semantics$default(((Modifier)v0_3), false, ((Function1)v7_3), 1, null);
            ComposerKt.sourceInformationMarkerStart(v2, 0x2BB5B5D7, v15_3);
            MeasurePolicy v4_4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v2, -1323940314, v6_1);
            v5_4 = ComposablesKt.getCurrentCompositeKeyHash(v2, 0);
            CompositionLocalMap v7_4 = v2.getCurrentCompositionLocalMap();
            v0_4 = ComposedModifierKt.materializeModifier(v2, v0_4);
            Function0 v8_4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v2, 0xD6BD0031, v1_1);
            if(!(v2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v2.startReusableNode();
            if(v2.getInserting()) {
                v2.createNode(v8_4);
            }
            else {
                v2.useNode();
            }

            Composer v8_5 = Updater.constructor-impl(v2);
            Updater.set-impl(v8_5, v4_4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v8_5, v7_4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v4_5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v8_5.getInserting()) || !Intrinsics.areEqual(v8_5.rememberedValue(), Integer.valueOf(v5_4))) {
                v8_5.updateRememberedValue(Integer.valueOf(v5_4));
                v8_5.apply(Integer.valueOf(v5_4), v4_5);
            }

            Updater.set-impl(v8_5, v0_4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v2, 0x800B7D29, v10_3);
            ComposerKt.sourceInformationMarkerStart(v2, -1897277909, "C504@20867L15:NavigationDrawer.kt#uh7d8r");
            arg26.invoke(v2, Integer.valueOf(v3 & 14));
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            v2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerStart(v2, 0x2BB5B5D7, v15_3);
            v0_3 = Modifier.Companion;
            MeasurePolicy v5_5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v2, -1323940314, v6_1);
            v6 = ComposablesKt.getCurrentCompositeKeyHash(v2, 0);
            v7_4 = v2.getCurrentCompositionLocalMap();
            v0_4 = ComposedModifierKt.materializeModifier(v2, ((Modifier)v0_3));
            v8_4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v2, 0xD6BD0031, v1_1);
            if(!(v2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v2.startReusableNode();
            if(v2.getInserting()) {
                v2.createNode(v8_4);
            }
            else {
                v2.useNode();
            }

            Composer v1_2 = Updater.constructor-impl(v2);
            Updater.set-impl(v1_2, v5_5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v1_2, v7_4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            v5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v1_2.getInserting()) || !Intrinsics.areEqual(v1_2.rememberedValue(), Integer.valueOf(v6))) {
                v1_2.updateRememberedValue(Integer.valueOf(v6));
                v1_2.apply(Integer.valueOf(v6), v5);
            }

            Updater.set-impl(v1_2, v0_4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v2, 0x800B7D29, v10_3);
            ComposerKt.sourceInformationMarkerStart(v2, 0xEFC8939A, "C506@20923L9:NavigationDrawer.kt#uh7d8r");
            v5 = arg30;
            v5.invoke(v2, Integer.valueOf(v3 >> 12 & 14));
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            v2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            v2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            v2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8 = v16;
            v4_6 = v20;
        }
        else {
            v2.skipToGroupEnd();
            v4_6 = v12;
        }

        DrawerState v3_1 = v9_1;
        ScopeUpdateScope v9_2 = v2.endRestartGroup();
        if(v9_2 != null) {
            v9_2.updateScope(new NavigationDrawerKt$$ExternalSyntheticLambda24(arg26, v8, v3_1, v4_6, v5, arg32, arg33));
        }
    }

    private static final boolean DismissibleNavigationDrawer$lambda$27(MutableState arg0) {
        return ((State)arg0).getValue().booleanValue();
    }

    private static final void DismissibleNavigationDrawer$lambda$28(MutableState arg0, boolean arg1) {
        arg0.setValue(Boolean.valueOf(arg1));
    }

    static final Unit DismissibleNavigationDrawer$lambda$30$lambda$29(DrawerState arg0, Density arg1, FiniteAnimationSpec arg2, FiniteAnimationSpec arg3) {
        arg0.setDensity$material3(arg1);
        arg0.setOpenDrawerMotionSpec$material3(arg2);
        arg0.setCloseDrawerMotionSpec$material3(arg3);
        return Unit.INSTANCE;
    }

    static final Unit DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32(String arg0, DrawerState arg1, CoroutineScope arg2, SemanticsPropertyReceiver arg3) {
        SemanticsPropertiesKt.setPaneTitle(arg3, arg0);
        if(arg1.isOpen()) {
            SemanticsPropertiesKt.dismiss$default(arg3, null, new NavigationDrawerKt$$ExternalSyntheticLambda25(arg1, arg2), 1, null);
        }

        return Unit.INSTANCE;
    }

    static final boolean DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32$lambda$31(DrawerState arg8, CoroutineScope arg9) {
        if(arg8.getConfirmStateChange$material3().invoke(DrawerValue.Closed).booleanValue()) {
            BuildersKt.launch$default(arg9, null, null, new NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1(arg8, null), 3, null);
        }

        return 1;
    }

    static final Unit DismissibleNavigationDrawer$lambda$39(Function2 arg8, Modifier arg9, DrawerState arg10, boolean arg11, Function2 arg12, int arg13, int arg14, Composer arg15, int arg16) {
        NavigationDrawerKt.DismissibleNavigationDrawer(arg8, arg9, arg10, arg11, arg12, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    public static final void DrawerPredictiveBackHandler(DrawerState arg18, Function3 arg19, Composer arg20, int arg21) {
        NavigationDrawerKt$DrawerPredictiveBackHandler$3$1 v2_3;
        Object v1_3;
        String v14_1;
        CoroutineScope v2_2;
        int v1;
        DrawerState v3 = arg18;
        Function3 v9 = arg19;
        int v10 = arg21;
        int v0 = 0xE92A8D05;
        Composer v11 = arg20.startRestartGroup(v0);
        ComposerKt.sourceInformation(v11, "C(DrawerPredictiveBackHandler)N(drawerState,content)942@40202L40,943@40259L24,944@40321L7,948@40483L7,954@40796L1297,954@40744L1349,986@42136L99,986@42099L136,992@42241L34:NavigationDrawer.kt#uh7d8r");
        int v12 = 4;
        if((v10 & 6) == 0) {
            v1 = v11.changed(v3) ? v12 : 2;
            v1 |= v10;
        }
        else {
            v1 = v10;
        }

        if((v10 & 0x30) == 0) {
            int v2 = v11.changedInstance(v9) ? 0x20 : 16;
            v1 |= v2;
        }

        int v13 = v1;
        boolean v1_1 = (v13 & 19) != 18 ? true : false;
        if(v11.shouldExecute(v1_1, v13 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v13, -1, "androidx.compose.material3.DrawerPredictiveBackHandler (NavigationDrawer.kt:941)");
            }

            String v1_2 = "CC(remember):NavigationDrawer.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v11, 1220245293, v1_2);
            Object v0_1 = v11.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                DrawerPredictiveBackState v0_2 = new DrawerPredictiveBackState();
                v11.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            ComposerKt.sourceInformationMarkerStart(v11, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v11, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
            Object v2_1 = v11.rememberedValue();
            if(v2_1 == Composer.Companion.getEmpty()) {
                v2_2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v11);
                v11.updateRememberedValue(v2_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            ComposerKt.sourceInformationMarkerEnd(v11);
            ProvidableCompositionLocal v4 = CompositionLocalsKt.getLocalLayoutDirection();
            int v5 = 0x789C5F52;
            String v6 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v11, v5, v6);
            Object v4_1 = v11.consume(((CompositionLocal)v4));
            ComposerKt.sourceInformationMarkerEnd(v11);
            boolean v4_2 = v4_1 == LayoutDirection.Rtl ? true : false;
            FloatRef v7 = new FloatRef();
            FloatRef v8 = new FloatRef();
            FloatRef v14 = new FloatRef();
            ProvidableCompositionLocal v15 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v11, v5, v6);
            Object v5_1 = v11.consume(((CompositionLocal)v15));
            ComposerKt.sourceInformationMarkerEnd(v11);
            v7.element = ((Density)v5_1).toPx-0680j_4(NavigationDrawerKt.PredictiveBackDrawerMaxScaleXDistanceGrow);
            v8.element = ((Density)v5_1).toPx-0680j_4(NavigationDrawerKt.PredictiveBackDrawerMaxScaleXDistanceShrink);
            v14.element = ((Density)v5_1).toPx-0680j_4(NavigationDrawerKt.PredictiveBackDrawerMaxScaleYDistance);
            boolean v15_1 = v3.isOpen();
            ComposerKt.sourceInformationMarkerStart(v11, 1220265558, v1_2);
            v5 = v11.changed(v4_2) | v11.changed(v7.element) | v11.changed(v8.element) | v11.changed(v14.element) | v11.changedInstance(v2_2);
            int v6_1 = v13 & 14;
            int v16 = v6_1 == v12 ? 1 : 0;
            Object v12_1 = v11.rememberedValue();
            if((v5 | v16) != 0 || v12_1 == Composer.Companion.getEmpty()) {
                String v5_2 = v1_2;
                v1_3 = v0_1;
                v12 = v6_1;
                FloatRef v17 = v14;
                v14_1 = v5_2;
                NavigationDrawerKt$DrawerPredictiveBackHandler$2$1 v0_3 = new NavigationDrawerKt$DrawerPredictiveBackHandler$2$1(((DrawerPredictiveBackState)v1_3), v2_2, v3, v4_2, v7, v8, v17, null);
                v11.updateRememberedValue(v0_3);
            }
            else {
                v14_1 = v1_2;
                v1_3 = v0_1;
                v0_1 = v12_1;
                v12 = v6_1;
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            BackHandler_androidKt.PredictiveBackHandler(v15_1, ((Function2)v0_1), v11, 0, 0);
            Boolean v0_4 = Boolean.valueOf(v3.isClosed());
            ComposerKt.sourceInformationMarkerStart(v11, 1220307240, v14_1);
            int v14_2 = v12 == 4 ? 1 : 0;
            v2_1 = v11.rememberedValue();
            if(v14_2 != 0 || v2_1 == Composer.Companion.getEmpty()) {
                v2_3 = new NavigationDrawerKt$DrawerPredictiveBackHandler$3$1(v3, ((DrawerPredictiveBackState)v1_3), null);
                v11.updateRememberedValue(v2_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            EffectsKt.LaunchedEffect(v0_4, ((Function2)v2_3), v11, 0);
            v9.invoke(v1_3, v11, Integer.valueOf(v13 & 0x70 | 6));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_176;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v11.skipToGroupEnd();
        }

    label_176:
        ScopeUpdateScope v0_5 = v11.endRestartGroup();
        if(v0_5 != null) {
            v0_5.updateScope(new NavigationDrawerKt$$ExternalSyntheticLambda22(v3, v9, v10));
        }
    }

    static final Unit DrawerPredictiveBackHandler$lambda$62(DrawerState arg0, Function3 arg1, int arg2, Composer arg3, int arg4) {
        NavigationDrawerKt.DrawerPredictiveBackHandler(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public static final void DrawerSheet-cm3T3N0(DrawerPredictiveBackState arg28, WindowInsets arg29, Modifier arg30, Shape arg31, long arg32, long arg34, float arg36, FloatProducer arg37, Function3 arg38, Composer arg39, int arg40, int arg41) {
        Modifier v3_1;
        long v7_2;
        long v5_1;
        Shape v4_1;
        FloatProducer v10_4;
        Composer v24;
        Companion v10_3;
        float v9_4;
        FloatProducer v2_3;
        long v16_1;
        float v20_1;
        int v0_2;
        int v2_2;
        int v18;
        int v16;
        long v14_1;
        int v14;
        long v10_1;
        Shape v9;
        int v8;
        Modifier v7;
        int v6;
        WindowInsets v5;
        int v4;
        DrawerPredictiveBackState v1 = arg28;
        FloatProducer v0 = arg37;
        int v12 = arg40;
        int v13 = arg41;
        Composer v3 = arg39.startRestartGroup(0x5D001CEE);
        ComposerKt.sourceInformation(v3, "C(DrawerSheet)N(drawerPredictiveBackState,windowInsets,modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,drawerOffset,content)797@34436L7,800@34593L7,826@35796L867,807@34858L1805:NavigationDrawer.kt#uh7d8r");
        if((v13 & 1) != 0) {
            v4 = v12 | 6;
        }
        else if((v12 & 6) == 0) {
            v4 = v3.changed(v1) ? 4 : 2;
            v4 |= v12;
        }
        else {
            v4 = v12;
        }

        if((v13 & 2) != 0) {
            v4 |= 0x30;
            goto label_37;
        }
        else if((v12 & 0x30) == 0) {
            v5 = arg29;
            v6 = v3.changed(v5) ? 0x20 : 16;
            v4 |= v6;
        }
        else {
        label_37:
            v5 = arg29;
        }

        v6 = v13 & 4;
        if(v6 != 0) {
            v4 |= 0x180;
            goto label_52;
        }
        else if((v12 & 0x180) == 0) {
            v7 = arg30;
            v8 = v3.changed(v7) ? 0x100 : 0x80;
            v4 |= v8;
        }
        else {
        label_52:
            v7 = arg30;
        }

        v8 = v13 & 8;
        if(v8 != 0) {
            v4 |= 0xC00;
            goto label_67;
        }
        else if((v12 & 0xC00) == 0) {
            v9 = arg31;
            int v10 = v3.changed(v9) ? 0x800 : 0x400;
            v4 |= v10;
        }
        else {
        label_67:
            v9 = arg31;
        }

        if((v12 & 0x6000) == 0) {
            if((v13 & 16) == 0) {
                v10_1 = arg32;
                if(v3.changed(v10_1)) {
                    v14 = 0x4000;
                }
                else {
                    goto label_78;
                }
            }
            else {
                v10_1 = arg32;
            label_78:
                v14 = 0x2000;
            }

            v4 |= v14;
        }
        else {
            v10_1 = arg32;
        }

        if((0x30000 & v12) == 0) {
            if((v13 & 0x20) == 0) {
                v14_1 = arg34;
                if(v3.changed(v14_1)) {
                    v16 = 0x20000;
                }
                else {
                    goto label_93;
                }
            }
            else {
                v14_1 = arg34;
            label_93:
                v16 = 0x10000;
            }

            v4 |= v16;
        }
        else {
            v14_1 = arg34;
        }

        v16 = v13 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v4 |= v17;
        }
        else {
            float v2 = arg36;
            if((v12 & v17) == 0) {
                v18 = v3.changed(v2) ? 0x100000 : 0x80000;
                v4 |= v18;
            }
        }

        v18 = 0xC00000;
        if((v12 & v18) == 0) {
            if((v13 & 0x80) == 0) {
                boolean v2_1 = (0x1000000 & v12) == 0 ? v3.changed(v0) : v3.changedInstance(v0);
                if(!v2_1) {
                    goto label_126;
                }

                v2_2 = 0x800000;
            }
            else {
            label_126:
                v2_2 = 0x400000;
            }

            v4 |= v2_2;
        }

        int v19 = 0x6000000;
        if((v13 & 0x100) != 0) {
            v4 |= v19;
        }
        else if((v12 & v19) == 0) {
            v19 = v3.changedInstance(arg38) ? 0x4000000 : 0x2000000;
            v4 |= v19;
        }

        int v39 = v4;
        boolean v0_1 = (v4 & 0x2492493) != 0x2492492 ? true : false;
        if(v3.shouldExecute(v0_1, v39 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "791@34129L22,792@34185L37,794@34330L20");
            int v20 = 0xFFF8FFFF;
            int v21 = 0xFFFF1FFF;
            int v22 = 0xFE3FFFFF;
            v2_2 = 6;
            if((v12 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v6 != 0) {
                    Companion v7_1 = Modifier.Companion;
                }

                if(v8 != 0) {
                    v9 = RectangleShapeKt.getRectangleShape();
                }

                if((v13 & 16) != 0) {
                    v10_1 = DrawerDefaults.INSTANCE.getStandardContainerColor(v3, v2_2);
                    v0_2 = v39 & v21;
                }
                else {
                    v0_2 = v39;
                }

                if((v13 & 0x20) != 0) {
                    v14_1 = ColorSchemeKt.contentColorFor-ek8zF_U(v10_1, v3, v0_2 >> 12 & 14);
                    v0_2 &= v20;
                }

                float v6_1 = v16 != 0 ? DrawerDefaults.INSTANCE.getPermanentDrawerElevation-D9Ej5fM() : arg36;
                if((v13 & 0x80) != 0) {
                    ComposerKt.sourceInformationMarkerStart(v3, 493671010, "CC(remember):NavigationDrawer.kt#9igjgp");
                    Object v2_4 = v3.rememberedValue();
                    if(v2_4 == Composer.Companion.getEmpty()) {
                        NavigationDrawerKt$$ExternalSyntheticLambda8 v2_5 = new NavigationDrawerKt$$ExternalSyntheticLambda8();
                        v3.updateRememberedValue(v2_5);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v3);
                    v0_2 &= v22;
                }
                else {
                    v2_3 = arg37;
                }

                v20_1 = v6_1;
                v16_1 = v10_1;
                v8 = v18;
            }
            else {
                v3.skipToGroupEnd();
                v0_2 = (v13 & 16) != 0 ? v39 & v21 : v39;
                if((v13 & 0x20) != 0) {
                    v0_2 &= v20;
                }

                if((v13 & 0x80) != 0) {
                    v0_2 &= v22;
                }

                v20_1 = arg36;
                v16_1 = v10_1;
                v8 = v18;
                v2_3 = arg37;
            }

            long v18_1 = v14_1;
            Shape v15 = v9;
            int v9_1 = 0x5D001CEE;
            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v9_1, v0_2, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:796)");
            }

            ProvidableCompositionLocal v9_2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v9_3 = v3.consume(((CompositionLocal)v9_2));
            ComposerKt.sourceInformationMarkerEnd(v3);
            float v14_2 = NavigationDrawerTokens.INSTANCE.getContainerWidth-D9Ej5fM();
            v9_4 = ((Density)v9_3).toPx-0680j_4(v14_2);
            ProvidableCompositionLocal v6_2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v6_3 = v3.consume(((CompositionLocal)v6_2));
            ComposerKt.sourceInformationMarkerEnd(v3);
            boolean v6_4 = v6_3 == LayoutDirection.Rtl ? true : false;
            if(v1 != null) {
                Modifier v10_2 = NavigationDrawerKt.predictiveBackDrawerContainer(Modifier.Companion, v1, v6_4);
            }
            else {
                v10_3 = Modifier.Companion;
            }

            Modifier v27 = v7;
            v0_2 >>= 6;
            v24 = v3;
            SurfaceKt.Surface-T9BRK9s(SizeKt.fillMaxHeight$default(NavigationDrawerKt.horizontalScaleUp(SizeKt.sizeIn-qDBjuR0$default(v7, NavigationDrawerKt.MinimumDrawerWidth, 0f, v14_2, 0f, 10, null), v2_3, v9_4, v6_4).then(((Modifier)v10_3)), 0f, 1, null), v15, v16_1, v18_1, v20_1, 0f, null, ComposableLambdaKt.rememberComposableLambda(-315420087, true, new NavigationDrawerKt$DrawerSheet$2(v1, v6_4, v14_2, v2_3, v9_4, v5, arg38), v3, 54), v24, v0_2 & 0x70 | v8 | v0_2 & 0x380 | v0_2 & 0x1C00 | v0_2 & 0xE000, 0x60);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v10_4 = v2_3;
            v4_1 = v15;
            v5_1 = v16_1;
            v7_2 = v18_1;
            v9_4 = v20_1;
            v3_1 = v27;
        }
        else {
            v24 = v3;
            v24.skipToGroupEnd();
            v3_1 = v7;
            v4_1 = v9;
            v5_1 = v10_1;
            v7_2 = v14_1;
            v9_4 = arg36;
            v10_4 = arg37;
        }

        ScopeUpdateScope v14_3 = v24.endRestartGroup();
        if(v14_3 != null) {
            v14_3.updateScope(new NavigationDrawerKt$$ExternalSyntheticLambda9(arg28, arg29, v3_1, v4_1, v5_1, v7_2, v9_4, v10_4, arg38, v12, v13));
        }
    }

    static final float DrawerSheet_cm3T3N0$lambda$51$lambda$50() {
        return 0;
    }

    static final Unit DrawerSheet_cm3T3N0$lambda$53(DrawerPredictiveBackState arg15, WindowInsets arg16, Modifier arg17, Shape arg18, long arg19, long arg21, float arg23, FloatProducer arg24, Function3 arg25, int arg26, int arg27, Composer arg28, int arg29) {
        NavigationDrawerKt.DrawerSheet-cm3T3N0(arg15, arg16, arg17, arg18, arg19, arg21, arg23, arg24, arg25, arg28, RecomposeScopeImplKt.updateChangedFlags(arg26 | 1), arg27);
        return Unit.INSTANCE;
    }

    public static final void ModalDrawerSheet-Snr_uVM(DrawerState arg18, Modifier arg19, Shape arg20, long arg21, long arg23, float arg25, WindowInsets arg26, Function3 arg27, Composer arg28, int arg29, int arg30) {
        WindowInsets v9_1;
        WindowInsets v1_1;
        float v8;
        long v6;
        long v4_2;
        Shape v3_2;
        Modifier v2_1;
        Companion v3_1;
        int v16;
        WindowInsets v15_1;
        float v14_1;
        int v10;
        long v7_1;
        int v7;
        long v5_1;
        int v5;
        Shape v4_1;
        Modifier v3;
        int v1;
        DrawerState v9 = arg18;
        int v11 = arg29;
        int v12 = arg30;
        Composer v13 = arg28.startRestartGroup(-1620540727);
        ComposerKt.sourceInformation(v13, "C(ModalDrawerSheet)N(drawerState,modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)642@27084L519,642@27043L560:NavigationDrawer.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v1 = v11 | 6;
        }
        else if((v11 & 6) == 0) {
            v1 = v13.changed(v9) ? 4 : 2;
            v1 |= v11;
        }
        else {
            v1 = v11;
        }

        int v2 = v12 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
            goto label_36;
        }
        else if((v11 & 0x30) == 0) {
            v3 = arg19;
            int v4 = v13.changed(v3) ? 0x20 : 16;
            v1 |= v4;
        }
        else {
        label_36:
            v3 = arg19;
        }

        if((v11 & 0x180) == 0) {
            if((v12 & 4) == 0) {
                v4_1 = arg20;
                if(v13.changed(v4_1)) {
                    v5 = 0x100;
                }
                else {
                    goto label_47;
                }
            }
            else {
                v4_1 = arg20;
            label_47:
                v5 = 0x80;
            }

            v1 |= v5;
        }
        else {
            v4_1 = arg20;
        }

        if((v11 & 0xC00) == 0) {
            if((v12 & 8) == 0) {
                v5_1 = arg21;
                if(v13.changed(v5_1)) {
                    v7 = 0x800;
                }
                else {
                    goto label_61;
                }
            }
            else {
                v5_1 = arg21;
            label_61:
                v7 = 0x400;
            }

            v1 |= v7;
        }
        else {
            v5_1 = arg21;
        }

        if((v11 & 0x6000) == 0) {
            if((v12 & 16) == 0) {
                v7_1 = arg23;
                if(v13.changed(v7_1)) {
                    v10 = 0x4000;
                }
                else {
                    goto label_75;
                }
            }
            else {
                v7_1 = arg23;
            label_75:
                v10 = 0x2000;
            }

            v1 |= v10;
        }
        else {
            v7_1 = arg23;
        }

        v10 = v12 & 0x20;
        int v14 = 0x30000;
        if(v10 != 0) {
            v1 |= v14;
            goto label_94;
        }
        else if((v14 & v11) == 0) {
            v14_1 = arg25;
            int v15 = v13.changed(v14_1) ? 0x20000 : 0x10000;
            v1 |= v15;
        }
        else {
        label_94:
            v14_1 = arg25;
        }

        if((0x180000 & v11) == 0) {
            if((v12 & 0x40) == 0) {
                v15_1 = arg26;
                if(v13.changed(v15_1)) {
                    v16 = 0x100000;
                }
                else {
                    goto label_106;
                }
            }
            else {
                v15_1 = arg26;
            label_106:
                v16 = 0x80000;
            }

            v1 |= v16;
        }
        else {
            v15_1 = arg26;
        }

        int v17 = 0xC00000;
        if((v12 & 0x80) != 0) {
            v1 |= v17;
        }
        else if((v11 & v17) == 0) {
            v17 = v13.changedInstance(arg27) ? 0x800000 : 0x400000;
            v1 |= v17;
        }

        int v28 = v2;
        boolean v0 = (v1 & 0x492493) != 4793490 ? true : false;
        if(v13.shouldExecute(v0, v1 & 1)) {
            v13.startDefaults();
            ComposerKt.sourceInformation(v13, "635@26708L5,636@26764L19,637@26817L37,639@26972L12");
            v2 = 0xFFC7FFFF;
            v17 = 0xFFFF1FFF;
            if((arg29 & 1) == 0 || (v13.getDefaultsInvalid())) {
                if(v28 != 0) {
                    v3_1 = Modifier.Companion;
                }

                v28 = v2;
                v2 = 6;
                if((v12 & 4) != 0) {
                    v1 &= -897;
                    v4_1 = DrawerDefaults.INSTANCE.getShape(v13, v2);
                }

                if((v12 & 8) != 0) {
                    v5_1 = DrawerDefaults.INSTANCE.getModalContainerColor(v13, v2);
                    v1 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v7_1 = ColorSchemeKt.contentColorFor-ek8zF_U(v5_1, v13, v1 >> 9 & 14);
                    v1 &= v17;
                }

                if(v10 != 0) {
                    v14_1 = DrawerDefaults.INSTANCE.getModalDrawerElevation-D9Ej5fM();
                }

                if((v12 & 0x40) != 0) {
                    WindowInsets v0_1 = DrawerDefaults.INSTANCE.getWindowInsets(v13, v2);
                    v2_1 = ((Modifier)v3_1);
                    v3_2 = v4_1;
                    v4_2 = v5_1;
                    v6 = v7_1;
                    v8 = v14_1;
                    v14 = v1 & v28;
                    v1_1 = v0_1;
                    goto label_208;
                }

            label_161:
                v2_1 = ((Modifier)v3_1);
                v3_2 = v4_1;
                v4_2 = v5_1;
                v6 = v7_1;
                v8 = v14_1;
                v14 = v1;
                v1_1 = v15_1;
            }
            else {
                v13.skipToGroupEnd();
                if((v12 & 4) != 0) {
                    v1 &= -897;
                }

                if((v12 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v1 &= v17;
                }

                if((v12 & 0x40) == 0) {
                    goto label_161;
                }

                v1 &= v2;
                goto label_161;
            }

        label_208:
            v13.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1620540727, v14, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:641)");
            }

            NavigationDrawerKt.DrawerPredictiveBackHandler(v9, ComposableLambdaKt.rememberComposableLambda(0x2F841CFE, true, new NavigationDrawerKt$ModalDrawerSheet$2(v1_1, v2_1, v3_2, v4_2, v6, v8, v9, arg27), v13, 54), v13, v14 & 14 | 0x30);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v9_1 = v1_1;
        }
        else {
            v13.skipToGroupEnd();
            v2_1 = v3;
            v3_2 = v4_1;
            v4_2 = v5_1;
            v6 = v7_1;
            v8 = v14_1;
            v9_1 = v15_1;
        }

        ScopeUpdateScope v13_1 = v13.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new NavigationDrawerKt$$ExternalSyntheticLambda10(arg18, v2_1, v3_2, v4_2, v6, v8, v9_1, arg27, arg29, v12));
        }
    }

    public static final void ModalDrawerSheet-afqeVBk(Modifier arg25, Shape arg26, long arg27, long arg29, float arg31, WindowInsets arg32, Function3 arg33, Composer arg34, int arg35, int arg36) {
        float v7;
        long v5_1;
        long v3_1;
        Shape v2_2;
        Modifier v1_1;
        WindowInsets v8_2;
        Composer v22;
        int v0_1;
        WindowInsets v12_1;
        float v19;
        long v17;
        Shape v14_1;
        long v15_1;
        Companion v13_3;
        Companion v0_2;
        int v14;
        WindowInsets v13_1;
        float v12;
        int v11;
        long v8_1;
        int v8;
        long v6_1;
        int v6;
        Shape v5;
        Modifier v3;
        int v4;
        int v10 = arg35;
        Composer v1 = arg34.startRestartGroup(0x72990EF5);
        ComposerKt.sourceInformation(v1, "C(ModalDrawerSheet)N(modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)598@24971L343:NavigationDrawer.kt#uh7d8r");
        int v2 = arg36 & 1;
        if(v2 != 0) {
            v4 = v10 | 6;
            v3 = arg25;
        }
        else if((v10 & 6) == 0) {
            v3 = arg25;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v10;
        }
        else {
            v3 = arg25;
            v4 = v10;
        }

        if((v10 & 0x30) == 0) {
            if((arg36 & 2) == 0) {
                v5 = arg26;
                if(v1.changed(v5)) {
                    v6 = 0x20;
                }
                else {
                    goto label_34;
                }
            }
            else {
                v5 = arg26;
            label_34:
                v6 = 16;
            }

            v4 |= v6;
        }
        else {
            v5 = arg26;
        }

        if((v10 & 0x180) == 0) {
            if((arg36 & 4) == 0) {
                v6_1 = arg27;
                if(v1.changed(v6_1)) {
                    v8 = 0x100;
                }
                else {
                    goto label_48;
                }
            }
            else {
                v6_1 = arg27;
            label_48:
                v8 = 0x80;
            }

            v4 |= v8;
        }
        else {
            v6_1 = arg27;
        }

        if((v10 & 0xC00) == 0) {
            if((arg36 & 8) == 0) {
                v8_1 = arg29;
                if(v1.changed(v8_1)) {
                    v11 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v8_1 = arg29;
            label_62:
                v11 = 0x400;
            }

            v4 |= v11;
        }
        else {
            v8_1 = arg29;
        }

        v11 = arg36 & 16;
        if(v11 != 0) {
            v4 |= 0x6000;
            goto label_80;
        }
        else if((v10 & 0x6000) == 0) {
            v12 = arg31;
            int v13 = v1.changed(v12) ? 0x4000 : 0x2000;
            v4 |= v13;
        }
        else {
        label_80:
            v12 = arg31;
        }

        if((0x30000 & v10) == 0) {
            if((arg36 & 0x20) == 0) {
                v13_1 = arg32;
                if(v1.changed(v13_1)) {
                    v14 = 0x20000;
                }
                else {
                    goto label_92;
                }
            }
            else {
                v13_1 = arg32;
            label_92:
                v14 = 0x10000;
            }

            v4 |= v14;
        }
        else {
            v13_1 = arg32;
        }

        int v15 = 0x180000;
        if((arg36 & 0x40) != 0) {
            v4 |= v15;
        }
        else if((v10 & v15) == 0) {
            v15 = v1.changedInstance(arg33) ? 0x100000 : 0x80000;
            v4 |= v15;
        }

        boolean v0 = (0x92493 & v4) != 0x92492 ? true : false;
        if(v1.shouldExecute(v0, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "591@24636L5,592@24692L19,593@24745L37,595@24900L12");
            int v34 = 0xFFF8FFFF;
            v15 = 6;
            if((v10 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v2 != 0) {
                    v0_2 = Modifier.Companion;
                }
                else {
                    Modifier v0_3 = v3;
                }

                if((arg36 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                    v5 = DrawerDefaults.INSTANCE.getShape(v1, v15);
                }

                if((arg36 & 4) != 0) {
                    v4 &= -897;
                    v6_1 = DrawerDefaults.INSTANCE.getModalContainerColor(v1, v15);
                }

                if((arg36 & 8) != 0) {
                    long v2_1 = ColorSchemeKt.contentColorFor-ek8zF_U(v6_1, v1, v4 >> 6 & 14);
                    v4 &= 0xFFFFE3FF;
                    v8_1 = v2_1;
                }

                if(v11 != 0) {
                    v12 = DrawerDefaults.INSTANCE.getModalDrawerElevation-D9Ej5fM();
                }

                if((arg36 & 0x20) != 0) {
                    v4 &= v34;
                    v13_3 = v0_2;
                    v14_1 = v5;
                    v17 = v8_1;
                    v19 = v12;
                    v0_1 = v15;
                    v12_1 = DrawerDefaults.INSTANCE.getWindowInsets(v1, v15);
                    v15_1 = v6_1;
                    v2 = 0x72990EF5;
                    goto label_203;
                }

                v14_1 = v5;
                v17 = v8_1;
                v19 = v12;
                v12_1 = v13_1;
                v2 = 0x72990EF5;
                v13_3 = v0_2;
                v0_1 = v15;
            label_152:
                v15_1 = v6_1;
            }
            else {
                v1.skipToGroupEnd();
                if((arg36 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }

                if((arg36 & 4) != 0) {
                    v4 &= -897;
                }

                if((arg36 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                if((arg36 & 0x20) != 0) {
                    v4 &= v34;
                }

                v14_1 = v5;
                v17 = v8_1;
                v19 = v12;
                v12_1 = v13_1;
                v0_1 = v15;
                v2 = 0x72990EF5;
                Modifier v13_2 = v3;
                goto label_152;
            }

        label_203:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v4, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:597)");
            }

            v2 = v4 >> 12 & 0x70 | v0_1;
            v0_1 = v4 << 6;
            v22 = v1;
            NavigationDrawerKt.DrawerSheet-cm3T3N0(null, v12_1, ((Modifier)v13_3), v14_1, v15_1, v17, v19, null, arg33, v22, v2 | v0_1 & 0x380 | v0_1 & 0x1C00 | 0xE000 & v0_1 | 0x70000 & v0_1 | 0x380000 & v0_1 | v0_1 & 0xE000000, 0x80);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8_2 = v12_1;
            v1_1 = ((Modifier)v13_3);
            v2_2 = v14_1;
            v3_1 = v15_1;
            v5_1 = v17;
            v7 = v19;
        }
        else {
            v22 = v1;
            v22.skipToGroupEnd();
            v1_1 = v3;
            v2_2 = v5;
            v3_1 = v6_1;
            v5_1 = v8_1;
            v7 = v12;
            v8_2 = v13_1;
        }

        ScopeUpdateScope v12_2 = v22.endRestartGroup();
        if(v12_2 != null) {
            v12_2.updateScope(new NavigationDrawerKt$$ExternalSyntheticLambda16(v1_1, v2_2, v3_1, v5_1, v7, v8_2, arg33, v10, arg36));
        }
    }

    static final Unit ModalDrawerSheet_Snr_uVM$lambda$44(DrawerState arg14, Modifier arg15, Shape arg16, long arg17, long arg19, float arg21, WindowInsets arg22, Function3 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        NavigationDrawerKt.ModalDrawerSheet-Snr_uVM(arg14, arg15, arg16, arg17, arg19, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit ModalDrawerSheet_afqeVBk$lambda$43(Modifier arg13, Shape arg14, long arg15, long arg17, float arg19, WindowInsets arg20, Function3 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        NavigationDrawerKt.ModalDrawerSheet-afqeVBk(arg13, arg14, arg15, arg17, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    public static final void ModalNavigationDrawer-FHprtrg(Function2 arg29, Modifier arg30, DrawerState arg31, boolean arg32, long arg33, Function2 arg35, Composer arg36, int arg37, int arg38) {
        boolean v4_5;
        Modifier v2_1;
        long v5_7;
        DrawerState v3_7;
        NavigationDrawerKt$$ExternalSyntheticLambda6 v11_6;
        NavigationDrawerKt$$ExternalSyntheticLambda5 v11_4;
        NavigationDrawerKt$$ExternalSyntheticLambda4 v15_6;
        NavigationDrawerKt$$ExternalSyntheticLambda3 v8_5;
        NavigationDrawerKt$$ExternalSyntheticLambda2 v8_2;
        DrawerState v19;
        MutableFloatState v15_3;
        MutableState v9_2;
        boolean v30;
        boolean v5_1;
        long v12;
        Modifier v4_1;
        Companion v4_2;
        long v11;
        int v13;
        int v10;
        DrawerState v6_1;
        int v6;
        Modifier v5;
        int v2;
        Function2 v1 = arg29;
        Function2 v7 = arg35;
        int v8 = arg37;
        int v0 = -1907430816;
        Composer v14 = arg36.startRestartGroup(v0);
        ComposerKt.sourceInformation(v14, "C(ModalNavigationDrawer)N(drawerContent,modifier,drawerState,gesturesEnabled,scrimColor:c#ui.graphics.Color,content)339@13901L24,340@13951L33,341@14016L7,342@14054L34,343@14109L45,348@14357L7,349@14451L7,350@14543L7,352@14567L229,352@14556L240,359@14835L7,360@14870L3155:NavigationDrawer.kt#uh7d8r");
        int v3 = 2;
        if((arg38 & 1) != 0) {
            v2 = v8 | 6;
        }
        else if((v8 & 6) == 0) {
            v2 = v14.changedInstance(v1) ? 4 : v3;
            v2 |= v8;
        }
        else {
            v2 = v8;
        }

        int v4 = arg38 & 2;
        if(v4 != 0) {
            v2 |= 0x30;
            goto label_37;
        }
        else if((v8 & 0x30) == 0) {
            v5 = arg30;
            v6 = v14.changed(v5) ? 0x20 : 16;
            v2 |= v6;
        }
        else {
        label_37:
            v5 = arg30;
        }

        if((v8 & 0x180) == 0) {
            if((arg38 & 4) == 0) {
                v6_1 = arg31;
                if(v14.changed(v6_1)) {
                    v10 = 0x100;
                }
                else {
                    goto label_48;
                }
            }
            else {
                v6_1 = arg31;
            label_48:
                v10 = 0x80;
            }

            v2 |= v10;
        }
        else {
            v6_1 = arg31;
        }

        v10 = arg38 & 8;
        if(v10 != 0) {
            v2 |= 0xC00;
        }
        else if((v8 & 0xC00) == 0) {
            v13 = v14.changed(arg32) ? 0x800 : 0x400;
            v2 |= v13;
        }

        if((v8 & 0x6000) == 0) {
            v11 = arg33;
            v13 = (arg38 & 16) != 0 || !v14.changed(v11) ? 0x2000 : 0x4000;
            v2 |= v13;
        }
        else {
            v11 = arg33;
        }

        int v15 = 0x30000;
        if((arg38 & 0x20) != 0) {
            v2 |= v15;
        }
        else if((v8 & v15) == 0) {
            v13 = v14.changedInstance(v7) ? 0x20000 : 0x10000;
            v2 |= v13;
        }

        boolean v13_1 = (74899 & v2) != 74898 ? true : false;
        if(v14.shouldExecute(v13_1, v2 & 1)) {
            v14.startDefaults();
            ComposerKt.sourceInformation(v14, "334@13715L39,336@13832L10");
            Function1 v15_1 = null;
            int v9 = 6;
            if((v8 & 1) == 0 || (v14.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v4_2 = Modifier.Companion;
                }
                else {
                    v4_1 = v5;
                }

                if((arg38 & 4) != 0) {
                    v2 &= -897;
                    v6_1 = NavigationDrawerKt.rememberDrawerState(DrawerValue.Closed, v15_1, v14, v9, v3);
                }

                v5_1 = v10 != 0 ? true : arg32;
                if((arg38 & 16) != 0) {
                    v2 &= 0xFFFF1FFF;
                    v12 = DrawerDefaults.INSTANCE.getScrimColor(v14, v9);
                    goto label_148;
                }

                v12 = v11;
            }
            else {
                v14.skipToGroupEnd();
                if((arg38 & 4) != 0) {
                    v2 &= -897;
                }

                if((arg38 & 16) != 0) {
                    v2 &= 0xFFFF1FFF;
                }

                v4_1 = v5;
                v12 = v11;
                v5_1 = arg32;
            }

        label_148:
            v14.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:338)");
            }

            ComposerKt.sourceInformationMarkerStart(v14, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v14, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
            Object v0_1 = v14.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                CoroutineScope v0_2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v14);
                v14.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            String v10_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.navigation_menu), v14, 0);
            ProvidableCompositionLocal v11_1 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v14, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v3_1 = v14.consume(((CompositionLocal)v11_1));
            ComposerKt.sourceInformationMarkerEnd(v14);
            String v11_2 = "CC(remember):NavigationDrawer.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v14, 0x363E0F62, v11_2);
            Object v9_1 = v14.rememberedValue();
            if(v9_1 == Composer.Companion.getEmpty()) {
                v30 = v5_1;
                v9_2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
                v14.updateRememberedValue(v9_2);
            }
            else {
                v30 = v5_1;
            }

            Object v5_2 = v9_2;
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerStart(v14, 910038605, v11_2);
            boolean v9_3 = v14.changed(v3_1);
            Object v15_2 = v14.rememberedValue();
            if((v9_3) || v15_2 == Composer.Companion.getEmpty()) {
                v15_3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
                v14.updateRememberedValue(v15_3);
            }

            v9_1 = v15_3;
            ComposerKt.sourceInformationMarkerEnd(v14);
            FiniteAnimationSpec v15_4 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, v14, 6);
            String v32 = v10_1;
            FiniteAnimationSpec v10_2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, v14, 6);
            arg33 = v12;
            FiniteAnimationSpec v12_1 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, v14, 6);
            ComposerKt.sourceInformationMarkerStart(v14, 910053445, v11_2);
            v13 = v2 & 0x380 ^ 0x180;
            v8 = 0x100;
            if(v13 <= v8 || !v14.changed(v6_1)) {
                v19 = v6_1;
                if((v2 & 0x180) == v8) {
                label_234:
                    v6 = 1;
                }
                else {
                    v6 = 0;
                }
            }
            else {
                v19 = v6_1;
                goto label_234;
            }

            v6 = v6 | v14.changed(v3_1) | v14.changedInstance(v10_2) | v14.changedInstance(v12_1) | v14.changedInstance(v15_4);
            Object v8_1 = v14.rememberedValue();
            if(v6 != 0 || v8_1 == Composer.Companion.getEmpty()) {
                v8_2 = new NavigationDrawerKt$$ExternalSyntheticLambda2(v19, v3_1, v10_2, v12_1, v15_4);
                v6_1 = v19;
                v14.updateRememberedValue(v8_2);
            }
            else {
                v6_1 = v19;
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            EffectsKt.SideEffect(((Function0)v8_2), v14, 0);
            ProvidableCompositionLocal v3_2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v14, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v3_1 = v14.consume(((CompositionLocal)v3_2));
            ComposerKt.sourceInformationMarkerEnd(v14);
            boolean v20 = v3_1 == LayoutDirection.Rtl ? true : false;
            Modifier v8_3 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(((Modifier)v4_2), 0f, 1, null), v6_1.getAnchoredDraggableState$material3(), v20, Orientation.Horizontal, v30, null, null, null, 0x70, null);
            boolean v12_2 = v30;
            ComposerKt.sourceInformationMarkerStart(v14, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v3_3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            Modifier v18 = ((Modifier)v4_2);
            String v4_3 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v14, -1323940314, v4_3);
            int v19_1 = ComposablesKt.getCurrentCompositeKeyHash(v14, 0);
            CompositionLocalMap v10_3 = v14.getCurrentCompositionLocalMap();
            v8_3 = ComposedModifierKt.materializeModifier(v14, v8_3);
            Function0 v15_5 = ComposeUiNode.Companion.getConstructor();
            Object v20_1 = v5_2;
            String v5_3 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v14, 0xD6BD0031, v5_3);
            if(!(v14.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v14.startReusableNode();
            if(v14.getInserting()) {
                v14.createNode(v15_5);
            }
            else {
                v14.useNode();
            }

            Composer v1_1 = Updater.constructor-impl(v14);
            Updater.set-impl(v1_1, v3_3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v1_1, v10_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v3_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v1_1.getInserting()) || !Intrinsics.areEqual(v1_1.rememberedValue(), Integer.valueOf(v19_1))) {
                v1_1.updateRememberedValue(Integer.valueOf(v19_1));
                v1_1.apply(Integer.valueOf(v19_1), v3_4);
            }

            Updater.set-impl(v1_1, v8_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v14, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v14, 101870438, "C370@15180L17,373@15274L183,378@15482L70,371@15206L389,384@15704L601,396@16337L452,407@16801L1218,381@15604L2415:NavigationDrawer.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(v14, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Companion v1_2 = Modifier.Companion;
            v3_3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v14, -1323940314, v4_3);
            v15 = ComposablesKt.getCurrentCompositeKeyHash(v14, 0);
            CompositionLocalMap v8_4 = v14.getCurrentCompositionLocalMap();
            Modifier v1_3 = ComposedModifierKt.materializeModifier(v14, ((Modifier)v1_2));
            Function0 v10_4 = ComposeUiNode.Companion.getConstructor();
            int v17 = v15;
            ComposerKt.sourceInformationMarkerStart(v14, 0xD6BD0031, v5_3);
            if(!(v14.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v14.startReusableNode();
            if(v14.getInserting()) {
                v14.createNode(v10_4);
            }
            else {
                v14.useNode();
            }

            Composer v10_5 = Updater.constructor-impl(v14);
            Updater.set-impl(v10_5, v3_3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v10_5, v8_4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            v3_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v10_5.getInserting()) || !Intrinsics.areEqual(v10_5.rememberedValue(), Integer.valueOf(v17))) {
                v10_5.updateRememberedValue(Integer.valueOf(v17));
                v10_5.apply(Integer.valueOf(v17), v3_4);
            }

            Updater.set-impl(v10_5, v1_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v14, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v14, 0x1480D36E, "C370@15186L9:NavigationDrawer.kt#uh7d8r");
            v7.invoke(v14, Integer.valueOf(v2 >> 15 & 14));
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            v14.endNode();
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            boolean v1_4 = v6_1.isOpen();
            ComposerKt.sourceInformationMarkerStart(v14, 2081496477, v11_2);
            v3 = (v2 & 0x1C00) == 0x800 ? 1 : 0;
            v8 = 0x100;
            v8 = v13 > v8 && (v14.changed(v6_1)) || (v2 & 0x180) == v8 ? 1 : 0;
            v3 = v3 | v8 | v14.changedInstance(v0_1);
            v8_1 = v14.rememberedValue();
            if(v3 != 0 || v8_1 == Composer.Companion.getEmpty()) {
                v8_5 = new NavigationDrawerKt$$ExternalSyntheticLambda3(v12_2, v6_1, ((CoroutineScope)v0_1));
                v14.updateRememberedValue(v8_5);
            }

            Object v10_6 = v8_5;
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerStart(v14, 2081503020, v11_2);
            boolean v3_5 = v14.changed(v9_1);
            v8 = 0x100;
            v15 = v13 > v8 && (v14.changed(v6_1)) || (v2 & 0x180) == v8 ? 1 : 0;
            v3 = (((int)v3_5)) | v15;
            v15_2 = v14.rememberedValue();
            if(v3 != 0 || v15_2 == Composer.Companion.getEmpty()) {
                v15_6 = new NavigationDrawerKt$$ExternalSyntheticLambda4(0f, v6_1, ((MutableFloatState)v9_1));
                v14.updateRememberedValue(v15_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            boolean v7_1 = v1_4;
            String v1_5 = v32;
            v32 = v5_3;
            int v5_4 = v8;
            v8_1 = v9_1;
            v9_3 = v7_1;
            String v7_2 = v11_2;
            boolean v22 = v12_2;
            v3 = v13;
            v12 = arg33;
            NavigationDrawerKt.Scrim-Bx497Mc(v9_3, ((Function0)v10_6), v15_6, v12, v14, v2 >> 3 & 0x1C00);
            Companion v9_4 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v14, 0x7C1154FF, v7_2);
            v10 = v3 > v5_4 && (v14.changed(v6_1)) || (v2 & 0x180) == v5_4 ? 1 : 0;
            Object v11_3 = v14.rememberedValue();
            if(v10 != 0 || v11_3 == Composer.Companion.getEmpty()) {
                v11_4 = new NavigationDrawerKt$$ExternalSyntheticLambda5(v6_1);
                v14.updateRememberedValue(v11_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            Modifier v9_5 = OffsetKt.offset(((Modifier)v9_4), ((Function1)v11_4));
            ComposerKt.sourceInformationMarkerStart(v14, 2081530762, v7_2);
            boolean v10_7 = v14.changed(v1_5);
            int v11_5 = v3 > v5_4 && (v14.changed(v6_1)) || (v2 & 0x180) == v5_4 ? 1 : 0;
            v10 = (((int)v10_7)) | v11_5 | v14.changedInstance(v0_1);
            v11_3 = v14.rememberedValue();
            if(v10 != 0 || v11_3 == Composer.Companion.getEmpty()) {
                v11_6 = new NavigationDrawerKt$$ExternalSyntheticLambda6(v1_5, v6_1, ((CoroutineScope)v0_1));
                v14.updateRememberedValue(v11_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            v1_3 = SemanticsModifierKt.semantics$default(v9_5, false, ((Function1)v11_6), 1, null);
            ComposerKt.sourceInformationMarkerStart(v14, 0x7C11E088, v7_2);
            v9 = v3 > v5_4 && (v14.changed(v6_1)) || (v2 & 0x180) == v5_4 ? 1 : 0;
            v0 = v14.changed(v8_1) | v9;
            v3_1 = v14.rememberedValue();
            if(v0 != 0 || v3_1 == Composer.Companion.getEmpty()) {
                NavigationDrawerKt$ModalNavigationDrawer$2$6$1 v3_6 = new NavigationDrawerKt$ModalNavigationDrawer$2$6$1(v6_1, v20_1, ((MutableFloatState)v8_1), 0f);
                v14.updateRememberedValue(v3_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            v0 = v2 & 14;
            ComposerKt.sourceInformationMarkerStart(v14, -1323940314, v4_3);
            v2 = ComposablesKt.getCurrentCompositeKeyHash(v14, 0);
            CompositionLocalMap v4_4 = v14.getCurrentCompositionLocalMap();
            v1_3 = ComposedModifierKt.materializeModifier(v14, v1_3);
            Function0 v5_5 = ComposeUiNode.Companion.getConstructor();
            v0 = v0 << 6 & 0x380 | 6;
            ComposerKt.sourceInformationMarkerStart(v14, 0xD6BD0031, v32);
            if(!(v14.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v14.startReusableNode();
            if(v14.getInserting()) {
                v14.createNode(v5_5);
            }
            else {
                v14.useNode();
            }

            Composer v5_6 = Updater.constructor-impl(v14);
            Updater.set-impl(v5_6, v3_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_6, v4_4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            v3_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v5_6.getInserting()) || !Intrinsics.areEqual(v5_6.rememberedValue(), Integer.valueOf(v2))) {
                v5_6.updateRememberedValue(Integer.valueOf(v2));
                v5_6.apply(Integer.valueOf(v2), v3_4);
            }

            Updater.set-impl(v5_6, v1_3, ComposeUiNode.Companion.getSetModifier());
            v1 = arg29;
            v1.invoke(v14, Integer.valueOf(v0 >> 6 & 14));
            v14.endNode();
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            v14.endNode();
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_7 = v6_1;
            v5_7 = v12;
            v2_1 = v18;
            v4_5 = v22;
        }
        else {
            v14.skipToGroupEnd();
            v4_5 = arg32;
            v2_1 = v5;
            v3_7 = v6_1;
            v5_7 = v11;
        }

        ScopeUpdateScope v10_8 = v14.endRestartGroup();
        if(v10_8 != null) {
            v10_8.updateScope(new NavigationDrawerKt$$ExternalSyntheticLambda7(v1, v2_1, v3_7, v4_5, v5_7, arg35, arg37, arg38));
        }
    }

    static final Unit ModalNavigationDrawer_FHprtrg$lambda$11$lambda$10(DrawerState arg0, Density arg1, FiniteAnimationSpec arg2, FiniteAnimationSpec arg3, FiniteAnimationSpec arg4) {
        arg0.setDensity$material3(arg1);
        arg0.setOpenDrawerMotionSpec$material3(arg2);
        arg0.setCloseDrawerMotionSpec$material3(arg3);
        arg0.setAnchoredDraggableMotionSpec$material3(arg4);
        return Unit.INSTANCE;
    }

    static final Unit ModalNavigationDrawer_FHprtrg$lambda$24$lambda$14$lambda$13(boolean arg7, DrawerState arg8, CoroutineScope arg9) {
        if((arg7) && (arg8.getConfirmStateChange$material3().invoke(DrawerValue.Closed).booleanValue())) {
            BuildersKt.launch$default(arg9, null, null, new NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1(arg8, null), 3, null);
        }

        return Unit.INSTANCE;
    }

    static final float ModalNavigationDrawer_FHprtrg$lambda$24$lambda$16$lambda$15(float arg0, DrawerState arg1, MutableFloatState arg2) {
        return NavigationDrawerKt.calculateFraction(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$8(arg2), arg0, arg1.requireOffset$material3());
    }

    static final IntOffset ModalNavigationDrawer_FHprtrg$lambda$24$lambda$19$lambda$18(DrawerState arg2, Density arg3) {
        int v2;
        float v0 = arg2.getCurrentOffset();
        if(!Float.isNaN(v0)) {
            v2 = MathKt.roundToInt(v0);
        }
        else if(arg2.isOpen()) {
            v2 = 0;
        }
        else {
            v2 = -arg3.roundToPx-0680j_4(DrawerDefaults.INSTANCE.getMaximumDrawerWidth-D9Ej5fM());
        }

        return IntOffset.box-impl(IntOffset.constructor-impl((((long)v2)) << 0x20));
    }

    static final Unit ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21(String arg0, DrawerState arg1, CoroutineScope arg2, SemanticsPropertyReceiver arg3) {
        SemanticsPropertiesKt.setPaneTitle(arg3, arg0);
        if(arg1.isOpen()) {
            SemanticsPropertiesKt.dismiss$default(arg3, null, new NavigationDrawerKt$$ExternalSyntheticLambda1(arg1, arg2), 1, null);
        }

        return Unit.INSTANCE;
    }

    static final boolean ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21$lambda$20(DrawerState arg8, CoroutineScope arg9) {
        if(arg8.getConfirmStateChange$material3().invoke(DrawerValue.Closed).booleanValue()) {
            BuildersKt.launch$default(arg9, null, null, new NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1(arg8, null), 3, null);
        }

        return 1;
    }

    static final Unit ModalNavigationDrawer_FHprtrg$lambda$25(Function2 arg11, Modifier arg12, DrawerState arg13, boolean arg14, long arg15, Function2 arg17, int arg18, int arg19, Composer arg20, int arg21) {
        NavigationDrawerKt.ModalNavigationDrawer-FHprtrg(arg11, arg12, arg13, arg14, arg15, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    private static final boolean ModalNavigationDrawer_FHprtrg$lambda$5(MutableState arg0) {
        return ((State)arg0).getValue().booleanValue();
    }

    private static final void ModalNavigationDrawer_FHprtrg$lambda$6(MutableState arg0, boolean arg1) {
        arg0.setValue(Boolean.valueOf(arg1));
    }

    private static final float ModalNavigationDrawer_FHprtrg$lambda$8(MutableFloatState arg0) {
        return ((FloatState)arg0).getFloatValue();
    }

    private static final void ModalNavigationDrawer_FHprtrg$lambda$9(MutableFloatState arg0, float arg1) {
        arg0.setFloatValue(arg1);
    }

    public static final void NavigationDrawerItem(Function2 arg32, boolean arg33, Function0 arg34, Modifier arg35, Function2 arg36, Function2 arg37, Shape arg38, NavigationDrawerItemColors arg39, MutableInteractionSource arg40, Composer arg41, int arg42, int arg43) {
        Function2 v6_1;
        Function2 v5_2;
        NavigationDrawerItemColors v8_1;
        MutableInteractionSource v9_1;
        Shape v7_3;
        Composer v21;
        NavigationDrawerKt$$ExternalSyntheticLambda14 v7_2;
        NavigationDrawerItemColors v5_1;
        Shape v28;
        Function2 v27;
        Modifier v4;
        MutableInteractionSource v12_1;
        Companion v4_2;
        NavigationDrawerItemColors v4_1;
        Companion v35;
        Function2 v26;
        Modifier v1_3;
        int v16;
        Shape v15_1;
        Function2 v13_1;
        int v12;
        Function2 v11;
        int v10;
        Modifier v9;
        int v8;
        int v6;
        boolean v0 = arg33;
        int v1 = arg42;
        int v2 = arg43;
        Composer v14 = arg41.startRestartGroup(-583709666);
        ComposerKt.sourceInformation(v14, "C(NavigationDrawerItem)N(label,selected,onClick,modifier,icon,badge,shape,colors,interactionSource)1083@46164L19,1087@46341L24,1089@46426L885,1078@46032L1279:NavigationDrawer.kt#uh7d8r");
        if((v2 & 1) != 0) {
            v6 = v1 | 6;
        }
        else if((v1 & 6) == 0) {
            v6 = v14.changedInstance(arg32) ? 4 : 2;
            v6 |= v1;
        }
        else {
            v6 = v1;
        }

        if((v2 & 2) != 0) {
            v6 |= 0x30;
        }
        else if((v1 & 0x30) == 0) {
            int v7 = v14.changed(v0) ? 0x20 : 16;
            v6 |= v7;
        }

        if((v2 & 4) != 0) {
            v6 |= 0x180;
        }
        else if((v1 & 0x180) == 0) {
            v8 = v14.changedInstance(arg34) ? 0x100 : 0x80;
            v6 |= v8;
        }

        v8 = v2 & 8;
        if(v8 != 0) {
            v6 |= 0xC00;
            goto label_67;
        }
        else if((v1 & 0xC00) == 0) {
            v9 = arg35;
            v10 = v14.changed(v9) ? 0x800 : 0x400;
            v6 |= v10;
        }
        else {
        label_67:
            v9 = arg35;
        }

        v10 = v2 & 16;
        if(v10 != 0) {
            v6 |= 0x6000;
            goto label_82;
        }
        else if((v1 & 0x6000) == 0) {
            v11 = arg36;
            v12 = v14.changedInstance(v11) ? 0x4000 : 0x2000;
            v6 |= v12;
        }
        else {
        label_82:
            v11 = arg36;
        }

        v12 = v2 & 0x20;
        int v13 = 0x30000;
        if(v12 != 0) {
            v6 |= v13;
            goto label_98;
        }
        else if((v13 & v1) == 0) {
            v13_1 = arg37;
            int v15 = v14.changedInstance(v13_1) ? 0x20000 : 0x10000;
            v6 |= v15;
        }
        else {
        label_98:
            v13_1 = arg37;
        }

        if((0x180000 & v1) == 0) {
            if((v2 & 0x40) == 0) {
                v15_1 = arg38;
                if(v14.changed(v15_1)) {
                    v16 = 0x100000;
                }
                else {
                    goto label_110;
                }
            }
            else {
                v15_1 = arg38;
            label_110:
                v16 = 0x80000;
            }

            v6 |= v16;
        }
        else {
            v15_1 = arg38;
        }

        if((v1 & 0xC00000) == 0) {
            v16 = (v2 & 0x80) != 0 || !v14.changed(arg39) ? 0x400000 : 0x800000;
            v6 |= v16;
        }

        int v3 = v2 & 0x100;
        v16 = 0x6000000;
        if(v3 != 0) {
            v6 |= v16;
        }
        else {
            MutableInteractionSource v5 = arg40;
            if((v1 & v16) == 0) {
                v16 = v14.changed(v5) ? 0x4000000 : 0x2000000;
                v6 |= v16;
            }
        }

        int v24 = v3;
        boolean v1_1 = (v6 & 0x2492493) != 0x2492492 ? true : false;
        if(v14.shouldExecute(v1_1, v6 & 1)) {
            v14.startDefaults();
            ComposerKt.sourceInformation(v14, "1074@45880L5,1075@45957L8");
            int v17 = 0xFFC7FFFF;
            int v25 = 0xFE3FFFFF;
            Object v3_1 = null;
            if((arg42 & 1) == 0 || (v14.getDefaultsInvalid())) {
                if(v8 != 0) {
                    Companion v1_2 = Modifier.Companion;
                }
                else {
                    v1_3 = v9;
                }

                v26 = v10 != 0 ? ((Function2)v3_1) : v11;
                v27 = v12 != 0 ? ((Function2)v3_1) : v13_1;
                if((v2 & 0x40) != 0) {
                    v6 &= v17;
                    v28 = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), v14, 6);
                }
                else {
                    v28 = v15_1;
                }

                int v29 = v6;
                if((v2 & 0x80) != 0) {
                    v35 = ((Companion)v1_3);
                    v1_1 = false;
                    v2 = 1;
                    v4_1 = NavigationDrawerItemDefaults.INSTANCE.colors-oq7We08(0, 0, 0, 0, 0, 0, 0, 0, v14, 0x6000000, 0xFF);
                    v14 = v14;
                    v6 = v29 & v25;
                }
                else {
                    v35 = ((Companion)v1_3);
                    v2 = 1;
                    v1_1 = false;
                    v4_1 = arg39;
                    v6 = v29;
                }

                v12_1 = v24 != 0 ? ((MutableInteractionSource)v3_1) : arg40;
                v5_1 = v4_1;
                v11 = v26;
                v4_2 = v35;
            }
            else {
                v14.skipToGroupEnd();
                if((v2 & 0x40) != 0) {
                    v6 &= v17;
                }

                if((v2 & 0x80) != 0) {
                    v6 &= v25;
                }

                v12_1 = arg40;
                v2 = 1;
                v4 = v9;
                v27 = v13_1;
                v28 = v15_1;
                v1_1 = false;
                v5_1 = arg39;
            }

            v14.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-583709666, v6, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:1077)");
            }

            ComposerKt.sourceInformationMarkerStart(v14, 0x651306B1, "CC(remember):NavigationDrawer.kt#9igjgp");
            Object v7_1 = v14.rememberedValue();
            if(v7_1 == Composer.Companion.getEmpty()) {
                v7_2 = new NavigationDrawerKt$$ExternalSyntheticLambda14();
                v14.updateRememberedValue(v7_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            v1_3 = SizeKt.fillMaxWidth$default(SizeKt.heightIn-VpY3zN4$default(SemanticsModifierKt.semantics$default(((Modifier)v4_2), v1_1, ((Function1)v7_2), v2, v3_1), NavigationDrawerTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM(), 0f, 2, v3_1), 0f, v2, v3_1);
            v3 = v6 >> 3;
            v26 = v11;
            NavigationDrawerItemColors v18 = v5_1;
            Modifier v19 = ((Modifier)v4_2);
            Shape v4_3 = v28;
            SurfaceKt.Surface-d85dljk(arg33, arg34, v1_3, false, v4_3, v5_1.containerColor(v0, v14, v3 & 14 | v6 >> 18 & 0x70).getValue().unbox-impl(), 0, 0f, 0f, null, v12_1, ComposableLambdaKt.rememberComposableLambda(-1173018444, ((boolean)v2), new NavigationDrawerKt$NavigationDrawerItem$2(v11, v5_1, v0, v27, arg32), v14, 54), v14, v3 & 0x7E | v6 >> 6 & 0xE000, v6 >> 24 & 14 | 0x30, 968);
            v21 = v14;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7_3 = v4_3;
            v9_1 = v12_1;
            v8_1 = v18;
            v4 = v19;
            v5_2 = v26;
            v6_1 = v27;
        }
        else {
            v21 = v14;
            v21.skipToGroupEnd();
            v8_1 = arg39;
            v4 = v9;
            v5_2 = v11;
            v6_1 = v13_1;
            v7_3 = v15_1;
            v9_1 = arg40;
        }

        ScopeUpdateScope v12_2 = v21.endRestartGroup();
        if(v12_2 != null) {
            v12_2.updateScope(new NavigationDrawerKt$$ExternalSyntheticLambda15(arg32, arg33, arg34, v4, v5_2, v6_1, v7_3, v8_1, v9_1, arg42, arg43));
        }
    }

    static final Unit NavigationDrawerItem$lambda$64$lambda$63(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(arg1, Role.Companion.getTab-o7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit NavigationDrawerItem$lambda$65(Function2 arg13, boolean arg14, Function0 arg15, Modifier arg16, Function2 arg17, Function2 arg18, Shape arg19, NavigationDrawerItemColors arg20, MutableInteractionSource arg21, int arg22, int arg23, Composer arg24, int arg25) {
        NavigationDrawerKt.NavigationDrawerItem(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    public static final void PermanentDrawerSheet-afqeVBk(Modifier arg25, Shape arg26, long arg27, long arg29, float arg31, WindowInsets arg32, Function3 arg33, Composer arg34, int arg35, int arg36) {
        float v7_2;
        long v5_3;
        long v3_1;
        Shape v2_1;
        WindowInsets v8_2;
        Modifier v1_1;
        Composer v22;
        long v6_1;
        Shape v14_2;
        WindowInsets v12;
        float v19;
        long v17;
        Modifier v0_1;
        Function3 v15_1;
        int v15;
        WindowInsets v14_1;
        float v13;
        long v11;
        int v9;
        long v7_1;
        Shape v6;
        int v4;
        int v10 = arg35;
        Composer v1 = arg34.startRestartGroup(0x6FE32AD4);
        ComposerKt.sourceInformation(v1, "C(PermanentDrawerSheet)N(modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)772@33449L33,776@33617L30,773@33487L384:NavigationDrawer.kt#uh7d8r");
        int v2 = arg36 & 1;
        if(v2 != 0) {
            v4 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v4 = v1.changed(arg25) ? 4 : 2;
            v4 |= v10;
        }
        else {
            v4 = v10;
        }

        int v5 = arg36 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_38;
        }
        else if((v10 & 0x30) == 0) {
            v6 = arg26;
            int v7 = v1.changed(v6) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_38:
            v6 = arg26;
        }

        if((v10 & 0x180) == 0) {
            if((arg36 & 4) == 0) {
                v7_1 = arg27;
                if(v1.changed(v7_1)) {
                    v9 = 0x100;
                }
                else {
                    goto label_49;
                }
            }
            else {
                v7_1 = arg27;
            label_49:
                v9 = 0x80;
            }

            v4 |= v9;
        }
        else {
            v7_1 = arg27;
        }

        if((v10 & 0xC00) == 0) {
            v11 = arg29;
            v9 = (arg36 & 8) != 0 || !v1.changed(v11) ? 0x400 : 0x800;
            v4 |= v9;
        }
        else {
            v11 = arg29;
        }

        v9 = arg36 & 16;
        if(v9 != 0) {
            v4 |= 0x6000;
            goto label_80;
        }
        else if((v10 & 0x6000) == 0) {
            v13 = arg31;
            int v14 = v1.changed(v13) ? 0x4000 : 0x2000;
            v4 |= v14;
        }
        else {
        label_80:
            v13 = arg31;
        }

        if((0x30000 & v10) == 0) {
            if((arg36 & 0x20) == 0) {
                v14_1 = arg32;
                if(v1.changed(v14_1)) {
                    v15 = 0x20000;
                }
                else {
                    goto label_92;
                }
            }
            else {
                v14_1 = arg32;
            label_92:
                v15 = 0x10000;
            }

            v4 |= v15;
        }
        else {
            v14_1 = arg32;
        }

        int v16 = 0x180000;
        if((arg36 & 0x40) != 0) {
            v4 |= v16;
            goto label_111;
        }
        else if((v10 & v16) == 0) {
            v15_1 = arg33;
            v16 = v1.changedInstance(v15_1) ? 0x100000 : 0x80000;
            v4 |= v16;
        }
        else {
        label_111:
            v15_1 = arg33;
        }

        int v34 = v2;
        boolean v0 = (v4 & 0x92493) != 0x92492 ? true : false;
        if(v1.shouldExecute(v0, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "766@33142L22,767@33198L37,769@33357L12");
            int v18 = 0xFFF8FFFF;
            v2 = 6;
            if((v10 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v34 != 0) {
                    Companion v0_2 = Modifier.Companion;
                }
                else {
                    v0_1 = arg25;
                }

                Shape v5_1 = v5 != 0 ? RectangleShapeKt.getRectangleShape() : v6;
                if((arg36 & 4) != 0) {
                    v6_1 = DrawerDefaults.INSTANCE.getStandardContainerColor(v1, v2);
                    v4 &= -897;
                }
                else {
                    v6_1 = v7_1;
                }

                if((arg36 & 8) != 0) {
                    v11 = ColorSchemeKt.contentColorFor-ek8zF_U(v6_1, v1, v4 >> 6 & 14);
                    v4 &= 0xFFFFE3FF;
                }

                float v8 = v9 != 0 ? DrawerDefaults.INSTANCE.getPermanentDrawerElevation-D9Ej5fM() : v13;
                if((arg36 & 0x20) != 0) {
                    v4 &= v18;
                    v14_2 = v5_1;
                    v19 = v8;
                    v17 = v11;
                    v5 = 0x6FE32AD4;
                    v12 = DrawerDefaults.INSTANCE.getWindowInsets(v1, v2);
                    goto label_194;
                }

                v19 = v8;
                v17 = v11;
                v12 = v14_1;
                v14_2 = v5_1;
                v5 = 0x6FE32AD4;
            }
            else {
                v1.skipToGroupEnd();
                if((arg36 & 4) != 0) {
                    v4 &= -897;
                }

                if((arg36 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                if((arg36 & 0x20) != 0) {
                    v4 &= v18;
                }

                v0_1 = arg25;
                v17 = v11;
                v19 = v13;
                v12 = v14_1;
                v5 = 0x6FE32AD4;
                v14_2 = v6;
                v6_1 = v7_1;
            }

        label_194:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v5, v4, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:771)");
            }

            String v5_2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.navigation_menu), v1, 0);
            ComposerKt.sourceInformationMarkerStart(v1, 0x3C415B2, "CC(remember):NavigationDrawer.kt#9igjgp");
            boolean v8_1 = v1.changed(v5_2);
            Object v9_1 = v1.rememberedValue();
            if((v8_1) || v9_1 == Composer.Companion.getEmpty()) {
                NavigationDrawerKt$$ExternalSyntheticLambda19 v9_2 = new NavigationDrawerKt$$ExternalSyntheticLambda19(v5_2);
                v1.updateRememberedValue(v9_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            int v3 = v4 >> 12 & 0x70 | v2;
            v2 = v4 << 6;
            v22 = v1;
            Function3 v21 = v15_1;
            long v15_2 = v6_1;
            NavigationDrawerKt.DrawerSheet-cm3T3N0(null, v12, SemanticsModifierKt.semantics$default(v0_1, false, ((Function1)v9_1), 1, null), v14_2, v15_2, v17, v19, null, v21, v22, v3 | v2 & 0x1C00 | 0xE000 & v2 | 0x70000 & v2 | 0x380000 & v2 | v2 & 0xE000000, 0x80);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_1 = v0_1;
            v8_2 = v12;
            v2_1 = v14_2;
            v3_1 = v15_2;
            v5_3 = v17;
            v7_2 = v19;
        }
        else {
            v22 = v1;
            v22.skipToGroupEnd();
            v1_1 = arg25;
            v2_1 = v6;
            v3_1 = v7_1;
            v5_3 = v11;
            v7_2 = v13;
            v8_2 = v14_1;
        }

        ScopeUpdateScope v12_1 = v22.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new NavigationDrawerKt$$ExternalSyntheticLambda20(v1_1, v2_1, v3_1, v5_3, v7_2, v8_2, arg33, v10, arg36));
        }
    }

    static final Unit PermanentDrawerSheet_afqeVBk$lambda$48$lambda$47(String arg0, SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setPaneTitle(arg1, arg0);
        return Unit.INSTANCE;
    }

    static final Unit PermanentDrawerSheet_afqeVBk$lambda$49(Modifier arg13, Shape arg14, long arg15, long arg17, float arg19, WindowInsets arg20, Function3 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        NavigationDrawerKt.PermanentDrawerSheet-afqeVBk(arg13, arg14, arg15, arg17, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    public static final void PermanentNavigationDrawer(Function2 arg16, Modifier arg17, Function2 arg18, Composer arg19, int arg20, int arg21) {
        Modifier v6_2;
        Companion v6_1;
        int v8;
        Modifier v7;
        int v5;
        Function2 v1 = arg16;
        Function2 v3 = arg18;
        int v4 = arg20;
        int v0 = 0x5529108;
        Composer v2 = arg19.startRestartGroup(v0);
        ComposerKt.sourceInformation(v2, "C(PermanentNavigationDrawer)N(drawerContent,modifier,content)562@23211L85:NavigationDrawer.kt#uh7d8r");
        if((arg21 & 1) != 0) {
            v5 = v4 | 6;
        }
        else if((v4 & 6) == 0) {
            v5 = v2.changedInstance(v1) ? 4 : 2;
            v5 |= v4;
        }
        else {
            v5 = v4;
        }

        int v6 = arg21 & 2;
        if(v6 != 0) {
            v5 |= 0x30;
            goto label_36;
        }
        else if((v4 & 0x30) == 0) {
            v7 = arg17;
            v8 = v2.changed(v7) ? 0x20 : 16;
            v5 |= v8;
        }
        else {
        label_36:
            v7 = arg17;
        }

        if((arg21 & 4) != 0) {
            v5 |= 0x180;
        }
        else if((v4 & 0x180) == 0) {
            v8 = v2.changedInstance(v3) ? 0x100 : 0x80;
            v5 |= v8;
        }

        boolean v8_1 = (v5 & 0x93) != 0x92 ? true : false;
        if(v2.shouldExecute(v8_1, v5 & 1)) {
            if(v6 != 0) {
                v6_1 = Modifier.Companion;
            }
            else {
                v6_2 = v7;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v5, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:561)");
            }

            Modifier v0_1 = SizeKt.fillMaxSize$default(((Modifier)v6_1), 0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(v2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy v7_1 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), v2, 0);
            v8 = -1323940314;
            String v9 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v2, v8, v9);
            int v11 = ComposablesKt.getCurrentCompositeKeyHash(v2, 0);
            CompositionLocalMap v12 = v2.getCurrentCompositionLocalMap();
            v0_1 = ComposedModifierKt.materializeModifier(v2, v0_1);
            Function0 v13 = ComposeUiNode.Companion.getConstructor();
            String v15 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v2, 0xD6BD0031, v15);
            if(!(v2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v2.startReusableNode();
            if(v2.getInserting()) {
                v2.createNode(v13);
            }
            else {
                v2.useNode();
            }

            Composer v13_1 = Updater.constructor-impl(v2);
            Updater.set-impl(v13_1, v7_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v13_1, v12, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v7_2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v13_1.getInserting()) || !Intrinsics.areEqual(v13_1.rememberedValue(), Integer.valueOf(v11))) {
                v13_1.updateRememberedValue(Integer.valueOf(v11));
                v13_1.apply(Integer.valueOf(v11), v7_2);
            }

            Updater.set-impl(v13_1, v0_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v2, 0xD6F40BCE, "C563@23249L15,564@23273L17:NavigationDrawer.kt#uh7d8r");
            v1.invoke(v2, Integer.valueOf(v5 & 14));
            ComposerKt.sourceInformationMarkerStart(v2, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Companion v0_2 = Modifier.Companion;
            v7_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v2, v8, v9);
            v8 = ComposablesKt.getCurrentCompositeKeyHash(v2, 0);
            CompositionLocalMap v9_1 = v2.getCurrentCompositionLocalMap();
            v0_1 = ComposedModifierKt.materializeModifier(v2, ((Modifier)v0_2));
            Function0 v10 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v2, 0xD6BD0031, v15);
            if(!(v2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v2.startReusableNode();
            if(v2.getInserting()) {
                v2.createNode(v10);
            }
            else {
                v2.useNode();
            }

            Composer v10_1 = Updater.constructor-impl(v2);
            Updater.set-impl(v10_1, v7_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v10_1, v9_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            v7_2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v10_1.getInserting()) || !Intrinsics.areEqual(v10_1.rememberedValue(), Integer.valueOf(v8))) {
                v10_1.updateRememberedValue(Integer.valueOf(v8));
                v10_1.apply(Integer.valueOf(v8), v7_2);
            }

            Updater.set-impl(v10_1, v0_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v2, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v2, 0x7510CE28, "C564@23279L9:NavigationDrawer.kt#uh7d8r");
            v3.invoke(v2, Integer.valueOf(v5 >> 6 & 14));
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            v2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            v2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_209;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v2.skipToGroupEnd();
            v6_2 = v7;
        }

    label_209:
        ScopeUpdateScope v7_3 = v2.endRestartGroup();
        if(v7_3 != null) {
            v7_3.updateScope(new NavigationDrawerKt$$ExternalSyntheticLambda26(v1, v6_1, v3, v4, arg21));
        }
    }

    static final Unit PermanentNavigationDrawer$lambda$42(Function2 arg6, Modifier arg7, Function2 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        NavigationDrawerKt.PermanentNavigationDrawer(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    private static final void Scrim-Bx497Mc(boolean arg17, Function0 arg18, Function0 arg19, long arg20, Composer arg22, int arg23) {
        NavigationDrawerKt$$ExternalSyntheticLambda28 v9_4;
        Companion v0_3;
        Modifier v0_2;
        NavigationDrawerKt$$ExternalSyntheticLambda27 v12_2;
        int v9;
        int v8;
        boolean v1 = arg17;
        Function0 v2 = arg18;
        Function0 v3 = arg19;
        long v4 = arg20;
        int v6 = arg23;
        int v0 = 2106487387;
        Composer v7 = arg22.startRestartGroup(v0);
        ComposerKt.sourceInformation(v7, "C(Scrim)N(open,onClose,fraction,color:c#ui.graphics.Color)1285@54138L30,1300@54636L39,1300@54585L90:NavigationDrawer.kt#uh7d8r");
        if((v6 & 6) == 0) {
            v8 = v7.changed(v1) ? 4 : 2;
            v8 |= v6;
        }
        else {
            v8 = v6;
        }

        int v10 = 0x20;
        if((v6 & 0x30) == 0) {
            v9 = v7.changedInstance(v2) ? v10 : 16;
            v8 |= v9;
        }

        if((v6 & 0x180) == 0) {
            v9 = v7.changedInstance(v3) ? 0x100 : 0x80;
            v8 |= v9;
        }

        if((v6 & 0xC00) == 0) {
            v9 = v7.changed(v4) ? 0x800 : 0x400;
            v8 |= v9;
        }

        int v15 = 1;
        boolean v9_1 = (v8 & 0x493) != 1170 ? true : false;
        if(v7.shouldExecute(v9_1, v8 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v8, -1, "androidx.compose.material3.Scrim (NavigationDrawer.kt:1284)");
            }

            String v0_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.close_drawer), v7, 0);
            String v9_2 = "CC(remember):NavigationDrawer.kt#9igjgp";
            if(v1) {
                v7.startReplaceGroup(0x23B0DABD);
                ComposerKt.sourceInformation(v7, "1288@54256L35,1289@54344L187");
                Companion v13 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(v7, 1404790366, v9_2);
                int v14 = v8 & 0x70;
                int v16 = v14 == v10 ? 1 : 0;
                Object v11 = v7.rememberedValue();
                if(v16 != 0 || v11 == Composer.Companion.getEmpty()) {
                    NavigationDrawerKt$Scrim$dismissDrawer$1$1 v11_1 = new NavigationDrawerKt$Scrim$dismissDrawer$1$1(v2);
                    v7.updateRememberedValue(v11_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v7);
                Modifier v11_2 = SuspendingPointerInputFilterKt.pointerInput(((Modifier)v13), v2, ((PointerInputEventHandler)v11));
                ComposerKt.sourceInformationMarkerStart(v7, 0x53BB71F6, v9_2);
                boolean v12 = v7.changed(v0_1);
                v10 = v14 == v10 ? 1 : 0;
                v10 |= ((int)v12);
                Object v12_1 = v7.rememberedValue();
                if(v10 != 0 || v12_1 == Composer.Companion.getEmpty()) {
                    v12_2 = new NavigationDrawerKt$$ExternalSyntheticLambda27(v0_1, v2);
                    v7.updateRememberedValue(v12_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v7);
                v0_2 = SemanticsModifierKt.semantics(v11_2, true, ((Function1)v12_2));
                v7.endReplaceGroup();
            }
            else {
                v7.startReplaceGroup(0x23B5CCA7);
                v7.endReplaceGroup();
                v0_3 = Modifier.Companion;
            }

            v0_2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0f, 1, null).then(((Modifier)v0_3));
            ComposerKt.sourceInformationMarkerStart(v7, 1404802530, v9_2);
            v9 = (v8 & 0x1C00) == 0x800 ? 1 : 0;
            if((v8 & 0x380) == 0x100) {
            }
            else {
                v15 = 0;
            }

            v8 = v9 | v15;
            Object v9_3 = v7.rememberedValue();
            if(v8 != 0 || v9_3 == Composer.Companion.getEmpty()) {
                v9_4 = new NavigationDrawerKt$$ExternalSyntheticLambda28(v4, v3);
                v7.updateRememberedValue(v9_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v7);
            CanvasKt.Canvas(v0_2, ((Function1)v9_4), v7, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_148;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v7.skipToGroupEnd();
        }

    label_148:
        ScopeUpdateScope v7_1 = v7.endRestartGroup();
        if(v7_1 != null) {
            v7_1.updateScope(new NavigationDrawerKt$$ExternalSyntheticLambda29(v1, v2, v3, v4, v6));
        }
    }

    static final Unit Scrim_Bx497Mc$lambda$69$lambda$68(String arg1, Function0 arg2, SemanticsPropertyReceiver arg3) {
        SemanticsPropertiesKt.setContentDescription(arg3, arg1);
        SemanticsPropertiesKt.onClick$default(arg3, null, new NavigationDrawerKt$$ExternalSyntheticLambda0(arg2), 1, null);
        return Unit.INSTANCE;
    }

    static final boolean Scrim_Bx497Mc$lambda$69$lambda$68$lambda$67(Function0 arg0) {
        arg0.invoke();
        return 1;
    }

    static final Unit Scrim_Bx497Mc$lambda$71$lambda$70(long arg14, Function0 arg16, DrawScope arg17) {
        DrawScope.drawRect-n-J9OG0$default(arg17, arg14, 0, 0, arg16.invoke().floatValue(), null, null, 0, 0x76, null);
        return Unit.INSTANCE;
    }

    static final Unit Scrim_Bx497Mc$lambda$72(boolean arg7, Function0 arg8, Function0 arg9, long arg10, int arg12, Composer arg13, int arg14) {
        NavigationDrawerKt.Scrim-Bx497Mc(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg12 | 1));
        return Unit.INSTANCE;
    }

    public static final boolean access$DismissibleNavigationDrawer$lambda$27(MutableState arg0) {
        return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$27(arg0);
    }

    public static final void access$DismissibleNavigationDrawer$lambda$28(MutableState arg0, boolean arg1) {
        NavigationDrawerKt.DismissibleNavigationDrawer$lambda$28(arg0, arg1);
    }

    public static final boolean access$ModalNavigationDrawer_FHprtrg$lambda$5(MutableState arg0) {
        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$5(arg0);
    }

    public static final void access$ModalNavigationDrawer_FHprtrg$lambda$6(MutableState arg0, boolean arg1) {
        NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$6(arg0, arg1);
    }

    public static final float access$ModalNavigationDrawer_FHprtrg$lambda$8(MutableFloatState arg0) {
        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$8(arg0);
    }

    public static final void access$ModalNavigationDrawer_FHprtrg$lambda$9(MutableFloatState arg0, float arg1) {
        NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9(arg0, arg1);
    }

    public static final TweenSpec access$getAnchoredDraggableDefaultAnimationSpec$p() {
        return NavigationDrawerKt.AnchoredDraggableDefaultAnimationSpec;
    }

    public static final float access$getDrawerPositionalThreshold$p() {
        return NavigationDrawerKt.DrawerPositionalThreshold;
    }

    public static final float access$getDrawerVelocityThreshold$p() {
        return NavigationDrawerKt.DrawerVelocityThreshold;
    }

    public static final float access$getMinimumDrawerWidth$p() {
        return NavigationDrawerKt.MinimumDrawerWidth;
    }

    public static final Modifier access$horizontalScaleDown(Modifier arg0, FloatProducer arg1, float arg2, boolean arg3) {
        return NavigationDrawerKt.horizontalScaleDown(arg0, arg1, arg2, arg3);
    }

    public static final Modifier access$predictiveBackDrawerChild(Modifier arg0, DrawerPredictiveBackState arg1, boolean arg2) {
        return NavigationDrawerKt.predictiveBackDrawerChild(arg0, arg1, arg2);
    }

    private static final float calculateFraction(float arg0, float arg1, float arg2) {
        return RangesKt.coerceIn((arg2 - arg0) / (arg1 - arg0), 0f, 1f);
    }

    private static final float calculatePredictiveBackScaleX(GraphicsLayerScope arg2, DrawerPredictiveBackState arg3) {
        float v2 = Float.intBitsToFloat(((int)(arg2.getSize-NH-jbRc() >> 0x20)));
        float v1 = 1f;
        if(!Float.isNaN(v2)) {
            if(v2 == 0f) {
            }
            else {
                int v0 = arg3.getSwipeEdgeMatchesDrawer() ? 1 : -1;
                return arg3.getScaleXDistance() * (((float)v0)) / v2 + v1;
            }
        }

        return v1;
    }

    private static final float calculatePredictiveBackScaleY(GraphicsLayerScope arg4, DrawerPredictiveBackState arg5) {
        float v4 = Float.intBitsToFloat(((int)(arg4.getSize-NH-jbRc() & 0xFFFFFFFFL)));
        float v1 = 1f;
        if(!Float.isNaN(v4)) {
            if(v4 == 0f) {
            }
            else {
                v1 -= arg5.getScaleYDistance() / v4;
            }
        }

        return v1;
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceGrow() {
        return NavigationDrawerKt.PredictiveBackDrawerMaxScaleXDistanceGrow;
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceShrink() {
        return NavigationDrawerKt.PredictiveBackDrawerMaxScaleXDistanceShrink;
    }

    public static final float getPredictiveBackDrawerMaxScaleYDistance() {
        return NavigationDrawerKt.PredictiveBackDrawerMaxScaleYDistance;
    }

    private static final Modifier horizontalScaleDown(Modifier arg1, FloatProducer arg2, float arg3, boolean arg4) {
        return GraphicsLayerModifierKt.graphicsLayer(arg1, new NavigationDrawerKt$$ExternalSyntheticLambda30(arg2, arg3, arg4));
    }

    static final Unit horizontalScaleDown$lambda$55(FloatProducer arg3, float arg4, boolean arg5, GraphicsLayerScope arg6) {
        float v3 = arg3.invoke();
        float v2 = 1f;
        v3 = Float.compare(v3, 0f) > 0 ? v2 / (v3 / arg4 + v2) : v2;
        arg6.setScaleX(v3);
        if(arg5) {
            v2 = 0f;
        }

        arg6.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(v2, 0f));
        return Unit.INSTANCE;
    }

    private static final Modifier horizontalScaleUp(Modifier arg1, FloatProducer arg2, float arg3, boolean arg4) {
        return GraphicsLayerModifierKt.graphicsLayer(arg1, new NavigationDrawerKt$$ExternalSyntheticLambda13(arg2, arg3, arg4));
    }

    static final Unit horizontalScaleUp$lambda$54(FloatProducer arg3, float arg4, boolean arg5, GraphicsLayerScope arg6) {
        float v3 = arg3.invoke();
        float v0 = 0f;
        float v2 = 1f;
        v3 = Float.compare(v3, 0f) > 0 ? v3 / arg4 + v2 : v2;
        arg6.setScaleX(v3);
        if(arg5) {
        }
        else {
            v0 = v2;
        }

        arg6.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(v0, 0.5f));
        return Unit.INSTANCE;
    }

    private static final Modifier predictiveBackDrawerChild(Modifier arg1, DrawerPredictiveBackState arg2, boolean arg3) {
        return GraphicsLayerModifierKt.graphicsLayer(arg1, new NavigationDrawerKt$$ExternalSyntheticLambda12(arg2, arg3));
    }

    static final Unit predictiveBackDrawerChild$lambda$57(DrawerPredictiveBackState arg4, boolean arg5, GraphicsLayerScope arg6) {
        float v0 = NavigationDrawerKt.calculatePredictiveBackScaleX(arg6, arg4);
        float v4 = NavigationDrawerKt.calculatePredictiveBackScaleY(arg6, arg4);
        float v3 = 1f;
        if(Float.compare(v0, 0f) == 0) {
            v4 = v3;
        }
        else {
            v4 /= v0;
        }

        arg6.setScaleX(v4);
        if(arg5) {
            v3 = 0f;
        }

        arg6.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(v3, 0f));
        return Unit.INSTANCE;
    }

    private static final Modifier predictiveBackDrawerContainer(Modifier arg1, DrawerPredictiveBackState arg2, boolean arg3) {
        return GraphicsLayerModifierKt.graphicsLayer(arg1, new NavigationDrawerKt$$ExternalSyntheticLambda18(arg2, arg3));
    }

    static final Unit predictiveBackDrawerContainer$lambda$56(DrawerPredictiveBackState arg1, boolean arg2, GraphicsLayerScope arg3) {
        arg3.setScaleX(NavigationDrawerKt.calculatePredictiveBackScaleX(arg3, arg1));
        arg3.setScaleY(NavigationDrawerKt.calculatePredictiveBackScaleY(arg3, arg1));
        float v1 = arg2 ? 1f : 0f;
        arg3.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(v1, 0.5f));
        return Unit.INSTANCE;
    }

    public static final DrawerState rememberDrawerState(DrawerValue arg6, Function1 arg7, Composer arg8, int arg9, int arg10) {
        Object v7;
        int v1 = 2098699222;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(rememberDrawerState)N(initialValue,confirmStateChange)304@12444L8,306@12546L61,306@12482L125:NavigationDrawer.kt#uh7d8r");
        String v0 = "CC(remember):NavigationDrawer.kt#9igjgp";
        if((arg10 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(arg8, 0x95A00D3E, v0);
            v7 = arg8.rememberedValue();
            if(v7 == Composer.Companion.getEmpty()) {
                NavigationDrawerKt$$ExternalSyntheticLambda31 v7_1 = new NavigationDrawerKt$$ExternalSyntheticLambda31();
                arg8.updateRememberedValue(v7_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg8);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:305)");
        }

        Object[] v1_1 = new Object[0];
        Saver v2 = DrawerState.Companion.Saver(((Function1)v7));
        ComposerKt.sourceInformationMarkerStart(arg8, 0x95A01A33, v0);
        int v3 = 1;
        int v4 = 4;
        int v0_1 = (arg9 & 14 ^ 6) > v4 && (arg8.changed(arg6.ordinal())) || (arg9 & 6) == v4 ? 1 : 0;
        int v5 = 0x20;
        if((arg9 & 0x70 ^ 0x30) <= v5 || !arg8.changed(v7)) {
            if((arg9 & 0x30) == v5) {
            }
            else {
                v3 = 0;
            }
        }

        arg9 = v0_1 | v3;
        Object v0_2 = arg8.rememberedValue();
        if(arg9 != 0 || v0_2 == Composer.Companion.getEmpty()) {
            NavigationDrawerKt$$ExternalSyntheticLambda32 v0_3 = new NavigationDrawerKt$$ExternalSyntheticLambda32(arg6, ((Function1)v7));
            arg8.updateRememberedValue(v0_3);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        Object v6 = RememberSaveableKt.rememberSaveable(v1_1, v2, ((Function0)v0_2), arg8, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return ((DrawerState)v6);
    }

    static final boolean rememberDrawerState$lambda$1$lambda$0(DrawerValue arg0) {
        return 1;
    }

    static final DrawerState rememberDrawerState$lambda$3$lambda$2(DrawerValue arg1, Function1 arg2) {
        return new DrawerState(arg1, arg2);
    }
}

