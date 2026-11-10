package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001AO\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00022\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0016\b\u0002\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0007¢\u0006\u0004\b\u000B\u0010\f\u001AE\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00022\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00020\u00052\u0016\b\u0002\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0007¢\u0006\u0004\b\r\u0010\u000E\u001A#\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"animateColorAsState", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "targetValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "label", "", "finishedListener", "Lkotlin/Function1;", "", "animateColorAsState-euL9pac", "(JLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateColorAsState-KTwxG1Y", "(JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "colorDefaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector4D;", "initialValue", "Animatable-8_81llA", "(J)Landroidx/compose/animation/core/Animatable;", "animation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SingleValueAnimationKt {
    private static final SpringSpec colorDefaultSpring;

    static {
        SingleValueAnimationKt.colorDefaultSpring = AnimationSpecKt.spring$default(0f, 0f, null, 7, null);
    }

    public static final Animatable Animatable-8_81llA(long arg7) {
        return new Animatable(Color.box-impl(arg7), ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.getColorSpace-impl(arg7)), null, null, 12, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="animate*AsState APIs now have a new label parameter added.") public static final State animateColorAsState-KTwxG1Y(long arg11, AnimationSpec arg13, Function1 arg14, Composer arg15, int arg16, int arg17) {
        SpringSpec v13;
        int v0 = arg16;
        int v2 = -1942442407;
        ComposerKt.sourceInformationMarkerStart(arg15, v2, "C(animateColorAsState)P(2:c#ui.graphics.Color)83@3489L84:SingleValueAnimation.kt#xbi5r1");
        if((arg17 & 2) != 0) {
            v13 = SingleValueAnimationKt.colorDefaultSpring;
        }

        AnimationSpec v5 = ((AnimationSpec)v13);
        if((arg17 & 4) != 0) {
            arg14 = null;
        }

        Function1 v7 = arg14;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.animateColorAsState (SingleValueAnimation.kt:82)");
        }

        State v11 = SingleValueAnimationKt.animateColorAsState-euL9pac(arg11, v5, null, v7, arg15, v0 & 0x7E | v0 << 3 & 0x1C00, 4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg15);
        return v11;
    }

    public static final State animateColorAsState-euL9pac(long arg9, AnimationSpec arg11, String arg12, Function1 arg13, Composer arg14, int arg15, int arg16) {
        AnimationSpec v1_1;
        int v2 = 0xE510911C;
        ComposerKt.sourceInformationMarkerStart(arg14, v2, "C(animateColorAsState)P(3:c#ui.graphics.Color!1,2)63@2906L84,64@3002L157:SingleValueAnimation.kt#xbi5r1");
        if((arg16 & 2) != 0) {
            SpringSpec v1 = SingleValueAnimationKt.colorDefaultSpring;
        }
        else {
            v1_1 = arg11;
        }

        String v4 = (arg16 & 4) != 0 ? "ColorAnimation" : arg12;
        Function1 v5 = (arg16 & 8) != 0 ? null : arg13;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg15, -1, "androidx.compose.animation.animateColorAsState (SingleValueAnimation.kt:61)");
        }

        ColorSpace v2_1 = Color.getColorSpace-impl(arg9);
        ComposerKt.sourceInformationMarkerStart(arg14, -483338000, "CC(remember):SingleValueAnimation.kt#9igjgp");
        boolean v2_2 = arg14.changed(v2_1);
        Object v3 = arg14.rememberedValue();
        if((v2_2) || v3 == Composer.Companion.getEmpty()) {
            v3 = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.getColorSpace-impl(arg9));
            arg14.updateRememberedValue(v3);
        }

        ComposerKt.sourceInformationMarkerEnd(arg14);
        int v0 = arg15 << 6;
        State v0_1 = AnimateAsStateKt.animateValueAsState(Color.box-impl(arg9), v3, ((SpringSpec)v1_1), null, v4, v5, arg14, arg15 & 14 | arg15 << 3 & 0x380 | 0xE000 & v0 | v0 & 0x70000, 8);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg14);
        return v0_1;
    }
}

