package androidx.window.layout.adapter.extensions;

import androidx.core.util.Consumer;

public final class ExtensionWindowBackendApi0$$ExternalSyntheticLambda0 implements Runnable {
    public ExtensionWindowBackendApi0$$ExternalSyntheticLambda0(Consumer arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void run() {
        ExtensionWindowBackendApi0.registerLayoutChangeCallback$lambda$0(this.f$0);
    }
}

