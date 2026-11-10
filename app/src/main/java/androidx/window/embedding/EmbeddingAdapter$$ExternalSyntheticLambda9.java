package androidx.window.embedding;

import android.content.Intent;
import androidx.window.reflection.Predicate2;

public final class EmbeddingAdapter$$ExternalSyntheticLambda9 implements Predicate2 {
    public EmbeddingAdapter$$ExternalSyntheticLambda9(ActivityRule arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean test(Object arg1) {
        return EmbeddingAdapter.translateActivityRule$lambda$18(this.f$0, ((Intent)arg1));
    }
}

