package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 !2\u00020\u0001:\u0001!B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000E\u0010\u001A\u001A\u00020\u001BH\u0096@¢\u0006\u0002\u0010\u001CJ\u000E\u0010\u001D\u001A\u00020\u001BH\u0096@¢\u0006\u0002\u0010\u001CJ\u000E\u0010\u001E\u001A\u00020\u001BH\u0096@¢\u0006\u0002\u0010\u001CJ\u0016\u0010\u001F\u001A\u00020\u001B2\u0006\u0010\u0016\u001A\u00020\u0003H\u0096@¢\u0006\u0002\u0010 R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00030\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001A\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\nR\u0014\u0010\u0018\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\n¨\u0006\""}, d2={"Landroidx/compose/material3/WideNavigationRailStateImpl;", "Landroidx/compose/material3/WideNavigationRailState;", "initialValue", "Landroidx/compose/material3/WideNavigationRailValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/material3/WideNavigationRailValue;Landroidx/compose/animation/core/AnimationSpec;)V", "getInitialValue", "()Landroidx/compose/material3/WideNavigationRailValue;", "setInitialValue", "(Landroidx/compose/material3/WideNavigationRailValue;)V", "internalValue", "internalState", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "_currentVal", "Landroidx/compose/runtime/State;", "isAnimating", "", "()Z", "targetValue", "getTargetValue", "currentValue", "getCurrentValue", "expand", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collapse", "toggle", "snapTo", "(Landroidx/compose/material3/WideNavigationRailValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WideNavigationRailStateImpl implements WideNavigationRailState {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00050\fR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Landroidx/compose/material3/WideNavigationRailStateImpl$Companion;", "", "<init>", "()V", "Collapsed", "", "Expanded", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/WideNavigationRailState;", "Landroidx/compose/material3/WideNavigationRailValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver Saver(AnimationSpec arg2) {
            return SaverKt.Saver(new WideNavigationRailStateImpl$Companion$$ExternalSyntheticLambda0(), new WideNavigationRailStateImpl$Companion$$ExternalSyntheticLambda1(arg2));
        }

        static final WideNavigationRailValue Saver$lambda$0(SaverScope arg0, WideNavigationRailState arg1) {
            return arg1.getTargetValue();
        }

        static final WideNavigationRailState Saver$lambda$1(AnimationSpec arg1, WideNavigationRailValue arg2) {
            return new WideNavigationRailStateImpl(arg2, arg1);
        }
    }

    public static final int $stable = 0;
    private static final float Collapsed = 0f;
    public static final Companion Companion = null;
    private static final float Expanded = 1f;
    private final State _currentVal;
    private final AnimationSpec animationSpec;
    private WideNavigationRailValue initialValue;
    private final Animatable internalState;
    private final float internalValue;

    static {
        WideNavigationRailStateImpl.Companion = new Companion(null);
        WideNavigationRailStateImpl.$stable = 8;
    }

    public WideNavigationRailStateImpl(WideNavigationRailValue arg8, AnimationSpec arg9) {
        super();
        this.initialValue = arg8;
        this.animationSpec = arg9;
        float v8 = WideNavigationRailStateKt.isExpanded(arg8) ? 1f : 0f;
        this.internalValue = v8;
        this.internalState = new Animatable(Float.valueOf(v8), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null);
        this._currentVal = SnapshotStateKt.derivedStateOf(new WideNavigationRailStateImpl$$ExternalSyntheticLambda0(this));
    }

    static final WideNavigationRailValue _currentVal$lambda$0(WideNavigationRailStateImpl arg1) {
        if(arg1.internalState.getValue().floatValue() == 1f) {
            return WideNavigationRailValue.Expanded;
        }

        return WideNavigationRailValue.Collapsed;
    }

    public Object collapse(Continuation arg9) {
        Object v8 = Animatable.animateTo$default(this.internalState, Boxing.boxFloat(0f), this.animationSpec, null, null, arg9, 12, null);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }

    public Object expand(Continuation arg9) {
        Object v8 = Animatable.animateTo$default(this.internalState, Boxing.boxFloat(1f), this.animationSpec, null, null, arg9, 12, null);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }

    public WideNavigationRailValue getCurrentValue() {
        return this._currentVal.getValue();
    }

    public final WideNavigationRailValue getInitialValue() {
        return this.initialValue;
    }

    public WideNavigationRailValue getTargetValue() {
        if(this.internalState.getTargetValue().floatValue() == 1f) {
            return WideNavigationRailValue.Expanded;
        }

        return WideNavigationRailValue.Collapsed;
    }

    public boolean isAnimating() {
        return this.internalState.isRunning();
    }

    public final void setInitialValue(WideNavigationRailValue arg1) {
        this.initialValue = arg1;
    }

    public Object snapTo(WideNavigationRailValue arg1, Continuation arg2) {
        float v1 = WideNavigationRailStateKt.isExpanded(arg1) ? 1f : 0f;
        Object v0 = this.internalState.snapTo(Boxing.boxFloat(v1), arg2);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public Object toggle(Continuation arg9) {
        Animatable v0 = this.internalState;
        float v1 = WideNavigationRailStateKt.isExpanded(this.getTargetValue()) ? 0f : 1f;
        Object v8 = Animatable.animateTo$default(v0, Boxing.boxFloat(v1), this.animationSpec, null, null, arg9, 12, null);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }
}

