package androidx.compose.material3.carousel;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.pager.PagerDefaults;
import androidx.compose.foundation.pager.PagerSnapDistance;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u000E\b\u0002\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\u0010\u000BJ5\u0010\f\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u000E\b\u0002\u0010\r\u001A\b\u0012\u0004\u0012\u00020\n0\u000E2\u000E\b\u0002\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\u0010\u000FJ\r\u0010\u0010\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0011R\u0013\u0010\u0012\u001A\u00020\u0013¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0017\u001A\u00020\u0013¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0019\u001A\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u001A\u0010\u0015R\u000E\u0010\u001B\u001A\u00020\nX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/compose/material3/carousel/CarouselDefaults;", "", "<init>", "()V", "singleAdvanceFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "state", "Landroidx/compose/material3/carousel/CarouselState;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "multiBrowseFlingBehavior", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "noSnapFlingBehavior", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "MinSmallItemSize", "Landroidx/compose/ui/unit/Dp;", "getMinSmallItemSize-D9Ej5fM", "()F", "F", "MaxSmallItemSize", "getMaxSmallItemSize-D9Ej5fM", "AnchorSize", "getAnchorSize-D9Ej5fM$material3", "MediumLargeItemDiffThreshold", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CarouselDefaults {
    public static final int $stable = 0;
    private static final float AnchorSize = 0f;
    public static final CarouselDefaults INSTANCE = null;
    private static final float MaxSmallItemSize = 0f;
    public static final float MediumLargeItemDiffThreshold = 0.85f;
    private static final float MinSmallItemSize;

    static {
        CarouselDefaults.INSTANCE = new CarouselDefaults();
        CarouselDefaults.MinSmallItemSize = Dp.constructor-impl(40f);
        CarouselDefaults.MaxSmallItemSize = Dp.constructor-impl(56f);
        CarouselDefaults.AnchorSize = Dp.constructor-impl(10f);
    }

    private CarouselDefaults() {
        super();
    }

    public final float getAnchorSize-D9Ej5fM$material3() {
        return CarouselDefaults.AnchorSize;
    }

    public final float getMaxSmallItemSize-D9Ej5fM() {
        return CarouselDefaults.MaxSmallItemSize;
    }

    public final float getMinSmallItemSize-D9Ej5fM() {
        return CarouselDefaults.MinSmallItemSize;
    }

    public final TargetedFlingBehavior multiBrowseFlingBehavior(CarouselState arg10, DecayAnimationSpec arg11, AnimationSpec arg12, Composer arg13, int arg14, int arg15) {
        SpringSpec v4;
        int v2 = -1105043293;
        ComposerKt.sourceInformationMarkerStart(arg13, v2, "C(multiBrowseFlingBehavior)N(state,decayAnimationSpec,snapAnimationSpec)814@36753L26,829@37357L217:Carousel.kt#dcf9yb");
        DecayAnimationSpec v3 = (arg15 & 2) != 0 ? SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(arg13, 0) : arg11;
        if((arg15 & 4) != 0) {
            v4 = AnimationSpecKt.spring$default(0f, 400f, null, 5, null);
        }
        else {
            AnimationSpec v4_1 = arg12;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg14, -1, "androidx.compose.material3.carousel.CarouselDefaults.multiBrowseFlingBehavior (Carousel.kt:816)");
        }

        TargetedFlingBehavior v0 = PagerDefaults.INSTANCE.flingBehavior(arg10.getPagerState$material3(), new CarouselDefaults$multiBrowseFlingBehavior$pagerSnapDistance$1(), v3, ((AnimationSpec)v4), 0f, arg13, PagerDefaults.$stable << 15 | arg14 << 3 & 0x1F80, 16);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg13);
        return v0;
    }

    public final TargetedFlingBehavior noSnapFlingBehavior(Composer arg3, int arg4) {
        int v0 = 0xE70F7B74;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(noSnapFlingBehavior)846@37988L158,852@38163L75:Carousel.kt#dcf9yb");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.carousel.CarouselDefaults.noSnapFlingBehavior (Carousel.kt:845)");
        }

        ComposerKt.sourceInformationMarkerStart(arg3, 0x611E7C32, "CC(remember):Carousel.kt#9igjgp");
        Object v2 = arg3.rememberedValue();
        if(v2 == Composer.Companion.getEmpty()) {
            CarouselDefaults$noSnapFlingBehavior$decayLayoutInfoProvider$1$1 v2_1 = new CarouselDefaults$noSnapFlingBehavior$decayLayoutInfoProvider$1$1();
            arg3.updateRememberedValue(v2_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        TargetedFlingBehavior v2_2 = SnapFlingBehaviorKt.rememberSnapFlingBehavior(((SnapLayoutInfoProvider)v2), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2_2;
    }

    public final TargetedFlingBehavior singleAdvanceFlingBehavior(CarouselState arg11, AnimationSpec arg12, Composer arg13, int arg14, int arg15) {
        SpringSpec v12;
        int v0 = 0x656C28FF;
        ComposerKt.sourceInformationMarkerStart(arg13, v0, "C(singleAdvanceFlingBehavior)N(state,snapAnimationSpec)784@35043L174:Carousel.kt#dcf9yb");
        if((arg15 & 2) != 0) {
            v12 = AnimationSpecKt.spring$default(0f, 400f, null, 5, null);
        }

        AnimationSpec v5 = ((AnimationSpec)v12);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg14, -1, "androidx.compose.material3.carousel.CarouselDefaults.singleAdvanceFlingBehavior (Carousel.kt:783)");
        }

        Composer v7 = arg13;
        TargetedFlingBehavior v10 = PagerDefaults.INSTANCE.flingBehavior(arg11.getPagerState$material3(), PagerSnapDistance.Companion.atMost(1), null, v5, 0f, v7, arg14 << 6 & 0x1C00 | PagerDefaults.$stable << 15, 20);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v7);
        return v10;
    }
}

