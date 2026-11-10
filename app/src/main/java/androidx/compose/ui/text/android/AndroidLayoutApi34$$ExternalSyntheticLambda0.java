package androidx.compose.ui.text.android;

import android.graphics.RectF;
import android.text.Layout$TextInclusionStrategy;
import kotlin.jvm.functions.Function2;

public final class AndroidLayoutApi34$$ExternalSyntheticLambda0 implements Layout$TextInclusionStrategy {
    public AndroidLayoutApi34$$ExternalSyntheticLambda0(Function2 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean isSegmentInside(RectF arg1, RectF arg2) {
        return AndroidLayoutApi34.getRangeForRect$lambda$0(this.f$0, arg1, arg2);
    }
}

