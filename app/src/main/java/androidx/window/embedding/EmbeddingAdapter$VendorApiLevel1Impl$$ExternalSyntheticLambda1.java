package androidx.window.embedding;

import android.content.Context;
import android.view.WindowMetrics;
import kotlin.jvm.functions.Function1;

public final class EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda1 implements Function1 {
    public EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda1(SplitRule arg1, Context arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return Boolean.valueOf(VendorApiLevel1Impl.translateParentMetricsPredicate$lambda$10(this.f$0, this.f$1, ((WindowMetrics)arg2)));
    }
}

