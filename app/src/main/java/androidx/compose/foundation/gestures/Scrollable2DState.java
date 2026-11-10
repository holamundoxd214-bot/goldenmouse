package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JA\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\'\u0010\u0006\u001A#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\b\nH¦@¢\u0006\u0002\u0010\u000BJ\u0017\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\rH&¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0014\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\rH&¢\u0006\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0011\u001A\u00020\u0012X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2={"Landroidx/compose/foundation/gestures/Scrollable2DState;", "", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/Scroll2DScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "Landroidx/compose/ui/geometry/Offset;", "delta", "dispatchRawDelta-MK-Hz9U", "(J)J", "isScrollInProgress", "", "()Z", "canScroll", "offset", "canScroll-k-4lQ0M", "(J)Z", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Scrollable2DState {
    boolean canScroll-k-4lQ0M(long arg1);

    long dispatchRawDelta-MK-Hz9U(long arg1);

    boolean isScrollInProgress();

    Object scroll(MutatePriority arg1, Function2 arg2, Continuation arg3);

    static Object scroll$default(Scrollable2DState arg0, MutatePriority arg1, Function2 arg2, Continuation arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 1) != 0) {
                arg1 = MutatePriority.Default;
            }

            return arg0.scroll(arg1, arg2, arg3);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scroll");
    }
}

