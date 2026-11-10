package androidx.window.embedding;

import androidx.core.util.Consumer;
import java.util.List;
import kotlinx.coroutines.channels.ProducerScope;

public final class SplitController$splitInfoList$1$$ExternalSyntheticLambda0 implements Consumer {
    public SplitController$splitInfoList$1$$ExternalSyntheticLambda0(ProducerScope arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void accept(Object arg1) {
        SplitController$splitInfoList$1.invokeSuspend$lambda$0(this.f$0, ((List)arg1));
    }
}

