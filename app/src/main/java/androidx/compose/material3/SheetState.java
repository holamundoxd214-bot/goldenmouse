package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LBU\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\u0014\b\u0002\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\u0003¢\u0006\u0004\b\r\u0010\u000EBC\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\u0014\b\u0002\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\u0003¢\u0006\u0004\b\r\u0010\u0011J\u0006\u0010\u001E\u001A\u00020\u0006J\u000E\u0010#\u001A\u00020$H\u0086@¢\u0006\u0002\u0010%J\u000E\u0010&\u001A\u00020$H\u0086@¢\u0006\u0002\u0010%J\u000E\u0010\'\u001A\u00020$H\u0086@¢\u0006\u0002\u0010%J\u000E\u0010(\u001A\u00020$H\u0086@¢\u0006\u0002\u0010%J0\u0010)\u001A\u00020$2\u0006\u0010\u001A\u001A\u00020\t2\f\u0010*\u001A\b\u0012\u0004\u0012\u00020\u00060+2\b\b\u0002\u0010,\u001A\u00020\u0006H\u0080@¢\u0006\u0004\b-\u0010.J\u0018\u0010/\u001A\u00020$2\u0006\u0010\u001A\u001A\u00020\tH\u0080@¢\u0006\u0004\b0\u00101J\u0018\u00102\u001A\u00020$2\u0006\u0010,\u001A\u00020\u0006H\u0080@¢\u0006\u0004\b3\u00104R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R \u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000BX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0014\u0010\f\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0017\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001A\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0019R\u0011\u0010\u001C\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u0013R\u0011\u0010\u001D\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u0013R\u0011\u0010\u001F\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b \u0010\u0013R\u0011\u0010!\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\"\u0010\u0013R \u00105\u001A\b\u0012\u0004\u0012\u00020\u000606X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b7\u00108\"\u0004\b9\u0010:R \u0010;\u001A\b\u0012\u0004\u0012\u00020\t0<X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010A\u001A\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bB\u0010CR \u0010D\u001A\b\u0012\u0004\u0012\u00020\u00060+X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bE\u0010F\"\u0004\bG\u0010HR \u0010I\u001A\b\u0012\u0004\u0012\u00020\u00060+X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bJ\u0010F\"\u0004\bK\u0010H¨\u0006M"}, d2={"Landroidx/compose/material3/SheetState;", "", "skipPartiallyExpanded", "", "positionalThreshold", "Lkotlin/Function0;", "", "velocityThreshold", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "Lkotlin/Function1;", "skipHiddenState", "<init>", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;Z)V", "density", "Landroidx/compose/ui/unit/Density;", "(ZLandroidx/compose/ui/unit/Density;Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;Z)V", "getSkipPartiallyExpanded$material3", "()Z", "getConfirmValueChange$material3", "()Lkotlin/jvm/functions/Function1;", "getSkipHiddenState$material3", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/SheetValue;", "targetValue", "getTargetValue", "isVisible", "isAnimationRunning", "requireOffset", "hasExpandedState", "getHasExpandedState", "hasPartiallyExpandedState", "getHasPartiallyExpandedState", "expand", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "partialExpand", "show", "hide", "animateTo", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "velocity", "animateTo$material3", "(Landroidx/compose/material3/SheetValue;Landroidx/compose/animation/core/FiniteAnimationSpec;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "snapTo$material3", "(Landroidx/compose/material3/SheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settle", "settle$material3", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchoredDraggableMotionSpec", "Landroidx/compose/animation/core/AnimationSpec;", "getAnchoredDraggableMotionSpec$material3", "()Landroidx/compose/animation/core/AnimationSpec;", "setAnchoredDraggableMotionSpec$material3", "(Landroidx/compose/animation/core/AnimationSpec;)V", "anchoredDraggableState", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "getAnchoredDraggableState$material3", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "setAnchoredDraggableState$material3", "(Landroidx/compose/material3/internal/AnchoredDraggableState;)V", "offset", "getOffset$material3", "()F", "showMotionSpec", "getShowMotionSpec$material3", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setShowMotionSpec$material3", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "hideMotionSpec", "getHideMotionSpec$material3", "setHideMotionSpec$material3", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SheetState {
    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JR\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001A\u00020\t2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000F2\u0006\u0010\u0010\u001A\u00020\tJ@\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001A\u00020\t2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000F2\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0010\u001A\u00020\tH\u0007¨\u0006\u0013"}, d2={"Landroidx/compose/material3/SheetState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SheetState;", "Landroidx/compose/material3/SheetValue;", "skipPartiallyExpanded", "", "positionalThreshold", "Lkotlin/Function0;", "", "velocityThreshold", "confirmValueChange", "Lkotlin/Function1;", "skipHiddenState", "density", "Landroidx/compose/ui/unit/Density;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver Saver(boolean arg7, Function0 arg8, Function0 arg9, Function1 arg10, boolean arg11) {
            return SaverKt.Saver(new SheetState$Companion$$ExternalSyntheticLambda0(), new SheetState$Companion$$ExternalSyntheticLambda1(arg7, arg8, arg9, arg10, arg11));
        }

        @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility.") public final Saver Saver(boolean arg7, Function1 arg8, Density arg9, boolean arg10) {
            return this.Saver(arg7, new SheetState$Companion$$ExternalSyntheticLambda2(arg9), new SheetState$Companion$$ExternalSyntheticLambda3(arg9), arg8, arg10);
        }

        static final SheetValue Saver$lambda$0(SaverScope arg0, SheetState arg1) {
            return arg1.getCurrentValue();
        }

        static final SheetState Saver$lambda$1(boolean arg7, Function0 arg8, Function0 arg9, Function1 arg10, boolean arg11, SheetValue arg12) {
            return new SheetState(arg7, arg8, arg9, arg12, arg10, arg11);
        }

        static final float Saver$lambda$3(Density arg1) {
            return arg1.toPx-0680j_4(BottomSheetDefaults.INSTANCE.getPositionalThreshold-D9Ej5fM$material3());
        }

        static final float Saver$lambda$5(Density arg1) {
            return arg1.toPx-0680j_4(BottomSheetDefaults.INSTANCE.getVelocityThreshold-D9Ej5fM$material3());
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private AnimationSpec anchoredDraggableMotionSpec;
    private AnchoredDraggableState anchoredDraggableState;
    private final Function1 confirmValueChange;
    private FiniteAnimationSpec hideMotionSpec;
    private FiniteAnimationSpec showMotionSpec;
    private final boolean skipHiddenState;
    private final boolean skipPartiallyExpanded;

    static {
        SheetState.Companion = new Companion(null);
    }

    public SheetState(boolean arg7, Function0 arg8, Function0 arg9, SheetValue arg10, Function1 arg11, boolean arg12) {
        super();
        this.skipPartiallyExpanded = arg7;
        this.confirmValueChange = arg11;
        this.skipHiddenState = arg12;
        if(arg7) {
            if(arg10 != SheetValue.PartiallyExpanded) {
            }
            else {
                throw new IllegalArgumentException("The initial value must not be set to PartiallyExpanded if skipPartiallyExpanded is set to true.".toString());
            }
        }

        if(arg12) {
            if(arg10 != SheetValue.Hidden) {
            }
            else {
                throw new IllegalArgumentException("The initial value must not be set to Hidden if skipHiddenState is set to true.".toString());
            }
        }

        this.anchoredDraggableMotionSpec = SheetDefaultsKt.BottomSheetAnimationSpec;
        this.anchoredDraggableState = new AnchoredDraggableState(arg10, new SheetState$$ExternalSyntheticLambda0(arg8), arg9, new SheetState$$ExternalSyntheticLambda1(this), arg11);
        this.showMotionSpec = AnimationSpecKt.snap$default(0, 1, null);
        this.hideMotionSpec = AnimationSpecKt.snap$default(0, 1, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility.") public SheetState(boolean arg8, Density arg9, SheetValue arg10, Function1 arg11, boolean arg12) {
        this(arg8, new SheetState$$ExternalSyntheticLambda4(arg9), new SheetState$$ExternalSyntheticLambda5(arg9), arg10, arg11, arg12);
    }

    public SheetState(boolean arg7, Density arg8, SheetValue arg9, Function1 arg10, boolean arg11, int arg12, DefaultConstructorMarker arg13) {
        SheetState$$ExternalSyntheticLambda3 v10;
        if((arg12 & 4) != 0) {
            arg9 = SheetValue.Hidden;
        }

        SheetValue v3 = arg9;
        if((arg12 & 8) != 0) {
            v10 = new SheetState$$ExternalSyntheticLambda3();
        }

        this(arg7, arg8, v3, ((Function1)v10), false);
    }

    public SheetState(boolean arg8, Function0 arg9, Function0 arg10, SheetValue arg11, Function1 arg12, boolean arg13, int arg14, DefaultConstructorMarker arg15) {
        SheetState$$ExternalSyntheticLambda2 v12;
        if((arg14 & 8) != 0) {
            arg11 = SheetValue.Hidden;
        }

        SheetValue v4 = arg11;
        if((arg14 & 16) != 0) {
            v12 = new SheetState$$ExternalSyntheticLambda2();
        }

        this(arg8, arg9, arg10, v4, ((Function1)v12), false);
    }

    static final boolean _init_$lambda$0(SheetValue arg0) {
        return 1;
    }

    static final float _init_$lambda$11(Density arg1) {
        return arg1.toPx-0680j_4(BottomSheetDefaults.INSTANCE.getVelocityThreshold-D9Ej5fM$material3());
    }

    static final boolean _init_$lambda$7(SheetValue arg0) {
        return 1;
    }

    static final float _init_$lambda$9(Density arg1) {
        return arg1.toPx-0680j_4(BottomSheetDefaults.INSTANCE.getPositionalThreshold-D9Ej5fM$material3());
    }

    static final float anchoredDraggableState$lambda$5(Function0 arg0, float arg1) {
        return arg0.invoke().floatValue();
    }

    static final AnimationSpec anchoredDraggableState$lambda$6(SheetState arg0) {
        return arg0.anchoredDraggableMotionSpec;
    }

    public final Object animateTo$material3(SheetValue arg8, FiniteAnimationSpec arg9, float arg10, Continuation arg11) {
        Object v7 = AnchoredDraggableState.anchoredDrag$default(this.anchoredDraggableState, arg8, null, new SheetState$animateTo$2(this, arg10, arg9, null), arg11, 2, null);
        if(v7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v7;
        }

        return Unit.INSTANCE;
    }

    public static Object animateTo$material3$default(SheetState arg0, SheetValue arg1, FiniteAnimationSpec arg2, float arg3, Continuation arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = arg0.anchoredDraggableState.getLastVelocity();
        }

        return arg0.animateTo$material3(arg1, arg2, arg3, arg4);
    }

    public final Object expand(Continuation arg9) {
        if(this.confirmValueChange.invoke(SheetValue.Expanded).booleanValue()) {
            Object v8 = SheetState.animateTo$material3$default(this, SheetValue.Expanded, this.showMotionSpec, 0f, arg9, 4, null);
            if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v8;
            }

            return Unit.INSTANCE;
        }

        return Unit.INSTANCE;
    }

    public final AnimationSpec getAnchoredDraggableMotionSpec$material3() {
        return this.anchoredDraggableMotionSpec;
    }

    public final AnchoredDraggableState getAnchoredDraggableState$material3() {
        return this.anchoredDraggableState;
    }

    public final Function1 getConfirmValueChange$material3() {
        return this.confirmValueChange;
    }

    public final SheetValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final boolean getHasExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(SheetValue.Expanded);
    }

    public final boolean getHasPartiallyExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(SheetValue.PartiallyExpanded);
    }

    public final FiniteAnimationSpec getHideMotionSpec$material3() {
        return this.hideMotionSpec;
    }

    public final float getOffset$material3() {
        return this.anchoredDraggableState.getOffset();
    }

    public final FiniteAnimationSpec getShowMotionSpec$material3() {
        return this.showMotionSpec;
    }

    public final boolean getSkipHiddenState$material3() {
        return this.skipHiddenState;
    }

    public final boolean getSkipPartiallyExpanded$material3() {
        return this.skipPartiallyExpanded;
    }

    public final SheetValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final Object hide(Continuation arg9) {
        if(!this.skipHiddenState) {
            if(this.confirmValueChange.invoke(SheetValue.Hidden).booleanValue()) {
                Object v8 = SheetState.animateTo$material3$default(this, SheetValue.Hidden, this.hideMotionSpec, 0f, arg9, 4, null);
                if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return v8;
                }

                return Unit.INSTANCE;
            }

            return Unit.INSTANCE;
        }

        throw new IllegalStateException("Attempted to animate to hidden when skipHiddenState was enabled. Set skipHiddenState to false to use this function.".toString());
    }

    public final boolean isAnimationRunning() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final boolean isVisible() {
        if(this.anchoredDraggableState.getCurrentValue() != SheetValue.Hidden) {
            return 1;
        }

        return 0;
    }

    public final Object partialExpand(Continuation arg9) {
        if(!this.skipPartiallyExpanded) {
            if(this.confirmValueChange.invoke(SheetValue.PartiallyExpanded).booleanValue()) {
                Object v8 = SheetState.animateTo$material3$default(this, SheetValue.PartiallyExpanded, this.hideMotionSpec, 0f, arg9, 4, null);
                if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return v8;
                }

                return Unit.INSTANCE;
            }

            return Unit.INSTANCE;
        }

        throw new IllegalStateException("Attempted to animate to partial expanded when skipPartiallyExpanded was enabled. Set skipPartiallyExpanded to false to use this function.".toString());
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final void setAnchoredDraggableMotionSpec$material3(AnimationSpec arg1) {
        this.anchoredDraggableMotionSpec = arg1;
    }

    public final void setAnchoredDraggableState$material3(AnchoredDraggableState arg1) {
        this.anchoredDraggableState = arg1;
    }

    public final void setHideMotionSpec$material3(FiniteAnimationSpec arg1) {
        this.hideMotionSpec = arg1;
    }

    public final void setShowMotionSpec$material3(FiniteAnimationSpec arg1) {
        this.showMotionSpec = arg1;
    }

    public final Object settle$material3(float arg1, Continuation arg2) {
        Object v0 = this.anchoredDraggableState.settle(arg1, arg2);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public final Object show(Continuation arg9) {
        SheetValue v0 = this.getHasPartiallyExpandedState() ? SheetValue.PartiallyExpanded : SheetValue.Expanded;
        SheetValue v2 = v0;
        if(this.confirmValueChange.invoke(v2).booleanValue()) {
            Object v8 = SheetState.animateTo$material3$default(this, v2, this.showMotionSpec, 0f, arg9, 4, null);
            if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v8;
            }

            return Unit.INSTANCE;
        }

        return Unit.INSTANCE;
    }

    public final Object snapTo$material3(SheetValue arg1, Continuation arg2) {
        Object v0 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, arg1, arg2);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }
}

