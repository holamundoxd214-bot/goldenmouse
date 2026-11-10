package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function1;

public final class ScrollableNode$drag$2$1$$ExternalSyntheticLambda0 implements Function1 {
    public ScrollableNode$drag$2$1$$ExternalSyntheticLambda0(NestedScrollScope arg1, ScrollingLogic arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return ScrollableNode$drag$2$1.invokeSuspend$lambda$0(this.f$0, this.f$1, ((DragDelta)arg2));
    }
}

