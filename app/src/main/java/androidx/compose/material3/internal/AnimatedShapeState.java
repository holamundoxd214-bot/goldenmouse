package androidx.compose.material3.internal;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u001A\u001A\u00020\u00062\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b \u0010!J!\u0010\u001D\u001A\u00020\u00062\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b\"\u0010!J!\u0010\u001E\u001A\u00020\u00062\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b#\u0010!J!\u0010\u001F\u001A\u00020\u00062\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b$\u0010!J\u0016\u0010%\u001A\u00020&2\u0006\u0010\u0002\u001A\u00020\'H\u0086@¢\u0006\u0002\u0010(R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u001C\u0010\r\u001A\u00020\u000EX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0013\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0014\u001A\u00020\u0015X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001C\u0010\u001A\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001C\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u001D\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001C\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u001E\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001C\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u001F\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001C\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006)"}, d2={"Landroidx/compose/material3/internal/AnimatedShapeState;", "", "shape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "spec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "<init>", "(Landroidx/compose/foundation/shape/RoundedCornerShape;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "getShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "getSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "J", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "topStart", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "topEnd", "bottomStart", "bottomEnd", "topStart-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", "topEnd-TmRCtEA", "bottomStart-TmRCtEA", "bottomEnd-TmRCtEA", "animateToShape", "Lkotlinx/coroutines/Job;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "(Landroidx/compose/foundation/shape/CornerBasedShape;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnimatedShapeState {
    public static final int $stable;
    private Animatable bottomEnd;
    private Animatable bottomStart;
    private Density density;
    private final RoundedCornerShape shape;
    private long size;
    private final FiniteAnimationSpec spec;
    private Animatable topEnd;
    private Animatable topStart;

    static {
    }

    public AnimatedShapeState(RoundedCornerShape arg1, FiniteAnimationSpec arg2) {
        super();
        this.shape = arg1;
        this.spec = arg2;
        this.size = Size.Companion.getZero-NH-jbRc();
        this.density = DensityKt.Density(0f, 0f);
    }

    public static final Animatable access$getBottomEnd$p(AnimatedShapeState arg0) {
        return arg0.bottomEnd;
    }

    public static final Animatable access$getBottomStart$p(AnimatedShapeState arg0) {
        return arg0.bottomStart;
    }

    public static final Animatable access$getTopEnd$p(AnimatedShapeState arg0) {
        return arg0.topEnd;
    }

    public static final Animatable access$getTopStart$p(AnimatedShapeState arg0) {
        return arg0.topStart;
    }

    public final Object animateToShape(CornerBasedShape arg3, Continuation arg4) {
        return CoroutineScopeKt.coroutineScope(new AnimatedShapeState$animateToShape$2(this, arg3, null), arg4);
    }

    public final float bottomEnd-TmRCtEA(long arg2, Density arg4) {
        Animatable v0 = this.bottomEnd;
        if(v0 == null) {
            v0 = AnimatableKt.Animatable$default(this.shape.getBottomEnd().toPx-TmRCtEA(arg2, arg4), 0f, 2, null);
            this.bottomEnd = v0;
        }

        return v0.getValue().floatValue();
    }

    public static float bottomEnd-TmRCtEA$default(AnimatedShapeState arg0, long arg1, Density arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.size;
        }

        if((arg4 & 2) != 0) {
            arg3 = arg0.density;
        }

        return arg0.bottomEnd-TmRCtEA(arg1, arg3);
    }

    public final float bottomStart-TmRCtEA(long arg2, Density arg4) {
        Animatable v0 = this.bottomStart;
        if(v0 == null) {
            v0 = AnimatableKt.Animatable$default(this.shape.getBottomStart().toPx-TmRCtEA(arg2, arg4), 0f, 2, null);
            this.bottomStart = v0;
        }

        return v0.getValue().floatValue();
    }

    public static float bottomStart-TmRCtEA$default(AnimatedShapeState arg0, long arg1, Density arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.size;
        }

        if((arg4 & 2) != 0) {
            arg3 = arg0.density;
        }

        return arg0.bottomStart-TmRCtEA(arg1, arg3);
    }

    public final Density getDensity() {
        return this.density;
    }

    public final RoundedCornerShape getShape() {
        return this.shape;
    }

    public final long getSize-NH-jbRc() {
        return this.size;
    }

    public final FiniteAnimationSpec getSpec() {
        return this.spec;
    }

    public final void setDensity(Density arg1) {
        this.density = arg1;
    }

    public final void setSize-uvyYCjk(long arg1) {
        this.size = arg1;
    }

    public final float topEnd-TmRCtEA(long arg2, Density arg4) {
        Animatable v0 = this.topEnd;
        if(v0 == null) {
            v0 = AnimatableKt.Animatable$default(this.shape.getTopEnd().toPx-TmRCtEA(arg2, arg4), 0f, 2, null);
            this.topEnd = v0;
        }

        return v0.getValue().floatValue();
    }

    public static float topEnd-TmRCtEA$default(AnimatedShapeState arg0, long arg1, Density arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.size;
        }

        if((arg4 & 2) != 0) {
            arg3 = arg0.density;
        }

        return arg0.topEnd-TmRCtEA(arg1, arg3);
    }

    public final float topStart-TmRCtEA(long arg2, Density arg4) {
        Animatable v0 = this.topStart;
        if(v0 == null) {
            v0 = AnimatableKt.Animatable$default(this.shape.getTopStart().toPx-TmRCtEA(arg2, arg4), 0f, 2, null);
            this.topStart = v0;
        }

        return v0.getValue().floatValue();
    }

    public static float topStart-TmRCtEA$default(AnimatedShapeState arg0, long arg1, Density arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.size;
        }

        if((arg4 & 2) != 0) {
            arg3 = arg0.density;
        }

        return arg0.topStart-TmRCtEA(arg1, arg3);
    }
}

