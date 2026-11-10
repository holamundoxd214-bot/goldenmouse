package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function1;

public final class DraggableNode$drag$2$$ExternalSyntheticLambda0 implements Function1 {
    public DraggableNode$drag$2$$ExternalSyntheticLambda0(DragScope arg1, DraggableNode arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return DraggableNode$drag$2.invokeSuspend$lambda$0(this.f$0, this.f$1, ((DragDelta)arg2));
    }
}

