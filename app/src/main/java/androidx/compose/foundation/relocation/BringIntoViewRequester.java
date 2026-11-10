package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u001A\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\u0006\u0082\u0001\u0001\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterImpl;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface BringIntoViewRequester {
    Object bringIntoView(Rect arg1, Continuation arg2);

    static Object bringIntoView$default(BringIntoViewRequester arg0, Rect arg1, Continuation arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg1 = null;
            }

            return arg0.bringIntoView(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bringIntoView");
    }
}

