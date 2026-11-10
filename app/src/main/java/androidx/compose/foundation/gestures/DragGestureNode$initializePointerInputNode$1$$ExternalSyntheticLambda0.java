package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import kotlin.jvm.functions.Function3;

public final class DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda0 implements Function3 {
    public DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda0(DragGestureNode arg1, VelocityTracker arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3, Object arg4) {
        return DragGestureNode$initializePointerInputNode$1.invoke$lambda$0(this.f$0, this.f$1, ((PointerInputChange)arg2), ((PointerInputChange)arg3), ((Offset)arg4));
    }
}

