package androidx.compose.foundation.gestures;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001A\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2={"Landroidx/compose/foundation/gestures/AnchoredDragScope;", "", "dragTo", "", "newOffset", "", "lastKnownVelocity", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface AnchoredDragScope {
    void dragTo(float arg1, float arg2);

    static void dragTo$default(AnchoredDragScope arg0, float arg1, float arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            arg0.dragTo(arg1, 0f);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dragTo");
    }
}

