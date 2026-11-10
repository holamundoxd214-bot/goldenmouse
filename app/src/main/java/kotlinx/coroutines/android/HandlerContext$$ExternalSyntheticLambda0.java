package kotlinx.coroutines.android;

import kotlinx.coroutines.DisposableHandle;

public final class HandlerContext$$ExternalSyntheticLambda0 implements DisposableHandle {
    public HandlerContext$$ExternalSyntheticLambda0(HandlerContext arg1, Runnable arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void dispose() {
        HandlerContext.invokeOnTimeout$lambda$3(this.f$0, this.f$1);
    }
}

