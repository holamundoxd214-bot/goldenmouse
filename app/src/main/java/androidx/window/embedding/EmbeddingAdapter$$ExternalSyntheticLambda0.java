package androidx.window.embedding;

import android.content.Context;
import android.view.WindowMetrics;
import androidx.window.reflection.Predicate2;

public final class EmbeddingAdapter$$ExternalSyntheticLambda0 implements Predicate2 {
    public EmbeddingAdapter$$ExternalSyntheticLambda0(SplitPinRule arg1, Context arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final boolean test(Object arg2) {
        return EmbeddingAdapter.translateSplitPinRule$lambda$8(this.f$0, this.f$1, ((WindowMetrics)arg2));
    }
}

