package androidx.compose.material3.carousel;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B)\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u0005H\u0016J?\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\'\u0010\u001B\u001A#\b\u0001\u0012\u0004\u0012\u00020\u001D\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001E\u0012\u0006\u0012\u0004\u0018\u00010\u001F0\u001C¢\u0006\u0002\b H\u0096@¢\u0006\u0002\u0010!J\u0016\u0010\"\u001A\u00020\u00182\u0006\u0010#\u001A\u00020\u0003H\u0086@¢\u0006\u0002\u0010$J&\u0010%\u001A\u00020\u00182\u0006\u0010#\u001A\u00020\u00032\u000E\b\u0002\u0010&\u001A\b\u0012\u0004\u0012\u00020\u00050\'H\u0086@¢\u0006\u0002\u0010(R\u001A\u0010\n\u001A\u00020\u000BX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0012R\u0011\u0010\u0002\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2={"Landroidx/compose/material3/carousel/CarouselState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "currentItem", "", "currentItemOffsetFraction", "", "itemCount", "Lkotlin/Function0;", "<init>", "(IFLkotlin/jvm/functions/Function0;)V", "pagerState", "Landroidx/compose/material3/carousel/CarouselPagerState;", "getPagerState$material3", "()Landroidx/compose/material3/carousel/CarouselPagerState;", "setPagerState$material3", "(Landroidx/compose/material3/carousel/CarouselPagerState;)V", "isScrollInProgress", "", "()Z", "getCurrentItem", "()I", "dispatchRawDelta", "delta", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "item", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateScrollToItem", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CarouselState implements ScrollableState {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001B\u0010\u0004\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/material3/carousel/CarouselState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/carousel/CarouselState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver getSaver() {
            return CarouselState.Saver;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Saver Saver;
    private CarouselPagerState pagerState;

    static {
        CarouselState.Companion = new Companion(null);
        CarouselState.$stable = 8;
        CarouselState.Saver = ListSaverKt.listSaver(new CarouselState$$ExternalSyntheticLambda1(), new CarouselState$$ExternalSyntheticLambda2());
    }

    public CarouselState(int arg2, float arg3, Function0 arg4) {
        super();
        this.pagerState = new CarouselPagerState(arg2, arg3, arg4);
    }

    public CarouselState(int arg1, float arg2, Function0 arg3, int arg4, DefaultConstructorMarker arg5) {
        this(0, 0f, arg3);
    }

    static final List Saver$lambda$1(SaverScope arg1, CarouselState arg2) {
        return CollectionsKt.listOf(new Object[]{Integer.valueOf(arg2.pagerState.getCurrentPage()), Float.valueOf(arg2.pagerState.getCurrentPageOffsetFraction()), Integer.valueOf(arg2.pagerState.getPageCount())});
    }

    static final CarouselState Saver$lambda$3(List arg4) {
        Object v1 = arg4.get(0);
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Int");
        int v1_1 = ((Integer)v1).intValue();
        Object v2 = arg4.get(1);
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlin.Float");
        return new CarouselState(v1_1, ((Float)v2).floatValue(), new CarouselState$$ExternalSyntheticLambda0(arg4));
    }

    static final int Saver$lambda$3$lambda$2(List arg1) {
        Object v1 = arg1.get(2);
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer)v1).intValue();
    }

    public static final Saver access$getSaver$cp() {
        return CarouselState.Saver;
    }

    public final Object animateScrollToItem(int arg9, AnimationSpec arg10, Continuation arg11) {
        CarouselPagerState v8 = this.pagerState;
        if(arg9 != v8.getCurrentPage() || v8.getCurrentPageOffsetFraction() != 0f) {
            if(v8.getPageCount() == 0) {
                goto label_9;
            }

            goto label_11;
        }
        else {
        }

    label_9:
        return Unit.INSTANCE;
    label_11:
        int v1 = 0;
        if(v8.getPageCount() > 0) {
            v1 = RangesKt.coerceIn(arg9, 0, v8.getPageCount() - 1);
        }

        Object v8_1 = ScrollableState.scroll$default(v8, null, new CarouselState$animateScrollToItem$2$1(v8, v1, arg10, null), arg11, 1, null);
        if(v8_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8_1;
        }

        return Unit.INSTANCE;
    }

    public static Object animateScrollToItem$default(CarouselState arg0, int arg1, AnimationSpec arg2, Continuation arg3, int arg4, Object arg5) {
        SpringSpec v2;
        if((arg4 & 2) != 0) {
            v2 = AnimationSpecKt.spring$default(0f, 0f, null, 7, null);
        }

        return arg0.animateScrollToItem(arg1, ((AnimationSpec)v2), arg3);
    }

    public float dispatchRawDelta(float arg1) {
        return this.pagerState.dispatchRawDelta(arg1);
    }

    public final int getCurrentItem() {
        return this.pagerState.getCurrentPage();
    }

    public final CarouselPagerState getPagerState$material3() {
        return this.pagerState;
    }

    public boolean isScrollInProgress() {
        return this.pagerState.isScrollInProgress();
    }

    public Object scroll(MutatePriority arg1, Function2 arg2, Continuation arg3) {
        Object v0 = this.pagerState.scroll(arg1, arg2, arg3);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public final Object scrollToItem(int arg2, Continuation arg3) {
        Object v1 = this.pagerState.scrollToPage(arg2, 0f, arg3);
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }

    public final void setPagerState$material3(CarouselPagerState arg1) {
        this.pagerState = arg1;
    }
}

