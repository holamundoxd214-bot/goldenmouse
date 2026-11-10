package androidx.window.embedding;

import android.content.Context;
import android.view.WindowMetrics;
import androidx.window.reflection.Predicate2;

public final class EmbeddingAdapter$$ExternalSyntheticLambda4 implements Predicate2 {
    public EmbeddingAdapter$$ExternalSyntheticLambda4(SplitPlaceholderRule arg1, Context arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final boolean test(Object arg2) {
        return EmbeddingAdapter.translateSplitPlaceholderRule$lambda$14(this.f$0, this.f$1, ((WindowMetrics)arg2));
    }
}

