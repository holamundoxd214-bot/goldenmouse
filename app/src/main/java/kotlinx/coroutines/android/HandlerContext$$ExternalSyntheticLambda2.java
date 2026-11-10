package kotlinx.coroutines.android;

import kotlin.jvm.functions.Function1;

public final class HandlerContext$$ExternalSyntheticLambda2 implements Function1 {
    public HandlerContext$$ExternalSyntheticLambda2(HandlerContext arg1, Runnable arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return HandlerContext.scheduleResumeAfterDelay$lambda$2(this.f$0, this.f$1, ((Throwable)arg2));
    }
}

