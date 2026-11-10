package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import kotlin.jvm.functions.Function1;

public final class DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda1 implements Function1 {
    public DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda1(VelocityTracker arg1, PointerInputScope arg2, DragGestureNode arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return DragGestureNode$initializePointerInputNode$1.invoke$lambda$1(this.f$0, this.f$1, this.f$2, ((PointerInputChange)arg3));
    }
}

