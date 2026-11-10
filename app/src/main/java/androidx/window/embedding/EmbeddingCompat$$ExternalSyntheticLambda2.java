package androidx.window.embedding;

import androidx.window.extensions.core.util.function.Function;
import androidx.window.extensions.embedding.SplitAttributesCalculatorParams;

public final class EmbeddingCompat$$ExternalSyntheticLambda2 implements Function {
    public EmbeddingCompat$$ExternalSyntheticLambda2(EmbeddingCompat arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object apply(Object arg1) {
        return EmbeddingCompat.setDefaultSplitAttributeCalculatorIfNeeded$lambda$3(this.f$0, ((SplitAttributesCalculatorParams)arg1));
    }
}

