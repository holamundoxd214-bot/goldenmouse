package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0001\u0010\t*\u00020\n2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\t0\fH\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Landroidx/compose/animation/core/DecayAnimationSpecImpl;", "T", "Landroidx/compose/animation/core/DecayAnimationSpec;", "floatDecaySpec", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "<init>", "(Landroidx/compose/animation/core/FloatDecayAnimationSpec;)V", "vectorize", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class DecayAnimationSpecImpl implements DecayAnimationSpec {
    private final FloatDecayAnimationSpec floatDecaySpec;

    public DecayAnimationSpecImpl(FloatDecayAnimationSpec arg1) {
        super();
        this.floatDecaySpec = arg1;
    }

    public VectorizedDecayAnimationSpec vectorize(TwoWayConverter arg1) {
        return new VectorizedFloatDecaySpec(this.floatDecaySpec);
    }
}

