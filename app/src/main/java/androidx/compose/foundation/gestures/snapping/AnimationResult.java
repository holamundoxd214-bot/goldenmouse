package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationState;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B#\u0012\u0006\u0010\u0005\u001A\u00028\u0000\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000E\u0010\u000F\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u000BJ\u0015\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0086\u0002R\u0013\u0010\u0005\u001A\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u001D\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u0011"}, d2={"Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "remainingOffset", "currentAnimationState", "Landroidx/compose/animation/core/AnimationState;", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationState;)V", "getRemainingOffset", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getCurrentAnimationState", "()Landroidx/compose/animation/core/AnimationState;", "component1", "component2", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AnimationResult {
    private final AnimationState currentAnimationState;
    private final Object remainingOffset;

    public AnimationResult(Object arg1, AnimationState arg2) {
        super();
        this.remainingOffset = arg1;
        this.currentAnimationState = arg2;
    }

    public final Object component1() {
        return this.remainingOffset;
    }

    public final AnimationState component2() {
        return this.currentAnimationState;
    }

    public final AnimationState getCurrentAnimationState() {
        return this.currentAnimationState;
    }

    public final Object getRemainingOffset() {
        return this.remainingOffset;
    }
}

