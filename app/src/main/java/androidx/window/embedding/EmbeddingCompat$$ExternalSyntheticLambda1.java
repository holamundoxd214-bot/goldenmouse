package androidx.window.embedding;

import androidx.window.reflection.Consumer2;
import java.util.List;

public final class EmbeddingCompat$$ExternalSyntheticLambda1 implements Consumer2 {
    public EmbeddingCompat$$ExternalSyntheticLambda1(EmbeddingCallbackInterface arg1, EmbeddingCompat arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void accept(Object arg2) {
        EmbeddingCompat.registerSplitInfoCallback$lambda$1(this.f$0, this.f$1, ((List)arg2));
    }
}

