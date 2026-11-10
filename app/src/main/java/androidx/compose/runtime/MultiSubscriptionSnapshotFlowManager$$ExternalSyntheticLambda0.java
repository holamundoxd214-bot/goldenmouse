package androidx.compose.runtime;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.SendChannel;

public final class MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda0 implements Function1 {
    public MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda0(MultiSubscriptionSnapshotFlowManager arg1, SendChannel arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return MultiSubscriptionSnapshotFlowManager.readObserverFor$lambda$0(this.f$0, this.f$1, arg2);
    }
}

