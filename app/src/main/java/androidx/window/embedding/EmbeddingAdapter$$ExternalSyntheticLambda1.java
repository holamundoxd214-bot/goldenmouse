package androidx.window.embedding;

import androidx.window.extensions.embedding.SplitAttributesCalculatorParams;
import androidx.window.reflection.JFunction2;
import kotlin.jvm.functions.Function1;

public final class EmbeddingAdapter$$ExternalSyntheticLambda1 implements JFunction2 {
    public EmbeddingAdapter$$ExternalSyntheticLambda1(EmbeddingAdapter arg1, Function1 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object apply(Object arg2) {
        return EmbeddingAdapter.translateSplitAttributesCalculator$lambda$1(this.f$0, this.f$1, ((SplitAttributesCalculatorParams)arg2));
    }
}

