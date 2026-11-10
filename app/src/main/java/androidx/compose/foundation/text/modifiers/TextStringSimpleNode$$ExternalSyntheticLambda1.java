package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.functions.Function1;

public final class TextStringSimpleNode$$ExternalSyntheticLambda1 implements Function1 {
    public TextStringSimpleNode$$ExternalSyntheticLambda1(TextStringSimpleNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(TextStringSimpleNode.applySemantics$lambda$1(this.f$0, ((AnnotatedString)arg1)));
    }
}

