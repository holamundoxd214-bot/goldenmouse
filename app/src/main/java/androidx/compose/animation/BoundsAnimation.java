package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition$DeferredAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0001\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u001C\u0010\u0007\u001A\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bR\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E¢\u0006\u0004\b\u0010\u0010\u0011J,\u0010\u001F\u001A\u00020 2\u001C\u0010\u0007\u001A\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bR\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000B\u001A\u00020\fJ\"\u00108\u001A\u00020 2\u0006\u00109\u001A\u00020\t2\u0006\u0010:\u001A\u00020\t2\n\b\u0002\u0010;\u001A\u0004\u0018\u00010\fR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017RW\u0010\u0007\u001A\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bR\b\u0012\u0004\u0012\u00020\u00060\u00052\u001C\u0010\u0018\u001A\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bR\b\u0012\u0004\u0012\u00020\u00060\u00058F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR+\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\f8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b%\u0010\u001E\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010&\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b&\u0010\'R \u0010(\u001A\b\u0012\u0004\u0012\u00020\t0)X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R;\u0010/\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010.2\u000E\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010.8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b4\u0010\u001E\u001A\u0004\b0\u00101\"\u0004\b2\u00103R\u0013\u00105\u001A\u0004\u0018\u00010\t8F¢\u0006\u0006\u001A\u0004\b6\u00107R\u0011\u0010<\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b=\u0010\'¨\u0006\u0007"}, d2={"Landroidx/compose/animation/BoundsAnimation;", "", "transitionScope", "Landroidx/compose/animation/SharedTransitionScope;", "transition", "Landroidx/compose/animation/core/Transition;", "", "animation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "momentumOffset", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(Landroidx/compose/animation/SharedTransitionScope;Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/BoundsTransform;Lkotlin/jvm/functions/Function0;)V", "getTransitionScope", "()Landroidx/compose/animation/SharedTransitionScope;", "getTransition", "()Landroidx/compose/animation/core/Transition;", "getMomentumOffset", "()Lkotlin/jvm/functions/Function0;", "<set-?>", "getAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "animation$delegate", "Landroidx/compose/runtime/MutableState;", "updateAnimation", "", "getBoundsTransform", "()Landroidx/compose/animation/BoundsTransform;", "setBoundsTransform", "(Landroidx/compose/animation/BoundsTransform;)V", "boundsTransform$delegate", "isRunning", "()Z", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "Landroidx/compose/runtime/State;", "animationState", "getAnimationState", "()Landroidx/compose/runtime/State;", "setAnimationState", "(Landroidx/compose/runtime/State;)V", "animationState$delegate", "value", "getValue", "()Landroidx/compose/ui/geometry/Rect;", "animate", "currentBounds", "targetBounds", "forcedBoundsTransform", "target", "getTarget"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BoundsAnimation {
    public static final int $stable = 8;
    private final MutableState animation$delegate;
    private FiniteAnimationSpec animationSpec;
    private final MutableState animationState$delegate;
    private final MutableState boundsTransform$delegate;
    private final Function0 momentumOffset;
    private final Transition transition;
    private final SharedTransitionScope transitionScope;

    static {
    }

    public BoundsAnimation(SharedTransitionScope arg1, Transition arg2, DeferredAnimation arg3, BoundsTransform arg4, Function0 arg5) {
        super();
        this.transitionScope = arg1;
        this.transition = arg2;
        this.momentumOffset = arg5;
        this.animation$delegate = SnapshotStateKt.mutableStateOf$default(arg3, null, 2, null);
        this.boundsTransform$delegate = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
        this.animationSpec = BoundsAnimationKt.access$getDefaultBoundsAnimation$p();
        this.animationState$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public final void animate(Rect arg3, Rect arg4, BoundsTransform arg5) {
        if(this.transitionScope.isTransitionActive()) {
            if(this.getAnimationState() == null) {
                if(arg5 == null) {
                    arg5 = this.getBoundsTransform();
                }

                this.animationSpec = arg5.createAnimationSpec(arg3, arg4);
            }

            this.setAnimationState(this.getAnimation().animate(new BoundsAnimation$animate$1(this), new BoundsAnimation$animate$2(this, arg4, arg3)));
        }
    }

    public static void animate$default(BoundsAnimation arg0, Rect arg1, Rect arg2, BoundsTransform arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        arg0.animate(arg1, arg2, arg3);
    }

    public final DeferredAnimation getAnimation() {
        return this.animation$delegate.getValue();
    }

    public final FiniteAnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final State getAnimationState() {
        return this.animationState$delegate.getValue();
    }

    private final BoundsTransform getBoundsTransform() {
        return this.boundsTransform$delegate.getValue();
    }

    public final Function0 getMomentumOffset() {
        return this.momentumOffset;
    }

    public final boolean getTarget() {
        return this.transition.getTargetState().booleanValue();
    }

    public final Transition getTransition() {
        return this.transition;
    }

    public final SharedTransitionScope getTransitionScope() {
        return this.transitionScope;
    }

    public final Rect getValue() {
        Rect v1 = null;
        if(this.transitionScope.isTransitionActive()) {
            State v0 = this.getAnimationState();
            if(v0 != null) {
                Object v0_1 = v0.getValue();
                if(v0_1 != null) {
                    long v1_1 = this.momentumOffset.invoke().unbox-impl();
                    if(!Offset.equals-impl0(v1_1, Offset.Companion.getZero-F1C5BW0())) {
                        return ((Rect)v0_1).translate-k-4lQ0M(v1_1);
                    }
                    else {
                        return ((Rect)v0_1);
                    }
                }
            }
        }

        return v1;
    }

    public final boolean isRunning() {
        Transition v1 = this.transition;
        while(v1.getParentTransition() != null) {
            v1 = v1.getParentTransition();
            Intrinsics.checkNotNull(v1);
        }

        return Intrinsics.areEqual(v1.getCurrentState(), v1.getTargetState()) ^ 1;
    }

    private final void setAnimation(DeferredAnimation arg1) {
        this.animation$delegate.setValue(arg1);
    }

    public final void setAnimationSpec(FiniteAnimationSpec arg1) {
        this.animationSpec = arg1;
    }

    public final void setAnimationState(State arg1) {
        this.animationState$delegate.setValue(arg1);
    }

    private final void setBoundsTransform(BoundsTransform arg1) {
        this.boundsTransform$delegate.setValue(arg1);
    }

    public final void updateAnimation(DeferredAnimation arg2, BoundsTransform arg3) {
        if(!Intrinsics.areEqual(this.getAnimation(), arg2)) {
            this.setAnimation(arg2);
            this.setAnimationState(null);
            this.animationSpec = BoundsAnimationKt.access$getDefaultBoundsAnimation$p();
        }

        this.setBoundsTransform(arg3);
    }
}

