package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition$DeferredAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000¬\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0080\u0004\u001A\u0015\u0010\u0000\u001A\u00020\u0004*\u00020\u00042\u0006\u0010\u0002\u001A\u00020\u0003H\u0080\u0004\u001A\"\u0010\u0005\u001A\u00020\u00012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001A\u00020\bH\u0007\u001A\"\u0010\n\u001A\u00020\u00042\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000B\u001A\u00020\bH\u0007\u001A;\u0010\f\u001A\u00020\u00012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\r0\u00072!\u0010\u000E\u001A\u001D\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000FH\u0007\u001A;\u0010\u0014\u001A\u00020\u00042\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\r0\u00072!\u0010\u0015\u001A\u001D\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000FH\u0007\u001A3\u0010\u0016\u001A\u00020\u00012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u0017\u001A\u00020\b2\b\b\u0002\u0010\u0018\u001A\u00020\u0019H\u0007¢\u0006\u0004\b\u001A\u0010\u001B\u001A3\u0010\u001C\u001A\u00020\u00042\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u001D\u001A\u00020\b2\b\b\u0002\u0010\u0018\u001A\u00020\u0019H\u0007¢\u0006\u0004\b\u001E\u0010\u001F\u001A3\u0010 \u001A\u00020\u00012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020!0\u00072\b\b\u0002\u0010\"\u001A\u00020!2\b\b\u0002\u0010#\u001A\u00020$H\u0007¢\u0006\u0004\b%\u0010&\u001A3\u0010\'\u001A\u00020\u00042\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020!0\u00072\b\b\u0002\u0010(\u001A\u00020!2\b\b\u0002\u0010#\u001A\u00020$H\u0007¢\u0006\u0004\b)\u0010*\u001AQ\u0010+\u001A\u00020\u00012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010,\u001A\u00020-2\b\b\u0002\u0010.\u001A\u00020$2#\b\u0002\u0010/\u001A\u001D\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000FH\u0007\u001AQ\u00100\u001A\u00020\u00042\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u00101\u001A\u00020-2\b\b\u0002\u0010.\u001A\u00020$2#\b\u0002\u00102\u001A\u001D\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000FH\u0007\u001AQ\u00103\u001A\u00020\u00012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010,\u001A\u0002042\b\b\u0002\u0010.\u001A\u00020$2#\b\u0002\u00105\u001A\u001D\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002060\u000FH\u0007\u001AQ\u00108\u001A\u00020\u00012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010,\u001A\u0002092\b\b\u0002\u0010.\u001A\u00020$2#\b\u0002\u0010:\u001A\u001D\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0004\u0012\u0002060\u000FH\u0007\u001AQ\u0010<\u001A\u00020\u00042\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u00101\u001A\u0002042\b\b\u0002\u0010.\u001A\u00020$2#\b\u0002\u0010=\u001A\u001D\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002060\u000FH\u0007\u001AQ\u0010>\u001A\u00020\u00042\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u00101\u001A\u0002092\b\b\u0002\u0010.\u001A\u00020$2#\b\u0002\u0010?\u001A\u001D\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0004\u0012\u0002060\u000FH\u0007\u001A=\u0010@\u001A\u00020\u00012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\r0\u00072#\b\u0002\u0010A\u001A\u001D\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002060\u000FH\u0007\u001A=\u0010B\u001A\u00020\u00012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\r0\u00072#\b\u0002\u0010C\u001A\u001D\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0004\u0012\u0002060\u000FH\u0007\u001A=\u0010D\u001A\u00020\u00042\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\r0\u00072#\b\u0002\u0010E\u001A\u001D\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002060\u000FH\u0007\u001A=\u0010F\u001A\u00020\u00042\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\r0\u00072#\b\u0002\u0010G\u001A\u001D\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0004\u0012\u0002060\u000FH\u0007\u001A\f\u0010H\u001A\u00020-*\u000204H\u0002\u001A\f\u0010H\u001A\u00020-*\u000209H\u0002\u001A,\u0010I\u001A\u0004\u0018\u0001HJ\"\b\b\u0000\u0010J*\u00020\u0003*\u00020\u00012\f\u0010K\u001A\b\u0012\u0004\u0012\u0002HJ0LH\u0080\u0002¢\u0006\u0002\u0010M\u001A,\u0010I\u001A\u0004\u0018\u0001HJ\"\b\b\u0000\u0010J*\u00020\u0003*\u00020\u00042\f\u0010K\u001A\b\u0012\u0004\u0012\u0002HJ0LH\u0080\u0002¢\u0006\u0002\u0010N\u001A?\u0010O\u001A\u00020P*\b\u0012\u0004\u0012\u00020R0Q2\u0006\u0010S\u001A\u00020\u00012\u0006\u0010T\u001A\u00020\u00042\u000E\b\u0002\u0010U\u001A\b\u0012\u0004\u0012\u00020$0V2\u0006\u0010W\u001A\u00020XH\u0001¢\u0006\u0002\u0010Y\u001A\u001F\u0010Z\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020R0Q2\u0006\u0010S\u001A\u00020\u0001H\u0001¢\u0006\u0002\u0010[\u001A\u001F\u0010\\\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020R0Q2\u0006\u0010T\u001A\u00020\u0004H\u0001¢\u0006\u0002\u0010]\u001A/\u0010^\u001A\u00020_*\b\u0012\u0004\u0012\u00020R0Q2\u0006\u0010S\u001A\u00020\u00012\u0006\u0010T\u001A\u00020\u00042\u0006\u0010W\u001A\u00020XH\u0003¢\u0006\u0002\u0010`\"\u001A\u0010a\u001A\u000E\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020c0bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010d\u001A\b\u0012\u0004\u0012\u00020\b0eX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010f\u001A\b\u0012\u0004\u0012\u00020!0eX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010g\u001A\b\u0012\u0004\u0012\u00020\r0eX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010h\u001A\b\u0012\u0004\u0012\u00020\u00100eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006i²\u0006\n\u0010j\u001A\u00020\u0001X\u008A\u008E\u0002²\u0006\n\u0010k\u001A\u00020\u0004X\u008A\u008E\u0002"}, d2={"withEffect", "Landroidx/compose/animation/EnterTransition;", "effect", "Landroidx/compose/animation/TransitionEffect;", "Landroidx/compose/animation/ExitTransition;", "fadeIn", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "initialAlpha", "fadeOut", "targetAlpha", "slideIn", "Landroidx/compose/ui/unit/IntOffset;", "initialOffset", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "fullSize", "slideOut", "targetOffset", "scaleIn", "initialScale", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleOut", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "unveilIn", "Landroidx/compose/ui/graphics/Color;", "initialColor", "matchParentSize", "", "unveilIn-bw27NRU", "(Landroidx/compose/animation/core/FiniteAnimationSpec;JZ)Landroidx/compose/animation/EnterTransition;", "veilOut", "targetColor", "veilOut-bw27NRU", "(Landroidx/compose/animation/core/FiniteAnimationSpec;JZ)Landroidx/compose/animation/ExitTransition;", "expandIn", "expandFrom", "Landroidx/compose/ui/Alignment;", "clip", "initialSize", "shrinkOut", "shrinkTowards", "targetSize", "expandHorizontally", "Landroidx/compose/ui/Alignment$Horizontal;", "initialWidth", "", "fullWidth", "expandVertically", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "fullHeight", "shrinkHorizontally", "targetWidth", "shrinkVertically", "targetHeight", "slideInHorizontally", "initialOffsetX", "slideInVertically", "initialOffsetY", "slideOutHorizontally", "targetOffsetX", "slideOutVertically", "targetOffsetY", "toAlignment", "get", "T", "key", "Landroidx/compose/animation/TransitionEffectKey;", "(Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/TransitionEffectKey;)Landroidx/compose/animation/TransitionEffect;", "(Landroidx/compose/animation/ExitTransition;Landroidx/compose/animation/TransitionEffectKey;)Landroidx/compose/animation/TransitionEffect;", "createModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "isEnabled", "Lkotlin/Function0;", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "trackActiveEnter", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "trackActiveExit", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/ExitTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "createGraphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/animation/core/AnimationVector2D;", "DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "DefaultColorAnimationSpec", "DefaultOffsetAnimationSpec", "DefaultSizeAnimationSpec", "animation", "activeEnter", "activeExit"}, k=2, mv={2, 0, 0}, xi=0x30) public final class EnterExitTransitionKt {
    private static final SpringSpec DefaultAlphaAndScaleSpring;
    private static final SpringSpec DefaultColorAnimationSpec;
    private static final SpringSpec DefaultOffsetAnimationSpec;
    private static final SpringSpec DefaultSizeAnimationSpec;
    private static final TwoWayConverter TransformOriginVectorConverter;

    public static Function1 $r8$lambda$IsnwG04bc30lhOT0dz7f2KRJk-w(DeferredAnimation arg0, DeferredAnimation arg1, Transition arg2, EnterTransition arg3, ExitTransition arg4, DeferredAnimation arg5) {
        return EnterExitTransitionKt.createGraphicsLayerBlock$lambda$2$0(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    static {
        EnterExitTransitionKt.TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(EnterExitTransitionKt$TransformOriginVectorConverter$1.INSTANCE, EnterExitTransitionKt$TransformOriginVectorConverter$2.INSTANCE);
        EnterExitTransitionKt.DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0f, 400f, null, 5, null);
        EnterExitTransitionKt.DefaultColorAnimationSpec = AnimationSpecKt.spring$default(0f, 400f, null, 5, null);
        EnterExitTransitionKt.DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0f, 400f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        EnterExitTransitionKt.DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0f, 400f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
    }

    public static final SpringSpec access$getDefaultAlphaAndScaleSpring$p() {
        return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
    }

    public static final SpringSpec access$getDefaultColorAnimationSpec$p() {
        return EnterExitTransitionKt.DefaultColorAnimationSpec;
    }

    public static final SpringSpec access$getDefaultOffsetAnimationSpec$p() {
        return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
    }

    public static final SpringSpec access$getDefaultSizeAnimationSpec$p() {
        return EnterExitTransitionKt.DefaultSizeAnimationSpec;
    }

    private static final GraphicsLayerBlockForEnterExit createGraphicsLayerBlock(Transition arg20, EnterTransition arg21, ExitTransition arg22, String arg23, Composer arg24, int arg25) {
        EnterExitTransitionKt$$ExternalSyntheticLambda0 v5_2;
        Transition v4_1;
        ExitTransition v2_5;
        EnterTransition v1_5;
        DeferredAnimation v12_1;
        Object v15_1;
        String v2_4;
        DeferredAnimation v14;
        String v1_2;
        String v0 = arg23;
        Composer v3 = arg24;
        int v7 = arg25;
        int v2 = 0x264802D5;
        ComposerKt.sourceInformationMarkerStart(v3, v2, "C(createGraphicsLayerBlock)1084@47699L3043:EnterExitTransition.kt#xbi5r1");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v7, -1, "androidx.compose.animation.createGraphicsLayerBlock (EnterExitTransition.kt:1052)");
        }

        int v8 = 0;
        int v1 = arg21.getData$animation().getFade() != null || arg22.getData$animation().getFade() != null ? 1 : 0;
        int v10 = arg21.getData$animation().getScale() != null || arg22.getData$animation().getScale() != null ? 1 : 0;
        String v11 = "CC(remember):EnterExitTransition.kt#9igjgp";
        Object v12 = null;
        if(v1 != 0) {
            v3.startReplaceGroup(0xD60BA703);
            ComposerKt.sourceInformation(v3, "1064@47133L27,1062@47029L146");
            TwoWayConverter v2_1 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(v3, 0xB4530310, v11);
            Object v1_1 = v3.rememberedValue();
            if(v1_1 == Composer.Companion.getEmpty()) {
                v1_2 = v0 + " alpha";
                v3.updateRememberedValue(v1_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            DeferredAnimation v2_2 = TransitionKt.createDeferredAnimation(arg20, v2_1, v1_2, v3, v7 & 14 | 0x180, 0);
            v3 = v3;
            v3.endReplaceGroup();
            v14 = v2_2;
        }
        else {
            v3.startReplaceGroup(-703709976);
            v3.endReplaceGroup();
            Object v14_1 = v12;
        }

        if(v10 != 0) {
            v3.startReplaceGroup(0xD60F4523);
            ComposerKt.sourceInformation(v3, "1072@47372L27,1070@47268L146");
            TwoWayConverter v1_3 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(v3, 0xB45320F0, v11);
            Object v2_3 = v3.rememberedValue();
            if(v2_3 == Composer.Companion.getEmpty()) {
                v2_4 = v0 + " scale";
                v3.updateRememberedValue(v2_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            DeferredAnimation v1_4 = TransitionKt.createDeferredAnimation(arg20, v1_3, v2_4, v3, v7 & 14 | 0x180, 0);
            v3.endReplaceGroup();
            DeferredAnimation v15 = v1_4;
        }
        else {
            v3.startReplaceGroup(0xD611DB08);
            v3.endReplaceGroup();
            v15_1 = v12;
        }

        if(v10 != 0) {
            v3.startReplaceGroup(0xD6130A60);
            ComposerKt.sourceInformation(v3, "1078@47517L149");
            v12_1 = TransitionKt.createDeferredAnimation(arg20, EnterExitTransitionKt.TransformOriginVectorConverter, "TransformOriginInterruptionHandling", v3, v7 & 14 | 0x180, 0);
            v3.endReplaceGroup();
        }
        else {
            v3.startReplaceGroup(-703222904);
            v3.endReplaceGroup();
        }

        ComposerKt.sourceInformationMarkerStart(v3, -1269607016, v11);
        boolean v0_1 = v3.changedInstance(v14);
        v2 = 0x20;
        if((v7 & 0x70 ^ 0x30) > v2) {
            v1_5 = arg21;
            if(!v3.changed(v1_5)) {
                goto label_133;
            }
            else {
                goto label_135;
            }
        }
        else {
            v1_5 = arg21;
        label_133:
            if((v7 & 0x30) == v2) {
            label_135:
                v2 = 1;
            }
            else {
                v2 = 0;
            }
        }

        int v0_2 = (((int)v0_1)) | v2;
        int v4 = 0x100;
        if((v7 & 0x380 ^ 0x180) > v4) {
            v2_5 = arg22;
            if(!v3.changed(v2_5)) {
                goto label_148;
            }
            else {
                goto label_150;
            }
        }
        else {
            v2_5 = arg22;
        label_148:
            if((v7 & 0x180) == v4) {
            label_150:
                v4 = 1;
            }
            else {
                v4 = 0;
            }
        }

        v0_2 = v0_2 | v4 | v3.changedInstance(v15_1);
        int v5 = 4;
        if((v7 & 14 ^ 6) > v5) {
            v4_1 = arg20;
            if(!v3.changed(v4_1)) {
                goto label_165;
            }
            else {
                goto label_167;
            }
        }
        else {
            v4_1 = arg20;
        label_165:
            if((v7 & 6) == v5) {
            label_167:
                v8 = 1;
            }
        }

        v0_2 = v0_2 | v8 | v3.changedInstance(v12_1);
        Object v5_1 = v3.rememberedValue();
        if(v0_2 != 0 || v5_1 == Composer.Companion.getEmpty()) {
            EnterExitTransitionKt$$ExternalSyntheticLambda0 v13 = new EnterExitTransitionKt$$ExternalSyntheticLambda0(v14, ((DeferredAnimation)v15_1), v4_1, v1_5, v2_5, v12_1);
            v3.updateRememberedValue(v13);
            v5_2 = v13;
        }

        ComposerKt.sourceInformationMarkerEnd(v3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v3);
        return ((GraphicsLayerBlockForEnterExit)v5_2);
    }

    private static final Function1 createGraphicsLayerBlock$lambda$2$0(DeferredAnimation arg3, DeferredAnimation arg4, Transition arg5, EnterTransition arg6, ExitTransition arg7, DeferredAnimation arg8) {
        TransformOrigin v5_1;
        Scale v5;
        State v0 = null;
        State v3 = arg3 != null ? arg3.animate(new EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1(arg6, arg7), new EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$2(arg6, arg7)) : v0;
        State v4 = arg4 != null ? arg4.animate(new EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1(arg6, arg7), new EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$2(arg6, arg7)) : v0;
        if(arg5.getCurrentState() == EnterExitState.PreEnter) {
            v5 = arg6.getData$animation().getScale();
            if(v5 == null) {
                v5 = arg7.getData$animation().getScale();
                if(v5 != null) {
                }
                else {
                    goto label_40;
                }
            }

            v5_1 = TransformOrigin.box-impl(v5.getTransformOrigin-SzJe1aQ());
        }
        else {
            v5 = arg7.getData$animation().getScale();
            if(v5 == null) {
                v5 = arg6.getData$animation().getScale();
                if(v5 != null) {
                }
                else {
                    goto label_40;
                }
            }

            v5_1 = TransformOrigin.box-impl(v5.getTransformOrigin-SzJe1aQ());
            goto label_41;
        label_40:
            v5_1 = ((TransformOrigin)v0);
        }

    label_41:
        if(arg8 != null) {
            v0 = arg8.animate(EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.INSTANCE, new EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2(v5_1, arg6, arg7));
        }

        return new EnterExitTransitionKt$createGraphicsLayerBlock$1$1$block$1(v3, v4, v0);
    }

    public static final Modifier createModifier(Transition arg22, EnterTransition arg23, ExitTransition arg24, Function0 arg25, String arg26, Composer arg27, int arg28, int arg29) {
        Companion v16_2;
        Companion v0_6;
        VeilModifierElement v2_3;
        boolean v14;
        Rgb v1_7;
        ColorSpace v1_6;
        boolean v0_4;
        DeferredAnimation v21;
        DeferredAnimation v20;
        String v0_2;
        Object v0_1;
        DeferredAnimation v19;
        DeferredAnimation v1_4;
        String v2_2;
        Object v2_1;
        TwoWayConverter v1_3;
        Object v9;
        Object v1;
        Transition v0 = arg22;
        String v6 = arg26;
        Composer v3 = arg27;
        int v7 = arg28;
        int v2 = 0x1AF3D96;
        ComposerKt.sourceInformationMarkerStart(v3, v2, "C(createModifier)931@41585L8,934@41650L31,935@41703L28,985@43657L56,987@43829L38:EnterExitTransition.kt#xbi5r1");
        String v8 = "CC(remember):EnterExitTransition.kt#9igjgp";
        if((arg29 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(v3, 0x52D6409E, v8);
            v1 = v3.rememberedValue();
            if(v1 == Composer.Companion.getEmpty()) {
                EnterExitTransitionKt$createModifier$1$1 v1_1 = EnterExitTransitionKt$createModifier$1$1.INSTANCE;
                v3.updateRememberedValue(v1_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            v9 = v1;
        }
        else {
            Function0 v9_1 = arg25;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v7, -1, "androidx.compose.animation.createModifier (EnterExitTransition.kt:933)");
        }

        int v10 = v7 & 14;
        EnterTransition v11 = EnterExitTransitionKt.trackActiveEnter(v0, arg23, v3, v7 & 0x7E);
        int v12 = v7 >> 3;
        ExitTransition v13 = EnterExitTransitionKt.trackActiveExit(v0, arg24, v3, v12 & 0x70 | v10);
        int v15 = 0;
        int v16 = v11.getData$animation().getVeil() != null || v13.getData$animation().getVeil() != null ? 1 : 0;
        int v1_2 = v11.getData$animation().getSlide() != null || v13.getData$animation().getSlide() != null ? 1 : 0;
        int v17 = v11.getData$animation().getChangeSize() != null || v13.getData$animation().getChangeSize() != null ? 1 : 0;
        ColorSpace v18 = null;
        if(v1_2 != 0) {
            v3.startReplaceGroup(0x7F98385);
            ComposerKt.sourceInformation(v3, "944@42155L27,944@42104L79");
            v1_3 = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
            ComposerKt.sourceInformationMarkerStart(v3, 0x52D687F1, v8);
            v2_1 = v3.rememberedValue();
            if(v2_1 == Composer.Companion.getEmpty()) {
                v2_2 = v6 + " slide";
                v3.updateRememberedValue(v2_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            v1_4 = TransitionKt.createDeferredAnimation(v0, v1_3, v2_2, v3, v10 | 0x180, 0);
            v3.endReplaceGroup();
            v19 = v1_4;
        }
        else {
            v3.startReplaceGroup(0x7FB20D0);
            v3.endReplaceGroup();
            v19 = ((DeferredAnimation)v18);
        }

        if(v17 != 0) {
            v3.startReplaceGroup(0x7FC875F);
            ComposerKt.sourceInformation(v3, "950@42352L35,950@42303L85");
            v1_3 = VectorConvertersKt.getVectorConverter(IntSize.Companion);
            ComposerKt.sourceInformationMarkerStart(v3, 0x52D6A099, v8);
            v0_1 = v3.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = v6 + " shrink/expand";
                v3.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            v1_4 = TransitionKt.createDeferredAnimation(arg22, v1_3, v0_1, v3, v10 | 0x180, 0);
            v3.endReplaceGroup();
            v20 = v1_4;
        }
        else {
            v3.startReplaceGroup(134101063);
            v3.endReplaceGroup();
            v20 = ((DeferredAnimation)v18);
        }

        if(v17 != 0) {
            v3.startReplaceGroup(0x7FF57E1);
            ComposerKt.sourceInformation(v3, "957@42571L48,955@42487L147");
            v1_3 = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
            ComposerKt.sourceInformationMarkerStart(v3, 1389804550, v8);
            v0_1 = v3.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = v6 + " InterruptionHandlingOffset";
                v3.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            v1_4 = TransitionKt.createDeferredAnimation(arg22, v1_3, v0_1, v3, v10 | 0x180, 0);
            v3.endReplaceGroup();
            v21 = v1_4;
        }
        else {
            v3.startReplaceGroup(0x801F187);
            v3.endReplaceGroup();
            v21 = ((DeferredAnimation)v18);
        }

        ChangeSize v0_3 = v11.getData$animation().getChangeSize();
        if(v0_3 == null || (v0_3.getClip())) {
            v0_3 = v13.getData$animation().getChangeSize();
            if(v0_3 != null && !v0_3.getClip()) {
                goto label_178;
            }

            if(v17 == 0) {
            label_178:
                v0_4 = true;
                goto label_181;
            }

            v0_4 = false;
        }
        else {
            goto label_178;
        }

    label_181:
        Veil v1_5 = v11.getData$animation().getVeil();
        if(v1_5 != null) {
            v1_6 = Color.getColorSpace-impl(v1_5.getInitialColor-0d7_KjU());
            if(v1_6 == null) {
                goto label_187;
            }
        }
        else {
        label_187:
            v1_5 = v11.getData$animation().getVeil();
            if(v1_5 != null) {
                v1_6 = Color.getColorSpace-impl(v1_5.getTargetColor-0d7_KjU());
            }
            else {
                v1_5 = v13.getData$animation().getVeil();
                v1_6 = v1_5 != null ? Color.getColorSpace-impl(v1_5.getInitialColor-0d7_KjU()) : v18;
                if(v1_6 != null) {
                    goto label_211;
                }

                v1_5 = v13.getData$animation().getVeil();
                if(v1_5 != null) {
                    v18 = Color.getColorSpace-impl(v1_5.getTargetColor-0d7_KjU());
                }

                if(v18 == null) {
                    v1_7 = ColorSpaces.INSTANCE.getSrgb();
                    goto label_211;
                }

                v1_6 = v18;
            }
        }

    label_211:
        if(v16 != 0) {
            v3.startReplaceGroup(0x809FA11);
            ComposerKt.sourceInformation(v3, "976@43322L26,974@43222L145");
            v1 = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(v1_7);
            ComposerKt.sourceInformationMarkerStart(v3, 0x52D719D0, v8);
            v2_1 = v3.rememberedValue();
            if(v2_1 == Composer.Companion.getEmpty()) {
                v2_2 = v6 + " veil";
                v3.updateRememberedValue(v2_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            v14 = v0_4;
            v0 = arg22;
            v2_3 = new VeilModifierElement(v0, TransitionKt.createDeferredAnimation(v0, ((TwoWayConverter)v1), v2_2, v3, v10 | 0x180, 0), v11, v13);
            v3.endReplaceGroup();
        }
        else {
            v14 = v0_4;
            v0 = arg22;
            v3.startReplaceGroup(0x80E3B8C);
            v3.endReplaceGroup();
            Companion v2_4 = Modifier.Companion;
        }

        VeilModifierElement v16_1 = v2_3;
        v1_5 = v11.getData$animation().getVeil();
        if(v1_5 == null) {
            v1_5 = v13.getData$animation().getVeil();
            if(v1_5 != null) {
                goto label_253;
            }
            else {
                goto label_260;
            }
        }
        else {
        label_253:
            boolean v17_1 = v1_5.getMatchParentSize();
            goto label_261;
        label_260:
            v17_1 = false;
        }

    label_261:
        Composer v4 = v3;
        EnterTransition v1_8 = v11;
        ExitTransition v2_5 = v13;
        GraphicsLayerBlockForEnterExit v3_1 = EnterExitTransitionKt.createGraphicsLayerBlock(v0, v1_8, v2_5, v6, v4, v10 | v12 & 0x1C00);
        Composer v10_1 = v4;
        if(v17_1) {
            VeilModifierElement v0_5 = v16_1;
        }
        else {
            v0_6 = Modifier.Companion;
        }

        Companion v4_1 = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart(v10_1, 0x52D7593C, v8);
        boolean v5 = v10_1.changed(v14);
        int v8_1 = 0x800;
        if((v7 & 0x1C00 ^ 0xC00) > v8_1 && (v10_1.changed(v9)) || (v7 & 0xC00) == v8_1) {
            v15 = 1;
        }

        Object v6_1 = v10_1.rememberedValue();
        if(((((int)v5)) | v15) != 0 || v6_1 == Composer.Companion.getEmpty()) {
            EnterExitTransitionKt$createModifier$2$1 v6_2 = new EnterExitTransitionKt$createModifier$2$1(v14, ((Function0)v9));
            v10_1.updateRememberedValue(v6_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v10_1);
        Modifier v0_7 = ((Modifier)v0_6).then(GraphicsLayerModifierKt.graphicsLayer(((Modifier)v4_1), ((Function1)v6_1))).then(new EnterExitTransitionElement(arg22, v20, v21, v19, v1_8, v2_5, v9, v3_1));
        if(!v17_1) {
        }
        else {
            v16_2 = Modifier.Companion;
        }

        v0_7 = v0_7.then(((VeilModifierElement)v16_2));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v10_1);
        return v0_7;
    }

    public static final EnterTransition expandHorizontally(FiniteAnimationSpec arg1, Horizontal arg2, boolean arg3, Function1 arg4) {
        return EnterExitTransitionKt.expandIn(arg1, EnterExitTransitionKt.toAlignment(arg2), arg3, new EnterExitTransitionKt$expandHorizontally$2(arg4));
    }

    public static EnterTransition expandHorizontally$default(FiniteAnimationSpec arg3, Horizontal arg4, boolean arg5, Function1 arg6, int arg7, Object arg8) {
        EnterExitTransitionKt$expandHorizontally$1 v6;
        SpringSpec v3;
        if((arg7 & 1) != 0) {
            v3 = AnimationSpecKt.spring$default(0f, 400f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }

        if((arg7 & 2) != 0) {
            arg4 = Alignment.Companion.getEnd();
        }

        if((arg7 & 8) != 0) {
            v6 = EnterExitTransitionKt$expandHorizontally$1.INSTANCE;
        }

        return EnterExitTransitionKt.expandHorizontally(((FiniteAnimationSpec)v3), arg4, true, ((Function1)v6));
    }

    public static final EnterTransition expandIn(FiniteAnimationSpec arg11, Alignment arg12, boolean arg13, Function1 arg14) {
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(arg12, arg14, arg11, arg13), null, null, false, null, 0x7B, null));
    }

    public static EnterTransition expandIn$default(FiniteAnimationSpec arg3, Alignment arg4, boolean arg5, Function1 arg6, int arg7, Object arg8) {
        EnterExitTransitionKt$expandIn$1 v6;
        SpringSpec v3;
        if((arg7 & 1) != 0) {
            v3 = AnimationSpecKt.spring$default(0f, 400f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }

        if((arg7 & 2) != 0) {
            arg4 = Alignment.Companion.getBottomEnd();
        }

        if((arg7 & 8) != 0) {
            v6 = EnterExitTransitionKt$expandIn$1.INSTANCE;
        }

        return EnterExitTransitionKt.expandIn(((FiniteAnimationSpec)v3), arg4, true, ((Function1)v6));
    }

    public static final EnterTransition expandVertically(FiniteAnimationSpec arg1, Vertical arg2, boolean arg3, Function1 arg4) {
        return EnterExitTransitionKt.expandIn(arg1, EnterExitTransitionKt.toAlignment(arg2), arg3, new EnterExitTransitionKt$expandVertically$2(arg4));
    }

    public static EnterTransition expandVertically$default(FiniteAnimationSpec arg3, Vertical arg4, boolean arg5, Function1 arg6, int arg7, Object arg8) {
        EnterExitTransitionKt$expandVertically$1 v6;
        SpringSpec v3;
        if((arg7 & 1) != 0) {
            v3 = AnimationSpecKt.spring$default(0f, 400f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }

        if((arg7 & 2) != 0) {
            arg4 = Alignment.Companion.getBottom();
        }

        if((arg7 & 8) != 0) {
            v6 = EnterExitTransitionKt$expandVertically$1.INSTANCE;
        }

        return EnterExitTransitionKt.expandVertically(((FiniteAnimationSpec)v3), arg4, true, ((Function1)v6));
    }

    public static final EnterTransition fadeIn(FiniteAnimationSpec arg11, float arg12) {
        return new EnterTransitionImpl(new TransitionData(new Fade(arg12, arg11), null, null, null, null, false, null, 0x7E, null));
    }

    public static EnterTransition fadeIn$default(FiniteAnimationSpec arg2, float arg3, int arg4, Object arg5) {
        SpringSpec v2;
        if((arg4 & 1) != 0) {
            v2 = AnimationSpecKt.spring$default(0f, 400f, null, 5, null);
        }

        return EnterExitTransitionKt.fadeIn(((FiniteAnimationSpec)v2), 0f);
    }

    public static final ExitTransition fadeOut(FiniteAnimationSpec arg11, float arg12) {
        return new ExitTransitionImpl(new TransitionData(new Fade(arg12, arg11), null, null, null, null, false, null, 0x7E, null));
    }

    public static ExitTransition fadeOut$default(FiniteAnimationSpec arg2, float arg3, int arg4, Object arg5) {
        SpringSpec v2;
        if((arg4 & 1) != 0) {
            v2 = AnimationSpecKt.spring$default(0f, 400f, null, 5, null);
        }

        return EnterExitTransitionKt.fadeOut(((FiniteAnimationSpec)v2), 0f);
    }

    public static final TransitionEffect get(EnterTransition arg0, TransitionEffectKey arg1) {
        Object v0 = arg0.getData$animation().getEffectsMap().get(arg1);
        if((v0 instanceof TransitionEffect)) {
            return ((TransitionEffect)v0);
        }

        return null;
    }

    public static final TransitionEffect get(ExitTransition arg0, TransitionEffectKey arg1) {
        Object v0 = arg0.getData$animation().getEffectsMap().get(arg1);
        if((v0 instanceof TransitionEffect)) {
            return ((TransitionEffect)v0);
        }

        return null;
    }

    public static final EnterTransition scaleIn-L8ZKh-E(FiniteAnimationSpec arg11, float arg12, long arg13) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(arg12, arg13, arg11, null), null, false, null, 0x77, null));
    }

    public static EnterTransition scaleIn-L8ZKh-E$default(FiniteAnimationSpec arg2, float arg3, long arg4, int arg6, Object arg7) {
        SpringSpec v2;
        if((arg6 & 1) != 0) {
            v2 = AnimationSpecKt.spring$default(0f, 400f, null, 5, null);
        }

        if((arg6 & 4) != 0) {
            arg4 = TransformOrigin.Companion.getCenter-SzJe1aQ();
        }

        return EnterExitTransitionKt.scaleIn-L8ZKh-E(((FiniteAnimationSpec)v2), 0f, arg4);
    }

    public static final ExitTransition scaleOut-L8ZKh-E(FiniteAnimationSpec arg11, float arg12, long arg13) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, new Scale(arg12, arg13, arg11, null), null, false, null, 0x77, null));
    }

    public static ExitTransition scaleOut-L8ZKh-E$default(FiniteAnimationSpec arg2, float arg3, long arg4, int arg6, Object arg7) {
        SpringSpec v2;
        if((arg6 & 1) != 0) {
            v2 = AnimationSpecKt.spring$default(0f, 400f, null, 5, null);
        }

        if((arg6 & 4) != 0) {
            arg4 = TransformOrigin.Companion.getCenter-SzJe1aQ();
        }

        return EnterExitTransitionKt.scaleOut-L8ZKh-E(((FiniteAnimationSpec)v2), 0f, arg4);
    }

    public static final ExitTransition shrinkHorizontally(FiniteAnimationSpec arg1, Horizontal arg2, boolean arg3, Function1 arg4) {
        return EnterExitTransitionKt.shrinkOut(arg1, EnterExitTransitionKt.toAlignment(arg2), arg3, new EnterExitTransitionKt$shrinkHorizontally$2(arg4));
    }

    public static ExitTransition shrinkHorizontally$default(FiniteAnimationSpec arg3, Horizontal arg4, boolean arg5, Function1 arg6, int arg7, Object arg8) {
        EnterExitTransitionKt$shrinkHorizontally$1 v6;
        SpringSpec v3;
        if((arg7 & 1) != 0) {
            v3 = AnimationSpecKt.spring$default(0f, 400f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }

        if((arg7 & 2) != 0) {
            arg4 = Alignment.Companion.getEnd();
        }

        if((arg7 & 8) != 0) {
            v6 = EnterExitTransitionKt$shrinkHorizontally$1.INSTANCE;
        }

        return EnterExitTransitionKt.shrinkHorizontally(((FiniteAnimationSpec)v3), arg4, true, ((Function1)v6));
    }

    public static final ExitTransition shrinkOut(FiniteAnimationSpec arg11, Alignment arg12, boolean arg13, Function1 arg14) {
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(arg12, arg14, arg11, arg13), null, null, false, null, 0x7B, null));
    }

    public static ExitTransition shrinkOut$default(FiniteAnimationSpec arg3, Alignment arg4, boolean arg5, Function1 arg6, int arg7, Object arg8) {
        EnterExitTransitionKt$shrinkOut$1 v6;
        SpringSpec v3;
        if((arg7 & 1) != 0) {
            v3 = AnimationSpecKt.spring$default(0f, 400f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }

        if((arg7 & 2) != 0) {
            arg4 = Alignment.Companion.getBottomEnd();
        }

        if((arg7 & 8) != 0) {
            v6 = EnterExitTransitionKt$shrinkOut$1.INSTANCE;
        }

        return EnterExitTransitionKt.shrinkOut(((FiniteAnimationSpec)v3), arg4, true, ((Function1)v6));
    }

    public static final ExitTransition shrinkVertically(FiniteAnimationSpec arg1, Vertical arg2, boolean arg3, Function1 arg4) {
        return EnterExitTransitionKt.shrinkOut(arg1, EnterExitTransitionKt.toAlignment(arg2), arg3, new EnterExitTransitionKt$shrinkVertically$2(arg4));
    }

    public static ExitTransition shrinkVertically$default(FiniteAnimationSpec arg3, Vertical arg4, boolean arg5, Function1 arg6, int arg7, Object arg8) {
        EnterExitTransitionKt$shrinkVertically$1 v6;
        SpringSpec v3;
        if((arg7 & 1) != 0) {
            v3 = AnimationSpecKt.spring$default(0f, 400f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }

        if((arg7 & 2) != 0) {
            arg4 = Alignment.Companion.getBottom();
        }

        if((arg7 & 8) != 0) {
            v6 = EnterExitTransitionKt$shrinkVertically$1.INSTANCE;
        }

        return EnterExitTransitionKt.shrinkVertically(((FiniteAnimationSpec)v3), arg4, true, ((Function1)v6));
    }

    public static final EnterTransition slideIn(FiniteAnimationSpec arg11, Function1 arg12) {
        return new EnterTransitionImpl(new TransitionData(null, new Slide(arg12, arg11), null, null, null, false, null, 0x7D, null));
    }

    public static EnterTransition slideIn$default(FiniteAnimationSpec arg2, Function1 arg3, int arg4, Object arg5) {
        SpringSpec v2;
        if((arg4 & 1) != 0) {
            v2 = AnimationSpecKt.spring$default(0f, 400f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }

        return EnterExitTransitionKt.slideIn(((FiniteAnimationSpec)v2), arg3);
    }

    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec arg1, Function1 arg2) {
        return EnterExitTransitionKt.slideIn(arg1, new EnterExitTransitionKt$slideInHorizontally$2(arg2));
    }

    public static EnterTransition slideInHorizontally$default(FiniteAnimationSpec arg3, Function1 arg4, int arg5, Object arg6) {
        EnterExitTransitionKt$slideInHorizontally$1 v4;
        SpringSpec v3;
        if((arg5 & 1) != 0) {
            v3 = AnimationSpecKt.spring$default(0f, 400f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }

        if((arg5 & 2) != 0) {
            v4 = EnterExitTransitionKt$slideInHorizontally$1.INSTANCE;
        }

        return EnterExitTransitionKt.slideInHorizontally(((FiniteAnimationSpec)v3), ((Function1)v4));
    }

    public static final EnterTransition slideInVertically(FiniteAnimationSpec arg1, Function1 arg2) {
        return EnterExitTransitionKt.slideIn(arg1, new EnterExitTransitionKt$slideInVertically$2(arg2));
    }

    public static EnterTransition slideInVertically$default(FiniteAnimationSpec arg3, Function1 arg4, int arg5, Object arg6) {
        EnterExitTransitionKt$slideInVertically$1 v4;
        SpringSpec v3;
        if((arg5 & 1) != 0) {
            v3 = AnimationSpecKt.spring$default(0f, 400f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }

        if((arg5 & 2) != 0) {
            v4 = EnterExitTransitionKt$slideInVertically$1.INSTANCE;
        }

        return EnterExitTransitionKt.slideInVertically(((FiniteAnimationSpec)v3), ((Function1)v4));
    }

    public static final ExitTransition slideOut(FiniteAnimationSpec arg11, Function1 arg12) {
        return new ExitTransitionImpl(new TransitionData(null, new Slide(arg12, arg11), null, null, null, false, null, 0x7D, null));
    }

    public static ExitTransition slideOut$default(FiniteAnimationSpec arg2, Function1 arg3, int arg4, Object arg5) {
        SpringSpec v2;
        if((arg4 & 1) != 0) {
            v2 = AnimationSpecKt.spring$default(0f, 400f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }

        return EnterExitTransitionKt.slideOut(((FiniteAnimationSpec)v2), arg3);
    }

    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec arg1, Function1 arg2) {
        return EnterExitTransitionKt.slideOut(arg1, new EnterExitTransitionKt$slideOutHorizontally$2(arg2));
    }

    public static ExitTransition slideOutHorizontally$default(FiniteAnimationSpec arg3, Function1 arg4, int arg5, Object arg6) {
        EnterExitTransitionKt$slideOutHorizontally$1 v4;
        SpringSpec v3;
        if((arg5 & 1) != 0) {
            v3 = AnimationSpecKt.spring$default(0f, 400f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }

        if((arg5 & 2) != 0) {
            v4 = EnterExitTransitionKt$slideOutHorizontally$1.INSTANCE;
        }

        return EnterExitTransitionKt.slideOutHorizontally(((FiniteAnimationSpec)v3), ((Function1)v4));
    }

    public static final ExitTransition slideOutVertically(FiniteAnimationSpec arg1, Function1 arg2) {
        return EnterExitTransitionKt.slideOut(arg1, new EnterExitTransitionKt$slideOutVertically$2(arg2));
    }

    public static ExitTransition slideOutVertically$default(FiniteAnimationSpec arg3, Function1 arg4, int arg5, Object arg6) {
        EnterExitTransitionKt$slideOutVertically$1 v4;
        SpringSpec v3;
        if((arg5 & 1) != 0) {
            v3 = AnimationSpecKt.spring$default(0f, 400f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }

        if((arg5 & 2) != 0) {
            v4 = EnterExitTransitionKt$slideOutVertically$1.INSTANCE;
        }

        return EnterExitTransitionKt.slideOutVertically(((FiniteAnimationSpec)v3), ((Function1)v4));
    }

    private static final Alignment toAlignment(Horizontal arg1) {
        if(Intrinsics.areEqual(arg1, Alignment.Companion.getStart())) {
            return Alignment.Companion.getCenterStart();
        }

        if(Intrinsics.areEqual(arg1, Alignment.Companion.getEnd())) {
            return Alignment.Companion.getCenterEnd();
        }

        return Alignment.Companion.getCenter();
    }

    private static final Alignment toAlignment(Vertical arg1) {
        if(Intrinsics.areEqual(arg1, Alignment.Companion.getTop())) {
            return Alignment.Companion.getTopCenter();
        }

        if(Intrinsics.areEqual(arg1, Alignment.Companion.getBottom())) {
            return Alignment.Companion.getBottomCenter();
        }

        return Alignment.Companion.getCenter();
    }

    public static final EnterTransition trackActiveEnter(Transition arg3, EnterTransition arg4, Composer arg5, int arg6) {
        int v1 = 0x149CFA6;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(trackActiveEnter)1009@44788L40:EnterExitTransition.kt#xbi5r1");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.animation.trackActiveEnter (EnterExitTransition.kt:1004)");
        }

        ComposerKt.sourceInformationMarkerStart(arg5, -703284114, "CC(remember):EnterExitTransition.kt#9igjgp");
        v1 = 4;
        arg6 = (arg6 & 14 ^ 6) > v1 && (arg5.changed(arg3)) || (arg6 & 6) == v1 ? 1 : 0;
        Object v0 = arg5.rememberedValue();
        if(arg6 != 0 || v0 == Composer.Companion.getEmpty()) {
            MutableState v0_1 = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
            arg5.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        if(arg3.getCurrentState() != arg3.getTargetState() || arg3.getCurrentState() != EnterExitState.Visible) {
            if(arg3.getTargetState() == EnterExitState.Visible) {
                EnterExitTransitionKt.trackActiveEnter$lambda$2(((MutableState)v0), EnterExitTransitionKt.trackActiveEnter$lambda$1(((MutableState)v0)).plus(arg4));
            }
        }
        else if(arg3.isSeeking()) {
            EnterExitTransitionKt.trackActiveEnter$lambda$2(((MutableState)v0), arg4);
        }
        else {
            EnterExitTransitionKt.trackActiveEnter$lambda$2(((MutableState)v0), EnterTransition.Companion.getNone());
        }

        EnterTransition v3 = EnterExitTransitionKt.trackActiveEnter$lambda$1(((MutableState)v0));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return v3;
    }

    private static final EnterTransition trackActiveEnter$lambda$1(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void trackActiveEnter$lambda$2(MutableState arg0, EnterTransition arg1) {
        arg0.setValue(arg1);
    }

    public static final ExitTransition trackActiveExit(Transition arg3, ExitTransition arg4, Composer arg5, int arg6) {
        MutableState v0_1;
        int v1 = -1363864804;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(trackActiveExit)1029@45769L39:EnterExitTransition.kt#xbi5r1");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.animation.trackActiveExit (EnterExitTransition.kt:1024)");
        }

        ComposerKt.sourceInformationMarkerStart(arg5, -709035581, "CC(remember):EnterExitTransition.kt#9igjgp");
        v1 = 4;
        arg6 = (arg6 & 14 ^ 6) > v1 && (arg5.changed(arg3)) || (arg6 & 6) == v1 ? 1 : 0;
        Object v0 = arg5.rememberedValue();
        if(arg6 != 0 || v0 == Composer.Companion.getEmpty()) {
            v0_1 = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
            arg5.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        if(arg3.getCurrentState() != arg3.getTargetState() || arg3.getCurrentState() != EnterExitState.Visible) {
            if(arg3.getTargetState() != EnterExitState.Visible) {
                EnterExitTransitionKt.trackActiveExit$lambda$2(v0_1, EnterExitTransitionKt.trackActiveExit$lambda$1(v0_1).plus(arg4));
            }
        }
        else if(arg3.isSeeking()) {
            EnterExitTransitionKt.trackActiveExit$lambda$2(v0_1, arg4);
        }
        else {
            EnterExitTransitionKt.trackActiveExit$lambda$2(v0_1, ExitTransition.Companion.getNone());
        }

        ExitTransition v3 = EnterExitTransitionKt.trackActiveExit$lambda$1(v0_1);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return v3;
    }

    private static final ExitTransition trackActiveExit$lambda$1(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void trackActiveExit$lambda$2(MutableState arg0, ExitTransition arg1) {
        arg0.setValue(arg1);
    }

    public static final EnterTransition unveilIn-bw27NRU(FiniteAnimationSpec arg11, long arg12, boolean arg14) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, null, new Veil(arg12, Color.copy-wmQWz5c$default(arg12, 0f, 0f, 0f, 0f, 14, null), arg11, arg14, null), false, null, 0x6F, null));
    }

    public static EnterTransition unveilIn-bw27NRU$default(FiniteAnimationSpec arg8, long arg9, boolean arg11, int arg12, Object arg13) {
        SpringSpec v8;
        if((arg12 & 1) != 0) {
            v8 = AnimationSpecKt.spring$default(0f, 400f, null, 5, null);
        }

        if((arg12 & 2) != 0) {
            arg9 = Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0f, 0f, 0f, 14, null);
        }

        return EnterExitTransitionKt.unveilIn-bw27NRU(((FiniteAnimationSpec)v8), arg9, false);
    }

    public static final ExitTransition veilOut-bw27NRU(FiniteAnimationSpec arg11, long arg12, boolean arg14) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, null, new Veil(Color.copy-wmQWz5c$default(arg12, 0f, 0f, 0f, 0f, 14, null), arg12, arg11, arg14, null), false, null, 0x6F, null));
    }

    public static ExitTransition veilOut-bw27NRU$default(FiniteAnimationSpec arg8, long arg9, boolean arg11, int arg12, Object arg13) {
        SpringSpec v8;
        if((arg12 & 1) != 0) {
            v8 = AnimationSpecKt.spring$default(0f, 400f, null, 5, null);
        }

        if((arg12 & 2) != 0) {
            arg9 = Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0f, 0f, 0f, 14, null);
        }

        return EnterExitTransitionKt.veilOut-bw27NRU(((FiniteAnimationSpec)v8), arg9, false);
    }

    public static final EnterTransition withEffect(EnterTransition arg10, TransitionEffect arg11) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, null, null, false, MapsKt.mapOf(TuplesKt.to(arg11.getKey$animation(), arg11)), 0x3F, null));
    }

    public static final ExitTransition withEffect(ExitTransition arg10, TransitionEffect arg11) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, null, null, false, MapsKt.mapOf(TuplesKt.to(arg11.getKey$animation(), arg11)), 0x3F, null));
    }
}

