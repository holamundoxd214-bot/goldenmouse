package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.autofill.FillableData;
import kotlin.jvm.functions.Function1;

public final class TextFieldDecoratorModifierNode$$ExternalSyntheticLambda11 implements Function1 {
    public TextFieldDecoratorModifierNode$$ExternalSyntheticLambda11(boolean arg1, TextFieldDecoratorModifierNode arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return Boolean.valueOf(TextFieldDecoratorModifierNode.applySemantics$lambda$1(this.f$0, this.f$1, ((FillableData)arg2)));
    }
}

