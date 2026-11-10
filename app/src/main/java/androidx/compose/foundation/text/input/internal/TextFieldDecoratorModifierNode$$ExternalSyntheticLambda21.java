package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.functions.Function1;

public final class TextFieldDecoratorModifierNode$$ExternalSyntheticLambda21 implements Function1 {
    public TextFieldDecoratorModifierNode$$ExternalSyntheticLambda21(boolean arg1, TextFieldDecoratorModifierNode arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return Boolean.valueOf(TextFieldDecoratorModifierNode.applySemantics$lambda$3(this.f$0, this.f$1, ((AnnotatedString)arg2)));
    }
}

