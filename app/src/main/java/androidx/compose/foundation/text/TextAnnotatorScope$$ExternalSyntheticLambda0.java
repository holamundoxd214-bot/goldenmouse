package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString$Range;
import androidx.compose.ui.text.SpanStyle;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;

public final class TextAnnotatorScope$$ExternalSyntheticLambda0 implements Function1 {
    public TextAnnotatorScope$$ExternalSyntheticLambda0(BooleanRef arg1, Range arg2, SpanStyle arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return TextAnnotatorScope.replaceStyle$lambda$0(this.f$0, this.f$1, this.f$2, ((Range)arg3));
    }
}

