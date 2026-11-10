package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001JA\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\'\u0010\u0006\u001A#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\b\nH¦@¢\u0006\u0002\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u000EH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000FÀ\u0006\u0003"}, d2={"Landroidx/compose/foundation/gestures/DraggableState;", "", "drag", "", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface DraggableState {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static Object drag$default(DraggableState arg0, MutatePriority arg1, Function2 arg2, Continuation arg3, int arg4, Object arg5) {
            return DraggableState.drag$default(arg0, arg1, arg2, arg3, arg4, arg5);
        }
    }

    void dispatchRawDelta(float arg1);

    Object drag(MutatePriority arg1, Function2 arg2, Continuation arg3);

    static Object drag$default(DraggableState arg0, MutatePriority arg1, Function2 arg2, Continuation arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 1) != 0) {
                arg1 = MutatePriority.Default;
            }

            return arg0.drag(arg1, arg2, arg3);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drag");
    }
}

