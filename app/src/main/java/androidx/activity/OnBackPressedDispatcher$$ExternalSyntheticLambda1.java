package androidx.activity;

import androidx.lifecycle.Lifecycle;

public final class OnBackPressedDispatcher$$ExternalSyntheticLambda1 implements AutoCloseable {
    public OnBackPressedDispatcher$$ExternalSyntheticLambda1(Lifecycle arg1, OnBackPressedDispatcher$addCallback$observer$1 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void close() {
        OnBackPressedDispatcher.addCallback$lambda$0(this.f$0, this.f$1);
    }
}

