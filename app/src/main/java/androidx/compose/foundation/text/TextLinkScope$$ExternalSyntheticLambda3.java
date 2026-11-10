package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString$Range;

public final class TextLinkScope$$ExternalSyntheticLambda3 implements TextRangeScopeMeasurePolicy {
    public TextLinkScope$$ExternalSyntheticLambda3(TextLinkScope arg1, Range arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final TextRangeLayoutMeasureResult measure(TextRangeLayoutMeasureScope arg2) {
        return TextLinkScope.textRange$lambda$0(this.f$0, this.f$1, arg2);
    }
}

