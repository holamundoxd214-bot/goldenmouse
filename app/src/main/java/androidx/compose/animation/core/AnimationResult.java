package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B#\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000F\u001A\u00020\u0010H\u0016R\u001D\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u0011"}, d2={"Landroidx/compose/animation/core/AnimationResult;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "endState", "Landroidx/compose/animation/core/AnimationState;", "endReason", "Landroidx/compose/animation/core/AnimationEndReason;", "<init>", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationEndReason;)V", "getEndState", "()Landroidx/compose/animation/core/AnimationState;", "getEndReason", "()Landroidx/compose/animation/core/AnimationEndReason;", "toString", "", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnimationResult {
    public static final int $stable;
    private final AnimationEndReason endReason;
    private final AnimationState endState;

    static {
    }

    public AnimationResult(AnimationState arg1, AnimationEndReason arg2) {
        super();
        this.endState = arg1;
        this.endReason = arg2;
    }

    public final AnimationEndReason getEndReason() {
        return this.endReason;
    }

    public final AnimationState getEndState() {
        return this.endState;
    }

    public String toString() {
        return "AnimationResult(endReason=" + this.endReason + ", endState=" + this.endState + ')';
    }
}

