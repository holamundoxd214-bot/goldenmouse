package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function1;

public final class BringIntoViewRequestPriorityQueue$$ExternalSyntheticLambda0 implements Function1 {
    public BringIntoViewRequestPriorityQueue$$ExternalSyntheticLambda0(BringIntoViewRequestPriorityQueue arg1, Request arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return BringIntoViewRequestPriorityQueue.enqueue$lambda$1(this.f$0, this.f$1, ((Throwable)arg2));
    }
}

