package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;

@Metadata(d1={"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u001C\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\u0004\b\r\u0010\u000EJ#\u0010!\u001A\u00020 *\u00020\u001A2\u0006\u0010\"\u001A\u00020 2\u0006\u0010#\u001A\u00020\u0017H\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001A\u00020\f2\u0006\u0010\'\u001A\u00020 ¢\u0006\u0004\b(\u0010)J\u0015\u0010&\u001A\u00020\f2\u0006\u0010*\u001A\u00020+¢\u0006\u0004\b,\u0010)J\u0017\u0010-\u001A\u00020 2\u0006\u0010.\u001A\u00020 H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00101\u001A\u00020 2\u0006\u0010.\u001A\u00020 H\u0002¢\u0006\u0004\b2\u00100J\u0018\u00103\u001A\u0002042\u0006\u00105\u001A\u00020+H\u0086@¢\u0006\u0004\b6\u00107J\u0018\u00108\u001A\u00020+2\u0006\u00109\u001A\u00020+H\u0096@¢\u0006\u0004\b:\u00107J\u0006\u0010;\u001A\u00020\fJA\u0010.\u001A\u0002042\b\b\u0002\u0010<\u001A\u00020=2\'\u0010>\u001A#\b\u0001\u0012\u0004\u0012\u00020@\u0012\n\u0012\b\u0012\u0004\u0012\u0002040A\u0012\u0006\u0012\u0004\u0018\u00010B0?¢\u0006\u0002\bCH\u0086@¢\u0006\u0002\u0010DJ(\u0010E\u001A\u00020\f2\u0006\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tR\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\f@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0018R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001B\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001DR\u001A\u0010\u001E\u001A\u000E\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2={"Landroidx/compose/foundation/gestures/ScrollingLogic2D;", "Landroidx/compose/foundation/gestures/ScrollLogic;", "scrollableState", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "isScrollableNodeAttached", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/gestures/Scrollable2DState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Lkotlin/jvm/functions/Function0;)V", "getScrollableState", "()Landroidx/compose/foundation/gestures/Scrollable2DState;", "setScrollableState", "(Landroidx/compose/foundation/gestures/Scrollable2DState;)V", "value", "isFlinging", "()Z", "latestScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "I", "outerStateScope", "Landroidx/compose/foundation/gestures/Scroll2DScope;", "nestedScrollScope", "androidx/compose/foundation/gestures/ScrollingLogic2D$nestedScrollScope$1", "Landroidx/compose/foundation/gestures/ScrollingLogic2D$nestedScrollScope$1;", "performScrollForOverscroll", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "performScroll", "delta", "source", "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/Scroll2DScope;JI)J", "shouldDispatchOverscroll", "offset", "shouldDispatchOverscroll-k-4lQ0M", "(J)Z", "velocity", "Landroidx/compose/ui/unit/Velocity;", "shouldDispatchOverscroll-TH1AsA0", "performRawScroll", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "dispatchRawDelta", "dispatchRawDelta-MK-Hz9U", "onScrollStopped", "", "initialVelocity", "onScrollStopped-sF-c-tU", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doFlingAnimation", "available", "doFlingAnimation-QWom1Mo", "shouldScrollImmediately", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ScrollingLogic2D implements ScrollLogic {
    private FlingBehavior flingBehavior;
    private boolean isFlinging;
    private final Function0 isScrollableNodeAttached;
    private int latestScrollSource;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private final ScrollingLogic2D$nestedScrollScope$1 nestedScrollScope;
    private Scroll2DScope outerStateScope;
    private OverscrollEffect overscrollEffect;
    private final Function1 performScrollForOverscroll;
    private Scrollable2DState scrollableState;

    public ScrollingLogic2D(Scrollable2DState arg1, OverscrollEffect arg2, FlingBehavior arg3, NestedScrollDispatcher arg4, Function0 arg5) {
        super();
        this.scrollableState = arg1;
        this.overscrollEffect = arg2;
        this.flingBehavior = arg3;
        this.nestedScrollDispatcher = arg4;
        this.isScrollableNodeAttached = arg5;
        this.latestScrollSource = NestedScrollSource.Companion.getUserInput-WNlRxjI();
        this.outerStateScope = Scrollable2DKt.NoOpScrollScope;
        this.nestedScrollScope = new ScrollingLogic2D$nestedScrollScope$1(this);
        this.performScrollForOverscroll = new ScrollingLogic2D$$ExternalSyntheticLambda0(this);
    }

    public static final long access$doFlingAnimation_QWom1Mo$toDecomposedOffset(float arg0, long arg1) {
        return ScrollingLogic2D.doFlingAnimation_QWom1Mo$toDecomposedOffset(arg0, arg1);
    }

    public static final long access$doFlingAnimation_QWom1Mo$toDecomposedVelocity(float arg0, long arg1) {
        return ScrollingLogic2D.doFlingAnimation_QWom1Mo$toDecomposedVelocity(arg0, arg1);
    }

    public static final float access$doFlingAnimation_QWom1Mo$toMagnitudeFloat(long arg0) {
        return ScrollingLogic2D.doFlingAnimation_QWom1Mo$toMagnitudeFloat(arg0);
    }

    public static final FlingBehavior access$getFlingBehavior$p(ScrollingLogic2D arg0) {
        return arg0.flingBehavior;
    }

    public static final int access$getLatestScrollSource$p(ScrollingLogic2D arg0) {
        return arg0.latestScrollSource;
    }

    public static final NestedScrollDispatcher access$getNestedScrollDispatcher$p(ScrollingLogic2D arg0) {
        return arg0.nestedScrollDispatcher;
    }

    public static final ScrollingLogic2D$nestedScrollScope$1 access$getNestedScrollScope$p(ScrollingLogic2D arg0) {
        return arg0.nestedScrollScope;
    }

    public static final Scroll2DScope access$getOuterStateScope$p(ScrollingLogic2D arg0) {
        return arg0.outerStateScope;
    }

    public static final OverscrollEffect access$getOverscrollEffect$p(ScrollingLogic2D arg0) {
        return arg0.overscrollEffect;
    }

    public static final Function1 access$getPerformScrollForOverscroll$p(ScrollingLogic2D arg0) {
        return arg0.performScrollForOverscroll;
    }

    public static final Function0 access$isScrollableNodeAttached$p(ScrollingLogic2D arg0) {
        return arg0.isScrollableNodeAttached;
    }

    public static final long access$performScroll-3eAAhYA(ScrollingLogic2D arg0, Scroll2DScope arg1, long arg2, int arg4) {
        return arg0.performScroll-3eAAhYA(arg1, arg2, arg4);
    }

    public static final void access$setLatestScrollSource$p(ScrollingLogic2D arg0, int arg1) {
        arg0.latestScrollSource = arg1;
    }

    public static final void access$setOuterStateScope$p(ScrollingLogic2D arg0, Scroll2DScope arg1) {
        arg0.outerStateScope = arg1;
    }

    private final long dispatchRawDelta-MK-Hz9U(long arg1) {
        return this.scrollableState.dispatchRawDelta-MK-Hz9U(arg1);
    }

    public Object doFlingAnimation-QWom1Mo(long arg12, Continuation arg14) {
        Throwable v12_1;
        ScrollingLogic2D v6;
        LongRef v12_2;
        long v7;
        Continuation v10;
        ScrollingLogic2D$doFlingAnimation$1 v0_1;
        int v2;
        if((arg14 instanceof ScrollingLogic2D$doFlingAnimation$1)) {
            Continuation v0 = arg14;
            v2 = 0x80000000;
            if((((ScrollingLogic2D$doFlingAnimation$1)v0).label & v2) != 0) {
                ((ScrollingLogic2D$doFlingAnimation$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ScrollingLogic2D$doFlingAnimation$1(this, arg14);
        }

        Object v14 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v14);
            LongRef v9 = new LongRef();
            v9.element = arg12;
            this.isFlinging = true;
            try {
                MutatePriority v14_1 = MutatePriority.Default;
                v10 = null;
                v6 = this;
                v7 = arg12;
            }
            catch(Throwable v0_2) {
                v6 = this;
                goto label_57;
            }

            try {
                ScrollingLogic2D$doFlingAnimation$2 v5 = new ScrollingLogic2D$doFlingAnimation$2(v6, v7, v9, v10);
                v0_1.L$0 = v9;
                v0_1.label = 1;
                if(v6.scroll(v14_1, ((Function2)v5), ((Continuation)v0_1)) != v1) {
                    goto label_48;
                }

                return v1;
            }
            catch(Throwable v0_2) {
            }

        label_57:
            v12_1 = v0_2;
        label_58:
            v6.isFlinging = false;
            throw v12_1;
            return v1;
        label_48:
            v12_2 = v9;
        }
        else if(v2 == 1) {
            Object v12 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v14);
                v6 = this;
            }
            catch(Throwable v0_2) {
                v12_1 = v0_2;
                v6 = this;
                goto label_58;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        v6.isFlinging = false;
        return Velocity.box-impl(v12_2.element);
    }

    private static final long doFlingAnimation_QWom1Mo$toDecomposedOffset(float arg6, long arg7) {
        long v1 = 0xFFFFFFFFL;
        int v3 = 0x20;
        if(Float.isNaN(Scrollable2DKt.getAngle-TH1AsA0(arg7))) {
            return Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << v3 | (((long)Float.floatToRawIntBits(arg6))) & v1);
        }

        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Math.abs((((float)Math.cos(((double)Scrollable2DKt.getAngle-TH1AsA0(arg7))))) * arg6) * Math.signum(Velocity.getX-impl(arg7))))) << v3 | (((long)Float.floatToRawIntBits(Math.abs((((float)Math.sin(((double)Scrollable2DKt.getAngle-TH1AsA0(arg7))))) * arg6) * Math.signum(Velocity.getY-impl(arg7))))) & v1);
    }

    private static final long doFlingAnimation_QWom1Mo$toDecomposedVelocity(float arg3, long arg4) {
        if(Float.isNaN(Scrollable2DKt.getAngle-TH1AsA0(arg4))) {
            return VelocityKt.Velocity(0f, arg3);
        }

        return VelocityKt.Velocity(Math.abs((((float)Math.cos(((double)Scrollable2DKt.getAngle-TH1AsA0(arg4))))) * arg3) * Math.signum(Velocity.getX-impl(arg4)), Math.abs((((float)Math.sin(((double)Scrollable2DKt.getAngle-TH1AsA0(arg4))))) * arg3) * Math.signum(Velocity.getY-impl(arg4)));
    }

    private static final float doFlingAnimation_QWom1Mo$toMagnitudeFloat(long arg6) {
        return ((float)Math.sqrt(((double)((((float)Math.pow(((double)Float.intBitsToFloat(((int)(arg6 >> 0x20)))), 2))) + (((float)Math.pow(((double)Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL)))), 2)))))));
    }

    public final Scrollable2DState getScrollableState() {
        return this.scrollableState;
    }

    public boolean isFlinging() {
        return this.isFlinging;
    }

    public final Object onScrollStopped-sF-c-tU(long arg3, Continuation arg5) {
        Object v2;
        ScrollingLogic2D$onScrollStopped$performFling$1 v0 = new ScrollingLogic2D$onScrollStopped$performFling$1(this, null);
        OverscrollEffect v1 = this.overscrollEffect;
        if(v1 != null && (this.shouldDispatchOverscroll-TH1AsA0(arg3))) {
            v2 = v1.applyToFling-BMRW4eQ(arg3, ((Function2)v0), arg5);
            if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v2;
            }
            else {
                return Unit.INSTANCE;
            }
        }

        v2 = ((Function2)v0).invoke(Velocity.box-impl(arg3), arg5);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    public long performRawScroll-MK-Hz9U(long arg2) {
        if(this.scrollableState.isScrollInProgress()) {
            return Offset.Companion.getZero-F1C5BW0();
        }

        return this.dispatchRawDelta-MK-Hz9U(arg2);
    }

    private final long performScroll-3eAAhYA(Scroll2DScope arg9, long arg10, int arg12) {
        long v0 = this.nestedScrollDispatcher.dispatchPreScroll-OzD1aCk(arg10, arg12);
        arg10 = Offset.minus-MK-Hz9U(arg10, v0);
        long v3 = arg9.scrollBy-MK-Hz9U(arg10);
        return Offset.plus-MK-Hz9U(Offset.plus-MK-Hz9U(v0, v3), this.nestedScrollDispatcher.dispatchPostScroll-DzOQY0M(v3, Offset.minus-MK-Hz9U(arg10, v3), arg12));
    }

    static final Offset performScrollForOverscroll$lambda$0(ScrollingLogic2D arg3, Offset arg4) {
        return Offset.box-impl(arg3.performScroll-3eAAhYA(arg3.outerStateScope, arg4.unbox-impl(), arg3.latestScrollSource));
    }

    public final Object scroll(MutatePriority arg4, Function2 arg5, Continuation arg6) {
        Object v3 = this.scrollableState.scroll(arg4, new ScrollingLogic2D$scroll$2(this, arg5, null), arg6);
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v3;
        }

        return Unit.INSTANCE;
    }

    public static Object scroll$default(ScrollingLogic2D arg0, MutatePriority arg1, Function2 arg2, Continuation arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = MutatePriority.Default;
        }

        return arg0.scroll(arg1, arg2, arg3);
    }

    public final void setScrollableState(Scrollable2DState arg1) {
        this.scrollableState = arg1;
    }

    public final boolean shouldDispatchOverscroll-TH1AsA0(long arg5) {
        return this.scrollableState.canScroll-k-4lQ0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(Velocity.getY-impl(arg5)))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Velocity.getX-impl(arg5)))) << 0x20));
    }

    public final boolean shouldDispatchOverscroll-k-4lQ0M(long arg1) {
        return this.scrollableState.canScroll-k-4lQ0M(arg1);
    }

    public final boolean shouldScrollImmediately() {
        if(!this.scrollableState.isScrollInProgress()) {
            OverscrollEffect v1 = this.overscrollEffect;
            boolean v1_1 = v1 != null ? v1.isInProgress() : false;
            if(v1_1) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    public final boolean update(Scrollable2DState arg2, OverscrollEffect arg3, FlingBehavior arg4, NestedScrollDispatcher arg5) {
        boolean v2;
        if(!Intrinsics.areEqual(this.scrollableState, arg2)) {
            this.scrollableState = arg2;
            v2 = true;
        }
        else {
            v2 = false;
        }

        this.overscrollEffect = arg3;
        this.flingBehavior = arg4;
        this.nestedScrollDispatcher = arg5;
        return v2;
    }
}

