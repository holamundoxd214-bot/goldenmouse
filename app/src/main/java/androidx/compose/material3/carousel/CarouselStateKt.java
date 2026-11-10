package androidx.compose.material3.carousel;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A%\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001AW\u0010\u000B\u001A\u00020\f*\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\b2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\b0\u00132\u001D\u0010\u0014\u001A\u0019\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u0015¢\u0006\u0002\b\u0017H\u0082@¢\u0006\u0002\u0010\u0018\u001A\u001C\u0010\u0019\u001A\u00020\b*\u00020\u000F2\u0006\u0010\u001A\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u0003H\u0002\"\u000E\u0010\u0007\u001A\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\n\u001A\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"rememberCarouselState", "Landroidx/compose/material3/carousel/CarouselState;", "initialItem", "", "itemCount", "Lkotlin/Function0;", "(ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/carousel/CarouselState;", "MinPageOffset", "", "MaxPageOffset", "MaxPagesForAnimateScroll", "animateScrollToPage", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "targetPage", "targetPageOffsetToSnappedPosition", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "updateTargetPage", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;Landroidx/compose/foundation/pager/PagerState;IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateScrollDistanceTo", "currentPage", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CarouselStateKt {
    public static final float MaxPageOffset = 0.5f;
    private static final int MaxPagesForAnimateScroll = 3;
    public static final float MinPageOffset = -0.5f;

    public static final Object access$animateScrollToPage(LazyLayoutScrollScope arg0, PagerState arg1, int arg2, float arg3, AnimationSpec arg4, Function2 arg5, Continuation arg6) {
        return CarouselStateKt.animateScrollToPage(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private static final Object animateScrollToPage(LazyLayoutScrollScope arg8, PagerState arg9, int arg10, float arg11, AnimationSpec arg12, Function2 arg13, Continuation arg14) {
        arg13.invoke(arg8, Boxing.boxInt(arg10));
        int v13 = arg10 > arg8.getFirstVisibleItemIndex() ? 1 : 0;
        int v2 = arg8.getLastVisibleItemIndex() - arg8.getFirstVisibleItemIndex() + 1;
        if((v13 != 0 && arg10 > arg8.getLastVisibleItemIndex() || v13 == 0 && arg10 < arg8.getFirstVisibleItemIndex()) && Math.abs(arg10 - arg8.getFirstVisibleItemIndex()) >= 3) {
            v13 = v13 != 0 ? RangesKt.coerceAtLeast(arg10 - v2, arg8.getFirstVisibleItemIndex()) : RangesKt.coerceAtMost(v2 + arg10, arg8.getFirstVisibleItemIndex());
            arg8.snapToItem(v13, 0);
        }

        Object v8 = SuspendAnimationKt.animate$default(0f, CarouselStateKt.calculateScrollDistanceTo(arg9, arg9.getCurrentPage(), arg10) + arg11, 0f, arg12, new CarouselStateKt$$ExternalSyntheticLambda1(new FloatRef(), arg8), arg14, 4, null);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }

    static final Unit animateScrollToPage$lambda$3(FloatRef arg0, LazyLayoutScrollScope arg1, float arg2, float arg3) {
        arg0.element += arg1.scrollBy(arg2 - arg0.element);
        return Unit.INSTANCE;
    }

    private static final float calculateScrollDistanceTo(PagerState arg8, int arg9, int arg10) {
        long v0 = arg8.getLayoutInfo().getOrientation() == Orientation.Horizontal ? arg8.getLayoutInfo().getViewportSize-YbymL2g() >> 0x20 : arg8.getLayoutInfo().getViewportSize-YbymL2g() & 0xFFFFFFFFL;
        int v2 = ((int)v0);
        return (((float)(arg10 - arg9))) * ((((float)arg8.getLayoutInfo().getPageSize())) + (((float)arg8.getLayoutInfo().getPageSpacing()))) + (((float)(arg8.getLayoutInfo().getSnapPosition().position(v2, arg8.getLayoutInfo().getPageSize(), arg8.getLayoutInfo().getBeforeContentPadding(), arg8.getLayoutInfo().getAfterContentPadding(), arg9, arg8.getPageCount()) - arg8.getLayoutInfo().getSnapPosition().position(v2, arg8.getLayoutInfo().getPageSize(), arg8.getLayoutInfo().getBeforeContentPadding(), arg8.getLayoutInfo().getAfterContentPadding(), arg10, arg8.getPageCount()))));
    }

    public static final CarouselState rememberCarouselState(int arg6, Function0 arg7, Composer arg8, int arg9, int arg10) {
        CarouselStateKt$$ExternalSyntheticLambda0 v0_2;
        int v1 = 0xF30C7BCC;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(rememberCarouselState)N(initialItem,itemCount)152@5940L182,152@5894L228:CarouselState.kt#dcf9yb");
        int v0 = 1;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.material3.carousel.rememberCarouselState (CarouselState.kt:151)");
        }

        Object[] v10 = new Object[0];
        Saver v1_1 = CarouselState.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart(arg8, 0x61DCD042, "CC(remember):CarouselState.kt#9igjgp");
        int v4 = 4;
        int v3 = (arg9 & 14 ^ 6) > v4 && (arg8.changed(0)) || (arg9 & 6) == v4 ? 1 : 0;
        int v5 = 0x20;
        if((arg9 & 0x70 ^ 0x30) <= v5 || !arg8.changed(arg7)) {
            if((arg9 & 0x30) == v5) {
            }
            else {
                v0 = 0;
            }
        }

        arg9 = v3 | v0;
        Object v0_1 = arg8.rememberedValue();
        if(arg9 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            v0_2 = new CarouselStateKt$$ExternalSyntheticLambda0(0, arg7);
            arg8.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        Object v6 = RememberSaveableKt.rememberSaveable(v10, v1_1, ((Function0)v0_2), arg8, 0);
        ((CarouselState)v6).getPagerState$material3().getPageCountState().setValue(arg7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return ((CarouselState)v6);
    }

    static final CarouselState rememberCarouselState$lambda$1$lambda$0(int arg2, Function0 arg3) {
        return new CarouselState(arg2, 0f, arg3);
    }
}

