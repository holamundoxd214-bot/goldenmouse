package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0007\u001A\u00020\b*\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0016R\u0018\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000FÀ\u0006\u0003"}, d2={"Landroidx/compose/animation/AnimatedVisibilityScope;", "", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "getTransition", "()Landroidx/compose/animation/core/Transition;", "animateEnterExit", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "label", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface AnimatedVisibilityScope {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static Modifier animateEnterExit(AnimatedVisibilityScope arg0, Modifier arg1, EnterTransition arg2, ExitTransition arg3, String arg4) {
            return arg0.animateEnterExit(arg1, arg2, arg3, arg4);
        }

        public static Modifier animateEnterExit$default(AnimatedVisibilityScope arg0, Modifier arg1, EnterTransition arg2, ExitTransition arg3, String arg4, int arg5, Object arg6) {
            return AnimatedVisibilityScope.animateEnterExit$default(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
        }
    }

    static Modifier access$animateEnterExit$jd(AnimatedVisibilityScope arg0, Modifier arg1, EnterTransition arg2, ExitTransition arg3, String arg4) {
        return super.animateEnterExit(arg1, arg2, arg3, arg4);
    }

    default Modifier animateEnterExit(Modifier arg3, EnterTransition arg4, ExitTransition arg5, String arg6) {
        AnimatedVisibilityScope$animateEnterExit$$inlined$debugInspectorInfo$1 v0;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v0 = new AnimatedVisibilityScope$animateEnterExit$$inlined$debugInspectorInfo$1(arg4, arg5, arg6);
        }
        else {
            Function1 v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg3, ((Function1)v0), new AnimatedVisibilityScope$animateEnterExit$2(this, arg4, arg5, arg6));
    }

    static Modifier animateEnterExit$default(AnimatedVisibilityScope arg3, Modifier arg4, EnterTransition arg5, ExitTransition arg6, String arg7, int arg8, Object arg9) {
        if(arg9 == null) {
            int v0 = 3;
            FiniteAnimationSpec v2 = null;
            if((arg8 & 1) != 0) {
                arg5 = EnterExitTransitionKt.fadeIn$default(v2, 0f, v0, v2);
            }

            if((arg8 & 2) != 0) {
                arg6 = EnterExitTransitionKt.fadeOut$default(v2, 0f, v0, v2);
            }

            if((arg8 & 4) != 0) {
                arg7 = "animateEnterExit";
            }

            return arg3.animateEnterExit(arg4, arg5, arg6, arg7);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateEnterExit");
    }

    Transition getTransition();
}

