package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.ShouldPauseCallback;

public final class PrefetchHandleProvider$HandleAndRequestImpl$$ExternalSyntheticLambda1 implements ShouldPauseCallback {
    public PrefetchHandleProvider$HandleAndRequestImpl$$ExternalSyntheticLambda1(HandleAndRequestImpl arg1, Averages arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final boolean shouldPause() {
        return HandleAndRequestImpl.performPausableComposition$lambda$1(this.f$0, this.f$1);
    }
}

