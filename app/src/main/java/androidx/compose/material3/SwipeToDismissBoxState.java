package androidx.compose.material3;

import androidx.compose.foundation.gestures.AnchoredDraggableDefaults;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B4\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012!\u0010\u0004\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\n\u0010\u000BBR\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0014\b\u0002\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000F0\u0005\u0012!\u0010\u0004\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\n\u0010\u0010J\u0006\u0010\u001F\u001A\u00020\u0006J\u0016\u0010-\u001A\u00020.2\u0006\u0010#\u001A\u00020\u0003H\u0086@¢\u0006\u0002\u0010/J\u000E\u00100\u001A\u00020.H\u0086@¢\u0006\u0002\u00101J\u0016\u00102\u001A\u00020.2\u0006\u00103\u001A\u00020\u0003H\u0086@¢\u0006\u0002\u0010/R\u001A\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00030\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R&\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0080.¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001A\u00020\u000F8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u0011\u0010 \u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b!\u0010\"R\u0011\u0010#\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b$\u0010\"R\u0011\u0010%\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b&\u0010\"R\u0017\u0010\'\u001A\u00020\u00068G¢\u0006\f\u0012\u0004\b(\u0010)\u001A\u0004\b*\u0010\u001ER\u0011\u0010+\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b,\u0010\"¨\u00065"}, d2={"Landroidx/compose/material3/SwipeToDismissBoxState;", "", "initialValue", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "<init>", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/jvm/functions/Function1;)V", "density", "Landroidx/compose/ui/unit/Density;", "confirmValueChange", "", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "getAnchoredDraggableState$material3", "()Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "getPositionalThreshold$material3", "()Lkotlin/jvm/functions/Function1;", "setPositionalThreshold$material3", "(Lkotlin/jvm/functions/Function1;)V", "useFlingBehavior", "getUseFlingBehavior$material3", "()Z", "offset", "getOffset$material3", "()F", "requireOffset", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/SwipeToDismissBoxValue;", "targetValue", "getTargetValue", "settledValue", "getSettledValue", "progress", "getProgress$annotations", "()V", "getProgress", "dismissDirection", "getDismissDirection", "snapTo", "", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismiss", "direction", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SwipeToDismissBoxState {
    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JS\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t2!\u0010\u000B\u001A\u001D\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\u0010\u001A\u00020\u0011H\u0007J5\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052!\u0010\u000B\u001A\u001D\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\f0\t¨\u0006\u0012"}, d2={"Landroidx/compose/material3/SwipeToDismissBoxState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SwipeToDismissBoxState;", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "", "Lkotlin/ParameterName;", "name", "totalDistance", "density", "Landroidx/compose/ui/unit/Density;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver Saver(Function1 arg2) {
            return SaverKt.Saver(new SwipeToDismissBoxState$Companion$$ExternalSyntheticLambda0(), new SwipeToDismissBoxState$Companion$$ExternalSyntheticLambda1(arg2));
        }

        @Deprecated(level=DeprecationLevel.WARNING, message="confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.", replaceWith="<_subannotation>") public final Saver Saver(Function1 arg2, Function1 arg3, Density arg4) {
            return SaverKt.Saver(new SwipeToDismissBoxState$Companion$$ExternalSyntheticLambda2(), new SwipeToDismissBoxState$Companion$$ExternalSyntheticLambda3(arg4, arg2, arg3));
        }

        static final SwipeToDismissBoxValue Saver$lambda$0(SaverScope arg0, SwipeToDismissBoxState arg1) {
            return arg1.getCurrentValue();
        }

        static final SwipeToDismissBoxState Saver$lambda$1(Density arg1, Function1 arg2, Function1 arg3, SwipeToDismissBoxValue arg4) {
            return new SwipeToDismissBoxState(arg4, arg1, arg2, arg3);
        }

        static final SwipeToDismissBoxValue Saver$lambda$2(SaverScope arg0, SwipeToDismissBoxState arg1) {
            return arg1.getCurrentValue();
        }

        static final SwipeToDismissBoxState Saver$lambda$3(Function1 arg1, SwipeToDismissBoxValue arg2) {
            return new SwipeToDismissBoxState(arg2, arg1);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final AnchoredDraggableState anchoredDraggableState;
    public Function1 positionalThreshold;

    static {
        SwipeToDismissBoxState.Companion = new Companion(null);
        SwipeToDismissBoxState.$stable = 8;
    }

    public SwipeToDismissBoxState(SwipeToDismissBoxValue arg2, Function1 arg3) {
        super();
        this.anchoredDraggableState = new AnchoredDraggableState(arg2);
        this.setPositionalThreshold$material3(arg3);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.", replaceWith="<_subannotation>") public SwipeToDismissBoxState(SwipeToDismissBoxValue arg8, Density arg9, Function1 arg10, Function1 arg11) {
        super();
        this.anchoredDraggableState = AnchoredDraggableKt.AnchoredDraggableState(arg8, arg11, new SwipeToDismissBoxState$$ExternalSyntheticLambda1(arg9), AnchoredDraggableDefaults.INSTANCE.getSnapAnimationSpec(), AnchoredDraggableDefaults.INSTANCE.getDecayAnimationSpec(), arg10);
    }

    public SwipeToDismissBoxState(SwipeToDismissBoxValue arg1, Density arg2, Function1 arg3, Function1 arg4, int arg5, DefaultConstructorMarker arg6) {
        SwipeToDismissBoxState$$ExternalSyntheticLambda0 v3;
        if((arg5 & 4) != 0) {
            v3 = new SwipeToDismissBoxState$$ExternalSyntheticLambda0();
        }

        this(arg1, arg2, ((Function1)v3), arg4);
    }

    static final boolean _init_$lambda$0(SwipeToDismissBoxValue arg0) {
        return 1;
    }

    static final float _init_$lambda$2(Density arg1) {
        return arg1.toPx-0680j_4(SwipeToDismissBoxKt.DismissVelocityThreshold);
    }

    public final Object dismiss(SwipeToDismissBoxValue arg7, Continuation arg8) {
        Object v6 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, arg7, null, arg8, 2, null);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public final AnchoredDraggableState getAnchoredDraggableState$material3() {
        return this.anchoredDraggableState;
    }

    public final SwipeToDismissBoxValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final SwipeToDismissBoxValue getDismissDirection() {
        if(this.getOffset$material3() == 0f) {
        }
        else {
            if(Float.isNaN(this.getOffset$material3())) {
                goto label_7;
            }

            goto label_9;
        }

    label_7:
        return SwipeToDismissBoxValue.Settled;
    label_9:
        if(this.getOffset$material3() > 0f) {
            return SwipeToDismissBoxValue.StartToEnd;
        }

        return SwipeToDismissBoxValue.EndToStart;
    }

    public final float getOffset$material3() {
        return this.anchoredDraggableState.getOffset();
    }

    public final Function1 getPositionalThreshold$material3() {
        Function1 v0 = this.positionalThreshold;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("positionalThreshold");
        return null;
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public static void getProgress$annotations() {
    }

    public final SwipeToDismissBoxValue getSettledValue() {
        return this.anchoredDraggableState.getSettledValue();
    }

    public final SwipeToDismissBoxValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean getUseFlingBehavior$material3() {
        if(this.positionalThreshold != null) {
            return 1;
        }

        return 0;
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final Object reset(Continuation arg7) {
        Object v6 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, SwipeToDismissBoxValue.Settled, null, arg7, 2, null);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public final void setPositionalThreshold$material3(Function1 arg1) {
        this.positionalThreshold = arg1;
    }

    public final Object snapTo(SwipeToDismissBoxValue arg1, Continuation arg2) {
        Object v0 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, arg1, arg2);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }
}

