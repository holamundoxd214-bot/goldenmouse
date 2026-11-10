package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.internal.BackEventProgress$Completed;
import androidx.compose.material3.internal.BackEventProgress$InProgress;
import androidx.compose.material3.internal.BackEventProgress$NotRunning;
import androidx.compose.material3.internal.BackEventProgress;
import androidx.compose.material3.internal.BackHandler_androidKt;
import androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.material3.internal.PredictiveBack;
import androidx.compose.material3.internal.PredictiveBackState;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path$Direction;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000\u008E\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001A\\\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000EH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001Ar\u0010\u0012\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0013\u001A\u00020\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001A\u0099\u0001\u0010\u0019\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\u001A\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\u0013\b\u0002\u0010\u0013\u001A\r\u0012\u0004\u0012\u00020\u00140\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\u001C\u0010\u001D\u001A\u0018\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u00010\u001E¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b!\u0010\"\u001A\u0084\u0001\u0010#\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u001B\u001A\u00020$2\u001C\u0010\u001D\u001A\u0018\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u00010\u001E¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b%\u0010&\u001A\u0098\u0001\u0010\u0000\u001A\u00020\u00012\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\'\u001A\u00020(2\u0012\u0010)\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001E2\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0013\u001A\u00020\u00142\u001C\u0010\u001D\u001A\u0018\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u00010\u001E¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b*\u0010+\u001A\u008E\u0001\u0010,\u001A\u00020\u00012\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\'\u001A\u00020(2\u0012\u0010)\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001E2\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\u001C\u0010\u001D\u001A\u0018\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u00010\u001E¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b-\u0010.\u001A7\u0010/\u001A\u00020\u00032\b\b\u0002\u00100\u001A\u0002012\u000E\b\u0002\u00102\u001A\b\u0012\u0004\u0012\u000204032\u000E\b\u0002\u00105\u001A\b\u0012\u0004\u0012\u00020403H\u0007¢\u0006\u0002\u00106\u001A\u0090\u0002\u0010\u0000\u001A\u00020\u00012\u0006\u00107\u001A\u0002082\u0012\u00109\u001A\u000E\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001E2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001E2\u0006\u0010;\u001A\u00020(2\u0012\u0010<\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001E2\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010=\u001A\u00020(2\u0015\b\u0002\u0010>\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010?\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010@\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0013\u001A\u00020\u00142\n\b\u0002\u0010A\u001A\u0004\u0018\u00010B2\u001C\u0010\u001D\u001A\u0018\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u00010\u001E¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\bC\u0010D\u001A\u0086\u0002\u0010,\u001A\u00020\u00012\u0006\u00107\u001A\u0002082\u0012\u00109\u001A\u000E\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001E2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001E2\u0006\u0010;\u001A\u00020(2\u0012\u0010<\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001E2\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010=\u001A\u00020(2\u0015\b\u0002\u0010>\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010?\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010@\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\n\b\u0002\u0010A\u001A\u0004\u0018\u00010B2\u001C\u0010\u001D\u001A\u0018\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u00010\u001E¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\bE\u0010F\u001AÄ\u0001\u0010K\u001A\u00020\u00012\u0012\u0010L\u001A\u000E\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020N0M2\u0006\u0010O\u001A\u00020P2\u0014\u0010Q\u001A\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\u0014\u0010U\u001A\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\b\b\u0002\u0010\u0007\u001A\u00020\b2\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0013\u001A\u00020\u00142\u001C\u0010\u001D\u001A\u0018\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u00010\u001E¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0001¢\u0006\u0004\bV\u0010W\u001A \u0001\u0010X\u001A\u00020\u00012\u0012\u0010L\u001A\u000E\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020N0M2\u0006\u0010O\u001A\u00020P2\u0014\u0010Q\u001A\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\u0014\u0010U\u001A\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u00142\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010Y\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\u0010\u001D\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010Z\u001Ap\u0010[\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\u001C\u0010\u001D\u001A\u0018\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u00010\u001E¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0003¢\u0006\u0004\b\\\u0010]\u001A\u0080\u0001\u0010^\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010_\u001A\u00020`2\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u001A\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\u00142\u001C\u0010\u001D\u001A\u0018\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u00010\u001E¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0003¢\u0006\u0004\ba\u0010b\u001A\u000E\u0010c\u001A\u000204*\u0004\u0018\u00010dH\u0002\u001A#\u0010j\u001A\u00020\u00012\u0006\u0010A\u001A\u00020k2\f\u0010l\u001A\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010m\u001A-\u0010n\u001A\u0002042\u000E\u0010U\u001A\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u0006\u0010o\u001A\u0002042\u0006\u0010O\u001A\u000204H\u0002¢\u0006\u0002\u0010p\u001AG\u0010q\u001A\u00020r2\u0006\u0010s\u001A\u00020t2\u0006\u0010u\u001A\u00020r2\u000E\u0010U\u001A\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u0006\u0010v\u001A\u00020w2\u0006\u0010o\u001A\u0002042\u0006\u0010x\u001A\u000204H\u0002¢\u0006\u0004\by\u0010z\u001AW\u0010{\u001A\u00020r2\u0006\u0010s\u001A\u00020t2\u0006\u0010u\u001A\u00020r2\u000E\u0010U\u001A\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u000E\u0010Q\u001A\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u0006\u0010|\u001A\u00020r2\u0006\u0010}\u001A\u00020r2\u0006\u0010x\u001A\u000204H\u0002¢\u0006\u0004\b~\u0010\u007F\"\u001E\u0010G\u001A\u00020(*\u00020\u00038BX\u0082\u0004¢\u0006\f\u0012\u0004\bH\u0010I\u001A\u0004\bG\u0010J\"\u001E\u0010e\u001A\u00020f*\u00020\u00038BX\u0082\u0004¢\u0006\f\u0012\u0004\bg\u0010I\u001A\u0004\bh\u0010i\"\u0010\u0010\u0080\u0001\u001A\u00030\u0081\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000F\u0010\u0082\u0001\u001A\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000F\u0010\u0083\u0001\u001A\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000F\u0010\u0084\u0001\u001A\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u001A\u0010\u0085\u0001\u001A\u00020\u000EX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001A\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u001A\u0010\u0089\u0001\u001A\u00020\u000EX\u0082\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u0012\u0006\b\u008A\u0001\u0010\u008B\u0001\"\u001A\u0010\u008C\u0001\u001A\u00020\u000EX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001A\u0006\b\u008D\u0001\u0010\u0087\u0001\"\u000F\u0010\u008E\u0001\u001A\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u001A\u0010\u008F\u0001\u001A\u00020\u000EX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001A\u0006\b\u0090\u0001\u0010\u0087\u0001\"\u0012\u0010\u0091\u0001\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u001A\u0010\u0092\u0001\u001A\u00020\u000EX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001A\u0006\b\u0093\u0001\u0010\u0087\u0001\"\u0012\u0010\u0094\u0001\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u000F\u0010\u0095\u0001\u001A\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0096\u0001\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u000F\u0010\u0097\u0001\u001A\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0098\u0001\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u000F\u0010\u0099\u0001\u001A\u00020rX\u0082T¢\u0006\u0002\n\u0000\"\u000F\u0010\u009A\u0001\u001A\u00020rX\u0082T¢\u0006\u0002\n\u0000\"\u000F\u0010\u009B\u0001\u001A\u00020rX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u009C\u0001\u001A\u00030\u009D\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u009E\u0001\u001A\u00030\u009D\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u009F\u0001\u001A\t\u0012\u0004\u0012\u0002040 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010¡\u0001\u001A\t\u0012\u0004\u0012\u0002040 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010¢\u0001\u001A\t\u0012\u0004\u0012\u0002040 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010£\u0001\u001A\n\u0012\u0005\u0012\u00030¤\u00010 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010¥\u0001\u001A\n\u0012\u0005\u0012\u00030¤\u00010 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010¦\u0001\u001A\u00030§\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010¨\u0001\u001A\u00030©\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ª\u0001²\u0006\u000B\u0010«\u0001\u001A\u00020(X\u008A\u0084\u0002²\u0006\u000B\u0010¬\u0001\u001A\u00020(X\u008A\u0084\u0002²\u0006\f\u0010­\u0001\u001A\u00030®\u0001X\u008A\u0084\u0002"}, d2={"SearchBar", "", "state", "Landroidx/compose/material3/SearchBarState;", "inputField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "SearchBar-nbWgWpA", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/runtime/Composer;II)V", "TopSearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "scrollBehavior", "Landroidx/compose/material3/SearchBarScrollBehavior;", "TopSearchBar-qKj4JfE", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/SearchBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "ExpandedFullScreenSearchBar", "collapsedShape", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ExpandedFullScreenSearchBar-_UtchM0", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ExpandedDockedSearchBar", "Landroidx/compose/ui/window/PopupProperties;", "ExpandedDockedSearchBar-qKj4JfE", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "expanded", "", "onExpandedChange", "SearchBar-Y92LkZI", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DockedSearchBar", "DockedSearchBar-EQC0FA8", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberSearchBarState", "initialValue", "Landroidx/compose/material3/SearchBarValue;", "animationSpecForExpand", "Landroidx/compose/animation/core/AnimationSpec;", "", "animationSpecForCollapse", "(Landroidx/compose/material3/SearchBarValue;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarState;", "query", "", "onQueryChange", "onSearch", "active", "onActiveChange", "enabled", "placeholder", "leadingIcon", "trailingIcon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "SearchBar-WuY5d9Q", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "DockedSearchBar-eWTbjVg", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "isExpanded", "isExpanded$annotations", "(Landroidx/compose/material3/SearchBarState;)V", "(Landroidx/compose/material3/SearchBarState;)Z", "SearchBarImpl", "animationProgress", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "finalBackProgress", "Landroidx/compose/runtime/MutableFloatState;", "firstBackEvent", "Landroidx/compose/runtime/MutableState;", "Landroidx/activity/BackEventCompat;", "Landroidx/compose/material3/internal/BackEventCompat;", "currentBackEvent", "SearchBarImpl-j1jLAyQ", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarLayout", "surface", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DockedSearchBarLayout", "DockedSearchBarLayout-nbWgWpA", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "FullScreenSearchBarLayout", "predictiveBackState", "Landroidx/compose/material3/internal/PredictiveBackState;", "FullScreenSearchBarLayout-EQC0FA8", "(Landroidx/compose/material3/SearchBarState;Landroidx/compose/material3/internal/PredictiveBackState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "transform", "Landroidx/compose/material3/internal/BackEventProgress$InProgress;", "collapsedBounds", "Landroidx/compose/ui/unit/IntRect;", "getCollapsedBounds$annotations", "getCollapsedBounds", "(Landroidx/compose/material3/SearchBarState;)Landroidx/compose/ui/unit/IntRect;", "DetectClickFromInteractionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "onClick", "(Landroidx/compose/foundation/interaction/InteractionSource;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "calculatePredictiveBackMultiplier", "progress", "(Landroidx/activity/BackEventCompat;FF)F", "calculatePredictiveBackOffsetX", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "minMargin", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "predictiveBackMultiplier", "calculatePredictiveBackOffsetX-rOvwMX4", "(JILandroidx/activity/BackEventCompat;Landroidx/compose/ui/unit/LayoutDirection;FF)I", "calculatePredictiveBackOffsetY", "height", "maxOffsetY", "calculatePredictiveBackOffsetY-dzo92Q0", "(JILandroidx/activity/BackEventCompat;Landroidx/activity/BackEventCompat;IIF)I", "UnspecifiedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "LayoutIdInputField", "LayoutIdSurface", "LayoutIdSearchContent", "SearchBarAsTopBarPadding", "getSearchBarAsTopBarPadding", "()F", "F", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "DockedExpandedTableMinHeight", "getDockedExpandedTableMinHeight", "DockedExpandedTableMaxHeightScreenRatio", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarMaxWidth", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "SearchBarIconOffsetX", "SearchBarPredictiveBackMinScale", "SearchBarPredictiveBackMinMargin", "SearchBarPredictiveBackMaxOffsetXRatio", "SearchBarPredictiveBackMaxOffsetY", "AnimationEnterDurationMillis", "AnimationExitDurationMillis", "AnimationDelayMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationExitEasing", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "AnimationExitFloatSpec", "AnimationPredictiveBackExitFloatSpec", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitSizeSpec", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "material3", "useFullScreenShape", "showContent", "backEvent", "Landroidx/compose/material3/internal/BackEventProgress;"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SearchBarKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing = null;
    private static final FiniteAnimationSpec AnimationEnterFloatSpec = null;
    private static final FiniteAnimationSpec AnimationEnterSizeSpec = null;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing = null;
    private static final FiniteAnimationSpec AnimationExitFloatSpec = null;
    private static final FiniteAnimationSpec AnimationExitSizeSpec = null;
    private static final FiniteAnimationSpec AnimationPredictiveBackExitFloatSpec = null;
    private static final EnterTransition DockedEnterTransition = null;
    private static final ExitTransition DockedExitTransition = null;
    private static final float DockedExpandedTableMaxHeightScreenRatio = 0.666667f;
    private static final float DockedExpandedTableMinHeight = 0f;
    private static final String LayoutIdInputField = "InputField";
    private static final String LayoutIdSearchContent = "Content";
    private static final String LayoutIdSurface = "Surface";
    private static final float SearchBarAsTopBarPadding = 0f;
    private static final float SearchBarCornerRadius = 0f;
    private static final float SearchBarIconOffsetX = 0f;
    private static final float SearchBarMaxWidth = 0f;
    private static final float SearchBarMinWidth = 0f;
    private static final float SearchBarPredictiveBackMaxOffsetXRatio = 0.05f;
    private static final float SearchBarPredictiveBackMaxOffsetY = 0f;
    private static final float SearchBarPredictiveBackMinMargin = 0f;
    private static final float SearchBarPredictiveBackMinScale = 0.9f;
    private static final float SearchBarVerticalPadding;
    private static final TextFieldColors UnspecifiedTextFieldColors;

    static {
        SearchBarKt.UnspecifiedTextFieldColors = new TextFieldColors(Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), new TextSelectionColors(Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), null), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), null);
        SearchBarKt.SearchBarAsTopBarPadding = Dp.constructor-impl(8f);
        SearchBarKt.SearchBarCornerRadius = Dp.constructor-impl(SearchBarDefaults.INSTANCE.getInputFieldHeight-D9Ej5fM() / 2f);
        SearchBarKt.DockedExpandedTableMinHeight = Dp.constructor-impl(240f);
        SearchBarKt.SearchBarMinWidth = Dp.constructor-impl(360f);
        SearchBarKt.SearchBarMaxWidth = Dp.constructor-impl(720f);
        SearchBarKt.SearchBarVerticalPadding = Dp.constructor-impl(8f);
        SearchBarKt.SearchBarIconOffsetX = Dp.constructor-impl(4f);
        SearchBarKt.SearchBarPredictiveBackMinMargin = Dp.constructor-impl(8f);
        SearchBarKt.SearchBarPredictiveBackMaxOffsetY = Dp.constructor-impl(24f);
        CubicBezierEasing v0 = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        SearchBarKt.AnimationEnterEasing = v0;
        CubicBezierEasing v1 = new CubicBezierEasing(0f, 1f, 0f, 1f);
        SearchBarKt.AnimationExitEasing = v1;
        TweenSpec v2 = AnimationSpecKt.tween(600, 100, v0);
        SearchBarKt.AnimationEnterFloatSpec = ((FiniteAnimationSpec)v2);
        TweenSpec v6 = AnimationSpecKt.tween(350, 100, v1);
        SearchBarKt.AnimationExitFloatSpec = ((FiniteAnimationSpec)v6);
        SearchBarKt.AnimationPredictiveBackExitFloatSpec = AnimationSpecKt.tween$default(350, 0, v1, 2, null);
        TweenSpec v12 = AnimationSpecKt.tween(600, 100, ((Easing)v0));
        SearchBarKt.AnimationEnterSizeSpec = ((FiniteAnimationSpec)v12);
        TweenSpec v0_1 = AnimationSpecKt.tween(350, 100, ((Easing)v1));
        SearchBarKt.AnimationExitSizeSpec = ((FiniteAnimationSpec)v0_1);
        SearchBarKt.DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(((FiniteAnimationSpec)v2), 0f, 2, null).plus(EnterExitTransitionKt.expandVertically$default(((FiniteAnimationSpec)v12), null, false, null, 14, null));
        SearchBarKt.DockedExitTransition = EnterExitTransitionKt.fadeOut$default(((FiniteAnimationSpec)v6), 0f, 2, null).plus(EnterExitTransitionKt.shrinkVertically$default(v0_1, null, false, null, 14, null));
    }

    private static final void DetectClickFromInteractionSource(InteractionSource arg8, Function0 arg9, Composer arg10, int arg11) {
        int v1;
        int v0 = -652650823;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(DetectClickFromInteractionSource)N(interactionSource,onClick)2593@119695L148,2593@119661L182:SearchBar.kt#uh7d8r");
        int v2 = 4;
        if((arg11 & 6) == 0) {
            v1 = arg10.changed(arg8) ? v2 : 2;
            v1 |= arg11;
        }
        else {
            v1 = arg11;
        }

        int v4 = 0x20;
        if((arg11 & 0x30) == 0) {
            int v3 = arg10.changedInstance(arg9) ? v4 : 16;
            v1 |= v3;
        }

        int v6 = 0;
        boolean v3_1 = (v1 & 19) != 18 ? true : false;
        if(arg10.shouldExecute(v3_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.DetectClickFromInteractionSource (SearchBar.kt:2592)");
            }

            ComposerKt.sourceInformationMarkerStart(arg10, -132210195, "CC(remember):SearchBar.kt#9igjgp");
            v0 = v1 & 14;
            v2 = v0 == v2 ? 1 : 0;
            if((v1 & 0x70) == v4) {
                v6 = 1;
            }

            v1 = v2 | v6;
            Object v2_1 = arg10.rememberedValue();
            if(v1 != 0 || v2_1 == Composer.Companion.getEmpty()) {
                SearchBarKt$DetectClickFromInteractionSource$1$1 v2_2 = new SearchBarKt$DetectClickFromInteractionSource$1$1(arg8, arg9, null);
                arg10.updateRememberedValue(v2_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg10);
            EffectsKt.LaunchedEffect(arg8, ((Function2)v2_1), arg10, v0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_69;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_69:
        ScopeUpdateScope v10 = arg10.endRestartGroup();
        if(v10 != null) {
            v10.updateScope(new SearchBarKt$$ExternalSyntheticLambda2(arg8, arg9, arg11));
        }
    }

    static final Unit DetectClickFromInteractionSource$lambda$73(InteractionSource arg0, Function0 arg1, int arg2, Composer arg3, int arg4) {
        SearchBarKt.DetectClickFromInteractionSource(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public static final void DockedSearchBar-EQC0FA8(Function2 arg27, boolean arg28, Function1 arg29, Modifier arg30, Shape arg31, SearchBarColors arg32, float arg33, float arg34, Function3 arg35, Composer arg36, int arg37, int arg38) {
        float v8_2;
        Modifier v4_2;
        SearchBarColors v6_3;
        int v4_1;
        Composer v13_1;
        float v18_1;
        float v19;
        SearchBarColors v0_2;
        SearchBarColors v12_2;
        int v24;
        Shape v0_3;
        int v16;
        float v7;
        int v15;
        float v14_1;
        int v14;
        int v13;
        Shape v12_1;
        Modifier v8;
        int v6;
        int v5;
        Function2 v1 = arg27;
        boolean v2 = arg28;
        Function1 v3 = arg29;
        Function3 v9 = arg35;
        int v10 = arg37;
        int v11 = arg38;
        Composer v4 = arg36.startRestartGroup(-2008777812);
        ComposerKt.sourceInformation(v4, "C(DockedSearchBar)N(inputField,expanded,onExpandedChange,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)661@31616L38,665@31811L696,658@31522L985,686@32545L27,686@32513L59:SearchBar.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v5 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v5 = v4.changedInstance(v1) ? 4 : 2;
            v5 |= v10;
        }
        else {
            v5 = v10;
        }

        if((v11 & 2) != 0) {
            v5 |= 0x30;
        }
        else if((v10 & 0x30) == 0) {
            v6 = v4.changed(v2) ? 0x20 : 16;
            v5 |= v6;
        }

        if((v11 & 4) != 0) {
            v5 |= 0x180;
        }
        else if((v10 & 0x180) == 0) {
            v6 = v4.changedInstance(v3) ? 0x100 : 0x80;
            v5 |= v6;
        }

        v6 = v11 & 8;
        if(v6 != 0) {
            v5 |= 0xC00;
            goto label_63;
        }
        else if((v10 & 0xC00) == 0) {
            v8 = arg30;
            int v12 = v4.changed(v8) ? 0x800 : 0x400;
            v5 |= v12;
        }
        else {
        label_63:
            v8 = arg30;
        }

        if((v10 & 0x6000) == 0) {
            if((v11 & 16) == 0) {
                v12_1 = arg31;
                if(v4.changed(v12_1)) {
                    v13 = 0x4000;
                }
                else {
                    goto label_74;
                }
            }
            else {
                v12_1 = arg31;
            label_74:
                v13 = 0x2000;
            }

            v5 |= v13;
        }
        else {
            v12_1 = arg31;
        }

        if((0x30000 & v10) == 0) {
            v14 = (v11 & 0x20) != 0 || !v4.changed(arg32) ? 0x10000 : 0x20000;
            v5 |= v14;
        }

        int v21 = v11 & 0x40;
        v14 = 0x180000;
        if(v21 != 0) {
            v5 |= v14;
            goto label_108;
        }
        else if((v14 & v10) == 0) {
            v14_1 = arg33;
            v15 = v4.changed(v14_1) ? 0x100000 : 0x80000;
            v5 |= v15;
        }
        else {
        label_108:
            v14_1 = arg33;
        }

        v15 = v11 & 0x80;
        int v22 = 0xC00000;
        if(v15 != 0) {
            v5 |= v22;
            v7 = arg34;
        }
        else {
            v7 = arg34;
            if((v10 & v22) == 0) {
                v16 = v4.changed(v7) ? 0x800000 : 0x400000;
                v5 |= v16;
            }
        }

        v16 = 0x6000000;
        if((v11 & 0x100) != 0) {
            v5 |= v16;
        }
        else if((v10 & v16) == 0) {
            int v0 = v4.changedInstance(v9) ? 0x4000000 : 0x2000000;
            v5 |= v0;
        }

        v16 = v5;
        boolean v0_1 = (0x2492493 & v5) != 0x2492492 ? true : false;
        if(v4.shouldExecute(v0_1, v16 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "652@31274L11,653@31335L8");
            v5 = 0xFFF8FFFF;
            int v18 = 0xFFFF1FFF;
            if((v10 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v6 != 0) {
                    Companion v8_1 = Modifier.Companion;
                }

                if((v11 & 16) != 0) {
                    v0_3 = SearchBarDefaults.INSTANCE.getDockedShape(v4, 6);
                    v6 = v16 & v18;
                }
                else {
                    v0_3 = v12_1;
                    v6 = v16;
                }

                if((v11 & 0x20) != 0) {
                    Composer v18_2 = v4;
                    v4_1 = 0;
                    v24 = v15;
                    v12_2 = SearchBarDefaults.INSTANCE.colors-Klgx-Pg(0, 0, null, v18_2, 0xC00, 7);
                    v13_1 = v18_2;
                    v6 &= v5;
                }
                else {
                    v24 = v15;
                    v13_1 = v4;
                    v4_1 = 0;
                    v12_2 = arg32;
                }

                v16 = v6;
                float v6_1 = v21 != 0 ? SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM() : arg33;
                if(v24 != 0) {
                    v7 = SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                }

                SearchBarColors v18_3 = v12_2;
                v12_1 = v0_3;
                v0_2 = v18_3;
                v18_1 = v6_1;
                v19 = v7;
                v6 = v16;
            }
            else {
                v4.skipToGroupEnd();
                if((v11 & 16) != 0) {
                    v16 &= v18;
                }

                if((v11 & 0x20) != 0) {
                    v16 &= v5;
                }

                v0_2 = arg32;
                v19 = v7;
                v18_1 = v14_1;
                v6 = v16;
                v13_1 = v4;
                v4_1 = 0;
            }

            v13_1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2008777812, v6, -1, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:657)");
            }

            long v14_2 = v0_2.getContainerColor-0d7_KjU();
            int v7_1 = v6;
            long v16_1 = ColorSchemeKt.contentColorFor-ek8zF_U(v0_2.getContainerColor-0d7_KjU(), v13_1, v4_1);
            Modifier v5_1 = SizeKt.width-3ABfNKs(ZIndexModifierKt.zIndex(v8, 1f), SearchBarKt.SearchBarMinWidth);
            SearchBarKt$DockedSearchBar$1 v6_2 = new SearchBarKt$DockedSearchBar$1(v1, v2, v0_2, v9);
            SearchBarColors v31 = v0_2;
            int v1_1 = 1;
            v4_1 = v7_1 >> 6;
            SurfaceKt.Surface-T9BRK9s(v5_1, v12_1, v14_2, v16_1, v18_1, v19, null, ComposableLambdaKt.rememberComposableLambda(401953073, true, v6_2, v13_1, 54), v13_1, v7_1 >> 9 & 0x70 | v22 | 0xE000 & v4_1 | v4_1 & 0x70000, 0x40);
            v12_1 = v12_1;
            v13_1 = v13_1;
            ComposerKt.sourceInformationMarkerStart(v13_1, 0x8914FD07, "CC(remember):SearchBar.kt#9igjgp");
            if((v7_1 & 0x380) == 0x100) {
            }
            else {
                v1_1 = 0;
            }

            Object v0_4 = v13_1.rememberedValue();
            if(v1_1 != 0 || v0_4 == Composer.Companion.getEmpty()) {
                SearchBarKt$$ExternalSyntheticLambda18 v0_5 = new SearchBarKt$$ExternalSyntheticLambda18(v3);
                v13_1.updateRememberedValue(v0_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v13_1);
            BackHandler_androidKt.BackHandler(v2, ((Function0)v0_4), v13_1, v7_1 >> 3 & 14, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6_3 = v31;
            v4_2 = v8;
            v7 = v18_1;
            v8_2 = v19;
        }
        else {
            v13_1 = v4;
            v13_1.skipToGroupEnd();
            v6_3 = arg32;
            v4_2 = v8;
            v8_2 = v7;
            v7 = arg33;
        }

        Shape v5_2 = v12_1;
        ScopeUpdateScope v12_3 = v13_1.endRestartGroup();
        if(v12_3 != null) {
            v12_3.updateScope(new SearchBarKt$$ExternalSyntheticLambda19(arg27, v2, v3, v4_2, v5_2, v6_3, v7, v8_2, v9, v10, v11));
        }
    }

    @Deprecated(message="Use overload which takes inputField as a parameter", replaceWith="<_subannotation>") public static final void DockedSearchBar-eWTbjVg(String arg34, Function1 arg35, Function1 arg36, boolean arg37, Function1 arg38, Modifier arg39, boolean arg40, Function2 arg41, Function2 arg42, Function2 arg43, Shape arg44, SearchBarColors arg45, float arg46, float arg47, MutableInteractionSource arg48, Function3 arg49, Composer arg50, int arg51, int arg52, int arg53) {
        Function2 v8_2;
        float v13_2;
        Shape v11_2;
        MutableInteractionSource v15_2;
        Function2 v9_2;
        boolean v7_4;
        SearchBarColors v12_1;
        Composer v0_4;
        float v14_1;
        int v13_1;
        float v6_1;
        Shape v8_1;
        Composer v10_1;
        Function2 v22_1;
        boolean v21_1;
        Modifier v7_1;
        boolean v1_1;
        Function2 v23_1;
        MutableInteractionSource v25_1;
        float v11_1;
        SearchBarColors v9_1;
        Function2 v24_1;
        SearchBarColors v4_1;
        Shape v17_1;
        Companion v0_2;
        int v24;
        int v31;
        Function2 v3;
        Function2 v10;
        boolean v8;
        int v25;
        Modifier v6;
        int v18;
        Function1 v15;
        int v4;
        int v0 = arg51;
        int v1 = arg52;
        int v2 = arg53;
        Composer v13 = arg50.startRestartGroup(0x73031C60);
        ComposerKt.sourceInformation(v13, "C(DockedSearchBar)N(query,onQueryChange,onSearch,active,onActiveChange,modifier,enabled,placeholder,leadingIcon,trailingIcon,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,interactionSource,content)2048@96829L591,2047@96791L894:SearchBar.kt#uh7d8r");
        if((v2 & 1) != 0) {
            v4 = v0 | 6;
        }
        else {
            String v14 = arg34;
            if((v0 & 6) == 0) {
                v4 = v13.changed(v14) ? 4 : 2;
                v4 |= v0;
            }
            else {
                v4 = v0;
            }
        }

        if((v2 & 2) != 0) {
            v4 |= 0x30;
            v15 = arg35;
        }
        else {
            v15 = arg35;
            if((v0 & 0x30) == 0) {
                int v7 = v13.changedInstance(v15) ? 0x20 : 16;
                v4 |= v7;
            }
        }

        if((v2 & 4) != 0) {
            v4 |= 0x180;
        }
        else if((v0 & 0x180) == 0) {
            int v12 = v13.changedInstance(arg36) ? 0x100 : 0x80;
            v4 |= v12;
        }

        int v16 = 0x800;
        int v17 = 0x400;
        if((v2 & 8) != 0) {
            v4 |= 0xC00;
        }
        else if((v0 & 0xC00) == 0) {
            v18 = v13.changed(arg37) ? v16 : v17;
            v4 |= v18;
        }

        int v19 = 0x4000;
        int v20 = 0x2000;
        if((v2 & 16) != 0) {
            v4 |= 0x6000;
        }
        else if((v0 & 0x6000) == 0) {
            v18 = v13.changedInstance(arg38) ? v19 : v20;
            v4 |= v18;
        }

        v18 = v2 & 0x20;
        int v21 = 0x20000;
        int v22 = 0x10000;
        int v23 = 0x30000;
        if(v18 != 0) {
            v4 |= v23;
            v6 = arg39;
        }
        else {
            v6 = arg39;
            if((v0 & v23) == 0) {
                v25 = v13.changed(v6) ? v21 : v22;
                v4 |= v25;
            }
        }

        v25 = v2 & 0x40;
        int v26 = 0x180000;
        if(v25 != 0) {
            v4 |= v26;
            v8 = arg40;
        }
        else {
            v8 = arg40;
            if((v0 & v26) == 0) {
                int v27 = v13.changed(v8) ? 0x100000 : 0x80000;
                v4 |= v27;
            }
        }

        int v9 = v2 & 0x80;
        int v28 = 0xC00000;
        if(v9 != 0) {
            v4 |= v28;
            v10 = arg41;
        }
        else {
            v10 = arg41;
            if((v0 & v28) == 0) {
                int v29 = v13.changedInstance(v10) ? 0x800000 : 0x400000;
                v4 |= v29;
            }
        }

        int v11 = v2 & 0x100;
        int v30 = 0x6000000;
        if(v11 != 0) {
            v4 |= v30;
            v3 = arg42;
        }
        else {
            v3 = arg42;
            if((v0 & v30) == 0) {
                v31 = v13.changedInstance(v3) ? 0x4000000 : 0x2000000;
                v4 |= v31;
            }
        }

        v0 = v2 & 0x200;
        v31 = 0x30000000;
        if(v0 != 0) {
            v4 |= v31;
            goto label_165;
        }
        else if((arg51 & v31) == 0) {
            v31 = v0;
            int v32 = v13.changedInstance(arg43) ? 0x20000000 : 0x10000000;
            v4 |= v32;
        }
        else {
        label_165:
            v31 = v0;
        }

        if((v1 & 6) == 0) {
            v24 = (v2 & 0x400) != 0 || !v13.changed(arg44) ? 2 : 4;
            v24 |= v1;
        }
        else {
            v24 = v1;
        }

        if((v1 & 0x30) == 0) {
            v26 = (v2 & 0x800) != 0 || !v13.changed(arg45) ? 16 : 0x20;
            v24 |= v26;
        }

        v0 = v24;
        int v5 = v2 & 0x1000;
        if(v5 != 0) {
            v0 |= 0x180;
        }
        else {
            v24 = v0;
            if((v1 & 0x180) == 0) {
                v28 = v13.changed(arg46) ? 0x100 : 0x80;
                v24 |= v28;
            }

            v0 = v24;
        }

        v24 = v5;
        v5 = v2 & 0x2000;
        if(v5 != 0) {
            v0 |= 0xC00;
        }
        else {
            v26 = v0;
            if((v1 & 0xC00) == 0) {
                if(v13.changed(arg47)) {
                }
                else {
                    v16 = v17;
                }

                v0 = v26 | v16;
            }
            else {
                v0 = v26;
            }
        }

        v16 = v5;
        v5 = v2 & 0x4000;
        if(v5 != 0) {
            v17 = v0 | 0x6000;
        }
        else {
            v17 = v0;
            if((v1 & 0x6000) == 0) {
                if(v13.changed(arg48)) {
                }
                else {
                    v19 = v20;
                }

                v17 |= v19;
            }
        }

        if((v2 & 0x8000) != 0) {
            v17 |= v23;
            goto label_264;
        }
        else if((v1 & v23) == 0) {
            v19 = v5;
            if(v13.changedInstance(arg49)) {
            }
            else {
                v21 = v22;
            }

            v17 |= v21;
        }
        else {
        label_264:
            v19 = v5;
        }

        boolean v0_1 = (v4 & 306783379) != 306783378 || (v17 & 74899) != 74898 ? true : false;
        if(v13.shouldExecute(v0_1, v4 & 1)) {
            v13.startDefaults();
            ComposerKt.sourceInformation(v13, "2040@96486L11,2041@96547L8");
            v1 = 6;
            if((arg51 & 1) == 0 || (v13.getDefaultsInvalid())) {
                if(v18 != 0) {
                    v0_2 = Modifier.Companion;
                }
                else {
                    Modifier v0_3 = v6;
                }

                boolean v18_1 = v25 != 0 ? true : v8;
                Function2 v20_1 = null;
                Function2 v21_2 = v9 != 0 ? v20_1 : v10;
                if(v11 != 0) {
                    v3 = v20_1;
                }

                v22_1 = v31 != 0 ? v20_1 : arg43;
                if((v2 & 0x400) != 0) {
                    v23 = v17 & -15;
                    v17_1 = SearchBarDefaults.INSTANCE.getDockedShape(v13, v1);
                }
                else {
                    v23 = v17;
                    v17_1 = arg44;
                }

                if((v2 & 0x800) != 0) {
                    arg50 = v13;
                    v13_1 = v4;
                    v10_1 = arg50;
                    v1_1 = true;
                    v4_1 = SearchBarDefaults.INSTANCE.colors-Klgx-Pg(0, 0, null, v10_1, 0xC00, 7);
                    v5 = v23 & 0xFFFFFF8F;
                }
                else {
                    v1_1 = true;
                    v10_1 = v13;
                    v13_1 = v4;
                    v4_1 = arg45;
                    v5 = v23;
                }

                v6_1 = v24 != 0 ? SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM() : arg46;
                float v7_2 = v16 != 0 ? SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM() : arg47;
                if(v19 != 0) {
                    v23_1 = v3;
                    v9_1 = v4_1;
                    v11_1 = v7_2;
                    v8_1 = v17_1;
                    v25_1 = ((MutableInteractionSource)v20_1);
                }
                else {
                    v25_1 = arg48;
                    v23_1 = v3;
                    v9_1 = v4_1;
                    v11_1 = v7_2;
                    v8_1 = v17_1;
                }

                v24_1 = v22_1;
                Companion v7_3 = v0_2;
                v22_1 = v21_2;
                v21_1 = v18_1;
            }
            else {
                v13.skipToGroupEnd();
                if((v2 & 0x400) != 0) {
                    v17 &= -15;
                }

                if((v2 & 0x800) != 0) {
                    v17 &= 0xFFFFFF8F;
                }

                v24_1 = arg43;
                v9_1 = arg45;
                v11_1 = arg47;
                v25_1 = arg48;
                v23_1 = v3;
                v1_1 = true;
                v7_1 = v6;
                v21_1 = v8;
                v22_1 = v10;
                v10_1 = v13;
                v5 = v17;
                v8_1 = arg44;
                v6_1 = arg46;
                v13_1 = v4;
            }

            v10_1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x73031C60, v13_1, v5, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:2047)");
            }

            ComposableLambda v4_2 = ComposableLambdaKt.rememberComposableLambda(0xB3F51AF2, v1_1, new SearchBarKt$DockedSearchBar$4(v9_1, arg34, v15, arg36, arg37, arg38, v21_1, v22_1, v23_1, v24_1, v25_1), v10_1, 54);
            v0 = v13_1 >> 6;
            v1 = v5 << 12;
            v13 = v10_1;
            float v10_2 = v6_1;
            SearchBarKt.DockedSearchBar-EQC0FA8(((Function2)v4_2), arg37, arg38, v7_1, v8_1, v9_1, v10_2, v11_1, arg49, v13, v0 & 0x1C00 | (v0 & 0x70 | 6 | v0 & 0x380) | 0xE000 & v1 | 0x70000 & v1 | 0x380000 & v1 | v1 & 0x1C00000 | v5 << 9 & 0xE000000, 0);
            SearchBarColors v15_1 = v9_1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6 = v7_1;
            v14_1 = v11_1;
            v0_4 = v13;
            v12_1 = v15_1;
            v7_4 = v21_1;
            v9_2 = v23_1;
            v15_2 = v25_1;
            v11_2 = v8_1;
            v13_2 = v10_2;
            v8_2 = v22_1;
            v10 = v24_1;
        }
        else {
            v13.skipToGroupEnd();
            v11_2 = arg44;
            v12_1 = arg45;
            v14_1 = arg47;
            v15_2 = arg48;
            v9_2 = v3;
            v7_4 = v8;
            v8_2 = v10;
            v0_4 = v13;
            v10 = arg43;
            v13_2 = arg46;
        }

        ScopeUpdateScope v0_5 = v0_4.endRestartGroup();
        if(v0_5 != null) {
            v0_5.updateScope(new SearchBarKt$$ExternalSyntheticLambda4(arg34, arg35, arg36, arg37, arg38, v6, v7_4, v8_2, v9_2, v10, v11_2, v12_1, v13_2, v14_1, v15_2, arg49, arg51, arg52, v2));
        }
    }

    private static final void DockedSearchBarLayout-nbWgWpA(SearchBarState arg23, Function2 arg24, Modifier arg25, Shape arg26, SearchBarColors arg27, float arg28, float arg29, Function3 arg30, Composer arg31, int arg32) {
        Composer v20;
        CoroutineScope v0_2;
        int v13;
        int v10;
        Modifier v7_1;
        int v4;
        SearchBarState v1 = arg23;
        Function2 v2 = arg24;
        SearchBarColors v5 = arg27;
        Function3 v8 = arg30;
        int v9 = arg32;
        int v0 = 1402423467;
        Composer v3 = arg31.startRestartGroup(v0);
        ComposerKt.sourceInformation(v3, "C(DockedSearchBarLayout)N(state,inputField,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)2324@107586L24,2325@107655L47,2325@107615L87,2330@107802L38,2334@107974L2233,2327@107708L2499:SearchBar.kt#uh7d8r");
        int v6 = 4;
        if((v9 & 6) == 0) {
            v4 = v3.changed(v1) ? v6 : 2;
            v4 |= v9;
        }
        else {
            v4 = v9;
        }

        if((v9 & 0x30) == 0) {
            int v7 = v3.changedInstance(v2) ? 0x20 : 16;
            v4 |= v7;
        }

        if((v9 & 0x180) == 0) {
            v7_1 = arg25;
            v10 = v3.changed(v7_1) ? 0x100 : 0x80;
            v4 |= v10;
        }
        else {
            v7_1 = arg25;
        }

        Shape v11 = arg26;
        if((v9 & 0xC00) == 0) {
            v10 = v3.changed(v11) ? 0x800 : 0x400;
            v4 |= v10;
        }

        if((v9 & 0x6000) == 0) {
            v10 = v3.changed(v5) ? 0x4000 : 0x2000;
            v4 |= v10;
        }

        if((0x30000 & v9) == 0) {
            int v12 = v3.changed(arg28) ? 0x20000 : 0x10000;
            v4 |= v12;
        }

        if((0x180000 & v9) == 0) {
            v13 = v3.changed(arg29) ? 0x100000 : 0x80000;
            v4 |= v13;
        }

        v13 = 0xC00000;
        if((v9 & v13) == 0) {
            int v14 = v3.changedInstance(v8) ? 0x800000 : 0x400000;
            v4 |= v14;
        }

        int v31 = v13;
        boolean v14_1 = (0x492493 & v4) != 4793490 ? true : false;
        if(v3.shouldExecute(v14_1, v4 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.material3.DockedSearchBarLayout (SearchBar.kt:2323)");
            }

            ComposerKt.sourceInformationMarkerStart(v3, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v3, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
            Object v0_1 = v3.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v3);
                v3.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            ComposerKt.sourceInformationMarkerEnd(v3);
            v14_1 = SearchBarKt.isExpanded(v1);
            ComposerKt.sourceInformationMarkerStart(v3, 0xCAE7FD9A, "CC(remember):SearchBar.kt#9igjgp");
            boolean v13_1 = v3.changedInstance(v0_2);
            v6 = (v4 & 14) == v6 ? 1 : 0;
            v6 |= ((int)v13_1);
            Object v13_2 = v3.rememberedValue();
            if(v6 != 0 || v13_2 == Composer.Companion.getEmpty()) {
                SearchBarKt$$ExternalSyntheticLambda12 v13_3 = new SearchBarKt$$ExternalSyntheticLambda12(v0_2, v1);
                v3.updateRememberedValue(v13_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            BackHandler_androidKt.BackHandler(v14_1, ((Function0)v13_2), v3, 0, 0);
            long v12_1 = v5.getContainerColor-0d7_KjU();
            long v14_2 = ColorSchemeKt.contentColorFor-ek8zF_U(v5.getContainerColor-0d7_KjU(), v3, 0);
            Modifier v10_1 = WindowInsetsPadding_androidKt.imePadding(v7_1);
            ComposableLambda v19 = ComposableLambdaKt.rememberComposableLambda(0xC6F6C906, true, new SearchBarKt$DockedSearchBarLayout$2(v2, v1, v5, v8), v3, 54);
            int v1_1 = v4 >> 3;
            v20 = v3;
            SurfaceKt.Surface-T9BRK9s(v10_1, v11, v12_1, v14_2, arg28, arg29, null, ((Function2)v19), v20, v4 >> 6 & 0x70 | v31 | 0xE000 & v1_1 | v1_1 & 0x70000, 0x40);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_176;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v20 = v3;
            v20.skipToGroupEnd();
        }

    label_176:
        ScopeUpdateScope v10_2 = v20.endRestartGroup();
        if(v10_2 != null) {
            v10_2.updateScope(new SearchBarKt$$ExternalSyntheticLambda13(arg23, arg24, v7_1, arg26, v5, arg28, arg29, v8, v9));
        }
    }

    static final Unit DockedSearchBarLayout_nbWgWpA$lambda$51$lambda$50(CoroutineScope arg8, SearchBarState arg9) {
        BuildersKt.launch$default(arg8, null, null, new SearchBarKt$DockedSearchBarLayout$1$1$1(arg9, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit DockedSearchBarLayout_nbWgWpA$lambda$52(SearchBarState arg11, Function2 arg12, Modifier arg13, Shape arg14, SearchBarColors arg15, float arg16, float arg17, Function3 arg18, int arg19, Composer arg20, int arg21) {
        SearchBarKt.DockedSearchBarLayout-nbWgWpA(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg20, RecomposeScopeImplKt.updateChangedFlags(arg19 | 1));
        return Unit.INSTANCE;
    }

    static final Unit DockedSearchBar_EQC0FA8$lambda$24$lambda$23(Function1 arg1) {
        arg1.invoke(Boolean.valueOf(false));
        return Unit.INSTANCE;
    }

    static final Unit DockedSearchBar_EQC0FA8$lambda$25(Function2 arg13, boolean arg14, Function1 arg15, Modifier arg16, Shape arg17, SearchBarColors arg18, float arg19, float arg20, Function3 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        SearchBarKt.DockedSearchBar-EQC0FA8(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    static final Unit DockedSearchBar_eWTbjVg$lambda$29(String arg21, Function1 arg22, Function1 arg23, boolean arg24, Function1 arg25, Modifier arg26, boolean arg27, Function2 arg28, Function2 arg29, Function2 arg30, Shape arg31, SearchBarColors arg32, float arg33, float arg34, MutableInteractionSource arg35, Function3 arg36, int arg37, int arg38, int arg39, Composer arg40, int arg41) {
        SearchBarKt.DockedSearchBar-eWTbjVg(arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg40, RecomposeScopeImplKt.updateChangedFlags(arg37 | 1), RecomposeScopeImplKt.updateChangedFlags(arg38), arg39);
        return Unit.INSTANCE;
    }

    public static final void ExpandedDockedSearchBar-qKj4JfE(SearchBarState arg24, Function2 arg25, Modifier arg26, Shape arg27, SearchBarColors arg28, float arg29, float arg30, PopupProperties arg31, Function3 arg32, Composer arg33, int arg34, int arg35) {
        Modifier v3_3;
        CoroutineScope v11_2;
        ScopeUpdateScope v12_3;
        float v7_2;
        PopupProperties v8_1;
        int v0_2;
        Shape v4_1;
        SearchBarColors v5_1;
        Composer v12_2;
        float v6_1;
        Modifier v2_1;
        Function3 v3;
        int v16;
        PopupProperties v15_1;
        int v14;
        int v13;
        float v12_1;
        int v12;
        SearchBarColors v9_1;
        int v9;
        Shape v7_1;
        Modifier v6;
        int v4;
        int v2;
        SearchBarState v1 = arg24;
        int v10 = arg34;
        int v11 = arg35;
        Composer v5 = arg33.startRestartGroup(0xBD2DF1DB);
        ComposerKt.sourceInformation(v5, "C(ExpandedDockedSearchBar)N(state,inputField,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,properties,content)439@21817L380,450@22215L24,454@22329L47,456@22417L1212,452@22245L1384:SearchBar.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v2 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v2 = v5.changed(v1) ? 4 : 2;
            v2 |= v10;
        }
        else {
            v2 = v10;
        }

        if((v11 & 2) != 0) {
            v2 |= 0x30;
        }
        else {
            Function2 v8 = arg25;
            if((v10 & 0x30) == 0) {
                v4 = v5.changedInstance(v8) ? 0x20 : 16;
                v2 |= v4;
            }
        }

        v4 = v11 & 4;
        if(v4 != 0) {
            v2 |= 0x180;
            goto label_50;
        }
        else if((v10 & 0x180) == 0) {
            v6 = arg26;
            int v7 = v5.changed(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_50:
            v6 = arg26;
        }

        if((v10 & 0xC00) == 0) {
            if((v11 & 8) == 0) {
                v7_1 = arg27;
                if(v5.changed(v7_1)) {
                    v9 = 0x800;
                }
                else {
                    goto label_61;
                }
            }
            else {
                v7_1 = arg27;
            label_61:
                v9 = 0x400;
            }

            v2 |= v9;
        }
        else {
            v7_1 = arg27;
        }

        if((v10 & 0x6000) == 0) {
            if((v11 & 16) == 0) {
                v9_1 = arg28;
                if(v5.changed(v9_1)) {
                    v12 = 0x4000;
                }
                else {
                    goto label_75;
                }
            }
            else {
                v9_1 = arg28;
            label_75:
                v12 = 0x2000;
            }

            v2 |= v12;
        }
        else {
            v9_1 = arg28;
        }

        int v21 = v11 & 0x20;
        v12 = 0x30000;
        if(v21 != 0) {
            v2 |= v12;
            goto label_94;
        }
        else if((v12 & v10) == 0) {
            v12_1 = arg29;
            v13 = v5.changed(v12_1) ? 0x20000 : 0x10000;
            v2 |= v13;
        }
        else {
        label_94:
            v12_1 = arg29;
        }

        int v22 = v11 & 0x40;
        v13 = 0x180000;
        if(v22 != 0) {
            v2 |= v13;
        }
        else if((v13 & v10) == 0) {
            v14 = v5.changed(arg30) ? 0x100000 : 0x80000;
            v2 |= v14;
        }

        v14 = v11 & 0x80;
        int v15 = 0xC00000;
        if(v14 != 0) {
            v2 |= v15;
            goto label_126;
        }
        else if((v15 & v10) == 0) {
            v15_1 = arg31;
            v16 = v5.changed(v15_1) ? 0x800000 : 0x400000;
            v2 |= v16;
        }
        else {
        label_126:
            v15_1 = arg31;
        }

        v16 = 0x6000000;
        if((v11 & 0x100) != 0) {
            v2 |= v16;
            goto label_142;
        }
        else if((v10 & v16) == 0) {
            v3 = arg32;
            v16 = v5.changedInstance(v3) ? 0x4000000 : 0x2000000;
            v2 |= v16;
        }
        else {
        label_142:
            v3 = arg32;
        }

        int v23 = 0;
        boolean v0 = (v2 & 0x2492493) != 0x2492492 ? true : false;
        if(v5.shouldExecute(v0, v2 & 1)) {
            v5.startDefaults();
            ComposerKt.sourceInformation(v5, "429@21409L11,430@21470L8");
            int v1_1 = 0xFFFF1FFF;
            if((v10 & 1) == 0 || (v5.getDefaultsInvalid())) {
                if(v4 != 0) {
                    Companion v6_2 = Modifier.Companion;
                }

                if((v11 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                    v7_1 = SearchBarDefaults.INSTANCE.getDockedShape(v5, 6);
                }

                if((v11 & 16) != 0) {
                    v4 = 1;
                    v0_2 = v14;
                    Composer v18 = v5;
                    v5_1 = SearchBarDefaults.INSTANCE.colors-Klgx-Pg(0, 0, null, v18, 0xC00, 7);
                    v12_2 = v18;
                    v2 &= v1_1;
                }
                else {
                    v12_2 = v5;
                    v4 = 1;
                    v0_2 = v14;
                    v5_1 = v9_1;
                }

                float v1_2 = v21 != 0 ? SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM() : arg29;
                float v9_2 = v22 != 0 ? SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM() : arg30;
                if(v0_2 != 0) {
                    v0_2 = v4;
                    v4_1 = v7_1;
                    v7_2 = v9_2;
                    v8_1 = new PopupProperties(true, false, false, false, 6, null);
                }
                else {
                    v8_1 = arg31;
                    v0_2 = v4;
                    v4_1 = v7_1;
                    v7_2 = v9_2;
                }

                v9 = v2;
                v2_1 = v6;
                v6_1 = v1_2;
            }
            else {
                v5.skipToGroupEnd();
                if((v11 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                if((v11 & 16) != 0) {
                    v2 &= v1_1;
                }

                SearchBarColors v0_1 = v9_1;
                v9 = v2;
                v2_1 = v6;
                v6_1 = v12_1;
                v12_2 = v5;
                v5_1 = v0_1;
                v4_1 = v7_1;
                v0_2 = 1;
                v8_1 = v15_1;
                v7_2 = arg30;
            }

            v12_2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xBD2DF1DB, v9, -1, "androidx.compose.material3.ExpandedDockedSearchBar (SearchBar.kt:435)");
            }

            if(!SearchBarKt.isExpanded(arg24)) {
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }

                v12_3 = v12_2.endRestartGroup();
                if(v12_3 == null) {
                    return;
                }

                SearchBarKt$$ExternalSyntheticLambda23 v0_3 = new SearchBarKt$$ExternalSyntheticLambda23(arg24, arg25, v2_1, v4_1, v5_1, v6_1, v7_2, v8_1, v3, v10, v11);
                goto label_263;
            }

            v1 = arg24;
            v15_1 = v8_1;
            String v8_2 = "CC(remember):SearchBar.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v12_2, 695809367, v8_2);
            int v3_1 = v9 & 14;
            v13 = v3_1 == 4 ? v0_2 : 0;
            Object v10_1 = v12_2.rememberedValue();
            if(v13 != 0 || v10_1 == Composer.Companion.getEmpty()) {
                SearchBarKt$ExpandedDockedSearchBar$positionProvider$1$1 v10_2 = new SearchBarKt$ExpandedDockedSearchBar$positionProvider$1$1(v1);
                v12_2.updateRememberedValue(v10_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v12_2);
            ComposerKt.sourceInformationMarkerStart(v12_2, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v12_2, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
            Object v11_1 = v12_2.rememberedValue();
            if(v11_1 == Composer.Companion.getEmpty()) {
                v11_2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v12_2);
                v12_2.updateRememberedValue(v11_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v12_2);
            ComposerKt.sourceInformationMarkerEnd(v12_2);
            ComposerKt.sourceInformationMarkerStart(v12_2, 0x2979740A, v8_2);
            boolean v8_3 = v12_2.changedInstance(v11_2);
            if(v3_1 == 4) {
                v23 = v0_2;
            }

            v3_1 = (((int)v8_3)) | v23;
            Object v8_4 = v12_2.rememberedValue();
            if(v3_1 != 0 || v8_4 == Composer.Companion.getEmpty()) {
                SearchBarKt$$ExternalSyntheticLambda24 v8_5 = new SearchBarKt$$ExternalSyntheticLambda24(v11_2, v1);
                v12_2.updateRememberedValue(v8_5);
            }

            v11_1 = v8_4;
            ComposerKt.sourceInformationMarkerEnd(v12_2);
            boolean v13_1 = ((boolean)v0_2);
            Shape v3_2 = v4_1;
            SearchBarColors v4_2 = v5_1;
            Modifier v0_4 = v2_1;
            Shape v8_6 = v3_2;
            SearchBarColors v14_1 = v4_2;
            float v16_1 = v6_1;
            float v17 = v7_2;
            v5 = v12_2;
            AndroidPopup_androidKt.Popup(v10_1, v11_1, v15_1, ComposableLambdaKt.rememberComposableLambda(0xEA5A57F9, v13_1, new SearchBarKt$ExpandedDockedSearchBar$3(v1, v2_1, v3_2, v4_2, v6_1, v7_2, arg32, arg25), v12_2, 54), v5, v9 >> 15 & 0x380 | 0xC00, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_3 = v0_4;
            v12_2 = v5;
            v4_1 = v8_6;
            v5_1 = v14_1;
            v8_1 = v15_1;
            v6_1 = v16_1;
            v7_2 = v17;
            goto label_365;
        }
        else {
            v5.skipToGroupEnd();
            v8_1 = arg31;
            v12_2 = v5;
            v3_3 = v6;
            v4_1 = v7_1;
            v5_1 = v9_1;
            v6_1 = arg29;
            v7_2 = arg30;
        label_365:
            v12_3 = v12_2.endRestartGroup();
            if(v12_3 == null) {
                return;
            }

            SearchBarKt$$ExternalSyntheticLambda25 v0_5 = new SearchBarKt$$ExternalSyntheticLambda25(arg24, arg25, v3_3, v4_1, v5_1, v6_1, v7_2, v8_1, arg32, arg34, arg35);
        label_263:
            v12_3.updateScope(((Function2)v0_5));
            return;
        }
    }

    static final Unit ExpandedDockedSearchBar_qKj4JfE$lambda$10(SearchBarState arg13, Function2 arg14, Modifier arg15, Shape arg16, SearchBarColors arg17, float arg18, float arg19, PopupProperties arg20, Function3 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        SearchBarKt.ExpandedDockedSearchBar-qKj4JfE(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    static final Unit ExpandedDockedSearchBar_qKj4JfE$lambda$13$lambda$12(CoroutineScope arg8, SearchBarState arg9) {
        BuildersKt.launch$default(arg8, null, null, new SearchBarKt$ExpandedDockedSearchBar$2$1$1(arg9, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit ExpandedDockedSearchBar_qKj4JfE$lambda$14(SearchBarState arg13, Function2 arg14, Modifier arg15, Shape arg16, SearchBarColors arg17, float arg18, float arg19, PopupProperties arg20, Function3 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        SearchBarKt.ExpandedDockedSearchBar-qKj4JfE(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    public static final void ExpandedFullScreenSearchBar-_UtchM0(SearchBarState arg24, Function2 arg25, Modifier arg26, Shape arg27, SearchBarColors arg28, float arg29, float arg30, Function2 arg31, DialogProperties arg32, Function3 arg33, Composer arg34, int arg35, int arg36) {
        Composer v8_4;
        ScopeUpdateScope v13_1;
        DialogProperties v9_2;
        float v7_1;
        Composer v10_2;
        Function2 v8_2;
        float v6_2;
        SearchBarColors v5_2;
        Shape v4_1;
        Modifier v3_1;
        boolean v11_1;
        Companion v3_3;
        SearchBarKt$ExpandedFullScreenSearchBar$1 v8_3;
        Function2 v4_3;
        Shape v20_1;
        Modifier v0_3;
        int v19;
        int v18;
        Function2 v10_1;
        float v9_1;
        int v9;
        float v8_1;
        int v8;
        SearchBarColors v6_1;
        int v6;
        Shape v5_1;
        Modifier v4;
        int v3;
        Function2 v14;
        int v2;
        SearchBarState v1 = arg24;
        int v11 = arg35;
        int v12 = arg36;
        Composer v7 = arg34.startRestartGroup(-909632031);
        ComposerKt.sourceInformation(v7, "C(ExpandedFullScreenSearchBar)N(state,inputField,modifier,collapsedShape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,properties,content)356@17952L24,359@18032L56,361@18129L1354,358@17982L1501:SearchBar.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v2 = v11 | 6;
        }
        else if((v11 & 6) == 0) {
            v2 = v7.changed(v1) ? 4 : 2;
            v2 |= v11;
        }
        else {
            v2 = v11;
        }

        if((v12 & 2) != 0) {
            v2 |= 0x30;
            v14 = arg25;
        }
        else {
            v14 = arg25;
            if((v11 & 0x30) == 0) {
                v3 = v7.changedInstance(v14) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        v3 = v12 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
            goto label_50;
        }
        else if((v11 & 0x180) == 0) {
            v4 = arg26;
            int v5 = v7.changed(v4) ? 0x100 : 0x80;
            v2 |= v5;
        }
        else {
        label_50:
            v4 = arg26;
        }

        if((v11 & 0xC00) == 0) {
            if((v12 & 8) == 0) {
                v5_1 = arg27;
                if(v7.changed(v5_1)) {
                    v6 = 0x800;
                }
                else {
                    goto label_61;
                }
            }
            else {
                v5_1 = arg27;
            label_61:
                v6 = 0x400;
            }

            v2 |= v6;
        }
        else {
            v5_1 = arg27;
        }

        if((v11 & 0x6000) == 0) {
            if((v12 & 16) == 0) {
                v6_1 = arg28;
                if(v7.changed(v6_1)) {
                    v8 = 0x4000;
                }
                else {
                    goto label_75;
                }
            }
            else {
                v6_1 = arg28;
            label_75:
                v8 = 0x2000;
            }

            v2 |= v8;
        }
        else {
            v6_1 = arg28;
        }

        int v15 = v12 & 0x20;
        int v16 = 0x30000;
        if(v15 != 0) {
            v2 |= v16;
            goto label_94;
        }
        else if((v11 & v16) == 0) {
            v8_1 = arg29;
            v9 = v7.changed(v8_1) ? 0x20000 : 0x10000;
            v2 |= v9;
        }
        else {
        label_94:
            v8_1 = arg29;
        }

        int v17 = v12 & 0x40;
        v9 = 0x180000;
        if(v17 != 0) {
            v2 |= v9;
            goto label_110;
        }
        else if((v9 & v11) == 0) {
            v9_1 = arg30;
            int v10 = v7.changed(v9_1) ? 0x100000 : 0x80000;
            v2 |= v10;
        }
        else {
        label_110:
            v9_1 = arg30;
        }

        if((0xC00000 & v11) == 0) {
            if((v12 & 0x80) == 0) {
                v10_1 = arg31;
                if(v7.changedInstance(v10_1)) {
                    v18 = 0x800000;
                }
                else {
                    goto label_122;
                }
            }
            else {
                v10_1 = arg31;
            label_122:
                v18 = 0x400000;
            }

            v2 |= v18;
        }
        else {
            v10_1 = arg31;
        }

        int v13 = v12 & 0x100;
        v18 = 0x6000000;
        if(v13 != 0) {
            v2 |= v18;
        }
        else {
            DialogProperties v0 = arg32;
            if((v11 & v18) == 0) {
                v19 = v7.changed(v0) ? 0x4000000 : 0x2000000;
                v2 |= v19;
            }
        }

        v19 = 0x30000000;
        if((v12 & 0x200) != 0) {
            v2 |= v19;
        }
        else if((v11 & v19) == 0) {
            v19 = v7.changedInstance(arg33) ? 0x20000000 : 0x10000000;
            v2 |= v19;
        }

        v19 = 0;
        int v20 = v3;
        boolean v0_1 = (v2 & 306783379) != 306783378 ? true : false;
        if(v7.shouldExecute(v0_1, v2 & 1)) {
            v7.startDefaults();
            ComposerKt.sourceInformation(v7, "346@17492L15,347@17557L8");
            int v1_1 = 0xFE3FFFFF;
            int v21 = 0xFFFF1FFF;
            if((v11 & 1) == 0 || (v7.getDefaultsInvalid())) {
                if(v20 != 0) {
                    Companion v0_2 = Modifier.Companion;
                }
                else {
                    v0_3 = v4;
                }

                if((v12 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                    v20_1 = SearchBarDefaults.INSTANCE.getInputFieldShape(v7, 6);
                }
                else {
                    v20_1 = v5_1;
                }

                int v22 = v2;
                if((v12 & 16) != 0) {
                    v11_1 = true;
                    v10_2 = v7;
                    v22 &= v21;
                    v6_1 = SearchBarDefaults.INSTANCE.colors-Klgx-Pg(0, 0, null, v7, 0xC00, 7);
                }
                else {
                    v11_1 = true;
                    v10_2 = v7;
                }

                float v2_1 = v15 != 0 ? SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM() : arg29;
                float v3_2 = v17 != 0 ? SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM() : arg30;
                if((v12 & 0x80) != 0) {
                    SearchBarKt$ExpandedFullScreenSearchBar$1 v4_2 = SearchBarKt$ExpandedFullScreenSearchBar$1.INSTANCE;
                    v22 &= v1_1;
                }
                else {
                    v4_3 = arg31;
                }

                v9_2 = v13 != 0 ? new DialogProperties(false, false, false, 7, null) : arg32;
                v7_1 = v3_2;
                v8_3 = ((SearchBarKt$ExpandedFullScreenSearchBar$1)v4_3);
                v5_2 = v6_1;
                v4_1 = v20_1;
                v13 = v22;
                v3_3 = ((Companion)v0_3);
                v6_2 = v2_1;
            }
            else {
                v7.skipToGroupEnd();
                if((v12 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v2 &= v21;
                }

                if((v12 & 0x80) != 0) {
                    v2 &= v1_1;
                }

                v13 = v2;
                v11_1 = true;
                v3_1 = v4;
                v4_1 = v5_1;
                v5_2 = v6_1;
                v6_2 = v8_1;
                v8_2 = v10_1;
                v10_2 = v7;
                v7_1 = v9_1;
                v9_2 = arg32;
            }

            v10_2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-909632031, v13, -1, "androidx.compose.material3.ExpandedFullScreenSearchBar (SearchBar.kt:353)");
            }

            if(!SearchBarKt.isExpanded(arg24)) {
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }

                v13_1 = v10_2.endRestartGroup();
                if(v13_1 == null) {
                    return;
                }

                SearchBarKt$$ExternalSyntheticLambda15 v0_4 = new SearchBarKt$$ExternalSyntheticLambda15(arg24, v14, ((Modifier)v3_3), v4_1, v5_2, v6_2, v7_1, ((Function2)v8_3), v9_2, arg33, arg35, v12);
                goto label_296;
            }

            v1 = arg24;
            DialogProperties v12_1 = v9_2;
            ComposerKt.sourceInformationMarkerStart(v10_2, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v10_2, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
            Object v0_5 = v10_2.rememberedValue();
            if(v0_5 == Composer.Companion.getEmpty()) {
                CoroutineScope v0_6 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v10_2);
                v10_2.updateRememberedValue(v0_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v10_2);
            ComposerKt.sourceInformationMarkerEnd(v10_2);
            ComposerKt.sourceInformationMarkerStart(v10_2, 2016970937, "CC(remember):SearchBar.kt#9igjgp");
            boolean v2_2 = v10_2.changedInstance(v0_5);
            if((v13 & 14) == 4) {
                v19 = ((int)v11_1);
            }

            Object v9_3 = v10_2.rememberedValue();
            if(((((int)v2_2)) | v19) != 0 || v9_3 == Composer.Companion.getEmpty()) {
                SearchBarKt$$ExternalSyntheticLambda16 v9_4 = new SearchBarKt$$ExternalSyntheticLambda16(((CoroutineScope)v0_5), v1);
                v10_2.updateRememberedValue(v9_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v10_2);
            Modifier v2_3 = ((Modifier)v3_3);
            v0_3 = v2_3;
            v20_1 = v4_1;
            SearchBarColors v15_1 = v5_2;
            float v17_1 = v6_2;
            float v18_1 = v7_1;
            Function2 v19_1 = ((Function2)v8_3);
            DialogProperties v3_4 = v12_1;
            BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog(v9_3, null, v3_4, false, false, ComposableLambdaKt.rememberComposableLambda(0x25422BF1, v11_1, new SearchBarKt$ExpandedFullScreenSearchBar$4(v1, v2_3, v4_1, v5_2, v6_2, v7_1, ((Function2)v8_3), arg33, arg25), v10_2, 54), v10_2, v13 >> 18 & 0x380 | v16, 26);
            v8_4 = v10_2;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v9_2 = v3_4;
            v10_2 = v8_4;
            v5_2 = v15_1;
            v6_2 = v17_1;
            v7_1 = v18_1;
            v8_2 = v19_1;
            v4_1 = v20_1;
            v3_1 = v0_3;
            goto label_389;
        }
        else {
            v8_4 = v7;
            v8_4.skipToGroupEnd();
            v7_1 = arg30;
            v9_2 = arg32;
            v3_1 = v4;
            v4_1 = v5_1;
            v5_2 = v6_1;
            v10_2 = v8_4;
            v6_2 = arg29;
            v8_2 = arg31;
        label_389:
            v13_1 = v10_2.endRestartGroup();
            if(v13_1 == null) {
                return;
            }

            SearchBarKt$$ExternalSyntheticLambda17 v0_7 = new SearchBarKt$$ExternalSyntheticLambda17(arg24, arg25, v3_1, v4_1, v5_2, v6_2, v7_1, v8_2, v9_2, arg33, arg35, arg36);
        label_296:
            v13_1.updateScope(((Function2)v0_7));
            return;
        }
    }

    static final Unit ExpandedFullScreenSearchBar__UtchM0$lambda$6(SearchBarState arg14, Function2 arg15, Modifier arg16, Shape arg17, SearchBarColors arg18, float arg19, float arg20, Function2 arg21, DialogProperties arg22, Function3 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        SearchBarKt.ExpandedFullScreenSearchBar-_UtchM0(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit ExpandedFullScreenSearchBar__UtchM0$lambda$8$lambda$7(CoroutineScope arg8, SearchBarState arg9) {
        BuildersKt.launch$default(arg8, null, null, new SearchBarKt$ExpandedFullScreenSearchBar$3$1$1(arg9, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit ExpandedFullScreenSearchBar__UtchM0$lambda$9(SearchBarState arg14, Function2 arg15, Modifier arg16, Shape arg17, SearchBarColors arg18, float arg19, float arg20, Function2 arg21, DialogProperties arg22, Function3 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        SearchBarKt.ExpandedFullScreenSearchBar-_UtchM0(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    private static final void FullScreenSearchBarLayout-EQC0FA8(SearchBarState arg27, PredictiveBackState arg28, Function2 arg29, Modifier arg30, Shape arg31, SearchBarColors arg32, float arg33, float arg34, WindowInsets arg35, Function3 arg36, Composer arg37, int arg38) {
        Composer v1_4;
        SearchBarKt$$ExternalSyntheticLambda7 v6_4;
        MutableWindowInsets v1_3;
        int v14_1;
        int v26;
        Object v5_1;
        Object v16_1;
        MutableState v2_2;
        State v0_1;
        int v16;
        int v3_1;
        int v1;
        SearchBarState v4 = arg27;
        PredictiveBackState v6 = arg28;
        Function2 v7 = arg29;
        Modifier v8 = arg30;
        WindowInsets v9 = arg35;
        Function3 v10 = arg36;
        int v11 = arg38;
        Composer v12 = arg37.startRestartGroup(-740838201);
        ComposerKt.sourceInformation(v12, "C(FullScreenSearchBarLayout)N(state,predictiveBackState,inputField,modifier,collapsedShape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,content)2399@110650L57,2401@110747L64,2410@111159L64,2419@111546L7,2420@111598L15,2422@111646L1042,2447@112954L34,2453@113205L120,2484@114348L4812,2450@113110L6050:SearchBar.kt#uh7d8r");
        if((v11 & 6) == 0) {
            v1 = v12.changed(v4) ? 4 : 2;
            v1 |= v11;
        }
        else {
            v1 = v11;
        }

        if((v11 & 0x30) == 0) {
            boolean v3 = (v11 & 0x40) == 0 ? v12.changed(v6) : v12.changedInstance(v6);
            v3_1 = v3 ? 0x20 : 16;
            v1 |= v3_1;
        }

        if((v11 & 0x180) == 0) {
            v3_1 = v12.changedInstance(v7) ? 0x100 : 0x80;
            v1 |= v3_1;
        }

        if((v11 & 0xC00) == 0) {
            v3_1 = v12.changed(v8) ? 0x800 : 0x400;
            v1 |= v3_1;
        }

        Shape v5 = arg31;
        if((v11 & 0x6000) == 0) {
            v3_1 = v12.changed(v5) ? 0x4000 : 0x2000;
            v1 |= v3_1;
        }

        SearchBarColors v14 = arg32;
        if((0x30000 & v11) == 0) {
            v3_1 = v12.changed(v14) ? 0x20000 : 0x10000;
            v1 |= v3_1;
        }

        float v15 = arg33;
        if((0x180000 & v11) == 0) {
            v3_1 = v12.changed(v15) ? 0x100000 : 0x80000;
            v1 |= v3_1;
        }

        if((0xC00000 & v11) == 0) {
            v16 = v12.changed(arg34) ? 0x800000 : 0x400000;
            v1 |= v16;
        }

        if((v11 & 0x6000000) == 0) {
            v16 = v12.changed(v9) ? 0x4000000 : 0x2000000;
            v1 |= v16;
        }

        if((v11 & 0x30000000) == 0) {
            v16 = v12.changedInstance(v10) ? 0x20000000 : 0x10000000;
            v1 |= v16;
        }

        boolean v2 = (v1 & 306783379) != 306783378 ? true : false;
        if(v12.shouldExecute(v2, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-740838201, v1, -1, "androidx.compose.material3.FullScreenSearchBarLayout (SearchBar.kt:2398)");
            }

            String v13 = "CC(remember):SearchBar.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v12, 1019074080, v13);
            Object v0 = v12.rememberedValue();
            if(v0 == Composer.Companion.getEmpty()) {
                v0_1 = SnapshotStateKt.derivedStateOf(new SearchBarKt$$ExternalSyntheticLambda5(v6));
                v12.updateRememberedValue(v0_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerStart(v12, 1019077191, v13);
            Object v2_1 = v12.rememberedValue();
            Object v6_1 = null;
            if(v2_1 == Composer.Companion.getEmpty()) {
                v2_2 = SnapshotStateKt.mutableStateOf$default(v6_1, ((SnapshotMutationPolicy)v6_1), 2, v6_1);
                v12.updateRememberedValue(v2_2);
            }

            Object v11_1 = v2_2;
            ComposerKt.sourceInformationMarkerEnd(v12);
            BackEventProgress v2_3 = SearchBarKt.FullScreenSearchBarLayout_EQC0FA8$lambda$55(v0_1);
            if((v2_3 instanceof InProgress)) {
                if(((MutableState)v11_1).getValue() == null) {
                    ((MutableState)v11_1).setValue(v2_3);
                }
            }
            else if(Intrinsics.areEqual(v2_3, NotRunning.INSTANCE)) {
                ((MutableState)v11_1).setValue(null);
            }
            else {
                if(Intrinsics.areEqual(v2_3, Completed.INSTANCE)) {
                    goto label_165;
                }

                goto label_533;
            }

        label_165:
            ComposerKt.sourceInformationMarkerStart(v12, 1019090375, v13);
            v2_1 = v12.rememberedValue();
            if(v2_1 == Composer.Companion.getEmpty()) {
                v16_1 = v0_1;
                v2_2 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                v12.updateRememberedValue(v2_2);
            }
            else {
                v16_1 = v0_1;
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            BackEventProgress v0_2 = SearchBarKt.FullScreenSearchBarLayout_EQC0FA8$lambda$55(((State)v16_1));
            if((v0_2 instanceof InProgress)) {
                v2_2.setValue(v0_2);
            }
            else if(Intrinsics.areEqual(v0_2, NotRunning.INSTANCE)) {
                v2_2.setValue(null);
            }
            else {
                if(Intrinsics.areEqual(v0_2, Completed.INSTANCE)) {
                    goto label_193;
                }

                goto label_530;
            }

        label_193:
            ProvidableCompositionLocal v0_3 = CompositionLocalsKt.getLocalDensity();
            v16 = v1;
            ComposerKt.sourceInformationMarkerStart(v12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v0 = v12.consume(((CompositionLocal)v0_3));
            ComposerKt.sourceInformationMarkerEnd(v12);
            Shape v1_1 = SearchBarDefaults.INSTANCE.getFullScreenShape(v12, 6);
            int v25 = 6;
            ComposerKt.sourceInformationMarkerStart(v12, 1019106937, v13);
            int v6_2 = v12.changed(v0) | v12.changed(v1_1);
            Object v20 = v0;
            v0 = v12.rememberedValue();
            if(v6_2 != 0 || v0 == Composer.Companion.getEmpty()) {
                Object v3_2 = v2_2;
                Shape v2_4 = v1_1;
                v1_1 = v5;
                v5_1 = v3_2;
                v26 = v16;
                v14_1 = 1;
                GenericShape v6_3 = new GenericShape(new SearchBarKt$$ExternalSyntheticLambda6(v1_1, v2_4, v20, v4, ((MutableState)v5_1)));
                v12.updateRememberedValue(v6_3);
                GenericShape v0_4 = v6_3;
            }
            else {
                v5_1 = v2_2;
                v26 = v16;
                v14_1 = 1;
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerStart(v12, 0x3CBEF609, v13);
            Object v1_2 = v12.rememberedValue();
            if(v1_2 == Composer.Companion.getEmpty()) {
                v1_3 = new MutableWindowInsets(null, v14_1, null);
                v12.updateRememberedValue(v1_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            WindowInsets v2_5 = WindowInsetsKt.only-bOOhFvg(v1_3.getInsets(), WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Companion.getHorizontal-JoeWqyM(), WindowInsetsSides.Companion.getBottom-JoeWqyM()));
            ComposerKt.sourceInformationMarkerStart(v12, 0x3CBF15BF, v13);
            v3_1 = (v26 & 0xE000000) == 0x4000000 ? v14_1 : 0;
            v6_1 = v12.rememberedValue();
            if(v3_1 != 0 || v6_1 == Composer.Companion.getEmpty()) {
                v6_4 = new SearchBarKt$$ExternalSyntheticLambda7(v1_3, v9);
                v12.updateRememberedValue(v6_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            Modifier v3_3 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(v8, ((Function1)v6_4)), v9);
            ComposerKt.sourceInformationMarkerStart(v12, 0x3CBFB6F3, v13);
            boolean v6_5 = v12.changed(v5_1);
            int v13_1 = (v26 & 14) == 4 ? 1 : 0;
            v6_2 = (((int)v6_5)) | v13_1 | v12.changed(v11_1);
            Object v13_2 = v12.rememberedValue();
            if(v6_2 != 0 || v13_2 == Composer.Companion.getEmpty()) {
                SearchBarKt$FullScreenSearchBarLayout$2$1 v13_3 = new SearchBarKt$FullScreenSearchBarLayout$2$1(((MutableState)v5_1), v4, v1_3, ((MutableState)v11_1));
                v12.updateRememberedValue(v13_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            String v5_2 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v12, -1323940314, v5_2);
            v11 = ComposablesKt.getCurrentCompositeKeyHash(v12, 0);
            CompositionLocalMap v6_6 = v12.getCurrentCompositionLocalMap();
            v3_3 = ComposedModifierKt.materializeModifier(v12, v3_3);
            Function0 v14_2 = ComposeUiNode.Companion.getConstructor();
            v16_1 = v0;
            String v0_5 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v12, 0xD6BD0031, v0_5);
            if(!(v12.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v12.startReusableNode();
            if(v12.getInserting()) {
                v12.createNode(v14_2);
            }
            else {
                v12.useNode();
            }

            v1_4 = Updater.constructor-impl(v12);
            Updater.set-impl(v1_4, v13_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v1_4, v6_6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v6_7 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v1_4.getInserting()) || !Intrinsics.areEqual(v1_4.rememberedValue(), Integer.valueOf(v11))) {
                v1_4.updateRememberedValue(Integer.valueOf(v11));
                v1_4.apply(Integer.valueOf(v11), v6_7);
            }

            Updater.set-impl(v1_4, v3_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v12, 0xB1C5EBBB, "C2461@113581L17,2458@113410L297,2471@113910L38,2467@113721L372,2478@114193L17,2477@114107L223:SearchBar.kt#uh7d8r");
            Modifier v1_5 = PaddingKt.padding(LayoutIdKt.layoutId(Modifier.Companion, "InputField"), WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(v2_5, WindowInsetsSides.Companion.getHorizontal-JoeWqyM()), v12, 0));
            ComposerKt.sourceInformationMarkerStart(v12, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v3_4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(v12, -1323940314, v5_2);
            v11 = ComposablesKt.getCurrentCompositeKeyHash(v12, 0);
            v6_6 = v12.getCurrentCompositionLocalMap();
            v1_5 = ComposedModifierKt.materializeModifier(v12, v1_5);
            Function0 v13_4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v12, 0xD6BD0031, v0_5);
            if(!(v12.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v12.startReusableNode();
            if(v12.getInserting()) {
                v12.createNode(v13_4);
            }
            else {
                v12.useNode();
            }

            Composer v13_5 = Updater.constructor-impl(v12);
            Updater.set-impl(v13_5, v3_4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v13_5, v6_6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v3_5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v13_5.getInserting()) || !Intrinsics.areEqual(v13_5.rememberedValue(), Integer.valueOf(v11))) {
                v13_5.updateRememberedValue(Integer.valueOf(v11));
                v13_5.apply(Integer.valueOf(v11), v3_5);
            }

            Updater.set-impl(v13_5, v1_5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v12, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v12, 0x2A9AE8CD, "C2464@113681L12:SearchBar.kt#uh7d8r");
            v1 = v26 >> 6;
            v7.invoke(v12, Integer.valueOf(v1 & 14));
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            v12.endNode();
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            SurfaceKt.Surface-T9BRK9s(LayoutIdKt.layoutId(Modifier.Companion, "Surface"), v16_1, arg32.getContainerColor-0d7_KjU(), ColorSchemeKt.contentColorFor-ek8zF_U(arg32.getContainerColor-0d7_KjU(), v12, 0), arg33, arg34, null, ComposableSingletons$SearchBarKt.INSTANCE.getLambda$-1146652811$material3(), v12, 0xE000 & v1 | 0xC00006 | v1 & 0x70000, 0x40);
            v1_4 = v12;
            Modifier v2_6 = PaddingKt.padding(LayoutIdKt.layoutId(Modifier.Companion, "Content"), WindowInsetsKt.asPaddingValues(v2_5, v1_4, 0));
            ComposerKt.sourceInformationMarkerStart(v1_4, 0xE32F0E82, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            v3_4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), v1_4, 0);
            ComposerKt.sourceInformationMarkerStart(v1_4, -1323940314, v5_2);
            int v4_1 = ComposablesKt.getCurrentCompositeKeyHash(v1_4, 0);
            CompositionLocalMap v5_3 = v1_4.getCurrentCompositionLocalMap();
            v2_6 = ComposedModifierKt.materializeModifier(v1_4, v2_6);
            Function0 v6_8 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v1_4, 0xD6BD0031, v0_5);
            if(!(v1_4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v1_4.startReusableNode();
            if(v1_4.getInserting()) {
                v1_4.createNode(v6_8);
            }
            else {
                v1_4.useNode();
            }

            Composer v0_6 = Updater.constructor-impl(v1_4);
            Updater.set-impl(v0_6, v3_4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v0_6, v5_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            v3_5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v0_6.getInserting()) || !Intrinsics.areEqual(v0_6.rememberedValue(), Integer.valueOf(v4_1))) {
                v0_6.updateRememberedValue(Integer.valueOf(v4_1));
                v0_6.apply(Integer.valueOf(v4_1), v3_5);
            }

            Updater.set-impl(v0_6, v2_6, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v1_4, 0xE9125B67, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance v0_7 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(v1_4, 0x97C3E081, "C2480@114244L46,2481@114307L9:SearchBar.kt#uh7d8r");
            DividerKt.HorizontalDivider-9IZ8Weo(null, 0f, arg32.getDividerColor-0d7_KjU(), v1_4, 0, 3);
            v10.invoke(v0_7, v1_4, Integer.valueOf(v25 | v26 >> 24 & 0x70));
            ComposerKt.sourceInformationMarkerEnd(v1_4);
            ComposerKt.sourceInformationMarkerEnd(v1_4);
            v1_4.endNode();
            ComposerKt.sourceInformationMarkerEnd(v1_4);
            ComposerKt.sourceInformationMarkerEnd(v1_4);
            ComposerKt.sourceInformationMarkerEnd(v1_4);
            ComposerKt.sourceInformationMarkerEnd(v1_4);
            v1_4.endNode();
            ComposerKt.sourceInformationMarkerEnd(v1_4);
            ComposerKt.sourceInformationMarkerEnd(v1_4);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_538;
            }

            ComposerKt.traceEventEnd();
            goto label_538;
        label_530:
            throw new NoWhenBranchMatchedException();
        label_533:
            throw new NoWhenBranchMatchedException();
        }
        else {
            v1_4 = v12;
            v1_4.skipToGroupEnd();
        }

    label_538:
        ScopeUpdateScope v12_1 = v1_4.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new SearchBarKt$$ExternalSyntheticLambda8(arg27, arg28, v7, v8, arg31, arg32, arg33, arg34, v9, v10, arg38));
        }
    }

    static final BackEventProgress FullScreenSearchBarLayout_EQC0FA8$lambda$54$lambda$53(PredictiveBackState arg0) {
        return arg0.getValue();
    }

    private static final BackEventProgress FullScreenSearchBarLayout_EQC0FA8$lambda$55(State arg0) {
        return arg0.getValue();
    }

    static final Unit FullScreenSearchBarLayout_EQC0FA8$lambda$62$lambda$61(Shape arg4, Shape arg5, Density arg6, SearchBarState arg7, MutableState arg8, Path arg9, Size arg10, LayoutDirection arg11) {
        if(arg4 != RoundedCornerShapeKt.getCircleShape() || arg5 != RectangleShapeKt.getRectangleShape()) {
            if(arg7.getProgress() < 0.5f) {
            }
            else {
                arg4 = arg5;
            }

            OutlineKt.addOutline(arg9, arg4.createOutline-Pq9zytI(arg10.unbox-impl(), arg11, arg6));
        }
        else {
            float v4 = arg6.toPx-0680j_4(Dp.constructor-impl(SearchBarKt.SearchBarCornerRadius * Math.max(1f - arg7.getProgress(), SearchBarKt.transform(arg8.getValue()))));
            int v6 = 2;
            Direction v7 = null;
            if(Double.compare(((double)v4), 0.001) < 0) {
                Path.addRect$default(arg9, androidx.compose.ui.geometry.SizeKt.toRect-uvyYCjk(arg10.unbox-impl()), v7, v6, v7);
            }
            else {
                Path.addRoundRect$default(arg9, RoundRectKt.RoundRect-sniSvfs(androidx.compose.ui.geometry.SizeKt.toRect-uvyYCjk(arg10.unbox-impl()), CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(v4))) << 0x20 | (((long)Float.floatToRawIntBits(v4))) & 0xFFFFFFFFL)), v7, v6, v7);
            }
        }

        return Unit.INSTANCE;
    }

    static final Unit FullScreenSearchBarLayout_EQC0FA8$lambda$65$lambda$64(MutableWindowInsets arg0, WindowInsets arg1, WindowInsets arg2) {
        arg0.setInsets(WindowInsetsKt.exclude(arg1, arg2));
        return Unit.INSTANCE;
    }

    static final Unit FullScreenSearchBarLayout_EQC0FA8$lambda$70(SearchBarState arg13, PredictiveBackState arg14, Function2 arg15, Modifier arg16, Shape arg17, SearchBarColors arg18, float arg19, float arg20, WindowInsets arg21, Function3 arg22, int arg23, Composer arg24, int arg25) {
        SearchBarKt.FullScreenSearchBarLayout-EQC0FA8(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg24, RecomposeScopeImplKt.updateChangedFlags(arg23 | 1));
        return Unit.INSTANCE;
    }

    @Deprecated(message="Use overload which takes inputField as a parameter", replaceWith="<_subannotation>") public static final void SearchBar-WuY5d9Q(String arg36, Function1 arg37, Function1 arg38, boolean arg39, Function1 arg40, Modifier arg41, boolean arg42, Function2 arg43, Function2 arg44, Function2 arg45, Shape arg46, SearchBarColors arg47, float arg48, float arg49, WindowInsets arg50, MutableInteractionSource arg51, Function3 arg52, Composer arg53, int arg54, int arg55, int arg56) {
        Function2 v8_2;
        Shape v11_2;
        float v14_2;
        MutableInteractionSource v16_2;
        Function2 v9_1;
        boolean v7_4;
        SearchBarColors v12_2;
        Composer v0_4;
        WindowInsets v15_1;
        float v13_1;
        int v14_1;
        Shape v8_1;
        Composer v10_1;
        Function2 v23_1;
        boolean v22_1;
        Modifier v7_1;
        Function2 v24_1;
        MutableInteractionSource v26_1;
        WindowInsets v12_1;
        float v11_1;
        float v5_2;
        SearchBarColors v16_1;
        Function2 v25_1;
        WindowInsets v7_2;
        SearchBarColors v4_1;
        Shape v22_2;
        Companion v0_2;
        int v27;
        int v24;
        int v32;
        Function2 v3;
        Function2 v10;
        boolean v8;
        int v25;
        Modifier v6;
        int v18;
        String v13;
        int v4;
        int v0 = arg54;
        int v1 = arg55;
        int v2 = arg56;
        Composer v14 = arg53.startRestartGroup(0x59D2D0FE);
        ComposerKt.sourceInformation(v14, "C(SearchBar)N(query,onQueryChange,onSearch,active,onActiveChange,modifier,enabled,placeholder,leadingIcon,trailingIcon,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,interactionSource,content)1968@93682L591,1967@93650L925:SearchBar.kt#uh7d8r");
        if((v2 & 1) != 0) {
            v4 = v0 | 6;
            v13 = arg36;
        }
        else {
            v13 = arg36;
            if((v0 & 6) == 0) {
                v4 = v14.changed(v13) ? 4 : 2;
                v4 |= v0;
            }
            else {
                v4 = v0;
            }
        }

        if((v2 & 2) != 0) {
            v4 |= 0x30;
        }
        else {
            Function1 v15 = arg37;
            if((v0 & 0x30) == 0) {
                int v7 = v14.changedInstance(v15) ? 0x20 : 16;
                v4 |= v7;
            }
        }

        if((v2 & 4) != 0) {
            v4 |= 0x180;
        }
        else if((v0 & 0x180) == 0) {
            int v12 = v14.changedInstance(arg38) ? 0x100 : 0x80;
            v4 |= v12;
        }

        int v16 = 0x800;
        int v17 = 0x400;
        if((v2 & 8) != 0) {
            v4 |= 0xC00;
        }
        else if((v0 & 0xC00) == 0) {
            v18 = v14.changed(arg39) ? v16 : v17;
            v4 |= v18;
        }

        int v19 = 0x2000;
        int v20 = 0x4000;
        if((v2 & 16) != 0) {
            v4 |= 0x6000;
        }
        else if((v0 & 0x6000) == 0) {
            v18 = v14.changedInstance(arg40) ? v20 : v19;
            v4 |= v18;
        }

        v18 = v2 & 0x20;
        int v21 = 0x20000;
        int v22 = 0x10000;
        int v23 = 0x30000;
        if(v18 != 0) {
            v4 |= v23;
            v6 = arg41;
        }
        else {
            v6 = arg41;
            if((v0 & v23) == 0) {
                v25 = v14.changed(v6) ? v21 : v22;
                v4 |= v25;
            }
        }

        v25 = v2 & 0x40;
        int v26 = 0x180000;
        if(v25 != 0) {
            v4 |= v26;
            v8 = arg42;
        }
        else {
            v8 = arg42;
            if((v0 & v26) == 0) {
                int v28 = v14.changed(v8) ? 0x100000 : 0x80000;
                v4 |= v28;
            }
        }

        int v9 = v2 & 0x80;
        int v29 = 0xC00000;
        if(v9 != 0) {
            v4 |= v29;
            v10 = arg43;
        }
        else {
            v10 = arg43;
            if((v0 & v29) == 0) {
                int v30 = v14.changedInstance(v10) ? 0x800000 : 0x400000;
                v4 |= v30;
            }
        }

        int v11 = v2 & 0x100;
        int v31 = 0x6000000;
        if(v11 != 0) {
            v4 |= v31;
            v3 = arg44;
        }
        else {
            v3 = arg44;
            if((v0 & v31) == 0) {
                v32 = v14.changedInstance(v3) ? 0x4000000 : 0x2000000;
                v4 |= v32;
            }
        }

        v0 = v2 & 0x200;
        v32 = 0x30000000;
        if(v0 != 0) {
            v4 |= v32;
            goto label_165;
        }
        else if((arg54 & v32) == 0) {
            v32 = v0;
            int v33 = v14.changedInstance(arg45) ? 0x20000000 : 0x10000000;
            v4 |= v33;
        }
        else {
        label_165:
            v32 = v0;
        }

        if((v1 & 6) == 0) {
            v24 = (v2 & 0x400) != 0 || !v14.changed(arg46) ? 2 : 4;
            v24 |= v1;
        }
        else {
            v24 = v1;
        }

        if((v1 & 0x30) == 0) {
            v27 = (v2 & 0x800) != 0 || !v14.changed(arg47) ? 16 : 0x20;
            v24 |= v27;
        }

        v0 = v24;
        int v5 = v2 & 0x1000;
        if(v5 != 0) {
            v0 |= 0x180;
        }
        else {
            v24 = v0;
            if((v1 & 0x180) == 0) {
                v29 = v14.changed(arg48) ? 0x100 : 0x80;
                v24 |= v29;
            }

            v0 = v24;
        }

        v24 = v5;
        v5 = v2 & 0x2000;
        if(v5 != 0) {
            v27 = v0 | 0xC00;
        }
        else {
            v27 = v0;
            if((v1 & 0xC00) == 0) {
                if(v14.changed(arg49)) {
                }
                else {
                    v16 = v17;
                }

                v27 |= v16;
            }
        }

        if((v1 & 0x6000) == 0) {
            if((v2 & 0x4000) == 0 && (v14.changed(arg50))) {
                v19 = v20;
            }

            v27 |= v19;
        }

        v16 = v2 & 0x8000;
        if(v16 != 0) {
            v27 |= v23;
            goto label_260;
        }
        else if((v1 & v23) == 0) {
            v17 = v5;
            if(v14.changed(arg51)) {
            }
            else {
                v21 = v22;
            }

            v27 |= v21;
        }
        else {
        label_260:
            v17 = v5;
        }

        if((v2 & v22) != 0) {
            v27 |= v26;
        }
        else {
            Function3 v5_1 = arg52;
            if((v1 & v26) == 0) {
                v19 = v14.changedInstance(v5_1) ? 0x100000 : 0x80000;
                v27 |= v19;
            }
        }

        boolean v0_1 = (v4 & 306783379) != 306783378 || (v27 & 0x92493) != 0x92492 ? true : false;
        if(v14.shouldExecute(v0_1, v4 & 1)) {
            v14.startDefaults();
            ComposerKt.sourceInformation(v14, "1959@93276L15,1960@93341L8,1963@93522L12");
            v1 = 6;
            if((arg54 & 1) == 0 || (v14.getDefaultsInvalid())) {
                if(v18 != 0) {
                    v0_2 = Modifier.Companion;
                }
                else {
                    Modifier v0_3 = v6;
                }

                boolean v18_1 = v25 != 0 ? true : v8;
                Function2 v19_1 = null;
                Function2 v20_1 = v9 != 0 ? v19_1 : v10;
                if(v11 != 0) {
                    v3 = v19_1;
                }

                Function2 v21_1 = v32 != 0 ? v19_1 : arg45;
                if((v2 & 0x400) != 0) {
                    v27 &= -15;
                    v22_2 = SearchBarDefaults.INSTANCE.getInputFieldShape(v14, v1);
                }
                else {
                    v22_2 = arg46;
                }

                if((v2 & 0x800) != 0) {
                    Composer v35 = v14;
                    v14_1 = v4;
                    v10_1 = v35;
                    v4_1 = SearchBarDefaults.INSTANCE.colors-Klgx-Pg(0, 0, null, v10_1, 0xC00, 7);
                    v27 &= 0xFFFFFF8F;
                }
                else {
                    v10_1 = v14;
                    v14_1 = v4;
                    v4_1 = arg47;
                }

                v5_2 = v24 != 0 ? SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM() : arg48;
                float v6_1 = v17 != 0 ? SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM() : arg49;
                if((v2 & 0x4000) != 0) {
                    v7_2 = SearchBarDefaults.INSTANCE.getWindowInsets(v10_1, v1);
                    v27 &= 0xFFFF1FFF;
                }
                else {
                    v7_2 = arg50;
                }

                if(v16 != 0) {
                    v24_1 = v3;
                    v16_1 = v4_1;
                    v11_1 = v6_1;
                    v12_1 = v7_2;
                    v26_1 = ((MutableInteractionSource)v19_1);
                }
                else {
                    v26_1 = arg51;
                    v24_1 = v3;
                    v16_1 = v4_1;
                    v11_1 = v6_1;
                    v12_1 = v7_2;
                }

                v23_1 = v20_1;
                v25_1 = v21_1;
                v8_1 = v22_2;
                Companion v7_3 = v0_2;
                v22_1 = v18_1;
                v0 = v27;
            }
            else {
                v14.skipToGroupEnd();
                if((v2 & 0x400) != 0) {
                    v27 &= -15;
                }

                if((v2 & 0x800) != 0) {
                    v27 &= 0xFFFFFF8F;
                }

                if((v2 & 0x4000) != 0) {
                    v27 &= 0xFFFF1FFF;
                }

                v25_1 = arg45;
                v16_1 = arg47;
                v5_2 = arg48;
                v11_1 = arg49;
                v12_1 = arg50;
                v26_1 = arg51;
                v24_1 = v3;
                v7_1 = v6;
                v22_1 = v8;
                v23_1 = v10;
                v10_1 = v14;
                v0 = v27;
                v8_1 = arg46;
                v14_1 = v4;
            }

            v10_1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x59D2D0FE, v14_1, v0, "androidx.compose.material3.SearchBar (SearchBar.kt:1967)");
            }

            ComposableLambda v4_2 = ComposableLambdaKt.rememberComposableLambda(0xA0CD121E, true, new SearchBarKt$SearchBar$6(v16_1, v13, arg37, arg38, arg39, arg40, v22_1, v23_1, v24_1, v25_1, v26_1), v10_1, 54);
            int v3_1 = v14_1 >> 6;
            v1 = v1 | v3_1 & 0x70 | v3_1 & 0x380 | v3_1 & 0x1C00;
            v3_1 = v0 << 12;
            v14 = v10_1;
            float v10_2 = v5_2;
            SearchBarKt.SearchBar-Y92LkZI(((Function2)v4_2), arg39, arg40, v7_1, v8_1, v16_1, v10_2, v11_1, v12_1, arg52, v14, v1 | 0xE000 & v3_1 | 0x70000 & v3_1 | 0x380000 & v3_1 | 0x1C00000 & v3_1 | v3_1 & 0xE000000 | v0 << 9 & 0x70000000, 0);
            v16_1 = v16_1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6 = v7_1;
            v13_1 = v10_2;
            v15_1 = v12_1;
            v0_4 = v14;
            v12_2 = v16_1;
            v7_4 = v22_1;
            v9_1 = v24_1;
            v10 = v25_1;
            v16_2 = v26_1;
            v14_2 = v11_1;
            v11_2 = v8_1;
            v8_2 = v23_1;
        }
        else {
            v14.skipToGroupEnd();
            v11_2 = arg46;
            v12_2 = arg47;
            v13_1 = arg48;
            v15_1 = arg50;
            v16_2 = arg51;
            v9_1 = v3;
            v7_4 = v8;
            v8_2 = v10;
            v0_4 = v14;
            v10 = arg45;
            v14_2 = arg49;
        }

        ScopeUpdateScope v0_5 = v0_4.endRestartGroup();
        if(v0_5 != null) {
            v0_5.updateScope(new SearchBarKt$$ExternalSyntheticLambda3(arg36, arg37, arg38, arg39, arg40, v6, v7_4, v8_2, v9_1, v10, v11_2, v12_2, v13_1, v14_2, v15_1, v16_2, arg52, arg54, arg55, v2));
        }
    }

    public static final void SearchBar-Y92LkZI(Function2 arg30, boolean arg31, Function1 arg32, Modifier arg33, Shape arg34, SearchBarColors arg35, float arg36, float arg37, WindowInsets arg38, Function3 arg39, Composer arg40, int arg41, int arg42) {
        WindowInsets v9_1;
        float v7_2;
        SearchBarColors v6_4;
        Shape v5_5;
        Modifier v4_5;
        Composer v25;
        Object v14_2;
        Object v13_3;
        SearchBarKt$SearchBar$4$1 v6_3;
        MutatorMutex v4_4;
        String v8_3;
        Shape v33;
        Boolean v7_1;
        SearchBarKt$SearchBar$3$1 v5_3;
        MutableState v0_3;
        MutableState v5_2;
        Composer v13_2;
        float v27_1;
        SearchBarColors v22_1;
        Shape v8_1;
        WindowInsets v23;
        float v28;
        float v8_2;
        Shape v0_1;
        Companion v10_1;
        WindowInsets v4;
        int v16;
        float v15_1;
        int v15;
        SearchBarColors v14_1;
        int v14;
        Shape v13_1;
        Modifier v10;
        Function1 v9;
        int v5;
        int v3;
        boolean v2 = arg31;
        int v11 = arg41;
        int v12 = arg42;
        Composer v1 = arg40.startRestartGroup(0x5684DCD0);
        ComposerKt.sourceInformation(v1, "C(SearchBar)N(inputField,expanded,onExpandedChange,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,content)545@26468L24,546@26521L64,547@26614L43,548@26683L51,549@26762L51,551@26844L638,551@26819L663,567@27507L27,568@27581L1149,568@27539L1191,596@28736L458:SearchBar.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v3 = v11 | 6;
        }
        else {
            Function2 v7 = arg30;
            if((v11 & 6) == 0) {
                v3 = v1.changedInstance(v7) ? 4 : 2;
                v3 |= v11;
            }
            else {
                v3 = v11;
            }
        }

        if((v12 & 2) != 0) {
            v3 |= 0x30;
        }
        else if((v11 & 0x30) == 0) {
            v5 = v1.changed(v2) ? 0x20 : 16;
            v3 |= v5;
        }

        if((v12 & 4) != 0) {
            v3 |= 0x180;
            v9 = arg32;
        }
        else {
            v9 = arg32;
            if((v11 & 0x180) == 0) {
                v5 = v1.changedInstance(v9) ? 0x100 : 0x80;
                v3 |= v5;
            }
        }

        v5 = v12 & 8;
        if(v5 != 0) {
            v3 |= 0xC00;
            goto label_64;
        }
        else if((v11 & 0xC00) == 0) {
            v10 = arg33;
            int v13 = v1.changed(v10) ? 0x800 : 0x400;
            v3 |= v13;
        }
        else {
        label_64:
            v10 = arg33;
        }

        if((v11 & 0x6000) == 0) {
            if((v12 & 16) == 0) {
                v13_1 = arg34;
                if(v1.changed(v13_1)) {
                    v14 = 0x4000;
                }
                else {
                    goto label_75;
                }
            }
            else {
                v13_1 = arg34;
            label_75:
                v14 = 0x2000;
            }

            v3 |= v14;
        }
        else {
            v13_1 = arg34;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v14_1 = arg35;
                if(v1.changed(v14_1)) {
                    v15 = 0x20000;
                }
                else {
                    goto label_90;
                }
            }
            else {
                v14_1 = arg35;
            label_90:
                v15 = 0x10000;
            }

            v3 |= v15;
        }
        else {
            v14_1 = arg35;
        }

        int v22 = v12 & 0x40;
        v15 = 0x180000;
        if(v22 != 0) {
            v3 |= v15;
            goto label_109;
        }
        else if((v15 & v11) == 0) {
            v15_1 = arg36;
            v16 = v1.changed(v15_1) ? 0x100000 : 0x80000;
            v3 |= v16;
        }
        else {
        label_109:
            v15_1 = arg36;
        }

        int v8 = v12 & 0x80;
        v16 = 0xC00000;
        if(v8 != 0) {
            v3 |= v16;
        }
        else {
            float v6 = arg37;
            if((v11 & v16) == 0) {
                v16 = v1.changed(v6) ? 0x800000 : 0x400000;
                v3 |= v16;
            }
        }

        if((v11 & 0x6000000) == 0) {
            if((v12 & 0x100) == 0) {
                v4 = arg38;
                if(v1.changed(v4)) {
                    v16 = 0x4000000;
                }
                else {
                    goto label_136;
                }
            }
            else {
                v4 = arg38;
            label_136:
                v16 = 0x2000000;
            }

            v3 |= v16;
        }
        else {
            v4 = arg38;
        }

        v16 = 0x30000000;
        if((v12 & 0x200) != 0) {
            v3 |= v16;
        }
        else if((v11 & v16) == 0) {
            v16 = v1.changedInstance(arg39) ? 0x20000000 : 0x10000000;
            v3 |= v16;
        }

        boolean v0 = (v3 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0, v3 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "538@26130L15,539@26195L8,542@26376L12");
            int v2_1 = 0xF1FFFFFF;
            int v27 = 0xFFF8FFFF;
            v16 = 0xFFFF1FFF;
            if((v11 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v5 != 0) {
                    v10_1 = Modifier.Companion;
                }

                v5 = 6;
                if((v12 & 16) != 0) {
                    v0_1 = SearchBarDefaults.INSTANCE.getInputFieldShape(v1, v5);
                    v3 &= v16;
                }
                else {
                    v0_1 = v13_1;
                }

                if((v12 & 0x20) != 0) {
                    v13_2 = v1;
                    v3 &= v27;
                    v14_1 = SearchBarDefaults.INSTANCE.colors-Klgx-Pg(0, 0, null, v1, 0xC00, 7);
                }
                else {
                    v13_2 = v1;
                }

                float v1_1 = v22 != 0 ? SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM() : arg36;
                v8_2 = v8 != 0 ? SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM() : arg37;
                if((v12 & 0x100) != 0) {
                    v4 = SearchBarDefaults.INSTANCE.getWindowInsets(v13_2, v5);
                    v3 &= v2_1;
                }

                v27_1 = v1_1;
                v23 = v4;
                v28 = v8_2;
                v22_1 = v14_1;
                v8_1 = v0_1;
                v14 = v3;
            }
            else {
                v1.skipToGroupEnd();
                if((v12 & 16) != 0) {
                    v3 &= v16;
                }

                if((v12 & 0x20) != 0) {
                    v3 &= v27;
                }

                if((v12 & 0x100) != 0) {
                    v3 &= v2_1;
                }

                v28 = arg37;
                v23 = v4;
                v8_1 = v13_1;
                v22_1 = v14_1;
                v27_1 = v15_1;
                v13_2 = v1;
                v14 = v3;
            }

            v13_2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x5684DCD0, v14, -1, "androidx.compose.material3.SearchBar (SearchBar.kt:544)");
            }

            ComposerKt.sourceInformationMarkerStart(v13_2, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v13_2, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
            Object v1_2 = v13_2.rememberedValue();
            if(v1_2 == Composer.Companion.getEmpty()) {
                CoroutineScope v1_3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v13_2);
                v13_2.updateRememberedValue(v1_3);
            }

            Object v15_2 = v1_2;
            ComposerKt.sourceInformationMarkerEnd(v13_2);
            ComposerKt.sourceInformationMarkerEnd(v13_2);
            String v2_2 = "CC(remember):SearchBar.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v13_2, 0xC8C13690, v2_2);
            v1_2 = v13_2.rememberedValue();
            Object v4_1 = null;
            if(v1_2 == Composer.Companion.getEmpty()) {
                float v3_1 = arg31 ? 1f : 0f;
                Animatable v1_4 = AnimatableKt.Animatable$default(v3_1, 0f, 2, v4_1);
                v13_2.updateRememberedValue(v1_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v13_2);
            ComposerKt.sourceInformationMarkerStart(v13_2, 0xC8C1421B, v2_2);
            Object v3_2 = v13_2.rememberedValue();
            if(v3_2 == Composer.Companion.getEmpty()) {
                MutableFloatState v3_3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(NaNf);
                v13_2.updateRememberedValue(v3_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v13_2);
            ComposerKt.sourceInformationMarkerStart(v13_2, -926856509, v2_2);
            Object v5_1 = v13_2.rememberedValue();
            if(v5_1 == Composer.Companion.getEmpty()) {
                v5_2 = SnapshotStateKt.mutableStateOf$default(v4_1, ((SnapshotMutationPolicy)v4_1), 2, v4_1);
                v13_2.updateRememberedValue(v5_2);
            }

            Object v19 = v5_2;
            ComposerKt.sourceInformationMarkerEnd(v13_2);
            ComposerKt.sourceInformationMarkerStart(v13_2, 0xC8C154A3, v2_2);
            Object v0_2 = v13_2.rememberedValue();
            if(v0_2 == Composer.Companion.getEmpty()) {
                v0_3 = SnapshotStateKt.mutableStateOf$default(v4_1, ((SnapshotMutationPolicy)v4_1), 2, v4_1);
                v13_2.updateRememberedValue(v0_3);
            }

            Object v20 = v0_3;
            ComposerKt.sourceInformationMarkerEnd(v13_2);
            Boolean v0_4 = Boolean.valueOf(arg31);
            ComposerKt.sourceInformationMarkerStart(v13_2, -926850770, v2_2);
            boolean v4_2 = v13_2.changedInstance(v1_2);
            v5 = (v14 & 0x70) == 0x20 ? 1 : 0;
            int v4_3 = (((int)v4_2)) | v5;
            v5_1 = v13_2.rememberedValue();
            if(v4_3 != 0 || v5_1 == Composer.Companion.getEmpty()) {
                v7_1 = v0_4;
                v33 = v8_1;
                v8_3 = v2_2;
                v2 = arg31;
                v5_3 = new SearchBarKt$SearchBar$3$1(((Animatable)v1_2), v2, ((MutableFloatState)v3_2), v19, v20, null);
                v13_2.updateRememberedValue(v5_3);
            }
            else {
                v7_1 = v0_4;
                v33 = v8_1;
                v8_3 = v2_2;
                v2 = arg31;
            }

            ComposerKt.sourceInformationMarkerEnd(v13_2);
            int v0_5 = v14 >> 3 & 14;
            EffectsKt.LaunchedEffect(v7_1, ((Function2)v5_3), v13_2, v0_5);
            ComposerKt.sourceInformationMarkerStart(v13_2, -926830165, v8_3);
            v4_1 = v13_2.rememberedValue();
            if(v4_1 == Composer.Companion.getEmpty()) {
                v4_4 = new MutatorMutex();
                v13_2.updateRememberedValue(v4_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v13_2);
            ComposerKt.sourceInformationMarkerStart(v13_2, 0xC8C1BF4D, v8_3);
            boolean v5_4 = v13_2.changedInstance(v1_2);
            int v6_1 = (v14 & 0x380) == 0x100 ? 1 : 0;
            v5 = (((int)v5_4)) | v6_1 | v13_2.changedInstance(v15_2);
            Object v6_2 = v13_2.rememberedValue();
            if(v5 != 0 || v6_2 == Composer.Companion.getEmpty()) {
                Object v16_1 = v1_2;
                Object v18 = v15_2;
                v1 = v13_2;
                v15_2 = v3_2;
                v3 = v14;
                v14_2 = v15_2;
                v13_3 = v16_1;
                v6_3 = new SearchBarKt$SearchBar$4$1(v4_4, ((MutableFloatState)v15_2), ((Animatable)v16_1), v9, ((CoroutineScope)v18), ((MutableState)v19), ((MutableState)v20), null);
                v1.updateRememberedValue(v6_3);
            }
            else {
                Composer v29 = v13_2;
                v13_3 = v1_2;
                v1 = v29;
                int v29_1 = v14;
                v14_2 = v3_2;
                v3 = v29_1;
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            BackHandler_androidKt.PredictiveBackHandler(v2, ((Function2)v6_3), v1, v0_5, 0);
            v4_3 = v3 << 6;
            v5_1 = v20;
            SearchBarColors v20_1 = v22_1;
            float v22_2 = v28;
            v25 = v1;
            Modifier v17 = ((Modifier)v10_1);
            v15_2 = v19;
            float v21 = v27_1;
            Shape v19_1 = v33;
            SearchBarKt.SearchBarImpl-j1jLAyQ(((Animatable)v13_3), ((MutableFloatState)v14_2), ((MutableState)v15_2), v5_1, v17, arg30, v19_1, v20_1, v21, v22_2, v23, arg39, v25, Animatable.$stable | 0xDB0 | v3 << 3 & 0xE000 | v3 << 15 & 0x70000 | 0x380000 & v4_3 | 0x1C00000 & v4_3 | 0xE000000 & v4_3 | v4_3 & 0x70000000, v3 >> 24 & 0x7E, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_5 = v17;
            v5_5 = v19_1;
            v6_4 = v20_1;
            v7_2 = v21;
            v8_2 = v22_2;
            v9_1 = v23;
        }
        else {
            v2 = arg31;
            v25 = v1;
            v25.skipToGroupEnd();
            v7_2 = arg36;
            v8_2 = arg37;
            v9_1 = v4;
            v4_5 = v10;
            v5_5 = v13_1;
            v6_4 = v14_1;
        }

        ScopeUpdateScope v13_4 = v25.endRestartGroup();
        if(v13_4 != null) {
            v13_4.updateScope(new SearchBarKt$$ExternalSyntheticLambda26(arg30, v2, arg32, v4_5, v5_5, v6_4, v7_2, v8_2, v9_1, arg39, v11, v12));
        }
    }

    public static final void SearchBar-nbWgWpA(SearchBarState arg22, Function2 arg23, Modifier arg24, Shape arg25, SearchBarColors arg26, float arg27, float arg28, Composer arg29, int arg30, int arg31) {
        float v6_2;
        Shape v4_1;
        Modifier v3_1;
        float v16;
        float v7_2;
        Shape v10_2;
        SearchBarColors v2_1;
        SearchBarColors v5_1;
        SearchBarColors v16_1;
        float v11_1;
        int v11;
        float v10_1;
        int v10;
        SearchBarColors v9_1;
        int v9;
        Shape v7_1;
        Modifier v6;
        int v5;
        Function2 v4;
        int v2;
        SearchBarState v1 = arg22;
        int v8 = arg30;
        int v0 = 0x498F3793;
        Composer v15 = arg29.startRestartGroup(v0);
        ComposerKt.sourceInformation(v15, "C(SearchBar)N(state,inputField,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp)234@11650L30,237@11767L38,233@11592L334:SearchBar.kt#uh7d8r");
        int v3 = 4;
        if((arg31 & 1) != 0) {
            v2 = v8 | 6;
        }
        else if((v8 & 6) == 0) {
            v2 = v15.changed(v1) ? v3 : 2;
            v2 |= v8;
        }
        else {
            v2 = v8;
        }

        if((arg31 & 2) != 0) {
            v2 |= 0x30;
            goto label_36;
        }
        else if((v8 & 0x30) == 0) {
            v4 = arg23;
            v5 = v15.changedInstance(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_36:
            v4 = arg23;
        }

        v5 = arg31 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_51;
        }
        else if((v8 & 0x180) == 0) {
            v6 = arg24;
            int v7 = v15.changed(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_51:
            v6 = arg24;
        }

        if((v8 & 0xC00) == 0) {
            if((arg31 & 8) == 0) {
                v7_1 = arg25;
                if(v15.changed(v7_1)) {
                    v9 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v7_1 = arg25;
            label_62:
                v9 = 0x400;
            }

            v2 |= v9;
        }
        else {
            v7_1 = arg25;
        }

        if((v8 & 0x6000) == 0) {
            if((arg31 & 16) == 0) {
                v9_1 = arg26;
                if(v15.changed(v9_1)) {
                    v10 = 0x4000;
                }
                else {
                    goto label_76;
                }
            }
            else {
                v9_1 = arg26;
            label_76:
                v10 = 0x2000;
            }

            v2 |= v10;
        }
        else {
            v9_1 = arg26;
        }

        int v18 = arg31 & 0x20;
        v10 = 0x30000;
        if(v18 != 0) {
            v2 |= v10;
            goto label_95;
        }
        else if((v10 & v8) == 0) {
            v10_1 = arg27;
            v11 = v15.changed(v10_1) ? 0x20000 : 0x10000;
            v2 |= v11;
        }
        else {
        label_95:
            v10_1 = arg27;
        }

        int v19 = arg31 & 0x40;
        v11 = 0x180000;
        if(v19 != 0) {
            v2 |= v11;
            goto label_111;
        }
        else if((v11 & v8) == 0) {
            v11_1 = arg28;
            int v12 = v15.changed(v11_1) ? 0x100000 : 0x80000;
            v2 |= v12;
        }
        else {
        label_111:
            v11_1 = arg28;
        }

        boolean v12_1 = (0x92493 & v2) != 0x92492 ? true : false;
        if(v15.shouldExecute(v12_1, v2 & 1)) {
            v15.startDefaults();
            ComposerKt.sourceInformation(v15, "228@11389L15,229@11454L8");
            int v21 = 0xFFFF1FFF;
            if((v8 & 1) == 0 || (v15.getDefaultsInvalid())) {
                if(v5 != 0) {
                    Companion v6_1 = Modifier.Companion;
                }

                if((arg31 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                    v7_1 = SearchBarDefaults.INSTANCE.getInputFieldShape(v15, 6);
                }

                if((arg31 & 16) != 0) {
                    v5 = 0;
                    v9_1 = SearchBarDefaults.INSTANCE.colors-Klgx-Pg(0, 0, null, v15, 0xC00, 7);
                    v2 &= v21;
                }
                else {
                    v5 = 0;
                }

                v10_1 = v18 != 0 ? SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM() : arg27;
                if(v19 != 0) {
                    v16_1 = v9_1;
                    v9 = v2;
                    v2_1 = v16_1;
                    v16 = v10_1;
                    v10_2 = v7_1;
                    v7_2 = v16;
                    v16 = SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                    goto label_195;
                }

                v16_1 = v9_1;
                v9 = v2;
                v2_1 = v16_1;
                v16 = v10_1;
                v10_2 = v7_1;
                v7_2 = v16;
                v16 = arg28;
            }
            else {
                v15.skipToGroupEnd();
                if((arg31 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                if((arg31 & 16) != 0) {
                    v2 &= v21;
                }

                v5_1 = v9_1;
                v9 = v2;
                v2_1 = v5_1;
                float v5_2 = v10_1;
                v10_2 = v7_1;
                v7_2 = v5_2;
                v16 = v11_1;
                v5 = 0;
            }

        label_195:
            v15.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v9, -1, "androidx.compose.material3.SearchBar (SearchBar.kt:232)");
            }

            ComposerKt.sourceInformationMarkerStart(v15, 580903377, "CC(remember):SearchBar.kt#9igjgp");
            int v14 = (v9 & 14) == v3 ? 1 : v5;
            Object v0_1 = v15.rememberedValue();
            if(v14 != 0 || v0_1 == Composer.Companion.getEmpty()) {
                SearchBarKt$$ExternalSyntheticLambda9 v0_2 = new SearchBarKt$$ExternalSyntheticLambda9(v1);
                v15.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            Modifier v0_3 = OnGloballyPositionedModifierKt.onGloballyPositioned(v6, ((Function1)v0_1));
            long v11_2 = v2_1.getContainerColor-0d7_KjU();
            long v13 = ColorSchemeKt.contentColorFor-ek8zF_U(v2_1.getContainerColor-0d7_KjU(), v15, v5);
            v5 = v9 >> 3;
            SurfaceKt.Surface-T9BRK9s(v0_3, v10_2, v11_2, v13, v7_2, v16, null, v4, v15, v9 >> 6 & 0x70 | v5 & 0xE000 | v5 & 0x70000 | v9 << 18 & 0x1C00000, 0x40);
            float v0_4 = v7_2;
            v15 = v15;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_1 = v2_1;
            v3_1 = v6;
            v4_1 = v10_2;
            v7_2 = v16;
            v6_2 = v0_4;
        }
        else {
            v15.skipToGroupEnd();
            v3_1 = v6;
            v4_1 = v7_1;
            v5_1 = v9_1;
            v6_2 = arg27;
            v7_2 = arg28;
        }

        ScopeUpdateScope v10_3 = v15.endRestartGroup();
        if(v10_3 != null) {
            v10_3.updateScope(new SearchBarKt$$ExternalSyntheticLambda10(v1, arg23, v3_1, v4_1, v5_1, v6_2, v7_2, v8, arg31));
        }
    }

    public static final void SearchBarImpl-j1jLAyQ(Animatable arg28, MutableFloatState arg29, MutableState arg30, MutableState arg31, Modifier arg32, Function2 arg33, Shape arg34, SearchBarColors arg35, float arg36, float arg37, WindowInsets arg38, Function3 arg39, Composer arg40, int arg41, int arg42, int arg43) {
        Modifier v5_3;
        WindowInsets v11_5;
        Shape v7_3;
        float v10_4;
        float v9_2;
        SearchBarColors v8_2;
        Composer v0_1;
        ComposableLambda v4_7;
        Shape v1_8;
        float v6_1;
        WindowInsets v7_1;
        Shape v2_2;
        int v10_1;
        Modifier v4_1;
        SearchBarColors v3_2;
        float v5_1;
        SearchBarColors v2_3;
        int v1_4;
        Companion v32;
        Shape v23_1;
        Companion v1_2;
        int v20;
        WindowInsets v6;
        int v23;
        int v22;
        int v21;
        SearchBarColors v4;
        int v19;
        int v16;
        Modifier v10;
        int v9;
        MutableState v14;
        int v5;
        int v2;
        Animatable v0 = arg28;
        Function3 v12 = arg39;
        int v13 = arg41;
        int v15 = arg43;
        Composer v8 = arg40.startRestartGroup(0x1DE82440);
        ComposerKt.sourceInformation(v8, "C(SearchBarImpl)N(animationProgress,finalBackProgress,firstBackEvent,currentBackEvent,modifier,inputField,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,content)2094@98568L7,2096@98628L15,2097@98695L15,2098@98741L101,2102@98875L666,2118@99580L333,2129@99938L99,2142@100370L362:SearchBar.kt#uh7d8r");
        if((v15 & 1) != 0) {
            v2 = v13 | 6;
        }
        else if((v13 & 6) == 0) {
            boolean v2_1 = (v13 & 8) == 0 ? v8.changed(v0) : v8.changedInstance(v0);
            v2 = v2_1 ? 4 : 2;
            v2 |= v13;
        }
        else {
            v2 = v13;
        }

        if((v15 & 2) != 0) {
            v2 |= 0x30;
        }
        else {
            MutableFloatState v11 = arg29;
            if((v13 & 0x30) == 0) {
                v5 = v8.changed(v11) ? 0x20 : 16;
                v2 |= v5;
            }
        }

        if((v15 & 4) != 0) {
            v2 |= 0x180;
            v14 = arg30;
        }
        else {
            v14 = arg30;
            if((v13 & 0x180) == 0) {
                v5 = v8.changed(v14) ? 0x100 : 0x80;
                v2 |= v5;
            }
        }

        if((v15 & 8) != 0) {
            v2 |= 0xC00;
        }
        else if((v13 & 0xC00) == 0) {
            v9 = v8.changed(arg31) ? 0x800 : 0x400;
            v2 |= v9;
        }

        v9 = v15 & 16;
        if(v9 != 0) {
            v2 |= 0x6000;
            goto label_84;
        }
        else if((v13 & 0x6000) == 0) {
            v10 = arg32;
            v16 = v8.changed(v10) ? 0x4000 : 0x2000;
            v2 |= v16;
        }
        else {
        label_84:
            v10 = arg32;
        }

        int v17 = 0x30000;
        if((v15 & 0x20) != 0) {
            v2 |= v17;
        }
        else {
            Function2 v1 = arg33;
            if((v13 & v17) == 0) {
                v17 = v8.changedInstance(v1) ? 0x20000 : 0x10000;
                v2 |= v17;
            }
        }

        v17 = 0x180000;
        if((v13 & v17) == 0) {
            Shape v3 = arg34;
            v19 = (v15 & 0x40) != 0 || !v8.changed(v3) ? 0x80000 : 0x100000;
            v2 |= v19;
        }

        v19 = 0xC00000;
        if((v13 & v19) == 0) {
            if((v15 & 0x80) == 0) {
                v4 = arg35;
                if(v8.changed(v4)) {
                    v21 = 0x800000;
                }
                else {
                    goto label_125;
                }
            }
            else {
                v4 = arg35;
            label_125:
                v21 = 0x400000;
            }

            v2 |= v21;
        }
        else {
            v4 = arg35;
        }

        int v3_1 = v15 & 0x100;
        v21 = 0x6000000;
        if(v3_1 != 0) {
            v2 |= v21;
            goto label_145;
        }
        else if((v13 & v21) == 0) {
            v21 = v3_1;
            v22 = v8.changed(arg36) ? 0x4000000 : 0x2000000;
            v2 |= v22;
        }
        else {
        label_145:
            v21 = v3_1;
        }

        v3_1 = v15 & 0x200;
        v22 = 0x30000000;
        if(v3_1 != 0) {
            v2 |= v22;
            goto label_163;
        }
        else if((v13 & v22) == 0) {
            v22 = v3_1;
            v23 = v8.changed(arg37) ? 0x20000000 : 0x10000000;
            v2 |= v23;
        }
        else {
        label_163:
            v22 = v3_1;
        }

        if((arg42 & 6) == 0) {
            if((v15 & 0x400) == 0) {
                v6 = arg38;
                if(v8.changed(v6)) {
                    v20 = 4;
                }
                else {
                    goto label_175;
                }
            }
            else {
                v6 = arg38;
            label_175:
                v20 = 2;
            }

            v20 |= arg42;
        }
        else {
            v6 = arg38;
            v20 = arg42;
        }

        if((v15 & 0x800) != 0) {
            v20 |= 0x30;
        }
        else if((arg42 & 0x30) == 0) {
            v23 = v8.changedInstance(v12) ? 0x20 : 16;
            v20 |= v23;
        }

        boolean v1_1 = (306783379 & v2) != 306783378 || (v20 & 19) != 18 ? true : false;
        if(v8.shouldExecute(v1_1, v2 & 1)) {
            v8.startDefaults();
            ComposerKt.sourceInformation(v8, "2087@98224L15,2088@98289L8,2091@98470L12");
            int v7 = 6;
            if((v13 & 1) == 0 || (v8.getDefaultsInvalid())) {
                if(v9 != 0) {
                    v1_2 = Modifier.Companion;
                }
                else {
                    Modifier v1_3 = v10;
                }

                if((v15 & 0x40) != 0) {
                    v2 &= 0xFFC7FFFF;
                    v23_1 = SearchBarDefaults.INSTANCE.getInputFieldShape(v8, v7);
                }
                else {
                    v23_1 = arg34;
                }

                int v24 = v2;
                if((v15 & 0x80) != 0) {
                    v32 = v1_2;
                    v1_4 = v7;
                    v2_3 = SearchBarDefaults.INSTANCE.colors-Klgx-Pg(0, 0, null, v8, 0xC00, 7);
                    v3_1 = v24 & 0xFE3FFFFF;
                }
                else {
                    v32 = v1_2;
                    v1_4 = v7;
                    v2_3 = v4;
                    v3_1 = v24;
                }

                float v4_2 = v21 != 0 ? SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM() : arg36;
                v5_1 = v22 != 0 ? SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM() : arg37;
                if((v15 & 0x400) != 0) {
                    v9 = v3_1;
                    v7_1 = SearchBarDefaults.INSTANCE.getWindowInsets(v8, v1_4);
                    v10_1 = v20 & -15;
                    v3_2 = v2_3;
                    v6_1 = v5_1;
                    v2_2 = v23_1;
                    v5_1 = v4_2;
                }
                else {
                    v7_1 = arg38;
                    v9 = v3_1;
                    v6_1 = v5_1;
                    v10_1 = v20;
                    v3_2 = v2_3;
                    v5_1 = v4_2;
                    v2_2 = v23_1;
                }

                Companion v4_3 = v32;
            }
            else {
                v8.skipToGroupEnd();
                if((v15 & 0x40) != 0) {
                    v2 &= 0xFFC7FFFF;
                }

                if((v15 & 0x80) != 0) {
                    v2 &= 0xFE3FFFFF;
                }

                if((v15 & 0x400) != 0) {
                    v20 &= -15;
                }

                v5_1 = arg36;
                v9 = v2;
                v3_2 = v4;
                v4_1 = v10;
                v10_1 = v20;
                v2_2 = arg34;
                v7_1 = v6;
                v6_1 = arg37;
            }

            v8.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                arg32 = v4_1;
                ComposerKt.traceEventStart(0x1DE82440, v9, v10_1, "androidx.compose.material3.SearchBarImpl (SearchBar.kt:2093)");
            }
            else {
                arg32 = v4_1;
            }

            ProvidableCompositionLocal v1_5 = CompositionLocalsKt.getLocalDensity();
            WindowInsets v34 = v7_1;
            ComposerKt.sourceInformationMarkerStart(v8, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v1_6 = v8.consume(((CompositionLocal)v1_5));
            ComposerKt.sourceInformationMarkerEnd(v8);
            Shape v4_4 = SearchBarDefaults.INSTANCE.getInputFieldShape(v8, 6);
            v16 = v10_1;
            Shape v35 = SearchBarDefaults.INSTANCE.getFullScreenShape(v8, 6);
            String v7_2 = "CC(remember):SearchBar.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v8, 0x44708765, v7_2);
            Object v10_2 = v8.rememberedValue();
            if(v10_2 == Composer.Companion.getEmpty()) {
                State v10_3 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new SearchBarKt$$ExternalSyntheticLambda0(v0));
                v8.updateRememberedValue(v10_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            boolean v11_1 = SearchBarKt.SearchBarImpl_j1jLAyQ$lambda$32(((State)v10_2));
            Object v36 = v10_2;
            ComposerKt.sourceInformationMarkerStart(v8, 0x44709A5A, v7_2);
            boolean v37 = v8.changed(v11_1);
            v10_1 = 0x100000;
            v10_1 = (0x380000 & v9 ^ v17) > v10_1 && (v8.changed(v2_2)) || (v9 & v17) == v10_1 ? 1 : 0;
            Object v11_2 = v8.rememberedValue();
            if(((((int)v37)) | v10_1) != 0 || v11_2 == Composer.Companion.getEmpty()) {
                if(Intrinsics.areEqual(v2_2, v4_4)) {
                    GenericShape v1_7 = new GenericShape(new SearchBarKt$$ExternalSyntheticLambda11(((Density)v1_6), v0));
                }
                else if(SearchBarKt.SearchBarImpl_j1jLAyQ$lambda$32(((State)v36))) {
                    v1_8 = v35;
                }
                else {
                    v1_8 = v2_2;
                }

                v8.updateRememberedValue(v1_8);
                GenericShape v11_3 = ((GenericShape)v1_8);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposableLambda v1_9 = ComposableLambdaKt.rememberComposableLambda(0xB2408AEB, true, new SearchBarKt$SearchBarImpl$surface$1(((Shape)v11_2), v3_2, v5_1, v6_1), v8, 54);
            ComposerKt.sourceInformationMarkerStart(v8, 0x44711D03, v7_2);
            Object v4_5 = v8.rememberedValue();
            if(v4_5 == Composer.Companion.getEmpty()) {
                State v4_6 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new SearchBarKt$$ExternalSyntheticLambda20(v0));
                v8.updateRememberedValue(v4_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            if(SearchBarKt.SearchBarImpl_j1jLAyQ$lambda$38(v4_6)) {
                v8.startReplaceGroup(0x49B54233);
                ComposerKt.sourceInformation(v8, "2134@100129L215");
                v4_7 = ComposableLambdaKt.rememberComposableLambda(1831594093, true, new SearchBarKt$SearchBarImpl$wrappedContent$1(v0, v3_2, v12), v8, 54);
                v8.endReplaceGroup();
            }
            else {
                v8.startReplaceGroup(0x49B8DB1D);
                v8.endReplaceGroup();
                v4_7 = null;
            }

            v10_1 = Animatable.$stable | v19 | v9 & 14 | v9 & 0x70 | v9 & 0x380 | v9 & 0x1C00 | 0xE000 & v9 | v16 << 15 & 0x70000 | v9 << 3 & 0x380000;
            v23_1 = v2_2;
            SearchBarColors v11_4 = v3_2;
            float v16_1 = v6_1;
            Composer v9_1 = v8;
            MutableState v2_4 = v14;
            ComposableLambda v8_1 = v4_7;
            float v14_1 = v5_1;
            v4_1 = arg32;
            WindowInsets v5_2 = v34;
            SearchBarKt.SearchBarLayout(v0, arg29, v2_4, arg31, v4_1, v5_2, arg33, v1_9, ((Function2)v8_1), v9_1, v10_1);
            v8 = v9_1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v0_1 = v8;
            v8_2 = v11_4;
            v9_2 = v14_1;
            v10_4 = v16_1;
            v7_3 = v23_1;
            v11_5 = v5_2;
            v5_3 = v4_1;
        }
        else {
            v8.skipToGroupEnd();
            v7_3 = arg34;
            v9_2 = arg36;
            v11_5 = arg38;
            v0_1 = v8;
            v5_3 = v10;
            v10_4 = arg37;
            v8_2 = v4;
        }

        ScopeUpdateScope v0_2 = v0_1.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new SearchBarKt$$ExternalSyntheticLambda21(arg28, arg29, arg30, arg31, v5_3, arg33, v7_3, v8_2, v9_2, v10_4, v11_5, v12, v13, arg42, v15));
        }
    }

    static final boolean SearchBarImpl_j1jLAyQ$lambda$31$lambda$30(Animatable arg1) {
        if(arg1.getValue().floatValue() == 1f) {
            return 1;
        }

        return 0;
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$32(State arg0) {
        return arg0.getValue().booleanValue();
    }

    static final Unit SearchBarImpl_j1jLAyQ$lambda$35$lambda$34(Density arg4, Animatable arg5, Path arg6, Size arg7, LayoutDirection arg8) {
        float v4 = arg4.toPx-0680j_4(Dp.constructor-impl(SearchBarKt.SearchBarCornerRadius * (1f - arg5.getValue().floatValue())));
        Path.addRoundRect$default(arg6, RoundRectKt.RoundRect-sniSvfs(androidx.compose.ui.geometry.SizeKt.toRect-uvyYCjk(arg7.unbox-impl()), CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(v4))) << 0x20 | (((long)Float.floatToRawIntBits(v4))) & 0xFFFFFFFFL)), null, 2, null);
        return Unit.INSTANCE;
    }

    static final boolean SearchBarImpl_j1jLAyQ$lambda$37$lambda$36(Animatable arg1) {
        if(arg1.getValue().floatValue() > 0f) {
            return 1;
        }

        return 0;
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$38(State arg0) {
        return arg0.getValue().booleanValue();
    }

    static final Unit SearchBarImpl_j1jLAyQ$lambda$39(Animatable arg17, MutableFloatState arg18, MutableState arg19, MutableState arg20, Modifier arg21, Function2 arg22, Shape arg23, SearchBarColors arg24, float arg25, float arg26, WindowInsets arg27, Function3 arg28, int arg29, int arg30, int arg31, Composer arg32, int arg33) {
        SearchBarKt.SearchBarImpl-j1jLAyQ(arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg32, RecomposeScopeImplKt.updateChangedFlags(arg29 | 1), RecomposeScopeImplKt.updateChangedFlags(arg30), arg31);
        return Unit.INSTANCE;
    }

    private static final void SearchBarLayout(Animatable arg19, MutableFloatState arg20, MutableState arg21, MutableState arg22, Modifier arg23, WindowInsets arg24, Function2 arg25, Function2 arg26, Function2 arg27, Composer arg28, int arg29) {
        int v3_2;
        int v5;
        MutableState v15_1;
        int v15;
        MutableState v13_1;
        int v13;
        int v2_1;
        Animatable v1 = arg19;
        Modifier v6 = arg23;
        WindowInsets v7 = arg24;
        Function2 v8 = arg25;
        Function2 v9 = arg26;
        Function2 v10 = arg27;
        int v11 = arg29;
        int v0 = 1217602934;
        Composer v12 = arg28.startRestartGroup(v0);
        ComposerKt.sourceInformation(v12, "C(SearchBarLayout)N(animationProgress,finalBackProgress,firstBackEvent,currentBackEvent,modifier,windowInsets,inputField,surface,content)2171@101429L34,2176@101591L120,2191@102227L5012,2172@101468L5771:SearchBar.kt#uh7d8r");
        if((v11 & 6) == 0) {
            boolean v2 = (v11 & 8) == 0 ? v12.changed(v1) : v12.changedInstance(v1);
            v2_1 = v2 ? 4 : 2;
            v2_1 |= v11;
        }
        else {
            v2_1 = v11;
        }

        if((v11 & 0x30) == 0) {
            v13 = v12.changed(arg20) ? 0x20 : 16;
            v2_1 |= v13;
        }

        if((v11 & 0x180) == 0) {
            v13_1 = arg21;
            v15 = v12.changed(v13_1) ? 0x100 : 0x80;
            v2_1 |= v15;
        }
        else {
            v13_1 = arg21;
        }

        if((v11 & 0xC00) == 0) {
            v15_1 = arg22;
            int v16 = v12.changed(v15_1) ? 0x800 : 0x400;
            v2_1 |= v16;
        }
        else {
            v15_1 = arg22;
        }

        if((v11 & 0x6000) == 0) {
            v5 = v12.changed(v6) ? 0x4000 : 0x2000;
            v2_1 |= v5;
        }

        if((0x30000 & v11) == 0) {
            v5 = v12.changed(v7) ? 0x20000 : 0x10000;
            v2_1 |= v5;
        }

        if((0x180000 & v11) == 0) {
            v5 = v12.changedInstance(v8) ? 0x100000 : 0x80000;
            v2_1 |= v5;
        }

        if((0xC00000 & v11) == 0) {
            v5 = v12.changedInstance(v9) ? 0x800000 : 0x400000;
            v2_1 |= v5;
        }

        if((0x6000000 & v11) == 0) {
            v5 = v12.changedInstance(v10) ? 0x4000000 : 0x2000000;
            v2_1 |= v5;
        }

        boolean v3 = (0x2492493 & v2_1) != 0x2492492 ? true : false;
        if(v12.shouldExecute(v3, v2_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2_1, -1, "androidx.compose.material3.SearchBarLayout (SearchBar.kt:2167)");
            }

            String v3_1 = "CC(remember):SearchBar.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v12, 0x705FF6B8, v3_1);
            Object v0_1 = v12.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                MutableWindowInsets v0_2 = new MutableWindowInsets(null, 1, null);
                v12.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            Modifier v5_1 = ZIndexModifierKt.zIndex(v6, 1f);
            ComposerKt.sourceInformationMarkerStart(v12, 0x70600B4E, v3_1);
            int v4 = (0x70000 & v2_1) == 0x20000 ? 1 : 0;
            Object v14 = v12.rememberedValue();
            if(v4 != 0 || v14 == Composer.Companion.getEmpty()) {
                SearchBarKt$$ExternalSyntheticLambda27 v14_1 = new SearchBarKt$$ExternalSyntheticLambda27(((MutableWindowInsets)v0_1), v7);
                v12.updateRememberedValue(v14_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            Modifier v14_2 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(v5_1, ((Function1)v14)), v7);
            ComposerKt.sourceInformationMarkerStart(v12, 0x70606DEA, v3_1);
            if((v2_1 & 14) != 4) {
                if((v2_1 & 8) != 0 && (v12.changedInstance(v1))) {
                    goto label_165;
                }

                v3_2 = 0;
            }
            else {
            label_165:
                v3_2 = 1;
            }

            v4 = (v2_1 & 0x1C00) == 0x800 ? 1 : 0;
            v3_2 |= v4;
            v4 = (v2_1 & 0x70) == 0x20 ? 1 : 0;
            v3_2 |= v4;
            v4 = (v2_1 & 0x380) == 0x100 ? 1 : 0;
            v3_2 |= v4;
            Object v4_1 = v12.rememberedValue();
            if(v3_2 != 0 || v4_1 == Composer.Companion.getEmpty()) {
                MutableState v5_2 = v13_1;
                v13 = v2_1;
                SearchBarKt$SearchBarLayout$2$1 v4_2 = new SearchBarKt$SearchBarLayout$2$1(v1, v0_1, v15_1, arg20, v5_2);
                v12.updateRememberedValue(v4_2);
            }
            else {
                v13 = v2_1;
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            String v1_1 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v12, -1323940314, v1_1);
            v3_2 = ComposablesKt.getCurrentCompositeKeyHash(v12, 0);
            CompositionLocalMap v2_2 = v12.getCurrentCompositionLocalMap();
            v5_1 = ComposedModifierKt.materializeModifier(v12, v14_2);
            Function0 v14_3 = ComposeUiNode.Companion.getConstructor();
            String v0_3 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v12, 0xD6BD0031, v0_3);
            if(!(v12.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v12.startReusableNode();
            if(v12.getInserting()) {
                v12.createNode(v14_3);
            }
            else {
                v12.useNode();
            }

            Composer v14_4 = Updater.constructor-impl(v12);
            Updater.set-impl(v14_4, v4_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v14_4, v2_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v2_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v14_4.getInserting()) || !Intrinsics.areEqual(v14_4.rememberedValue(), Integer.valueOf(v3_2))) {
                v14_4.updateRememberedValue(Integer.valueOf(v3_2));
                v14_4.apply(Integer.valueOf(v3_2), v2_3);
            }

            Updater.set-impl(v14_4, v5_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v12, 2058590599, "C2181@101796L85,2182@101894L119:SearchBar.kt#uh7d8r");
            Modifier v2_4 = LayoutIdKt.layoutId(Modifier.Companion, "Surface");
            String v4_3 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v12, 0x2BB5B5D7, v4_3);
            MeasurePolicy v5_3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(v12, -1323940314, v1_1);
            v15 = ComposablesKt.getCurrentCompositeKeyHash(v12, 0);
            CompositionLocalMap v14_5 = v12.getCurrentCompositionLocalMap();
            v2_4 = ComposedModifierKt.materializeModifier(v12, v2_4);
            Function0 v3_3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v12, 0xD6BD0031, v0_3);
            if(!(v12.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v12.startReusableNode();
            if(v12.getInserting()) {
                v12.createNode(v3_3);
            }
            else {
                v12.useNode();
            }

            Composer v3_4 = Updater.constructor-impl(v12);
            Updater.set-impl(v3_4, v5_3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v3_4, v14_5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v5_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v3_4.getInserting()) || !Intrinsics.areEqual(v3_4.rememberedValue(), Integer.valueOf(v15))) {
                v3_4.updateRememberedValue(Integer.valueOf(v15));
                v3_4.apply(Integer.valueOf(v15), v5_4);
            }

            Updater.set-impl(v3_4, v2_4, ComposeUiNode.Companion.getSetModifier());
            v3_1 = "C72@3468L9:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v12, 0x800B7D29, v3_1);
            ComposerKt.sourceInformationMarkerStart(v12, 0x139FCC21, "C2181@101870L9:SearchBar.kt#uh7d8r");
            v9.invoke(v12, Integer.valueOf(v13 >> 21 & 14));
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            v12.endNode();
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            v5_1 = LayoutIdKt.layoutId(Modifier.Companion, "InputField");
            ComposerKt.sourceInformationMarkerStart(v12, 0x2BB5B5D7, v4_3);
            MeasurePolicy v6_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(v12, -1323940314, v1_1);
            v15 = ComposablesKt.getCurrentCompositeKeyHash(v12, 0);
            v14_5 = v12.getCurrentCompositionLocalMap();
            v5_1 = ComposedModifierKt.materializeModifier(v12, v5_1);
            Function0 v2_5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v12, 0xD6BD0031, v0_3);
            if(!(v12.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v12.startReusableNode();
            if(v12.getInserting()) {
                v12.createNode(v2_5);
            }
            else {
                v12.useNode();
            }

            Composer v2_6 = Updater.constructor-impl(v12);
            Updater.set-impl(v2_6, v6_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v2_6, v14_5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v6_2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v2_6.getInserting()) || !Intrinsics.areEqual(v2_6.rememberedValue(), Integer.valueOf(v15))) {
                v2_6.updateRememberedValue(Integer.valueOf(v15));
                v2_6.apply(Integer.valueOf(v15), v6_2);
            }

            Updater.set-impl(v2_6, v5_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v12, 0x800B7D29, v3_1);
            ComposerKt.sourceInformationMarkerStart(v12, 0x17ADF235, "C2183@101987L12:SearchBar.kt#uh7d8r");
            v8.invoke(v12, Integer.valueOf(v13 >> 18 & 14));
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            v12.endNode();
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            if(v10 == null) {
                v12.startReplaceGroup(2058820276);
                v12.endReplaceGroup();
            }
            else {
                v12.startReplaceGroup(2058820277);
                ComposerKt.sourceInformation(v12, "*2186@102068L127");
                v2_4 = LayoutIdKt.layoutId(Modifier.Companion, "Content");
                ComposerKt.sourceInformationMarkerStart(v12, 0x2BB5B5D7, v4_3);
                MeasurePolicy v4_4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(v12, -1323940314, v1_1);
                int v1_2 = ComposablesKt.getCurrentCompositeKeyHash(v12, 0);
                CompositionLocalMap v5_5 = v12.getCurrentCompositionLocalMap();
                v2_4 = ComposedModifierKt.materializeModifier(v12, v2_4);
                Function0 v6_3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v12, 0xD6BD0031, v0_3);
                if(!(v12.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v12.startReusableNode();
                if(v12.getInserting()) {
                    v12.createNode(v6_3);
                }
                else {
                    v12.useNode();
                }

                Composer v0_4 = Updater.constructor-impl(v12);
                Updater.set-impl(v0_4, v4_4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v0_4, v5_5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 v4_5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v0_4.getInserting()) || !Intrinsics.areEqual(v0_4.rememberedValue(), Integer.valueOf(v1_2))) {
                    v0_4.updateRememberedValue(Integer.valueOf(v1_2));
                    v0_4.apply(Integer.valueOf(v1_2), v4_5);
                }

                Updater.set-impl(v0_4, v2_4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v12, 0x800B7D29, v3_1);
                ComposerKt.sourceInformationMarkerStart(v12, 0x9388DBC7, "C2187@102168L9:SearchBar.kt#uh7d8r");
                v10.invoke(v12, Integer.valueOf(0));
                ComposerKt.sourceInformationMarkerEnd(v12);
                ComposerKt.sourceInformationMarkerEnd(v12);
                v12.endNode();
                ComposerKt.sourceInformationMarkerEnd(v12);
                ComposerKt.sourceInformationMarkerEnd(v12);
                ComposerKt.sourceInformationMarkerEnd(v12);
                v12.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            v12.endNode();
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_476;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v12.skipToGroupEnd();
        }

    label_476:
        ScopeUpdateScope v12_1 = v12.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new SearchBarKt$$ExternalSyntheticLambda1(arg19, arg20, arg21, arg22, arg23, arg24, v8, v9, v10, v11));
        }
    }

    static final Unit SearchBarLayout$lambda$42$lambda$41(MutableWindowInsets arg0, WindowInsets arg1, WindowInsets arg2) {
        arg0.setInsets(WindowInsetsKt.exclude(arg1, arg2));
        return Unit.INSTANCE;
    }

    static final Unit SearchBarLayout$lambda$49(Animatable arg12, MutableFloatState arg13, MutableState arg14, MutableState arg15, Modifier arg16, WindowInsets arg17, Function2 arg18, Function2 arg19, Function2 arg20, int arg21, Composer arg22, int arg23) {
        SearchBarKt.SearchBarLayout(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg22, RecomposeScopeImplKt.updateChangedFlags(arg21 | 1));
        return Unit.INSTANCE;
    }

    static final Unit SearchBar_WuY5d9Q$lambda$28(String arg22, Function1 arg23, Function1 arg24, boolean arg25, Function1 arg26, Modifier arg27, boolean arg28, Function2 arg29, Function2 arg30, Function2 arg31, Shape arg32, SearchBarColors arg33, float arg34, float arg35, WindowInsets arg36, MutableInteractionSource arg37, Function3 arg38, int arg39, int arg40, int arg41, Composer arg42, int arg43) {
        SearchBarKt.SearchBar-WuY5d9Q(arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg42, RecomposeScopeImplKt.updateChangedFlags(arg39 | 1), RecomposeScopeImplKt.updateChangedFlags(arg40), arg41);
        return Unit.INSTANCE;
    }

    static final Unit SearchBar_Y92LkZI$lambda$22(Function2 arg14, boolean arg15, Function1 arg16, Modifier arg17, Shape arg18, SearchBarColors arg19, float arg20, float arg21, WindowInsets arg22, Function3 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        SearchBarKt.SearchBar-Y92LkZI(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit SearchBar_nbWgWpA$lambda$1$lambda$0(SearchBarState arg0, LayoutCoordinates arg1) {
        arg0.setCollapsedCoords(arg1);
        return Unit.INSTANCE;
    }

    static final Unit SearchBar_nbWgWpA$lambda$2(SearchBarState arg11, Function2 arg12, Modifier arg13, Shape arg14, SearchBarColors arg15, float arg16, float arg17, int arg18, int arg19, Composer arg20, int arg21) {
        SearchBarKt.SearchBar-nbWgWpA(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    public static final void TopSearchBar-qKj4JfE(SearchBarState arg26, Function2 arg27, Modifier arg28, Shape arg29, SearchBarColors arg30, float arg31, float arg32, WindowInsets arg33, SearchBarScrollBehavior arg34, Composer arg35, int arg36, int arg37) {
        float v7_1;
        Composer v19_1;
        SearchBarScrollBehavior v9_1;
        Modifier v3_1;
        Companion v4_3;
        Shape v15_1;
        SearchBarScrollBehavior v1_1;
        boolean v3;
        float v17_1;
        float v18_1;
        SearchBarColors v16_1;
        Modifier v0_2;
        WindowInsets v0_5;
        int v0_4;
        Companion v28;
        int v24;
        Companion v0_3;
        int v9;
        WindowInsets v8_1;
        float v6_1;
        float v15;
        int v6;
        SearchBarColors v5_1;
        int v5;
        Shape v4_1;
        int v4;
        int v2;
        Function2 v13;
        SearchBarState v12;
        int v1;
        int v10 = arg36;
        int v11 = arg37;
        Composer v7 = arg35.startRestartGroup(0x2EA8ED4E);
        ComposerKt.sourceInformation(v7, "C(TopSearchBar)N(state,inputField,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,scrollBehavior)293@14798L586:SearchBar.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v1 = v10 | 6;
            v12 = arg26;
        }
        else {
            v12 = arg26;
            if((v10 & 6) == 0) {
                v1 = v7.changed(v12) ? 4 : 2;
                v1 |= v10;
            }
            else {
                v1 = v10;
            }
        }

        if((v11 & 2) != 0) {
            v1 |= 0x30;
            v13 = arg27;
        }
        else {
            v13 = arg27;
            if((v10 & 0x30) == 0) {
                v2 = v7.changedInstance(v13) ? 0x20 : 16;
                v1 |= v2;
            }
        }

        v2 = v11 & 4;
        if(v2 != 0) {
            v1 |= 0x180;
        }
        else if((v10 & 0x180) == 0) {
            v4 = v7.changed(arg28) ? 0x100 : 0x80;
            v1 |= v4;
        }

        if((v10 & 0xC00) == 0) {
            if((v11 & 8) == 0) {
                v4_1 = arg29;
                if(v7.changed(v4_1)) {
                    v5 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v4_1 = arg29;
            label_62:
                v5 = 0x400;
            }

            v1 |= v5;
        }
        else {
            v4_1 = arg29;
        }

        if((v10 & 0x6000) == 0) {
            if((v11 & 16) == 0) {
                v5_1 = arg30;
                if(v7.changed(v5_1)) {
                    v6 = 0x4000;
                }
                else {
                    goto label_76;
                }
            }
            else {
                v5_1 = arg30;
            label_76:
                v6 = 0x2000;
            }

            v1 |= v6;
        }
        else {
            v5_1 = arg30;
        }

        int v14 = v11 & 0x20;
        v6 = 0x30000;
        if(v14 != 0) {
            v1 |= v6;
            v15 = arg31;
        }
        else {
            v15 = arg31;
            if((v6 & v10) == 0) {
                v6 = v7.changed(v15) ? 0x20000 : 0x10000;
                v1 |= v6;
            }
        }

        int v16 = v11 & 0x40;
        v6 = 0x180000;
        if(v16 != 0) {
            v1 |= v6;
            goto label_110;
        }
        else if((v6 & v10) == 0) {
            v6_1 = arg32;
            int v8 = v7.changed(v6_1) ? 0x100000 : 0x80000;
            v1 |= v8;
        }
        else {
        label_110:
            v6_1 = arg32;
        }

        if((0xC00000 & v10) == 0) {
            if((v11 & 0x80) == 0) {
                v8_1 = arg33;
                if(v7.changed(v8_1)) {
                    v9 = 0x800000;
                }
                else {
                    goto label_122;
                }
            }
            else {
                v8_1 = arg33;
            label_122:
                v9 = 0x400000;
            }

            v1 |= v9;
        }
        else {
            v8_1 = arg33;
        }

        v9 = v11 & 0x100;
        int v17 = 0x6000000;
        if(v9 != 0) {
            v1 |= v17;
        }
        else {
            SearchBarScrollBehavior v0 = arg34;
            if((v10 & v17) == 0) {
                int v18 = v7.changed(v0) ? 0x4000000 : 0x2000000;
                v1 |= v18;
            }
        }

        int v35 = v2;
        boolean v0_1 = (v1 & 0x2492493) != 0x2492492 ? true : false;
        if(v7.shouldExecute(v0_1, v1 & 1)) {
            v7.startDefaults();
            ComposerKt.sourceInformation(v7, "286@14477L15,287@14542L8,290@14723L12");
            int v19 = 0xFE3FFFFF;
            int v20 = 0xFFFF1FFF;
            if((v10 & 1) == 0 || (v7.getDefaultsInvalid())) {
                if(v35 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    v0_2 = arg28;
                }

                v2 = 6;
                if((v11 & 8) != 0) {
                    v4_1 = SearchBarDefaults.INSTANCE.getInputFieldShape(v7, v2);
                    v1 &= 0xFFFFE3FF;
                }

                int v22 = v1;
                Shape v21 = v4_1;
                if((v11 & 16) != 0) {
                    v24 = v9;
                    v28 = v0_3;
                    v0_4 = v2;
                    v22 &= v20;
                    v5_1 = SearchBarDefaults.INSTANCE.colors-Klgx-Pg(0, 0, null, v7, 0xC00, 7);
                }
                else {
                    v28 = v0_3;
                    v0_4 = v2;
                    v24 = v9;
                }

                if(v14 != 0) {
                    v15 = SearchBarDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                }

                float v1_2 = v16 != 0 ? SearchBarDefaults.INSTANCE.getShadowElevation-D9Ej5fM() : arg32;
                if((v11 & 0x80) != 0) {
                    v0_5 = SearchBarDefaults.INSTANCE.getWindowInsets(v7, v0_4);
                    v22 &= v19;
                }
                else {
                    v0_5 = arg33;
                }

                v8_1 = v0_5;
                v18_1 = v1_2;
                v16_1 = v5_1;
                v17_1 = v15;
                v15_1 = v21;
                v2 = v22;
                if(v24 != 0) {
                    v1_1 = null;
                    v3 = false;
                    v4 = 0x2EA8ED4E;
                    v0_3 = v28;
                    goto label_250;
                }

                v3 = false;
                v4 = 0x2EA8ED4E;
                v0_3 = v28;
                v1_1 = arg34;
            }
            else {
                v7.skipToGroupEnd();
                if((v11 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                }

                if((v11 & 16) != 0) {
                    v1 &= v20;
                }

                if((v11 & 0x80) != 0) {
                    v1 &= v19;
                }

                v0_2 = arg28;
                v2 = v1;
                v16_1 = v5_1;
                v18_1 = v6_1;
                v17_1 = v15;
                v3 = false;
                v1_1 = arg34;
                v15_1 = v4_1;
                v4 = 0x2EA8ED4E;
            }

        label_250:
            v7.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v4, v2, -1, "androidx.compose.material3.TopSearchBar (SearchBar.kt:292)");
            }

            if(v1_1 != null) {
                Modifier v4_2 = v1_1.searchBarScrollBehavior(Modifier.Companion);
                if(v4_2 == null) {
                    goto label_260;
                }
            }
            else {
            label_260:
                v4_3 = Modifier.Companion;
            }

            SearchBarKt.SearchBar-nbWgWpA(v12, v13, SizeKt.wrapContentWidth$default(SizeKt.fillMaxWidth$default(PaddingKt.padding-3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(((Modifier)v0_3).then(((Modifier)v4_3)), v8_1), SearchBarKt.SearchBarAsTopBarPadding), 0f, 1, null), null, v3, 3, null), v15_1, v16_1, v17_1, v18_1, v7, v2 & 0x3FFC7E, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = ((Modifier)v0_3);
            v9_1 = v1_1;
            v19_1 = v7;
            v4_1 = v15_1;
            v5_1 = v16_1;
            v6_1 = v17_1;
            v7_1 = v18_1;
        }
        else {
            v7.skipToGroupEnd();
            v3_1 = arg28;
            v8_1 = arg33;
            v9_1 = arg34;
            v19_1 = v7;
            v6_1 = v15;
            v7_1 = arg32;
        }

        ScopeUpdateScope v12_1 = v19_1.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new SearchBarKt$$ExternalSyntheticLambda14(arg26, arg27, v3_1, v4_1, v5_1, v6_1, v7_1, v8_1, v9_1, v10, v11));
        }
    }

    static final Unit TopSearchBar_qKj4JfE$lambda$5(SearchBarState arg13, Function2 arg14, Modifier arg15, Shape arg16, SearchBarColors arg17, float arg18, float arg19, WindowInsets arg20, SearchBarScrollBehavior arg21, int arg22, int arg23, Composer arg24, int arg25) {
        SearchBarKt.TopSearchBar-qKj4JfE(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    public static final void access$DetectClickFromInteractionSource(InteractionSource arg0, Function0 arg1, Composer arg2, int arg3) {
        SearchBarKt.DetectClickFromInteractionSource(arg0, arg1, arg2, arg3);
    }

    public static final void access$DockedSearchBarLayout-nbWgWpA(SearchBarState arg0, Function2 arg1, Modifier arg2, Shape arg3, SearchBarColors arg4, float arg5, float arg6, Function3 arg7, Composer arg8, int arg9) {
        SearchBarKt.DockedSearchBarLayout-nbWgWpA(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public static final void access$FullScreenSearchBarLayout-EQC0FA8(SearchBarState arg0, PredictiveBackState arg1, Function2 arg2, Modifier arg3, Shape arg4, SearchBarColors arg5, float arg6, float arg7, WindowInsets arg8, Function3 arg9, Composer arg10, int arg11) {
        SearchBarKt.FullScreenSearchBarLayout-EQC0FA8(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public static final float access$calculatePredictiveBackMultiplier(BackEventCompat arg0, float arg1, float arg2) {
        return SearchBarKt.calculatePredictiveBackMultiplier(arg0, arg1, arg2);
    }

    public static final int access$calculatePredictiveBackOffsetX-rOvwMX4(long arg0, int arg2, BackEventCompat arg3, LayoutDirection arg4, float arg5, float arg6) {
        return SearchBarKt.calculatePredictiveBackOffsetX-rOvwMX4(arg0, arg2, arg3, arg4, arg5, arg6);
    }

    public static final int access$calculatePredictiveBackOffsetY-dzo92Q0(long arg0, int arg2, BackEventCompat arg3, BackEventCompat arg4, int arg5, int arg6, float arg7) {
        return SearchBarKt.calculatePredictiveBackOffsetY-dzo92Q0(arg0, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static final FiniteAnimationSpec access$getAnimationEnterFloatSpec$p() {
        return SearchBarKt.AnimationEnterFloatSpec;
    }

    public static final FiniteAnimationSpec access$getAnimationExitFloatSpec$p() {
        return SearchBarKt.AnimationExitFloatSpec;
    }

    public static final FiniteAnimationSpec access$getAnimationPredictiveBackExitFloatSpec$p() {
        return SearchBarKt.AnimationPredictiveBackExitFloatSpec;
    }

    public static final IntRect access$getCollapsedBounds(SearchBarState arg0) {
        return SearchBarKt.getCollapsedBounds(arg0);
    }

    public static final EnterTransition access$getDockedEnterTransition$p() {
        return SearchBarKt.DockedEnterTransition;
    }

    public static final ExitTransition access$getDockedExitTransition$p() {
        return SearchBarKt.DockedExitTransition;
    }

    public static final float access$getSearchBarIconOffsetX$p() {
        return SearchBarKt.SearchBarIconOffsetX;
    }

    public static final float access$getSearchBarMaxWidth$p() {
        return SearchBarKt.SearchBarMaxWidth;
    }

    public static final float access$getSearchBarPredictiveBackMaxOffsetY$p() {
        return SearchBarKt.SearchBarPredictiveBackMaxOffsetY;
    }

    public static final float access$getSearchBarPredictiveBackMinMargin$p() {
        return SearchBarKt.SearchBarPredictiveBackMinMargin;
    }

    public static final TextFieldColors access$getUnspecifiedTextFieldColors$p() {
        return SearchBarKt.UnspecifiedTextFieldColors;
    }

    public static final boolean access$isExpanded(SearchBarState arg0) {
        return SearchBarKt.isExpanded(arg0);
    }

    public static final float access$transform(InProgress arg0) {
        return SearchBarKt.transform(arg0);
    }

    private static final float calculatePredictiveBackMultiplier(BackEventCompat arg1, float arg2, float arg3) {
        if(arg1 == null) {
            return 0;
        }

        if(Float.isNaN(arg3)) {
            return 1f;
        }

        if(arg3 <= 0f) {
            return 0;
        }

        return arg2 / arg3;
    }

    private static final int calculatePredictiveBackOffsetX-rOvwMX4(long arg3, int arg5, BackEventCompat arg6, LayoutDirection arg7, float arg8, float arg9) {
        if(arg6 != null) {
            if(arg9 == 0f) {
            }
            else {
                int v0 = 1;
                int v1 = -1;
                int v6 = arg6.getSwipeEdge() == 0 ? 1 : v1;
                if(arg7 == LayoutDirection.Ltr) {
                }
                else {
                    v0 = v1;
                }

                return MathKt.roundToInt(((((float)Constraints.getMaxWidth-impl(arg3))) * 0.05f - (((float)arg5))) * (1f - arg8) * arg9 * (((float)v6)) * (((float)v0)));
            }
        }

        return 0;
    }

    private static final int calculatePredictiveBackOffsetY-dzo92Q0(long arg2, int arg4, BackEventCompat arg5, BackEventCompat arg6, int arg7, int arg8, float arg9) {
        if(arg6 != null && arg5 != null) {
            if(arg9 == 0f) {
            }
            else {
                arg4 = Math.min(Math.max(0, (Constraints.getMaxHeight-impl(arg2) - arg7) / 2 - arg4), arg8);
                float v5 = arg5.getTouchY() - arg6.getTouchY();
                return MathKt.roundToInt((((float)MathHelpersKt.lerp(0, arg4, Math.abs(v5) / (((float)Constraints.getMaxHeight-impl(arg2)))))) * arg9 * Math.signum(v5));
            }
        }

        return 0;
    }

    private static final IntRect getCollapsedBounds(SearchBarState arg4) {
        LayoutCoordinates v4 = arg4.getCollapsedCoords();
        if(v4 != null) {
            IntRect v4_1 = IntRectKt.IntRect-VbeCjmY(IntOffsetKt.round-k-4lQ0M(LayoutCoordinatesKt.positionInWindow(v4)), v4.getSize-YbymL2g());
            if(v4_1 == null) {
            }
            else {
                return v4_1;
            }
        }

        return IntRect.Companion.getZero();
    }

    private static void getCollapsedBounds$annotations(SearchBarState arg0) {
    }

    public static final float getDockedExpandedTableMinHeight() {
        return SearchBarKt.DockedExpandedTableMinHeight;
    }

    public static final float getSearchBarAsTopBarPadding() {
        return SearchBarKt.SearchBarAsTopBarPadding;
    }

    private static void getSearchBarCornerRadius$annotations() {
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarKt.SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarKt.SearchBarVerticalPadding;
    }

    private static final boolean isExpanded(SearchBarState arg1) {
        if(arg1.getCurrentValue() == SearchBarValue.Expanded) {
            return 1;
        }

        return 0;
    }

    private static void isExpanded$annotations(SearchBarState arg0) {
    }

    public static final SearchBarState rememberSearchBarState(SearchBarValue arg5, AnimationSpec arg6, AnimationSpec arg7, Composer arg8, int arg9, int arg10) {
        SearchBarKt$$ExternalSyntheticLambda22 v0_2;
        FiniteAnimationSpec v7;
        FiniteAnimationSpec v6;
        int v1 = 0xDF7471CD;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(rememberSearchBarState)N(initialValue,animationSpecForExpand,animationSpecForCollapse)817@37213L7,818@37312L7,829@37663L208,820@37352L519:SearchBar.kt#uh7d8r");
        if((arg10 & 1) != 0) {
            arg5 = SearchBarValue.Collapsed;
        }

        int v2 = 6;
        if((arg10 & 2) != 0) {
            v6 = MotionSchemeKt.value(MotionSchemeKeyTokens.SlowSpatial, arg8, v2);
        }

        int v0 = 4;
        if((arg10 & v0) != 0) {
            v7 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, arg8, v2);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.material3.rememberSearchBarState (SearchBar.kt:819)");
        }

        Object[] v10 = new Object[]{arg5, v6, v7};
        Saver v1_1 = SearchBarState.Companion.Saver(((AnimationSpec)v6), ((AnimationSpec)v7));
        ComposerKt.sourceInformationMarkerStart(arg8, 0xD41F861D, "CC(remember):SearchBar.kt#9igjgp");
        arg9 = (arg9 & 14 ^ v2) > v0 && (arg8.changed(arg5.ordinal())) || (arg9 & v2) == v0 ? 1 : 0;
        arg9 = arg9 | arg8.changedInstance(v6) | arg8.changedInstance(v7);
        Object v0_1 = arg8.rememberedValue();
        if(arg9 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            v0_2 = new SearchBarKt$$ExternalSyntheticLambda22(arg5, ((AnimationSpec)v6), ((AnimationSpec)v7));
            arg8.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        Object v5 = RememberSaveableKt.rememberSaveable(v10, v1_1, ((Function0)v0_2), arg8, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return ((SearchBarState)v5);
    }

    static final SearchBarState rememberSearchBarState$lambda$27$lambda$26(SearchBarValue arg1, AnimationSpec arg2, AnimationSpec arg3) {
        return new SearchBarState(arg1, arg2, arg3);
    }

    private static final float transform(InProgress arg1) {
        if(arg1 == null) {
            return 0;
        }

        return PredictiveBack.INSTANCE.transform$material3(arg1.getProgress());
    }
}

