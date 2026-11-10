package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A&\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0002H\u0007\"\u000E\u0010\u0006\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\r\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u000E\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u000F\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0010\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Animatable", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "initialValue", "visibilityThreshold", "positiveInfinityBounds1D", "positiveInfinityBounds2D", "Landroidx/compose/animation/core/AnimationVector2D;", "positiveInfinityBounds3D", "Landroidx/compose/animation/core/AnimationVector3D;", "positiveInfinityBounds4D", "Landroidx/compose/animation/core/AnimationVector4D;", "negativeInfinityBounds1D", "negativeInfinityBounds2D", "negativeInfinityBounds3D", "negativeInfinityBounds4D", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AnimatableKt {
    private static final AnimationVector1D negativeInfinityBounds1D;
    private static final AnimationVector2D negativeInfinityBounds2D;
    private static final AnimationVector3D negativeInfinityBounds3D;
    private static final AnimationVector4D negativeInfinityBounds4D;
    private static final AnimationVector1D positiveInfinityBounds1D;
    private static final AnimationVector2D positiveInfinityBounds2D;
    private static final AnimationVector3D positiveInfinityBounds3D;
    private static final AnimationVector4D positiveInfinityBounds4D;

    static {
        AnimatableKt.positiveInfinityBounds1D = AnimationVectorsKt.AnimationVector(Infinityf);
        AnimatableKt.positiveInfinityBounds2D = AnimationVectorsKt.AnimationVector(Infinityf, Infinityf);
        AnimatableKt.positiveInfinityBounds3D = AnimationVectorsKt.AnimationVector(Infinityf, Infinityf, Infinityf);
        AnimatableKt.positiveInfinityBounds4D = AnimationVectorsKt.AnimationVector(Infinityf, Infinityf, Infinityf, Infinityf);
        AnimatableKt.negativeInfinityBounds1D = AnimationVectorsKt.AnimationVector(-Infinityf);
        AnimatableKt.negativeInfinityBounds2D = AnimationVectorsKt.AnimationVector(-Infinityf, -Infinityf);
        AnimatableKt.negativeInfinityBounds3D = AnimationVectorsKt.AnimationVector(-Infinityf, -Infinityf, -Infinityf);
        AnimatableKt.negativeInfinityBounds4D = AnimationVectorsKt.AnimationVector(-Infinityf, -Infinityf, -Infinityf, -Infinityf);
    }

    public static final Animatable Animatable(float arg7, float arg8) {
        return new Animatable(Float.valueOf(arg7), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(arg8), null, 8, null);
    }

    public static Animatable Animatable$default(float arg0, float arg1, int arg2, Object arg3) {
        if((arg2 & 2) != 0) {
            arg1 = 0.01f;
        }

        return AnimatableKt.Animatable(arg0, arg1);
    }

    public static final AnimationVector1D access$getNegativeInfinityBounds1D$p() {
        return AnimatableKt.negativeInfinityBounds1D;
    }

    public static final AnimationVector2D access$getNegativeInfinityBounds2D$p() {
        return AnimatableKt.negativeInfinityBounds2D;
    }

    public static final AnimationVector3D access$getNegativeInfinityBounds3D$p() {
        return AnimatableKt.negativeInfinityBounds3D;
    }

    public static final AnimationVector4D access$getNegativeInfinityBounds4D$p() {
        return AnimatableKt.negativeInfinityBounds4D;
    }

    public static final AnimationVector1D access$getPositiveInfinityBounds1D$p() {
        return AnimatableKt.positiveInfinityBounds1D;
    }

    public static final AnimationVector2D access$getPositiveInfinityBounds2D$p() {
        return AnimatableKt.positiveInfinityBounds2D;
    }

    public static final AnimationVector3D access$getPositiveInfinityBounds3D$p() {
        return AnimatableKt.positiveInfinityBounds3D;
    }

    public static final AnimationVector4D access$getPositiveInfinityBounds4D$p() {
        return AnimatableKt.positiveInfinityBounds4D;
    }
}

