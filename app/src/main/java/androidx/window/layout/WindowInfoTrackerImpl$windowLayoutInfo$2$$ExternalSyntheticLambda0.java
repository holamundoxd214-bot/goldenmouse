package androidx.window.layout;

import androidx.core.util.Consumer;
import kotlinx.coroutines.channels.ProducerScope;

public final class WindowInfoTrackerImpl$windowLayoutInfo$2$$ExternalSyntheticLambda0 implements Consumer {
    public WindowInfoTrackerImpl$windowLayoutInfo$2$$ExternalSyntheticLambda0(ProducerScope arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void accept(Object arg1) {
        WindowInfoTrackerImpl$windowLayoutInfo$2.invokeSuspend$lambda$0(this.f$0, ((WindowLayoutInfo)arg1));
    }
}

