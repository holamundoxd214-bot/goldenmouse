package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function1;

public final class Scrollable2DNode$drag$2$1$$ExternalSyntheticLambda0 implements Function1 {
    public Scrollable2DNode$drag$2$1$$ExternalSyntheticLambda0(NestedScrollScope arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Scrollable2DNode$drag$2$1.invokeSuspend$lambda$0(this.f$0, ((DragDelta)arg1));
    }
}

