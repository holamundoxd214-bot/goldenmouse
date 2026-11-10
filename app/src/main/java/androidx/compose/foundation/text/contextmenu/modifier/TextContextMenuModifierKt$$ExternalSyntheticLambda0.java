package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.ui.node.TraversableNode;
import kotlin.jvm.functions.Function1;

public final class TextContextMenuModifierKt$$ExternalSyntheticLambda0 implements Function1 {
    public TextContextMenuModifierKt$$ExternalSyntheticLambda0(Function1 arg1, Function1 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return Boolean.valueOf(TextContextMenuModifierKt.traverseTextContextMenuDataNodes$lambda$0(this.f$0, this.f$1, ((TraversableNode)arg2)));
    }
}

