package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function1;

public final class AnchoredDraggableNode$drag$2$$ExternalSyntheticLambda1 implements Function1 {
    public AnchoredDraggableNode$drag$2$$ExternalSyntheticLambda1(AnchoredDraggableNode arg1, AnchoredDragScope arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return AnchoredDraggableNode$drag$2.invokeSuspend$lambda$0(this.f$0, this.f$1, ((DragDelta)arg2));
    }
}

