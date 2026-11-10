package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.AppBarLargeFlexibleTokens;
import androidx.compose.material3.tokens.AppBarLargeTokens;
import androidx.compose.material3.tokens.AppBarMediumFlexibleTokens;
import androidx.compose.material3.tokens.AppBarMediumTokens;
import androidx.compose.material3.tokens.AppBarSmallTokens;
import androidx.compose.material3.tokens.AppBarTokens;
import androidx.compose.material3.tokens.BottomAppBarTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000ä\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001A\u007F\u0010\u0000\u001A\u00020\u00012\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0013\b\u0002\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001E\b\u0002\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001A\u008B\u0001\u0010\u0000\u001A\u00020\u00012\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0013\b\u0002\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001E\b\u0002\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001A\u007F\u0010\u0017\u001A\u00020\u00012\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0013\b\u0002\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001E\b\u0002\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001A\u008B\u0001\u0010\u0017\u001A\u00020\u00012\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0013\b\u0002\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001E\b\u0002\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0018\u0010\u0016\u001A¨\u0001\u0010\u0000\u001A\u00020\u00012\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0011\u0010\u0019\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0013\b\u0002\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001E\b\u0002\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\u001C\u0010\u001D\u001A\u007F\u0010\u001E\u001A\u00020\u00012\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0013\b\u0002\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001E\b\u0002\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001A\u0095\u0001\u0010\u001E\u001A\u00020\u00012\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0013\b\u0002\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001E\b\u0002\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\b\b\u0002\u0010\u001F\u001A\u00020\u00142\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b \u0010!\u001A¶\u0001\u0010\"\u001A\u00020\u00012\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0015\b\u0002\u0010\u0019\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001E\b\u0002\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001F\u001A\u00020\u00142\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b#\u0010$\u001A\u007F\u0010%\u001A\u00020\u00012\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0013\b\u0002\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001E\b\u0002\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001A\u0095\u0001\u0010%\u001A\u00020\u00012\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0013\b\u0002\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001E\b\u0002\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\b\b\u0002\u0010\u001F\u001A\u00020\u00142\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b&\u0010!\u001A¶\u0001\u0010\'\u001A\u00020\u00012\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0015\b\u0002\u0010\u0019\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001E\b\u0002\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001F\u001A\u00020\u00142\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b(\u0010$\u001Aà\u0001\u0010)\u001A\u00020\u00012&\u0010\u0002\u001A\"\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062*\b\u0002\u0010\u0019\u001A$\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001E\b\u0002\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001F\u001A\u00020\u00142\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b.\u0010/\u001A\u0080\u0001\u00100\u001A\u00020\u00012\u001C\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0015\b\u0002\u00101\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u00102\u001A\u0002032\b\b\u0002\u00104\u001A\u0002032\b\b\u0002\u00105\u001A\u00020\u00142\b\b\u0002\u00106\u001A\u0002072\b\b\u0002\u0010\f\u001A\u00020\rH\u0007¢\u0006\u0004\b8\u00109\u001A\u008C\u0001\u00100\u001A\u00020\u00012\u001C\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0015\b\u0002\u00101\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u00102\u001A\u0002032\b\b\u0002\u00104\u001A\u0002032\b\b\u0002\u00105\u001A\u00020\u00142\b\b\u0002\u00106\u001A\u0002072\b\b\u0002\u0010\f\u001A\u00020\r2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010:H\u0007¢\u0006\u0004\b;\u0010<\u001Ai\u00100\u001A\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u00102\u001A\u0002032\b\b\u0002\u00104\u001A\u0002032\b\b\u0002\u00105\u001A\u00020\u00142\b\b\u0002\u00106\u001A\u0002072\b\b\u0002\u0010\f\u001A\u00020\r2\u001C\u0010=\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000BH\u0007¢\u0006\u0004\b>\u0010?\u001Au\u00100\u001A\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u00102\u001A\u0002032\b\b\u0002\u00104\u001A\u0002032\b\b\u0002\u00105\u001A\u00020\u00142\b\b\u0002\u00106\u001A\u0002072\b\b\u0002\u0010\f\u001A\u00020\r2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010:2\u001C\u0010=\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000BH\u0007¢\u0006\u0004\b@\u0010A\u001A\u007F\u0010B\u001A\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u00102\u001A\u0002032\b\b\u0002\u00104\u001A\u0002032\b\b\u0002\u00106\u001A\u0002072\b\b\u0002\u0010C\u001A\u00020D2\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\f\u001A\u00020\r2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010:2\u001C\u0010=\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000BH\u0001¢\u0006\u0004\bE\u0010F\u001Ay\u0010G\u001A\u00020\u00012\u0006\u0010H\u001A\u00020\u00142\u0006\u0010C\u001A\u00020D2\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u0002032\u0006\u00105\u001A\u00020\u00142\u0006\u00106\u001A\u0002072\u0006\u0010\f\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010:2\u001C\u0010=\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000BH\u0003¢\u0006\u0004\bI\u0010J\u001A+\u0010K\u001A\u00020L2\b\b\u0002\u0010M\u001A\u00020N2\b\b\u0002\u0010O\u001A\u00020N2\b\b\u0002\u0010P\u001A\u00020NH\u0007¢\u0006\u0002\u0010Q\u001A+\u0010R\u001A\u00020S2\b\b\u0002\u0010M\u001A\u00020N2\b\b\u0002\u0010O\u001A\u00020N2\b\b\u0002\u0010P\u001A\u00020NH\u0007¢\u0006\u0002\u0010T\u001A \u0010U\u001A\u00020S2\u0006\u0010M\u001A\u00020N2\u0006\u0010O\u001A\u00020N2\u0006\u0010P\u001A\u00020NH\u0007\u001A>\u0010V\u001A\u00020W2\u0006\u0010X\u001A\u00020S2\u0006\u0010Y\u001A\u00020N2\u000E\u0010Z\u001A\n\u0012\u0004\u0012\u00020N\u0018\u00010[2\u000E\u0010\\\u001A\n\u0012\u0004\u0012\u00020N\u0018\u00010]H\u0082@¢\u0006\u0002\u0010^\u001A¬\u0001\u0010f\u001A\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010g\u001A\u00020h2\u0013\u0010\u0019\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010i\u001A\u00020h2\u0006\u0010\u001A\u001A\u00020\u001B2\u0011\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001C\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\bj\u0010k\u001Aô\u0001\u0010)\u001A\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010g\u001A\u00020h2\u0006\u0010s\u001A\u00020\u00142\u0011\u0010t\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010u\u001A\u00020h2\u0013\u0010\u0019\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010i\u001A\u00020h2\u0013\u0010v\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010w\u001A\u00020h2\u0006\u0010\u001A\u001A\u00020\u001B2\u0011\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001C\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000B2\u0006\u0010\u001F\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\bx\u0010y\u001A\u0016\u0010~\u001A\u00020\u0006*\u00020\u00062\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0002\u001Aá\u0001\u0010\u007F\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u0080\u0001\u001A\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001A\u0002032\u0007\u0010\u0083\u0001\u001A\u0002032\u0007\u0010\u0084\u0001\u001A\u0002032\u0007\u0010\u0085\u0001\u001A\u0002032\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010g\u001A\u00020h2\u0013\u0010\u0019\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010i\u001A\u00020h2\r\u0010\u0086\u0001\u001A\b\u0012\u0004\u0012\u00020N0\u00032\b\u0010\u0087\u0001\u001A\u00030\u0088\u00012\u0006\u0010\u001A\u001A\u00020\u001B2\u0007\u0010s\u001A\u00030\u0089\u00012\u0007\u0010\u008A\u0001\u001A\u00020*2\u0011\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0011\u0010\b\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0007\u0010\u008B\u0001\u001A\u00020\u0014H\u0003¢\u0006\u0006\b\u008C\u0001\u0010\u008D\u0001\u001A@\u0010\u008E\u0001\u001A\u00020W2\u0006\u0010X\u001A\u00020L2\u0006\u0010Y\u001A\u00020N2\u000E\u0010Z\u001A\n\u0012\u0004\u0012\u00020N\u0018\u00010[2\u000E\u0010\\\u001A\n\u0012\u0004\u0012\u00020N\u0018\u00010]H\u0082@¢\u0006\u0003\u0010\u008F\u0001\u001A\u0016\u0010\u0090\u0001\u001A\t\u0012\u0004\u0012\u00020*0\u0091\u0001H\u0003¢\u0006\u0003\u0010\u0092\u0001\"\u0010\u0010_\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0016\u0010a\u001A\u00020\u0014X\u0080\u0004¢\u0006\n\n\u0002\u0010`\u001A\u0004\bb\u0010c\"\u0010\u0010d\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0010\u0010e\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\" \u0010l\u001A\b\u0012\u0004\u0012\u00020n0mX\u0080\u0004¢\u0006\u000E\n\u0000\u0012\u0004\bo\u0010p\u001A\u0004\bq\u0010r\" \u0010z\u001A\b\u0012\u0004\u0012\u00020{0mX\u0080\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b|\u0010p\u001A\u0004\b}\u0010r\"\u0018\u0010\u0093\u0001\u001A\u00030\u0094\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001A\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0011\u0010\u0097\u0001\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0011\u0010\u0098\u0001\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0011\u0010\u0099\u0001\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0011\u0010\u009A\u0001\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`¨\u0006\u009B\u0001²\u0006\u000B\u0010\u009C\u0001\u001A\u00020*X\u008A\u0084\u0002"}, d2={"TopAppBar", "", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "navigationIcon", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "colors", "Landroidx/compose/material3/TopAppBarColors;", "scrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "expandedHeight", "Landroidx/compose/ui/unit/Dp;", "TopAppBar-GHTll3U", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "CenterAlignedTopAppBar", "CenterAlignedTopAppBar-GHTll3U", "subtitle", "titleHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "TopAppBar-cJHQLPU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Alignment$Horizontal;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "MediumTopAppBar", "collapsedHeight", "MediumTopAppBar-oKE7A98", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "MediumFlexibleTopAppBar", "MediumFlexibleTopAppBar-eXZ4JBQ", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Alignment$Horizontal;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "LargeTopAppBar", "LargeTopAppBar-oKE7A98", "LargeFlexibleTopAppBar", "LargeFlexibleTopAppBar-eXZ4JBQ", "TwoRowsTopAppBar", "", "Lkotlin/ParameterName;", "name", "expanded", "TwoRowsTopAppBar-eXZ4JBQ", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Alignment$Horizontal;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "BottomAppBar", "floatingActionButton", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomAppBar-Snr_uVM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "BottomAppBar-qhFBPw4", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "content", "BottomAppBar-1oL4kX8", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-e-3WI5M", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlexibleBottomAppBar", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "FlexibleBottomAppBar-wBhsO_E", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/Arrangement$Horizontal;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBarLayout", "containerHeight", "BottomAppBarLayout-t5fmz9U", "(FLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberTopAppBarState", "Landroidx/compose/material3/TopAppBarState;", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarState;", "rememberBottomAppBarState", "Landroidx/compose/material3/BottomAppBarState;", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomAppBarState;", "BottomAppBarState", "settleAppBarBottom", "Landroidx/compose/ui/unit/Velocity;", "state", "velocity", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/BottomAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "BottomAppBarHorizontalPadding", "F", "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "SingleRowTopAppBar", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "subtitleTextStyle", "SingleRowTopAppBar-wn8IZOc", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "LocalSingleRowTopAppBarOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/SingleRowTopAppBarOverride;", "getLocalSingleRowTopAppBarOverride$annotations", "()V", "getLocalSingleRowTopAppBarOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "titleBottomPadding", "smallTitle", "smallTitleTextStyle", "smallSubtitle", "smallSubtitleTextStyle", "TwoRowsTopAppBar-pJA5dT0", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "LocalTwoRowsTopAppBarOverride", "Landroidx/compose/material3/TwoRowsTopAppBarOverride;", "getLocalTwoRowsTopAppBarOverride$annotations", "getLocalTwoRowsTopAppBarOverride", "adjustHeightOffsetLimit", "TopAppBarLayout", "scrolledOffset", "Landroidx/compose/material3/internal/FloatProducer;", "navigationIconContentColor", "titleContentColor", "subtitleContentColor", "actionIconContentColor", "titleAlpha", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "", "hideTitleSemantics", "height", "TopAppBarLayout-lyUyIHI", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/internal/FloatProducer;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;II)V", "settleAppBar", "(Landroidx/compose/material3/TopAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rememberTouchExplorationService", "Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "MediumTitleBottomPadding", "LargeTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "material3", "touchExplorationServiceEnabled"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AppBarKt {
    private static final float BottomAppBarHorizontalPadding;
    private static final float BottomAppBarVerticalPadding;
    private static final float FABHorizontalPadding;
    private static final float FABVerticalPadding;
    private static final float LargeTitleBottomPadding;
    private static final ProvidableCompositionLocal LocalSingleRowTopAppBarOverride;
    private static final ProvidableCompositionLocal LocalTwoRowsTopAppBarOverride;
    private static final float MediumTitleBottomPadding;
    private static final float TopAppBarHorizontalPadding;
    private static final float TopAppBarTitleInset;
    private static final CubicBezierEasing TopTitleAlphaEasing;

    static {
        float v1 = Dp.constructor-impl(Dp.constructor-impl(16f) - Dp.constructor-impl(12f));
        AppBarKt.BottomAppBarHorizontalPadding = v1;
        float v3 = Dp.constructor-impl(Dp.constructor-impl(16f) - Dp.constructor-impl(12f));
        AppBarKt.BottomAppBarVerticalPadding = v3;
        AppBarKt.FABHorizontalPadding = Dp.constructor-impl(Dp.constructor-impl(16f) - v1);
        AppBarKt.FABVerticalPadding = Dp.constructor-impl(Dp.constructor-impl(12f) - v3);
        AppBarKt.LocalSingleRowTopAppBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new AppBarKt$$ExternalSyntheticLambda25(), 1, null);
        AppBarKt.LocalTwoRowsTopAppBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new AppBarKt$$ExternalSyntheticLambda26(), 1, null);
        AppBarKt.TopTitleAlphaEasing = new CubicBezierEasing(0.8f, 0f, 0.8f, 0.15f);
        AppBarKt.MediumTitleBottomPadding = Dp.constructor-impl(24f);
        AppBarKt.LargeTitleBottomPadding = Dp.constructor-impl(28f);
        v1 = Dp.constructor-impl(4f);
        AppBarKt.TopAppBarHorizontalPadding = v1;
        AppBarKt.TopAppBarTitleInset = Dp.constructor-impl(Dp.constructor-impl(16f) - v1);
    }

    public static final void BottomAppBar-1oL4kX8(Modifier arg24, long arg25, long arg27, float arg29, PaddingValues arg30, WindowInsets arg31, Function3 arg32, Composer arg33, int arg34, int arg35) {
        WindowInsets v8;
        PaddingValues v7_2;
        float v6;
        long v4_1;
        long v2_2;
        Modifier v1_1;
        Composer v21;
        Modifier v11_1;
        float v16_1;
        long v14_2;
        long v12_1;
        int v0_1;
        WindowInsets v18;
        PaddingValues v17_1;
        Companion v11_2;
        Companion v0_2;
        int v15;
        WindowInsets v14_1;
        PaddingValues v13;
        int v12;
        float v11;
        int v9;
        long v7_1;
        int v7;
        long v5;
        Modifier v3;
        int v4;
        int v10 = arg34;
        Composer v1 = arg33.startRestartGroup(107726720);
        ComposerKt.sourceInformation(v1, "C(BottomAppBar)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,contentPadding,windowInsets,content)1173@59794L303:AppBar.kt#uh7d8r");
        int v2 = arg35 & 1;
        if(v2 != 0) {
            v4 = v10 | 6;
            v3 = arg24;
        }
        else if((v10 & 6) == 0) {
            v3 = arg24;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v10;
        }
        else {
            v3 = arg24;
            v4 = v10;
        }

        if((v10 & 0x30) == 0) {
            if((arg35 & 2) == 0) {
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

        if((v10 & 0x180) == 0) {
            if((arg35 & 4) == 0) {
                v7_1 = arg27;
                if(v1.changed(v7_1)) {
                    v9 = 0x100;
                }
                else {
                    goto label_48;
                }
            }
            else {
                v7_1 = arg27;
            label_48:
                v9 = 0x80;
            }

            v4 |= v9;
        }
        else {
            v7_1 = arg27;
        }

        v9 = arg35 & 8;
        if(v9 != 0) {
            v4 |= 0xC00;
            goto label_66;
        }
        else if((v10 & 0xC00) == 0) {
            v11 = arg29;
            v12 = v1.changed(v11) ? 0x800 : 0x400;
            v4 |= v12;
        }
        else {
        label_66:
            v11 = arg29;
        }

        v12 = arg35 & 16;
        if(v12 != 0) {
            v4 |= 0x6000;
            goto label_81;
        }
        else if((v10 & 0x6000) == 0) {
            v13 = arg30;
            int v14 = v1.changed(v13) ? 0x4000 : 0x2000;
            v4 |= v14;
        }
        else {
        label_81:
            v13 = arg30;
        }

        if((0x30000 & v10) == 0) {
            if((arg35 & 0x20) == 0) {
                v14_1 = arg31;
                if(v1.changed(v14_1)) {
                    v15 = 0x20000;
                }
                else {
                    goto label_93;
                }
            }
            else {
                v14_1 = arg31;
            label_93:
                v15 = 0x10000;
            }

            v4 |= v15;
        }
        else {
            v14_1 = arg31;
        }

        int v16 = 0x180000;
        if((arg35 & 0x40) != 0) {
            v4 |= v16;
        }
        else if((v10 & v16) == 0) {
            int v17 = v1.changedInstance(arg32) ? 0x100000 : 0x80000;
            v4 |= v17;
        }

        int v33 = v2;
        boolean v0 = (v4 & 0x92493) != 0x92492 ? true : false;
        if(v1.shouldExecute(v0, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "1166@59458L14,1167@59500L31,1170@59726L12");
            v2 = 0xFFF8FFFF;
            if((v10 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v33 != 0) {
                    v0_2 = Modifier.Companion;
                }
                else {
                    Modifier v0_3 = v3;
                }

                v33 = v2;
                v2 = 6;
                if((arg35 & 2) != 0) {
                    v5 = BottomAppBarDefaults.INSTANCE.getContainerColor(v1, v2);
                    v4 &= 0xFFFFFF8F;
                }

                if((arg35 & 4) != 0) {
                    v7_1 = ColorSchemeKt.contentColorFor-ek8zF_U(v5, v1, v4 >> 3 & 14);
                    v4 &= -897;
                }

                if(v9 != 0) {
                    v11 = BottomAppBarDefaults.INSTANCE.getContainerElevation-D9Ej5fM();
                }

                if(v12 != 0) {
                    v13 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                }

                if((arg35 & 0x20) != 0) {
                    v4 &= v33;
                    float v12_2 = v11;
                    v11_2 = v0_2;
                    v0_1 = v16;
                    v16_1 = v12_2;
                    v18 = BottomAppBarDefaults.INSTANCE.getWindowInsets(v1, v2);
                    v14_2 = v7_1;
                    v17_1 = v13;
                    v2 = 107726720;
                    v12_1 = v5;
                    goto label_202;
                }

                float v2_1 = v11;
                v11_2 = v0_2;
                v0_1 = v16;
                v16_1 = v2_1;
                v17_1 = v13;
                v18 = v14_1;
                v2 = 107726720;
                v12_1 = v5;
                v14_2 = v7_1;
            }
            else {
                v1.skipToGroupEnd();
                if((arg35 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }

                if((arg35 & 4) != 0) {
                    v4 &= -897;
                }

                if((arg35 & 0x20) != 0) {
                    v4 &= v2;
                }

                v17_1 = v13;
                v18 = v14_1;
                v0_1 = v16;
                v2 = 107726720;
                v12_1 = v5;
                v14_2 = v7_1;
                v16_1 = v11;
                v11_1 = v3;
            }

        label_202:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v4, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:1173)");
            }

            v21 = v1;
            AppBarKt.BottomAppBar-e-3WI5M(v11_1, v12_1, v14_2, v16_1, v17_1, v18, null, arg32, v21, v0_1 | v4 & 14 | v4 & 0x70 | v4 & 0x380 | v4 & 0x1C00 | 0xE000 & v4 | 0x70000 & v4 | 0x1C00000 & v4 << 3, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_1 = v11_1;
            v2_2 = v12_1;
            v4_1 = v14_2;
            v6 = v16_1;
            v7_2 = v17_1;
            v8 = v18;
        }
        else {
            v21 = v1;
            v21.skipToGroupEnd();
            v1_1 = v3;
            v2_2 = v5;
            v4_1 = v7_1;
            v6 = v11;
            v7_2 = v13;
            v8 = v14_1;
        }

        ScopeUpdateScope v12_3 = v21.endRestartGroup();
        if(v12_3 != null) {
            v12_3.updateScope(new AppBarKt$$ExternalSyntheticLambda17(v1_1, v2_2, v4_1, v6, v7_2, v8, arg32, v10, arg35));
        }
    }

    public static final void BottomAppBar-Snr_uVM(Function3 arg27, Modifier arg28, Function2 arg29, long arg30, long arg32, float arg34, PaddingValues arg35, WindowInsets arg36, Composer arg37, int arg38, int arg39) {
        WindowInsets v10;
        PaddingValues v9_2;
        float v8;
        long v6_1;
        long v4_2;
        Function2 v3_1;
        Modifier v2_1;
        Composer v24;
        WindowInsets v22;
        PaddingValues v21;
        Modifier v14_1;
        int v18;
        PaddingValues v0;
        int v16;
        float v15_1;
        int v14;
        long v9_1;
        int v9;
        long v7_1;
        Function2 v6;
        int v5;
        Modifier v4;
        Function3 v13;
        int v2;
        int v11 = arg38;
        int v12 = arg39;
        Composer v1 = arg37.startRestartGroup(0x8033B8E1);
        ComposerKt.sourceInformation(v1, "C(BottomAppBar)N(actions,modifier,floatingActionButton,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,contentPadding,windowInsets)1044@53613L356:AppBar.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v2 = v11 | 6;
            v13 = arg27;
        }
        else {
            v13 = arg27;
            if((v11 & 6) == 0) {
                v2 = v1.changedInstance(v13) ? 4 : 2;
                v2 |= v11;
            }
            else {
                v2 = v11;
            }
        }

        int v3 = v12 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_37;
        }
        else if((v11 & 0x30) == 0) {
            v4 = arg28;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_37:
            v4 = arg28;
        }

        v5 = v12 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_52;
        }
        else if((v11 & 0x180) == 0) {
            v6 = arg29;
            int v7 = v1.changedInstance(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_52:
            v6 = arg29;
        }

        if((v11 & 0xC00) == 0) {
            if((v12 & 8) == 0) {
                v7_1 = arg30;
                if(v1.changed(v7_1)) {
                    v9 = 0x800;
                }
                else {
                    goto label_63;
                }
            }
            else {
                v7_1 = arg30;
            label_63:
                v9 = 0x400;
            }

            v2 |= v9;
        }
        else {
            v7_1 = arg30;
        }

        if((v11 & 0x6000) == 0) {
            if((v12 & 16) == 0) {
                v9_1 = arg32;
                if(v1.changed(v9_1)) {
                    v14 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v9_1 = arg32;
            label_77:
                v14 = 0x2000;
            }

            v2 |= v14;
        }
        else {
            v9_1 = arg32;
        }

        v14 = v12 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v2 |= v15;
            goto label_96;
        }
        else if((v15 & v11) == 0) {
            v15_1 = arg34;
            v16 = v1.changed(v15_1) ? 0x20000 : 0x10000;
            v2 |= v16;
        }
        else {
        label_96:
            v15_1 = arg34;
        }

        v16 = v12 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v2 |= v17;
        }
        else {
            v0 = arg35;
            if((v11 & v17) == 0) {
                v18 = v1.changed(v0) ? 0x100000 : 0x80000;
                v2 |= v18;
            }
        }

        if((v11 & 0xC00000) == 0) {
            v18 = (v12 & 0x80) != 0 || !v1.changed(arg36) ? 0x400000 : 0x800000;
            v2 |= v18;
        }

        int v37 = v3;
        boolean v0_1 = (v2 & 0x492493) != 4793490 ? true : false;
        if(v1.shouldExecute(v0_1, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "1038@53323L14,1039@53365L31,1042@53591L12");
            v3 = 0xFE3FFFFF;
            v18 = 0xFFFF1FFF;
            if((v11 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v37 != 0) {
                    Companion v4_1 = Modifier.Companion;
                }

                if(v5 != 0) {
                    v6 = null;
                }

                v5 = 6;
                if((v12 & 8) != 0) {
                    v7_1 = BottomAppBarDefaults.INSTANCE.getContainerColor(v1, v5);
                    v2 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v9_1 = ColorSchemeKt.contentColorFor-ek8zF_U(v7_1, v1, v2 >> 9 & 14);
                    v2 &= v18;
                }

                if(v14 != 0) {
                    v15_1 = BottomAppBarDefaults.INSTANCE.getContainerElevation-D9Ej5fM();
                }

                v0 = v16 != 0 ? BottomAppBarDefaults.INSTANCE.getContentPadding() : arg35;
                if((v12 & 0x80) != 0) {
                    v2 &= v3;
                    v21 = v0;
                    v14_1 = v4;
                    v22 = BottomAppBarDefaults.INSTANCE.getWindowInsets(v1, v5);
                    goto label_161;
                }

                v22 = arg36;
                v21 = v0;
            label_160:
                v14_1 = v4;
            }
            else {
                v1.skipToGroupEnd();
                if((v12 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v2 &= v18;
                }

                if((v12 & 0x80) != 0) {
                    v2 &= v3;
                }

                v21 = arg35;
                v22 = arg36;
                goto label_160;
            }

        label_161:
            long v16_1 = v7_1;
            long v18_1 = v9_1;
            float v20 = v15_1;
            int v0_2 = 0x8033B8E1;
            Function2 v15_2 = v6;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_2, v2, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:1044)");
            }

            v24 = v1;
            AppBarKt.BottomAppBar-qhFBPw4(v13, v14_1, v15_2, v16_1, v18_1, v20, v21, v22, null, v24, v2 & 14 | 0x6000000 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00 | 0xE000 & v2 | 0x70000 & v2 | 0x380000 & v2 | v2 & 0x1C00000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v14_1;
            v3_1 = v15_2;
            v4_2 = v16_1;
            v6_1 = v18_1;
            v8 = v20;
            v9_2 = v21;
            v10 = v22;
        }
        else {
            v24 = v1;
            v24.skipToGroupEnd();
            v2_1 = v4;
            v3_1 = v6;
            v4_2 = v7_1;
            v6_1 = v9_1;
            v8 = v15_1;
            v9_2 = arg35;
            v10 = arg36;
        }

        ScopeUpdateScope v13_1 = v24.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new AppBarKt$$ExternalSyntheticLambda16(arg27, v2_1, v3_1, v4_2, v6_1, v8, v9_2, v10, v11, v12));
        }
    }

    public static final void BottomAppBar-e-3WI5M(Modifier arg28, long arg29, long arg31, float arg33, PaddingValues arg34, WindowInsets arg35, BottomAppBarScrollBehavior arg36, Function3 arg37, Composer arg38, int arg39, int arg40) {
        BottomAppBarScrollBehavior v9_1;
        WindowInsets v8;
        PaddingValues v7_2;
        float v6;
        long v4_1;
        long v2_1;
        Modifier v1_1;
        Composer v25;
        BottomAppBarScrollBehavior v23;
        Companion v3_1;
        int v18;
        int v16;
        WindowInsets v15_1;
        PaddingValues v14;
        int v13;
        float v10;
        int v9;
        long v7_1;
        int v7;
        long v5;
        Modifier v3;
        int v4;
        int v11 = arg39;
        int v12 = arg40;
        Composer v1 = arg38.startRestartGroup(0x5D24A7E2);
        ComposerKt.sourceInformation(v1, "C(BottomAppBar)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,contentPadding,windowInsets,scrollBehavior,content)1227@62600L432:AppBar.kt#uh7d8r");
        int v2 = v12 & 1;
        if(v2 != 0) {
            v4 = v11 | 6;
            v3 = arg28;
        }
        else if((v11 & 6) == 0) {
            v3 = arg28;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v11;
        }
        else {
            v3 = arg28;
            v4 = v11;
        }

        if((v11 & 0x30) == 0) {
            if((v12 & 2) == 0) {
                v5 = arg29;
                if(v1.changed(v5)) {
                    v7 = 0x20;
                }
                else {
                    goto label_35;
                }
            }
            else {
                v5 = arg29;
            label_35:
                v7 = 16;
            }

            v4 |= v7;
        }
        else {
            v5 = arg29;
        }

        if((v11 & 0x180) == 0) {
            if((v12 & 4) == 0) {
                v7_1 = arg31;
                if(v1.changed(v7_1)) {
                    v9 = 0x100;
                }
                else {
                    goto label_49;
                }
            }
            else {
                v7_1 = arg31;
            label_49:
                v9 = 0x80;
            }

            v4 |= v9;
        }
        else {
            v7_1 = arg31;
        }

        v9 = v12 & 8;
        if(v9 != 0) {
            v4 |= 0xC00;
            goto label_67;
        }
        else if((v11 & 0xC00) == 0) {
            v10 = arg33;
            v13 = v1.changed(v10) ? 0x800 : 0x400;
            v4 |= v13;
        }
        else {
        label_67:
            v10 = arg33;
        }

        v13 = v12 & 16;
        if(v13 != 0) {
            v4 |= 0x6000;
            goto label_82;
        }
        else if((v11 & 0x6000) == 0) {
            v14 = arg34;
            int v15 = v1.changed(v14) ? 0x4000 : 0x2000;
            v4 |= v15;
        }
        else {
        label_82:
            v14 = arg34;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v15_1 = arg35;
                if(v1.changed(v15_1)) {
                    v16 = 0x20000;
                }
                else {
                    goto label_94;
                }
            }
            else {
                v15_1 = arg35;
            label_94:
                v16 = 0x10000;
            }

            v4 |= v16;
        }
        else {
            v15_1 = arg35;
        }

        v16 = v12 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v4 |= v17;
        }
        else {
            BottomAppBarScrollBehavior v0 = arg36;
            if((v11 & v17) == 0) {
                v18 = v1.changed(v0) ? 0x100000 : 0x80000;
                v4 |= v18;
            }
        }

        v18 = 0xC00000;
        if((v12 & 0x80) != 0) {
            v4 |= v18;
        }
        else if((v11 & v18) == 0) {
            v18 = v1.changedInstance(arg37) ? 0x800000 : 0x400000;
            v4 |= v18;
        }

        int v38 = v2;
        boolean v0_1 = (v4 & 0x492493) != 4793490 ? true : false;
        if(v1.shouldExecute(v0_1, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "1219@62208L14,1220@62250L31,1223@62476L12");
            v18 = 0xFFF8FFFF;
            v2 = 6;
            if((v11 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v38 != 0) {
                    v3_1 = Modifier.Companion;
                }

                if((v12 & 2) != 0) {
                    v5 = BottomAppBarDefaults.INSTANCE.getContainerColor(v1, v2);
                    v4 &= 0xFFFFFF8F;
                }

                if((v12 & 4) != 0) {
                    v7_1 = ColorSchemeKt.contentColorFor-ek8zF_U(v5, v1, v4 >> 3 & 14);
                    v4 &= -897;
                }

                if(v9 != 0) {
                    v10 = BottomAppBarDefaults.INSTANCE.getContainerElevation-D9Ej5fM();
                }

                if(v13 != 0) {
                    v14 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                }

                if((v12 & 0x20) != 0) {
                    v4 &= v18;
                    v15_1 = BottomAppBarDefaults.INSTANCE.getWindowInsets(v1, v2);
                }

                if(v16 != 0) {
                    v23 = null;
                    goto label_161;
                }

            label_160:
                v23 = arg36;
            }
            else {
                v1.skipToGroupEnd();
                if((v12 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }

                if((v12 & 4) != 0) {
                    v4 &= -897;
                }

                if((v12 & 0x20) == 0) {
                    goto label_160;
                }

                v4 &= v18;
                goto label_160;
            }

        label_161:
            long v16_1 = v5;
            long v18_1 = v7_1;
            float v20 = v10;
            PaddingValues v21 = v14;
            WindowInsets v22 = v15_1;
            int v0_2 = 0x5D24A7E2;
            Modifier v15_2 = ((Modifier)v3_1);
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_2, v4, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:1226)");
            }

            v0_2 = v4 << 6;
            v25 = v1;
            AppBarKt.BottomAppBarLayout-t5fmz9U(BottomAppBarTokens.INSTANCE.getContainerHeight-D9Ej5fM(), Arrangement.INSTANCE.getStart(), v15_2, v16_1, v18_1, v20, v21, v22, v23, arg37, v25, v0_2 & 0x380 | 54 | v0_2 & 0x1C00 | 0xE000 & v0_2 | 0x70000 & v0_2 | 0x380000 & v0_2 | 0x1C00000 & v0_2 | 0xE000000 & v0_2 | v0_2 & 0x70000000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_1 = v15_2;
            v2_1 = v16_1;
            v4_1 = v18_1;
            v6 = v20;
            v7_2 = v21;
            v8 = v22;
            v9_1 = v23;
        }
        else {
            v25 = v1;
            v25.skipToGroupEnd();
            v9_1 = arg36;
            v1_1 = v3;
            v2_1 = v5;
            v4_1 = v7_1;
            v6 = v10;
            v7_2 = v14;
            v8 = v15_1;
        }

        ScopeUpdateScope v13_1 = v25.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new AppBarKt$$ExternalSyntheticLambda20(v1_1, v2_1, v4_1, v6, v7_2, v8, v9_1, arg37, v11, v12));
        }
    }

    public static final void BottomAppBar-qhFBPw4(Function3 arg27, Modifier arg28, Function2 arg29, long arg30, long arg32, float arg34, PaddingValues arg35, WindowInsets arg36, BottomAppBarScrollBehavior arg37, Composer arg38, int arg39, int arg40) {
        BottomAppBarScrollBehavior v11;
        WindowInsets v10_2;
        PaddingValues v9;
        float v8_2;
        long v6_2;
        long v4_1;
        Modifier v2_1;
        Function2 v3_1;
        Composer v24;
        long v15_2;
        float v19_1;
        BottomAppBarScrollBehavior v22;
        WindowInsets v21_1;
        PaddingValues v20_1;
        Companion v14_3;
        WindowInsets v15_3;
        Companion v0_3;
        int v20;
        int v19;
        int v18;
        int v16;
        float v15_1;
        int v14;
        long v10_1;
        int v10;
        long v8_1;
        Function2 v7;
        int v6;
        int v3;
        Function3 v1 = arg27;
        int v12 = arg39;
        int v13 = arg40;
        Composer v2 = arg38.startRestartGroup(0x1039F7E1);
        ComposerKt.sourceInformation(v2, "C(BottomAppBar)N(actions,modifier,floatingActionButton,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,contentPadding,windowInsets,scrollBehavior)1118@57288L540,1110@57001L827:AppBar.kt#uh7d8r");
        if((v13 & 1) != 0) {
            v3 = v12 | 6;
        }
        else if((v12 & 6) == 0) {
            v3 = v2.changedInstance(v1) ? 4 : 2;
            v3 |= v12;
        }
        else {
            v3 = v12;
        }

        int v4 = v13 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
        }
        else if((v12 & 0x30) == 0) {
            v6 = v2.changed(arg28) ? 0x20 : 16;
            v3 |= v6;
        }

        v6 = v13 & 4;
        if(v6 != 0) {
            v3 |= 0x180;
            goto label_51;
        }
        else if((v12 & 0x180) == 0) {
            v7 = arg29;
            int v8 = v2.changedInstance(v7) ? 0x100 : 0x80;
            v3 |= v8;
        }
        else {
        label_51:
            v7 = arg29;
        }

        if((v12 & 0xC00) == 0) {
            if((v13 & 8) == 0) {
                v8_1 = arg30;
                if(v2.changed(v8_1)) {
                    v10 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v8_1 = arg30;
            label_62:
                v10 = 0x400;
            }

            v3 |= v10;
        }
        else {
            v8_1 = arg30;
        }

        if((v12 & 0x6000) == 0) {
            if((v13 & 16) == 0) {
                v10_1 = arg32;
                if(v2.changed(v10_1)) {
                    v14 = 0x4000;
                }
                else {
                    goto label_76;
                }
            }
            else {
                v10_1 = arg32;
            label_76:
                v14 = 0x2000;
            }

            v3 |= v14;
        }
        else {
            v10_1 = arg32;
        }

        v14 = v13 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v3 |= v15;
            goto label_95;
        }
        else if((v15 & v12) == 0) {
            v15_1 = arg34;
            v16 = v2.changed(v15_1) ? 0x20000 : 0x10000;
            v3 |= v16;
        }
        else {
        label_95:
            v15_1 = arg34;
        }

        v16 = v13 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v3 |= v17;
        }
        else {
            PaddingValues v0 = arg35;
            if((v12 & v17) == 0) {
                v18 = v2.changed(v0) ? 0x100000 : 0x80000;
                v3 |= v18;
            }
        }

        v18 = 0xC00000;
        if((v12 & v18) == 0) {
            v19 = (v13 & 0x80) != 0 || !v2.changed(arg36) ? 0x400000 : 0x800000;
            v3 |= v19;
        }

        int v0_1 = v13 & 0x100;
        v19 = 0x6000000;
        if(v0_1 != 0) {
            v3 |= v19;
            goto label_142;
        }
        else if((v12 & v19) == 0) {
            v19 = v0_1;
            v20 = v2.changed(arg37) ? 0x4000000 : 0x2000000;
            v3 |= v20;
        }
        else {
        label_142:
            v19 = v0_1;
        }

        int v38 = v4;
        boolean v0_2 = (v3 & 0x2492493) != 0x2492492 ? true : false;
        if(v2.shouldExecute(v0_2, v3 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "1103@56655L14,1104@56697L31,1107@56923L12");
            v20 = 0xFFFF1FFF;
            int v21 = 0xFE3FFFFF;
            v4 = 6;
            if((v12 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v38 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    Modifier v0_4 = arg28;
                }

                v22 = null;
                if(v6 != 0) {
                    v7 = ((Function2)v22);
                }

                if((v13 & 8) != 0) {
                    v8_1 = BottomAppBarDefaults.INSTANCE.getContainerColor(v2, v4);
                    v3 &= 0xFFFFE3FF;
                }

                if((v13 & 16) != 0) {
                    v10_1 = ColorSchemeKt.contentColorFor-ek8zF_U(v8_1, v2, v3 >> 9 & 14);
                    v3 &= v20;
                }

                float v6_1 = v14 != 0 ? BottomAppBarDefaults.INSTANCE.getContainerElevation-D9Ej5fM() : v15_1;
                PaddingValues v14_2 = v16 != 0 ? BottomAppBarDefaults.INSTANCE.getContentPadding() : arg35;
                if((v13 & 0x80) != 0) {
                    v15_3 = BottomAppBarDefaults.INSTANCE.getWindowInsets(v2, v4);
                    v3 &= v21;
                }
                else {
                    v15_3 = arg36;
                }

                if(v19 != 0) {
                }
                else {
                    v22 = arg37;
                }

                v19_1 = v6_1;
                v20_1 = v14_2;
                v21_1 = v15_3;
                v6 = 0x1039F7E1;
                v14_3 = v0_3;
                v15_2 = v8_1;
                v0_1 = v18;
            }
            else {
                v2.skipToGroupEnd();
                if((v13 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                if((v13 & 16) != 0) {
                    v3 &= v20;
                }

                if((v13 & 0x80) != 0) {
                    v3 &= v21;
                }

                Modifier v14_1 = arg28;
                v20_1 = arg35;
                v21_1 = arg36;
                v22 = arg37;
                v19_1 = v15_1;
                v0_1 = v18;
                v6 = 0x1039F7E1;
                v15_2 = v8_1;
            }

            long v17_1 = v10_1;
            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v6, v3, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:1110)");
            }

            v0_1 |= v3 >> 3 & 14;
            v3 >>= v4;
            v24 = v2;
            AppBarKt.BottomAppBar-e-3WI5M(((Modifier)v14_3), v15_2, v17_1, v19_1, v20_1, v21_1, v22, ComposableLambdaKt.rememberComposableLambda(0x8C2EFE5A, true, new AppBarKt$BottomAppBar$2(v1, v7), v2, 54), v24, v0_1 | v3 & 0x70 | v3 & 0x380 | v3 & 0x1C00 | 0xE000 & v3 | 0x70000 & v3 | v3 & 0x380000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = v7;
            v2_1 = ((Modifier)v14_3);
            v4_1 = v15_2;
            v6_2 = v17_1;
            v8_2 = v19_1;
            v9 = v20_1;
            v10_2 = v21_1;
            v11 = v22;
        }
        else {
            v24 = v2;
            v24.skipToGroupEnd();
            v2_1 = arg28;
            v3_1 = v7;
            v4_1 = v8_1;
            v6_2 = v10_1;
            v8_2 = v15_1;
            v9 = arg35;
            v10_2 = arg36;
            v11 = arg37;
        }

        ScopeUpdateScope v14_4 = v24.endRestartGroup();
        if(v14_4 != null) {
            v14_4.updateScope(new AppBarKt$$ExternalSyntheticLambda6(v1, v2_1, v3_1, v4_1, v6_2, v8_2, v9, v10_2, v11, v12, v13));
        }
    }

    private static final void BottomAppBarLayout-t5fmz9U(float arg30, Horizontal arg31, Modifier arg32, long arg33, long arg35, float arg37, PaddingValues arg38, WindowInsets arg39, BottomAppBarScrollBehavior arg40, Function3 arg41, Composer arg42, int arg43, int arg44) {
        Modifier v3_3;
        Composer v25;
        AppBarKt$$ExternalSyntheticLambda4 v5_3;
        Modifier v2_5;
        boolean v4_1;
        Companion v20;
        Companion v2_6;
        Modifier v0_2;
        int v17;
        WindowInsets v8_1;
        float v15;
        long v11;
        long v9;
        int v6;
        int v3;
        Horizontal v7;
        int v2;
        int v13 = arg43;
        int v14 = arg44;
        Composer v1 = arg42.startRestartGroup(0xF7960940);
        ComposerKt.sourceInformation(v1, "C(BottomAppBarLayout)N(containerHeight:c#ui.unit.Dp,horizontalArrangement,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,contentPadding,windowInsets,scrollBehavior,content)1331@67632L33,1363@69116L5,1366@69187L620,1379@69857L350,1358@68849L1358:AppBar.kt#uh7d8r");
        if((v14 & 1) != 0) {
            v2 = v13 | 6;
        }
        else {
            float v5 = arg30;
            if((v13 & 6) == 0) {
                v2 = v1.changed(v5) ? 4 : 2;
                v2 |= v13;
            }
            else {
                v2 = v13;
            }
        }

        if((v14 & 2) != 0) {
            v2 |= 0x30;
            v7 = arg31;
        }
        else {
            v7 = arg31;
            if((v13 & 0x30) == 0) {
                v3 = v1.changed(v7) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        v3 = v14 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
        }
        else if((v13 & 0x180) == 0) {
            v6 = v1.changed(arg32) ? 0x100 : 0x80;
            v2 |= v6;
        }

        if((v14 & 8) != 0) {
            v2 |= 0xC00;
            v9 = arg33;
        }
        else {
            v9 = arg33;
            if((v13 & 0xC00) == 0) {
                v6 = v1.changed(v9) ? 0x800 : 0x400;
                v2 |= v6;
            }
        }

        if((v14 & 16) != 0) {
            v2 |= 0x6000;
            v11 = arg35;
        }
        else {
            v11 = arg35;
            if((v13 & 0x6000) == 0) {
                v6 = v1.changed(v11) ? 0x4000 : 0x2000;
                v2 |= v6;
            }
        }

        int v8 = 0x30000;
        if((v14 & 0x20) != 0) {
            v2 |= v8;
            v15 = arg37;
        }
        else {
            v15 = arg37;
            if((v13 & v8) == 0) {
                v6 = v1.changed(v15) ? 0x20000 : 0x10000;
                v2 |= v6;
            }
        }

        v8 = 0x180000;
        if((v14 & 0x40) != 0) {
            v2 |= v8;
        }
        else if((v13 & v8) == 0) {
            v8 = v1.changed(arg38) ? 0x100000 : 0x80000;
            v2 |= v8;
        }

        int v16 = 0xC00000;
        if((v14 & 0x80) != 0) {
            v2 |= v16;
            goto label_126;
        }
        else if((v13 & v16) == 0) {
            v8_1 = arg39;
            v17 = v1.changed(v8_1) ? 0x800000 : 0x400000;
            v2 |= v17;
        }
        else {
        label_126:
            v8_1 = arg39;
        }

        int v18 = 0x6000000;
        if((v14 & 0x100) != 0) {
            v2 |= v18;
        }
        else if((v13 & v18) == 0) {
            v18 = v1.changed(arg40) ? 0x4000000 : 0x2000000;
            v2 |= v18;
        }

        v18 = 0x30000000;
        if((v14 & 0x200) != 0) {
            v2 |= v18;
        }
        else if((v13 & v18) == 0) {
            v18 = v1.changedInstance(arg41) ? 0x20000000 : 0x10000000;
            v2 |= v18;
        }

        int v42 = v3;
        boolean v0 = (v2 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0, v2 & 1)) {
            if(v42 != 0) {
                Companion v0_1 = Modifier.Companion;
            }
            else {
                v0_2 = arg32;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xF7960940, v2, -1, "androidx.compose.material3.BottomAppBarLayout (AppBar.kt:1330)");
            }

            BottomAppBarScrollBehavior v3_1 = !AppBarKt.BottomAppBarLayout_t5fmz9U$lambda$17(AppBarKt.rememberTouchExplorationService(v1, 0)) ? arg40 : null;
            String v5_1 = "CC(remember):AppBar.kt#9igjgp";
            if(v3_1 == null || (v3_1.isPinned())) {
                v17 = v2;
                v1.startReplaceGroup(0xDCF43302);
                v1.endReplaceGroup();
                v2_6 = Modifier.Companion;
            }
            else {
                v1.startReplaceGroup(0xDCEAEDB1);
                ComposerKt.sourceInformation(v1, "1339@68112L105,1339@68089L128,1342@68251L308");
                Companion v4 = Modifier.Companion;
                Orientation v21 = Orientation.Vertical;
                v17 = v2;
                ComposerKt.sourceInformationMarkerStart(v1, 0x6A393189, v5_1);
                boolean v19 = v1.changed(v3_1);
                Object v2_1 = v1.rememberedValue();
                if(!v19) {
                    v20 = v4;
                    if(v2_1 == Composer.Companion.getEmpty()) {
                        goto label_210;
                    }
                }
                else {
                    v20 = v4;
                label_210:
                    AppBarKt$$ExternalSyntheticLambda3 v2_2 = new AppBarKt$$ExternalSyntheticLambda3(v3_1);
                    v1.updateRememberedValue(v2_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v1);
                DraggableState v2_3 = DraggableKt.rememberDraggableState(((Function1)v2_1), v1, 0);
                Companion v19_1 = v20;
                ComposerKt.sourceInformationMarkerStart(v1, 1782137780, v5_1);
                v4_1 = v1.changed(v3_1);
                DraggableState v20_1 = v2_3;
                v2_1 = v1.rememberedValue();
                if((v4_1) || v2_1 == Composer.Companion.getEmpty()) {
                    AppBarKt$BottomAppBarLayout$appBarDragModifier$2$1 v2_4 = new AppBarKt$BottomAppBarLayout$appBarDragModifier$2$1(v3_1, null);
                    v1.updateRememberedValue(v2_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v1);
                v2_5 = DraggableKt.draggable$default(((Modifier)v19_1), v20_1, v21, false, null, false, null, v2_1, false, 0xBC, null);
                v1.endReplaceGroup();
            }

            Shape v18_1 = ShapesKt.getValue(BottomAppBarTokens.INSTANCE.getContainerShape(), v1, 6);
            ComposerKt.sourceInformationMarkerStart(v1, 1782168044, v5_1);
            v4_1 = v1.changed(v3_1);
            Object v5_2 = v1.rememberedValue();
            if((v4_1) || v5_2 == Composer.Companion.getEmpty()) {
                v5_3 = new AppBarKt$$ExternalSyntheticLambda4(v3_1);
                v1.updateRememberedValue(v5_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v2_5 = LayoutModifierKt.layout(v0_2, ((Function3)v5_3)).then(((Modifier)v2_6));
            Companion v28 = ((Companion)v0_2);
            int v0_3 = v17 >> 3;
            v25 = v1;
            SurfaceKt.Surface-T9BRK9s(v2_5, v18_1, v9, v11, v15, 0f, null, ComposableLambdaKt.rememberComposableLambda(1054101083, true, new AppBarKt$BottomAppBarLayout$2(v8_1, arg30, arg38, v7, arg41), v1, 54), v25, v0_3 & 0x380 | v16 | v0_3 & 0x1C00 | v0_3 & 0xE000, 0x60);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Companion v3_2 = v28;
        }
        else {
            v25 = v1;
            v25.skipToGroupEnd();
            v3_3 = arg32;
        }

        ScopeUpdateScope v15_1 = v25.endRestartGroup();
        if(v15_1 != null) {
            v15_1.updateScope(new AppBarKt$$ExternalSyntheticLambda5(arg30, arg31, v3_3, arg33, arg35, arg37, arg38, arg39, arg40, arg41, v13, v14));
        }
    }

    private static final boolean BottomAppBarLayout_t5fmz9U$lambda$17(State arg0) {
        return arg0.getValue().booleanValue();
    }

    static final Unit BottomAppBarLayout_t5fmz9U$lambda$19$lambda$18(BottomAppBarScrollBehavior arg1, float arg2) {
        BottomAppBarState v1 = arg1.getState();
        v1.setHeightOffset(v1.getHeightOffset() - arg2);
        return Unit.INSTANCE;
    }

    static final MeasureResult BottomAppBarLayout_t5fmz9U$lambda$23$lambda$22(BottomAppBarScrollBehavior arg7, MeasureScope arg8, Measurable arg9, Constraints arg10) {
        float v7_1;
        Placeable v9 = arg9.measure-BRTryo0(arg10.unbox-impl());
        if(arg7 != null) {
            BottomAppBarState v10 = arg7.getState();
            if(v10 != null) {
                v10.setHeightOffsetLimit(-(((float)v9.getHeight())));
            }
        }

        float v10_1 = ((float)v9.getHeight());
        if(arg7 != null) {
            BottomAppBarState v7 = arg7.getState();
            if(v7 != null) {
                v7_1 = v7.getHeightOffset();
            }
            else {
                goto label_17;
            }
        }
        else {
        label_17:
            v7_1 = 0f;
        }

        return MeasureScope.layout$default(arg8, v9.getWidth(), MathKt.roundToInt(RangesKt.coerceAtLeast(v10_1 + v7_1, 0f)), null, new AppBarKt$$ExternalSyntheticLambda27(v9), 4, null);
    }

    static final Unit BottomAppBarLayout_t5fmz9U$lambda$23$lambda$22$lambda$21(Placeable arg7, PlacementScope arg8) {
        PlacementScope.place$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    static final Unit BottomAppBarLayout_t5fmz9U$lambda$24(float arg16, Horizontal arg17, Modifier arg18, long arg19, long arg21, float arg23, PaddingValues arg24, WindowInsets arg25, BottomAppBarScrollBehavior arg26, Function3 arg27, int arg28, int arg29, Composer arg30, int arg31) {
        AppBarKt.BottomAppBarLayout-t5fmz9U(arg16, arg17, arg18, arg19, arg21, arg23, arg24, arg25, arg26, arg27, arg30, RecomposeScopeImplKt.updateChangedFlags(arg28 | 1), arg29);
        return Unit.INSTANCE;
    }

    public static final BottomAppBarState BottomAppBarState(float arg1, float arg2, float arg3) {
        return new BottomAppBarStateImpl(arg1, arg2, arg3);
    }

    static final Unit BottomAppBar_1oL4kX8$lambda$14(Modifier arg13, long arg14, long arg16, float arg18, PaddingValues arg19, WindowInsets arg20, Function3 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        AppBarKt.BottomAppBar-1oL4kX8(arg13, arg14, arg16, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    static final Unit BottomAppBar_Snr_uVM$lambda$12(Function3 arg14, Modifier arg15, Function2 arg16, long arg17, long arg19, float arg21, PaddingValues arg22, WindowInsets arg23, int arg24, int arg25, Composer arg26, int arg27) {
        AppBarKt.BottomAppBar-Snr_uVM(arg14, arg15, arg16, arg17, arg19, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit BottomAppBar_e_3WI5M$lambda$15(Modifier arg14, long arg15, long arg17, float arg19, PaddingValues arg20, WindowInsets arg21, BottomAppBarScrollBehavior arg22, Function3 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        AppBarKt.BottomAppBar-e-3WI5M(arg14, arg15, arg17, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit BottomAppBar_qhFBPw4$lambda$13(Function3 arg15, Modifier arg16, Function2 arg17, long arg18, long arg20, float arg22, PaddingValues arg23, WindowInsets arg24, BottomAppBarScrollBehavior arg25, int arg26, int arg27, Composer arg28, int arg29) {
        AppBarKt.BottomAppBar-qhFBPw4(arg15, arg16, arg17, arg18, arg20, arg22, arg23, arg24, arg25, arg28, RecomposeScopeImplKt.updateChangedFlags(arg26 | 1), arg27);
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in favor of CenterAlignedTopAppBar with expandedHeight parameter") public static final void CenterAlignedTopAppBar(Function2 arg20, Modifier arg21, Function2 arg22, Function3 arg23, WindowInsets arg24, TopAppBarColors arg25, TopAppBarScrollBehavior arg26, Composer arg27, int arg28, int arg29) {
        TopAppBarScrollBehavior v7_1;
        TopAppBarColors v6_1;
        WindowInsets v5_1;
        Function3 v4_2;
        Function2 v3_1;
        Modifier v2_1;
        Composer v17_1;
        Function2 v11_2;
        WindowInsets v14_2;
        Function3 v12_2;
        int v0_1;
        TopAppBarScrollBehavior v16;
        TopAppBarColors v15_1;
        Companion v10_2;
        Companion v0_2;
        int v15;
        TopAppBarScrollBehavior v14_1;
        int v13;
        TopAppBarColors v12_1;
        int v12;
        WindowInsets v11_1;
        Function3 v10;
        int v7;
        Function2 v6;
        int v5;
        Modifier v4;
        Function2 v9;
        int v2;
        int v8 = arg28;
        Composer v1 = arg27.startRestartGroup(0x23F3D797);
        ComposerKt.sourceInformation(v1, "C(CenterAlignedTopAppBar)N(title,modifier,navigationIcon,actions,windowInsets,colors,scrollBehavior)291@14250L320:AppBar.kt#uh7d8r");
        if((arg29 & 1) != 0) {
            v2 = v8 | 6;
            v9 = arg20;
        }
        else {
            v9 = arg20;
            if((v8 & 6) == 0) {
                v2 = v1.changedInstance(v9) ? 4 : 2;
                v2 |= v8;
            }
            else {
                v2 = v8;
            }
        }

        int v3 = arg29 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_36;
        }
        else if((v8 & 0x30) == 0) {
            v4 = arg21;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_36:
            v4 = arg21;
        }

        v5 = arg29 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_51;
        }
        else if((v8 & 0x180) == 0) {
            v6 = arg22;
            v7 = v1.changedInstance(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_51:
            v6 = arg22;
        }

        v7 = arg29 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_66;
        }
        else if((v8 & 0xC00) == 0) {
            v10 = arg23;
            int v11 = v1.changedInstance(v10) ? 0x800 : 0x400;
            v2 |= v11;
        }
        else {
        label_66:
            v10 = arg23;
        }

        if((v8 & 0x6000) == 0) {
            if((arg29 & 16) == 0) {
                v11_1 = arg24;
                if(v1.changed(v11_1)) {
                    v12 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v11_1 = arg24;
            label_77:
                v12 = 0x2000;
            }

            v2 |= v12;
        }
        else {
            v11_1 = arg24;
        }

        if((0x30000 & v8) == 0) {
            if((arg29 & 0x20) == 0) {
                v12_1 = arg25;
                if(v1.changed(v12_1)) {
                    v13 = 0x20000;
                }
                else {
                    goto label_92;
                }
            }
            else {
                v12_1 = arg25;
            label_92:
                v13 = 0x10000;
            }

            v2 |= v13;
        }
        else {
            v12_1 = arg25;
        }

        v13 = arg29 & 0x40;
        int v14 = 0x180000;
        if(v13 != 0) {
            v2 |= v14;
            goto label_111;
        }
        else if((v14 & v8) == 0) {
            v14_1 = arg26;
            v15 = v1.changed(v14_1) ? 0x100000 : 0x80000;
            v2 |= v15;
        }
        else {
        label_111:
            v14_1 = arg26;
        }

        boolean v0 = (0x92493 & v2) != 0x92492 ? true : false;
        if(v1.shouldExecute(v0, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "287@14108L12,288@14170L17");
            v15 = 0xFFF8FFFF;
            int v17 = 0xFFFF1FFF;
            if((v8 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    v0_2 = Modifier.Companion;
                }
                else {
                    Modifier v0_3 = v4;
                }

                if(v5 != 0) {
                    v6 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1866429650$material3();
                }

                if(v7 != 0) {
                    v10 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$-541682128$material3();
                }

                int v4_1 = 6;
                if((arg29 & 16) != 0) {
                    v2 &= v17;
                    v11_1 = TopAppBarDefaults.INSTANCE.getWindowInsets(v1, v4_1);
                }

                if((arg29 & 0x20) != 0) {
                    v2 &= v15;
                    v12_1 = TopAppBarDefaults.INSTANCE.topAppBarColors(v1, v4_1);
                }

                if(v13 != 0) {
                    v16 = null;
                    v14_2 = v11_1;
                    v15_1 = v12_1;
                    v11_2 = v6;
                    v12_2 = v10;
                    v10_2 = v0_2;
                }
                else {
                    v15_1 = v12_1;
                    v16 = v14_1;
                    v12_2 = v10;
                    v14_2 = v11_1;
                    v10_2 = v0_2;
                    v11_2 = v6;
                }

                v0_1 = 0x23F3D797;
            }
            else {
                v1.skipToGroupEnd();
                if((arg29 & 16) != 0) {
                    v2 &= v17;
                }

                if((arg29 & 0x20) != 0) {
                    v2 &= v15;
                }

                v15_1 = v12_1;
                v16 = v14_1;
                v0_1 = 0x23F3D797;
                v12_2 = v10;
                v14_2 = v11_1;
                Modifier v10_1 = v4;
                v11_2 = v6;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_1, v2, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:291)");
            }

            v0_1 = v2 & 14 | 0x6000 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00;
            v2 <<= 3;
            v17_1 = v1;
            AppBarKt.CenterAlignedTopAppBar-GHTll3U(v9, ((Modifier)v10_2), v11_2, v12_2, TopAppBarDefaults.INSTANCE.getTopAppBarExpandedHeight-D9Ej5fM(), v14_2, v15_1, v16, v17_1, v0_1 | 0x70000 & v2 | 0x380000 & v2 | v2 & 0x1C00000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v10_2);
            v3_1 = v11_2;
            v4_2 = v12_2;
            v5_1 = v14_2;
            v6_1 = v15_1;
            v7_1 = v16;
        }
        else {
            v17_1 = v1;
            v17_1.skipToGroupEnd();
            v2_1 = v4;
            v3_1 = v6;
            v4_2 = v10;
            v5_1 = v11_1;
            v6_1 = v12_1;
            v7_1 = v14_1;
        }

        ScopeUpdateScope v10_3 = v17_1.endRestartGroup();
        if(v10_3 != null) {
            v10_3.updateScope(new AppBarKt$$ExternalSyntheticLambda0(arg20, v2_1, v3_1, v4_2, v5_1, v6_1, v7_1, v8, arg29));
        }
    }

    static final Unit CenterAlignedTopAppBar$lambda$2(Function2 arg11, Modifier arg12, Function2 arg13, Function3 arg14, WindowInsets arg15, TopAppBarColors arg16, TopAppBarScrollBehavior arg17, int arg18, int arg19, Composer arg20, int arg21) {
        AppBarKt.CenterAlignedTopAppBar(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    public static final void CenterAlignedTopAppBar-GHTll3U(Function2 arg27, Modifier arg28, Function2 arg29, Function3 arg30, float arg31, WindowInsets arg32, TopAppBarColors arg33, TopAppBarScrollBehavior arg34, Composer arg35, int arg36, int arg37) {
        TopAppBarScrollBehavior v8_1;
        TopAppBarColors v7_1;
        WindowInsets v6_1;
        Function3 v4_2;
        Function2 v3_1;
        Modifier v2_1;
        float v5_1;
        Composer v23;
        float v0_2;
        int v4_1;
        TopAppBarColors v21;
        WindowInsets v20;
        Function3 v18_1;
        Function2 v17_1;
        TopAppBarScrollBehavior v22;
        Companion v11_2;
        Companion v0_3;
        int v18;
        int v16;
        TopAppBarColors v15_1;
        int v15;
        WindowInsets v14_1;
        float v13;
        int v11;
        Function3 v8;
        int v7;
        Function2 v6;
        int v5;
        Modifier v4;
        Function2 v12;
        int v2;
        int v9 = arg36;
        int v10 = arg37;
        Composer v1 = arg35.startRestartGroup(-302230691);
        ComposerKt.sourceInformation(v1, "C(CenterAlignedTopAppBar)N(title,modifier,navigationIcon,actions,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)352@17429L5,349@17304L680:AppBar.kt#uh7d8r");
        if((v10 & 1) != 0) {
            v2 = v9 | 6;
            v12 = arg27;
        }
        else {
            v12 = arg27;
            if((v9 & 6) == 0) {
                v2 = v1.changedInstance(v12) ? 4 : 2;
                v2 |= v9;
            }
            else {
                v2 = v9;
            }
        }

        int v3 = v10 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_37;
        }
        else if((v9 & 0x30) == 0) {
            v4 = arg28;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_37:
            v4 = arg28;
        }

        v5 = v10 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_52;
        }
        else if((v9 & 0x180) == 0) {
            v6 = arg29;
            v7 = v1.changedInstance(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_52:
            v6 = arg29;
        }

        v7 = v10 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_67;
        }
        else if((v9 & 0xC00) == 0) {
            v8 = arg30;
            v11 = v1.changedInstance(v8) ? 0x800 : 0x400;
            v2 |= v11;
        }
        else {
        label_67:
            v8 = arg30;
        }

        v11 = v10 & 16;
        if(v11 != 0) {
            v2 |= 0x6000;
            goto label_82;
        }
        else if((v9 & 0x6000) == 0) {
            v13 = arg31;
            int v14 = v1.changed(v13) ? 0x4000 : 0x2000;
            v2 |= v14;
        }
        else {
        label_82:
            v13 = arg31;
        }

        if((0x30000 & v9) == 0) {
            if((v10 & 0x20) == 0) {
                v14_1 = arg32;
                if(v1.changed(v14_1)) {
                    v15 = 0x20000;
                }
                else {
                    goto label_94;
                }
            }
            else {
                v14_1 = arg32;
            label_94:
                v15 = 0x10000;
            }

            v2 |= v15;
        }
        else {
            v14_1 = arg32;
        }

        if((0x180000 & v9) == 0) {
            if((v10 & 0x40) == 0) {
                v15_1 = arg33;
                if(v1.changed(v15_1)) {
                    v16 = 0x100000;
                }
                else {
                    goto label_109;
                }
            }
            else {
                v15_1 = arg33;
            label_109:
                v16 = 0x80000;
            }

            v2 |= v16;
        }
        else {
            v15_1 = arg33;
        }

        int v0 = v10 & 0x80;
        int v17 = 0xC00000;
        if(v0 != 0) {
            v2 |= v17;
            goto label_129;
        }
        else if((v9 & v17) == 0) {
            v17 = v0;
            v18 = v1.changed(arg34) ? 0x800000 : 0x400000;
            v2 |= v18;
        }
        else {
        label_129:
            v17 = v0;
        }

        int v35 = v2;
        boolean v0_1 = (v2 & 0x492493) != 4793490 ? true : false;
        if(v1.shouldExecute(v0_1, v35 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "345@17162L12,346@17224L17");
            v18 = 0xFFF8FFFF;
            int v19 = 0xFFC7FFFF;
            v2 = 6;
            if((v9 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    Modifier v0_4 = v4;
                }

                if(v5 != 0) {
                    v6 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$575301698$material3();
                }

                if(v7 != 0) {
                    v8 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$-643931612$material3();
                }

                if(v11 != 0) {
                    v13 = TopAppBarDefaults.INSTANCE.getTopAppBarExpandedHeight-D9Ej5fM();
                }

                if((v10 & 0x20) != 0) {
                    v4_1 = v35 & v18;
                    v14_1 = TopAppBarDefaults.INSTANCE.getWindowInsets(v1, v2);
                }
                else {
                    v4_1 = v35;
                }

                if((v10 & 0x40) != 0) {
                    v4_1 &= v19;
                    v15_1 = TopAppBarDefaults.INSTANCE.topAppBarColors(v1, v2);
                }

                if(v17 != 0) {
                    v11_2 = v0_3;
                    v22 = null;
                }
                else {
                    v22 = arg34;
                    v11_2 = v0_3;
                }

                v17_1 = v6;
                v18_1 = v8;
                v0_2 = v13;
                v20 = v14_1;
                v21 = v15_1;
            }
            else {
                v1.skipToGroupEnd();
                v0 = (v10 & 0x20) != 0 ? v35 & v18 : v35;
                if((v10 & 0x40) != 0) {
                    v0 &= v19;
                }

                v22 = arg34;
                Modifier v11_1 = v4;
                v17_1 = v6;
                v18_1 = v8;
                v20 = v14_1;
                v21 = v15_1;
                v4_1 = v0;
                v0_2 = v13;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-302230691, v4_1, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:349)");
            }

            TextStyle v13_1 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), v1, v2);
            TextStyle v15_2 = TextStyle.Companion.getDefault();
            androidx.compose.ui.Alignment$Horizontal v16_1 = Alignment.Companion.getCenterHorizontally();
            float v19_1 = (Dp.equals-impl0(v0_2, Dp.Companion.getUnspecified-D9Ej5fM())) || (Dp.equals-impl0(v0_2, Dp.Companion.getInfinity-D9Ej5fM())) ? TopAppBarDefaults.INSTANCE.getTopAppBarExpandedHeight-D9Ej5fM() : v0_2;
            v3 = v4_1 << 12;
            v23 = v1;
            AppBarKt.SingleRowTopAppBar-wn8IZOc(((Modifier)v11_2), v12, v13_1, null, v15_2, v16_1, v17_1, v18_1, v19_1, v20, v21, v22, v23, v4_1 >> 3 & 14 | 0x36C00 | v4_1 << 3 & 0x70 | 0x380000 & v3 | 0x1C00000 & v3 | v3 & 0x70000000, v4_1 >> 18 & 0x7E, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_1 = v0_2;
            v2_1 = ((Modifier)v11_2);
            v3_1 = v17_1;
            v4_2 = v18_1;
            v6_1 = v20;
            v7_1 = v21;
            v8_1 = v22;
        }
        else {
            v23 = v1;
            v23.skipToGroupEnd();
            v2_1 = v4;
            v3_1 = v6;
            v4_2 = v8;
            v5_1 = v13;
            v6_1 = v14_1;
            v7_1 = v15_1;
            v8_1 = arg34;
        }

        ScopeUpdateScope v11_3 = v23.endRestartGroup();
        if(v11_3 != null) {
            v11_3.updateScope(new AppBarKt$$ExternalSyntheticLambda21(arg27, v2_1, v3_1, v4_2, v5_1, v6_1, v7_1, v8_1, v9, v10));
        }
    }

    static final Unit CenterAlignedTopAppBar_GHTll3U$lambda$3(Function2 arg12, Modifier arg13, Function2 arg14, Function3 arg15, float arg16, WindowInsets arg17, TopAppBarColors arg18, TopAppBarScrollBehavior arg19, int arg20, int arg21, Composer arg22, int arg23) {
        AppBarKt.CenterAlignedTopAppBar-GHTll3U(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    public static final void FlexibleBottomAppBar-wBhsO_E(Modifier arg29, long arg30, long arg32, PaddingValues arg34, Horizontal arg35, float arg36, WindowInsets arg37, BottomAppBarScrollBehavior arg38, Function3 arg39, Composer arg40, int arg41, int arg42) {
        BottomAppBarScrollBehavior v10_1;
        WindowInsets v9_1;
        PaddingValues v6;
        long v4_1;
        long v2_2;
        Modifier v1_1;
        Horizontal v7_2;
        float v8;
        Composer v26;
        BottomAppBarScrollBehavior v24;
        WindowInsets v23;
        long v19_1;
        long v17;
        WindowInsets v2_1;
        Companion v3_1;
        int v19;
        int v18;
        float v0;
        int v15;
        Horizontal v14;
        int v11;
        PaddingValues v10;
        int v9;
        long v7_1;
        int v7;
        long v5;
        Modifier v3;
        int v4;
        int v12 = arg41;
        int v13 = arg42;
        Composer v1 = arg40.startRestartGroup(0x999A0CB9);
        ComposerKt.sourceInformation(v1, "C(FlexibleBottomAppBar)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,contentPadding,horizontalArrangement,expandedHeight:c#ui.unit.Dp,windowInsets,scrollBehavior,content)1298@66503L646:AppBar.kt#uh7d8r");
        int v2 = v13 & 1;
        if(v2 != 0) {
            v4 = v12 | 6;
            v3 = arg29;
        }
        else if((v12 & 6) == 0) {
            v3 = arg29;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v12;
        }
        else {
            v3 = arg29;
            v4 = v12;
        }

        if((v12 & 0x30) == 0) {
            if((v13 & 2) == 0) {
                v5 = arg30;
                if(v1.changed(v5)) {
                    v7 = 0x20;
                }
                else {
                    goto label_35;
                }
            }
            else {
                v5 = arg30;
            label_35:
                v7 = 16;
            }

            v4 |= v7;
        }
        else {
            v5 = arg30;
        }

        if((v12 & 0x180) == 0) {
            if((v13 & 4) == 0) {
                v7_1 = arg32;
                if(v1.changed(v7_1)) {
                    v9 = 0x100;
                }
                else {
                    goto label_49;
                }
            }
            else {
                v7_1 = arg32;
            label_49:
                v9 = 0x80;
            }

            v4 |= v9;
        }
        else {
            v7_1 = arg32;
        }

        v9 = v13 & 8;
        if(v9 != 0) {
            v4 |= 0xC00;
            goto label_67;
        }
        else if((v12 & 0xC00) == 0) {
            v10 = arg34;
            v11 = v1.changed(v10) ? 0x800 : 0x400;
            v4 |= v11;
        }
        else {
        label_67:
            v10 = arg34;
        }

        v11 = v13 & 16;
        if(v11 != 0) {
            v4 |= 0x6000;
            goto label_82;
        }
        else if((v12 & 0x6000) == 0) {
            v14 = arg35;
            v15 = v1.changed(v14) ? 0x4000 : 0x2000;
            v4 |= v15;
        }
        else {
        label_82:
            v14 = arg35;
        }

        v15 = v13 & 0x20;
        int v16 = 0x30000;
        if(v15 != 0) {
            v4 |= v16;
        }
        else {
            v0 = arg36;
            if((v12 & v16) == 0) {
                v18 = v1.changed(v0) ? 0x20000 : 0x10000;
                v4 |= v18;
            }
        }

        if((v12 & 0x180000) == 0) {
            WindowInsets v0_1 = arg37;
            v18 = (v13 & 0x40) != 0 || !v1.changed(v0_1) ? 0x80000 : 0x100000;
            v4 |= v18;
        }

        int v0_2 = v13 & 0x80;
        v18 = 0xC00000;
        if(v0_2 != 0) {
            v4 |= v18;
            goto label_128;
        }
        else if((v12 & v18) == 0) {
            v18 = v0_2;
            v19 = v1.changed(arg38) ? 0x800000 : 0x400000;
            v4 |= v19;
        }
        else {
        label_128:
            v18 = v0_2;
        }

        v19 = 0x6000000;
        if((v13 & 0x100) != 0) {
            v4 |= v19;
        }
        else if((v12 & v19) == 0) {
            v19 = v1.changedInstance(arg39) ? 0x4000000 : 0x2000000;
            v4 |= v19;
        }

        int v40 = v2;
        boolean v0_3 = (v4 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_3, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "1288@65983L14,1289@66025L31,1294@66379L12");
            v2 = 0xFFC7FFFF;
            if((v12 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v40 != 0) {
                    v3_1 = Modifier.Companion;
                }

                v40 = v2;
                v2 = 6;
                if((v13 & 2) != 0) {
                    v5 = BottomAppBarDefaults.INSTANCE.getContainerColor(v1, v2);
                    v4 &= 0xFFFFFF8F;
                }

                if((v13 & 4) != 0) {
                    v7_1 = ColorSchemeKt.contentColorFor-ek8zF_U(v5, v1, v4 >> 3 & 14);
                    v4 &= -897;
                }

                if(v9 != 0) {
                    v10 = BottomAppBarDefaults.INSTANCE.getFlexibleContentPadding$material3();
                }

                if(v11 != 0) {
                    v14 = BottomAppBarDefaults.INSTANCE.getFlexibleHorizontalArrangement$material3();
                }

                v0 = v15 != 0 ? BottomAppBarDefaults.INSTANCE.getFlexibleBottomAppBarHeight-D9Ej5fM$material3() : arg36;
                if((v13 & 0x40) != 0) {
                    v2_1 = BottomAppBarDefaults.INSTANCE.getWindowInsets(v1, v2);
                    v4 &= v40;
                }
                else {
                    v2_1 = arg37;
                }

                if(v18 != 0) {
                    v23 = v2_1;
                    v17 = v5;
                    v19_1 = v7_1;
                    v24 = null;
                    goto label_181;
                }

                v24 = arg38;
                v23 = v2_1;
            label_179:
                v17 = v5;
                v19_1 = v7_1;
            }
            else {
                v1.skipToGroupEnd();
                if((v13 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }

                if((v13 & 4) != 0) {
                    v4 &= -897;
                }

                if((v13 & 0x40) != 0) {
                    v4 &= v2;
                }

                v0 = arg36;
                v23 = arg37;
                v24 = arg38;
                goto label_179;
            }

        label_181:
            PaddingValues v22 = v10;
            Horizontal v15_1 = v14;
            v2 = 0x999A0CB9;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v4, -1, "androidx.compose.material3.FlexibleBottomAppBar (AppBar.kt:1297)");
            }

            float v14_1 = (Float.floatToRawIntBits(v0) & 0x7FFFFFFF) >= 0x7F800000 || (Float.isNaN(v0)) || Dp.compareTo-0680j_4(v0, Dp.constructor-impl(0f)) <= 0 ? BottomAppBarDefaults.INSTANCE.getFlexibleBottomAppBarHeight-D9Ej5fM$material3() : v0;
            int v5_1 = v4 << 6;
            v2 = v4 >> 9 & 0x70 | v16 | v5_1 & 0x380 | v5_1 & 0x1C00 | v5_1 & 0xE000 | 0x380000 & v4 << 9;
            v4 <<= 3;
            v26 = v1;
            Modifier v16_1 = ((Modifier)v3_1);
            AppBarKt.BottomAppBarLayout-t5fmz9U(v14_1, v15_1, v16_1, v17, v19_1, AppBarTokens.INSTANCE.getContainerElevation-D9Ej5fM(), v22, v23, v24, arg39, v26, v2 | 0x1C00000 & v4 | 0xE000000 & v4 | v4 & 0x70000000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8 = v0;
            v7_2 = v15_1;
            v1_1 = v16_1;
            v2_2 = v17;
            v4_1 = v19_1;
            v6 = v22;
            v9_1 = v23;
            v10_1 = v24;
        }
        else {
            v26 = v1;
            v26.skipToGroupEnd();
            v9_1 = arg37;
            v1_1 = v3;
            v2_2 = v5;
            v4_1 = v7_1;
            v6 = v10;
            v7_2 = v14;
            v8 = arg36;
            v10_1 = arg38;
        }

        ScopeUpdateScope v14_2 = v26.endRestartGroup();
        if(v14_2 != null) {
            v14_2.updateScope(new AppBarKt$$ExternalSyntheticLambda10(v1_1, v2_2, v4_1, v6, v7_2, v8, v9_1, v10_1, arg39, v12, v13));
        }
    }

    static final Unit FlexibleBottomAppBar_wBhsO_E$lambda$16(Modifier arg15, long arg16, long arg18, PaddingValues arg20, Horizontal arg21, float arg22, WindowInsets arg23, BottomAppBarScrollBehavior arg24, Function3 arg25, int arg26, int arg27, Composer arg28, int arg29) {
        AppBarKt.FlexibleBottomAppBar-wBhsO_E(arg15, arg16, arg18, arg20, arg21, arg22, arg23, arg24, arg25, arg28, RecomposeScopeImplKt.updateChangedFlags(arg26 | 1), arg27);
        return Unit.INSTANCE;
    }

    public static final void LargeFlexibleTopAppBar-eXZ4JBQ(Function2 arg38, Modifier arg39, Function2 arg40, Function2 arg41, Function3 arg42, androidx.compose.ui.Alignment$Horizontal arg43, float arg44, float arg45, WindowInsets arg46, TopAppBarColors arg47, TopAppBarScrollBehavior arg48, Composer arg49, int arg50, int arg51, int arg52) {
        TopAppBarScrollBehavior v11_2;
        TopAppBarColors v10_2;
        WindowInsets v9_1;
        Function3 v5_1;
        Function2 v4_1;
        androidx.compose.ui.Alignment$Horizontal v6_2;
        float v7_2;
        Function2 v3_2;
        float v8_2;
        Composer v33;
        float v29;
        float v11_1;
        Function3 v27;
        Function2 v26;
        TopAppBarScrollBehavior v32;
        TopAppBarColors v31;
        WindowInsets v30;
        androidx.compose.ui.Alignment$Horizontal v25;
        Companion v15_3;
        TopAppBarColors v15_2;
        WindowInsets v13_1;
        Modifier v2_2;
        int v21;
        int v20;
        float v4;
        int v19;
        int v16;
        Function3 v15;
        int v13;
        Function2 v11;
        int v10;
        Function2 v9;
        int v8;
        Modifier v7;
        int v5;
        int v12 = arg50;
        int v14 = arg52;
        Composer v1 = arg49.startRestartGroup(0x41D2955F);
        ComposerKt.sourceInformation(v1, "C(LargeFlexibleTopAppBar)N(title,modifier,subtitle,navigationIcon,actions,titleHorizontalAlignment,collapsedHeight:c#ui.unit.Dp,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)860@43856L5,861@43921L5,866@44141L5,868@44252L5,858@43754L1415:AppBar.kt#uh7d8r");
        if((v14 & 1) != 0) {
            v5 = v12 | 6;
        }
        else if((v12 & 6) == 0) {
            v5 = v1.changedInstance(arg38) ? 4 : 2;
            v5 |= v12;
        }
        else {
            v5 = v12;
        }

        int v6 = v14 & 2;
        if(v6 != 0) {
            v5 |= 0x30;
            goto label_39;
        }
        else if((v12 & 0x30) == 0) {
            v7 = arg39;
            v8 = v1.changed(v7) ? 0x20 : 16;
            v5 |= v8;
        }
        else {
        label_39:
            v7 = arg39;
        }

        v8 = v14 & 4;
        if(v8 != 0) {
            v5 |= 0x180;
            goto label_54;
        }
        else if((v12 & 0x180) == 0) {
            v9 = arg40;
            v10 = v1.changedInstance(v9) ? 0x100 : 0x80;
            v5 |= v10;
        }
        else {
        label_54:
            v9 = arg40;
        }

        v10 = v14 & 8;
        if(v10 != 0) {
            v5 |= 0xC00;
            goto label_69;
        }
        else if((v12 & 0xC00) == 0) {
            v11 = arg41;
            v13 = v1.changedInstance(v11) ? 0x800 : 0x400;
            v5 |= v13;
        }
        else {
        label_69:
            v11 = arg41;
        }

        v13 = v14 & 16;
        if(v13 != 0) {
            v5 |= 0x6000;
            goto label_84;
        }
        else if((v12 & 0x6000) == 0) {
            v15 = arg42;
            v16 = v1.changedInstance(v15) ? 0x4000 : 0x2000;
            v5 |= v16;
        }
        else {
        label_84:
            v15 = arg42;
        }

        v16 = v14 & 0x20;
        int v17 = 0x30000;
        if(v16 != 0) {
            v5 |= v17;
        }
        else {
            androidx.compose.ui.Alignment$Horizontal v3 = arg43;
            if((v12 & v17) == 0) {
                v17 = v1.changed(v3) ? 0x20000 : 0x10000;
                v5 |= v17;
            }
        }

        v17 = v14 & 0x40;
        int v18 = 0x180000;
        if(v17 != 0) {
            v5 |= v18;
        }
        else {
            float v0 = arg44;
            if((v12 & v18) == 0) {
                v19 = v1.changed(v0) ? 0x100000 : 0x80000;
                v5 |= v19;
            }
        }

        if((v12 & 0xC00000) == 0) {
            if((v14 & 0x80) == 0) {
                v4 = arg45;
                if(v1.changed(v4)) {
                    v20 = 0x800000;
                }
                else {
                    goto label_126;
                }
            }
            else {
                v4 = arg45;
            label_126:
                v20 = 0x400000;
            }

            v5 |= v20;
        }
        else {
            v4 = arg45;
        }

        if((v12 & 0x6000000) == 0) {
            v20 = (v14 & 0x100) != 0 || !v1.changed(arg46) ? 0x2000000 : 0x4000000;
            v5 |= v20;
        }

        if((v12 & 0x30000000) == 0) {
            v20 = (v14 & 0x200) != 0 || !v1.changed(arg47) ? 0x10000000 : 0x20000000;
            v5 |= v20;
        }

        int v0_1 = v14 & 0x400;
        if(v0_1 != 0) {
            v20 = v0_1;
            v0_1 = arg51 | 6;
        }
        else if((arg51 & 6) == 0) {
            v20 = v0_1;
            v21 = v1.changed(arg48) ? 4 : 2;
            v0_1 = arg51 | v21;
        }
        else {
            v20 = v0_1;
            v0_1 = arg51;
        }

        boolean v2 = (v5 & 306783379) != 306783378 || (v0_1 & 3) != 2 ? true : false;
        if(v1.shouldExecute(v2, v5 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "854@43612L12,855@43674L17");
            v19 = 0xF1FFFFFF;
            v21 = 0xFE3FFFFF;
            int v49 = 0x8FFFFFFF;
            int v3_1 = 6;
            if((v12 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v6 != 0) {
                    Companion v2_1 = Modifier.Companion;
                }
                else {
                    v2_2 = v7;
                }

                Function2 v6_1 = null;
                if(v8 != 0) {
                    v9 = v6_1;
                }

                Function2 v7_1 = v10 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.getLambda$-780193532$material3() : v11;
                Function3 v8_1 = v13 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.getLambda$-1846660506$material3() : v15;
                androidx.compose.ui.Alignment$Horizontal v10_1 = v16 != 0 ? Alignment.Companion.getStart() : arg43;
                v11_1 = v17 != 0 ? TopAppBarDefaults.INSTANCE.getLargeAppBarCollapsedHeight-D9Ej5fM() : arg44;
                if((v14 & 0x80) != 0) {
                    v4 = v9 != null ? TopAppBarDefaults.INSTANCE.getLargeFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM() : TopAppBarDefaults.INSTANCE.getLargeFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM();
                    v5 &= v21;
                }

                if((v14 & 0x100) != 0) {
                    v13_1 = TopAppBarDefaults.INSTANCE.getWindowInsets(v1, v3_1);
                    v5 &= v19;
                }
                else {
                    v13_1 = arg46;
                }

                if((v14 & 0x200) != 0) {
                    v15_2 = TopAppBarDefaults.INSTANCE.topAppBarColors(v1, v3_1);
                    v5 &= v49;
                }
                else {
                    v15_2 = arg47;
                }

                v32 = v20 != 0 ? ((TopAppBarScrollBehavior)v6_1) : arg48;
                v26 = v7_1;
                v27 = v8_1;
                v25 = v10_1;
                v30 = v13_1;
                v31 = v15_2;
                v15_3 = ((Companion)v2_2);
            }
            else {
                v1.skipToGroupEnd();
                if((v14 & 0x80) != 0) {
                    v5 &= v21;
                }

                if((v14 & 0x100) != 0) {
                    v5 &= v19;
                }

                if((v14 & 0x200) != 0) {
                    v5 &= v49;
                }

                v25 = arg43;
                v30 = arg46;
                v31 = arg47;
                v32 = arg48;
                v26 = v11;
                v27 = v15;
                v11_1 = arg44;
                Modifier v15_1 = v7;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x41D2955F, v5, v0_1, "androidx.compose.material3.LargeFlexibleTopAppBar (AppBar.kt:858)");
            }

            TextStyle v17_1 = TypographyKt.getValue(AppBarLargeFlexibleTokens.INSTANCE.getTitleFont(), v1, v3_1);
            TextStyle v20_1 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), v1, v3_1);
            float v18_1 = AppBarKt.LargeTitleBottomPadding;
            Function2 v21_1 = v9 == null ? ComposableSingletons$AppBarKt.INSTANCE.getLambda$-661145402$material3() : v9;
            TextStyle v22 = TypographyKt.getValue(AppBarLargeFlexibleTokens.INSTANCE.getSubtitleFont(), v1, v3_1);
            Function2 v23 = v9 == null ? ComposableSingletons$AppBarKt.INSTANCE.getLambda$-1113422563$material3() : v9;
            TextStyle v24 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getSubtitleFont(), v1, v3_1);
            float v28 = (Dp.equals-impl0(v11_1, Dp.Companion.getUnspecified-D9Ej5fM())) || (Dp.equals-impl0(v11_1, Dp.Companion.getInfinity-D9Ej5fM())) ? TopAppBarDefaults.INSTANCE.getLargeAppBarCollapsedHeight-D9Ej5fM() : v11_1;
            if((Dp.equals-impl0(v4, Dp.Companion.getUnspecified-D9Ej5fM())) || (Dp.equals-impl0(v4, Dp.Companion.getInfinity-D9Ej5fM()))) {
                float v2_3 = v9 != null ? TopAppBarDefaults.INSTANCE.getLargeFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM() : TopAppBarDefaults.INSTANCE.getLargeFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM();
                v29 = v2_3;
            }
            else {
                v29 = v4;
            }

            v3_1 = v5 >> 6;
            int v2_4 = v5 >> 15 & 14 | v3_1 & 0x70 | v3_1 & 0x380;
            v3_1 = v5 >> 9;
            v33 = v1;
            AppBarKt.TwoRowsTopAppBar-pJA5dT0(((Modifier)v15_3), arg38, v17_1, v18_1, arg38, v20_1, v21_1, v22, v23, v24, v25, v26, v27, v28, v29, v30, v31, v32, v33, v5 >> 3 & 14 | 0xC00 | v5 << 3 & 0x70 | v5 << 12 & 0xE000, v2_4 | 0x70000 & v3_1 | v3_1 & 0x380000 | v0_1 << 21 & 0x1C00000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8_2 = v4;
            v3_2 = v9;
            v7_2 = v11_1;
            v2_2 = ((Modifier)v15_3);
            v6_2 = v25;
            v4_1 = v26;
            v5_1 = v27;
            v9_1 = v30;
            v10_2 = v31;
            v11_2 = v32;
        }
        else {
            v33 = v1;
            v33.skipToGroupEnd();
            v6_2 = arg43;
            v10_2 = arg47;
            v8_2 = v4;
            v2_2 = v7;
            v3_2 = v9;
            v4_1 = v11;
            v5_1 = v15;
            v7_2 = arg44;
            v9_1 = arg46;
            v11_2 = arg48;
        }

        ScopeUpdateScope v15_4 = v33.endRestartGroup();
        if(v15_4 != null) {
            v15_4.updateScope(new AppBarKt$$ExternalSyntheticLambda2(arg38, v2_2, v3_2, v4_1, v5_1, v6_2, v7_2, v8_2, v9_1, v10_2, v11_2, v12, arg51, v14));
        }
    }

    static final Unit LargeFlexibleTopAppBar_eXZ4JBQ$lambda$10(Function2 arg16, Modifier arg17, Function2 arg18, Function2 arg19, Function3 arg20, androidx.compose.ui.Alignment$Horizontal arg21, float arg22, float arg23, WindowInsets arg24, TopAppBarColors arg25, TopAppBarScrollBehavior arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        AppBarKt.LargeFlexibleTopAppBar-eXZ4JBQ(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in favor of LargeTopAppBar with collapsedHeight and expandedHeight parameters") public static final void LargeTopAppBar(Function2 arg21, Modifier arg22, Function2 arg23, Function3 arg24, WindowInsets arg25, TopAppBarColors arg26, TopAppBarScrollBehavior arg27, Composer arg28, int arg29, int arg30) {
        TopAppBarScrollBehavior v7_1;
        TopAppBarColors v6_1;
        WindowInsets v5_1;
        Function3 v4_1;
        Function2 v3_1;
        Modifier v2_1;
        Composer v18;
        WindowInsets v15_1;
        Function3 v12_2;
        TopAppBarScrollBehavior v17_1;
        TopAppBarColors v16;
        Companion v10_2;
        Companion v0_1;
        int v15;
        TopAppBarScrollBehavior v14_1;
        int v13;
        TopAppBarColors v12_1;
        int v12;
        WindowInsets v11_1;
        Function3 v10;
        int v7;
        Function2 v6;
        int v5;
        Modifier v4;
        Function2 v9;
        int v2;
        int v8 = arg29;
        Composer v1 = arg28.startRestartGroup(-330927229);
        ComposerKt.sourceInformation(v1, "C(LargeTopAppBar)N(title,modifier,navigationIcon,actions,windowInsets,colors,scrollBehavior)696@34858L386:AppBar.kt#uh7d8r");
        if((arg30 & 1) != 0) {
            v2 = v8 | 6;
            v9 = arg21;
        }
        else {
            v9 = arg21;
            if((v8 & 6) == 0) {
                v2 = v1.changedInstance(v9) ? 4 : 2;
                v2 |= v8;
            }
            else {
                v2 = v8;
            }
        }

        int v3 = arg30 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_36;
        }
        else if((v8 & 0x30) == 0) {
            v4 = arg22;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_36:
            v4 = arg22;
        }

        v5 = arg30 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_51;
        }
        else if((v8 & 0x180) == 0) {
            v6 = arg23;
            v7 = v1.changedInstance(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_51:
            v6 = arg23;
        }

        v7 = arg30 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_66;
        }
        else if((v8 & 0xC00) == 0) {
            v10 = arg24;
            int v11 = v1.changedInstance(v10) ? 0x800 : 0x400;
            v2 |= v11;
        }
        else {
        label_66:
            v10 = arg24;
        }

        if((v8 & 0x6000) == 0) {
            if((arg30 & 16) == 0) {
                v11_1 = arg25;
                if(v1.changed(v11_1)) {
                    v12 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v11_1 = arg25;
            label_77:
                v12 = 0x2000;
            }

            v2 |= v12;
        }
        else {
            v11_1 = arg25;
        }

        if((0x30000 & v8) == 0) {
            if((arg30 & 0x20) == 0) {
                v12_1 = arg26;
                if(v1.changed(v12_1)) {
                    v13 = 0x20000;
                }
                else {
                    goto label_92;
                }
            }
            else {
                v12_1 = arg26;
            label_92:
                v13 = 0x10000;
            }

            v2 |= v13;
        }
        else {
            v12_1 = arg26;
        }

        v13 = arg30 & 0x40;
        int v14 = 0x180000;
        if(v13 != 0) {
            v2 |= v14;
            goto label_111;
        }
        else if((v14 & v8) == 0) {
            v14_1 = arg27;
            v15 = v1.changed(v14_1) ? 0x100000 : 0x80000;
            v2 |= v15;
        }
        else {
        label_111:
            v14_1 = arg27;
        }

        boolean v0 = (0x92493 & v2) != 0x92492 ? true : false;
        if(v1.shouldExecute(v0, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "692@34716L12,693@34778L17");
            int v17 = 0xFFFF1FFF;
            int v28 = 0xFFF8FFFF;
            v15 = 6;
            if((v8 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    v0_1 = Modifier.Companion;
                }
                else {
                    Modifier v0_2 = v4;
                }

                if(v5 != 0) {
                    v6 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$-699106370$material3();
                }

                if(v7 != 0) {
                    v10 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1702484764$material3();
                }

                if((arg30 & 16) != 0) {
                    v2 &= v17;
                    v11_1 = TopAppBarDefaults.INSTANCE.getWindowInsets(v1, v15);
                }

                if((arg30 & 0x20) != 0) {
                    v2 &= v28;
                    v12_1 = TopAppBarDefaults.INSTANCE.topAppBarColors(v1, v15);
                }

                if(v13 != 0) {
                    v17_1 = null;
                    v16 = v12_1;
                }
                else {
                    v16 = v12_1;
                    v17_1 = v14_1;
                }

                v3 = -330927229;
                v12_2 = v10;
                v10_2 = v0_1;
                v15_1 = v11_1;
            }
            else {
                v1.skipToGroupEnd();
                if((arg30 & 16) != 0) {
                    v2 &= v17;
                }

                if((arg30 & 0x20) != 0) {
                    v2 &= v28;
                }

                v16 = v12_1;
                v17_1 = v14_1;
                v3 = -330927229;
                v12_2 = v10;
                v15_1 = v11_1;
                Modifier v10_1 = v4;
            }

            Function2 v11_2 = v6;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v2, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:696)");
            }

            int v0_3 = v2 << 6;
            v18 = v1;
            AppBarKt.LargeTopAppBar-oKE7A98(v9, ((Modifier)v10_2), v11_2, v12_2, TopAppBarDefaults.INSTANCE.getLargeAppBarCollapsedHeight-D9Ej5fM(), TopAppBarDefaults.INSTANCE.getLargeAppBarExpandedHeight-D9Ej5fM(), v15_1, v16, v17_1, v18, 0x380000 & v0_3 | (v2 & 14 | 0x36000 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00) | 0x1C00000 & v0_3 | v0_3 & 0xE000000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v10_2);
            v3_1 = v11_2;
            v4_1 = v12_2;
            v5_1 = v15_1;
            v6_1 = v16;
            v7_1 = v17_1;
        }
        else {
            v18 = v1;
            v18.skipToGroupEnd();
            v2_1 = v4;
            v3_1 = v6;
            v4_1 = v10;
            v5_1 = v11_1;
            v6_1 = v12_1;
            v7_1 = v14_1;
        }

        ScopeUpdateScope v10_3 = v18.endRestartGroup();
        if(v10_3 != null) {
            v10_3.updateScope(new AppBarKt$$ExternalSyntheticLambda14(arg21, v2_1, v3_1, v4_1, v5_1, v6_1, v7_1, v8, arg30));
        }
    }

    static final Unit LargeTopAppBar$lambda$8(Function2 arg11, Modifier arg12, Function2 arg13, Function3 arg14, WindowInsets arg15, TopAppBarColors arg16, TopAppBarScrollBehavior arg17, int arg18, int arg19, Composer arg20, int arg21) {
        AppBarKt.LargeTopAppBar(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    public static final void LargeTopAppBar-oKE7A98(Function2 arg34, Modifier arg35, Function2 arg36, Function3 arg37, float arg38, float arg39, WindowInsets arg40, TopAppBarColors arg41, TopAppBarScrollBehavior arg42, Composer arg43, int arg44, int arg45) {
        TopAppBarScrollBehavior v9_1;
        TopAppBarColors v8_1;
        WindowInsets v7_1;
        Function3 v4_3;
        Function2 v3_3;
        Modifier v2_1;
        float v6_1;
        float v5_2;
        Composer v30;
        Function3 v24;
        Function2 v23;
        TopAppBarScrollBehavior v29;
        TopAppBarColors v28;
        WindowInsets v27;
        Modifier v12_1;
        float v0_3;
        int v4_1;
        TopAppBarColors v5_1;
        int v18;
        int v17;
        WindowInsets v0;
        float v15_1;
        int v14;
        float v12;
        int v9;
        Function3 v8;
        int v7;
        Function2 v6;
        int v5;
        Modifier v4;
        Function2 v13;
        int v2;
        int v10 = arg44;
        int v11 = arg45;
        Composer v1 = arg43.startRestartGroup(-1406602045);
        ComposerKt.sourceInformation(v1, "C(LargeTopAppBar)N(title,modifier,navigationIcon,actions,collapsedHeight:c#ui.unit.Dp,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)765@38799L5,766@38864L5,763@38705L1138:AppBar.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v2 = v10 | 6;
            v13 = arg34;
        }
        else {
            v13 = arg34;
            if((v10 & 6) == 0) {
                v2 = v1.changedInstance(v13) ? 4 : 2;
                v2 |= v10;
            }
            else {
                v2 = v10;
            }
        }

        int v3 = v11 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_37;
        }
        else if((v10 & 0x30) == 0) {
            v4 = arg35;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_37:
            v4 = arg35;
        }

        v5 = v11 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_52;
        }
        else if((v10 & 0x180) == 0) {
            v6 = arg36;
            v7 = v1.changedInstance(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_52:
            v6 = arg36;
        }

        v7 = v11 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_67;
        }
        else if((v10 & 0xC00) == 0) {
            v8 = arg37;
            v9 = v1.changedInstance(v8) ? 0x800 : 0x400;
            v2 |= v9;
        }
        else {
        label_67:
            v8 = arg37;
        }

        v9 = v11 & 16;
        if(v9 != 0) {
            v2 |= 0x6000;
            goto label_82;
        }
        else if((v10 & 0x6000) == 0) {
            v12 = arg38;
            v14 = v1.changed(v12) ? 0x4000 : 0x2000;
            v2 |= v14;
        }
        else {
        label_82:
            v12 = arg38;
        }

        v14 = v11 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v2 |= v15;
            goto label_98;
        }
        else if((v15 & v10) == 0) {
            v15_1 = arg39;
            int v16 = v1.changed(v15_1) ? 0x20000 : 0x10000;
            v2 |= v16;
        }
        else {
        label_98:
            v15_1 = arg39;
        }

        if((v10 & 0x180000) == 0) {
            v0 = arg40;
            v17 = (v11 & 0x40) != 0 || !v1.changed(v0) ? 0x80000 : 0x100000;
            v2 |= v17;
        }

        if((v10 & 0xC00000) == 0) {
            v17 = (v11 & 0x80) != 0 || !v1.changed(arg41) ? 0x400000 : 0x800000;
            v2 |= v17;
        }

        int v0_1 = v11 & 0x100;
        v17 = 0x6000000;
        if(v0_1 != 0) {
            v2 |= v17;
            goto label_144;
        }
        else if((v10 & v17) == 0) {
            v17 = v0_1;
            v18 = v1.changed(arg42) ? 0x4000000 : 0x2000000;
            v2 |= v18;
        }
        else {
        label_144:
            v17 = v0_1;
        }

        int v43 = v2;
        boolean v0_2 = (v2 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_2, v43 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "759@38563L12,760@38625L17");
            v18 = 0xFFC7FFFF;
            int v19 = 0xFE3FFFFF;
            v2 = 6;
            if((v10 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    Companion v4_2 = Modifier.Companion;
                }

                if(v5 != 0) {
                    v6 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$-1230986050$material3();
                }

                if(v7 != 0) {
                    v8 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1921811868$material3();
                }

                if(v9 != 0) {
                    v12 = TopAppBarDefaults.INSTANCE.getLargeAppBarCollapsedHeight-D9Ej5fM();
                }

                if(v14 != 0) {
                    v15_1 = TopAppBarDefaults.INSTANCE.getLargeAppBarExpandedHeight-D9Ej5fM();
                }

                if((v11 & 0x40) != 0) {
                    v0 = TopAppBarDefaults.INSTANCE.getWindowInsets(v1, v2);
                    v3 = v43 & v18;
                }
                else {
                    v0 = arg40;
                    v3 = v43;
                }

                if((v11 & 0x80) != 0) {
                    v5_1 = TopAppBarDefaults.INSTANCE.topAppBarColors(v1, v2);
                    v3 &= v19;
                }
                else {
                    v5_1 = arg41;
                }

                if(v17 != 0) {
                    v27 = v0;
                    v28 = v5_1;
                    v23 = v6;
                    v29 = null;
                }
                else {
                    v29 = arg42;
                    v27 = v0;
                    v28 = v5_1;
                    v23 = v6;
                }

                v24 = v8;
                v0_3 = v12;
                v12_1 = v4;
                v4_1 = v3;
            }
            else {
                v1.skipToGroupEnd();
                v0_1 = (v11 & 0x40) != 0 ? v43 & v18 : v43;
                if((v11 & 0x80) != 0) {
                    v0_1 &= v19;
                }

                Modifier v3_1 = v4;
                v4_1 = v0_1;
                v0_3 = v12;
                v12_1 = v3_1;
                v27 = arg40;
                v28 = arg41;
                v29 = arg42;
                v23 = v6;
                v24 = v8;
            }

            float v3_2 = v15_1;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1406602045, v4_1, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:763)");
            }

            TextStyle v14_1 = TypographyKt.getValue(AppBarLargeTokens.INSTANCE.getTitleFont(), v1, v2);
            TextStyle v17_1 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), v1, v2);
            v15_1 = AppBarKt.LargeTitleBottomPadding;
            TextStyle v19_1 = TextStyle.Companion.getDefault();
            TextStyle v21 = TextStyle.Companion.getDefault();
            androidx.compose.ui.Alignment$Horizontal v22 = Alignment.Companion.getStart();
            float v25 = (Dp.equals-impl0(v0_3, Dp.Companion.getUnspecified-D9Ej5fM())) || (Dp.equals-impl0(v0_3, Dp.Companion.getInfinity-D9Ej5fM())) ? TopAppBarDefaults.INSTANCE.getLargeAppBarCollapsedHeight-D9Ej5fM() : v0_3;
            float v26 = (Dp.equals-impl0(v3_2, Dp.Companion.getUnspecified-D9Ej5fM())) || (Dp.equals-impl0(v3_2, Dp.Companion.getInfinity-D9Ej5fM())) ? TopAppBarDefaults.INSTANCE.getLargeAppBarExpandedHeight-D9Ej5fM() : v3_2;
            v5 = v4_1 >> 3;
            v30 = v1;
            AppBarKt.TwoRowsTopAppBar-pJA5dT0(v12_1, v13, v14_1, v15_1, arg34, v17_1, null, v19_1, null, v21, v22, v23, v24, v25, v26, v27, v28, v29, v30, v5 & 14 | 0x36D80C00 | v4_1 << 3 & 0x70 | v4_1 << 12 & 0xE000, v2 | v5 & 0x70 | v5 & 0x380 | 0x70000 & v5 | 0x380000 & v5 | 0x1C00000 & v5, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_2 = v0_3;
            v6_1 = v3_2;
            v2_1 = v12_1;
            v3_3 = v23;
            v4_3 = v24;
            v7_1 = v27;
            v8_1 = v28;
            v9_1 = v29;
        }
        else {
            v30 = v1;
            v30.skipToGroupEnd();
            v7_1 = arg40;
            v9_1 = arg42;
            v2_1 = v4;
            v3_3 = v6;
            v4_3 = v8;
            v5_2 = v12;
            v6_1 = v15_1;
            v8_1 = arg41;
        }

        ScopeUpdateScope v12_2 = v30.endRestartGroup();
        if(v12_2 != null) {
            v12_2.updateScope(new AppBarKt$$ExternalSyntheticLambda15(arg34, v2_1, v3_3, v4_3, v5_2, v6_1, v7_1, v8_1, v9_1, v10, v11));
        }
    }

    static final Unit LargeTopAppBar_oKE7A98$lambda$9(Function2 arg13, Modifier arg14, Function2 arg15, Function3 arg16, float arg17, float arg18, WindowInsets arg19, TopAppBarColors arg20, TopAppBarScrollBehavior arg21, int arg22, int arg23, Composer arg24, int arg25) {
        AppBarKt.LargeTopAppBar-oKE7A98(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    static final SingleRowTopAppBarOverride LocalSingleRowTopAppBarOverride$lambda$33() {
        return DefaultSingleRowTopAppBarOverride.INSTANCE;
    }

    static final TwoRowsTopAppBarOverride LocalTwoRowsTopAppBarOverride$lambda$36() {
        return DefaultTwoRowsTopAppBarOverride.INSTANCE;
    }

    public static final void MediumFlexibleTopAppBar-eXZ4JBQ(Function2 arg38, Modifier arg39, Function2 arg40, Function2 arg41, Function3 arg42, androidx.compose.ui.Alignment$Horizontal arg43, float arg44, float arg45, WindowInsets arg46, TopAppBarColors arg47, TopAppBarScrollBehavior arg48, Composer arg49, int arg50, int arg51, int arg52) {
        TopAppBarScrollBehavior v11_2;
        TopAppBarColors v10_2;
        WindowInsets v9_1;
        Function3 v5_1;
        Function2 v4_1;
        androidx.compose.ui.Alignment$Horizontal v6_2;
        float v7_2;
        Function2 v3_2;
        float v8_2;
        Composer v33;
        float v29;
        Modifier v15_1;
        float v11_1;
        Function3 v27;
        Function2 v26;
        TopAppBarScrollBehavior v32;
        TopAppBarColors v31;
        WindowInsets v30;
        androidx.compose.ui.Alignment$Horizontal v25;
        TopAppBarColors v15_2;
        WindowInsets v13_1;
        Modifier v2_2;
        int v21;
        int v20;
        float v4;
        int v19;
        int v16;
        Function3 v15;
        int v13;
        Function2 v11;
        int v10;
        Function2 v9;
        int v8;
        Modifier v7;
        int v5;
        int v12 = arg50;
        int v14 = arg52;
        Composer v1 = arg49.startRestartGroup(0x8F056B49);
        ComposerKt.sourceInformation(v1, "C(MediumFlexibleTopAppBar)N(title,modifier,subtitle,navigationIcon,actions,titleHorizontalAlignment,collapsedHeight:c#ui.unit.Dp,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)616@30967L5,617@31032L5,621@31225L5,623@31336L5,613@30835L1421:AppBar.kt#uh7d8r");
        if((v14 & 1) != 0) {
            v5 = v12 | 6;
        }
        else if((v12 & 6) == 0) {
            v5 = v1.changedInstance(arg38) ? 4 : 2;
            v5 |= v12;
        }
        else {
            v5 = v12;
        }

        int v6 = v14 & 2;
        if(v6 != 0) {
            v5 |= 0x30;
            goto label_39;
        }
        else if((v12 & 0x30) == 0) {
            v7 = arg39;
            v8 = v1.changed(v7) ? 0x20 : 16;
            v5 |= v8;
        }
        else {
        label_39:
            v7 = arg39;
        }

        v8 = v14 & 4;
        if(v8 != 0) {
            v5 |= 0x180;
            goto label_54;
        }
        else if((v12 & 0x180) == 0) {
            v9 = arg40;
            v10 = v1.changedInstance(v9) ? 0x100 : 0x80;
            v5 |= v10;
        }
        else {
        label_54:
            v9 = arg40;
        }

        v10 = v14 & 8;
        if(v10 != 0) {
            v5 |= 0xC00;
            goto label_69;
        }
        else if((v12 & 0xC00) == 0) {
            v11 = arg41;
            v13 = v1.changedInstance(v11) ? 0x800 : 0x400;
            v5 |= v13;
        }
        else {
        label_69:
            v11 = arg41;
        }

        v13 = v14 & 16;
        if(v13 != 0) {
            v5 |= 0x6000;
            goto label_84;
        }
        else if((v12 & 0x6000) == 0) {
            v15 = arg42;
            v16 = v1.changedInstance(v15) ? 0x4000 : 0x2000;
            v5 |= v16;
        }
        else {
        label_84:
            v15 = arg42;
        }

        v16 = v14 & 0x20;
        int v17 = 0x30000;
        if(v16 != 0) {
            v5 |= v17;
        }
        else {
            androidx.compose.ui.Alignment$Horizontal v3 = arg43;
            if((v12 & v17) == 0) {
                v17 = v1.changed(v3) ? 0x20000 : 0x10000;
                v5 |= v17;
            }
        }

        v17 = v14 & 0x40;
        int v18 = 0x180000;
        if(v17 != 0) {
            v5 |= v18;
        }
        else {
            float v0 = arg44;
            if((v12 & v18) == 0) {
                v19 = v1.changed(v0) ? 0x100000 : 0x80000;
                v5 |= v19;
            }
        }

        if((v12 & 0xC00000) == 0) {
            if((v14 & 0x80) == 0) {
                v4 = arg45;
                if(v1.changed(v4)) {
                    v20 = 0x800000;
                }
                else {
                    goto label_126;
                }
            }
            else {
                v4 = arg45;
            label_126:
                v20 = 0x400000;
            }

            v5 |= v20;
        }
        else {
            v4 = arg45;
        }

        if((v12 & 0x6000000) == 0) {
            v20 = (v14 & 0x100) != 0 || !v1.changed(arg46) ? 0x2000000 : 0x4000000;
            v5 |= v20;
        }

        if((v12 & 0x30000000) == 0) {
            v20 = (v14 & 0x200) != 0 || !v1.changed(arg47) ? 0x10000000 : 0x20000000;
            v5 |= v20;
        }

        int v0_1 = v14 & 0x400;
        if(v0_1 != 0) {
            v20 = v0_1;
            v0_1 = arg51 | 6;
        }
        else if((arg51 & 6) == 0) {
            v20 = v0_1;
            v21 = v1.changed(arg48) ? 4 : 2;
            v0_1 = arg51 | v21;
        }
        else {
            v20 = v0_1;
            v0_1 = arg51;
        }

        boolean v2 = (v5 & 306783379) != 306783378 || (v0_1 & 3) != 2 ? true : false;
        if(v1.shouldExecute(v2, v5 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "609@30693L12,610@30755L17");
            v19 = 0xF1FFFFFF;
            v21 = 0xFE3FFFFF;
            int v49 = 0x8FFFFFFF;
            int v3_1 = 6;
            if((v12 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v6 != 0) {
                    Companion v2_1 = Modifier.Companion;
                }
                else {
                    v2_2 = v7;
                }

                Function2 v6_1 = null;
                if(v8 != 0) {
                    v9 = v6_1;
                }

                Function2 v7_1 = v10 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.getLambda$-185842620$material3() : v11;
                Function3 v8_1 = v13 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.getLambda$1113419554$material3() : v15;
                androidx.compose.ui.Alignment$Horizontal v10_1 = v16 != 0 ? Alignment.Companion.getStart() : arg43;
                v11_1 = v17 != 0 ? TopAppBarDefaults.INSTANCE.getMediumAppBarCollapsedHeight-D9Ej5fM() : arg44;
                if((v14 & 0x80) != 0) {
                    v4 = v9 != null ? TopAppBarDefaults.INSTANCE.getMediumFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM() : TopAppBarDefaults.INSTANCE.getMediumFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM();
                    v5 &= v21;
                }

                if((v14 & 0x100) != 0) {
                    v13_1 = TopAppBarDefaults.INSTANCE.getWindowInsets(v1, v3_1);
                    v5 &= v19;
                }
                else {
                    v13_1 = arg46;
                }

                if((v14 & 0x200) != 0) {
                    v15_2 = TopAppBarDefaults.INSTANCE.topAppBarColors(v1, v3_1);
                    v5 &= v49;
                }
                else {
                    v15_2 = arg47;
                }

                v32 = v20 != 0 ? ((TopAppBarScrollBehavior)v6_1) : arg48;
                v26 = v7_1;
                v27 = v8_1;
                v25 = v10_1;
                v30 = v13_1;
                v31 = v15_2;
                Companion v15_3 = ((Companion)v2_2);
            }
            else {
                v1.skipToGroupEnd();
                if((v14 & 0x80) != 0) {
                    v5 &= v21;
                }

                if((v14 & 0x100) != 0) {
                    v5 &= v19;
                }

                if((v14 & 0x200) != 0) {
                    v5 &= v49;
                }

                v25 = arg43;
                v30 = arg46;
                v31 = arg47;
                v32 = arg48;
                v26 = v11;
                v27 = v15;
                v11_1 = arg44;
                v15_1 = v7;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x8F056B49, v5, v0_1, "androidx.compose.material3.MediumFlexibleTopAppBar (AppBar.kt:613)");
            }

            TextStyle v17_1 = TypographyKt.getValue(AppBarMediumFlexibleTokens.INSTANCE.getTitleFont(), v1, v3_1);
            TextStyle v20_1 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), v1, v3_1);
            float v18_1 = AppBarKt.MediumTitleBottomPadding;
            Function2 v21_1 = v9 == null ? ComposableSingletons$AppBarKt.INSTANCE.getLambda$-790317886$material3() : v9;
            TextStyle v22 = TypographyKt.getValue(AppBarMediumFlexibleTokens.INSTANCE.getSubtitleFont(), v1, v3_1);
            Function2 v23 = v9 == null ? ComposableSingletons$AppBarKt.INSTANCE.getLambda$-1926007989$material3() : v9;
            TextStyle v24 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getSubtitleFont(), v1, v3_1);
            float v28 = (Dp.equals-impl0(v11_1, Dp.Companion.getUnspecified-D9Ej5fM())) || (Dp.equals-impl0(v11_1, Dp.Companion.getInfinity-D9Ej5fM())) ? TopAppBarDefaults.INSTANCE.getMediumAppBarCollapsedHeight-D9Ej5fM() : v11_1;
            if((Dp.equals-impl0(v4, Dp.Companion.getUnspecified-D9Ej5fM())) || (Dp.equals-impl0(v4, Dp.Companion.getInfinity-D9Ej5fM()))) {
                float v2_3 = v9 != null ? TopAppBarDefaults.INSTANCE.getMediumFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM() : TopAppBarDefaults.INSTANCE.getMediumFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM();
                v29 = v2_3;
            }
            else {
                v29 = v4;
            }

            v3_1 = v5 >> 6;
            int v2_4 = v5 >> 15 & 14 | v3_1 & 0x70 | v3_1 & 0x380;
            v3_1 = v5 >> 9;
            v33 = v1;
            AppBarKt.TwoRowsTopAppBar-pJA5dT0(v15_1, arg38, v17_1, v18_1, arg38, v20_1, v21_1, v22, v23, v24, v25, v26, v27, v28, v29, v30, v31, v32, v33, v5 >> 3 & 14 | 0xC00 | v5 << 3 & 0x70 | v5 << 12 & 0xE000, v2_4 | 0x70000 & v3_1 | v3_1 & 0x380000 | v0_1 << 21 & 0x1C00000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8_2 = v4;
            v3_2 = v9;
            v7_2 = v11_1;
            v2_2 = v15_1;
            v6_2 = v25;
            v4_1 = v26;
            v5_1 = v27;
            v9_1 = v30;
            v10_2 = v31;
            v11_2 = v32;
        }
        else {
            v33 = v1;
            v33.skipToGroupEnd();
            v6_2 = arg43;
            v10_2 = arg47;
            v8_2 = v4;
            v2_2 = v7;
            v3_2 = v9;
            v4_1 = v11;
            v5_1 = v15;
            v7_2 = arg44;
            v9_1 = arg46;
            v11_2 = arg48;
        }

        ScopeUpdateScope v15_4 = v33.endRestartGroup();
        if(v15_4 != null) {
            v15_4.updateScope(new AppBarKt$$ExternalSyntheticLambda36(arg38, v2_2, v3_2, v4_1, v5_1, v6_2, v7_2, v8_2, v9_1, v10_2, v11_2, v12, arg51, v14));
        }
    }

    static final Unit MediumFlexibleTopAppBar_eXZ4JBQ$lambda$7(Function2 arg16, Modifier arg17, Function2 arg18, Function2 arg19, Function3 arg20, androidx.compose.ui.Alignment$Horizontal arg21, float arg22, float arg23, WindowInsets arg24, TopAppBarColors arg25, TopAppBarScrollBehavior arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        AppBarKt.MediumFlexibleTopAppBar-eXZ4JBQ(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in favor of MediumTopAppBar with collapsedHeight and expandedHeight parameters") public static final void MediumTopAppBar(Function2 arg21, Modifier arg22, Function2 arg23, Function3 arg24, WindowInsets arg25, TopAppBarColors arg26, TopAppBarScrollBehavior arg27, Composer arg28, int arg29, int arg30) {
        TopAppBarScrollBehavior v7_1;
        TopAppBarColors v6_1;
        WindowInsets v5_1;
        Function3 v4_1;
        Function2 v3_1;
        Modifier v2_1;
        Composer v18;
        WindowInsets v15_1;
        Function3 v12_2;
        TopAppBarScrollBehavior v17_1;
        TopAppBarColors v16;
        Companion v10_2;
        Modifier v0_2;
        int v15;
        TopAppBarScrollBehavior v14_1;
        int v13;
        TopAppBarColors v12_1;
        int v12;
        WindowInsets v11_1;
        Function3 v10;
        int v7;
        Function2 v6;
        int v5;
        Modifier v4;
        Function2 v9;
        int v2;
        int v8 = arg29;
        Composer v1 = arg28.startRestartGroup(0xECF92159);
        ComposerKt.sourceInformation(v1, "C(MediumTopAppBar)N(title,modifier,navigationIcon,actions,windowInsets,colors,scrollBehavior)451@21910L389:AppBar.kt#uh7d8r");
        if((arg30 & 1) != 0) {
            v2 = v8 | 6;
            v9 = arg21;
        }
        else {
            v9 = arg21;
            if((v8 & 6) == 0) {
                v2 = v1.changedInstance(v9) ? 4 : 2;
                v2 |= v8;
            }
            else {
                v2 = v8;
            }
        }

        int v3 = arg30 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_36;
        }
        else if((v8 & 0x30) == 0) {
            v4 = arg22;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_36:
            v4 = arg22;
        }

        v5 = arg30 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_51;
        }
        else if((v8 & 0x180) == 0) {
            v6 = arg23;
            v7 = v1.changedInstance(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_51:
            v6 = arg23;
        }

        v7 = arg30 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_66;
        }
        else if((v8 & 0xC00) == 0) {
            v10 = arg24;
            int v11 = v1.changedInstance(v10) ? 0x800 : 0x400;
            v2 |= v11;
        }
        else {
        label_66:
            v10 = arg24;
        }

        if((v8 & 0x6000) == 0) {
            if((arg30 & 16) == 0) {
                v11_1 = arg25;
                if(v1.changed(v11_1)) {
                    v12 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v11_1 = arg25;
            label_77:
                v12 = 0x2000;
            }

            v2 |= v12;
        }
        else {
            v11_1 = arg25;
        }

        if((0x30000 & v8) == 0) {
            if((arg30 & 0x20) == 0) {
                v12_1 = arg26;
                if(v1.changed(v12_1)) {
                    v13 = 0x20000;
                }
                else {
                    goto label_92;
                }
            }
            else {
                v12_1 = arg26;
            label_92:
                v13 = 0x10000;
            }

            v2 |= v13;
        }
        else {
            v12_1 = arg26;
        }

        v13 = arg30 & 0x40;
        int v14 = 0x180000;
        if(v13 != 0) {
            v2 |= v14;
            goto label_111;
        }
        else if((v14 & v8) == 0) {
            v14_1 = arg27;
            v15 = v1.changed(v14_1) ? 0x100000 : 0x80000;
            v2 |= v15;
        }
        else {
        label_111:
            v14_1 = arg27;
        }

        boolean v0 = (0x92493 & v2) != 0x92492 ? true : false;
        if(v1.shouldExecute(v0, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "447@21768L12,448@21830L17");
            int v17 = 0xFFFF1FFF;
            int v28 = 0xFFF8FFFF;
            v15 = 6;
            if((v8 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    Companion v0_1 = Modifier.Companion;
                }
                else {
                    v0_2 = v4;
                }

                if(v5 != 0) {
                    v6 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1152131198$material3();
                }

                if(v7 != 0) {
                    v10 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$-1707954976$material3();
                }

                if((arg30 & 16) != 0) {
                    v2 &= v17;
                    v11_1 = TopAppBarDefaults.INSTANCE.getWindowInsets(v1, v15);
                }

                if((arg30 & 0x20) != 0) {
                    v2 &= v28;
                    v12_1 = TopAppBarDefaults.INSTANCE.topAppBarColors(v1, v15);
                }

                if(v13 != 0) {
                    v17_1 = null;
                    v16 = v12_1;
                }
                else {
                    v16 = v12_1;
                    v17_1 = v14_1;
                }

                v3 = 0xECF92159;
                v12_2 = v10;
                v10_2 = ((Companion)v0_2);
                v15_1 = v11_1;
            }
            else {
                v1.skipToGroupEnd();
                if((arg30 & 16) != 0) {
                    v2 &= v17;
                }

                if((arg30 & 0x20) != 0) {
                    v2 &= v28;
                }

                v16 = v12_1;
                v17_1 = v14_1;
                v3 = 0xECF92159;
                v12_2 = v10;
                v15_1 = v11_1;
                Modifier v10_1 = v4;
            }

            Function2 v11_2 = v6;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v2, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:451)");
            }

            int v0_3 = v2 << 6;
            v18 = v1;
            AppBarKt.MediumTopAppBar-oKE7A98(v9, ((Modifier)v10_2), v11_2, v12_2, TopAppBarDefaults.INSTANCE.getMediumAppBarCollapsedHeight-D9Ej5fM(), TopAppBarDefaults.INSTANCE.getMediumAppBarExpandedHeight-D9Ej5fM(), v15_1, v16, v17_1, v18, 0x380000 & v0_3 | (v2 & 14 | 0x36000 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00) | 0x1C00000 & v0_3 | v0_3 & 0xE000000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v10_2);
            v3_1 = v11_2;
            v4_1 = v12_2;
            v5_1 = v15_1;
            v6_1 = v16;
            v7_1 = v17_1;
        }
        else {
            v18 = v1;
            v18.skipToGroupEnd();
            v2_1 = v4;
            v3_1 = v6;
            v4_1 = v10;
            v5_1 = v11_1;
            v6_1 = v12_1;
            v7_1 = v14_1;
        }

        ScopeUpdateScope v10_3 = v18.endRestartGroup();
        if(v10_3 != null) {
            v10_3.updateScope(new AppBarKt$$ExternalSyntheticLambda33(arg21, v2_1, v3_1, v4_1, v5_1, v6_1, v7_1, v8, arg30));
        }
    }

    static final Unit MediumTopAppBar$lambda$5(Function2 arg11, Modifier arg12, Function2 arg13, Function3 arg14, WindowInsets arg15, TopAppBarColors arg16, TopAppBarScrollBehavior arg17, int arg18, int arg19, Composer arg20, int arg21) {
        AppBarKt.MediumTopAppBar(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    public static final void MediumTopAppBar-oKE7A98(Function2 arg34, Modifier arg35, Function2 arg36, Function3 arg37, float arg38, float arg39, WindowInsets arg40, TopAppBarColors arg41, TopAppBarScrollBehavior arg42, Composer arg43, int arg44, int arg45) {
        TopAppBarScrollBehavior v9_1;
        TopAppBarColors v8_1;
        WindowInsets v7_1;
        Function3 v4_3;
        Function2 v3_3;
        Modifier v2_1;
        float v6_1;
        float v5_2;
        Composer v30;
        Function3 v24;
        Function2 v23;
        TopAppBarScrollBehavior v29;
        TopAppBarColors v28;
        WindowInsets v27;
        Modifier v12_1;
        float v0_3;
        int v4_1;
        TopAppBarColors v5_1;
        int v18;
        int v17;
        WindowInsets v0;
        float v15_1;
        int v14;
        float v12;
        int v9;
        Function3 v8;
        int v7;
        Function2 v6;
        int v5;
        Modifier v4;
        Function2 v13;
        int v2;
        int v10 = arg44;
        int v11 = arg45;
        Composer v1 = arg43.startRestartGroup(0xADDB6A19);
        ComposerKt.sourceInformation(v1, "C(MediumTopAppBar)N(title,modifier,navigationIcon,actions,collapsedHeight:c#ui.unit.Dp,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)521@25897L5,522@25962L5,518@25773L1142:AppBar.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v2 = v10 | 6;
            v13 = arg34;
        }
        else {
            v13 = arg34;
            if((v10 & 6) == 0) {
                v2 = v1.changedInstance(v13) ? 4 : 2;
                v2 |= v10;
            }
            else {
                v2 = v10;
            }
        }

        int v3 = v11 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_37;
        }
        else if((v10 & 0x30) == 0) {
            v4 = arg35;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_37:
            v4 = arg35;
        }

        v5 = v11 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_52;
        }
        else if((v10 & 0x180) == 0) {
            v6 = arg36;
            v7 = v1.changedInstance(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_52:
            v6 = arg36;
        }

        v7 = v11 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_67;
        }
        else if((v10 & 0xC00) == 0) {
            v8 = arg37;
            v9 = v1.changedInstance(v8) ? 0x800 : 0x400;
            v2 |= v9;
        }
        else {
        label_67:
            v8 = arg37;
        }

        v9 = v11 & 16;
        if(v9 != 0) {
            v2 |= 0x6000;
            goto label_82;
        }
        else if((v10 & 0x6000) == 0) {
            v12 = arg38;
            v14 = v1.changed(v12) ? 0x4000 : 0x2000;
            v2 |= v14;
        }
        else {
        label_82:
            v12 = arg38;
        }

        v14 = v11 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v2 |= v15;
            goto label_98;
        }
        else if((v15 & v10) == 0) {
            v15_1 = arg39;
            int v16 = v1.changed(v15_1) ? 0x20000 : 0x10000;
            v2 |= v16;
        }
        else {
        label_98:
            v15_1 = arg39;
        }

        if((v10 & 0x180000) == 0) {
            v0 = arg40;
            v17 = (v11 & 0x40) != 0 || !v1.changed(v0) ? 0x80000 : 0x100000;
            v2 |= v17;
        }

        if((v10 & 0xC00000) == 0) {
            v17 = (v11 & 0x80) != 0 || !v1.changed(arg41) ? 0x400000 : 0x800000;
            v2 |= v17;
        }

        int v0_1 = v11 & 0x100;
        v17 = 0x6000000;
        if(v0_1 != 0) {
            v2 |= v17;
            goto label_144;
        }
        else if((v10 & v17) == 0) {
            v17 = v0_1;
            v18 = v1.changed(arg42) ? 0x4000000 : 0x2000000;
            v2 |= v18;
        }
        else {
        label_144:
            v17 = v0_1;
        }

        int v43 = v2;
        boolean v0_2 = (v2 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_2, v43 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "514@25631L12,515@25693L17");
            v18 = 0xFFC7FFFF;
            int v19 = 0xFE3FFFFF;
            v2 = 6;
            if((v10 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    Companion v4_2 = Modifier.Companion;
                }

                if(v5 != 0) {
                    v6 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$-229000834$material3();
                }

                if(v7 != 0) {
                    v8 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$-1276513184$material3();
                }

                if(v9 != 0) {
                    v12 = TopAppBarDefaults.INSTANCE.getMediumAppBarCollapsedHeight-D9Ej5fM();
                }

                if(v14 != 0) {
                    v15_1 = TopAppBarDefaults.INSTANCE.getMediumAppBarExpandedHeight-D9Ej5fM();
                }

                if((v11 & 0x40) != 0) {
                    v0 = TopAppBarDefaults.INSTANCE.getWindowInsets(v1, v2);
                    v3 = v43 & v18;
                }
                else {
                    v0 = arg40;
                    v3 = v43;
                }

                if((v11 & 0x80) != 0) {
                    v5_1 = TopAppBarDefaults.INSTANCE.topAppBarColors(v1, v2);
                    v3 &= v19;
                }
                else {
                    v5_1 = arg41;
                }

                if(v17 != 0) {
                    v27 = v0;
                    v28 = v5_1;
                    v23 = v6;
                    v29 = null;
                }
                else {
                    v29 = arg42;
                    v27 = v0;
                    v28 = v5_1;
                    v23 = v6;
                }

                v24 = v8;
                v0_3 = v12;
                v12_1 = v4;
                v4_1 = v3;
            }
            else {
                v1.skipToGroupEnd();
                v0_1 = (v11 & 0x40) != 0 ? v43 & v18 : v43;
                if((v11 & 0x80) != 0) {
                    v0_1 &= v19;
                }

                Modifier v3_1 = v4;
                v4_1 = v0_1;
                v0_3 = v12;
                v12_1 = v3_1;
                v27 = arg40;
                v28 = arg41;
                v29 = arg42;
                v23 = v6;
                v24 = v8;
            }

            float v3_2 = v15_1;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xADDB6A19, v4_1, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:518)");
            }

            TextStyle v14_1 = TypographyKt.getValue(AppBarMediumTokens.INSTANCE.getTitleFont(), v1, v2);
            TextStyle v17_1 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), v1, v2);
            v15_1 = AppBarKt.MediumTitleBottomPadding;
            TextStyle v19_1 = TextStyle.Companion.getDefault();
            TextStyle v21 = TextStyle.Companion.getDefault();
            androidx.compose.ui.Alignment$Horizontal v22 = Alignment.Companion.getStart();
            float v25 = (Dp.equals-impl0(v0_3, Dp.Companion.getUnspecified-D9Ej5fM())) || (Dp.equals-impl0(v0_3, Dp.Companion.getInfinity-D9Ej5fM())) ? TopAppBarDefaults.INSTANCE.getMediumAppBarCollapsedHeight-D9Ej5fM() : v0_3;
            float v26 = (Dp.equals-impl0(v3_2, Dp.Companion.getUnspecified-D9Ej5fM())) || (Dp.equals-impl0(v3_2, Dp.Companion.getInfinity-D9Ej5fM())) ? TopAppBarDefaults.INSTANCE.getMediumAppBarExpandedHeight-D9Ej5fM() : v3_2;
            v5 = v4_1 >> 3;
            v30 = v1;
            AppBarKt.TwoRowsTopAppBar-pJA5dT0(v12_1, v13, v14_1, v15_1, arg34, v17_1, null, v19_1, null, v21, v22, v23, v24, v25, v26, v27, v28, v29, v30, v5 & 14 | 0x36D80C00 | v4_1 << 3 & 0x70 | v4_1 << 12 & 0xE000, v2 | v5 & 0x70 | v5 & 0x380 | 0x70000 & v5 | 0x380000 & v5 | 0x1C00000 & v5, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_2 = v0_3;
            v6_1 = v3_2;
            v2_1 = v12_1;
            v3_3 = v23;
            v4_3 = v24;
            v7_1 = v27;
            v8_1 = v28;
            v9_1 = v29;
        }
        else {
            v30 = v1;
            v30.skipToGroupEnd();
            v7_1 = arg40;
            v9_1 = arg42;
            v2_1 = v4;
            v3_3 = v6;
            v4_3 = v8;
            v5_2 = v12;
            v6_1 = v15_1;
            v8_1 = arg41;
        }

        ScopeUpdateScope v12_2 = v30.endRestartGroup();
        if(v12_2 != null) {
            v12_2.updateScope(new AppBarKt$$ExternalSyntheticLambda8(arg34, v2_1, v3_3, v4_3, v5_2, v6_1, v7_1, v8_1, v9_1, v10, v11));
        }
    }

    static final Unit MediumTopAppBar_oKE7A98$lambda$6(Function2 arg13, Modifier arg14, Function2 arg15, Function3 arg16, float arg17, float arg18, WindowInsets arg19, TopAppBarColors arg20, TopAppBarScrollBehavior arg21, int arg22, int arg23, Composer arg24, int arg25) {
        AppBarKt.MediumTopAppBar-oKE7A98(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    private static final void SingleRowTopAppBar-wn8IZOc(Modifier arg31, Function2 arg32, TextStyle arg33, Function2 arg34, TextStyle arg35, androidx.compose.ui.Alignment$Horizontal arg36, Function2 arg37, Function3 arg38, float arg39, WindowInsets arg40, TopAppBarColors arg41, TopAppBarScrollBehavior arg42, Composer arg43, int arg44, int arg45, int arg46) {
        Modifier v17_2;
        Companion v17_1;
        WindowInsets v9;
        float v8;
        androidx.compose.ui.Alignment$Horizontal v14_1;
        TextStyle v12_1;
        Function2 v11_1;
        TextStyle v10_1;
        Function2 v7;
        Modifier v5;
        int v6;
        int v13 = arg44;
        int v15 = arg46;
        Composer v1 = arg43.startRestartGroup(-2033800111);
        ComposerKt.sourceInformation(v1, "C(SingleRowTopAppBar)N(modifier,title,titleTextStyle,subtitle,subtitleTextStyle,titleHorizontalAlignment,navigationIcon,actions,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)2500@117679L7,*2500@117696L20:AppBar.kt#uh7d8r");
        int v2 = v15 & 1;
        if(v2 != 0) {
            v6 = v13 | 6;
            v5 = arg31;
        }
        else if((v13 & 6) == 0) {
            v5 = arg31;
            v6 = v1.changed(v5) ? 4 : 2;
            v6 |= v13;
        }
        else {
            v5 = arg31;
            v6 = v13;
        }

        if((v15 & 2) != 0) {
            v6 |= 0x30;
            goto label_39;
        }
        else if((v13 & 0x30) == 0) {
            v7 = arg32;
            int v10 = v1.changedInstance(v7) ? 0x20 : 16;
            v6 |= v10;
        }
        else {
        label_39:
            v7 = arg32;
        }

        if((v15 & 4) != 0) {
            v6 |= 0x180;
            goto label_54;
        }
        else if((v13 & 0x180) == 0) {
            v10_1 = arg33;
            int v11 = v1.changed(v10_1) ? 0x100 : 0x80;
            v6 |= v11;
        }
        else {
        label_54:
            v10_1 = arg33;
        }

        if((v15 & 8) != 0) {
            v6 |= 0xC00;
            goto label_69;
        }
        else if((v13 & 0xC00) == 0) {
            v11_1 = arg34;
            int v12 = v1.changedInstance(v11_1) ? 0x800 : 0x400;
            v6 |= v12;
        }
        else {
        label_69:
            v11_1 = arg34;
        }

        if((v15 & 16) != 0) {
            v6 |= 0x6000;
            goto label_84;
        }
        else if((v13 & 0x6000) == 0) {
            v12_1 = arg35;
            int v14 = v1.changed(v12_1) ? 0x4000 : 0x2000;
            v6 |= v14;
        }
        else {
        label_84:
            v12_1 = arg35;
        }

        int v16 = 0x30000;
        if((v15 & 0x20) != 0) {
            v6 |= v16;
            goto label_100;
        }
        else if((v13 & v16) == 0) {
            v14_1 = arg36;
            v16 = v1.changed(v14_1) ? 0x20000 : 0x10000;
            v6 |= v16;
        }
        else {
        label_100:
            v14_1 = arg36;
        }

        int v17 = 0x180000;
        if((v15 & 0x40) != 0) {
            v6 |= v17;
        }
        else {
            Function2 v3 = arg37;
            if((v13 & v17) == 0) {
                v16 = v1.changedInstance(v3) ? 0x100000 : 0x80000;
                v6 |= v16;
            }
        }

        v17 = 0xC00000;
        if((v15 & 0x80) != 0) {
            v6 |= v17;
        }
        else if((v13 & v17) == 0) {
            v17 = v1.changedInstance(arg38) ? 0x800000 : 0x400000;
            v6 |= v17;
        }

        int v18 = 0x6000000;
        if((v15 & 0x100) != 0) {
            v6 |= v18;
            goto label_147;
        }
        else if((v13 & v18) == 0) {
            v8 = arg39;
            v18 = v1.changed(v8) ? 0x4000000 : 0x2000000;
            v6 |= v18;
        }
        else {
        label_147:
            v8 = arg39;
        }

        int v19 = 0x30000000;
        if((v15 & 0x200) != 0) {
            v6 |= v19;
            goto label_163;
        }
        else if((v13 & v19) == 0) {
            v9 = arg40;
            v19 = v1.changed(v9) ? 0x20000000 : 0x10000000;
            v6 |= v19;
        }
        else {
        label_163:
            v9 = arg40;
        }

        if((v15 & 0x400) != 0) {
            v16 = arg45 | 6;
        }
        else if((arg45 & 6) == 0) {
            v16 = v1.changed(arg41) ? 4 : 2;
            v16 |= arg45;
        }
        else {
            v16 = arg45;
        }

        if((v15 & 0x800) != 0) {
            v16 |= 0x30;
        }
        else if((arg45 & 0x30) == 0) {
            v17 = v1.changed(arg42) ? 0x20 : 16;
            v16 |= v17;
        }

        int v0 = v16;
        int v43 = v2;
        boolean v2_1 = (v6 & 306783379) != 306783378 || (v0 & 19) != 18 ? true : false;
        if(v1.shouldExecute(v2_1, v6 & 1)) {
            if(v43 != 0) {
                v17_1 = Modifier.Companion;
            }
            else {
                v17_2 = v5;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2033800111, v6, v0, "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:2484)");
            }

            SingleRowTopAppBarOverrideScope v0_1 = new SingleRowTopAppBarOverrideScope(((Modifier)v17_1), v7, v10_1, v11_1, v12_1, v14_1, arg37, arg38, v8, v9, arg41, arg42, null);
            ProvidableCompositionLocal v2_2 = AppBarKt.LocalSingleRowTopAppBarOverride;
            ComposerKt.sourceInformationMarkerStart(v1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v2_3 = v1.consume(((CompositionLocal)v2_2));
            ComposerKt.sourceInformationMarkerEnd(v1);
            ((SingleRowTopAppBarOverride)v2_3).SingleRowTopAppBar(v0_1, v1, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_252;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
            v17_2 = v5;
        }

    label_252:
        ScopeUpdateScope v0_2 = v1.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new AppBarKt$$ExternalSyntheticLambda13(v17_1, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, v13, arg45, v15));
        }
    }

    static final Unit SingleRowTopAppBar_wn8IZOc$lambda$32(Modifier arg17, Function2 arg18, TextStyle arg19, Function2 arg20, TextStyle arg21, androidx.compose.ui.Alignment$Horizontal arg22, Function2 arg23, Function3 arg24, float arg25, WindowInsets arg26, TopAppBarColors arg27, TopAppBarScrollBehavior arg28, int arg29, int arg30, int arg31, Composer arg32, int arg33) {
        AppBarKt.SingleRowTopAppBar-wn8IZOc(arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg32, RecomposeScopeImplKt.updateChangedFlags(arg29 | 1), RecomposeScopeImplKt.updateChangedFlags(arg30), arg31);
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in favor of TopAppBar with expandedHeight parameter") public static final void TopAppBar(Function2 arg20, Modifier arg21, Function2 arg22, Function3 arg23, WindowInsets arg24, TopAppBarColors arg25, TopAppBarScrollBehavior arg26, Composer arg27, int arg28, int arg29) {
        TopAppBarScrollBehavior v7_1;
        TopAppBarColors v6_1;
        WindowInsets v5_1;
        Function3 v4_2;
        Function2 v3_1;
        Modifier v2_1;
        Composer v17_1;
        Function2 v11_2;
        Modifier v10_1;
        WindowInsets v14_2;
        Function3 v12_2;
        int v0_1;
        TopAppBarScrollBehavior v16;
        TopAppBarColors v15_1;
        Companion v10_2;
        Companion v0_2;
        int v15;
        TopAppBarScrollBehavior v14_1;
        int v13;
        TopAppBarColors v12_1;
        int v12;
        WindowInsets v11_1;
        Function3 v10;
        int v7;
        Function2 v6;
        int v5;
        Modifier v4;
        Function2 v9;
        int v2;
        int v8 = arg28;
        Composer v1 = arg27.startRestartGroup(0x6A9E5A04);
        ComposerKt.sourceInformation(v1, "C(TopAppBar)N(title,modifier,navigationIcon,actions,windowInsets,colors,scrollBehavior)168@8176L307:AppBar.kt#uh7d8r");
        if((arg29 & 1) != 0) {
            v2 = v8 | 6;
            v9 = arg20;
        }
        else {
            v9 = arg20;
            if((v8 & 6) == 0) {
                v2 = v1.changedInstance(v9) ? 4 : 2;
                v2 |= v8;
            }
            else {
                v2 = v8;
            }
        }

        int v3 = arg29 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_36;
        }
        else if((v8 & 0x30) == 0) {
            v4 = arg21;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_36:
            v4 = arg21;
        }

        v5 = arg29 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_51;
        }
        else if((v8 & 0x180) == 0) {
            v6 = arg22;
            v7 = v1.changedInstance(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_51:
            v6 = arg22;
        }

        v7 = arg29 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_66;
        }
        else if((v8 & 0xC00) == 0) {
            v10 = arg23;
            int v11 = v1.changedInstance(v10) ? 0x800 : 0x400;
            v2 |= v11;
        }
        else {
        label_66:
            v10 = arg23;
        }

        if((v8 & 0x6000) == 0) {
            if((arg29 & 16) == 0) {
                v11_1 = arg24;
                if(v1.changed(v11_1)) {
                    v12 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v11_1 = arg24;
            label_77:
                v12 = 0x2000;
            }

            v2 |= v12;
        }
        else {
            v11_1 = arg24;
        }

        if((0x30000 & v8) == 0) {
            if((arg29 & 0x20) == 0) {
                v12_1 = arg25;
                if(v1.changed(v12_1)) {
                    v13 = 0x20000;
                }
                else {
                    goto label_92;
                }
            }
            else {
                v12_1 = arg25;
            label_92:
                v13 = 0x10000;
            }

            v2 |= v13;
        }
        else {
            v12_1 = arg25;
        }

        v13 = arg29 & 0x40;
        int v14 = 0x180000;
        if(v13 != 0) {
            v2 |= v14;
            goto label_111;
        }
        else if((v14 & v8) == 0) {
            v14_1 = arg26;
            v15 = v1.changed(v14_1) ? 0x100000 : 0x80000;
            v2 |= v15;
        }
        else {
        label_111:
            v14_1 = arg26;
        }

        boolean v0 = (0x92493 & v2) != 0x92492 ? true : false;
        if(v1.shouldExecute(v0, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "164@8034L12,165@8096L17");
            v15 = 0xFFF8FFFF;
            int v17 = 0xFFFF1FFF;
            if((v8 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    v0_2 = Modifier.Companion;
                }
                else {
                    Modifier v0_3 = v4;
                }

                if(v5 != 0) {
                    v6 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$-944449303$material3();
                }

                if(v7 != 0) {
                    v10 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$917296843$material3();
                }

                int v4_1 = 6;
                if((arg29 & 16) != 0) {
                    v2 &= v17;
                    v11_1 = TopAppBarDefaults.INSTANCE.getWindowInsets(v1, v4_1);
                }

                if((arg29 & 0x20) != 0) {
                    v2 &= v15;
                    v12_1 = TopAppBarDefaults.INSTANCE.topAppBarColors(v1, v4_1);
                }

                if(v13 != 0) {
                    v16 = null;
                    v14_2 = v11_1;
                    v15_1 = v12_1;
                    v11_2 = v6;
                    v12_2 = v10;
                    v10_2 = v0_2;
                }
                else {
                    v15_1 = v12_1;
                    v16 = v14_1;
                    v12_2 = v10;
                    v14_2 = v11_1;
                    v10_2 = v0_2;
                    v11_2 = v6;
                }

                v0_1 = 0x6A9E5A04;
            }
            else {
                v1.skipToGroupEnd();
                if((arg29 & 16) != 0) {
                    v2 &= v17;
                }

                if((arg29 & 0x20) != 0) {
                    v2 &= v15;
                }

                v15_1 = v12_1;
                v16 = v14_1;
                v0_1 = 0x6A9E5A04;
                v12_2 = v10;
                v14_2 = v11_1;
                v10_1 = v4;
                v11_2 = v6;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_1, v2, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:168)");
            }

            v0_1 = v2 & 14 | 0x6000 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00;
            v2 <<= 3;
            v17_1 = v1;
            AppBarKt.TopAppBar-GHTll3U(v9, v10_1, v11_2, v12_2, TopAppBarDefaults.INSTANCE.getTopAppBarExpandedHeight-D9Ej5fM(), v14_2, v15_1, v16, v17_1, v0_1 | 0x70000 & v2 | 0x380000 & v2 | v2 & 0x1C00000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v10_1;
            v3_1 = v11_2;
            v4_2 = v12_2;
            v5_1 = v14_2;
            v6_1 = v15_1;
            v7_1 = v16;
        }
        else {
            v17_1 = v1;
            v17_1.skipToGroupEnd();
            v2_1 = v4;
            v3_1 = v6;
            v4_2 = v10;
            v5_1 = v11_1;
            v6_1 = v12_1;
            v7_1 = v14_1;
        }

        ScopeUpdateScope v10_3 = v17_1.endRestartGroup();
        if(v10_3 != null) {
            v10_3.updateScope(new AppBarKt$$ExternalSyntheticLambda28(arg20, v2_1, v3_1, v4_2, v5_1, v6_1, v7_1, v8, arg29));
        }
    }

    static final Unit TopAppBar$lambda$0(Function2 arg11, Modifier arg12, Function2 arg13, Function3 arg14, WindowInsets arg15, TopAppBarColors arg16, TopAppBarScrollBehavior arg17, int arg18, int arg19, Composer arg20, int arg21) {
        AppBarKt.TopAppBar(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    public static final void TopAppBar-GHTll3U(Function2 arg27, Modifier arg28, Function2 arg29, Function3 arg30, float arg31, WindowInsets arg32, TopAppBarColors arg33, TopAppBarScrollBehavior arg34, Composer arg35, int arg36, int arg37) {
        TopAppBarScrollBehavior v8_1;
        TopAppBarColors v7_1;
        WindowInsets v6_1;
        Function3 v4_2;
        Function2 v3_1;
        Modifier v2_1;
        float v5_1;
        Composer v23;
        float v0_2;
        int v4_1;
        TopAppBarColors v21;
        WindowInsets v20;
        Function3 v18_1;
        Function2 v17_1;
        Modifier v11_1;
        TopAppBarScrollBehavior v22;
        Companion v11_2;
        Modifier v0_4;
        int v18;
        int v16;
        TopAppBarColors v15_1;
        int v15;
        WindowInsets v14_1;
        float v13;
        int v11;
        Function3 v8;
        int v7;
        Function2 v6;
        int v5;
        Modifier v4;
        Function2 v12;
        int v2;
        int v9 = arg36;
        int v10 = arg37;
        Composer v1 = arg35.startRestartGroup(0x6A5C1DD0);
        ComposerKt.sourceInformation(v1, "C(TopAppBar)N(title,modifier,navigationIcon,actions,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)228@11268L5,225@11143L667:AppBar.kt#uh7d8r");
        if((v10 & 1) != 0) {
            v2 = v9 | 6;
            v12 = arg27;
        }
        else {
            v12 = arg27;
            if((v9 & 6) == 0) {
                v2 = v1.changedInstance(v12) ? 4 : 2;
                v2 |= v9;
            }
            else {
                v2 = v9;
            }
        }

        int v3 = v10 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_37;
        }
        else if((v9 & 0x30) == 0) {
            v4 = arg28;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_37:
            v4 = arg28;
        }

        v5 = v10 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_52;
        }
        else if((v9 & 0x180) == 0) {
            v6 = arg29;
            v7 = v1.changedInstance(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_52:
            v6 = arg29;
        }

        v7 = v10 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_67;
        }
        else if((v9 & 0xC00) == 0) {
            v8 = arg30;
            v11 = v1.changedInstance(v8) ? 0x800 : 0x400;
            v2 |= v11;
        }
        else {
        label_67:
            v8 = arg30;
        }

        v11 = v10 & 16;
        if(v11 != 0) {
            v2 |= 0x6000;
            goto label_82;
        }
        else if((v9 & 0x6000) == 0) {
            v13 = arg31;
            int v14 = v1.changed(v13) ? 0x4000 : 0x2000;
            v2 |= v14;
        }
        else {
        label_82:
            v13 = arg31;
        }

        if((0x30000 & v9) == 0) {
            if((v10 & 0x20) == 0) {
                v14_1 = arg32;
                if(v1.changed(v14_1)) {
                    v15 = 0x20000;
                }
                else {
                    goto label_94;
                }
            }
            else {
                v14_1 = arg32;
            label_94:
                v15 = 0x10000;
            }

            v2 |= v15;
        }
        else {
            v14_1 = arg32;
        }

        if((0x180000 & v9) == 0) {
            if((v10 & 0x40) == 0) {
                v15_1 = arg33;
                if(v1.changed(v15_1)) {
                    v16 = 0x100000;
                }
                else {
                    goto label_109;
                }
            }
            else {
                v15_1 = arg33;
            label_109:
                v16 = 0x80000;
            }

            v2 |= v16;
        }
        else {
            v15_1 = arg33;
        }

        int v0 = v10 & 0x80;
        int v17 = 0xC00000;
        if(v0 != 0) {
            v2 |= v17;
            goto label_129;
        }
        else if((v9 & v17) == 0) {
            v17 = v0;
            v18 = v1.changed(arg34) ? 0x800000 : 0x400000;
            v2 |= v18;
        }
        else {
        label_129:
            v17 = v0;
        }

        int v35 = v2;
        boolean v0_1 = (v2 & 0x492493) != 4793490 ? true : false;
        if(v1.shouldExecute(v0_1, v35 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "221@11001L12,222@11063L17");
            v18 = 0xFFF8FFFF;
            int v19 = 0xFFC7FFFF;
            v2 = 6;
            if((v9 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    Companion v0_3 = Modifier.Companion;
                }
                else {
                    v0_4 = v4;
                }

                if(v5 != 0) {
                    v6 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$657782987$material3();
                }

                if(v7 != 0) {
                    v8 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$-1270442071$material3();
                }

                if(v11 != 0) {
                    v13 = TopAppBarDefaults.INSTANCE.getTopAppBarExpandedHeight-D9Ej5fM();
                }

                if((v10 & 0x20) != 0) {
                    v4_1 = v35 & v18;
                    v14_1 = TopAppBarDefaults.INSTANCE.getWindowInsets(v1, v2);
                }
                else {
                    v4_1 = v35;
                }

                if((v10 & 0x40) != 0) {
                    v4_1 &= v19;
                    v15_1 = TopAppBarDefaults.INSTANCE.topAppBarColors(v1, v2);
                }

                if(v17 != 0) {
                    v11_2 = ((Companion)v0_4);
                    v22 = null;
                }
                else {
                    v22 = arg34;
                    v11_2 = ((Companion)v0_4);
                }

                v17_1 = v6;
                v18_1 = v8;
                v0_2 = v13;
                v20 = v14_1;
                v21 = v15_1;
            }
            else {
                v1.skipToGroupEnd();
                v0 = (v10 & 0x20) != 0 ? v35 & v18 : v35;
                if((v10 & 0x40) != 0) {
                    v0 &= v19;
                }

                v22 = arg34;
                v11_1 = v4;
                v17_1 = v6;
                v18_1 = v8;
                v20 = v14_1;
                v21 = v15_1;
                v4_1 = v0;
                v0_2 = v13;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x6A5C1DD0, v4_1, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:225)");
            }

            TextStyle v13_1 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), v1, v2);
            TextStyle v15_2 = TextStyle.Companion.getDefault();
            androidx.compose.ui.Alignment$Horizontal v16_1 = Alignment.Companion.getStart();
            float v19_1 = (Dp.equals-impl0(v0_2, Dp.Companion.getUnspecified-D9Ej5fM())) || (Dp.equals-impl0(v0_2, Dp.Companion.getInfinity-D9Ej5fM())) ? TopAppBarDefaults.INSTANCE.getTopAppBarExpandedHeight-D9Ej5fM() : v0_2;
            v3 = v4_1 << 12;
            v23 = v1;
            AppBarKt.SingleRowTopAppBar-wn8IZOc(v11_1, v12, v13_1, null, v15_2, v16_1, v17_1, v18_1, v19_1, v20, v21, v22, v23, v4_1 >> 3 & 14 | 0x36C00 | v4_1 << 3 & 0x70 | 0x380000 & v3 | 0x1C00000 & v3 | v3 & 0x70000000, v4_1 >> 18 & 0x7E, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_1 = v0_2;
            v2_1 = v11_1;
            v3_1 = v17_1;
            v4_2 = v18_1;
            v6_1 = v20;
            v7_1 = v21;
            v8_1 = v22;
        }
        else {
            v23 = v1;
            v23.skipToGroupEnd();
            v2_1 = v4;
            v3_1 = v6;
            v4_2 = v8;
            v5_1 = v13;
            v6_1 = v14_1;
            v7_1 = v15_1;
            v8_1 = arg34;
        }

        ScopeUpdateScope v11_3 = v23.endRestartGroup();
        if(v11_3 != null) {
            v11_3.updateScope(new AppBarKt$$ExternalSyntheticLambda9(arg27, v2_1, v3_1, v4_2, v5_1, v6_1, v7_1, v8_1, v9, v10));
        }
    }

    public static final void TopAppBar-cJHQLPU(Function2 arg29, Function2 arg30, Modifier arg31, Function2 arg32, Function3 arg33, androidx.compose.ui.Alignment$Horizontal arg34, float arg35, WindowInsets arg36, TopAppBarColors arg37, TopAppBarScrollBehavior arg38, Composer arg39, int arg40, int arg41) {
        TopAppBarScrollBehavior v10_1;
        TopAppBarColors v9_1;
        WindowInsets v8_2;
        Function3 v5_3;
        Function2 v4_2;
        androidx.compose.ui.Alignment$Horizontal v6_1;
        Modifier v3_1;
        float v7_1;
        Composer v25;
        androidx.compose.ui.Alignment$Horizontal v18_1;
        Function3 v20;
        Function2 v19_1;
        TopAppBarScrollBehavior v24;
        TopAppBarColors v23;
        WindowInsets v22;
        TopAppBarColors v8_1;
        WindowInsets v4_1;
        Companion v5_1;
        int v18;
        int v17;
        float v0;
        int v15;
        androidx.compose.ui.Alignment$Horizontal v13_1;
        int v10;
        Function3 v9;
        int v8;
        Function2 v7;
        int v6;
        Modifier v5;
        int v4;
        Function2 v3;
        Function2 v14;
        int v2;
        int v11 = arg40;
        int v12 = arg41;
        Composer v1 = arg39.startRestartGroup(0x7483760D);
        ComposerKt.sourceInformation(v1, "C(TopAppBar)N(title,subtitle,modifier,navigationIcon,actions,titleHorizontalAlignment,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)386@18726L5,388@18821L5,383@18601L699:AppBar.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v2 = v11 | 6;
            v14 = arg29;
        }
        else {
            v14 = arg29;
            if((v11 & 6) == 0) {
                v2 = v1.changedInstance(v14) ? 4 : 2;
                v2 |= v11;
            }
            else {
                v2 = v11;
            }
        }

        if((v12 & 2) != 0) {
            v2 |= 0x30;
            goto label_37;
        }
        else if((v11 & 0x30) == 0) {
            v3 = arg30;
            v4 = v1.changedInstance(v3) ? 0x20 : 16;
            v2 |= v4;
        }
        else {
        label_37:
            v3 = arg30;
        }

        v4 = v12 & 4;
        if(v4 != 0) {
            v2 |= 0x180;
            goto label_52;
        }
        else if((v11 & 0x180) == 0) {
            v5 = arg31;
            v6 = v1.changed(v5) ? 0x100 : 0x80;
            v2 |= v6;
        }
        else {
        label_52:
            v5 = arg31;
        }

        v6 = v12 & 8;
        if(v6 != 0) {
            v2 |= 0xC00;
            goto label_67;
        }
        else if((v11 & 0xC00) == 0) {
            v7 = arg32;
            v8 = v1.changedInstance(v7) ? 0x800 : 0x400;
            v2 |= v8;
        }
        else {
        label_67:
            v7 = arg32;
        }

        v8 = v12 & 16;
        if(v8 != 0) {
            v2 |= 0x6000;
            goto label_82;
        }
        else if((v11 & 0x6000) == 0) {
            v9 = arg33;
            v10 = v1.changedInstance(v9) ? 0x4000 : 0x2000;
            v2 |= v10;
        }
        else {
        label_82:
            v9 = arg33;
        }

        v10 = v12 & 0x20;
        int v13 = 0x30000;
        if(v10 != 0) {
            v2 |= v13;
            goto label_98;
        }
        else if((v13 & v11) == 0) {
            v13_1 = arg34;
            v15 = v1.changed(v13_1) ? 0x20000 : 0x10000;
            v2 |= v15;
        }
        else {
        label_98:
            v13_1 = arg34;
        }

        v15 = v12 & 0x40;
        int v16 = 0x180000;
        if(v15 != 0) {
            v2 |= v16;
        }
        else {
            v0 = arg35;
            if((v11 & v16) == 0) {
                v17 = v1.changed(v0) ? 0x100000 : 0x80000;
                v2 |= v17;
            }
        }

        if((v11 & 0xC00000) == 0) {
            v17 = (v12 & 0x80) != 0 || !v1.changed(arg36) ? 0x400000 : 0x800000;
            v2 |= v17;
        }

        if((v11 & 0x6000000) == 0) {
            v17 = (v12 & 0x100) != 0 || !v1.changed(arg37) ? 0x2000000 : 0x4000000;
            v2 |= v17;
        }

        int v0_1 = v12 & 0x200;
        v17 = 0x30000000;
        if(v0_1 != 0) {
            v2 |= v17;
            goto label_160;
        }
        else if((v11 & v17) == 0) {
            v17 = v0_1;
            v18 = v1.changed(arg38) ? 0x20000000 : 0x10000000;
            v2 |= v18;
        }
        else {
        label_160:
            v17 = v0_1;
        }

        int v39 = v2;
        boolean v0_2 = (v2 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0_2, v39 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "379@18459L12,380@18521L17");
            v18 = 0xFE3FFFFF;
            int v19 = 0xF1FFFFFF;
            v2 = 6;
            if((v11 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v5_1 = Modifier.Companion;
                }

                if(v6 != 0) {
                    v7 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$-1168245838$material3();
                }

                if(v8 != 0) {
                    v9 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$-1401945836$material3();
                }

                if(v10 != 0) {
                    v13_1 = Alignment.Companion.getStart();
                }

                v0 = v15 != 0 ? TopAppBarDefaults.INSTANCE.getTopAppBarExpandedHeight-D9Ej5fM() : arg35;
                if((v12 & 0x80) != 0) {
                    v4_1 = TopAppBarDefaults.INSTANCE.getWindowInsets(v1, v2);
                    v6 = v39 & v18;
                }
                else {
                    v4_1 = arg36;
                    v6 = v39;
                }

                if((v12 & 0x100) != 0) {
                    v8_1 = TopAppBarDefaults.INSTANCE.topAppBarColors(v1, v2);
                    v6 &= v19;
                }
                else {
                    v8_1 = arg37;
                }

                if(v17 != 0) {
                    v22 = v4_1;
                    v19_1 = v7;
                    v23 = v8_1;
                    v20 = v9;
                    v24 = null;
                }
                else {
                    v24 = arg38;
                    v22 = v4_1;
                    v19_1 = v7;
                    v23 = v8_1;
                    v20 = v9;
                }

                v18_1 = v13_1;
            }
            else {
                v1.skipToGroupEnd();
                v0_1 = (v12 & 0x80) != 0 ? v39 & v18 : v39;
                if((v12 & 0x100) != 0) {
                    v0_1 &= v19;
                }

                v22 = arg36;
                v23 = arg37;
                v24 = arg38;
                v6 = v0_1;
                v19_1 = v7;
                v20 = v9;
                v18_1 = v13_1;
                v0 = arg35;
            }

            Modifier v13_2 = ((Modifier)v5_1);
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x7483760D, v6, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:383)");
            }

            TextStyle v15_1 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), v1, v2);
            TextStyle v17_1 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getSubtitleFont(), v1, v2);
            float v21 = (Dp.equals-impl0(v0, Dp.Companion.getUnspecified-D9Ej5fM())) || (Dp.equals-impl0(v0, Dp.Companion.getInfinity-D9Ej5fM())) ? TopAppBarDefaults.INSTANCE.getTopAppBarExpandedHeight-D9Ej5fM() : v0;
            v4 = v6 << 6;
            int v5_2 = v6 << 9;
            v25 = v1;
            AppBarKt.SingleRowTopAppBar-wn8IZOc(v13_2, v14, v15_1, v3, v17_1, v18_1, v19_1, v20, v21, v22, v23, v24, v25, v6 >> 6 & 14 | v6 << 3 & 0x70 | v4 & 0x1C00 | 0x70000 & v6 | 0x380000 & v5_2 | v5_2 & 0x1C00000 | v4 & 0x70000000, v6 >> 24 & 0x7E, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7_1 = v0;
            v3_1 = v13_2;
            v6_1 = v18_1;
            v4_2 = v19_1;
            v5_3 = v20;
            v8_2 = v22;
            v9_1 = v23;
            v10_1 = v24;
        }
        else {
            v25 = v1;
            v25.skipToGroupEnd();
            v8_2 = arg36;
            v10_1 = arg38;
            v3_1 = v5;
            v4_2 = v7;
            v5_3 = v9;
            v6_1 = v13_1;
            v7_1 = arg35;
            v9_1 = arg37;
        }

        ScopeUpdateScope v13_3 = v25.endRestartGroup();
        if(v13_3 != null) {
            v13_3.updateScope(new AppBarKt$$ExternalSyntheticLambda7(arg29, arg30, v3_1, v4_2, v5_3, v6_1, v7_1, v8_2, v9_1, v10_1, v11, v12));
        }
    }

    private static final void TopAppBarLayout-lyUyIHI(Modifier arg36, FloatProducer arg37, long arg38, long arg40, long arg42, long arg44, Function2 arg46, TextStyle arg47, Function2 arg48, TextStyle arg49, Function0 arg50, Vertical arg51, androidx.compose.ui.Alignment$Horizontal arg52, int arg53, boolean arg54, Function2 arg55, Function2 arg56, float arg57, Composer arg58, int arg59, int arg60) {
        Function2 v3_10;
        MeasurePolicy v3_9;
        AppBarKt$$ExternalSyntheticLambda31 v3_8;
        Companion v3_5;
        String v14_1;
        String v0_6;
        Composer v6_5;
        Function0 v5_4;
        Modifier v0_4;
        String v7_3;
        androidx.compose.ui.Alignment$Horizontal v8_4;
        int v58;
        int v16;
        String v25;
        Function2 v0_3;
        int v0_2;
        int v3_1;
        int v22;
        int v9;
        int v21;
        int v6;
        int v18;
        int v8_1;
        int v4;
        Modifier v1 = arg36;
        FloatProducer v2 = arg37;
        Function2 v13 = arg48;
        Function0 v15 = arg50;
        androidx.compose.ui.Alignment$Horizontal v5 = arg52;
        boolean v0 = arg54;
        Function2 v10 = arg56;
        int v11 = arg59;
        int v12 = arg60;
        Composer v14 = arg58.startRestartGroup(0x788A5DC);
        ComposerKt.sourceInformation(v14, "C(TopAppBarLayout)N(modifier,scrolledOffset,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,subtitleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color,title,titleTextStyle,subtitle,subtitleTextStyle,titleAlpha,titleVerticalArrangement,titleHorizontalAlignment,titleBottomPadding,hideTitleSemantics,navigationIcon,actions,height:c#ui.unit.Dp)3053@144004L469,2995@141484L2996:AppBar.kt#uh7d8r");
        if((v11 & 6) == 0) {
            v4 = v14.changed(v1) ? 4 : 2;
            v4 |= v11;
        }
        else {
            v4 = v11;
        }

        if((v11 & 0x30) == 0) {
            boolean v8 = (v11 & 0x40) == 0 ? v14.changed(v2) : v14.changedInstance(v2);
            v8_1 = v8 ? 0x20 : 16;
            v4 |= v8_1;
        }

        if((v11 & 0x180) == 0) {
            v18 = v14.changed(arg38) ? 0x100 : 0x80;
            v4 |= v18;
        }

        if((v11 & 0xC00) == 0) {
            v6 = v4;
            v21 = v14.changed(arg40) ? 0x800 : 0x400;
            v6 |= v21;
        }
        else {
            v6 = v4;
        }

        if((v11 & 0x6000) == 0) {
            v21 = v14.changed(arg42) ? 0x4000 : 0x2000;
            v6 |= v21;
        }

        long v8_2 = arg44;
        if((v11 & 0x30000) == 0) {
            int v7 = v14.changed(v8_2) ? 0x20000 : 0x10000;
            v6 |= v7;
        }

        if((0x180000 & v11) == 0) {
            v21 = v14.changedInstance(arg46) ? 0x100000 : 0x80000;
            v6 |= v21;
        }

        TextStyle v4_1 = arg47;
        if((v11 & 0xC00000) == 0) {
            v21 = v14.changed(v4_1) ? 0x800000 : 0x400000;
            v6 |= v21;
        }

        if((v11 & 0x6000000) == 0) {
            v21 = v14.changedInstance(v13) ? 0x4000000 : 0x2000000;
            v6 |= v21;
        }

        TextStyle v8_3 = arg49;
        if((v11 & 0x30000000) == 0) {
            v9 = v14.changed(v8_3) ? 0x20000000 : 0x10000000;
            v6 |= v9;
        }

        v9 = v6;
        if((v12 & 6) == 0) {
            v6 = v14.changedInstance(v15) ? 4 : 2;
            v6 |= v12;
        }
        else {
            v6 = v12;
        }

        Vertical v3 = arg51;
        if((v12 & 0x30) == 0) {
            v22 = v14.changed(v3) ? 0x20 : 16;
            v6 |= v22;
        }

        if((v12 & 0x180) == 0) {
            v3_1 = v14.changed(v5) ? 0x100 : 0x80;
            v6 |= v3_1;
        }

        if((v12 & 0xC00) == 0) {
            v22 = v14.changed(arg53) ? 0x800 : 0x400;
            v6 |= v22;
        }

        if((v12 & 0x6000) == 0) {
            v3_1 = v14.changed(v0) ? 0x4000 : 0x2000;
            v6 |= v3_1;
        }

        if((0x30000 & v12) == 0) {
            v22 = v14.changedInstance(arg55) ? 0x20000 : 0x10000;
            v6 |= v22;
        }

        if((v12 & 0x180000) == 0) {
            v22 = v14.changedInstance(v10) ? 0x100000 : 0x80000;
            v6 |= v22;
        }

        float v0_1 = arg57;
        if((v12 & 0xC00000) == 0) {
            v22 = v14.changed(v0_1) ? 0x800000 : 0x400000;
            v6 |= v22;
        }

        v22 = 1;
        v0 = (v9 & 306783379) != 306783378 || (0x492493 & v6) != 4793490 ? true : false;
        if(v14.shouldExecute(v0, v9 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x788A5DC, v9, v6, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:2994)");
            }

            String v3_2 = "CC(remember):AppBar.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v14, 0x47F83071, v3_2);
            if((v9 & 0x70) != 0x20) {
                if((v9 & 0x40) != 0 && (v14.changed(v2))) {
                    goto label_234;
                }

                v0_2 = 0;
            }
            else {
            label_234:
                v0_2 = 1;
            }

            int v23 = v0_2;
            v0_2 = (v6 & 0x70) == 0x20 ? 1 : 0;
            v8_1 = v6 & 0x380;
            v18 = v23 | v0_2;
            v0_2 = v8_1 == 0x100 ? 1 : 0;
            int v17 = v18 | v0_2;
            v0_2 = (v6 & 0x1C00) == 0x800 ? 1 : 0;
            v17 |= v0_2;
            v0_2 = (0x1C00000 & v6) == 0x800000 ? 1 : 0;
            Object v2_1 = v14.rememberedValue();
            if((v17 | v0_2) != 0 || v2_1 == Composer.Companion.getEmpty()) {
                v16 = v8_1;
                v25 = v3_2;
                v23 = v6;
                v58 = v9;
                v9 = 0;
                v0_3 = arg55;
                TopAppBarMeasurePolicy v2_2 = new TopAppBarMeasurePolicy(arg37, arg51, v5, arg53, arg57, null);
                v8_4 = v5;
                v14.updateRememberedValue(v2_2);
            }
            else {
                v0_3 = arg55;
                v25 = v3_2;
                v23 = v6;
                v16 = v8_1;
                v58 = v9;
                v9 = 0;
                v8_4 = v5;
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            String v4_2 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v14, -1323940314, v4_2);
            int v5_1 = ComposablesKt.getCurrentCompositeKeyHash(v14, v9);
            CompositionLocalMap v6_1 = v14.getCurrentCompositionLocalMap();
            Modifier v7_1 = ComposedModifierKt.materializeModifier(v14, v1);
            Function0 v3_3 = ComposeUiNode.Companion.getConstructor();
            String v1_1 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v14, 0xD6BD0031, v1_1);
            if(!(v14.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v14.startReusableNode();
            if(v14.getInserting()) {
                v14.createNode(v3_3);
            }
            else {
                v14.useNode();
            }

            Composer v3_4 = Updater.constructor-impl(v14);
            Updater.set-impl(v3_4, v2_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v3_4, v6_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v2_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v3_4.getInserting()) || !Intrinsics.areEqual(v3_4.rememberedValue(), Integer.valueOf(v5_1))) {
                v3_4.updateRememberedValue(Integer.valueOf(v5_1));
                v3_4.apply(Integer.valueOf(v5_1), v2_3);
            }

            Updater.set-impl(v3_4, v7_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v14, 0xAEE0EC11, "C2997@141514L281,3044@143662L265:AppBar.kt#uh7d8r");
            Modifier v26 = LayoutIdKt.layoutId(Modifier.Companion, "navigationIcon");
            float v27 = AppBarKt.TopAppBarHorizontalPadding;
            Modifier v2_4 = PaddingKt.padding-qDBjuR0$default(v26, v27, 0f, 0f, 0f, 14, null);
            float v9_1 = v27;
            ComposerKt.sourceInformationMarkerStart(v14, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v6_2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v14, -1323940314, v4_2);
            v3_1 = ComposablesKt.getCurrentCompositeKeyHash(v14, 0);
            CompositionLocalMap v7_2 = v14.getCurrentCompositionLocalMap();
            v2_4 = ComposedModifierKt.materializeModifier(v14, v2_4);
            int v20 = v3_1;
            v3_3 = ComposeUiNode.Companion.getConstructor();
            String v27_1 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v14, 0xD6BD0031, v1_1);
            if(!(v14.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v14.startReusableNode();
            if(v14.getInserting()) {
                v14.createNode(v3_3);
            }
            else {
                v14.useNode();
            }

            v3_4 = Updater.constructor-impl(v14);
            Updater.set-impl(v3_4, v6_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v3_4, v7_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v5_2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v3_4.getInserting()) || !Intrinsics.areEqual(v3_4.rememberedValue(), Integer.valueOf(v20))) {
                v3_4.updateRememberedValue(Integer.valueOf(v20));
                v3_4.apply(Integer.valueOf(v20), v5_2);
            }

            Updater.set-impl(v3_4, v2_4, ComposeUiNode.Companion.getSetModifier());
            v3_2 = "C72@3468L9:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v14, 0x800B7D29, v3_2);
            ComposerKt.sourceInformationMarkerStart(v14, -1301830080, "C2998@141617L164:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(arg38)), v0_3, v14, ProvidedValue.$stable | v23 >> 12 & 0x70);
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            v14.endNode();
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            if(v13 != null) {
                v14.startReplaceGroup(0xAEE50CF8);
                ComposerKt.sourceInformation(v14, "3012@142259L24,3004@141848L997");
                v2_4 = PaddingKt.padding-VpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "title"), v9_1, 0f, 2, null);
                if(arg54) {
                    v14.startReplaceGroup(510303260);
                    ComposerKt.sourceInformation(v14, "3009@142137L2");
                    Companion v5_3 = Modifier.Companion;
                    v7_3 = v25;
                    ComposerKt.sourceInformationMarkerStart(v14, 510303911, v7_3);
                    Object v6_3 = v14.rememberedValue();
                    if(v6_3 == Composer.Companion.getEmpty()) {
                        AppBarKt$$ExternalSyntheticLambda11 v6_4 = new AppBarKt$$ExternalSyntheticLambda11();
                        v14.updateRememberedValue(v6_4);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v14);
                    v0_4 = SemanticsModifierKt.clearAndSetSemantics(((Modifier)v5_3), ((Function1)v6_3));
                    v14.endReplaceGroup();
                }
                else {
                    v7_3 = v25;
                    v14.startReplaceGroup(510305197);
                    v14.endReplaceGroup();
                    Companion v0_5 = Modifier.Companion;
                }

                v0_4 = v2_4.then(v0_4);
                ComposerKt.sourceInformationMarkerStart(v14, 510307837, v7_3);
                if((v23 & 14) == 4) {
                }
                else {
                    v22 = 0;
                }

                v2_1 = v14.rememberedValue();
                if(v22 != 0 || v2_1 == Composer.Companion.getEmpty()) {
                    AppBarKt$$ExternalSyntheticLambda22 v2_5 = new AppBarKt$$ExternalSyntheticLambda22(v15);
                    v14.updateRememberedValue(v2_5);
                }

                ComposerKt.sourceInformationMarkerEnd(v14);
                v0_4 = GraphicsLayerModifierKt.graphicsLayer(v0_4, ((Function1)v2_1));
                ComposerKt.sourceInformationMarkerStart(v14, 0xE32F0E82, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy v2_6 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), v8_4, v14, v16 >> 3 & 0x70);
                ComposerKt.sourceInformationMarkerStart(v14, -1323940314, v4_2);
                v6 = ComposablesKt.getCurrentCompositeKeyHash(v14, 0);
                v7_2 = v14.getCurrentCompositionLocalMap();
                v0_4 = ComposedModifierKt.materializeModifier(v14, v0_4);
                v5_4 = ComposeUiNode.Companion.getConstructor();
                v25 = v3_2;
                ComposerKt.sourceInformationMarkerStart(v14, 0xD6BD0031, v1_1);
                if(!(v14.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v14.startReusableNode();
                if(v14.getInserting()) {
                    v14.createNode(v5_4);
                }
                else {
                    v14.useNode();
                }

                v3_4 = Updater.constructor-impl(v14);
                Updater.set-impl(v3_4, v2_6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v3_4, v7_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                v2_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v3_4.getInserting()) || !Intrinsics.areEqual(v3_4.rememberedValue(), Integer.valueOf(v6))) {
                    v3_4.updateRememberedValue(Integer.valueOf(v6));
                    v3_4.apply(Integer.valueOf(v6), v2_3);
                }

                Updater.set-impl(v3_4, v0_4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v14, 0xE9125B67, "C89@4556L9:Column.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(v14, -190335683, "C3015@142393L202,3020@142616L211:AppBar.kt#uh7d8r");
                int v2_7 = v58 >> 18;
                v3_1 = v58 >> 12;
                ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(arg40, arg47, arg46, v14, v58 >> 9 & 14 | v2_7 & 0x70 | v3_1 & 0x380);
                v6_5 = v14;
                v0_6 = v25;
                v14_1 = v27_1;
                ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(arg42, arg49, v13, v6_5, v3_1 & 14 | v58 >> 24 & 0x70 | v2_7 & 0x380);
                ComposerKt.sourceInformationMarkerEnd(v6_5);
                ComposerKt.sourceInformationMarkerEnd(v6_5);
                v6_5.endNode();
                ComposerKt.sourceInformationMarkerEnd(v6_5);
                ComposerKt.sourceInformationMarkerEnd(v6_5);
                ComposerKt.sourceInformationMarkerEnd(v6_5);
                v6_5.endReplaceGroup();
                v4_2 = v4_2;
            }
            else {
                v0_6 = v3_2;
                String v34 = v4_2;
                v6_5 = v14;
                v7_3 = v25;
                v14_1 = v27_1;
                int v13_1 = 0x2BB5B5D7;
                v6_5.startReplaceGroup(0xAEF499ED);
                ComposerKt.sourceInformation(v6_5, "3035@143350L24,3027@142942L693");
                v2_4 = PaddingKt.padding-VpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "title"), v9_1, 0f, 2, null);
                if(arg54) {
                    v6_5.startReplaceGroup(510338172);
                    ComposerKt.sourceInformation(v6_5, "3032@143228L2");
                    v3_5 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(v6_5, 0x1E6B2707, v7_3);
                    Object v4_3 = v6_5.rememberedValue();
                    if(v4_3 == Composer.Companion.getEmpty()) {
                        AppBarKt$$ExternalSyntheticLambda30 v4_4 = new AppBarKt$$ExternalSyntheticLambda30();
                        v6_5.updateRememberedValue(v4_4);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v6_5);
                    Modifier v3_6 = SemanticsModifierKt.clearAndSetSemantics(((Modifier)v3_5), ((Function1)v4_3));
                    v6_5.endReplaceGroup();
                }
                else {
                    v6_5.startReplaceGroup(510340109);
                    v6_5.endReplaceGroup();
                    v3_5 = Modifier.Companion;
                }

                v2_4 = v2_4.then(((Modifier)v3_5));
                ComposerKt.sourceInformationMarkerStart(v6_5, 510342749, v7_3);
                if((v23 & 14) == 4) {
                }
                else {
                    v22 = 0;
                }

                Object v3_7 = v6_5.rememberedValue();
                if(v22 != 0 || v3_7 == Composer.Companion.getEmpty()) {
                    v3_8 = new AppBarKt$$ExternalSyntheticLambda31(v15);
                    v6_5.updateRememberedValue(v3_8);
                }

                ComposerKt.sourceInformationMarkerEnd(v6_5);
                v2_4 = GraphicsLayerModifierKt.graphicsLayer(v2_4, ((Function1)v3_8));
                ComposerKt.sourceInformationMarkerStart(v6_5, v13_1, v14_1);
                v3_9 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                v4_2 = v34;
                ComposerKt.sourceInformationMarkerStart(v6_5, -1323940314, v4_2);
                v16 = ComposablesKt.getCurrentCompositeKeyHash(v6_5, 0);
                v7_2 = v6_5.getCurrentCompositionLocalMap();
                v2_4 = ComposedModifierKt.materializeModifier(v6_5, v2_4);
                v5_4 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v6_5, 0xD6BD0031, v1_1);
                if(!(v6_5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v6_5.startReusableNode();
                if(v6_5.getInserting()) {
                    v6_5.createNode(v5_4);
                }
                else {
                    v6_5.useNode();
                }

                Composer v5_5 = Updater.constructor-impl(v6_5);
                Updater.set-impl(v5_5, v3_9, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v5_5, v7_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                v3_10 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v5_5.getInserting()) || !Intrinsics.areEqual(v5_5.rememberedValue(), Integer.valueOf(v16))) {
                    v5_5.updateRememberedValue(Integer.valueOf(v16));
                    v5_5.apply(Integer.valueOf(v16), v3_10);
                }

                Updater.set-impl(v5_5, v2_4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v6_5, 0x800B7D29, v0_6);
                ComposerKt.sourceInformationMarkerStart(v6_5, 0xED39DAFE, "C3037@143415L202:AppBar.kt#uh7d8r");
                ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(arg40, arg47, arg46, v6_5, v58 >> 9 & 14 | v58 >> 18 & 0x70 | v58 >> 12 & 0x380);
                ComposerKt.sourceInformationMarkerEnd(v6_5);
                ComposerKt.sourceInformationMarkerEnd(v6_5);
                v6_5.endNode();
                ComposerKt.sourceInformationMarkerEnd(v6_5);
                ComposerKt.sourceInformationMarkerEnd(v6_5);
                ComposerKt.sourceInformationMarkerEnd(v6_5);
                v6_5.endReplaceGroup();
            }

            v2_4 = PaddingKt.padding-qDBjuR0$default(LayoutIdKt.layoutId(Modifier.Companion, "actionIcons"), 0f, 0f, v9_1, 0f, 11, null);
            ComposerKt.sourceInformationMarkerStart(v6_5, 0x2BB5B5D7, v14_1);
            v3_9 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v6_5, -1323940314, v4_2);
            v4 = ComposablesKt.getCurrentCompositeKeyHash(v6_5, 0);
            CompositionLocalMap v5_6 = v6_5.getCurrentCompositionLocalMap();
            v2_4 = ComposedModifierKt.materializeModifier(v6_5, v2_4);
            Function0 v7_4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v6_5, 0xD6BD0031, v1_1);
            if(!(v6_5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v6_5.startReusableNode();
            if(v6_5.getInserting()) {
                v6_5.createNode(v7_4);
            }
            else {
                v6_5.useNode();
            }

            Composer v1_2 = Updater.constructor-impl(v6_5);
            Updater.set-impl(v1_2, v3_9, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v1_2, v5_6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            v3_10 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v1_2.getInserting()) || !Intrinsics.areEqual(v1_2.rememberedValue(), Integer.valueOf(v4))) {
                v1_2.updateRememberedValue(Integer.valueOf(v4));
                v1_2.apply(Integer.valueOf(v4), v3_10);
            }

            Updater.set-impl(v1_2, v2_4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v6_5, 0x800B7D29, v0_6);
            ComposerKt.sourceInformationMarkerStart(v6_5, 0xA514EF22, "C3045@143760L153:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(arg44)), v10, v6_5, ProvidedValue.$stable | v23 >> 15 & 0x70);
            ComposerKt.sourceInformationMarkerEnd(v6_5);
            ComposerKt.sourceInformationMarkerEnd(v6_5);
            v6_5.endNode();
            ComposerKt.sourceInformationMarkerEnd(v6_5);
            ComposerKt.sourceInformationMarkerEnd(v6_5);
            ComposerKt.sourceInformationMarkerEnd(v6_5);
            ComposerKt.sourceInformationMarkerEnd(v6_5);
            v6_5.endNode();
            ComposerKt.sourceInformationMarkerEnd(v6_5);
            ComposerKt.sourceInformationMarkerEnd(v6_5);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_796;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v8_4 = v5;
            v6_5 = v14;
            v6_5.skipToGroupEnd();
        }

    label_796:
        ScopeUpdateScope v0_7 = v6_5.endRestartGroup();
        if(v0_7 != null) {
            v0_7.updateScope(new AppBarKt$$ExternalSyntheticLambda32(arg36, arg37, arg38, arg40, arg42, arg44, arg46, arg47, arg48, arg49, v15, arg51, v8_4, arg53, arg54, arg55, v10, arg57, v11, v12));
        }
    }

    static final Unit TopAppBarLayout_lyUyIHI$lambda$51$lambda$41$lambda$40(SemanticsPropertyReceiver arg0) {
        return Unit.INSTANCE;
    }

    static final Unit TopAppBarLayout_lyUyIHI$lambda$51$lambda$43$lambda$42(Function0 arg0, GraphicsLayerScope arg1) {
        arg1.setAlpha(arg0.invoke().floatValue());
        return Unit.INSTANCE;
    }

    static final Unit TopAppBarLayout_lyUyIHI$lambda$51$lambda$46$lambda$45(SemanticsPropertyReceiver arg0) {
        return Unit.INSTANCE;
    }

    static final Unit TopAppBarLayout_lyUyIHI$lambda$51$lambda$48$lambda$47(Function0 arg0, GraphicsLayerScope arg1) {
        arg1.setAlpha(arg0.invoke().floatValue());
        return Unit.INSTANCE;
    }

    static final Unit TopAppBarLayout_lyUyIHI$lambda$53(Modifier arg26, FloatProducer arg27, long arg28, long arg30, long arg32, long arg34, Function2 arg36, TextStyle arg37, Function2 arg38, TextStyle arg39, Function0 arg40, Vertical arg41, androidx.compose.ui.Alignment$Horizontal arg42, int arg43, boolean arg44, Function2 arg45, Function2 arg46, float arg47, int arg48, int arg49, Composer arg50, int arg51) {
        AppBarKt.TopAppBarLayout-lyUyIHI(arg26, arg27, arg28, arg30, arg32, arg34, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg45, arg46, arg47, arg50, RecomposeScopeImplKt.updateChangedFlags(arg48 | 1), RecomposeScopeImplKt.updateChangedFlags(arg49));
        return Unit.INSTANCE;
    }

    static final Unit TopAppBar_GHTll3U$lambda$1(Function2 arg12, Modifier arg13, Function2 arg14, Function3 arg15, float arg16, WindowInsets arg17, TopAppBarColors arg18, TopAppBarScrollBehavior arg19, int arg20, int arg21, Composer arg22, int arg23) {
        AppBarKt.TopAppBar-GHTll3U(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    static final Unit TopAppBar_cJHQLPU$lambda$4(Function2 arg14, Function2 arg15, Modifier arg16, Function2 arg17, Function3 arg18, androidx.compose.ui.Alignment$Horizontal arg19, float arg20, WindowInsets arg21, TopAppBarColors arg22, TopAppBarScrollBehavior arg23, int arg24, int arg25, Composer arg26, int arg27) {
        AppBarKt.TopAppBar-cJHQLPU(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final void TwoRowsTopAppBar-eXZ4JBQ(Function3 arg38, Modifier arg39, Function3 arg40, Function2 arg41, Function3 arg42, androidx.compose.ui.Alignment$Horizontal arg43, float arg44, float arg45, WindowInsets arg46, TopAppBarColors arg47, TopAppBarScrollBehavior arg48, Composer arg49, int arg50, int arg51, int arg52) {
        TopAppBarScrollBehavior v11_2;
        TopAppBarColors v10_2;
        WindowInsets v9_1;
        Function3 v5_1;
        Function2 v4_3;
        androidx.compose.ui.Alignment$Horizontal v6_2;
        Modifier v2_1;
        float v8_2;
        float v7_2;
        Function3 v3_4;
        Composer v33;
        float v29;
        Modifier v15_1;
        float v11_1;
        Function3 v27;
        Function2 v26;
        TopAppBarScrollBehavior v32;
        TopAppBarColors v31;
        WindowInsets v30;
        float v13_1;
        androidx.compose.ui.Alignment$Horizontal v25;
        TopAppBarColors v6_1;
        WindowInsets v15_2;
        Companion v3_2;
        int v21;
        int v19;
        float v0;
        int v16;
        Function3 v15;
        int v13;
        Function2 v11;
        int v10;
        Function3 v9;
        int v8;
        Modifier v7;
        int v3;
        Function3 v1 = arg38;
        int v12 = arg50;
        int v14 = arg52;
        Composer v2 = arg49.startRestartGroup(0x63B61AC0);
        ComposerKt.sourceInformation(v2, "C(TwoRowsTopAppBar)N(title,modifier,subtitle,navigationIcon,actions,titleHorizontalAlignment,collapsedHeight:c#ui.unit.Dp,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)965@49886L5,966@49951L5,971@50176L5,973@50300L5,964@49807L15,968@50014L16,970@50080L26,972@50207L27,963@49773L1578:AppBar.kt#uh7d8r");
        if((v14 & 1) != 0) {
            v3 = v12 | 6;
        }
        else if((v12 & 6) == 0) {
            v3 = v2.changedInstance(v1) ? 4 : 2;
            v3 |= v12;
        }
        else {
            v3 = v12;
        }

        int v6 = v14 & 2;
        if(v6 != 0) {
            v3 |= 0x30;
            goto label_36;
        }
        else if((v12 & 0x30) == 0) {
            v7 = arg39;
            v8 = v2.changed(v7) ? 0x20 : 16;
            v3 |= v8;
        }
        else {
        label_36:
            v7 = arg39;
        }

        v8 = v14 & 4;
        if(v8 != 0) {
            v3 |= 0x180;
            goto label_51;
        }
        else if((v12 & 0x180) == 0) {
            v9 = arg40;
            v10 = v2.changedInstance(v9) ? 0x100 : 0x80;
            v3 |= v10;
        }
        else {
        label_51:
            v9 = arg40;
        }

        v10 = v14 & 8;
        if(v10 != 0) {
            v3 |= 0xC00;
            goto label_66;
        }
        else if((v12 & 0xC00) == 0) {
            v11 = arg41;
            v13 = v2.changedInstance(v11) ? 0x800 : 0x400;
            v3 |= v13;
        }
        else {
        label_66:
            v11 = arg41;
        }

        v13 = v14 & 16;
        if(v13 != 0) {
            v3 |= 0x6000;
            goto label_81;
        }
        else if((v12 & 0x6000) == 0) {
            v15 = arg42;
            v16 = v2.changedInstance(v15) ? 0x4000 : 0x2000;
            v3 |= v16;
        }
        else {
        label_81:
            v15 = arg42;
        }

        v16 = v14 & 0x20;
        int v17 = 0x30000;
        if(v16 != 0) {
            v3 |= v17;
        }
        else {
            androidx.compose.ui.Alignment$Horizontal v4 = arg43;
            if((v12 & v17) == 0) {
                v17 = v2.changed(v4) ? 0x20000 : 0x10000;
                v3 |= v17;
            }
        }

        v17 = v14 & 0x40;
        int v18 = 0x180000;
        if(v17 != 0) {
            v3 |= v18;
        }
        else {
            v0 = arg44;
            if((v12 & v18) == 0) {
                v19 = v2.changed(v0) ? 0x100000 : 0x80000;
                v3 |= v19;
            }
        }

        int v5 = v14 & 0x80;
        int v20 = 0xC00000;
        if(v5 != 0) {
            v3 |= v20;
        }
        else {
            v0 = arg45;
            if((v12 & v20) == 0) {
                v20 = v2.changed(v0) ? 0x800000 : 0x400000;
                v3 |= v20;
            }
        }

        if((v12 & 0x6000000) == 0) {
            v20 = (v14 & 0x100) != 0 || !v2.changed(arg46) ? 0x2000000 : 0x4000000;
            v3 |= v20;
        }

        if((v12 & 0x30000000) == 0) {
            v20 = (v14 & 0x200) != 0 || !v2.changed(arg47) ? 0x10000000 : 0x20000000;
            v3 |= v20;
        }

        int v0_1 = v14 & 0x400;
        if(v0_1 != 0) {
            v20 = v0_1;
            v0_1 = arg51 | 6;
        }
        else if((arg51 & 6) == 0) {
            v20 = v0_1;
            v21 = v2.changed(arg48) ? 4 : 2;
            v0_1 = arg51 | v21;
        }
        else {
            v20 = v0_1;
            v0_1 = arg51;
        }

        int v49 = v3;
        v21 = v5;
        boolean v3_1 = (v49 & 306783379) != 306783378 || (v0_1 & 3) != 2 ? true : false;
        if(v2.shouldExecute(v3_1, v49 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "959@49631L12,960@49693L17");
            v19 = 0xF1FFFFFF;
            int v4_1 = 6;
            if((v12 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v6 != 0) {
                    v3_2 = Modifier.Companion;
                }
                else {
                    Modifier v3_3 = v7;
                }

                if(v8 != 0) {
                    v9 = null;
                }

                Function2 v7_1 = v10 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.getLambda$1767216677$material3() : v11;
                Function3 v8_1 = v13 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.getLambda$-470693625$material3() : v15;
                androidx.compose.ui.Alignment$Horizontal v10_1 = v16 != 0 ? Alignment.Companion.getStart() : arg43;
                v11_1 = v17 != 0 ? Dp.Companion.getUnspecified-D9Ej5fM() : arg44;
                v13_1 = v21 != 0 ? Dp.Companion.getUnspecified-D9Ej5fM() : arg45;
                if((v14 & 0x100) != 0) {
                    v15_2 = TopAppBarDefaults.INSTANCE.getWindowInsets(v2, v4_1);
                    v16 = v49 & v19;
                }
                else {
                    v15_2 = arg46;
                    v16 = v49;
                }

                if((v14 & 0x200) != 0) {
                    v6_1 = TopAppBarDefaults.INSTANCE.topAppBarColors(v2, v4_1);
                    v16 &= 0x8FFFFFFF;
                }
                else {
                    v6_1 = arg47;
                }

                if(v20 != 0) {
                    v31 = v6_1;
                    v26 = v7_1;
                    v27 = v8_1;
                    v25 = v10_1;
                    v30 = v15_2;
                    v32 = null;
                }
                else {
                    v32 = arg48;
                    v31 = v6_1;
                    v26 = v7_1;
                    v27 = v8_1;
                    v25 = v10_1;
                    v30 = v15_2;
                }

                Companion v15_3 = v3_2;
                v3 = v16;
            }
            else {
                v2.skipToGroupEnd();
                v3 = (v14 & 0x100) != 0 ? v49 & v19 : v49;
                if((v14 & 0x200) != 0) {
                    v3 &= 0x8FFFFFFF;
                }

                v25 = arg43;
                v13_1 = arg45;
                v30 = arg46;
                v31 = arg47;
                v32 = arg48;
                v26 = v11;
                v27 = v15;
                v11_1 = arg44;
                v15_1 = v7;
            }

            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x63B61AC0, v3, v0_1, "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:962)");
            }

            TextStyle v17_1 = TypographyKt.getValue(AppBarMediumFlexibleTokens.INSTANCE.getTitleFont(), v2, v4_1);
            TextStyle v20_1 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), v2, v4_1);
            float v18_1 = Dp.constructor-impl(0f);
            TextStyle v22 = TypographyKt.getValue(AppBarMediumFlexibleTokens.INSTANCE.getSubtitleFont(), v2, v4_1);
            TextStyle v24 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getSubtitleFont(), v2, v4_1);
            float v28 = (Dp.equals-impl0(v11_1, Dp.Companion.getUnspecified-D9Ej5fM())) || (Dp.equals-impl0(v11_1, Dp.Companion.getInfinity-D9Ej5fM())) ? TopAppBarDefaults.INSTANCE.getMediumAppBarCollapsedHeight-D9Ej5fM() : v11_1;
            if((Dp.equals-impl0(v13_1, Dp.Companion.getUnspecified-D9Ej5fM())) || (Dp.equals-impl0(v13_1, Dp.Companion.getInfinity-D9Ej5fM()))) {
                float v4_2 = v9 != null ? TopAppBarDefaults.INSTANCE.getMediumFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM() : TopAppBarDefaults.INSTANCE.getMediumFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM();
                v29 = v4_2;
            }
            else {
                v29 = v13_1;
            }

            int v34 = v3 >> 3 & 14 | 0x6186C30;
            v5 = v3 >> 6;
            v4_1 = v3 >> 15 & 14 | v5 & 0x70 | v5 & 0x380;
            v3 >>= 9;
            v33 = v2;
            AppBarKt.TwoRowsTopAppBar-pJA5dT0(v15_1, ComposableLambdaKt.rememberComposableLambda(0x9C2B44D0, true, new AppBarKt$TwoRowsTopAppBar$1(v1), v2, 54), v17_1, v18_1, ComposableLambdaKt.rememberComposableLambda(1295408045, true, new AppBarKt$TwoRowsTopAppBar$2(v1), v2, 54), v20_1, ComposableLambdaKt.rememberComposableLambda(0x6DE86AEB, true, new AppBarKt$TwoRowsTopAppBar$3(v9), v2, 54), v22, ComposableLambdaKt.rememberComposableLambda(-1902478807, true, new AppBarKt$TwoRowsTopAppBar$4(v9), v2, 54), v24, v25, v26, v27, v28, v29, v30, v31, v32, v33, v34, v3 & 0x380000 | (v4_1 | 0x70000 & v3) | v0_1 << 21 & 0x1C00000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_4 = v9;
            v7_2 = v11_1;
            v8_2 = v13_1;
            v2_1 = v15_1;
            v6_2 = v25;
            v4_3 = v26;
            v5_1 = v27;
            v9_1 = v30;
            v10_2 = v31;
            v11_2 = v32;
        }
        else {
            v33 = v2;
            v33.skipToGroupEnd();
            v6_2 = arg43;
            v8_2 = arg45;
            v10_2 = arg47;
            v2_1 = v7;
            v3_4 = v9;
            v4_3 = v11;
            v5_1 = v15;
            v7_2 = arg44;
            v9_1 = arg46;
            v11_2 = arg48;
        }

        ScopeUpdateScope v15_4 = v33.endRestartGroup();
        if(v15_4 != null) {
            v15_4.updateScope(new AppBarKt$$ExternalSyntheticLambda1(v1, v2_1, v3_4, v4_3, v5_1, v6_2, v7_2, v8_2, v9_1, v10_2, v11_2, v12, arg51, v14));
        }
    }

    private static final void TwoRowsTopAppBar-pJA5dT0(Modifier arg34, Function2 arg35, TextStyle arg36, float arg37, Function2 arg38, TextStyle arg39, Function2 arg40, TextStyle arg41, Function2 arg42, TextStyle arg43, androidx.compose.ui.Alignment$Horizontal arg44, Function2 arg45, Function3 arg46, float arg47, float arg48, WindowInsets arg49, TopAppBarColors arg50, TopAppBarScrollBehavior arg51, Composer arg52, int arg53, int arg54, int arg55) {
        Companion v1_2;
        Companion v14;
        float v3;
        int v27;
        Function2 v12;
        TextStyle v11;
        int v21;
        Function2 v7;
        float v6;
        int v16;
        TextStyle v10_1;
        Function2 v15;
        Modifier v8;
        int v9;
        int v0 = arg53;
        int v1 = arg54;
        int v2 = arg55;
        Composer v4 = arg52.startRestartGroup(1092180406);
        ComposerKt.sourceInformation(v4, "C(TwoRowsTopAppBar)N(modifier,title,titleTextStyle,titleBottomPadding:c#ui.unit.Dp,smallTitle,smallTitleTextStyle,subtitle,subtitleTextStyle,smallSubtitle,smallSubtitleTextStyle,titleHorizontalAlignment,navigationIcon,actions,collapsedHeight:c#ui.unit.Dp,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)2722@127583L7,*2722@127600L18:AppBar.kt#uh7d8r");
        int v5 = v2 & 1;
        if(v5 != 0) {
            v9 = v0 | 6;
            v8 = arg34;
        }
        else if((v0 & 6) == 0) {
            v8 = arg34;
            v9 = v4.changed(v8) ? 4 : 2;
            v9 |= v0;
        }
        else {
            v8 = arg34;
            v9 = v0;
        }

        if((v2 & 2) != 0) {
            v9 |= 0x30;
            v15 = arg35;
        }
        else {
            v15 = arg35;
            if((v0 & 0x30) == 0) {
                int v10 = v4.changedInstance(v15) ? 0x20 : 16;
                v9 |= v10;
            }
        }

        if((v2 & 4) != 0) {
            v9 |= 0x180;
            goto label_54;
        }
        else if((v0 & 0x180) == 0) {
            v10_1 = arg36;
            v16 = v4.changed(v10_1) ? 0x100 : 0x80;
            v9 |= v16;
        }
        else {
        label_54:
            v10_1 = arg36;
        }

        int v17 = 0x800;
        int v18 = 0x400;
        if((v2 & 8) != 0) {
            v9 |= 0xC00;
            goto label_71;
        }
        else if((v0 & 0xC00) == 0) {
            v6 = arg37;
            v16 = v4.changed(v6) ? v17 : v18;
            v9 |= v16;
        }
        else {
        label_71:
            v6 = arg37;
        }

        int v19 = 0x4000;
        int v20 = 0x2000;
        if((v2 & 16) != 0) {
            v9 |= 0x6000;
            goto label_88;
        }
        else if((v0 & 0x6000) == 0) {
            v7 = arg38;
            v21 = v4.changedInstance(v7) ? v19 : v20;
            v9 |= v21;
        }
        else {
        label_88:
            v7 = arg38;
        }

        int v22 = 0x20000;
        int v23 = 0x10000;
        int v24 = 0x30000;
        if((v2 & 0x20) != 0) {
            v9 |= v24;
            v11 = arg39;
        }
        else {
            v11 = arg39;
            if((v0 & v24) == 0) {
                int v25 = v4.changed(v11) ? v22 : v23;
                v9 |= v25;
            }
        }

        int v26 = 0x180000;
        if((v2 & 0x40) != 0) {
            v9 |= v26;
            v12 = arg40;
        }
        else {
            v12 = arg40;
            if((v0 & v26) == 0) {
                v27 = v4.changedInstance(v12) ? 0x100000 : 0x80000;
                v9 |= v27;
            }
        }

        int v28 = 0xC00000;
        if((v2 & 0x80) != 0) {
            v9 |= v28;
        }
        else if((v0 & v28) == 0) {
            int v29 = v4.changed(arg41) ? 0x800000 : 0x400000;
            v9 |= v29;
        }

        if((v2 & 0x100) != 0) {
            v9 |= 0x6000000;
        }
        else if((0x6000000 & v0) == 0) {
            int v30 = v4.changedInstance(arg42) ? 0x4000000 : 0x2000000;
            v9 |= v30;
        }

        if((v2 & 0x200) != 0) {
            v9 |= 0x30000000;
        }
        else if((0x30000000 & v0) == 0) {
            int v31 = v4.changed(arg43) ? 0x20000000 : 0x10000000;
            v9 |= v31;
        }

        if((v2 & 0x400) != 0) {
            v16 = v1 | 6;
        }
        else if((v1 & 6) == 0) {
            v16 = v4.changed(arg44) ? 4 : 2;
            v16 |= v1;
        }
        else {
            v16 = v1;
        }

        if((v2 & 0x800) != 0) {
            v16 |= 0x30;
        }
        else if((v1 & 0x30) == 0) {
            v21 = v4.changedInstance(arg45) ? 0x20 : 16;
            v16 |= v21;
        }

        v0 = v16;
        if((v2 & 0x1000) != 0) {
            v0 |= 0x180;
        }
        else if((v1 & 0x180) == 0) {
            v27 = v4.changedInstance(arg46) ? 0x100 : 0x80;
            v0 |= v27;
        }

        if((v2 & 0x2000) != 0) {
            v0 |= 0xC00;
        }
        else if((v1 & 0xC00) == 0) {
            if(v4.changed(arg47)) {
            }
            else {
                v17 = v18;
            }

            v0 |= v17;
        }

        if((v2 & 0x4000) != 0) {
            v0 |= 0x6000;
            goto label_247;
        }
        else if((v1 & 0x6000) == 0) {
            v3 = arg48;
            if(v4.changed(v3)) {
            }
            else {
                v19 = v20;
            }

            v0 |= v19;
        }
        else {
        label_247:
            v3 = arg48;
        }

        if((v2 & 0x8000) != 0) {
            v16 = v0 | v24;
        }
        else {
            int v52 = v0;
            WindowInsets v0_1 = arg49;
            if((v1 & v24) == 0) {
                v16 = v4.changed(v0_1) ? v22 : v23;
                v16 |= v52;
            }
            else {
                v16 = v52;
            }
        }

        if((v2 & v23) != 0) {
            v16 |= v26;
        }
        else {
            TopAppBarColors v0_2 = arg50;
            if((v1 & v26) == 0) {
                v17 = v4.changed(v0_2) ? 0x100000 : 0x80000;
                v16 |= v17;
            }
        }

        if((v2 & v22) != 0) {
            v16 |= v28;
        }
        else {
            TopAppBarScrollBehavior v0_3 = arg51;
            if((v1 & v28) == 0) {
                v17 = v4.changed(v0_3) ? 0x800000 : 0x400000;
                v16 |= v17;
            }
        }

        v0 = v16;
        boolean v1_1 = (v9 & 306783379) != 306783378 || (0x492493 & v0) != 4793490 ? true : false;
        if(v4.shouldExecute(v1_1, v9 & 1)) {
            if(v5 != 0) {
                v14 = Modifier.Companion;
            }
            else {
                Modifier v14_1 = v8;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1092180406, v9, v0, "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:2700)");
            }

            TwoRowsTopAppBarOverrideScope v13 = new TwoRowsTopAppBarOverrideScope(((Modifier)v14), v15, v10_1, v6, v7, v11, v12, arg41, arg42, arg43, arg44, arg45, arg46, arg47, v3, arg49, arg50, arg51, null);
            ProvidableCompositionLocal v0_4 = AppBarKt.LocalTwoRowsTopAppBarOverride;
            ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_5 = v4.consume(((CompositionLocal)v0_4));
            ComposerKt.sourceInformationMarkerEnd(v4);
            ((TwoRowsTopAppBarOverride)v0_5).TwoRowsTopAppBar(v13, v4, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_2 = v14;
        }
        else {
            v4.skipToGroupEnd();
            Modifier v1_3 = v8;
        }

        ScopeUpdateScope v0_6 = v4.endRestartGroup();
        if(v0_6 != null) {
            v0_6.updateScope(new AppBarKt$$ExternalSyntheticLambda29(((Modifier)v1_2), arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg45, arg46, arg47, arg48, arg49, arg50, arg51, arg53, arg54, arg55));
        }
    }

    static final Unit TwoRowsTopAppBar_eXZ4JBQ$lambda$11(Function3 arg16, Modifier arg17, Function3 arg18, Function2 arg19, Function3 arg20, androidx.compose.ui.Alignment$Horizontal arg21, float arg22, float arg23, WindowInsets arg24, TopAppBarColors arg25, TopAppBarScrollBehavior arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        AppBarKt.TwoRowsTopAppBar-eXZ4JBQ(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    static final Unit TwoRowsTopAppBar_pJA5dT0$lambda$35(Modifier arg23, Function2 arg24, TextStyle arg25, float arg26, Function2 arg27, TextStyle arg28, Function2 arg29, TextStyle arg30, Function2 arg31, TextStyle arg32, androidx.compose.ui.Alignment$Horizontal arg33, Function2 arg34, Function3 arg35, float arg36, float arg37, WindowInsets arg38, TopAppBarColors arg39, TopAppBarScrollBehavior arg40, int arg41, int arg42, int arg43, Composer arg44, int arg45) {
        AppBarKt.TwoRowsTopAppBar-pJA5dT0(arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg44, RecomposeScopeImplKt.updateChangedFlags(arg41 | 1), RecomposeScopeImplKt.updateChangedFlags(arg42), arg43);
        return Unit.INSTANCE;
    }

    public static final void access$TopAppBarLayout-lyUyIHI(Modifier arg0, FloatProducer arg1, long arg2, long arg4, long arg6, long arg8, Function2 arg10, TextStyle arg11, Function2 arg12, TextStyle arg13, Function0 arg14, Vertical arg15, androidx.compose.ui.Alignment$Horizontal arg16, int arg17, boolean arg18, Function2 arg19, Function2 arg20, float arg21, Composer arg22, int arg23, int arg24) {
        AppBarKt.TopAppBarLayout-lyUyIHI(arg0, arg1, arg2, arg4, arg6, arg8, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24);
    }

    public static final Modifier access$adjustHeightOffsetLimit(Modifier arg0, TopAppBarScrollBehavior arg1) {
        return AppBarKt.adjustHeightOffsetLimit(arg0, arg1);
    }

    public static final float access$getBottomAppBarHorizontalPadding$p() {
        return AppBarKt.BottomAppBarHorizontalPadding;
    }

    public static final float access$getFABHorizontalPadding$p() {
        return AppBarKt.FABHorizontalPadding;
    }

    public static final float access$getFABVerticalPadding$p() {
        return AppBarKt.FABVerticalPadding;
    }

    public static final float access$getTopAppBarTitleInset$p() {
        return AppBarKt.TopAppBarTitleInset;
    }

    public static final Object access$settleAppBar(TopAppBarState arg0, float arg1, DecayAnimationSpec arg2, AnimationSpec arg3, Continuation arg4) {
        return AppBarKt.settleAppBar(arg0, arg1, arg2, arg3, arg4);
    }

    public static final Object access$settleAppBarBottom(BottomAppBarState arg0, float arg1, DecayAnimationSpec arg2, AnimationSpec arg3, Continuation arg4) {
        return AppBarKt.settleAppBarBottom(arg0, arg1, arg2, arg3, arg4);
    }

    private static final Modifier adjustHeightOffsetLimit(Modifier arg1, TopAppBarScrollBehavior arg2) {
        if(arg2 != null) {
            TopAppBarState v2 = arg2.getState();
            if(v2 != null) {
                Modifier v2_1 = OnRemeasuredModifierKt.onSizeChanged(arg1, new AppBarKt$$ExternalSyntheticLambda12(v2));
                if(v2_1 == null) {
                }
                else {
                    return v2_1;
                }
            }
        }

        return arg1;
    }

    static final Unit adjustHeightOffsetLimit$lambda$38$lambda$37(TopAppBarState arg4, IntSize arg5) {
        arg4.setHeightOffsetLimit(-((((float)(((int)(arg5.unbox-impl() & 0xFFFFFFFFL))))) - arg4.getHeightOffset()));
        return Unit.INSTANCE;
    }

    public static final float getBottomAppBarVerticalPadding() {
        return AppBarKt.BottomAppBarVerticalPadding;
    }

    public static final ProvidableCompositionLocal getLocalSingleRowTopAppBarOverride() {
        return AppBarKt.LocalSingleRowTopAppBarOverride;
    }

    public static void getLocalSingleRowTopAppBarOverride$annotations() {
    }

    public static final ProvidableCompositionLocal getLocalTwoRowsTopAppBarOverride() {
        return AppBarKt.LocalTwoRowsTopAppBarOverride;
    }

    public static void getLocalTwoRowsTopAppBarOverride$annotations() {
    }

    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return AppBarKt.TopTitleAlphaEasing;
    }

    public static final BottomAppBarState rememberBottomAppBarState(float arg6, float arg7, float arg8, Composer arg9, int arg10, int arg11) {
        AppBarKt$$ExternalSyntheticLambda34 v0_2;
        int v1 = 0x54B0D200;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(rememberBottomAppBarState)N(initialHeightOffsetLimit,initialHeightOffset,initialContentOffset)2235@107287L102,2235@107237L152:AppBar.kt#uh7d8r");
        if((arg11 & 1) != 0) {
            arg6 = -3.402823E+38f;
        }

        int v0 = 4;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.material3.rememberBottomAppBarState (AppBar.kt:2234)");
        }

        Object[] v1_1 = new Object[0];
        Saver v2 = BottomAppBarState.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart(arg9, 0xEBC475E6, "CC(remember):AppBar.kt#9igjgp");
        int v4 = 1;
        v0 = (arg10 & 14 ^ 6) > v0 && (arg9.changed(arg6)) || (arg10 & 6) == v0 ? 1 : 0;
        int v5 = 0x20;
        int v3 = (arg10 & 0x70 ^ 0x30) > v5 && (arg9.changed(0f)) || (arg10 & 0x30) == v5 ? 1 : 0;
        v0 |= v3;
        v5 = 0x100;
        if((arg10 & 0x380 ^ 0x180) <= v5 || !arg9.changed(0f)) {
            if((arg10 & 0x180) == v5) {
            }
            else {
                v4 = 0;
            }
        }

        arg10 = v0 | v4;
        Object v0_1 = arg9.rememberedValue();
        if(arg10 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            v0_2 = new AppBarKt$$ExternalSyntheticLambda34(arg6, 0f, 0f);
            arg9.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        Object v6 = RememberSaveableKt.rememberSaveable(v1_1, v2, ((Function0)v0_2), arg9, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        return ((BottomAppBarState)v6);
    }

    static final BottomAppBarState rememberBottomAppBarState$lambda$28$lambda$27(float arg0, float arg1, float arg2) {
        return AppBarKt.BottomAppBarState(arg0, arg1, arg2);
    }

    public static final TopAppBarState rememberTopAppBarState(float arg6, float arg7, float arg8, Composer arg9, int arg10, int arg11) {
        AppBarKt$$ExternalSyntheticLambda35 v0_2;
        int v1 = 0x6B67E0A2;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(rememberTopAppBarState)N(initialHeightOffsetLimit,initialHeightOffset,initialContentOffset)1858@91732L99,1858@91685L146:AppBar.kt#uh7d8r");
        if((arg11 & 1) != 0) {
            arg6 = -3.402823E+38f;
        }

        int v0 = 4;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:1857)");
        }

        Object[] v1_1 = new Object[0];
        Saver v2 = TopAppBarState.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart(arg9, 0x30F25FA5, "CC(remember):AppBar.kt#9igjgp");
        int v4 = 1;
        v0 = (arg10 & 14 ^ 6) > v0 && (arg9.changed(arg6)) || (arg10 & 6) == v0 ? 1 : 0;
        int v5 = 0x20;
        int v3 = (arg10 & 0x70 ^ 0x30) > v5 && (arg9.changed(0f)) || (arg10 & 0x30) == v5 ? 1 : 0;
        v0 |= v3;
        v5 = 0x100;
        if((arg10 & 0x380 ^ 0x180) <= v5 || !arg9.changed(0f)) {
            if((arg10 & 0x180) == v5) {
            }
            else {
                v4 = 0;
            }
        }

        arg10 = v0 | v4;
        Object v0_1 = arg9.rememberedValue();
        if(arg10 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            v0_2 = new AppBarKt$$ExternalSyntheticLambda35(arg6, 0f, 0f);
            arg9.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        Object v6 = RememberSaveableKt.rememberSaveable(v1_1, v2, ((Function0)v0_2), arg9, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        return ((TopAppBarState)v6);
    }

    static final TopAppBarState rememberTopAppBarState$lambda$26$lambda$25(float arg1, float arg2, float arg3) {
        return new TopAppBarState(arg1, arg2, arg3);
    }

    private static final State rememberTouchExplorationService(Composer arg9, int arg10) {
        int v1 = 0x9D036E62;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(rememberTouchExplorationService)3498@163258L171:AppBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.material3.rememberTouchExplorationService (AppBar.kt:3498)");
        }

        Composer v6 = arg9;
        State v9 = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(true, false, false, v6, 438, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        return v9;
    }

    private static final Object settleAppBar(TopAppBarState arg21, float arg22, DecayAnimationSpec arg23, AnimationSpec arg24, Continuation arg25) {
        Object v0_1;
        AnimationSpec v12_1;
        Continuation v2;
        TopAppBarState v0 = arg21;
        Continuation v1 = arg25;
        if((v1 instanceof AppBarKt$settleAppBar$1)) {
            v2 = v1;
            int v4 = 0x80000000;
            if((((AppBarKt$settleAppBar$1)v2).label & v4) != 0) {
                ((AppBarKt$settleAppBar$1)v2).label -= v4;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            AppBarKt$settleAppBar$1 v2_1 = new AppBarKt$settleAppBar$1(v1);
        }

        Continuation v7 = v2;
        Object v1_1 = ((AppBarKt$settleAppBar$1)v7).result;
        Object v2_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v3 = ((AppBarKt$settleAppBar$1)v7).label;
        int v10 = 2;
        if(v3 == 0) {
            ResultKt.throwOnFailure(v1_1);
            if(v0.getCollapsedFraction() >= 0.01f) {
                float v3_2 = 1f;
                if(v0.getCollapsedFraction() == v3_2) {
                }
                else {
                    FloatRef v1_2 = new FloatRef();
                    float v13 = arg22;
                    v1_2.element = v13;
                    if(arg23 != null && Math.abs(v13) > v3_2) {
                        FloatRef v3_3 = new FloatRef();
                        AnimationState v5 = AnimationStateKt.AnimationState$default(0f, v13, 0, 0, false, 28, null);
                        AppBarKt$$ExternalSyntheticLambda18 v6 = new AppBarKt$$ExternalSyntheticLambda18(v3_3, v0, v1_2);
                        ((AppBarKt$settleAppBar$1)v7).L$0 = v0;
                        v12_1 = arg24;
                        ((AppBarKt$settleAppBar$1)v7).L$1 = v12_1;
                        ((AppBarKt$settleAppBar$1)v7).L$2 = v1_2;
                        ((AppBarKt$settleAppBar$1)v7).label = 1;
                        if(SuspendAnimationKt.animateDecay$default(v5, arg23, false, ((Function1)v6), v7, 2, null) == v2_2) {
                            return v2_2;
                        }
                        else {
                            goto label_79;
                        }
                    }

                    v12_1 = arg24;
                label_79:
                    Object v5_1 = v12_1;
                    if(v5_1 == null) {
                        goto label_121;
                    }

                    if(v0.getHeightOffset() >= 0f) {
                        goto label_121;
                    }

                    if(v0.getHeightOffset() <= v0.getHeightOffsetLimit()) {
                        goto label_121;
                    }

                    AnimationState v3_4 = AnimationStateKt.AnimationState$default(v0.getHeightOffset(), 0f, 0, 0, false, 30, null);
                    float v4_2 = v0.getCollapsedFraction() < 0.5f ? 0f : v0.getHeightOffsetLimit();
                    Float v4_3 = Boxing.boxFloat(v4_2);
                    AppBarKt$$ExternalSyntheticLambda19 v6_1 = new AppBarKt$$ExternalSyntheticLambda19(v0);
                    ((AppBarKt$settleAppBar$1)v7).L$0 = v1_1;
                    ((AppBarKt$settleAppBar$1)v7).L$1 = null;
                    ((AppBarKt$settleAppBar$1)v7).L$2 = null;
                    ((AppBarKt$settleAppBar$1)v7).label = v10;
                    if(SuspendAnimationKt.animateTo$default(v3_4, v4_3, ((AnimationSpec)v5_1), false, v6_1, v7, 4, null) == v2_2) {
                        return v2_2;
                    }

                    v0_1 = v1_1;
                label_120:
                    v1_1 = v0_1;
                    goto label_121;
                }
            }

            goto label_125;
        }
        else if(v3 == 1) {
            v0_1 = ((AppBarKt$settleAppBar$1)v7).L$2;
            Object v3_1 = ((AppBarKt$settleAppBar$1)v7).L$1;
            Object v4_1 = ((AppBarKt$settleAppBar$1)v7).L$0;
            ResultKt.throwOnFailure(v1_1);
            v1_1 = v0_1;
            Object v12 = v3_1;
            v0_1 = v4_1;
            goto label_79;
        }
        else if(v3 == v10) {
            v0_1 = ((AppBarKt$settleAppBar$1)v7).L$0;
            ResultKt.throwOnFailure(v1_1);
            goto label_120;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_121:
        return Velocity.box-impl(VelocityKt.Velocity(0f, ((FloatRef)v1_1).element));
    label_125:
        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
    }

    static final Unit settleAppBar$lambda$54(FloatRef arg3, TopAppBarState arg4, FloatRef arg5, AnimationScope arg6) {
        float v0 = arg6.getValue().floatValue() - arg3.element;
        float v1 = arg4.getHeightOffset();
        arg4.setHeightOffset(v1 + v0);
        float v4 = Math.abs(v1 - arg4.getHeightOffset());
        arg3.element = arg6.getValue().floatValue();
        arg5.element = arg6.getVelocity().floatValue();
        if(Math.abs(v0 - v4) > 0.5f) {
            arg6.cancelAnimation();
        }

        return Unit.INSTANCE;
    }

    static final Unit settleAppBar$lambda$55(TopAppBarState arg0, AnimationScope arg1) {
        arg0.setHeightOffset(arg1.getValue().floatValue());
        return Unit.INSTANCE;
    }

    private static final Object settleAppBarBottom(BottomAppBarState arg21, float arg22, DecayAnimationSpec arg23, AnimationSpec arg24, Continuation arg25) {
        Object v0_1;
        AnimationSpec v12_1;
        FloatRef v1_2;
        Continuation v2;
        BottomAppBarState v0 = arg21;
        Continuation v1 = arg25;
        if((v1 instanceof AppBarKt$settleAppBarBottom$1)) {
            v2 = v1;
            int v4 = 0x80000000;
            if((((AppBarKt$settleAppBarBottom$1)v2).label & v4) != 0) {
                ((AppBarKt$settleAppBarBottom$1)v2).label -= v4;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            AppBarKt$settleAppBarBottom$1 v2_1 = new AppBarKt$settleAppBarBottom$1(v1);
        }

        Continuation v7 = v2;
        Object v1_1 = ((AppBarKt$settleAppBarBottom$1)v7).result;
        Object v2_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v3 = ((AppBarKt$settleAppBarBottom$1)v7).label;
        int v10 = 2;
        if(v3 == 0) {
            ResultKt.throwOnFailure(v1_1);
            if(v0.getCollapsedFraction() >= 0.01f) {
                float v3_2 = 1f;
                if(v0.getCollapsedFraction() == v3_2) {
                }
                else {
                    v1_2 = new FloatRef();
                    float v13 = arg22;
                    v1_2.element = v13;
                    if(arg23 != null && Math.abs(v13) > v3_2) {
                        FloatRef v3_3 = new FloatRef();
                        AnimationState v5 = AnimationStateKt.AnimationState$default(0f, v13, 0, 0, false, 28, null);
                        AppBarKt$$ExternalSyntheticLambda23 v6 = new AppBarKt$$ExternalSyntheticLambda23(v3_3, v0, v1_2);
                        ((AppBarKt$settleAppBarBottom$1)v7).L$0 = v0;
                        v12_1 = arg24;
                        ((AppBarKt$settleAppBarBottom$1)v7).L$1 = v12_1;
                        ((AppBarKt$settleAppBarBottom$1)v7).L$2 = v1_2;
                        ((AppBarKt$settleAppBarBottom$1)v7).label = 1;
                        if(SuspendAnimationKt.animateDecay$default(v5, arg23, false, ((Function1)v6), v7, 2, null) == v2_2) {
                            return v2_2;
                        }
                        else {
                            goto label_79;
                        }
                    }

                    v12_1 = arg24;
                label_79:
                    Object v5_1 = v12_1;
                    if(v5_1 == null) {
                        goto label_121;
                    }

                    if(((BottomAppBarState)v0_1).getHeightOffset() >= 0f) {
                        goto label_121;
                    }

                    if(((BottomAppBarState)v0_1).getHeightOffset() <= ((BottomAppBarState)v0_1).getHeightOffsetLimit()) {
                        goto label_121;
                    }

                    AnimationState v3_4 = AnimationStateKt.AnimationState$default(((BottomAppBarState)v0_1).getHeightOffset(), 0f, 0, 0, false, 30, null);
                    float v4_2 = ((BottomAppBarState)v0_1).getCollapsedFraction() < 0.5f ? 0f : ((BottomAppBarState)v0_1).getHeightOffsetLimit();
                    Float v4_3 = Boxing.boxFloat(v4_2);
                    AppBarKt$$ExternalSyntheticLambda24 v6_1 = new AppBarKt$$ExternalSyntheticLambda24(((BottomAppBarState)v0_1));
                    ((AppBarKt$settleAppBarBottom$1)v7).L$0 = v1_2;
                    ((AppBarKt$settleAppBarBottom$1)v7).L$1 = null;
                    ((AppBarKt$settleAppBarBottom$1)v7).L$2 = null;
                    ((AppBarKt$settleAppBarBottom$1)v7).label = v10;
                    if(SuspendAnimationKt.animateTo$default(v3_4, v4_3, ((AnimationSpec)v5_1), false, v6_1, v7, 4, null) == v2_2) {
                        return v2_2;
                    }

                    v0_1 = v1_2;
                label_120:
                    v1_1 = v0_1;
                    goto label_121;
                }
            }

            goto label_125;
        }
        else if(v3 == 1) {
            v0_1 = ((AppBarKt$settleAppBarBottom$1)v7).L$2;
            Object v3_1 = ((AppBarKt$settleAppBarBottom$1)v7).L$1;
            Object v4_1 = ((AppBarKt$settleAppBarBottom$1)v7).L$0;
            ResultKt.throwOnFailure(v1_1);
            v1_1 = v0_1;
            Object v12 = v3_1;
            v0_1 = v4_1;
            goto label_79;
        }
        else if(v3 == v10) {
            v0_1 = ((AppBarKt$settleAppBarBottom$1)v7).L$0;
            ResultKt.throwOnFailure(v1_1);
            goto label_120;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_121:
        return Velocity.box-impl(VelocityKt.Velocity(0f, v1_2.element));
    label_125:
        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
    }

    static final Unit settleAppBarBottom$lambda$29(FloatRef arg3, BottomAppBarState arg4, FloatRef arg5, AnimationScope arg6) {
        float v0 = arg6.getValue().floatValue() - arg3.element;
        float v1 = arg4.getHeightOffset();
        arg4.setHeightOffset(v1 + v0);
        float v4 = Math.abs(v1 - arg4.getHeightOffset());
        arg3.element = arg6.getValue().floatValue();
        arg5.element = arg6.getVelocity().floatValue();
        if(Math.abs(v0 - v4) > 0.5f) {
            arg6.cancelAnimation();
        }

        return Unit.INSTANCE;
    }

    static final Unit settleAppBarBottom$lambda$30(BottomAppBarState arg0, AnimationScope arg1) {
        arg0.setHeightOffset(arg1.getValue().floatValue());
        return Unit.INSTANCE;
    }
}

