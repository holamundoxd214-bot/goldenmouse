package androidx.window.embedding;

import android.content.Intent;
import androidx.window.reflection.Predicate2;

public final class EmbeddingAdapter$$ExternalSyntheticLambda3 implements Predicate2 {
    public EmbeddingAdapter$$ExternalSyntheticLambda3(SplitPlaceholderRule arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean test(Object arg1) {
        return EmbeddingAdapter.translateSplitPlaceholderRule$lambda$13(this.f$0, ((Intent)arg1));
    }
}

