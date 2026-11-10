package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0006\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0096\u0001R\u0018\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FX\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2={"Landroidx/compose/animation/AnimatedContentScopeImpl;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "animatedVisibilityScope", "<init>", "(Landroidx/compose/animation/AnimatedVisibilityScope;)V", "animateEnterExit", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "label", "", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "getTransition", "()Landroidx/compose/animation/core/Transition;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AnimatedContentScopeImpl implements AnimatedContentScope, AnimatedVisibilityScope {
    public AnimatedContentScopeImpl(AnimatedVisibilityScope arg1) {
        super();
        this.$$delegate_0 = arg1;
    }

    public Modifier animateEnterExit(Modifier arg1, EnterTransition arg2, ExitTransition arg3, String arg4) {
        return this.$$delegate_0.animateEnterExit(arg1, arg2, arg3, arg4);
    }

    public Transition getTransition() {
        return this.$$delegate_0.getTransition();
    }
}

