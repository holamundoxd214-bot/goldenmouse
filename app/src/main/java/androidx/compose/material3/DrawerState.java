package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.gestures.AnchoredDraggableDefaults;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001HB%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000E\u0010\u001F\u001A\u00020 H\u0086@¢\u0006\u0002\u0010!J\u000E\u0010\"\u001A\u00020 H\u0086@¢\u0006\u0002\u0010!J$\u0010#\u001A\u00020 2\u0006\u0010$\u001A\u00020\u00032\f\u0010%\u001A\b\u0012\u0004\u0012\u00020\r0&H\u0087@¢\u0006\u0002\u0010\'J\u0016\u0010(\u001A\u00020 2\u0006\u0010$\u001A\u00020\u0003H\u0086@¢\u0006\u0002\u0010)J\b\u0010B\u001A\u000204H\u0002J\r\u0010C\u001A\u00020\rH\u0000¢\u0006\u0002\bDJ.\u0010#\u001A\u00020 2\u0006\u0010$\u001A\u00020\u00032\f\u0010E\u001A\b\u0012\u0004\u0012\u00020\r0&2\b\b\u0002\u0010F\u001A\u00020\rH\u0082@¢\u0006\u0002\u0010GR \u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR \u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\fX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0080\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001A\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0019R\u0011\u0010\u001B\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u0011\u0010\u001E\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u0019R\u0011\u0010$\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b*\u0010\u001DR\"\u0010+\u001A\b\u0012\u0004\u0012\u00020\r0,8\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b-\u0010\u0015\u001A\u0004\b.\u0010/R\u0011\u00100\u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b1\u00102R/\u00105\u001A\u0004\u0018\u0001042\b\u00103\u001A\u0004\u0018\u0001048@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b:\u0010;\u001A\u0004\b6\u00107\"\u0004\b8\u00109R \u0010<\u001A\b\u0012\u0004\u0012\u00020\r0\fX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b=\u0010\u000F\"\u0004\b>\u0010\u0011R \u0010?\u001A\b\u0012\u0004\u0012\u00020\r0\fX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b@\u0010\u000F\"\u0004\bA\u0010\u0011¨\u0006I"}, d2={"Landroidx/compose/material3/DrawerState;", "", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "<init>", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;)V", "getConfirmStateChange$material3", "()Lkotlin/jvm/functions/Function1;", "anchoredDraggableMotionSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "getAnchoredDraggableMotionSpec$material3", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnchoredDraggableMotionSpec$material3", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "anchoredDraggableState", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "getAnchoredDraggableState$material3$annotations", "()V", "getAnchoredDraggableState$material3", "()Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "isOpen", "()Z", "isClosed", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/DrawerValue;", "isAnimationRunning", "open", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "animateTo", "targetValue", "anim", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/DrawerValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "(Landroidx/compose/material3/DrawerValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTargetValue", "offset", "Landroidx/compose/runtime/State;", "getOffset$annotations", "getOffset", "()Landroidx/compose/runtime/State;", "currentOffset", "getCurrentOffset", "()F", "<set-?>", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$material3", "()Landroidx/compose/ui/unit/Density;", "setDensity$material3", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "Landroidx/compose/runtime/MutableState;", "openDrawerMotionSpec", "getOpenDrawerMotionSpec$material3", "setOpenDrawerMotionSpec$material3", "closeDrawerMotionSpec", "getCloseDrawerMotionSpec$material3", "setCloseDrawerMotionSpec$material3", "requireDensity", "requireOffset", "requireOffset$material3", "animationSpec", "velocity", "(Landroidx/compose/material3/DrawerValue;Landroidx/compose/animation/core/AnimationSpec;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DrawerState {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000B"}, d2={"Landroidx/compose/material3/DrawerState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/DrawerState;", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver Saver(Function1 arg2) {
            return SaverKt.Saver(new DrawerState$Companion$$ExternalSyntheticLambda0(), new DrawerState$Companion$$ExternalSyntheticLambda1(arg2));
        }

        static final DrawerValue Saver$lambda$0(SaverScope arg0, DrawerState arg1) {
            return arg1.getCurrentValue();
        }

        static final DrawerState Saver$lambda$1(Function1 arg1, DrawerValue arg2) {
            return new DrawerState(arg2, arg1);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private FiniteAnimationSpec anchoredDraggableMotionSpec;
    private final AnchoredDraggableState anchoredDraggableState;
    private FiniteAnimationSpec closeDrawerMotionSpec;
    private final Function1 confirmStateChange;
    private final MutableState density$delegate;
    private final State offset;
    private FiniteAnimationSpec openDrawerMotionSpec;

    static {
        DrawerState.Companion = new Companion(null);
    }

    public DrawerState(DrawerValue arg9, Function1 arg10) {
        super();
        this.confirmStateChange = arg10;
        TweenSpec v0 = NavigationDrawerKt.access$getAnchoredDraggableDefaultAnimationSpec$p();
        this.anchoredDraggableMotionSpec = ((FiniteAnimationSpec)v0);
        this.anchoredDraggableState = AnchoredDraggableKt.AnchoredDraggableState(arg9, new DrawerState$$ExternalSyntheticLambda1(), new DrawerState$$ExternalSyntheticLambda2(this), v0, AnchoredDraggableDefaults.INSTANCE.getDecayAnimationSpec(), arg10);
        this.offset = new DrawerState$offset$1(this);
        this.density$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.openDrawerMotionSpec = AnimationSpecKt.snap$default(0, 1, null);
        this.closeDrawerMotionSpec = AnimationSpecKt.snap$default(0, 1, null);
    }

    public DrawerState(DrawerValue arg1, Function1 arg2, int arg3, DefaultConstructorMarker arg4) {
        DrawerState$$ExternalSyntheticLambda0 v2;
        if((arg3 & 2) != 0) {
            v2 = new DrawerState$$ExternalSyntheticLambda0();
        }

        this(arg1, ((Function1)v2));
    }

    static final boolean _init_$lambda$0(DrawerValue arg0) {
        return 1;
    }

    public static final Object access$animateTo(DrawerState arg0, DrawerValue arg1, AnimationSpec arg2, float arg3, Continuation arg4) {
        return arg0.animateTo(arg1, arg2, arg3, arg4);
    }

    static final float anchoredDraggableState$lambda$1(float arg1) {
        return arg1 * NavigationDrawerKt.access$getDrawerPositionalThreshold$p();
    }

    static final float anchoredDraggableState$lambda$3(DrawerState arg1) {
        return arg1.requireDensity().toPx-0680j_4(NavigationDrawerKt.access$getDrawerVelocityThreshold$p());
    }

    private final Object animateTo(DrawerValue arg8, AnimationSpec arg9, float arg10, Continuation arg11) {
        Object v7 = AnchoredDraggableState.anchoredDrag$default(this.anchoredDraggableState, arg8, null, new DrawerState$animateTo$3(this, arg10, arg9, null), arg11, 2, null);
        if(v7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v7;
        }

        return Unit.INSTANCE;
    }

    @Deprecated(message="This method has been replaced by the open and close methods. The animation spec is now an implementation detail of ModalDrawer.") public final Object animateTo(DrawerValue arg8, AnimationSpec arg9, Continuation arg10) {
        Object v7 = DrawerState.animateTo$default(this, arg8, arg9, 0f, arg10, 4, null);
        if(v7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v7;
        }

        return Unit.INSTANCE;
    }

    static Object animateTo$default(DrawerState arg0, DrawerValue arg1, AnimationSpec arg2, float arg3, Continuation arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = arg0.anchoredDraggableState.getLastVelocity();
        }

        return arg0.animateTo(arg1, arg2, arg3, arg4);
    }

    public final Object close(Continuation arg8) {
        Object v7 = DrawerState.animateTo$default(this, DrawerValue.Closed, this.closeDrawerMotionSpec, 0f, arg8, 4, null);
        if(v7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v7;
        }

        return Unit.INSTANCE;
    }

    public final FiniteAnimationSpec getAnchoredDraggableMotionSpec$material3() {
        return this.anchoredDraggableMotionSpec;
    }

    public final AnchoredDraggableState getAnchoredDraggableState$material3() {
        return this.anchoredDraggableState;
    }

    public static void getAnchoredDraggableState$material3$annotations() {
    }

    public final FiniteAnimationSpec getCloseDrawerMotionSpec$material3() {
        return this.closeDrawerMotionSpec;
    }

    public final Function1 getConfirmStateChange$material3() {
        return this.confirmStateChange;
    }

    public final float getCurrentOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    public final DrawerValue getCurrentValue() {
        return this.anchoredDraggableState.getSettledValue();
    }

    public final Density getDensity$material3() {
        return this.density$delegate.getValue();
    }

    public final State getOffset() {
        return this.offset;
    }

    @Deprecated(message="Please access the offset through currentOffset, which returns the value directly instead of wrapping it in a state object.", replaceWith="<_subannotation>") public static void getOffset$annotations() {
    }

    public final FiniteAnimationSpec getOpenDrawerMotionSpec$material3() {
        return this.openDrawerMotionSpec;
    }

    public final DrawerValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isAnimationRunning() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final boolean isClosed() {
        if(this.getCurrentValue() == DrawerValue.Closed) {
            return 1;
        }

        return 0;
    }

    public final boolean isOpen() {
        if(this.getCurrentValue() == DrawerValue.Open) {
            return 1;
        }

        return 0;
    }

    public final Object open(Continuation arg8) {
        Object v7 = DrawerState.animateTo$default(this, DrawerValue.Open, this.openDrawerMotionSpec, 0f, arg8, 4, null);
        if(v7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v7;
        }

        return Unit.INSTANCE;
    }

    private final Density requireDensity() {
        Density v0 = this.getDensity$material3();
        if(v0 != null) {
            return v0;
        }

        throw new IllegalArgumentException("The density on DrawerState (" + this + ") was not set. Did you use DrawerState with the ModalNavigationDrawer or DismissibleNavigationDrawer composables?".toString());
    }

    public final float requireOffset$material3() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final void setAnchoredDraggableMotionSpec$material3(FiniteAnimationSpec arg1) {
        this.anchoredDraggableMotionSpec = arg1;
    }

    public final void setCloseDrawerMotionSpec$material3(FiniteAnimationSpec arg1) {
        this.closeDrawerMotionSpec = arg1;
    }

    public final void setDensity$material3(Density arg1) {
        this.density$delegate.setValue(arg1);
    }

    public final void setOpenDrawerMotionSpec$material3(FiniteAnimationSpec arg1) {
        this.openDrawerMotionSpec = arg1;
    }

    public final Object snapTo(DrawerValue arg1, Continuation arg2) {
        Object v0 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, arg1, arg2);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }
}

