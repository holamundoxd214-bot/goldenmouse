package androidx.window.embedding;

import android.app.Activity;
import java.util.Set;
import kotlin.jvm.functions.Function2;

public final class EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda3 implements Function2 {
    public EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda3(Set arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return Boolean.valueOf(VendorApiLevel1Impl.translateActivityPairPredicates$lambda$2(this.f$0, ((Activity)arg1), ((Activity)arg2)));
    }
}

