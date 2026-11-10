package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\rH¦@¢\u0006\u0002\u0010\u000EJ\b\u0010\u000F\u001A\u00020\u000BH&J\b\u0010\u0010\u001A\u00020\u000BH&R\u0018\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2={"Landroidx/compose/material3/TooltipState;", "", "transition", "Landroidx/compose/animation/core/MutableTransitionState;", "", "getTransition", "()Landroidx/compose/animation/core/MutableTransitionState;", "isVisible", "()Z", "isPersistent", "show", "", "mutatePriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismiss", "onDispose", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TooltipState {
    void dismiss();

    MutableTransitionState getTransition();

    boolean isPersistent();

    boolean isVisible();

    void onDispose();

    Object show(MutatePriority arg1, Continuation arg2);

    static Object show$default(TooltipState arg0, MutatePriority arg1, Continuation arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg1 = MutatePriority.Default;
            }

            return arg0.show(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }
}

