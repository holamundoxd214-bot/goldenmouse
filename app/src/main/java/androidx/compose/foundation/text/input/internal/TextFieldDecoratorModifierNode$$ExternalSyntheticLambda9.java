package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import kotlin.jvm.functions.Function2;

public final class TextFieldDecoratorModifierNode$$ExternalSyntheticLambda9 implements Function2 {
    public TextFieldDecoratorModifierNode$$ExternalSyntheticLambda9(TextFieldDecoratorModifierNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return Boolean.valueOf(TextFieldDecoratorModifierNode.dragAndDropNode$lambda$1(this.f$0, ((ClipEntry)arg1), ((ClipMetadata)arg2)));
    }
}

