package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.material3.internal.ElevationKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0010\u001A\u00020\u0003*\u0004\u0018\u00010\u000EH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0003H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J\u000E\u0010\u0017\u001A\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001A\u00020\u00142\b\u0010\u001A\u001A\u0004\u0018\u00010\u000EH\u0086@¢\u0006\u0002\u0010\u001BJ\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00030\u001DR\u0010\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0006\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\tR\u001A\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Landroidx/compose/material3/FloatingActionButtonElevationAnimatable;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "hoveredElevation", "focusedElevation", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "lastTargetInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "targetInteraction", "calculateTarget", "calculateTarget-u2uoSUM", "(Landroidx/compose/foundation/interaction/Interaction;)F", "updateElevation", "", "updateElevation-lDy3nrA", "(FFFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapElevation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateElevation", "to", "(Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asState", "Landroidx/compose/runtime/State;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class FloatingActionButtonElevationAnimatable {
    private final Animatable animatable;
    private float defaultElevation;
    private float focusedElevation;
    private float hoveredElevation;
    private Interaction lastTargetInteraction;
    private float pressedElevation;
    private Interaction targetInteraction;

    public FloatingActionButtonElevationAnimatable(float arg1, float arg2, float arg3, float arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    private FloatingActionButtonElevationAnimatable(float arg8, float arg9, float arg10, float arg11) {
        super();
        this.defaultElevation = arg8;
        this.pressedElevation = arg9;
        this.hoveredElevation = arg10;
        this.focusedElevation = arg11;
        this.animatable = new Animatable(Dp.box-impl(this.defaultElevation), VectorConvertersKt.getVectorConverter(Dp.Companion), null, null, 12, null);
    }

    public static final Object access$snapElevation(FloatingActionButtonElevationAnimatable arg0, Continuation arg1) {
        return arg0.snapElevation(arg1);
    }

    public final Object animateElevation(Interaction arg6, Continuation arg7) {
        Object v6;
        FloatingActionButtonElevationAnimatable$animateElevation$1 v0_1;
        int v2;
        if((arg7 instanceof FloatingActionButtonElevationAnimatable$animateElevation$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((FloatingActionButtonElevationAnimatable$animateElevation$1)v0).label & v2) != 0) {
                ((FloatingActionButtonElevationAnimatable$animateElevation$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new FloatingActionButtonElevationAnimatable$animateElevation$1(this, arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            float v7_2 = this.calculateTarget-u2uoSUM(arg6);
            this.targetInteraction = arg6;
            try {
                if(!Dp.equals-impl0(this.animatable.getTargetValue().unbox-impl(), v7_2)) {
                    Animatable v2_1 = this.animatable;
                    Interaction v4 = this.lastTargetInteraction;
                    v0_1.L$0 = arg6;
                    v0_1.label = 1;
                    if(ElevationKt.animateElevation-rAjV9yQ(v2_1, v7_2, v4, arg6, ((Continuation)v0_1)) != v1) {
                        goto label_41;
                    }

                    return v1;
                }

                goto label_41;
            }
            catch(Throwable v7_1) {
            label_45:
                this.lastTargetInteraction = ((Interaction)v6);
                throw v7_1;
            }

            return v1;
        }
        else if(v2 == 1) {
            v6 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v7);
            }
            catch(Throwable v7_1) {
                goto label_45;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_41:
        this.lastTargetInteraction = ((Interaction)v6);
        return Unit.INSTANCE;
    }

    public final State asState() {
        return this.animatable.asState();
    }

    private final float calculateTarget-u2uoSUM(Interaction arg2) {
        if((arg2 instanceof Press)) {
            return this.pressedElevation;
        }

        if((arg2 instanceof Enter)) {
            return this.hoveredElevation;
        }

        if((arg2 instanceof Focus)) {
            return this.focusedElevation;
        }

        return this.defaultElevation;
    }

    private final Object snapElevation(Continuation arg5) {
        int v2;
        Continuation v0;
        if((arg5 instanceof FloatingActionButtonElevationAnimatable$snapElevation$1)) {
            v0 = arg5;
            v2 = 0x80000000;
            if((((FloatingActionButtonElevationAnimatable$snapElevation$1)v0).label & v2) != 0) {
                ((FloatingActionButtonElevationAnimatable$snapElevation$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            FloatingActionButtonElevationAnimatable$snapElevation$1 v0_1 = new FloatingActionButtonElevationAnimatable$snapElevation$1(this, arg5);
        }

        Object v5 = ((FloatingActionButtonElevationAnimatable$snapElevation$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((FloatingActionButtonElevationAnimatable$snapElevation$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            float v5_2 = this.calculateTarget-u2uoSUM(this.targetInteraction);
            if(!Dp.equals-impl0(this.animatable.getTargetValue().unbox-impl(), v5_2)) {
                try {
                    Animatable v2_1 = this.animatable;
                    Dp v5_3 = Dp.box-impl(v5_2);
                    ((FloatingActionButtonElevationAnimatable$snapElevation$1)v0).label = 1;
                    if(v2_1.snapTo(v5_3, v0) != v1) {
                        goto label_41;
                    }
                }
                catch(Throwable v5_1) {
                label_44:
                    this.lastTargetInteraction = this.targetInteraction;
                    throw v5_1;
                }

                return v1;
            label_41:
                this.lastTargetInteraction = this.targetInteraction;
            }
        }
        else if(v2 == 1) {
            try {
                ResultKt.throwOnFailure(v5);
                goto label_41;
            }
            catch(Throwable v5_1) {
                goto label_44;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Unit.INSTANCE;
    }

    public final Object updateElevation-lDy3nrA(float arg1, float arg2, float arg3, float arg4, Continuation arg5) {
        this.defaultElevation = arg1;
        this.pressedElevation = arg2;
        this.hoveredElevation = arg3;
        this.focusedElevation = arg4;
        Object v0 = this.snapElevation(arg5);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }
}

