package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerType;
import kotlin.jvm.functions.Function1;

public final class DragGestureNode$$ExternalSyntheticLambda0 implements Function1 {
    public DragGestureNode$$ExternalSyntheticLambda0(DragGestureNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(DragGestureNode._canDrag$lambda$0(this.f$0, ((PointerType)arg1)));
    }
}

