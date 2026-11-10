package androidx.compose.material3;

import androidx.collection.IntList;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot$Companion;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u000E\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001C\u0010\u001A\u001A\u00020\u001B2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00160\u001DH\u0086@¢\u0006\u0002\u0010\u001EJ\b\u0010\u001F\u001A\u00020\u0005H\u0002J\u0010\u0010$\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016H\u0002J\u001C\u0010)\u001A\u00020\u001B2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00160\u001DH\u0086@¢\u0006\u0002\u0010\u001EJ.\u0010*\u001A\u00020\u001B2\u0006\u0010+\u001A\u00020\u00162\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00160\u001D2\b\b\u0002\u0010,\u001A\u00020\u0005H\u0086@¢\u0006\u0002\u0010-J\b\u00105\u001A\u00020\u001BH\u0002J\f\u00109\u001A\u00020\u0016*\u00020\u0016H\u0002J\f\u0010<\u001A\u00020/*\u00020\u0016H\u0002J\f\u0010=\u001A\u00020/*\u00020\u0016H\u0002J\u0010\u0010>\u001A\u00020\u00162\u0006\u0010+\u001A\u00020\u0016H\u0002R\u0011\u0010\u0002\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR+\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\r8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001A\u00020\u00168F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0010R\u000E\u0010\u0018\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010 \u001A\u00020!8F¢\u0006\u0006\u001A\u0004\b\"\u0010#R\u001A\u0010&\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020(0\'X\u0082\u000E¢\u0006\u0002\n\u0000R$\u00100\u001A\u00020/2\u0006\u0010.\u001A\u00020/8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b1\u00102\"\u0004\b3\u00104R$\u00106\u001A\u00020/2\u0006\u0010.\u001A\u00020/8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b7\u00102\"\u0004\b8\u00104R\u000E\u0010:\u001A\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010?\u001A\u00020\u0005X\u0096\u000F¢\u0006\f\u001A\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0018\u0010C\u001A\u00020DX\u0096\u000F¢\u0006\f\u001A\u0004\bE\u00102\"\u0004\bF\u00104¨\u0006G"}, d2={"Landroidx/compose/material3/AnalogTimePickerState;", "Landroidx/compose/material3/TimePickerState;", "state", "userOverride", "Landroidx/compose/ui/node/Ref;", "", "<init>", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/node/Ref;)V", "getState", "()Landroidx/compose/material3/TimePickerState;", "getUserOverride", "()Landroidx/compose/ui/node/Ref;", "<set-?>", "Landroidx/compose/ui/unit/Dp;", "currentDiameter", "getCurrentDiameter-D9Ej5fM", "()F", "setCurrentDiameter-0680j_4", "(F)V", "currentDiameter$delegate", "Landroidx/compose/runtime/MutableState;", "currentAngle", "", "getCurrentAngle", "hourAngle", "minuteAngle", "animateToCurrent", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUpdated", "clockFaceValues", "Landroidx/collection/IntList;", "getClockFaceValues", "()Landroidx/collection/IntList;", "endValueForAnimation", "new", "anim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "onGestureEnd", "rotateTo", "angle", "animate", "(FLandroidx/compose/animation/core/AnimationSpec;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "minute", "getMinute", "()I", "setMinute", "(I)V", "updateBaseStateMinute", "hour", "getHour", "setHour", "normalize", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "toHour", "toMinute", "offsetAngle", "is24hour", "()Z", "set24hour", "(Z)V", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "getSelection-yecRtBI", "setSelection-6_8s6DQ", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnalogTimePickerState implements TimePickerState {
    public static final int $stable = 8;
    private Animatable anim;
    private final MutableState currentDiameter$delegate;
    private float hourAngle;
    private float minuteAngle;
    private final MutatorMutex mutex;
    private final TimePickerState state;
    private final Ref userOverride;

    static {
    }

    public AnalogTimePickerState(TimePickerState arg5, Ref arg6) {
        super();
        this.state = arg5;
        this.userOverride = arg6;
        this.currentDiameter$delegate = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(0f)), null, 2, null);
        this.hourAngle = (((float)(arg5.getHour() % 12))) * 0.523599f - 1.570796f;
        this.minuteAngle = (((float)arg5.getMinute())) * 0.10472f - 1.570796f;
        this.anim = AnimatableKt.Animatable$default(this.hourAngle, 0f, 2, null);
        this.mutex = new MutatorMutex();
    }

    public AnalogTimePickerState(TimePickerState arg1, Ref arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = new Ref();
        }

        this(arg1, arg2);
    }

    public static final float access$endValueForAnimation(AnalogTimePickerState arg0, float arg1) {
        return arg0.endValueForAnimation(arg1);
    }

    public static final Animatable access$getAnim$p(AnalogTimePickerState arg0) {
        return arg0.anim;
    }

    public static final float access$getHourAngle$p(AnalogTimePickerState arg0) {
        return arg0.hourAngle;
    }

    public static final float access$getMinuteAngle$p(AnalogTimePickerState arg0) {
        return arg0.minuteAngle;
    }

    public static final float access$offsetAngle(AnalogTimePickerState arg0, float arg1) {
        return arg0.offsetAngle(arg1);
    }

    public static final void access$setHourAngle$p(AnalogTimePickerState arg0, float arg1) {
        arg0.hourAngle = arg1;
    }

    public static final void access$setMinuteAngle$p(AnalogTimePickerState arg0, float arg1) {
        arg0.minuteAngle = arg1;
    }

    public static final int access$toHour(AnalogTimePickerState arg0, float arg1) {
        return arg0.toHour(arg1);
    }

    public static final int access$toMinute(AnalogTimePickerState arg0, float arg1) {
        return arg0.toMinute(arg1);
    }

    public final Object animateToCurrent(AnimationSpec arg6, Continuation arg7) {
        if(!this.isUpdated()) {
            return Unit.INSTANCE;
        }

        float v0 = TimePickerSelectionMode.equals-impl0(this.getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getHour-yecRtBI()) ? this.endValueForAnimation(this.hourAngle) : this.endValueForAnimation(this.minuteAngle);
        Object v5 = this.mutex.mutate(MutatePriority.PreventUserInput, new AnalogTimePickerState$animateToCurrent$2(this, v0, arg6, null), arg7);
        if(v5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v5;
        }

        return Unit.INSTANCE;
    }

    private final float endValueForAnimation(float arg3) {
        float v1;
        float v0 = this.anim.getValue().floatValue() - arg3;
        while(true) {
            v1 = 6.283185f;
            if(Float.compare(v0, 3.141593f) > 0) {
                v0 -= v1;
                continue;
            }

            break;
        }

        while(v0 <= -3.141593f) {
            v0 += v1;
        }

        return this.anim.getValue().floatValue() - v0;
    }

    public final IntList getClockFaceValues() {
        if(TimePickerSelectionMode.equals-impl0(this.getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getMinute-yecRtBI())) {
            return TimePickerKt.access$getMinutes$p();
        }

        return TimePickerKt.access$getHours$p();
    }

    public final float getCurrentAngle() {
        return this.anim.getValue().floatValue();
    }

    public final float getCurrentDiameter-D9Ej5fM() {
        return this.currentDiameter$delegate.getValue().unbox-impl();
    }

    public int getHour() {
        return this.state.getHour();
    }

    public int getMinute() {
        return this.state.getMinute();
    }

    public int getSelection-yecRtBI() {
        return this.state.getSelection-yecRtBI();
    }

    public final TimePickerState getState() {
        return this.state;
    }

    public final Ref getUserOverride() {
        return this.userOverride;
    }

    public boolean is24hour() {
        return this.state.is24hour();
    }

    private final boolean isUpdated() {
        if((TimePickerSelectionMode.equals-impl0(this.getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getHour-yecRtBI())) && this.normalize(this.anim.getTargetValue().floatValue()) == this.normalize(this.hourAngle)) {
            return 0;
        }

        if((TimePickerSelectionMode.equals-impl0(this.getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getMinute-yecRtBI())) && this.normalize(this.anim.getTargetValue().floatValue()) == this.normalize(this.minuteAngle)) {
            return 0;
        }

        return 1;
    }

    private final float normalize(float arg5) {
        double v0 = 6.283185;
        double v4 = (((double)arg5)) % v0;
        if(v4 < 0) {
            v4 += v0;
        }

        return ((float)v4);
    }

    private final float offsetAngle(float arg1) {
        arg1 += 1.570796f;
        if(arg1 < 0f) {
            arg1 += 6.283185f;
        }

        return arg1;
    }

    public final Object onGestureEnd(AnimationSpec arg6, Continuation arg7) {
        float v0 = TimePickerSelectionMode.equals-impl0(this.getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getHour-yecRtBI()) ? this.hourAngle : this.minuteAngle;
        Object v5 = this.mutex.mutate(MutatePriority.PreventUserInput, new AnalogTimePickerState$onGestureEnd$2(this, this.endValueForAnimation(v0), arg6, null), arg7);
        if(v5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v5;
        }

        return Unit.INSTANCE;
    }

    public final Object rotateTo(float arg9, AnimationSpec arg10, boolean arg11, Continuation arg12) {
        this.userOverride.setValue(Boxing.boxBoolean(false));
        Object v8 = this.mutex.mutate(MutatePriority.UserInput, new AnalogTimePickerState$rotateTo$2(this, arg9, arg11, arg10, null), arg12);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }

    public static Object rotateTo$default(AnalogTimePickerState arg0, float arg1, AnimationSpec arg2, boolean arg3, Continuation arg4, int arg5, Object arg6) {
        return arg0.rotateTo(arg1, arg2, false, arg4);
    }

    public void set24hour(boolean arg1) {
        this.state.set24hour(arg1);
    }

    public final void setCurrentDiameter-0680j_4(float arg1) {
        this.currentDiameter$delegate.setValue(Dp.box-impl(arg1));
    }

    public void setHour(int arg4) {
        this.hourAngle = (((float)(arg4 % 12))) * 0.523599f - 1.570796f;
        this.state.setHour(arg4);
        if(TimePickerSelectionMode.equals-impl0(this.getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getHour-yecRtBI())) {
            this.anim = AnimatableKt.Animatable$default(this.hourAngle, 0f, 2, null);
        }
    }

    public void setMinute(int arg4) {
        this.minuteAngle = (((float)arg4)) * 0.10472f - 1.570796f;
        this.state.setMinute(arg4);
        if(TimePickerSelectionMode.equals-impl0(this.getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getMinute-yecRtBI())) {
            this.anim = AnimatableKt.Animatable$default(this.minuteAngle, 0f, 2, null);
        }

        this.updateBaseStateMinute();
    }

    public void setSelection-6_8s6DQ(int arg1) {
        this.state.setSelection-6_8s6DQ(arg1);
    }

    private final int toHour(float arg3) {
        return (((int)(((((double)arg3)) + 1.832596) / 0.523599))) % 12;
    }

    private final int toMinute(float arg3) {
        return (((int)(((((double)arg3)) + 1.623156) / 0.10472))) % 60;
    }

    private final void updateBaseStateMinute() {
        Companion v0 = Snapshot.Companion;
        Snapshot v1 = v0.getCurrentThreadSnapshot();
        Function1 v2 = v1 != null ? v1.getReadObserver() : null;
        Snapshot v3 = v0.makeCurrentNonObservable(v1);
        try {
            this.state.setMinute(this.getMinute());
        }
        catch(Throwable v5) {
            v0.restoreNonObservable(v1, v3, v2);
            throw v5;
        }

        v0.restoreNonObservable(v1, v3, v2);
    }
}

