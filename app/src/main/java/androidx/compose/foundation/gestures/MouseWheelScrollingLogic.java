package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1={"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001SBR\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u00121\u0010\u0006\u001A-\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\u0006\u0010\u000E\u001A\u00020\u000F¢\u0006\u0004\b\u0010\u0010\u0011J\u000E\u0010\u0013\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FJ%\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A¢\u0006\u0004\b\u001B\u0010\u001CJ\f\u0010 \u001A\u00020\r*\u00020\u0016H\u0002J\u000E\u0010\'\u001A\u00020\r2\u0006\u0010(\u001A\u00020)J;\u0010*\u001A\u00020\r*\u00020\u00032\'\u0010+\u001A#\b\u0001\u0012\u0004\u0012\u00020,\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\b-H\u0082@¢\u0006\u0002\u0010.J\u001F\u0010/\u001A\u00020\u001E2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u001AH\u0002¢\u0006\u0004\b0\u00101J\u0014\u00102\u001A\u0004\u0018\u00010#*\b\u0012\u0004\u0012\u00020#0\"H\u0002J\u0018\u00103\u001A\u00020#*\b\u0012\u0004\u0012\u00020#0\"H\u0082@¢\u0006\u0002\u00104J$\u00105\u001A\b\u0012\u0004\u0012\u0002H706\"\u0004\b\u0000\u001072\u000E\u00108\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001H709H\u0002J\u001B\u0010:\u001A\u00020\u001E*\u00020\u00032\u0006\u0010;\u001A\u00020<H\u0002¢\u0006\u0004\b=\u0010>J\u0010\u0010A\u001A\u00020\r2\u0006\u0010;\u001A\u00020#H\u0002J*\u0010B\u001A\u00020\r*\u00020\u00032\u0006\u0010;\u001A\u00020#2\u0006\u0010C\u001A\u00020D2\u0006\u0010E\u001A\u00020DH\u0082@¢\u0006\u0002\u0010FJY\u0010G\u001A\u00020\r*\u00020,2\u0012\u0010H\u001A\u000E\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020J0I2\u0006\u0010K\u001A\u00020D2\u0006\u0010L\u001A\u00020M2!\u0010N\u001A\u001D\u0012\u0013\u0012\u00110D¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020\u001E0OH\u0082@¢\u0006\u0002\u0010QJ\u0014\u0010B\u001A\u00020D*\u00020,2\u0006\u0010R\u001A\u00020DH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R;\u0010\u0006\u001A-\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0019\u0010\u001D\u001A\u00020\u001E*\u00020\u00168Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001FR\u0014\u0010!\u001A\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010%\u001A\u0004\u0018\u00010&X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010?\u001A\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2={"Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic;", "", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "mouseWheelScrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "onScrollStopped", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Velocity;", "Lkotlin/ParameterName;", "name", "velocity", "Lkotlin/coroutines/Continuation;", "", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/unit/Density;)V", "Lkotlin/jvm/functions/Function2;", "updateDensity", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "isConsumed", "", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "consume", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "isScrolling", "receivingMouseWheelEventsJob", "Lkotlinx/coroutines/Job;", "startReceivingMouseWheelEvents", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "userScroll", "block", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onMouseWheel", "onMouseWheel-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "sumOrNull", "busyReceive", "(Lkotlinx/coroutines/channels/Channel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "untilNull", "Lkotlin/sequences/Sequence;", "E", "builderAction", "Lkotlin/Function0;", "canConsumeDelta", "scrollDelta", "Landroidx/compose/ui/geometry/Offset;", "canConsumeDelta-Uv8p0NA", "(Landroidx/compose/foundation/gestures/ScrollingLogic;J)Z", "velocityTracker", "Landroidx/compose/foundation/gestures/MouseWheelVelocityTracker;", "trackVelocity", "dispatchMouseWheelScroll", "threshold", "", "speed", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateMouseWheelScroll", "animationState", "Landroidx/compose/animation/core/AnimationState;", "Landroidx/compose/animation/core/AnimationVector1D;", "targetValue", "durationMillis", "", "shouldCancelAnimation", "Lkotlin/Function1;", "lastValue", "(Landroidx/compose/foundation/gestures/NestedScrollScope;Landroidx/compose/animation/core/AnimationState;FILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delta", "MouseWheelScrollDelta", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MouseWheelScrollingLogic {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0010\u001A\u00020\u00002\u0006\u0010\u0011\u001A\u00020\u0000H\u0086\u0002J\u0010\u0010\u0012\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000BJ\t\u0010\u0014\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0007HÆ\u0003J.\u0010\u0016\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001A\u00020\u00072\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001E"}, d2={"Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "", "value", "Landroidx/compose/ui/geometry/Offset;", "timeMillis", "", "shouldApplyImmediately", "", "<init>", "(JJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-F1C5BW0", "()J", "J", "getTimeMillis", "getShouldApplyImmediately", "()Z", "plus", "other", "component1", "component1-F1C5BW0", "component2", "component3", "copy", "copy-9KIMszo", "(JJZ)Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "equals", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class MouseWheelScrollDelta {
        private final boolean shouldApplyImmediately;
        private final long timeMillis;
        private final long value;

        public MouseWheelScrollDelta(long arg1, long arg3, boolean arg5, DefaultConstructorMarker arg6) {
            this(arg1, arg3, arg5);
        }

        private MouseWheelScrollDelta(long arg1, long arg3, boolean arg5) {
            super();
            this.value = arg1;
            this.timeMillis = arg3;
            this.shouldApplyImmediately = arg5;
        }

        public final long component1-F1C5BW0() {
            return this.value;
        }

        public final long component2() {
            return this.timeMillis;
        }

        public final boolean component3() {
            return this.shouldApplyImmediately;
        }

        public final MouseWheelScrollDelta copy-9KIMszo(long arg8, long arg10, boolean arg12) {
            return new MouseWheelScrollDelta(arg8, arg10, arg12, null);
        }

        public static MouseWheelScrollDelta copy-9KIMszo$default(MouseWheelScrollDelta arg6, long arg7, long arg9, boolean arg11, int arg12, Object arg13) {
            if((arg12 & 1) != 0) {
                arg7 = arg6.value;
            }

            long v1 = arg7;
            if((arg12 & 2) != 0) {
                arg9 = arg6.timeMillis;
            }

            long v3 = arg9;
            if((arg12 & 4) != 0) {
                arg11 = arg6.shouldApplyImmediately;
            }

            return arg6.copy-9KIMszo(v1, v3, arg11);
        }

        public boolean equals(Object arg8) {
            if(this == (((MouseWheelScrollDelta)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof MouseWheelScrollDelta)) {
                return 0;
            }

            if(!Offset.equals-impl0(this.value, ((MouseWheelScrollDelta)arg8).value)) {
                return 0;
            }

            if(this.timeMillis != ((MouseWheelScrollDelta)arg8).timeMillis) {
                return 0;
            }

            if(this.shouldApplyImmediately != ((MouseWheelScrollDelta)arg8).shouldApplyImmediately) {
                return 0;
            }

            return 1;
        }

        public final boolean getShouldApplyImmediately() {
            return this.shouldApplyImmediately;
        }

        public final long getTimeMillis() {
            return this.timeMillis;
        }

        public final long getValue-F1C5BW0() {
            return this.value;
        }

        public int hashCode() {
            return (Offset.hashCode-impl(this.value) * 0x1F + Long.hashCode(this.timeMillis)) * 0x1F + Boolean.hashCode(this.shouldApplyImmediately);
        }

        public final MouseWheelScrollDelta plus(MouseWheelScrollDelta arg8) {
            return new MouseWheelScrollDelta(Offset.plus-MK-Hz9U(this.value, arg8.value), Math.max(this.timeMillis, arg8.timeMillis), this.shouldApplyImmediately, null);
        }

        public String toString() {
            return "MouseWheelScrollDelta(value=" + Offset.toString-impl(this.value) + ", timeMillis=" + this.timeMillis + ", shouldApplyImmediately=" + this.shouldApplyImmediately + ')';
        }
    }

    public static final int $stable = 8;
    private final Channel channel;
    private Density density;
    private boolean isScrolling;
    private final ScrollConfig mouseWheelScrollConfig;
    private final Function2 onScrollStopped;
    private Job receivingMouseWheelEventsJob;
    private final ScrollingLogic scrollingLogic;
    private final MouseWheelVelocityTracker velocityTracker;

    static {
    }

    public MouseWheelScrollingLogic(ScrollingLogic arg1, ScrollConfig arg2, Function2 arg3, Density arg4) {
        super();
        this.scrollingLogic = arg1;
        this.mouseWheelScrollConfig = arg2;
        this.onScrollStopped = arg3;
        this.density = arg4;
        this.channel = ChannelKt.Channel$default(0x7FFFFFFF, null, null, 6, null);
        this.velocityTracker = new MouseWheelVelocityTracker();
    }

    public static final Object access$animateMouseWheelScroll(MouseWheelScrollingLogic arg0, NestedScrollScope arg1, AnimationState arg2, float arg3, int arg4, Function1 arg5, Continuation arg6) {
        return arg0.animateMouseWheelScroll(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static final Object access$busyReceive(MouseWheelScrollingLogic arg0, Channel arg1, Continuation arg2) {
        return arg0.busyReceive(arg1, arg2);
    }

    public static final float access$dispatchMouseWheelScroll(MouseWheelScrollingLogic arg0, NestedScrollScope arg1, float arg2) {
        return arg0.dispatchMouseWheelScroll(arg1, arg2);
    }

    public static final Object access$dispatchMouseWheelScroll(MouseWheelScrollingLogic arg0, ScrollingLogic arg1, MouseWheelScrollDelta arg2, float arg3, float arg4, Continuation arg5) {
        return arg0.dispatchMouseWheelScroll(arg1, arg2, arg3, arg4, arg5);
    }

    public static final Object access$dispatchMouseWheelScroll$waitNextScrollDelta(MouseWheelScrollingLogic arg0, ObjectRef arg1, FloatRef arg2, ScrollingLogic arg3, ObjectRef arg4, long arg5, Continuation arg7) {
        return MouseWheelScrollingLogic.dispatchMouseWheelScroll$waitNextScrollDelta(arg0, arg1, arg2, arg3, arg4, arg5, arg7);
    }

    public static final Channel access$getChannel$p(MouseWheelScrollingLogic arg0) {
        return arg0.channel;
    }

    public static final Density access$getDensity$p(MouseWheelScrollingLogic arg0) {
        return arg0.density;
    }

    public static final ScrollingLogic access$getScrollingLogic$p(MouseWheelScrollingLogic arg0) {
        return arg0.scrollingLogic;
    }

    public static final void access$setReceivingMouseWheelEventsJob$p(MouseWheelScrollingLogic arg0, Job arg1) {
        arg0.receivingMouseWheelEventsJob = arg1;
    }

    public static final MouseWheelScrollDelta access$sumOrNull(MouseWheelScrollingLogic arg0, Channel arg1) {
        return arg0.sumOrNull(arg1);
    }

    public static final void access$trackVelocity(MouseWheelScrollingLogic arg0, MouseWheelScrollDelta arg1) {
        arg0.trackVelocity(arg1);
    }

    public static final Object access$userScroll(MouseWheelScrollingLogic arg0, ScrollingLogic arg1, Function2 arg2, Continuation arg3) {
        return arg0.userScroll(arg1, arg2, arg3);
    }

    private final Object animateMouseWheelScroll(NestedScrollScope arg6, AnimationState arg7, float arg8, int arg9, Function1 arg10, Continuation arg11) {
        FloatRef v0 = new FloatRef();
        v0.element = arg7.getValue().floatValue();
        Object v5 = SuspendAnimationKt.animateTo(arg7, Boxing.boxFloat(arg8), AnimationSpecKt.tween$default(arg9, 0, EasingKt.getLinearEasing(), 2, null), true, new MouseWheelScrollingLogic$$ExternalSyntheticLambda1(v0, this, arg6, arg10), arg11);
        if(v5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v5;
        }

        return Unit.INSTANCE;
    }

    static final Unit animateMouseWheelScroll$lambda$0(FloatRef arg2, MouseWheelScrollingLogic arg3, NestedScrollScope arg4, Function1 arg5, AnimationScope arg6) {
        float v0 = arg6.getValue().floatValue() - arg2.element;
        if(!MouseWheelScrollableKt.isLowScrollingDelta(v0)) {
            if(!MouseWheelScrollableKt.isLowScrollingDelta(v0 - arg3.dispatchMouseWheelScroll(arg4, v0))) {
                arg6.cancelAnimation();
                return Unit.INSTANCE;
            }
            else {
                arg2.element += v0;
            }
        }

        if(arg5.invoke(Float.valueOf(arg2.element)).booleanValue()) {
            arg6.cancelAnimation();
        }

        return Unit.INSTANCE;
    }

    private final Object busyReceive(Channel arg2, Continuation arg3) {
        return CoroutineScopeKt.coroutineScope(new MouseWheelScrollingLogic$busyReceive$2(arg2, null), arg3);
    }

    private final boolean canConsumeDelta-Uv8p0NA(ScrollingLogic arg1, long arg2) {
        float v0 = ComposeFoundationFlags.isMouseWheel1DAxisLockingEnabled ? arg1.toSingleAxisDeltaFromAngle-k-4lQ0M(arg1.reverseIfNeeded-MK-Hz9U(arg2)) : arg1.toFloat-k-4lQ0M(arg1.reverseIfNeeded-MK-Hz9U(arg2));
        if(v0 == 0f) {
            return 0;
        }

        if(v0 > 0f) {
            return arg1.getScrollableState().getCanScrollForward();
        }

        return arg1.getScrollableState().getCanScrollBackward();
    }

    private final void consume(PointerEvent arg3) {
        List v2 = arg3.getChanges();
        int v3 = v2.size();
        int v0;
        for(v0 = 0; v0 < v3; ++v0) {
            v2.get(v0).consume();
        }
    }

    private final float dispatchMouseWheelScroll(NestedScrollScope arg3, float arg4) {
        return this.scrollingLogic.toFloat-k-4lQ0M(this.scrollingLogic.reverseIfNeeded-MK-Hz9U(arg3.scrollBy-OzD1aCk(this.scrollingLogic.toOffset-tuRUvjQ(this.scrollingLogic.reverseIfNeeded(arg4)), NestedScrollSource.Companion.getUserInput-WNlRxjI())));
    }

    private final Object dispatchMouseWheelScroll(ScrollingLogic arg23, MouseWheelScrollDelta arg24, float arg25, float arg26, Continuation arg27) {
        Object v3;
        float v0_1;
        MouseWheelScrollingLogic$dispatchMouseWheelScroll$1 v2_1;
        MouseWheelScrollingLogic v5 = this;
        ScrollingLogic v7 = arg23;
        MouseWheelScrollDelta v0 = arg24;
        Continuation v1 = arg27;
        if((v1 instanceof MouseWheelScrollingLogic$dispatchMouseWheelScroll$1)) {
            Continuation v2 = v1;
            int v4 = 0x80000000;
            if((((MouseWheelScrollingLogic$dispatchMouseWheelScroll$1)v2).label & v4) != 0) {
                ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$1)v2).label -= v4;
            }
            else {
                goto label_15;
            }
        }
        else {
        label_15:
            v2_1 = new MouseWheelScrollingLogic$dispatchMouseWheelScroll$1(v5, v1);
        }

        Continuation v9 = ((Continuation)v2_1);
        Object v1_1 = ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$1)v9).result;
        Object v10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v2_2 = ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$1)v9).label;
        int v11 = 2;
        if(v2_2 == 0) {
            ResultKt.throwOnFailure(v1_1);
            ObjectRef v3_1 = new ObjectRef();
            v3_1.element = v0;
            v5.trackVelocity(v0);
            v0 = v5.sumOrNull(v5.channel);
            if(v0 != null) {
                v5.trackVelocity(v0);
                v3_1.element = v3_1.element.plus(v0);
            }

            FloatRef v1_2 = new FloatRef();
            v1_2.element = v7.toFloat-k-4lQ0M(v7.reverseIfNeeded-MK-Hz9U(v3_1.element.getValue-F1C5BW0()));
            if(MouseWheelScrollableKt.isLowScrollingDelta(v1_2.element)) {
                return Unit.INSTANCE;
            }

            ObjectRef v2_4 = new ObjectRef();
            v2_4.element = AnimationStateKt.AnimationState$default(0f, 0f, 0, 0, false, 30, null);
            float v6 = arg26;
            MouseWheelScrollingLogic$dispatchMouseWheelScroll$3 v0_2 = new MouseWheelScrollingLogic$dispatchMouseWheelScroll$3(v1_2, v2_4, v3_1, arg25, v5, v6, v7, null);
            ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$1)v9).L$0 = v7;
            ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$1)v9).L$1 = v1_2;
            ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$1)v9).F$0 = v6;
            ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$1)v9).label = 1;
            if(v5.userScroll(v7, ((Function2)v0_2), v9) != v10) {
                FloatRef v2_5 = v1_2;
                v0_1 = v6;
                ScrollingLogic v3_2 = v7;
            label_87:
                long v6_1 = v5.velocityTracker.calculateVelocity-9UxMQ8M();
                if(Velocity.equals-impl0(v6_1, Velocity.Companion.getZero-9UxMQ8M())) {
                    v6_1 = ((ScrollingLogic)v3).toVelocity-adjELrA(((ScrollingLogic)v3).reverseIfNeeded(Math.signum(v2_5.element)) * Math.min(Math.abs(v2_5.element) / 100f, v0_1) * 1000f);
                }

                Function2 v0_3 = v5.onScrollStopped;
                Velocity v1_3 = Velocity.box-impl(v6_1);
                ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$1)v9).L$0 = null;
                ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$1)v9).L$1 = null;
                ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$1)v9).label = v11;
                if(v0_3.invoke(v1_3, v9) != v10) {
                    goto label_114;
                }
            }

            return v10;
        }
        else if(v2_2 == 1) {
            v0_1 = ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$1)v9).F$0;
            Object v2_3 = ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$1)v9).L$1;
            v3 = ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$1)v9).L$0;
            ResultKt.throwOnFailure(v1_1);
            goto label_87;
        }
        else if(v2_2 == v11) {
            ResultKt.throwOnFailure(v1_1);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_114:
        return Unit.INSTANCE;
    }

    private static final Object dispatchMouseWheelScroll$waitNextScrollDelta(MouseWheelScrollingLogic arg21, ObjectRef arg22, FloatRef arg23, ScrollingLogic arg24, ObjectRef arg25, long arg26, Continuation arg28) {
        int v7_1;
        ObjectRef v11_1;
        ScrollingLogic v10_1;
        FloatRef v9_1;
        MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1 v4_1;
        int v6;
        MouseWheelScrollingLogic v0 = arg21;
        long v1 = arg26;
        Continuation v3 = arg28;
        if((v3 instanceof MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1)) {
            Continuation v4 = v3;
            v6 = 0x80000000;
            if((((MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1)v4).label & v6) != 0) {
                ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1)v4).label -= v6;
            }
            else {
                goto label_14;
            }
        }
        else {
        label_14:
            v4_1 = new MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1(v3);
        }

        Object v3_1 = v4_1.result;
        Object v5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v6 = v4_1.label;
        boolean v7 = false;
        if(v6 == 0) {
            ResultKt.throwOnFailure(v3_1);
            if(v1 < 0) {
                return Boxing.boxBoolean(false);
            }
            else {
                MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$2 v3_2 = new MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$2(v0, null);
                v4_1.L$0 = v0;
                ObjectRef v6_1 = arg22;
                v4_1.L$1 = v6_1;
                v9_1 = arg23;
                v4_1.L$2 = v9_1;
                v10_1 = arg24;
                v4_1.L$3 = v10_1;
                v11_1 = arg25;
                v4_1.L$4 = v11_1;
                v4_1.label = 1;
                v3_1 = TimeoutKt.withTimeoutOrNull(v1, ((Function2)v3_2), ((Continuation)v4_1));
                if(v3_1 == v5) {
                    return v5;
                }
                else {
                    ObjectRef v5_1 = v6_1;
                }
            }
        }
        else if(v6 == 1) {
            Object v0_1 = v4_1.L$4;
            Object v1_1 = v4_1.L$3;
            Object v2 = v4_1.L$2;
            v5 = v4_1.L$1;
            Object v4_2 = v4_1.L$0;
            ResultKt.throwOnFailure(v3_1);
            Object v11 = v0_1;
            Object v10 = v1_1;
            Object v9 = v2;
            v0_1 = v4_2;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        if(v3_1 != null) {
            ((ObjectRef)v5).element = MouseWheelScrollDelta.copy-9KIMszo$default(v3_1, 0, 0, ((ObjectRef)v5).element.getShouldApplyImmediately(), 3, null);
            float v1_2 = ComposeFoundationFlags.isMouseWheel1DAxisLockingEnabled ? v10_1.toSingleAxisDeltaFromAngle-k-4lQ0M(v10_1.reverseIfNeeded-MK-Hz9U(((ObjectRef)v5).element.getValue-F1C5BW0())) : v10_1.toFloat-k-4lQ0M(v10_1.reverseIfNeeded-MK-Hz9U(((ObjectRef)v5).element.getValue-F1C5BW0()));
            v9_1.element = v1_2;
            v11_1.element = AnimationStateKt.AnimationState$default(0f, 0f, 0, 0, false, 30, null);
            v0.trackVelocity(((MouseWheelScrollDelta)v3_1));
            v7_1 = MouseWheelScrollableKt.isLowScrollingDelta(v9_1.element) ^ 1;
        }

        return Boxing.boxBoolean(((boolean)v7_1));
    }

    private final boolean isConsumed(PointerEvent arg4) {
        List v3 = arg4.getChanges();
        int v4 = v3.size();
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            if(v3.get(v1).isConsumed()) {
                return 1;
            }
        }

        return 0;
    }

    private final boolean onMouseWheel-O0kMr_c(PointerEvent arg10, long arg11) {
        long v3 = this.mouseWheelScrollConfig.calculateMouseWheelScroll-8xgXZGE(this.density, arg10, arg11);
        if(this.canConsumeDelta-Uv8p0NA(this.scrollingLogic, v3)) {
            Channel v11 = this.channel;
            long v5 = CollectionsKt.first(arg10.getChanges()).getUptimeMillis();
            boolean v9 = !this.mouseWheelScrollConfig.isSmoothScrollingEnabled() || (this.mouseWheelScrollConfig.isPreciseWheelScroll(arg10)) ? true : false;
            return ChannelResult.isSuccess-impl(v11.trySend-JP2dKIU(new MouseWheelScrollDelta(v3, v5, v9, null)));
        }

        return this.isScrolling;
    }

    public final void onPointerEvent-H0pRuoY(PointerEvent arg5, PointerEventPass arg6, long arg7) {
        int v1 = 0;
        if(!ComposeFoundationFlags.isMouseWheel1DAxisLockingEnabled) {
            if(arg6 != PointerEventPass.Main) {
                return;
            }

            if(!PointerEventType.equals-impl0(arg5.getType-7fucELk(), PointerEventType.Companion.getScroll-7fucELk())) {
                return;
            }

            List v6 = arg5.getChanges();
            int v0_1 = v6.size();
            while(v1 < v0_1) {
                if(v6.get(v1).isConsumed()) {
                    return;
                }

                ++v1;
            }

            if(!this.onMouseWheel-O0kMr_c(arg5, arg7)) {
                return;
            }

            this.consume(arg5);
        }
        else if(!PointerEventType.equals-impl0(arg5.getType-7fucELk(), PointerEventType.Companion.getScroll-7fucELk())) {
        }
        else {
            List v0 = arg5.getChanges();
            int v2 = v0.size();
            while(true) {
                if(v1 >= v2) {
                    break;
                }
                else if(v0.get(v1).isConsumed()) {
                    return;
                }
                else {
                    ++v1;
                    continue;
                }

                return;
            }

            if(arg6 == PointerEventPass.Initial && (this.isScrolling)) {
                this.onMouseWheel-O0kMr_c(arg5, arg7);
                this.consume(arg5);
            }

            if(arg6 != PointerEventPass.Main) {
                return;
            }

            if(this.isScrolling) {
                return;
            }

            if(!this.onMouseWheel-O0kMr_c(arg5, arg7)) {
                return;
            }

            this.consume(arg5);
            return;
        }
    }

    public final void startReceivingMouseWheelEvents(CoroutineScope arg9) {
        if(this.receivingMouseWheelEventsJob == null) {
            this.receivingMouseWheelEventsJob = BuildersKt.launch$default(arg9, null, null, new MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1(this, null), 3, null);
        }
    }

    private final MouseWheelScrollDelta sumOrNull(Channel arg2) {
        MouseWheelScrollDelta v2_1;
        Iterator v1 = this.untilNull(new MouseWheelScrollingLogic$$ExternalSyntheticLambda0(arg2)).iterator();
        Object v2 = null;
        while(v1.hasNext()) {
            Object v0 = v1.next();
            if(v2 == null) {
                v2 = v0;
                continue;
            }

            v2_1 = v2_1.plus(((MouseWheelScrollDelta)v0));
        }

        return v2_1;
    }

    static final MouseWheelScrollDelta sumOrNull$lambda$0(Channel arg0) {
        return ChannelResult.getOrNull-impl(arg0.tryReceive-PtdJZtk());
    }

    private final void trackVelocity(MouseWheelScrollDelta arg5) {
        this.velocityTracker.addDelta-Uv8p0NA(arg5.getTimeMillis(), arg5.getValue-F1C5BW0());
    }

    private final Sequence untilNull(Function0 arg2) {
        return SequencesKt.sequence(new MouseWheelScrollingLogic$untilNull$1(arg2, null));
    }

    public final void updateDensity(Density arg1) {
        this.density = arg1;
    }

    private final Object userScroll(ScrollingLogic arg5, Function2 arg6, Continuation arg7) {
        int v2;
        Continuation v0;
        if((arg7 instanceof MouseWheelScrollingLogic$userScroll$1)) {
            v0 = arg7;
            v2 = 0x80000000;
            if((((MouseWheelScrollingLogic$userScroll$1)v0).label & v2) != 0) {
                ((MouseWheelScrollingLogic$userScroll$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            MouseWheelScrollingLogic$userScroll$1 v0_1 = new MouseWheelScrollingLogic$userScroll$1(this, arg7);
        }

        Object v7 = ((MouseWheelScrollingLogic$userScroll$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((MouseWheelScrollingLogic$userScroll$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            this.isScrolling = true;
            MouseWheelScrollingLogic$userScroll$2 v7_1 = new MouseWheelScrollingLogic$userScroll$2(arg5, arg6, null);
            ((MouseWheelScrollingLogic$userScroll$1)v0).label = 1;
            if(SupervisorKt.supervisorScope(((Function2)v7_1), v0) == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v7);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        this.isScrolling = false;
        return Unit.INSTANCE;
    }
}

