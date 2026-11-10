package androidx.window.embedding;

import android.app.Activity;
import androidx.window.reflection.Predicate2;

public final class EmbeddingAdapter$$ExternalSyntheticLambda2 implements Predicate2 {
    public EmbeddingAdapter$$ExternalSyntheticLambda2(SplitPlaceholderRule arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean test(Object arg1) {
        return EmbeddingAdapter.translateSplitPlaceholderRule$lambda$11(this.f$0, ((Activity)arg1));
    }
}

