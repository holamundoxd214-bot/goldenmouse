package androidx.compose.material3.internal;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001A\u0015\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001A#\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2={"rememberAnimatedShape", "Landroidx/compose/ui/graphics/Shape;", "state", "Landroidx/compose/material3/internal/AnimatedShapeState;", "(Landroidx/compose/material3/internal/AnimatedShapeState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "currentShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "(Landroidx/compose/foundation/shape/RoundedCornerShape;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AnimatedShapeKt {
    public static final Shape rememberAnimatedShape(RoundedCornerShape arg8, FiniteAnimationSpec arg9, Composer arg10, int arg11) {
        AnimatedShapeKt$rememberAnimatedShape$3$1 v11_1;
        AnimatedShapeKt$$ExternalSyntheticLambda0 v0_2;
        Channel v9_1;
        int v1 = 0xEECA908B;
        ComposerKt.sourceInformationMarkerStart(arg10, v1, "C(rememberAnimatedShape)N(currentShape,animationSpec)133@5294L90,135@5404L59,137@5480L33,137@5469L44,138@5549L177,138@5518L208,145@5739L28:AnimatedShape.kt#mqatfk");
        int v2 = -1;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg11, v2, "androidx.compose.material3.internal.rememberAnimatedShape (AnimatedShape.kt:131)");
        }

        String v1_1 = "CC(remember):AnimatedShape.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg10, 0x6668AF25, v1_1);
        boolean v0 = arg10.changed(arg9);
        Object v3 = arg10.rememberedValue();
        if((v0) || v3 == Composer.Companion.getEmpty()) {
            AnimatedShapeState v3_1 = new AnimatedShapeState(arg8, arg9);
            arg10.updateRememberedValue(v3_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        ComposerKt.sourceInformationMarkerStart(arg10, 1718140102, v1_1);
        Object v9 = arg10.rememberedValue();
        int v4 = 6;
        BufferOverflow v5 = null;
        if(v9 == Composer.Companion.getEmpty()) {
            v9_1 = ChannelKt.Channel$default(v2, v5, ((Function1)v5), v4, v5);
            arg10.updateRememberedValue(v9_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        ComposerKt.sourceInformationMarkerStart(arg10, 1718142508, v1_1);
        v0 = arg10.changedInstance(v9_1);
        int v6 = 4;
        arg11 = (arg11 & 14 ^ v4) > v6 && (arg10.changed(arg8)) || (arg11 & v4) == v6 ? 1 : 0;
        arg11 |= ((int)v0);
        Object v0_1 = arg10.rememberedValue();
        if(arg11 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            v0_2 = new AnimatedShapeKt$$ExternalSyntheticLambda0(v9_1, arg8);
            arg10.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        EffectsKt.SideEffect(((Function0)v0_2), arg10, 0);
        ComposerKt.sourceInformationMarkerStart(arg10, 0x6668CF5C, v1_1);
        int v8 = arg10.changedInstance(v9_1) | arg10.changed(v3);
        Object v11 = arg10.rememberedValue();
        if(v8 != 0 || v11 == Composer.Companion.getEmpty()) {
            v11_1 = new AnimatedShapeKt$rememberAnimatedShape$3$1(v9_1, ((AnimatedShapeState)v3), ((Continuation)v5));
            arg10.updateRememberedValue(v11_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        EffectsKt.LaunchedEffect(v3, v9_1, ((Function2)v11_1), arg10, 0);
        Shape v8_1 = AnimatedShapeKt.rememberAnimatedShape(((AnimatedShapeState)v3), arg10, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        return v8_1;
    }

    private static final Shape rememberAnimatedShape(AnimatedShapeState arg3, Composer arg4, int arg5) {
        AnimatedShapeKt$rememberAnimatedShape$1$1 v0_3;
        int v1 = 0xAD8B7B7B;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(rememberAnimatedShape)N(state)90@3673L7,93@3721L1401:AnimatedShape.kt#mqatfk");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.internal.rememberAnimatedShape (AnimatedShape.kt:89)");
        }

        ProvidableCompositionLocal v0 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v0_1 = arg4.consume(((CompositionLocal)v0));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        arg3.setDensity(((Density)v0_1));
        ComposerKt.sourceInformationMarkerStart(arg4, 2023400020, "CC(remember):AnimatedShape.kt#9igjgp");
        boolean v0_2 = arg4.changed(v0_1);
        int v2 = 4;
        arg5 = (arg5 & 14 ^ 6) > v2 && (arg4.changed(arg3)) || (arg5 & 6) == v2 ? 1 : 0;
        arg5 |= ((int)v0_2);
        v0_1 = arg4.rememberedValue();
        if(arg5 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            v0_3 = new AnimatedShapeKt$rememberAnimatedShape$1$1(arg3);
            arg4.updateRememberedValue(v0_3);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return ((Shape)v0_3);
    }

    static final Unit rememberAnimatedShape$lambda$4$lambda$3(Channel arg0, RoundedCornerShape arg1) {
        arg0.trySend-JP2dKIU(arg1);
        return Unit.INSTANCE;
    }
}

