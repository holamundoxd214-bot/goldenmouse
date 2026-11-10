package androidx.window.embedding;

import android.app.Activity;
import java.util.Set;
import kotlin.jvm.functions.Function1;

public final class EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda4 implements Function1 {
    public EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda4(Set arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(VendorApiLevel1Impl.translateActivityPredicates$lambda$7(this.f$0, ((Activity)arg1)));
    }
}

