package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001Ak\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0002\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0007*\u000E\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00022\b\b\u0002\u0010\b\u001A\u0002H\u00052\n\b\u0002\u0010\t\u001A\u0004\u0018\u0001H\u00062\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u000B2\b\b\u0002\u0010\r\u001A\u00020\u0001¢\u0006\u0002\u0010\u000E\u001AT\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00100\u0002*\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00100\u00022\b\b\u0002\u0010\b\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u000F2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u000B2\b\b\u0002\u0010\r\u001A\u00020\u0001\u001AB\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00100\u00022\u0006\u0010\u0013\u001A\u00020\u000F2\b\b\u0002\u0010\u0014\u001A\u00020\u000F2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u000B2\b\b\u0002\u0010\r\u001A\u00020\u0001\u001Ai\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0002\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\u0012\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00162\u0006\u0010\u0013\u001A\u0002H\u00052\u0006\u0010\u0014\u001A\u0002H\u00052\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u000B2\b\b\u0002\u0010\r\u001A\u00020\u0001¢\u0006\u0002\u0010\u0017\u001A3\u0010\u0018\u001A\u0002H\u0006\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0007*\u000E\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00162\u0006\u0010\b\u001A\u0002H\u0005¢\u0006\u0002\u0010\u0019\"\u001D\u0010\u0000\u001A\u00020\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001A\u0004\b\u0000\u0010\u0003¨\u0006\u001A"}, d2={"isFinished", "", "Landroidx/compose/animation/core/AnimationState;", "(Landroidx/compose/animation/core/AnimationState;)Z", "copy", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "value", "velocityVector", "lastFrameTimeNanos", "", "finishedTimeNanos", "isRunning", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;JJZ)Landroidx/compose/animation/core/AnimationState;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "velocity", "AnimationState", "initialValue", "initialVelocity", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;JJZ)Landroidx/compose/animation/core/AnimationState;", "createZeroVectorFrom", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)Landroidx/compose/animation/core/AnimationVector;", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AnimationStateKt {
    public static final AnimationState AnimationState(float arg9, float arg10, long arg11, long arg13, boolean arg15) {
        return new AnimationState(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(arg9), AnimationVectorsKt.AnimationVector(arg10), arg11, arg13, arg15);
    }

    public static final AnimationState AnimationState(TwoWayConverter arg9, Object arg10, Object arg11, long arg12, long arg14, boolean arg16) {
        return new AnimationState(arg9, arg10, arg9.getConvertToVector().invoke(arg11), arg12, arg14, arg16);
    }

    public static AnimationState AnimationState$default(float arg2, float arg3, long arg4, long arg6, boolean arg8, int arg9, Object arg10) {
        long v0 = -9223372036854775808L;
        if((arg9 & 4) != 0) {
            arg4 = v0;
        }

        if((arg9 & 8) != 0) {
            arg6 = v0;
        }

        return AnimationStateKt.AnimationState(arg2, 0f, arg4, arg6, false);
    }

    public static AnimationState AnimationState$default(TwoWayConverter arg2, Object arg3, Object arg4, long arg5, long arg7, boolean arg9, int arg10, Object arg11) {
        long v0 = -9223372036854775808L;
        if((arg10 & 8) != 0) {
            arg5 = v0;
        }

        if((arg10 & 16) != 0) {
            arg7 = v0;
        }

        return AnimationStateKt.AnimationState(arg2, arg3, arg4, arg5, arg7, false);
    }

    public static final AnimationState copy(AnimationState arg9, float arg10, float arg11, long arg12, long arg14, boolean arg16) {
        return new AnimationState(arg9.getTypeConverter(), Float.valueOf(arg10), AnimationVectorsKt.AnimationVector(arg11), arg12, arg14, arg16);
    }

    public static final AnimationState copy(AnimationState arg9, Object arg10, AnimationVector arg11, long arg12, long arg14, boolean arg16) {
        return new AnimationState(arg9.getTypeConverter(), arg10, arg11, arg12, arg14, arg16);
    }

    public static AnimationState copy$default(AnimationState arg0, float arg1, float arg2, long arg3, long arg5, boolean arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.getValue().floatValue();
        }

        if((arg8 & 2) != 0) {
            arg2 = arg0.getVelocityVector().getValue();
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.getLastFrameTimeNanos();
        }

        if((arg8 & 8) != 0) {
            arg5 = arg0.getFinishedTimeNanos();
        }

        if((arg8 & 16) != 0) {
            arg7 = arg0.isRunning();
        }

        return AnimationStateKt.copy(arg0, arg1, arg2, arg3, arg5, arg7);
    }

    public static AnimationState copy$default(AnimationState arg0, Object arg1, AnimationVector arg2, long arg3, long arg5, boolean arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.getValue();
        }

        if((arg8 & 2) != 0) {
            arg2 = AnimationVectorsKt.copy(arg0.getVelocityVector());
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.getLastFrameTimeNanos();
        }

        if((arg8 & 8) != 0) {
            arg5 = arg0.getFinishedTimeNanos();
        }

        if((arg8 & 16) != 0) {
            arg7 = arg0.isRunning();
        }

        return AnimationStateKt.copy(arg0, arg1, arg2, arg3, arg5, arg7);
    }

    public static final AnimationVector createZeroVectorFrom(TwoWayConverter arg0, Object arg1) {
        Object v0 = arg0.getConvertToVector().invoke(arg1);
        ((AnimationVector)v0).reset$animation_core();
        return ((AnimationVector)v0);
    }

    public static final boolean isFinished(AnimationState arg4) {
        if(arg4.getFinishedTimeNanos() != -9223372036854775808L) {
            return 1;
        }

        return 0;
    }
}

