package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.KeyCommand;
import kotlin.jvm.functions.Function1;

public final class TextFieldDecoratorModifierNode$$ExternalSyntheticLambda16 implements Function1 {
    public TextFieldDecoratorModifierNode$$ExternalSyntheticLambda16(TextFieldDecoratorModifierNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return TextFieldDecoratorModifierNode.clipboardKeyCommandsHandler$lambda$0(this.f$0, ((KeyCommand)arg1));
    }
}

