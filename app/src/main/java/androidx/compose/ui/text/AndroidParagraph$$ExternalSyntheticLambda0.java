package androidx.compose.ui.text;

import android.graphics.RectF;
import kotlin.jvm.functions.Function2;

public final class AndroidParagraph$$ExternalSyntheticLambda0 implements Function2 {
    public AndroidParagraph$$ExternalSyntheticLambda0(TextInclusionStrategy arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return Boolean.valueOf(AndroidParagraph.getRangeForRect_8_6BmAI$lambda$0(this.f$0, ((RectF)arg1), ((RectF)arg2)));
    }
}

