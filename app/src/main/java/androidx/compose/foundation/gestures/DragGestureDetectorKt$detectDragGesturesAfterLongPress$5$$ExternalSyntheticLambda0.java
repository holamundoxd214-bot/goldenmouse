package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$$ExternalSyntheticLambda0 implements Function1 {
    public DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$$ExternalSyntheticLambda0(Function2 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return DragGestureDetectorKt$detectDragGesturesAfterLongPress$5.invokeSuspend$lambda$0(this.f$0, ((PointerInputChange)arg1));
    }
}

