package androidx.window.embedding;

import androidx.core.util.Consumer;
import kotlinx.coroutines.channels.ProducerScope;

public final class ActivityEmbeddingController$embeddedActivityWindowInfo$1$$ExternalSyntheticLambda0 implements Consumer {
    public ActivityEmbeddingController$embeddedActivityWindowInfo$1$$ExternalSyntheticLambda0(ProducerScope arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void accept(Object arg1) {
        ActivityEmbeddingController$embeddedActivityWindowInfo$1.invokeSuspend$lambda$0(this.f$0, ((EmbeddedActivityWindowInfo)arg1));
    }
}

