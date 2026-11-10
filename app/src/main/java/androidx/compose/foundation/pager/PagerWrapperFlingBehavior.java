package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\f\u001A\u00020\r*\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0011"}, d2={"Landroidx/compose/foundation/pager/PagerWrapperFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "originalFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "<init>", "(Landroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/pager/PagerState;)V", "getOriginalFlingBehavior", "()Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "performFling", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class PagerWrapperFlingBehavior implements FlingBehavior {
    private final TargetedFlingBehavior originalFlingBehavior;
    private final PagerState pagerState;

    public static Unit $r8$lambda$QSWpr1eY7kVkDPLgg4o08s0atlQ(PagerWrapperFlingBehavior arg0, ScrollScope arg1, float arg2) {
        return PagerWrapperFlingBehavior.performFling$lambda$0$0(arg0, arg1, arg2);
    }

    public PagerWrapperFlingBehavior(TargetedFlingBehavior arg1, PagerState arg2) {
        super();
        this.originalFlingBehavior = arg1;
        this.pagerState = arg2;
    }

    public final TargetedFlingBehavior getOriginalFlingBehavior() {
        return this.originalFlingBehavior;
    }

    public final PagerState getPagerState() {
        return this.pagerState;
    }

    public Object performFling(ScrollScope arg5, float arg6, Continuation arg7) {
        PagerWrapperFlingBehavior$performFling$1 v0_1;
        int v2;
        if((arg7 instanceof PagerWrapperFlingBehavior$performFling$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((PagerWrapperFlingBehavior$performFling$1)v0).label & v2) != 0) {
                ((PagerWrapperFlingBehavior$performFling$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new PagerWrapperFlingBehavior$performFling$1(this, arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            TargetedFlingBehavior v7_1 = this.originalFlingBehavior;
            PagerWrapperFlingBehavior$$ExternalSyntheticLambda0 v2_1 = new PagerWrapperFlingBehavior$$ExternalSyntheticLambda0(this, arg5);
            v0_1.label = 1;
            v7 = v7_1.performFling(arg5, arg6, ((Function1)v2_1), ((Continuation)v0_1));
            if(v7 == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v7);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        float v5 = ((Number)v7).floatValue();
        if(this.pagerState.getCurrentPageOffsetFraction() == 0f) {
            goto label_51;
        }
        else if((((double)Math.abs(this.pagerState.getCurrentPageOffsetFraction()))) < 0.001) {
            PagerState.requestScrollToPage$default(this.pagerState, this.pagerState.getCurrentPage(), 0f, 2, null);
        }
        else {
        label_51:
            Boxing.boxFloat(this.pagerState.getCurrentPageOffsetFraction());
        }

        return Boxing.boxFloat(v5);
    }

    private static final Unit performFling$lambda$0$0(PagerWrapperFlingBehavior arg1, ScrollScope arg2, float arg3) {
        if(arg1.pagerState.getPageSizeWithSpacing$foundation() != 0) {
            arg3 /= ((float)arg1.pagerState.getPageSizeWithSpacing$foundation());
        }
        else {
            arg3 = 0f;
        }

        arg1.pagerState.updateTargetPage(arg2, MathKt.roundToInt(arg3) + arg1.pagerState.getCurrentPage());
        return Unit.INSTANCE;
    }
}

