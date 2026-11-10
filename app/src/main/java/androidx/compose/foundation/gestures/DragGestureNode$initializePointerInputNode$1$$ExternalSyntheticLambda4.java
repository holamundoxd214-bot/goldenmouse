package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;

public final class DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda4 implements Function2 {
    public DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda4(DragGestureNode arg1, LongRef arg2, VelocityTracker arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return DragGestureNode$initializePointerInputNode$1.invoke$lambda$4(this.f$0, this.f$1, this.f$2, ((PointerInputChange)arg3), ((Offset)arg4));
    }
}

