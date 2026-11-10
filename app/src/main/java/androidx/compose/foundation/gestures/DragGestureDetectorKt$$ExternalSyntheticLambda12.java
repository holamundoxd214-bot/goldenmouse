package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

public final class DragGestureDetectorKt$$ExternalSyntheticLambda12 implements Function3 {
    public DragGestureDetectorKt$$ExternalSyntheticLambda12(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return DragGestureDetectorKt.detectDragGestures$lambda$3(this.f$0, ((PointerInputChange)arg1), ((PointerInputChange)arg2), ((Offset)arg3));
    }
}

