package androidx.window.embedding;

import java.util.List;

public final class ExtensionEmbeddingBackend$SplitListenerWrapper$$ExternalSyntheticLambda0 implements Runnable {
    public ExtensionEmbeddingBackend$SplitListenerWrapper$$ExternalSyntheticLambda0(SplitListenerWrapper arg1, List arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        SplitListenerWrapper.accept$lambda$1(this.f$0, this.f$1);
    }
}

