package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function1;

public final class Draggable2DNode$drag$2$$ExternalSyntheticLambda0 implements Function1 {
    public Draggable2DNode$drag$2$$ExternalSyntheticLambda0(Drag2DScope arg1, Draggable2DNode arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return Draggable2DNode$drag$2.invokeSuspend$lambda$0(this.f$0, this.f$1, ((DragDelta)arg2));
    }
}

