package androidx.window.embedding;

import android.util.Pair;
import androidx.window.reflection.Predicate2;

public final class EmbeddingAdapter$$ExternalSyntheticLambda5 implements Predicate2 {
    public EmbeddingAdapter$$ExternalSyntheticLambda5(SplitPairRule arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean test(Object arg1) {
        return EmbeddingAdapter.translateSplitPairRule$lambda$4(this.f$0, ((Pair)arg1));
    }
}

