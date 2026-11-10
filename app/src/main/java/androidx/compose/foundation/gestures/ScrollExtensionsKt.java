package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$LongRef;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A*\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00012\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001A,\u0010\u0000\u001A\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001A\u00020\u00072\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0086@¢\u0006\u0004\b\t\u0010\n\u001A\u001A\u0010\u000B\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0086@¢\u0006\u0002\u0010\f\u001A\u001C\u0010\u000B\u001A\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001A\u00020\u0007H\u0086@¢\u0006\u0004\b\r\u0010\u000E\u001A\u001C\u0010\u000F\u001A\u00020\u0010*\u00020\u00022\b\b\u0002\u0010\u0011\u001A\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0013\u001A\u001C\u0010\u000F\u001A\u00020\u0010*\u00020\b2\b\b\u0002\u0010\u0011\u001A\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2={"animateScrollBy", "", "Landroidx/compose/foundation/gestures/ScrollableState;", "value", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/ScrollableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "animateScrollBy-ubNVwUQ", "(Landroidx/compose/foundation/gestures/Scrollable2DState;JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollBy", "(Landroidx/compose/foundation/gestures/ScrollableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/Scrollable2DState;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopScroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/compose/foundation/gestures/Scrollable2DState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ScrollExtensionsKt {
    public static final Object animateScrollBy(ScrollableState arg7, float arg8, AnimationSpec arg9, Continuation arg10) {
        Object v7;
        Continuation v0;
        if((arg10 instanceof ScrollExtensionsKt$animateScrollBy$1)) {
            v0 = arg10;
            int v2 = 0x80000000;
            if((((ScrollExtensionsKt$animateScrollBy$1)v0).label & v2) != 0) {
                ((ScrollExtensionsKt$animateScrollBy$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ScrollExtensionsKt$animateScrollBy$1 v0_1 = new ScrollExtensionsKt$animateScrollBy$1(arg10);
        }

        Continuation v4 = v0;
        Object v10 = ((ScrollExtensionsKt$animateScrollBy$1)v4).result;
        Object v0_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1 = ((ScrollExtensionsKt$animateScrollBy$1)v4).label;
        if(v1 == 0) {
            ResultKt.throwOnFailure(v10);
            FloatRef v10_1 = new FloatRef();
            ScrollExtensionsKt$animateScrollBy$2 v3 = new ScrollExtensionsKt$animateScrollBy$2(arg8, arg9, v10_1, null);
            ((ScrollExtensionsKt$animateScrollBy$1)v4).L$0 = v10_1;
            ((ScrollExtensionsKt$animateScrollBy$1)v4).label = 1;
            if(ScrollableState.scroll$default(arg7, null, ((Function2)v3), v4, 1, null) == v0_2) {
                return v0_2;
            }
            else {
                FloatRef v7_1 = v10_1;
            }
        }
        else if(v1 == 1) {
            v7 = ((ScrollExtensionsKt$animateScrollBy$1)v4).L$0;
            ResultKt.throwOnFailure(v10);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Boxing.boxFloat(((FloatRef)v7).element);
    }

    public static Object animateScrollBy$default(ScrollableState arg0, float arg1, AnimationSpec arg2, Continuation arg3, int arg4, Object arg5) {
        SpringSpec v2;
        if((arg4 & 2) != 0) {
            v2 = AnimationSpecKt.spring$default(0f, 0f, null, 7, null);
        }

        return ScrollExtensionsKt.animateScrollBy(arg0, arg1, ((AnimationSpec)v2), arg3);
    }

    public static final Object animateScrollBy-ubNVwUQ(Scrollable2DState arg11, long arg12, AnimationSpec arg14, Continuation arg15) {
        LongRef v11_1;
        ScrollExtensionsKt$animateScrollBy$3 v0_1;
        if((arg15 instanceof ScrollExtensionsKt$animateScrollBy$3)) {
            Continuation v0 = arg15;
            int v2 = 0x80000000;
            if((((ScrollExtensionsKt$animateScrollBy$3)v0).label & v2) != 0) {
                ((ScrollExtensionsKt$animateScrollBy$3)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ScrollExtensionsKt$animateScrollBy$3(arg15);
        }

        Continuation v4 = ((Continuation)v0_1);
        Object v15 = ((ScrollExtensionsKt$animateScrollBy$3)v4).result;
        Object v0_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1 = ((ScrollExtensionsKt$animateScrollBy$3)v4).label;
        if(v1 == 0) {
            ResultKt.throwOnFailure(v15);
            LongRef v9 = new LongRef();
            v9.element = Offset.Companion.getZero-F1C5BW0();
            ScrollExtensionsKt$animateScrollBy$4 v3 = new ScrollExtensionsKt$animateScrollBy$4(arg12, arg14, v9, null);
            ((ScrollExtensionsKt$animateScrollBy$3)v4).L$0 = v9;
            ((ScrollExtensionsKt$animateScrollBy$3)v4).label = 1;
            if(Scrollable2DState.scroll$default(arg11, null, ((Function2)v3), v4, 1, null) == v0_2) {
                return v0_2;
            }
            else {
                v11_1 = v9;
            }
        }
        else if(v1 == 1) {
            Object v11 = ((ScrollExtensionsKt$animateScrollBy$3)v4).L$0;
            ResultKt.throwOnFailure(v15);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Offset.box-impl(v11_1.element);
    }

    public static Object animateScrollBy-ubNVwUQ$default(Scrollable2DState arg0, long arg1, AnimationSpec arg3, Continuation arg4, int arg5, Object arg6) {
        SpringSpec v3;
        if((arg5 & 2) != 0) {
            v3 = AnimationSpecKt.spring$default(0f, 0f, null, 7, null);
        }

        return ScrollExtensionsKt.animateScrollBy-ubNVwUQ(arg0, arg1, ((AnimationSpec)v3), arg4);
    }

    public static final Object scrollBy(ScrollableState arg7, float arg8, Continuation arg9) {
        FloatRef v7_1;
        Continuation v0;
        if((arg9 instanceof ScrollExtensionsKt$scrollBy$1)) {
            v0 = arg9;
            int v2 = 0x80000000;
            if((((ScrollExtensionsKt$scrollBy$1)v0).label & v2) != 0) {
                ((ScrollExtensionsKt$scrollBy$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ScrollExtensionsKt$scrollBy$1 v0_1 = new ScrollExtensionsKt$scrollBy$1(arg9);
        }

        Continuation v4 = v0;
        Object v9 = ((ScrollExtensionsKt$scrollBy$1)v4).result;
        Object v0_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1 = ((ScrollExtensionsKt$scrollBy$1)v4).label;
        if(v1 == 0) {
            ResultKt.throwOnFailure(v9);
            FloatRef v9_1 = new FloatRef();
            ScrollExtensionsKt$scrollBy$2 v3 = new ScrollExtensionsKt$scrollBy$2(v9_1, arg8, null);
            ((ScrollExtensionsKt$scrollBy$1)v4).L$0 = v9_1;
            ((ScrollExtensionsKt$scrollBy$1)v4).label = 1;
            if(ScrollableState.scroll$default(arg7, null, ((Function2)v3), v4, 1, null) == v0_2) {
                return v0_2;
            }
            else {
                v7_1 = v9_1;
            }
        }
        else if(v1 == 1) {
            Object v7 = ((ScrollExtensionsKt$scrollBy$1)v4).L$0;
            ResultKt.throwOnFailure(v9);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Boxing.boxFloat(v7_1.element);
    }

    public static final Object scrollBy-d-4ec7I(Scrollable2DState arg7, long arg8, Continuation arg10) {
        Object v7;
        ScrollExtensionsKt$scrollBy$3 v0_1;
        if((arg10 instanceof ScrollExtensionsKt$scrollBy$3)) {
            Continuation v0 = arg10;
            int v2 = 0x80000000;
            if((((ScrollExtensionsKt$scrollBy$3)v0).label & v2) != 0) {
                ((ScrollExtensionsKt$scrollBy$3)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ScrollExtensionsKt$scrollBy$3(arg10);
        }

        Continuation v4 = ((Continuation)v0_1);
        Object v10 = ((ScrollExtensionsKt$scrollBy$3)v4).result;
        Object v0_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1 = ((ScrollExtensionsKt$scrollBy$3)v4).label;
        if(v1 == 0) {
            ResultKt.throwOnFailure(v10);
            LongRef v10_1 = new LongRef();
            v10_1.element = Offset.Companion.getZero-F1C5BW0();
            ScrollExtensionsKt$scrollBy$4 v3 = new ScrollExtensionsKt$scrollBy$4(v10_1, arg8, null);
            ((ScrollExtensionsKt$scrollBy$3)v4).L$0 = v10_1;
            ((ScrollExtensionsKt$scrollBy$3)v4).label = 1;
            if(Scrollable2DState.scroll$default(arg7, null, ((Function2)v3), v4, 1, null) == v0_2) {
                return v0_2;
            }
            else {
                LongRef v7_1 = v10_1;
            }
        }
        else if(v1 == 1) {
            v7 = ((ScrollExtensionsKt$scrollBy$3)v4).L$0;
            ResultKt.throwOnFailure(v10);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Offset.box-impl(((LongRef)v7).element);
    }

    public static final Object stopScroll(Scrollable2DState arg2, MutatePriority arg3, Continuation arg4) {
        Object v2 = arg2.scroll(arg3, new ScrollExtensionsKt$stopScroll$4(null), arg4);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    public static final Object stopScroll(ScrollableState arg2, MutatePriority arg3, Continuation arg4) {
        Object v2 = arg2.scroll(arg3, new ScrollExtensionsKt$stopScroll$2(null), arg4);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    public static Object stopScroll$default(Scrollable2DState arg0, MutatePriority arg1, Continuation arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = MutatePriority.Default;
        }

        return ScrollExtensionsKt.stopScroll(arg0, arg1, arg2);
    }

    public static Object stopScroll$default(ScrollableState arg0, MutatePriority arg1, Continuation arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = MutatePriority.Default;
        }

        return ScrollExtensionsKt.stopScroll(arg0, arg1, arg2);
    }
}

