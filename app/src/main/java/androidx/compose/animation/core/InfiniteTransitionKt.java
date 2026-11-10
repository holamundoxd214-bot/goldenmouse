package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001A\u0017\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001Ac\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u00020\u00012\u0006\u0010\n\u001A\u0002H\u00072\u0006\u0010\u000B\u001A\u0002H\u00072\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\r2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00070\u000F2\b\b\u0002\u0010\u0002\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0010\u001A?\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\u0006*\u00020\u00012\u0006\u0010\n\u001A\u00020\u00122\u0006\u0010\u000B\u001A\u00020\u00122\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00120\u000F2\b\b\u0002\u0010\u0002\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001A\r\u0010\u0000\u001A\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0014\u001AY\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u00020\u00012\u0006\u0010\n\u001A\u0002H\u00072\u0006\u0010\u000B\u001A\u0002H\u00072\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\r2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00070\u000FH\u0007¢\u0006\u0002\u0010\u0015\u001A5\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\u0006*\u00020\u00012\u0006\u0010\n\u001A\u00020\u00122\u0006\u0010\u000B\u001A\u00020\u00122\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00120\u000FH\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2={"rememberInfiniteTransition", "Landroidx/compose/animation/core/InfiniteTransition;", "label", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/InfiniteTransition;", "animateValue", "Landroidx/compose/runtime/State;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "initialValue", "targetValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloat", "", "(Landroidx/compose/animation/core/InfiniteTransition;FFLandroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/InfiniteTransition;", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Landroidx/compose/animation/core/InfiniteTransition;FFLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class InfiniteTransitionKt {
    public static Unit $r8$lambda$ZtrbR6KuLG7E73R6HGvkRBo3u9g(Object arg0, TransitionAnimationState arg1, Object arg2, InfiniteRepeatableSpec arg3) {
        return InfiniteTransitionKt.animateValue$lambda$1$0(arg0, arg1, arg2, arg3);
    }

    public static DisposableEffectResult $r8$lambda$hW3r_vsxyx9JNRg6DAgxhbNQ99U(InfiniteTransition arg0, TransitionAnimationState arg1, DisposableEffectScope arg2) {
        return InfiniteTransitionKt.animateValue$lambda$2$0(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="animateFloat APIs now have a new label parameter added.") public static final State animateFloat(InfiniteTransition arg9, float arg10, float arg11, InfiniteRepeatableSpec arg12, Composer arg13, int arg14) {
        int v1 = 0x1BFB95F0;
        ComposerKt.sourceInformationMarkerStart(arg13, v1, "C(animateFloat)N(initialValue,targetValue,animationSpec)337@13593L164:InfiniteTransition.kt#pdpnli");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg14, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:336)");
        }

        Composer v6 = arg13;
        State v9 = InfiniteTransitionKt.animateFloat(arg9, arg10, arg11, arg12, "FloatAnimation", v6, arg14 & 14 | 0x6000 | arg14 & 0x70 | arg14 & 0x380 | arg14 & 0x1C00, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        return v9;
    }

    public static final State animateFloat(InfiniteTransition arg12, float arg13, float arg14, InfiniteRepeatableSpec arg15, String arg16, Composer arg17, int arg18, int arg19) {
        int v0 = arg18;
        int v2 = -644770905;
        Composer v9 = arg17;
        ComposerKt.sourceInformationMarkerStart(v9, v2, "C(animateFloat)N(initialValue,targetValue,animationSpec,label)296@12385L84:InfiniteTransition.kt#pdpnli");
        String v8 = (arg19 & 8) != 0 ? "FloatAnimation" : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:296)");
        }

        Float v4 = Float.valueOf(arg13);
        Float v5 = Float.valueOf(arg14);
        int v14 = v0 << 3;
        State v12 = InfiniteTransitionKt.animateValue(arg12, v4, v5, VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), arg15, v8, v9, v0 & 0x3FE | 0xE000 & v14 | v14 & 0x70000, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg17);
        return v12;
    }

    public static final State animateValue(InfiniteTransition arg13, Object arg14, Object arg15, TwoWayConverter arg16, InfiniteRepeatableSpec arg17, String arg18, Composer arg19, int arg20, int arg21) {
        InfiniteTransitionKt$$ExternalSyntheticLambda1 v15;
        InfiniteTransitionKt$$ExternalSyntheticLambda0 v5_3;
        InfiniteRepeatableSpec v0 = arg17;
        Composer v1 = arg19;
        int v2 = arg20;
        int v4 = 0xC0A63B11;
        ComposerKt.sourceInformationMarkerStart(v1, v4, "C(animateValue)N(initialValue,targetValue,typeConverter,animationSpec,label)246@10575L113,250@10705L364,250@10694L375,263@11113L108,263@11075L146:InfiniteTransition.kt#pdpnli");
        String v11 = (arg21 & 16) != 0 ? "ValueAnimation" : arg18;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v4, v2, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:245)");
        }

        String v4_1 = "CC(remember):InfiniteTransition.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(v1, 0x3003DD62, v4_1);
        Object v3 = v1.rememberedValue();
        if(v3 == Composer.Companion.getEmpty()) {
            TransitionAnimationState v5 = new TransitionAnimationState(arg13, arg14, arg15, arg16, v0, v11);
            v1.updateRememberedValue(v5);
            TransitionAnimationState v3_1 = v5;
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        ComposerKt.sourceInformationMarkerStart(v1, 0x3003EE9D, v4_1);
        int v9 = 0x20;
        int v10 = 1;
        int v5_1 = (v2 & 0x70 ^ 0x30) > v9 && (v1.changedInstance(arg14)) || (v2 & 0x30) == v9 ? 1 : 0;
        int v12 = 0x100;
        v9 = (v2 & 0x380 ^ 0x180) > v12 && (v1.changedInstance(arg15)) || (v2 & 0x180) == v12 ? 1 : 0;
        v5_1 |= v9;
        v12 = 0x4000;
        if((0xE000 & v2 ^ 0x6000) <= v12 || !v1.changedInstance(v0)) {
            if((v2 & 0x6000) == v12) {
            }
            else {
                v10 = 0;
            }
        }

        v2 = v5_1 | v10;
        Object v5_2 = v1.rememberedValue();
        if(v2 != 0 || v5_2 == Composer.Companion.getEmpty()) {
            v5_3 = new InfiniteTransitionKt$$ExternalSyntheticLambda0(arg14, ((TransitionAnimationState)v3), arg15, v0);
            v1.updateRememberedValue(v5_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        EffectsKt.SideEffect(((Function0)v5_3), v1, 0);
        ComposerKt.sourceInformationMarkerStart(v1, 0x3004209D, v4_1);
        boolean v14 = v1.changedInstance(arg13);
        arg15 = v1.rememberedValue();
        if((v14) || arg15 == Composer.Companion.getEmpty()) {
            v15 = new InfiniteTransitionKt$$ExternalSyntheticLambda1(arg13, ((TransitionAnimationState)v3));
            v1.updateRememberedValue(v15);
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        EffectsKt.DisposableEffect(v3, ((Function1)v15), v1, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return ((State)v3);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="animateValue APIs now have a new label parameter added.") public static final State animateValue(InfiniteTransition arg12, Object arg13, Object arg14, TwoWayConverter arg15, InfiniteRepeatableSpec arg16, Composer arg17, int arg18) {
        int v0 = arg18;
        int v2 = 0x9AF211C6;
        Composer v9 = arg17;
        ComposerKt.sourceInformationMarkerStart(v9, v2, "C(animateValue)N(initialValue,targetValue,typeConverter,animationSpec)318@13087L203:InfiniteTransition.kt#pdpnli");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:317)");
        }

        v2 = v0 >> 3 & 8;
        State v12 = InfiniteTransitionKt.animateValue(arg12, arg13, arg14, arg15, arg16, "ValueAnimation", v9, v0 & 14 | 0x30000 | v2 << 3 | v0 & 0x70 | v2 << 6 | v0 & 0x380 | v0 & 0x1C00 | v0 & 0xE000, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg17);
        return v12;
    }

    private static final Unit animateValue$lambda$1$0(Object arg1, TransitionAnimationState arg2, Object arg3, InfiniteRepeatableSpec arg4) {
        if(!Intrinsics.areEqual(arg1, arg2.getInitialValue$animation_core()) || !Intrinsics.areEqual(arg3, arg2.getTargetValue$animation_core())) {
            arg2.updateValues$animation_core(arg1, arg3, ((AnimationSpec)arg4));
        }

        return Unit.INSTANCE;
    }

    private static final DisposableEffectResult animateValue$lambda$2$0(InfiniteTransition arg0, TransitionAnimationState arg1, DisposableEffectScope arg2) {
        arg0.addAnimation$animation_core(arg1);
        return new InfiniteTransitionKt$animateValue$lambda$2$0$$inlined$onDispose$1(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="rememberInfiniteTransition APIs now have a new label parameter added.") public static final InfiniteTransition rememberInfiniteTransition(Composer arg3, int arg4) {
        int v1 = -840193660;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(rememberInfiniteTransition)304@12685L48:InfiniteTransition.kt#pdpnli");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:303)");
        }

        InfiniteTransition v4 = InfiniteTransitionKt.rememberInfiniteTransition("InfiniteTransition", arg3, 6, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4;
    }

    public static final InfiniteTransition rememberInfiniteTransition(String arg2, Composer arg3, int arg4, int arg5) {
        int v1 = 1013651573;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(rememberInfiniteTransition)N(label)45@1988L38,46@2050L5:InfiniteTransition.kt#pdpnli");
        if((arg5 & 1) != 0) {
            arg2 = "InfiniteTransition";
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:44)");
        }

        ComposerKt.sourceInformationMarkerStart(arg3, 0xCE06DE5B, "CC(remember):InfiniteTransition.kt#9igjgp");
        Object v4 = arg3.rememberedValue();
        if(v4 == Composer.Companion.getEmpty()) {
            InfiniteTransition v4_1 = new InfiniteTransition(arg2);
            arg3.updateRememberedValue(v4_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        ((InfiniteTransition)v4).run$animation_core(arg3, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((InfiniteTransition)v4);
    }
}

