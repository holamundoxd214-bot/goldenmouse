package androidx.window.embedding;

import androidx.core.util.Consumer;
import kotlinx.coroutines.channels.ProducerScope;

public final class OverlayController$overlayInfo$1$$ExternalSyntheticLambda0 implements Consumer {
    public OverlayController$overlayInfo$1$$ExternalSyntheticLambda0(ProducerScope arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void accept(Object arg1) {
        OverlayController$overlayInfo$1.invokeSuspend$lambda$0(this.f$0, ((OverlayInfo)arg1));
    }
}

