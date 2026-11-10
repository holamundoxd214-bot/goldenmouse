package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Path;
import kotlin.jvm.functions.Function1;

public final class MultiParagraph$$ExternalSyntheticLambda1 implements Function1 {
    public MultiParagraph$$ExternalSyntheticLambda1(Path arg1, int arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return MultiParagraph.getPathForRange$lambda$1(this.f$0, this.f$1, this.f$2, ((ParagraphInfo)arg3));
    }
}

