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

@Metadata(d1={"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001:\b\u0001\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u001B\u001A\u00020\u001C*\u00020\u001D¢\u0006\u0004\b\u001E\u0010\u001FJ\u0011\u0010 \u001A\u00020\u001C*\u00020\u001C¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001A\u00020\u001D*\u00020\u001C¢\u0006\u0004\b$\u0010%J\u0011\u0010&\u001A\u00020\u001D*\u00020\u001C¢\u0006\u0004\b\'\u0010%J\u0011\u0010(\u001A\u00020)*\u00020\u001D¢\u0006\u0004\b*\u0010\u001FJ\u0013\u0010#\u001A\u00020\u001D*\u00020)H\u0002¢\u0006\u0004\b+\u0010%J\u0013\u0010,\u001A\u00020)*\u00020)H\u0002¢\u0006\u0004\b-\u0010\"J\u001B\u0010.\u001A\u00020)*\u00020)2\u0006\u0010/\u001A\u00020\u001DH\u0002¢\u0006\u0004\b0\u00101J\n\u00102\u001A\u00020\u001D*\u00020\u001DJ\u0011\u00102\u001A\u00020\u001C*\u00020\u001C¢\u0006\u0004\b3\u0010\"J#\u0010>\u001A\u00020\u001C*\u0002082\u0006\u0010?\u001A\u00020\u001C2\u0006\u0010@\u001A\u000205H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010E\u001A\u00020\u001C2\u0006\u0010F\u001A\u00020\u001CH\u0016¢\u0006\u0004\bG\u0010\"J\u0017\u0010H\u001A\u00020\u001C2\u0006\u0010F\u001A\u00020\u001CH\u0002¢\u0006\u0004\bI\u0010\"J \u0010J\u001A\u00020K2\u0006\u0010L\u001A\u00020)2\u0006\u0010M\u001A\u00020\u000BH\u0086@¢\u0006\u0004\bN\u0010OJ\u0018\u0010P\u001A\u00020)2\u0006\u0010Q\u001A\u00020)H\u0096@¢\u0006\u0004\bR\u0010SJ\u0006\u0010T\u001A\u00020\u000BJA\u0010F\u001A\u00020K2\b\b\u0002\u0010U\u001A\u00020V2\'\u0010W\u001A#\b\u0001\u0012\u0004\u0012\u00020Y\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0Z\u0012\u0006\u0012\u0004\u0018\u00010[0X¢\u0006\u0002\b\\H\u0086@¢\u0006\u0002\u0010]J8\u0010.\u001A\u00020\u000B2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\t2\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rJ\u0006\u0010^\u001A\u00020\u000BR\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u0019\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u000B@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0010\u00104\u001A\u000205X\u0082\u000E¢\u0006\u0004\n\u0002\u00106R\u000E\u00107\u001A\u000208X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00109\u001A\u00020:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;R\u001A\u0010<\u001A\u000E\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\u001C0=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010C\u001A\u00020\u000B8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bD\u0010\u001A¨\u0006_"}, d2={"Landroidx/compose/foundation/gestures/ScrollingLogic;", "Landroidx/compose/foundation/gestures/ScrollLogic;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "onScrollChangedDispatcher", "Landroidx/compose/foundation/gestures/OnScrollChangedDispatcher;", "isScrollableNodeAttached", "Lkotlin/Function0;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroidx/compose/foundation/gestures/OnScrollChangedDispatcher;Lkotlin/jvm/functions/Function0;)V", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "setScrollableState", "(Landroidx/compose/foundation/gestures/ScrollableState;)V", "value", "isFlinging", "()Z", "toOffset", "Landroidx/compose/ui/geometry/Offset;", "", "toOffset-tuRUvjQ", "(F)J", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "(J)J", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toSingleAxisDeltaFromAngle", "toSingleAxisDeltaFromAngle-k-4lQ0M", "toVelocity", "Landroidx/compose/ui/unit/Velocity;", "toVelocity-adjELrA", "toFloat-TH1AsA0", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "update", "newValue", "update-QWom1Mo", "(JF)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "latestScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "I", "outerStateScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "nestedScrollScope", "androidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1", "Landroidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1;", "performScrollForOverscroll", "Lkotlin/Function1;", "performScroll", "delta", "source", "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "shouldDispatchOverscroll", "getShouldDispatchOverscroll", "performRawScroll", "scroll", "performRawScroll-MK-Hz9U", "dispatchRawDelta", "dispatchRawDelta-MK-Hz9U", "onScrollStopped", "", "initialVelocity", "isMouseWheel", "onScrollStopped-BMRW4eQ", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doFlingAnimation", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldScrollImmediately", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isVertical", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ScrollingLogic implements ScrollLogic {
    public static final int $stable = 8;
    private FlingBehavior flingBehavior;
    private boolean isFlinging;
    private final Function0 isScrollableNodeAttached;
    private int latestScrollSource;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private final ScrollingLogic$nestedScrollScope$1 nestedScrollScope;
    private OnScrollChangedDispatcher onScrollChangedDispatcher;
    private Orientation orientation;
    private ScrollScope outerStateScope;
    private OverscrollEffect overscrollEffect;
    private final Function1 performScrollForOverscroll;
    private boolean reverseDirection;
    private ScrollableState scrollableState;

    static {
    }

    public ScrollingLogic(ScrollableState arg1, OverscrollEffect arg2, FlingBehavior arg3, Orientation arg4, boolean arg5, NestedScrollDispatcher arg6, OnScrollChangedDispatcher arg7, Function0 arg8) {
        super();
        this.scrollableState = arg1;
        this.overscrollEffect = arg2;
        this.flingBehavior = arg3;
        this.orientation = arg4;
        this.reverseDirection = arg5;
        this.nestedScrollDispatcher = arg6;
        this.onScrollChangedDispatcher = arg7;
        this.isScrollableNodeAttached = arg8;
        this.latestScrollSource = NestedScrollSource.Companion.getUserInput-WNlRxjI();
        this.outerStateScope = ScrollableKt.NoOpScrollScope;
        this.nestedScrollScope = new ScrollingLogic$nestedScrollScope$1(this);
        this.performScrollForOverscroll = new ScrollingLogic$$ExternalSyntheticLambda0(this);
    }

    public static final FlingBehavior access$getFlingBehavior$p(ScrollingLogic arg0) {
        return arg0.flingBehavior;
    }

    public static final int access$getLatestScrollSource$p(ScrollingLogic arg0) {
        return arg0.latestScrollSource;
    }

    public static final NestedScrollDispatcher access$getNestedScrollDispatcher$p(ScrollingLogic arg0) {
        return arg0.nestedScrollDispatcher;
    }

    public static final ScrollingLogic$nestedScrollScope$1 access$getNestedScrollScope$p(ScrollingLogic arg0) {
        return arg0.nestedScrollScope;
    }

    public static final ScrollScope access$getOuterStateScope$p(ScrollingLogic arg0) {
        return arg0.outerStateScope;
    }

    public static final OverscrollEffect access$getOverscrollEffect$p(ScrollingLogic arg0) {
        return arg0.overscrollEffect;
    }

    public static final Function1 access$getPerformScrollForOverscroll$p(ScrollingLogic arg0) {
        return arg0.performScrollForOverscroll;
    }

    public static final boolean access$getShouldDispatchOverscroll(ScrollingLogic arg0) {
        return arg0.getShouldDispatchOverscroll();
    }

    public static final Function0 access$isScrollableNodeAttached$p(ScrollingLogic arg0) {
        return arg0.isScrollableNodeAttached;
    }

    public static final long access$performScroll-3eAAhYA(ScrollingLogic arg0, ScrollScope arg1, long arg2, int arg4) {
        return arg0.performScroll-3eAAhYA(arg1, arg2, arg4);
    }

    public static final void access$setLatestScrollSource$p(ScrollingLogic arg0, int arg1) {
        arg0.latestScrollSource = arg1;
    }

    public static final void access$setOuterStateScope$p(ScrollingLogic arg0, ScrollScope arg1) {
        arg0.outerStateScope = arg1;
    }

    public static final float access$toFloat-TH1AsA0(ScrollingLogic arg0, long arg1) {
        return arg0.toFloat-TH1AsA0(arg1);
    }

    public static final long access$update-QWom1Mo(ScrollingLogic arg0, long arg1, float arg3) {
        return arg0.update-QWom1Mo(arg1, arg3);
    }

    private final long dispatchRawDelta-MK-Hz9U(long arg2) {
        return this.toOffset-tuRUvjQ(this.reverseIfNeeded(this.scrollableState.dispatchRawDelta(this.reverseIfNeeded(this.toFloat-k-4lQ0M(arg2)))));
    }

    public Object doFlingAnimation-QWom1Mo(long arg12, Continuation arg14) {
        Throwable v12_1;
        ScrollingLogic v6;
        LongRef v12_2;
        long v8;
        Continuation v10;
        int v2;
        Continuation v0;
        if((arg14 instanceof ScrollingLogic$doFlingAnimation$1)) {
            v0 = arg14;
            v2 = 0x80000000;
            if((((ScrollingLogic$doFlingAnimation$1)v0).label & v2) != 0) {
                ((ScrollingLogic$doFlingAnimation$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ScrollingLogic$doFlingAnimation$1 v0_1 = new ScrollingLogic$doFlingAnimation$1(this, arg14);
        }

        Object v14 = ((ScrollingLogic$doFlingAnimation$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((ScrollingLogic$doFlingAnimation$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v14);
            LongRef v7 = new LongRef();
            v7.element = arg12;
            this.isFlinging = true;
            try {
                MutatePriority v14_1 = MutatePriority.Default;
                v10 = null;
                v6 = this;
                v8 = arg12;
            }
            catch(Throwable v0_2) {
                v6 = this;
                goto label_57;
            }

            try {
                ScrollingLogic$doFlingAnimation$2 v5 = new ScrollingLogic$doFlingAnimation$2(v6, v7, v8, v10);
                ((ScrollingLogic$doFlingAnimation$1)v0).L$0 = v7;
                ((ScrollingLogic$doFlingAnimation$1)v0).label = 1;
                if(v6.scroll(v14_1, ((Function2)v5), v0) != v1) {
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
            v12_2 = v7;
        }
        else if(v2 == 1) {
            Object v12 = ((ScrollingLogic$doFlingAnimation$1)v0).L$0;
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

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    private final boolean getShouldDispatchOverscroll() {
        if(!this.scrollableState.getCanScrollForward()) {
            if(this.scrollableState.getCanScrollBackward()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean isFlinging() {
        return this.isFlinging;
    }

    public final boolean isVertical() {
        if(this.orientation == Orientation.Vertical) {
            return 1;
        }

        return 0;
    }

    public final Object onScrollStopped-BMRW4eQ(long arg2, boolean arg4, Continuation arg5) {
        Object v1;
        if((arg4) && !ScrollableKt.getShouldBeTriggeredByMouseWheel(this.flingBehavior)) {
            return Unit.INSTANCE;
        }

        arg2 = this.singleAxisVelocity-AH228Gc(arg2);
        ScrollingLogic$onScrollStopped$performFling$1 v4 = new ScrollingLogic$onScrollStopped$performFling$1(this, null);
        OverscrollEffect v0 = this.overscrollEffect;
        if(v0 != null && (this.getShouldDispatchOverscroll())) {
            v1 = v0.applyToFling-BMRW4eQ(arg2, ((Function2)v4), arg5);
            if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v1;
            }
            else {
                return Unit.INSTANCE;
            }
        }

        v1 = ((Function2)v4).invoke(Velocity.box-impl(arg2), arg5);
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }

    public long performRawScroll-MK-Hz9U(long arg2) {
        if(this.scrollableState.isScrollInProgress()) {
            return Offset.Companion.getZero-F1C5BW0();
        }

        return this.dispatchRawDelta-MK-Hz9U(arg2);
    }

    private final long performScroll-3eAAhYA(ScrollScope arg11, long arg12, int arg14) {
        long v0 = this.nestedScrollDispatcher.dispatchPreScroll-OzD1aCk(arg12, arg14);
        arg12 = Offset.minus-MK-Hz9U(arg12, v0);
        long v5 = this.reverseIfNeeded-MK-Hz9U(this.toOffset-tuRUvjQ(arg11.scrollBy(this.toFloat-k-4lQ0M(this.reverseIfNeeded-MK-Hz9U(this.singleAxisOffset-MK-Hz9U(arg12))))));
        this.onScrollChangedDispatcher.dispatchScrollDeltaInfo-k-4lQ0M(v5);
        return Offset.plus-MK-Hz9U(Offset.plus-MK-Hz9U(v0, v5), this.nestedScrollDispatcher.dispatchPostScroll-DzOQY0M(v5, Offset.minus-MK-Hz9U(arg12, v5), arg14));
    }

    static final Offset performScrollForOverscroll$lambda$0(ScrollingLogic arg3, Offset arg4) {
        return Offset.box-impl(arg3.performScroll-3eAAhYA(arg3.outerStateScope, arg4.unbox-impl(), arg3.latestScrollSource));
    }

    public final float reverseIfNeeded(float arg1) {
        if(this.reverseDirection) {
            arg1 *= -1f;
        }

        return arg1;
    }

    public final long reverseIfNeeded-MK-Hz9U(long arg1) {
        if(this.reverseDirection) {
            return Offset.times-tuRUvjQ(arg1, -1f);
        }

        return arg1;
    }

    public final Object scroll(MutatePriority arg4, Function2 arg5, Continuation arg6) {
        Object v3 = this.scrollableState.scroll(arg4, new ScrollingLogic$scroll$2(this, arg5, null), arg6);
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v3;
        }

        return Unit.INSTANCE;
    }

    public static Object scroll$default(ScrollingLogic arg0, MutatePriority arg1, Function2 arg2, Continuation arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = MutatePriority.Default;
        }

        return arg0.scroll(arg1, arg2, arg3);
    }

    public final void setScrollableState(ScrollableState arg1) {
        this.scrollableState = arg1;
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

    public final long singleAxisOffset-MK-Hz9U(long arg8) {
        if(this.orientation == Orientation.Horizontal) {
            return Offset.copy-dBAh8RU$default(arg8, 0f, 0f, 1, null);
        }

        return Offset.copy-dBAh8RU$default(arg8, 0f, 0f, 2, null);
    }

    private final long singleAxisVelocity-AH228Gc(long arg8) {
        if(this.orientation == Orientation.Horizontal) {
            return Velocity.copy-OhffZ5M$default(arg8, 0f, 0f, 1, null);
        }

        return Velocity.copy-OhffZ5M$default(arg8, 0f, 0f, 2, null);
    }

    private final float toFloat-TH1AsA0(long arg2) {
        if(this.orientation == Orientation.Horizontal) {
            return Velocity.getX-impl(arg2);
        }

        return Velocity.getY-impl(arg2);
    }

    public final float toFloat-k-4lQ0M(long arg3) {
        long v2 = this.orientation == Orientation.Horizontal ? arg3 >> 0x20 : arg3 & 0xFFFFFFFFL;
        return Float.intBitsToFloat(((int)v2));
    }

    public final long toOffset-tuRUvjQ(float arg6) {
        if(arg6 == 0f) {
            return Offset.Companion.getZero-F1C5BW0();
        }

        long v2 = 0xFFFFFFFFL;
        int v4 = 0x20;
        if(this.orientation == Orientation.Horizontal) {
            return Offset.constructor-impl((((long)Float.floatToRawIntBits(arg6))) << v4 | (((long)Float.floatToRawIntBits(0f))) & v2);
        }

        return Offset.constructor-impl((((long)Float.floatToRawIntBits(arg6))) & v2 | (((long)Float.floatToRawIntBits(0f))) << v4);
    }

    public final float toSingleAxisDeltaFromAngle-k-4lQ0M(long arg6) {
        int v0 = ((int)(0xFFFFFFFFL & arg6));
        int v6 = ((int)(arg6 >> 0x20));
        int v7 = Double.compare(((double)(((float)Math.atan2(((double)Math.abs(Float.intBitsToFloat(v0))), ((double)Math.abs(Float.intBitsToFloat(v6))))))), 0.785398);
        Orientation v5 = this.orientation;
        if(v7 >= 0) {
            if(v5 == Orientation.Vertical) {
                return Float.intBitsToFloat(v0);
            }

            return 0;
        }

        if(v5 == Orientation.Horizontal) {
            return Float.intBitsToFloat(v6);
        }

        return 0;
    }

    public final long toVelocity-adjELrA(float arg3) {
        if(arg3 == 0f) {
            return Velocity.Companion.getZero-9UxMQ8M();
        }

        if(this.orientation == Orientation.Horizontal) {
            return VelocityKt.Velocity(arg3, 0f);
        }

        return VelocityKt.Velocity(0f, arg3);
    }

    public final boolean update(ScrollableState arg3, Orientation arg4, OverscrollEffect arg5, boolean arg6, FlingBehavior arg7, NestedScrollDispatcher arg8) {
        boolean v3;
        boolean v1 = true;
        if(!Intrinsics.areEqual(this.scrollableState, arg3)) {
            this.scrollableState = arg3;
            v3 = true;
        }
        else {
            v3 = false;
        }

        this.overscrollEffect = arg5;
        if(this.orientation != arg4) {
            this.orientation = arg4;
            v3 = true;
        }

        if(this.reverseDirection != arg6) {
            this.reverseDirection = arg6;
        }
        else {
            v1 = v3;
        }

        this.flingBehavior = arg7;
        this.nestedScrollDispatcher = arg8;
        return v1;
    }

    private final long update-QWom1Mo(long arg8, float arg10) {
        if(this.orientation == Orientation.Horizontal) {
            return Velocity.copy-OhffZ5M$default(arg8, arg10, 0f, 2, null);
        }

        return Velocity.copy-OhffZ5M$default(arg8, 0f, arg10, 1, null);
    }
}

