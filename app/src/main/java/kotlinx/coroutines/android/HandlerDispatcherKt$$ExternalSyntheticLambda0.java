package kotlinx.coroutines.android;

import android.view.Choreographer$FrameCallback;
import kotlinx.coroutines.CancellableContinuation;

public final class HandlerDispatcherKt$$ExternalSyntheticLambda0 implements Choreographer$FrameCallback {
    public HandlerDispatcherKt$$ExternalSyntheticLambda0(CancellableContinuation arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void doFrame(long arg1) {
        HandlerDispatcherKt.postFrameCallback$lambda$5(this.f$0, arg1);
    }
}

