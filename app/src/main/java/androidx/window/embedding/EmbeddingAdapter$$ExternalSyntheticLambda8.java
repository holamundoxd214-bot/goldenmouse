package androidx.window.embedding;

import android.app.Activity;
import androidx.window.reflection.Predicate2;

public final class EmbeddingAdapter$$ExternalSyntheticLambda8 implements Predicate2 {
    public EmbeddingAdapter$$ExternalSyntheticLambda8(ActivityRule arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean test(Object arg1) {
        return EmbeddingAdapter.translateActivityRule$lambda$16(this.f$0, ((Activity)arg1));
    }
}

