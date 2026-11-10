package androidx.window.embedding;

import android.content.Intent;
import java.util.Set;
import kotlin.jvm.functions.Function1;

public final class EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda0 implements Function1 {
    public EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda0(Set arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(VendorApiLevel1Impl.translateIntentPredicates$lambda$9(this.f$0, ((Intent)arg1)));
    }
}

