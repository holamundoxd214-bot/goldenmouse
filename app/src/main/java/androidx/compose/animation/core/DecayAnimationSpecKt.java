package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1={"\u0000$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001AI\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\b\b\u0001\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0007\u001A\u0002H\u00012\u0006\u0010\b\u001A\u0002H\u0001¢\u0006\u0002\u0010\t\u001A \u0010\u0000\u001A\u00020\n*\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u0007\u001A\u00020\n2\u0006\u0010\b\u001A\u00020\n\u001A&\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0004\"\u0004\b\u0000\u0010\u00012\b\b\u0003\u0010\f\u001A\u00020\n2\b\b\u0003\u0010\r\u001A\u00020\n\u001A\u0016\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0004\"\u0004\b\u0000\u0010\u0001*\u00020\u000F¨\u0006\u0010"}, d2={"calculateTargetValue", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocity", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "exponentialDecay", "frictionMultiplier", "absVelocityThreshold", "generateDecayAnimationSpec", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DecayAnimationSpecKt {
    public static final float calculateTargetValue(DecayAnimationSpec arg1, float arg2, float arg3) {
        return arg1.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE)).getTargetValue(AnimationVectorsKt.AnimationVector(arg2), AnimationVectorsKt.AnimationVector(arg3)).getValue();
    }

    public static final Object calculateTargetValue(DecayAnimationSpec arg1, TwoWayConverter arg2, Object arg3, Object arg4) {
        return arg2.getConvertFromVector().invoke(arg1.vectorize(arg2).getTargetValue(arg2.getConvertToVector().invoke(arg3), arg2.getConvertToVector().invoke(arg4)));
    }

    public static final DecayAnimationSpec exponentialDecay(float arg1, float arg2) {
        return DecayAnimationSpecKt.generateDecayAnimationSpec(new FloatExponentialDecaySpec(arg1, arg2));
    }

    public static DecayAnimationSpec exponentialDecay$default(float arg0, float arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg0 = 1f;
        }

        if((arg2 & 2) != 0) {
            arg1 = 0.1f;
        }

        return DecayAnimationSpecKt.exponentialDecay(arg0, arg1);
    }

    public static final DecayAnimationSpec generateDecayAnimationSpec(FloatDecayAnimationSpec arg1) {
        return new DecayAnimationSpecImpl(arg1);
    }
}

