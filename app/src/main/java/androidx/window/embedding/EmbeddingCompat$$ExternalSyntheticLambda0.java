package androidx.window.embedding;

import java.util.List;
import kotlin.jvm.functions.Function1;

public final class EmbeddingCompat$$ExternalSyntheticLambda0 implements Function1 {
    public EmbeddingCompat$$ExternalSyntheticLambda0(EmbeddingCallbackInterface arg1, EmbeddingCompat arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return EmbeddingCompat.setEmbeddingCallback$lambda$0(this.f$0, this.f$1, ((List)arg2));
    }
}

