package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001A\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00032\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007H¦@¢\u0006\u0002\u0010\tJ\u001A\u0010\u0002\u001A\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0003H\u0096@¢\u0006\u0002\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "performFling", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "onRemainingDistanceUpdated", "Lkotlin/Function1;", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TargetedFlingBehavior extends FlingBehavior {
    Object performFling(ScrollScope arg1, float arg2, Function1 arg3, Continuation arg4);

    default Object performFling(ScrollScope arg1, float arg2, Continuation arg3) {
        return TargetedFlingBehavior.performFling$suspendImpl(this, arg1, arg2, arg3);
    }

    static Object performFling$suspendImpl(TargetedFlingBehavior arg1, ScrollScope arg2, float arg3, Continuation arg4) {
        return arg1.performFling(arg2, arg3, TargetedFlingBehaviorKt.access$getNoOnReport$p(), arg4);
    }
}

