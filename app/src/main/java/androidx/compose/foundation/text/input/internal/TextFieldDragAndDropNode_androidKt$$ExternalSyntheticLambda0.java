package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.draganddrop.DragAndDropEvent;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

public final class TextFieldDragAndDropNode_androidKt$$ExternalSyntheticLambda0 implements Function1 {
    public TextFieldDragAndDropNode_androidKt$$ExternalSyntheticLambda0(Function0 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode$lambda$0(this.f$0, ((DragAndDropEvent)arg1)));
    }
}

