package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.functions.Function1;

public final class CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda9 implements Function1 {
    public CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda9(CoreTextFieldSemanticsModifierNode arg1, SemanticsPropertyReceiver arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return Boolean.valueOf(CoreTextFieldSemanticsModifierNode.applySemantics$lambda$4(this.f$0, this.f$1, ((AnnotatedString)arg2)));
    }
}

