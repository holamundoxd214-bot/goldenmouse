package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00040\u0001\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00060\u0001\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0004\b\b\u0010\tJ,\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\f0\u000B\"\b\b\u0000\u0010\f*\u00020\r2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\f0\u000FH\u0016R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/gestures/DelegatingAnimationSpec;", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/foundation/gestures/AnimationData;", "zoomAnimationSpec", "", "offsetAnimationSpec", "Landroidx/compose/ui/geometry/Offset;", "rotationAnimationSpec", "<init>", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "vectorize", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DelegatingAnimationSpec implements AnimationSpec {
    private final AnimationSpec offsetAnimationSpec;
    private final AnimationSpec rotationAnimationSpec;
    private final AnimationSpec zoomAnimationSpec;

    public DelegatingAnimationSpec(AnimationSpec arg1, AnimationSpec arg2, AnimationSpec arg3) {
        super();
        this.zoomAnimationSpec = arg1;
        this.offsetAnimationSpec = arg2;
        this.rotationAnimationSpec = arg3;
    }

    public VectorizedAnimationSpec vectorize(TwoWayConverter arg4) {
        return new DelegatingAnimationSpec$vectorize$1(arg4, this.zoomAnimationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE)), this.offsetAnimationSpec.vectorize(VectorConvertersKt.getVectorConverter(Offset.Companion)), this.rotationAnimationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE)));
    }
}

