package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.text.AnnotatedString$Range;
import kotlin.jvm.functions.Function1;

public final class TextLinkScope$$ExternalSyntheticLambda0 implements Function1 {
    public TextLinkScope$$ExternalSyntheticLambda0(TextLinkScope arg1, Range arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return TextLinkScope.clipLink$lambda$0(this.f$0, this.f$1, ((GraphicsLayerScope)arg2));
    }
}

