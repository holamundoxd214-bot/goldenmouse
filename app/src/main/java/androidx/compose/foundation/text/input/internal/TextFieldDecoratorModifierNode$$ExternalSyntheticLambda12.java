package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.draganddrop.DragAndDropEvent;
import kotlin.jvm.functions.Function1;

public final class TextFieldDecoratorModifierNode$$ExternalSyntheticLambda12 implements Function1 {
    public TextFieldDecoratorModifierNode$$ExternalSyntheticLambda12(TextFieldDecoratorModifierNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return TextFieldDecoratorModifierNode.dragAndDropNode$lambda$3(this.f$0, ((DragAndDropEvent)arg1));
    }
}

