package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec$KeyframesSpecConfig;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u001AE\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\f\u0010\r\u001Aj\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\u0019\b\u0002\u0010\u0010\u001A\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001A7\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001AA\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001A?\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\f\u0010\u001A\u001A5\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\bH\u0007¢\u0006\u0004\b\u001B\u0010\u001C\u001A-\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\bH\u0007¢\u0006\u0004\b\u001D\u0010\u001E\u001A;\u0010\u001F\u001A\u00020\u0001*\u00020\u00122\u0006\u0010 \u001A\u00020\u00042\u0006\u0010!\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\"\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u000BH\u0002¢\u0006\u0004\b#\u0010$\u001AO\u0010%\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\"\u001A\u00020\u000F2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007¢\u0006\u0004\b&\u0010\'\u001AY\u0010%\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\"\u001A\u00020\u000F2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u0007¢\u0006\u0004\b(\u0010)\u001AA\u0010%\u001A\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\"\u001A\u00020\u000F2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007¢\u0006\u0004\b*\u0010+\u001AK\u0010%\u001A\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\"\u001A\u00020\u000F2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u0007¢\u0006\u0004\b,\u0010-\u001AI\u0010%\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\"\u001A\u00020\u000F2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007¢\u0006\u0004\b&\u0010.\u001A5\u0010%\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\"\u001A\u00020\u000FH\u0007¢\u0006\u0004\b/\u00100\u001A-\u0010%\u001A\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\"\u001A\u00020\u000FH\u0007¢\u0006\u0004\b1\u00102\u001A3\u00103\u001A\u00020\u0001*\u00020\u00122\u0006\u00104\u001A\u00020\u00042\u0006\u00105\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\b2\u0006\u00106\u001A\u000207H\u0002¢\u0006\u0004\b8\u00109\u001A#\u0010:\u001A\u00020\u0001*\u00020\u00122\u0006\u0010\u0007\u001A\u00020\b2\u0006\u00106\u001A\u000207H\u0002¢\u0006\u0004\b;\u0010<\u001A3\u0010=\u001A\u00020\u0001*\u00020\u00122\u0006\u00104\u001A\u00020\u00042\u0006\u00105\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\b2\u0006\u00106\u001A\u000207H\u0002¢\u0006\u0004\b>\u00109\u001A;\u0010?\u001A\u00020\u0001*\u00020\u00122\u0006\u00104\u001A\u00020\u00042\u0006\u0010\"\u001A\u00020\u000F2\u0006\u00105\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\b2\u0006\u00106\u001A\u000207H\u0002¢\u0006\u0004\b@\u0010A\"\u001A\u0010B\u001A\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bD\u0010E\"\u001A\u0010F\u001A\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bG\u0010E\"\u001A\u0010H\u001A\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bI\u0010E\"\u001A\u0010J\u001A\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bK\u0010E\"\u001A\u0010L\u001A\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bM\u0010E\"\u001A\u0010N\u001A\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bO\u0010E\"\u001A\u0010P\u001A\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bQ\u0010E\"\u0016\u0010R\u001A\u00020\u000FX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001A\u0004\bS\u0010T\"\u0016\u0010V\u001A\u00020\u000FX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001A\u0004\bW\u0010T\"\u0016\u0010X\u001A\u00020\u000FX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001A\u0004\bY\u0010T\"\u0016\u0010Z\u001A\u00020\u000FX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001A\u0004\b[\u0010T\"\u000E\u0010\\\u001A\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010^\u001A\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010_\u001A\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010`\u001A\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010a\u001A\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010b\u001A\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010c\u001A\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010d\u001A\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010e\u001A\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010f\u001A\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bh\u0010i\"\u0014\u0010j\u001A\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bk\u0010i\"\u000E\u0010l\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010m\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010n\u001A\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010o\u001A\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010p\u001A\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010q\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010r\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006s"}, d2={"LinearProgressIndicator", "", "progress", "Lkotlin/Function0;", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "trackColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "LinearProgressIndicator-_5eSR-E", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "gapSize", "Landroidx/compose/ui/unit/Dp;", "drawStopIndicator", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "LinearProgressIndicator-GJbTh5U", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJIFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-rIrjwxo", "(Landroidx/compose/ui/Modifier;JJIFLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "drawLinearIndicator", "startFraction", "endFraction", "strokeWidth", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "CircularProgressIndicator", "CircularProgressIndicator-DUhRLBM", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-IyT6zlY", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJIFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-4lLiAd8", "(Landroidx/compose/ui/Modifier;JFJIFLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorTrack", "drawCircularIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "circularIndeterminateGlobalRotationAnimationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "getCircularIndeterminateGlobalRotationAnimationSpec", "()Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "circularIndeterminateRotationAnimationSpec", "getCircularIndeterminateRotationAnimationSpec", "circularIndeterminateProgressAnimationSpec", "getCircularIndeterminateProgressAnimationSpec", "linearIndeterminateFirstLineHeadAnimationSpec", "getLinearIndeterminateFirstLineHeadAnimationSpec", "linearIndeterminateFirstLineTailAnimationSpec", "getLinearIndeterminateFirstLineTailAnimationSpec", "linearIndeterminateSecondLineHeadAnimationSpec", "getLinearIndeterminateSecondLineHeadAnimationSpec", "linearIndeterminateSecondLineTailAnimationSpec", "getLinearIndeterminateSecondLineTailAnimationSpec", "LinearIndicatorWidth", "getLinearIndicatorWidth", "()F", "F", "LinearIndicatorHeight", "getLinearIndicatorHeight", "StopIndicatorTrailingSpace", "getStopIndicatorTrailingSpace", "CircularIndicatorDiameter", "getCircularIndicatorDiameter", "LinearAnimationDuration", "", "FirstLineHeadDuration", "FirstLineTailDuration", "SecondLineHeadDuration", "SecondLineTailDuration", "FirstLineHeadDelay", "FirstLineTailDelay", "SecondLineHeadDelay", "SecondLineTailDelay", "LinearIndeterminateProgressEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getLinearIndeterminateProgressEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "CircularProgressEasing", "getCircularProgressEasing", "CircularIndeterminateMinProgress", "CircularIndeterminateMaxProgress", "CircularAnimationProgressDuration", "CircularAnimationAdditionalRotationDelay", "CircularAnimationAdditionalRotationDuration", "CircularAdditionalRotationDegreesTarget", "CircularGlobalRotationDegreesTarget", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ProgressIndicatorKt {
    public static final float CircularAdditionalRotationDegreesTarget = 360f;
    public static final int CircularAnimationAdditionalRotationDelay = 1500;
    public static final int CircularAnimationAdditionalRotationDuration = 300;
    public static final int CircularAnimationProgressDuration = 6000;
    public static final float CircularGlobalRotationDegreesTarget = 1080f;
    public static final float CircularIndeterminateMaxProgress = 0.87f;
    public static final float CircularIndeterminateMinProgress = 0.1f;
    private static final float CircularIndicatorDiameter = 0f;
    private static final CubicBezierEasing CircularProgressEasing = null;
    public static final int FirstLineHeadDelay = 0;
    public static final int FirstLineHeadDuration = 1000;
    public static final int FirstLineTailDelay = 0xFA;
    public static final int FirstLineTailDuration = 1000;
    public static final int LinearAnimationDuration = 1750;
    private static final CubicBezierEasing LinearIndeterminateProgressEasing = null;
    private static final float LinearIndicatorHeight = 0f;
    private static final float LinearIndicatorWidth = 0f;
    public static final int SecondLineHeadDelay = 650;
    public static final int SecondLineHeadDuration = 850;
    public static final int SecondLineTailDelay = 900;
    public static final int SecondLineTailDuration = 850;
    private static final float StopIndicatorTrailingSpace;

    static {
        ProgressIndicatorKt.LinearIndicatorWidth = Dp.constructor-impl(240f);
        ProgressIndicatorKt.LinearIndicatorHeight = LinearProgressIndicatorTokens.INSTANCE.getHeight-D9Ej5fM();
        ProgressIndicatorKt.StopIndicatorTrailingSpace = Dp.constructor-impl(6f);
        ProgressIndicatorKt.CircularIndicatorDiameter = CircularProgressIndicatorTokens.INSTANCE.getSize-D9Ej5fM();
        ProgressIndicatorKt.LinearIndeterminateProgressEasing = MotionTokens.INSTANCE.getEasingEmphasizedAccelerateCubicBezier();
        ProgressIndicatorKt.CircularProgressEasing = MotionTokens.INSTANCE.getEasingStandardCubicBezier();
    }

    public static final void CircularProgressIndicator-4lLiAd8(Modifier arg32, long arg33, float arg35, long arg36, int arg38, float arg39, Composer arg40, int arg41, int arg42) {
        long v2_4;
        float v4_1;
        float v8;
        int v7_1;
        Composer v12_2;
        Modifier v1_2;
        float v24;
        long v30;
        long v27;
        long v5_1;
        int v22;
        float v23;
        Modifier v0_1;
        Companion v0_2;
        float v10;
        int v16;
        int v13;
        long v14;
        int v12;
        float v11;
        int v5;
        long v7;
        Modifier v3;
        int v4;
        int v9 = arg41;
        Composer v1 = arg40.startRestartGroup(0x13DB87C1);
        ComposerKt.sourceInformation(v1, "C(CircularProgressIndicator)N(modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap,gapSize:c#ui.unit.Dp)631@26690L7,633@26785L28,636@26938L195,644@27283L193,653@27649L216,659@27940L734,659@27871L803:ProgressIndicator.kt#uh7d8r");
        int v2 = arg42 & 1;
        if(v2 != 0) {
            v4 = v9 | 6;
            v3 = arg32;
        }
        else if((v9 & 6) == 0) {
            v3 = arg32;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v9;
        }
        else {
            v3 = arg32;
            v4 = v9;
        }

        if((v9 & 0x30) == 0) {
            v7 = arg33;
            v5 = (arg42 & 2) != 0 || !v1.changed(v7) ? 16 : 0x20;
            v4 |= v5;
        }
        else {
            v7 = arg33;
        }

        v5 = arg42 & 4;
        if(v5 != 0) {
            v4 |= 0x180;
            goto label_51;
        }
        else if((v9 & 0x180) == 0) {
            v11 = arg35;
            v12 = v1.changed(v11) ? 0x100 : 0x80;
            v4 |= v12;
        }
        else {
        label_51:
            v11 = arg35;
        }

        if((v9 & 0xC00) == 0) {
            v14 = arg36;
            v12 = (arg42 & 8) != 0 || !v1.changed(v14) ? 0x400 : 0x800;
            v4 |= v12;
        }
        else {
            v14 = arg36;
        }

        v12 = arg42 & 16;
        if(v12 != 0) {
            v4 |= 0x6000;
            goto label_79;
        }
        else if((v9 & 0x6000) == 0) {
            v13 = arg38;
            v16 = v1.changed(v13) ? 0x4000 : 0x2000;
            v4 |= v16;
        }
        else {
        label_79:
            v13 = arg38;
        }

        v16 = arg42 & 0x20;
        int v17 = 0x30000;
        if(v16 != 0) {
            v4 |= v17;
            v10 = arg39;
        }
        else {
            v10 = arg39;
            if((v9 & v17) == 0) {
                int v18 = v1.changed(v10) ? 0x20000 : 0x10000;
                v4 |= v18;
            }
        }

        int v19 = v2;
        boolean v0 = (v4 & 74899) != 74898 ? true : false;
        if(v1.shouldExecute(v0, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "625@26324L13,627@26458L31");
            if((v9 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v19 != 0) {
                    v0_2 = Modifier.Companion;
                }
                else {
                    v0_1 = v3;
                }

                int v6 = 6;
                if((arg42 & 2) != 0) {
                    v7 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(v1, v6);
                    v4 &= 0xFFFFFF8F;
                }

                if(v5 != 0) {
                    v11 = ProgressIndicatorDefaults.INSTANCE.getCircularStrokeWidth-D9Ej5fM();
                }

                if((arg42 & 8) != 0) {
                    v5_1 = ProgressIndicatorDefaults.INSTANCE.getCircularIndeterminateTrackColor(v1, v6);
                    v4 &= 0xFFFFE3FF;
                }
                else {
                    v5_1 = v14;
                }

                if(v12 != 0) {
                    v13 = ProgressIndicatorDefaults.INSTANCE.getCircularIndeterminateStrokeCap-KaPHkGw();
                }

                v23 = v16 != 0 ? ProgressIndicatorDefaults.INSTANCE.getCircularIndicatorTrackGapSize-D9Ej5fM() : v10;
                v22 = v13;
            }
            else {
                v1.skipToGroupEnd();
                if((arg42 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }

                if((arg42 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                v0_1 = v3;
                v23 = v10;
                v22 = v13;
                v5_1 = v14;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x13DB87C1, v4, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:630)");
            }

            ProvidableCompositionLocal v3_1 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v3_2 = v1.consume(((CompositionLocal)v3_1));
            ComposerKt.sourceInformationMarkerEnd(v1);
            Stroke v3_3 = new Stroke(((Density)v3_2).toPx-0680j_4(v11), 0f, v22, 0, null, 26, null);
            Composer v37 = v1;
            InfiniteTransition v32 = InfiniteTransitionKt.rememberInfiniteTransition(null, v1, 0, 1);
            State v1_1 = InfiniteTransitionKt.animateFloat(v32, 0f, 1080f, ProgressIndicatorKt.getCircularIndeterminateGlobalRotationAnimationSpec(), null, v37, InfiniteTransition.$stable | 0x1B0 | InfiniteRepeatableSpec.$stable << 9, 8);
            State v10_1 = InfiniteTransitionKt.animateFloat(v32, 0f, 360f, ProgressIndicatorKt.getCircularIndeterminateRotationAnimationSpec(), null, v37, InfiniteTransition.$stable | 0x1B0 | InfiniteRepeatableSpec.$stable << 9, 8);
            State v12_1 = InfiniteTransitionKt.animateFloat(v32, 0.1f, 0.87f, ProgressIndicatorKt.getCircularIndeterminateProgressAnimationSpec(), null, v37, InfiniteTransition.$stable | 0x1B0 | InfiniteRepeatableSpec.$stable << 9, 8);
            Composer v13_1 = v37;
            Modifier v14_1 = SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics(((Modifier)v0_2)), ProgressIndicatorKt.CircularIndicatorDiameter);
            ComposerKt.sourceInformationMarkerStart(v13_1, 0x8B197CBF, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean v2_1 = v13_1.changed(v12_1);
            arg32 = ((Modifier)v0_2);
            int v0_3 = (0xE000 & v4) == 0x4000 ? 1 : 0;
            v0_3 |= ((int)v2_1);
            v2 = (0x70000 & v4) == 0x20000 ? 1 : 0;
            v0_3 |= v2;
            v2 = (v4 & 0x380) == 0x100 ? 1 : 0;
            v0_3 = v0_3 | v2 | v13_1.changed(v1_1) | v13_1.changed(v10_1);
            int v15 = 0x800;
            v2 = (v4 & 0x1C00 ^ 0xC00) > v15 && (v13_1.changed(v5_1)) || (v4 & 0xC00) == v15 ? 1 : 0;
            v0_3 = v0_3 | v2 | v13_1.changedInstance(v3_3);
            v15 = 0x20;
            v2 = (v4 & 0x70 ^ 0x30) > v15 && (v13_1.changed(v7)) || (v4 & 0x30) == v15 ? 1 : 0;
            v0_3 |= v2;
            Object v2_2 = v13_1.rememberedValue();
            if(v0_3 != 0 || v2_2 == Composer.Companion.getEmpty()) {
                v27 = v5_1;
                v30 = v7;
                v24 = v11;
                ProgressIndicatorKt$$ExternalSyntheticLambda28 v2_3 = new ProgressIndicatorKt$$ExternalSyntheticLambda28(v12_1, v22, v23, v24, v1_1, v10_1, v27, v3_3, v30);
                v13_1.updateRememberedValue(v2_3);
            }
            else {
                v27 = v5_1;
                v30 = v7;
                v24 = v11;
            }

            ComposerKt.sourceInformationMarkerEnd(v13_1);
            CanvasKt.Canvas(v14_1, ((Function1)v2_2), v13_1, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_2 = arg32;
            v12_2 = v13_1;
            v7_1 = v22;
            v8 = v23;
            v4_1 = v24;
            v5_1 = v27;
            v2_4 = v30;
        }
        else {
            v12_2 = v1;
            v12_2.skipToGroupEnd();
            v1_2 = v3;
            v2_4 = v7;
            v8 = v10;
            v4_1 = v11;
            v7_1 = v13;
            v5_1 = v14;
        }

        ScopeUpdateScope v11_1 = v12_2.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new ProgressIndicatorKt$$ExternalSyntheticLambda29(v1_2, v2_4, v4_1, v5_1, v7_1, v8, v9, arg42));
        }
    }

    @Deprecated(message="Use the overload that takes `progress` as a lambda", replaceWith="<_subannotation>") public static final void CircularProgressIndicator-DUhRLBM(float arg22, Modifier arg23, long arg24, float arg26, long arg27, int arg29, Composer arg30, int arg31, int arg32) {
        int v8;
        long v6_2;
        float v5_1;
        long v3_1;
        Modifier v2_1;
        Composer v19;
        Modifier v11_1;
        long v15_1;
        float v14_1;
        int v0_1;
        int v17;
        Companion v6_1;
        int v14;
        long v12_1;
        float v11;
        int v10;
        long v7_1;
        Modifier v6;
        int v3;
        float v1 = arg22;
        int v9 = arg31;
        Composer v2 = arg30.startRestartGroup(0xA83E2731);
        ComposerKt.sourceInformation(v2, "C(CircularProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)706@29604L12,705@29558L216:ProgressIndicator.kt#uh7d8r");
        if((arg32 & 1) != 0) {
            v3 = v9 | 6;
        }
        else if((v9 & 6) == 0) {
            v3 = v2.changed(v1) ? 4 : 2;
            v3 |= v9;
        }
        else {
            v3 = v9;
        }

        int v5 = arg32 & 2;
        if(v5 != 0) {
            v3 |= 0x30;
            goto label_35;
        }
        else if((v9 & 0x30) == 0) {
            v6 = arg23;
            int v7 = v2.changed(v6) ? 0x20 : 16;
            v3 |= v7;
        }
        else {
        label_35:
            v6 = arg23;
        }

        if((v9 & 0x180) == 0) {
            if((arg32 & 4) == 0) {
                v7_1 = arg24;
                if(v2.changed(v7_1)) {
                    v10 = 0x100;
                }
                else {
                    goto label_46;
                }
            }
            else {
                v7_1 = arg24;
            label_46:
                v10 = 0x80;
            }

            v3 |= v10;
        }
        else {
            v7_1 = arg24;
        }

        v10 = arg32 & 8;
        if(v10 != 0) {
            v3 |= 0xC00;
            goto label_64;
        }
        else if((v9 & 0xC00) == 0) {
            v11 = arg26;
            int v12 = v2.changed(v11) ? 0x800 : 0x400;
            v3 |= v12;
        }
        else {
        label_64:
            v11 = arg26;
        }

        if((v9 & 0x6000) == 0) {
            if((arg32 & 16) == 0) {
                v12_1 = arg27;
                if(v2.changed(v12_1)) {
                    v14 = 0x4000;
                }
                else {
                    goto label_75;
                }
            }
            else {
                v12_1 = arg27;
            label_75:
                v14 = 0x2000;
            }

            v3 |= v14;
        }
        else {
            v12_1 = arg27;
        }

        v14 = arg32 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v3 |= v15;
            goto label_94;
        }
        else if((v15 & v9) == 0) {
            v15 = arg29;
            int v16 = v2.changed(v15) ? 0x20000 : 0x10000;
            v3 |= v16;
        }
        else {
        label_94:
            v15 = arg29;
        }

        boolean v0 = (v3 & 74899) != 74898 ? true : false;
        if(v2.shouldExecute(v0, v3 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "700@29313L13,702@29447L18");
            int v4 = 0xFFFF1FFF;
            if((v9 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v5 != 0) {
                    v6_1 = Modifier.Companion;
                }

                v5 = 6;
                if((arg32 & 4) != 0) {
                    v7_1 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(v2, v5);
                    v3 &= -897;
                }

                if(v10 != 0) {
                    v11 = ProgressIndicatorDefaults.INSTANCE.getCircularStrokeWidth-D9Ej5fM();
                }

                if((arg32 & 16) != 0) {
                    v12_1 = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(v2, v5);
                    v3 &= v4;
                }

                if(v14 != 0) {
                    v17 = ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateStrokeCap-KaPHkGw();
                    v0_1 = 0;
                    v14_1 = v11;
                    v15_1 = v12_1;
                    v4 = 0xA83E2731;
                    v11_1 = ((Modifier)v6_1);
                    goto label_129;
                }

            label_123:
                v14_1 = v11;
                v0_1 = 0;
                v4 = 0xA83E2731;
                v11_1 = ((Modifier)v6_1);
                v17 = v15;
                v15_1 = v12_1;
            }
            else {
                v2.skipToGroupEnd();
                if((arg32 & 4) != 0) {
                    v3 &= -897;
                }

                if((arg32 & 16) == 0) {
                    goto label_123;
                }

                v3 &= v4;
                goto label_123;
            }

        label_129:
            v12_1 = v7_1;
            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v4, v3, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:705)");
            }

            ComposerKt.sourceInformationMarkerStart(v2, 0x915192BD, "CC(remember):ProgressIndicator.kt#9igjgp");
            if((v3 & 14) == 4) {
                v0_1 = 1;
            }

            Object v4_1 = v2.rememberedValue();
            if(v0_1 != 0 || v4_1 == Composer.Companion.getEmpty()) {
                ProgressIndicatorKt$$ExternalSyntheticLambda21 v4_2 = new ProgressIndicatorKt$$ExternalSyntheticLambda21(v1);
                v2.updateRememberedValue(v4_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            v19 = v2;
            ProgressIndicatorKt.CircularProgressIndicator-IyT6zlY(v4_1, v11_1, v12_1, v14_1, v15_1, v17, 0f, v19, v3 & 0x7FFF0, 0x40);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v11_1;
            v3_1 = v12_1;
            v5_1 = v14_1;
            v6_2 = v15_1;
            v8 = v17;
        }
        else {
            v19 = v2;
            v19.skipToGroupEnd();
            v2_1 = v6;
            v3_1 = v7_1;
            v5_1 = v11;
            v6_2 = v12_1;
            v8 = v15;
        }

        ScopeUpdateScope v11_2 = v19.endRestartGroup();
        if(v11_2 != null) {
            v11_2.updateScope(new ProgressIndicatorKt$$ExternalSyntheticLambda23(v1, v2_1, v3_1, v5_1, v6_2, v8, v9, arg32));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the overload that takes `gapSize`, see `LegacyCircularProgressIndicatorSample` on how to restore the previous behavior", replaceWith="<_subannotation>") public static final void CircularProgressIndicator-DUhRLBM(Function0 arg22, Modifier arg23, long arg24, float arg26, long arg27, int arg29, Composer arg30, int arg31, int arg32) {
        int v8_1;
        long v6;
        float v5_2;
        long v3_1;
        Modifier v2_1;
        Composer v19;
        float v14_1;
        long v12;
        int v0_1;
        int v17;
        long v15_1;
        Companion v11_3;
        Companion v0_2;
        int v15;
        int v13;
        long v11_1;
        float v8;
        int v7;
        long v5_1;
        Modifier v4;
        Function0 v10;
        int v2;
        int v9 = arg31;
        Composer v1 = arg30.startRestartGroup(-761680467);
        ComposerKt.sourceInformation(v1, "C(CircularProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)481@19831L218:ProgressIndicator.kt#uh7d8r");
        if((arg32 & 1) != 0) {
            v2 = v9 | 6;
            v10 = arg22;
        }
        else {
            v10 = arg22;
            if((v9 & 6) == 0) {
                v2 = v1.changedInstance(v10) ? 4 : 2;
                v2 |= v9;
            }
            else {
                v2 = v9;
            }
        }

        int v3 = arg32 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_36;
        }
        else if((v9 & 0x30) == 0) {
            v4 = arg23;
            int v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_36:
            v4 = arg23;
        }

        if((v9 & 0x180) == 0) {
            if((arg32 & 4) == 0) {
                v5_1 = arg24;
                if(v1.changed(v5_1)) {
                    v7 = 0x100;
                }
                else {
                    goto label_47;
                }
            }
            else {
                v5_1 = arg24;
            label_47:
                v7 = 0x80;
            }

            v2 |= v7;
        }
        else {
            v5_1 = arg24;
        }

        v7 = arg32 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_65;
        }
        else if((v9 & 0xC00) == 0) {
            v8 = arg26;
            int v11 = v1.changed(v8) ? 0x800 : 0x400;
            v2 |= v11;
        }
        else {
        label_65:
            v8 = arg26;
        }

        if((v9 & 0x6000) == 0) {
            if((arg32 & 16) == 0) {
                v11_1 = arg27;
                if(v1.changed(v11_1)) {
                    v13 = 0x4000;
                }
                else {
                    goto label_76;
                }
            }
            else {
                v11_1 = arg27;
            label_76:
                v13 = 0x2000;
            }

            v2 |= v13;
        }
        else {
            v11_1 = arg27;
        }

        v13 = arg32 & 0x20;
        int v14 = 0x30000;
        if(v13 != 0) {
            v2 |= v14;
            goto label_95;
        }
        else if((v14 & v9) == 0) {
            v14 = arg29;
            v15 = v1.changed(v14) ? 0x20000 : 0x10000;
            v2 |= v15;
        }
        else {
        label_95:
            v14 = arg29;
        }

        boolean v0 = (74899 & v2) != 74898 ? true : false;
        if(v1.shouldExecute(v0, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "476@19575L13,478@19709L29");
            v15 = 0xFFFF1FFF;
            if((v9 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    v0_2 = Modifier.Companion;
                }
                else {
                    Modifier v0_3 = v4;
                }

                int v4_1 = 6;
                if((arg32 & 4) != 0) {
                    v5_1 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(v1, v4_1);
                    v2 &= -897;
                }

                if(v7 != 0) {
                    v8 = ProgressIndicatorDefaults.INSTANCE.getCircularStrokeWidth-D9Ej5fM();
                }

                if((arg32 & 16) != 0) {
                    v2 &= v15;
                    v11_1 = ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateTrackColor(v1, v4_1);
                }

                if(v13 != 0) {
                    v17 = ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateStrokeCap-KaPHkGw();
                    v14_1 = v8;
                    v15_1 = v11_1;
                    v11_3 = v0_2;
                    v12 = v5_1;
                }
                else {
                    v15_1 = v11_1;
                    v17 = v14;
                    v11_3 = v0_2;
                    v12 = v5_1;
                    v14_1 = v8;
                }

                v0_1 = -761680467;
            }
            else {
                v1.skipToGroupEnd();
                if((arg32 & 4) != 0) {
                    v2 &= -897;
                }

                if((arg32 & 16) != 0) {
                    v2 &= v15;
                }

                v15_1 = v11_1;
                v17 = v14;
                v0_1 = -761680467;
                Modifier v11_2 = v4;
                v12 = v5_1;
                v14_1 = v8;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_1, v2, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:480)");
            }

            v19 = v1;
            ProgressIndicatorKt.CircularProgressIndicator-IyT6zlY(v10, ((Modifier)v11_3), v12, v14_1, v15_1, v17, ProgressIndicatorDefaults.INSTANCE.getCircularIndicatorTrackGapSize-D9Ej5fM(), v19, v2 & 14 | 0x180000 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00 | 0xE000 & v2 | v2 & 0x70000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v11_3);
            v3_1 = v12;
            v5_2 = v14_1;
            v6 = v15_1;
            v8_1 = v17;
        }
        else {
            v19 = v1;
            v19.skipToGroupEnd();
            v2_1 = v4;
            v3_1 = v5_1;
            v5_2 = v8;
            v6 = v11_1;
            v8_1 = v14;
        }

        ScopeUpdateScope v11_4 = v19.endRestartGroup();
        if(v11_4 != null) {
            v11_4.updateScope(new ProgressIndicatorKt$$ExternalSyntheticLambda11(arg22, v2_1, v3_1, v5_2, v6, v8_1, v9, arg32));
        }
    }

    public static final void CircularProgressIndicator-IyT6zlY(Function0 arg32, Modifier arg33, long arg34, float arg36, long arg37, int arg39, float arg40, Composer arg41, int arg42, int arg43) {
        long v3_1;
        float v5_1;
        float v26;
        long v30;
        long v27;
        ProgressIndicatorKt$$ExternalSyntheticLambda25 v15_2;
        ProgressIndicatorKt$$ExternalSyntheticLambda24 v9_1;
        int v24;
        long v7_1;
        float v25;
        float v14_1;
        int v18;
        int v15;
        int v16;
        long v8;
        float v13;
        long v11;
        int v7;
        Modifier v6;
        int v3;
        Function0 v1 = arg32;
        int v10 = arg42;
        Composer v2 = arg41.startRestartGroup(0x94C736F5);
        ComposerKt.sourceInformation(v2, "C(CircularProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap,gapSize:c#ui.unit.Dp)527@22030L35,528@22101L7,531@22243L241,537@22536L693,529@22170L1059:ProgressIndicator.kt#uh7d8r");
        if((arg43 & 1) != 0) {
            v3 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v3 = v2.changedInstance(v1) ? 4 : 2;
            v3 |= v10;
        }
        else {
            v3 = v10;
        }

        int v5 = arg43 & 2;
        if(v5 != 0) {
            v3 |= 0x30;
            goto label_35;
        }
        else if((v10 & 0x30) == 0) {
            v6 = arg33;
            v7 = v2.changed(v6) ? 0x20 : 16;
            v3 |= v7;
        }
        else {
        label_35:
            v6 = arg33;
        }

        if((v10 & 0x180) == 0) {
            v11 = arg34;
            v7 = (arg43 & 4) != 0 || !v2.changed(v11) ? 0x80 : 0x100;
            v3 |= v7;
        }
        else {
            v11 = arg34;
        }

        v7 = arg43 & 8;
        if(v7 != 0) {
            v3 |= 0xC00;
            goto label_63;
        }
        else if((v10 & 0xC00) == 0) {
            v13 = arg36;
            int v14 = v2.changed(v13) ? 0x800 : 0x400;
            v3 |= v14;
        }
        else {
        label_63:
            v13 = arg36;
        }

        if((v10 & 0x6000) == 0) {
            v8 = arg37;
            v16 = (arg43 & 16) != 0 || !v2.changed(v8) ? 0x2000 : 0x4000;
            v3 |= v16;
        }
        else {
            v8 = arg37;
        }

        v16 = arg43 & 0x20;
        int v17 = 0x30000;
        if(v16 != 0) {
            v3 |= v17;
            v15 = arg39;
        }
        else {
            v15 = arg39;
            if((v10 & v17) == 0) {
                v18 = v2.changed(v15) ? 0x20000 : 0x10000;
                v3 |= v18;
            }
        }

        v18 = arg43 & 0x40;
        int v19 = 0x180000;
        if(v18 != 0) {
            v3 |= v19;
            v14_1 = arg40;
        }
        else {
            v14_1 = arg40;
            if((v10 & v19) == 0) {
                int v20 = v2.changed(v14_1) ? 0x100000 : 0x80000;
                v3 |= v20;
            }
        }

        int v21 = v5;
        boolean v0 = (v3 & 0x92493) != 0x92492 ? true : false;
        if(v2.shouldExecute(v0, v3 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "521@21677L13,523@21811L29");
            int v4 = 0xFFFF1FFF;
            if((v10 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v21 != 0) {
                    Companion v6_1 = Modifier.Companion;
                }

                v21 = v4;
                v4 = 6;
                if((arg43 & 4) != 0) {
                    v11 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(v2, v4);
                    v3 &= -897;
                }

                if(v7 != 0) {
                    v13 = ProgressIndicatorDefaults.INSTANCE.getCircularStrokeWidth-D9Ej5fM();
                }

                if((arg43 & 16) != 0) {
                    v7_1 = ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateTrackColor(v2, v4);
                    v3 &= v21;
                }
                else {
                    v7_1 = v8;
                }

                if(v16 != 0) {
                    v15 = ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateStrokeCap-KaPHkGw();
                }

                if(v18 != 0) {
                    v25 = ProgressIndicatorDefaults.INSTANCE.getCircularIndicatorTrackGapSize-D9Ej5fM();
                    goto label_137;
                }

            label_136:
                v25 = v14_1;
            }
            else {
                v2.skipToGroupEnd();
                if((arg43 & 4) != 0) {
                    v3 &= -897;
                }

                if((arg43 & 16) != 0) {
                    v3 &= v4;
                }

                v7_1 = v8;
                goto label_136;
            }

        label_137:
            v24 = v15;
            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x94C736F5, v3, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:526)");
            }

            String v4_1 = "CC(remember):ProgressIndicator.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v2, 0x7FD591B8, v4_1);
            int v0_1 = (v3 & 14) == 4 ? 1 : 0;
            Object v9 = v2.rememberedValue();
            if(v0_1 != 0 || v9 == Composer.Companion.getEmpty()) {
                v9_1 = new ProgressIndicatorKt$$ExternalSyntheticLambda24(v1);
                v2.updateRememberedValue(v9_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            ProvidableCompositionLocal v0_2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_3 = v2.consume(((CompositionLocal)v0_2));
            ComposerKt.sourceInformationMarkerEnd(v2);
            Stroke v0_4 = new Stroke(((Density)v0_3).toPx-0680j_4(v13), 0f, v24, 0, null, 26, null);
            ComposerKt.sourceInformationMarkerStart(v2, 0x7FD5AD26, v4_1);
            boolean v14_2 = v2.changed(v9_1);
            Object v15_1 = v2.rememberedValue();
            if((v14_2) || v15_1 == Composer.Companion.getEmpty()) {
                v15_2 = new ProgressIndicatorKt$$ExternalSyntheticLambda25(((Function0)v9_1));
                v2.updateRememberedValue(v15_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            Modifier v14_3 = SizeKt.size-3ABfNKs(SemanticsModifierKt.semantics(v6, true, ((Function1)v15_2)), ProgressIndicatorKt.CircularIndicatorDiameter);
            ComposerKt.sourceInformationMarkerStart(v2, 0x7FD5D38A, v4_1);
            boolean v4_2 = v2.changed(v9_1);
            v5 = (0x70000 & v3) == 0x20000 ? 1 : 0;
            v4 = (((int)v4_2)) | v5;
            v5 = (0x380000 & v3) == 0x100000 ? 1 : 0;
            v4 |= v5;
            v5 = (v3 & 0x1C00) == 0x800 ? 1 : 0;
            v4 |= v5;
            v15 = 0x4000;
            v5 = (0xE000 & v3 ^ 0x6000) > v15 && (v2.changed(v7_1)) || (v3 & 0x6000) == v15 ? 1 : 0;
            v4 = v4 | v5 | v2.changedInstance(v0_4);
            v15 = 0x100;
            v5 = (v3 & 0x380 ^ 0x180) > v15 && (v2.changed(v11)) || (v3 & 0x180) == v15 ? 1 : 0;
            v3 = v4 | v5;
            Object v4_3 = v2.rememberedValue();
            if(v3 != 0 || v4_3 == Composer.Companion.getEmpty()) {
                v27 = v7_1;
                v30 = v11;
                v26 = v13;
                ProgressIndicatorKt$$ExternalSyntheticLambda26 v4_4 = new ProgressIndicatorKt$$ExternalSyntheticLambda26(v9_1, v24, v25, v26, v27, v0_4, v30);
                v2.updateRememberedValue(v4_4);
            }
            else {
                v27 = v7_1;
                v30 = v11;
                v26 = v13;
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            CanvasKt.Canvas(v14_3, ((Function1)v4_3), v2, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_1 = v26;
            v8 = v27;
            v3_1 = v30;
        }
        else {
            v2.skipToGroupEnd();
            v3_1 = v11;
            v5_1 = v13;
            v25 = v14_1;
            v24 = v15;
        }

        ScopeUpdateScope v12 = v2.endRestartGroup();
        if(v12 != null) {
            v12.updateScope(new ProgressIndicatorKt$$ExternalSyntheticLambda27(v1, v6, v3_1, v5_1, v8, v24, v25, v10, arg43));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the overload that takes `gapSize`", replaceWith="<_subannotation>") public static final void CircularProgressIndicator-LxG7B9w(Modifier arg20, long arg21, float arg23, long arg24, int arg26, Composer arg27, int arg28, int arg29) {
        float v4_1;
        long v2_3;
        Modifier v1_1;
        Composer v17;
        int v15;
        float v12_1;
        Companion v9_2;
        long v13_1;
        Modifier v2_2;
        int v14;
        int v13;
        int v12;
        long v10_1;
        float v9;
        int v7;
        long v5;
        Modifier v3;
        int v4;
        int v8 = arg28;
        int v0 = 0xF917F061;
        Composer v1 = arg27.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(CircularProgressIndicator)N(modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)594@24879L258:ProgressIndicator.kt#uh7d8r");
        int v2 = arg29 & 1;
        if(v2 != 0) {
            v4 = v8 | 6;
            v3 = arg20;
        }
        else if((v8 & 6) == 0) {
            v3 = arg20;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v8;
        }
        else {
            v3 = arg20;
            v4 = v8;
        }

        if((v8 & 0x30) == 0) {
            if((arg29 & 2) == 0) {
                v5 = arg21;
                if(v1.changed(v5)) {
                    v7 = 0x20;
                }
                else {
                    goto label_34;
                }
            }
            else {
                v5 = arg21;
            label_34:
                v7 = 16;
            }

            v4 |= v7;
        }
        else {
            v5 = arg21;
        }

        v7 = arg29 & 4;
        if(v7 != 0) {
            v4 |= 0x180;
            goto label_52;
        }
        else if((v8 & 0x180) == 0) {
            v9 = arg23;
            int v10 = v1.changed(v9) ? 0x100 : 0x80;
            v4 |= v10;
        }
        else {
        label_52:
            v9 = arg23;
        }

        if((v8 & 0xC00) == 0) {
            if((arg29 & 8) == 0) {
                v10_1 = arg24;
                if(v1.changed(v10_1)) {
                    v12 = 0x800;
                }
                else {
                    goto label_63;
                }
            }
            else {
                v10_1 = arg24;
            label_63:
                v12 = 0x400;
            }

            v4 |= v12;
        }
        else {
            v10_1 = arg24;
        }

        v12 = arg29 & 16;
        if(v12 != 0) {
            v4 |= 0x6000;
            goto label_81;
        }
        else if((v8 & 0x6000) == 0) {
            v13 = arg26;
            v14 = v1.changed(v13) ? 0x4000 : 0x2000;
            v4 |= v14;
        }
        else {
        label_81:
            v13 = arg26;
        }

        boolean v14_1 = (v4 & 9363) != 9362 ? true : false;
        if(v1.shouldExecute(v14_1, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "589@24619L13,591@24753L31");
            if((v8 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v2 != 0) {
                    Companion v2_1 = Modifier.Companion;
                }
                else {
                    v2_2 = v3;
                }

                v14 = 6;
                if((arg29 & 2) != 0) {
                    v5 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(v1, v14);
                    v4 &= 0xFFFFFF8F;
                }

                if(v7 != 0) {
                    v9 = ProgressIndicatorDefaults.INSTANCE.getCircularStrokeWidth-D9Ej5fM();
                }

                if((arg29 & 8) != 0) {
                    v10_1 = ProgressIndicatorDefaults.INSTANCE.getCircularIndeterminateTrackColor(v1, v14);
                    v4 &= 0xFFFFE3FF;
                }

                if(v12 != 0) {
                    v15 = ProgressIndicatorDefaults.INSTANCE.getCircularIndeterminateStrokeCap-KaPHkGw();
                    v12_1 = v9;
                    v13_1 = v10_1;
                    v9_2 = ((Companion)v2_2);
                    goto label_110;
                }

                v12_1 = v9;
                v15 = v13;
                v9_2 = ((Companion)v2_2);
            label_109:
                v13_1 = v10_1;
            }
            else {
                v1.skipToGroupEnd();
                if((arg29 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }

                if((arg29 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                v12_1 = v9;
                v15 = v13;
                Modifier v9_1 = v3;
                goto label_109;
            }

        label_110:
            v10_1 = v5;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:594)");
            }

            v17 = v1;
            ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(((Modifier)v9_2), v10_1, v12_1, v13_1, v15, ProgressIndicatorDefaults.INSTANCE.getCircularIndicatorTrackGapSize-D9Ej5fM(), v17, v4 & 14 | 0x30000 | v4 & 0x70 | v4 & 0x380 | v4 & 0x1C00 | 0xE000 & v4, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_1 = ((Modifier)v9_2);
            v2_3 = v10_1;
            v4_1 = v12_1;
            v5 = v13_1;
            v7 = v15;
        }
        else {
            v17 = v1;
            v17.skipToGroupEnd();
            v1_1 = v3;
            v2_3 = v5;
            v4_1 = v9;
            v5 = v10_1;
            v7 = v13;
        }

        ScopeUpdateScope v10_2 = v17.endRestartGroup();
        if(v10_2 != null) {
            v10_2.updateScope(new ProgressIndicatorKt$$ExternalSyntheticLambda30(v1_1, v2_3, v4_1, v5, v7, v8, arg29));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public static final void CircularProgressIndicator-MBs18nI(float arg20, Modifier arg21, long arg22, float arg24, Composer arg25, int arg26, int arg27) {
        float v5_1;
        long v3_3;
        Modifier v2_1;
        long v9_1;
        float v4_1;
        Companion v8_1;
        Companion v3_1;
        float v9;
        long v7;
        int v5;
        Modifier v4;
        float v1;
        int v2;
        int v6 = arg26;
        int v0 = 0x1802DE6C;
        Composer v15 = arg25.startRestartGroup(v0);
        ComposerKt.sourceInformation(v15, "C(CircularProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp)728@30267L18,723@30121L247:ProgressIndicator.kt#uh7d8r");
        if((arg27 & 1) != 0) {
            v2 = v6 | 6;
            v1 = arg20;
        }
        else if((v6 & 6) == 0) {
            v1 = arg20;
            v2 = v15.changed(v1) ? 4 : 2;
            v2 |= v6;
        }
        else {
            v1 = arg20;
            v2 = v6;
        }

        int v3 = arg27 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_38;
        }
        else if((v6 & 0x30) == 0) {
            v4 = arg21;
            v5 = v15.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_38:
            v4 = arg21;
        }

        if((v6 & 0x180) == 0) {
            v7 = arg22;
            v5 = (arg27 & 4) != 0 || !v15.changed(v7) ? 0x80 : 0x100;
            v2 |= v5;
        }
        else {
            v7 = arg22;
        }

        v5 = arg27 & 8;
        if(v5 != 0) {
            v2 |= 0xC00;
            goto label_66;
        }
        else if((v6 & 0xC00) == 0) {
            v9 = arg24;
            int v10 = v15.changed(v9) ? 0x800 : 0x400;
            v2 |= v10;
        }
        else {
        label_66:
            v9 = arg24;
        }

        boolean v10_1 = (v2 & 0x493) != 1170 ? true : false;
        if(v15.shouldExecute(v10_1, v2 & 1)) {
            v15.startDefaults();
            ComposerKt.sourceInformation(v15, "720@30029L13");
            int v11 = 6;
            if((v6 & 1) == 0 || (v15.getDefaultsInvalid())) {
                if(v3 != 0) {
                    v3_1 = Modifier.Companion;
                }
                else {
                    Modifier v3_2 = v4;
                }

                if((arg27 & 4) != 0) {
                    v7 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(v15, v11);
                    v2 &= -897;
                }

                v4_1 = v5 != 0 ? ProgressIndicatorDefaults.INSTANCE.getCircularStrokeWidth-D9Ej5fM() : v9;
                v9_1 = v7;
                v8_1 = v3_1;
            }
            else {
                v15.skipToGroupEnd();
                if((arg27 & 4) != 0) {
                    v2 &= -897;
                }

                long v18 = v7;
                Modifier v8 = v4;
                v4_1 = v9;
                v9_1 = v18;
            }

            v15.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:723)");
            }

            long v12 = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(v15, v11);
            float v11_1 = v4_1;
            ProgressIndicatorKt.CircularProgressIndicator-DUhRLBM(v1, ((Modifier)v8_1), v9_1, v11_1, v12, ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateStrokeCap-KaPHkGw(), v15, v2 & 14 | 0x30000 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v8_1);
            v3_3 = v9_1;
            v5_1 = v11_1;
        }
        else {
            v15.skipToGroupEnd();
            v2_1 = v4;
            v3_3 = v7;
            v5_1 = v9;
        }

        ScopeUpdateScope v8_2 = v15.endRestartGroup();
        if(v8_2 != null) {
            v8_2.updateScope(new ProgressIndicatorKt$$ExternalSyntheticLambda14(arg20, v2_1, v3_3, v5_1, v6, arg27));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public static final void CircularProgressIndicator-aM-cp0Q(Modifier arg17, long arg18, float arg20, Composer arg21, int arg22, int arg23) {
        float v4_1;
        long v2_1;
        Modifier v6_1;
        long v7;
        float v9_2;
        Modifier v1_2;
        float v8;
        int v4;
        long v6;
        Modifier v2;
        int v3;
        int v5 = arg22;
        int v0 = 0x3875079C;
        Composer v14 = arg21.startRestartGroup(v0);
        ComposerKt.sourceInformation(v14, "C(CircularProgressIndicator)N(modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp)744@30822L18,740@30694L231:ProgressIndicator.kt#uh7d8r");
        int v1 = arg23 & 1;
        if(v1 != 0) {
            v3 = v5 | 6;
            v2 = arg17;
        }
        else if((v5 & 6) == 0) {
            v2 = arg17;
            v3 = v14.changed(v2) ? 4 : 2;
            v3 |= v5;
        }
        else {
            v2 = arg17;
            v3 = v5;
        }

        if((v5 & 0x30) == 0) {
            v6 = arg18;
            v4 = (arg23 & 2) != 0 || !v14.changed(v6) ? 16 : 0x20;
            v3 |= v4;
        }
        else {
            v6 = arg18;
        }

        v4 = arg23 & 4;
        if(v4 != 0) {
            v3 |= 0x180;
            goto label_51;
        }
        else if((v5 & 0x180) == 0) {
            v8 = arg20;
            int v9 = v14.changed(v8) ? 0x100 : 0x80;
            v3 |= v9;
        }
        else {
        label_51:
            v8 = arg20;
        }

        boolean v9_1 = (v3 & 0x93) != 0x92 ? true : false;
        if(v14.shouldExecute(v9_1, v3 & 1)) {
            v14.startDefaults();
            ComposerKt.sourceInformation(v14, "737@30602L13");
            int v10 = 6;
            if((v5 & 1) == 0 || (v14.getDefaultsInvalid())) {
                if(v1 != 0) {
                    Companion v1_1 = Modifier.Companion;
                }
                else {
                    v1_2 = v2;
                }

                if((arg23 & 2) != 0) {
                    v6 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(v14, v10);
                    v3 &= 0xFFFFFF8F;
                }

                v9_2 = v4 != 0 ? ProgressIndicatorDefaults.INSTANCE.getCircularStrokeWidth-D9Ej5fM() : v8;
                v7 = v6;
                Companion v6_2 = ((Companion)v1_2);
            }
            else {
                v14.skipToGroupEnd();
                if((arg23 & 2) != 0) {
                    v3 &= 0xFFFFFF8F;
                }

                v9_2 = v8;
                v7 = v6;
                v6_1 = v2;
            }

            v14.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:740)");
            }

            ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(v6_1, v7, v9_2, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(v14, v10), ProgressIndicatorDefaults.INSTANCE.getCircularIndeterminateStrokeCap-KaPHkGw(), 0f, v14, v3 & 14 | 0x6000 | v3 & 0x70 | v3 & 0x380, 0x20);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_2 = v6_1;
            v2_1 = v7;
            v4_1 = v9_2;
        }
        else {
            v14.skipToGroupEnd();
            v1_2 = v2;
            v2_1 = v6;
            v4_1 = v8;
        }

        ScopeUpdateScope v7_1 = v14.endRestartGroup();
        if(v7_1 != null) {
            v7_1.updateScope(new ProgressIndicatorKt$$ExternalSyntheticLambda20(v1_2, v2_1, v4_1, v5, arg23));
        }
    }

    static final Unit CircularProgressIndicator_4lLiAd8$lambda$34$lambda$33(State arg10, int arg11, float arg12, float arg13, State arg14, State arg15, long arg16, Stroke arg18, long arg19, DrawScope arg21) {
        float v0 = 360f;
        float v10 = arg10.getValue().floatValue() * v0;
        int v1 = 0x20;
        if(!StrokeCap.equals-impl0(arg11, StrokeCap.Companion.getButt-KaPHkGw())) {
            if(Float.intBitsToFloat(((int)(arg21.getSize-NH-jbRc() & 0xFFFFFFFFL))) > Float.intBitsToFloat(((int)(arg21.getSize-NH-jbRc() >> v1)))) {
            }
            else {
                arg12 = Dp.constructor-impl(arg12 + arg13);
            }
        }

        float v11 = Float.intBitsToFloat(((int)(arg21.getSize-NH-jbRc() >> v1)));
        DrawScope v1_1 = arg21;
        arg12 = arg12 / (((float)((((double)v1_1.toDp-u2uoSUM(v11))) * 3.141593))) * v0;
        v11 = arg14.getValue().floatValue() + arg15.getValue().floatValue();
        long v13 = v1_1.getCenter-F1C5BW0();
        DrawContext v7 = v1_1.getDrawContext();
        long v8 = v7.getSize-NH-jbRc();
        v7.getCanvas().save();
        try {
            v7.getTransform().rotate-Uv8p0NA(v11, v13);
            ProgressIndicatorKt.drawCircularIndicator-42QJj7c(v1_1, v10 + Math.min(v10, arg12), v0 - v10 - Math.min(v10, arg12) * 2f, arg16, arg18);
            ProgressIndicatorKt.drawDeterminateCircularIndicator-42QJj7c(arg21, 0f, v10, arg19, arg18);
        }
        catch(Throwable v0_1) {
            v7.getCanvas().restore();
            v7.setSize-uvyYCjk(v8);
            throw v0_1;
        }

        v7.getCanvas().restore();
        v7.setSize-uvyYCjk(v8);
        return Unit.INSTANCE;
    }

    static final Unit CircularProgressIndicator_4lLiAd8$lambda$35(Modifier arg12, long arg13, float arg15, long arg16, int arg18, float arg19, int arg20, int arg21, Composer arg22, int arg23) {
        ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(arg12, arg13, arg15, arg16, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    static final Unit CircularProgressIndicator_DUhRLBM$lambda$20(Function0 arg12, Modifier arg13, long arg14, float arg16, long arg17, int arg19, int arg20, int arg21, Composer arg22, int arg23) {
        ProgressIndicatorKt.CircularProgressIndicator-DUhRLBM(arg12, arg13, arg14, arg16, arg17, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    static final float CircularProgressIndicator_DUhRLBM$lambda$37$lambda$36(float arg0) {
        return arg0;
    }

    static final Unit CircularProgressIndicator_DUhRLBM$lambda$38(float arg12, Modifier arg13, long arg14, float arg16, long arg17, int arg19, int arg20, int arg21, Composer arg22, int arg23) {
        ProgressIndicatorKt.CircularProgressIndicator-DUhRLBM(arg12, arg13, arg14, arg16, arg17, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    static final float CircularProgressIndicator_IyT6zlY$lambda$22$lambda$21(Function0 arg2) {
        float v2 = arg2.invoke().floatValue();
        if(v2 < 0f) {
            v2 = 0f;
        }

        float v0 = 1f;
        if(v2 > v0) {
            return v0;
        }

        return v2;
    }

    static final Unit CircularProgressIndicator_IyT6zlY$lambda$26$lambda$25(Function0 arg7, SemanticsPropertyReceiver arg8) {
        Object v7 = arg7.invoke();
        if(!Float.isNaN(v7.floatValue())) {
        }
        else {
            v7 = null;
        }

        float v2 = v7 != null ? ((Float)v7).floatValue() : 0f;
        SemanticsPropertiesKt.setProgressBarRangeInfo(arg8, new ProgressBarRangeInfo(v2, RangesKt.rangeTo(0f, 1f), 0, 4, null));
        return Unit.INSTANCE;
    }

    static final Unit CircularProgressIndicator_IyT6zlY$lambda$28$lambda$27(Function0 arg10, int arg11, float arg12, float arg13, long arg14, Stroke arg16, long arg17, DrawScope arg19) {
        float v0 = 360f;
        float v3 = arg10.invoke().floatValue() * v0;
        boolean v10 = StrokeCap.equals-impl0(arg11, StrokeCap.Companion.getButt-KaPHkGw());
        arg11 = 0x20;
        if(!v10) {
            if(Float.intBitsToFloat(((int)(arg19.getSize-NH-jbRc() & 0xFFFFFFFFL))) > Float.intBitsToFloat(((int)(arg19.getSize-NH-jbRc() >> arg11)))) {
            }
            else {
                arg12 = Dp.constructor-impl(arg12 + arg13);
            }
        }

        arg12 = arg12 / (((float)((((double)arg19.toDp-u2uoSUM(Float.intBitsToFloat(((int)(arg19.getSize-NH-jbRc() >> arg11)))))) * 3.141593))) * v0;
        ProgressIndicatorKt.drawCircularIndicator-42QJj7c(arg19, 270f + v3 + Math.min(v3, arg12), v0 - v3 - Math.min(v3, arg12) * 2f, arg14, arg16);
        ProgressIndicatorKt.drawDeterminateCircularIndicator-42QJj7c(arg19, 270f, v3, arg17, arg16);
        return Unit.INSTANCE;
    }

    static final Unit CircularProgressIndicator_IyT6zlY$lambda$29(Function0 arg13, Modifier arg14, long arg15, float arg17, long arg18, int arg20, float arg21, int arg22, int arg23, Composer arg24, int arg25) {
        ProgressIndicatorKt.CircularProgressIndicator-IyT6zlY(arg13, arg14, arg15, arg17, arg18, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    static final Unit CircularProgressIndicator_LxG7B9w$lambda$30(Modifier arg11, long arg12, float arg14, long arg15, int arg17, int arg18, int arg19, Composer arg20, int arg21) {
        ProgressIndicatorKt.CircularProgressIndicator-LxG7B9w(arg11, arg12, arg14, arg15, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    static final Unit CircularProgressIndicator_MBs18nI$lambda$39(float arg8, Modifier arg9, long arg10, float arg12, int arg13, int arg14, Composer arg15, int arg16) {
        ProgressIndicatorKt.CircularProgressIndicator-MBs18nI(arg8, arg9, arg10, arg12, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    static final Unit CircularProgressIndicator_aM_cp0Q$lambda$40(Modifier arg7, long arg8, float arg10, int arg11, int arg12, Composer arg13, int arg14) {
        ProgressIndicatorKt.CircularProgressIndicator-aM-cp0Q(arg7, arg8, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the overload that takes `gapSize`, see `LegacyIndeterminateLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith="<_subannotation>") public static final void LinearProgressIndicator-2cYBFYY(Modifier arg18, long arg19, long arg21, int arg23, Composer arg24, int arg25, int arg26) {
        long v2_1;
        int v13;
        long v11_2;
        Companion v8_2;
        Modifier v1_2;
        int v11;
        int v10;
        long v8;
        int v6;
        long v4;
        Modifier v2;
        int v3;
        int v7 = arg25;
        int v0 = 0xE3939CB1;
        Composer v15 = arg24.startRestartGroup(v0);
        ComposerKt.sourceInformation(v15, "C(LinearProgressIndicator)N(modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)220@9927L175:ProgressIndicator.kt#uh7d8r");
        int v1 = arg26 & 1;
        if(v1 != 0) {
            v3 = v7 | 6;
            v2 = arg18;
        }
        else if((v7 & 6) == 0) {
            v2 = arg18;
            v3 = v15.changed(v2) ? 4 : 2;
            v3 |= v7;
        }
        else {
            v2 = arg18;
            v3 = v7;
        }

        if((v7 & 0x30) == 0) {
            if((arg26 & 2) == 0) {
                v4 = arg19;
                if(v15.changed(v4)) {
                    v6 = 0x20;
                }
                else {
                    goto label_34;
                }
            }
            else {
                v4 = arg19;
            label_34:
                v6 = 16;
            }

            v3 |= v6;
        }
        else {
            v4 = arg19;
        }

        if((v7 & 0x180) == 0) {
            v8 = arg21;
            v6 = (arg26 & 4) != 0 || !v15.changed(v8) ? 0x80 : 0x100;
            v3 |= v6;
        }
        else {
            v8 = arg21;
        }

        v6 = arg26 & 8;
        if(v6 != 0) {
            v3 |= 0xC00;
            goto label_65;
        }
        else if((v7 & 0xC00) == 0) {
            v10 = arg23;
            v11 = v15.changed(v10) ? 0x800 : 0x400;
            v3 |= v11;
        }
        else {
        label_65:
            v10 = arg23;
        }

        boolean v11_1 = (v3 & 0x493) != 1170 ? true : false;
        if(v15.shouldExecute(v11_1, v3 & 1)) {
            v15.startDefaults();
            ComposerKt.sourceInformation(v15, "216@9768L11,217@9831L16");
            if((v7 & 1) == 0 || (v15.getDefaultsInvalid())) {
                if(v1 != 0) {
                    Companion v1_1 = Modifier.Companion;
                }
                else {
                    v1_2 = v2;
                }

                v11 = 6;
                if((arg26 & 2) != 0) {
                    v4 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(v15, v11);
                    v3 &= 0xFFFFFF8F;
                }

                if((arg26 & 4) != 0) {
                    v8 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(v15, v11);
                    v3 &= -897;
                }

                if(v6 != 0) {
                    v13 = ProgressIndicatorDefaults.INSTANCE.getLinearStrokeCap-KaPHkGw();
                    v11_2 = v8;
                }
                else {
                    v11_2 = v8;
                    v13 = v10;
                }

                v8_2 = ((Companion)v1_2);
            }
            else {
                v15.skipToGroupEnd();
                if((arg26 & 2) != 0) {
                    v3 &= 0xFFFFFF8F;
                }

                if((arg26 & 4) != 0) {
                    v3 &= -897;
                }

                v11_2 = v8;
                v13 = v10;
                Modifier v8_1 = v2;
            }

            long v9 = v4;
            v15.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:219)");
            }

            ProgressIndicatorKt.LinearProgressIndicator-rIrjwxo(((Modifier)v8_2), v9, v11_2, v13, ProgressIndicatorDefaults.INSTANCE.getLinearIndicatorTrackGapSize-D9Ej5fM(), v15, v3 & 14 | 0x6000 | v3 & 0x70 | v3 & 0x380 | v3 & 0x1C00, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_2 = ((Modifier)v8_2);
            v2_1 = v9;
            v4 = v11_2;
            v6 = v13;
        }
        else {
            v15.skipToGroupEnd();
            v1_2 = v2;
            v2_1 = v4;
            v4 = v8;
            v6 = v10;
        }

        ScopeUpdateScope v9_1 = v15.endRestartGroup();
        if(v9_1 != null) {
            v9_1.updateScope(new ProgressIndicatorKt$$ExternalSyntheticLambda6(v1_2, v2_1, v4, v6, v7, arg26));
        }
    }

    public static final void LinearProgressIndicator-GJbTh5U(Function0 arg30, Modifier arg31, long arg32, long arg34, int arg36, float arg37, Function1 arg38, Composer arg39, int arg40, int arg41) {
        Function1 v9_3;
        long v3_3;
        float v8_4;
        long v25;
        long v27;
        Function1 v29;
        ProgressIndicatorKt$$ExternalSyntheticLambda2 v6_3;
        int v22;
        Modifier v5_1;
        float v23;
        Function1 v7_1;
        Object v7_2;
        ProgressIndicatorKt$$ExternalSyntheticLambda1 v8_3;
        int v8_1;
        int v18;
        float v4;
        int v16;
        int v9;
        long v13;
        long v11;
        int v7;
        Modifier v6;
        int v3;
        Function0 v1 = arg30;
        int v10 = arg40;
        Composer v2 = arg39.startRestartGroup(-339970038);
        ComposerKt.sourceInformation(v2, "C(LinearProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap,gapSize:c#ui.unit.Dp,drawStopIndicator)154@7102L35,158@7266L241,164@7577L806,155@7142L1241:ProgressIndicator.kt#uh7d8r");
        if((arg41 & 1) != 0) {
            v3 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v3 = v2.changedInstance(v1) ? 4 : 2;
            v3 |= v10;
        }
        else {
            v3 = v10;
        }

        int v5 = arg41 & 2;
        if(v5 != 0) {
            v3 |= 0x30;
            goto label_35;
        }
        else if((v10 & 0x30) == 0) {
            v6 = arg31;
            v7 = v2.changed(v6) ? 0x20 : 16;
            v3 |= v7;
        }
        else {
        label_35:
            v6 = arg31;
        }

        if((v10 & 0x180) == 0) {
            v11 = arg32;
            v7 = (arg41 & 4) != 0 || !v2.changed(v11) ? 0x80 : 0x100;
            v3 |= v7;
        }
        else {
            v11 = arg32;
        }

        if((v10 & 0xC00) == 0) {
            v13 = arg34;
            v7 = (arg41 & 8) != 0 || !v2.changed(v13) ? 0x400 : 0x800;
            v3 |= v7;
        }
        else {
            v13 = arg34;
        }

        v7 = arg41 & 16;
        if(v7 != 0) {
            v3 |= 0x6000;
            goto label_76;
        }
        else if((v10 & 0x6000) == 0) {
            v9 = arg36;
            v16 = v2.changed(v9) ? 0x4000 : 0x2000;
            v3 |= v16;
        }
        else {
        label_76:
            v9 = arg36;
        }

        v16 = arg41 & 0x20;
        int v17 = 0x30000;
        if(v16 != 0) {
            v3 |= v17;
            v4 = arg37;
        }
        else {
            v4 = arg37;
            if((v10 & v17) == 0) {
                v18 = v2.changed(v4) ? 0x20000 : 0x10000;
                v3 |= v18;
            }
        }

        v18 = 0x180000;
        if((v10 & v18) == 0) {
            Function1 v0 = arg38;
            int v20 = (arg41 & 0x40) != 0 || !v2.changedInstance(v0) ? 0x80000 : 0x100000;
            v3 |= v20;
        }

        int v0_1 = 1;
        boolean v8 = (v3 & 0x92493) != 0x92492 ? true : false;
        if(v2.shouldExecute(v8, v3 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "141@6585L11,142@6648L16,145@6855L215");
            String v15 = "CC(remember):ProgressIndicator.kt#9igjgp";
            if((v10 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v5 != 0) {
                    Companion v5_2 = Modifier.Companion;
                }
                else {
                    v5_1 = v6;
                }

                v8_1 = 6;
                if((arg41 & 4) != 0) {
                    v11 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(v2, v8_1);
                    v3 &= -897;
                }

                if((arg41 & 8) != 0) {
                    v13 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(v2, v8_1);
                    v3 &= 0xFFFFE3FF;
                }

                int v6_1 = v7 != 0 ? ProgressIndicatorDefaults.INSTANCE.getLinearStrokeCap-KaPHkGw() : v9;
                if(v16 != 0) {
                    v4 = ProgressIndicatorDefaults.INSTANCE.getLinearIndicatorTrackGapSize-D9Ej5fM();
                }

                if((arg41 & 0x40) != 0) {
                    ComposerKt.sourceInformationMarkerStart(v2, 0xEE7ED7A1, v15);
                    v8_1 = 0x100;
                    v7 = (v3 & 0x380 ^ 0x180) > v8_1 && (v2.changed(v11)) || (v3 & 0x180) == v8_1 ? 1 : 0;
                    v8_1 = (0xE000 & v3) == 0x4000 ? 1 : 0;
                    v7 |= v8_1;
                    Object v8_2 = v2.rememberedValue();
                    if(v7 != 0 || v8_2 == Composer.Companion.getEmpty()) {
                        v8_3 = new ProgressIndicatorKt$$ExternalSyntheticLambda1(v11, v6_1);
                        v2.updateRememberedValue(v8_3);
                    }

                    v7_2 = v8_3;
                    ComposerKt.sourceInformationMarkerEnd(v2);
                    v3 &= 0xFFC7FFFF;
                }
                else {
                    v7_1 = arg38;
                }

                v23 = v4;
                v22 = v6_1;
            }
            else {
                v2.skipToGroupEnd();
                if((arg41 & 4) != 0) {
                    v3 &= -897;
                }

                if((arg41 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                if((arg41 & 0x40) != 0) {
                    v3 &= 0xFFC7FFFF;
                }

                v7_1 = arg38;
                v23 = v4;
                v5_1 = v6;
                v22 = v9;
            }

            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-339970038, v3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:153)");
            }

            ComposerKt.sourceInformationMarkerStart(v2, 0xEE7EF5CD, v15);
            int v4_1 = (v3 & 14) == 4 ? 1 : 0;
            Object v6_2 = v2.rememberedValue();
            if(v4_1 != 0 || v6_2 == Composer.Companion.getEmpty()) {
                v6_3 = new ProgressIndicatorKt$$ExternalSyntheticLambda2(v1);
                v2.updateRememberedValue(v6_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            Modifier v4_2 = v5_1.then(AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds());
            ComposerKt.sourceInformationMarkerStart(v2, 0xEE7F0B1B, v15);
            v8 = v2.changed(v6_3);
            Object v9_1 = v2.rememberedValue();
            if((v8) || v9_1 == Composer.Companion.getEmpty()) {
                ProgressIndicatorKt$$ExternalSyntheticLambda3 v9_2 = new ProgressIndicatorKt$$ExternalSyntheticLambda3(((Function0)v6_3));
                v2.updateRememberedValue(v9_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            v4_2 = SizeKt.size-VpY3zN4(SemanticsModifierKt.semantics(v4_2, true, ((Function1)v9_1)), ProgressIndicatorKt.LinearIndicatorWidth, ProgressIndicatorKt.LinearIndicatorHeight);
            ComposerKt.sourceInformationMarkerStart(v2, 0xEE7F3430, v15);
            v8_1 = (0xE000 & v3) == 0x4000 ? 1 : 0;
            v9 = (0x70000 & v3) == 0x20000 ? 1 : 0;
            v8_1 = v8_1 | v9 | v2.changed(v6_3);
            int v15_1 = 0x800;
            v9 = (v3 & 0x1C00 ^ 0xC00) > v15_1 && (v2.changed(v13)) || (v3 & 0xC00) == v15_1 ? 1 : 0;
            v8_1 |= v9;
            v15_1 = 0x100;
            v9 = (v3 & 0x380 ^ 0x180) > v15_1 && (v2.changed(v11)) || (v3 & 0x180) == v15_1 ? 1 : 0;
            v8_1 |= v9;
            v15_1 = 0x100000;
            if((0x380000 & v3 ^ v18) <= v15_1 || !v2.changed(v7_2)) {
                if((v3 & v18) == v15_1) {
                }
                else {
                    v0_1 = 0;
                }
            }

            Object v3_1 = v2.rememberedValue();
            if((v0_1 | v8_1) != 0 || v3_1 == Composer.Companion.getEmpty()) {
                v29 = ((Function1)v7_2);
                v27 = v11;
                v25 = v13;
                ProgressIndicatorKt$$ExternalSyntheticLambda4 v3_2 = new ProgressIndicatorKt$$ExternalSyntheticLambda4(v22, v23, v6_3, v25, v27, v29);
                v2.updateRememberedValue(v3_2);
            }
            else {
                v29 = ((Function1)v7_2);
                v27 = v11;
                v25 = v13;
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            CanvasKt.Canvas(v4_2, ((Function1)v3_1), v2, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7 = v22;
            v8_4 = v23;
            v13 = v25;
            v3_3 = v27;
            v9_3 = v29;
        }
        else {
            v2.skipToGroupEnd();
            v8_4 = v4;
            v5_1 = v6;
            v7 = v9;
            v3_3 = v11;
            v9_3 = arg38;
        }

        ScopeUpdateScope v12 = v2.endRestartGroup();
        if(v12 != null) {
            v12.updateScope(new ProgressIndicatorKt$$ExternalSyntheticLambda5(v1, v5_1, v3_3, v13, v7, v8_4, v9_3, v10, arg41));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public static final void LinearProgressIndicator-RIQooxk(Modifier arg17, long arg18, long arg20, Composer arg22, int arg23, int arg24) {
        long v2_1;
        long v10;
        Companion v7_3;
        Modifier v1_2;
        Companion v1_1;
        int v9;
        long v7_1;
        int v7;
        long v4;
        Modifier v2;
        int v3;
        int v6 = arg23;
        int v0 = 0x22E72F03;
        Composer v14 = arg22.startRestartGroup(v0);
        ComposerKt.sourceInformation(v14, "C(LinearProgressIndicator)N(modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color)391@16079L146:ProgressIndicator.kt#uh7d8r");
        int v1 = arg24 & 1;
        if(v1 != 0) {
            v3 = v6 | 6;
            v2 = arg17;
        }
        else if((v6 & 6) == 0) {
            v2 = arg17;
            v3 = v14.changed(v2) ? 4 : 2;
            v3 |= v6;
        }
        else {
            v2 = arg17;
            v3 = v6;
        }

        if((v6 & 0x30) == 0) {
            if((arg24 & 2) == 0) {
                v4 = arg18;
                if(v14.changed(v4)) {
                    v7 = 0x20;
                }
                else {
                    goto label_34;
                }
            }
            else {
                v4 = arg18;
            label_34:
                v7 = 16;
            }

            v3 |= v7;
        }
        else {
            v4 = arg18;
        }

        if((v6 & 0x180) == 0) {
            if((arg24 & 4) == 0) {
                v7_1 = arg20;
                if(v14.changed(v7_1)) {
                    v9 = 0x100;
                }
                else {
                    goto label_48;
                }
            }
            else {
                v7_1 = arg20;
            label_48:
                v9 = 0x80;
            }

            v3 |= v9;
        }
        else {
            v7_1 = arg20;
        }

        boolean v9_1 = (v3 & 0x93) != 0x92 ? true : false;
        if(v14.shouldExecute(v9_1, v3 & 1)) {
            v14.startDefaults();
            ComposerKt.sourceInformation(v14, "388@15990L11,389@16053L16");
            if((v6 & 1) == 0 || (v14.getDefaultsInvalid())) {
                if(v1 != 0) {
                    v1_1 = Modifier.Companion;
                }
                else {
                    v1_2 = v2;
                }

                v9 = 6;
                if((arg24 & 2) != 0) {
                    v4 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(v14, v9);
                    v3 &= 0xFFFFFF8F;
                }

                if((arg24 & 4) != 0) {
                    v7_1 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(v14, v9);
                    v3 &= -897;
                }

                v10 = v7_1;
                v7_3 = v1_1;
            }
            else {
                v14.skipToGroupEnd();
                if((arg24 & 2) != 0) {
                    v3 &= 0xFFFFFF8F;
                }

                if((arg24 & 4) != 0) {
                    v3 &= -897;
                }

                v10 = v7_1;
                Modifier v7_2 = v2;
            }

            long v8 = v4;
            v14.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:391)");
            }

            ProgressIndicatorKt.LinearProgressIndicator-rIrjwxo(((Modifier)v7_3), v8, v10, ProgressIndicatorDefaults.INSTANCE.getLinearStrokeCap-KaPHkGw(), 0f, v14, v3 & 14 | 0xC00 | v3 & 0x70 | v3 & 0x380, 16);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_2 = ((Modifier)v7_3);
            v2_1 = v8;
            v4 = v10;
        }
        else {
            v14.skipToGroupEnd();
            v1_2 = v2;
            v2_1 = v4;
            v4 = v7_1;
        }

        ScopeUpdateScope v8_1 = v14.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new ProgressIndicatorKt$$ExternalSyntheticLambda16(v1_2, v2_1, v4, v6, arg24));
        }
    }

    @Deprecated(message="Use the overload that takes `progress` as a lambda", replaceWith="<_subannotation>") public static final void LinearProgressIndicator-_5eSR-E(float arg21, Modifier arg22, long arg23, long arg25, int arg27, Composer arg28, int arg29, int arg30) {
        long v5_1;
        long v3_1;
        Modifier v2_1;
        Composer v18;
        ProgressIndicatorKt$$ExternalSyntheticLambda10 v0_2;
        int v15;
        Companion v6_1;
        int v14;
        int v13;
        long v11;
        long v9;
        int v7;
        Modifier v6;
        int v3;
        float v1 = arg21;
        int v8 = arg29;
        int v0 = 0x35F79B61;
        Composer v2 = arg28.startRestartGroup(v0);
        ComposerKt.sourceInformation(v2, "C(LinearProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)360@15142L12,359@15098L179:ProgressIndicator.kt#uh7d8r");
        int v4 = 4;
        if((arg30 & 1) != 0) {
            v3 = v8 | 6;
        }
        else if((v8 & 6) == 0) {
            v3 = v2.changed(v1) ? v4 : 2;
            v3 |= v8;
        }
        else {
            v3 = v8;
        }

        int v5 = arg30 & 2;
        if(v5 != 0) {
            v3 |= 0x30;
            goto label_36;
        }
        else if((v8 & 0x30) == 0) {
            v6 = arg22;
            v7 = v2.changed(v6) ? 0x20 : 16;
            v3 |= v7;
        }
        else {
        label_36:
            v6 = arg22;
        }

        if((v8 & 0x180) == 0) {
            v9 = arg23;
            v7 = (arg30 & 4) != 0 || !v2.changed(v9) ? 0x80 : 0x100;
            v3 |= v7;
        }
        else {
            v9 = arg23;
        }

        if((v8 & 0xC00) == 0) {
            v11 = arg25;
            v7 = (arg30 & 8) != 0 || !v2.changed(v11) ? 0x400 : 0x800;
            v3 |= v7;
        }
        else {
            v11 = arg25;
        }

        v7 = arg30 & 16;
        if(v7 != 0) {
            v3 |= 0x6000;
            goto label_77;
        }
        else if((v8 & 0x6000) == 0) {
            v13 = arg27;
            v14 = v2.changed(v13) ? 0x4000 : 0x2000;
            v3 |= v14;
        }
        else {
        label_77:
            v13 = arg27;
        }

        int v16 = 0;
        boolean v14_1 = (v3 & 9363) != 9362 ? true : false;
        if(v2.shouldExecute(v14_1, v3 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "355@14939L11,356@15002L16");
            if((v8 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v5 != 0) {
                    v6_1 = Modifier.Companion;
                }

                v14 = 6;
                if((arg30 & 4) != 0) {
                    v9 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(v2, v14);
                    v3 &= -897;
                }

                if((arg30 & 8) != 0) {
                    v11 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(v2, v14);
                    v3 &= 0xFFFFE3FF;
                }

                if(v7 != 0) {
                    v15 = ProgressIndicatorDefaults.INSTANCE.getLinearStrokeCap-KaPHkGw();
                    goto label_105;
                }

            label_104:
                v15 = v13;
            }
            else {
                v2.skipToGroupEnd();
                if((arg30 & 4) != 0) {
                    v3 &= -897;
                }

                if((arg30 & 8) == 0) {
                    goto label_104;
                }

                v3 &= 0xFFFFE3FF;
                goto label_104;
            }

        label_105:
            long v13_1 = v11;
            v11 = v9;
            Modifier v10 = ((Modifier)v6_1);
            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:359)");
            }

            ComposerKt.sourceInformationMarkerStart(v2, -1770084819, "CC(remember):ProgressIndicator.kt#9igjgp");
            if((v3 & 14) == v4) {
                v16 = 1;
            }

            Object v0_1 = v2.rememberedValue();
            if(v16 != 0 || v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = new ProgressIndicatorKt$$ExternalSyntheticLambda10(v1);
                v2.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            v18 = v2;
            ProgressIndicatorKt.LinearProgressIndicator-GJbTh5U(v0_2, v10, v11, v13_1, v15, 0f, null, v18, v3 & 0xFFF0, 0x60);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v10;
            v3_1 = v11;
            v5_1 = v13_1;
            v7 = v15;
        }
        else {
            v18 = v2;
            v18.skipToGroupEnd();
            v2_1 = v6;
            v3_1 = v9;
            v5_1 = v11;
            v7 = v13;
        }

        ScopeUpdateScope v10_1 = v18.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new ProgressIndicatorKt$$ExternalSyntheticLambda12(v1, v2_1, v3_1, v5_1, v7, v8, arg30));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the overload that takes `gapSize` and `drawStopIndicator`, see `LegacyLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith="<_subannotation>") public static final void LinearProgressIndicator-_5eSR-E(Function0 arg21, Modifier arg22, long arg23, long arg25, int arg27, Composer arg28, int arg29, int arg30) {
        long v3_3;
        Modifier v2_1;
        Composer v18;
        long v11;
        int v15;
        long v13_2;
        Companion v10_2;
        long v4_1;
        Modifier v3_2;
        int v13;
        int v12;
        long v10;
        int v7;
        long v5_1;
        Modifier v4;
        Function0 v9;
        int v2;
        int v8 = arg29;
        int v0 = 0x94E41365;
        Composer v1 = arg28.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(LinearProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)101@4670L193:ProgressIndicator.kt#uh7d8r");
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
            int v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_36:
            v4 = arg22;
        }

        if((v8 & 0x180) == 0) {
            if((arg30 & 4) == 0) {
                v5_1 = arg23;
                if(v1.changed(v5_1)) {
                    v7 = 0x100;
                }
                else {
                    goto label_47;
                }
            }
            else {
                v5_1 = arg23;
            label_47:
                v7 = 0x80;
            }

            v2 |= v7;
        }
        else {
            v5_1 = arg23;
        }

        if((v8 & 0xC00) == 0) {
            v10 = arg25;
            v7 = (arg30 & 8) != 0 || !v1.changed(v10) ? 0x400 : 0x800;
            v2 |= v7;
        }
        else {
            v10 = arg25;
        }

        v7 = arg30 & 16;
        if(v7 != 0) {
            v2 |= 0x6000;
            goto label_78;
        }
        else if((v8 & 0x6000) == 0) {
            v12 = arg27;
            v13 = v1.changed(v12) ? 0x4000 : 0x2000;
            v2 |= v13;
        }
        else {
        label_78:
            v12 = arg27;
        }

        boolean v13_1 = (v2 & 9363) != 9362 ? true : false;
        if(v1.shouldExecute(v13_1, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "97@4511L11,98@4574L16");
            if((v8 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    Companion v3_1 = Modifier.Companion;
                }
                else {
                    v3_2 = v4;
                }

                v13 = 6;
                if((arg30 & 4) != 0) {
                    v4_1 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(v1, v13);
                    v2 &= -897;
                }
                else {
                    v4_1 = v5_1;
                }

                if((arg30 & 8) != 0) {
                    v10 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(v1, v13);
                    v2 &= 0xFFFFE3FF;
                }

                if(v7 != 0) {
                    v15 = ProgressIndicatorDefaults.INSTANCE.getLinearStrokeCap-KaPHkGw();
                    v13_2 = v10;
                }
                else {
                    v13_2 = v10;
                    v15 = v12;
                }

                v10_2 = ((Companion)v3_2);
                v11 = v4_1;
            }
            else {
                v1.skipToGroupEnd();
                if((arg30 & 4) != 0) {
                    v2 &= -897;
                }

                if((arg30 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                v13_2 = v10;
                v15 = v12;
                Modifier v10_1 = v4;
                v11 = v5_1;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:100)");
            }

            v18 = v1;
            ProgressIndicatorKt.LinearProgressIndicator-GJbTh5U(v9, ((Modifier)v10_2), v11, v13_2, v15, ProgressIndicatorDefaults.INSTANCE.getLinearIndicatorTrackGapSize-D9Ej5fM(), null, v18, v2 & 14 | 0x30000 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00 | v2 & 0xE000, 0x40);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v10_2);
            v3_3 = v11;
            v5_1 = v13_2;
            v7 = v15;
        }
        else {
            v18 = v1;
            v18.skipToGroupEnd();
            v2_1 = v4;
            v3_3 = v5_1;
            v5_1 = v10;
            v7 = v12;
        }

        ScopeUpdateScope v10_3 = v18.endRestartGroup();
        if(v10_3 != null) {
            v10_3.updateScope(new ProgressIndicatorKt$$ExternalSyntheticLambda22(arg21, v2_1, v3_3, v5_1, v7, v8, arg30));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public static final void LinearProgressIndicator-eaDK9VM(float arg18, Modifier arg19, long arg20, long arg22, Composer arg24, int arg25, int arg26) {
        long v5;
        long v10;
        long v12;
        Companion v9_2;
        long v3_1;
        Modifier v2_2;
        Companion v2_1;
        long v9;
        int v6;
        long v4_1;
        Modifier v3;
        float v8;
        int v1;
        int v7 = arg25;
        int v0 = 0xE9C8C9B3;
        Composer v15 = arg24.startRestartGroup(v0);
        ComposerKt.sourceInformation(v15, "C(LinearProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color)376@15619L164:ProgressIndicator.kt#uh7d8r");
        if((arg26 & 1) != 0) {
            v1 = v7 | 6;
            v8 = arg18;
        }
        else {
            v8 = arg18;
            if((v7 & 6) == 0) {
                v1 = v15.changed(v8) ? 4 : 2;
                v1 |= v7;
            }
            else {
                v1 = v7;
            }
        }

        int v2 = arg26 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
            goto label_36;
        }
        else if((v7 & 0x30) == 0) {
            v3 = arg19;
            int v4 = v15.changed(v3) ? 0x20 : 16;
            v1 |= v4;
        }
        else {
        label_36:
            v3 = arg19;
        }

        if((v7 & 0x180) == 0) {
            if((arg26 & 4) == 0) {
                v4_1 = arg20;
                if(v15.changed(v4_1)) {
                    v6 = 0x100;
                }
                else {
                    goto label_47;
                }
            }
            else {
                v4_1 = arg20;
            label_47:
                v6 = 0x80;
            }

            v1 |= v6;
        }
        else {
            v4_1 = arg20;
        }

        if((v7 & 0xC00) == 0) {
            v9 = arg22;
            v6 = (arg26 & 8) != 0 || !v15.changed(v9) ? 0x400 : 0x800;
            v1 |= v6;
        }
        else {
            v9 = arg22;
        }

        boolean v6_1 = (v1 & 0x493) != 1170 ? true : false;
        if(v15.shouldExecute(v6_1, v1 & 1)) {
            v15.startDefaults();
            ComposerKt.sourceInformation(v15, "373@15530L11,374@15593L16");
            if((v7 & 1) == 0 || (v15.getDefaultsInvalid())) {
                if(v2 != 0) {
                    v2_1 = Modifier.Companion;
                }
                else {
                    v2_2 = v3;
                }

                v6 = 6;
                if((arg26 & 4) != 0) {
                    v3_1 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(v15, v6);
                    v1 &= -897;
                }
                else {
                    v3_1 = v4_1;
                }

                if((arg26 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                    v9_2 = v2_1;
                    v10 = v3_1;
                    v12 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(v15, v6);
                    goto label_116;
                }

                v12 = v9;
                v9_2 = v2_1;
                v10 = v3_1;
            }
            else {
                v15.skipToGroupEnd();
                if((arg26 & 4) != 0) {
                    v1 &= -897;
                }

                if((arg26 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                }

                v12 = v9;
                Modifier v9_1 = v3;
                v10 = v4_1;
            }

        label_116:
            v15.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:376)");
            }

            ProgressIndicatorKt.LinearProgressIndicator-_5eSR-E(v8, ((Modifier)v9_2), v10, v12, ProgressIndicatorDefaults.INSTANCE.getLinearStrokeCap-KaPHkGw(), v15, v1 & 14 | 0x6000 | v1 & 0x70 | v1 & 0x380 | v1 & 0x1C00, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2 = ((Modifier)v9_2);
            v3_1 = v10;
            v5 = v12;
        }
        else {
            v15.skipToGroupEnd();
            v2_2 = v3;
            v3_1 = v4_1;
            v5 = v9;
        }

        ScopeUpdateScope v9_3 = v15.endRestartGroup();
        if(v9_3 != null) {
            v9_3.updateScope(new ProgressIndicatorKt$$ExternalSyntheticLambda18(arg18, v2_2, v3_1, v5, v7, arg26));
        }
    }

    public static final void LinearProgressIndicator-rIrjwxo(Modifier arg29, long arg30, long arg32, int arg34, float arg35, Composer arg36, int arg37, int arg38) {
        long v2_3;
        long v4_3;
        Modifier v1_2;
        long v22;
        long v25;
        ProgressIndicatorKt$$ExternalSyntheticLambda7 v4_2;
        Composer v13;
        Modifier v2_1;
        float v20;
        int v6_1;
        Companion v2_2;
        float v7;
        int v15;
        int v14;
        long v11;
        int v5;
        long v9;
        Modifier v3;
        int v4;
        int v8 = arg37;
        Composer v1 = arg36.startRestartGroup(0x21D4B971);
        ComposerKt.sourceInformation(v1, "C(LinearProgressIndicator)N(modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap,gapSize:c#ui.unit.Dp)255@11480L28,257@11560L159,263@11771L159,269@11983L160,275@12196L160,285@12539L1839,280@12361L2017:ProgressIndicator.kt#uh7d8r");
        int v2 = arg38 & 1;
        if(v2 != 0) {
            v4 = v8 | 6;
            v3 = arg29;
        }
        else if((v8 & 6) == 0) {
            v3 = arg29;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v8;
        }
        else {
            v3 = arg29;
            v4 = v8;
        }

        if((v8 & 0x30) == 0) {
            v9 = arg30;
            v5 = (arg38 & 2) != 0 || !v1.changed(v9) ? 16 : 0x20;
            v4 |= v5;
        }
        else {
            v9 = arg30;
        }

        if((v8 & 0x180) == 0) {
            v11 = arg32;
            v5 = (arg38 & 4) != 0 || !v1.changed(v11) ? 0x80 : 0x100;
            v4 |= v5;
        }
        else {
            v11 = arg32;
        }

        v5 = arg38 & 8;
        if(v5 != 0) {
            v4 |= 0xC00;
            goto label_64;
        }
        else if((v8 & 0xC00) == 0) {
            v14 = arg34;
            v15 = v1.changed(v14) ? 0x800 : 0x400;
            v4 |= v15;
        }
        else {
        label_64:
            v14 = arg34;
        }

        v15 = arg38 & 16;
        if(v15 != 0) {
            v4 |= 0x6000;
            goto label_79;
        }
        else if((v8 & 0x6000) == 0) {
            v7 = arg35;
            int v16 = v1.changed(v7) ? 0x4000 : 0x2000;
            v4 |= v16;
        }
        else {
        label_79:
            v7 = arg35;
        }

        boolean v6 = (v4 & 9363) != 9362 ? true : false;
        if(v1.shouldExecute(v6, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "250@11223L11,251@11286L16");
            if((v8 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v2 != 0) {
                    v2_2 = Modifier.Companion;
                }
                else {
                    v2_1 = v3;
                }

                v6_1 = 6;
                if((arg38 & 2) != 0) {
                    v9 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(v1, v6_1);
                    v4 &= 0xFFFFFF8F;
                }

                if((arg38 & 4) != 0) {
                    v11 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(v1, v6_1);
                    v4 &= -897;
                }

                if(v5 != 0) {
                    v14 = ProgressIndicatorDefaults.INSTANCE.getLinearStrokeCap-KaPHkGw();
                }

                if(v15 != 0) {
                    v20 = ProgressIndicatorDefaults.INSTANCE.getLinearIndicatorTrackGapSize-D9Ej5fM();
                    goto label_107;
                }

            label_106:
                v20 = v7;
            }
            else {
                v1.skipToGroupEnd();
                if((arg38 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }

                if((arg38 & 4) != 0) {
                    v4 &= -897;
                }

                v2_1 = v3;
                goto label_106;
            }

        label_107:
            int v19 = v14;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x21D4B971, v4, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:254)");
            }

            Composer v34 = v1;
            InfiniteTransition v29 = InfiniteTransitionKt.rememberInfiniteTransition(null, v1, 0, 1);
            State v1_1 = InfiniteTransitionKt.animateFloat(v29, 0f, 1f, ProgressIndicatorKt.getLinearIndeterminateFirstLineHeadAnimationSpec(), null, v34, InfiniteTransition.$stable | 0x1B0 | InfiniteRepeatableSpec.$stable << 9, 8);
            State v3_1 = InfiniteTransitionKt.animateFloat(v29, 0f, 1f, ProgressIndicatorKt.getLinearIndeterminateFirstLineTailAnimationSpec(), null, v34, InfiniteTransition.$stable | 0x1B0 | InfiniteRepeatableSpec.$stable << 9, 8);
            State v5_1 = InfiniteTransitionKt.animateFloat(v29, 0f, 1f, ProgressIndicatorKt.getLinearIndeterminateSecondLineHeadAnimationSpec(), null, v34, InfiniteTransition.$stable | 0x1B0 | InfiniteRepeatableSpec.$stable << 9, 8);
            State v6_2 = InfiniteTransitionKt.animateFloat(v29, 0f, 1f, ProgressIndicatorKt.getLinearIndeterminateSecondLineTailAnimationSpec(), null, v34, InfiniteTransition.$stable | 0x1B0 | InfiniteRepeatableSpec.$stable << 9, 8);
            v13 = v34;
            Modifier v7_1 = SizeKt.size-VpY3zN4(ProgressSemanticsKt.progressSemantics(((Modifier)v2_2).then(AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds())), ProgressIndicatorKt.LinearIndicatorWidth, ProgressIndicatorKt.LinearIndicatorHeight);
            ComposerKt.sourceInformationMarkerStart(v13, 0xFF8CE100, "CC(remember):ProgressIndicator.kt#9igjgp");
            v14 = (v4 & 0x1C00) == 0x800 ? 1 : 0;
            int v0 = (0xE000 & v4) == 0x4000 ? 1 : 0;
            v0 = v0 | v14 | v13.changed(v1_1);
            v15 = 0x100;
            v14 = (v4 & 0x380 ^ 0x180) > v15 && (v13.changed(v11)) || (v4 & 0x180) == v15 ? 1 : 0;
            v0 = v0 | v14 | v13.changed(v3_1);
            v15 = 0x20;
            v4 = (v4 & 0x70 ^ 0x30) > v15 && (v13.changed(v9)) || (v4 & 0x30) == v15 ? 1 : 0;
            v0 = v0 | v4 | v13.changed(v5_1) | v13.changed(v6_2);
            Object v4_1 = v13.rememberedValue();
            if(v0 != 0 || v4_1 == Composer.Companion.getEmpty()) {
                v25 = v9;
                v22 = v11;
                v4_2 = new ProgressIndicatorKt$$ExternalSyntheticLambda7(v19, v20, v1_1, v22, v3_1, v25, v5_1, v6_2);
                v13.updateRememberedValue(v4_2);
            }
            else {
                v25 = v9;
                v22 = v11;
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            CanvasKt.Canvas(v7_1, ((Function1)v4_2), v13, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_2 = ((Modifier)v2_2);
            v6_1 = v19;
            v7 = v20;
            v4_3 = v22;
            v2_3 = v25;
        }
        else {
            v13 = v1;
            v13.skipToGroupEnd();
            v1_2 = v3;
            v2_3 = v9;
            v4_3 = v11;
            v6_1 = v14;
        }

        ScopeUpdateScope v10 = v13.endRestartGroup();
        if(v10 != null) {
            v10.updateScope(new ProgressIndicatorKt$$ExternalSyntheticLambda8(v1_2, v2_3, v4_3, v6_1, v7, v8, arg38));
        }
    }

    static final Unit LinearProgressIndicator_2cYBFYY$lambda$11(Modifier arg10, long arg11, long arg13, int arg15, int arg16, int arg17, Composer arg18, int arg19) {
        ProgressIndicatorKt.LinearProgressIndicator-2cYBFYY(arg10, arg11, arg13, arg15, arg18, RecomposeScopeImplKt.updateChangedFlags(arg16 | 1), arg17);
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator_GJbTh5U$lambda$10(Function0 arg13, Modifier arg14, long arg15, long arg17, int arg19, float arg20, Function1 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        ProgressIndicatorKt.LinearProgressIndicator-GJbTh5U(arg13, arg14, arg15, arg17, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator_GJbTh5U$lambda$2$lambda$1(long arg6, int arg8, DrawScope arg9) {
        ProgressIndicatorDefaults.INSTANCE.drawStopIndicator-EgI2THU(arg9, ProgressIndicatorDefaults.INSTANCE.getLinearTrackStopIndicatorSize-D9Ej5fM(), arg6, arg8);
        return Unit.INSTANCE;
    }

    static final float LinearProgressIndicator_GJbTh5U$lambda$4$lambda$3(Function0 arg2) {
        float v2 = arg2.invoke().floatValue();
        if(v2 < 0f) {
            v2 = 0f;
        }

        float v0 = 1f;
        if(v2 > v0) {
            return v0;
        }

        return v2;
    }

    static final Unit LinearProgressIndicator_GJbTh5U$lambda$7$lambda$6(Function0 arg7, SemanticsPropertyReceiver arg8) {
        Object v7 = arg7.invoke();
        if(!Float.isNaN(v7.floatValue())) {
        }
        else {
            v7 = null;
        }

        float v2 = v7 != null ? ((Float)v7).floatValue() : 0f;
        SemanticsPropertiesKt.setProgressBarRangeInfo(arg8, new ProgressBarRangeInfo(v2, RangesKt.rangeTo(0f, 1f), 0, 4, null));
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator_GJbTh5U$lambda$9$lambda$8(int arg8, float arg9, Function0 arg10, long arg11, long arg13, Function1 arg15, DrawScope arg16) {
        DrawScope v0 = arg16;
        long v3 = 0xFFFFFFFFL;
        float v5 = Float.intBitsToFloat(((int)(v0.getSize-NH-jbRc() & v3)));
        int v2 = 0x20;
        if(!StrokeCap.equals-impl0(arg8, StrokeCap.Companion.getButt-KaPHkGw())) {
            if(Float.intBitsToFloat(((int)(v3 & v0.getSize-NH-jbRc()))) > Float.intBitsToFloat(((int)(v0.getSize-NH-jbRc() >> v2)))) {
            }
            else {
                arg9 = Dp.constructor-impl(arg9 + v0.toDp-u2uoSUM(v5));
            }
        }

        arg9 /= v0.toDp-u2uoSUM(Float.intBitsToFloat(((int)(v0.getSize-NH-jbRc() >> v2))));
        float v10 = arg10.invoke().floatValue();
        float v1 = v10 + Math.min(v10, arg9);
        if(v1 <= 1f) {
            ProgressIndicatorKt.drawLinearIndicator-qYKTg0g(v0, v1, 1f, arg11, v5, arg8);
        }

        ProgressIndicatorKt.drawLinearIndicator-qYKTg0g(arg16, 0f, v10, arg13, v5, arg8);
        arg15.invoke(arg16);
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator_RIQooxk$lambda$19(Modifier arg8, long arg9, long arg11, int arg13, int arg14, Composer arg15, int arg16) {
        ProgressIndicatorKt.LinearProgressIndicator-RIQooxk(arg8, arg9, arg11, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator__5eSR_E$lambda$0(Function0 arg11, Modifier arg12, long arg13, long arg15, int arg17, int arg18, int arg19, Composer arg20, int arg21) {
        ProgressIndicatorKt.LinearProgressIndicator-_5eSR-E(arg11, arg12, arg13, arg15, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    static final float LinearProgressIndicator__5eSR_E$lambda$16$lambda$15(float arg0) {
        return arg0;
    }

    static final Unit LinearProgressIndicator__5eSR_E$lambda$17(float arg11, Modifier arg12, long arg13, long arg15, int arg17, int arg18, int arg19, Composer arg20, int arg21) {
        ProgressIndicatorKt.LinearProgressIndicator-_5eSR-E(arg11, arg12, arg13, arg15, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator_eaDK9VM$lambda$18(float arg10, Modifier arg11, long arg12, long arg14, int arg16, int arg17, Composer arg18, int arg19) {
        ProgressIndicatorKt.LinearProgressIndicator-eaDK9VM(arg10, arg11, arg12, arg14, arg18, RecomposeScopeImplKt.updateChangedFlags(arg16 | 1), arg17);
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator_rIrjwxo$lambda$13$lambda$12(int arg9, float arg10, State arg11, long arg12, State arg14, long arg15, State arg17, State arg18, DrawScope arg19) {
        float v1;
        DrawScope v0 = arg19;
        long v3 = 0xFFFFFFFFL;
        float v5 = Float.intBitsToFloat(((int)(v0.getSize-NH-jbRc() & v3)));
        int v2 = 0x20;
        if(!StrokeCap.equals-impl0(arg9, StrokeCap.Companion.getButt-KaPHkGw())) {
            if(Float.intBitsToFloat(((int)(v3 & v0.getSize-NH-jbRc()))) > Float.intBitsToFloat(((int)(v0.getSize-NH-jbRc() >> v2)))) {
            }
            else {
                arg10 = Dp.constructor-impl(arg10 + v0.toDp-u2uoSUM(v5));
            }
        }

        arg10 /= v0.toDp-u2uoSUM(Float.intBitsToFloat(((int)(v0.getSize-NH-jbRc() >> v2))));
        float v7 = 1f;
        if(Float.compare(arg11.getValue().floatValue(), v7 - arg10) < 0) {
            v1 = arg11.getValue().floatValue() > 0f ? arg11.getValue().floatValue() + arg10 : 0f;
            ProgressIndicatorKt.drawLinearIndicator-qYKTg0g(v0, v1, 1f, arg12, v5, arg9);
        }

        if(arg11.getValue().floatValue() - arg14.getValue().floatValue() > 0f) {
            ProgressIndicatorKt.drawLinearIndicator-qYKTg0g(arg19, arg11.getValue().floatValue(), arg14.getValue().floatValue(), arg15, v5, arg9);
        }

        if(arg14.getValue().floatValue() > arg10) {
            v1 = arg17.getValue().floatValue() > 0f ? arg17.getValue().floatValue() + arg10 : 0f;
            float v2_1 = arg14.getValue().floatValue() < v7 ? arg14.getValue().floatValue() - arg10 : v7;
            ProgressIndicatorKt.drawLinearIndicator-qYKTg0g(arg19, v1, v2_1, arg12, v5, arg9);
        }

        if(arg17.getValue().floatValue() - arg18.getValue().floatValue() > 0f) {
            ProgressIndicatorKt.drawLinearIndicator-qYKTg0g(arg19, arg17.getValue().floatValue(), arg18.getValue().floatValue(), arg15, v5, arg9);
        }

        if(arg18.getValue().floatValue() > arg10) {
            if(arg18.getValue().floatValue() < v7) {
                v7 = arg18.getValue().floatValue() - arg10;
            }

            ProgressIndicatorKt.drawLinearIndicator-qYKTg0g(arg19, 0f, v7, arg12, v5, arg9);
        }

        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator_rIrjwxo$lambda$14(Modifier arg11, long arg12, long arg14, int arg16, float arg17, int arg18, int arg19, Composer arg20, int arg21) {
        ProgressIndicatorKt.LinearProgressIndicator-rIrjwxo(arg11, arg12, arg14, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    static final Unit _get_circularIndeterminateProgressAnimationSpec_$lambda$42(KeyframesSpecConfig arg3) {
        arg3.setDurationMillis(6000);
        arg3.using(arg3.at(Float.valueOf(0.87f), 3000), ProgressIndicatorKt.CircularProgressEasing);
        arg3.at(Float.valueOf(0.1f), 6000);
        return Unit.INSTANCE;
    }

    static final Unit _get_circularIndeterminateRotationAnimationSpec_$lambda$41(KeyframesSpecConfig arg4) {
        arg4.setDurationMillis(6000);
        Float v1 = Float.valueOf(90f);
        arg4.using(arg4.at(v1, 300), MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier());
        arg4.at(v1, 1500);
        v1 = Float.valueOf(180f);
        arg4.at(v1, 1800);
        arg4.at(v1, 3000);
        v1 = Float.valueOf(270f);
        arg4.at(v1, 3300);
        arg4.at(v1, 4500);
        v1 = Float.valueOf(360f);
        arg4.at(v1, 4800);
        arg4.at(v1, 6000);
        return Unit.INSTANCE;
    }

    static final Unit _get_linearIndeterminateFirstLineHeadAnimationSpec_$lambda$43(KeyframesSpecConfig arg2) {
        arg2.setDurationMillis(1750);
        arg2.using(arg2.at(Float.valueOf(0f), 0), ProgressIndicatorKt.LinearIndeterminateProgressEasing);
        arg2.at(Float.valueOf(1f), 1000);
        return Unit.INSTANCE;
    }

    static final Unit _get_linearIndeterminateFirstLineTailAnimationSpec_$lambda$44(KeyframesSpecConfig arg2) {
        arg2.setDurationMillis(1750);
        arg2.using(arg2.at(Float.valueOf(0f), 0xFA), ProgressIndicatorKt.LinearIndeterminateProgressEasing);
        arg2.at(Float.valueOf(1f), 1250);
        return Unit.INSTANCE;
    }

    static final Unit _get_linearIndeterminateSecondLineHeadAnimationSpec_$lambda$45(KeyframesSpecConfig arg2) {
        arg2.setDurationMillis(1750);
        arg2.using(arg2.at(Float.valueOf(0f), 650), ProgressIndicatorKt.LinearIndeterminateProgressEasing);
        arg2.at(Float.valueOf(1f), 1500);
        return Unit.INSTANCE;
    }

    static final Unit _get_linearIndeterminateSecondLineTailAnimationSpec_$lambda$46(KeyframesSpecConfig arg3) {
        arg3.setDurationMillis(1750);
        arg3.using(arg3.at(Float.valueOf(0f), 900), ProgressIndicatorKt.LinearIndeterminateProgressEasing);
        arg3.at(Float.valueOf(1f), 1750);
        return Unit.INSTANCE;
    }

    private static final void drawCircularIndicator-42QJj7c(DrawScope arg25, float arg26, float arg27, long arg28, Stroke arg30) {
        float v0 = arg30.getWidth() / 2f;
        float v2 = Float.intBitsToFloat(((int)(arg25.getSize-NH-jbRc() >> 0x20))) - 2f * v0;
        DrawScope.drawArc-yD3GUKo$default(arg25, arg28, arg26, arg27, false, Offset.constructor-impl((((long)Float.floatToRawIntBits(v0))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v0))) << 0x20), Size.constructor-impl((((long)Float.floatToRawIntBits(v2))) << 0x20 | (((long)Float.floatToRawIntBits(v2))) & 0xFFFFFFFFL), 0f, arg30, null, 0, 0x340, null);
    }

    private static final void drawCircularIndicatorTrack-bw27NRU(DrawScope arg6, long arg7, Stroke arg9) {
        ProgressIndicatorKt.drawCircularIndicator-42QJj7c(arg6, 0f, 360f, arg7, arg9);
    }

    private static final void drawDeterminateCircularIndicator-42QJj7c(DrawScope arg0, float arg1, float arg2, long arg3, Stroke arg5) {
        ProgressIndicatorKt.drawCircularIndicator-42QJj7c(arg0, arg1, arg2, arg3, arg5);
    }

    private static final void drawIndeterminateCircularIndicator-hrjfTZI(DrawScope arg6, float arg7, float arg8, float arg9, long arg10, Stroke arg12) {
        arg8 = StrokeCap.equals-impl0(arg12.getCap-KaPHkGw(), StrokeCap.Companion.getButt-KaPHkGw()) ? 0f : arg8 / Dp.constructor-impl(ProgressIndicatorKt.CircularIndicatorDiameter / 2f) * 57.29578f / 2f;
        ProgressIndicatorKt.drawCircularIndicator-42QJj7c(arg6, arg7 + arg8, Math.max(arg9, 0.1f), arg10, arg12);
    }

    private static final void drawLinearIndicator-qYKTg0g(DrawScope arg40, float arg41, float arg42, long arg43, float arg45, int arg46) {
        int v2 = 0x20;
        float v0 = Float.intBitsToFloat(((int)(arg40.getSize-NH-jbRc() >> v2)));
        long v5 = 0xFFFFFFFFL;
        float v1 = Float.intBitsToFloat(((int)(arg40.getSize-NH-jbRc() & v5)));
        float v3 = 2f;
        float v4 = v1 / v3;
        int v7 = arg40.getLayoutDirection() == LayoutDirection.Ltr ? 1 : 0;
        float v8 = 1f;
        float v9 = v7 != 0 ? arg41 : v8 - arg42;
        v9 *= v0;
        if(v7 != 0) {
            v8 = arg42;
        }
        else {
            v8 -= arg41;
        }

        v8 *= v0;
        int v10 = arg46;
        if(!StrokeCap.equals-impl0(v10, StrokeCap.Companion.getButt-KaPHkGw())) {
            if(v1 > v0) {
            }
            else {
                v1 = arg45 / v3;
                v0 -= v1;
                if(v9 < v1) {
                    v9 = v1;
                }

                if(v9 > v0) {
                    v9 = v0;
                }

                if(v8 < v1) {
                    v8 = v1;
                }

                if(v8 > v0) {
                }
                else {
                    v0 = v8;
                }

                if(Math.abs(arg42 - arg41) > 0f) {
                    DrawScope.drawLine-NGM6Ib0$default(arg40, arg43, Offset.constructor-impl((((long)Float.floatToRawIntBits(v9))) << v2 | (((long)Float.floatToRawIntBits(v4))) & v5), Offset.constructor-impl((((long)Float.floatToRawIntBits(v0))) << v2 | (((long)Float.floatToRawIntBits(v4))) & v5), arg45, v10, null, 0f, null, 0, 480, null);
                }

                return;
            }
        }

        DrawScope.drawLine-NGM6Ib0$default(arg40, arg43, Offset.constructor-impl((((long)Float.floatToRawIntBits(v9))) << v2 | (((long)Float.floatToRawIntBits(v4))) & v5), Offset.constructor-impl((((long)Float.floatToRawIntBits(v8))) << v2 | (((long)Float.floatToRawIntBits(v4))) & v5), arg45, 0, null, 0f, null, 0, 0x1F0, null);
    }

    public static final InfiniteRepeatableSpec getCircularIndeterminateGlobalRotationAnimationSpec() {
        return AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(6000, 0, EasingKt.getLinearEasing(), 2, null), null, 0, 6, null);
    }

    public static final InfiniteRepeatableSpec getCircularIndeterminateProgressAnimationSpec() {
        return AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new ProgressIndicatorKt$$ExternalSyntheticLambda13()), null, 0, 6, null);
    }

    public static final InfiniteRepeatableSpec getCircularIndeterminateRotationAnimationSpec() {
        return AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new ProgressIndicatorKt$$ExternalSyntheticLambda15()), null, 0, 6, null);
    }

    public static final float getCircularIndicatorDiameter() {
        return ProgressIndicatorKt.CircularIndicatorDiameter;
    }

    public static final CubicBezierEasing getCircularProgressEasing() {
        return ProgressIndicatorKt.CircularProgressEasing;
    }

    public static final InfiniteRepeatableSpec getLinearIndeterminateFirstLineHeadAnimationSpec() {
        return AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new ProgressIndicatorKt$$ExternalSyntheticLambda0()), null, 0, 6, null);
    }

    public static final InfiniteRepeatableSpec getLinearIndeterminateFirstLineTailAnimationSpec() {
        return AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new ProgressIndicatorKt$$ExternalSyntheticLambda9()), null, 0, 6, null);
    }

    public static final CubicBezierEasing getLinearIndeterminateProgressEasing() {
        return ProgressIndicatorKt.LinearIndeterminateProgressEasing;
    }

    public static final InfiniteRepeatableSpec getLinearIndeterminateSecondLineHeadAnimationSpec() {
        return AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new ProgressIndicatorKt$$ExternalSyntheticLambda17()), null, 0, 6, null);
    }

    public static final InfiniteRepeatableSpec getLinearIndeterminateSecondLineTailAnimationSpec() {
        return AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new ProgressIndicatorKt$$ExternalSyntheticLambda19()), null, 0, 6, null);
    }

    public static final float getLinearIndicatorHeight() {
        return ProgressIndicatorKt.LinearIndicatorHeight;
    }

    public static final float getLinearIndicatorWidth() {
        return ProgressIndicatorKt.LinearIndicatorWidth;
    }

    public static final float getStopIndicatorTrailingSpace() {
        return ProgressIndicatorKt.StopIndicatorTrailingSpace;
    }
}

