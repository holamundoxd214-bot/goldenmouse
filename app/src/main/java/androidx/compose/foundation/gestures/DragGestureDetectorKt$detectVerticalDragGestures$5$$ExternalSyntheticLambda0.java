package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;

public final class DragGestureDetectorKt$detectVerticalDragGestures$5$$ExternalSyntheticLambda0 implements Function2 {
    public DragGestureDetectorKt$detectVerticalDragGestures$5$$ExternalSyntheticLambda0(FloatRef arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return DragGestureDetectorKt$detectVerticalDragGestures$5.invokeSuspend$lambda$0(this.f$0, ((PointerInputChange)arg1), ((Float)arg2).floatValue());
    }
}

