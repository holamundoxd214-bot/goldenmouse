package kotlinx.coroutines.android;

import kotlinx.coroutines.CancellableContinuation;

public final class HandlerContext$$ExternalSyntheticLambda1 implements Runnable {
    public HandlerContext$$ExternalSyntheticLambda1(CancellableContinuation arg1, HandlerContext arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        HandlerContext.scheduleResumeAfterDelay$lambda$1(this.f$0, this.f$1);
    }
}

