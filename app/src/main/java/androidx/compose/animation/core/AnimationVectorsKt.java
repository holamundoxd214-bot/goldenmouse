package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001A\u000E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003\u001A\u0016\u0010\u0000\u001A\u00020\u00042\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0003\u001A\u001E\u0010\u0000\u001A\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0003\u001A&\u0010\u0000\u001A\u00020\b2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0003\u001A\u001B\u0010\n\u001A\u0002H\u000B\"\b\b\u0000\u0010\u000B*\u00020\f*\u0002H\u000BH\u0000¢\u0006\u0002\u0010\r\u001A\u001B\u0010\u000E\u001A\u0002H\u000B\"\b\b\u0000\u0010\u000B*\u00020\f*\u0002H\u000BH\u0000¢\u0006\u0002\u0010\r\u001A#\u0010\u000F\u001A\u00020\u0010\"\b\b\u0000\u0010\u000B*\u00020\f*\u0002H\u000B2\u0006\u0010\u0011\u001A\u0002H\u000BH\u0000¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2={"AnimationVector", "Landroidx/compose/animation/core/AnimationVector1D;", "v1", "", "Landroidx/compose/animation/core/AnimationVector2D;", "v2", "Landroidx/compose/animation/core/AnimationVector3D;", "v3", "Landroidx/compose/animation/core/AnimationVector4D;", "v4", "newInstance", "T", "Landroidx/compose/animation/core/AnimationVector;", "(Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "copy", "copyFrom", "", "source", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AnimationVectorsKt {
    public static final AnimationVector1D AnimationVector(float arg1) {
        return new AnimationVector1D(arg1);
    }

    public static final AnimationVector2D AnimationVector(float arg1, float arg2) {
        return new AnimationVector2D(arg1, arg2);
    }

    public static final AnimationVector3D AnimationVector(float arg1, float arg2, float arg3) {
        return new AnimationVector3D(arg1, arg2, arg3);
    }

    public static final AnimationVector4D AnimationVector(float arg1, float arg2, float arg3, float arg4) {
        return new AnimationVector4D(arg1, arg2, arg3, arg4);
    }

    public static final AnimationVector copy(AnimationVector arg4) {
        AnimationVector v0 = AnimationVectorsKt.newInstance(arg4);
        int v1 = v0.getSize$animation_core();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.set$animation_core(v2, arg4.get$animation_core(v2));
        }

        return v0;
    }

    public static final void copyFrom(AnimationVector arg3, AnimationVector arg4) {
        int v0 = arg3.getSize$animation_core();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3.set$animation_core(v1, arg4.get$animation_core(v1));
        }
    }

    public static final AnimationVector newInstance(AnimationVector arg1) {
        arg1 = arg1.newVector$animation_core();
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type T of androidx.compose.animation.core.AnimationVectorsKt.newInstance");
        return arg1;
    }
}

