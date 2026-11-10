package androidx.lifecycle;

import kotlinx.coroutines.channels.ProducerScope;

public final class FlowLiveDataConversions$asFlow$1$$ExternalSyntheticLambda0 implements Observer {
    public FlowLiveDataConversions$asFlow$1$$ExternalSyntheticLambda0(ProducerScope arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onChanged(Object arg1) {
        FlowLiveDataConversions$asFlow$1.invokeSuspend$lambda$0(this.f$0, arg1);
    }
}

