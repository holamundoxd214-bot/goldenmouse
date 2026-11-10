package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000F\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u000E\u0010\u0019\u001A\u00020\u001AH\u0096@¢\u0006\u0002\u0010\u001BJ\u000E\u0010\u001C\u001A\u00020\u001AH\u0096@¢\u0006\u0002\u0010\u001BJ\u000E\u0010\u001D\u001A\u00020\u001AH\u0096@¢\u0006\u0002\u0010\u001BJ\u0016\u0010\u001E\u001A\u00020\u001A2\u0006\u0010\u0014\u001A\u00020\u000EH\u0096@¢\u0006\u0002\u0010\u001FJ\u0018\u0010 \u001A\u00020\u001A2\u0006\u0010!\u001A\u00020\u0007H\u0080@¢\u0006\u0004\b\"\u0010#J0\u0010\'\u001A\u00020\u001A2\u0006\u0010\u0014\u001A\u00020\u000E2\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010!\u001A\u00020\u0007H\u0082@¢\u0006\u0002\u0010(R\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u001A\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\rX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001A\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0018R\u0011\u0010$\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b%\u0010&¨\u0006)"}, d2={"Landroidx/compose/material3/ModalWideNavigationRailState;", "Landroidx/compose/material3/WideNavigationRailState;", "state", "density", "Landroidx/compose/ui/unit/Density;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/material3/WideNavigationRailState;Landroidx/compose/ui/unit/Density;Landroidx/compose/animation/core/AnimationSpec;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "anchoredDraggableState", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "Landroidx/compose/material3/WideNavigationRailValue;", "getAnchoredDraggableState$material3", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/WideNavigationRailValue;", "targetValue", "getTargetValue", "isAnimating", "", "()Z", "expand", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collapse", "toggle", "snapTo", "(Landroidx/compose/material3/WideNavigationRailValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settle", "velocity", "settle$material3", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentOffset", "getCurrentOffset", "()F", "animateTo", "(Landroidx/compose/material3/WideNavigationRailValue;Landroidx/compose/animation/core/AnimationSpec;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ModalWideNavigationRailState implements WideNavigationRailState {
    public static final int $stable = 8;
    private final AnchoredDraggableState anchoredDraggableState;
    private final AnimationSpec animationSpec;

    static {
    }

    public ModalWideNavigationRailState(WideNavigationRailState arg9, Density arg10, AnimationSpec arg11) {
        super();
        this.$$delegate_0 = arg9;
        this.animationSpec = arg11;
        this.anchoredDraggableState = new AnchoredDraggableState(arg9.getTargetValue(), new ModalWideNavigationRailState$$ExternalSyntheticLambda0(), new ModalWideNavigationRailState$$ExternalSyntheticLambda1(arg10), new ModalWideNavigationRailState$$ExternalSyntheticLambda2(this), null, 16, null);
    }

    public static final Object access$animateTo(ModalWideNavigationRailState arg0, WideNavigationRailValue arg1, AnimationSpec arg2, float arg3, Continuation arg4) {
        return arg0.animateTo(arg1, arg2, arg3, arg4);
    }

    static final float anchoredDraggableState$lambda$0(float arg1) {
        return arg1 * 0.5f;
    }

    static final float anchoredDraggableState$lambda$2(Density arg1) {
        return arg1.toPx-0680j_4(Dp.constructor-impl(400f));
    }

    static final AnimationSpec anchoredDraggableState$lambda$3(ModalWideNavigationRailState arg0) {
        return arg0.animationSpec;
    }

    private final Object animateTo(WideNavigationRailValue arg8, AnimationSpec arg9, float arg10, Continuation arg11) {
        Object v7 = AnchoredDraggableState.anchoredDrag$default(this.anchoredDraggableState, arg8, null, new ModalWideNavigationRailState$animateTo$2(this, arg10, arg9, null), arg11, 2, null);
        if(v7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v7;
        }

        return Unit.INSTANCE;
    }

    static Object animateTo$default(ModalWideNavigationRailState arg0, WideNavigationRailValue arg1, AnimationSpec arg2, float arg3, Continuation arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg2 = arg0.animationSpec;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.anchoredDraggableState.getLastVelocity();
        }

        return arg0.animateTo(arg1, arg2, arg3, arg4);
    }

    public Object collapse(Continuation arg8) {
        Object v7 = ModalWideNavigationRailState.animateTo$default(this, WideNavigationRailValue.Collapsed, null, 0f, arg8, 6, null);
        if(v7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v7;
        }

        return Unit.INSTANCE;
    }

    public Object expand(Continuation arg8) {
        Object v7 = ModalWideNavigationRailState.animateTo$default(this, WideNavigationRailValue.Expanded, null, 0f, arg8, 6, null);
        if(v7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v7;
        }

        return Unit.INSTANCE;
    }

    public final AnchoredDraggableState getAnchoredDraggableState$material3() {
        return this.anchoredDraggableState;
    }

    public final AnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final float getCurrentOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    public WideNavigationRailValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public WideNavigationRailValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public boolean isAnimating() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final Object settle$material3(float arg1, Continuation arg2) {
        Object v0 = this.anchoredDraggableState.settle(arg1, arg2);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public Object snapTo(WideNavigationRailValue arg1, Continuation arg2) {
        Object v0 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, arg1, arg2);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public Object toggle(Continuation arg9) {
        Object v8 = ModalWideNavigationRailState.animateTo$default(this, WideNavigationRailStateKt.not(this.getTargetValue()), null, 0f, arg9, 6, null);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }
}

