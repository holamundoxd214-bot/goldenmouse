package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.functions.Function1;

public final class TextFieldDecoratorModifierNode$$ExternalSyntheticLambda13 implements Function1 {
    public TextFieldDecoratorModifierNode$$ExternalSyntheticLambda13(TextFieldDecoratorModifierNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return TextFieldDecoratorModifierNode.dragAndDropNode$lambda$4(this.f$0, ((Offset)arg1));
    }
}

